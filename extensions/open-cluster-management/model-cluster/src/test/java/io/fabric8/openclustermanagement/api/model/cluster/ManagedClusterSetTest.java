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
import io.fabric8.openclustermanagement.api.model.cluster.v1beta1.ManagedClusterSet;
import io.fabric8.openclustermanagement.api.model.cluster.v1beta1.ManagedClusterSetBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ManagedClusterSetTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-managedclusterset.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final ManagedClusterSet managedClusterSet = mapper.readValue(originalJson, ManagedClusterSet.class);
    final String serializedJson = mapper.writeValueAsString(managedClusterSet);
    final ManagedClusterSet managedClusterSetFromSerializedJson = mapper.readValue(serializedJson, ManagedClusterSet.class);

    // Then
    assertNotNull(managedClusterSet);
    assertNotNull(serializedJson);
    assertNotNull(managedClusterSetFromSerializedJson);
    assertEquals(managedClusterSet.getMetadata().getName(), managedClusterSetFromSerializedJson.getMetadata().getName());
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    ManagedClusterSetBuilder managedClusterBuilder = new ManagedClusterSetBuilder()
        .withNewMetadata()
        .withName("cluster1")
        .endMetadata()
        .withNewSpec()
        .endSpec();

    // When
    ManagedClusterSet managedClusterSet = managedClusterBuilder.build();

    // Then
    assertNotNull(managedClusterSet);
    assertEquals("cluster1", managedClusterSet.getMetadata().getName());
  }
}
