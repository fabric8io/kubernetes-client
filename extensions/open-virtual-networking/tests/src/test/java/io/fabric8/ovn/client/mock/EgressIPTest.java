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

import io.fabric8.kubernetes.api.model.ovn.v1.EgressIP;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressIPBuilder;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressIPList;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressIPListBuilder;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.ovn.client.OpenVirtualNetworkingClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.util.Collections;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@EnableKubernetesMockClient
class EgressIPTest {
  private OpenVirtualNetworkingClient ovnClient;
  KubernetesMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/k8s.ovn.org/v1/egressips/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewEgressIP("test-get"))
        .once();

    // When
    EgressIP egressIP = ovnClient.v1().egressIps().withName("test-get").get();

    // Then
    assertThat(egressIP)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/k8s.ovn.org/v1/egressips")
        .andReturn(HttpURLConnection.HTTP_OK, new EgressIPListBuilder()
            .addToItems(createNewEgressIP("test-list"))
            .build())
        .once();

    // When
    EgressIPList egressIPList = ovnClient.v1().egressIps().list();

    // Then
    assertThat(egressIPList).isNotNull();
    assertThat(egressIPList.getItems()).hasSize(1);
    assertThat(egressIPList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/k8s.ovn.org/v1/egressips/egressip-prod")
        .andReturn(HttpURLConnection.HTTP_OK, createNewEgressIP("egressip-prod"))
        .once();

    // When
    boolean isDeleted = ovnClient.v1().egressIps().withName("egressip-prod").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private EgressIP createNewEgressIP(String name) {
    return new EgressIPBuilder()
        .withNewMetadata()
        .withName(name)
        .endMetadata()
        .withNewSpec()
        .addToEgressIPs("172.18.0.33", "172.18.0.44")
        .withNewNamespaceSelector()
        .addNewMatchExpression()
        .withKey("environment")
        .withOperator("NotIn")
        .withValues("development")
        .endMatchExpression()
        .endNamespaceSelector()
        .withNewPodSelector()
        .withMatchLabels(Collections.singletonMap("app", "web"))
        .endPodSelector()
        .endSpec()
        .build();
  }
}
