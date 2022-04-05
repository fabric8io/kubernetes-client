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
package io.fabric8.openclustermanagement.test.policy;

import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.openclustermanagement.api.model.governancepolicypropagator.policy.v1.PlacementBinding;
import io.fabric8.openclustermanagement.api.model.governancepolicypropagator.policy.v1.PlacementBindingBuilder;
import io.fabric8.openclustermanagement.api.model.governancepolicypropagator.policy.v1.PlacementBindingList;
import io.fabric8.openclustermanagement.api.model.governancepolicypropagator.policy.v1.PlacementBindingListBuilder;
import io.fabric8.openclustermanagement.client.OpenClusterManagementClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient
class PlacementBindingTest {
  private OpenClusterManagementClient client;
  private KubernetesMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/policy.open-cluster-management.io/v1/namespaces/ns1/placementbindings/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewPlacementBinding("test-get"))
        .once();

    // When
    PlacementBinding placementBinding = client.policy().placementBindings().inNamespace("ns1").withName("test-get").get();

    // Then
    assertThat(placementBinding)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/policy.open-cluster-management.io/v1/namespaces/ns1/placementbindings")
        .andReturn(HttpURLConnection.HTTP_OK, new PlacementBindingListBuilder()
            .addToItems(createNewPlacementBinding("test-list"))
            .build())
        .once();

    // When
    PlacementBindingList placementBindingList = client.policy().placementBindings().inNamespace("ns1").list();

    // Then
    assertThat(placementBindingList).isNotNull();
    assertThat(placementBindingList.getItems()).hasSize(1);
    assertThat(placementBindingList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/policy.open-cluster-management.io/v1/namespaces/ns1/placementbindings/sample-pb")
        .andReturn(HttpURLConnection.HTTP_OK, createNewPlacementBinding("sample-pb"))
        .once();

    // When
    boolean isDeleted = client.policy().placementBindings().inNamespace("ns1").withName("sample-pb").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private PlacementBinding createNewPlacementBinding(String name) {
    return new PlacementBindingBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewPlacementRef()
        .withName("test-policy-plr")
        .withApiGroup("apps.open-cluster-management.io")
        .withKind("PlacementRule")
        .endPlacementRef()
        .addNewSubject()
        .withName("test-policy")
        .withApiGroup("policy.open-cluster-management.io")
        .withKind("Policy")
        .endSubject()
        .build();
  }
}
