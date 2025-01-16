/*
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

import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.api.model.apps.DeploymentBuilder;
import io.fabric8.kubernetes.api.model.apps.DeploymentList;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.FilterWatchListDeletable;
import io.fabric8.kubernetes.client.dsl.RollableScalableResource;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableKubernetesMockClient(crud = true)
class DeploymentCrudTest {

  KubernetesClient client;

  @Test
  void testCrud() {

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

    FilterWatchListDeletable<Deployment, DeploymentList, RollableScalableResource<Deployment>> withLabels = client.apps()
        .deployments()
        .inAnyNamespace()
        .withLabels(Collections.singletonMap("testKey", "testValue"));
    aDeploymentList = withLabels.list();
    assertNotNull(aDeploymentList);
    assertEquals(3, aDeploymentList.getItems().size());

    assertEquals(3, withLabels.resources().count());

    boolean bDeleted = client.apps().deployments().inNamespace("ns2").withName("deployment3").delete().size() == 1;
    assertTrue(bDeleted);

    deployment2 = client.apps().deployments()
        .inNamespace("ns1").withName("deployment2").edit(d -> new DeploymentBuilder(d)
            .editMetadata().addToLabels("key1", "value1").endMetadata()
            .build());

    assertNotNull(deployment2);
    assertEquals("value1", deployment2.getMetadata().getLabels().get("key1"));
  }

  @Test
  @DisplayName("Should replace Deployment in CRUD server")
  void testReplace() {
    // Given
    Deployment deployment1 = new DeploymentBuilder().withNewMetadata()
        .withName("d1")
        .withNamespace("ns1")
        .addToLabels("testKey", "testValue")
        .endMetadata()
        .withNewSpec()
        .endSpec()
        .build();
    deployment1 = client.apps().deployments().inNamespace("ns1").create(deployment1);

    // When
    deployment1.getMetadata().getLabels().put("testKey", "one");
    client.apps().deployments().inNamespace("ns1").withName("d1").replace(deployment1);
    Deployment replacedDeployment = client.apps().deployments().inNamespace("ns1").withName("d1").get();

    // Then
    assertNotNull(replacedDeployment);
    assertFalse(replacedDeployment.getMetadata().getLabels().isEmpty());
    assertEquals("one", replacedDeployment.getMetadata().getLabels().get("testKey"));
  }

  @Test
  @DisplayName("Should pause resource")
  void testPause() {
    // Given
    Deployment deployment1 = new DeploymentBuilder().withNewMetadata()
        .withName("d1")
        .withNamespace("ns1")
        .addToLabels("testKey", "testValue")
        .endMetadata()
        .withNewSpec()
        .endSpec()
        .build();
    client.apps().deployments().inNamespace("ns1").create(deployment1);

    // When
    client.apps()
        .deployments()
        .inNamespace("ns1")
        .withName("d1")
        .rolling()
        .pause();
    Deployment updatedDeployment = client.apps().deployments().inNamespace("ns1").withName("d1").get();

    // Then
    assertNotNull(updatedDeployment);
    assertEquals(true, updatedDeployment.getSpec().getPaused());
  }

  @Test
  @DisplayName("Should resume rollout")
  void testRolloutResume() throws InterruptedException {
    // Given
    Deployment deployment1 = new DeploymentBuilder().withNewMetadata()
        .withName("d1")
        .withNamespace("ns1")
        .addToLabels("testKey", "testValue")
        .endMetadata()
        .withNewSpec()
        .withPaused(true)
        .endSpec()
        .build();
    client.apps().deployments().inNamespace("ns1").create(deployment1);

    // When
    client.apps()
        .deployments()
        .inNamespace("ns1")
        .withName("d1")
        .rolling()
        .resume();
    Deployment updatedDeployment = client.apps().deployments().inNamespace("ns1").withName("d1").get();

    // Then
    assertNotNull(updatedDeployment);
    assertNull(updatedDeployment.getSpec().getPaused());
  }

  @Test
  @DisplayName("Should restart rollout")
  void testRolloutRestart() throws InterruptedException {
    // Given
    Deployment deployment1 = new DeploymentBuilder().withNewMetadata()
        .withName("d1")
        .withNamespace("ns1")
        .addToLabels("testKey", "testValue")
        .endMetadata()
        .withNewSpec()
        .withNewTemplate()
        .withNewMetadata()
        .addToAnnotations("", "")
        .endMetadata()
        .endTemplate()
        .endSpec()
        .build();
    client.apps().deployments().inNamespace("ns1").create(deployment1);

    // When
    client.apps()
        .deployments()
        .inNamespace("ns1")
        .withName("d1")
        .rolling()
        .restart();
    Deployment updatedDeployment = client.apps().deployments().inNamespace("ns1").withName("d1").get();

    // Then
    assertNotNull(updatedDeployment);
    assertNotNull(
        updatedDeployment.getSpec().getTemplate().getMetadata().getAnnotations().get("kubectl.kubernetes.io/restartedAt"));
  }
}
