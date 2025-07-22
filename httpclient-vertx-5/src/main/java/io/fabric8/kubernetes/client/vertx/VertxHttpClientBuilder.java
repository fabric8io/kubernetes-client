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

import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.StandardHttpClientBuilder;
import io.fabric8.kubernetes.client.http.TlsVersion;
import io.netty.handler.ssl.ApplicationProtocolConfig;
import io.netty.handler.ssl.IdentityCipherSuiteFilter;
import io.netty.handler.ssl.JdkSslContext;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.file.FileSystemOptions;
import io.vertx.core.http.HttpVersion;
import io.vertx.core.http.PoolOptions;
import io.vertx.core.http.WebSocketClientOptions;
import io.vertx.core.net.JdkSSLEngineOptions;
import io.vertx.core.net.ProxyOptions;
import io.vertx.core.net.ProxyType;
import io.vertx.core.spi.tls.SslContextFactory;
import io.vertx.ext.web.client.WebClientOptions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Stream;

import static io.fabric8.kubernetes.client.utils.HttpClientUtils.decodeBasicCredentials;
import static io.vertx.core.impl.SysProps.DISABLE_DNS_RESOLVER;

/**
 * Builder for creating Vert.x-based HTTP clients used in Kubernetes API communication.
 * 
 * <p>
 * Extends {@link StandardHttpClientBuilder} to provide Vert.x-specific configuration
 * including connection pooling, SSL/TLS options, proxy settings, and WebSocket support.
 * 
 * @param <F> the factory type for creating HTTP clients
 */
