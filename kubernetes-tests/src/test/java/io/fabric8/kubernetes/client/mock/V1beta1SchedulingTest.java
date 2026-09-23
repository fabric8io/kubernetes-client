/*
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
package io.fabric8.kubernetes.client.mock;

import io.fabric8.kubernetes.api.model.scheduling.v1beta1.PodGroup;
import io.fabric8.kubernetes.api.model.scheduling.v1beta1.PodGroupBuilder;
import io.fabric8.kubernetes.api.model.scheduling.v1beta1.Workload;
import io.fabric8.kubernetes.api.model.scheduling.v1beta1.WorkloadBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient(https = false, crud = true)
class V1beta1SchedulingTest {

  KubernetesMockServer server;
  KubernetesClient client;

  @Test
  @DisplayName("scheduling().v1beta1().podGroups() manages namespaced scheduling.k8s.io/v1beta1 PodGroups")
  void podGroups() throws InterruptedException {
    // Given
    client.scheduling().v1beta1().podGroups().inNamespace("ns").resource(new PodGroupBuilder()
        .withNewMetadata().withName("gang").endMetadata()
        .withNewSpec().withPriorityClassName("high").endSpec()
        .build()).create();

    // When
    final PodGroup result = client.scheduling().v1beta1().podGroups().inNamespace("ns").withName("gang").get();

    // Then
    assertThat(server.getLastRequest().getPath())
        .isEqualTo("/apis/scheduling.k8s.io/v1beta1/namespaces/ns/podgroups/gang");
    assertThat(result)
        .hasFieldOrPropertyWithValue("apiVersion", "scheduling.k8s.io/v1beta1")
        .hasFieldOrPropertyWithValue("spec.priorityClassName", "high");
    assertThat(client.scheduling().v1beta1().podGroups().inNamespace("other").list().getItems()).isEmpty();
  }

  @Test
  @DisplayName("scheduling().v1beta1().workloads() manages namespaced scheduling.k8s.io/v1beta1 Workloads")
  void workloads() throws InterruptedException {
    // Given
    client.scheduling().v1beta1().workloads().inNamespace("ns").resource(new WorkloadBuilder()
        .withNewMetadata().withName("training").endMetadata()
        .withNewSpec().endSpec()
        .build()).create();

    // When
    final Workload result = client.scheduling().v1beta1().workloads().inNamespace("ns").withName("training").get();

    // Then
    assertThat(server.getLastRequest().getPath())
        .isEqualTo("/apis/scheduling.k8s.io/v1beta1/namespaces/ns/workloads/training");
    assertThat(result).hasFieldOrPropertyWithValue("apiVersion", "scheduling.k8s.io/v1beta1");
    assertThat(client.scheduling().v1beta1().workloads().inAnyNamespace().list().getItems()).hasSize(1);
  }
}
