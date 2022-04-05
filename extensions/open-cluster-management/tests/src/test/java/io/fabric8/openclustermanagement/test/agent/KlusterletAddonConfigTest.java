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
package io.fabric8.openclustermanagement.test.agent;

import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.openclustermanagement.api.model.agent.v1.KlusterletAddonConfig;
import io.fabric8.openclustermanagement.api.model.agent.v1.KlusterletAddonConfigBuilder;
import io.fabric8.openclustermanagement.api.model.agent.v1.KlusterletAddonConfigList;
import io.fabric8.openclustermanagement.api.model.agent.v1.KlusterletAddonConfigListBuilder;
import io.fabric8.openclustermanagement.client.OpenClusterManagementClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient
class KlusterletAddonConfigTest {
  private OpenClusterManagementClient client;
  private KubernetesMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/agent.open-cluster-management.io/v1/namespaces/ns1/klusterletaddonconfigs/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewKlusterletAddonConfig("test-get"))
        .once();

    // When
    KlusterletAddonConfig klusterletAddonConfig = client.agents().klusterletAddonConfigs().inNamespace("ns1")
        .withName("test-get").get();

    // Then
    assertThat(klusterletAddonConfig)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/agent.open-cluster-management.io/v1/namespaces/ns1/klusterletaddonconfigs")
        .andReturn(HttpURLConnection.HTTP_OK, new KlusterletAddonConfigListBuilder()
            .addToItems(createNewKlusterletAddonConfig("test-list"))
            .build())
        .once();

    // When
    KlusterletAddonConfigList klusterletAddonConfigList = client.agents().klusterletAddonConfigs().inNamespace("ns1").list();

    // Then
    assertThat(klusterletAddonConfigList).isNotNull();
    assertThat(klusterletAddonConfigList.getItems()).hasSize(1);
    assertThat(klusterletAddonConfigList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete()
        .withPath(
            "/apis/agent.open-cluster-management.io/v1/namespaces/ns1/klusterletaddonconfigs/sample-klusterletaddonconfig")
        .andReturn(HttpURLConnection.HTTP_OK, createNewKlusterletAddonConfig("sample-klusterletaddonconfig"))
        .once();

    // When
    Boolean isDeleted = client.agents().klusterletAddonConfigs().inNamespace("ns1").withName("sample-klusterletaddonconfig")
        .delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private KlusterletAddonConfig createNewKlusterletAddonConfig(String name) {
    return new KlusterletAddonConfigBuilder()
        .withNewMetadata()
        .withName(name)
        .endMetadata()
        .withNewSpec()
        .withNewApplicationManager()
        .withEnabled(true)
        .endApplicationManager()
        .withNewPolicyController()
        .withEnabled(true)
        .endPolicyController()
        .withNewSearchCollector()
        .withEnabled(true)
        .endSearchCollector()
        .withNewCertPolicyController()
        .withEnabled(true)
        .endCertPolicyController()
        .withNewIamPolicyController()
        .withEnabled(true)
        .endIamPolicyController()
        .endSpec()
        .build();
  }

}
