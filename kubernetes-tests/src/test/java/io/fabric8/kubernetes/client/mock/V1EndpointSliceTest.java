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

import io.fabric8.kubernetes.api.model.discovery.v1.EndpointSlice;
import io.fabric8.kubernetes.api.model.discovery.v1.EndpointSliceBuilder;
import io.fabric8.kubernetes.api.model.discovery.v1.EndpointSliceList;
import io.fabric8.kubernetes.api.model.discovery.v1.EndpointSliceListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient
class V1EndpointSliceTest {
  private KubernetesMockServer server;
  private KubernetesClient client;

  @Test
  void load() {
    // Given + When
    EndpointSlice es = client.discovery().v1().endpointSlices().load(getClass().getResourceAsStream("/v1-endpointslice.yml"))
        .item();

    // Than
    assertThat(es).isNotNull();
    assertThat(es.getMetadata().getName()).isEqualTo("example-abc");
    assertThat(es.getAddressType()).isEqualTo("IPv4");
    assertThat(es.getPorts()).hasSize(1);
    assertThat(es.getEndpoints()).hasSize(1);
  }

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/discovery.k8s.io/v1/namespaces/default/endpointslices/test-es")
        .andReturn(HttpURLConnection.HTTP_OK, getEndpointSlice("test-es"))
        .once();

    // When
    EndpointSlice es = client.discovery().v1().endpointSlices().inNamespace("default").withName("test-es").get();

    // Then
    assertThat(es).isNotNull();
    assertThat(es.getMetadata().getName()).isEqualTo("test-es");
  }

  @Test
  void listInSingleNamespace() {
    // Given
    server.expect().get().withPath("/apis/discovery.k8s.io/v1/namespaces/default/endpointslices")
        .andReturn(HttpURLConnection.HTTP_OK, new EndpointSliceListBuilder()
            .addToItems(getEndpointSlice("test-es"))
            .build())
        .once();

    // When
    EndpointSliceList esList = client.discovery().v1().endpointSlices().inNamespace("default").list();

    // Then
    assertThat(esList).isNotNull();
    assertThat(esList.getItems()).hasSize(1);
  }

  @Test
  void listAllNamespaces() {
    // Given
    server.expect().get().withPath("/apis/discovery.k8s.io/v1/endpointslices")
        .andReturn(HttpURLConnection.HTTP_OK, new EndpointSliceListBuilder()
            .addToItems(getEndpointSlice("test-es"))
            .build())
        .once();

    // When
    EndpointSliceList esList = client.discovery().v1().endpointSlices().inAnyNamespace().list();

    // Then
    assertThat(esList).isNotNull();
    assertThat(esList.getItems()).hasSize(1);
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/discovery.k8s.io/v1/namespaces/default/endpointslices/test-es")
        .andReturn(HttpURLConnection.HTTP_OK, getEndpointSlice("test-es"))
        .once();

    // When
    boolean isDeleted = client.discovery().v1().endpointSlices().inNamespace("default").withName("test-es").delete()
        .size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  @Test
  void create() {
    // Given
    EndpointSlice endpointSlice = getEndpointSlice("example-abc");
    server.expect().post().withPath("/apis/discovery.k8s.io/v1/namespaces/ns1/endpointslices")
        .andReturn(HttpURLConnection.HTTP_OK, endpointSlice)
        .once();

    // When
    EndpointSlice endpointSliceCreated = client.discovery().v1().endpointSlices().inNamespace("ns1")
        .createOrReplace(endpointSlice);

    // Then
    assertThat(endpointSliceCreated).isNotNull();
    assertThat(endpointSliceCreated.getMetadata().getName()).isEqualTo("example-abc");
    assertThat(endpointSliceCreated.getApiVersion()).isEqualTo("discovery.k8s.io/v1");
    assertThat(endpointSliceCreated.getMetadata().getLabels()).containsEntry("kubernetes.io/service-name", "example");
    assertThat(endpointSliceCreated.getAddressType()).isEqualTo("IPv4");
    assertThat(endpointSliceCreated.getPorts()).hasSize(1);
    assertThat(endpointSliceCreated.getEndpoints()).hasSize(1);
    assertThat(endpointSliceCreated.getEndpoints().get(0).getHostname()).isEqualTo("pod-1");
  }

  private EndpointSlice getEndpointSlice(String name) {
    return new EndpointSliceBuilder()
        .withNewMetadata()
        .withName(name)
        .addToLabels("kubernetes.io/service-name", "example")
        .endMetadata()
        .withAddressType("IPv4")
        .addNewPort()
        .withName("http")
        .withPort(80)
        .endPort()
        .addNewEndpoint()
        .withAddresses("10.1.2.3")
        .withNewConditions().withReady(true).endConditions()
        .withHostname("pod-1")
        .endEndpoint()
        .build();
  }
}
