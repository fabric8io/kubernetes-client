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

import io.fabric8.commons.ClusterEntity;
import io.fabric8.commons.ReadyEntity;
import io.fabric8.kubernetes.api.model.apps.StatefulSet;
import io.fabric8.kubernetes.api.model.apps.StatefulSetList;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

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

  @BeforeClass
  public static void init() {
    ClusterEntity.apply(StatefulSetIT.class.getResourceAsStream("/statefulset-it.yml"));
  }

  @Test
  public void load() {
    StatefulSet aStatefulSet = client.apps().statefulSets().inNamespace(session.getNamespace())
      .load(getClass().getResourceAsStream("/test-statefulset.yml")).get();
    assertThat(aStatefulSet).isNotNull();
    assertEquals("web", aStatefulSet.getMetadata().getName());
  }

  @Test
  public void get() {
    StatefulSet ss1 = client.apps().statefulSets().inNamespace(session.getNamespace()).withName("ss-get").get();
    assertNotNull(ss1);
  }

  @Test
  public void list() {
    StatefulSetList statefulSetList = client.apps().statefulSets().inNamespace(session.getNamespace()).list();
    assertThat(statefulSetList).isNotNull();
    assertTrue(statefulSetList.getItems().size() >= 1);
  }

  @Test
  public void update() {
    ReadyEntity<StatefulSet> statefulSetReady = new ReadyEntity<>(StatefulSet.class, client, "ss-update", session.getNamespace());
    StatefulSet ss1 = client.apps().statefulSets().inNamespace(session.getNamespace()).withName("ss-update").scale(5);
    await().atMost(30, TimeUnit.SECONDS).until(statefulSetReady);
    assertEquals(5, ss1.getSpec().getReplicas().intValue());
  }

  @Test
  public void delete() {
    ReadyEntity<StatefulSet> statefulSetReady = new ReadyEntity<>(StatefulSet.class, client, "ss-delete", session.getNamespace());
    await().atMost(30, TimeUnit.SECONDS).until(statefulSetReady);
    boolean bDeleted = client.apps().statefulSets().inNamespace(session.getNamespace()).withName("ss-delete ").delete();
    assertTrue(bDeleted);
  }

  @AfterClass
  public static void cleanup() {
    ClusterEntity.remove(StatefulSetIT.class.getResourceAsStream("/statefulset-it.yml"));
  }

}
