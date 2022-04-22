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

import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.openshift.api.model.machine.v1beta1.Machine;
import io.fabric8.openshift.api.model.machine.v1beta1.MachineBuilder;
import io.fabric8.openshift.api.model.machine.v1beta1.MachineList;
import io.fabric8.openshift.api.model.machine.v1beta1.MachineListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class MachineTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() throws IOException {
    // Given
    server.expect().get().withPath("/apis/machine.openshift.io/v1beta1/namespaces/ns1/machines/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewMachine("test-get"))
        .once();

    // When
    Machine machine = client.machine().machines().inNamespace("ns1").withName("test-get").get();

    // Then
    assertThat(machine)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() throws IOException {
    // Given
    server.expect().get().withPath("/apis/machine.openshift.io/v1beta1/namespaces/ns1/machines")
        .andReturn(HttpURLConnection.HTTP_OK, new MachineListBuilder()
            .addToItems(createNewMachine("test-list"))
            .build())
        .once();

    // When
    MachineList machineList = client.machine().machines().inNamespace("ns1").list();

    // Then
    assertThat(machineList).isNotNull();
    assertThat(machineList.getItems()).hasSize(1);
    assertThat(machineList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() throws IOException {
    // Given
    server.expect().delete().withPath("/apis/machine.openshift.io/v1beta1/namespaces/ns1/machines/cluster")
        .andReturn(HttpURLConnection.HTTP_OK, createNewMachine("cluster"))
        .once();

    // When
    boolean isDeleted = client.machine().machines().inNamespace("ns1").withName("cluster").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private Machine createNewMachine(String name) throws IOException {
    Map<String, Object> providerMachineSpec = Serialization.jsonMapper()
        .readValue(getClass().getResourceAsStream("/test-machineproviderspec.json"), Map.class);
    return new MachineBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withProviderID("foo")
        .withNewProviderSpec()
        .withValue(providerMachineSpec)
        .endProviderSpec()
        .endSpec()
        .build();
  }
}
