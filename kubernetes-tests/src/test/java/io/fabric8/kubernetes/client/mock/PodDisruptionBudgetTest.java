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

import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.policy.v1beta1.PodDisruptionBudget;
import io.fabric8.kubernetes.api.model.policy.v1beta1.PodDisruptionBudgetBuilder;
import io.fabric8.kubernetes.api.model.policy.v1beta1.PodDisruptionBudgetList;
import io.fabric8.kubernetes.api.model.policy.v1beta1.PodDisruptionBudgetListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.kubernetes.client.utils.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableKubernetesMockClient
public class PodDisruptionBudgetTest {

  KubernetesMockServer server;
  KubernetesClient client;

  @Test
  public void list() {
    server.expect().withPath("/apis/policy/v1beta1/namespaces/test/poddisruptionbudgets")
        .andReturn(200, new PodDisruptionBudgetListBuilder().build()).once();
    server.expect().withPath("/apis/policy/v1beta1/namespaces/ns1/poddisruptionbudgets")
        .andReturn(200, new PodDisruptionBudgetListBuilder()
            .addNewItem().and()
            .addNewItem().and().build())
        .once();

    server.expect().withPath("/apis/policy/v1beta1/poddisruptionbudgets").andReturn(200, new PodDisruptionBudgetListBuilder()
        .addNewItem().and()
        .addNewItem().and()
        .addNewItem()
        .and().build()).once();

    PodDisruptionBudgetList podDisruptionBudgetList = client.policy().podDisruptionBudget().list();
    assertNotNull(podDisruptionBudgetList);
    assertEquals(0, podDisruptionBudgetList.getItems().size());

    podDisruptionBudgetList = client.policy().podDisruptionBudget().inNamespace("ns1").list();
    assertNotNull(podDisruptionBudgetList);
    assertEquals(2, podDisruptionBudgetList.getItems().size());

    podDisruptionBudgetList = client.policy().podDisruptionBudget().inAnyNamespace().list();
    assertNotNull(podDisruptionBudgetList);
    assertEquals(3, podDisruptionBudgetList.getItems().size());
  }

  @Test
  public void testListWithLabels() {
    server.expect()
        .withPath("/apis/policy/v1beta1/namespaces/test/poddisruptionbudgets?labelSelector="
            + Utils.toUrlEncoded("key1=value1,key2=value2,key3=value3"))
        .andReturn(200, new PodDisruptionBudgetListBuilder().build()).always();
    server.expect()
        .withPath("/apis/policy/v1beta1/namespaces/test/poddisruptionbudgets?labelSelector="
            + Utils.toUrlEncoded("key1=value1,key2=value2"))
        .andReturn(200, new PodDisruptionBudgetListBuilder()
            .addNewItem().and()
            .addNewItem().and()
            .addNewItem().and()
            .build())
        .once();

    PodDisruptionBudgetList podDisruptionBudgetList = client.policy().podDisruptionBudget()
        .withLabel("key1", "value1")
        .withLabel("key2", "value2")
        .withLabel("key3", "value3")
        .list();

    assertNotNull(podDisruptionBudgetList);
    assertEquals(0, podDisruptionBudgetList.getItems().size());

    podDisruptionBudgetList = client.policy().podDisruptionBudget()
        .withLabel("key1", "value1")
        .withLabel("key2", "value2")
        .list();

    assertNotNull(podDisruptionBudgetList);
    assertEquals(3, podDisruptionBudgetList.getItems().size());
  }

  @Test
  public void testGet() {
    server.expect().withPath("/apis/policy/v1beta1/namespaces/test/poddisruptionbudgets/poddisruptionbudget1")
        .andReturn(200, new PodDisruptionBudgetBuilder().build()).once();
    server.expect().withPath("/apis/policy/v1beta1/namespaces/ns1/poddisruptionbudgets/poddisruptionbudget2")
        .andReturn(200, new PodDisruptionBudgetBuilder().build()).once();

    PodDisruptionBudget podDisruptionBudget = client.policy().podDisruptionBudget().withName("poddisruptionbudget1").get();
    assertNotNull(podDisruptionBudget);

    podDisruptionBudget = client.policy().podDisruptionBudget().withName("poddisruptionbudget2").get();
    assertNull(podDisruptionBudget);

    podDisruptionBudget = client.policy().podDisruptionBudget().inNamespace("ns1").withName("poddisruptionbudget2").get();
    assertNotNull(podDisruptionBudget);
  }

  @Test
  public void testDelete() {
    server.expect().withPath("/apis/policy/v1beta1/namespaces/test/poddisruptionbudgets/poddisruptionbudget1")
        .andReturn(200, new PodDisruptionBudgetBuilder()
            .withNewMetadata().withName("poddisruptionbudget1").withNamespace("test").endMetadata()
            .withNewSpec()
            .withMaxUnavailable(new IntOrString("1%"))
            .withNewSelector()
            .withMatchLabels(Collections.singletonMap("app", "zookeeper"))
            .endSelector()
            .endSpec()
            .build())
        .once();

    boolean deleted = client.policy().podDisruptionBudget().withName("poddisruptionbudget1").delete().size() == 1;
    assertTrue(deleted);
  }

  @Test
  public void testDeleteWithNamespaceMismatch() {
    PodDisruptionBudget podDisruptionBudget1 = new PodDisruptionBudgetBuilder().withNewMetadata()
        .withName("podDisruptionBudget1").withNamespace("test").and().build();

    Boolean deleted = client.policy().podDisruptionBudget().inNamespace("test1").delete(podDisruptionBudget1).size() == 1;
    assertFalse(deleted);
  }

  @Test
  public void testCreateWithNameMismatch() {
    Assertions.assertThrows(KubernetesClientException.class, () -> {
      PodDisruptionBudget podDisruptionBudget1 = new PodDisruptionBudgetBuilder().withNewMetadata()
          .withName("podDisruptionBudget1").withNamespace("test").and().build();

      client.policy().podDisruptionBudget().inNamespace("test1").withName("mypodDisruptionBudget1")
          .create(podDisruptionBudget1);
    });
  }

  @Test
  public void testLoadFromFile() {
    assertNotNull(client.policy().podDisruptionBudget().load(getClass().getResourceAsStream("/test-pdb.yml")).item());
  }
}
