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

import io.fabric8.kubernetes.api.model.ovn.v1.ClusterUserDefinedNetwork;
import io.fabric8.kubernetes.api.model.ovn.v1.ClusterUserDefinedNetworkBuilder;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.ovn.client.OpenVirtualNetworkingClient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient(https = false, crud = true)
class ClusterUserDefinedNetworkTest {
  private OpenVirtualNetworkingClient ovnClient;
  KubernetesMockServer server;

  @Test
  @DisplayName("create sends the ClusterUserDefinedNetwork to the cluster-scoped clusteruserdefinednetworks endpoint")
  void create() throws InterruptedException {
    ClusterUserDefinedNetwork created = ovnClient.v1().clusterUserDefinedNetworks()
        .resource(newClusterUserDefinedNetwork("blue")).create();

    assertThat(created).hasFieldOrPropertyWithValue("metadata.name", "blue");
    assertThat(server.getLastRequest().getPath()).isEqualTo("/apis/k8s.ovn.org/v1/clusteruserdefinednetworks");
  }

  @Test
  @DisplayName("get returns the ClusterUserDefinedNetwork with its namespace selector and Layer2 network")
  void get() {
    ovnClient.v1().clusterUserDefinedNetworks().resource(newClusterUserDefinedNetwork("test-get")).create();

    ClusterUserDefinedNetwork cudn = ovnClient.v1().clusterUserDefinedNetworks().withName("test-get").get();

    assertThat(cudn.getSpec().getNamespaceSelector().getMatchLabels()).containsEntry("network", "blue");
    assertThat(cudn.getSpec().getNetwork())
        .hasFieldOrPropertyWithValue("topology", "Layer2")
        .hasFieldOrPropertyWithValue("layer2.role", "Secondary")
        .hasFieldOrPropertyWithValue("layer2.ipam.lifecycle", "Persistent");
    assertThat(cudn.getSpec().getNetwork().getLayer2().getSubnets()).containsExactly("10.100.0.0/16");
  }

  @Test
  @DisplayName("list returns the created ClusterUserDefinedNetwork")
  void list() {
    ovnClient.v1().clusterUserDefinedNetworks().resource(newClusterUserDefinedNetwork("test-list")).create();

    assertThat(ovnClient.v1().clusterUserDefinedNetworks().list().getItems())
        .singleElement()
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  @DisplayName("delete removes the ClusterUserDefinedNetwork")
  void delete() {
    ovnClient.v1().clusterUserDefinedNetworks().resource(newClusterUserDefinedNetwork("test-delete")).create();

    assertThat(ovnClient.v1().clusterUserDefinedNetworks().withName("test-delete").delete()).hasSize(1);
    assertThat(ovnClient.v1().clusterUserDefinedNetworks().withName("test-delete").get()).isNull();
  }

  private static ClusterUserDefinedNetwork newClusterUserDefinedNetwork(String name) {
    return new ClusterUserDefinedNetworkBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withNewNamespaceSelector().addToMatchLabels("network", "blue").endNamespaceSelector()
        .withNewNetwork()
        .withTopology("Layer2")
        .withNewLayer2()
        .withRole("Secondary")
        .addToSubnets("10.100.0.0/16")
        .withNewIpam().withLifecycle("Persistent").endIpam()
        .endLayer2()
        .endNetwork()
        .endSpec()
        .build();
  }
}
