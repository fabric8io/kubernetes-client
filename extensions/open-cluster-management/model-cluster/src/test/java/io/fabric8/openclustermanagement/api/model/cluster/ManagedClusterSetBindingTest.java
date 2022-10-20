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
import io.fabric8.openclustermanagement.api.model.cluster.v1beta1.ManagedClusterSetBinding;
import io.fabric8.openclustermanagement.api.model.cluster.v1beta1.ManagedClusterSetBindingBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ManagedClusterSetBindingTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-managedclustersetbinding.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final ManagedClusterSetBinding managedClusterSetBinding = mapper.readValue(originalJson, ManagedClusterSetBinding.class);
    final String serializedJson = mapper.writeValueAsString(managedClusterSetBinding);
    final ManagedClusterSetBinding managedClusterSetFromSerializedJson = mapper.readValue(serializedJson,
        ManagedClusterSetBinding.class);

    // Then
    assertNotNull(managedClusterSetBinding);
    assertNotNull(serializedJson);
    assertNotNull(managedClusterSetFromSerializedJson);
    assertEquals(managedClusterSetBinding.getMetadata().getName(), managedClusterSetFromSerializedJson.getMetadata().getName());
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    ManagedClusterSetBindingBuilder managedClusterBuilder = new ManagedClusterSetBindingBuilder()
        .withNewMetadata()
        .withName("clusterset1")
        .withNamespace("ns1")
        .endMetadata()
        .withNewSpec()
        .withClusterSet("clusterset1")
        .endSpec();

    // When
    ManagedClusterSetBinding managedClusterSetBinding = managedClusterBuilder.build();

    // Then
    assertNotNull(managedClusterSetBinding);
    assertEquals("clusterset1", managedClusterSetBinding.getMetadata().getName());
    assertEquals("clusterset1", managedClusterSetBinding.getSpec().getClusterSet());
  }
}
