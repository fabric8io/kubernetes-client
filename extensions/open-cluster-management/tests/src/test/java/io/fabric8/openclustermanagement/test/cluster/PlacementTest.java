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
import io.fabric8.openclustermanagement.api.model.cluster.v1alpha1.Placement;
import io.fabric8.openclustermanagement.api.model.cluster.v1alpha1.PlacementBuilder;
import io.fabric8.openclustermanagement.api.model.cluster.v1alpha1.PlacementList;
import io.fabric8.openclustermanagement.api.model.cluster.v1alpha1.PlacementListBuilder;
import io.fabric8.openclustermanagement.client.OpenClusterManagementClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient
class PlacementTest {
  private OpenClusterManagementClient client;
  private KubernetesMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/cluster.open-cluster-management.io/v1alpha1/namespaces/ns1/placements/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewPlacement("test-get"))
        .once();

    // When
    Placement placement = client.clusters().placements().inNamespace("ns1").withName("test-get").get();

    // Then
    assertThat(placement)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/cluster.open-cluster-management.io/v1alpha1/namespaces/ns1/placements")
        .andReturn(HttpURLConnection.HTTP_OK, new PlacementListBuilder()
            .addToItems(createNewPlacement("test-list"))
            .build())
        .once();

    // When
    PlacementList placementList = client.clusters().placements().inNamespace("ns1").list();

    // Then
    assertThat(placementList).isNotNull();
    assertThat(placementList.getItems()).hasSize(1);
    assertThat(placementList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/cluster.open-cluster-management.io/v1alpha1/namespaces/ns1/placements/placement1")
        .andReturn(HttpURLConnection.HTTP_OK, createNewPlacement("placement1"))
        .once();

    // When
    boolean isDeleted = client.clusters().placements().inNamespace("ns1").withName("placement1").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private Placement createNewPlacement(String name) {
    return new PlacementBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .addNewPredicate()
        .withNewRequiredClusterSelector()
        .withNewLabelSelector()
        .addToMatchLabels("vendor", "OpenShift")
        .endLabelSelector()
        .endRequiredClusterSelector()
        .endPredicate()
        .endSpec()
        .build();
  }
}
