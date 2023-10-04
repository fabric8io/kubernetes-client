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
package io.fabric8.openshift.client.server.mock;

import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.openshift.api.model.operatorhub.v1.OLMConfig;
import io.fabric8.openshift.api.model.operatorhub.v1.OLMConfigBuilder;
import io.fabric8.openshift.api.model.operatorhub.v1.OLMConfigList;
import io.fabric8.openshift.api.model.operatorhub.v1.OLMConfigListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient
class OLMConfigTest {
  private OpenShiftClient client;
  private KubernetesMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/operators.coreos.com/v1/olmconfigs/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewOLMConfig("test-get"))
        .once();

    // When
    OLMConfig olmConfig = client.operatorHub().olmConfigs().withName("test-get").get();

    // Then
    assertThat(olmConfig)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/operators.coreos.com/v1/olmconfigs")
        .andReturn(HttpURLConnection.HTTP_OK, new OLMConfigListBuilder()
            .addToItems(createNewOLMConfig("test-list"))
            .build())
        .once();

    // When
    OLMConfigList olmConfigList = client.operatorHub().olmConfigs().list();

    // Then
    assertThat(olmConfigList).isNotNull();
    assertThat(olmConfigList.getItems()).hasSize(1);
    assertThat(olmConfigList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/operators.coreos.com/v1/olmconfigs/cluster")
        .andReturn(HttpURLConnection.HTTP_OK, createNewOLMConfig("cluster"))
        .once();

    // When
    boolean isDeleted = client.operatorHub().olmConfigs().withName("cluster").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private OLMConfig createNewOLMConfig(String name) {
    return new OLMConfigBuilder()
        .withNewMetadata()
        .withName(name)
        .endMetadata()
        .withNewSpec()
        .withNewFeatures()
        .withDisableCopiedCSVs(true)
        .endFeatures()
        .endSpec()
        .build();
  }
}
