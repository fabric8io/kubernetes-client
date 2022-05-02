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
package io.fabric8.openclustermanagement.test.observability;

import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.openclustermanagement.api.model.multiclusterobservabilityoperator.apps.v1beta1.ObservabilityAddon;
import io.fabric8.openclustermanagement.api.model.multiclusterobservabilityoperator.apps.v1beta1.ObservabilityAddonBuilder;
import io.fabric8.openclustermanagement.api.model.multiclusterobservabilityoperator.apps.v1beta1.ObservabilityAddonList;
import io.fabric8.openclustermanagement.api.model.multiclusterobservabilityoperator.apps.v1beta1.ObservabilityAddonListBuilder;
import io.fabric8.openclustermanagement.client.OpenClusterManagementClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient
class ObservabilityAddonTest {
  private OpenClusterManagementClient client;
  private KubernetesMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get()
        .withPath("/apis/observability.open-cluster-management.io/v1beta1/namespaces/ns1/observabilityaddons/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewObservabilityAddon("test-get"))
        .once();

    // When
    ObservabilityAddon observabilityAddon = client.observability().observabilityAddons().inNamespace("ns1").withName("test-get")
        .get();

    // Then
    assertThat(observabilityAddon)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/observability.open-cluster-management.io/v1beta1/namespaces/ns1/observabilityaddons")
        .andReturn(HttpURLConnection.HTTP_OK, new ObservabilityAddonListBuilder()
            .addToItems(createNewObservabilityAddon("test-list"))
            .build())
        .once();

    // When
    ObservabilityAddonList observabilityAddonList = client.observability().observabilityAddons().inNamespace("ns1").list();

    // Then
    assertThat(observabilityAddonList).isNotNull();
    assertThat(observabilityAddonList.getItems()).hasSize(1);
    assertThat(observabilityAddonList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath(
        "/apis/observability.open-cluster-management.io/v1beta1/namespaces/ns1/observabilityaddons/sample-observabilityaddon")
        .andReturn(HttpURLConnection.HTTP_OK, createNewObservabilityAddon("sample-observabilityaddon"))
        .once();

    // When
    Boolean isDeleted = client.observability().observabilityAddons().inNamespace("ns1").withName("sample-observabilityaddon")
        .delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private ObservabilityAddon createNewObservabilityAddon(String name) {
    return new ObservabilityAddonBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withEnableMetrics(true)
        .withInterval(10)
        .endSpec()
        .build();
  }
}
