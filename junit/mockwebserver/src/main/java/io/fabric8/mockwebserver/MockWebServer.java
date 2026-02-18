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
package io.fabric8.mockwebserver;

import io.fabric8.mockwebserver.http.Dispatcher;
import io.fabric8.mockwebserver.http.HttpUrl;
import io.fabric8.mockwebserver.http.MockResponse;
import io.fabric8.mockwebserver.http.QueueDispatcher;
import io.fabric8.mockwebserver.http.RecordedHttpConnection;
import io.fabric8.mockwebserver.http.RecordedRequest;
import io.fabric8.mockwebserver.vertx.HttpServerRequestHandler;
import io.fabric8.mockwebserver.vertx.Protocol;
import io.netty.handler.ssl.ClientAuth;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.core.net.NetServerOptions;
import io.vertx.core.net.PemKeyCertOptions;
import io.vertx.core.net.SelfSignedCertificate;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static io.vertx.core.net.SSLOptions.DEFAULT_ENABLED_SECURE_TRANSPORT_PROTOCOLS;

public class MockWebServer implements Closeable {

  private static final String[] SUPPORTED_WEBSOCKET_SUB_PROTOCOLS = new String[] {
      "v1.channel.k8s.io", "v2.channel.k8s.io", "v3.channel.k8s.io", "v4.channel.k8s.io"
  };

  private static final Logger logger = Logger.getLogger(MockWebServer.class.getName());

  private final Vertx vertx;
  private final BlockingQueue<RecordedRequest> requestQueue;
  private final AtomicInteger requestCount;
  private final List<MockWebServerListener> listeners;
  private Dispatcher dispatcher;
  private ClientAuth clientAuth;
  private final List<String> enabledSecuredTransportProtocols;
  private boolean ssl;
  private SelfSignedCertificate selfSignedCertificate;
  private File pemKeyFile;
  private File pemCertFile;
  private HttpServer httpServer;
  private int port;
  private InetAddress inetAddress;
  private String hostName;
  private List<Protocol> protocols;
  private boolean started;

  public MockWebServer() {
    vertx = Vertx.vertx();
    requestQueue = new LinkedBlockingQueue<>();
    requestCount = new AtomicInteger();
    listeners = new ArrayList<>();
    dispatcher = new QueueDispatcher();
    clientAuth = ClientAuth.NONE;
    enabledSecuredTransportProtocols = new ArrayList<>();
    enabledSecuredTransportProtocols.addAll(DEFAULT_ENABLED_SECURE_TRANSPORT_PROTOCOLS);
    protocols = Arrays.asList(Protocol.HTTP_2, Protocol.HTTP_1_1);
  }

  private void before() {
    if (started) {
      return;
    }
    start();
  }

  public void start() {
    start(NetServerOptions.DEFAULT_PORT);
  }

  public void start(int port) {
    start(InetAddress.getLoopbackAddress(), port);
  }

  public synchronized void start(InetAddress inetAddress, int port) {
    if (started) {
      throw new IllegalStateException("start() already called");
    }
    this.started = true;
    this.inetAddress = inetAddress;
    this.hostName = inetAddress.getHostName().equals("127.0.0.1") ? "localhost" : inetAddress.getHostName();
    final HttpServerOptions options = new HttpServerOptions()
        .setHost(inetAddress.getHostAddress())
        .setPort(port)
        .setAlpnVersions(protocols.stream().map(Protocol::getHttpVersion).collect(Collectors.toList()))
        .setWebSocketSubProtocols(Arrays.asList(SUPPORTED_WEBSOCKET_SUB_PROTOCOLS))
        .setHandle100ContinueAutomatically(true);
    if (ssl) {
      options
          .setSsl(true)
          .setEnabledSecureTransportProtocols(new HashSet<>(enabledSecuredTransportProtocols));

      // Use custom PEM certificates if provided, otherwise use self-signed certificate
      if (pemKeyFile != null && pemCertFile != null) {
        options.setPemKeyCertOptions(new PemKeyCertOptions()
            .setKeyPath(pemKeyFile.getAbsolutePath())
            .setCertPath(pemCertFile.getAbsolutePath()));
      } else {
        selfSignedCertificate = SelfSignedCertificate.create(getHostName());
        options
            .setTrustOptions(selfSignedCertificate.trustOptions())
            .setKeyCertOptions(selfSignedCertificate.keyCertOptions());
      }
    }
    httpServer = vertx.createHttpServer(options);
    httpServer.connectionHandler(event -> {
      final RecordedHttpConnection connection = new RecordedHttpConnection(
          event.remoteAddress(), event.localAddress(), ssl);
      listeners.forEach(listener -> listener.onConnection(connection));
      event.closeHandler(res -> listeners.forEach(listener -> listener.onConnectionClosed(connection)));
    });
    httpServer.requestHandler(new HttpServerRequestHandler(vertx) {
      @Override
      protected MockResponse onHttpRequest(RecordedRequest request) {
        requestCount.incrementAndGet();
        requestQueue.add(request);
        final MockResponse response = dispatcher.dispatch(request);
        info("received request: %s and responded: %s", request.toString(), response.toString());
        return response;
      }
    });
    await(httpServer.listen(), "Unable to start MockWebServer");
    this.port = httpServer.actualPort();
    info("starting to accept connections on %s", getHostName());
  }

