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

import io.fabric8.openshift.api.model.config.v1.InfrastructureBuilder;
import io.fabric8.openshift.api.model.machineconfig.v1.ControllerConfig;
import io.fabric8.openshift.api.model.machineconfig.v1.ControllerConfigBuilder;
import io.fabric8.openshift.api.model.machineconfig.v1.ControllerConfigList;
import io.fabric8.openshift.api.model.machineconfig.v1.ControllerConfigListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class ControllerConfigTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/machineconfiguration.openshift.io/v1/controllerconfigs/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewControllerConfig("test-get"))
        .once();

    // When
    ControllerConfig controllerConfig = client.machineConfigurations().controllerConfigs().withName("test-get").get();

    // Then
    assertThat(controllerConfig)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/machineconfiguration.openshift.io/v1/controllerconfigs")
        .andReturn(HttpURLConnection.HTTP_OK, new ControllerConfigListBuilder()
            .addToItems(createNewControllerConfig("test-list"))
            .build())
        .once();

    // When
    ControllerConfigList controllerConfigList = client.machineConfigurations().controllerConfigs().list();

    // Then
    assertThat(controllerConfigList).isNotNull();
    assertThat(controllerConfigList.getItems()).hasSize(1);
    assertThat(controllerConfigList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/machineconfiguration.openshift.io/v1/controllerconfigs/cluster")
        .andReturn(HttpURLConnection.HTTP_OK, createNewControllerConfig("cluster"))
        .once();

    // When
    boolean isDeleted = client.machineConfigurations().controllerConfigs().withName("cluster").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private ControllerConfig createNewControllerConfig(String name) {
    return new ControllerConfigBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withInfra(new InfrastructureBuilder()
            .withNewSpec()
            .withNewCloudConfig()
            .withName("")
            .endCloudConfig()
            .endSpec()
            .withNewStatus()
            .withNewPlatformStatus()
            .withType("Libvirt")
            .endPlatformStatus()
            .endStatus()
            .build())
        .withClusterDNSIP("10.2.3.10")
        .endSpec()
        .build();
  }
}
