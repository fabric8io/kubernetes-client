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
import io.fabric8.kubernetes.api.model.networking.v1.IngressClass;
import io.fabric8.kubernetes.api.model.networking.v1.IngressClassBuilder;
import io.fabric8.kubernetes.api.model.networking.v1.IngressClassList;
import io.fabric8.kubernetes.api.model.networking.v1.IngressClassListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.kubernetes.client.utils.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableKubernetesMockClient
class V1IngressClassTest {

  KubernetesMockServer server;
  KubernetesClient client;

  @Test
  void testLoad() {
    // When
    List<HasMetadata> itemList = client.load(getClass().getResourceAsStream("/test-v1-ingressclass.yml")).items();

    // Then
    assertEquals(1, itemList.size());
    assertTrue(itemList.get(0) instanceof IngressClass);
    IngressClass ingressClass = (IngressClass) itemList.get(0);
    assertEquals("external-lb", ingressClass.getMetadata().getName());
    assertEquals("example.com/ingress-controller", ingressClass.getSpec().getController());
  }

  @Test
  void testList() {
    // Given
    server.expect().withPath("/apis/networking.k8s.io/v1/ingressclasses")
        .andReturn(HttpURLConnection.HTTP_OK, new IngressClassListBuilder().build()).once();
    server.expect().withPath("/apis/networking.k8s.io/v1/ingressclasses")
        .andReturn(HttpURLConnection.HTTP_OK, new IngressClassListBuilder()
            .addNewItem().and()
            .addNewItem().and().build())
        .once();

    server.expect().withPath("/apis/networking.k8s.io/v1/ingressclasses")
        .andReturn(HttpURLConnection.HTTP_OK, new IngressClassListBuilder()
            .addNewItem().and()
            .addNewItem().and()
            .addNewItem()
            .and().build())
        .once();

    // When + Then
    IngressClassList ingressClassList = client.network().v1().ingressClasses().list();
    assertNotNull(ingressClassList);
    assertEquals(0, ingressClassList.getItems().size());

    ingressClassList = client.network().v1().ingressClasses().list();
    assertNotNull(ingressClassList);
    assertEquals(2, ingressClassList.getItems().size());

    ingressClassList = client.network().v1().ingressClasses().list();
    assertNotNull(ingressClassList);
    assertEquals(3, ingressClassList.getItems().size());
  }

  @Test
  void testListWithLables() {
    // Given
    server.expect()
        .withPath("/apis/networking.k8s.io/v1/ingressclasses?labelSelector="
            + Utils.toUrlEncoded("key1=value1,key2=value2,key3=value3"))
        .andReturn(HttpURLConnection.HTTP_OK, new IngressClassListBuilder().build()).always();
    server.expect()
        .withPath("/apis/networking.k8s.io/v1/ingressclasses?labelSelector=" + Utils.toUrlEncoded("key1=value1,key2=value2"))
        .andReturn(HttpURLConnection.HTTP_OK, new IngressClassListBuilder()
            .addNewItem().and()
            .addNewItem().and()
            .addNewItem().and()
            .build())
        .once();

    // When + Then
    IngressClassList ingressClassList = client.network().v1().ingressClasses()
        .withLabel("key1", "value1")
        .withLabel("key2", "value2")
        .withLabel("key3", "value3")
        .list();

    assertNotNull(ingressClassList);
    assertEquals(0, ingressClassList.getItems().size());

    ingressClassList = client.network().v1().ingressClasses()
        .withLabel("key1", "value1")
        .withLabel("key2", "value2")
        .list();

    assertNotNull(ingressClassList);
    assertEquals(3, ingressClassList.getItems().size());
  }

  @Test
  void testGet() {
    // Given
    server.expect().withPath("/apis/networking.k8s.io/v1/ingressclasses/ingressClass1")
        .andReturn(HttpURLConnection.HTTP_OK, new IngressClassBuilder().build()).once();
    server.expect().withPath("/apis/networking.k8s.io/v1/ingressclasses/ingressClass2")
        .andReturn(HttpURLConnection.HTTP_OK, new IngressClassBuilder().build()).once();

    // When
    IngressClass ingressClass1 = client.network().v1().ingressClasses().withName("ingressClass1").get();
    IngressClass ingressClass2 = client.network().v1().ingressClasses().withName("ingressClass2").get();

    // Then
    assertNotNull(ingressClass1);
    assertNotNull(ingressClass2);
  }

  @Test
  void testDelete() {
    // Given
    server.expect().withPath("/apis/networking.k8s.io/v1/ingressclasses/ingressClass1")
        .andReturn(HttpURLConnection.HTTP_OK, new IngressClassBuilder().build()).once();
    server.expect().withPath("/apis/networking.k8s.io/v1/ingressclasses/ingressClass2")
        .andReturn(HttpURLConnection.HTTP_OK, new IngressClassBuilder().build()).once();

    // When
    boolean result1 = client.network().v1().ingressClasses().withName("ingressClass1").delete().size() == 1;
    boolean result2 = client.network().v1().ingressClasses().withName("ingressClass2").delete().size() == 1;

    // Then
    assertTrue(result1);
    assertTrue(result2);
  }

  @Test
  void testCreateWithNameMismatch() {
    // Given
    IngressClass ingressClass1 = new IngressClassBuilder().withNewMetadata().withName("ingressClass1").and().build();

    // When
    Resource<IngressClass> ingressClassOp = client.network().v1().ingressClasses().withName("myingressClass1");

    // Then
    Assertions.assertThrows(KubernetesClientException.class, () -> ingressClassOp.create(ingressClass1));
  }
}
