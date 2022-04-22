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

import io.fabric8.openshift.api.model.machineconfig.v1.ContainerRuntimeConfig;
import io.fabric8.openshift.api.model.machineconfig.v1.ContainerRuntimeConfigBuilder;
import io.fabric8.openshift.api.model.machineconfig.v1.ContainerRuntimeConfigList;
import io.fabric8.openshift.api.model.machineconfig.v1.ContainerRuntimeConfigListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class ContainerRuntimeConfigTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/machineconfiguration.openshift.io/v1/containerruntimeconfigs/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewContainerRuntimeConfig("test-get"))
        .once();

    // When
    ContainerRuntimeConfig containerRuntimeConfig = client.machineConfigurations().containerRuntimeConfigs()
        .withName("test-get").get();

    // Then
    assertThat(containerRuntimeConfig)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/machineconfiguration.openshift.io/v1/containerruntimeconfigs")
        .andReturn(HttpURLConnection.HTTP_OK, new ContainerRuntimeConfigListBuilder()
            .addToItems(createNewContainerRuntimeConfig("test-list"))
            .build())
        .once();

    // When
    ContainerRuntimeConfigList containerRuntimeConfigList = client.machineConfigurations().containerRuntimeConfigs().list();

    // Then
    assertThat(containerRuntimeConfigList).isNotNull();
    assertThat(containerRuntimeConfigList.getItems()).hasSize(1);
    assertThat(containerRuntimeConfigList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/machineconfiguration.openshift.io/v1/containerruntimeconfigs/cluster")
        .andReturn(HttpURLConnection.HTTP_OK, createNewContainerRuntimeConfig("cluster"))
        .once();

    // When
    boolean isDeleted = client.machineConfigurations().containerRuntimeConfigs().withName("cluster").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private ContainerRuntimeConfig createNewContainerRuntimeConfig(String name) {
    return new ContainerRuntimeConfigBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withNewMachineConfigPoolSelector()
        .addToMatchLabels("pools.operator.machineconfiguration.openshift.io/worker", "")
        .endMachineConfigPoolSelector()
        .withNewContainerRuntimeConfig()
        .withPidsLimit(2048L)
        .endContainerRuntimeConfig()
        .endSpec()
        .build();
  }
}
