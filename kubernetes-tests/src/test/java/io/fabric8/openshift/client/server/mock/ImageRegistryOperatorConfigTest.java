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

import io.fabric8.kubernetes.api.model.Duration;
import io.fabric8.openshift.api.model.miscellaneous.imageregistry.operator.v1.Config;
import io.fabric8.openshift.api.model.miscellaneous.imageregistry.operator.v1.ConfigBuilder;
import io.fabric8.openshift.api.model.miscellaneous.imageregistry.operator.v1.ConfigList;
import io.fabric8.openshift.api.model.miscellaneous.imageregistry.operator.v1.ConfigListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.text.ParseException;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class ImageRegistryOperatorConfigTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() throws ParseException {
    // Given
    server.expect().get().withPath("/apis/imageregistry.operator.openshift.io/v1/configs/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewConfig("test-get"))
        .once();

    // When
    Config Config = client.imageRegistryOperatorConfigs().withName("test-get").get();

    // Then
    assertThat(Config)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() throws ParseException {
    // Given
    server.expect().get().withPath("/apis/imageregistry.operator.openshift.io/v1/configs")
        .andReturn(HttpURLConnection.HTTP_OK, new ConfigListBuilder()
            .addToItems(createNewConfig("test-list"))
            .build())
        .once();

    // When
    ConfigList ConfigList = client.imageRegistryOperatorConfigs().list();

    // Then
    assertThat(ConfigList).isNotNull();
    assertThat(ConfigList.getItems()).hasSize(1);
    assertThat(ConfigList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() throws ParseException {
    // Given
    server.expect().delete().withPath("/apis/imageregistry.operator.openshift.io/v1/configs/cluster")
        .andReturn(HttpURLConnection.HTTP_OK, createNewConfig("cluster"))
        .once();

    // When
    boolean isDeleted = client.imageRegistryOperatorConfigs().withName("cluster").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private Config createNewConfig(String name) throws ParseException {
    return new ConfigBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withDefaultRoute(true)
        .withHttpSecret("secret")
        .withLogLevel("Normal")
        .withManagementState("Managed")
        .withOperatorLogLevel("Normal")
        .withReplicas(1)
        .withNewRequests()
        .withNewRead()
        .withMaxWaitInQueue(Duration.parse("0s"))
        .endRead()
        .withNewWrite()
        .withMaxWaitInQueue(Duration.parse("0s"))
        .endWrite()
        .endRequests()
        .withRolloutStrategy("RollingUpdate")
        .withNewStorage()
        .withManagementState("Managed")
        .withNewPvc()
        .withClaim("crc-image-registry-storage")
        .endPvc()
        .endStorage()
        .endSpec()
        .build();
  }
}
