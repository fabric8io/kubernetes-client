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
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.ws.DefaultWebSocketListener;
import com.ning.http.client.ws.WebSocket;
import com.ning.http.client.ws.WebSocketUpgradeHandler;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.WatchEvent;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
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
  private WebSocket webSocket;

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

    AsyncHttpClient.BoundRequestBuilder requestBuilder = baseOperation.getClient().getHttpClient().prepareGet(requestUrl.toString().replaceFirst("^http", "ws"));

    String labelQueryParam = baseOperation.getLabelQueryParam();
    if (labelQueryParam.length() > 0) {
      requestBuilder.addQueryParam("labelSelector", labelQueryParam);
    }

    String fieldQueryString = baseOperation.getFieldQueryParam();
    if (fieldQueryString.length() > 0) {
      requestBuilder.addQueryParam("fieldSelector", fieldQueryString);
    }

    requestBuilder.addQueryParam("resourceVersion", this.resourceVersion.get());
    requestBuilder.addQueryParam("watch", "true");
    WebSocketUpgradeHandler.Builder wsUpgradeBuilder = new WebSocketUpgradeHandler.Builder()
      .addWebSocketListener(
        new DefaultWebSocketListener() {

          private final Logger logger = LoggerFactory.getLogger(this.getClass());

          @Override
          public void onMessage(String message) {
            try {
              WatchEvent event = mapper.readerFor(WatchEvent.class).readValue(message);
              T obj = (T) event.getObject();
              //Dirty cast - should always be valid though
              String currentResourceVersion = resourceVersion.get();
              String newResourceVersion = ((HasMetadata) obj).getMetadata().getResourceVersion();
              if (currentResourceVersion.compareTo(newResourceVersion) < 0) {
                resourceVersion.compareAndSet(currentResourceVersion, newResourceVersion);
              }
              Watcher.Action action = Watcher.Action.valueOf(event.getType());
              watcher.eventReceived(action, obj);
            } catch (IOException e) {
              logger.error("Could not deserialize watch event: {}", message, e);
            } catch (ClassCastException e) {
              logger.error("Received wrong type of object for watch", e);
            } catch (IllegalArgumentException e) {
              logger.error("Invalid event type", e);
            }
          }

          @Override
          public void onOpen(WebSocket websocket) {
            currentReconnectAttempt.set(0);
            this.webSocket = websocket;
            super.onOpen(websocket);
          }

          @Override
          public void onClose(WebSocket websocket) {
            if (!forceClosed.get()) {
              try {
                runWatch();
              } catch (ExecutionException e) {
                if (e.getCause() != null && e.getCause().getCause() != null && e.getCause().getCause() instanceof ConnectException) {
                  if (reconnectLimit >= 0 && currentReconnectAttempt.getAndIncrement() >= reconnectLimit) {
                    watcher.onClose(new KubernetesClientException("Connection closed.", e));
                    return;
                  }
                  try {
                    TimeUnit.MILLISECONDS.sleep(reconnectInterval);
                  } catch (InterruptedException e1) {
                    watcher.onClose(new KubernetesClientException("Connection closed.", e1));
                    return;
                  }
                  onClose(websocket);
                }
              } catch (MalformedURLException | InterruptedException e) {
                throw KubernetesClientException.launderThrowable(e);
              }
            }
            watcher.onClose(null);
            super.onClose(websocket);
          }
        });

    Future<WebSocket> f = requestBuilder.execute(wsUpgradeBuilder.build());

    this.webSocket = f.get();
  }

  @Override
  public boolean isOpen() {
    return webSocket.isOpen();
  }

  @Override
  public void close() {
    forceClosed.set(true);
    webSocket.close();
  }

}
