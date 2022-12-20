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
import io.fabric8.kubernetes.api.model.networking.v1.Ingress;
import io.fabric8.kubernetes.api.model.networking.v1.IngressBuilder;
import io.fabric8.kubernetes.api.model.networking.v1.IngressList;
import io.fabric8.kubernetes.api.model.networking.v1.IngressListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.kubernetes.client.utils.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableKubernetesMockClient
class NetworkingV1IngressTest {

  KubernetesMockServer server;
  KubernetesClient client;

  @Test
  void testLoad() {
    List<HasMetadata> itemList = client.load(getClass().getResourceAsStream("/test-v1-ingress.yml")).items();

    assertEquals(1, itemList.size());
    Ingress ingress = (Ingress) itemList.get(0);
    assertEquals("minimal-ingress", ingress.getMetadata().getName());
    assertEquals(1, ingress.getSpec().getRules().size());
  }

  @Test
  void testList() {
    server.expect().withPath("/apis/networking.k8s.io/v1/namespaces/test/ingresses")
        .andReturn(HttpURLConnection.HTTP_OK, new IngressListBuilder().build()).once();
    server.expect().withPath("/apis/networking.k8s.io/v1/namespaces/ns1/ingresses")
        .andReturn(HttpURLConnection.HTTP_OK, new IngressListBuilder()
            .addNewItem().and()
            .addNewItem().and().build())
        .once();

    server.expect().withPath("/apis/networking.k8s.io/v1/ingresses")
        .andReturn(HttpURLConnection.HTTP_OK, new IngressListBuilder()
            .addNewItem().and()
            .addNewItem().and()
            .addNewItem()
            .and().build())
        .once();

    IngressList ingressList = client.network().v1().ingresses().list();
    assertNotNull(ingressList);
    assertEquals(0, ingressList.getItems().size());

    ingressList = client.network().v1().ingresses().inNamespace("ns1").list();
    assertNotNull(ingressList);
    assertEquals(2, ingressList.getItems().size());

    ingressList = client.network().v1().ingresses().inAnyNamespace().list();
    assertNotNull(ingressList);
    assertEquals(3, ingressList.getItems().size());
  }

  @Test
  void testListWithLables() {
    server.expect()
        .withPath("/apis/networking.k8s.io/v1/namespaces/test/ingresses?labelSelector="
            + Utils.toUrlEncoded("key1=value1,key2=value2,key3=value3"))
        .andReturn(HttpURLConnection.HTTP_OK, new IngressListBuilder().build()).always();
    server.expect().withPath(
        "/apis/networking.k8s.io/v1/namespaces/test/ingresses?labelSelector=" + Utils.toUrlEncoded("key1=value1,key2=value2"))
        .andReturn(HttpURLConnection.HTTP_OK, new IngressListBuilder()
            .addNewItem().and()
            .addNewItem().and()
            .addNewItem().and()
            .build())
        .once();

    IngressList ingressList = client.network().v1().ingresses()
        .withLabel("key1", "value1")
        .withLabel("key2", "value2")
        .withLabel("key3", "value3")
        .list();

    assertNotNull(ingressList);
    assertEquals(0, ingressList.getItems().size());

    ingressList = client.network().v1().ingresses()
        .withLabel("key1", "value1")
        .withLabel("key2", "value2")
        .list();

    assertNotNull(ingressList);
    assertEquals(3, ingressList.getItems().size());
  }

  @Test
  void testGet() {
    server.expect().withPath("/apis/networking.k8s.io/v1/namespaces/test/ingresses/ingress1")
        .andReturn(HttpURLConnection.HTTP_OK, new IngressBuilder().build()).once();
    server.expect().withPath("/apis/networking.k8s.io/v1/namespaces/ns1/ingresses/ingress2")
        .andReturn(HttpURLConnection.HTTP_OK, new IngressBuilder().build()).once();

    Ingress ingress = client.network().v1().ingresses().withName("ingress1").get();
    assertNotNull(ingress);

    ingress = client.network().v1().ingresses().withName("ingress2").get();
    assertNull(ingress);

    ingress = client.network().v1().ingresses().inNamespace("ns1").withName("ingress2").get();
    assertNotNull(ingress);
  }

