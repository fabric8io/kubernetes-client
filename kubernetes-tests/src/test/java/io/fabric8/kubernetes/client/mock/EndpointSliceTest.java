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

import io.fabric8.kubernetes.api.model.discovery.EndpointSlice;
import io.fabric8.kubernetes.api.model.discovery.EndpointSliceBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesServer;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;

import java.net.HttpURLConnection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@EnableRuleMigrationSupport
class EndpointSliceTest {
  @Rule
  public KubernetesServer server = new KubernetesServer();

  private KubernetesClient client;

  @BeforeEach
  void init() {
    this.client = server.getClient();
  }

  @Test
  void resourceCreate() {
    // Given
    EndpointSlice endpointSlice = getEndpointSlice();
    server.expect().post().withPath("/apis/discovery.k8s.io/v1beta1/namespaces/ns1/endpointslices")
      .andReturn(HttpURLConnection.HTTP_OK, endpointSlice)
      .once();

    // When
    EndpointSlice endpointSliceCreated = client.resource(endpointSlice).inNamespace("ns1").createOrReplace();

    // Then
    assertNotNull(endpointSliceCreated);
    assertEquals("example-abc", endpointSliceCreated.getMetadata().getName());
    assertEquals("discovery.k8s.io/v1beta1", endpointSliceCreated.getApiVersion());
    assertEquals("example-abc", endpointSliceCreated.getMetadata().getName());
    assertEquals("example", endpointSliceCreated.getMetadata().getLabels().get("kubernetes.io/service-name"));
    assertEquals("IPv4", endpointSliceCreated.getAddressType());
    assertEquals(1, endpointSliceCreated.getPorts().size());
    assertEquals(1, endpointSliceCreated.getEndpoints().size());
    assertEquals("pod-1", endpointSliceCreated.getEndpoints().get(0).getHostname());
    assertEquals("node-1", endpointSliceCreated.getEndpoints().get(0).getTopology().get("kubernetes.io/hostname"));
    assertEquals("us-west2-a", endpointSliceCreated.getEndpoints().get(0).getTopology().get("topology.kubernetes.io/zone"));
  }

  private EndpointSlice getEndpointSlice() {
    return new EndpointSliceBuilder()
      .withNewMetadata()
      .withName("example-abc")
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
      .addToTopology("kubernetes.io/hostname", "node-1")
      .addToTopology("topology.kubernetes.io/zone", "us-west2-a")
      .endEndpoint()
      .build();
  }
}
