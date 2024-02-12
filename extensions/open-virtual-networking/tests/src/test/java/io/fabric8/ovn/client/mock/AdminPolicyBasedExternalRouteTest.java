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

import io.fabric8.kubernetes.api.model.ovn.v1.AdminPolicyBasedExternalRoute;
import io.fabric8.kubernetes.api.model.ovn.v1.AdminPolicyBasedExternalRouteBuilder;
import io.fabric8.kubernetes.api.model.ovn.v1.AdminPolicyBasedExternalRouteList;
import io.fabric8.kubernetes.api.model.ovn.v1.AdminPolicyBasedExternalRouteListBuilder;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.ovn.client.OpenVirtualNetworkingClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.util.Collections;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@EnableKubernetesMockClient
class AdminPolicyBasedExternalRouteTest {
  private OpenVirtualNetworkingClient ovnClient;
  private KubernetesMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/k8s.ovn.org/v1/adminpolicybasedexternalroutes/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewAdminPolicyBasedExternalRoute("test-get"))
        .once();

    // When
    AdminPolicyBasedExternalRoute adminPolicyBasedExternalRoute = ovnClient.v1()
        .adminPolicyBasedExternalRoutes().withName("test-get").get();

    // Then
    assertThat(adminPolicyBasedExternalRoute)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/k8s.ovn.org/v1/adminpolicybasedexternalroutes")
        .andReturn(HttpURLConnection.HTTP_OK, new AdminPolicyBasedExternalRouteListBuilder()
            .addToItems(createNewAdminPolicyBasedExternalRoute("test-list"))
            .build())
        .once();

    // When
    AdminPolicyBasedExternalRouteList adminPolicyBasedExternalRouteList = ovnClient.v1()
        .adminPolicyBasedExternalRoutes().list();

    // Then
    assertThat(adminPolicyBasedExternalRouteList).isNotNull();
    assertThat(adminPolicyBasedExternalRouteList.getItems()).hasSize(1);
    assertThat(adminPolicyBasedExternalRouteList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/k8s.ovn.org/v1/adminpolicybasedexternalroutes/test-adminpolicybasedexternalroute")
        .andReturn(HttpURLConnection.HTTP_OK, createNewAdminPolicyBasedExternalRoute("test-adminpolicybasedexternalroute"))
        .once();

    // When
    boolean isDeleted = ovnClient.v1().adminPolicyBasedExternalRoutes()
        .withName("test-adminpolicybasedexternalroute").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private AdminPolicyBasedExternalRoute createNewAdminPolicyBasedExternalRoute(String name) {
    return new AdminPolicyBasedExternalRouteBuilder()
        .withNewMetadata()
        .withName(name)
        .endMetadata()
        .withNewSpec()
        .withNewFrom()
        .withNewNamespaceSelector()
        .withMatchLabels(Collections.singletonMap("multiple_gws", "true"))
        .endNamespaceSelector()
        .endFrom()
        .withNewNextHops()
        .addNewStatic()
        .withIp("172.18.0.2")
        .withBfdEnabled(true)
        .endStatic()
        .addNewDynamic()
        .withBfdEnabled(true)
        .withNewNamespaceSelector()
        .withMatchLabels(Collections.singletonMap("gateway", "true"))
        .endNamespaceSelector()
        .withNewPodSelector()
        .withMatchLabels(Collections.singletonMap("external-gateway", "true"))
        .endPodSelector()
        .endDynamic()
        .endNextHops()
        .endSpec()
        .build();
  }
}
