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
package io.fabric8.openclustermanagement.api.model.multicloudoperatorsplacementrule.apps;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorsplacementrule.apps.v1.PlacementRule;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorsplacementrule.apps.v1.PlacementRuleBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PlacementRuleTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-placementrule.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final PlacementRule placementRule = mapper.readValue(originalJson, PlacementRule.class);
    final String serializedJson = mapper.writeValueAsString(placementRule);
    final PlacementRule prFromSerializedJson = mapper.readValue(serializedJson, PlacementRule.class);

    // Then
    assertNotNull(placementRule);
    assertNotNull(serializedJson);
    assertNotNull(prFromSerializedJson);
    assertEquals(placementRule.getMetadata().getName(), prFromSerializedJson.getMetadata().getName());
    assertEquals(1, placementRule.getSpec().getClusterReplicas());
    assertEquals(3, placementRule.getSpec().getClusters().size());
    assertEquals(1, placementRule.getSpec().getClusterConditions().size());
    assertEquals("ManagedClusterConditionAvailable", placementRule.getSpec().getClusterConditions().get(0).getType());
    assertEquals("True", placementRule.getSpec().getClusterConditions().get(0).getStatus());
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    PlacementRuleBuilder placementRuleBuilder = new PlacementRuleBuilder()
        .withNewMetadata()
        .withName("all-ready-clusters")
        .endMetadata()
        .withNewSpec()
        .withClusterReplicas(1)
        .addNewClusterCondition()
        .withStatus("True")
        .withType("ManagedClusterConditionAvailable")
        .endClusterCondition()
        .addNewCluster().withName("cluster1").endCluster()
        .addNewCluster().withName("cluster2").endCluster()
        .addNewCluster().withName("cluster3").endCluster()
        .endSpec();

    // When
    PlacementRule placementRule = placementRuleBuilder.build();

    // Then
    assertNotNull(placementRule);
    assertEquals("all-ready-clusters", placementRule.getMetadata().getName());
    assertEquals(1, placementRule.getSpec().getClusterReplicas());
    assertEquals(3, placementRule.getSpec().getClusters().size());
    assertEquals(1, placementRule.getSpec().getClusterConditions().size());
    assertEquals("ManagedClusterConditionAvailable", placementRule.getSpec().getClusterConditions().get(0).getType());
    assertEquals("True", placementRule.getSpec().getClusterConditions().get(0).getStatus());
  }
}
