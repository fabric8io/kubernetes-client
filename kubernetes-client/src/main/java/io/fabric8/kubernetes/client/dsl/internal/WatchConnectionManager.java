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
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.ws.WebSocket;
import okhttp3.ws.WebSocketCall;
import okhttp3.ws.WebSocketListener;
import okio.Buffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import static io.fabric8.kubernetes.client.utils.Utils.isNotNullOrEmpty;
import static java.net.HttpURLConnection.HTTP_GONE;

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
  private final long websocketPingInterval;
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

  private WebSocketCall webSocketCall;
  private ScheduledFuture<?> pingFuture;
  private OkHttpClient clonedClient;

  public WatchConnectionManager(final OkHttpClient client, final BaseOperation<T, L, ?, ?> baseOperation, final String version, final Watcher<T> watcher, final int reconnectInterval, final int reconnectLimit, long websocketTimeout, long websocketPingInterval) throws MalformedURLException {
    if (version == null) {
      L currentList = baseOperation.list();
      this.resourceVersion = new AtomicReference<>(currentList.getMetadata().getResourceVersion());
    } else {
      this.resourceVersion = new AtomicReference<>(version);
    }
    this.baseOperation = baseOperation;
    this.watcher = watcher;
    this.reconnectInterval = reconnectInterval;
    this.reconnectLimit = reconnectLimit;
    this.websocketTimeout = websocketTimeout;
    this.websocketPingInterval = websocketPingInterval;

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
    if (name != null && name.length() > 0) {
      if (fieldQueryString.length() > 0) {
        fieldQueryString += ",";
      }
      fieldQueryString += "metadata.name=" + name;
    }
    if (isNotNullOrEmpty(fieldQueryString)) {
      httpUrlBuilder.addQueryParameter("fieldSelector", fieldQueryString);
    }

    httpUrlBuilder
      .addQueryParameter("resourceVersion", this.resourceVersion.get())
      .addQueryParameter("watch", "true");

    Request request = new Request.Builder()
      .get()
      .url(httpUrlBuilder.build())
      .addHeader("Origin", requestUrl.getProtocol() + "://" + requestUrl.getHost() + ":" + requestUrl.getPort())
      .build();

    webSocketCall = WebSocketCall.create(clonedClient, request);
    webSocketCall.enqueue(new WebSocketListener() {
      @Override
      public void onOpen(final WebSocket webSocket, Response response) {
        if (response != null && response.body() != null) {
          response.body().close();
        }
        logger.info("WebSocket successfully opened");
        webSocketRef.set(webSocket);
        currentReconnectAttempt.set(0);
        started.set(true);
        queue.clear();
        queue.add(true);
        pingFuture = executor.scheduleAtFixedRate(new NamedRunnable("websocket ping") {
          @Override
          public void execute() {
            WebSocket ws = webSocketRef.get();
            if (ws == null) // not currently running
              return;
            try {
              ws.sendPing(new Buffer().writeUtf8("Alive?"));
            } catch (IOException e) {
              logger.debug("Failed to send ping", e);
              // sendPing: IOException - if unable to write the ping. Clients must call close when this happens to
              // ensure resources are cleaned up.
              closeWebSocket(ws);
              // onFailure expects that the socket was already closed by okhttp
              onFailure(e, null);
            } catch (IllegalStateException e) {
              logger.error("Tried to send ping in already closed websocket");
            }
          }
        }, websocketPingInterval, websocketPingInterval, TimeUnit.MILLISECONDS);
      }

      @Override
      public void onFailure(IOException e, Response response) {
        if (forceClosed.get()) {
          logger.warn("Ignoring onFailure for already closed/closing websocket", e);
          // avoid resource leak though
          if (response != null && response.body() != null) {
            response.body().close();
          }
          return;
        }

        if (response != null) {
          // We only need to queue startup failures.
          Status status = OperationSupport.createStatus(response);
          if (response.body() != null) {
            response.body().close();
          }
          logger.warn("Exec Failure: HTTP {}, Status: {} - {}", response.code(), status.getCode(), status.getMessage(),
              e);
          if (!started.get()) {
            queue.add(new KubernetesClientException(status));
            return; // no reconnect
          }
        } else {
          logger.warn("Exec Failure", e);
          if (!started.get()) {
            queue.add(new KubernetesClientException("Failed to start websocket", e));
            return; // no reconnect
          }
        }

        if (currentReconnectAttempt.get() >= reconnectLimit && reconnectLimit >= 0) {
          watcher.onClose(new KubernetesClientException("Connection failure", e));
          return;
        }

        scheduleReconnect();
      }

      @Override
      public void onMessage(ResponseBody message) throws IOException {
        String messageSource = null;
        try {
          messageSource = message.string();
          WatchEvent event = mapper.readValue(messageSource, WatchEvent.class);

          if (event.getObject() instanceof HasMetadata) {
            @SuppressWarnings("unchecked")
            T obj = (T) event.getObject();
            // Dirty cast - should always be valid though
            String currentResourceVersion = resourceVersion.get();
            String newResourceVersion = ((HasMetadata) obj).getMetadata().getResourceVersion();
            if (currentResourceVersion.compareTo(newResourceVersion) < 0) {
              resourceVersion.compareAndSet(currentResourceVersion, newResourceVersion);
            }
            Watcher.Action action = Watcher.Action.valueOf(event.getType());
            watcher.eventReceived(action, obj);
          } else if (event.getObject() instanceof Status) {
            Status status = (Status) event.getObject();

            // The resource version no longer exists - this has to be handled by the caller.
            if (status.getCode() == HTTP_GONE) {
              webSocketRef.set(null); // lose the ref: closing in close() would only generate a Broken pipe
                                      // exception
              // shut down executor, etc.
              close();
              watcher.onClose(new KubernetesClientException(status));
              return;
            }

            logger.error("Error received: {}", status.toString());
          } else {
            logger.error("Unknown message received: {}", messageSource);
          }
        } catch (IOException e) {
          logger.error("Could not deserialize watch event: {}", messageSource, e);
        } catch (ClassCastException e) {
          logger.error("Received wrong type of object for watch", e);
        } catch (IllegalArgumentException e) {
          logger.error("Invalid event type", e);
        } finally {
          message.close();
        }
      }

      @Override
      public void onPong(Buffer buffer) {
        try {
          if (!buffer.equals(new Buffer().writeUtf8("Alive?"))) {
            logger.error("Failed to verify pong");
            // onClose expects that the socket was already closed by okhttp
            closeWebSocket(webSocketRef.get());
            onClose(4000, "WebSocket pong verification error");
          }
        } finally {
          buffer.close();
        }
      }

      @Override
      public void onClose(final int code, final String reason) {
        logger.info("WebSocket close received. code: {}, reason: {}", code, reason);
        if (forceClosed.get()) {
          logger.warn("Ignoring onClose for already closed/closing websocket");
          return;
        }
        if (currentReconnectAttempt.get() >= reconnectLimit && reconnectLimit >= 0) {
          watcher.onClose(new KubernetesClientException("Connection unexpectedly closed"));
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
        stopWsPing();
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
                close();
                watcher.onClose(new KubernetesClientException("Unhandled exception in reconnect attempt", e));
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
    forceClosed.set(true);
    stopWsPing();
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

  private void stopWsPing() {
    if (pingFuture != null && !pingFuture.isCancelled() && !pingFuture.isDone()) {
      pingFuture.cancel(true);
    }
    pingFuture = null;
  }

  private void closeWebSocket(WebSocket ws) {
    if (ws != null) {
      logger.debug("Closing websocket {}", ws);
      try {
        ws.close(0, null);
      } catch (IOException e) {
        if ("closed".equals(e.getMessage())) {
          logger.debug("Socket already closed");
        } else {
          logger.warn("Failed to write websocket close message: {} {}", e.getClass(), e.getMessage());
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
