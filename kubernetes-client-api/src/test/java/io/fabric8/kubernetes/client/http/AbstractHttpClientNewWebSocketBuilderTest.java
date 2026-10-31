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

import io.fabric8.mockwebserver.DefaultMockServer;
import io.fabric8.mockwebserver.internal.WebSocketMessage;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.entry;

public abstract class AbstractHttpClientNewWebSocketBuilderTest {

  private static DefaultMockServer server;

  private HttpClient httpClient;

  @BeforeAll
  static void beforeAll() {
    server = new DefaultMockServer(false);
    server.start();
  }

  @AfterAll
  static void afterAll() {
    server.shutdown();
  }

  @BeforeEach
  void setUp() {
    httpClient = getHttpClientFactory().newBuilder().build();
  }

  @AfterEach
  void tearDown() {
    httpClient.close();
  }

  protected abstract HttpClient.Factory getHttpClientFactory();

  @Test
  void buildAsyncConnectsAndUpgrades() throws Exception {
    server.expect().withPath("/websocket-test")
        .andUpgradeToWebSocket()
        .open()
        .done()
        .always();
    final AtomicBoolean open = new AtomicBoolean(false);
    httpClient.newWebSocketBuilder()
        .uri(URI.create(server.url("/websocket-test")))
        .buildAsync(new WebSocket.Listener() {
          @Override
          public void onOpen(WebSocket webSocket) {
            open.set(true);
          }
        }).get(10L, TimeUnit.SECONDS);
    assertThat(open).isTrue();
  }

  @Test
  void buildAsyncReceivesMultipleMessages() throws Exception {
    server.expect().withPath("/websocket-multiple-message")
        .andUpgradeToWebSocket()
        .open("First", "Second")
        .done()
        .always();
    final CompletableFuture<String> firstReceived = new CompletableFuture<>();
    final CompletableFuture<String> secondReceived = new CompletableFuture<>();
    httpClient.newWebSocketBuilder()
        .uri(URI.create(server.url("/websocket-multiple-message")))
        .buildAsync(new WebSocket.Listener() {
          @Override
          public void onMessage(WebSocket webSocket, String text) {
            if (!firstReceived.complete(text)) {
              secondReceived.complete(text);
            }
            webSocket.request();
          }
        }).get(10L, TimeUnit.SECONDS);
    assertThat(firstReceived).succeedsWithin(10, TimeUnit.SECONDS).isEqualTo("First");
    assertThat(secondReceived).succeedsWithin(10, TimeUnit.SECONDS).isEqualTo("Second");
  }

  @Test
  @DisplayName("buildAsync, receives every binary message when the listener requests one after each")
  void buildAsyncReceivesMultipleBinaryMessages() throws Exception {
    server.expect().withPath("/websocket-multiple-binary-message")
        .andUpgradeToWebSocket()
        .open(new WebSocketMessage(new byte[] { 1 }), new WebSocketMessage(new byte[] { 2 }),
            new WebSocketMessage(new byte[] { 3 }))
        .done()
        .always();
    final BlockingQueue<Byte> received = new LinkedBlockingQueue<>();
    httpClient.newWebSocketBuilder()
        .uri(URI.create(server.url("/websocket-multiple-binary-message")))
        .buildAsync(new WebSocket.Listener() {
          @Override
          public void onMessage(WebSocket webSocket, ByteBuffer bytes) {
            received.add(bytes.get());
            webSocket.request();
          }
        }).get(10L, TimeUnit.SECONDS);
    final List<Byte> messages = new ArrayList<>();
    for (int i = 0; i < 3; i++) {
      messages.add(received.poll(10L, TimeUnit.SECONDS));
    }
    assertThat(messages).containsExactly((byte) 1, (byte) 2, (byte) 3);
  }

  @Test
  void buildAsyncConnectsAndCloses() throws Exception {
    server.expect().withPath("/websocket-on-close")
        .andUpgradeToWebSocket()
        .open()
        .expectSentWebSocketMessage("NEVER RECEIVED; JUST TO KEEP THE CONNECTION OPEN")
        .andEmit("OK")
        .once()
        .done()
        .always();
    final CompletableFuture<String> closeMessage = new CompletableFuture<>();
    httpClient.newWebSocketBuilder()
        .uri(URI.create(server.url("/websocket-on-close")))
        .buildAsync(new WebSocket.Listener() {
          public void onOpen(WebSocket webSocket) {
            webSocket.sendClose(1000, "Closing from client");
          }

          @Override
          public void onClose(WebSocket webSocket, int code, String reason) {
            closeMessage.complete(reason);
          }
        }).get(10L, TimeUnit.SECONDS);
    assertThat(closeMessage)
        .succeedsWithin(10, TimeUnit.SECONDS)
        .asString()
        .isEqualTo("Closing from client");
  }

