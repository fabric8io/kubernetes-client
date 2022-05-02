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
import io.fabric8.openclustermanagement.api.model.discovery.v1alpha1.DiscoveryConfig;
import io.fabric8.openclustermanagement.api.model.discovery.v1alpha1.DiscoveryConfigBuilder;
import io.fabric8.openclustermanagement.api.model.discovery.v1alpha1.DiscoveryConfigList;
import io.fabric8.openclustermanagement.api.model.discovery.v1alpha1.DiscoveryConfigListBuilder;
import io.fabric8.openclustermanagement.client.OpenClusterManagementClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient
class DiscoveryConfigTest {
  private OpenClusterManagementClient client;
  private KubernetesMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get()
        .withPath("/apis/discovery.open-cluster-management.io/v1alpha1/namespaces/ns1/discoveryconfigs/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewDiscoveryConfig("test-get"))
        .once();

    // When
    DiscoveryConfig discoveryConfig = client.discovery().discoveryConfigs().inNamespace("ns1").withName("test-get").get();

    // Then
    assertThat(discoveryConfig)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/discovery.open-cluster-management.io/v1alpha1/namespaces/ns1/discoveryconfigs")
        .andReturn(HttpURLConnection.HTTP_OK, new DiscoveryConfigListBuilder()
            .addToItems(createNewDiscoveryConfig("test-list"))
            .build())
        .once();

    // When
    DiscoveryConfigList discoveryConfigList = client.discovery().discoveryConfigs().inNamespace("ns1").list();

    // Then
    assertThat(discoveryConfigList).isNotNull();
    assertThat(discoveryConfigList.getItems()).hasSize(1);
    assertThat(discoveryConfigList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete()
        .withPath("/apis/discovery.open-cluster-management.io/v1alpha1/namespaces/ns1/discoveryconfigs/sample-discoveryconfig")
        .andReturn(HttpURLConnection.HTTP_OK, createNewDiscoveryConfig("sample-discoveryconfig"))
        .once();

    // When
    boolean isDeleted = client.discovery().discoveryConfigs().inNamespace("ns1").withName("sample-discoveryconfig").delete()
        .size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private DiscoveryConfig createNewDiscoveryConfig(String name) {
    return new DiscoveryConfigBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withCredential("ocm-api-token")
        .withNewFilters()
        .withLastActive(7)
        .endFilters()
        .endSpec()
        .build();
  }
}
