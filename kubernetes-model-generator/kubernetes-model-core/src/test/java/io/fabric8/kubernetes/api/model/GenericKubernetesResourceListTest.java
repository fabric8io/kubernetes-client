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
package io.fabric8.kubernetes.api.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class GenericKubernetesResourceListTest {

  private ObjectMapper objectMapper;

  @BeforeEach
  void setUp() {
    objectMapper = new ObjectMapper();
  }

  @Test
  @DisplayName("serialize, with empty items, should serialize")
  void serializeWithEmptyItems() {
    // Given
    final GenericKubernetesResourceList gkrl = new GenericKubernetesResourceList();
    gkrl.setApiVersion("the-cr.example.com/v1");
    gkrl.setKind("SomeCustomResource");
    gkrl.setItems(Collections.emptyList());
    // When
    final Map<String, ?> result = objectMapper.convertValue(gkrl, new TypeReference<Map<String, ?>>() {
    });
    // Then
    assertThat(result)
        .hasFieldOrPropertyWithValue("apiVersion", "the-cr.example.com/v1")
        .hasFieldOrPropertyWithValue("kind", "SomeCustomResource")
        .hasFieldOrPropertyWithValue("items", Collections.emptyList());
  }

  @Test
  @DisplayName("deserialize, with empty items, should deserialize")
  void deserializeWithEmptyItems() throws Exception {
    // Given
    final String list = "{" +
        "\"apiVersion\": \"v1\"," +
        "\"items\": []," +
        "\"kind\": \"List\"" +
        "}";
    // When
    final GenericKubernetesResourceList result = objectMapper.readValue(list, GenericKubernetesResourceList.class);
    // Then
    assertThat(result)
        .hasFieldOrPropertyWithValue("apiVersion", "v1")
        .hasFieldOrPropertyWithValue("kind", "List")
        .hasFieldOrPropertyWithValue("items", Collections.emptyList());
  }
}
