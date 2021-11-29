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
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

  @Test
  @DisplayName("equality should look at all fields")
  void equality() {
    // Given
    final GenericKubernetesResource gkr = new GenericKubernetesResource();
    gkr.setApiVersion("the-cr.example.com/v1");
    gkr.setKind("SomeCustomResource");
    gkr.setMetadata(new ObjectMetaBuilder().withName("custom-resource-example").build());
    gkr.setAdditionalProperties(Collections.singletonMap("spec", Collections.singletonMap("field", "value")));

    // clone
    final GenericKubernetesResource gkr1 = objectMapper.convertValue(gkr, GenericKubernetesResource.class);
    // Then
    assertThat(gkr)
      .isEqualTo(gkr1);

    gkr1.getAdditionalProperties().put("key", "value");

    assertThat(gkr)
      .isNotEqualTo(gkr1);
  }

  @Test
  @DisplayName("builder should initialize GenericKubernetesResource")
  void builder() {
    // Given
    GenericKubernetesResourceBuilder genericKubernetesResourceBuilder = new GenericKubernetesResourceBuilder()
      .withApiVersion("the-cr.example.com/v1")
      .withKind("SomeCustomResource")
      .withNewMetadata().withName("foo").withNamespace("ns1").endMetadata();

    // When
    GenericKubernetesResource genericKubernetesResource = genericKubernetesResourceBuilder.build();

    // Then
    assertThat(genericKubernetesResource)
      .hasFieldOrPropertyWithValue("kind", "SomeCustomResource")
      .hasFieldOrPropertyWithValue("apiVersion", "the-cr.example.com/v1")
      .hasFieldOrPropertyWithValue("metadata.namespace", "ns1")
      .hasFieldOrPropertyWithValue("metadata.name", "foo");
  }

  @Test
  @DisplayName("get with dot notation, with nested Maps, should return value")
  void getDotNotationWithNestedMapsFound() {
    // Given
    final GenericKubernetesResource gkr = new GenericKubernetesResource();
    gkr.setAdditionalProperties(Collections.singletonMap("spec",
      Collections.singletonMap("field", Collections.singletonMap("nested", 42))));
    // When
    final int result = gkr.get("spec.field.nested");
    // Then
    assertThat(result).isEqualTo(42);
  }

  @Test
  @DisplayName("get with path/varargs notation, with nested Maps, should return value")
  void getPathNotationWithNestedMapsFound() {
    // Given
    final GenericKubernetesResource gkr = new GenericKubernetesResource();
    gkr.setAdditionalProperties(Collections.singletonMap("spec",
      Collections.singletonMap("field", Collections.singletonMap("nested", 42))));
    // When
    final int result = gkr.get("spec", "field", "nested");
    // Then
    assertThat(result).isEqualTo(42);
  }

  @Test
  @DisplayName("get with mixed notation, with nested Maps, should return value")
  void getMixedNotationWithNestedMapsFound() {
    // Given
    final GenericKubernetesResource gkr = new GenericKubernetesResource();
    gkr.setAdditionalProperties(Collections.singletonMap("spec",
      Collections.singletonMap("field", Collections.singletonMap("nested", 42))));
    // When
    final int result = gkr.get("spec", "field.nested");
    // Then
    assertThat(result).isEqualTo(42);
  }

  @Test
  @DisplayName("get with mixed notation, with nested Maps and last path property missing, should return null")
  void getMixedNotationWithNestedMapsNotFound() {
    // Given
    final GenericKubernetesResource gkr = new GenericKubernetesResource();
    gkr.setAdditionalProperties(Collections.singletonMap("spec",
      Collections.singletonMap("field", Collections.singletonMap("nested", 42))));
    // When
    final Object result = gkr.get("spec", "field.not-here");
    // Then
    assertThat(result).isNull();
  }

  @Test
  @DisplayName("get with mixed notation, with nested Maps and traversed path property missing,  should throw Exception")
  void getMixedNotationWithNestedMapsException() {
    // Given
    final GenericKubernetesResource gkr = new GenericKubernetesResource();
    gkr.setAdditionalProperties(Collections.singletonMap("spec",
      Collections.singletonMap("field", Collections.singletonMap("nested", 42))));
    // When
    final IllegalArgumentException result = assertThrows(IllegalArgumentException.class, () ->
      gkr.get("spec", "field.nested.not.here"));
    // Then
    assertThat(result)
      .hasMessageContaining("Cannot get property 'spec.field.nested.not.here'")
      .hasMessageContaining("(missing segment 'not.here')");
  }

  @Test
  @DisplayName("get with wrong notation, with nested Maps and Arrays, should throw Exception")
  void getWrongNotationWithNestedMapsAndArraysException() {
    // Given
    final GenericKubernetesResource gkr = new GenericKubernetesResource();
    gkr.setAdditionalProperties(Collections.singletonMap("spec",
      Collections.singletonMap("field",
        Collections.singletonMap("nested", Arrays.asList(
          true, false, 1337
        )))));
    // When
    final NumberFormatException result = assertThrows(NumberFormatException.class, () ->
      gkr.get("spec", "field.nested["+(Integer.MAX_VALUE+1L)+"]"));
    // Then
    assertThat(result)
      .hasMessageContaining("For input string")
      .hasMessageContaining("2147483648");
  }

  @Test
  @DisplayName("get, with nested Maps and Arrays, should return value")
  void getWithNestedMapsAndArraysFound() {
    // Given
    final GenericKubernetesResource gkr = new GenericKubernetesResource();
    gkr.setAdditionalProperties(Collections.singletonMap("spec",
      Collections.singletonMap("field",
        Collections.singletonMap("nested", Arrays.asList(
          true, false, 1337
        )))));
    // When
    final boolean result = gkr.get("spec", "field.nested[1]");
    // Then
    assertThat(result).isFalse();
  }

  @Test
  @DisplayName("get, with nested Maps and Arrays with Maps, should return value")
  void getWithNestedMapsAndArraysWithMapsFound() {
    // Given
    final GenericKubernetesResource gkr = new GenericKubernetesResource();
    gkr.setAdditionalProperties(Collections.singletonMap("spec",
      Collections.singletonMap("field",
        Collections.singletonMap("nested", Arrays.asList(
          Collections.singletonMap("objectField", "Atomic"),
          Collections.singletonMap("objectField", "Particles")
        )))));
    // When
    final String result = gkr.get("spec", "field.nested[1].objectField");
    // Then
    assertThat(result).isEqualTo("Particles");
  }

  @Test
  @DisplayName("get, with nested Maps and invalid array reference, should throw Exception")
  void getWithNestedMapsAndInvalidArrayReferenceShouldThrowException() {
    // Given
    final GenericKubernetesResource gkr = new GenericKubernetesResource();
    gkr.setAdditionalProperties(Collections.singletonMap("spec",
      Collections.singletonMap("field", Collections.singletonMap("nested",
        Collections.singletonMap("not", "an-array")))));
    // When
    final ClassCastException result = assertThrows(ClassCastException.class, () ->
      gkr.get("spec", "field.nested[1].not"));
    // Then
    assertThat(result)
      .hasMessageContaining("cannot be cast to")
      .hasMessageContaining("Collection");
  }

  @Test
  @DisplayName("get, with dots in field, should return value")
  void getWithDotsInFieldFound() {
    // Given
    final GenericKubernetesResource gkr = new GenericKubernetesResource();
    gkr.setAdditionalProperties(Collections.singletonMap("spec",
      Collections.singletonMap("field.with.dots",
        Collections.singletonMap("check", "mate")
      )));
    // When
    final String result = gkr.get("spec", "field\\.with\\.dots.check");
    // Then
    assertThat(result).isEqualTo("mate");
  }

  @Test
  @DisplayName("get, with with 2D array, should return value")
  void getWith2DArrayInFieldFound() {
    // Given
    final GenericKubernetesResource gkr = new GenericKubernetesResource();
    gkr.setAdditionalProperties(Collections.singletonMap("spec",
      Collections.singletonMap("nested",
        Collections.singletonMap("2dList", Arrays.asList(
          Arrays.asList(
            Collections.singletonMap("entry", 0),
            Collections.singletonMap("entry", 1),
            Collections.singletonMap("entry", 2)
          ),
          Collections.singletonList(Collections.singletonMap("entry", 3))
        )))));
    // When
    final int result = gkr.get("spec.nested.2dList[1][0].entry");
    // Then
    assertThat(result).isEqualTo(3);
  }

  @Test
  @DisplayName("get, with with multidimensional array, should return value")
  void getWithMultidimensionalArrayInFieldFound() {
    // Given
    final GenericKubernetesResource gkr = new GenericKubernetesResource();
    gkr.setAdditionalProperties(Collections.singletonMap("spec",
      Collections.singletonMap("nested",
        Collections.singletonMap("multidimensional", Collections.singletonList(
          Collections.singletonList(
            Collections.singletonList(
              Arrays.asList(
                Collections.singletonMap("entry", 0),
                Collections.singletonMap("entry", 1),
                Collections.singletonMap("entry", 2)
              )
            )))))));
    // When
    final int result = gkr.get("spec.nested.multidimensional[0][0][0][2].entry");
    // Then
    assertThat(result).isEqualTo(2);
  }

  @Test
  @DisplayName("get, with complex-structure-resource, should return queried values")
  void getWithComplexStructureShouldRetrieveQueried() throws Exception {
    // Given
    // When
    final GenericKubernetesResource result = objectMapper
      .readValue(load("complex-structure-resource.json"), GenericKubernetesResource.class);
    // Then
    assertThat(result)
      .returns(42, gkr -> gkr.get("spec.dot\\.in\\.field"))
      .returns(3, gkr -> gkr.get("spec.nested.2dList[1][0].entry"));
  }

  private static InputStream load(String resource) {
    return GenericKubernetesResource.class.getResourceAsStream("/generic-kubernetes-resource/" + resource);
  }
}
