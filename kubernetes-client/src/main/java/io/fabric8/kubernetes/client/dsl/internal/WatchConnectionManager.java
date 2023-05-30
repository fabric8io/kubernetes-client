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

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * Manages a WebSocket and listener per request
 */
public class WatchConnectionManager<T extends HasMetadata, L extends KubernetesResourceList<T>>
    extends AbstractWatchManager<T> {

  private final long connectTimeoutMillis;
  protected WatcherWebSocketListener<T> listener;
  private volatile CompletableFuture<WebSocket> websocketFuture;

  volatile boolean ready;

  public WatchConnectionManager(final HttpClient client, final BaseOperation<T, L, ?> baseOperation,
      final ListOptions listOptions, final Watcher<T> watcher, final int reconnectInterval, final int reconnectLimit,
      long websocketTimeout) throws MalformedURLException {
    super(watcher, baseOperation, listOptions, reconnectLimit, reconnectInterval, client);
    this.connectTimeoutMillis = websocketTimeout;
  }

  @Override
  protected void closeCurrentRequest() {
    Optional.ofNullable(this.websocketFuture).ifPresent(
        theFuture -> theFuture.whenComplete(
            (w, t) -> Optional.ofNullable(w).ifPresent(ws -> ws.sendClose(1000, null))));
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
        try {
          if (t instanceof WebSocketHandshakeException) {
            WebSocketHandshakeException wshe = (WebSocketHandshakeException) t;
            HttpResponse<?> response = wshe.getResponse();
            final int code = response.code();
            // We do not expect a 200 in response to the websocket connection. If it occurs, we throw
            // an exception and try the watch via a persistent HTTP Get.
            // Newer Kubernetes might also return 503 Service Unavailable in case WebSockets are not supported
            Status status = OperationSupport.createStatus(response, this.baseOperation.getKubernetesSerialization());
            t = OperationSupport.requestFailure(client.newHttpRequestBuilder().url(url).build(),
                status, "Received " + code + " on websocket");
          }
          throw KubernetesClientException.launderThrowable(t);
        } finally {
          if (ready) {
            // if we're ready, then invoke the reconnect logic
            watchEnded(t, state);
          }
        }
      }
      this.ready = true;
      return w;
    });
  }

}
