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

import io.vertx.core.http.HttpClient;
import io.vertx.core.http.WebSocketClientOptions;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Configuration object for VertxHttpClient instantiation.
 * 
 * <p>
 * Encapsulates all client creation parameters to eliminate constructor ambiguity
 * that existed between two constructors with similar parameter signatures.
 * This approach provides a clear and extensible way to configure VertxHttpClient instances.
 * </p>
 * 
 * <p>
 * This class is package-private and used internally by the VertxHttpClient factory methods.
 * External users should use {@link VertxHttpClientBuilder} instead of creating instances directly.
 * </p>
 * 
 * @param <F> the factory type for creating HTTP clients
 * @since 7.4.0
 */
@Builder
@Getter
class VertxHttpClientConfiguration<F extends io.fabric8.kubernetes.client.http.HttpClient.Factory> {

  @NonNull
  private final VertxHttpClientBuilder<F> clientBuilder;

  @NonNull
  private final AtomicBoolean closed;

  @NonNull
  private final HttpClient httpClient;

  private final WebSocketClientOptions webSocketOptions;

  private final boolean closeVertx;

  /**
   * Creates a configuration with default WebSocket options.
   * 
   * @param clientBuilder the builder that created the client
   * @param closed atomic boolean indicating if client is closed
   * @param httpClient the Vert.x HTTP client instance
   * @param closeVertx whether to close Vert.x instance when client closes
   * @return configuration with default WebSocket settings
   */
  static <F extends io.fabric8.kubernetes.client.http.HttpClient.Factory> VertxHttpClientConfiguration<F> withDefaultWebSocket(
      VertxHttpClientBuilder<F> clientBuilder,
      AtomicBoolean closed,
      HttpClient httpClient,
      boolean closeVertx) {
    return VertxHttpClientConfiguration.<F> builder()
        .clientBuilder(clientBuilder)
        .closed(closed)
        .httpClient(httpClient)
        .closeVertx(closeVertx)
        .build();
  }

  /**
   * Creates a configuration with custom WebSocket options.
   * 
   * @param clientBuilder the builder that created the client
   * @param closed atomic boolean indicating if client is closed
   * @param httpClient the Vert.x HTTP client instance
   * @param webSocketOptions custom WebSocket client options
   * @param closeVertx whether to close Vert.x instance when client closes
   * @return configuration with custom WebSocket settings
   */
  static <F extends io.fabric8.kubernetes.client.http.HttpClient.Factory> VertxHttpClientConfiguration<F> withCustomWebSocket(
      VertxHttpClientBuilder<F> clientBuilder,
      AtomicBoolean closed,
      HttpClient httpClient,
      WebSocketClientOptions webSocketOptions,
      boolean closeVertx) {
    return VertxHttpClientConfiguration.<F> builder()
        .clientBuilder(clientBuilder)
        .closed(closed)
        .httpClient(httpClient)
        .webSocketOptions(webSocketOptions)
        .closeVertx(closeVertx)
        .build();
  }
}