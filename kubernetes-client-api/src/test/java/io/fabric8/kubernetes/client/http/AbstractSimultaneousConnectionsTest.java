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
package io.fabric8.kubernetes.client.http;

import io.fabric8.kubernetes.client.RequestConfigBuilder;
import io.fabric8.mockwebserver.MockWebServer;
import io.fabric8.mockwebserver.MockWebServerListener;
import io.fabric8.mockwebserver.http.MockResponse;
import io.fabric8.mockwebserver.http.RecordedHttpConnection;
import io.fabric8.mockwebserver.http.Response;
import io.fabric8.mockwebserver.http.WebSocketListener;
import io.fabric8.mockwebserver.vertx.Protocol;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpVersion;
import io.vertx.core.net.NetServerOptions;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;

import java.net.URI;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class AbstractSimultaneousConnectionsTest {

  // TODO:
  //  Should match whatever spec we decide on to guarantee that these simultaneous connections can be handled
  //  by any HttpClient implementation
  private static final int MAX_HTTP_1_CONNECTIONS = 2048; // Should be able to at least make 2048
  private static final int MAX_HTTP_1_WS_CONNECTIONS = 1024; // Should be able to at least make 1024

  private RegisteredConnections registeredConnections;
  private MockWebServer mockWebServer;
  private Vertx vertx;

  private HttpClient.Builder clientBuilder;

  @BeforeEach
  void prepareServerAndBuilder() {
    registeredConnections = new RegisteredConnections();
    mockWebServer = new MockWebServer();
    mockWebServer.addListener(registeredConnections);
    vertx = Vertx.vertx();
    clientBuilder = getHttpClientFactory().newBuilder()
        .connectTimeout(60, TimeUnit.SECONDS);
  }

  @AfterEach
  void stopServer() {
    mockWebServer.shutdown();
    vertx.close();
  }

  protected abstract HttpClient.Factory getHttpClientFactory();

  private void withHttp1() {
    mockWebServer.setProtocols(Collections.singletonList(Protocol.HTTP_1_1));
    mockWebServer.start();
  }

  @Test
  @DisplayName("Should be able to make 2048 simultaneous HTTP/1.x connections before processing the response")
  @DisabledOnOs(OS.WINDOWS)
  public void http1Connections() throws Exception {
    final Collection<CompletableFuture<HttpResponse<AsyncBody>>> asyncResponses = ConcurrentHashMap.newKeySet();
    try (
        var server = new DelayedResponseHttp1Server(vertx, MAX_HTTP_1_CONNECTIONS);
        var client = clientBuilder.tag(new RequestConfigBuilder().withRequestRetryBackoffLimit(0).build()).build()) {
      for (int it = 0; it < MAX_HTTP_1_CONNECTIONS; it++) {
        final HttpRequest request = client.newHttpRequestBuilder()
            .uri(server.uri() + "?" + it)
            .build();
        asyncResponses.add(client.consumeBytes(request, (value, asyncBody) -> asyncBody.consume()));
      }
      server.await();
      assertThat(server.requests)
          .hasSize(MAX_HTTP_1_CONNECTIONS);
      for (HttpServerRequest serverRequest : server.requests) {
        serverRequest.response().setStatusCode(204).end();
      }
      CompletableFuture.allOf(asyncResponses.toArray(new CompletableFuture[0])).get(70, TimeUnit.SECONDS);
      assertThat(asyncResponses)
          .hasSize(MAX_HTTP_1_CONNECTIONS)
          .extracting(CompletableFuture::join)
          .extracting(response -> {
            response.body().consume();
            return response.code();
          })
          .containsOnly(204);
    }
  }

  @Test
  @DisplayName("Should be able to make 1024 simultaneous HTTP connections before upgrading to WebSocket")
  @DisabledOnOs(OS.WINDOWS)
  public void http1WebSocketConnectionsBeforeUpgrade() throws Exception {
    try (var server = new DelayedResponseHttp1Server(vertx, MAX_HTTP_1_WS_CONNECTIONS); var client = clientBuilder.build()) {
      for (int it = 0; it < MAX_HTTP_1_WS_CONNECTIONS; it++) {
        client.newWebSocketBuilder()
            .uri(URI.create(server.uri()))
            .buildAsync(new WebSocket.Listener() {
            });
      }
      server.await();
      assertThat(server.requests)
          .hasSize(MAX_HTTP_1_WS_CONNECTIONS);
      server.requests.forEach(request -> request.response().setStatusCode(101).end());
    }
  }

  @Test
  @DisplayName("Should be able to make 1024 simultaneous upgraded WebSocket connections")
  @DisabledOnOs(OS.WINDOWS)
  public void http1WebSocketConnections() throws Exception {
    withHttp1();
    final Collection<io.fabric8.mockwebserver.http.WebSocket> serverSockets = ConcurrentHashMap.newKeySet();
    final Collection<WebSocket> clientSockets = ConcurrentHashMap.newKeySet();
    final CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
    final CountDownLatch latch = new CountDownLatch(MAX_HTTP_1_WS_CONNECTIONS);
    final MockResponse response = new MockResponse()
        .withWebSocketUpgrade(new WebSocketListener() {
          @Override
          public void onOpen(io.fabric8.mockwebserver.http.WebSocket webSocket, Response response) {
            try {
              cyclicBarrier.await(1, TimeUnit.SECONDS);
            } catch (Exception ignore) {
              // Ignored
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
          .isLessThanOrEqualTo(registeredConnections.activeConnections());
      //      assertThat(clientSockets)
      //          .hasSize(MAX_HTTP_1_WS_CONNECTIONS);
    } finally {
      for (io.fabric8.mockwebserver.http.WebSocket socket : serverSockets) {
        socket.close(1000, "done");
      }
    }
  }

  private static class DelayedResponseHttp1Server implements AutoCloseable {

    private final int connections;
    private final HttpServer httpServer;
    private final Collection<HttpServerRequest> requests;
    private final CountDownLatch connectionLatch;

    private DelayedResponseHttp1Server(Vertx vertx, int connections) throws Exception {
      this.connections = connections;
      requests = ConcurrentHashMap.newKeySet();
      connectionLatch = new CountDownLatch(connections);
      httpServer = vertx.createHttpServer(new HttpServerOptions()
          .setPort(NetServerOptions.DEFAULT_PORT)
          .setAlpnVersions(Collections.singletonList(HttpVersion.HTTP_1_1)));
      httpServer.connectionHandler(event -> connectionLatch.countDown());
      httpServer.requestHandler(requests::add);
      httpServer.listen().toCompletionStage().toCompletableFuture().get(10, TimeUnit.SECONDS);
    }

    @Override
    public void close() throws Exception {
      requests.forEach(request -> request.connection().close());
      requests.clear();
      httpServer.close().toCompletionStage().toCompletableFuture().get(10, TimeUnit.SECONDS);
    }

    private String uri() {
      return String.format("http://localhost:%s/http-1-connections", httpServer.actualPort());
    }

    private void await() {
      try {
        if (!connectionLatch.await(10, TimeUnit.SECONDS)) {
          throw new AssertionError(
              "Failed to await the connection latch, remaining connections to open: " + connectionLatch.getCount());
        }
        Awaitility.await().atMost(5, TimeUnit.SECONDS).until(() -> requests.size() == connections);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        throw new RuntimeException("Failed to await the connection latch (interrupted)", e);
      }
    }
  }

  private static class RegisteredConnections implements MockWebServerListener {

    private final Set<RecordedHttpConnection> connections = ConcurrentHashMap.newKeySet();

    final int activeConnections() {
      return connections.size();
    }

    @Override
    public void onConnection(RecordedHttpConnection connection) {
      connections.add(connection);
      MockWebServerListener.super.onConnection(connection);
    }

    @Override
    public void onConnectionClosed(RecordedHttpConnection connection) {
      connections.remove(connection);
    }
  }
}
