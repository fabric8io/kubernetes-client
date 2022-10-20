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
import io.fabric8.openclustermanagement.api.model.multiclusterhub.operator.v1.MultiClusterHub;
import io.fabric8.openclustermanagement.api.model.multiclusterhub.operator.v1.MultiClusterHubBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MultiClusterHubTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-multiclusterhub.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final MultiClusterHub multiClusterHub = mapper.readValue(originalJson, MultiClusterHub.class);
    final String serializedJson = mapper.writeValueAsString(multiClusterHub);
    final MultiClusterHub mchFromSerializedJson = mapper.readValue(serializedJson, MultiClusterHub.class);

    // Then
    assertNotNull(multiClusterHub);
    assertNotNull(serializedJson);
    assertNotNull(mchFromSerializedJson);
    assertEquals(multiClusterHub.getMetadata().getName(), mchFromSerializedJson.getMetadata().getName());
    assertEquals("redhat-registry", multiClusterHub.getSpec().getImagePullSecret());
    assertFalse(multiClusterHub.getSpec().getDisableHubSelfManagement());
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    MultiClusterHubBuilder multiClusterHubBuilder = new MultiClusterHubBuilder()
        .withNewMetadata()
        .withName("sample_mch")
        .endMetadata()
        .withNewSpec()
        .withImagePullSecret("redhat-registry")
        .withDisableHubSelfManagement(false)
        .endSpec();

    // When
    MultiClusterHub multiClusterHub = multiClusterHubBuilder.build();

    // Then
    assertNotNull(multiClusterHub);
    assertEquals("sample_mch", multiClusterHub.getMetadata().getName());
    assertEquals("redhat-registry", multiClusterHub.getSpec().getImagePullSecret());
    assertFalse(multiClusterHub.getSpec().getDisableHubSelfManagement());
  }
}
