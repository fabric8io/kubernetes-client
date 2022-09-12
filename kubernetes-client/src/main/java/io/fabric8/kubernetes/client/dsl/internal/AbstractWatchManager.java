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
import io.fabric8.kubernetes.api.model.*;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.Watcher.Action;
import io.fabric8.kubernetes.client.WatcherException;
import io.fabric8.kubernetes.client.dsl.base.BaseOperation;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.utils.ExponentialBackoffIntervalCalculator;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.kubernetes.client.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
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
  final AtomicInteger currentReconnectAttempt;
  private ScheduledFuture<?> reconnectAttempt;
  
  protected final HttpClient client;
  private final BaseOperation<T, ?, ?> baseOperation;
  private final ListOptions listOptions;
  private final URL requestUrl;

  private final AtomicBoolean reconnectPending = new AtomicBoolean(false);
  
  private final boolean receiveBookmarks;

  AbstractWatchManager(
    Watcher<T> watcher, BaseOperation<T, ?, ?> baseOperation, ListOptions listOptions, int reconnectLimit, int reconnectInterval, int maxIntervalExponent, Supplier<HttpClient> clientSupplier
  ) throws MalformedURLException {
    this.watcher = watcher;
    this.reconnectLimit = reconnectLimit;
    this.retryIntervalCalculator = new ExponentialBackoffIntervalCalculator(reconnectInterval, maxIntervalExponent);
    this.resourceVersion = new AtomicReference<>(listOptions.getResourceVersion());
    this.currentReconnectAttempt = new AtomicInteger(0);
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
    
    runWatch();
  }
  
  protected abstract void run(URL url, Map<String, String> headers);
  
  protected abstract void closeRequest();
  
  final void close(WatcherException cause) {
    // proactively close the request (it will be called again in close)
    // for reconnecting watchers, we may not complete onClose for a while
    closeRequest();  
    if (forceClosed.get()) {
      logger.debug("Ignoring duplicate firing of onClose event");
    } else { 
      boolean success = false;
      try {
        watcher.onClose(cause);
        success = true;
      } finally {
        if (success || !watcher.reconnecting()) {
          forceClosed.set(true);
        }
      }
    }
    close();
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
  
  void scheduleReconnect() {
    if (!reconnectPending.compareAndSet(false, true)) {
      logger.debug("Reconnect already scheduled");
      return;
    }
    
    if (isForceClosed()) {
      logger.debug("Ignoring error for already closed/closing connection");
      return;
    }
    
    if (cannotReconnect()) {
      close(new WatcherException("Exhausted reconnects"));
      return;
    }
    
    logger.debug("Scheduling reconnect task");
    
    long delay = nextReconnectInterval();
    
    synchronized (this) {
      reconnectAttempt = Utils.schedule(Utils.getCommonExecutorSerive(), () -> {
        try {
          runWatch();
          if (isForceClosed()) {
            closeRequest();
          }
        } catch (Exception e) {
          // An unexpected error occurred and we didn't even get an onFailure callback.
          logger.error("Exception in reconnect", e);
          close(new WatcherException("Unhandled exception in reconnect attempt", e));
        } finally {
          reconnectPending.set(false);
        }
      }, delay, TimeUnit.MILLISECONDS);
      if (isForceClosed()) {
        cancelReconnect();
      }
    }
  }

  final boolean cannotReconnect() {
    return !watcher.reconnecting() && currentReconnectAttempt.get() >= reconnectLimit && reconnectLimit >= 0;
  }

  final long nextReconnectInterval() {
    int exponentOfTwo = currentReconnectAttempt.getAndIncrement();
    long ret = retryIntervalCalculator.getInterval(exponentOfTwo);
    logger.debug("Current reconnect backoff is {} milliseconds (T{})", ret, exponentOfTwo);
    return ret;
  }
  
  void resetReconnectAttempts() {
    currentReconnectAttempt.set(0);
  }
  
  boolean isForceClosed() {
    return forceClosed.get();
  }
  
  @SuppressWarnings("unchecked")
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
    watcher.eventReceived(action, (T)resource);
  }
  
  void updateResourceVersion(final String newResourceVersion) {
    resourceVersion.set(newResourceVersion);
  }
  
  protected void runWatch() {
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
    run(url, headers);
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
      final String msg = "Unexpected exception processing watch event";
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
