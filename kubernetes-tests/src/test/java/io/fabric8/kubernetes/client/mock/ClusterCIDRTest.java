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
package io.fabric8.kubernetes.client.mock;

import io.fabric8.kubernetes.api.model.NodeSelectorBuilder;
import io.fabric8.kubernetes.api.model.NodeSelectorTermBuilder;
import io.fabric8.kubernetes.api.model.networking.v1alpha1.ClusterCIDR;
import io.fabric8.kubernetes.api.model.networking.v1alpha1.ClusterCIDRBuilder;
import io.fabric8.kubernetes.api.model.networking.v1alpha1.ClusterCIDRList;
import io.fabric8.kubernetes.api.model.networking.v1alpha1.ClusterCIDRListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient
class ClusterCIDRTest {
  KubernetesMockServer server;
  KubernetesClient client;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/networking.k8s.io/v1alpha1/clustercidrs/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewClusterCIDR("test-get"))
        .once();

    // When
    ClusterCIDR clusterCIDR = client.network().v1alpha1().clusterCIDRs().withName("test-get").get();

    // Then
    assertThat(clusterCIDR)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/networking.k8s.io/v1alpha1/clustercidrs")
        .andReturn(HttpURLConnection.HTTP_OK, new ClusterCIDRListBuilder()
            .addToItems(createNewClusterCIDR("test-list"))
            .build())
        .once();

    // When
    ClusterCIDRList clusterCIDRList = client.network().v1alpha1().clusterCIDRs().list();

    // Then
    assertThat(clusterCIDRList).isNotNull();
    assertThat(clusterCIDRList.getItems()).hasSize(1);
    assertThat(clusterCIDRList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/networking.k8s.io/v1alpha1/clustercidrs/test-delete")
        .andReturn(HttpURLConnection.HTTP_OK, createNewClusterCIDR("test-delete"))
        .once();

    // When
    boolean isDeleted = client.network().v1alpha1().clusterCIDRs().withName("test-delete").delete()
        .size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private ClusterCIDR createNewClusterCIDR(String name) {
    return new ClusterCIDRBuilder()
        .withNewMetadata()
        .withName(name)
        .endMetadata()
        .withNewSpec()
        .withIpv4("10.0.0.0/8")
        .withIpv6("2001:db8::/64")
        .withPerNodeHostBits(4)
        .withNodeSelector(new NodeSelectorBuilder()
            .withNodeSelectorTerms(Collections.singletonList(new NodeSelectorTermBuilder()
                .addNewMatchField()
                .withKey("metadata.name")
                .withOperator("In")
                .withValues("test-name")
                .endMatchField()
                .addNewMatchExpression()
                .withKey("metadata.name")
                .withOperator("In")
                .withValues("test-name")
                .endMatchExpression()
                .build()))
            .build())
        .endSpec()
        .build();
  }
}
