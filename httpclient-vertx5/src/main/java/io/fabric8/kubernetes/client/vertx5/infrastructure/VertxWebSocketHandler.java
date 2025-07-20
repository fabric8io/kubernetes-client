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
package io.fabric8.kubernetes.client.vertx5.infrastructure;

import io.fabric8.kubernetes.client.http.WebSocket;
import io.fabric8.kubernetes.client.vertx5.core.WebSocketSpec;
import io.fabric8.kubernetes.client.vertx5.functional.Result;
import io.vertx.core.http.WebSocketClient;
import io.vertx.core.http.WebSocketConnectOptions;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;

@RequiredArgsConstructor
public final class VertxWebSocketHandler {

  @NonNull
  private final WebSocketClient webSocketClient;

  public CompletableFuture<Result<io.vertx.core.http.WebSocket>> connectWebSocket(
      @NonNull final WebSocketSpec webSocketSpec,
      @NonNull final WebSocket.Listener listener) {

    final CompletableFuture<Result<io.vertx.core.http.WebSocket>> future = new CompletableFuture<>();

    try {
      final WebSocketConnectOptions options = createWebSocketOptions(webSocketSpec);

      webSocketClient.connect(options)
          .onSuccess(webSocket -> {
            configureWebSocket(webSocket, listener);
            future.complete(Result.success(webSocket));
          })
          .onFailure(throwable -> future.complete(Result.failure(throwable)));

    } catch (final Exception e) {
      future.complete(Result.failure(e));
    }

    return future;
  }

  private WebSocketConnectOptions createWebSocketOptions(@NonNull final WebSocketSpec webSocketSpec) {
    final WebSocketConnectOptions options = new WebSocketConnectOptions();

    options.setAbsoluteURI(webSocketSpec.getUri().toString());

    if (webSocketSpec.getSubprotocol() != null) {
      options.setSubProtocols(Collections.singletonList(webSocketSpec.getSubprotocol()));
    }

    if (webSocketSpec.getTimeout() != null) {
      options.setTimeout(webSocketSpec.getTimeout().toMillis());
    }

    webSocketSpec.getHeaders().forEach((name, values) -> values.forEach(value -> options.addHeader(name, value)));

    return options;
  }

  private void configureWebSocket(
      @NonNull final io.vertx.core.http.WebSocket webSocket,
      @NonNull final WebSocket.Listener listener) {

    webSocket.binaryMessageHandler(buffer -> {
      webSocket.pause();
      listener.onMessage(new VertxWebSocketAdapter(webSocket), ByteBuffer.wrap(buffer.getBytes()));
    });

    webSocket.textMessageHandler(text -> {
      webSocket.pause();
      listener.onMessage(new VertxWebSocketAdapter(webSocket), text);
    });

    webSocket.endHandler(
        v -> listener.onClose(new VertxWebSocketAdapter(webSocket), webSocket.closeStatusCode(), webSocket.closeReason()));

    webSocket.exceptionHandler(throwable -> {
      try {
        listener.onError(new VertxWebSocketAdapter(webSocket), throwable);
      } finally {
        if (!webSocket.isClosed()) {
          webSocket.close();
        }
      }
    });

    listener.onOpen(new VertxWebSocketAdapter(webSocket));
  }
}