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

import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.StandardHttpClientBuilder;
import io.fabric8.kubernetes.client.http.TlsVersion;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.SslProvider;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.file.FileSystemOptions;
import io.vertx.core.http.HttpClientOptions;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.core.http.HttpVersion;
import io.vertx.core.http.PoolOptions;
import io.vertx.core.http.WebSocketClientOptions;
import io.vertx.core.net.ClientOptionsBase;
import io.vertx.core.net.JdkSSLEngineOptions;
import io.vertx.core.net.KeyCertOptions;
import io.vertx.core.net.ProxyOptions;
import io.vertx.core.net.ProxyType;
import io.vertx.core.net.SelfSignedCertificate;
import io.vertx.core.net.TCPSSLOptions;
import io.vertx.core.net.TrustOptions;
import io.vertx.ext.web.client.WebClientOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Stream;

import javax.net.ssl.KeyManager;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509KeyManager;
import javax.net.ssl.X509TrustManager;

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
public class Vertx5HttpClientBuilder<F extends HttpClient.Factory>
    extends StandardHttpClientBuilder<Vertx5HttpClient<F>, F, Vertx5HttpClientBuilder<F>> {

  private static final Logger logger = LoggerFactory.getLogger(Vertx5HttpClientBuilder.class);
  private static final AtomicBoolean TLS_CONTEXT_WARMED = new AtomicBoolean(false);
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

  /**
   * Creates a builder with optional shared Vert.x instance.
   * If no shared instance is provided, creates a new one.
   *
   * @param clientFactory factory for creating HTTP clients
   * @param sharedVertx optional shared Vert.x instance
   */
  public Vertx5HttpClientBuilder(final F clientFactory, final Vertx sharedVertx) {
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
  Vertx5HttpClientBuilder(final F clientFactory, final Vertx vertx, final boolean closeVertx) {
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
    options.setIdleTimeoutUnit(TimeUnit.SECONDS);
    if (this.connectTimeout != null) {
      options.setConnectTimeout((int) this.connectTimeout.toMillis());
    }
    options.setFollowRedirects(this.followRedirects);
    if (this.preferHttp11) {
      options.setProtocolVersion(HttpVersion.HTTP_1_1);
    }
  }

  /** Configure proxy and potential auth interceptor. */
  private void applyProxy(final ClientOptionsBase options) {
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
   * Builds the configured Vertx5HttpClient instance.
   *
   * @return configured Vertx5HttpClient ready for use
   */
  @Override
  public Vertx5HttpClient<F> build() {
    if (this.client != null) {
      return Vertx5HttpClient.createWithDefaults(
          this,
          this.client.getClosed(),
          this.client.getHttpClient(),
          closeVertx);
    }

    // Warn if tlsServerName is configured but not supported
    if (tlsServerName != null && !tlsServerName.isEmpty()) {
      logger.warn(
          "tlsServerName '{}' is configured but not supported by Vert.x HTTP client. "
              + "Consider using Jetty HTTP client for SNI support.",
          tlsServerName);
    }

    final PoolOptions poolOptions = createPoolOptions();
    final WebClientOptions httpOptions = new WebClientOptions();
    applyBasicHttpSettings(httpOptions);
    applyProxy(httpOptions);

    final String[] protocols = resolveProtocols();

    if (this.sslContext != null) {
      applyTlsOptions(httpOptions, protocols);
      warmTlsStack();
    }

    final WebSocketClientOptions wsOptions = createWebSocketClientOptions(protocols);
    applyProxy(wsOptions);

    // Since the factory is not explicitly typed as VertxHttpClientFactory, we need to check the type before invoking
    // additionalConfig as to not break other implementations of HttpClient.Factory for VertxHttpClientBuilder.
    if (clientFactory instanceof Vertx5HttpClientFactory) {
      ((Vertx5HttpClientFactory) clientFactory).additionalConfig(httpOptions, wsOptions, poolOptions);
    }

    return Vertx5HttpClient.createWithWebSocketOptions(
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
      applyTlsOptions(wsOptions, protocols);
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
  protected Vertx5HttpClientBuilder<F> newInstance(final F clientFactory) {
    return new Vertx5HttpClientBuilder<>(clientFactory, vertx, closeVertx);
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
    return createVertxInstance(new VertxOptions()
        .setFileSystemOptions(new FileSystemOptions().setFileCachingEnabled(false).setClassPathResolvingEnabled(false))
        .setUseDaemonThread(true));
  }

  /** Creates a Vert.x instance from the given options with the async DNS resolver disabled. */
  private static Vertx createVertxInstance(final VertxOptions options) {
    // We must disable the async DNS resolver as it can cause issues when resolving the Vault instance.
    // This is done using the DISABLE_DNS_RESOLVER_PROP_NAME system property.
    // The DNS resolver used by vert.x is configured during the (synchronous) initialization.
    // So, we just need to disable the async resolver around the Vert.x instance creation.
    final String originalValue = DISABLE_DNS_RESOLVER.get();
    Vertx vertx;
    try {
      System.setProperty(DISABLE_DNS_RESOLVER.name, "true");
      vertx = Vertx.vertx(options);
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

  /**
   * Dispatches the configured {@link TlsWarmup} mode read off the (typed) client factory. Done the
   * same way as {@link Vertx5HttpClientFactory#additionalConfig}: only honoured when the factory is
   * a {@link Vertx5HttpClientFactory}, otherwise the default {@link TlsWarmup#CONTEXT} applies.
   */
  private void warmTlsStack() {
    TlsWarmup mode = TlsWarmup.CONTEXT;
    if (clientFactory instanceof Vertx5HttpClientFactory) {
      mode = ((Vertx5HttpClientFactory) clientFactory).getTlsWarmup();
    }
    switch (mode) {
      case OFF:
        return;
      case FULL:
        warmTlsStackFull();
        break;
      case CONTEXT:
      default:
        warmTlsStackContext();
        break;
    }
  }

  /**
   * One-time, off-event-loop warm-up of the JDK TLS stack ({@link TlsWarmup#CONTEXT}, the default).
   * Vert.x 5.1 materialises the client SslContext lazily on the event loop on the first handshake
   * (ClientSslContextProvider.createClientContext), which loads
   * JdkDefaultApplicationProtocolNegotiator and compiles SSL-path lambda forms — enough to
   * trip BlockedThreadChecker on a cold/constrained JVM. Building and discarding a context
   * here (on the caller's thread) loads those JVM-global classes first. Best-effort: must
   * never fail client construction. See #7921. We cannot reuse the instance (unlike the
   * Vert.x 4 module) because #7907 requires trust to flow through TrustOptions/KeyCertOptions,
   * not a custom SslContextFactory. The provider is pinned to {@link SslProvider#JDK} so the
   * warm-up loads the same classes the client's {@code JdkSSLEngineOptions} path uses, even
   * when netty-tcnative is on the classpath (which would otherwise make the default provider
   * OpenSSL and warm the wrong stack).
   */
  private static void warmTlsStackContext() {
    // A full handshake already warms a superset of the context, so skip if FULL ran first.
    if (TLS_FULL_WARMED.get() || !TLS_CONTEXT_WARMED.compareAndSet(false, true)) {
      return;
    }
    try {
      SslContextBuilder.forClient().sslProvider(SslProvider.JDK).build();
    } catch (Exception e) {
      logger.debug("TLS stack warm-up skipped: {}", e.getMessage());
    }
  }

  /**
   * One-time, off-event-loop warm-up that drives a complete throwaway loopback TLS handshake
   * ({@link TlsWarmup#FULL}). The {@link TlsWarmup#CONTEXT} warm-up leaves the {@code SslHandler}
   * creation and the handshake {@code wrap}/{@code unwrap} (the bulk of the one-time TLS class
   * loading) on the event loop on the first connection; under hard CPU throttling that residual can
   * still exceed the connect timeout. Running a real handshake against a self-signed loopback server
   * here warms the full Netty + JDK TLS class path and the Vert.x connect/DNS path, so the first
   * real connection no longer blocks the loop. Runs synchronously on the building thread (the
   * explicit trade opt-in users make). Best-effort: any failure falls back to the context warm-up.
   * See #7926.
   */
  private static void warmTlsStackFull() {
    if (!TLS_FULL_WARMED.compareAndSet(false, true)) {
      return;
    }
    // A full handshake subsumes the context-only warm-up; mark it done so a later CONTEXT build is a no-op.
    TLS_CONTEXT_WARMED.set(true);
    try {
      loopbackTlsHandshake();
    } catch (Exception e) {
      logger.debug("Full TLS stack warm-up skipped, falling back to context warm-up: {}", e.getMessage());
      try {
        SslContextBuilder.forClient().sslProvider(SslProvider.JDK).build();
      } catch (Exception ignore) {
        // best-effort: warm-up must never fail client construction
      }
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

  /**
   * Applies the builder's TLS configuration uniformly to both the HTTP and WebSocket client options.
   *
   * <p>
   * Trust and key material are supplied to Vert.x as {@link TrustOptions}/{@link KeyCertOptions} wrapping
   * the builder's {@link #trustManagers}/{@link #keyManagers} rather than a pre-built Netty
   * {@code JdkSslContext} carried inside a custom {@code SslContextFactory}. Vert.x 5.1 resolves the
   * WebSocket client's TLS through a per-connection {@code ClientSSLOptions} derived from these options
   * (not from the engine-options factory), so carrying trust only in the factory left WebSocket-over-TLS
   * connections falling back to the default JVM trust store. Driving both clients through the same options
   * keeps a single source of trust and fixes the WebSocket path (see fabric8io/kubernetes-client#7907).
   */
  private void applyTlsOptions(final TCPSSLOptions options, final String[] protocols) {
    options.setSsl(true);
    options.setSslEngineOptions(new JdkSSLEngineOptions());
    final X509TrustManager trustManager = firstX509TrustManager();
    if (trustManager != null) {
      options.setTrustOptions(TrustOptions.wrap(trustManager));
    }
    final X509KeyManager keyManager = firstX509KeyManager();
    if (keyManager != null) {
      options.setKeyCertOptions(KeyCertOptions.wrap(keyManager));
    }
    if (protocols.length > 0) {
      options.setEnabledSecureTransportProtocols(new HashSet<>(Arrays.asList(protocols)));
    }
  }

  /** Returns the first {@link X509TrustManager} from the configured trust managers, or {@code null}. */
  private X509TrustManager firstX509TrustManager() {
    if (trustManagers == null) {
      return null;
    }
    for (TrustManager trustManager : trustManagers) {
      if (trustManager instanceof X509TrustManager) {
        return (X509TrustManager) trustManager;
      }
    }
    return null;
  }

  /** Returns the first {@link X509KeyManager} from the configured key managers, or {@code null}. */
  private X509KeyManager firstX509KeyManager() {
    if (keyManagers == null) {
      return null;
    }
    for (KeyManager keyManager : keyManagers) {
      if (keyManager instanceof X509KeyManager) {
        return (X509KeyManager) keyManager;
      }
    }
    return null;
  }
}
