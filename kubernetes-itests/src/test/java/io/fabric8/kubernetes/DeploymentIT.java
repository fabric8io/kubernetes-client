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
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.api.model.apps.DeploymentBuilder;
import io.fabric8.kubernetes.api.model.apps.DeploymentList;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.internal.readiness.Readiness;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.*;
import org.junit.runner.RunWith;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static org.junit.Assert.assertEquals;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class DeploymentIT {
  @ArquillianResource
  KubernetesClient client;

  @ArquillianResource
  Session session;

  @BeforeClass
  public static void init() {
    ClusterEntity.apply(DeploymentIT.class.getResourceAsStream("/deployment-it.yml"));
  }

  @Test
  public void load() {
    Deployment aDeployment = client.apps().deployments().inNamespace(session.getNamespace()).load(getClass().getResourceAsStream("/test-deployments.yml")).get();
    assertThat(aDeployment).isNotNull();
    assertEquals("nginx-deployment", aDeployment.getMetadata().getName());
  }

  @Test
  public void get() {
    Deployment deployment1 = client.apps().deployments().inNamespace(session.getNamespace())
      .withName("deployment-standard").get();
    assertNotNull(deployment1);
  }

  @Test
  public void list() {
    DeploymentList aDeploymentList = client.apps().deployments().inNamespace(session.getNamespace()).list();
    assertThat(aDeploymentList).isNotNull();
    assertTrue(aDeploymentList.getItems().size() >= 1);
  }

  @Test
  public void update() {
    Deployment deployment1 = client.apps().deployments().inNamespace(session.getNamespace()).withName("deployment-standard")
      .edit(d -> new DeploymentBuilder(d).editMetadata().addToAnnotations("updated", "true").endMetadata().build());
    assertThat(deployment1).isNotNull();
    assertEquals("true", deployment1.getMetadata().getAnnotations().get("updated"));
  }

  @Test
  public void waitTest() {
    // Wait for resources to get ready
    ReadyEntity<Deployment> deploymentReady = new ReadyEntity<>(Deployment.class, client, "deployment-wait", session.getNamespace());
    await().atMost(120, TimeUnit.SECONDS).until(deploymentReady);
    Deployment deploymentOne = client.apps().deployments()
      .inNamespace(session.getNamespace()).withName("deployment-wait").get();
    assertTrue(Readiness.getInstance().isDeploymentReady(deploymentOne));
  }

  @Test
  public void listFromServer() {
    Deployment deployment1 = client.apps().deployments().inNamespace(session.getNamespace()).withName("deployment-standard").get();
    List<HasMetadata> resources = client.resourceList(deployment1).inNamespace(session.getNamespace()).fromServer().get();

    assertNotNull(resources);
    assertEquals(1, resources.size());
    assertNotNull(resources.get(0));

    HasMetadata fromServerPod = resources.get(0);

    assertEquals(deployment1.getKind(), fromServerPod.getKind());
    assertEquals(session.getNamespace(), fromServerPod.getMetadata().getNamespace());
    assertEquals(deployment1.getMetadata().getName(), fromServerPod.getMetadata().getName());
  }

  @Test
  public void delete() {
    assertTrue(client.apps().deployments().inNamespace(session.getNamespace()).withName("deployment-delete").delete());
  }

  @AfterClass
  public static void cleanup() {
    ClusterEntity.remove(ClusterRoleBindingIT.class.getResourceAsStream("/deployment-it.yml"));
  }
}
