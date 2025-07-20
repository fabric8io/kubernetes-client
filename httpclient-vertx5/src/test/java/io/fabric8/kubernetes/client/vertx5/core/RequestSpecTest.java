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

@DisplayName("RequestSpec value object")
class RequestSpecTest {

  private static final URI TEST_URI = URI.create("https://api.example.com/v1/pods");

  @Nested
  @DisplayName("Builder pattern validation")
  class BuilderPatternValidation {

    @Test
    @DisplayName("should create minimal request specification")
    void shouldCreateMinimalRequestSpecification() {
      final RequestSpec spec = RequestSpec.builder()
          .uri(TEST_URI)
          .method("GET")
          .build();

      assertAll("Minimal request",
          () -> assertEquals(TEST_URI, spec.getUri()),
          () -> assertEquals("GET", spec.getMethod()),
          () -> assertTrue(spec.getHeaders().isEmpty()),
          () -> assertNull(spec.getContentType()),
          () -> assertNull(spec.getTimeout()));
    }

    @Test
    @DisplayName("should create complete request specification")
    void shouldCreateCompleteRequestSpecification() {
      final String contentType = "application/json";
      final Duration timeout = Duration.ofSeconds(30);
      final Map<String, List<String>> headers = Map.of(
          "Authorization", List.of("Bearer token123"),
          "Accept", List.of("application/json", "application/yaml"));

      final RequestSpec spec = RequestSpec.builder()
          .uri(TEST_URI)
          .method("POST")
          .contentType(contentType)
          .timeout(timeout)
          .headers(headers)
          .build();

      assertAll("Complete request",
          () -> assertEquals(TEST_URI, spec.getUri()),
          () -> assertEquals("POST", spec.getMethod()),
          () -> assertEquals(contentType, spec.getContentType()),
          () -> assertEquals(timeout, spec.getTimeout()),
          () -> assertEquals(headers, spec.getHeaders()));
    }

    @Test
    @DisplayName("should handle empty headers map")
    void shouldHandleEmptyHeadersMap() {
      final RequestSpec spec = RequestSpec.builder()
          .uri(TEST_URI)
          .method("GET")
          .headers(Map.of())
          .build();

      assertTrue(spec.getHeaders().isEmpty());
    }
  }

  @Nested
  @DisplayName("HTTP method validation")
  class HttpMethodValidation {

    @ParameterizedTest(name = "should accept HTTP method: {0}")
    @ValueSource(strings = { "GET", "POST", "PUT", "DELETE", "PATCH", "HEAD", "OPTIONS" })
    @DisplayName("should accept standard HTTP methods")
    void shouldAcceptStandardHttpMethods(final String method) {
      final RequestSpec spec = RequestSpec.builder()
          .uri(TEST_URI)
          .method(method)
          .build();

      assertEquals(method, spec.getMethod());
    }

    @Test
    @DisplayName("should accept custom HTTP methods")
    void shouldAcceptCustomHttpMethods() {
      final String customMethod = "CONNECT";

      final RequestSpec spec = RequestSpec.builder()
          .uri(TEST_URI)
          .method(customMethod)
          .build();

      assertEquals(customMethod, spec.getMethod());
    }

    @Test
    @DisplayName("should preserve method case")
    void shouldPreserveMethodCase() {
      final String mixedCaseMethod = "GeT";

      final RequestSpec spec = RequestSpec.builder()
          .uri(TEST_URI)
          .method(mixedCaseMethod)
          .build();

      assertEquals(mixedCaseMethod, spec.getMethod());
    }
  }

  @Nested
  @DisplayName("URI handling")
  class UriHandling {

    @Test
    @DisplayName("should handle HTTPS URIs")
    void shouldHandleHttpsUris() {
      final URI httpsUri = URI.create("https://secure.example.com/api");

      final RequestSpec spec = RequestSpec.builder()
          .uri(httpsUri)
          .method("GET")
          .build();

      assertEquals(httpsUri, spec.getUri());
    }

    @Test
    @DisplayName("should handle HTTP URIs")
    void shouldHandleHttpUris() {
      final URI httpUri = URI.create("http://insecure.example.com/api");

      final RequestSpec spec = RequestSpec.builder()
          .uri(httpUri)
          .method("GET")
          .build();

      assertEquals(httpUri, spec.getUri());
    }

    @Test
    @DisplayName("should handle URIs with query parameters")
    void shouldHandleUrisWithQueryParameters() {
      final URI uriWithQuery = URI.create("https://api.example.com/v1/pods?namespace=default&labelSelector=app%3Dnginx");

      final RequestSpec spec = RequestSpec.builder()
          .uri(uriWithQuery)
          .method("GET")
          .build();

      assertEquals(uriWithQuery, spec.getUri());
    }

    @Test
    @DisplayName("should handle URIs with ports")
    void shouldHandleUrisWithPorts() {
      final URI uriWithPort = URI.create("https://api.example.com:8443/v1/pods");

      final RequestSpec spec = RequestSpec.builder()
          .uri(uriWithPort)
          .method("GET")
          .build();

      assertEquals(uriWithPort, spec.getUri());
    }
  }

