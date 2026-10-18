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

import io.fabric8.kubernetes.api.model.ovn.v1.RouteAdvertisements;
import io.fabric8.kubernetes.api.model.ovn.v1.RouteAdvertisementsBuilder;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.ovn.client.OpenVirtualNetworkingClient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient(https = false, crud = true)
class RouteAdvertisementsTest {
  private OpenVirtualNetworkingClient ovnClient;
  KubernetesMockServer server;

  @Test
  @DisplayName("create sends the RouteAdvertisements to the cluster-scoped routeadvertisements endpoint")
  void create() throws InterruptedException {
    RouteAdvertisements created = ovnClient.v1().routeAdvertisements().resource(newRouteAdvertisements("default")).create();

    assertThat(created).hasFieldOrPropertyWithValue("metadata.name", "default");
    assertThat(server.getLastRequest().getPath()).isEqualTo("/apis/k8s.ovn.org/v1/routeadvertisements");
  }

  @Test
  @DisplayName("get returns the RouteAdvertisements with its network selectors and advertisements")
  void get() {
    ovnClient.v1().routeAdvertisements().resource(newRouteAdvertisements("test-get")).create();

    RouteAdvertisements routeAdvertisements = ovnClient.v1().routeAdvertisements().withName("test-get").get();

    assertThat(routeAdvertisements.getSpec().getAdvertisements()).containsExactly("PodNetwork");
    assertThat(routeAdvertisements.getSpec().getNetworkSelectors())
        .singleElement()
        .hasFieldOrPropertyWithValue("networkSelectionType", "DefaultNetwork");
  }

  @Test
  @DisplayName("list returns the created RouteAdvertisements")
  void list() {
    ovnClient.v1().routeAdvertisements().resource(newRouteAdvertisements("test-list")).create();

    assertThat(ovnClient.v1().routeAdvertisements().list().getItems())
        .singleElement()
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  @DisplayName("delete removes the RouteAdvertisements")
  void delete() {
    ovnClient.v1().routeAdvertisements().resource(newRouteAdvertisements("test-delete")).create();

    assertThat(ovnClient.v1().routeAdvertisements().withName("test-delete").delete()).hasSize(1);
    assertThat(ovnClient.v1().routeAdvertisements().withName("test-delete").get()).isNull();
  }

  private static RouteAdvertisements newRouteAdvertisements(String name) {
    return new RouteAdvertisementsBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .addToAdvertisements("PodNetwork")
        .addNewNetworkSelector().withNetworkSelectionType("DefaultNetwork").endNetworkSelector()
        .endSpec()
        .build();
  }
}
