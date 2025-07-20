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
package io.fabric8.kubernetes.client.vertx5.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.net.InetSocketAddress;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;

import javax.net.ssl.SSLContext;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("ConnectionConfig value object")
class ConnectionConfigTest {

  @Nested
  @DisplayName("Builder pattern validation")
  class BuilderPatternValidation {

    @Test
    @DisplayName("should create default configuration with required fields")
    void shouldCreateDefaultConfiguration() {
      final ConnectionConfig config = ConnectionConfig.builder().build();

      assertAll("Default configuration",
          () -> assertEquals(Duration.ofSeconds(10), config.getConnectTimeout()),
          () -> assertEquals(Duration.ofSeconds(30), config.getIdleTimeout()),
          () -> assertEquals(8192, config.getMaxPoolSize()),
          () -> assertFalse(config.isPreferHttp11()),
          () -> assertNull(config.getSslContext()),
          () -> assertNull(config.getTlsVersions()),
          () -> assertNull(config.getProxy()));
    }

    @Test
    @DisplayName("should create configuration with custom timeouts")
    void shouldCreateConfigurationWithCustomTimeouts() {
      final Duration connectTimeout = Duration.ofSeconds(5);
      final Duration idleTimeout = Duration.ofMinutes(2);

      final ConnectionConfig config = ConnectionConfig.builder()
          .connectTimeout(connectTimeout)
          .idleTimeout(idleTimeout)
          .build();

      assertAll("Custom timeouts",
          () -> assertEquals(connectTimeout, config.getConnectTimeout()),
          () -> assertEquals(idleTimeout, config.getIdleTimeout()));
    }

    @Test
    @DisplayName("should create configuration with SSL context")
    void shouldCreateConfigurationWithSslContext() throws NoSuchAlgorithmException {
      final SSLContext sslContext = SSLContext.getDefault();

      final ConnectionConfig config = ConnectionConfig.builder()
          .sslContext(sslContext)
          .build();

      assertEquals(sslContext, config.getSslContext());
    }

    @Test
    @DisplayName("should create configuration with TLS versions")
    void shouldCreateConfigurationWithTlsVersions() {
      final String[] tlsVersions = { "TLSv1.2", "TLSv1.3" };

      final ConnectionConfig config = ConnectionConfig.builder()
          .tlsVersions(tlsVersions)
          .build();

      assertArrayEquals(tlsVersions, config.getTlsVersions());
    }

    @Test
    @DisplayName("should create configuration with proxy settings")
    void shouldCreateConfigurationWithProxy() {
      final ProxyConfig proxy = ProxyConfig.builder()
          .type(io.fabric8.kubernetes.client.http.HttpClient.ProxyType.HTTP)
          .address(new InetSocketAddress("proxy.example.com", 8080))
          .build();

      final ConnectionConfig config = ConnectionConfig.builder()
          .proxy(proxy)
          .build();

      assertEquals(proxy, config.getProxy());
    }
  }

  @Nested
  @DisplayName("Pool size validation")
  class PoolSizeValidation {

    @ParameterizedTest(name = "should accept valid pool size: {0}")
    @ValueSource(ints = { 1, 10, 100, 1000, 8192 })
    @DisplayName("should accept valid pool sizes")
    void shouldAcceptValidPoolSizes(final int poolSize) {
      final ConnectionConfig config = ConnectionConfig.builder()
          .maxPoolSize(poolSize)
          .build();

      assertEquals(poolSize, config.getMaxPoolSize());
    }

    @Test
    @DisplayName("should handle zero pool size gracefully")
    void shouldHandleZeroPoolSize() {
      assertDoesNotThrow(() -> ConnectionConfig.builder()
          .maxPoolSize(0)
          .build());
    }
  }

  @Nested
  @DisplayName("HTTP version preferences")
  class HttpVersionPreferences {

    @Test
    @DisplayName("should default to HTTP/2 preference")
    void shouldDefaultToHttp2Preference() {
      final ConnectionConfig config = ConnectionConfig.builder().build();

      assertFalse(config.isPreferHttp11());
    }

    @Test
    @DisplayName("should allow HTTP/1.1 preference")
    void shouldAllowHttp11Preference() {
      final ConnectionConfig config = ConnectionConfig.builder()
          .preferHttp11(true)
          .build();

      assertTrue(config.isPreferHttp11());
    }
  }

  @Nested
  @DisplayName("Value object characteristics")
  class ValueObjectCharacteristics {

    @Test
    @DisplayName("should be immutable after creation")
    void shouldBeImmutableAfterCreation() {
      final ConnectionConfig config = ConnectionConfig.builder()
          .tlsVersions(new String[] { "TLSv1.2" })
          .build();

      final String[] originalVersions = config.getTlsVersions();
      originalVersions[0] = "TLSv1.3";

      assertEquals("TLSv1.2", config.getTlsVersions()[0]);
    }

    @Test
    @DisplayName("should have proper equals and hashCode")
    void shouldHaveProperEqualsAndHashCode() {
      final ConnectionConfig config1 = ConnectionConfig.builder()
          .connectTimeout(Duration.ofSeconds(5))
          .maxPoolSize(20)
          .build();

      final ConnectionConfig config2 = ConnectionConfig.builder()
          .connectTimeout(Duration.ofSeconds(5))
          .maxPoolSize(20)
          .build();

      final ConnectionConfig config3 = ConnectionConfig.builder()
          .connectTimeout(Duration.ofSeconds(10))
          .maxPoolSize(20)
          .build();

      assertAll("Equals and hashCode",
          () -> assertEquals(config1, config2),
          () -> assertEquals(config1.hashCode(), config2.hashCode()),
          () -> assertNotEquals(config1, config3),
          () -> assertNotEquals(config1.hashCode(), config3.hashCode()));
    }

    @Test
    @DisplayName("should have meaningful toString representation")
    void shouldHaveMeaningfulToStringRepresentation() {
      final ConnectionConfig config = ConnectionConfig.builder()
          .connectTimeout(Duration.ofSeconds(5))
          .maxPoolSize(20)
          .preferHttp11(true)
          .build();

      final String toString = config.toString();

      assertAll("ToString content",
          () -> assertTrue(toString.contains("ConnectionConfig")),
          () -> assertTrue(toString.contains("connectTimeout")),
          () -> assertTrue(toString.contains("maxPoolSize")),
          () -> assertTrue(toString.contains("preferHttp11")));
    }
  }
}