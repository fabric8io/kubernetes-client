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

import io.fabric8.mockwebserver.DefaultMockServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
  void buildAsyncIncludesRequiredHeadersAndPropagatesConfigured() throws Exception {
    server.expect().withPath("/websocket-headers-test")
        .andUpgradeToWebSocket()
        .open()
        .done()
        .always();
    final AtomicBoolean open = new AtomicBoolean(false);
    httpClient.newWebSocketBuilder()
        .header("A-Random-Header", "A-Random-Value")
        .subprotocol("amqp")
        .uri(URI.create(server.url("/websocket-headers-test")))
        .buildAsync(new WebSocket.Listener() {
          @Override
          public void onOpen(WebSocket webSocket) {
            open.set(true);
          }
        }).get(10L, TimeUnit.SECONDS);
    assertThat(open).isTrue();
    assertThat(server.getLastRequest().getHeaders().toMultimap())
        .containsEntry("a-random-header", Collections.singletonList("A-Random-Value"))
        .containsEntry("sec-websocket-protocol", Collections.singletonList("amqp"))
        .containsEntry("connection", Collections.singletonList("Upgrade"))
        .containsEntry("upgrade", Collections.singletonList("websocket"))
        .containsEntry("sec-websocket-version", Collections.singletonList("13"))
        .containsKey("sec-websocket-key");
  }
}
