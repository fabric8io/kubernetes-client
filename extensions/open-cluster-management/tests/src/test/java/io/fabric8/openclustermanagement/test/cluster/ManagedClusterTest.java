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
import io.fabric8.openclustermanagement.api.model.cluster.v1.ManagedCluster;
import io.fabric8.openclustermanagement.api.model.cluster.v1.ManagedClusterBuilder;
import io.fabric8.openclustermanagement.api.model.cluster.v1.ManagedClusterList;
import io.fabric8.openclustermanagement.api.model.cluster.v1.ManagedClusterListBuilder;
import io.fabric8.openclustermanagement.client.OpenClusterManagementClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient
class ManagedClusterTest {
  private OpenClusterManagementClient client;
  private KubernetesMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/cluster.open-cluster-management.io/v1/managedclusters/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewManagedCluster("test-get"))
        .once();

    // When
    ManagedCluster managedCluster = client.clusters().managedClusters().withName("test-get").get();

    // Then
    assertThat(managedCluster)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/cluster.open-cluster-management.io/v1/managedclusters")
        .andReturn(HttpURLConnection.HTTP_OK, new ManagedClusterListBuilder()
            .addToItems(createNewManagedCluster("test-list"))
            .build())
        .once();

    // When
    ManagedClusterList managedClusterList = client.clusters().managedClusters().list();

    // Then
    assertThat(managedClusterList).isNotNull();
    assertThat(managedClusterList.getItems()).hasSize(1);
    assertThat(managedClusterList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/cluster.open-cluster-management.io/v1/managedclusters/cluster")
        .andReturn(HttpURLConnection.HTTP_OK, createNewManagedCluster("cluster"))
        .once();

    // When
    boolean isDeleted = client.clusters().managedClusters().withName("cluster").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private ManagedCluster createNewManagedCluster(String name) {
    return new ManagedClusterBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withHubAcceptsClient(true)
        .addNewManagedClusterClientConfig()
        .withCaBundle("test")
        .withUrl("test.com")
        .endManagedClusterClientConfig()
        .endSpec()
        .build();
  }
}
