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
package io.fabric8.kubernetes.client.vertx5.infrastructure;

import io.fabric8.kubernetes.client.vertx5.core.ConnectionConfig;
import io.fabric8.kubernetes.client.vertx5.core.ProxyConfig;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpClient;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.net.InetSocketAddress;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;

import javax.net.ssl.SSLContext;

import static io.vertx.core.impl.SysProps.DISABLE_DNS_RESOLVER;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("VertxConnectionFactory infrastructure")
class VertxConnectionFactoryTest {

  private Vertx vertx;

  @BeforeEach
  void setUp() {
    // Save original system property if it exists
    // Note: We'll test the DNS resolver property separately
  }

  @AfterEach
  void tearDown() {
    if (vertx != null) {
      vertx.close();
    }
  }

  @Nested
  @DisplayName("Vertx instance creation")
  class VertxInstanceCreation {

    @Test
    @DisplayName("should create Vertx instance successfully")
    void shouldCreateVertxInstanceSuccessfully() {
      vertx = VertxConnectionFactory.createVertxInstance();

      assertNotNull(vertx);
    }

    @Test
    @DisplayName("should configure DNS resolver property during creation")
    void shouldConfigureDnsResolverPropertyDuringCreation() {
      final String originalValue = DISABLE_DNS_RESOLVER.get();

      try {
        vertx = VertxConnectionFactory.createVertxInstance();

        // The property should be restored after creation
        assertEquals(originalValue, DISABLE_DNS_RESOLVER.get());
      } finally {
        // Ensure property is restored even if test fails
        if (originalValue == null) {
          System.clearProperty(DISABLE_DNS_RESOLVER.name);
        } else {
          System.setProperty(DISABLE_DNS_RESOLVER.name, originalValue);
        }
      }
    }

    @Test
    @DisplayName("should handle existing DNS resolver property")
    void shouldHandleExistingDnsResolverProperty() {
      final String testValue = "test-value";
      System.setProperty(DISABLE_DNS_RESOLVER.name, testValue);

      try {
        vertx = VertxConnectionFactory.createVertxInstance();

        // Original value should be restored
        assertEquals(testValue, DISABLE_DNS_RESOLVER.get());
      } finally {
        System.clearProperty(DISABLE_DNS_RESOLVER.name);
      }
    }

    @Test
    @DisplayName("should create multiple independent Vertx instances")
    void shouldCreateMultipleIndependentVertxInstances() {
      final Vertx vertx1 = VertxConnectionFactory.createVertxInstance();
      final Vertx vertx2 = VertxConnectionFactory.createVertxInstance();

      try {
        assertAll("Multiple instances",
            () -> assertNotNull(vertx1),
            () -> assertNotNull(vertx2),
            () -> assertNotEquals(vertx1, vertx2));
      } finally {
        vertx1.close();
        vertx2.close();
      }
    }
  }

  @Nested
  @DisplayName("HTTP client creation")
  class HttpClientCreation {

    @BeforeEach
    void setUpVertx() {
      vertx = VertxConnectionFactory.createVertxInstance();
    }

    @Test
    @DisplayName("should create HTTP client with minimal configuration")
    void shouldCreateHttpClientWithMinimalConfiguration() {
      final ConnectionConfig config = ConnectionConfig.builder().build();

      final HttpClient httpClient = VertxConnectionFactory.createHttpClient(vertx, config);

      assertNotNull(httpClient);
    }

    @Test
    @DisplayName("should create HTTP client with custom timeouts")
    void shouldCreateHttpClientWithCustomTimeouts() {
      final ConnectionConfig config = ConnectionConfig.builder()
          .connectTimeout(Duration.ofSeconds(5))
          .idleTimeout(Duration.ofMinutes(2))
          .build();

      final HttpClient httpClient = VertxConnectionFactory.createHttpClient(vertx, config);

      assertNotNull(httpClient);
    }

    @Test
    @DisplayName("should create HTTP client with custom pool size")
    void shouldCreateHttpClientWithCustomPoolSize() {
      final ConnectionConfig config = ConnectionConfig.builder()
          .maxPoolSize(50)
          .build();

      final HttpClient httpClient = VertxConnectionFactory.createHttpClient(vertx, config);

      assertNotNull(httpClient);
    }

    @Test
    @DisplayName("should create HTTP client with HTTP/1.1 preference")
    void shouldCreateHttpClientWithHttp11Preference() {
      final ConnectionConfig config = ConnectionConfig.builder()
          .preferHttp11(true)
          .build();

      final HttpClient httpClient = VertxConnectionFactory.createHttpClient(vertx, config);

      assertNotNull(httpClient);
    }

    @Test
    @DisplayName("should create HTTP client with SSL configuration")
    void shouldCreateHttpClientWithSslConfiguration() throws NoSuchAlgorithmException {
      final SSLContext sslContext = SSLContext.getDefault();
      final String[] tlsVersions = { "TLSv1.2", "TLSv1.3" };

      final ConnectionConfig config = ConnectionConfig.builder()
          .sslContext(sslContext)
          .tlsVersions(tlsVersions)
          .build();

      final HttpClient httpClient = VertxConnectionFactory.createHttpClient(vertx, config);

      assertNotNull(httpClient);
    }

    @Test
    @DisplayName("should create HTTP client with proxy configuration")
    void shouldCreateHttpClientWithProxyConfiguration() {
      final ProxyConfig proxyConfig = ProxyConfig.builder()
          .type(io.fabric8.kubernetes.client.http.HttpClient.ProxyType.HTTP)
          .address(new InetSocketAddress("proxy.example.com", 8080))
          .username("proxyuser")
          .password("proxypass")
          .build();

      final ConnectionConfig config = ConnectionConfig.builder()
          .proxy(proxyConfig)
          .build();

      final HttpClient httpClient = VertxConnectionFactory.createHttpClient(vertx, config);

      assertNotNull(httpClient);
    }

