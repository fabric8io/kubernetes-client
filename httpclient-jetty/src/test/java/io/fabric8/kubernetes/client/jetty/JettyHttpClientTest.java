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
package io.fabric8.kubernetes.client.jetty;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.http.HttpClient.DerivedClientBuilder;
import io.fabric8.kubernetes.client.http.HttpResponse;
import io.fabric8.kubernetes.client.http.StandardHttpClientBuilder;
import io.fabric8.kubernetes.client.http.TlsVersion;
import io.fabric8.kubernetes.client.http.WebSocket;
import io.fabric8.mockwebserver.DefaultMockServer;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.util.component.LifeCycle;
import org.eclipse.jetty.websocket.client.WebSocketClient;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class JettyHttpClientTest {

  private static DefaultMockServer server;

  private HttpClient httpClient;
  private WebSocketClient webSocketClient;

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
    httpClient = new HttpClient();
    webSocketClient = new WebSocketClient(httpClient);
  }

  @AfterEach
  void tearDown() throws Exception {
    webSocketClient.stop();
    httpClient.stop();
  }

  @Test
  @DisplayName("close, should close all underlying clients")
  void closeShouldCloseClients() {
    try (var jettyHttpClient = new JettyHttpClient(
        null, httpClient, webSocketClient)) {
      // When
      jettyHttpClient.close();
      // Then
      assertThat(httpClient.isStopped()).isTrue();
      assertThat(webSocketClient.isStopped()).isTrue();
    }
  }

  @Test
  @DisplayName("close, stops the WebSocket client before the HTTP client it runs on")
  void closeStopsWebSocketClientFirst() throws Exception {
    // Given
    final List<String> stopping = new CopyOnWriteArrayList<>();
    httpClient.addEventListener(stoppingListener(stopping, "http"));
    webSocketClient.addEventListener(stoppingListener(stopping, "websocket"));
    httpClient.start();
    webSocketClient.start();
    try (var jettyHttpClient = new JettyHttpClient(
        null, httpClient, webSocketClient)) {
      // When
      jettyHttpClient.close();
      // Then
      assertThat(stopping).containsExactly("websocket", "http");
    }
  }

  @Test
  @DisplayName("close, stops the HTTP client even if stopping the WebSocket client fails")
  void closeStopsHttpClientWhenWebSocketClientStopFails() throws Exception {
    // Given
    final var failingWebSocketClient = new WebSocketClient(httpClient) {
      @Override
      protected void doStop() throws Exception {
        super.doStop();
        throw new IllegalStateException("WebSocket client stop failed");
      }
    };
    httpClient.start();
    failingWebSocketClient.start();
    try (var jettyHttpClient = new JettyHttpClient(
        null, httpClient, failingWebSocketClient)) {
      // When
      assertThatThrownBy(jettyHttpClient::close)
          .hasStackTraceContaining("WebSocket client stop failed");
      // Then
      assertThat(httpClient.isStopped()).isTrue();
    }
  }

  @Test
  @DisplayName("WebSocket as the first operation, starts the HTTP client first so that the WebSocket client doesn't adopt (and stop) it")
  void webSocketAsFirstOperationKeepsHttpClientLifecycle() throws Exception {
    // Given
    server.expect().withPath("/websocket-first")
        .andUpgradeToWebSocket()
        .open()
        .done()
        .always();
    try (var client = new JettyHttpClientFactory().newBuilder().build()) {
      client.newWebSocketBuilder()
          .uri(URI.create(server.url("/websocket-first")))
          .buildAsync(new WebSocket.Listener() {
          }).get(10L, TimeUnit.SECONDS);
      // When
      client.getJettyWs().stop();
      // Then
      assertThat(client.getJetty().isRunning()).isTrue();
    }
  }

  @Test
  @DisplayName("WebSocket upgrade, keeps Jetty's handshake headers over request headers with the same name")
  void webSocketUpgradeKeepsHandshakeHeaders() throws Exception {
    // Given
    server.expect().withPath("/websocket-handshake-headers")
        .andUpgradeToWebSocket()
        .open()
        .done()
        .always();
    try (var client = new JettyHttpClientFactory().newBuilder().build()) {
      // When
      client.newWebSocketBuilder()
          .header("Connection", "keep-alive")
          .uri(URI.create(server.url("/websocket-handshake-headers")))
          .buildAsync(new WebSocket.Listener() {
          }).get(10L, TimeUnit.SECONDS);
      // Then
      assertThat(server.getLastRequest().getHeaders().headers("Connection")).containsExactly("Upgrade");
    }
  }

  @Test
  @DisplayName("WebSocket upgrade, a request header replaces the Jetty default with the same name (User-Agent) instead of adding a second line")
  void webSocketUpgradeReplacesJettyDefaultHeader() throws Exception {
    // Given
    server.expect().withPath("/websocket-user-agent")
        .andUpgradeToWebSocket()
        .open()
        .done()
        .always();
    try (var client = new JettyHttpClientFactory().newBuilder(Config.empty()).build()) {
      // When
      client.newWebSocketBuilder()
          .uri(URI.create(server.url("/websocket-user-agent")))
          .buildAsync(new WebSocket.Listener() {
          }).get(10L, TimeUnit.SECONDS);
      // Then
      assertThat(server.getLastRequest().getHeaders().headers("User-Agent"))
          .singleElement(InstanceOfAssertFactories.STRING)
          .startsWith("fabric8-kubernetes-client");
    }
  }

  @Test
  @DisplayName("cookies set by a response, aren't sent back on later requests or WebSocket upgrades (no other HttpClient implementation keeps them)")
  void cookiesAreNotKept() throws Exception {
    // Given
    server.expect().withPath("/set-cookie").andReturn(200, "ok").withHeader("Set-Cookie", "session=secret").always();
    server.expect().withPath("/after-cookie").andReturn(200, "ok").always();
    server.expect().withPath("/websocket-after-cookie")
        .andUpgradeToWebSocket()
        .open()
        .done()
        .always();
    try (var client = new JettyHttpClientFactory().newBuilder().build()) {
      client.sendAsync(client.newHttpRequestBuilder().uri(server.url("/set-cookie")).build(), String.class)
          .get(10L, TimeUnit.SECONDS);
      server.getLastRequest();
      // When
      client.sendAsync(client.newHttpRequestBuilder().uri(server.url("/after-cookie")).build(), String.class)
          .get(10L, TimeUnit.SECONDS);
      // Then
      assertThat(server.getLastRequest().getHeader("Cookie")).isNull();
      // When
      client.newWebSocketBuilder()
          .uri(URI.create(server.url("/websocket-after-cookie")))
          .buildAsync(new WebSocket.Listener() {
          }).get(10L, TimeUnit.SECONDS);
      // Then
      assertThat(server.getLastRequest().getHeader("Cookie")).isNull();
    }
  }

  @Test
  @DisplayName("WebSocket#request() from a thread other than Jetty's (as exec streams do), delivers the next message")
  void requestFromForeignThreadDeliversNextMessage() throws Exception {
    // Given
    server.expect().withPath("/request-from-foreign-thread")
        .andUpgradeToWebSocket()
        .open("1", "2", "3")
        .done()
        .always();
    final BlockingQueue<String> received = new LinkedBlockingQueue<>();
    try (var client = new JettyHttpClientFactory().newBuilder().build()) {
      final WebSocket ws = client.newWebSocketBuilder()
          .uri(URI.create(server.url("/request-from-foreign-thread")))
          .buildAsync(new WebSocket.Listener() {
            @Override
            public void onMessage(WebSocket webSocket, String text) {
              received.add(text);
            }
          }).get(10L, TimeUnit.SECONDS);
      final List<String> messages = new ArrayList<>();
      // When
      for (int i = 0; i < 3; i++) {
        messages.add(received.poll(10L, TimeUnit.SECONDS));
        ws.request();
      }
      // Then
      assertThat(messages).containsExactly("1", "2", "3");
    }
  }

  @Test
  @DisplayName("restarted HTTP client, still returns a 401 without challenge with its body (Jetty re-installs its WWW-Authenticate handler on every start)")
  void restartedClientReturnsUnauthorizedBody() throws Exception {
    // Given
    server.expect().withPath("/unauthorized-after-restart").andReturn(401, "Unauthorized").always();
    try (var client = new JettyHttpClientFactory().newBuilder().build()) {
      final var request = client.newHttpRequestBuilder().uri(server.url("/unauthorized-after-restart")).build();
      client.sendAsync(request, String.class).get(10L, TimeUnit.SECONDS);
      client.getJetty().stop();
      // When
      final var response = client.sendAsync(request, String.class).get(10L, TimeUnit.SECONDS);
      // Then
      assertThat(response)
          .returns(401, HttpResponse::code)
          .returns("Unauthorized", HttpResponse::body);
    }
  }

  @Test
  @DisplayName("newBuilder instantiates a DerivedJettyHttpClientBuilder")
  void newBuilderInstantiatesJettyHttpClientBuilderWithSameSettings() throws Exception {
    // Given
    final var originalBuilder = new JettyHttpClientBuilder(null);
    originalBuilder
        .connectTimeout(1337, TimeUnit.SECONDS)
        .tlsVersions(TlsVersion.SSL_3_0)
        .followAllRedirects();
    try (var firstClient = new JettyHttpClient(
        originalBuilder, httpClient, webSocketClient)) {
      // When
      final var result = firstClient.newBuilder();
      // Then
      assertThat(result)
          .isNotNull()
          .isInstanceOf(DerivedClientBuilder.class)
          .isNotSameAs(originalBuilder);
      final var expected = Map.of(
          "getTlsVersions", new TlsVersion[] { TlsVersion.SSL_3_0 },
          "isFollowRedirects", true);
      for (var entry : expected.entrySet()) {
        final var method = StandardHttpClientBuilder.class.getMethod(entry.getKey());
        assertThat(method.invoke(result))
            .isEqualTo(method.invoke(originalBuilder))
            .isEqualTo(entry.getValue());
      }
      var connectTimeout = StandardHttpClientBuilder.class.getDeclaredField("connectTimeout");
      connectTimeout.setAccessible(true);
      assertThat(connectTimeout.get(result)).isEqualTo(Duration.ofSeconds(1337));
      assertThat(connectTimeout.get(originalBuilder)).isEqualTo(Duration.ofSeconds(1337));
      connectTimeout.setAccessible(false);
    }
  }

  private static LifeCycle.Listener stoppingListener(List<String> stopping, String name) {
    return new LifeCycle.Listener() {
      @Override
      public void lifeCycleStopping(LifeCycle event) {
        stopping.add(name);
      }
    };
  }

}
