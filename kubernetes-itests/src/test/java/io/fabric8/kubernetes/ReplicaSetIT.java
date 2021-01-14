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
import io.fabric8.kubernetes.api.model.apps.ReplicaSet;
import io.fabric8.kubernetes.api.model.apps.ReplicaSetBuilder;
import io.fabric8.kubernetes.api.model.apps.ReplicaSetList;
import io.fabric8.kubernetes.client.KubernetesClient;
import java.util.concurrent.TimeUnit;

import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertNotNull;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class ReplicaSetIT {
  @ArquillianResource
  KubernetesClient client;

  @ArquillianResource
  Session session;

  @BeforeClass
  public static void init() {
    ClusterEntity.apply(ReplicaSetIT.class.getResourceAsStream("/replicaset-it.yml"));
  }

  @Test
  public void load() {
    ReplicaSet replicaSet = client.apps().replicaSets().inNamespace(session.getNamespace())
      .load(getClass().getResourceAsStream("/test-replicaset.yml")).get();
    assertThat(replicaSet).isNotNull();
    assertEquals("frontend", replicaSet.getMetadata().getName());
  }

  @Test
  public void get() {
    ReplicaSet replicaset1 = client.apps().replicaSets().inNamespace(session.getNamespace()).withName("replicaset-get").get();
    assertNotNull(replicaset1);
  }

  @Test
  public void list() {
    ReplicaSetList replicaSetList = client.apps().replicaSets().inNamespace(session.getNamespace()).list();
    assertThat(replicaSetList).isNotNull();
    assertTrue(replicaSetList.getItems().size() >= 1);
  }

  @Test
  public void update() {
    ReadyEntity<ReplicaSet> replicaSetReady = new ReadyEntity<>(ReplicaSet.class, client, "replicaset-update", session.getNamespace());
    await().atMost(30, TimeUnit.SECONDS).until(replicaSetReady);

    ReplicaSet replicaset1 = client.apps().replicaSets().inNamespace(session.getNamespace()).withName("replicaset-update").edit(r -> new ReplicaSetBuilder(r)
                        .editSpec().withReplicas(2).endSpec().build());
    assertThat(replicaset1).isNotNull();
    assertEquals(2, replicaset1.getSpec().getReplicas().intValue());
  }

  @Test
  public void delete() {
    ReadyEntity<ReplicaSet> replicaSetReady = new ReadyEntity<>(ReplicaSet.class, client, "replicaset-delete", session.getNamespace());
    await().atMost(30, TimeUnit.SECONDS).until(replicaSetReady);
    boolean bDeleted = client.apps().replicaSets().inNamespace(session.getNamespace()).withName("replicaset-delete").delete();
    assertTrue(bDeleted);
  }

  @AfterClass
  public static void cleanup() {
    ClusterEntity.remove(ReplicaSetIT.class.getResourceAsStream("/replicaset-it.yml"));
  }
}
