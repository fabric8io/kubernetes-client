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

import io.fabric8.openshift.api.model.hive.v1.HiveConfig;
import io.fabric8.openshift.api.model.hive.v1.HiveConfigBuilder;
import io.fabric8.openshift.api.model.hive.v1.HiveConfigList;
import io.fabric8.openshift.api.model.hive.v1.HiveConfigListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import io.fabric8.openshift.client.server.mock.EnableOpenShiftMockClient;
import io.fabric8.openshift.client.server.mock.OpenShiftMockServer;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class HiveConfigTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/hive.openshift.io/v1/hiveconfigs/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewHiveConfig("test-get"))
        .once();

    // When
    HiveConfig hiveConfig = client.hive().hiveConfigs().withName("test-get").get();

    // Then
    assertThat(hiveConfig)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/hive.openshift.io/v1/hiveconfigs")
        .andReturn(HttpURLConnection.HTTP_OK, new HiveConfigListBuilder()
            .addToItems(createNewHiveConfig("test-list"))
            .build())
        .once();

    // When
    HiveConfigList hiveConfigList = client.hive().hiveConfigs().list();

    // Then
    assertThat(hiveConfigList).isNotNull();
    assertThat(hiveConfigList.getItems()).hasSize(1);
    assertThat(hiveConfigList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/hive.openshift.io/v1/hiveconfigs/hiveconfig1")
        .andReturn(HttpURLConnection.HTTP_OK, createNewHiveConfig("hiveconfig1"))
        .once();

    // When
    boolean isDeleted = client.hive().hiveConfigs().withName("hiveconfig1").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private HiveConfig createNewHiveConfig(String name) {
    return new HiveConfigBuilder()
        .withNewMetadata()
        .withName(name)
        .endMetadata()
        .withNewSpec()
        .addNewManagedDomain()
        .withNewGcp()
        .withNewCredentialsSecretRef("gcp-creds")
        .endGcp()
        .addToDomains("hive.example.com")
        .endManagedDomain()
        .endSpec()
        .build();
  }
}
