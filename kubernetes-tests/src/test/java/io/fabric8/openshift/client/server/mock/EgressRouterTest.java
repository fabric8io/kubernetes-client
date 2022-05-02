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

import io.fabric8.openshift.api.model.miscellaneous.network.operator.v1.EgressRouter;
import io.fabric8.openshift.api.model.miscellaneous.network.operator.v1.EgressRouterBuilder;
import io.fabric8.openshift.api.model.miscellaneous.network.operator.v1.EgressRouterList;
import io.fabric8.openshift.api.model.miscellaneous.network.operator.v1.EgressRouterListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class EgressRouterTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/network.operator.openshift.io/v1/namespaces/ns1/egressrouters/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewEgressRouter("test-get"))
        .once();

    // When
    EgressRouter egressRouter = client.egressRouters().inNamespace("ns1").withName("test-get").get();

    // Then
    assertThat(egressRouter)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/network.operator.openshift.io/v1/namespaces/ns1/egressrouters")
        .andReturn(HttpURLConnection.HTTP_OK, new EgressRouterListBuilder()
            .addToItems(createNewEgressRouter("test-list"))
            .build())
        .once();

    // When
    EgressRouterList ipPoolList = client.egressRouters().inNamespace("ns1").list();

    // Then
    assertThat(ipPoolList).isNotNull();
    assertThat(ipPoolList.getItems()).hasSize(1);
    assertThat(ipPoolList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/network.operator.openshift.io/v1/namespaces/ns1/egressrouters/egressrouter1")
        .andReturn(HttpURLConnection.HTTP_OK, createNewEgressRouter("egressrouter1"))
        .once();

    // When
    boolean isDeleted = client.egressRouters().inNamespace("ns1").withName("egressrouter1").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private EgressRouter createNewEgressRouter(String name) {
    return new EgressRouterBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .addNewAddress()
        .withGateway("192.168.3.1")
        .withIp("192.168.3.10/24")
        .endAddress()
        .withMode("Redirect")
        .withNewNetworkInterface()
        .withNewMacvlan()
        .withMode("Bridge")
        .endMacvlan()
        .endNetworkInterface()
        .withNewRedirect()
        .withFallbackIP("203.0.113.25")
        .endRedirect()
        .endSpec()
        .build();
  }
}
