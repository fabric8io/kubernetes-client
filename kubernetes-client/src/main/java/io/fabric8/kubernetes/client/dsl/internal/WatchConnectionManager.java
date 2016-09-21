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
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import static io.fabric8.kubernetes.client.utils.Utils.isNotNullOrEmpty;
import static java.net.HttpURLConnection.HTTP_GONE;

public class WatchConnectionManager<T, L extends KubernetesResourceList> implements Watch {

  private static final ObjectMapper mapper = new ObjectMapper();
  private final AtomicBoolean forceClosed = new AtomicBoolean();
  private final AtomicReference<String> resourceVersion;
  private final BaseOperation<T, L, ?, ?> baseOperation;
  private final Watcher<T> watcher;
  private final int reconnectLimit;
  private final int reconnectInterval;
  private final AtomicInteger currentReconnectAttempt = new AtomicInteger(0);
  private final AtomicReference<WebSocket> webSocketRef = new AtomicReference<>();
  private final ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
  private final AtomicBoolean started = new AtomicBoolean(false);
  private final ArrayBlockingQueue<Object> queue = new ArrayBlockingQueue<>(1);

  private WebSocketCall webSocketCall;
  private ScheduledFuture pingFuture;
  private OkHttpClient clonedClient;

  public WatchConnectionManager(final OkHttpClient client, final BaseOperation<T, L, ?, ?> baseOperation, final String version, final Watcher<T> watcher, final int reconnectInterval, final int reconnectLimit) throws InterruptedException, ExecutionException, MalformedURLException {
    if (version == null) {
      KubernetesResourceList currentList = baseOperation.list();
      this.resourceVersion = new AtomicReference<>(currentList.getMetadata().getResourceVersion());
    } else {
      this.resourceVersion = new AtomicReference<>(version);
    }
    this.clonedClient = client.newBuilder().readTimeout(1200, TimeUnit.MILLISECONDS).build();
    this.baseOperation = baseOperation;
    this.watcher = watcher;
    this.reconnectInterval = reconnectInterval;
    this.reconnectLimit = reconnectLimit;

    runWatch();
  }

