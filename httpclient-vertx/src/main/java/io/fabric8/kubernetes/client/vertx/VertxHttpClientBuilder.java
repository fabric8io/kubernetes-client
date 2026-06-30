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
import io.netty.handler.ssl.ClientAuth;
import io.netty.handler.ssl.IdentityCipherSuiteFilter;
import io.netty.handler.ssl.JdkSslContext;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.file.FileSystemOptions;
import io.vertx.core.http.HttpClientOptions;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.core.http.HttpVersion;
import io.vertx.core.net.JdkSSLEngineOptions;
import io.vertx.core.net.ProxyOptions;
import io.vertx.core.net.ProxyType;
import io.vertx.core.net.SelfSignedCertificate;
import io.vertx.core.net.TrustOptions;
import io.vertx.core.spi.tls.SslContextFactory;
import io.vertx.ext.web.client.WebClientOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Stream;

import javax.net.ssl.X509TrustManager;

import static io.fabric8.kubernetes.client.utils.HttpClientUtils.decodeBasicCredentials;
import static io.vertx.core.spi.resolver.ResolverProvider.DISABLE_DNS_RESOLVER_PROP_NAME;

public class VertxHttpClientBuilder<F extends HttpClient.Factory>
    extends StandardHttpClientBuilder<VertxHttpClient<F>, F, VertxHttpClientBuilder<F>> {

  private static final Logger logger = LoggerFactory.getLogger(VertxHttpClientBuilder.class);
  private static final AtomicBoolean TLS_FULL_WARMED = new AtomicBoolean(false);
  private static final int MAX_CONNECTIONS = 8192;
  private static final String LOOPBACK_HOST = "127.0.0.1";
  // Single overall deadline for the warm-up's useful work (bind + handshake) so the synchronous stall
  // on build() is bounded to roughly this, not multiplied per phase. Teardown gets its own short budget.
  private static final long WARMUP_TIMEOUT_SECONDS = 30;
  private static final long WARMUP_CLOSE_TIMEOUT_SECONDS = 10;
  // the default for etcd seems to be 3 MB, but we'll default to unlimited, so we have the same behavior across clients
  private static final int MAX_WS_MESSAGE_SIZE = Integer.MAX_VALUE;

  final Vertx vertx;
  private final boolean closeVertx;

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

  @Override
  public VertxHttpClient<F> build() {
    if (this.client != null) {
      return new VertxHttpClient<>(this, this.client.getClosed(), this.client.getClient(), closeVertx);
    }

    // Warn if tlsServerName is configured but not supported
    if (tlsServerName != null && !tlsServerName.isEmpty()) {
      logger.warn(
          "tlsServerName '{}' is configured but not supported by Vert.x HTTP client. Consider using Jetty HTTP client for SNI support.",
          tlsServerName);
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
      final TlsWarmup warmup = resolveTlsWarmup();
      // Build the Netty SslContext off the Vert.x event loop. Vert.x otherwise calls
      // SslContextFactory.create() lazily on the event loop during the first handshake; pre-building
      // it (CONTEXT/FULL, the default) keeps that construction off the loop. With OFF the context is
      // built lazily on the loop as before #7922. See #7921 / #7926.
      final SslContextFactory sslContextFactory;
      if (warmup == TlsWarmup.OFF) {
        sslContextFactory = () -> buildJdkSslContext(protocols);
      } else {
        final JdkSslContext jdkSslContext = buildJdkSslContext(protocols);
        sslContextFactory = () -> jdkSslContext;
      }
      options.setSslEngineOptions(new JdkSSLEngineOptions() {
        @Override
        public JdkSSLEngineOptions copy() {
          return this;
        }

        @Override
        public SslContextFactory sslContextFactory() {
          return sslContextFactory;
        }
      });
      if (warmup == TlsWarmup.FULL) {
        warmTlsStackFull();
      }
    }

    // Since the factory is not explicitly typed as VertxHttpClientFactory, we need to check the type before invoking
    // additionalConfig as to not break other implementations of HttpClient.Factory for VertxHttpClientBuilder.
    if (clientFactory instanceof VertxHttpClientFactory) {
      ((VertxHttpClientFactory) clientFactory).additionalConfig(options);
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
    return createVertxInstance(new VertxOptions()
        .setFileSystemOptions(new FileSystemOptions().setFileCachingEnabled(false).setClassPathResolvingEnabled(false))
        .setUseDaemonThread(true));
  }

  private static Vertx createVertxInstance(final VertxOptions options) {
    // We must disable the async DNS resolver as it can cause issues when resolving the Vault instance.
    // This is done using the DISABLE_DNS_RESOLVER_PROP_NAME system property.
    // The DNS resolver used by vert.x is configured during the (synchronous) initialization.
    // So, we just need to disable the async resolver around the Vert.x instance creation.
    final String originalValue = System.getProperty(DISABLE_DNS_RESOLVER_PROP_NAME);
    Vertx vertx;
    try {
      System.setProperty(DISABLE_DNS_RESOLVER_PROP_NAME, "true");
      vertx = Vertx.vertx(options);
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

  /** Resolves the configured {@link TlsWarmup} mode off the (typed) client factory, defaulting to CONTEXT. */
  private TlsWarmup resolveTlsWarmup() {
    if (clientFactory instanceof VertxHttpClientFactory) {
      return ((VertxHttpClientFactory) clientFactory).getTlsWarmup();
    }
    return TlsWarmup.CONTEXT;
  }

  /** Builds the Netty {@link JdkSslContext} wrapping the configured {@code sslContext} for the given protocols. */
  private JdkSslContext buildJdkSslContext(final String[] protocols) {
    return new JdkSslContext(
        sslContext, true, null, IdentityCipherSuiteFilter.INSTANCE,
        ApplicationProtocolConfig.DISABLED, ClientAuth.NONE,
        protocols, false);
  }

  /**
   * One-time, off-event-loop warm-up that drives a complete throwaway loopback TLS handshake
   * ({@link TlsWarmup#FULL}). The eager context pre-build keeps the {@code JdkSslContext} construction
   * off the event loop, but the {@code SslHandler} creation and the handshake {@code wrap}/{@code unwrap}
   * (the bulk of the one-time TLS class loading) still happen on the loop on the first connection; under
   * hard CPU throttling that residual can exceed the connect timeout. Running a real handshake against a
   * self-signed loopback server here warms the full Netty + JDK TLS class path and the Vert.x connect/DNS
   * path. Runs synchronously on the building thread (the explicit trade opt-in users make). Best-effort:
   * any failure is swallowed since the eager context pre-build already happened. See #7926.
   */
  private static void warmTlsStackFull() {
    if (!TLS_FULL_WARMED.compareAndSet(false, true)) {
      return;
    }
    try {
      loopbackTlsHandshake();
    } catch (Exception e) {
      logger.debug("Full TLS stack warm-up skipped: {}", e.getMessage());
    }
  }

  /**
   * Stands up a self-signed HTTPS server on a loopback ephemeral port, performs one client TLS
   * handshake against it and tears both down, on a disposable Vert.x instance created with the same
   * DNS-resolver setting as the real client so the same classes are loaded. The trust-all manager is
   * scoped to this throwaway client and never touches real traffic.
   */
  private static void loopbackTlsHandshake() throws Exception {
    final long deadlineNanos = System.nanoTime() + TimeUnit.SECONDS.toNanos(WARMUP_TIMEOUT_SECONDS);
    final Vertx warmVertx = createVertxInstance(new VertxOptions()
        .setEventLoopPoolSize(1)
        .setUseDaemonThread(true)
        // The warm-up deliberately drives a TLS handshake on this throwaway event loop, which is exactly
        // the work we are relocating off the real loop. Relax the blocked-thread checker so the warm-up
        // does not emit alarming "thread blocked" warnings in the user's logs under CPU throttling.
        .setBlockedThreadCheckInterval(WARMUP_TIMEOUT_SECONDS).setBlockedThreadCheckIntervalUnit(TimeUnit.SECONDS)
        .setMaxEventLoopExecuteTime(WARMUP_TIMEOUT_SECONDS).setMaxEventLoopExecuteTimeUnit(TimeUnit.SECONDS));
    SelfSignedCertificate certificate = null;
    try {
      certificate = SelfSignedCertificate.create();
      final HttpServer server = warmVertx
          .createHttpServer(new HttpServerOptions()
              .setSsl(true)
              .setKeyCertOptions(certificate.keyCertOptions())
              .setHost(LOOPBACK_HOST)
              .setPort(0))
          .requestHandler(req -> req.response().end("ok"));
      server.listen().toCompletionStage().toCompletableFuture()
          .get(remainingMillis(deadlineNanos), TimeUnit.MILLISECONDS);
      final int port = server.actualPort();
      final HttpClientOptions clientOptions = new HttpClientOptions()
          .setSsl(true)
          .setSslEngineOptions(new JdkSSLEngineOptions())
          .setTrustOptions(TrustOptions.wrap(trustAllManager()));
      final io.vertx.core.http.HttpClient warmClient = warmVertx.createHttpClient(clientOptions);
      warmClient.request(HttpMethod.GET, port, LOOPBACK_HOST, "/")
          .compose(req -> req.send())
          .compose(resp -> resp.body())
          .toCompletionStage().toCompletableFuture()
          .get(remainingMillis(deadlineNanos), TimeUnit.MILLISECONDS);
    } finally {
      try {
        warmVertx.close().toCompletionStage().toCompletableFuture().get(WARMUP_CLOSE_TIMEOUT_SECONDS, TimeUnit.SECONDS);
      } finally {
        // Remove the throwaway self-signed cert/key temp files now rather than relying on deleteOnExit.
        if (certificate != null) {
          certificate.delete();
        }
      }
    }
  }

  /** Milliseconds left until the warm-up deadline, floored at 1 so a {@code get} never waits indefinitely. */
  private static long remainingMillis(final long deadlineNanos) {
    return Math.max(1L, (deadlineNanos - System.nanoTime()) / 1_000_000L);
  }

  /** Trust-all manager used solely by the throwaway loopback warm-up client; never used for real traffic. */
  private static X509TrustManager trustAllManager() {
    return new X509TrustManager() {
      @Override
      public void checkClientTrusted(X509Certificate[] chain, String authType) {
        // no-op: throwaway warm-up only
      }

      @Override
      public void checkServerTrusted(X509Certificate[] chain, String authType) {
        // no-op: throwaway warm-up only
      }

      @Override
      public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
      }
    };
  }
}
