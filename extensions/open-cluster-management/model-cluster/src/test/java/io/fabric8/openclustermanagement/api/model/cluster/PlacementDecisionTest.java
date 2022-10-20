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
import io.fabric8.openclustermanagement.api.model.cluster.v1alpha1.PlacementDecision;
import io.fabric8.openclustermanagement.api.model.cluster.v1alpha1.PlacementDecisionBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PlacementDecisionTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-placementdecision.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final PlacementDecision placementDecision = mapper.readValue(originalJson, PlacementDecision.class);
    final String serializedJson = mapper.writeValueAsString(placementDecision);
    final PlacementDecision placementDecisionFromSerializedJson = mapper.readValue(serializedJson, PlacementDecision.class);

    // Then
    assertNotNull(placementDecision);
    assertNotNull(serializedJson);
    assertNotNull(placementDecisionFromSerializedJson);
    assertEquals(placementDecision.getMetadata().getName(), placementDecisionFromSerializedJson.getMetadata().getName());
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    PlacementDecisionBuilder placementDecisionBuilder = new PlacementDecisionBuilder()
        .withNewMetadata()
        .addToLabels("vendor", "OpenShift")
        .withName("placement1-decision1")
        .endMetadata()
        .withNewStatus()
        .addNewDecision()
        .withClusterName("cluster1")
        .withReason("somereason")
        .endDecision()
        .endStatus();

    // When
    PlacementDecision placementDecision = placementDecisionBuilder.build();

    // Then
    assertNotNull(placementDecision);
    assertEquals("placement1-decision1", placementDecision.getMetadata().getName());
    assertEquals(1, placementDecision.getStatus().getDecisions().size());
  }
}
