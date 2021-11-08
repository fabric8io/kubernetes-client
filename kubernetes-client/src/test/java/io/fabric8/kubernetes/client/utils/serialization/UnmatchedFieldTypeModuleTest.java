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
package io.fabric8.kubernetes.client.utils.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.ConfigMapBuilder;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.apps.Deployment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UnmatchedFieldTypeModuleTest {

  private ObjectMapper objectMapper;

  @BeforeEach
  void setUp() {
    objectMapper = new ObjectMapper();
    objectMapper.registerModule(new UnmatchedFieldTypeModule());
  }

  @Test
  @DisplayName("readValue, with unknown fields, values are set in additionalProperties map")
  void readValueWithUnknownFields() throws JsonProcessingException {
    // Given
    final String json =
      "{\"kind\": \"ConfigMap\"," +
        "\"apiVersion\": \"v1\"," +
        "\"metadata\":{\"name\":\"the-name\"}," +
        "\"data\":{\"key\":\"value\"}," +
        "\"unknownField\":\"unknownValue\"}";
    // When
    final KubernetesResource result = objectMapper.readValue(json, KubernetesResource.class);
    // Then
    assertThat(result)
      .isInstanceOf(ConfigMap.class)
      .hasFieldOrPropertyWithValue("metadata.name", "the-name")
      .hasFieldOrPropertyWithValue("data.key", "value")
      .hasFieldOrPropertyWithValue("additionalProperties.unknownField", "unknownValue");
  }

  @Test
  @DisplayName("readValue, with unmatched type fields, values are set in additionalProperties map")
  void readValueWithUnmatchedTypeFields() throws JsonProcessingException {
    // Given
    final String json =
      "{\"kind\": \"ConfigMap\"," +
        "\"apiVersion\": \"v1\"," +
        "\"metadata\":{\"name\":\"the-name\"}," +
        "\"data\":{\"key\":\"value\"}," +
        "\"unknownField\":\"unknownValue\"," +
        "\"immutable\":\"${immutable}\"}";
    // When
    final KubernetesResource result = objectMapper.readValue(json, KubernetesResource.class);
    // Then
    assertThat(result)
      .isInstanceOf(ConfigMap.class)
      .hasFieldOrPropertyWithValue("metadata.name", "the-name")
      .hasFieldOrPropertyWithValue("immutable", null)
      .hasFieldOrPropertyWithValue("additionalProperties.unknownField", "unknownValue")
      .hasFieldOrPropertyWithValue("additionalProperties.immutable", "${immutable}");
  }

  @Test
  @DisplayName("readValue, with unmatched type nested fields, values are set in additionalProperties map")
  void readValueWithUnmatchedTypeNestedFields() throws JsonProcessingException {
    // Given
    final String json =
      "{\"kind\": \"Deployment\"," +
        "\"apiVersion\": \"apps/v1\"," +
        "\"metadata\":{\"name\":\"deployment\", \"annotations\": \"${annotations}\"}," +
        "\"spec\":{\"replicas\":\"${replicas}\",\"paused\":true}," +
        "\"unknownField\":\"unknownValue\"}";
    // When
    final KubernetesResource result = objectMapper.readValue(json, KubernetesResource.class);
    // Then
    assertThat(result)
      .isInstanceOf(Deployment.class)
      .hasFieldOrPropertyWithValue("metadata.name", "deployment")
      .hasFieldOrPropertyWithValue("metadata.annotations", null)
      .hasFieldOrPropertyWithValue("metadata.additionalProperties.annotations", "${annotations}")
      .hasFieldOrPropertyWithValue("spec.paused", true)
      .hasFieldOrPropertyWithValue("spec.replicas", null)
      .hasFieldOrPropertyWithValue("spec.additionalProperties.replicas", "${replicas}")
      .hasFieldOrPropertyWithValue("additionalProperties.unknownField", "unknownValue");
  }

  @Test
  @DisplayName("readValue, with no anySetter, should throw Exception")
  void readValueWithNoAnySetterShouldThrowException()  {
    // Given
    final String json = "{\"value\": false}";
    // When
    final MismatchedInputException result = assertThrows(MismatchedInputException.class, () ->
      objectMapper.readValue(json, Example.class));
    // Then
    assertThat(result).hasMessageStartingWith("Cannot deserialize value of type `int` from Boolean value");
  }

  @Test
  @DisplayName("writeValueAsString, with unmatched type fields, values are set in additionalProperties map")
  void marshalWithAdditionalPropertiesOverridingFields() throws JsonProcessingException {
    // Given
    final ConfigMap configMap = new ConfigMapBuilder()
      .withNewMetadata().withName("name").addToAnnotations("key", "ignored").addToLabels("lKey", "value").endMetadata()
      .withImmutable(true)
      .build();
    configMap.getAdditionalProperties().put("unknownField", "unknownValue");
    configMap.getAdditionalProperties().put("immutable", "${immutable}");
    configMap.getMetadata().getAdditionalProperties().put("annotations", "${annotations}");
    // When
    final String result = objectMapper.writeValueAsString(configMap);
    // Then
    assertThat(result).isEqualTo("{" +
      "\"apiVersion\":\"v1\"," +
      "\"kind\":\"ConfigMap\"," +
      "\"metadata\":{\"labels\":{\"lKey\":\"value\"},\"name\":\"name\",\"annotations\":\"${annotations}\"}," +
      "\"immutable\":\"${immutable}\"," +
      "\"unknownField\":\"unknownValue\"" +
      "}");
  }

  private static class Example {
    public int value;
  }
}
