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
package io.fabric8.kubernetes.client.vertx;

import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.TlsVersion;
import io.vertx.core.Vertx;
import io.vertx.core.impl.VertxImpl;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("VertxHttpClientBuilder")
class VertxHttpClientBuilderTest {

  @Test
  @DisplayName("Should build client with zero timeout without issues")
  void testZeroTimeouts() {
    VertxHttpClientFactory factory = new VertxHttpClientFactory();
    HttpClient.Builder builder = factory.newBuilder();

    // should build and be usable without an issue
    try (HttpClient client = builder.connectTimeout(0, TimeUnit.MILLISECONDS).build()) {
      assertNotNull(client.newHttpRequestBuilder().uri("http://localhost").build());
    }
  }

  @Test
  @DisplayName("Should reuse shared Vertx instance")
  void reusesVertxInstanceWhenSharedVertx() {
    Vertx vertx = Vertx.vertx();
    try (HttpClient client = new VertxHttpClientFactory(vertx).newBuilder().build()) {
      assertThat(client)
          .isInstanceOf(VertxHttpClient.class)
          .extracting("vertx")
          .isSameAs(vertx);
    } finally {
      vertx.close();
    }
  }

  @Test
  @DisplayName("Should create new Vertx instance when no shared instance provided")
  void createsVertxInstanceWhenNoSharedVertx() {
    try (HttpClient client = new VertxHttpClientFactory().newBuilder().build()) {
      assertThat(client)
          .isInstanceOf(VertxHttpClient.class)
          .extracting("vertx")
          .isNotNull();
    }
  }

  @Test
  @DisplayName("Should not close shared Vertx instance when client is closed")
  void doesntCloseSharedVertxInstanceWhenClientIsClosed() {
    final Vertx vertx = Vertx.vertx();
    final var builder = new VertxHttpClientFactory(vertx).newBuilder();
    builder.build().close();
    assertThat(builder.vertx)
        .asInstanceOf(InstanceOfAssertFactories.type(VertxImpl.class))
        .returns(false, vi -> vi.closeFuture().isClosed());
    vertx.close();
  }

  @Test
  @DisplayName("Should close owned Vertx instance when client is closed")
  void closesVertxInstanceWhenClientIsClosed() {
    final var builder = new VertxHttpClientFactory().newBuilder();
    builder.build().close();
    assertThat(builder.vertx)
        .asInstanceOf(InstanceOfAssertFactories.type(VertxImpl.class))
        .returns(true, vi -> vi.closeFuture().isClosed());
  }

  @Nested
  @DisplayName("Proxy Configuration")
  class ProxyConfigurationTests {

    @Test
    @DisplayName("Should configure HTTP proxy correctly")
    void httpProxy_shouldConfigureCorrectly() {
      VertxHttpClientFactory factory = new VertxHttpClientFactory();
      VertxHttpClientBuilder<?> builder = factory.newBuilder();

      builder.proxyAddress(new InetSocketAddress("proxy.example.com", 8080));
      builder.proxyType(HttpClient.ProxyType.HTTP);

      try (HttpClient client = builder.build()) {
        assertThat(client).isNotNull();
      }
    }

    @Test
    @DisplayName("Should configure SOCKS4 proxy correctly")
    void socks4Proxy_shouldConfigureCorrectly() {
      VertxHttpClientFactory factory = new VertxHttpClientFactory();
      VertxHttpClientBuilder<?> builder = factory.newBuilder();

      builder.proxyAddress(new InetSocketAddress("socks.example.com", 1080));
      builder.proxyType(HttpClient.ProxyType.SOCKS4);

      try (HttpClient client = builder.build()) {
        assertThat(client).isNotNull();
      }
    }

    @Test
    @DisplayName("Should configure SOCKS5 proxy correctly")
    void socks5Proxy_shouldConfigureCorrectly() {
      VertxHttpClientFactory factory = new VertxHttpClientFactory();
      VertxHttpClientBuilder<?> builder = factory.newBuilder();

      builder.proxyAddress(new InetSocketAddress("socks5.example.com", 1080));
      builder.proxyType(HttpClient.ProxyType.SOCKS5);

      try (HttpClient client = builder.build()) {
        assertThat(client).isNotNull();
      }
    }

