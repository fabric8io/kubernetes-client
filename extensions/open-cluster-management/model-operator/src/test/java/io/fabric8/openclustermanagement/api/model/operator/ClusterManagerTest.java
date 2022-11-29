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
package io.fabric8.openclustermanagement.api.model.operator;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.openclustermanagement.api.model.operator.v1.ClusterManager;
import io.fabric8.openclustermanagement.api.model.operator.v1.ClusterManagerBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ClusterManagerTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-clustermanager.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final ClusterManager clusterManager = mapper.readValue(originalJson, ClusterManager.class);
    final String serializedJson = mapper.writeValueAsString(clusterManager);
    final ClusterManager clusterManagerFromSerializedJson = mapper.readValue(serializedJson, ClusterManager.class);

    // Then
    assertNotNull(clusterManager);
    assertNotNull(serializedJson);
    assertNotNull(clusterManagerFromSerializedJson);
    assertEquals(clusterManager.getMetadata().getName(), clusterManagerFromSerializedJson.getMetadata().getName());
    assertEquals("quay.io/open-cluster-management/registration", clusterManager.getSpec().getRegistrationImagePullSpec());
    assertEquals("quay.io/open-cluster-management/work", clusterManager.getSpec().getWorkImagePullSpec());
    assertEquals("quay.io/open-cluster-management/placement", clusterManager.getSpec().getPlacementImagePullSpec());
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    ClusterManagerBuilder clusterManagerBuilder = new ClusterManagerBuilder()
        .withNewMetadata()
        .withName("cluster-manager")
        .endMetadata()
        .withNewSpec()
        .withRegistrationImagePullSpec("quay.io/open-cluster-management/registration")
        .withWorkImagePullSpec("quay.io/open-cluster-management/work")
        .withPlacementImagePullSpec("quay.io/open-cluster-management/placement")
        .endSpec();

    // When
    ClusterManager clusterManager = clusterManagerBuilder.build();

    // Then
    assertNotNull(clusterManager);
    assertEquals("cluster-manager", clusterManager.getMetadata().getName());
    assertEquals("quay.io/open-cluster-management/registration", clusterManager.getSpec().getRegistrationImagePullSpec());
    assertEquals("quay.io/open-cluster-management/work", clusterManager.getSpec().getWorkImagePullSpec());
    assertEquals("quay.io/open-cluster-management/placement", clusterManager.getSpec().getPlacementImagePullSpec());
  }
}
