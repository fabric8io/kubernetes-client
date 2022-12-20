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
package io.fabric8.kubernetes.client.mock;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.flowcontrol.v1beta2.PriorityLevelConfiguration;
import io.fabric8.kubernetes.api.model.flowcontrol.v1beta2.PriorityLevelConfigurationBuilder;
import io.fabric8.kubernetes.api.model.flowcontrol.v1beta2.PriorityLevelConfigurationList;
import io.fabric8.kubernetes.api.model.flowcontrol.v1beta2.PriorityLevelConfigurationListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@EnableKubernetesMockClient
class V1beta2PriorityLevelConfigurationTest {
  private KubernetesMockServer server;
  private KubernetesClient client;

  @Test
  void load() {
    List<HasMetadata> items = client.load(getClass().getResourceAsStream("/v1beta2-prioritylevelconfiguration.yml")).items();
    assertThat(items).isNotNull().hasSize(1);
    AssertionsForClassTypes.assertThat(items.get(0))
        .isInstanceOf(PriorityLevelConfiguration.class)
        .hasFieldOrPropertyWithValue("metadata.name", "my-priority-level-configuration");
  }

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/flowcontrol.apiserver.k8s.io/v1beta2/prioritylevelconfigurations/plc1")
        .andReturn(HttpURLConnection.HTTP_OK, createPriorityLevelConfiguration("plc1"))
        .once();

    // When
    PriorityLevelConfiguration priorityLevelConfiguration = client.flowControl().v1beta2().priorityLevelConfigurations()
        .withName("plc1").get();

    // Then
    AssertionsForClassTypes.assertThat(priorityLevelConfiguration)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "plc1");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/flowcontrol.apiserver.k8s.io/v1beta2/prioritylevelconfigurations")
        .andReturn(HttpURLConnection.HTTP_OK, new PriorityLevelConfigurationListBuilder()
            .addToItems(createPriorityLevelConfiguration("exempt"))
            .build())
        .once();

    // When
    PriorityLevelConfigurationList priorityLevelConfigurations = client.flowControl().v1beta2().priorityLevelConfigurations()
        .list();

    // Then
    AssertionsForClassTypes.assertThat(priorityLevelConfigurations).isNotNull();
    assertThat(priorityLevelConfigurations.getItems()).hasSize(1);
    AssertionsForClassTypes.assertThat(priorityLevelConfigurations.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "exempt");
  }

  @Test
  void create() {
    // Given
    PriorityLevelConfiguration priorityLevelConfiguration = createPriorityLevelConfiguration("prioritylevelconfiguration1");
    server.expect().post().withPath("/apis/flowcontrol.apiserver.k8s.io/v1beta2/prioritylevelconfigurations")
        .andReturn(HttpURLConnection.HTTP_OK, priorityLevelConfiguration)
        .once();

    // When
    PriorityLevelConfiguration createdPriorityLevelConfiguration = client.flowControl().v1beta2().priorityLevelConfigurations()
        .create(priorityLevelConfiguration);

    // Then
    AssertionsForClassTypes.assertThat(createdPriorityLevelConfiguration).isNotNull();
    AssertionsForClassTypes.assertThat(createdPriorityLevelConfiguration)
        .hasFieldOrPropertyWithValue("metadata.name", "prioritylevelconfiguration1");
  }

  @Test
  void delete() {
    // Given
    PriorityLevelConfiguration priorityLevelConfiguration = createPriorityLevelConfiguration("prioritylevelconfiguration1");
    server.expect().delete()
        .withPath("/apis/flowcontrol.apiserver.k8s.io/v1beta2/prioritylevelconfigurations/prioritylevelconfiguration1")
        .andReturn(HttpURLConnection.HTTP_OK, priorityLevelConfiguration)
        .once();

    // When
    boolean isDeleted = client.flowControl().v1beta2().priorityLevelConfigurations().withName("prioritylevelconfiguration1")
        .delete().size() == 1;

    // Then
    AssertionsForClassTypes.assertThat(isDeleted).isTrue();
  }

  private PriorityLevelConfiguration createPriorityLevelConfiguration(String name) {
    return new PriorityLevelConfigurationBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withNewLimited()
        .withAssuredConcurrencyShares(20)
        .withNewLimitResponse()
        .withNewQueuing()
        .withHandSize(3)
        .withQueueLengthLimit(50)
        .withQueues(16)
        .endQueuing()
        .withType("Queue")
        .endLimitResponse()
        .endLimited()
        .withType("Limited")
        .endSpec()
        .build();
  }
}
