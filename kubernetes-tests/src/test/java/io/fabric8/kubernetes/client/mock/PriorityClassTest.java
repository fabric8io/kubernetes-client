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

import io.fabric8.kubernetes.api.model.scheduling.PriorityClass;
import io.fabric8.kubernetes.api.model.scheduling.PriorityClassBuilder;
import io.fabric8.kubernetes.api.model.scheduling.PriorityClassList;
import io.fabric8.kubernetes.api.model.scheduling.PriorityClassListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.server.mock.KubernetesServer;
import io.fabric8.kubernetes.client.utils.Utils;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class PriorityClassTest {
  @Rule
  public KubernetesServer server = new KubernetesServer();

  @Test
  public void testList() {
    server.expect().withPath("/apis/scheduling.k8s.io/v1beta1/priorityclasses").andReturn(200, new PriorityClassListBuilder()
      .addNewItem().and()
      .addNewItem().and()
      .addNewItem()
      .and().build()).once();

    KubernetesClient client = server.getClient();

    PriorityClassList priorityClassList = client.scheduling().priorityClass().list();
    assertNotNull(priorityClassList);
    assertEquals(3, priorityClassList.getItems().size());
  }

  @Test
  public void testListWithLables() {
    server.expect().withPath("/apis/scheduling.k8s.io/v1beta1/priorityclasses?labelSelector=" + Utils.toUrlEncoded("key1=value1,key2=value2,key3=value3")).andReturn(200, new PriorityClassListBuilder().build()).always();
    server.expect().withPath("/apis/scheduling.k8s.io/v1beta1/priorityclasses?labelSelector=" + Utils.toUrlEncoded("key1=value1,key2=value2")).andReturn(200, new PriorityClassListBuilder()
      .addNewItem().and()
      .addNewItem().and()
      .addNewItem().and()
      .build()).once();

    KubernetesClient client = server.getClient();

    PriorityClassList priorityClassList = client.scheduling().priorityClass()
      .withLabel("key1", "value1")
      .withLabel("key2", "value2")
      .list();
    assertEquals(3, priorityClassList.getItems().size());

    priorityClassList = client.scheduling().priorityClass()
      .withLabel("key1", "value1")
      .withLabel("key2","value2")
      .withLabel("key3","value3")
      .list();
    assertEquals(0, priorityClassList.getItems().size());
  }

  @Test
  public void testGet() {
    server.expect().withPath("/apis/scheduling.k8s.io/v1beta1/priorityclasses/priorityclass1").andReturn(200, new PriorityClassBuilder().build()).once();
    server.expect().withPath("/apis/scheduling.k8s.io/v1beta1/priorityclasses/priorityclass2").andReturn(200, new PriorityClassBuilder().build()).once();

    KubernetesClient client = server.getClient();

    PriorityClass priorityClass1 = client.scheduling().priorityClass().withName("priorityclass1").get();
    assertNotNull(priorityClass1);

    priorityClass1 = client.scheduling().priorityClass().withName("priorityclass2").get();
    assertNotNull(priorityClass1);

  }

  @Test
  public void testDelete() {
    server.expect().withPath("/apis/scheduling.k8s.io/v1beta1/priorityclasses/priorityclass1").andReturn(200, new PriorityClassBuilder()
      .withNewMetadata().withName("high-priority").endMetadata()
      .withValue(new Integer(100000))
      .withGlobalDefault(false)
      .withDescription("This priority class should be used for XYZ service pods only.")
      .build()).once();

    KubernetesClient client = server.getClient();

    Boolean deleted = client.scheduling().priorityClass().withName("priorityclass1").delete();
    assertNotNull(deleted);
    assertTrue(deleted);
  }

  @Test
  public void testDeleteMulti() {
    PriorityClass priorityClass1 = new PriorityClassBuilder()
      .withNewMetadata().withName("high-priority").endMetadata()
      .withValue(new Integer(100000))
      .withGlobalDefault(false)
      .withDescription("This priority class should be used for XYZ service pods only.")
      .build();
    PriorityClass priorityClass2 = new PriorityClassBuilder()
      .withNewMetadata().withName("super-high-priority").endMetadata()
      .withValue(new Integer(1000000))
      .withGlobalDefault(false)
      .withDescription("This priority class should be used for XYZ service pods only.")
      .build();

    server.expect().withPath("/apis/scheduling.k8s.io/v1beta1/priorityclasses/priorityclass1").andReturn(200, priorityClass1).once();
    server.expect().withPath("/apis/scheduling.k8s.io/v1beta1/priorityclasses/priorityclass1").andReturn(200, new PriorityClassBuilder(priorityClass1)
      .editMetadata().addToAnnotations("foo", "bar").endMetadata().build()).times(5);
    server.expect().withPath("/apis/scheduling.k8s.io/v1beta1/priorityclasses/priorityclass2").andReturn(200, priorityClass2).once();
    server.expect().withPath("/apis/scheduling.k8s.io/v1beta1/priorityclasses/priorityclass2").andReturn(200, new PriorityClassBuilder(priorityClass2)
      .editMetadata().addToAnnotations("foo", "bar").endMetadata().build()).times(5);

    KubernetesClient client = server.getClient();

    Boolean deleted = client.scheduling().priorityClass().delete(priorityClass1, priorityClass2);
    assertNotNull(deleted);
  }

  @Test(expected = KubernetesClientException.class)
  public void testCreateWithNameMismatch() {
    PriorityClass priorityClass1 = new PriorityClassBuilder().withNewMetadata().withName("priorityclass1").and().build();
    KubernetesClient client = server.getClient();

    client.scheduling().priorityClass().withName("mypriorityclass1").create(priorityClass1);
  }

  @Test
  public void testLoadFromFile() {
    KubernetesClient client = server.getClient();
    assertNotNull(client.scheduling().priorityClass().load(getClass().getResourceAsStream("/test-priorityclass.yml")).get());
  }
}
