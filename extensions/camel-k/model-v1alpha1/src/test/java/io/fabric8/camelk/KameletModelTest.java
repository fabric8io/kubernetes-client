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
package io.fabric8.camelk;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.camelk.v1alpha1.JSONSchemaPropsBuilder;
import io.fabric8.camelk.v1alpha1.Kamelet;
import io.fabric8.camelk.v1alpha1.KameletBuilder;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class KameletModelTest {

  @Test
  void shouldCreateKamelet() {
    Kamelet kamelet = new KameletBuilder()
        .withNewMetadata()
        .withName("my-kamelet")
        .endMetadata()
        .withNewSpec()
        .withDefinition(new JSONSchemaPropsBuilder()
            // blah blah
            .build())
        .endSpec()
        .build();

    assertNotNull(kamelet);
    assertEquals("my-kamelet", kamelet.getMetadata().getName());
  }

  @Test
  void shouldDeserializeValidYamlIntoObject() throws JsonProcessingException {
    final ObjectMapper mapper = new ObjectMapper();
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-kamelet.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final Kamelet kamelet = mapper.readValue(originalJson, Kamelet.class);
    final String serializedJson = mapper.writeValueAsString(kamelet);
    final Kamelet kameletFromSerializedJson = mapper.readValue(serializedJson, Kamelet.class);

    // Then
    assertNotNull(kamelet);
    assertNotNull(serializedJson);
    assertNotNull(kameletFromSerializedJson);
    assertEquals(kamelet.getMetadata().getName(), kameletFromSerializedJson.getMetadata().getName());
    assertNotNull(kamelet.getSpec().getTemplate());
    assertFalse(kamelet.getSpec().getTemplate().isEmpty());
    assertTrue(kamelet.getSpec().getTemplate().containsKey("beans"));
    assertTrue(kamelet.getSpec().getTemplate().containsKey("from"));
  }

  @Test
  void shouldDeserializeValidYamlContainingCamelJSONSchemaProps() throws JsonProcessingException {
    final ObjectMapper mapper = new ObjectMapper();
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-kamelet-x-descriptors.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final Kamelet kamelet = mapper.readValue(originalJson, Kamelet.class);
    final String serializedJson = mapper.writeValueAsString(kamelet);
    final Kamelet kameletFromSerializedJson = mapper.readValue(serializedJson, Kamelet.class);

    // Then
    assertNotNull(kamelet);
    assertNotNull(serializedJson);
    assertNotNull(kameletFromSerializedJson);
    assertEquals(kamelet.getMetadata().getName(), kameletFromSerializedJson.getMetadata().getName());
    assertNotNull(kamelet.getSpec().getDefinition());
    assertNotNull(kamelet.getSpec().getDefinition().getProperties());
    assertNotNull(kamelet.getSpec().getDefinition().getProperties().get("validate"));
    assertEquals(Collections.singletonList("urn:alm:descriptor:com.tectonic.ui:checkbox"),
        kamelet.getSpec().getDefinition().getProperties().get("validate").getXDescriptors());
  }
}
