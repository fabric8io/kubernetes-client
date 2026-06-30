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

import io.fabric8.kubernetes.client.Config;
import io.vertx.core.Vertx;
import io.vertx.ext.web.client.WebClientOptions;

public class VertxHttpClientFactory implements io.fabric8.kubernetes.client.http.HttpClient.Factory {

  final Vertx sharedVertx;
  private volatile TlsWarmup tlsWarmup = TlsWarmup.CONTEXT;

  @Override
  public int priority() {
    return -1;
  }

  public VertxHttpClientFactory() {
    this(null);
  }

  /**
   * Create a new instance of the factory that will reuse the provided {@link Vertx} instance.
   * <p>
   * It's the user's responsibility to manage the lifecycle of the provided Vert.x instance.
   * Operations such as close, and so on are left on hands of the user.
   *
   * @param sharedVertx the Vertx instance to use.
   */
  public VertxHttpClientFactory(Vertx sharedVertx) {
    this.sharedVertx = sharedVertx;
  }

  @Override
  public VertxHttpClientBuilder<VertxHttpClientFactory> newBuilder() {
    return new VertxHttpClientBuilder<>(this, sharedVertx);
  }

  /**
   * Additional configuration to be applied to the options after the {@link Config} has been processed.
   */
  protected void additionalConfig(WebClientOptions options) {
    // no default implementation
  }

  /**
   * Returns the configured {@link TlsWarmup} mode (never {@code null}).
   *
   * @return the TLS warm-up mode applied when building TLS-enabled clients
   */
  public TlsWarmup getTlsWarmup() {
    return tlsWarmup;
  }

  /**
   * Configures how the TLS stack is warmed up off the Vert.x event loop when a TLS-enabled client
   * is built. See {@link TlsWarmup} for the trade-offs of each mode.
   *
   * @param tlsWarmup the warm-up mode; {@code null} resets it to the default {@link TlsWarmup#CONTEXT}
   */
  public void setTlsWarmup(TlsWarmup tlsWarmup) {
    this.tlsWarmup = tlsWarmup == null ? TlsWarmup.CONTEXT : tlsWarmup;
  }
}
