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

import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.NamespaceBuilder;
import io.fabric8.kubernetes.api.model.Node;
import io.fabric8.kubernetes.api.model.NodeList;
import io.fabric8.kubernetes.api.model.NodeListBuilder;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableKubernetesMockClient
public class NodeTest {

  KubernetesMockServer server;
  KubernetesClient client;

  @Test
  public void testList() {
    server.expect().withPath("/api/v1/nodes").andReturn(200, new NodeListBuilder().addNewItem().and().build()).once();

    NodeList nodeList = client.nodes().list();
    assertNotNull(nodeList);
    assertEquals(1, nodeList.getItems().size());
  }

  @Test
  public void testGet() {
    server.expect().withPath("/api/v1/nodes/node1").andReturn(200, new PodBuilder().build()).once();
    server.expect().withPath("/api/v1/nodes/node2").andReturn(200, new PodBuilder().build()).once();

    Node node = client.nodes().withName("node1").get();
    assertNotNull(node);

    node = client.nodes().withName("node2").get();
    assertNotNull(node);

    node = client.nodes().withName("node3").get();
    assertNull(node);
  }

  @Test
  public void testDelete() {
    server.expect().withPath("/api/v1/nodes/node1").andReturn(200, new PodBuilder().build()).once();
    server.expect().withPath("/api/v1/nodes/node2").andReturn(200, new PodBuilder().build()).once();

    boolean deleted = client.nodes().withName("node1").delete().size() == 1;
    assertTrue(deleted);

    deleted = client.nodes().withName("node2").delete().size() == 1;
    assertTrue(deleted);

    deleted = client.nodes().withName("node3").delete().size() == 1;
    assertFalse(deleted);
  }

  @Test
  public void testCreateWithNameMismatch() {
    Assertions.assertThrows(KubernetesClientException.class, () -> {
      Namespace ns1 = new NamespaceBuilder().withNewMetadata().withName("ns1").and().build();

      client.namespaces().withName("myns1").create(ns1);
    });
  }
}
