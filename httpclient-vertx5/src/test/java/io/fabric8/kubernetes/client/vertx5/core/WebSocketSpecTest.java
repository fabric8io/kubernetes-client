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

import java.net.URI;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("WebSocketSpec value object")
class WebSocketSpecTest {

  private static final URI WS_URI = URI.create("ws://localhost:8080/websocket");
  private static final URI WSS_URI = URI.create("wss://secure.example.com/websocket");

  @Nested
  @DisplayName("Builder pattern validation")
  class BuilderPatternValidation {

    @Test
    @DisplayName("should create minimal WebSocket specification")
    void shouldCreateMinimalWebSocketSpecification() {
      final WebSocketSpec spec = WebSocketSpec.builder()
          .uri(WS_URI)
          .build();

      assertAll("Minimal WebSocket spec",
          () -> assertEquals(WS_URI, spec.getUri()),
          () -> assertTrue(spec.getHeaders().isEmpty()),
          () -> assertNull(spec.getSubprotocol()),
          () -> assertNull(spec.getTimeout()));
    }

    @Test
    @DisplayName("should create complete WebSocket specification")
    void shouldCreateCompleteWebSocketSpecification() {
      final String subprotocol = "v4.channel.k8s.io";
      final Duration timeout = Duration.ofSeconds(30);
      final Map<String, List<String>> headers = Map.of(
          "Authorization", List.of("Bearer token123"),
          "Sec-WebSocket-Protocol", List.of(subprotocol));

      final WebSocketSpec spec = WebSocketSpec.builder()
          .uri(WSS_URI)
          .subprotocol(subprotocol)
          .timeout(timeout)
          .headers(headers)
          .build();

      assertAll("Complete WebSocket spec",
          () -> assertEquals(WSS_URI, spec.getUri()),
          () -> assertEquals(subprotocol, spec.getSubprotocol()),
          () -> assertEquals(timeout, spec.getTimeout()),
          () -> assertEquals(headers, spec.getHeaders()));
    }

    @Test
    @DisplayName("should handle empty headers map")
    void shouldHandleEmptyHeadersMap() {
      final WebSocketSpec spec = WebSocketSpec.builder()
          .uri(WS_URI)
          .headers(Map.of())
          .build();

      assertTrue(spec.getHeaders().isEmpty());
    }
  }

  @Nested
  @DisplayName("URI scheme validation")
  class UriSchemeValidation {

    @Test
    @DisplayName("should handle WebSocket URI scheme")
    void shouldHandleWebSocketUriScheme() {
      final URI wsUri = URI.create("ws://localhost:8080/path");

      final WebSocketSpec spec = WebSocketSpec.builder()
          .uri(wsUri)
          .build();

      assertEquals(wsUri, spec.getUri());
      assertEquals("ws", spec.getUri().getScheme());
    }

    @Test
    @DisplayName("should handle secure WebSocket URI scheme")
    void shouldHandleSecureWebSocketUriScheme() {
      final URI wssUri = URI.create("wss://secure.example.com:8443/secure-path");

      final WebSocketSpec spec = WebSocketSpec.builder()
          .uri(wssUri)
          .build();

      assertEquals(wssUri, spec.getUri());
      assertEquals("wss", spec.getUri().getScheme());
    }

    @Test
    @DisplayName("should handle URIs with query parameters")
    void shouldHandleUrisWithQueryParameters() {
      final URI uriWithQuery = URI.create("wss://api.example.com/exec?namespace=default&pod=my-pod&container=app");

      final WebSocketSpec spec = WebSocketSpec.builder()
          .uri(uriWithQuery)
          .build();

      assertEquals(uriWithQuery, spec.getUri());
      assertTrue(spec.getUri().toString().contains("namespace=default"));
    }

    @Test
    @DisplayName("should handle URIs with custom ports")
    void shouldHandleUrisWithCustomPorts() {
      final URI uriWithPort = URI.create("wss://api.example.com:6443/websocket");

      final WebSocketSpec spec = WebSocketSpec.builder()
          .uri(uriWithPort)
          .build();

      assertEquals(6443, spec.getUri().getPort());
    }
  }

