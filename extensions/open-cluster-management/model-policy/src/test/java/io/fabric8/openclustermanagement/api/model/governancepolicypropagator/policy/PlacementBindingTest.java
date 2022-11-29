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
package io.fabric8.openclustermanagement.api.model.governancepolicypropagator.policy;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.openclustermanagement.api.model.governancepolicypropagator.policy.v1.PlacementBinding;
import io.fabric8.openclustermanagement.api.model.governancepolicypropagator.policy.v1.PlacementBindingBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PlacementBindingTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-placementbinding.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final PlacementBinding placementBinding = mapper.readValue(originalJson, PlacementBinding.class);
    final String serializedJson = mapper.writeValueAsString(placementBinding);
    final PlacementBinding placementBindingFromSerializedJson = mapper.readValue(serializedJson, PlacementBinding.class);

    // Then
    assertNotNull(placementBinding);
    assertNotNull(serializedJson);
    assertNotNull(placementBindingFromSerializedJson);
    assertEquals(placementBinding.getMetadata().getName(), placementBindingFromSerializedJson.getMetadata().getName());
    assertEquals("test-policy-pb", placementBinding.getMetadata().getName());
    assertEquals("test-policy-plr", placementBinding.getPlacementRef().getName());
    assertEquals("PlacementRule", placementBinding.getPlacementRef().getKind());
    assertEquals(1, placementBinding.getSubjects().size());
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    PlacementBindingBuilder placementBindingBuilder = new PlacementBindingBuilder()
        .withNewMetadata()
        .withName("test-policy-pb")
        .endMetadata()
        .withNewPlacementRef()
        .withName("test-policy-plr")
        .withApiGroup("apps.open-cluster-management.io")
        .withKind("PlacementRule")
        .endPlacementRef()
        .addNewSubject()
        .withName("test-policy")
        .withApiGroup("policy.open-cluster-management.io")
        .withKind("Policy")
        .endSubject();

    // When
    PlacementBinding placementBinding = placementBindingBuilder.build();

    // Then
    assertNotNull(placementBinding);
    assertEquals("test-policy-pb", placementBinding.getMetadata().getName());
    assertEquals("test-policy-plr", placementBinding.getPlacementRef().getName());
    assertEquals("PlacementRule", placementBinding.getPlacementRef().getKind());
    assertEquals("apps.open-cluster-management.io", placementBinding.getPlacementRef().getApiGroup());
    assertEquals(1, placementBinding.getSubjects().size());
  }
}
