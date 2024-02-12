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

import io.fabric8.kubernetes.api.model.ovn.v1.EgressQoS;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressQoSBuilder;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressQoSList;
import io.fabric8.kubernetes.api.model.ovn.v1.EgressQoSListBuilder;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.ovn.client.OpenVirtualNetworkingClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.util.Collections;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@EnableKubernetesMockClient
class EgressQoSTest {
  private OpenVirtualNetworkingClient ovnClient;
  private KubernetesMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/k8s.ovn.org/v1/namespaces/default/egressqoses/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewEgressQoS("test-get"))
        .once();

    // When
    EgressQoS egressQoS = ovnClient.v1().egressQoses().inNamespace("default").withName("test-get").get();

    // Then
    assertThat(egressQoS)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/k8s.ovn.org/v1/namespaces/default/egressqoses")
        .andReturn(HttpURLConnection.HTTP_OK, new EgressQoSListBuilder()
            .addToItems(createNewEgressQoS("test-list"))
            .build())
        .once();

    // When
    EgressQoSList egressQoSList = ovnClient.v1().egressQoses().inNamespace("default").list();

    // Then
    assertThat(egressQoSList).isNotNull();
    assertThat(egressQoSList.getItems()).hasSize(1);
    assertThat(egressQoSList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/k8s.ovn.org/v1/namespaces/default/egressqoses/default")
        .andReturn(HttpURLConnection.HTTP_OK, createNewEgressQoS("default"))
        .once();

    // When
    boolean isDeleted = ovnClient.v1().egressQoses().inNamespace("default").withName("default").delete()
        .size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private EgressQoS createNewEgressQoS(String name) {
    return new EgressQoSBuilder()
        .withNewMetadata()
        .withName(name)
        .endMetadata()
        .withNewSpec()
        .addNewEgress()
        .withDscp(48)
        .withNewPodSelector()
        .withMatchLabels(Collections.singletonMap("app", "updated-example"))
        .endPodSelector()
        .endEgress()
        .addNewEgress()
        .withDscp(28)
        .endEgress()
        .endSpec()
        .build();
  }
}
