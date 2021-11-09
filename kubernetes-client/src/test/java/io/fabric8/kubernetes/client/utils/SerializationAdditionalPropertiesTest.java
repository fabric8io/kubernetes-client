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
package io.fabric8.kubernetes.client.utils;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.ConfigMapBuilder;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.client.KubernetesClientException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SerializationAdditionalPropertiesTest {

  @AfterEach
  void tearDown() {
    // Revert to initial state
    Serialization.UNMATCHED_FIELD_TYPE_MODULE.setRestrictToTemplates(true);
  }

  @Test
  @DisplayName("unmarshal, with unknown fields, values are set in additionalProperties map")
  void unmarshalWithUnknownFields() {
    // Given
    final String marshalled =
      "{\"kind\": \"ConfigMap\"," +
        "\"apiVersion\": \"v1\"," +
        "\"metadata\":{\"name\":\"the-name\"}," +
        "\"data\":{\"key\":\"value\"}," +
        "\"unknownField\":\"unknownValue\"}";
    // When
    final KubernetesResource result = Serialization.unmarshal(marshalled);
    // Then
    assertThat(result)
      .isInstanceOf(ConfigMap.class)
      .hasFieldOrPropertyWithValue("metadata.name", "the-name")
      .hasFieldOrPropertyWithValue("data.key", "value")
      .hasFieldOrPropertyWithValue("additionalProperties.unknownField", "unknownValue");
  }

  @Test
  @DisplayName("unmarshal, with unmatched type fields, should throw Exception")
  void unmarshalWithUnmatchedTypeFieldsAndDefaults() {
    // Given
    final String marshalled =
      "{\"kind\": \"ConfigMap\"," +
        "\"apiVersion\": \"v1\"," +
        "\"metadata\":{\"name\":\"the-name\"}," +
        "\"data\":{\"key\":\"value\"}," +
        "\"immutable\":\"${immutable}\"}";
    // When
    final KubernetesClientException result = assertThrows(KubernetesClientException.class, () ->
      Serialization.unmarshal(marshalled));
    // Then
    assertThat(result)
      .getCause()
      .isInstanceOf(InvalidFormatException.class)
      .hasMessageStartingWith("Cannot deserialize value of type `java.lang.Boolean` from String \"${immutable}\"");
  }

  @Test
  @DisplayName("unmarshal, with unmatched type fields and unrestricted, values are set in additionalProperties map")
  void unmarshalWithUnmatchedTypeFields() {
    // Given
    Serialization.UNMATCHED_FIELD_TYPE_MODULE.setRestrictToTemplates(false);
    final String marshalled =
      "{\"kind\": \"ConfigMap\"," +
        "\"apiVersion\": \"v1\"," +
        "\"metadata\":{\"name\":\"the-name\"}," +
        "\"data\":{\"key\":\"value\"}," +
        "\"unknownField\":\"unknownValue\"," +
        "\"immutable\":\"${immutable}\"}";
    // When
    final KubernetesResource result = Serialization.unmarshal(marshalled);
    // Then
    assertThat(result)
      .isInstanceOf(ConfigMap.class)
      .hasFieldOrPropertyWithValue("metadata.name", "the-name")
      .hasFieldOrPropertyWithValue("immutable", null)
      .hasFieldOrPropertyWithValue("additionalProperties.unknownField", "unknownValue")
      .hasFieldOrPropertyWithValue("additionalProperties.immutable", "${immutable}");
  }

  @Test
  @DisplayName("unmarshal, with unmatched type nested fields and unrestricted, values are set in additionalProperties map")
  void unmarshalWithUnmatchedTypeNestedFields() {
    // Given
    Serialization.UNMATCHED_FIELD_TYPE_MODULE.setRestrictToTemplates(false);
    final String marshalled =
      "{\"kind\": \"Deployment\"," +
        "\"apiVersion\": \"apps/v1\"," +
        "\"metadata\":{\"name\":\"deployment\", \"annotations\": \"${annotations}\"}," +
        "\"spec\":{\"replicas\":\"${replicas}\",\"paused\":true}," +
        "\"unknownField\":\"unknownValue\"}";
    // When
    final KubernetesResource result = Serialization.unmarshal(marshalled);
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
  @DisplayName("marshal, with unmatched type fields, values are set in additionalProperties map")
  void marshalWithAdditionalPropertiesOverridingFields() {
    // Given
    final ConfigMap configMap = new ConfigMapBuilder()
      .withNewMetadata().withName("name").addToAnnotations("key", "value").endMetadata()
      .withImmutable(true)
      .build();
    configMap.getAdditionalProperties().put("unknownField", "unknownValue");
    configMap.getAdditionalProperties().put("immutable", "${immutable}");
    configMap.getMetadata().getAdditionalProperties().put("annotations", "${annotations}");
    // When
    final String result = Serialization.asJson(configMap);
    // Then
    assertThat(result).isEqualTo("{" +
      "\"apiVersion\":\"v1\"," +
      "\"kind\":\"ConfigMap\"," +
      "\"metadata\":{\"name\":\"name\",\"annotations\":\"${annotations}\"}," +
      "\"immutable\":\"${immutable}\"," +
      "\"unknownField\":\"unknownValue\"" +
      "}");
  }

}
