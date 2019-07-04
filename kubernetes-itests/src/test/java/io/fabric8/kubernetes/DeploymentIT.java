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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

  private Deployment deployment1;

  private String currentNamespace;

  private static final Logger logger = LoggerFactory.getLogger(DeploymentIT.class);

  @Before
  public void init() {

    currentNamespace = session.getNamespace();

    client.apps().deployments().inNamespace(currentNamespace).delete();
    client.pods().inNamespace(currentNamespace).delete();

    deployment1 = new DeploymentBuilder()
      .withNewMetadata()
        .withName("deployment1")
        .addToLabels("test", "deployment")
      .endMetadata()
      .withNewSpec()
        .withReplicas(1)
        .withNewTemplate()
          .withNewMetadata()
          .addToLabels("app", "httpd")
          .endMetadata()
          .withNewSpec()
            .addNewContainer()
              .withName("busybox")
              .withImage("busybox")
              .withCommand("sleep","36000")
            .endContainer()
          .endSpec()
        .endTemplate()
        .withNewSelector()
          .addToMatchLabels("app","httpd")
        .endSelector()
      .endSpec()
      .build();

    client.apps().deployments().inNamespace(currentNamespace).create(deployment1);
  }

  @Test
  public void load() {

    Deployment aDeployment = client.apps().deployments().inNamespace(currentNamespace).load(getClass().getResourceAsStream("/test-deployments.yml")).get();
    assertThat(aDeployment).isNotNull();
    assertEquals("nginx-deployment", aDeployment.getMetadata().getName());
  }

  @Test
  public void get() {
    deployment1 = client.apps().deployments().inNamespace(currentNamespace)
      .withName("deployment1").get();
    assertNotNull(deployment1);
  }

  @Test
  public void list() {
    DeploymentList aDeploymentList = client.apps().deployments().inNamespace(currentNamespace).list();
    assertThat(aDeploymentList).isNotNull();
    assertEquals(1, aDeploymentList.getItems().size());
  }

  @Test
  public void update() {
    ReadyEntity<Deployment> deploymentReady = new ReadyEntity<>(Deployment.class, client, "deployment1", currentNamespace);
    deployment1 = client.apps().deployments().inNamespace(currentNamespace).withName("deployment1").edit()
      .editSpec().withReplicas(2).endSpec().done();
    await().atMost(30, TimeUnit.SECONDS).until(deploymentReady);
    assertThat(deployment1).isNotNull();
    assertEquals(2, deployment1.getSpec().getReplicas().intValue());
  }

  @Test
  public void delete() throws InterruptedException {
    // Usually creation, deletion of things like Deployments take some time. So let's wait for a while:
    // Wait for resources to get ready
    ReadyEntity<Deployment> deploymentReady = new ReadyEntity<>(Deployment.class, client, "deployment1", currentNamespace);
    await().atMost(30, TimeUnit.SECONDS).until(deploymentReady);
    assertTrue(client.apps().deployments().inNamespace(currentNamespace).delete(deployment1));
  }

  @Test
  public void waitTest() throws InterruptedException {
    // Wait for resources to get ready
    ReadyEntity<Deployment> deploymentReady = new ReadyEntity<>(Deployment.class, client, "deployment1", currentNamespace);
    await().atMost(30, TimeUnit.SECONDS).until(deploymentReady);
    Deployment deploymentOne = client.apps().deployments()
      .inNamespace(currentNamespace).withName("deployment1").get();
    assertTrue(Readiness.isDeploymentReady(deploymentOne));
  }

  @Test
  public void listFromServer() {
    ReadyEntity<Deployment> deploymentReady = new ReadyEntity<>(Deployment.class, client, "deployment1", currentNamespace);
    await().atMost(30, TimeUnit.SECONDS).until(deploymentReady);

    List<HasMetadata> resources = client.resourceList(deployment1).inNamespace(currentNamespace).fromServer().get();

    assertNotNull(resources);
    assertEquals(1, resources.size());
    assertNotNull(resources.get(0));

    HasMetadata fromServerPod = resources.get(0);

    assertEquals(deployment1.getKind(), fromServerPod.getKind());
    assertEquals(currentNamespace, fromServerPod.getMetadata().getNamespace());
    assertEquals(deployment1.getMetadata().getName(), fromServerPod.getMetadata().getName());
  }

  @After
  public void cleanup() throws InterruptedException {
    int attempts = 0;
    do {
      try {
        if (client.apps().deployments().inNamespace(currentNamespace).list().getItems().size() != 0) {
          client.apps().deployments().inNamespace(currentNamespace).delete();
        }
        // Wait for resources to get destroyed
        DeleteEntity<Deployment> deploymentDelete = new DeleteEntity<>(Deployment.class, client, "deployment1", currentNamespace);
        await().atMost(30, TimeUnit.SECONDS).until(deploymentDelete);
        return;
      } catch(NullPointerException exception) {
        attempts++;
        continue;
      }
    } while (attempts < 5);
  }
}
