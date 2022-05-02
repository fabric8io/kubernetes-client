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

import io.fabric8.openshift.api.model.hive.v1.DNSZone;
import io.fabric8.openshift.api.model.hive.v1.DNSZoneBuilder;
import io.fabric8.openshift.api.model.hive.v1.DNSZoneList;
import io.fabric8.openshift.api.model.hive.v1.DNSZoneListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import io.fabric8.openshift.client.server.mock.EnableOpenShiftMockClient;
import io.fabric8.openshift.client.server.mock.OpenShiftMockServer;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class DNSZoneTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/hive.openshift.io/v1/namespaces/ns1/dnszones/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewDNSZone("test-get"))
        .once();

    // When
    DNSZone dnsZone = client.hive().dnsZones().inNamespace("ns1").withName("test-get").get();

    // Then
    assertThat(dnsZone)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/hive.openshift.io/v1/namespaces/ns1/dnszones")
        .andReturn(HttpURLConnection.HTTP_OK, new DNSZoneListBuilder()
            .addToItems(createNewDNSZone("test-list"))
            .build())
        .once();

    // When
    DNSZoneList dnsZoneList = client.hive().dnsZones().inNamespace("ns1").list();

    // Then
    assertThat(dnsZoneList).isNotNull();
    assertThat(dnsZoneList.getItems()).hasSize(1);
    assertThat(dnsZoneList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/hive.openshift.io/v1/namespaces/ns1/dnszones/dnszone1")
        .andReturn(HttpURLConnection.HTTP_OK, createNewDNSZone("dnszone1"))
        .once();

    // When
    boolean isDeleted = client.hive().dnsZones().inNamespace("ns1").withName("dnszone1").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private DNSZone createNewDNSZone(String name) {
    return new DNSZoneBuilder()
        .withNewMetadata()
        .withName(name)
        .endMetadata()
        .withNewSpec()
        .withPreserveOnDelete(false)
        .withZone("testzone.testdomain.com")
        .withNewAws()
        .withNewCredentialsSecretRef().withName("route53-creds-secret").endCredentialsSecretRef()
        .endAws()
        .endSpec()
        .build();
  }
}
