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
package io.fabric8.kubernetes.client.http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.WebSocketListener;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.URI;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import javax.net.ServerSocketFactory;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class AbstractSimultaneousConnectionsTest {

  // TODO:
  //  Should match whatever spec we decide on to guarantee that these simultaneous connections can be handled
  //  by any HttpClient implementation
  private static final int MAX_HTTP_1_CONNECTIONS = 2048; // Should be able to at least make 2048
  private static final int MAX_HTTP_1_WS_CONNECTIONS = 1024; // Should be able to at least make 1024

  private RegisteredServerSocketFactory serverSocketFactory;
  private MockWebServer mockWebServer;
  private ExecutorService httpExecutor;
  private HttpServer httpServer;

  private HttpClient.Builder clientBuilder;

  @BeforeEach
  void prepareServerAndBuilder() throws IOException {
    serverSocketFactory = new RegisteredServerSocketFactory();
    mockWebServer = new MockWebServer();
    mockWebServer.setServerSocketFactory(serverSocketFactory);
    httpExecutor = Executors.newCachedThreadPool();
    httpServer = HttpServer.create(new InetSocketAddress(0), 0);
    httpServer.setExecutor(httpExecutor);
    httpServer.start();
    clientBuilder = getHttpClientFactory().newBuilder()
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS);
  }

  @AfterEach
  void stopServer() throws IOException {
    serverSocketFactory.close();
    mockWebServer.shutdown();
    httpServer.stop(0);
    httpExecutor.shutdownNow();
  }

  protected abstract HttpClient.Factory getHttpClientFactory();

  private void withHttp1() throws IOException {
    mockWebServer.setProtocols(Collections.singletonList(Protocol.HTTP_1_1));
    mockWebServer.start();
  }

  @Test
  @DisplayName("Should be able to make 2048 simultaneous HTTP/1.x connections before processing the response")
  @DisabledOnOs(OS.WINDOWS)
  public void http1Connections() throws Exception {
    final DelayedResponseHandler handler = new DelayedResponseHandler(MAX_HTTP_1_CONNECTIONS,
        exchange -> exchange.sendResponseHeaders(204, -1));
    httpServer.createContext("/http", handler);
    try (final HttpClient client = clientBuilder.build()) {
      final Collection<CompletableFuture<HttpResponse<AsyncBody>>> asyncResponses = ConcurrentHashMap.newKeySet();
      final HttpRequest request = client.newHttpRequestBuilder()
          .uri(String.format("http://localhost:%s/http", httpServer.getAddress().getPort()))
          .build();
      for (int it = 0; it < MAX_HTTP_1_CONNECTIONS; it++) {
        asyncResponses.add(client.consumeBytes(request, (value, asyncBody) -> asyncBody.consume()));
        handler.await();
      }
      CompletableFuture.allOf(asyncResponses.toArray(new CompletableFuture[0])).get(60, TimeUnit.SECONDS);
      assertThat(asyncResponses)
          .hasSize(MAX_HTTP_1_CONNECTIONS)
          .extracting(CompletableFuture::join)
          .extracting(HttpResponse::code).containsOnly(204);
    }
  }

  @Test
  @DisplayName("Should be able to make 1024 simultaneous HTTP connections before upgrading to WebSocket")
  @DisabledOnOs(OS.WINDOWS)
  public void http1WebSocketConnectionsBeforeUpgrade() throws Exception {
    final DelayedResponseHandler handler = new DelayedResponseHandler(MAX_HTTP_1_WS_CONNECTIONS,
        exchange -> exchange.sendResponseHeaders(404, -1));
    httpServer.createContext("/http", handler);
    try (final HttpClient client = clientBuilder.build()) {
      for (int it = 0; it < MAX_HTTP_1_WS_CONNECTIONS; it++) {
        client.newWebSocketBuilder()
            .uri(URI.create(String.format("http://localhost:%s/http", httpServer.getAddress().getPort())))
            .buildAsync(new WebSocket.Listener() {
            });
        handler.await();
      }
    }
    assertThat(handler.connectionCount.get(60, TimeUnit.SECONDS)).isEqualTo(MAX_HTTP_1_WS_CONNECTIONS);
  }

  @Test
  @DisplayName("Should be able to make 1024 simultaneous upgraded WebSocket connections")
  @DisabledOnOs(OS.WINDOWS)
  public void http1WebSocketConnections() throws Exception {
    withHttp1();
    final Collection<okhttp3.WebSocket> serverSockets = ConcurrentHashMap.newKeySet();
    final Collection<WebSocket> clientSockets = ConcurrentHashMap.newKeySet();
    final CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
    final CountDownLatch latch = new CountDownLatch(MAX_HTTP_1_WS_CONNECTIONS);
    final MockResponse response = new MockResponse()
        .withWebSocketUpgrade(new WebSocketListener() {
          @Override
          public void onOpen(okhttp3.WebSocket webSocket, Response response) {
            try {
              cyclicBarrier.await(1, TimeUnit.SECONDS);
            } catch (Exception ignore) {
            }
            serverSockets.add(webSocket);
            webSocket.send("go on");
          }
        });
    IntStream.range(0, MAX_HTTP_1_WS_CONNECTIONS).forEach(i -> mockWebServer.enqueue(response));
    try (final HttpClient client = clientBuilder.build()) {
      for (int it = 0; it < MAX_HTTP_1_WS_CONNECTIONS; it++) {
        client.newWebSocketBuilder()
            .uri(mockWebServer.url("/").uri())
            .buildAsync(new WebSocket.Listener() {

              @Override
              public void onMessage(WebSocket webSocket, String text) {
                clientSockets.add(webSocket);
                latch.countDown();
                webSocket.request();
              }
            });
        cyclicBarrier.await(1, TimeUnit.SECONDS);
      }
      assertThat(latch.await(60L, TimeUnit.SECONDS)).isTrue();
      assertThat(serverSockets.size())
          .isEqualTo(MAX_HTTP_1_WS_CONNECTIONS)
          .isLessThanOrEqualTo((int) serverSocketFactory.activeConnections());
      //      assertThat(clientSockets)
      //          .hasSize(MAX_HTTP_1_WS_CONNECTIONS);
    } finally {
      for (okhttp3.WebSocket socket : serverSockets) {
        socket.close(1000, "done");
      }
    }
  }

  private static class DelayedResponseHandler implements HttpHandler {

    private final int requestCount;
    private final CyclicBarrier barrier;
    private final Set<HttpExchange> exchanges;
    private final CompletableFuture<Integer> connectionCount;
    private final ExecutorService executorService;

    private DelayedResponseHandler(int requestCount, HttpHandler handler) {
      this.requestCount = requestCount;
      this.barrier = new CyclicBarrier(2);
      exchanges = ConcurrentHashMap.newKeySet();
      connectionCount = new CompletableFuture<>();
      executorService = Executors.newFixedThreadPool(1);
      connectionCount.thenRunAsync(() -> {
        for (HttpExchange exchange : exchanges) {
          try {
            handler.handle(exchange);
          } catch (IOException ignore) {
            // NO OP
          }
        }
      }, executorService)
          .whenComplete((unused, throwable) -> executorService.shutdownNow());
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
      exchanges.add(exchange);
      await();
      if (exchanges.size() == requestCount) {
        connectionCount.complete(requestCount);
      }

    }

    public final void await() {
      try {
        barrier.await(1, TimeUnit.SECONDS);
      } catch (Exception ex) {
        throw new RuntimeException("Failed to await the barrier");
      }
      ;
    }
  }

  private static class RegisteredServerSocketFactory extends ServerSocketFactory implements Closeable {

    private final Set<Socket> connections = new HashSet<>();

    final long activeConnections() {
      return connections.stream().filter(Socket::isConnected).filter(s -> !s.isClosed()).count();
    }

    public final void close() {
      for (Socket socket : connections) {
        try {
          socket.close();
        } catch (IOException ignored) {
          // ignored
        }
      }
    }

    @Override
    public ServerSocket createServerSocket() throws IOException {
      return new ServerSocket() {
        @Override
        public Socket accept() throws IOException {
          final Socket socket = super.accept();
          connections.add(socket);
          return socket;
        }
      };
    }

    @Override
    public ServerSocket createServerSocket(int port) throws IOException {
      throw new SocketException("not implemented");
    }

    @Override
    public ServerSocket createServerSocket(int port, int backlog) throws IOException {
      throw new SocketException("not implemented");
    }

    @Override
    public ServerSocket createServerSocket(int port, int backlog, InetAddress ifAddress) throws IOException {
      throw new SocketException("not implemented");
    }
  }
}
