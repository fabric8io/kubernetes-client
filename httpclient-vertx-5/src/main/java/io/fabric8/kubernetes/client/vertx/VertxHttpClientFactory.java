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

import io.fabric8.kubernetes.client.http.HttpClient;
import io.vertx.core.Vertx;

/**
 * Vert.x implementation of {@link io.fabric8.kubernetes.client.http.HttpClient.Factory}.
 *
 * <p>
 * When constructed with a non‑null {@link Vertx} the same instance is reused for every
 * client; otherwise each {@link #newBuilder()} call will lazily create (and own) its own
 * Vert.x runtime.
 * </p>
 */
public class VertxHttpClientFactory implements HttpClient.Factory {

  final Vertx vertx;

  /**
   * Return a factory that reuses the supplied Vert.x instance.
   */
  public VertxHttpClientFactory() {
    this(null);
  }

  /**
   * Create a new instance of the factory that will reuse the provided {@link Vertx} instance.
   * <p>
   * It's the user's responsibility to manage the lifecycle of the provided Vert.x instance.
   * Operations such as close, and so on are left on hands of the user.
   *
   * @param vertx the Vertx instance to use.
   */
  public VertxHttpClientFactory(final Vertx vertx) {
    this.vertx = vertx;
  }

  /**
   * {@inheritDoc} – reuses the shared Vert.x when present, otherwise defers creation to the
   * builder.
   */
  @Override
  public VertxHttpClientBuilder<VertxHttpClientFactory> newBuilder() {
    return new VertxHttpClientBuilder<>(this, vertx);
  }
}
