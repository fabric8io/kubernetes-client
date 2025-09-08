/*
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
import io.vertx.core.http.WebSocketClient;
import io.vertx.core.http.WebSocketClientOptions;
import io.vertx.core.http.WebSocketConnectOptions;
import lombok.Getter;

import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicBoolean;

import static io.fabric8.kubernetes.client.vertx.VertxHttpRequest.toHeadersMap;

public class VertxHttpClient<F extends io.fabric8.kubernetes.client.http.HttpClient.Factory>
    extends StandardHttpClient<VertxHttpClient<F>, F, VertxHttpClientBuilder<F>> {

  private final Vertx vertx;
  @Getter
  private final HttpClient httpClient;
  private final WebSocketClient webSocketClient;
  private final boolean closeVertx;

  /**
   * Create a new VertxHttpClient instance using configuration object.
   * This eliminates constructor ambiguity and provides clear instantiation path.
   *
   * @param config configuration containing all required parameters
   */
  VertxHttpClient(final VertxHttpClientConfiguration<F> config) {
    super(config.getClientBuilder(), config.getClosed());
    this.vertx = config.getClientBuilder().vertx;
    this.httpClient = config.getHttpClient();
    this.webSocketClient = createWebSocketClient(config);
    this.closeVertx = config.isCloseVertx();
  }

  /**
   * Creates WebSocket client based on configuration.
   * Uses custom options if provided, otherwise creates with defaults.
   */
  private WebSocketClient createWebSocketClient(final VertxHttpClientConfiguration<F> config) {
    final WebSocketClientOptions options = config.getWebSocketOptions();
    return options != null
        ? vertx.createWebSocketClient(options)
        : vertx.createWebSocketClient();
  }

  /**
   * Creates VertxHttpClient with default WebSocket configuration.
   * For internal use by VertxHttpClientBuilder.
   */
  static <F extends io.fabric8.kubernetes.client.http.HttpClient.Factory> VertxHttpClient<F> createWithDefaults(
      final VertxHttpClientBuilder<F> builder,
      final AtomicBoolean closed,
      final HttpClient httpClient,
      final boolean closeVertx) {

    final VertxHttpClientConfiguration<F> config = VertxHttpClientConfiguration.withDefaultWebSocket(builder, closed,
        httpClient, closeVertx);
    return new VertxHttpClient<>(config);
  }

  /**
   * Creates VertxHttpClient with custom WebSocket configuration.
   * For internal use by VertxHttpClientBuilder.
   */
  static <F extends io.fabric8.kubernetes.client.http.HttpClient.Factory> VertxHttpClient<F> createWithWebSocketOptions(
      final VertxHttpClientBuilder<F> builder,
      final AtomicBoolean closed,
      final HttpClient httpClient,
      final WebSocketClientOptions wsOptions,
      final boolean closeVertx) {

    final VertxHttpClientConfiguration<F> config = VertxHttpClientConfiguration.withCustomWebSocket(
        builder, closed, httpClient, wsOptions, closeVertx);
    return new VertxHttpClient<>(config);
  }

  @Override
  public CompletableFuture<WebSocketResponse> buildWebSocketDirect(final StandardWebSocketBuilder standardWebSocketBuilder,
      WebSocket.Listener listener) {
    WebSocketConnectOptions options = new WebSocketConnectOptions();

    if (standardWebSocketBuilder.getSubprotocol() != null) {
      options.setSubProtocols(Collections.singletonList(standardWebSocketBuilder.getSubprotocol()));
    }

    final StandardHttpRequest request = standardWebSocketBuilder.asHttpRequest();

    if (request.getTimeout() != null) {
      options.setTimeout(request.getTimeout().toMillis());
    }

    request.headers().forEach((key, value) -> value.forEach(v -> options.addHeader(key, v)));
    options.setAbsoluteURI(WebSocket.toWebSocketUri(request.uri()).toString());

    final CompletableFuture<WebSocketResponse> response = new CompletableFuture<>();

    webSocketClient
        .connect(options)
        .onSuccess(ws -> {
          final VertxWebSocket ret = new VertxWebSocket(ws, listener);
          ret.initHandlers();
          response.complete(new WebSocketResponse(new WebSocketUpgradeResponse(request), ret));
        }).onFailure(t -> {
          if (t instanceof UpgradeRejectedException) {
            final UpgradeRejectedException handshake = (UpgradeRejectedException) t;
            final WebSocketUpgradeResponse upgradeResponse = new WebSocketUpgradeResponse(
                request, handshake.getStatus(), toHeadersMap(handshake.getHeaders()));
            response.complete(new WebSocketResponse(upgradeResponse, handshake));
          }
          response.completeExceptionally(t);
        });
    return response;
  }

  @Override
  public CompletableFuture<HttpResponse<AsyncBody>> consumeBytesDirect(final StandardHttpRequest request,
      final AsyncBody.Consumer<List<ByteBuffer>> consumer) {

    final var options = new RequestOptions();

    request.headers().forEach((k, l) -> l.forEach(v -> options.addHeader(k, v)));
    options.setAbsoluteURI(request.uri().toString());
    options.setMethod(HttpMethod.valueOf(request.method()));

    if (request.getTimeout() != null) {
      options.setTimeout(request.getTimeout().toMillis());
    }

    Optional.ofNullable(request.getContentType())
        .ifPresent(s -> options.putHeader(HttpHeaders.CONTENT_TYPE, s));

    if (request.isExpectContinue()) {
      options.putHeader(HttpHeaders.EXPECT, HttpHeaders.CONTINUE);
    }

    return new VertxHttpRequest(vertx, options, request).consumeBytes(this.httpClient, consumer);
  }

  @Override
  public void doClose() {
    try {
      httpClient.close();
    } finally {
      if (closeVertx) {
        vertx.close();
      }
    }
  }

}
