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
package io.fabric8.openshift.client.server.mock.hive;

import io.fabric8.openshift.api.model.hive.v1.ClusterRelocate;
import io.fabric8.openshift.api.model.hive.v1.ClusterRelocateBuilder;
import io.fabric8.openshift.api.model.hive.v1.ClusterRelocateList;
import io.fabric8.openshift.api.model.hive.v1.ClusterRelocateListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import io.fabric8.openshift.client.server.mock.EnableOpenShiftMockClient;
import io.fabric8.openshift.client.server.mock.OpenShiftMockServer;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class ClusterRelocateTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/hive.openshift.io/v1/namespaces/ns1/clusterrelocates/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewClusterRelocate("test-get"))
        .once();

    // When
    ClusterRelocate clusterRelocate = client.hive().clusterRelocates().inNamespace("ns1").withName("test-get").get();

    // Then
    assertThat(clusterRelocate)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/hive.openshift.io/v1/namespaces/ns1/clusterrelocates")
        .andReturn(HttpURLConnection.HTTP_OK, new ClusterRelocateListBuilder()
            .addToItems(createNewClusterRelocate("test-list"))
            .build())
        .once();

    // When
    ClusterRelocateList clusterRelocateList = client.hive().clusterRelocates().inNamespace("ns1").list();

    // Then
    assertThat(clusterRelocateList).isNotNull();
    assertThat(clusterRelocateList.getItems()).hasSize(1);
    assertThat(clusterRelocateList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/hive.openshift.io/v1/namespaces/ns1/clusterrelocates/clusterrelocate1")
        .andReturn(HttpURLConnection.HTTP_OK, createNewClusterRelocate("clusterrelocate1"))
        .once();

    // When
    boolean isDeleted = client.hive().clusterRelocates().inNamespace("ns1").withName("clusterrelocate1").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private ClusterRelocate createNewClusterRelocate(String name) {
    return new ClusterRelocateBuilder()
        .withNewMetadata()
        .withName(name)
        .endMetadata()
        .withNewSpec()
        .withNewKubeconfigSecretRef()
        .withName("hive2-remote-kubeconfig-secret")
        .withNamespace("hive")
        .endKubeconfigSecretRef()
        .withNewClusterDeploymentSelector()
        .addToMatchLabels("hive-instance", "hive2")
        .endClusterDeploymentSelector()
        .endSpec()
        .build();
  }
}
