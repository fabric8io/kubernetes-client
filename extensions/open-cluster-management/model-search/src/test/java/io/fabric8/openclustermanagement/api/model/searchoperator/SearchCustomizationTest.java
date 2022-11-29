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
package io.fabric8.openclustermanagement.api.model.searchoperator;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.openclustermanagement.api.model.searchoperator.v1alpha1.SearchCustomization;
import io.fabric8.openclustermanagement.api.model.searchoperator.v1alpha1.SearchCustomizationBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SearchCustomizationTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-searchcustomization.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final SearchCustomization searchCustomization = mapper.readValue(originalJson, SearchCustomization.class);
    final String serializedJson = mapper.writeValueAsString(searchCustomization);
    final SearchCustomization scFromSerializedJson = mapper.readValue(serializedJson, SearchCustomization.class);

    // Then
    assertNotNull(searchCustomization);
    assertNotNull(serializedJson);
    assertNotNull(scFromSerializedJson);
    assertEquals(searchCustomization.getMetadata().getName(), scFromSerializedJson.getMetadata().getName());
    assertTrue(searchCustomization.getSpec().getPersistence());
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    SearchCustomizationBuilder searchCustomizationBuilder = new SearchCustomizationBuilder()
        .withNewMetadata()
        .withName("searchcustomization")
        .endMetadata()
        .withNewSpec()
        .withPersistence(true)
        .endSpec();

    // When
    SearchCustomization searchCustomization = searchCustomizationBuilder.build();

    // Then
    assertNotNull(searchCustomization);
    assertEquals("searchcustomization", searchCustomization.getMetadata().getName());
    assertTrue(searchCustomization.getSpec().getPersistence());
  }
}