  public synchronized void shutdown() {
    if (!started) {
      return;
    }
    if (httpServer == null) {
      throw new IllegalStateException("shutdown() before start()");
    }
    dispatcher.shutdown();
    final Future<Void> httpClose = httpServer.close();
    Handler<AsyncResult<Void>> onComplete = v -> {
      vertx.close();
      info("done accepting connections");
    };
    if (httpClose.isComplete()) {
      onComplete.handle(httpClose);
    } else {
      httpClose.onComplete(onComplete);
      await(httpClose, "Unable to close MockWebServer");
    }
    await(vertx.close(), "Unable to close Vertx");
  }

  @Override
  public void close() throws IOException {
    shutdown();
  }

  public int getPort() {
    before();
    return port;
  }

  public String getHostName() {
    before();
    return hostName;
  }

  public Proxy toProxyAddress() {
    before();
    final InetSocketAddress address = new InetSocketAddress(getHostName(), getPort());
    return new Proxy(Proxy.Type.HTTP, address);
  }

  public SelfSignedCertificate getSelfSignedCertificate() {
    return selfSignedCertificate;
  }

  public HttpUrl url(String path) {
    if (path.startsWith("/")) {
      path = path.substring(1);
    }
    final String schema = ssl ? "https" : "http";
    return HttpUrl.parse(schema + "://" + getHostName() + ":" + getPort() + "/" + path);
  }

  public RecordedRequest takeRequest() throws InterruptedException {
    return requestQueue.take();
  }

  public RecordedRequest takeRequest(long timeout, TimeUnit unit) throws InterruptedException {
    return requestQueue.poll(timeout, unit);
  }

  public int getRequestCount() {
    return requestCount.get();
  }

  public void useHttps() {
    this.ssl = true;
  }

  /**
   * Configures the server to use custom PEM certificates with proper Subject Alternative Names.
   * This must be called before start().
   *
   * @param keyFile the PEM private key file
   * @param certFile the PEM certificate file
   */
  public void usePemCertificates(File keyFile, File certFile) {
    if (started) {
      throw new IllegalStateException("Cannot set certificates after server has started");
    }
    this.ssl = true;
    this.pemKeyFile = keyFile;
    this.pemCertFile = certFile;
  }

  public void enqueue(MockResponse response) {
    if (dispatcher instanceof QueueDispatcher) {
      ((QueueDispatcher) dispatcher).enqueueResponse(response);
    } else {
      throw new IllegalStateException("Dispatcher is not a QueueDispatcher");
    }
  }

  public void addListener(MockWebServerListener listener) {
    listeners.add(listener);
  }

  public void setDispatcher(Dispatcher dispatcher) {
    this.dispatcher = dispatcher;
  }

  public void setProtocols(List<Protocol> protocols) {
    this.protocols = protocols;
  }

  /**
   * Returns the MockWebServer to its initial state by:
   * <ul>
   * <li>Clearing the request count.</li>
   * <li>Clearing the request queue.</li>
   * </ul>
   */
  public final void reset() {
    requestCount.set(0);
    requestQueue.clear();
  }

  private static <T> T await(Future<T> vertxFuture, String errorMessage) {
    final CompletableFuture<T> future = new CompletableFuture<>();
    vertxFuture.onComplete(r -> {
      if (r.succeeded()) {
        future.complete(r.result());
      } else {
        future.completeExceptionally(r.cause());
      }
    });
    try {
      return future.get(10, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new IllegalStateException(e);
    } catch (ExecutionException | TimeoutException e) {
      throw new IllegalStateException(errorMessage, e);
    }
  }

  private void info(String log, String... parameters) {
    if (logger.isLoggable(Level.INFO)) {
      final String formatMessage = "%s " + log;
      final String[] allParams = Arrays.copyOf(new String[] { toString() }, parameters.length + 1);
      System.arraycopy(parameters, 0, allParams, 1, parameters.length);
      logger.info(String.format(formatMessage, allParams));
    }
  }

  @Override
  public String toString() {
    return "MockWebServer[" + getPort() + "]";
  }
}
