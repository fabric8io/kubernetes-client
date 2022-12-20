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

import io.fabric8.kubernetes.api.model.Endpoints;
import io.fabric8.kubernetes.api.model.EndpointsBuilder;
import io.fabric8.kubernetes.api.model.EndpointsList;
import io.fabric8.kubernetes.api.model.EndpointsListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.kubernetes.client.utils.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableKubernetesMockClient
public class EndpointsTest {

  KubernetesMockServer server;
  KubernetesClient client;

  @Test
  public void testList() {
    server.expect().withPath("/api/v1/namespaces/test/endpoints").andReturn(200, new EndpointsListBuilder().build()).once();
    server.expect().withPath("/api/v1/namespaces/ns1/endpoints").andReturn(200, new EndpointsListBuilder()
        .addNewItem().and()
        .addNewItem().and()
        .build()).once();
    server.expect().withPath("/api/v1/endpoints").andReturn(200, new EndpointsListBuilder()
        .addNewItem().and()
        .addNewItem().and()
        .addNewItem().and()
        .build()).once();

    EndpointsList endpointsList = client.endpoints().list();
    assertNotNull(endpointsList);
    assertEquals(0, endpointsList.getItems().size());

    endpointsList = client.endpoints().inNamespace("ns1").list();
    assertNotNull(endpointsList);
    assertEquals(2, endpointsList.getItems().size());

    endpointsList = client.endpoints().inAnyNamespace().list();
    assertNotNull(endpointsList);
    assertEquals(3, endpointsList.getItems().size());
  }

  @Test
  public void testListWithLabels() {
    server.expect()
        .withPath(
            "/api/v1/namespaces/test/endpoints?labelSelector=" + Utils.toUrlEncoded("key1=value1,key2=value2,key3=value3"))
        .andReturn(200, new EndpointsListBuilder().build()).once();
    server.expect().withPath("/api/v1/namespaces/ns1/endpoints?labelSelector=" + Utils.toUrlEncoded("key1=value1,key2=value2"))
        .andReturn(200, new EndpointsListBuilder()
            .addNewItem().and()
            .addNewItem().and()
            .build())
        .once();

    EndpointsList endpointsList = client.endpoints()
        .withLabel("key1", "value1")
        .withLabel("key2", "value2")
        .withLabel("key3", "value3")
        .list();
    assertNotNull(endpointsList);
    assertEquals(0, endpointsList.getItems().size());

    endpointsList = client.endpoints().inNamespace("ns1")
        .withLabel("key1", "value1")
        .withLabel("key2", "value2")
        .list();
    assertNotNull(endpointsList);
    assertEquals(2, endpointsList.getItems().size());
  }

  @Test
  public void testEditMissing() {
    Assertions.assertThrows(KubernetesClientException.class, () -> {
      server.expect().withPath("/api/v1/namespaces/test/endpoints/endpoint").andReturn(404, "error message from kubernetes")
          .always();

      client.endpoints().withName("endpoint").edit(r -> r);
    });
  }

  @Test
  public void testGet() {
    server.expect().withPath("/api/v1/namespaces/test/endpoints/endpoint1").andReturn(200, new EndpointsBuilder().build())
        .once();
    server.expect().withPath("/api/v1/namespaces/ns1/endpoints/endpoint2").andReturn(200, new EndpointsBuilder().build())
        .once();

    Endpoints endpoints = client.endpoints().inNamespace("test").withName("endpoint1").get();
    assertNotNull(endpoints);

    endpoints = client.endpoints().withName("endpoint2").get();
    assertNull(endpoints);

    endpoints = client.endpoints().inNamespace("ns1").withName("endpoint2").get();
    assertNotNull(endpoints);
  }

  @Test
  public void testDelete() {
    server.expect().withPath("/api/v1/namespaces/test/endpoints/endpoint1").andReturn(200, new EndpointsBuilder().build())
        .once();
    server.expect().withPath("/api/v1/namespaces/ns1/endpoints/endpoint2").andReturn(200, new EndpointsBuilder().build())
        .once();

    boolean deleted = client.endpoints().inNamespace("test").withName("endpoint1").delete().size() == 1;
    assertTrue(deleted);

    deleted = client.endpoints().withName("endpoint2").delete().size() == 1;
    assertFalse(deleted);

    deleted = client.endpoints().inNamespace("ns1").withName("endpoint2").delete().size() == 1;
    assertTrue(deleted);
  }

  @Test
  public void testDeleteMulti() {
    Endpoints endpoint1 = new EndpointsBuilder().withNewMetadata().withName("endpoint1").withNamespace("test").endMetadata()
        .build();
    Endpoints endpoint2 = new EndpointsBuilder().withNewMetadata().withName("endpoint2").withNamespace("ns1").endMetadata()
        .build();
    Endpoints endpoint3 = new EndpointsBuilder().withNewMetadata().withName("endpoint3").withNamespace("any").endMetadata()
        .build();

    server.expect().withPath("/api/v1/namespaces/test/endpoints/endpoint1").andReturn(200, endpoint1).once();
    server.expect().withPath("/api/v1/namespaces/ns1/endpoints/endpoint2").andReturn(200, endpoint2).once();

    Boolean deleted = client.endpoints().inAnyNamespace().delete(endpoint1, endpoint2);
    assertTrue(deleted);

    deleted = client.endpoints().inAnyNamespace().delete(endpoint3).size() == 1;
    assertFalse(deleted);
  }

  @Test
  public void testCreateWithNameMismatch() {
    Assertions.assertThrows(KubernetesClientException.class, () -> {
      Endpoints endpoint1 = new EndpointsBuilder().withNewMetadata().withName("endpoint1").withNamespace("test").endMetadata()
          .build();
      Endpoints endpoint2 = new EndpointsBuilder().withNewMetadata().withName("endpoint2").withNamespace("ns1").endMetadata()
          .build();

      client.endpoints().inNamespace("test1").withName("myendpoint1").create(endpoint1);
    });
  }

  @Test
  public void testLoad() {
    Endpoints endpoints = client.endpoints().load(getClass().getResourceAsStream("/test-endpoints.yml")).item();
    assertNotNull(endpoints);
    assertEquals("external-web", endpoints.getMetadata().getName());
  }

  @Test
  public void testBuild() {
    Endpoints endpoints = new EndpointsBuilder()
        .withNewMetadata().withName("endpoint").withNamespace("test").endMetadata()
        .withSubsets().addNewSubset().addNewAddress().withIp("10.10.50.53").endAddress()
        .addNewPort().withPort(80).withName("apache").endPort()
        .endSubset()
        .build();

    server.expect().withPath("/api/v1/namespaces/test/endpoints/endpoint").andReturn(200, endpoints).once();

    endpoints = client.endpoints().inNamespace("test").withName("endpoint").get();
    assertNotNull(endpoints);
    assertEquals("apache", endpoints.getSubsets().get(0).getPorts().get(0).getName());
  }

}
