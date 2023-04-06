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
package io.fabric8.kubernetes.client.vertx;

import io.fabric8.kubernetes.client.http.AsyncBody;
import io.fabric8.kubernetes.client.http.HttpResponse;
import io.fabric8.kubernetes.client.http.StandardHttpClient;
import io.fabric8.kubernetes.client.http.StandardHttpRequest;
import io.fabric8.kubernetes.client.http.StandardWebSocketBuilder;
import io.fabric8.kubernetes.client.http.WebSocket;
import io.fabric8.kubernetes.client.http.WebSocketResponse;
import io.fabric8.kubernetes.client.http.WebSocketUpgradeResponse;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpHeaders;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.RequestOptions;
import io.vertx.core.http.UpgradeRejectedException;
import io.vertx.core.http.WebSocketConnectOptions;
import io.vertx.ext.web.client.WebClientOptions;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import static io.fabric8.kubernetes.client.vertx.VertxHttpRequest.toHeadersMap;

public class VertxHttpClient<F extends io.fabric8.kubernetes.client.http.HttpClient.Factory>
    extends StandardHttpClient<VertxHttpClient<F>, F, VertxHttpClientBuilder<F>> {

  private final List<VertxHttpClient<F>> derivedClients;
  private final Vertx vertx;
  private final HttpClient client;
  private final String proxyAuthorization;

  VertxHttpClient(VertxHttpClientBuilder<F> vertxHttpClientBuilder, WebClientOptions options,
      String proxyAuthorization) {
    super(vertxHttpClientBuilder);
    derivedClients = Collections.synchronizedList(new ArrayList<>());
    this.vertx = vertxHttpClientBuilder.vertx;
    this.client = vertx.createHttpClient(options);
    this.proxyAuthorization = proxyAuthorization;
  }

  @Override
  public CompletableFuture<WebSocketResponse> buildWebSocketDirect(StandardWebSocketBuilder standardWebSocketBuilder,
      WebSocket.Listener listener) {
    WebSocketConnectOptions options = new WebSocketConnectOptions();

    if (builder.getReadTimeout() != null) {
      options.setTimeout(builder.getReadTimeout().toMillis());
    }

    if (standardWebSocketBuilder.getSubprotocol() != null) {
      options.setSubProtocols(Collections.singletonList(standardWebSocketBuilder.getSubprotocol()));
    }

    final StandardHttpRequest request = standardWebSocketBuilder.asHttpRequest();

    request.headers().entrySet().stream()
        .forEach(e -> e.getValue().stream().forEach(v -> options.addHeader(e.getKey(), v)));
    options.setAbsoluteURI(request.uri().toString());

    CompletableFuture<WebSocketResponse> response = new CompletableFuture<>();

    client
        .webSocket(options)
        .onSuccess(ws -> {
          VertxWebSocket ret = new VertxWebSocket(ws, listener);
          ret.init();
          response.complete(new WebSocketResponse(new WebSocketUpgradeResponse(request, ret), null));
        }).onFailure(t -> {
          if (t instanceof UpgradeRejectedException) {
            UpgradeRejectedException handshake = (UpgradeRejectedException) t;
            final WebSocketUpgradeResponse upgradeResponse = new WebSocketUpgradeResponse(
                request, handshake.getStatus(), toHeadersMap(handshake.getHeaders()), null);
            response.complete(new WebSocketResponse(upgradeResponse,
                new io.fabric8.kubernetes.client.http.WebSocketHandshakeException(upgradeResponse)));
          }
          response.completeExceptionally(t);
        });
    return response;
  }

  @Override
  public CompletableFuture<HttpResponse<AsyncBody>> consumeBytesDirect(StandardHttpRequest request,
      AsyncBody.Consumer<List<ByteBuffer>> consumer) {

    RequestOptions options = new RequestOptions();

    request.headers().forEach((k, l) -> l.forEach(v -> options.addHeader(k, v)));
    options.setAbsoluteURI(request.uri().toString());
    options.setMethod(HttpMethod.valueOf(request.method()));

    // Proxy authorization is handled manually since the proxyAuthorization value is the actual header
    if (proxyAuthorization != null) {
      options.putHeader(HttpHeaders.PROXY_AUTHORIZATION, proxyAuthorization);
    }

    Optional.ofNullable(request.getContentType())
        .ifPresent(s -> options.putHeader(io.vertx.core.http.HttpHeaders.CONTENT_TYPE, s));

    if (request.isExpectContinue()) {
      // TODO: determine if this is enforced by the client
      // seems like a continue handler is needed
      options.putHeader(io.vertx.core.http.HttpHeaders.EXPECT, io.vertx.core.http.HttpHeaders.CONTINUE);
    }

    return new VertxHttpRequest(vertx, options, request).consumeBytes(this.client, consumer);
  }

  void addDerivedClient(VertxHttpClient<F> client) {
    derivedClients.add(client);
  }

  @Override
  public void close() {
    client.close();
    synchronized (derivedClients) {
      derivedClients.forEach(VertxHttpClient::close);
      derivedClients.clear();
    }
  }

}
