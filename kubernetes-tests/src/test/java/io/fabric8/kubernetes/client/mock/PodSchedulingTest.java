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
package io.fabric8.kubernetes.client.mock;

import io.fabric8.kubernetes.api.model.resource.v1alpha1.PodScheduling;
import io.fabric8.kubernetes.api.model.resource.v1alpha1.PodSchedulingBuilder;
import io.fabric8.kubernetes.api.model.resource.v1alpha1.PodSchedulingList;
import io.fabric8.kubernetes.api.model.resource.v1alpha1.PodSchedulingListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient
class PodSchedulingTest {
  private KubernetesClient client;
  private KubernetesMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/resource.k8s.io/v1alpha1/namespaces/test/podschedulings/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewPodScheduling("test-get"))
        .once();

    // When
    PodScheduling podScheduling = client.dynamicResourceAllocation().v1alpha1().podSchedulings().inNamespace("test")
        .withName("test-get").get();

    // Then
    assertThat(podScheduling)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/resource.k8s.io/v1alpha1/namespaces/test/podschedulings")
        .andReturn(HttpURLConnection.HTTP_OK, new PodSchedulingListBuilder()
            .addToItems(createNewPodScheduling("test-list"))
            .build())
        .once();

    // When
    PodSchedulingList podSchedulingList = client.dynamicResourceAllocation().v1alpha1().podSchedulings().inNamespace("test")
        .list();

    // Then
    assertThat(podSchedulingList).isNotNull();
    assertThat(podSchedulingList.getItems()).hasSize(1);
    assertThat(podSchedulingList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/resource.k8s.io/v1alpha1/namespaces/test/podschedulings/cluster")
        .andReturn(HttpURLConnection.HTTP_OK, createNewPodScheduling("cluster"))
        .once();

    // When
    boolean isDeleted = client.dynamicResourceAllocation().v1alpha1().podSchedulings().inNamespace("test").withName("cluster")
        .delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private PodScheduling createNewPodScheduling(String name) {
    return new PodSchedulingBuilder()
        .withNewMetadata()
        .withName(name)
        .endMetadata()
        .withNewSpec()
        .addToPotentialNodes("potential-node")
        .withSelectedNode("selected-node")
        .endSpec()
        .build();
  }
}
