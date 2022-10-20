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
package io.fabric8.openclustermanagement.api.model.cluster;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.openclustermanagement.api.model.cluster.v1alpha1.Placement;
import io.fabric8.openclustermanagement.api.model.cluster.v1alpha1.PlacementBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PlacementTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-placement.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final Placement placement = mapper.readValue(originalJson, Placement.class);
    final String serializedJson = mapper.writeValueAsString(placement);
    final Placement placementFromSerializedJson = mapper.readValue(serializedJson, Placement.class);

    // Then
    assertNotNull(placement);
    assertNotNull(serializedJson);
    assertNotNull(placementFromSerializedJson);
    assertEquals(placement.getMetadata().getName(), placementFromSerializedJson.getMetadata().getName());
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    PlacementBuilder placementBuilder = new PlacementBuilder()
        .withNewMetadata()
        .withName("placement1")
        .withNamespace("ns1")
        .endMetadata()
        .withNewSpec()
        .addNewPredicate()
        .withNewRequiredClusterSelector()
        .withNewLabelSelector()
        .addToMatchLabels("vendor", "OpenShift")
        .endLabelSelector()
        .endRequiredClusterSelector()
        .endPredicate()
        .endSpec();

    // When
    Placement placement = placementBuilder.build();

    // Then
    assertNotNull(placement);
    assertEquals("placement1", placement.getMetadata().getName());
    assertEquals(1, placement.getSpec().getPredicates().size());
    assertEquals("OpenShift", placement.getSpec().getPredicates().get(0)
        .getRequiredClusterSelector()
        .getLabelSelector()
        .getMatchLabels()
        .get("vendor"));
  }
}
