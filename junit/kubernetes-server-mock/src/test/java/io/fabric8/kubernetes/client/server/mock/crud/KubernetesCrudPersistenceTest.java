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
package io.fabric8.kubernetes.client.server.mock.crud;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.ConfigMapBuilder;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.client.utils.Serialization;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.fabric8.kubernetes.client.server.mock.crud.KubernetesCrudPersistence.shouldIncreaseGeneration;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class KubernetesCrudPersistenceTest {

  private static final ObjectMapper MAPPER = Serialization.jsonMapper();

  @Test
  @DisplayName("shouldIncreaseGeneration, when existing is null, returns false")
  void shouldIncreaseGenerationExistingIsNullReturnsFalse() {
    // When
    final boolean result = shouldIncreaseGeneration(null, null);
    // Then
    assertFalse(result);
  }

  @Test
  @DisplayName("shouldIncreaseGeneration, with existing and source equal, returns false")
  void shouldIncreaseGenerationExistingSourceEqualReturnsFalse() {
    //Given
    final ConfigMap existing = new ConfigMapBuilder().addToData("key", "same").build();
    final ConfigMap source = new ConfigMapBuilder().addToData("key", "same").build();
    // When
    final boolean result = shouldIncreaseGeneration(MAPPER.convertValue(existing, JsonNode.class),
        MAPPER.convertValue(source, JsonNode.class));
    // Then
    assertFalse(result);
  }

  @Test
  @DisplayName("shouldIncreaseGeneration, with existing and source have different metadata, returns false")
  void shouldIncreaseGenerationExistingSourceDifferentMetadataReturnsFalse() {
    //Given
    final ConfigMap existing = new ConfigMapBuilder().withNewMetadata().addToAnnotations("f", "1").endMetadata()
        .addToData("key", "same").build();
    final ConfigMap source = new ConfigMapBuilder().withNewMetadata().addToAnnotations("f", "2").endMetadata()
        .addToData("key", "same").build();
    // When
    final boolean result = shouldIncreaseGeneration(MAPPER.convertValue(existing, JsonNode.class),
        MAPPER.convertValue(source, JsonNode.class));
    // Then
    assertFalse(result);
  }

  @Test
  @DisplayName("shouldIncreaseGeneration, with existing and source have different status, returns false")
  void shouldIncreaseGenerationExistingSourceDifferentStatusReturnsFalse() {
    //Given
    final Pod existing = new PodBuilder().withNewSpec().withHostname("same").endSpec()
        .withNewStatus().withHostIP("1.3.3.7").endStatus().build();
    final Pod source = new PodBuilder().withNewSpec().withHostname("same").endSpec()
        .withNewStatus().withHostIP("31.3.3.73").endStatus().build();
    // When
    final boolean result = shouldIncreaseGeneration(MAPPER.convertValue(existing, JsonNode.class),
        MAPPER.convertValue(source, JsonNode.class));
    // Then
    assertFalse(result);
  }

  @Test
  @DisplayName("shouldIncreaseGeneration, with existing and source have different data, returns true")
  void shouldIncreaseGenerationExistingSourceDifferentDataReturnsTrue() {
    //Given
    final ConfigMap existing = new ConfigMapBuilder().addToData("key", "different").build();
    final ConfigMap source = new ConfigMapBuilder().addToData("key", "not-equal").build();
    // When
    final boolean result = shouldIncreaseGeneration(MAPPER.convertValue(existing, JsonNode.class),
        MAPPER.convertValue(source, JsonNode.class));
    // Then
    assertTrue(result);
  }
}
