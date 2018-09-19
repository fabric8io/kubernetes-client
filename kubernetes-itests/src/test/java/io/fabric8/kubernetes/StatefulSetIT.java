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

package io.fabric8.kubernetes;

import io.fabric8.commons.DeleteEntity;
import io.fabric8.commons.ReadyEntity;
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.apps.StatefulSet;
import io.fabric8.kubernetes.api.model.apps.StatefulSetBuilder;
import io.fabric8.kubernetes.api.model.apps.StatefulSetList;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertNotNull;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class StatefulSetIT {
  @ArquillianResource
  KubernetesClient client;

  @ArquillianResource
  Session session;

  private StatefulSet ss1;

  private String currentNamespace;

  @Before
  public void init() {
    currentNamespace = session.getNamespace();
    ss1 = new StatefulSetBuilder()
      .withNewMetadata().withName("ss1").endMetadata()
      .withNewSpec()
      .withReplicas(2)
      .withNewSelector().withMatchLabels(Collections.singletonMap("app", "nginx")).endSelector()
      .withNewTemplate()
      .withNewMetadata()
      .addToLabels("app", "nginx")
      .endMetadata()
      .withNewSpec()
      .addNewContainer()
      .withName("nginx")
      .withImage("nginx")
      .addNewPort()
      .withContainerPort(80)
      .withName("web")
      .endPort()
      .addNewVolumeMount()
      .withName("www")
      .withMountPath("/usr/share/nginx/html")
      .endVolumeMount()
      .endContainer()
      .endSpec()
      .endTemplate()
      .addNewVolumeClaimTemplate()
      .withNewMetadata()
      .withName("www")
      .endMetadata()
      .withNewSpec()
      .addToAccessModes("ReadWriteOnce")
      .withNewResources()
      .withRequests(Collections.singletonMap("storage", new Quantity("1Gi")))
      .endResources()
      .endSpec()
      .endVolumeClaimTemplate()
      .endSpec()
      .build();

    client.apps().statefulSets().inNamespace(currentNamespace).create(ss1);
  }

  @Test
  public void load() {
    String currentNamespace = session.getNamespace();
    StatefulSet aStatefulSet = client.apps().statefulSets().inNamespace(currentNamespace)
      .load(getClass().getResourceAsStream("/test-statefulset.yml")).get();
    assertThat(aStatefulSet).isNotNull();
    assertEquals("web", aStatefulSet.getMetadata().getName());
  }

  @Test
  public void get() {
    ss1 = client.apps().statefulSets().inNamespace(currentNamespace).withName("ss1").get();
    assertNotNull(ss1);
  }

  @Test
  public void list() {
    StatefulSetList statefulSetList = client.apps().statefulSets().inNamespace(currentNamespace).list();
    assertThat(statefulSetList).isNotNull();
    assertEquals(1, statefulSetList.getItems().size());
  }

  @Test
  public void update() {
    ReadyEntity<StatefulSet> statefulSetReady = new ReadyEntity<>(StatefulSet.class, client, "ss1", currentNamespace);
    ss1 = client.apps().statefulSets().inNamespace(currentNamespace).withName("ss1").scale(5);
    await().atMost(30, TimeUnit.SECONDS).until(statefulSetReady);
    assertEquals(5, ss1.getSpec().getReplicas().intValue());
  }

  @Test
  public void delete() {
    ReadyEntity<StatefulSet> statefulSetReady = new ReadyEntity<>(StatefulSet.class, client, "ss1", currentNamespace);
    await().atMost(30, TimeUnit.SECONDS).until(statefulSetReady);
    boolean bDeleted = client.apps().statefulSets().inNamespace(currentNamespace).withName("ss1").delete();
    assertTrue(bDeleted);
  }

  @After
  public void cleanup() throws InterruptedException {
    if (client.apps().statefulSets().inNamespace(currentNamespace).list().getItems().size()!= 0) {
      client.apps().statefulSets().inNamespace(currentNamespace).delete();
    }
    // Wait for resources to get destroyed
    DeleteEntity<StatefulSet> statefulSetDelete = new DeleteEntity<>(StatefulSet.class, client, "ss1", currentNamespace);
    await().atMost(30, TimeUnit.SECONDS).until(statefulSetDelete);
  }
}
