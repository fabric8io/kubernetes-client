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
package io.fabric8.openclustermanagement.test.apps;

import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorsplacementrule.apps.v1.PlacementRule;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorsplacementrule.apps.v1.PlacementRuleBuilder;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorsplacementrule.apps.v1.PlacementRuleList;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorsplacementrule.apps.v1.PlacementRuleListBuilder;
import io.fabric8.openclustermanagement.client.OpenClusterManagementClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient
class PlacementRuleTest {
  private OpenClusterManagementClient client;
  private KubernetesMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/apps.open-cluster-management.io/v1/namespaces/ns1/placementrules/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewPlacementRule("test-get"))
        .once();

    // When
    PlacementRule placementRule = client.apps().placementRules().inNamespace("ns1").withName("test-get").get();

    // Then
    assertThat(placementRule)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/apps.open-cluster-management.io/v1/namespaces/ns1/placementrules")
        .andReturn(HttpURLConnection.HTTP_OK, new PlacementRuleListBuilder()
            .addToItems(createNewPlacementRule("test-list"))
            .build())
        .once();

    // When
    PlacementRuleList placementRuleList = client.apps().placementRules().inNamespace("ns1").list();

    // Then
    assertThat(placementRuleList).isNotNull();
    assertThat(placementRuleList.getItems()).hasSize(1);
    assertThat(placementRuleList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/apps.open-cluster-management.io/v1/namespaces/ns1/placementrules/towhichcluster")
        .andReturn(HttpURLConnection.HTTP_OK, createNewPlacementRule("towhichcluster"))
        .once();

    // When
    boolean isDeleted = client.apps().placementRules().inNamespace("ns1").withName("towhichcluster").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private PlacementRule createNewPlacementRule(String name) {
    return new PlacementRuleBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .addNewClusterCondition()
        .withType("ManagedClusterConditionAvailable")
        .withStatus("True")
        .endClusterCondition()
        .endSpec()
        .build();
  }
}
