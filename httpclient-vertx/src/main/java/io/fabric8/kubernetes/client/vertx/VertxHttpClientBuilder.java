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
import io.vertx.core.net.JdkSSLEngineOptions;
import io.vertx.core.net.ProxyOptions;
import io.vertx.core.net.ProxyType;
import io.vertx.core.spi.tls.SslContextFactory;
import io.vertx.ext.web.client.WebClientOptions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Stream;

import static io.fabric8.kubernetes.client.utils.HttpClientUtils.decodeBasicCredentials;
import static io.vertx.core.spi.resolver.ResolverProvider.DISABLE_DNS_RESOLVER_PROP_NAME;

public class VertxHttpClientBuilder<F extends HttpClient.Factory>
    extends StandardHttpClientBuilder<VertxHttpClient<F>, F, VertxHttpClientBuilder<F>> {

  private static final int MAX_CONNECTIONS = 8192;
  // the default for etcd seems to be 3 MB, but we'll default to unlimited, so we have the same behavior across clients
  private static final int MAX_WS_MESSAGE_SIZE = Integer.MAX_VALUE;

  final Vertx vertx;
  private final boolean closeVertx;
  private WebClientOptions customWebClientOptions;

  public VertxHttpClientBuilder(F clientFactory, Vertx sharedVertx) {
    this(
        clientFactory,
        sharedVertx != null ? sharedVertx : createVertxInstance(),
        sharedVertx == null);
  }

  VertxHttpClientBuilder(F clientFactory, Vertx vertx, boolean closeVertx) {
    super(clientFactory);
    this.vertx = vertx;
    this.closeVertx = closeVertx;
  }

  /**
   * Use the provided {@link WebClientOptions} as the base options for the client.
   * <p>
   *   Note: The Builder overrides some options to ensure the client works properly with the Kubernetes API server.
   *   These options that the Builder controls will override the values you set in the provided
   *   {@link WebClientOptions}.
   * </p>
   */
  public VertxHttpClientBuilder<F> withCustomWebClientOptions(WebClientOptions options) {
    this.customWebClientOptions = options;
    return this;
  }

  @Override
  public VertxHttpClient<F> build() {
    if (this.client != null) {
      return new VertxHttpClient<>(this, this.client.getClosed(), this.client.getClient(), closeVertx);
    }

    WebClientOptions options;
    if (customWebClientOptions == null) {
      options = new WebClientOptions();
    } else {
      options = new WebClientOptions(customWebClientOptions);
    }

    options.setMaxPoolSize(MAX_CONNECTIONS);
    options.setMaxWebSockets(MAX_CONNECTIONS);
    options.setIdleTimeoutUnit(TimeUnit.SECONDS);
    // the api-server does not seem to fragment messages, so the frames can be very large
    options.setMaxWebSocketFrameSize(MAX_WS_MESSAGE_SIZE);
    options.setMaxWebSocketMessageSize(MAX_WS_MESSAGE_SIZE);

    if (this.connectTimeout != null) {
      options.setConnectTimeout((int) this.connectTimeout.toMillis());
    }

    if (this.followRedirects) {
      options.setFollowRedirects(followRedirects);
    }

    if (this.proxyType != HttpClient.ProxyType.DIRECT && this.proxyAddress != null) {
      final ProxyOptions proxyOptions = new ProxyOptions()
          .setHost(this.proxyAddress.getHostName())
          .setPort(this.proxyAddress.getPort())
          .setType(convertProxyType());
      final String[] userPassword = decodeBasicCredentials(this.proxyAuthorization);
      if (userPassword != null) {
        proxyOptions.setUsername(userPassword[0]);
        proxyOptions.setPassword(userPassword[1]);
      } else {
        addProxyAuthInterceptor();
      }
      options.setProxyOptions(proxyOptions);
    }

    final String[] protocols;
    if (tlsVersions != null && tlsVersions.length > 0) {
      protocols = Stream.of(tlsVersions).map(TlsVersion::javaName).toArray(String[]::new);
      options.setEnabledSecureTransportProtocols(new HashSet<>(Arrays.asList(protocols)));
    } else {
      protocols = null;
    }

    if (this.preferHttp11) {
      options.setProtocolVersion(HttpVersion.HTTP_1_1);
    }

    if (this.sslContext != null) {
      options.setSsl(true);
      options.setSslEngineOptions(new JdkSSLEngineOptions() {
        @Override
        public JdkSSLEngineOptions copy() {
          return this;
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
      });
    }
    return new VertxHttpClient<>(this, new AtomicBoolean(), vertx.createHttpClient(options), closeVertx);
  }

  @Override
  protected VertxHttpClientBuilder<F> newInstance(F clientFactory) {
    return new VertxHttpClientBuilder<>(clientFactory, vertx, closeVertx);
  }

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

  private static Vertx createVertxInstance() {
    // We must disable the async DNS resolver as it can cause issues when resolving the Vault instance.
    // This is done using the DISABLE_DNS_RESOLVER_PROP_NAME system property.
    // The DNS resolver used by vert.x is configured during the (synchronous) initialization.
    // So, we just need to disable the async resolver around the Vert.x instance creation.
    final String originalValue = System.getProperty(DISABLE_DNS_RESOLVER_PROP_NAME);
    Vertx vertx;
    try {
      System.setProperty(DISABLE_DNS_RESOLVER_PROP_NAME, "true");
      vertx = Vertx.vertx(new VertxOptions()
          .setFileSystemOptions(new FileSystemOptions().setFileCachingEnabled(false).setClassPathResolvingEnabled(false))
          .setUseDaemonThread(true));
    } finally {
      // Restore the original value
      if (originalValue == null) {
        System.clearProperty(DISABLE_DNS_RESOLVER_PROP_NAME);
      } else {
        System.setProperty(DISABLE_DNS_RESOLVER_PROP_NAME, originalValue);
      }
    }
    return vertx;
  }
}
