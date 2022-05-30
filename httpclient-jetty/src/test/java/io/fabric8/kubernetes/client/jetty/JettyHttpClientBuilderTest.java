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
package io.fabric8.kubernetes.client.jetty;

import io.fabric8.kubernetes.client.http.HttpResponse;
import io.fabric8.mockwebserver.DefaultMockServer;
import io.fabric8.mockwebserver.utils.ResponseProviders;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.websocket.client.WebSocketClient;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

class JettyHttpClientBuilderTest {

  private static DefaultMockServer server;
  private static JettyHttpClientFactory factory;

  @BeforeAll
  static void beforeAll() {
    server = new DefaultMockServer(false);
    server.start();
    factory = new JettyHttpClientFactory();
  }

  @AfterAll
  static void afterAll() {
    factory = null;
    server.shutdown();
  }

  @Test
  @DisplayName("build, creates a WS client and an HTTP client with different underlying connector instances")
  void underlyingHttpAndWsClientsDifferentTransports() {
    try (var client = factory.newBuilder().build()) {
      assertThat(client)
        .satisfies(c -> assertThat(c.getJetty())
          .isNotSameAs(c.getJettyWs().getHttpClient())
          .returns(c.getJettyWs().getSslContextFactory(), HttpClient::getSslContextFactory)
          .extracting(HttpClient::getTransport)
          .isNotSameAs(c.getJettyWs().getHttpClient().getTransport())
        );
    }
  }

  @Test
  @DisplayName("build, creates a WS client with disabled Idle timeout")
  void generatedWSClientHasDisabledIdleTimeout() {
    try (var client = factory.newBuilder().build()) {
      assertThat(client)
        .extracting(JettyHttpClient::getJettyWs)
        .extracting(WebSocketClient::getIdleTimeout)
        .isEqualTo(Duration.ZERO);
    }
  }

  @Test
  @DisplayName("client.newBuilder().build(), reuses the jetty and jettyWS shared instances")
  void buildClientBuilderBuildShareWsAndHttpClients() {
    try (var client = factory.newBuilder().build()) {
      final var client2 = client.newBuilder().build();
      assertThat(client2)
        .isInstanceOf(JettyHttpClient.class)
        .asInstanceOf(InstanceOfAssertFactories.type(JettyHttpClient.class))
        .isNotSameAs(client)
        .returns(client.getJetty(), JettyHttpClient::getJetty)
        .returns(client.getJettyWs(), JettyHttpClient::getJettyWs);
    }
  }

  @Test
  @DisplayName("connectTimeout, sets connect timeout for underlying clients")
  void connectTimeout() {
    try (var client = factory.newBuilder().connectTimeout(1337, TimeUnit.MILLISECONDS).build()) {
      assertThat(client)
        .returns(1337L, c -> c.getJetty().getConnectTimeout())
        .returns(1337L, c -> c.getJettyWs().getConnectTimeout());
    }
  }

  @Test
  @DisplayName("followRedirects=false, no redirection")
  void followAllRedirectsDisabled() throws Exception {
    server.expect()
      .withPath("/redirect-me")
      .andReply(ResponseProviders.of(301, "", Collections.singletonMap("Location", "/new-location")))
      .always();
    server.expect()
      .withPath("/new-location")
      .andReturn(200, "You made it!")
      .always();
    try (var client = factory.newBuilder().build()) {
      final var result = client
        .sendAsync(client.newHttpRequestBuilder().uri(server.url("redirect-me")).build(), String.class)
          .get(10, TimeUnit.SECONDS);
      assertThat(result)
        .returns(301, HttpResponse::code);
    }
  }

  @Test
  @DisplayName("followAllRedirects=true, redirected")
  void followAllRedirectsEnabled() throws Exception {
    server.expect()
      .withPath("/redirect-me")
      .andReply(ResponseProviders.of(301, "", Collections.singletonMap("Location", "/new-location")))
      .always();
    server.expect()
      .withPath("/new-location")
      .andReturn(200, "You made it!")
      .always();
    try (var client = factory.newBuilder().followAllRedirects().build()) {
      final var result = client
        .sendAsync(client.newHttpRequestBuilder().uri(server.url("redirect-me")).build(), String.class)
          .get(10, TimeUnit.SECONDS);
      assertThat(result)
        .returns(200, HttpResponse::code)
        .returns("You made it!", r -> {
          try {
            return r.bodyString();
          } catch (IOException ignored) {
            return null;
          }
        });
    }
  }

  @Test
  @DisplayName("build, with preferHttp11, returns a client with an HTTP/1.1 transport")
  void http11() throws Exception {
    try (var client = factory.newBuilder().preferHttp11().build()) {
      client.sendAsync(client.newHttpRequestBuilder().uri(server.url("/http-1-1")).build(), String.class).get();
      assertThat(server.getLastRequest())
          .isNotNull()
          .hasFieldOrPropertyWithValue("requestLine", "GET /http-1-1 HTTP/1.1");
    }
  }
}
