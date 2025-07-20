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
package io.fabric8.kubernetes.client.vertx5.adapters;

import io.fabric8.kubernetes.client.http.AsyncBody;
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.http.HttpResponse;
import io.fabric8.kubernetes.client.http.StandardHttpClient;
import io.fabric8.kubernetes.client.http.StandardHttpRequest;
import io.fabric8.kubernetes.client.http.StandardWebSocketBuilder;
import io.fabric8.kubernetes.client.http.WebSocket;
import io.fabric8.kubernetes.client.http.WebSocketResponse;
import io.fabric8.kubernetes.client.http.WebSocketUpgradeResponse;
import io.fabric8.kubernetes.client.vertx5.core.WebSocketSpec;
import io.fabric8.kubernetes.client.vertx5.infrastructure.VertxWebSocketAdapter;
import io.fabric8.kubernetes.client.vertx5.infrastructure.VertxWebSocketHandler;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.WebSocketClient;
import lombok.NonNull;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicBoolean;

public final class Vertx5HttpClient<F extends io.fabric8.kubernetes.client.http.HttpClient.Factory>
    extends StandardHttpClient<Vertx5HttpClient<F>, F, Vertx5HttpClientBuilder<F>> {

  private final Vertx vertx;
  private final HttpClient httpClient;
  private final WebSocketClient webSocketClient;
  private final boolean closeVertx;

  Vertx5HttpClient(@NonNull final Vertx5HttpClientBuilder<F> builder, @NonNull final AtomicBoolean closed,
      @NonNull final HttpClient httpClient, @NonNull final WebSocketClient webSocketClient,
      final boolean closeVertx) {
    super(builder, closed);
    this.vertx = builder.vertx;
    this.httpClient = httpClient;
    this.webSocketClient = webSocketClient;
    this.closeVertx = closeVertx;
  }

  @Override
  public CompletableFuture<HttpResponse<AsyncBody>> consumeBytes(HttpRequest request,
      AsyncBody.Consumer<List<ByteBuffer>> consumer) {
    return consumeBytesDirect((StandardHttpRequest) request, consumer);
  }

  @Override
  public CompletableFuture<HttpResponse<AsyncBody>> consumeBytesDirect(StandardHttpRequest request,
      AsyncBody.Consumer<List<ByteBuffer>> consumer) {
    final io.vertx.core.http.RequestOptions options = new io.vertx.core.http.RequestOptions();

    // Set headers
    request.headers().forEach((k, l) -> l.forEach(v -> options.addHeader(k, v)));

    // Set URI and method
    options.setAbsoluteURI(request.uri().toString());
    options.setMethod(io.vertx.core.http.HttpMethod.valueOf(request.method()));

    // Set timeout if present
    if (request.getTimeout() != null) {
      options.setTimeout(request.getTimeout().toMillis());
    }

    // Set content type if present
    Optional.ofNullable(request.getContentType())
        .ifPresent(s -> options.addHeader(io.vertx.core.http.HttpHeaders.CONTENT_TYPE, s));

    // Handle Expect: 100-continue header
    if (request.isExpectContinue()) {
      options.addHeader(io.vertx.core.http.HttpHeaders.EXPECT, io.vertx.core.http.HttpHeaders.CONTINUE);
    }

    return new Vertx5HttpRequest(vertx, options, request).consumeBytes(httpClient, consumer);
  }

  @Override
  public CompletableFuture<WebSocketResponse> buildWebSocketDirect(StandardWebSocketBuilder standardWebSocketBuilder,
      WebSocket.Listener listener) {

    final StandardHttpRequest request = standardWebSocketBuilder.asHttpRequest();

    final WebSocketSpec.WebSocketSpecBuilder specBuilder = WebSocketSpec.builder()
        .uri(WebSocket.toWebSocketUri(request.uri()));

    if (standardWebSocketBuilder.getSubprotocol() != null) {
      specBuilder.subprotocol(standardWebSocketBuilder.getSubprotocol());
    }

    if (request.getTimeout() != null) {
      specBuilder.timeout(request.getTimeout());
    }

    specBuilder.headers(request.headers());

    final WebSocketSpec webSocketSpec = specBuilder.build();
    final VertxWebSocketHandler handler = new VertxWebSocketHandler(webSocketClient);

    final CompletableFuture<WebSocketResponse> response = new CompletableFuture<>();

    handler.connectWebSocket(webSocketSpec, listener)
        .whenComplete((result, throwable) -> {
          if (throwable != null) {
            response.completeExceptionally(throwable);
            return;
          }

          result.fold(
              vertxWebSocket -> {
                final VertxWebSocketAdapter webSocket = new VertxWebSocketAdapter(vertxWebSocket);
                final WebSocketUpgradeResponse upgradeResponse = new WebSocketUpgradeResponse(request);
                response.complete(new WebSocketResponse(upgradeResponse, webSocket));
                return null;
              },
              error -> {
                response.completeExceptionally(error);
                return null;
              });
        });

    return response;
  }

  @Override
  protected void doClose() {
    try {
      if (httpClient != null) {
        httpClient.close();
      }
      if (webSocketClient != null) {
        webSocketClient.close();
      }
    } catch (final Exception e) {
      // Log error but don't throw
    }

    if (closeVertx && vertx != null) {
      try {
        vertx.close();
      } catch (final Exception e) {
        // Log error but don't throw
      }
    }
  }

  HttpClient getHttpClient() {
    return httpClient;
  }

  WebSocketClient getWebSocketClient() {
    return webSocketClient;
  }
}