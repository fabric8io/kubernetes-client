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
import io.vertx.core.http.WebSocketClient;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Configuration object for {@link Vertx5HttpClient} instantiation.
 *
 * <p>
 * Both transports are supplied fully built. The client never creates one itself, so a freshly built and a
 * derived client are constructed through the exact same path and there is no code path left that could fall
 * back to Vert.x's bare defaults (and, in particular, the JVM default trust store). Both are {@code @NonNull},
 * so Lombok's generated constructor rejects a caller that forgets one rather than silently degrading.
 * </p>
 *
 * <p>
 * This class is package-private and used internally by {@link Vertx5HttpClient}'s factory method.
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

  @NonNull
  private final WebSocketClient webSocketClient;

  private final boolean closeVertx;
}
