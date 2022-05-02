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
package io.fabric8.openclustermanagement.test.discovery;

import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.openclustermanagement.api.model.discovery.v1alpha1.DiscoveredCluster;
import io.fabric8.openclustermanagement.api.model.discovery.v1alpha1.DiscoveredClusterBuilder;
import io.fabric8.openclustermanagement.api.model.discovery.v1alpha1.DiscoveredClusterList;
import io.fabric8.openclustermanagement.api.model.discovery.v1alpha1.DiscoveredClusterListBuilder;
import io.fabric8.openclustermanagement.client.OpenClusterManagementClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient
class DiscoveredClusterTest {
  private OpenClusterManagementClient client;
  private KubernetesMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get()
        .withPath("/apis/discovery.open-cluster-management.io/v1alpha1/namespaces/ns1/discoveredclusters/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewDiscoveredCluster("test-get"))
        .once();

    // When
    DiscoveredCluster discoveredCluster = client.discovery().discoveredClusters().inNamespace("ns1").withName("test-get").get();

    // Then
    assertThat(discoveredCluster)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/discovery.open-cluster-management.io/v1alpha1/namespaces/ns1/discoveredclusters")
        .andReturn(HttpURLConnection.HTTP_OK, new DiscoveredClusterListBuilder()
            .addToItems(createNewDiscoveredCluster("test-list"))
            .build())
        .once();

    // When
    DiscoveredClusterList discoveredClusterList = client.discovery().discoveredClusters().inNamespace("ns1").list();

    // Then
    assertThat(discoveredClusterList).isNotNull();
    assertThat(discoveredClusterList.getItems()).hasSize(1);
    assertThat(discoveredClusterList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete()
        .withPath("/apis/discovery.open-cluster-management.io/v1alpha1/namespaces/ns1/discoveredclusters/sample-dc")
        .andReturn(HttpURLConnection.HTTP_OK, createNewDiscoveredCluster("sample-dc"))
        .once();

    // When
    boolean isDeleted = client.discovery().discoveredClusters().inNamespace("ns1").withName("sample-dc").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private DiscoveredCluster createNewDiscoveredCluster(String name) {
    return new DiscoveredClusterBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withName("crc-cluster")
        .withApiUrl("https://api.crc.testing:6443")
        .withCloudProvider("RedHat")
        .withDisplayName("Crc")
        .endSpec()
        .build();
  }
}
