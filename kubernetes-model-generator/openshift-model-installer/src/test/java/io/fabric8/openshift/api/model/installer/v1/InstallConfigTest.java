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
package io.fabric8.openshift.api.model.installer.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class InstallConfigTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-installconfig.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final InstallConfig installConfig = mapper.readValue(originalJson, InstallConfig.class);
    final String serializedJson = mapper.writeValueAsString(installConfig);
    final InstallConfig installConfigFromSerializedJson = mapper.readValue(serializedJson, InstallConfig.class);

    // Then
    assertThat(serializedJson).isNotNull();
    assertThat(installConfig)
        .isNotNull()
        .isEqualTo(installConfigFromSerializedJson)
        .hasFieldOrPropertyWithValue("metadata.name", "mycluster")
        .hasFieldOrPropertyWithValue("pullSecret", "sample-pull-secret")
        .hasFieldOrPropertyWithValue("sshKey", "sample-ssh-key")
        .hasFieldOrPropertyWithValue("platform.aws.region", "us-east-1")
        .hasFieldOrPropertyWithValue("controlPlane.name", "master")
        .hasFieldOrPropertyWithValue("controlPlane.platform.aws.rootVolume.type", "gp2")
        .hasFieldOrPropertyWithValue("controlPlane.platform.aws.rootVolume.iops", 100)
        .hasFieldOrPropertyWithValue("controlPlane.platform.aws.rootVolume.size", 22)
        .hasFieldOrPropertyWithValue("controlPlane.platform.aws.type", "m4.xlarge")
        .hasFieldOrPropertyWithValue("networking.machineCIDR", "10.0.0.0/16")
        .hasFieldOrPropertyWithValue("networking.networkType", "OpenShiftSDN");
    assertThat(installConfig.getCompute()).asList()
        .hasSize(1)
        .first()
        .hasFieldOrPropertyWithValue("name", "worker")
        .hasFieldOrPropertyWithValue("platform.aws.rootVolume.iops", 100)
        .hasFieldOrPropertyWithValue("platform.aws.rootVolume.size", 22)
        .hasFieldOrPropertyWithValue("platform.aws.rootVolume.type", "gp2")
        .hasFieldOrPropertyWithValue("platform.aws.type", "m4.xlarge")
        .hasFieldOrPropertyWithValue("replicas", 3L);
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    InstallConfigBuilder installConfigBuilder = new InstallConfigBuilder()
        .withNewMetadata()
        .withName("mycluster")
        .endMetadata()
        .withPullSecret("sample-pull-secret")
        .withSshKey("sample-ssh-key")
        .withNewControlPlane()
        .withName("master")
        .withNewPlatform()
        .withAws(new io.fabric8.openshift.api.model.installer.aws.v1.MachinePoolBuilder()
            .withNewRootVolume()
            .withIops(100)
            .withSize(22)
            .withType("gp2")
            .endRootVolume()
            .withType("m4.xlarge")
            .build())
        .endPlatform()
        .endControlPlane()
        .addNewCompute()
        .withName("worker")
        .withNewPlatform()
        .withAws(new io.fabric8.openshift.api.model.installer.aws.v1.MachinePoolBuilder()
            .withNewRootVolume()
            .withIops(100)
            .withSize(22)
            .withType("gp2")
            .endRootVolume()
            .withType("m4.xlarge")
            .build())
        .endPlatform()
        .withReplicas(3L)
        .endCompute()
        .withNewNetworking()
        .addNewClusterNetwork()
        .withCidr("10.128.0.0/14")
        .withHostPrefix(23)
        .endClusterNetwork()
        .withMachineCIDR("10.0.0.0/16")
        .withNetworkType("OpenShiftSDN")
        .addToServiceNetwork("172.30.0.0/16")
        .endNetworking()
        .withNewPlatform()
        .withAws(new io.fabric8.openshift.api.model.installer.aws.v1.PlatformBuilder()
            .withRegion("us-east-1")
            .build())
        .endPlatform();

    // When
    InstallConfig installConfig = installConfigBuilder.build();

    // Then
    assertThat(installConfig)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "mycluster")
        .hasFieldOrPropertyWithValue("pullSecret", "sample-pull-secret")
        .hasFieldOrPropertyWithValue("sshKey", "sample-ssh-key")
        .hasFieldOrPropertyWithValue("platform.aws.region", "us-east-1")
        .hasFieldOrPropertyWithValue("controlPlane.name", "master")
        .hasFieldOrPropertyWithValue("controlPlane.platform.aws.rootVolume.type", "gp2")
        .hasFieldOrPropertyWithValue("controlPlane.platform.aws.rootVolume.iops", 100)
        .hasFieldOrPropertyWithValue("controlPlane.platform.aws.rootVolume.size", 22)
        .hasFieldOrPropertyWithValue("controlPlane.platform.aws.type", "m4.xlarge")
        .hasFieldOrPropertyWithValue("networking.machineCIDR", "10.0.0.0/16")
        .hasFieldOrPropertyWithValue("networking.networkType", "OpenShiftSDN");
    assertThat(installConfig.getCompute()).asList()
        .hasSize(1)
        .first()
        .hasFieldOrPropertyWithValue("name", "worker")
        .hasFieldOrPropertyWithValue("platform.aws.rootVolume.iops", 100)
        .hasFieldOrPropertyWithValue("platform.aws.rootVolume.size", 22)
        .hasFieldOrPropertyWithValue("platform.aws.rootVolume.type", "gp2")
        .hasFieldOrPropertyWithValue("platform.aws.type", "m4.xlarge")
        .hasFieldOrPropertyWithValue("replicas", 3L);
  }
}
