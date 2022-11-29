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

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KubernetesResourceTest {

  private ObjectMapper objectMapper;

  @BeforeEach
  void setUp() {
    objectMapper = new ObjectMapper();
  }

  @Test
  @DisplayName("deserialize, with Registered apiVersion and Kind (Pod), should return Pod")
  void deserializeWithRegisteredApiVersionKindShouldReturnPod() throws Exception {
    // When
    final HasMetadata result = objectMapper.readerFor(KubernetesResource.class)
        .readValue("{\"kind\": \"Pod\", \"apiVersion\": \"v1\"}");
    // Then
    assertThat(result)
        .isNotNull()
        .isInstanceOf(Pod.class)
        .hasFieldOrPropertyWithValue("kind", "Pod")
        .hasFieldOrPropertyWithValue("apiVersion", "v1");
  }

  @Test
  @DisplayName("deserialize, with unregistered apiVersion and Kind, should return Generic Custom Resource")
  void deserializeWithUnregisteredApiVersionKindShouldReturnGenericCustomResource() throws Exception {
    // When
    final HasMetadata result = objectMapper.readerFor(KubernetesResource.class)
        .readValue("{\"kind\": \"CustomKind\", \"apiVersion\": \"custom/v1\"}");
    // Then
    assertThat(result)
        .isNotNull()
        .isInstanceOf(GenericKubernetesResource.class)
        .hasFieldOrPropertyWithValue("kind", "CustomKind")
        .hasFieldOrPropertyWithValue("apiVersion", "custom/v1");
  }
}
