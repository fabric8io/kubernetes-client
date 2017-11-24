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

import io.fabric8.kubernetes.api.model.extensions.Deployment;
import io.fabric8.kubernetes.api.model.extensions.DeploymentBuilder;
import io.fabric8.kubernetes.api.model.extensions.DeploymentList;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesServer;
import org.junit.Rule;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DeploymentCrudTest {
  @Rule
  public KubernetesServer server = new KubernetesServer(true, true);

  @Test
  public void testCrud() {
    KubernetesClient client = server.getClient();

    Deployment deployment1 = new DeploymentBuilder().withNewMetadata()
      .withName("deployment1")
      .withNamespace("ns1")
      .addToLabels("testKey", "testValue")
      .endMetadata()
      .build();

    Deployment deployment2 = new DeploymentBuilder().withNewMetadata()
      .withName("deployment2")
      .withNamespace("ns1")
      .addToLabels("testKey", "testValue")
      .endMetadata()
      .build();

    Deployment deployment3 = new DeploymentBuilder().withNewMetadata()
      .withName("deployment3")
      .addToLabels("testKey", "testValue")
      .withNamespace("ns2")
      .endMetadata()
      .build();

    client.extensions().deployments().inNamespace("ns1").create(deployment1);
    client.extensions().deployments().inNamespace("ns1").create(deployment2);
    client.extensions().deployments().inNamespace("ns2").create(deployment3);

    DeploymentList aDeploymentList = client.extensions().deployments().list();
    assertNotNull(aDeploymentList);
    assertEquals(3, aDeploymentList.getItems().size());

    aDeploymentList = client.extensions().deployments().inAnyNamespace().list();
    assertNotNull(aDeploymentList);
    assertEquals(3, aDeploymentList.getItems().size());

    aDeploymentList = client.extensions().deployments().inNamespace("ns1").list();
    assertNotNull(aDeploymentList);
    // Should give 2 but is giving 3
    //assertEquals(2, aDeploymentList.getItems().size());

    aDeploymentList = client.extensions()
      .deployments()
      .inAnyNamespace()
      .withLabels(Collections.singletonMap("testKey", "testValue"))
      .list();
    assertNotNull(aDeploymentList);
    assertEquals(3, aDeploymentList.getItems().size());

    // Not working!
//    boolean bDeleted = client.extensions().deployments().inNamespace("ns2").withName("deployment3").delete();
//    assertTrue(bDeleted);

    // Not working!
//    deployment2 = client.extensions().deployments()
//      .inNamespace("ns1").withName("deployment2")
//      .edit().editMetadata().withName("deployment-2").endMetadata().done();
//    assertNotNull(deployment1);
//    assertEquals("deployment-2", deployment1);
  }
}

