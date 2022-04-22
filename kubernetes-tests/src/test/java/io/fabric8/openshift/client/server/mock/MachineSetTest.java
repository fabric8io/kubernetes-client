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

import io.fabric8.openshift.api.model.machine.v1beta1.MachineSet;
import io.fabric8.openshift.api.model.machine.v1beta1.MachineSetBuilder;
import io.fabric8.openshift.api.model.machine.v1beta1.MachineSetList;
import io.fabric8.openshift.api.model.machine.v1beta1.MachineSetListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class MachineSetTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/machine.openshift.io/v1beta1/namespaces/ns1/machinesets/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewMachineSet("test-get"))
        .once();

    // When
    MachineSet machineSet = client.machine().machineSets().inNamespace("ns1").withName("test-get").get();

    // Then
    assertThat(machineSet)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/machine.openshift.io/v1beta1/namespaces/ns1/machinesets")
        .andReturn(HttpURLConnection.HTTP_OK, new MachineSetListBuilder()
            .addToItems(createNewMachineSet("test-list"))
            .build())
        .once();

    // When
    MachineSetList machineSetList = client.machine().machineSets().inNamespace("ns1").list();

    // Then
    assertThat(machineSetList).isNotNull();
    assertThat(machineSetList.getItems()).hasSize(1);
    assertThat(machineSetList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/machine.openshift.io/v1beta1/namespaces/ns1/machinesets/cluster")
        .andReturn(HttpURLConnection.HTTP_OK, createNewMachineSet("cluster"))
        .once();

    // When
    boolean isDeleted = client.machine().machineSets().inNamespace("ns1").withName("cluster").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private MachineSet createNewMachineSet(String name) {
    return new MachineSetBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withReplicas(2)
        .withNewSelector()
        .addToMatchLabels("machine.openshift.io/cluster-api-machineset", "worker")
        .endSelector()
        .withNewTemplate()
        .withNewMetadata()
        .addToLabels("machine.openshift.io/cluster-api-machineset", "worker")
        .endMetadata()
        .endTemplate()
        .endSpec()
        .build();
  }
}
