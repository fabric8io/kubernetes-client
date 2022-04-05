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
import io.fabric8.openclustermanagement.api.model.multiclusterobservabilityoperator.apps.v1beta2.MultiClusterObservability;
import io.fabric8.openclustermanagement.api.model.multiclusterobservabilityoperator.apps.v1beta2.MultiClusterObservabilityBuilder;
import io.fabric8.openclustermanagement.api.model.multiclusterobservabilityoperator.apps.v1beta2.MultiClusterObservabilityList;
import io.fabric8.openclustermanagement.api.model.multiclusterobservabilityoperator.apps.v1beta2.MultiClusterObservabilityListBuilder;
import io.fabric8.openclustermanagement.client.OpenClusterManagementClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient
class MultiClusterObservabilityTest {
  private OpenClusterManagementClient client;
  private KubernetesMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get()
        .withPath("/apis/observability.open-cluster-management.io/v1beta2/multiclusterobservabilities/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewMultiClusterObservability("test-get"))
        .once();

    // When
    MultiClusterObservability multiClusterObservability = client.observability().multiClusterObservailities()
        .withName("test-get").get();

    // Then
    assertThat(multiClusterObservability)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/observability.open-cluster-management.io/v1beta2/multiclusterobservabilities")
        .andReturn(HttpURLConnection.HTTP_OK, new MultiClusterObservabilityListBuilder()
            .addToItems(createNewMultiClusterObservability("test-list"))
            .build())
        .once();

    // When
    MultiClusterObservabilityList multiClusterObservabilityList = client.observability().multiClusterObservailities().list();

    // Then
    assertThat(multiClusterObservabilityList).isNotNull();
    assertThat(multiClusterObservabilityList.getItems()).hasSize(1);
    assertThat(multiClusterObservabilityList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete()
        .withPath("/apis/observability.open-cluster-management.io/v1beta2/multiclusterobservabilities/sample-mch")
        .andReturn(HttpURLConnection.HTTP_OK, createNewMultiClusterObservability("sample-mch"))
        .once();

    // When
    boolean isDeleted = client.observability().multiClusterObservailities().withName("sample-mch").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private MultiClusterObservability createNewMultiClusterObservability(String name) {
    return new MultiClusterObservabilityBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .endSpec()
        .build();
  }
}
