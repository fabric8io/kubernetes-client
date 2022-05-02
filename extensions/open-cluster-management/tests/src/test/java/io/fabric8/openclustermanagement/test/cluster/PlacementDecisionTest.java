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
package io.fabric8.openclustermanagement.test.cluster;

import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.openclustermanagement.api.model.cluster.v1alpha1.PlacementDecision;
import io.fabric8.openclustermanagement.api.model.cluster.v1alpha1.PlacementDecisionBuilder;
import io.fabric8.openclustermanagement.api.model.cluster.v1alpha1.PlacementDecisionList;
import io.fabric8.openclustermanagement.api.model.cluster.v1alpha1.PlacementDecisionListBuilder;
import io.fabric8.openclustermanagement.client.OpenClusterManagementClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient
class PlacementDecisionTest {
  private OpenClusterManagementClient client;
  private KubernetesMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get()
        .withPath("/apis/cluster.open-cluster-management.io/v1alpha1/namespaces/ns1/placementdecisions/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewPlacementDecision("test-get"))
        .once();

    // When
    PlacementDecision placementDecision = client.clusters().placementDecisions().inNamespace("ns1").withName("test-get").get();

    // Then
    assertThat(placementDecision)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/cluster.open-cluster-management.io/v1alpha1/namespaces/ns1/placementdecisions")
        .andReturn(HttpURLConnection.HTTP_OK, new PlacementDecisionListBuilder()
            .addToItems(createNewPlacementDecision("test-list"))
            .build())
        .once();

    // When
    PlacementDecisionList placementDecisionList = client.clusters().placementDecisions().inNamespace("ns1").list();

    // Then
    assertThat(placementDecisionList).isNotNull();
    assertThat(placementDecisionList.getItems()).hasSize(1);
    assertThat(placementDecisionList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete()
        .withPath("/apis/cluster.open-cluster-management.io/v1alpha1/namespaces/ns1/placementdecisions/placement1")
        .andReturn(HttpURLConnection.HTTP_OK, createNewPlacementDecision("placement1"))
        .once();

    // When
    boolean isDeleted = client.clusters().placementDecisions().inNamespace("ns1").withName("placement1").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private PlacementDecision createNewPlacementDecision(String name) {
    return new PlacementDecisionBuilder()
        .withNewMetadata()
        .withName(name)
        .addToAnnotations("cluster.open-cluster-management.io/placement", "placement1")
        .endMetadata()
        .build();
  }
}