  @Nested
  @DisplayName("Subprotocol handling")
  class SubprotocolHandling {

    @ParameterizedTest(name = "should handle Kubernetes subprotocol: {0}")
    @ValueSource(strings = {
        "v4.channel.k8s.io",
        "v3.channel.k8s.io",
        "v2.channel.k8s.io",
        "v1.channel.k8s.io"
    })
    @DisplayName("should handle Kubernetes channel subprotocols")
    void shouldHandleKubernetesChannelSubprotocols(final String subprotocol) {
      final WebSocketSpec spec = WebSocketSpec.builder()
          .uri(WS_URI)
          .subprotocol(subprotocol)
          .build();

      assertEquals(subprotocol, spec.getSubprotocol());
    }

    @Test
    @DisplayName("should handle custom subprotocols")
    void shouldHandleCustomSubprotocols() {
      final String customSubprotocol = "my-custom-protocol";

      final WebSocketSpec spec = WebSocketSpec.builder()
          .uri(WS_URI)
          .subprotocol(customSubprotocol)
          .build();

      assertEquals(customSubprotocol, spec.getSubprotocol());
    }

    @Test
    @DisplayName("should handle empty subprotocol")
    void shouldHandleEmptySubprotocol() {
      final WebSocketSpec spec = WebSocketSpec.builder()
          .uri(WS_URI)
          .subprotocol("")
          .build();

      assertEquals("", spec.getSubprotocol());
    }

    @Test
    @DisplayName("should handle null subprotocol")
    void shouldHandleNullSubprotocol() {
      final WebSocketSpec spec = WebSocketSpec.builder()
          .uri(WS_URI)
          .build();

      assertNull(spec.getSubprotocol());
    }
  }

  @Nested
  @DisplayName("Header management")
  class HeaderManagement {

    @Test
    @DisplayName("should handle authorization headers")
    void shouldHandleAuthorizationHeaders() {
      final Map<String, List<String>> headers = Map.of(
          "Authorization", List.of("Bearer eyJhbGciOiJSUzI1NiIs..."));

      final WebSocketSpec spec = WebSocketSpec.builder()
          .uri(WSS_URI)
          .headers(headers)
          .build();

      assertTrue(spec.getHeaders().containsKey("Authorization"));
      assertEquals("Bearer eyJhbGciOiJSUzI1NiIs...",
          spec.getHeaders().get("Authorization").get(0));
    }

    @Test
    @DisplayName("should handle protocol headers")
    void shouldHandleProtocolHeaders() {
      final Map<String, List<String>> headers = Map.of(
          "Sec-WebSocket-Protocol", List.of("v4.channel.k8s.io"),
          "Sec-WebSocket-Version", List.of("13"));

      final WebSocketSpec spec = WebSocketSpec.builder()
          .uri(WS_URI)
          .headers(headers)
          .build();

      assertEquals(2, spec.getHeaders().size());
      assertTrue(spec.getHeaders().containsKey("Sec-WebSocket-Protocol"));
      assertTrue(spec.getHeaders().containsKey("Sec-WebSocket-Version"));
    }

    @Test
    @DisplayName("should handle custom headers")
    void shouldHandleCustomHeaders() {
      final Map<String, List<String>> headers = Map.of(
          "X-Custom-Header", List.of("custom-value"),
          "X-Client-ID", List.of("kubernetes-client-vertx5"));

      final WebSocketSpec spec = WebSocketSpec.builder()
          .uri(WS_URI)
          .headers(headers)
          .build();

      assertEquals("custom-value", spec.getHeaders().get("X-Custom-Header").get(0));
      assertEquals("kubernetes-client-vertx5", spec.getHeaders().get("X-Client-ID").get(0));
    }

