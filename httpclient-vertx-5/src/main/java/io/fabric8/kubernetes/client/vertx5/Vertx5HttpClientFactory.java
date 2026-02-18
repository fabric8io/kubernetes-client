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

import io.fabric8.kubernetes.client.http.HttpClient;
import io.vertx.core.Vertx;
import io.vertx.core.http.PoolOptions;
import io.vertx.core.http.WebSocketClientOptions;
import io.vertx.ext.web.client.WebClientOptions;

/**
 * Vert.x 5 implementation of {@link io.fabric8.kubernetes.client.http.HttpClient.Factory}.
 *
 * <p>
 * When constructed with a non‑null {@link Vertx} the same instance is reused for every
 * client; otherwise each {@link #newBuilder()} call will lazily create (and own) its own
 * Vert.x runtime.
 * </p>
 *
 * <p>
 * <strong>Important:</strong> This HTTP client requires Vert.x 5.x runtime classes.
 * It is mutually exclusive with {@code kubernetes-httpclient-vertx} (Vert.x 4.x).
 * Including both on the classpath will cause runtime errors due to incompatible
 * Vert.x API versions. Ensure your project excludes one or the other.
 * </p>
 */
public class Vertx5HttpClientFactory implements HttpClient.Factory {

  private static final String VERTX5_MARKER_CLASS = "io.vertx.core.impl.SysProps";

  final Vertx vertx;

  /**
   * Return a factory that reuses the supplied Vert.x instance.
   */
  public Vertx5HttpClientFactory() {
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
  public Vertx5HttpClientFactory(final Vertx vertx) {
    this.vertx = vertx;
  }

  /**
   * {@inheritDoc} – reuses the shared Vert.x when present, otherwise defers creation to the
   * builder.
   *
   * @throws IllegalStateException if Vert.x 5 runtime classes are not available on the classpath
   */
  @Override
  public Vertx5HttpClientBuilder<Vertx5HttpClientFactory> newBuilder() {
    validateVertx5Runtime();
    return new Vertx5HttpClientBuilder<>(this, vertx);
  }

  /**
   * Validates that Vert.x 5 runtime classes are available on the classpath.
   *
   * <p>
   * This check prevents cryptic {@link NoClassDefFoundError} when both
   * {@code kubernetes-httpclient-vertx} (Vert.x 4) and {@code kubernetes-httpclient-vertx-5}
   * are on the classpath, but Maven dependency resolution picks Vert.x 4 JARs.
   * </p>
   *
   * @throws IllegalStateException if Vert.x 5 runtime is not available
   */
  private static void validateVertx5Runtime() {
    try {
      Class.forName(VERTX5_MARKER_CLASS);
    } catch (ClassNotFoundException e) {
      throw new IllegalStateException(
          "Vert.x 5 runtime classes not found. The kubernetes-httpclient-vertx-5 module requires "
              + "Vert.x 5.x on the classpath. This error typically occurs when both kubernetes-httpclient-vertx "
              + "(Vert.x 4) and kubernetes-httpclient-vertx-5 (Vert.x 5) are present, causing Maven to resolve "
              + "Vert.x 4 JARs. These modules are mutually exclusive - please exclude one from your dependencies "
              + "and ensure vertx.version property is set appropriately (5.x for vertx-5, 4.x for vertx).",
          e);
    }
  }

  protected void additionalConfig(WebSocketClientOptions wsOptions, WebClientOptions webClientOptions,
      PoolOptions poolOptions) {
    // no default implementation
  }
}
