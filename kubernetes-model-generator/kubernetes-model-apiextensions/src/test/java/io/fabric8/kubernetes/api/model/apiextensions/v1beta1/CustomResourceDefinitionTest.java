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
package io.fabric8.kubernetes.api.model.apiextensions.v1beta1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.model.util.Helper;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static net.javacrumbs.jsonunit.core.Option.IGNORING_ARRAY_ORDER;
import static net.javacrumbs.jsonunit.core.Option.IGNORING_EXTRA_FIELDS;
import static net.javacrumbs.jsonunit.core.Option.TREATING_NULL_AS_ABSENT;
import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CustomResourceDefinitionTest {
  private final ObjectMapper objectMapper = new ObjectMapper();

  @Test
  public void testBuilder() {
    CustomResourceDefinition crd = new io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionBuilder()
        .withApiVersion("apiextensions.k8s.io/v1beta1")
        .withNewMetadata()
        .withName("itests.examples.fabric8.io")
        .endMetadata()
        .withNewSpec()
        .withGroup("examples.fabric8.io")
        .withVersion("v1")
        .addAllToVersions(Collections
            .singletonList(new io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionVersionBuilder()
                .withName("v1")
                .withServed(true)
                .withStorage(true)
                .build()))
        .withScope("Namespaced")
        .withNewNames()
        .withPlural("itests")
        .withSingular("itest")
        .withKind("Itest")
        .withShortNames("it")
        .endNames()
        .endSpec()
        .build();

    assertEquals("itests.examples.fabric8.io", crd.getMetadata().getName());
    assertEquals("examples.fabric8.io", crd.getSpec().getGroup());
    assertEquals("v1", crd.getSpec().getVersion());
    assertEquals("Namespaced", crd.getSpec().getScope());
  }

  @Test
  void testLoadFromJsonSchemaPropsOrBool() throws JsonProcessingException {
    // Given
    final String originalJson = Helper.loadJson("/valid-crd.json");

    // when
    final CustomResourceDefinition customResourceDefinition = objectMapper.readValue(originalJson,
        CustomResourceDefinition.class);
    final String serializedJson = objectMapper.writeValueAsString(customResourceDefinition);

    // then
    assertThatJson(serializedJson).when(IGNORING_ARRAY_ORDER, TREATING_NULL_AS_ABSENT, IGNORING_EXTRA_FIELDS)
        .isEqualTo(originalJson);
  }

  @Test
  void testLoadFromJsonSchemaPropsOrArray() throws JsonProcessingException {
    // Given
    String jsonString = Helper.loadJson("/valid-crd-jsonschemapropsorarray.json");

    // When
    CustomResourceDefinition result = objectMapper.readValue(jsonString, CustomResourceDefinition.class);
    final String serializedJson = objectMapper.writeValueAsString(result);

    // Then
    assertNotNull(result);

    // then
    assertThatJson(serializedJson).when(IGNORING_ARRAY_ORDER, TREATING_NULL_AS_ABSENT, IGNORING_EXTRA_FIELDS)
        .isEqualTo(jsonString);
  }

  @Test
  void testLoadFromJsonSchemaPropsOrStringArray() throws JsonProcessingException {
    // Given
    String jsonString = Helper.loadJson("/valid-crd-jsonschemapropsorstringarray.json");

    // When
    CustomResourceDefinition result = objectMapper.readValue(jsonString, CustomResourceDefinition.class);
    final String serializedJson = objectMapper.writeValueAsString(result);

    // Then
    assertNotNull(result);

    // then
    assertThatJson(serializedJson).when(IGNORING_ARRAY_ORDER, TREATING_NULL_AS_ABSENT, IGNORING_EXTRA_FIELDS)
        .isEqualTo(jsonString);
  }
}
