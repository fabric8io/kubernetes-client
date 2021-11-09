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
import org.mockito.MockedStatic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class UnmatchedFieldTypeModuleTest {

  private ObjectMapper objectMapper;
  private UnmatchedFieldTypeModule unmatchedFieldTypeModule;

  @BeforeEach
  void setUp() {
    objectMapper = new ObjectMapper();
    unmatchedFieldTypeModule = new UnmatchedFieldTypeModule(false, false);
    objectMapper.registerModule(unmatchedFieldTypeModule);
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
  @DisplayName("readValue, with restrict to templates and unmatched type,  should throw Exception")
  void readValueWithRestrictToTemplatesAndUnmatchedTypeFields() {
    // Given
    unmatchedFieldTypeModule.setRestrictToTemplates(true);
    final String json =
      "{\"kind\": \"ConfigMap\"," +
        "\"apiVersion\": \"v1\"," +
        "\"metadata\":{\"name\":\"the-name\"}," +
        "\"data\":{\"key\":\"value\"}," +
        "\"immutable\":\"${immutable}\"}";
    // When
    final MismatchedInputException result = assertThrows(MismatchedInputException.class, () ->
      objectMapper.readValue(json, KubernetesResource.class));
    // Then
    assertThat(result).hasMessageStartingWith("Cannot deserialize value of type `java.lang.Boolean` from String");
  }

  @Test
  @DisplayName("writeValueAsString, with additionalProperties overriding fields, additionalProperties are serialized and fields ignored")
  void writeValueAsStringWithAdditionalPropertiesOverridingFields() throws JsonProcessingException {
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

  @Test
  @DisplayName("writeValueAsString, with additionalProperties overriding fields and enabled log, should log warning")
  void writeValueAsStringWithAdditionalPropertiesOverridingFieldsShouldLogWarning() throws JsonProcessingException {
    try (MockedStatic<LoggerFactory> lfMock = mockStatic(LoggerFactory.class)) {
      // Given
      unmatchedFieldTypeModule.setLogWarnings(true);
      final ConfigMap configMap = new ConfigMapBuilder()
        .withNewMetadata().withName("name").endMetadata()
        .withImmutable(true)
        .build();
      configMap.getAdditionalProperties().put("immutable", "I'll trigger a warning");
      final Logger mockLogger = mock(Logger.class, RETURNS_DEEP_STUBS);
      lfMock.when(() -> LoggerFactory.getLogger(any(Class.class))).thenReturn(mockLogger);
      // When
      objectMapper.writeValueAsString(configMap);
      // Then
      verify(mockLogger, times(1))
        .warn("Value in field '{}' ignored in favor of value in additionalProperties ({}) for {}",
          "immutable", "I'll trigger a warning", "io.fabric8.kubernetes.api.model.ConfigMap");
    }
  }

  @Test
  @DisplayName("writeValueAsString, with additionalProperties overriding fields and disabled log, should NOT log warning")
  void writeValueAsStringWithAdditionalPropertiesOverridingFieldsShouldNotLogWarning() throws JsonProcessingException {
    try (MockedStatic<LoggerFactory> lfMock = mockStatic(LoggerFactory.class)) {
      // Given
      final ObjectMapper om = new ObjectMapper();
      final UnmatchedFieldTypeModule module = new UnmatchedFieldTypeModule();
      om.registerModule(module);
      module.setLogWarnings(false);
      final ConfigMap configMap = new ConfigMapBuilder()
        .withNewMetadata().withName("name").endMetadata()
        .withImmutable(true)
        .build();
      configMap.getAdditionalProperties().put("immutable", "I'll trigger a warning");
      final Logger mockLogger = mock(Logger.class, RETURNS_DEEP_STUBS);
      lfMock.when(() -> LoggerFactory.getLogger(any(Class.class))).thenReturn(mockLogger);
      // When
      om.writeValueAsString(configMap);
      // Then
      verify(mockLogger, never())
        .warn("Value in field '{}' ignored in favor of value in additionalProperties ({}) for {}",
          "immutable", "I'll trigger a warning", "io.fabric8.kubernetes.api.model.ConfigMap");
    }
  }

  private static class Example {
    public int value;
  }
}
