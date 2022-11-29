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
import io.fabric8.openclustermanagement.api.model.cluster.v1.ManagedCluster;
import io.fabric8.openclustermanagement.api.model.cluster.v1.ManagedClusterBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ManagedClusterTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-managedcluster.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final ManagedCluster managedCluster = mapper.readValue(originalJson, ManagedCluster.class);
    final String serializedJson = mapper.writeValueAsString(managedCluster);
    final ManagedCluster managedClusterFromSerializedJson = mapper.readValue(serializedJson, ManagedCluster.class);

    // Then
    assertNotNull(managedCluster);
    assertNotNull(serializedJson);
    assertNotNull(managedClusterFromSerializedJson);
    assertEquals(managedCluster.getMetadata().getName(), managedClusterFromSerializedJson.getMetadata().getName());
    assertTrue(managedCluster.getSpec().getHubAcceptsClient());
    assertEquals(1, managedCluster.getSpec().getManagedClusterClientConfigs().size());
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    ManagedClusterBuilder managedClusterBuilder = new ManagedClusterBuilder()
        .withNewMetadata()
        .addToLabels("vendor", "OpenShift")
        .withName("cluster1")
        .endMetadata()
        .withNewSpec()
        .withHubAcceptsClient(true)
        .addNewManagedClusterClientConfig()
        .withCaBundle("test")
        .withUrl("https://test.com")
        .endManagedClusterClientConfig()
        .endSpec();

    // When
    ManagedCluster managedCluster = managedClusterBuilder.build();

    // Then
    assertNotNull(managedCluster);
    assertEquals("cluster1", managedCluster.getMetadata().getName());
    assertEquals(1, managedCluster.getMetadata().getLabels().size());
    assertTrue(managedCluster.getSpec().getHubAcceptsClient());
    assertEquals(1, managedCluster.getSpec().getManagedClusterClientConfigs().size());
  }
}