  @Test
  void buildAsyncCantUpgradeThrowsWebSocketHandshakeException() {
    final CompletableFuture<WebSocket> future = httpClient.newWebSocketBuilder()
        .uri(URI.create(server.url("/not-found")))
        .buildAsync(new WebSocket.Listener() {
        });
    assertThatThrownBy(() -> future.get(10L, TimeUnit.SECONDS))
        .isInstanceOf(ExecutionException.class)
        .hasCauseInstanceOf(WebSocketHandshakeException.class);
  }

  @Test
  void buildAsyncIncludesRequiredHeaders() throws Exception {
    server.expect().withPath("/websocket-headers-test")
        .andUpgradeToWebSocket()
        .open()
        .waitFor(50L).andEmit("OK")
        .done()
        .always();
    httpClient.newWebSocketBuilder()
        .uri(URI.create(server.url("/websocket-headers-test")))
        .buildAsync(new WebSocket.Listener() {
        }).get(10L, TimeUnit.SECONDS);
    assertThat(server.getLastRequest().getHeaders().toMultimap())
        .containsEntry("upgrade", Collections.singletonList("websocket"))
        .containsEntry("sec-websocket-version", Collections.singletonList("13"))
        .containsKey("sec-websocket-key")
        .containsAnyOf(entry("connection", Collections.singletonList("Upgrade")),
            entry("connection", Collections.singletonList("upgrade")));
  }

  @Test
  void buildAsyncPropagatesConfiguredHeaders() throws Exception {
    server.expect().withPath("/websocket-headers-test")
        .andUpgradeToWebSocket()
        .open()
        .done()
        .always();
    httpClient.newWebSocketBuilder()
        .header("A-Random-Header", "A-Random-Value")
        .uri(URI.create(server.url("/websocket-headers-test")))
        .buildAsync(new WebSocket.Listener() {
        }).get(10L, TimeUnit.SECONDS);
    assertThat(server.getLastRequest().getHeaders().toMultimap())
        .containsEntry("a-random-header", Collections.singletonList("A-Random-Value"));
  }

  @Test
  @DisplayName("buildAsync, sends a multi-valued header as one header line per value")
  void buildAsyncPropagatesMultiValuedHeaderAsSeparateLines() throws Exception {
    server.expect().withPath("/websocket-multi-valued-header-test")
        .andUpgradeToWebSocket()
        .open()
        .done()
        .always();
    httpClient.newWebSocketBuilder()
        .header("Impersonate-Group", "group-1")
        .header("Impersonate-Group", "group-2")
        .uri(URI.create(server.url("/websocket-multi-valued-header-test")))
        .buildAsync(new WebSocket.Listener() {
        }).get(10L, TimeUnit.SECONDS);
    assertThat(server.getLastRequest().getHeaders().headers("Impersonate-Group"))
        .as("a single joined line reads as one group named 'group-1, group-2' on the API server")
        .containsExactly("group-1", "group-2");
  }

  @Test
  void buildAsyncIncludesSubprotocolHeader() throws Exception {
    server.expect().withPath("/websocket-headers-test")
        .andUpgradeToWebSocket()
        .open()
        .done()
        .always();
    httpClient.newWebSocketBuilder()
        .subprotocol("amqp")
        .uri(URI.create(server.url("/websocket-headers-test")))
        .buildAsync(new WebSocket.Listener() {
        })
        .handle((w, t) -> null /* ignore handshake errors (Vert.x) - only interested in headers */)
        .get(10L, TimeUnit.SECONDS);
    assertThat(server.getLastRequest().getHeaders().toMultimap())
        .containsEntry("sec-websocket-protocol", Collections.singletonList("amqp"));
  }

  @Test
  void buildAsyncPreservesHandshakeExceptionWhenUpgradeFails() {
    server.expect().withPath("/not-a-websocket").andReturn(200, "not a websocket").always();
    final CompletableFuture<WebSocket> ws = httpClient.newWebSocketBuilder()
        .uri(URI.create(server.url("/not-a-websocket")))
        .buildAsync(new WebSocket.Listener() {
        });
    assertThatThrownBy(() -> ws.get(10L, TimeUnit.SECONDS))
        .isInstanceOf(ExecutionException.class)
        .cause()
        .asInstanceOf(InstanceOfAssertFactories.type(WebSocketHandshakeException.class))
        .extracting(WebSocketHandshakeException::getResponse)
        .extracting(HttpResponse::code)
        .isEqualTo(200);
  }

}
