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

import io.fabric8.kubernetes.api.model.ovn.v1.ClusterNetworkConnect;
import io.fabric8.kubernetes.api.model.ovn.v1.ClusterNetworkConnectBuilder;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.ovn.client.OpenVirtualNetworkingClient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient(https = false, crud = true)
class ClusterNetworkConnectTest {
  private OpenVirtualNetworkingClient ovnClient;
  KubernetesMockServer server;

  @Test
  @DisplayName("create sends the ClusterNetworkConnect to the cluster-scoped clusternetworkconnects endpoint")
  void create() throws InterruptedException {
    ClusterNetworkConnect created = ovnClient.v1().clusterNetworkConnects().resource(newClusterNetworkConnect("connect"))
        .create();

    assertThat(created).hasFieldOrPropertyWithValue("metadata.name", "connect");
    assertThat(server.getLastRequest().getPath()).isEqualTo("/apis/k8s.ovn.org/v1/clusternetworkconnects");
  }

  @Test
  @DisplayName("get returns the ClusterNetworkConnect with its connect subnets, connectivity and network selectors")
  void get() {
    ovnClient.v1().clusterNetworkConnects().resource(newClusterNetworkConnect("test-get")).create();

    ClusterNetworkConnect clusterNetworkConnect = ovnClient.v1().clusterNetworkConnects().withName("test-get").get();

    assertThat(clusterNetworkConnect.getSpec().getConnectSubnets())
        .singleElement()
        .hasFieldOrPropertyWithValue("cidr", "192.168.0.0/16")
        .hasFieldOrPropertyWithValue("networkPrefix", 24);
    assertThat(clusterNetworkConnect.getSpec().getConnectivity()).containsExactly("PodNetwork");
    assertThat(clusterNetworkConnect.getSpec().getNetworkSelectors())
        .singleElement()
        .hasFieldOrPropertyWithValue("networkSelectionType", "ClusterUserDefinedNetworks")
        .hasFieldOrPropertyWithValue("clusterUserDefinedNetworkSelector.networkSelector.matchLabels",
            Collections.singletonMap("connect", "true"));
  }

  @Test
  @DisplayName("list returns the created ClusterNetworkConnect")
  void list() {
    ovnClient.v1().clusterNetworkConnects().resource(newClusterNetworkConnect("test-list")).create();

    assertThat(ovnClient.v1().clusterNetworkConnects().list().getItems())
        .singleElement()
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  @DisplayName("delete removes the ClusterNetworkConnect")
  void delete() {
    ovnClient.v1().clusterNetworkConnects().resource(newClusterNetworkConnect("test-delete")).create();

    assertThat(ovnClient.v1().clusterNetworkConnects().withName("test-delete").delete()).hasSize(1);
    assertThat(ovnClient.v1().clusterNetworkConnects().withName("test-delete").get()).isNull();
  }

  private static ClusterNetworkConnect newClusterNetworkConnect(String name) {
    return new ClusterNetworkConnectBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .addNewConnectSubnet().withCidr("192.168.0.0/16").withNetworkPrefix(24).endConnectSubnet()
        .addToConnectivity("PodNetwork")
        .addNewNetworkSelector()
        .withNetworkSelectionType("ClusterUserDefinedNetworks")
        .withNewClusterUserDefinedNetworkSelector()
        .withNewNetworkSelector().addToMatchLabels("connect", "true").endNetworkSelector()
        .endClusterUserDefinedNetworkSelector()
        .endNetworkSelector()
        .endSpec()
        .build();
  }
}
