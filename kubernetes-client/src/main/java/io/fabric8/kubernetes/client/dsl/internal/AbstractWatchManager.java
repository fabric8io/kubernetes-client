/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fabric8.kubernetes.client.dsl.internal;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.ListOptions;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.api.model.WatchEvent;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.Watcher.Action;
import io.fabric8.kubernetes.client.WatcherException;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.kubernetes.client.utils.internal.ExponentialBackoffIntervalCalculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;

import static java.net.HttpURLConnection.HTTP_GONE;

public abstract class AbstractWatchManager<T extends HasMetadata> implements Watch {

  private static final Logger logger = LoggerFactory.getLogger(AbstractWatchManager.class);

  final Watcher<T> watcher;
  final AtomicReference<String> resourceVersion;

  final AtomicBoolean forceClosed;
  private final int reconnectLimit;
  private final ExponentialBackoffIntervalCalculator retryIntervalCalculator;
  private Future<?> reconnectAttempt;

  protected final HttpClient client;
  protected BaseOperation<T, ?, ?> baseOperation;
  private final ListOptions listOptions;
  private final URL requestUrl;

  private final boolean receiveBookmarks;

  AbstractWatchManager(
      Watcher<T> watcher, BaseOperation<T, ?, ?> baseOperation, ListOptions listOptions, int reconnectLimit,
      int reconnectInterval, int maxIntervalExponent, Supplier<HttpClient> clientSupplier) throws MalformedURLException {
    this.watcher = watcher;
    this.reconnectLimit = reconnectLimit;
    this.retryIntervalCalculator = new ExponentialBackoffIntervalCalculator(reconnectInterval, maxIntervalExponent);
    this.resourceVersion = new AtomicReference<>(listOptions.getResourceVersion());
    this.forceClosed = new AtomicBoolean();
    this.receiveBookmarks = Boolean.TRUE.equals(listOptions.getAllowWatchBookmarks());
    // opt into bookmarks by default
    if (listOptions.getAllowWatchBookmarks() == null) {
      listOptions.setAllowWatchBookmarks(true);
    }
    this.baseOperation = baseOperation;
    this.requestUrl = baseOperation.getNamespacedUrl();
    this.listOptions = listOptions;
    this.client = clientSupplier.get();

    startWatch();
  }

  protected abstract void start(URL url, Map<String, String> headers);

  protected abstract void closeRequest();

  final void close(WatcherException cause) {
    if (!forceClosed.compareAndSet(false, true)) {
      logger.debug("Ignoring duplicate firing of onClose event");
    } else {
      // proactively close the request (it will be called again in close)
      closeRequest();
      try {
        watcher.onClose(cause);
      } finally {
        close();
      }
    }
  }

  final void closeEvent() {
    if (forceClosed.getAndSet(true)) {
      logger.debug("Ignoring duplicate firing of onClose event");
      return;
    }
    watcher.onClose();
  }

  final synchronized void cancelReconnect() {
    if (reconnectAttempt != null) {
      reconnectAttempt.cancel(true);
    }
  }

  /**
   * Called to reestablish the connection. Should only be called once per request.
   */
  void scheduleReconnect() {
    if (isForceClosed()) {
      logger.debug("Ignoring already closed/closing connection");
      return;
    }

    if (cannotReconnect()) {
      close(new WatcherException("Exhausted reconnects"));
      return;
    }

    logger.debug("Scheduling reconnect task");

    long delay = nextReconnectInterval();

    synchronized (this) {
      reconnectAttempt = Utils.schedule(baseOperation.context.getExecutor(), this::reconnect, delay, TimeUnit.MILLISECONDS);
      if (isForceClosed()) {
        cancelReconnect();
      }
    }
  }

  synchronized void reconnect() {
    try {
      startWatch();
      if (isForceClosed()) {
        closeRequest();
      }
    } catch (Exception e) {
      // An unexpected error occurred and we didn't even get an onFailure callback.
      logger.error("Exception in reconnect", e);
      close(new WatcherException("Unhandled exception in reconnect attempt", e));
    }
  }

  final boolean cannotReconnect() {
    return !watcher.reconnecting() && retryIntervalCalculator.getCurrentReconnectAttempt() >= reconnectLimit
        && reconnectLimit >= 0;
  }

  final long nextReconnectInterval() {
    return retryIntervalCalculator.nextReconnectInterval();
  }

  void resetReconnectAttempts() {
    retryIntervalCalculator.resetReconnectAttempts();
  }

  boolean isForceClosed() {
    return forceClosed.get();
  }

