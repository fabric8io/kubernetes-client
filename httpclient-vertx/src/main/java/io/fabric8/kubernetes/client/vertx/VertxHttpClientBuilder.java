/**
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
import io.vertx.core.http.HttpVersion;
import io.vertx.core.net.JdkSSLEngineOptions;
import io.vertx.core.net.ProxyOptions;
import io.vertx.core.net.ProxyType;
import io.vertx.core.spi.tls.SslContextFactory;
import io.vertx.ext.web.client.WebClientOptions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class VertxHttpClientBuilder<F extends HttpClient.Factory>
    extends StandardHttpClientBuilder<VertxHttpClient<F>, F, VertxHttpClientBuilder<F>> {

  private static final int MAX_CONNECTIONS = 8192;
  // the default for etcd seems to be 3 MB, but we'll default to unlimited, so we have the same behavior across clients
  private static final int MAX_WS_MESSAGE_SIZE = Integer.MAX_VALUE;

  final Vertx vertx;

  public VertxHttpClientBuilder(F clientFactory, Vertx vertx) {
    super(clientFactory);
    this.vertx = vertx;
  }

  @Override
  public VertxHttpClient<F> build() {
    if (this.client != null) {
      return new VertxHttpClient<>(this, this.client.getClient());
    }

    WebClientOptions options = new WebClientOptions();

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
      ProxyOptions proxyOptions = new ProxyOptions()
          .setHost(this.proxyAddress.getHostName())
          .setPort(this.proxyAddress.getPort())
          .setType(convertProxyType());
      options.setProxyOptions(proxyOptions);
      addProxyAuthInterceptor();
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
    return new VertxHttpClient<>(this, vertx.createHttpClient(options));
  }

  @Override
  protected VertxHttpClientBuilder<F> newInstance(F clientFactory) {
    return new VertxHttpClientBuilder<>(clientFactory, vertx);
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

}
