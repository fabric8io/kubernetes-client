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

import io.fabric8.kubernetes.api.model.*;
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

  private ReplicationController rc1;

  private String currentNamespace;

  @Before
  public void init() {
    currentNamespace = session.getNamespace();
    rc1 = new ReplicationControllerBuilder()
      .withNewMetadata().withName("nginx-controller").addToLabels("server", "nginx").endMetadata()
      .withNewSpec().withReplicas(3)
      .withNewTemplate()
      .withNewMetadata().addToLabels("server", "nginx").endMetadata()
      .withNewSpec()
      .addNewContainer().withName("nginx").withImage("nginx")
      .addNewPort().withContainerPort(80).endPort()
      .endContainer()
      .endSpec()
      .endTemplate()
      .endSpec().build();

    client.replicationControllers().inNamespace(currentNamespace).createOrReplace(rc1);
  }

  @Test
  public void load() {
    ReplicationController aReplicationController = client.replicationControllers().inNamespace(currentNamespace)
      .load(getClass().getResourceAsStream("/test-replicationcontroller.yml")).get();

    assertThat(aReplicationController).isNotNull();
    assertEquals("nginx", aReplicationController.getMetadata().getName());
    assertEquals(3, aReplicationController.getSpec().getReplicas().intValue());
  }

  @Test
  public void get() {
    rc1 = client.replicationControllers().inNamespace(currentNamespace).withName("nginx-controller").get();
    assertNotNull(rc1);
  }

  @Test
  public void list() {
    ReplicationControllerList aRcList = client.replicationControllers().inNamespace(currentNamespace).list();
    assertThat(aRcList).isNotNull();
    assertEquals(1, aRcList.getItems().size());
  }

  @Test
  public void update() {
    rc1 = client.replicationControllers().inNamespace(currentNamespace).withName("nginx-controller").scale(5);
    assertEquals(5, rc1.getSpec().getReplicas().intValue());
  }

  @Test
  public void delete() {
    assertTrue(client.replicationControllers().inNamespace(currentNamespace).withName("nginx-controller").delete());
  }

  @After
  public void cleanup() throws InterruptedException {
    client.replicationControllers().inNamespace(currentNamespace).delete();
    // Wait for resources to get destroyed
    Thread.sleep(30000);
  }
}
