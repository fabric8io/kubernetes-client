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
import io.fabric8.kubernetes.api.model.ListOptions;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.api.model.StatusDetails;
import io.fabric8.kubernetes.api.model.WatchEvent;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.Watcher.Action;
import io.fabric8.kubernetes.client.WatcherException;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.utils.ExponentialBackoffIntervalCalculator;
import io.fabric8.kubernetes.client.utils.KubernetesSerialization;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.kubernetes.client.utils.internal.SerialExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import static java.net.HttpURLConnection.HTTP_GONE;

public abstract class AbstractWatchManager<T extends HasMetadata> implements Watch {

  private static final class SerialWatcher<T> implements Watcher<T> {
    private final Watcher<T> watcher;
    SerialExecutor serialExecutor;

    private SerialWatcher(Watcher<T> watcher, SerialExecutor serialExecutor) {
      this.watcher = watcher;
      this.serialExecutor = serialExecutor;
    }

    @Override
    public void eventReceived(Action action, T resource) {
      serialExecutor.execute(() -> watcher.eventReceived(action, resource));
    }

    @Override
    public void onClose(WatcherException cause) {
      serialExecutor.execute(() -> {
        watcher.onClose(cause);
        serialExecutor.shutdownNow();
      });
    }

    @Override
    public void onClose() {
      serialExecutor.execute(() -> {
        watcher.onClose();
        serialExecutor.shutdownNow();
      });
    }

    @Override
    public boolean reconnecting() {
      return watcher.reconnecting();
    }
  }

  public static class WatchRequestState {

    final AtomicBoolean reconnected = new AtomicBoolean();
    final AtomicBoolean closed = new AtomicBoolean();
    final CompletableFuture<Void> ended = new CompletableFuture<>();

  }

  private static final Logger logger = LoggerFactory.getLogger(AbstractWatchManager.class);
  private static final int INFO_LOG_CONNECTION_ERRORS = 10;

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

  volatile WatchRequestState latestRequestState;
  private final Map<Class<?>, Integer> endErrors = new ConcurrentHashMap<>();
  private AtomicInteger retryAfterSeconds = new AtomicInteger();

  private int watchEndCheckMs = 120000;

  AbstractWatchManager(
      Watcher<T> watcher, BaseOperation<T, ?, ?> baseOperation, ListOptions listOptions, int reconnectLimit,
      int reconnectInterval, HttpClient client) throws MalformedURLException {
    // prevent the callbacks from happening in the httpclient thread
    this.watcher = new SerialWatcher<>(watcher, new SerialExecutor(baseOperation.getOperationContext().getExecutor()));
    this.reconnectLimit = reconnectLimit;
    this.retryIntervalCalculator = new ExponentialBackoffIntervalCalculator(reconnectInterval, reconnectLimit);
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
    this.client = client;

    startWatch();
  }

  protected abstract void start(URL url, Map<String, String> headers, WatchRequestState state);

  /**
   * Attempt to gracefully close the current request.
   * <p>
   * If forceClosed has not been set, then it's expected that the watch will
   * attempt to reconnect
   */
  public synchronized void closeRequest() {
    WatchRequestState state = latestRequestState;
    if (state != null && state.closed.compareAndSet(false, true)) {
      logger.debug("Closing the current watch");
      closeCurrentRequest();
      CompletableFuture<Void> future = Utils.schedule(Runnable::run, () -> failSafeReconnect(state), watchEndCheckMs,
          TimeUnit.MILLISECONDS);
      state.ended.whenComplete((v, t) -> future.cancel(true));
    }
  }

  private synchronized void failSafeReconnect(WatchRequestState state) {
    if (state == latestRequestState && !forceClosed.get() && (reconnectAttempt == null || reconnectAttempt.isDone())) {
      logger.error("The last watch has yet to terminate as expected, will force start another watch. "
          + "Please report this to the Fabric8 Kubernetes Client development team.");
      reconnect();
    }
  }

  public void setWatchEndCheckMs(int watchEndCheckMs) {
    this.watchEndCheckMs = watchEndCheckMs;
  }

  protected abstract void closeCurrentRequest();

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
  void scheduleReconnect(WatchRequestState state) {
    if (!state.reconnected.compareAndSet(false, true)) {
      return;
    }
    if (isForceClosed()) {
      logger.debug("Ignoring already closed/closing connection");
      return;
    }

    if (cannotReconnect()) {
      close(new WatcherException("Exhausted reconnects"));
      return;
    }

    long delay = nextReconnectInterval();

    logger.debug("Scheduling reconnect task in {} ms", delay);

    synchronized (this) {
      reconnectAttempt = Utils.schedule(baseOperation.getOperationContext().getExecutor(), this::reconnect, delay,
          TimeUnit.MILLISECONDS);
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
    return Math.max(retryAfterSeconds.getAndSet(0) * 1000L, retryIntervalCalculator.nextReconnectInterval());
  }

  void resetReconnectAttempts(WatchRequestState state) {
    if (state.closed.get()) {
      return;
    }
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
      resource = this.baseOperation.getKubernetesSerialization().convertValue(resource, baseOperation.getType());
    }
    @SuppressWarnings("unchecked")
    final T t = (T) resource;
    try {
      watcher.eventReceived(action, t);
    } catch (Exception e) {
      // for compatibility, this will just log the exception as was done in previous versions
      // a case could be made for this to terminate the watch instead
      logger.error("Unhandled exception encountered in watcher event handler", e);
    }
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
    latestRequestState = new WatchRequestState();
    start(url, headers, latestRequestState);
  }

