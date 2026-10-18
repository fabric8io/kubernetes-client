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

import io.fabric8.kubernetes.api.model.ovn.v1.VTEP;
import io.fabric8.kubernetes.api.model.ovn.v1.VTEPBuilder;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.ovn.client.OpenVirtualNetworkingClient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient(https = false, crud = true)
class VTEPTest {
  private OpenVirtualNetworkingClient ovnClient;
  KubernetesMockServer server;

  @Test
  @DisplayName("create sends the VTEP to the cluster-scoped vteps endpoint")
  void create() throws InterruptedException {
    VTEP created = ovnClient.v1().vteps().resource(newVTEP("evpn")).create();

    assertThat(created).hasFieldOrPropertyWithValue("metadata.name", "evpn");
    assertThat(server.getLastRequest().getPath()).isEqualTo("/apis/k8s.ovn.org/v1/vteps");
  }

  @Test
  @DisplayName("get returns the VTEP with its CIDRs and mode")
  void get() {
    ovnClient.v1().vteps().resource(newVTEP("test-get")).create();

    VTEP vtep = ovnClient.v1().vteps().withName("test-get").get();

    assertThat(vtep.getSpec().getCidrs()).containsExactly("100.64.0.0/24");
    assertThat(vtep.getSpec().getMode()).isEqualTo("Managed");
  }

  @Test
  @DisplayName("list returns the created VTEP")
  void list() {
    ovnClient.v1().vteps().resource(newVTEP("test-list")).create();

    assertThat(ovnClient.v1().vteps().list().getItems())
        .singleElement()
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  @DisplayName("delete removes the VTEP")
  void delete() {
    ovnClient.v1().vteps().resource(newVTEP("test-delete")).create();

    assertThat(ovnClient.v1().vteps().withName("test-delete").delete()).hasSize(1);
    assertThat(ovnClient.v1().vteps().withName("test-delete").get()).isNull();
  }

  private static VTEP newVTEP(String name) {
    return new VTEPBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .addToCidrs("100.64.0.0/24")
        .withMode("Managed")
        .endSpec()
        .build();
  }
}
