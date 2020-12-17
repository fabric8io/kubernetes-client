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

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.ListOptions;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.api.model.WatchEvent;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.Watcher.Action;
import io.fabric8.kubernetes.client.WatcherException;
import io.fabric8.kubernetes.client.dsl.base.BaseOperation;
import io.fabric8.kubernetes.client.dsl.base.OperationSupport;
import io.fabric8.kubernetes.client.utils.HttpClientUtils;
import io.fabric8.kubernetes.client.utils.Utils;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import static io.fabric8.kubernetes.client.dsl.internal.WatchHTTPManager.readWatchEvent;
import static java.net.HttpURLConnection.HTTP_GONE;
import static java.net.HttpURLConnection.HTTP_OK;

public class WatchConnectionManager<T extends HasMetadata, L extends KubernetesResourceList<T>> extends AbstractWatchManager<T> {

  private static final Logger logger = LoggerFactory.getLogger(WatchConnectionManager.class);

  private final BaseOperation<T, L, ?> baseOperation;
  private final AtomicReference<WebSocket> webSocketRef = new AtomicReference<>();
  /** True if an onOpen callback was received on the first connect attempt, ie. the watch was successfully started. */
  private final AtomicBoolean started = new AtomicBoolean(false);
  private final AtomicBoolean reconnectPending = new AtomicBoolean(false);
  /** Blocking queue for startup exceptions. */
  private final ArrayBlockingQueue<Object> queue = new ArrayBlockingQueue<>(1);
  private final URL requestUrl;

  public WatchConnectionManager(final OkHttpClient client, final BaseOperation<T, L, ?> baseOperation, final ListOptions listOptions, final Watcher<T> watcher, final int reconnectInterval, final int reconnectLimit, long websocketTimeout, int maxIntervalExponent) throws MalformedURLException {
    super(
      watcher, listOptions, reconnectLimit, reconnectInterval, maxIntervalExponent,
      client.newBuilder()
        .readTimeout(websocketTimeout, TimeUnit.MILLISECONDS)
        .build()
    );
    this.baseOperation = baseOperation;

    // The URL is created, validated and saved once, so that reconnect attempts don't have to deal with
    // MalformedURLExceptions that would never occur

    requestUrl = baseOperation.getNamespacedUrl();
    runWatch();
  }

  public WatchConnectionManager(final OkHttpClient client, final BaseOperation<T, L, ?> baseOperation, final ListOptions listOptions, final Watcher<T> watcher, final int reconnectInterval, final int reconnectLimit, long websocketTimeout) throws MalformedURLException {
    // Default max 32x slowdown from base interval
    this(client, baseOperation, listOptions, watcher, reconnectInterval, reconnectLimit, websocketTimeout, 5);
  }

  private void runWatch() {
    logger.debug("Connecting websocket to {}...", requestUrl);

    HttpUrl.Builder httpUrlBuilder = HttpUrl.get(requestUrl).newBuilder();

    String labelQueryParam = baseOperation.getLabelQueryParam();
    if (Utils.isNotNullOrEmpty(labelQueryParam)) {
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
    if (Utils.isNotNullOrEmpty(fieldQueryString)) {
      httpUrlBuilder.addQueryParameter("fieldSelector", fieldQueryString);
    }

    listOptions.setResourceVersion(resourceVersion.get());
    HttpClientUtils.appendListOptionParams(httpUrlBuilder, listOptions);

    String origin = requestUrl.getProtocol() + "://" + requestUrl.getHost();
    if (requestUrl.getPort() != -1) {
        origin += ":" + requestUrl.getPort();
    }

    Request request = new Request.Builder()
      .get()
      .url(httpUrlBuilder.build())
      .addHeader("Origin", origin)
      .build();

    clonedClient.newWebSocket(request, new WebSocketListener() {
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
        // Newer Kubernetes might also return 503 Service Unavailable in case WebSockets are not supported
        if (response != null && (response.code() == HTTP_OK || response.code() == 503)) {
          queue.clear();
          queue.offer(new KubernetesClientException("Received " + response.code() + " on websocket",
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

        if (cannotReconnect()) {
          closeEvent(new WatcherException("Connection failure", t));
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
            resourceVersion.set(obj.getMetadata().getResourceVersion());
            Watcher.Action action = Watcher.Action.valueOf(event.getType());
            watcher.eventReceived(action, obj);
          } else if (object instanceof KubernetesResourceList) {
            KubernetesResourceList list = (KubernetesResourceList) object;
            // Dirty cast - should always be valid though
            resourceVersion.set(list.getMetadata().getResourceVersion());
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
              closeEvent(new WatcherException(status.getMessage(), new KubernetesClientException(status)));
              close();
              return;
            }

            watcher.eventReceived(Action.ERROR, null);
            logger.error("Error received: {}", status);
          } else {
            logger.error("Unknown message received: {}", message);
          }
        } catch (ClassCastException e) {
          logger.error("Received wrong type of object for watch", e);
        } catch (IllegalArgumentException e) {
          logger.error("Invalid event type", e);
        } catch (Throwable e) {
          logger.error("Unhandled exception encountered in watcher event handler", e);
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
        if (cannotReconnect()) {
          closeEvent(new WatcherException("Connection unexpectedly closed"));
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
    submit(new NamedRunnable("scheduleReconnect") {
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
          schedule(new NamedRunnable("reconnectAttempt") {
            @Override
            public void execute() {
              try {
                runWatch();
                reconnectPending.set(false);
              } catch (Exception e) {
                // An unexpected error occurred and we didn't even get an onFailure callback.
                logger.error("Exception in reconnect", e);
                webSocketRef.set(null);
                closeEvent(new WatcherException("Unhandled exception in reconnect attempt", e));
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
    closeEvent();
    closeWebSocket(webSocketRef.getAndSet(null));
    closeExecutorService();
  }

}
