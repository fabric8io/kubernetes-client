/*
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
import io.fabric8.kubernetes.api.model.StatusBuilder;
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
import java.util.Objects;
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
    private final SerialExecutor serialExecutor;

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
    final AtomicBoolean started = new AtomicBoolean();
    final AtomicBoolean messageReceived = new AtomicBoolean();
    long startedAtNs;
  }

  private static final Logger logger = LoggerFactory.getLogger(AbstractWatchManager.class);
  private static final int INFO_LOG_CONNECTION_ERRORS = 10;
  // Max connection lifetime (ns) under which a zero-message clean close is treated as a stale
  // resourceVersion rejection. GKE closes within ~100ms; legitimate idle closes take much longer.
  private static final long STALE_RV_CLOSE_THRESHOLD_NS = 2_000_000_000L;

  final Watcher<T> watcher;
  // Serializes both the message-deserialization+dispatch task (queued from onMessage) and the
  // user-facing watcher callbacks (queued by SerialWatcher). Keeping both on one queue gives
  // strict per-watch ordering, gets Jackson off the receive thread, and (combined with the
  // completion callback that re-arms the WebSocket) provides natural per-frame back-pressure.
  final SerialExecutor serialExecutor;
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

  @SuppressWarnings("java:S3077") // inner fields (AtomicBoolean, CompletableFuture) are thread-safe
  volatile WatchRequestState latestRequestState;
  private final Map<Class<?>, Integer> endErrors = new ConcurrentHashMap<>();
  private AtomicInteger retryAfterSeconds = new AtomicInteger();

  private int watchEndCheckMs = 120000;

  AbstractWatchManager(
      Watcher<T> watcher, BaseOperation<T, ?, ?> baseOperation, ListOptions listOptions, int reconnectLimit,
      int reconnectInterval, HttpClient client) throws MalformedURLException {
    // prevent the callbacks from happening in the httpclient thread
    this.serialExecutor = new SerialExecutor(baseOperation.getOperationContext().getExecutor());
    this.watcher = new SerialWatcher<>(watcher, this.serialExecutor);
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
      CompletableFuture<Void> future = schedule(() -> failSafeReconnect(state), watchEndCheckMs, TimeUnit.MILLISECONDS);
      state.ended.whenComplete((v, t) -> future.cancel(true));
    }
  }

  /**
   * Schedule a delayed task on the operation executor. Test-overridable seam so unit tests
   * can drive the fail-safe / reconnect timing deterministically without touching
   * {@link Utils#schedule}'s shared scheduler. Must return a non-null future:
   * {@link #closeRequest()} attaches a cancellation callback to it and will NPE otherwise.
   */
  protected CompletableFuture<Void> schedule(Runnable command, long delay, TimeUnit unit) {
    return Utils.schedule(baseOperation.getOperationContext().getExecutor(), command, delay, unit);
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
      reconnectAttempt = schedule(this::reconnect, delay, TimeUnit.MILLISECONDS);
      if (isForceClosed()) {
        cancelReconnect();
      }
    }
  }

  synchronized void reconnect() {
    try {
      if (client.isClosed()) {
        logger.debug("The client has closed, closing the watch");
        this.close();
        return;
      }
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
    URL url = this.baseOperation.appendListOptionParams(requestUrl, listOptions);

    String origin = requestUrl.getProtocol() + "://" + requestUrl.getHost();
    if (requestUrl.getPort() != -1) {
      origin += ":" + requestUrl.getPort();
    }

    Map<String, String> headers = new HashMap<>();
    headers.put("Origin", origin);

    logger.debug("Watching {}...", url);

    closeRequest(); // only one can be active at a time
    latestRequestState = new WatchRequestState();
    latestRequestState.startedAtNs = System.nanoTime();
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

  /**
   * Hand a freshly received frame off to the per-watch {@link SerialExecutor} for
   * deserialization and dispatch, returning immediately. This keeps Jackson's
   * deserializer-cold-path off the receive thread (the Vert.x event loop in the
   * WebSocket path), where a single Pod-deep type warmup under CPU contention has
   * been measured at tens of seconds and trips Vert.x's blocked-thread checker.
   * <p>
   * {@code onComplete} runs after the body finishes (success or failure) and is the
   * point where WebSocket flow control should be re-armed by the caller. Fire-and-forget
   * dispatch without it would let frames pile up faster than the executor can drain.
   * It is also fired synchronously when the serial executor has already been shut down
   * by the time this call enters, covering the common termination path. Two narrow
   * races remain (a {@code shutdownNow()} interleaved between this check and
   * {@code SerialExecutor.execute}, or between {@code execute} and the wrapper's own
   * shutdown check) where the runnable can be dropped; both can only happen at watch
   * teardown where the WebSocket is closing and back-pressure re-arm is moot. The
   * runnable must not be null; if it throws, the error is logged and swallowed so a
   * broken re-arm cannot wedge the queue.
   */
  protected void onMessage(String message, WatchRequestState state, Runnable onComplete) {
    Objects.requireNonNull(onComplete, "onComplete");
    if (serialExecutor.isShutdown()) {
      // The watch is already terminating; the executor would silently drop the task,
      // which would orphan the completion. Fire it inline so back-pressure never wedges.
      runQuietly(onComplete);
      return;
    }
    state.messageReceived.set(true);
    serialExecutor.execute(() -> {
      try {
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
              logger.error("Received an error which is not a status but {} - will retry", message);
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
      } finally {
        runQuietly(onComplete);
      }
    });
  }

  private static void runQuietly(Runnable r) {
    try {
      r.run();
    } catch (Exception e) {
      // Swallow: the completion callback is back-pressure re-arming (typically
      // webSocket.request()). If it fails, the WS itself is already broken and
      // propagating would also wedge the per-watch SerialExecutor's draining.
      logger.warn("Error invoking onMessage completion callback", e);
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
    // When a watch closes cleanly (code 1000, no body) with zero messages within a very short
    // window, treat it as a silent stale-resourceVersion rejection. This compensates for a
    // GKE-specific behaviour on v1/events where the GKFE proxy sends a bare close instead of
    // the standard {"type":"ERROR","code":410} response, causing the watch to loop indefinitely
    // with the same stale resourceVersion. Emitting a WatcherException mirrors the ProtocolException
    // path and lets the caller (e.g. an informer) decide how to recover.
    // See: https://github.com/kubernetes/kubernetes/issues/137089
    long connectionAgeNs = System.nanoTime() - state.startedAtNs;
    if (t == null && resourceVersion.get() != null && !state.messageReceived.get()
        && connectionAgeNs < STALE_RV_CLOSE_THRESHOLD_NS) {
      logger.debug("Watch ended cleanly with no messages after {}ms — treating as stale resourceVersion rejection",
          connectionAgeNs / 1_000_000);
      Status status = new StatusBuilder()
          .withCode(HTTP_GONE)
          .withStatus("Failure")
          .withReason("Expired")
          .withMessage("resourceVersion too old")
          .build();
      close(new WatcherException(status.getMessage(), new KubernetesClientException(status)));
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
        logger.info("Watch connection error received {} times without progress, will reconnect if possible", occurrences, t);
      } else {
        logger.debug("Watch connection error, will reconnect if possible", t);
      }
    } else if (occurrences > 1) {
      logger.info("Unknown Watch error received {} times without progress, will reconnect if possible", occurrences, t);
    } else {
      logger.debug("Unknown Watch error received, will reconnect if possible", t);
    }
  }

  public boolean isWatching() {
    return Optional.ofNullable(latestRequestState).map(s -> s.started.get() && !s.ended.isDone()).orElse(false);
  }

}
