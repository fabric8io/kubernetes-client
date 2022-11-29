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
package io.fabric8.openshift.api.model.hive.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class SyncSetTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-syncset.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final SyncSet syncSet = mapper.readValue(originalJson, SyncSet.class);
    final String serializedJson = mapper.writeValueAsString(syncSet);
    final SyncSet syncSetFromSerializedJson = mapper.readValue(serializedJson, SyncSet.class);

    // Then
    assertThat(serializedJson).isNotNull();
    assertThat(syncSet)
        .isNotNull()
        .isEqualTo(syncSetFromSerializedJson)
        .hasFieldOrPropertyWithValue("metadata.name", "mygroup")
        .hasFieldOrPropertyWithValue("spec.resourceApplyMode", "Upsert");
    assertThat(syncSet.getSpec().getClusterDeploymentRefs()).hasSize(1);
    assertThat(syncSet.getSpec().getResources()).hasSize(1);
    assertThat(syncSet.getSpec().getPatches()).hasSize(1);
    assertThat(syncSet.getSpec().getSecretMappings()).hasSize(1);
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    SyncSetBuilder syncSetBuilder = new SyncSetBuilder()
        .withNewMetadata()
        .withName("mygroup")
        .endMetadata()
        .withNewSpec()
        .withResourceApplyMode("Upsert")
        .addNewClusterDeploymentRef()
        .withName("ClusterName")
        .endClusterDeploymentRef()
        .addNewSecretMapping()
        .withNewSourceRef()
        .withName("ad-bind-password")
        .withNamespace("default")
        .endSourceRef()
        .withNewTargetRef()
        .withName("ad-bind-password")
        .withNamespace("openshift-config")
        .endTargetRef()
        .endSecretMapping()
        .endSpec();

    // When
    SyncSet syncSet = syncSetBuilder.build();

    // Then
    assertThat(syncSet)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "mygroup")
        .hasFieldOrPropertyWithValue("spec.resourceApplyMode", "Upsert");
    assertThat(syncSet.getSpec().getClusterDeploymentRefs()).hasSize(1);
    assertThat(syncSet.getSpec().getSecretMappings()).hasSize(1);
  }
}
