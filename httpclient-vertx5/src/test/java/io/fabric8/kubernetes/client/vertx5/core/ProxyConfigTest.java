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

import io.fabric8.kubernetes.client.http.HttpClient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.net.InetSocketAddress;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("ProxyConfig value object")
class ProxyConfigTest {

  @Nested
  @DisplayName("Builder pattern validation")
  class BuilderPatternValidation {

    @Test
    @DisplayName("should create proxy configuration with required fields")
    void shouldCreateProxyConfigurationWithRequiredFields() {
      final InetSocketAddress address = new InetSocketAddress("proxy.example.com", 8080);
      final HttpClient.ProxyType type = HttpClient.ProxyType.HTTP;

      final ProxyConfig config = ProxyConfig.builder()
          .type(type)
          .address(address)
          .build();

      assertAll("Required fields",
          () -> assertEquals(type, config.getType()),
          () -> assertEquals(address, config.getAddress()),
          () -> assertNull(config.getUsername()),
          () -> assertNull(config.getPassword()));
    }

    @Test
    @DisplayName("should create proxy configuration with authentication")
    void shouldCreateProxyConfigurationWithAuthentication() {
      final InetSocketAddress address = new InetSocketAddress("proxy.example.com", 8080);
      final String username = "proxyuser";
      final String password = "proxypass";

      final ProxyConfig config = ProxyConfig.builder()
          .type(HttpClient.ProxyType.HTTP)
          .address(address)
          .username(username)
          .password(password)
          .build();

      assertAll("Authentication fields",
          () -> assertEquals(username, config.getUsername()),
          () -> assertEquals(password, config.getPassword()));
    }

    @Test
    @DisplayName("should create proxy configuration without authentication")
    void shouldCreateProxyConfigurationWithoutAuthentication() {
      final ProxyConfig config = ProxyConfig.builder()
          .type(HttpClient.ProxyType.HTTP)
          .address(new InetSocketAddress("proxy.example.com", 8080))
          .build();

      assertAll("No authentication",
          () -> assertNull(config.getUsername()),
          () -> assertNull(config.getPassword()));
    }
  }

  @Nested
  @DisplayName("Proxy type support")
  class ProxyTypeSupport {

    @ParameterizedTest(name = "should support proxy type: {0}")
    @EnumSource(value = HttpClient.ProxyType.class, names = { "HTTP", "SOCKS4", "SOCKS5" })
    @DisplayName("should support all proxy types except DIRECT")
    void shouldSupportAllProxyTypesExceptDirect(final HttpClient.ProxyType proxyType) {
      final ProxyConfig config = ProxyConfig.builder()
          .type(proxyType)
          .address(new InetSocketAddress("proxy.example.com", 8080))
          .build();

      assertEquals(proxyType, config.getType());
    }

    @Test
    @DisplayName("should handle DIRECT proxy type")
    void shouldHandleDirectProxyType() {
      assertDoesNotThrow(() -> ProxyConfig.builder()
          .type(HttpClient.ProxyType.DIRECT)
          .address(new InetSocketAddress("proxy.example.com", 8080))
          .build());
    }
  }

  @Nested
  @DisplayName("Address validation")
  class AddressValidation {

    @Test
    @DisplayName("should accept hostname and port")
    void shouldAcceptHostnameAndPort() {
      final InetSocketAddress address = new InetSocketAddress("proxy.example.com", 8080);

      final ProxyConfig config = ProxyConfig.builder()
          .type(HttpClient.ProxyType.HTTP)
          .address(address)
          .build();

      assertAll("Address properties",
          () -> assertEquals("proxy.example.com", config.getAddress().getHostName()),
          () -> assertEquals(8080, config.getAddress().getPort()));
    }

    @Test
    @DisplayName("should accept IP address and port")
    void shouldAcceptIpAddressAndPort() {
      final InetSocketAddress address = new InetSocketAddress("192.168.1.100", 3128);

      final ProxyConfig config = ProxyConfig.builder()
          .type(HttpClient.ProxyType.HTTP)
          .address(address)
          .build();

      assertEquals(3128, config.getAddress().getPort());
    }

