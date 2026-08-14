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

import io.fabric8.kubernetes.client.http.HttpClient.ProxyType;
import io.fabric8.kubernetes.client.http.HttpResponse;
import io.fabric8.mockwebserver.DefaultMockServer;
import io.fabric8.mockwebserver.utils.ResponseProviders;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.HttpProxy;
import org.eclipse.jetty.client.ProxyConfiguration;
import org.eclipse.jetty.client.Socks4Proxy;
import org.eclipse.jetty.client.Socks5Proxy;
import org.eclipse.jetty.client.api.Authentication;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.eclipse.jetty.websocket.client.WebSocketClient;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static io.fabric8.kubernetes.client.utils.HttpClientUtils.basicCredentials;
import static org.assertj.core.api.Assertions.assertThat;

class JettyHttpClientBuilderTest {

  private static final String PROXY_ORIGIN = "localhost:3128";
  private static final InetSocketAddress PROXY_ADDRESS = new InetSocketAddress("localhost", 3128);

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
              .isNotSameAs(c.getJettyWs().getHttpClient().getTransport()));
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

  @Test
  @DisplayName("tlsServerName, configures SNI provider on SSL context factory")
  void tlsServerNameConfiguresSniProvider() {
    try (var client = factory.newBuilder()
        .sslContext(null, null)
        .tlsServerName("api.example.cluster.local")
        .build()) {
      // Verify the client was built successfully with tlsServerName
      assertThat(client).isNotNull();
      SslContextFactory.Client sslContextFactory = client.getJetty().getSslContextFactory();
      assertThat(sslContextFactory).isNotNull();
      // The SNI provider is set internally, we can verify the factory is properly configured
      assertThat(sslContextFactory.getSNIProvider()).isNotNull();
    }
  }

  @Test
  @DisplayName("build without tlsServerName, uses default SNI provider")
  void buildWithoutTlsServerNameUsesDefaultSniProvider() {
    try (var client = factory.newBuilder().build()) {
      assertThat(client).isNotNull();
      SslContextFactory.Client sslContextFactory = client.getJetty().getSslContextFactory();
      assertThat(sslContextFactory).isNotNull();
    }
  }

  @Test
  @DisplayName("proxyAddress, configures the HTTP proxy on the WebSocket transport as well as the HTTP one")
  void httpProxyIsConfiguredOnBothTransports() {
    try (var client = factory.newBuilder().proxyAddress(PROXY_ADDRESS).build()) {
      assertThat(proxiesOf(client.getJetty()))
          .as("the HTTP transport should be proxied")
          .singleElement().isInstanceOf(HttpProxy.class)
          .returns(PROXY_ORIGIN, proxy -> proxy.getAddress().asString());
      assertThat(proxiesOf(client.getJettyWs().getHttpClient()))
          .as("exec/attach/portForward would otherwise bypass the configured egress proxy")
          .singleElement().isInstanceOf(HttpProxy.class)
          .returns(PROXY_ORIGIN, proxy -> proxy.getAddress().asString());
    }
  }

  @Test
  @DisplayName("proxyType SOCKS4, configures the SOCKS4 proxy on the WebSocket transport as well as the HTTP one")
  void socks4ProxyIsConfiguredOnBothTransports() {
    try (var client = factory.newBuilder().proxyType(ProxyType.SOCKS4).proxyAddress(PROXY_ADDRESS).build()) {
      assertThat(proxiesOf(client.getJetty())).singleElement().isInstanceOf(Socks4Proxy.class);
      assertThat(proxiesOf(client.getJettyWs().getHttpClient())).singleElement().isInstanceOf(Socks4Proxy.class);
    }
  }

  @Test
  @DisplayName("proxyType SOCKS5, configures the SOCKS5 proxy on the WebSocket transport as well as the HTTP one")
  void socks5ProxyIsConfiguredOnBothTransports() {
    try (var client = factory.newBuilder().proxyType(ProxyType.SOCKS5).proxyAddress(PROXY_ADDRESS).build()) {
      assertThat(proxiesOf(client.getJetty())).singleElement().isInstanceOf(Socks5Proxy.class);
      assertThat(proxiesOf(client.getJettyWs().getHttpClient())).singleElement().isInstanceOf(Socks5Proxy.class);
    }
  }

  @Test
  @DisplayName("proxyAuthorization, registers the proxy credentials on the WebSocket transport as well as the HTTP one")
  void proxyAuthenticationIsRegisteredOnBothTransports() {
    try (var client = factory.newBuilder()
        .proxyAddress(PROXY_ADDRESS)
        .proxyAuthorization(basicCredentials("user", "pass"))
        .build()) {
      final URI proxyUri = URI.create("http://" + PROXY_ORIGIN);
      assertThat(client.getJetty().getAuthenticationStore()
          .findAuthentication("Basic", proxyUri, Authentication.ANY_REALM))
          .as("the HTTP transport should be able to answer the proxy's 407")
          .isNotNull();
      assertThat(client.getJettyWs().getHttpClient().getAuthenticationStore()
          .findAuthentication("Basic", proxyUri, Authentication.ANY_REALM))
          .as("the WebSocket transport has its own store, so it needs its own entry to answer the proxy's 407")
          .isNotNull();
    }
  }

  @Test
  @DisplayName("proxyType DIRECT, leaves both transports unproxied even when an address is set")
  void directProxyLeavesBothTransportsUnproxied() {
    try (var client = factory.newBuilder().proxyType(ProxyType.DIRECT).proxyAddress(PROXY_ADDRESS).build()) {
      assertThat(proxiesOf(client.getJetty())).isEmpty();
      assertThat(proxiesOf(client.getJettyWs().getHttpClient())).isEmpty();
    }
  }

  private static List<ProxyConfiguration.Proxy> proxiesOf(HttpClient httpClient) {
    return httpClient.getProxyConfiguration().getProxies();
  }
}
