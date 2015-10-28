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
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ws.WebSocket;
import com.squareup.okhttp.ws.WebSocketCall;
import com.squareup.okhttp.ws.WebSocketListener;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.WatchEvent;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import okio.Buffer;
import okio.BufferedSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class WatchConnectionManager<T, L extends KubernetesResourceList> implements Watch {

  private static final ObjectMapper mapper = new ObjectMapper();
  private final AtomicBoolean forceClosed = new AtomicBoolean();
  private final AtomicReference<String> resourceVersion;
  private final BaseOperation<?, T, L, ?, ?> baseOperation;
  private final Watcher<T> watcher;
  private final int reconnectLimit;
  private final int reconnectInterval;
  private final AtomicInteger currentReconnectAttempt = new AtomicInteger(0);
  private final AtomicReference<WebSocket> webSocketRef = new AtomicReference<>();
  private WebSocketCall webSocketCall;
  private OkHttpClient clonedClient;

  WatchConnectionManager(final BaseOperation<?, T, L, ?, ?> baseOperation, final String version, final Watcher<T> watcher, final int reconnectInterval, final int reconnectLimit) throws InterruptedException, ExecutionException, MalformedURLException {
    if (version == null) {
      KubernetesResourceList currentList = baseOperation.list();
      this.resourceVersion = new AtomicReference<>(currentList.getMetadata().getResourceVersion());
    } else {
      this.resourceVersion = new AtomicReference<>(version);
    }
    this.baseOperation = baseOperation;
    this.watcher = watcher;
    this.reconnectInterval = reconnectInterval;
    this.reconnectLimit = reconnectLimit;

    runWatch();
  }

  private final void runWatch() throws MalformedURLException, ExecutionException, InterruptedException {
    URL requestUrl = baseOperation.getResourceUrl();

    HttpUrl.Builder httpUrlBuilder = HttpUrl.get(requestUrl).newBuilder();

    String labelQueryParam = baseOperation.getLabelQueryParam();
    if (labelQueryParam.length() > 0) {
      httpUrlBuilder.addQueryParameter("labelSelector", labelQueryParam);
    }

    String fieldQueryString = baseOperation.getFieldQueryParam();
    if (fieldQueryString.length() > 0) {
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

    clonedClient = baseOperation.getClient().getHttpClient().clone(); // Clone to make a customized OkHttp for this request.
    clonedClient.setReadTimeout(0, TimeUnit.MILLISECONDS);

    webSocketCall = WebSocketCall.create(clonedClient, request);
    webSocketCall.enqueue(new WebSocketListener() {
      private final Logger logger = LoggerFactory.getLogger(this.getClass());

      @Override
      public void onOpen(WebSocket webSocket, Response response) {
        webSocketRef.set(webSocket);
        currentReconnectAttempt.set(0);
      }

      @Override
      public void onFailure(IOException e, Response response) {
        if (!forceClosed.get()) {
          watcher.onClose(new KubernetesClientException("Connection unexpectedly closed", e));
        }
      }

      @Override
      public void onMessage(BufferedSource bufferedSource, WebSocket.PayloadType payloadType) throws IOException {
        try {
          WatchEvent event = mapper.readValue(bufferedSource.inputStream(), WatchEvent.class);
          T obj = (T) event.getObject();
          //Dirty cast - should always be valid though
          String currentResourceVersion = resourceVersion.get();
          String newResourceVersion = ((HasMetadata) obj).getMetadata().getResourceVersion();
          if (currentResourceVersion.compareTo(newResourceVersion) < 0) {
            resourceVersion.compareAndSet(currentResourceVersion, newResourceVersion);
          }
          Watcher.Action action = Watcher.Action.valueOf(event.getType());
          watcher.eventReceived(action, obj);
          bufferedSource.close();
        } catch (IOException e) {
          logger.error("Could not deserialize watch event: {}", bufferedSource.readUtf8(), e);
        } catch (ClassCastException e) {
          logger.error("Received wrong type of object for watch", e);
        } catch (IllegalArgumentException e) {
          logger.error("Invalid event type", e);
        } finally {
          bufferedSource.close();
        }
      }

      @Override
      public void onPong(Buffer buffer) {

      }

      @Override
      public void onClose(int code, String reason) {
        if (!forceClosed.get()) {
          try {
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
        watcher.onClose(null);
      }
    });
  }

  @Override
  public void close() {
    forceClosed.set(true);
    // Trigger shutdown of the dispatcher's executor so this process can exit cleanly.
    clonedClient.getDispatcher().getExecutorService().shutdown();
    try {
      WebSocket ws = webSocketRef.get();
      if (ws != null) {
        ws.close(1000, "Closing...");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
