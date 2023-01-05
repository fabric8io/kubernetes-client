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

import com.sun.net.httpserver.HttpServer;
import io.fabric8.kubernetes.client.utils.Utils;
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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import javax.net.ServerSocketFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

public abstract class AbstractSimultaneousConnectionsTest {

  // TODO:
  //  Should match whatever spec we decide on to guarantee that these simultaneous connections can be handled
  //  by any HttpClient implementation
  private static final int MAX_HTTP_1_CONNECTIONS = 1024; // Should be able to at least make 1024

  private RegisteredServerSocketFactory serverSocketFactory;
  private MockWebServer mockWebServer;
  private ExecutorService httpExecutor;
  private ExecutorService responseService;
  private HttpServer httpServer;

  private HttpClient.Builder clientBuilder;

  @BeforeEach
  void prepareServerAndBuilder() throws IOException {
    serverSocketFactory = new RegisteredServerSocketFactory();
    mockWebServer = new MockWebServer();
    mockWebServer.setServerSocketFactory(serverSocketFactory);
    httpExecutor = Executors.newCachedThreadPool();
    responseService = Executors.newFixedThreadPool(4);
    httpServer = HttpServer.create(new InetSocketAddress(0), 0);
    httpServer.setExecutor(httpExecutor);
    httpServer.start();
    clientBuilder = getHttpClientFactory().newBuilder();
  }

  @AfterEach
  void stopServer() throws IOException {
    serverSocketFactory.close();
    mockWebServer.shutdown();
    httpServer.stop(0);
    httpExecutor.shutdownNow();
    responseService.shutdownNow();
  }

  protected abstract HttpClient.Factory getHttpClientFactory();

  private void withHttp1() throws IOException {
    mockWebServer.setProtocols(Collections.singletonList(Protocol.HTTP_1_1));
    mockWebServer.start();
  }

  @Test
  @DisplayName("Should be able to make 1024 simultaneous HTTP/1.x connections before processing the response")
  @DisabledOnOs(OS.WINDOWS)
  public void http1Connections() throws Exception {
    final CountDownLatch activeConnections = delayedResponseWithCode(MAX_HTTP_1_CONNECTIONS, 204);
    try (final HttpClient client = clientBuilder.build()) {
      final Collection<CompletableFuture<HttpResponse<AsyncBody>>> asyncResponses = ConcurrentHashMap.newKeySet();
      final HttpRequest request = client.newHttpRequestBuilder()
          .uri(String.format("http://localhost:%s/http", httpServer.getAddress().getPort()))
          .build();
      for (int it = 0; it < MAX_HTTP_1_CONNECTIONS; it++) {
        asyncResponses.add(client.consumeBytes(request, (value, asyncBody) -> asyncBody.consume()));
      }
      awaitLatch(activeConnections);
      CompletableFuture.allOf(asyncResponses.toArray(new CompletableFuture[0])).get(10, TimeUnit.SECONDS);
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
    final CountDownLatch activeConnections = delayedResponseWithCode(MAX_HTTP_1_CONNECTIONS, 500);
    try (final HttpClient client = clientBuilder.build()) {
      for (int it = 0; it < MAX_HTTP_1_CONNECTIONS; it++) {
        newWebSocket(client, URI.create(String.format("http://localhost:%s/http", httpServer.getAddress().getPort())),
            new WebSocket.Listener() {
            });
      }
      awaitLatch(activeConnections);
    }
  }

  private CountDownLatch delayedResponseWithCode(int connections, int code) {
    final CountDownLatch activeConnections = new CountDownLatch(MAX_HTTP_1_CONNECTIONS);
    CompletableFuture<Void> finished = new CompletableFuture<>();
    httpServer.createContext("/http", exchange -> {
      activeConnections.countDown();
      if (activeConnections.getCount() == 0) {
        finished.complete(null);
      }
      finished.thenRunAsync(() -> {
        try {
          exchange.sendResponseHeaders(code, -1);
        } catch (IOException ignore) {

        }
      }, responseService);
    });
    return activeConnections;
  }

  /**
   * Create a new websocket that will retry on a server error
   *
   * @param client
   * @param uri
   * @param listener
   */
  private void newWebSocket(final HttpClient client, URI uri, WebSocket.Listener listener) {
    client.newWebSocketBuilder()
        .uri(uri)
        .buildAsync(listener).whenComplete((w, t) -> {
          if (t != null) {
            // if the server side exception occurs after context, but before the response is sent
            // we can end up creating connections even after the activeConnections reaches 0, but the tests
            // don't seem to care about that situation
            Utils.schedule(Runnable::run, () -> newWebSocket(client, uri, listener), (long) (Math.random() * 20),
                TimeUnit.MILLISECONDS);
          }
        });
  }

  @Test
  @DisplayName("Should be able to make 1024 simultaneous upgraded WebSocket connections")
  @DisabledOnOs(OS.WINDOWS)
  public void http1WebSocketConnections() throws Exception {
    withHttp1();
    final Collection<okhttp3.WebSocket> serverSockets = ConcurrentHashMap.newKeySet();
    final CountDownLatch latch = new CountDownLatch(MAX_HTTP_1_CONNECTIONS);
    final MockResponse response = new MockResponse()
        .withWebSocketUpgrade(new WebSocketListener() {
          @Override
          public void onOpen(okhttp3.WebSocket webSocket, Response response) {
            serverSockets.add(webSocket);
            webSocket.send("go on");
          }
        });
    IntStream.range(0, MAX_HTTP_1_CONNECTIONS).forEach(i -> mockWebServer.enqueue(response));
    try (final HttpClient client = clientBuilder.build()) {
      for (int it = 0; it < MAX_HTTP_1_CONNECTIONS; it++) {
        newWebSocket(client, mockWebServer.url("/").uri(), new WebSocket.Listener() {

          @Override
          public void onMessage(WebSocket webSocket, String text) {
            latch.countDown();
            webSocket.request();
          }
        });
      }
      awaitLatch(latch);
      assertThat(serverSockets.size())
          .isEqualTo(MAX_HTTP_1_CONNECTIONS)
          .isLessThanOrEqualTo((int) serverSocketFactory.activeConnections());
    } finally {
      for (okhttp3.WebSocket socket : serverSockets) {
        socket.close(1000, "done");
      }
    }
  }

  private void awaitLatch(final CountDownLatch latch) throws InterruptedException {
    long count = latch.getCount();
    int iterations = 10;
    int wait = 6;
    for (int i = 0; i < iterations; i++) {
      if (latch.await(wait, TimeUnit.SECONDS)) {
        return;
      }
      if (i == iterations - 1) {
        fail(String.format("Failed to finish after %s seconds", iterations * wait));
      }
      long nextCount = latch.getCount();
      if (nextCount == count) {
        fail("Processing not proceeding, count stuck at " + nextCount);
      }
      count = nextCount;
    }
  }

  private static class RegisteredServerSocketFactory extends ServerSocketFactory implements Closeable {

    private final Set<Socket> connections = new HashSet<>();

    final long activeConnections() {
      return connections.stream().filter(Socket::isConnected).filter(s -> !s.isClosed()).count();
    }

    @Override
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
