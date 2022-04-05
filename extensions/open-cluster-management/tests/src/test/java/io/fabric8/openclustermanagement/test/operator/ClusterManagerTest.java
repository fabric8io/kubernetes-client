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
package io.fabric8.openclustermanagement.test.operator;

import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.openclustermanagement.api.model.operator.v1.ClusterManager;
import io.fabric8.openclustermanagement.api.model.operator.v1.ClusterManagerBuilder;
import io.fabric8.openclustermanagement.api.model.operator.v1.ClusterManagerList;
import io.fabric8.openclustermanagement.api.model.operator.v1.ClusterManagerListBuilder;
import io.fabric8.openclustermanagement.client.OpenClusterManagementClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient
class ClusterManagerTest {
  private OpenClusterManagementClient client;
  private KubernetesMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/operator.open-cluster-management.io/v1/clustermanagers/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewClusterManager("test-get"))
        .once();

    // When
    ClusterManager clusterManager = client.operator().clusterManagers().withName("test-get").get();

    // Then
    assertThat(clusterManager)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/operator.open-cluster-management.io/v1/clustermanagers")
        .andReturn(HttpURLConnection.HTTP_OK, new ClusterManagerListBuilder()
            .addToItems(createNewClusterManager("test-list"))
            .build())
        .once();

    // When
    ClusterManagerList clusterManagerList = client.operator().clusterManagers().list();

    // Then
    assertThat(clusterManagerList).isNotNull();
    assertThat(clusterManagerList.getItems()).hasSize(1);
    assertThat(clusterManagerList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/operator.open-cluster-management.io/v1/clustermanagers/sample-cm")
        .andReturn(HttpURLConnection.HTTP_OK, createNewClusterManager("sample-cm"))
        .once();

    // When
    boolean isDeleted = client.operator().clusterManagers().withName("sample-cm").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private ClusterManager createNewClusterManager(String name) {
    return new ClusterManagerBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withRegistrationImagePullSpec("quay.io/open-cluster-management/registration")
        .withWorkImagePullSpec("quay.io/open-cluster-management/work")
        .withPlacementImagePullSpec("quay.io/open-cluster-management/placement")
        .endSpec()
        .build();
  }
}
