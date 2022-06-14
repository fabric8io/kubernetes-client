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

import io.fabric8.openshift.api.model.config.v1.DNS;
import io.fabric8.openshift.api.model.config.v1.DNSBuilder;
import io.fabric8.openshift.api.model.config.v1.DNSList;
import io.fabric8.openshift.api.model.config.v1.DNSListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class DNSTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/config.openshift.io/v1/dnses/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewDNS("test-get"))
        .once();

    // When
    DNS dns = client.config().dnses().withName("test-get").get();

    // Then
    assertThat(dns)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/config.openshift.io/v1/dnses")
        .andReturn(HttpURLConnection.HTTP_OK, new DNSListBuilder()
            .addToItems(createNewDNS("test-list"))
            .build())
        .once();

    // When
    DNSList dnsList = client.config().dnses().list();

    // Then
    assertThat(dnsList).isNotNull();
    assertThat(dnsList.getItems()).hasSize(1);
    assertThat(dnsList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/config.openshift.io/v1/dnses/cluster")
        .andReturn(HttpURLConnection.HTTP_OK, createNewDNS("cluster"))
        .once();

    // When
    boolean isDeleted = client.config().dnses().withName("cluster").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private DNS createNewDNS(String name) {
    return new DNSBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withBaseDomain("crc.testing")
        .endSpec()
        .build();
  }
}
