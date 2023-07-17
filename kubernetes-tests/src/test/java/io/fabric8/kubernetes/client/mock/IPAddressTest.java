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

import io.fabric8.kubernetes.api.model.networking.v1alpha1.IPAddress;
import io.fabric8.kubernetes.api.model.networking.v1alpha1.IPAddressBuilder;
import io.fabric8.kubernetes.api.model.networking.v1alpha1.IPAddressList;
import io.fabric8.kubernetes.api.model.networking.v1alpha1.IPAddressListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient
class IPAddressTest {
  KubernetesMockServer server;
  KubernetesClient client;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/networking.k8s.io/v1alpha1/ipaddresses/192.168.1.5")
        .andReturn(HttpURLConnection.HTTP_OK, createNewIPAddress())
        .once();

    // When
    IPAddress ipAddress = client.network().v1alpha1().ipAddresses().withName("192.168.1.5").get();

    // Then
    assertThat(ipAddress)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "192.168.1.5");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/networking.k8s.io/v1alpha1/ipaddresses")
        .andReturn(HttpURLConnection.HTTP_OK, new IPAddressListBuilder()
            .addToItems(createNewIPAddress())
            .build())
        .once();

    // When
    IPAddressList ipAddressList = client.network().v1alpha1().ipAddresses().list();

    // Then
    assertThat(ipAddressList).isNotNull();
    assertThat(ipAddressList.getItems()).hasSize(1);
    assertThat(ipAddressList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "192.168.1.5");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/networking.k8s.io/v1alpha1/ipaddresses/192.168.1.5")
        .andReturn(HttpURLConnection.HTTP_OK, createNewIPAddress())
        .once();

    // When
    boolean isDeleted = client.network().v1alpha1().ipAddresses().withName("192.168.1.5").delete()
        .size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private IPAddress createNewIPAddress() {
    return new IPAddressBuilder()
        .withNewMetadata()
        .withName("192.168.1.5")
        .endMetadata()
        .withNewSpec()
        .withNewParentRef()
        .withGroup("apps")
        .withResource("Deployment")
        .withNamespace("default")
        .withName("test-deploy")
        .withUid("95f24228-b0fb-499c-94f0-801a707c6875")
        .endParentRef()
        .endSpec()
        .build();
  }
}
