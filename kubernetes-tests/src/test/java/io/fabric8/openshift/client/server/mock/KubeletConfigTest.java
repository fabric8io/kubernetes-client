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

import io.fabric8.openshift.api.model.machineconfig.v1.KubeletConfig;
import io.fabric8.openshift.api.model.machineconfig.v1.KubeletConfigBuilder;
import io.fabric8.openshift.api.model.machineconfig.v1.KubeletConfigList;
import io.fabric8.openshift.api.model.machineconfig.v1.KubeletConfigListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class KubeletConfigTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/machineconfiguration.openshift.io/v1/kubeletconfigs/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewKubeletConfig("test-get"))
        .once();

    // When
    KubeletConfig kubeletConfig = client.machineConfigurations().kubeletConfigs().withName("test-get").get();

    // Then
    assertThat(kubeletConfig)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/machineconfiguration.openshift.io/v1/kubeletconfigs")
        .andReturn(HttpURLConnection.HTTP_OK, new KubeletConfigListBuilder()
            .addToItems(createNewKubeletConfig("test-list"))
            .build())
        .once();

    // When
    KubeletConfigList kubeletConfigList = client.machineConfigurations().kubeletConfigs().list();

    // Then
    assertThat(kubeletConfigList).isNotNull();
    assertThat(kubeletConfigList.getItems()).hasSize(1);
    assertThat(kubeletConfigList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/machineconfiguration.openshift.io/v1/kubeletconfigs/cluster")
        .andReturn(HttpURLConnection.HTTP_OK, createNewKubeletConfig("cluster"))
        .once();

    // When
    boolean isDeleted = client.machineConfigurations().kubeletConfigs().withName("cluster").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private KubeletConfig createNewKubeletConfig(String name) {
    return new KubeletConfigBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withNewMachineConfigPoolSelector()
        .addToMatchLabels("custom-kubelet", "large-pods")
        .endMachineConfigPoolSelector()
        .addToKubeletConfig("maxPods", "500")
        .endSpec()
        .build();
  }
}
