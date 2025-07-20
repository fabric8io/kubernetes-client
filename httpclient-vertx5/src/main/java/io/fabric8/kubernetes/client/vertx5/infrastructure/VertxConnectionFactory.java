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
package io.fabric8.kubernetes.client.vertx5.infrastructure;

import io.fabric8.kubernetes.client.vertx5.core.ConnectionConfig;
import io.fabric8.kubernetes.client.vertx5.core.ProxyConfig;
import io.netty.handler.ssl.ApplicationProtocolConfig;
import io.netty.handler.ssl.ClientAuth;
import io.netty.handler.ssl.IdentityCipherSuiteFilter;
import io.netty.handler.ssl.JdkSslContext;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.file.FileSystemOptions;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientOptions;
import io.vertx.core.http.HttpVersion;
import io.vertx.core.http.PoolOptions;
import io.vertx.core.net.JdkSSLEngineOptions;
import io.vertx.core.net.ProxyOptions;
import io.vertx.core.net.ProxyType;
import io.vertx.core.spi.tls.SslContextFactory;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;

import static io.vertx.core.impl.SysProps.DISABLE_DNS_RESOLVER;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class VertxConnectionFactory {

  public static Vertx createVertxInstance() {
    final String originalValue = DISABLE_DNS_RESOLVER.get();
    final Vertx vertx;

    try {
      System.setProperty(DISABLE_DNS_RESOLVER.name, "true");
      vertx = Vertx.vertx(new VertxOptions()
          .setFileSystemOptions(new FileSystemOptions()
              .setFileCachingEnabled(false)
              .setClassPathResolvingEnabled(false))
          .setUseDaemonThread(true));
    } finally {
      if (originalValue == null) {
        System.clearProperty(DISABLE_DNS_RESOLVER.name);
      } else {
        System.setProperty(DISABLE_DNS_RESOLVER.name, originalValue);
      }
    }

    return vertx;
  }

  public static HttpClient createHttpClient(@NonNull final Vertx vertx, @NonNull final ConnectionConfig config) {
    final HttpClientOptions options = new HttpClientOptions();
    final PoolOptions poolOptions = new PoolOptions()
        .setHttp1MaxSize(config.getMaxPoolSize())
        .setCleanerPeriod(1000);

    configureBasicOptions(options, config);
    configureProxyOptions(options, config);
    configureSslOptions(options, config);

    return vertx.createHttpClient(options, poolOptions);
  }

  private static void configureBasicOptions(@NonNull final HttpClientOptions options, @NonNull final ConnectionConfig config) {
    // Pool configuration is handled in createHttpClient method via PoolOptions parameter

    // Connection timeouts  
    options.setConnectTimeout((int) config.getConnectTimeout().toMillis());
    options.setIdleTimeout((int) config.getIdleTimeout().toSeconds());
    options.setIdleTimeoutUnit(TimeUnit.SECONDS);

    if (config.isPreferHttp11()) {
      options.setProtocolVersion(HttpVersion.HTTP_1_1);
    }

    // Note: WebSocket frame/message size and redirect following are configured separately
    // in Vert.x 5 through WebSocketClientOptions and client behavior
  }

  private static void configureProxyOptions(@NonNull final HttpClientOptions options, @NonNull final ConnectionConfig config) {
    if (config.getProxy() == null) {
      return;
    }

    final ProxyConfig proxyConfig = config.getProxy();
    final ProxyOptions proxyOptions = new ProxyOptions()
        .setHost(proxyConfig.getAddress().getHostName())
        .setPort(proxyConfig.getAddress().getPort())
        .setType(convertProxyType(proxyConfig.getType()));

    if (proxyConfig.getUsername() != null) {
      proxyOptions.setUsername(proxyConfig.getUsername());
    }

    if (proxyConfig.getPassword() != null) {
      proxyOptions.setPassword(proxyConfig.getPassword());
    }

    options.setProxyOptions(proxyOptions);
  }

  private static void configureSslOptions(@NonNull final HttpClientOptions options, @NonNull final ConnectionConfig config) {
    if (config.getSslContext() == null) {
      return;
    }

    options.setSsl(true);

    final String[] protocols = getTlsProtocols(config);
    if (protocols != null) {
      options.setEnabledSecureTransportProtocols(new HashSet<>(Arrays.asList(protocols)));
    }

    options.setSslEngineOptions(new JdkSSLEngineOptions() {
      @Override
      public JdkSSLEngineOptions copy() {
        return this;
      }

      @Override
      public SslContextFactory sslContextFactory() {
        return () -> new JdkSslContext(
            config.getSslContext(),
            true,
            null,
            IdentityCipherSuiteFilter.INSTANCE,
            ApplicationProtocolConfig.DISABLED,
            ClientAuth.NONE,
            protocols,
            false);
      }
    });
  }

  private static String[] getTlsProtocols(@NonNull final ConnectionConfig config) {
    if (config.getTlsVersions() == null || config.getTlsVersions().length == 0) {
      return new String[0];
    }
    // TLS versions are already in Java format (e.g., "TLSv1.2", "TLSv1.3")
    return config.getTlsVersions();
  }

  private static ProxyType convertProxyType(@NonNull final io.fabric8.kubernetes.client.http.HttpClient.ProxyType proxyType) {
    switch (proxyType) {
      case HTTP:
        return ProxyType.HTTP;
      case SOCKS4:
        return ProxyType.SOCKS4;
      case SOCKS5:
        return ProxyType.SOCKS5;
      default:
        throw new IllegalArgumentException("Unsupported proxy type: " + proxyType);
    }
  }
}
