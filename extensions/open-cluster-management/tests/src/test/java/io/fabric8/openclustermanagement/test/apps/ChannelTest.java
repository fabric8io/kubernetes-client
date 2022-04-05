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
import io.fabric8.openclustermanagement.api.model.multicloudoperatorschannel.apps.v1.Channel;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorschannel.apps.v1.ChannelBuilder;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorschannel.apps.v1.ChannelList;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorschannel.apps.v1.ChannelListBuilder;
import io.fabric8.openclustermanagement.client.OpenClusterManagementClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient
class ChannelTest {
  private OpenClusterManagementClient client;
  private KubernetesMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/apps.open-cluster-management.io/v1/namespaces/ns1/channels/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewChannel("test-get"))
        .once();

    // When
    Channel channel = client.apps().channels().inNamespace("ns1").withName("test-get").get();

    // Then
    assertThat(channel)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/apps.open-cluster-management.io/v1/namespaces/ns1/channels")
        .andReturn(HttpURLConnection.HTTP_OK, new ChannelListBuilder()
            .addToItems(createNewChannel("test-list"))
            .build())
        .once();

    // When
    ChannelList channelList = client.apps().channels().inNamespace("ns1").list();

    // Then
    assertThat(channelList).isNotNull();
    assertThat(channelList.getItems()).hasSize(1);
    assertThat(channelList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/apps.open-cluster-management.io/v1/namespaces/ns1/channels/sample-channel")
        .andReturn(HttpURLConnection.HTTP_OK, createNewChannel("sample-channel"))
        .once();

    // When
    boolean isDeleted = client.apps().channels().inNamespace("ns1").withName("sample-channel").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private Channel createNewChannel(String name) {
    return new ChannelBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withNewConfigMapRef()
        .withKind("configmap")
        .withName("bookinfo-resource-filter-configmap")
        .endConfigMapRef()
        .withPathname("https://charts.helm.sh/stable")
        .withType("HelmRepo")
        .endSpec()
        .build();
  }
}
