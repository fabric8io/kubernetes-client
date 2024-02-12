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

import io.fabric8.kubernetes.api.model.ovn.v1.EgressService;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressServiceBuilder;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressServiceList;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressServiceListBuilder;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.ovn.client.OpenVirtualNetworkingClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.util.Collections;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@EnableKubernetesMockClient
class EgressServiceTest {
  private OpenVirtualNetworkingClient ovnClient;
  private KubernetesMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/k8s.ovn.org/v1/namespaces/default/egressservices/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewEgressService("test-get"))
        .once();

    // When
    EgressService egressService = ovnClient.v1().egressServices().inNamespace("default")
        .withName("test-get").get();

    // Then
    assertThat(egressService)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/k8s.ovn.org/v1/namespaces/default/egressservices")
        .andReturn(HttpURLConnection.HTTP_OK, new EgressServiceListBuilder()
            .addToItems(createNewEgressService("test-list"))
            .build())
        .once();

    // When
    EgressServiceList egressServiceList = ovnClient.v1().egressServices().inNamespace("default").list();

    // Then
    assertThat(egressServiceList).isNotNull();
    assertThat(egressServiceList.getItems()).hasSize(1);
    assertThat(egressServiceList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/k8s.ovn.org/v1/namespaces/default/egressservices/default")
        .andReturn(HttpURLConnection.HTTP_OK, createNewEgressService("default"))
        .once();

    // When
    boolean isDeleted = ovnClient.v1().egressServices().inNamespace("default").withName("default").delete()
        .size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private EgressService createNewEgressService(String name) {
    return new EgressServiceBuilder()
        .withNewMetadata()
        .withName(name)
        .endMetadata()
        .withNewSpec()
        .withSourceIPBy("LoadBalancerIP")
        .withNewNodeSelector()
        .withMatchLabels(Collections.singletonMap("node-role.kubernetes.io/worker", ""))
        .endNodeSelector()
        .endSpec()
        .build();
  }
}
