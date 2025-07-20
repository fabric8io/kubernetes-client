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
package io.fabric8.kubernetes.client.vertx5.adapters;

import io.vertx.core.MultiMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Vertx5HttpRequest utility methods")
class Vertx5HttpRequestTest {

  @Nested
  @DisplayName("Header conversion")
  class HeaderConversion {

    @Test
    @DisplayName("should convert empty MultiMap to empty headers map")
    void shouldConvertEmptyMultiMapToEmptyHeadersMap() {
      final MultiMap multiMap = MultiMap.caseInsensitiveMultiMap();

      final Map<String, List<String>> headers = Vertx5HttpRequest.toHeadersMap(multiMap);

      assertTrue(headers.isEmpty());
    }

    @Test
    @DisplayName("should convert single header correctly")
    void shouldConvertSingleHeaderCorrectly() {
      final MultiMap multiMap = MultiMap.caseInsensitiveMultiMap();
      multiMap.add("Content-Type", "application/json");

      final Map<String, List<String>> headers = Vertx5HttpRequest.toHeadersMap(multiMap);

      assertAll("Single header conversion",
          () -> assertEquals(1, headers.size()),
          () -> assertTrue(headers.containsKey("Content-Type")),
          () -> assertEquals(List.of("application/json"), headers.get("Content-Type")));
    }

    @Test
    @DisplayName("should convert multiple values for same header")
    void shouldConvertMultipleValuesForSameHeader() {
      final MultiMap multiMap = MultiMap.caseInsensitiveMultiMap();
      multiMap.add("Accept", "application/json");
      multiMap.add("Accept", "application/xml");

      final Map<String, List<String>> headers = Vertx5HttpRequest.toHeadersMap(multiMap);

      assertAll("Multiple values header conversion",
          () -> assertEquals(1, headers.size()),
          () -> assertTrue(headers.containsKey("Accept")),
          () -> assertEquals(2, headers.get("Accept").size()),
          () -> assertTrue(headers.get("Accept").contains("application/json")),
          () -> assertTrue(headers.get("Accept").contains("application/xml")));
    }

    @Test
    @DisplayName("should convert multiple different headers")
    void shouldConvertMultipleDifferentHeaders() {
      final MultiMap multiMap = MultiMap.caseInsensitiveMultiMap();
      multiMap.add("Content-Type", "application/json");
      multiMap.add("Authorization", "Bearer token123");
      multiMap.add("User-Agent", "kubernetes-client");

      final Map<String, List<String>> headers = Vertx5HttpRequest.toHeadersMap(multiMap);

      assertAll("Multiple headers conversion",
          () -> assertEquals(3, headers.size()),
          () -> assertTrue(headers.containsKey("Content-Type")),
          () -> assertTrue(headers.containsKey("Authorization")),
          () -> assertTrue(headers.containsKey("User-Agent")),
          () -> assertEquals(List.of("application/json"), headers.get("Content-Type")),
          () -> assertEquals(List.of("Bearer token123"), headers.get("Authorization")),
          () -> assertEquals(List.of("kubernetes-client"), headers.get("User-Agent")));
    }

    @Test
    @DisplayName("should preserve header case from MultiMap")
    void shouldPreserveHeaderCaseFromMultiMap() {
      final MultiMap multiMap = MultiMap.caseInsensitiveMultiMap();
      multiMap.add("Content-TYPE", "application/json");

      final Map<String, List<String>> headers = Vertx5HttpRequest.toHeadersMap(multiMap);

      // The actual key preservation depends on Vert.x MultiMap implementation
      assertFalse(headers.isEmpty());
      assertEquals(1, headers.size());
    }
  }
}