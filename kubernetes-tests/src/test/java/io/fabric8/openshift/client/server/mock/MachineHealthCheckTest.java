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

import io.fabric8.kubernetes.api.model.Duration;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.openshift.api.model.machine.v1beta1.MachineHealthCheck;
import io.fabric8.openshift.api.model.machine.v1beta1.MachineHealthCheckBuilder;
import io.fabric8.openshift.api.model.machine.v1beta1.MachineHealthCheckList;
import io.fabric8.openshift.api.model.machine.v1beta1.MachineHealthCheckListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.text.ParseException;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class MachineHealthCheckTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() throws ParseException {
    // Given
    server.expect().get().withPath("/apis/machine.openshift.io/v1beta1/namespaces/ns1/machinehealthchecks/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewMachineHealthCheck("test-get"))
        .once();

    // When
    MachineHealthCheck machineHealthCheck = client.machine().machineHealthChecks().inNamespace("ns1").withName("test-get")
        .get();

    // Then
    assertThat(machineHealthCheck)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() throws ParseException {
    // Given
    server.expect().get().withPath("/apis/machine.openshift.io/v1beta1/namespaces/ns1/machinehealthchecks")
        .andReturn(HttpURLConnection.HTTP_OK, new MachineHealthCheckListBuilder()
            .addToItems(createNewMachineHealthCheck("test-list"))
            .build())
        .once();

    // When
    MachineHealthCheckList machineHealthCheckList = client.machine().machineHealthChecks().inNamespace("ns1").list();

    // Then
    assertThat(machineHealthCheckList).isNotNull();
    assertThat(machineHealthCheckList.getItems()).hasSize(1);
    assertThat(machineHealthCheckList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() throws ParseException {
    // Given
    server.expect().delete().withPath("/apis/machine.openshift.io/v1beta1/namespaces/ns1/machinehealthchecks/cluster")
        .andReturn(HttpURLConnection.HTTP_OK, createNewMachineHealthCheck("cluster"))
        .once();

    // When
    boolean isDeleted = client.machine().machineHealthChecks().inNamespace("ns1").withName("cluster").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private MachineHealthCheck createNewMachineHealthCheck(String name) throws ParseException {
    return new MachineHealthCheckBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withNewSelector()
        .addToMatchLabels("machine.openshift.io/interruptible-instance", "")
        .endSelector()
        .withMaxUnhealthy(new IntOrString("100%"))
        .withNodeStartupTimeout(Duration.parse("0s"))
        .addNewUnhealthyCondition()
        .withTimeout(Duration.parse("0s"))
        .withStatus("True")
        .withType("Terminating")
        .endUnhealthyCondition()
        .endSpec()
        .build();
  }
}