public class VertxHttpClientBuilder<F extends HttpClient.Factory>
    extends StandardHttpClientBuilder<VertxHttpClient<F>, F, VertxHttpClientBuilder<F>> {

  private static final int MAX_CONNECTIONS = 8192;

  // the default for etcd seems to be 3 MB, but we'll default to unlimited, so we have the same behavior across clients
  private static final int MAX_WS_MESSAGE_SIZE = Integer.MAX_VALUE;

  final Vertx vertx;
  private final boolean closeVertx;

  /**
   * Creates a builder with optional shared Vert.x instance.
   * If no shared instance is provided, creates a new one.
   *
   * @param clientFactory factory for creating HTTP clients
   * @param sharedVertx optional shared Vert.x instance
   */
  public VertxHttpClientBuilder(final F clientFactory, final Vertx sharedVertx) {
    this(
        clientFactory,
        sharedVertx != null ? sharedVertx : createVertxInstance(),
        sharedVertx == null);
  }

  /**
   * Creates a builder with explicit Vert.x instance and lifecycle management flag.
   *
   * @param clientFactory factory for creating HTTP clients
   * @param vertx Vert.x instance to use
   * @param closeVertx whether this builder should close the Vert.x instance
   */
  VertxHttpClientBuilder(final F clientFactory, final Vertx vertx, final boolean closeVertx) {
    super(clientFactory);
    this.vertx = vertx;
    this.closeVertx = closeVertx;
  }

  /* ------------------------------------------------------------------------- */
  /** Assemble connection pool options. */
  private static PoolOptions createPoolOptions() {
    return new PoolOptions()
        .setHttp1MaxSize(MAX_CONNECTIONS)
        .setHttp2MaxSize(MAX_CONNECTIONS);
  }

  /** Apply time‑outs, redirects, HTTP/1 preference. */
  private void applyBasicHttpSettings(final WebClientOptions options) {
    if (this.connectTimeout != null) {
      options.setConnectTimeout((int) this.connectTimeout.toMillis());
    }
    options.setFollowRedirects(this.followRedirects);
    if (this.preferHttp11) {
      options.setProtocolVersion(HttpVersion.HTTP_1_1);
    }
  }

  /** Configure proxy and potential auth interceptor. */
  private void applyProxy(final WebClientOptions options) {
    if (this.proxyType == HttpClient.ProxyType.DIRECT || this.proxyAddress == null) {
      return;
    }
    final ProxyOptions proxyOptions = new ProxyOptions()
        .setHost(this.proxyAddress.getHostName())
        .setPort(this.proxyAddress.getPort())
        .setType(convertProxyType());

    final String[] userPassword = decodeBasicCredentials(this.proxyAuthorization);
    if (userPassword != null) {
      proxyOptions.setUsername(userPassword[0]).setPassword(userPassword[1]);
    } else {
      addProxyAuthInterceptor();
    }
    options.setProxyOptions(proxyOptions);
  }

  /** Translate requested TLS versions (if any). */
  private String[] resolveProtocols() {
    if (tlsVersions == null || tlsVersions.length == 0) {
      return new String[0];
    }
    return Stream.of(tlsVersions).map(TlsVersion::javaName).toArray(String[]::new);
  }

  /**
   * Builds the configured VertxHttpClient instance.
   *
   * @return configured VertxHttpClient ready for use
   */
  @Override
  public VertxHttpClient<F> build() {
    if (this.client != null) {
      return new VertxHttpClient<>(this, this.client.getClosed(), this.client.getHttpClient(), closeVertx);
    }

    final PoolOptions poolOptions = createPoolOptions();
    final WebClientOptions httpOptions = new WebClientOptions();
    applyBasicHttpSettings(httpOptions);
    applyProxy(httpOptions);

    final String[] protocols = resolveProtocols();
    if (protocols.length > 0) {
      httpOptions.setEnabledSecureTransportProtocols(new HashSet<>(Arrays.asList(protocols)));
    }

    if (this.sslContext != null) {
      httpOptions.setSsl(true);
      httpOptions.setSslEngineOptions(createSslEngineOptions(protocols));
    }

    final WebSocketClientOptions wsOptions = createWebSocketClientOptions(protocols);

    return new VertxHttpClient<>(
        this,
        new AtomicBoolean(),
        vertx.createHttpClient(httpOptions, poolOptions),
        wsOptions,
        closeVertx);
  }

  /** Creates WebSocket client options with appropriate limits for Kubernetes API communication. */
  private WebSocketClientOptions createWebSocketClientOptions(final String[] protocols) {
    final WebSocketClientOptions wsOptions = new WebSocketClientOptions();

    wsOptions.setMaxConnections(MAX_CONNECTIONS);

    // the api-server does not seem to fragment messages, so the frames can be very large
    wsOptions.setMaxFrameSize(MAX_WS_MESSAGE_SIZE);
    wsOptions.setMaxMessageSize(MAX_WS_MESSAGE_SIZE);

    if (this.sslContext != null) {
      wsOptions.setSsl(true);
      wsOptions.setSslEngineOptions(createSslEngineOptions(protocols));
    }

    return wsOptions;
  }

  /**
   * Creates a new builder instance sharing the same Vert.x instance.
   *
   * @param clientFactory factory for creating HTTP clients
   * @return new builder instance
   */
  @Override
  protected VertxHttpClientBuilder<F> newInstance(final F clientFactory) {
    return new VertxHttpClientBuilder<>(clientFactory, vertx, closeVertx);
  }

  /** Maps client proxy types to Vert.x proxy types. */
  private ProxyType convertProxyType() {
    switch (proxyType) {
      case HTTP:
        return ProxyType.HTTP;
      case SOCKS4:
        return ProxyType.SOCKS4;
      case SOCKS5:
        return ProxyType.SOCKS5;
      default:
        throw new KubernetesClientException("Unsupported proxy type");
    }
  }

  /** Creates Vert.x instance with DNS resolver disabled to prevent Vault resolution issues. */
  private static Vertx createVertxInstance() {
    // We must disable the async DNS resolver as it can cause issues when resolving the Vault instance.
    // This is done using the DISABLE_DNS_RESOLVER_PROP_NAME system property.
    // The DNS resolver used by vert.x is configured during the (synchronous) initialization.
    // So, we just need to disable the async resolver around the Vert.x instance creation.
    final String originalValue = DISABLE_DNS_RESOLVER.get();
    Vertx vertx;
    try {
      System.setProperty(DISABLE_DNS_RESOLVER.name, "true");
      vertx = Vertx.vertx(new VertxOptions()
          .setFileSystemOptions(new FileSystemOptions().setFileCachingEnabled(false).setClassPathResolvingEnabled(false))
          .setUseDaemonThread(true));
    } finally {
      // Restore the original value
      if (originalValue == null) {
        System.clearProperty(DISABLE_DNS_RESOLVER.name);
      } else {
        System.setProperty(DISABLE_DNS_RESOLVER.name, originalValue);
      }
    }
    return vertx;
  }

  /** Utility that converts the builder’s {@link #sslContext} + protocols to Vert.x {@link JdkSSLEngineOptions}. */
  private JdkSSLEngineOptions createSslEngineOptions(final String[] protocols) {
    return new JdkSSLEngineOptions() {
      @Override
      public JdkSSLEngineOptions copy() {
        return this; // immutable
      }

      @Override
      public SslContextFactory sslContextFactory() {
        return () -> new JdkSslContext(
            sslContext,
            true,
            null,
            IdentityCipherSuiteFilter.INSTANCE,
            ApplicationProtocolConfig.DISABLED,
            io.netty.handler.ssl.ClientAuth.NONE,
            protocols,
            false);
      }
    };
  }
}
