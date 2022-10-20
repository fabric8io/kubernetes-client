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
package io.fabric8.openclustermanagement.api.model.discovery;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.openclustermanagement.api.model.discovery.v1alpha1.DiscoveredCluster;
import io.fabric8.openclustermanagement.api.model.discovery.v1alpha1.DiscoveredClusterBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DiscoveredClusterTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-discoveredcluster.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final DiscoveredCluster discoveredCluster = mapper.readValue(originalJson, DiscoveredCluster.class);
    final String serializedJson = mapper.writeValueAsString(discoveredCluster);
    final DiscoveredCluster discoveredClusterFromSerializedJson = mapper.readValue(serializedJson, DiscoveredCluster.class);

    // Then
    assertNotNull(discoveredCluster);
    assertNotNull(serializedJson);
    assertNotNull(discoveredClusterFromSerializedJson);
    assertEquals(discoveredCluster.getMetadata().getName(), discoveredClusterFromSerializedJson.getMetadata().getName());
    assertEquals("foo-cluster", discoveredCluster.getSpec().getName());
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    DiscoveredClusterBuilder subscriptionBuilder = new DiscoveredClusterBuilder()
        .withNewMetadata()
        .withName("sample_discoveredcluster")
        .endMetadata()
        .withNewSpec()
        .withName("crc-cluster")
        .withApiUrl("https://api.crc.testing:6443")
        .withCloudProvider("RedHat")
        .withDisplayName("Crc")
        .endSpec();

    // When
    DiscoveredCluster subscription = subscriptionBuilder.build();

    // Then
    assertNotNull(subscription);
    assertEquals("sample_discoveredcluster", subscription.getMetadata().getName());
    assertEquals("crc-cluster", subscription.getSpec().getName());
    assertEquals("https://api.crc.testing:6443", subscription.getSpec().getApiUrl());
    assertEquals("RedHat", subscription.getSpec().getCloudProvider());
    assertEquals("Crc", subscription.getSpec().getDisplayName());
  }
}