    @Test
    @DisplayName("should handle multiple header values")
    void shouldHandleMultipleHeaderValues() {
      final Map<String, List<String>> headers = Map.of(
          "Accept-Encoding", List.of("gzip", "deflate", "br"));

      final WebSocketSpec spec = WebSocketSpec.builder()
          .uri(WS_URI)
          .headers(headers)
          .build();

      final List<String> encodings = spec.getHeaders().get("Accept-Encoding");
      assertEquals(3, encodings.size());
      assertTrue(encodings.contains("gzip"));
      assertTrue(encodings.contains("deflate"));
      assertTrue(encodings.contains("br"));
    }
  }

  @Nested
  @DisplayName("Timeout configuration")
  class TimeoutConfiguration {

    @Test
    @DisplayName("should handle connection timeout")
    void shouldHandleConnectionTimeout() {
      final Duration connectionTimeout = Duration.ofSeconds(10);

      final WebSocketSpec spec = WebSocketSpec.builder()
          .uri(WS_URI)
          .timeout(connectionTimeout)
          .build();

      assertEquals(connectionTimeout, spec.getTimeout());
    }

    @Test
    @DisplayName("should handle short timeouts")
    void shouldHandleShortTimeouts() {
      final Duration shortTimeout = Duration.ofMillis(100);

      final WebSocketSpec spec = WebSocketSpec.builder()
          .uri(WS_URI)
          .timeout(shortTimeout)
          .build();

      assertEquals(shortTimeout, spec.getTimeout());
    }

    @Test
    @DisplayName("should handle long timeouts")
    void shouldHandleLongTimeouts() {
      final Duration longTimeout = Duration.ofMinutes(10);

      final WebSocketSpec spec = WebSocketSpec.builder()
          .uri(WS_URI)
          .timeout(longTimeout)
          .build();

      assertEquals(longTimeout, spec.getTimeout());
    }

    @Test
    @DisplayName("should handle zero timeout")
    void shouldHandleZeroTimeout() {
      final Duration zeroTimeout = Duration.ZERO;

      final WebSocketSpec spec = WebSocketSpec.builder()
          .uri(WS_URI)
          .timeout(zeroTimeout)
          .build();

      assertEquals(zeroTimeout, spec.getTimeout());
    }
  }

  @Nested
  @DisplayName("Value object characteristics")
  class ValueObjectCharacteristics {

    @Test
    @DisplayName("should have proper equals and hashCode")
    void shouldHaveProperEqualsAndHashCode() {
      final WebSocketSpec spec1 = WebSocketSpec.builder()
          .uri(WS_URI)
          .subprotocol("v4.channel.k8s.io")
          .timeout(Duration.ofSeconds(30))
          .build();

      final WebSocketSpec spec2 = WebSocketSpec.builder()
          .uri(WS_URI)
          .subprotocol("v4.channel.k8s.io")
          .timeout(Duration.ofSeconds(30))
          .build();

      final WebSocketSpec spec3 = WebSocketSpec.builder()
          .uri(WSS_URI)
          .subprotocol("v4.channel.k8s.io")
          .timeout(Duration.ofSeconds(30))
          .build();

      assertAll("Equals and hashCode",
          () -> assertEquals(spec1, spec2),
          () -> assertEquals(spec1.hashCode(), spec2.hashCode()),
          () -> assertNotEquals(spec1, spec3),
          () -> assertNotEquals(spec1.hashCode(), spec3.hashCode()));
    }

    @Test
    @DisplayName("should have meaningful toString representation")
    void shouldHaveMeaningfulToStringRepresentation() {
      final WebSocketSpec spec = WebSocketSpec.builder()
          .uri(WSS_URI)
          .subprotocol("v4.channel.k8s.io")
          .timeout(Duration.ofSeconds(30))
          .build();

      final String toString = spec.toString();

      assertAll("ToString content",
          () -> assertTrue(toString.contains("WebSocketSpec")),
          () -> assertTrue(toString.contains("uri")),
          () -> assertTrue(toString.contains("subprotocol")),
          () -> assertTrue(toString.contains("timeout")));
    }
  }
}