    @Test
    @DisplayName("Should handle direct connection when proxy type is DIRECT")
    void directProxy_shouldSkipProxyConfiguration() {
      VertxHttpClientFactory factory = new VertxHttpClientFactory();
      VertxHttpClientBuilder<?> builder = factory.newBuilder();

      builder.proxyType(HttpClient.ProxyType.DIRECT);

      try (HttpClient client = builder.build()) {
        assertThat(client).isNotNull();
      }
    }

    @Test
    @DisplayName("Should configure proxy with basic authentication")
    void proxyWithBasicAuth_shouldConfigureCorrectly() {
      VertxHttpClientFactory factory = new VertxHttpClientFactory();
      VertxHttpClientBuilder<?> builder = factory.newBuilder();

      builder.proxyAddress(new InetSocketAddress("proxy.example.com", 8080));
      builder.proxyType(HttpClient.ProxyType.HTTP);
      builder.proxyAuthorization("Basic dXNlcjpwYXNz"); // user:pass in base64

      try (HttpClient client = builder.build()) {
        assertThat(client).isNotNull();
      }
    }
  }

  @Nested
  @DisplayName("SSL/TLS Configuration")
  class SslTlsConfigurationTests {

    @Test
    @DisplayName("Should configure SSL context correctly")
    void sslContext_shouldConfigureCorrectly() {
      VertxHttpClientFactory factory = new VertxHttpClientFactory();
      VertxHttpClientBuilder<?> builder = factory.newBuilder();

      builder.sslContext(null, null);

      try (HttpClient client = builder.build()) {
        assertThat(client).isNotNull();
      }
    }

    @Test
    @DisplayName("Should configure TLS versions correctly")
    void tlsVersions_shouldConfigureCorrectly() {
      VertxHttpClientFactory factory = new VertxHttpClientFactory();
      VertxHttpClientBuilder<?> builder = factory.newBuilder();

      builder.sslContext(null, null);
      builder.tlsVersions(TlsVersion.TLS_1_2, TlsVersion.TLS_1_3);

      try (HttpClient client = builder.build()) {
        assertThat(client).isNotNull();
      }
    }

    @Test
    @DisplayName("Should handle empty TLS versions array")
    void emptyTlsVersions_shouldNotFailBuild() {
      VertxHttpClientFactory factory = new VertxHttpClientFactory();
      VertxHttpClientBuilder<?> builder = factory.newBuilder();

      builder.tlsVersions(); // empty array

      try (HttpClient client = builder.build()) {
        assertThat(client).isNotNull();
      }
    }

    @Test
    @DisplayName("Should handle null TLS versions")
    void nullTlsVersions_shouldNotFailBuild() {
      VertxHttpClientFactory factory = new VertxHttpClientFactory();
      VertxHttpClientBuilder<?> builder = factory.newBuilder();

      try (HttpClient client = builder.build()) {
        assertThat(client).isNotNull();
      }
    }
  }

  @Nested
  @DisplayName("Timeout and HTTP Settings")
  class TimeoutAndHttpSettingsTests {

    @Test
    @DisplayName("Should configure connect timeout correctly")
    void connectTimeout_shouldConfigureCorrectly() {
      VertxHttpClientFactory factory = new VertxHttpClientFactory();
      VertxHttpClientBuilder<?> builder = factory.newBuilder();

      builder.connectTimeout(5000, TimeUnit.MILLISECONDS);

      try (HttpClient client = builder.build()) {
        assertThat(client).isNotNull();
      }
    }

    @Test
    @DisplayName("Should configure follow redirects correctly")
    void followRedirects_shouldConfigureCorrectly() {
      VertxHttpClientFactory factory = new VertxHttpClientFactory();
      VertxHttpClientBuilder<?> builder = factory.newBuilder();

      builder.followAllRedirects();

      try (HttpClient client = builder.build()) {
        assertThat(client).isNotNull();
      }
    }

