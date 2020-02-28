/**
 * Copyright (C) 2015 Fabric8 Authors.
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
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.dsl.base.OperationSupport;
import io.fabric8.kubernetes.client.utils.Utils;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import static java.net.HttpURLConnection.HTTP_OK;

/**
 * This class just replicates WatchConnectionManager in handling watch connections but
 * instead of using a solid type for deserializing events, it uses plain strings.
 *
 */
public class RawWatchConnectionManager implements Watch {
  private static final Logger logger = LoggerFactory.getLogger(RawWatchConnectionManager.class);
  private ObjectMapper objectMapper;
  private Watcher<String> watcher;
  private Request watchRequest;

  private final AtomicBoolean forceClosed = new AtomicBoolean();
  private final AtomicReference<String> resourceVersion;
  private final int reconnectLimit;
  private final int reconnectInterval;
  private int maxIntervalExponent;
  private final AtomicInteger currentReconnectAttempt = new AtomicInteger(0);
  private final AtomicReference<WebSocket> webSocketRef = new AtomicReference<>();
  // single threaded serial executor
  private final ScheduledExecutorService executor;
  /** True if an onOpen callback was received on the first connect attempt, ie. the watch was successfully started. */
  private final AtomicBoolean started = new AtomicBoolean(false);
  private final AtomicBoolean reconnectPending = new AtomicBoolean(false);
  /** Blocking queue for startup exceptions. */
  private final ArrayBlockingQueue<Object> queue = new ArrayBlockingQueue<>(1);

  private WebSocket webSocket;
  private OkHttpClient clonedClient;

  public RawWatchConnectionManager(OkHttpClient okHttpClient, Request watchRequest, String resourceVersion, ObjectMapper objectMapper, final Watcher<String> watcher, int reconnectLimit, int reconnectInterval, int maxIntervalExponent)  {
    this.clonedClient = okHttpClient;
    this.watchRequest = watchRequest;
    this.objectMapper = objectMapper;
    this.watcher = watcher;
    this.reconnectLimit = reconnectLimit;
    this.reconnectInterval = reconnectInterval;
    this.resourceVersion = new AtomicReference<>(resourceVersion);
    this.maxIntervalExponent = maxIntervalExponent;
    executor = Executors.newSingleThreadScheduledExecutor(r -> {
      Thread ret = new Thread(r, "Executor for Watch " + System.identityHashCode(RawWatchConnectionManager.this));
      ret.setDaemon(true);
      return ret;
    });

    runWatch();
  }

  private void runWatch() {
    webSocket = clonedClient.newWebSocket(watchRequest, new WebSocketListener() {
      @Override
      public void onOpen(WebSocket webSocket, Response response) {
        logger.info("Websocket opened");
        webSocketRef.set(webSocket);
        currentReconnectAttempt.set(0);
        started.set(true);
        queue.clear();
        queue.add(true);
      }

      @Override
      public void onMessage(WebSocket webSocket, String text) {
        try {
          Map<String, Object> watchEvent = objectMapper.readValue(text, HashMap.class);

          String watchEventType = watchEvent.get("type").toString();
          String watchObjectAsString = objectMapper.writeValueAsString(watchEvent.get("object"));

          watcher.eventReceived(Watcher.Action.valueOf(watchEventType), watchObjectAsString);

        } catch (IOException exception) {
          logger.error("Failed to deserialize watch response: " + exception.getMessage());
        }
      }

      @Override
      public void onMessage(WebSocket webSocket, ByteString bytes) {
        onMessage(webSocket, bytes.utf8());
      }

      @Override
      public void onClosing(WebSocket webSocket, int code, String reason) {
        logger.info("Socket closing: " + reason);
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
          queue.clear();
          queue.offer(new KubernetesClientException("Received 200 on websocket",
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
            queue.clear();
            queue.offer(new KubernetesClientException(status));
          }
        } else {
          logger.warn("Exec Failure", t);
          if (!started.get()) {
            queue.clear();
            queue.offer(new KubernetesClientException("Failed to start websocket", t));
          }
        }

        if (currentReconnectAttempt.get() >= reconnectLimit && reconnectLimit >= 0) {
          closeEvent(new KubernetesClientException("Connection failure", t));
          return;
        }

        scheduleReconnect();
      }
    });
  }

  private void scheduleReconnect() {

    logger.debug("Submitting reconnect task to the executor");
    // Don't submit new tasks after having called shutdown() on executor
    if(!executor.isShutdown()) {
      // make sure that whichever thread calls this method, the tasks are
      // performed serially in the executor
      executor.submit(new RawWatchConnectionManager.NamedRunnable("scheduleReconnect") {
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
            executor.schedule(new RawWatchConnectionManager.NamedRunnable("reconnectAttempt") {
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
    logger.debug("Current reconnect backoff is " + ret + " milliseconds (T" + exponentOfTwo + ")");
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
