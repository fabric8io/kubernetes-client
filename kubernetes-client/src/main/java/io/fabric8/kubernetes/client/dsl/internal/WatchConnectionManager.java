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

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.api.model.WatchEvent;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.dsl.base.BaseOperation;
import io.fabric8.kubernetes.client.dsl.base.OperationSupport;
import io.fabric8.kubernetes.client.utils.Utils;
import okhttp3.*;
import okio.ByteString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import static io.fabric8.kubernetes.client.dsl.internal.WatchHTTPManager.readWatchEvent;
import static io.fabric8.kubernetes.client.utils.Utils.isNotNullOrEmpty;
import static java.net.HttpURLConnection.HTTP_GONE;
import static java.net.HttpURLConnection.HTTP_OK;

public class WatchConnectionManager<T extends HasMetadata, L extends KubernetesResourceList<T>> implements Watch {

  private static final Logger logger = LoggerFactory.getLogger(WatchConnectionManager.class);

  private static final ObjectMapper mapper = new ObjectMapper();
  private final AtomicBoolean forceClosed = new AtomicBoolean();
  private final AtomicReference<String> resourceVersion;
  private final BaseOperation<T, L, ?, ?> baseOperation;
  private final Watcher<T> watcher;
  private final int reconnectLimit;
  private final int reconnectInterval;
  // TODO maybe make this configurable, either as is (an exponent) or a max time
  private final static int maxIntervalExponent = 5; // max 32x slowdown from base interval
  private final long websocketTimeout;
  private final AtomicInteger currentReconnectAttempt = new AtomicInteger(0);
  private final AtomicReference<WebSocket> webSocketRef = new AtomicReference<>();
  // single threaded serial executor
  private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() {
    @Override
    public Thread newThread(Runnable r) {
      Thread ret = new Thread(r, "Executor for Watch " + System.identityHashCode(WatchConnectionManager.this));
      ret.setDaemon(true);
      return ret;
    }
  });
  /** True if an onOpen callback was received on the first connect attempt, ie. the watch was successfully started. */
  private final AtomicBoolean started = new AtomicBoolean(false);
  private final AtomicBoolean reconnectPending = new AtomicBoolean(false);
  /** Blocking queue for startup exceptions. */
  private final ArrayBlockingQueue<Object> queue = new ArrayBlockingQueue<>(1);
  private final URL requestUrl;

  private WebSocket webSocket;
  private OkHttpClient clonedClient;

  public WatchConnectionManager(final OkHttpClient client, final BaseOperation<T, L, ?, ?> baseOperation, final String version, final Watcher<T> watcher, final int reconnectInterval, final int reconnectLimit, long websocketTimeout) throws MalformedURLException {
    this.resourceVersion = new AtomicReference<>(version); // may be a reference to null
    this.baseOperation = baseOperation;
    this.watcher = watcher;
    this.reconnectInterval = reconnectInterval;
    this.reconnectLimit = reconnectLimit;
    this.websocketTimeout = websocketTimeout;

    this.clonedClient = client.newBuilder().readTimeout(this.websocketTimeout, TimeUnit.MILLISECONDS).build();

    // The URL is created, validated and saved once, so that reconnect attempts don't have to deal with
    // MalformedURLExceptions that would never occur
    requestUrl = baseOperation.getNamespacedUrl();
    runWatch();
  }

  private final void runWatch() {
    logger.debug("Connecting websocket ... {}", this);

    HttpUrl.Builder httpUrlBuilder = HttpUrl.get(requestUrl).newBuilder();

    String labelQueryParam = baseOperation.getLabelQueryParam();
    if (isNotNullOrEmpty(labelQueryParam)) {
      httpUrlBuilder.addQueryParameter("labelSelector", labelQueryParam);
    }

    String fieldQueryString = baseOperation.getFieldQueryParam();
    String name = baseOperation.getName();

    // for API groups we can use the name in the path rather than a fieldSelector
    // which is more likely to work well for API Groups
    if (name != null && name.length() > 0) {
      if (baseOperation.isApiGroup()) {
        httpUrlBuilder.addPathSegment(name);
      } else {
        if (fieldQueryString.length() > 0) {
          fieldQueryString += ",";
        }
        fieldQueryString += "metadata.name=" + name;
      }
    }
    if (isNotNullOrEmpty(fieldQueryString)) {
      if (baseOperation.isApiGroup()) {
        logger.warn("Ignoring field selector " + fieldQueryString + " on watch URI " + requestUrl + " as fieldSelector is not yet supported on API Groups APIs");
      } else {
        httpUrlBuilder.addQueryParameter("fieldSelector", fieldQueryString);
      }
    }

    if (this.resourceVersion.get() != null) {
      httpUrlBuilder.addQueryParameter("resourceVersion", this.resourceVersion.get());
    }

    httpUrlBuilder.addQueryParameter("watch", "true");

    Request request = new Request.Builder()
      .get()
      .url(httpUrlBuilder.build())
      .addHeader("Origin", requestUrl.getProtocol() + "://" + requestUrl.getHost() + ":" + requestUrl.getPort())
      .build();

    webSocket = clonedClient.newWebSocket(request, new WebSocketListener() {
      @Override
      public void onOpen(final WebSocket webSocket, Response response) {
        if (response != null && response.body() != null) {
          response.body().close();
        }
        logger.debug("WebSocket successfully opened");
        webSocketRef.set(webSocket);
        currentReconnectAttempt.set(0);
        started.set(true);
        queue.clear();
        queue.add(true);
      }

      @Override
      public void onFailure(WebSocket webSocket, Throwable t, Response response) {
        if (forceClosed.get()) {
          logger.debug("Ignoring onFailure for already closed/closing websocket", t);
          // avoid resource leak though
          if (response != null && response.body() != null) {
            response.body().close();
          }
          return;
        }

        // We do not expect a 200 in response to the websocket connection. If it occurs, we throw
        // an exception and try the watch via a persistent HTTP Get.
        if (response != null && response.code() == HTTP_OK) {
          queue.add(new KubernetesClientException("Received 200 on websocket",
            response.code(), null));
          response.body().close();
          return;
        }

        if (response != null) {
          // We only need to queue startup failures.
          Status status = OperationSupport.createStatus(response);
          if (response.body() != null) {
            response.body().close();
          }
          logger.warn("Exec Failure: HTTP {}, Status: {} - {}", response.code(), status.getCode(), status.getMessage(),
              t);
          if (!started.get()) {
            queue.add(new KubernetesClientException(status));
            return; // no reconnect
          }
        } else {
          logger.warn("Exec Failure", t);
          if (!started.get()) {
            queue.add(new KubernetesClientException("Failed to start websocket", t));
            return; // no reconnect
          }
        }

        if (currentReconnectAttempt.get() >= reconnectLimit && reconnectLimit >= 0) {
          closeEvent(new KubernetesClientException("Connection failure", t));
          return;
        }

        scheduleReconnect();
      }

      @Override
      public void onMessage(WebSocket webSocket, ByteString bytes) {
        onMessage(webSocket, bytes.utf8());
      }

      @Override
      public void onMessage(WebSocket webSocket, String message) {
        try {
          WatchEvent event = readWatchEvent(message);
          Object object = event.getObject();
          if (object instanceof HasMetadata) {
            @SuppressWarnings("unchecked")
            T obj = (T) object;
            // Dirty cast - should always be valid though
            String currentResourceVersion = resourceVersion.get();
            String newResourceVersion = ((HasMetadata) obj).getMetadata().getResourceVersion();
            if (currentResourceVersion == null || currentResourceVersion.compareTo(newResourceVersion) < 0) {
              resourceVersion.compareAndSet(currentResourceVersion, newResourceVersion);
            }
            Watcher.Action action = Watcher.Action.valueOf(event.getType());
            watcher.eventReceived(action, obj);
          } else if (object instanceof KubernetesResourceList) {
            @SuppressWarnings("unchecked")

            KubernetesResourceList list = (KubernetesResourceList) object;
            // Dirty cast - should always be valid though
            String currentResourceVersion = resourceVersion.get();
            String newResourceVersion = list.getMetadata().getResourceVersion();
            if (currentResourceVersion == null || currentResourceVersion.compareTo(newResourceVersion) < 0) {
              resourceVersion.compareAndSet(currentResourceVersion, newResourceVersion);
            }
            Watcher.Action action = Watcher.Action.valueOf(event.getType());
            List<HasMetadata> items = list.getItems();
            if (items != null) {
              for (HasMetadata item : items) {
                watcher.eventReceived(action, (T) item);
              }
            }
          } else if (object instanceof Status) {
            Status status = (Status) object;

            // The resource version no longer exists - this has to be handled by the caller.
            if (status.getCode() == HTTP_GONE) {
              webSocketRef.set(null); // lose the ref: closing in close() would only generate a Broken pipe
                                      // exception
              // shut down executor, etc.
              closeEvent(new KubernetesClientException(status));
              close();
              return;
            }

            logger.error("Error received: {}", status.toString());
          } else {
            logger.error("Unknown message received: {}", message);
          }
        } catch (IOException e) {
          logger.error("Could not deserialize watch event: {}", message, e);
        } catch (ClassCastException e) {
          logger.error("Received wrong type of object for watch", e);
        } catch (IllegalArgumentException e) {
          logger.error("Invalid event type", e);
        }
      }

      @Override
      public void onClosing(WebSocket webSocket, int code, String reason) {
        webSocket.close(code, reason);
      }

      @Override
      public void onClosed(WebSocket webSocket, int code, String reason) {
        logger.debug("WebSocket close received. code: {}, reason: {}", code, reason);
        if (forceClosed.get()) {
          logger.debug("Ignoring onClose for already closed/closing websocket");
          return;
        }
        if (currentReconnectAttempt.get() >= reconnectLimit && reconnectLimit >= 0) {
          closeEvent(new KubernetesClientException("Connection unexpectedly closed"));
          return;
        }
        scheduleReconnect();
      }
    });
  }

  private void scheduleReconnect() {

    logger.debug("Submitting reconnect task to the executor");
    // make sure that whichever thread calls this method, the tasks are
    // performed serially in the executor
    executor.submit(new NamedRunnable("scheduleReconnect") {
      @Override
      public void execute() {
        if (!reconnectPending.compareAndSet(false, true)) {
          logger.debug("Reconnect already scheduled");
          return;
        }
        webSocketRef.set(null);
        try {
          // actual reconnect only after the back-off time has passed, without
          // blocking the thread
          logger.debug("Scheduling reconnect task");
          executor.schedule(new NamedRunnable("reconnectAttempt") {
            @Override
            public void execute() {
              try {
                runWatch();
                reconnectPending.set(false);
              } catch (Exception e) {
                // An unexpected error occurred and we didn't even get an onFailure callback.
                logger.error("Exception in reconnect", e);
                webSocketRef.set(null);
                closeEvent(new KubernetesClientException("Unhandled exception in reconnect attempt", e));
                close();
              }
            }
          }, nextReconnectInterval(), TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e) {
          reconnectPending.set(false);
        }
      }
    });
  }

  public void waitUntilReady() {
    Utils.waitUntilReady(queue, 10, TimeUnit.SECONDS);
  }

  @Override
  public void close() {
    logger.debug("Force closing the watch {}", this);
    closeEvent(null);
    closeWebSocket(webSocketRef.getAndSet(null));
    if (!executor.isShutdown()) {
      try {
        executor.shutdown();
        if (!executor.awaitTermination(1, TimeUnit.SECONDS)) {
          logger.warn("Executor didn't terminate in time after shutdown in close(), killing it in: {}", this);
          executor.shutdownNow();
        }
      } catch (Throwable t) {
        throw KubernetesClientException.launderThrowable(t);
      }
    }
  }

  private void closeEvent(KubernetesClientException cause) {
    if (forceClosed.getAndSet(true)) {
      logger.debug("Ignoring duplicate firing of onClose event");
      return;
    }
    watcher.onClose(cause);
  }

  private void closeWebSocket(WebSocket ws) {
    if (ws != null) {
      logger.debug("Closing websocket {}", ws);
      try {
        if (!ws.close(1000, null)) {
          logger.warn("Failed to close websocket");
        }
      } catch (IllegalStateException e) {
        logger.error("Called close on already closed websocket: {} {}", e.getClass(), e.getMessage());
      }
    }
  }

  private long nextReconnectInterval() {
    int exponentOfTwo = currentReconnectAttempt.getAndIncrement();
    if (exponentOfTwo > maxIntervalExponent)
      exponentOfTwo = maxIntervalExponent;
    long ret = reconnectInterval * (1 << exponentOfTwo);
    logger.info("Current reconnect backoff is " + ret + " milliseconds (T" + exponentOfTwo + ")");
    return ret;
  }

  private static abstract class NamedRunnable implements Runnable {
    private final String name;

    public NamedRunnable(String name) {
      this.name = Objects.requireNonNull(name);
    }

    private void tryToSetName(String value) {
      try {
        Thread.currentThread().setName(value);
      } catch (SecurityException ignored) {
      }
    }

    public final void run() {
      String oldName = Thread.currentThread().getName();
      tryToSetName(this.name + "|" + oldName);
      try {
        execute();
      } finally {
        tryToSetName(oldName);
      }
    }

    protected abstract void execute();
  }
}
