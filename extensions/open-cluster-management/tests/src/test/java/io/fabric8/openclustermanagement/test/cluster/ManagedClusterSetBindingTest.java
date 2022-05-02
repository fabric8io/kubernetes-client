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
import io.fabric8.openclustermanagement.api.model.cluster.v1beta1.ManagedClusterSetBinding;
import io.fabric8.openclustermanagement.api.model.cluster.v1beta1.ManagedClusterSetBindingBuilder;
import io.fabric8.openclustermanagement.api.model.cluster.v1beta1.ManagedClusterSetBindingList;
import io.fabric8.openclustermanagement.api.model.cluster.v1beta1.ManagedClusterSetBindingListBuilder;
import io.fabric8.openclustermanagement.client.OpenClusterManagementClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient
class ManagedClusterSetBindingTest {
  private OpenClusterManagementClient client;
  private KubernetesMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get()
        .withPath("/apis/cluster.open-cluster-management.io/v1beta1/namespaces/ns1/managedclustersetbindings/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewManagedClusterSetBinding("test-get"))
        .once();

    // When
    ManagedClusterSetBinding managedClusterSetBinding = client.clusters().managedClusterSetBindings().inNamespace("ns1")
        .withName("test-get").get();

    // Then
    assertThat(managedClusterSetBinding)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/cluster.open-cluster-management.io/v1beta1/namespaces/ns1/managedclustersetbindings")
        .andReturn(HttpURLConnection.HTTP_OK, new ManagedClusterSetBindingListBuilder()
            .addToItems(createNewManagedClusterSetBinding("test-list"))
            .build())
        .once();

    // When
    ManagedClusterSetBindingList managedClusterSetBindingList = client.clusters().managedClusterSetBindings().inNamespace("ns1")
        .list();

    // Then
    assertThat(managedClusterSetBindingList).isNotNull();
    assertThat(managedClusterSetBindingList.getItems()).hasSize(1);
    assertThat(managedClusterSetBindingList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete()
        .withPath("/apis/cluster.open-cluster-management.io/v1beta1/namespaces/ns1/managedclustersetbindings/clustersetbinding")
        .andReturn(HttpURLConnection.HTTP_OK, createNewManagedClusterSetBinding("clustersetbinding"))
        .once();

    // When
    boolean isDeleted = client.clusters().managedClusterSetBindings().inNamespace("ns1").withName("clustersetbinding").delete()
        .size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private ManagedClusterSetBinding createNewManagedClusterSetBinding(String name) {
    return new ManagedClusterSetBindingBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withClusterSet("clusterset1")
        .endSpec()
        .build();
  }
}
