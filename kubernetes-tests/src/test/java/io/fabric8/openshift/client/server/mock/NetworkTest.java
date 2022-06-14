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

import io.fabric8.openshift.api.model.config.v1.Network;
import io.fabric8.openshift.api.model.config.v1.NetworkBuilder;
import io.fabric8.openshift.api.model.config.v1.NetworkList;
import io.fabric8.openshift.api.model.config.v1.NetworkListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class NetworkTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/config.openshift.io/v1/networks/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewNetwork("test-get"))
        .once();

    // When
    Network network = client.config().networks().withName("test-get").get();

    // Then
    assertThat(network)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/config.openshift.io/v1/networks")
        .andReturn(HttpURLConnection.HTTP_OK, new NetworkListBuilder()
            .addToItems(createNewNetwork("test-list"))
            .build())
        .once();

    // When
    NetworkList networkList = client.config().networks().list();

    // Then
    assertThat(networkList).isNotNull();
    assertThat(networkList.getItems()).hasSize(1);
    assertThat(networkList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/config.openshift.io/v1/networks/cluster")
        .andReturn(HttpURLConnection.HTTP_OK, createNewNetwork("cluster"))
        .once();

    // When
    boolean isDeleted = client.config().networks().withName("cluster").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private Network createNewNetwork(String name) {
    return new NetworkBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .addNewClusterNetwork()
        .withCidr("10.217.0.0/22")
        .withHostPrefix(23)
        .endClusterNetwork()
        .withNewExternalIP().withNewPolicy().endPolicy().endExternalIP()
        .withNetworkType("OpenShiftSDN")
        .withServiceNetwork("10.218.9.3/23")
        .endSpec()
        .build();
  }
}