  @Override
  public void close() {
    logger.debug("Force closing the watch");
    closeEvent();
    closeRequest();
    cancelReconnect();
  }

  private WatchEvent contextAwareWatchEventDeserializer(String messageSource)
      throws JsonProcessingException {
    KubernetesSerialization kubernetesSerialization = this.baseOperation.getKubernetesSerialization();
    try {
      return kubernetesSerialization.unmarshal(messageSource, WatchEvent.class);
    } catch (Exception ex1) {
      // TODO: this is not necessarily correct - it will force the object to be the expected type
      // even though it is not (for example Status could be converted to the typed result)
      JsonNode json = kubernetesSerialization.unmarshal(messageSource, JsonNode.class);
      JsonNode objectJson = null;
      if (json instanceof ObjectNode && json.has("object")) {
        objectJson = ((ObjectNode) json).remove("object");
      }

      WatchEvent watchEvent = kubernetesSerialization.convertValue(json, WatchEvent.class);
      KubernetesResource object = kubernetesSerialization.convertValue(objectJson, baseOperation.getType());

      watchEvent.setObject(object);
      return watchEvent;
    }
  }

  protected void onMessage(String message, WatchRequestState state) {
    endErrors.clear();
    if (state.closed.get() || forceClosed.get()) {
      return;
    }
    try {
      WatchEvent event = contextAwareWatchEventDeserializer(message);
      Object object = event.getObject();
      Action action = Action.valueOf(event.getType());
      if (action == Action.ERROR) {
        if (object instanceof Status) {
          Status status = (Status) object;

          onStatus(status, state);
        } else {
          logger.error("Error received, but object is not a status - will retry");
          closeRequest();
        }
      } else if (object instanceof HasMetadata) {
        HasMetadata hasMetadata = (HasMetadata) object;
        updateResourceVersion(hasMetadata.getMetadata().getResourceVersion());
        eventReceived(action, hasMetadata);
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

  protected boolean onStatus(Status status, WatchRequestState state) {
    endErrors.clear();
    if (state.closed.get()) {
      return true;
    }
    // The resource version no longer exists - this has to be handled by the caller.
    if (Integer.valueOf(HTTP_GONE).equals(status.getCode())) {
      close(new WatcherException(status.getMessage(), new KubernetesClientException(status)));
      return true;
    }

    logger.error("Error received: {}, will retry", status);
    // save the after seconds for the retry attempt
    retryAfterSeconds.set(Optional.ofNullable(status.getDetails()).map(StatusDetails::getRetryAfterSeconds).orElse(0));
    closeRequest();
    return false;
  }

  void watchEnded(Throwable t, WatchRequestState state) {
    state.ended.complete(null);
    if (state != latestRequestState) {
      // should not happen, but there is already some mitigation logic in the jetty client,
      // so we'll guard against an erroneous error after the logical close which would cause
      // a reconnect
      if (t != null) {
        logger.debug("Watch error received after the next watch started", t);
      }
      return;
    }
    if (t instanceof ProtocolException) {
      // informers could generally try relisting in this case, but for now would need to override the execeptionHandler
      close(new WatcherException("Could not process Watch response", t));
      return;
    }
    try {
      if (t != null) {
        logEndError(t);
      }
    } finally {
      scheduleReconnect(state);
    }
  }

  private void logEndError(Throwable t) {
    int occurrences = endErrors.compute(t.getClass(), (k, v) -> v == null ? 1 : v + 1);
    if (t instanceof IOException || t instanceof KubernetesClientException) {
      // could introspect the KubernetesClientException - it may represent something that should have elevated logging
      if (occurrences > INFO_LOG_CONNECTION_ERRORS) {
        logger.info("Watch connection error recieved {} times without progress, will reconnect if possible", occurrences, t);
      } else {
        logger.debug("Watch connection error, will reconnect if possible", t);
      }
    } else if (occurrences > 1) {
      logger.info("Unknown Watch error received {} times without progress, will reconnect if possible", occurrences, t);
    } else {
      logger.debug("Unknown Watch error received, will reconnect if possible", t);
    }
  }

}
