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

import io.fabric8.openshift.api.model.machineconfig.v1.MachineConfig;
import io.fabric8.openshift.api.model.machineconfig.v1.MachineConfigBuilder;
import io.fabric8.openshift.api.model.machineconfig.v1.MachineConfigList;
import io.fabric8.openshift.api.model.machineconfig.v1.MachineConfigListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class MachineConfigTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/machineconfiguration.openshift.io/v1/machineconfigs/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewMachineConfig("test-get"))
        .once();

    // When
    MachineConfig machineConfig = client.machineConfigurations().machineConfigs().withName("test-get").get();

    // Then
    assertThat(machineConfig)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/machineconfiguration.openshift.io/v1/machineconfigs")
        .andReturn(HttpURLConnection.HTTP_OK, new MachineConfigListBuilder()
            .addToItems(createNewMachineConfig("test-list"))
            .build())
        .once();

    // When
    MachineConfigList machineConfigList = client.machineConfigurations().machineConfigs().list();

    // Then
    assertThat(machineConfigList).isNotNull();
    assertThat(machineConfigList.getItems()).hasSize(1);
    assertThat(machineConfigList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/machineconfiguration.openshift.io/v1/machineconfigs/cluster")
        .andReturn(HttpURLConnection.HTTP_OK, createNewMachineConfig("cluster"))
        .once();

    // When
    boolean isDeleted = client.machineConfigurations().machineConfigs().withName("cluster").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private MachineConfig createNewMachineConfig(String name) {
    return new MachineConfigBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withFips(false)
        .withOsImageURL(
            "quay.io/openshift-release-dev/ocp-v4.0-art-dev@sha256:0b2c764f69eb4663efb2954e74d0c235b5edcb429fd9d66f151dc666be03f63c")
        .withKernelType("")
        .endSpec()
        .build();
  }
}
