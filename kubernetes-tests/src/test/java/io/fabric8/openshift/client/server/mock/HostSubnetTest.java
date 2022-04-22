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

import io.fabric8.openshift.api.model.HostSubnet;
import io.fabric8.openshift.api.model.HostSubnetBuilder;
import io.fabric8.openshift.api.model.HostSubnetList;
import io.fabric8.openshift.api.model.HostSubnetListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class HostSubnetTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/network.openshift.io/v1/hostsubnets/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewHostSubnet("test-get"))
        .once();

    // When
    HostSubnet hostSubnet = client.hostSubnets().withName("test-get").get();

    // Then
    assertThat(hostSubnet)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/network.openshift.io/v1/hostsubnets")
        .andReturn(HttpURLConnection.HTTP_OK, new HostSubnetListBuilder()
            .addToItems(createNewHostSubnet("test-list"))
            .build())
        .once();

    // When
    HostSubnetList hostSubnetList = client.hostSubnets().list();

    // Then
    assertThat(hostSubnetList).isNotNull();
    assertThat(hostSubnetList.getItems()).hasSize(1);
    assertThat(hostSubnetList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/network.openshift.io/v1/hostsubnets/test-delete")
        .andReturn(HttpURLConnection.HTTP_OK, createNewHostSubnet("test-delete"))
        .once();

    // When
    boolean isDeleted = client.hostSubnets().withName("test-delete").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private HostSubnet createNewHostSubnet(String name) {
    return new HostSubnetBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withHost("crc-rsppg-master-0")
        .withHostIP("192.168.126.11")
        .withKind("HostSubnet")
        .withSubnet("10.217.0.0/23")
        .build();
  }
}
