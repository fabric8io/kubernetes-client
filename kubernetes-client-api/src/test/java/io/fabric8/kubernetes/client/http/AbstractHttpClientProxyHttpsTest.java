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

import io.fabric8.kubernetes.client.internal.SSLUtils;
import io.fabric8.mockwebserver.Context;
import io.fabric8.mockwebserver.DefaultMockServer;
import io.fabric8.mockwebserver.MockWebServer;
import io.fabric8.mockwebserver.ServerRequest;
import io.fabric8.mockwebserver.ServerResponse;
import io.fabric8.mockwebserver.dsl.HttpMethod;
import io.fabric8.mockwebserver.http.Headers;
import io.fabric8.mockwebserver.http.RecordedRequest;
import io.fabric8.mockwebserver.internal.MockDispatcher;
import io.fabric8.mockwebserver.internal.SimpleRequest;
import io.fabric8.mockwebserver.internal.SimpleResponse;
import io.fabric8.mockwebserver.utils.ResponseProvider;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import static io.fabric8.kubernetes.client.utils.HttpClientUtils.basicCredentials;
import static org.assertj.core.api.Assertions.assertThat;

public abstract class AbstractHttpClientProxyHttpsTest {

  private static Map<ServerRequest, Queue<ServerResponse>> responses;
  private static DefaultMockServer proxyServer;

  @BeforeAll
  static void beforeAll() {
    responses = new HashMap<>();
    proxyServer = new DefaultMockServer(new Context(), new MockWebServer(), responses, new MockDispatcher(responses), false);
    proxyServer.start();
  }

  @AfterAll
  static void afterAll() {
    proxyServer.shutdown();
  }

  protected abstract HttpClient.Factory getHttpClientFactory();

  @Test
  @DisplayName("Proxied HttpClient with basic authorization (the password contains a colon) adds required headers to the request")
  protected void proxyConfigurationAddsRequiredHeadersForHttps() throws Exception {
    final AtomicReference<RecordedRequest> initialConnectRequest = new AtomicReference<>();
    final ResponseProvider<String> bodyProvider = new ResponseProvider<String>() {

      @Override
      public String getBody(RecordedRequest request) {
        return "\n";
      }

      @Override
      public void setHeaders(Headers headers) {
      }

      @Override
      public int getStatusCode(RecordedRequest request) {
        if (request.getHeader(StandardHttpHeaders.PROXY_AUTHORIZATION) != null) {
          initialConnectRequest.compareAndSet(null, request);
          return 200;
        }
        return 407;
      }

      @Override
      public Headers getHeaders() {
        return new Headers.Builder().add("Proxy-Authenticate", "Basic").build();
      }

    };
    responses.computeIfAbsent(new SimpleRequest(HttpMethod.CONNECT, "example.com:443"), k -> new ArrayDeque<>())
        .add(new SimpleResponse(true, bodyProvider, null, 0, TimeUnit.SECONDS));
    // Given
    final HttpClient.Builder builder = getHttpClientFactory().newBuilder()
        .sslContext(null, SSLUtils.trustManagers(null, null, true, null, null))
        .proxyAddress(new InetSocketAddress("localhost", proxyServer.getPort()))
        // The colon in the password must survive decoding: the CONNECT only authenticates with credentials configured
        // on the transport, a Proxy-Authorization request header never reaches it
        .proxyAuthorization(basicCredentials("auth", "cr:ed"));
    try (HttpClient client = builder.build()) {
      // When (just send and ignore the response, we only care about the CONNECT request headers)
      client.sendAsync(client.newHttpRequestBuilder().uri("https://example.com/proxied").build(), String.class)
          .exceptionally(t -> null);
      // Then
      // The mock proxy can't complete the TLS handshake through the tunnel, so the request will eventually fail
      // (and be retried). The CONNECT request we care about is recorded as soon as the authenticated tunnel is
      // established, so we await that observable instead of blocking on the request's (irrelevant) final outcome.
      Awaitility.await().atMost(30, TimeUnit.SECONDS).untilAsserted(() -> assertThat(initialConnectRequest)
          .doesNotHaveNullValue()
          .hasValueMatching(r -> r.getHeader("Proxy-Authorization").equals(basicCredentials("auth", "cr:ed"))));
    }
  }

  @Test
  @DisplayName("Proxied HttpClient with other (non Basic) authorization doesn't send it through the tunnel to the HTTPS server")
  protected void proxyConfigurationOtherAuthIsNotSentThroughTunnel() throws Exception {
    final DefaultMockServer origin = new DefaultMockServer(true);
    origin.start();
    try (TunnelingProxy proxy = new TunnelingProxy(origin.getPort())) {
      // Given
      origin.expect().get().withPath("/tunneled").andReturn(200, "tunneled").always();
      origin.expect().withPath("/tunneled-ws").andUpgradeToWebSocket().open().done().always();
      final HttpClient.Builder builder = getHttpClientFactory().newBuilder()
          .sslContext(null, SSLUtils.trustManagers(null, null, true, null, null))
          .proxyAddress(new InetSocketAddress(InetAddress.getLoopbackAddress(), proxy.getPort()))
          .proxyAuthorization("Other kind of auth");
      try (HttpClient client = builder.build()) {
        // When
        final HttpResponse<String> response = client
            .sendAsync(client.newHttpRequestBuilder().uri(origin.url("/tunneled")).build(), String.class)
            // the first HTTPS exchange of a fork is slow to set up, plus the proxy hop
            .get(30L, TimeUnit.SECONDS);
        // Then
        assertThat(response.body()).isEqualTo("tunneled");
        assertThat(origin.getLastRequest().getHeader(StandardHttpHeaders.PROXY_AUTHORIZATION)).isNull();
        // When
        client.newWebSocketBuilder()
            .uri(URI.create(origin.url("/tunneled-ws")))
            .buildAsync(new WebSocket.Listener() {
            }).get(30L, TimeUnit.SECONDS);
        // Then
        assertThat(origin.getLastRequest())
            .returns("/tunneled-ws", RecordedRequest::getPath)
            .returns(null, r -> r.getHeader(StandardHttpHeaders.PROXY_AUTHORIZATION));
      }
      assertThat(proxy.getRequestHeads())
          .as("the requests should have been tunneled through the proxy")
          .isNotEmpty()
          .allMatch(head -> head.startsWith("CONNECT "));
    } finally {
      origin.shutdown();
    }
  }
}
