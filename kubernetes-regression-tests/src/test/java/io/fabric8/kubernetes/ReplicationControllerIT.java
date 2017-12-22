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
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Collections;

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

  @Test
  public void testLoad() {
    String currentNamespace = session.getNamespace();
    ReplicationController aReplicationController = client.replicationControllers().inNamespace(currentNamespace)
      .load(getClass().getResourceAsStream("/test-replicationcontroller.yml")).get();

    assertThat(aReplicationController).isNotNull();
    assertEquals("nginx", aReplicationController.getMetadata().getName());
    assertEquals(3, aReplicationController.getSpec().getReplicas().intValue());
  }

  @Test
  public void testCrud() {
    String currentNamespace = session.getNamespace();
    ReplicationController rc1 = new ReplicationControllerBuilder()
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
    ReplicationController rc2 = new ReplicationControllerBuilder()
      .withNewMetadata().withName("frontend").endMetadata()
      .withNewSpec()
      .withReplicas(1)
      .withSelector(Collections.singletonMap("name", "frontend"))
      .withNewTemplate()
      .withNewMetadata().addToLabels("name", "frontend").endMetadata()
      .withNewSpec()
      .addNewContainer().withName("helloworld").withImage("openshift/hello-openshift")
      .addNewPort().withContainerPort(8080).withProtocol("TCP").endPort()
      .endContainer()
      .withRestartPolicy("Always")
      .endSpec()
      .endTemplate()
      .endSpec()
      .build();

    client.replicationControllers().inNamespace(currentNamespace).create(rc1);
    client.replicationControllers().inNamespace(currentNamespace).create(rc2);

    ReplicationControllerList aRcList = client.replicationControllers().inNamespace(currentNamespace).list();
    assertThat(aRcList).isNotNull();
    assertEquals(2, aRcList.getItems().size());

    rc1 = client.replicationControllers().inNamespace(currentNamespace).withName("nginx-controller").scale(5);
    assertEquals(5, rc1.getSpec().getReplicas().intValue());

    boolean bDeleted = client.replicationControllers().inNamespace(currentNamespace).withName("nginx-controller").delete();
    assertTrue(bDeleted);
    bDeleted = client.replicationControllers().inNamespace(currentNamespace).withName("frontend").delete();
    assertTrue(bDeleted);
  }
}
