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
import io.fabric8.mockwebserver.http.Headers;
import io.fabric8.mockwebserver.http.RecordedRequest;
import io.fabric8.mockwebserver.utils.ResponseProvider;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.InetSocketAddress;
import java.net.URI;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static io.fabric8.kubernetes.client.utils.HttpClientUtils.basicCredentials;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

@SuppressWarnings("HttpUrlsUsage")
public abstract class AbstractHttpClientProxyTest {

  private static DefaultMockServer proxyServer;

  @BeforeAll
  static void beforeAll() {
    proxyServer = new DefaultMockServer(false);
    proxyServer.start();
  }

  @AfterAll
  static void afterAll() {
    proxyServer.shutdown();
  }

  protected abstract HttpClient.Factory getHttpClientFactory();

  @Test
  @DisplayName("Proxied HttpClient with basic authorization adds required headers to the request")
  protected void proxyConfigurationBasicAuthAddsRequiredHeaders() throws Exception {
    proxyServer.expect().get().withPath("http://example.com/proxied").andReply(new ResponseProvider<Object>() {

      @Override
      public String getBody(RecordedRequest request) {
        return "\n";
      }

      @Override
      public void setHeaders(Headers headers) {
      }

      @Override
      public int getStatusCode(RecordedRequest request) {
        return request.getHeader(StandardHttpHeaders.PROXY_AUTHORIZATION) != null ? 200 : 407;
      }

      @Override
      public Headers getHeaders() {
        return new Headers.Builder().add("Proxy-Authenticate", "Basic").build();
      }

    }).always();
    // Given
    final HttpClient.Builder builder = getHttpClientFactory().newBuilder()
        .proxyAddress(new InetSocketAddress("localhost", proxyServer.getPort()))
        .proxyAuthorization(basicCredentials("auth", "cred"));
    try (HttpClient client = builder.build()) {
      // When
      client.sendAsync(client.newHttpRequestBuilder().uri("http://example.com/proxied").build(), String.class)
          .get(10L, TimeUnit.SECONDS);
      // Then
      assertThat(proxyServer.getLastRequest())
          .extracting(RecordedRequest::getHeaders)
          .returns("example.com", h -> h.get("Host"))
          .returns("Basic YXV0aDpjcmVk", h -> h.get("Proxy-Authorization"));
    }
  }

  @Test
  @DisplayName("Proxied HttpClient routes WebSocket connections through the proxy instead of dialing the origin directly")
  protected void proxyConfigurationIsHonoredByWebSocketConnections() throws Exception {
    // Given
    // The origin host is deliberately unresolvable (reserved .test TLD, RFC 6761), so the client can only ever
    // reach the proxy: were it to bypass the proxy, name resolution would fail and nothing would be recorded.
    // Clients that forward the upgrade in absolute form match one of these expectations and complete the
    // handshake (OkHttp keeps the http scheme, Jetty keeps the ws one); clients that tunnel with CONNECT match
    // neither, but their CONNECT is still recorded, which is all this test asserts on.
    for (String absoluteForm : new String[] { "http://ws.example.test/proxied-ws", "ws://ws.example.test/proxied-ws" }) {
      proxyServer.expect().withPath(absoluteForm)
          .andUpgradeToWebSocket()
          .open()
          .done()
          .always();
    }
    final int requestsBeforeConnect = proxyServer.getRequestCount();
    final CompletableFuture<WebSocket> connected;
    try (HttpClient client = getHttpClientFactory().newBuilder()
        .proxyAddress(new InetSocketAddress("localhost", proxyServer.getPort()))
        .build()) {
      // When
      connected = client.newWebSocketBuilder()
          .uri(URI.create("http://ws.example.test/proxied-ws"))
          .buildAsync(new WebSocket.Listener() {
          });
      // Then
      // Only the fact that the connection is addressed to the proxy is asserted, not that the upgrade completes:
      // implementations legitimately differ here (Vert.x and the JDK tunnel with CONNECT, which DefaultMockServer
      // does not implement, while OkHttp sends an absolute-form GET). What regressed, and what matters for an
      // operator-mandated egress proxy, is whether the proxy is contacted at all.
      await().atMost(30L, TimeUnit.SECONDS)
          .failFast(connected::isCompletedExceptionally)
          .untilAsserted(() -> assertThat(proxyServer.getRequestCount())
              .as("the WebSocket connection should have been addressed to the proxy, not to the origin")
              .isGreaterThan(requestsBeforeConnect));
      assertThat(proxyServer.getLastRequest().getPath())
          .as("the proxy should have been asked to reach the origin")
          .contains("ws.example.test");
    }
    connected.cancel(true);
  }

  @Test
  @DisplayName("Proxied HttpClient with other authorization adds required headers to the request")
  protected void proxyConfigurationOtherAuthAddsRequiredHeaders() throws Exception {
    // Given
    final HttpClient.Builder builder = getHttpClientFactory().newBuilder()
        .proxyAddress(new InetSocketAddress("localhost", proxyServer.getPort()))
        .proxyAuthorization("Other kind of auth");
    try (HttpClient client = builder.build()) {
      // When
      client.sendAsync(client.newHttpRequestBuilder().uri("http://example.com/proxied").build(), String.class)
          .get(10L, TimeUnit.SECONDS);
      // Then
      assertThat(proxyServer.getLastRequest())
          .extracting(RecordedRequest::getHeaders)
          .returns("example.com", h -> h.get("Host"))
          .returns("Other kind of auth", h -> h.get("Proxy-Authorization"));
    }
  }
}
