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
package io.fabric8.openshift.client.server.mock.hive;

import io.fabric8.openshift.api.model.hive.v1.MachinePool;
import io.fabric8.openshift.api.model.hive.v1.MachinePoolBuilder;
import io.fabric8.openshift.api.model.hive.v1.MachinePoolList;
import io.fabric8.openshift.api.model.hive.v1.MachinePoolListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import io.fabric8.openshift.client.server.mock.EnableOpenShiftMockClient;
import io.fabric8.openshift.client.server.mock.OpenShiftMockServer;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class MachinePoolTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/hive.openshift.io/v1/namespaces/ns1/machinepools/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewMachinePool("test-get"))
        .once();

    // When
    MachinePool machinePool = client.hive().machinePools().inNamespace("ns1").withName("test-get").get();

    // Then
    assertThat(machinePool)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/hive.openshift.io/v1/namespaces/ns1/machinepools")
        .andReturn(HttpURLConnection.HTTP_OK, new MachinePoolListBuilder()
            .addToItems(createNewMachinePool("test-list"))
            .build())
        .once();

    // When
    MachinePoolList machinePoolList = client.hive().machinePools().inNamespace("ns1").list();

    // Then
    assertThat(machinePoolList).isNotNull();
    assertThat(machinePoolList.getItems()).hasSize(1);
    assertThat(machinePoolList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/hive.openshift.io/v1/namespaces/ns1/machinepools/machinepool1")
        .andReturn(HttpURLConnection.HTTP_OK, createNewMachinePool("machinepool1"))
        .once();

    // When
    boolean isDeleted = client.hive().machinePools().inNamespace("ns1").withName("machinepool1").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private MachinePool createNewMachinePool(String name) {
    return new MachinePoolBuilder()
        .withNewMetadata()
        .withName(name)
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
        .endSpec()
        .build();
  }
}
