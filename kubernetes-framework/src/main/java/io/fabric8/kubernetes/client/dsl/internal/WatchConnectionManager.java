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
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.HttpResponse;
import io.fabric8.kubernetes.client.http.WebSocket;
import io.fabric8.kubernetes.client.http.WebSocket.Builder;
import io.fabric8.kubernetes.client.http.WebSocketHandshakeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static java.net.HttpURLConnection.HTTP_OK;
import static java.net.HttpURLConnection.HTTP_UNAVAILABLE;

/**
 * Manages a WebSocket and listener per request
 */
public class WatchConnectionManager<T extends HasMetadata, L extends KubernetesResourceList<T>>
    extends AbstractWatchManager<T> {

  private static final Logger logger = LoggerFactory.getLogger(WatchConnectionManager.class);

  private final long connectTimeoutMillis;
  protected WatcherWebSocketListener<T> listener;
  private volatile CompletableFuture<WebSocket> websocketFuture;

  private volatile boolean ready;

  static void closeWebSocket(WebSocket webSocket) {
    if (webSocket != null) {
      logger.debug("Closing websocket {}", webSocket);
      try {
        if (!webSocket.sendClose(1000, null)) {
          logger.debug("Websocket already closed {}", webSocket);
        }
      } catch (IllegalStateException e) {
        logger.error("invalid code for websocket: {} {}", e.getClass(), e.getMessage());
      }
    }
  }

  public WatchConnectionManager(final HttpClient client, final BaseOperation<T, L, ?> baseOperation,
      final ListOptions listOptions, final Watcher<T> watcher, final int reconnectInterval, final int reconnectLimit,
      long websocketTimeout) throws MalformedURLException {
    super(watcher, baseOperation, listOptions, reconnectLimit, reconnectInterval, client);
    this.connectTimeoutMillis = websocketTimeout;
  }

  @Override
  protected void closeCurrentRequest() {
    Optional.ofNullable(this.websocketFuture).ifPresent(theFuture -> {
      this.websocketFuture = null;
      theFuture.whenComplete((w, t) -> {
        if (w != null) {
          closeWebSocket(w);
        }
      });
    });
  }

  public CompletableFuture<WebSocket> getWebsocketFuture() {
    return websocketFuture;
  }

  @Override
  protected void start(URL url, Map<String, String> headers, WatchRequestState state) {
    this.listener = new WatcherWebSocketListener<>(this, state);
    Builder builder = client.newWebSocketBuilder();
    headers.forEach(builder::header);
    builder.uri(URI.create(url.toString())).connectTimeout(connectTimeoutMillis, TimeUnit.MILLISECONDS);

    this.websocketFuture = builder.buildAsync(this.listener).handle((w, t) -> {
      if (t != null) {
        if (t instanceof WebSocketHandshakeException) {
          WebSocketHandshakeException wshe = (WebSocketHandshakeException) t;
          HttpResponse<?> response = wshe.getResponse();
          final int code = response.code();
          // We do not expect a 200 in response to the websocket connection. If it occurs, we throw
          // an exception and try the watch via a persistent HTTP Get.
          // Newer Kubernetes might also return 503 Service Unavailable in case WebSockets are not supported
          Status status = OperationSupport.createStatus(response);
          if (HTTP_OK == code || HTTP_UNAVAILABLE == code) {
            throw OperationSupport.requestFailure(client.newHttpRequestBuilder().url(url).build(), status,
                "Received " + code + " on websocket");
          }
          logger.warn("Exec Failure: HTTP {}, Status: {} - {}", code, status.getCode(), status.getMessage());
          t = OperationSupport.requestFailure(client.newHttpRequestBuilder().url(url).build(), status);
        }
        if (ready) {
          // if we're not ready yet, that means we're waiting on the future and there's
          // no need to invoke the reconnect logic
          listener.onError(w, t, true);
        }
        throw KubernetesClientException.launderThrowable(t);
      }
      if (w != null) {
        this.ready = true;
      }
      return w;
    });
  }

}
