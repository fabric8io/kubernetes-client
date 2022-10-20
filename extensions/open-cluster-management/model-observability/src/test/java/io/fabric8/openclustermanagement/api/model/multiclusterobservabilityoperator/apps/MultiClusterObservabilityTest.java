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
package io.fabric8.openclustermanagement.api.model.multiclusterobservabilityoperator.apps;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.openclustermanagement.api.model.multiclusterobservabilityoperator.apps.v1beta2.MultiClusterObservability;
import io.fabric8.openclustermanagement.api.model.multiclusterobservabilityoperator.apps.v1beta2.MultiClusterObservabilityBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MultiClusterObservabilityTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-multiclusterobservability.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final MultiClusterObservability multiClusterObservability = mapper.readValue(originalJson, MultiClusterObservability.class);
    final String serializedJson = mapper.writeValueAsString(multiClusterObservability);
    final MultiClusterObservability mchFromSerializedJson = mapper.readValue(serializedJson, MultiClusterObservability.class);

    // Then
    assertNotNull(multiClusterObservability);
    assertNotNull(serializedJson);
    assertNotNull(mchFromSerializedJson);
    assertEquals(multiClusterObservability.getMetadata().getName(), mchFromSerializedJson.getMetadata().getName());
    assertNotNull(multiClusterObservability.getSpec().getObservabilityAddonSpec());
    assertTrue(multiClusterObservability.getSpec().getObservabilityAddonSpec().getEnableMetrics());
    assertEquals(10, multiClusterObservability.getSpec().getObservabilityAddonSpec().getInterval());
    assertEquals(1, multiClusterObservability.getSpec().getObservabilityAddonSpec().getResources().getLimits().size());
    assertEquals(1, multiClusterObservability.getSpec().getObservabilityAddonSpec().getResources().getRequests().size());
    assertEquals("thanos-object-storage",
        multiClusterObservability.getSpec().getStorageConfig().getMetricObjectStorage().getName());
    assertEquals("thanos.yaml", multiClusterObservability.getSpec().getStorageConfig().getMetricObjectStorage().getKey());
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    MultiClusterObservabilityBuilder multiClusterObservabilityBuilder = new MultiClusterObservabilityBuilder()
        .withNewMetadata()
        .withName("sample_mch")
        .endMetadata()
        .withNewSpec()
        .endSpec();

    // When
    MultiClusterObservability mch = multiClusterObservabilityBuilder.build();

    // Then
    assertNotNull(mch);
    assertEquals("sample_mch", mch.getMetadata().getName());
  }
}
