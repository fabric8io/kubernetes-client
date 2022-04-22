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

import io.fabric8.openshift.api.model.operator.controlplane.v1alpha1.PodNetworkConnectivityCheck;
import io.fabric8.openshift.api.model.operator.controlplane.v1alpha1.PodNetworkConnectivityCheckBuilder;
import io.fabric8.openshift.api.model.operator.controlplane.v1alpha1.PodNetworkConnectivityCheckList;
import io.fabric8.openshift.api.model.operator.controlplane.v1alpha1.PodNetworkConnectivityCheckListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class PodNetworkConnectivityCheckTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get()
        .withPath("/apis/controlplane.operator.openshift.io/v1alpha1/namespaces/ns1/podnetworkconnectivitychecks/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewPodNetworkConnectivityCheck("test-get"))
        .once();

    // When
    PodNetworkConnectivityCheck podNetworkConnectivityCheck = client.operator().podNetworkConnectivityChecks()
        .inNamespace("ns1").withName("test-get").get();

    // Then
    assertThat(podNetworkConnectivityCheck)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get()
        .withPath("/apis/controlplane.operator.openshift.io/v1alpha1/namespaces/ns1/podnetworkconnectivitychecks")
        .andReturn(HttpURLConnection.HTTP_OK, new PodNetworkConnectivityCheckListBuilder()
            .addToItems(createNewPodNetworkConnectivityCheck("test-list"))
            .build())
        .once();

    // When
    PodNetworkConnectivityCheckList podNetworkConnectivityCheckList = client.operator().podNetworkConnectivityChecks()
        .inNamespace("ns1").list();

    // Then
    assertThat(podNetworkConnectivityCheckList).isNotNull();
    assertThat(podNetworkConnectivityCheckList.getItems()).hasSize(1);
    assertThat(podNetworkConnectivityCheckList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete()
        .withPath("/apis/controlplane.operator.openshift.io/v1alpha1/namespaces/ns1/podnetworkconnectivitychecks/cluster")
        .andReturn(HttpURLConnection.HTTP_OK, createNewPodNetworkConnectivityCheck("cluster"))
        .once();

    // When
    boolean isDeleted = client.operator().podNetworkConnectivityChecks().inNamespace("ns1").withName("cluster").delete()
        .size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private PodNetworkConnectivityCheck createNewPodNetworkConnectivityCheck(String name) {
    return new PodNetworkConnectivityCheckBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withSourcePod("network-check-source-596b4c6566-rgh92")
        .withTargetEndpoint("api.crc.testing:6443")
        .endSpec()
        .build();
  }
}
