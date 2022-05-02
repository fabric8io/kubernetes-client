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

import io.fabric8.openshift.api.model.clusterautoscaling.v1.ClusterAutoscaler;
import io.fabric8.openshift.api.model.clusterautoscaling.v1.ClusterAutoscalerBuilder;
import io.fabric8.openshift.api.model.clusterautoscaling.v1.ClusterAutoscalerList;
import io.fabric8.openshift.api.model.clusterautoscaling.v1.ClusterAutoscalerListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class ClusterAutoscalerTest {
  private OpenShiftMockServer server;
  private OpenShiftClient client;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/autoscaling.openshift.io/v1/clusterautoscalers/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewClusterAutoscaler("test-get"))
        .once();

    // When
    ClusterAutoscaler clusterAutoscaler = client.clusterAutoscaling().v1().clusterAutoscalers().withName("test-get").get();

    // Then
    assertThat(clusterAutoscaler)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/autoscaling.openshift.io/v1/clusterautoscalers")
        .andReturn(HttpURLConnection.HTTP_OK, new ClusterAutoscalerListBuilder()
            .addToItems(createNewClusterAutoscaler("test-list"))
            .build())
        .once();

    // When
    ClusterAutoscalerList clusterAutoscalerList = client.clusterAutoscaling().v1().clusterAutoscalers().list();

    // Then
    assertThat(clusterAutoscalerList).isNotNull();
    assertThat(clusterAutoscalerList.getItems()).hasSize(1);
    assertThat(clusterAutoscalerList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/autoscaling.openshift.io/v1/clusterautoscalers/cluster")
        .andReturn(HttpURLConnection.HTTP_OK, createNewClusterAutoscaler("cluster"))
        .once();

    // When
    boolean isDeleted = client.clusterAutoscaling().v1().clusterAutoscalers().withName("cluster").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private ClusterAutoscaler createNewClusterAutoscaler(String name) {
    return new ClusterAutoscalerBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withBalanceSimilarNodeGroups(true)
        .withIgnoreDaemonsetsUtilization(false)
        .withSkipNodesWithLocalStorage(true)
        .withPodPriorityThreshold(-10)
        .withNewResourceLimits()
        .withMaxNodesTotal(24)
        .withNewCores()
        .withMin(0)
        .withMax(128)
        .endCores()
        .withNewMemory()
        .withMin(4)
        .withMax(256)
        .endMemory()
        .addNewGpus(0, 16, "example.com/gpu")
        .endResourceLimits()
        .withNewScaleDown()
        .withEnabled(true)
        .withDelayAfterAdd("10s")
        .withDelayAfterDelete("10s")
        .withDelayAfterFailure("10s")
        .endScaleDown()
        .endSpec()
        .build();
  }

}