  void eventReceived(Watcher.Action action, HasMetadata resource) {
    if (!receiveBookmarks && action == Action.BOOKMARK) {
      // the user didn't ask for bookmarks, just filter them
      return;
    }
    // the WatchEvent deserialization is not specifically typed
    // modify the type here if needed
    if (resource != null && !baseOperation.getType().isAssignableFrom(resource.getClass())) {
      resource = Serialization.jsonMapper().convertValue(resource, baseOperation.getType());
    }
    @SuppressWarnings("unchecked")
    final T t = (T) resource;
    watcher.eventReceived(action, t);
  }

  void updateResourceVersion(final String newResourceVersion) {
    resourceVersion.set(newResourceVersion);
  }

  /**
   * Async start of the watch
   */
  protected void startWatch() {
    listOptions.setResourceVersion(resourceVersion.get());
    URL url = BaseOperation.appendListOptionParams(requestUrl, listOptions);

    String origin = requestUrl.getProtocol() + "://" + requestUrl.getHost();
    if (requestUrl.getPort() != -1) {
      origin += ":" + requestUrl.getPort();
    }

    Map<String, String> headers = new HashMap<>();
    headers.put("Origin", origin);

    logger.debug("Watching {}...", url);

    closeRequest(); // only one can be active at a time
    start(url, headers);
  }

  @Override
  public void close() {
    logger.debug("Force closing the watch {}", this);
    closeEvent();
    closeRequest();
    cancelReconnect();
  }

  private WatchEvent contextAwareWatchEventDeserializer(String messageSource)
      throws JsonProcessingException {
    try {
      return Serialization.unmarshal(messageSource, WatchEvent.class);
    } catch (Exception ex1) {
      JsonNode json = Serialization.jsonMapper().readTree(messageSource);
      JsonNode objectJson = null;
      if (json instanceof ObjectNode && json.has("object")) {
        objectJson = ((ObjectNode) json).remove("object");
      }

      WatchEvent watchEvent = Serialization.jsonMapper().treeToValue(json, WatchEvent.class);
      KubernetesResource object = Serialization.jsonMapper().treeToValue(objectJson, baseOperation.getType());

      watchEvent.setObject(object);
      return watchEvent;
    }
  }

  protected WatchEvent readWatchEvent(String messageSource) throws JsonProcessingException {
    WatchEvent event = contextAwareWatchEventDeserializer(messageSource);
    KubernetesResource object = null;
    if (event != null) {
      object = event.getObject();
    }
    // when watching API Groups we don't get a WatchEvent resource
    // so the object will be null
    // so lets try parse the message as a KubernetesResource
    // as it will probably be a list of resources like a BuildList
    if (object == null) {
      object = Serialization.unmarshal(messageSource, KubernetesResource.class);
      if (event == null) {
        event = new WatchEvent(object, "MODIFIED");
      } else {
        event.setObject(object);
      }
    }
    if (event.getType() == null) {
      event.setType("MODIFIED");
    }
    return event;
  }

  protected void onMessage(String message) {
    try {
      WatchEvent event = readWatchEvent(message);
      Object object = event.getObject();
      Action action = Action.valueOf(event.getType());
      if (action == Action.ERROR) {
        if (object instanceof Status) {
          Status status = (Status) object;

          onStatus(status);
        } else {
          logger.error("Error received, but object is not a status - will retry");
          closeRequest();
        }
      } else if (object instanceof HasMetadata) {
        HasMetadata hasMetadata = (HasMetadata) object;
        updateResourceVersion(hasMetadata.getMetadata().getResourceVersion());

        if (object instanceof KubernetesResourceList) {
          // Dirty cast - should always be valid though
          @SuppressWarnings({ "rawtypes" })
          KubernetesResourceList list = (KubernetesResourceList) hasMetadata;
          @SuppressWarnings("unchecked")
          List<HasMetadata> items = list.getItems();
          if (items != null) {
            for (HasMetadata item : items) {
              eventReceived(action, item);
            }
          }
        } else {
          eventReceived(action, hasMetadata);
        }
      } else {
        final String msg = String.format("Invalid object received: %s", message);
        close(new WatcherException(msg, null, message));
      }
    } catch (ClassCastException e) {
      final String msg = "Received wrong type of object for watch";
      close(new WatcherException(msg, e, message));
    } catch (JsonProcessingException e) {
      final String msg = "Couldn't deserialize watch event: " + message;
      close(new WatcherException(msg, e, message));
    } catch (Exception e) {
      final String msg = "Unhandled exception encountered in watcher event handler";
      close(new WatcherException(msg, e, message));
    }
  }

  protected boolean onStatus(Status status) {
    // The resource version no longer exists - this has to be handled by the caller.
    if (status.getCode() == HTTP_GONE) {
      close(new WatcherException(status.getMessage(), new KubernetesClientException(status)));
      return true;
    }

    logger.error("Error received: {}, will retry", status);
    closeRequest();
    return false;
  }

}
