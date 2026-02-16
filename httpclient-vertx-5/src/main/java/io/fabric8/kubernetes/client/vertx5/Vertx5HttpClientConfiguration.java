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
package io.fabric8.kubernetes.client.vertx5;

import io.vertx.core.http.HttpClient;
import io.vertx.core.http.WebSocketClientOptions;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Configuration object for Vertx5HttpClient instantiation.
 * 
 * <p>
 * Encapsulates all client creation parameters to eliminate constructor ambiguity
 * that existed between two constructors with similar parameter signatures.
 * This approach provides a clear and extensible way to configure Vertx5HttpClient instances.
 * </p>
 * 
 * <p>
 * This class is package-private and used internally by the Vertx5HttpClient factory methods.
 * External users should use {@link Vertx5HttpClientBuilder} instead of creating instances directly.
 * </p>
 * 
 * @param <F> the factory type for creating HTTP clients
 * @since 7.4.0
 */
@Builder
@Getter
class Vertx5HttpClientConfiguration<F extends io.fabric8.kubernetes.client.http.HttpClient.Factory> {

  @NonNull
  private final Vertx5HttpClientBuilder<F> clientBuilder;

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
  static <F extends io.fabric8.kubernetes.client.http.HttpClient.Factory> Vertx5HttpClientConfiguration<F> withDefaultWebSocket(
      Vertx5HttpClientBuilder<F> clientBuilder,
      AtomicBoolean closed,
      HttpClient httpClient,
      boolean closeVertx) {
    return Vertx5HttpClientConfiguration.<F> builder()
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
  static <F extends io.fabric8.kubernetes.client.http.HttpClient.Factory> Vertx5HttpClientConfiguration<F> withCustomWebSocket(
      Vertx5HttpClientBuilder<F> clientBuilder,
      AtomicBoolean closed,
      HttpClient httpClient,
      WebSocketClientOptions webSocketOptions,
      boolean closeVertx) {
    return Vertx5HttpClientConfiguration.<F> builder()
        .clientBuilder(clientBuilder)
        .closed(closed)
        .httpClient(httpClient)
        .webSocketOptions(webSocketOptions)
        .closeVertx(closeVertx)
        .build();
  }
}