    @Test
    @DisplayName("should handle standard proxy ports")
    void shouldHandleStandardProxyPorts() {
      final int[] standardPorts = { 8080, 3128, 1080, 8888 };

      for (final int port : standardPorts) {
        assertDoesNotThrow(() -> ProxyConfig.builder()
            .type(HttpClient.ProxyType.HTTP)
            .address(new InetSocketAddress("proxy.example.com", port))
            .build());
      }
    }
  }

  @Nested
  @DisplayName("Authentication handling")
  class AuthenticationHandling {

    @Test
    @DisplayName("should handle empty username and password")
    void shouldHandleEmptyUsernameAndPassword() {
      final ProxyConfig config = ProxyConfig.builder()
          .type(HttpClient.ProxyType.HTTP)
          .address(new InetSocketAddress("proxy.example.com", 8080))
          .username("")
          .password("")
          .build();

      assertAll("Empty credentials",
          () -> assertEquals("", config.getUsername()),
          () -> assertEquals("", config.getPassword()));
    }

    @Test
    @DisplayName("should handle only username without password")
    void shouldHandleOnlyUsernameWithoutPassword() {
      final ProxyConfig config = ProxyConfig.builder()
          .type(HttpClient.ProxyType.HTTP)
          .address(new InetSocketAddress("proxy.example.com", 8080))
          .username("proxyuser")
          .build();

      assertAll("Username only",
          () -> assertEquals("proxyuser", config.getUsername()),
          () -> assertNull(config.getPassword()));
    }

    @Test
    @DisplayName("should handle only password without username")
    void shouldHandleOnlyPasswordWithoutUsername() {
      final ProxyConfig config = ProxyConfig.builder()
          .type(HttpClient.ProxyType.HTTP)
          .address(new InetSocketAddress("proxy.example.com", 8080))
          .password("proxypass")
          .build();

      assertAll("Password only",
          () -> assertNull(config.getUsername()),
          () -> assertEquals("proxypass", config.getPassword()));
    }
  }

  @Nested
  @DisplayName("Value object characteristics")
  class ValueObjectCharacteristics {

    @Test
    @DisplayName("should have proper equals and hashCode")
    void shouldHaveProperEqualsAndHashCode() {
      final InetSocketAddress address = new InetSocketAddress("proxy.example.com", 8080);

      final ProxyConfig config1 = ProxyConfig.builder()
          .type(HttpClient.ProxyType.HTTP)
          .address(address)
          .username("user")
          .build();

      final ProxyConfig config2 = ProxyConfig.builder()
          .type(HttpClient.ProxyType.HTTP)
          .address(address)
          .username("user")
          .build();

      final ProxyConfig config3 = ProxyConfig.builder()
          .type(HttpClient.ProxyType.SOCKS5)
          .address(address)
          .username("user")
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
      final ProxyConfig config = ProxyConfig.builder()
          .type(HttpClient.ProxyType.HTTP)
          .address(new InetSocketAddress("proxy.example.com", 8080))
          .username("user")
          .build();

      final String toString = config.toString();

      assertAll("ToString content",
          () -> assertTrue(toString.contains("ProxyConfig")),
          () -> assertTrue(toString.contains("type")),
          () -> assertTrue(toString.contains("address")),
          () -> assertTrue(toString.contains("username")),
          () -> assertFalse(toString.contains("password")));
    }

    @Test
    @DisplayName("should not expose password in toString")
    void shouldNotExposePasswordInToString() {
      final ProxyConfig config = ProxyConfig.builder()
          .type(HttpClient.ProxyType.HTTP)
          .address(new InetSocketAddress("proxy.example.com", 8080))
          .username("user")
          .password("secretpassword")
          .build();

      final String toString = config.toString();

      assertFalse(toString.contains("secretpassword"));
    }
  }
}