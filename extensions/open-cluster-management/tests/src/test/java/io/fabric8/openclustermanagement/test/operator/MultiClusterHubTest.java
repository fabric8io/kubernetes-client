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
import io.fabric8.openclustermanagement.api.model.multiclusterhub.operator.v1.MultiClusterHub;
import io.fabric8.openclustermanagement.api.model.multiclusterhub.operator.v1.MultiClusterHubBuilder;
import io.fabric8.openclustermanagement.api.model.multiclusterhub.operator.v1.MultiClusterHubList;
import io.fabric8.openclustermanagement.api.model.multiclusterhub.operator.v1.MultiClusterHubListBuilder;
import io.fabric8.openclustermanagement.client.OpenClusterManagementClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient
class MultiClusterHubTest {
  private OpenClusterManagementClient client;
  private KubernetesMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/operator.open-cluster-management.io/v1/namespaces/ns1/multiclusterhubs/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewMultiClusterHub("test-get"))
        .once();

    // When
    MultiClusterHub multiClusterHub = client.operator().multiClusterHubs().inNamespace("ns1").withName("test-get").get();

    // Then
    assertThat(multiClusterHub)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/operator.open-cluster-management.io/v1/namespaces/ns1/multiclusterhubs")
        .andReturn(HttpURLConnection.HTTP_OK, new MultiClusterHubListBuilder()
            .addToItems(createNewMultiClusterHub("test-list"))
            .build())
        .once();

    // When
    MultiClusterHubList multiClusterHubList = client.operator().multiClusterHubs().inNamespace("ns1").list();

    // Then
    assertThat(multiClusterHubList).isNotNull();
    assertThat(multiClusterHubList.getItems()).hasSize(1);
    assertThat(multiClusterHubList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/operator.open-cluster-management.io/v1/namespaces/ns1/multiclusterhubs/sample-mch")
        .andReturn(HttpURLConnection.HTTP_OK, createNewMultiClusterHub("sample-mch"))
        .once();

    // When
    boolean isDeleted = client.operator().multiClusterHubs().inNamespace("ns1").withName("sample-mch").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private MultiClusterHub createNewMultiClusterHub(String name) {
    return new MultiClusterHubBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withImagePullSecret("redhat-registry")
        .withDisableHubSelfManagement(false)
        .endSpec()
        .build();
  }
}