  private final void runWatch() throws MalformedURLException, ExecutionException, InterruptedException {
    URL requestUrl = baseOperation.getNamespacedUrl();

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
      private final Logger logger = LoggerFactory.getLogger(this.getClass());

      @Override
      public void onOpen(final WebSocket webSocket, Response response) {
        logger.debug("WebSocket successfully opened");
        webSocketRef.set(webSocket);
        currentReconnectAttempt.set(0);
        started.set(true);
        queue.clear();
        queue.add(true);
        pingFuture = executor.scheduleAtFixedRate(
          new Runnable() {
            @Override
            public void run() {
              try {
                webSocket.sendPing(new Buffer().writeUtf8("Alive?"));
              } catch (IOException e) {
                logger.error("Failed to send ping", e);
                onClose(4000, "Connection unexpectedly closed");
              }
            }
          }, 0, 1, TimeUnit.SECONDS
        );
      }

      @Override
      public void onFailure(IOException e, Response response) {
        if (response != null) {
          //We only need to queue startup failures.
          Status status = OperationSupport.createStatus(response);
          logger.error("Exec Failure: HTTP:" + status.getCode() + ". Message:" + status.getMessage(), e);
          if (!started.get()) {
            queue.add(new KubernetesClientException(status));
          }
        } else {
          logger.error("Exec Failure", e);
          if (!started.get()) {
            queue.add(KubernetesClientException.launderThrowable(e));
          }
        }

        if (response != null && response.body() != null){
          response.body().close();
        }

        if (forceClosed.get()) {
          watcher.onClose(null);
          return;
        }

        if (reconnectLimit >= 0 && currentReconnectAttempt.getAndIncrement() >= reconnectLimit) {
          watcher.onClose(new KubernetesClientException("Connection unexpectedly closed", e));
          return;
        }
        try {
          TimeUnit.MILLISECONDS.sleep(reconnectInterval);
        } catch (InterruptedException e1) {
          watcher.onClose(new KubernetesClientException("Connection unexpectedly closed", e1));
          return;
        }
        onClose(4000, "Connection unexpectedly closed");
      }

      @Override
      public void onMessage(ResponseBody message) throws IOException {
        String messageSource = null;
        try {
          messageSource = message.string();
          WatchEvent event = mapper.readValue(messageSource, WatchEvent.class);

          if (event.getObject() instanceof HasMetadata) {
            T obj = (T) event.getObject();
            //Dirty cast - should always be valid though
            String currentResourceVersion = resourceVersion.get();
            String newResourceVersion = ((HasMetadata) obj).getMetadata().getResourceVersion();
            if (currentResourceVersion.compareTo(newResourceVersion) < 0) {
              resourceVersion.compareAndSet(currentResourceVersion, newResourceVersion);
            }
            Watcher.Action action = Watcher.Action.valueOf(event.getType());
            watcher.eventReceived(action, obj);
          } else if (event.getObject() instanceof Status){
            Status status = (Status) event.getObject();

            // The resource version no longer exists - this has to be handled by the caller.
            if (status.getCode() == HTTP_GONE) {
              close();
              watcher.onClose(new KubernetesClientException(status));
              return;
            }

            logger.error("Error received: {}", status.toString());
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
            onClose(4000, "Connection unexpectedly closed");
          }
        } finally{
          buffer.close();
        }
      }

      @Override
      public void onClose(final int code, final String reason) {
        if (!pingFuture.isCancelled() && !pingFuture.isDone()) {
          pingFuture.cancel(true);
        }

        if (forceClosed.get()) {
          watcher.onClose(null);
          return;
        }

        // Let's close the websocket before trying to reopen a new one.
        try {
          WebSocket ws = webSocketRef.get();
          if (ws != null) {
            ws.close(1000, "Closing...");
            webSocketRef.set(null);
          }
        } catch (IOException e) {
          e.printStackTrace();
        } catch (IllegalStateException e) {
          // Ignore...
        }

        executor.submit(new Runnable() {
          @Override
          public void run() {
            try {
              queue.clear();
              runWatch();
            } catch (ExecutionException e) {
              if (e.getCause() != null && e.getCause().getCause() != null && e.getCause().getCause() instanceof ConnectException) {
                if (reconnectLimit >= 0 && currentReconnectAttempt.getAndIncrement() >= reconnectLimit) {
                  watcher.onClose(new KubernetesClientException("Connection unexpectedly closed", e));
                  return;
                }
                try {
                  TimeUnit.MILLISECONDS.sleep(reconnectInterval);
                } catch (InterruptedException e1) {
                  watcher.onClose(new KubernetesClientException("Connection unexpectedly closed", e1));
                  return;
                }
                onClose(code, reason);
              }
            } catch (MalformedURLException | InterruptedException e) {
              throw KubernetesClientException.launderThrowable(e);
            }
          }
        });
      }
    });
  }

  public void waitUntilReady() {
    try {
      Object obj = queue.poll(10, TimeUnit.SECONDS);
      if (Boolean.TRUE.equals(obj)) {
        return;
      } else {
        if (obj instanceof Throwable) {
          throw (Throwable) obj;
        }
      }
    } catch (Throwable t) {
      throw KubernetesClientException.launderThrowable(t);
    }
  }

  @Override
  public void close() {
    forceClosed.set(true);
    try {
      WebSocket ws = webSocketRef.get();
      if (ws != null) {
        ws.close(1000, "Closing...");
        webSocketRef.set(null);
      }
    } catch (IOException | IllegalStateException e) {
      e.printStackTrace();
    }

    if (!executor.isShutdown()) {
      try {
        executor.shutdown();
        if (!executor.awaitTermination(1, TimeUnit.SECONDS)) {
          executor.shutdownNow();
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    if (!executor.isShutdown()) {
      try {
        executor.shutdown();
        if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
          executor.shutdownNow();
        }
      } catch (Throwable t) {
        throw KubernetesClientException.launderThrowable(t);
      }
    }
  }
}
