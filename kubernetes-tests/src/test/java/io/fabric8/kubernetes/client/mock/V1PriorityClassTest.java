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

import io.fabric8.kubernetes.api.model.scheduling.v1.PriorityClass;
import io.fabric8.kubernetes.api.model.scheduling.v1.PriorityClassBuilder;
import io.fabric8.kubernetes.api.model.scheduling.v1.PriorityClassList;
import io.fabric8.kubernetes.api.model.scheduling.v1.PriorityClassListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.kubernetes.client.utils.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableKubernetesMockClient
class V1PriorityClassTest {

  KubernetesClient client;
  KubernetesMockServer server;

  @Test
  void testList() {
    // Given
    server.expect().withPath("/apis/scheduling.k8s.io/v1/priorityclasses")
        .andReturn(HttpURLConnection.HTTP_OK, new PriorityClassListBuilder()
            .addNewItem().and()
            .addNewItem().and()
            .addNewItem()
            .and().build())
        .once();

    // When
    PriorityClassList priorityClassList = client.scheduling().v1().priorityClasses().list();

    // Then
    assertNotNull(priorityClassList);
    assertEquals(3, priorityClassList.getItems().size());
  }

  @Test
  void testListWithLables() {
    // Given
    server.expect()
        .withPath("/apis/scheduling.k8s.io/v1/priorityclasses?labelSelector="
            + Utils.toUrlEncoded("key1=value1,key2=value2,key3=value3"))
        .andReturn(HttpURLConnection.HTTP_OK, new PriorityClassListBuilder().build()).always();
    server.expect()
        .withPath("/apis/scheduling.k8s.io/v1/priorityclasses?labelSelector=" + Utils.toUrlEncoded("key1=value1,key2=value2"))
        .andReturn(HttpURLConnection.HTTP_OK, new PriorityClassListBuilder()
            .addNewItem().and()
            .addNewItem().and()
            .addNewItem().and()
            .build())
        .once();

    // When
    PriorityClassList priorityClassList1 = client.scheduling().v1().priorityClasses()
        .withLabel("key1", "value1")
        .withLabel("key2", "value2")
        .list();

    PriorityClassList priorityClassList2 = client.scheduling().v1().priorityClasses()
        .withLabel("key1", "value1")
        .withLabel("key2", "value2")
        .withLabel("key3", "value3")
        .list();

    // Then
    assertEquals(3, priorityClassList1.getItems().size());
    assertEquals(0, priorityClassList2.getItems().size());
  }

  @Test
  void testGet() {
    // Given
    server.expect().withPath("/apis/scheduling.k8s.io/v1/priorityclasses/priorityclass1")
        .andReturn(HttpURLConnection.HTTP_OK, new PriorityClassBuilder().build()).once();
    server.expect().withPath("/apis/scheduling.k8s.io/v1/priorityclasses/priorityclass2")
        .andReturn(HttpURLConnection.HTTP_OK, new PriorityClassBuilder().build()).once();

    // When
    PriorityClass priorityClass1 = client.scheduling().v1().priorityClasses().withName("priorityclass1").get();
    PriorityClass priorityClass2 = client.scheduling().v1().priorityClasses().withName("priorityclass2").get();

    // Then
    assertNotNull(priorityClass1);
    assertNotNull(priorityClass2);

  }

  @Test
  void testDelete() {
    // Given
    server.expect().withPath("/apis/scheduling.k8s.io/v1/priorityclasses/priorityclass1")
        .andReturn(HttpURLConnection.HTTP_OK, new PriorityClassBuilder()
            .withNewMetadata().withName("high-priority").endMetadata()
            .withValue(100000)
            .withGlobalDefault(false)
            .withDescription("This priority class should be used for XYZ service pods only.")
            .build())
        .once();

    // When
    boolean deleted = client.scheduling().v1().priorityClasses().withName("priorityclass1").delete().size() == 1;

    // Then
    assertTrue(deleted);
  }

  @Test
  void testDeleteMulti() {
    // Given
    PriorityClass priorityClass1 = new PriorityClassBuilder()
        .withNewMetadata().withName("high-priority").endMetadata()
        .withValue(100000)
        .withGlobalDefault(false)
        .withDescription("This priority class should be used for XYZ service pods only.")
        .build();
    PriorityClass priorityClass2 = new PriorityClassBuilder()
        .withNewMetadata().withName("super-high-priority").endMetadata()
        .withValue(1000000)
        .withGlobalDefault(false)
        .withDescription("This priority class should be used for XYZ service pods only.")
        .build();

    server.expect().delete().withPath("/apis/scheduling.k8s.io/v1/priorityclasses/high-priority")
        .andReturn(HttpURLConnection.HTTP_OK, priorityClass1).once();
    server.expect().delete().withPath("/apis/scheduling.k8s.io/v1/priorityclasses/super-high-priority")
        .andReturn(HttpURLConnection.HTTP_OK, priorityClass2).once();

    // When
    boolean deleted = client.scheduling().v1().priorityClasses().delete(priorityClass1, priorityClass2);

    // Then
    assertTrue(deleted);
  }

  @Test
  void testCreateWithNameMismatch() {
    PriorityClass priorityClass1 = new PriorityClassBuilder().withNewMetadata().withName("priorityclass1").and().build();
    Resource<PriorityClass> pcOp = client.scheduling().v1().priorityClasses().withName("mypriorityclass1");
    Assertions.assertThrows(KubernetesClientException.class, () -> {
      pcOp.create(priorityClass1);
    });
  }

  @Test
  void testLoadFromFile() {
    assertNotNull(
        client.scheduling().priorityClass().load(getClass().getResourceAsStream("/test-v1-priorityclass.yml")).item());
  }

}
