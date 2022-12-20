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

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.NamespaceBuilder;
import io.fabric8.kubernetes.api.model.NamespaceList;
import io.fabric8.kubernetes.api.model.NamespaceListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.kubernetes.client.utils.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableKubernetesMockClient
public class NamespaceTest {

  KubernetesMockServer server;
  KubernetesClient client;

  @Test
  public void testList() {
    server.expect().withPath("/api/v1/namespaces").andReturn(200, new NamespaceListBuilder()
        .addNewItem().and()
        .addNewItem().and()
        .build()).once();

    NamespaceList namespaceList = client.namespaces().list();
    assertNotNull(namespaceList);
    assertEquals(2, namespaceList.getItems().size());
  }

  @Test
  public void testCreateWithHandler() {
    server.expect().post().withPath("/api/v1/namespaces")
        .andReturn(200, new NamespaceBuilder()
            .withNewMetadata()
            .withName("namespace-test")
            .endMetadata()
            .build())
        .once();

    List<HasMetadata> nsList = client.load(getClass().getResourceAsStream("/test-namespace.yml")).createOrReplace();
    assertNotNull(nsList);
    assertEquals(1, nsList.size());
    assertEquals("namespace-test", nsList.get(0).getMetadata().getName());
  }

  @Test
  public void testListWithLables() {
    server.expect().withPath("/api/v1/namespaces?labelSelector=" + Utils.toUrlEncoded("key1=value1,key2=value2,key3=value3"))
        .andReturn(200, new NamespaceListBuilder().build()).always();
    server.expect().withPath("/api/v1/namespaces?labelSelector=" + Utils.toUrlEncoded("key1=value1,key2=value2"))
        .andReturn(200, new NamespaceListBuilder().addNewItem().and()
            .addNewItem().and()
            .addNewItem().and()
            .build())
        .once();

    NamespaceList namespaceList = client.namespaces()
        .withLabel("key1", "value1")
        .withLabel("key2", "value2")
        .list();
    assertEquals(3, namespaceList.getItems().size());

    namespaceList = client.namespaces()
        .withLabel("key1", "value1")
        .withLabel("key2", "value2")
        .withLabel("key3", "value3")
        .list();
    assertEquals(0, namespaceList.getItems().size());
  }

  @Test
  public void testEditMissing() {
    Assertions.assertThrows(KubernetesClientException.class, () -> {
      server.expect().withPath("/api/v1/namespaces/namespace1").andReturn(404, "error message from kubernetes").always();

      client.namespaces().withName("namespace1").edit(n -> n);
    });
  }

  @Test
  public void testGet() {
    server.expect().withPath("/api/v1/namespaces/namespace1").andReturn(200, new NamespaceBuilder().build()).once();
    server.expect().withPath("/api/v1/namespaces/namespace2").andReturn(200, new NamespaceBuilder().build()).once();

    Namespace namespace = client.namespaces().withName("namespace1").get();
    assertNotNull(namespace);

    namespace = client.namespaces().withName("namespace2").get();
    assertNotNull(namespace);

    namespace = client.namespaces().withName("namespace2").get();
    assertNull(namespace);
  }

  @Test
  public void testDelete() {
    server.expect().withPath("/api/v1/namespaces/namespace1").andReturn(200, new NamespaceBuilder().build()).once();
    boolean deleted = client.namespaces().withName("namespace1").delete().size() == 1;
    assertTrue(deleted);
  }

  @Test
  public void testDeleteMulti() {
    Namespace namespace1 = new NamespaceBuilder().withNewMetadata().withName("namespace1").and().build();
    Namespace namespace2 = new NamespaceBuilder().withNewMetadata().withName("namespace2").and().build();
    Namespace namespace3 = new NamespaceBuilder().withNewMetadata().withName("namespace3").and().build();

    server.expect().withPath("/api/v1/namespaces/namespace1").andReturn(200, namespace1).once();
    server.expect().withPath("/api/v1/namespaces/namespace2").andReturn(200, namespace2).once();

    Boolean deleted = client.namespaces().delete(namespace1, namespace2);
    assertTrue(deleted);

    deleted = client.namespaces().delete(namespace3).size() == 1;
    assertFalse(deleted);
  }

  @Test
  public void testLoadFromFile() {
    Namespace namespace = client.namespaces().load(getClass().getResourceAsStream("/test-namespace.yml")).item();
    assertEquals("namespace-test", namespace.getMetadata().getName());
  }

}
