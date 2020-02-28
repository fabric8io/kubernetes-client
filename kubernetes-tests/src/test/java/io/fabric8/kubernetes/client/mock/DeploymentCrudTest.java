/**
 * Copyright (C) 2015 Fabric8 Authors.
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

import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.api.model.apps.DeploymentBuilder;
import io.fabric8.kubernetes.api.model.apps.DeploymentList;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesServer;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@EnableRuleMigrationSupport
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
      .withNewSpec()
      .endSpec()
      .build();

    Deployment deployment2 = new DeploymentBuilder().withNewMetadata()
      .withName("deployment2")
      .withNamespace("ns1")
      .addToLabels("testKey", "testValue")
      .endMetadata()
      .withNewSpec()
      .endSpec()
      .build();

    Deployment deployment3 = new DeploymentBuilder().withNewMetadata()
      .withName("deployment3")
      .addToLabels("testKey", "testValue")
      .withNamespace("ns2")
      .endMetadata()
      .withNewSpec()
      .endSpec()
      .build();

    client.apps().deployments().inNamespace("ns1").create(deployment1);
    client.apps().deployments().inNamespace("ns1").create(deployment2);
    client.apps().deployments().inNamespace("ns2").create(deployment3);

    DeploymentList aDeploymentList = client.apps().deployments().inAnyNamespace().list();
    assertNotNull(aDeploymentList);
    assertEquals(3, aDeploymentList.getItems().size());

    aDeploymentList = client.apps().deployments().inNamespace("ns1").list();
    assertNotNull(aDeploymentList);
    assertEquals(2, aDeploymentList.getItems().size());

    aDeploymentList = client.apps()
      .deployments()
      .inAnyNamespace()
      .withLabels(Collections.singletonMap("testKey", "testValue"))
      .list();
    assertNotNull(aDeploymentList);
    assertEquals(3, aDeploymentList.getItems().size());


    boolean bDeleted = client.apps().deployments().inNamespace("ns2").withName("deployment3").delete();
    assertTrue(bDeleted);


    deployment2 = client.apps().deployments()
      .inNamespace("ns1").withName("deployment2").edit()
      .editMetadata().addToLabels("key1", "value1").endMetadata().done();
    assertNotNull(deployment2);
    assertEquals("value1", deployment2.getMetadata().getLabels().get("key1"));
  }
}

