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
package io.fabric8.openshift.client.server.mock;

import io.fabric8.openshift.api.model.machineconfig.v1.MachineConfigPool;
import io.fabric8.openshift.api.model.machineconfig.v1.MachineConfigPoolBuilder;
import io.fabric8.openshift.api.model.machineconfig.v1.MachineConfigPoolList;
import io.fabric8.openshift.api.model.machineconfig.v1.MachineConfigPoolListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class MachineConfigPoolTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/machineconfiguration.openshift.io/v1/machineconfigpools/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewMachineConfigPool("test-get"))
        .once();

    // When
    MachineConfigPool machineConfigPool = client.machineConfigurations().machineConfigPools().withName("test-get").get();

    // Then
    assertThat(machineConfigPool)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/machineconfiguration.openshift.io/v1/machineconfigpools")
        .andReturn(HttpURLConnection.HTTP_OK, new MachineConfigPoolListBuilder()
            .addToItems(createNewMachineConfigPool("test-list"))
            .build())
        .once();

    // When
    MachineConfigPoolList machineConfigPoolList = client.machineConfigurations().machineConfigPools().list();

    // Then
    assertThat(machineConfigPoolList).isNotNull();
    assertThat(machineConfigPoolList.getItems()).hasSize(1);
    assertThat(machineConfigPoolList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/machineconfiguration.openshift.io/v1/machineconfigpools/cluster")
        .andReturn(HttpURLConnection.HTTP_OK, createNewMachineConfigPool("cluster"))
        .once();

    // When
    boolean isDeleted = client.machineConfigurations().machineConfigPools().withName("cluster").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private MachineConfigPool createNewMachineConfigPool(String name) {
    return new MachineConfigPoolBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withNewMachineConfigSelector()
        .addToMatchLabels("machineconfiguration.openshift.io/role", "master")
        .endMachineConfigSelector()
        .withNewNodeSelector()
        .addToMatchLabels("node-role.kubernetes.io/master", "")
        .endNodeSelector()
        .endSpec()
        .build();
  }
}
