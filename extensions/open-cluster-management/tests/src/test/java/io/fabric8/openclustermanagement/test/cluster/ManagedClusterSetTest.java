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
import io.fabric8.openclustermanagement.api.model.cluster.v1beta1.ManagedClusterSet;
import io.fabric8.openclustermanagement.api.model.cluster.v1beta1.ManagedClusterSetBuilder;
import io.fabric8.openclustermanagement.api.model.cluster.v1beta1.ManagedClusterSetList;
import io.fabric8.openclustermanagement.api.model.cluster.v1beta1.ManagedClusterSetListBuilder;
import io.fabric8.openclustermanagement.client.OpenClusterManagementClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient
class ManagedClusterSetTest {
  private OpenClusterManagementClient client;
  private KubernetesMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/cluster.open-cluster-management.io/v1beta1/managedclustersets/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewManagedClusterSet("test-get"))
        .once();

    // When
    ManagedClusterSet managedClusterSet = client.clusters().managedClusterSets().withName("test-get").get();

    // Then
    assertThat(managedClusterSet)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/cluster.open-cluster-management.io/v1beta1/managedclustersets")
        .andReturn(HttpURLConnection.HTTP_OK, new ManagedClusterSetListBuilder()
            .addToItems(createNewManagedClusterSet("test-list"))
            .build())
        .once();

    // When
    ManagedClusterSetList managedClusterSetList = client.clusters().managedClusterSets().list();

    // Then
    assertThat(managedClusterSetList).isNotNull();
    assertThat(managedClusterSetList.getItems()).hasSize(1);
    assertThat(managedClusterSetList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/cluster.open-cluster-management.io/v1beta1/managedclustersets/clusterset")
        .andReturn(HttpURLConnection.HTTP_OK, createNewManagedClusterSet("clusterset"))
        .once();

    // When
    boolean isDeleted = client.clusters().managedClusterSets().withName("clusterset").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private ManagedClusterSet createNewManagedClusterSet(String name) {
    return new ManagedClusterSetBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .endSpec()
        .build();
  }
}
