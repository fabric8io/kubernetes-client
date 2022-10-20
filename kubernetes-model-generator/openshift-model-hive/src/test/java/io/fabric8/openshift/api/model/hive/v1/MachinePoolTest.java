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

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MachinePoolTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-machinepool.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final MachinePool machinePool = mapper.readValue(originalJson, MachinePool.class);
    final String serializedJson = mapper.writeValueAsString(machinePool);
    final MachinePool machinePoolFromSerializedJson = mapper.readValue(serializedJson, MachinePool.class);

    // Then
    assertThat(serializedJson).isNotNull();
    assertThat(machinePool)
        .isNotNull()
        .isEqualTo(machinePoolFromSerializedJson)
        .hasFieldOrPropertyWithValue("metadata.name", "foo-worker")
        .hasFieldOrPropertyWithValue("spec.clusterDeploymentRef.name", "foo")
        .hasFieldOrPropertyWithValue("spec.name", "worker")
        .hasFieldOrPropertyWithValue("spec.replicas", 3L)
        .hasFieldOrPropertyWithValue("spec.platform.aws.type", "m4.large")
        .hasFieldOrPropertyWithValue("spec.platform.aws.rootVolume.iops", 100)
        .hasFieldOrPropertyWithValue("spec.platform.aws.rootVolume.size", 22)
        .hasFieldOrPropertyWithValue("spec.platform.aws.rootVolume.type", "gp2");
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    MachinePoolBuilder machinePoolBuilder = new MachinePoolBuilder()
        .withNewMetadata()
        .withName("foo-worker")
        .endMetadata()
        .withNewSpec()
        .withNewClusterDeploymentRef()
        .withName("foo")
        .endClusterDeploymentRef()
        .withName("worker")
        .withReplicas(3L)
        .withNewPlatform()
        .withNewAws()
        .withType("m4.large")
        .withNewRootVolume()
        .withIops(100)
        .withSize(22)
        .withType("gp2")
        .endRootVolume()
        .endAws()
        .endPlatform()
        .endSpec();

    // When
    MachinePool machinePool = machinePoolBuilder.build();

    // Then
    assertThat(machinePool)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "foo-worker")
        .hasFieldOrPropertyWithValue("spec.clusterDeploymentRef.name", "foo")
        .hasFieldOrPropertyWithValue("spec.name", "worker")
        .hasFieldOrPropertyWithValue("spec.replicas", 3L)
        .hasFieldOrPropertyWithValue("spec.platform.aws.type", "m4.large")
        .hasFieldOrPropertyWithValue("spec.platform.aws.rootVolume.iops", 100)
        .hasFieldOrPropertyWithValue("spec.platform.aws.rootVolume.size", 22)
        .hasFieldOrPropertyWithValue("spec.platform.aws.rootVolume.type", "gp2");
  }

}
