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
package io.fabric8.kubernetes.api.model.apiextensions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static net.javacrumbs.jsonunit.core.Option.IGNORING_ARRAY_ORDER;
import static net.javacrumbs.jsonunit.core.Option.IGNORING_EXTRA_FIELDS;
import static net.javacrumbs.jsonunit.core.Option.TREATING_NULL_AS_ABSENT;
import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class JSONSchemaPropsOrStringArrayTest {
  private ObjectMapper objectMapper = new ObjectMapper();

  @Test
  void testLoadFromSchema() throws JsonProcessingException {
    // Given
    String jsonString = "{" +
      "\"description\": \"APIVersion defines the versioned schema of this representation\\nof an object. Servers should convert recognized schemas to the latest\\ninternal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#resources\"," +
      "\"type\": \"string\"" +
      "}";

    // When
    JSONSchemaPropsOrStringArray result = objectMapper.readValue(jsonString, JSONSchemaPropsOrStringArray.class);
    final String serializedJson = objectMapper.writeValueAsString(result);

    // Then
    assertNotNull(result);
    assertEquals("string", result.getSchema().getType());
    assertThatJson(serializedJson).when(IGNORING_ARRAY_ORDER, TREATING_NULL_AS_ABSENT, IGNORING_EXTRA_FIELDS)
      .isEqualTo(jsonString);
  }

  @Test
  void testLoadFromArray() throws JsonProcessingException {
    // Given
    String jsonString = "[\"one\", \"two\"]";

    // When
    JSONSchemaPropsOrStringArray result = objectMapper.readValue(jsonString, JSONSchemaPropsOrStringArray.class);
    final String serializedJson = objectMapper.writeValueAsString(result);

    // Then
    assertNotNull(result);
    assertEquals(2, result.getProperty().size());
    assertThatJson(serializedJson).when(IGNORING_ARRAY_ORDER, TREATING_NULL_AS_ABSENT, IGNORING_EXTRA_FIELDS)
      .isEqualTo(jsonString);
  }
}
