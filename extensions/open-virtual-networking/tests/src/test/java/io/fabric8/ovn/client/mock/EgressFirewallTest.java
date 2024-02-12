/*
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
package io.fabric8.ovn.client.mock;

import io.fabric8.kubernetes.api.model.ovn.v1.EgressFirewall;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressFirewallBuilder;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressFirewallList;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressFirewallListBuilder;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.ovn.client.OpenVirtualNetworkingClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@EnableKubernetesMockClient
class EgressFirewallTest {
  private OpenVirtualNetworkingClient ovnClient;
  private KubernetesMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/k8s.ovn.org/v1/namespaces/default/egressfirewalls/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewEgressFirewall("test-get"))
        .once();

    // When
    EgressFirewall egressFirewall = ovnClient.v1().egressFirewalls().inNamespace("default")
        .withName("test-get").get();

    // Then
    assertThat(egressFirewall)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/k8s.ovn.org/v1/namespaces/default/egressfirewalls")
        .andReturn(HttpURLConnection.HTTP_OK, new EgressFirewallListBuilder()
            .addToItems(createNewEgressFirewall("test-list"))
            .build())
        .once();

    // When
    EgressFirewallList egressFirewallList = ovnClient.v1().egressFirewalls().inNamespace("default").list();

    // Then
    assertThat(egressFirewallList).isNotNull();
    assertThat(egressFirewallList.getItems()).hasSize(1);
    assertThat(egressFirewallList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/k8s.ovn.org/v1/namespaces/default/egressfirewalls/default")
        .andReturn(HttpURLConnection.HTTP_OK, createNewEgressFirewall("default"))
        .once();

    // When
    boolean isDeleted = ovnClient.v1().egressFirewalls().inNamespace("default").withName("default")
        .delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private EgressFirewall createNewEgressFirewall(String name) {
    return new EgressFirewallBuilder()
        .withNewMetadata()
        .withName(name)
        .endMetadata()
        .withNewSpec()
        .addNewEgress()
        .withType("Allow")
        .withNewTo()
        .withDnsName("www.openvswitch.org")
        .endTo()
        .endEgress()
        .addNewEgress()
        .withType("Allow")
        .withNewTo()
        .withCidrSelector("1.2.3.0/24")
        .endTo()
        .addNewPort()
        .withProtocol("UDP")
        .withPort(55)
        .endPort()
        .endEgress()
        .addNewEgress()
        .withType("Deny")
        .withNewTo()
        .withCidrSelector("0.0.0.0/0")
        .endTo()
        .endEgress()
        .endSpec()
        .build();
  }
}