    @Test
    @DisplayName("should handle all proxy types")
    void shouldHandleAllProxyTypes() {
      final io.fabric8.kubernetes.client.http.HttpClient.ProxyType[] proxyTypes = {
          io.fabric8.kubernetes.client.http.HttpClient.ProxyType.HTTP,
          io.fabric8.kubernetes.client.http.HttpClient.ProxyType.SOCKS4,
          io.fabric8.kubernetes.client.http.HttpClient.ProxyType.SOCKS5
      };

      for (final io.fabric8.kubernetes.client.http.HttpClient.ProxyType proxyType : proxyTypes) {
        final ProxyConfig proxyConfig = ProxyConfig.builder()
            .type(proxyType)
            .address(new InetSocketAddress("proxy.example.com", 8080))
            .build();

        final ConnectionConfig config = ConnectionConfig.builder()
            .proxy(proxyConfig)
            .build();

        assertDoesNotThrow(() -> VertxConnectionFactory.createHttpClient(vertx, config));
      }
    }

    @Test
    @DisplayName("should create HTTP client with complete configuration")
    void shouldCreateHttpClientWithCompleteConfiguration() throws NoSuchAlgorithmException {
      final SSLContext sslContext = SSLContext.getDefault();
      final String[] tlsVersions = { "TLSv1.2", "TLSv1.3" };
      final ProxyConfig proxyConfig = ProxyConfig.builder()
          .type(io.fabric8.kubernetes.client.http.HttpClient.ProxyType.HTTP)
          .address(new InetSocketAddress("proxy.example.com", 8080))
          .username("proxyuser")
          .password("proxypass")
          .build();

      final ConnectionConfig config = ConnectionConfig.builder()
          .connectTimeout(Duration.ofSeconds(5))
          .idleTimeout(Duration.ofMinutes(2))
          .maxPoolSize(100)
          .preferHttp11(true)
          .sslContext(sslContext)
          .tlsVersions(tlsVersions)
          .proxy(proxyConfig)
          .build();

      final HttpClient httpClient = VertxConnectionFactory.createHttpClient(vertx, config);

      assertNotNull(httpClient);
    }
  }

  @Nested
  @DisplayName("Configuration validation")
  class ConfigurationValidation {

    @BeforeEach
    void setUpVertx() {
      vertx = VertxConnectionFactory.createVertxInstance();
    }

    @Test
    @DisplayName("should handle null SSL context gracefully")
    void shouldHandleNullSslContextGracefully() {
      final ConnectionConfig config = ConnectionConfig.builder()
          .sslContext(null)
          .build();

      assertDoesNotThrow(() -> VertxConnectionFactory.createHttpClient(vertx, config));
    }

    @Test
    @DisplayName("should handle empty TLS versions array")
    void shouldHandleEmptyTlsVersionsArray() throws NoSuchAlgorithmException {
      final SSLContext sslContext = SSLContext.getDefault();
      final ConnectionConfig config = ConnectionConfig.builder()
          .sslContext(sslContext)
          .tlsVersions(new String[0])
          .build();

      assertDoesNotThrow(() -> VertxConnectionFactory.createHttpClient(vertx, config));
    }

    @Test
    @DisplayName("should handle null proxy configuration")
    void shouldHandleNullProxyConfiguration() {
      final ConnectionConfig config = ConnectionConfig.builder()
          .proxy(null)
          .build();

      assertDoesNotThrow(() -> VertxConnectionFactory.createHttpClient(vertx, config));
    }

    @Test
    @DisplayName("should reject null Vertx instance")
    void shouldRejectNullVertxInstance() {
      final ConnectionConfig config = ConnectionConfig.builder().build();

      assertThrows(NullPointerException.class, () -> VertxConnectionFactory.createHttpClient(null, config));
    }

    @Test
    @DisplayName("should reject null configuration")
    void shouldRejectNullConfiguration() {
      assertThrows(NullPointerException.class, () -> VertxConnectionFactory.createHttpClient(vertx, null));
    }
  }

  @Nested
  @DisplayName("Resource management")
  class ResourceManagement {

    @Test
    @DisplayName("should create clients that can be closed independently")
    void shouldCreateClientsThatCanBeClosedIndependently() {
      vertx = VertxConnectionFactory.createVertxInstance();
      final ConnectionConfig config = ConnectionConfig.builder().build();

      final HttpClient client1 = VertxConnectionFactory.createHttpClient(vertx, config);
      final HttpClient client2 = VertxConnectionFactory.createHttpClient(vertx, config);

      assertAll("Independent clients",
          () -> assertNotNull(client1),
          () -> assertNotNull(client2),
          () -> assertNotEquals(client1, client2));

      // Should be able to close clients independently
      assertDoesNotThrow(client1::close);
      assertDoesNotThrow(client2::close);
    }

    @Test
    @DisplayName("should handle client creation after Vertx closure")
    void shouldHandleClientCreationAfterVertxClosure() {
      vertx = VertxConnectionFactory.createVertxInstance();
      vertx.close();

      final ConnectionConfig config = ConnectionConfig.builder().build();

      // Creating a client with a closed Vertx may succeed in Vert.x 5
      // The behavior depends on Vert.x implementation
      assertDoesNotThrow(() -> VertxConnectionFactory.createHttpClient(vertx, config));
    }
  }
}