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
import io.fabric8.kubernetes.api.model.*;
import io.fabric8.kubernetes.client.KubernetesClient;
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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class ReplicationControllerIT {
  @ArquillianResource
  KubernetesClient client;

  @ArquillianResource
  Session session;

  @BeforeClass
  public static void init() {
    ClusterEntity.apply(ReplicationControllerIT.class.getResourceAsStream("/replicationcontroller-it.yml"));
  }

  @Test
  public void load() {
    ReplicationController aReplicationController = client.replicationControllers().inNamespace(session.getNamespace())
      .load(getClass().getResourceAsStream("/test-replicationcontroller.yml")).get();

    assertThat(aReplicationController).isNotNull();
    assertEquals("nginx", aReplicationController.getMetadata().getName());
    assertEquals(3, (int) aReplicationController.getSpec().getReplicas());
  }

  @Test
  public void get() {
    ReplicationController rc1 = client.replicationControllers().inNamespace(session.getNamespace()).withName("rc-get").get();
    assertNotNull(rc1);
  }

  @Test
  public void list() {
    ReplicationControllerList aRcList = client.replicationControllers().inNamespace(session.getNamespace()).list();
    assertThat(aRcList).isNotNull();
    assertTrue(aRcList.getItems().size() >= 1);
  }

  @Test
  public void update() {
    ReplicationController rc1 = client.replicationControllers().inNamespace(session.getNamespace()).withName("rc-update").scale(5);
    assertEquals(5, rc1.getSpec().getReplicas().intValue());
  }

  @Test
  public void delete() {
    assertTrue(client.replicationControllers().inNamespace(session.getNamespace()).withName("rc-delete").delete());
  }

  @AfterClass
  public static void cleanup() {
    ClusterEntity.remove(ReplicationControllerIT.class.getResourceAsStream("/replicationcontroller-it.yml"));
  }
}
