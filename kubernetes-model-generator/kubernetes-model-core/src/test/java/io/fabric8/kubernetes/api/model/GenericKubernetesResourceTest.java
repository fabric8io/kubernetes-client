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

import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class GenericKubernetesResourceTest {

  private ObjectMapper objectMapper;

  @BeforeEach
  void setUp() {
    objectMapper = new ObjectMapper();
  }

  @Test
  @DisplayName("deserialize, with empty JSON, should deserialize empty")
  void deserializeWithEmptyShouldDeserializeEmpty() throws Exception {
    // When
    final GenericKubernetesResource result = objectMapper
      .readValue(load("empty.json"), GenericKubernetesResource.class);
    // Then
    assertThat(result).isEqualTo(new GenericKubernetesResource());
  }

  @Test
  @DisplayName("deserialize, with config map structure, should deserialize like ConfigMap")
  void deserializeWithConfigMapStructureShouldDeserializeLikeConfigMap() throws Exception {
    // Given
    final ConfigMap configMap = objectMapper.readValue(load("config-map.json"), ConfigMap.class);
    // When
    final GenericKubernetesResource result = objectMapper
      .readValue(load("config-map.json"), GenericKubernetesResource.class);
    // Then
    assertThat(result)
      .hasFieldOrPropertyWithValue("metadata.namespace", "default")
      .hasFieldOrPropertyWithValue("metadata.name", "generic-resource-test")
      .hasFieldOrPropertyWithValue("additionalProperties.data", configMap.getData());
  }

  @Test
  @DisplayName("deserialize, with custom resource, should deserialize")
  void deserializeWithCustomResourceShouldDeserialize() throws Exception {
    // When
    final GenericKubernetesResource result = objectMapper
      .readValue(load("custom-resource.json"), GenericKubernetesResource.class);
    // Then
    assertThat(result)
      .hasFieldOrPropertyWithValue("apiVersion", "the-cr.example.com/v1")
      .hasFieldOrPropertyWithValue("Kind", "SomeCustomResource")
      .hasFieldOrPropertyWithValue("metadata.name", "custom-resource-example")
      .hasFieldOrPropertyWithValue("additionalProperties.spec.field", "value")
      .hasFieldOrPropertyWithValue("additionalProperties.status.reconciled", true);
  }

  @Test
  @DisplayName("serialize, with custom resource, should serialize")
  void serializeWithCustomResourceShouldSerialize() {
    // Given
    final GenericKubernetesResource gkr = new GenericKubernetesResource();
    gkr.setApiVersion("the-cr.example.com/v1");
    gkr.setKind("SomeCustomResource");
    gkr.setMetadata(new ObjectMetaBuilder().withName("custom-resource-example").build());
    gkr.setAdditionalProperties(Collections.singletonMap("spec", Collections.singletonMap("field", "value")));
    // When
    final Map<String, ?> result = objectMapper.convertValue(gkr, new TypeReference<Map<String, ?>>() {});
    // Then
    assertThat(result)
      .hasFieldOrPropertyWithValue("kind", "SomeCustomResource")
      .hasFieldOrPropertyWithValue("metadata.name", "custom-resource-example")
      .hasFieldOrPropertyWithValue("spec.field", "value");
  }

  private static InputStream load(String resource) {
    return GenericKubernetesResource.class.getResourceAsStream("/generic-kubernetes-resource/" + resource);
  }
}
