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

import io.fabric8.openshift.api.model.operator.v1.Config;
import io.fabric8.openshift.api.model.operator.v1.ConfigBuilder;
import io.fabric8.openshift.api.model.operator.v1.ConfigList;
import io.fabric8.openshift.api.model.operator.v1.ConfigListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class ConfigTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/operator.openshift.io/v1/configs/test-get")
      .andReturn(HttpURLConnection.HTTP_OK, createNewConfig("test-get"))
      .once();

    // When
    Config config = client.operator().configs().withName("test-get").get();

    // Then
    assertThat(config)
      .isNotNull()
      .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/operator.openshift.io/v1/configs")
      .andReturn(HttpURLConnection.HTTP_OK, new ConfigListBuilder()
        .addToItems(createNewConfig("test-list"))
        .build())
      .once();

    // When
    ConfigList configList = client.operator().configs().list();

    // Then
    assertThat(configList).isNotNull();
    assertThat(configList.getItems()).hasSize(1);
    assertThat(configList.getItems().get(0))
      .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/operator.openshift.io/v1/configs/cluster")
      .andReturn(HttpURLConnection.HTTP_OK, createNewConfig("cluster"))
      .once();

    // When
    Boolean isDeleted = client.operator().configs().withName("cluster").delete();

    // Then
    assertThat(isDeleted).isTrue();
  }

  private Config createNewConfig(String name) {
    return new ConfigBuilder()
      .withNewMetadata().withName(name).endMetadata()
      .withNewSpec()
      .withLogLevel("Normal")
      .withOperatorLogLevel("Normal")
      .endSpec()
      .build();
  }
}