  @Nested
  @DisplayName("Header management")
  class HeaderManagement {

    @Test
    @DisplayName("should handle single header values")
    void shouldHandleSingleHeaderValues() {
      final Map<String, List<String>> headers = Map.of(
          "Content-Type", List.of("application/json"));

      final RequestSpec spec = RequestSpec.builder()
          .uri(TEST_URI)
          .method("POST")
          .headers(headers)
          .build();

      assertEquals(List.of("application/json"), spec.getHeaders().get("Content-Type"));
    }

    @Test
    @DisplayName("should handle multiple header values")
    void shouldHandleMultipleHeaderValues() {
      final Map<String, List<String>> headers = Map.of(
          "Accept", List.of("application/json", "application/xml", "text/plain"));

      final RequestSpec spec = RequestSpec.builder()
          .uri(TEST_URI)
          .method("GET")
          .headers(headers)
          .build();

      assertEquals(3, spec.getHeaders().get("Accept").size());
      assertTrue(spec.getHeaders().get("Accept").contains("application/json"));
      assertTrue(spec.getHeaders().get("Accept").contains("application/xml"));
      assertTrue(spec.getHeaders().get("Accept").contains("text/plain"));
    }

    @Test
    @DisplayName("should handle case-sensitive header names")
    void shouldHandleCaseSensitiveHeaderNames() {
      final Map<String, List<String>> headers = Map.of(
          "Content-Type", List.of("application/json"),
          "content-type", List.of("text/plain"));

      final RequestSpec spec = RequestSpec.builder()
          .uri(TEST_URI)
          .method("POST")
          .headers(headers)
          .build();

      assertEquals(2, spec.getHeaders().size());
      assertTrue(spec.getHeaders().containsKey("Content-Type"));
      assertTrue(spec.getHeaders().containsKey("content-type"));
    }
  }

  @Nested
  @DisplayName("Content type handling")
  class ContentTypeHandling {

    @Test
    @DisplayName("should handle JSON content type")
    void shouldHandleJsonContentType() {
      final RequestSpec spec = RequestSpec.builder()
          .uri(TEST_URI)
          .method("POST")
          .contentType("application/json")
          .build();

      assertEquals("application/json", spec.getContentType());
    }

    @Test
    @DisplayName("should handle XML content type")
    void shouldHandleXmlContentType() {
      final RequestSpec spec = RequestSpec.builder()
          .uri(TEST_URI)
          .method("POST")
          .contentType("application/xml")
          .build();

      assertEquals("application/xml", spec.getContentType());
    }

    @Test
    @DisplayName("should handle content type with charset")
    void shouldHandleContentTypeWithCharset() {
      final String contentTypeWithCharset = "application/json; charset=utf-8";

      final RequestSpec spec = RequestSpec.builder()
          .uri(TEST_URI)
          .method("POST")
          .contentType(contentTypeWithCharset)
          .build();

      assertEquals(contentTypeWithCharset, spec.getContentType());
    }
  }

  @Nested
  @DisplayName("Timeout configuration")
  class TimeoutConfiguration {

    @Test
    @DisplayName("should handle short timeouts")
    void shouldHandleShortTimeouts() {
      final Duration shortTimeout = Duration.ofMillis(500);

      final RequestSpec spec = RequestSpec.builder()
          .uri(TEST_URI)
          .method("GET")
          .timeout(shortTimeout)
          .build();

      assertEquals(shortTimeout, spec.getTimeout());
    }

    @Test
    @DisplayName("should handle long timeouts")
    void shouldHandleLongTimeouts() {
      final Duration longTimeout = Duration.ofMinutes(5);

      final RequestSpec spec = RequestSpec.builder()
          .uri(TEST_URI)
          .method("GET")
          .timeout(longTimeout)
          .build();

      assertEquals(longTimeout, spec.getTimeout());
    }

    @Test
    @DisplayName("should handle zero timeout")
    void shouldHandleZeroTimeout() {
      final Duration zeroTimeout = Duration.ZERO;

      final RequestSpec spec = RequestSpec.builder()
          .uri(TEST_URI)
          .method("GET")
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
      final RequestSpec spec1 = RequestSpec.builder()
          .uri(TEST_URI)
          .method("GET")
          .contentType("application/json")
          .build();

      final RequestSpec spec2 = RequestSpec.builder()
          .uri(TEST_URI)
          .method("GET")
          .contentType("application/json")
          .build();

      final RequestSpec spec3 = RequestSpec.builder()
          .uri(TEST_URI)
          .method("POST")
          .contentType("application/json")
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
      final RequestSpec spec = RequestSpec.builder()
          .uri(TEST_URI)
          .method("POST")
          .contentType("application/json")
          .timeout(Duration.ofSeconds(30))
          .build();

      final String toString = spec.toString();

      assertAll("ToString content",
          () -> assertTrue(toString.contains("RequestSpec")),
          () -> assertTrue(toString.contains("uri")),
          () -> assertTrue(toString.contains("method")),
          () -> assertTrue(toString.contains("contentType")),
          () -> assertTrue(toString.contains("timeout")));
    }
  }
}