  @Test
  void testDelete() {
    server.expect().withPath("/apis/networking.k8s.io/v1/namespaces/test/ingresses/ingress1")
        .andReturn(HttpURLConnection.HTTP_OK, new IngressBuilder().build()).once();
    server.expect().withPath("/apis/networking.k8s.io/v1/namespaces/ns1/ingresses/ingress2")
        .andReturn(HttpURLConnection.HTTP_OK, new IngressBuilder().build()).once();

    boolean deleted = client.network().v1().ingresses().withName("ingress1").delete().size() == 1;
    assertTrue(deleted);

    deleted = client.network().v1().ingresses().withName("ingress2").delete().size() == 1;
    assertFalse(deleted);

    deleted = client.network().v1().ingresses().inNamespace("ns1").withName("ingress2").delete().size() == 1;
    assertTrue(deleted);
  }

  @Test
  void testDeleteMulti() {
    Ingress ingress1 = new IngressBuilder().withNewMetadata().withName("ingress1").withNamespace("test").and().build();
    Ingress ingress2 = new IngressBuilder().withNewMetadata().withName("ingress2").withNamespace("ns1").and().build();
    Ingress ingress3 = new IngressBuilder().withNewMetadata().withName("ingress3").withNamespace("any").and().build();

    server.expect().withPath("/apis/networking.k8s.io/v1/namespaces/test/ingresses/ingress1")
        .andReturn(HttpURLConnection.HTTP_OK, ingress1).once();
    server.expect().withPath("/apis/networking.k8s.io/v1/namespaces/ns1/ingresses/ingress2")
        .andReturn(HttpURLConnection.HTTP_OK, ingress2).once();

    Boolean deleted = client.network().v1().ingresses().inAnyNamespace().delete(ingress1, ingress2);
    assertTrue(deleted);

    deleted = client.network().v1().ingresses().inAnyNamespace().delete(ingress3).size() == 1;
    assertFalse(deleted);
  }

  @Test
  void testDeleteWithNamespaceMismatch() {
    Ingress ingress1 = new IngressBuilder().withNewMetadata().withName("ingress1").withNamespace("test").and().build();
    NonNamespaceOperation<Ingress, IngressList, Resource<Ingress>> ingressOp = client
        .network()
        .v1()
        .ingresses().inNamespace("test1");

    assertFalse(ingressOp.delete(ingress1).size() == 1);
  }

  @Test
  void testCreateWithNameMismatch() {
    Ingress ingress1 = new IngressBuilder().withNewMetadata().withName("ingress1").withNamespace("test").and().build();
    Resource<Ingress> ingressOp = client.network().v1().ingresses().inNamespace("test1").withName("myingress1");

    Assertions.assertThrows(KubernetesClientException.class, () -> ingressOp.create(ingress1));
  }

  @Test
  void testCreateOrReplaceWhenAnnotationUpdated() {
    // Given
    Ingress ingressFromServer = new IngressBuilder().withNewMetadata().withName("ing1").endMetadata().build();
    Ingress ingressUpdated = new IngressBuilder(ingressFromServer).editOrNewMetadata()
        .addToAnnotations("nginx.ingress.kubernetes.io/rewrite-target", "/")
        .endMetadata().build();
    server.expect().post().withPath("/apis/networking.k8s.io/v1/namespaces/ns1/ingresses")
        .andReturn(HttpURLConnection.HTTP_CONFLICT, ingressFromServer).once();
    server.expect().get().withPath("/apis/networking.k8s.io/v1/namespaces/ns1/ingresses/ing1")
        .andReturn(HttpURLConnection.HTTP_OK, ingressFromServer).times(2);
    server.expect().put().withPath("/apis/networking.k8s.io/v1/namespaces/ns1/ingresses/ing1")
        .andReturn(HttpURLConnection.HTTP_OK, ingressUpdated).once();

    // When
    ingressUpdated = client.network().v1().ingresses().inNamespace("ns1").createOrReplace(ingressUpdated);

    // Then
    assertNotNull(ingressUpdated);
    assertNotNull(ingressUpdated.getMetadata());
    assertTrue(ingressUpdated.getMetadata().getAnnotations().containsKey("nginx.ingress.kubernetes.io/rewrite-target"));
  }
}
