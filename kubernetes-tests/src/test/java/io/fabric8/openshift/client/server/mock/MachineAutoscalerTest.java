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

import io.fabric8.openshift.api.model.clusterautoscaling.v1beta1.MachineAutoscaler;
import io.fabric8.openshift.api.model.clusterautoscaling.v1beta1.MachineAutoscalerBuilder;
import io.fabric8.openshift.api.model.clusterautoscaling.v1beta1.MachineAutoscalerList;
import io.fabric8.openshift.api.model.clusterautoscaling.v1beta1.MachineAutoscalerListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class MachineAutoscalerTest {
  private OpenShiftMockServer server;
  private OpenShiftClient client;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/autoscaling.openshift.io/v1beta1/namespaces/ns1/machineautoscalers/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewMachineAutoscaler("test-get"))
        .once();

    // When
    MachineAutoscaler machineAutoscaler = client.clusterAutoscaling().v1beta1().machineAutoscalers()
        .inNamespace("ns1")
        .withName("test-get").get();

    // Then
    assertThat(machineAutoscaler)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/autoscaling.openshift.io/v1beta1/namespaces/ns1/machineautoscalers")
        .andReturn(HttpURLConnection.HTTP_OK, new MachineAutoscalerListBuilder()
            .addToItems(createNewMachineAutoscaler("test-list"))
            .build())
        .once();

    // When
    MachineAutoscalerList machineAutoscalerList = client.clusterAutoscaling().v1beta1().machineAutoscalers()
        .inNamespace("ns1")
        .list();

    // Then
    assertThat(machineAutoscalerList).isNotNull();
    assertThat(machineAutoscalerList.getItems()).hasSize(1);
    assertThat(machineAutoscalerList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/autoscaling.openshift.io/v1beta1/namespaces/ns1/machineautoscalers/ma")
        .andReturn(HttpURLConnection.HTTP_OK, createNewMachineAutoscaler("ma"))
        .once();

    // When
    Boolean isDeleted = client.clusterAutoscaling().v1beta1().machineAutoscalers()
        .inNamespace("ns1")
        .withName("ma").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private MachineAutoscaler createNewMachineAutoscaler(String name) {
    return new MachineAutoscalerBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withMaxReplicas(12)
        .withMinReplicas(1)
        .withNewScaleTargetRef()
        .withApiVersion("machine.openshift.io/v1beta1")
        .withKind("MachineSet")
        .withName("worker-us-east-1a")
        .endScaleTargetRef()
        .endSpec()
        .build();
  }
}