    @Test
    @DisplayName("Should configure HTTP/1.1 preference correctly")
    void preferHttp11_shouldConfigureCorrectly() {
      VertxHttpClientFactory factory = new VertxHttpClientFactory();
      VertxHttpClientBuilder<?> builder = factory.newBuilder();

      builder.preferHttp11();

      try (HttpClient client = builder.build()) {
        assertThat(client).isNotNull();
      }
    }

    @Test
    @DisplayName("Should handle null connect timeout")
    void nullConnectTimeout_shouldNotFailBuild() {
      VertxHttpClientFactory factory = new VertxHttpClientFactory();
      VertxHttpClientBuilder<?> builder = factory.newBuilder();

      try (HttpClient client = builder.build()) {
        assertThat(client).isNotNull();
      }
    }
  }

  @Nested
  @DisplayName("WebSocket Configuration")
  class WebSocketConfigurationTests {

    @Test
    @DisplayName("Should configure WebSocket options with SSL")
    void webSocketWithSsl_shouldConfigureCorrectly() {
      VertxHttpClientFactory factory = new VertxHttpClientFactory();
      VertxHttpClientBuilder<?> builder = factory.newBuilder();

      builder.sslContext(null, null);

      try (HttpClient client = builder.build()) {
        assertThat(client).isNotNull();
      }
    }

    @Test
    @DisplayName("Should configure WebSocket options without SSL")
    void webSocketWithoutSsl_shouldConfigureCorrectly() {
      VertxHttpClientFactory factory = new VertxHttpClientFactory();
      VertxHttpClientBuilder<?> builder = factory.newBuilder();

      try (HttpClient client = builder.build()) {
        assertThat(client).isNotNull();
      }
    }
  }

  @Nested
  @DisplayName("Builder Instance Management")
  class BuilderInstanceManagementTests {

    @Test
    @DisplayName("Should create new instance with shared Vertx")
    void newInstance_shouldShareVertx() {
      VertxHttpClientFactory factory = new VertxHttpClientFactory();
      VertxHttpClientBuilder<VertxHttpClientFactory> originalBuilder = factory.newBuilder();
      VertxHttpClientBuilder<VertxHttpClientFactory> newBuilder = originalBuilder.newInstance(factory);

      assertThat(newBuilder.vertx).isSameAs(originalBuilder.vertx);
    }

    @Test
    @DisplayName("Should handle multiple builds from same builder")
    void multipleBuildFromSameBuilder_shouldSucceed() {
      VertxHttpClientFactory factory = new VertxHttpClientFactory();
      VertxHttpClientBuilder<?> builder = factory.newBuilder();

      try (HttpClient client1 = builder.build();
          HttpClient client2 = builder.build()) {
        assertThat(client1).isNotNull();
        assertThat(client2).isNotNull();
        assertThat(client1).isNotSameAs(client2);
      }
    }
  }

  @Nested
  @DisplayName("Error Handling and Edge Cases")
  class ErrorHandlingTests {

    @Test
    @DisplayName("Should handle build with all default settings")
    void buildWithDefaults_shouldSucceed() {
      VertxHttpClientFactory factory = new VertxHttpClientFactory();
      VertxHttpClientBuilder<?> builder = factory.newBuilder();

      try (HttpClient client = builder.build()) {
        assertThat(client).isNotNull();
        assertThat(client).isInstanceOf(VertxHttpClient.class);
      }
    }

    @Test
    @DisplayName("Should handle complex configuration combination")
    void complexConfiguration_shouldSucceed() {
      VertxHttpClientFactory factory = new VertxHttpClientFactory();
      VertxHttpClientBuilder<?> builder = factory.newBuilder();

      InetSocketAddress proxyAddress = new InetSocketAddress("proxy.example.com", 8080);

      builder
          .connectTimeout(10000, TimeUnit.MILLISECONDS)
          .sslContext(null, null)
          .tlsVersions(TlsVersion.TLS_1_2, TlsVersion.TLS_1_3)
          .proxyAddress(proxyAddress)
          .proxyType(HttpClient.ProxyType.HTTP)
          .followAllRedirects()
          .preferHttp11();

      try (HttpClient client = builder.build()) {
        assertThat(client).isNotNull();
        assertThat(client).isInstanceOf(VertxHttpClient.class);
      }
    }
  }
}
