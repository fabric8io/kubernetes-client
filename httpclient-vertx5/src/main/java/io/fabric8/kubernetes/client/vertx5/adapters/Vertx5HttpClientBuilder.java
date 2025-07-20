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
package io.fabric8.kubernetes.client.vertx5.adapters;

import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.StandardHttpClientBuilder;
import io.fabric8.kubernetes.client.http.TlsVersion;
import io.fabric8.kubernetes.client.vertx5.core.ConnectionConfig;
import io.fabric8.kubernetes.client.vertx5.core.ProxyConfig;
import io.fabric8.kubernetes.client.vertx5.infrastructure.VertxConnectionFactory;
import io.vertx.core.Vertx;
import io.vertx.core.http.WebSocketClient;
import lombok.NonNull;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Stream;

public final class Vertx5HttpClientBuilder<F extends HttpClient.Factory>
    extends StandardHttpClientBuilder<Vertx5HttpClient<F>, F, Vertx5HttpClientBuilder<F>> {

  private static final int MAX_CONNECTIONS = 8192;
  // the default for etcd seems to be 3 MB, but we'll default to unlimited, so we have the same behavior across clients
  private static final int MAX_WS_MESSAGE_SIZE = Integer.MAX_VALUE;

  final Vertx vertx;
  private final boolean closeVertx;

  public Vertx5HttpClientBuilder(@NonNull final F clientFactory, final Vertx sharedVertx) {
    this(
        clientFactory,
        sharedVertx != null ? sharedVertx : VertxConnectionFactory.createVertxInstance(),
        sharedVertx == null);
  }

  Vertx5HttpClientBuilder(@NonNull final F clientFactory, @NonNull final Vertx vertx, final boolean closeVertx) {
    super(clientFactory);
    this.vertx = vertx;
    this.closeVertx = closeVertx;
  }

  @Override
  public Vertx5HttpClient<F> build() {
    if (this.client != null) {
      return new Vertx5HttpClient<>(this, this.client.getClosed(), this.client.getHttpClient(),
          this.client.getWebSocketClient(), closeVertx);
    }

    final ConnectionConfig config = buildConnectionConfig();
    final io.vertx.core.http.HttpClient httpClient = VertxConnectionFactory.createHttpClient(vertx, config);
    final WebSocketClient webSocketClient = vertx.createWebSocketClient();

    return new Vertx5HttpClient<>(this, new AtomicBoolean(), httpClient, webSocketClient, closeVertx);
  }

  @Override
  protected Vertx5HttpClientBuilder<F> newInstance(@NonNull final F clientFactory) {
    return new Vertx5HttpClientBuilder<>(clientFactory, vertx, closeVertx);
  }

  private ConnectionConfig buildConnectionConfig() {
    final ConnectionConfig.ConnectionConfigBuilder builder = ConnectionConfig.builder()
        .maxPoolSize(MAX_CONNECTIONS)
        .maxWebSocketFrameSize(MAX_WS_MESSAGE_SIZE)
        .maxWebSocketMessageSize(MAX_WS_MESSAGE_SIZE)
        .preferHttp11(this.preferHttp11)
        .followRedirects(this.followRedirects);

    if (this.connectTimeout != null) {
      builder.connectTimeout(this.connectTimeout);
    }

    if (this.sslContext != null) {
      builder.sslContext(this.sslContext);
    }

    if (this.tlsVersions != null && this.tlsVersions.length > 0) {
      builder.tlsVersions(Stream.of(this.tlsVersions)
          .map(TlsVersion::javaName)
          .toArray(String[]::new));
    }

    if (this.proxyType != HttpClient.ProxyType.DIRECT && this.proxyAddress != null) {
      final ProxyConfig proxyConfig = createProxyConfig();
      builder.proxy(proxyConfig);
    }

    return builder.build();
  }

  private ProxyConfig createProxyConfig() {
    final ProxyConfig.ProxyConfigBuilder builder = ProxyConfig.builder()
        .type(this.proxyType)
        .address(this.proxyAddress);

    if (this.proxyAuthorization != null) {
      final String[] userPassword = io.fabric8.kubernetes.client.utils.HttpClientUtils
          .decodeBasicCredentials(this.proxyAuthorization);
      if (userPassword != null) {
        builder.username(userPassword[0])
            .password(userPassword[1]);
      }
    }

    return builder.build();
  }
}