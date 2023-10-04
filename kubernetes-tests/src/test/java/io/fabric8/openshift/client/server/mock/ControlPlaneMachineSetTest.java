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

import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.openshift.api.model.machine.v1.ControlPlaneMachineSet;
import io.fabric8.openshift.api.model.machine.v1.ControlPlaneMachineSetBuilder;
import io.fabric8.openshift.api.model.machine.v1.ControlPlaneMachineSetList;
import io.fabric8.openshift.api.model.machine.v1.ControlPlaneMachineSetListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableKubernetesMockClient
class ControlPlaneMachineSetTest {
  KubernetesMockServer server;
  OpenShiftClient client;

  @Test
  void create() {
    // Given
    ControlPlaneMachineSet controlPlaneMachineSet = getControlPlaneMachineSet();
    server.expect().post()
        .withPath("/apis/machine.openshift.io/v1/namespaces/ns1/controlplanemachinesets")
        .andReturn(HttpURLConnection.HTTP_OK, controlPlaneMachineSet)
        .once();

    // When
    controlPlaneMachineSet = client.machine().controlPlaneMachineSets().inNamespace("ns1").resource(controlPlaneMachineSet)
        .create();

    // Then
    assertNotNull(controlPlaneMachineSet);
    assertEquals("cluster", controlPlaneMachineSet.getMetadata().getName());
  }

  @Test
  void get() {
    // Given
    server.expect().get()
        .withPath("/apis/machine.openshift.io/v1/namespaces/ns1/controlplanemachinesets/cluster")
        .andReturn(HttpURLConnection.HTTP_OK, getControlPlaneMachineSet())
        .once();

    // When
    ControlPlaneMachineSet controlPlaneMachineSet = client.machine().controlPlaneMachineSets().inNamespace("ns1")
        .withName("cluster").get();

    // Then
    assertNotNull(controlPlaneMachineSet);
    assertEquals("cluster", controlPlaneMachineSet.getMetadata().getName());
  }

  @Test
  void list() {
    // Given
    server.expect().get()
        .withPath("/apis/machine.openshift.io/v1/namespaces/ns1/controlplanemachinesets")
        .andReturn(HttpURLConnection.HTTP_OK,
            new ControlPlaneMachineSetListBuilder().withItems(getControlPlaneMachineSet()).build())
        .once();

    // When
    ControlPlaneMachineSetList controlPlaneMachineSetList = client.machine().controlPlaneMachineSets().inNamespace("ns1")
        .list();

    // Then
    assertNotNull(controlPlaneMachineSetList);
    assertNotNull(controlPlaneMachineSetList.getItems());
    assertEquals(1, controlPlaneMachineSetList.getItems().size());
  }

  @Test
  void delete() {
    // Given
    server.expect().delete()
        .withPath("/apis/machine.openshift.io/v1/namespaces/ns1/controlplanemachinesets/cluster")
        .andReturn(HttpURLConnection.HTTP_OK, getControlPlaneMachineSet())
        .once();

    // When
    boolean deleted = client.machine().controlPlaneMachineSets().inNamespace("ns1").withName("cluster").delete().size() == 1;

    // Then
    assertTrue(deleted);
  }

  private ControlPlaneMachineSet getControlPlaneMachineSet() {
    return new ControlPlaneMachineSetBuilder()
        .withNewMetadata()
        .withName("cluster")
        .endMetadata()
        .withNewSpec()
        .withReplicas(3)
        .withState("Active")
        .withNewStrategy().withType("RollingUpdate").endStrategy()
        .withNewSelector()
        .addToMatchLabels("machine.openshift.io/cluster-api-machine-role", "master")
        .addToMatchLabels("machine.openshift.io/cluster-api-machine-type", "master")
        .endSelector()
        .withNewTemplate()
        .withMachineType("machines_v1beta1_machine_openshift_io")
        .withNewMachinesV1beta1MachineOpenshiftIo()
        .withNewMetadata()
        .addToLabels("machine.openshift.io/cluster-api-machine-role", "master")
        .addToLabels("machine.openshift.io/cluster-api-machine-type", "master")
        .addToLabels("machine.openshift.io/cluster-api-cluster", "cluster")
        .endMetadata()
        .withNewSpec()
        .withNewProviderSpec()
        .endProviderSpec()
        .endSpec()
        .endMachinesV1beta1MachineOpenshiftIo()
        .endTemplate()
        .endSpec()
        .build();
  }
}
