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

/**
 * Controls how aggressively the Vert.x HTTP client warms up the JDK/Netty TLS stack off the
 * Vert.x event loop when a client is built.
 *
 * <p>
 * Vert.x materialises the Netty {@code SslContext}, the {@code SslHandler} and the {@code SSLEngine}
 * lazily on the event loop on the first TLS connection, which on a cold or CPU-throttled JVM pays
 * the one-time class loading of the entire TLS stack on the loop and can trip the
 * {@code BlockedThreadChecker} (or, under hard throttling, the connect timeout). Warming the stack
 * once per JVM off the event loop relocates that cost. See
 * <a href="https://github.com/fabric8io/kubernetes-client/issues/7926">fabric8io/kubernetes-client#7926</a>.
 *
 * <p>
 * The mode is configured programmatically on the Vert.x HTTP client factory, for example:
 *
 * <pre>{@code
 * Vertx5HttpClientFactory factory = new Vertx5HttpClientFactory();
 * factory.setTlsWarmup(TlsWarmup.FULL);
 * KubernetesClient client = new KubernetesClientBuilder().withHttpClientFactory(factory).build();
 * }</pre>
 */
public enum TlsWarmup {

  /**
   * No warm-up. The TLS stack is materialised lazily by Vert.x on the event loop on the first
   * connection (the behaviour before #7922).
   */
  OFF,

  /**
   * Build and discard a Netty {@code SslContext} on the building thread (the default). This loads
   * the SSL engine and cipher catalogue off the event loop but not the {@code SslHandler}/handshake
   * classes. This is the behaviour introduced in #7922 and is sufficient for most environments.
   */
  CONTEXT,

  /**
   * Run a complete throwaway loopback TLS handshake on the building thread, once per JVM. A tiny
   * self-signed HTTPS server is stood up on {@code 127.0.0.1}, one client handshake is driven
   * against it and both are torn down. This warms the full Netty + JDK TLS class path and the
   * Vert.x connect path, so the first real connection no longer blocks the event loop. It runs
   * synchronously, adding the warm-up cost to client construction (sub-second on a healthy host, a
   * few seconds under hard CPU throttling), which is the explicit trade opt-in users make to avoid
   * a first-connection timeout. The bind and handshake are bounded by a single overall deadline
   * (about 30 seconds), after which the warm-up gives up and falls back rather than blocking for
   * long; because it blocks the building thread, do not build a {@code FULL}-configured client from
   * a Vert.x event-loop thread. Best-effort: if the warm-up cannot run (for example a blocked
   * loopback bind), the client falls back to {@link #CONTEXT}.
   */
  FULL
}
