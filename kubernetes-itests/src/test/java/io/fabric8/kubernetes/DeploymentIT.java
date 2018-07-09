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

import io.fabric8.kubernetes.api.model.extensions.Deployment;
import io.fabric8.kubernetes.api.model.extensions.DeploymentBuilder;
import io.fabric8.kubernetes.api.model.extensions.DeploymentList;
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
    deployment1 = new DeploymentBuilder()
      .withNewMetadata().withName("deployment1").endMetadata()
      .withNewSpec()
      .withReplicas(1)
      .withNewTemplate()
      .withNewMetadata()
      .addToLabels("app", "httpd")
      .endMetadata()
      .withNewSpec()
      .addNewContainer()
      .withName("ruby-hello-world")
      .withImage("openshift/ruby-hello-world")
      .addNewPort()
      .withContainerPort(8080)
      .withProtocol("TCP")
      .endPort()
      .endContainer()
      .endSpec()
      .endTemplate()
      .endSpec()
      .build();

    client.extensions().deployments().inNamespace(currentNamespace).create(deployment1);
  }

  @Test
  public void load() {
    Deployment aDeployment = client.extensions().deployments().load(getClass().getResourceAsStream("/test-deployments.yml")).get();
    assertThat(aDeployment).isNotNull();
    assertEquals("nginx-deployment", aDeployment.getMetadata().getName());
  }

  @Test
  public void get() {
    deployment1 = client.extensions().deployments().inNamespace(currentNamespace)
      .withName("deployment1").get();
    assertNotNull(deployment1);
  }

  @Test
  public void list() {
    DeploymentList aDeploymentList = client.extensions().deployments().inNamespace(currentNamespace).list();
    assertThat(aDeploymentList).isNotNull();
    assertEquals(1, aDeploymentList.getItems().size());
  }

  @Test
  public void update() {
    deployment1 = client.extensions().deployments().inNamespace(currentNamespace).withName("deployment1").edit()
      .editSpec().withReplicas(2).endSpec().done();
    assertThat(deployment1).isNotNull();
    assertEquals(2, deployment1.getSpec().getReplicas().intValue());
  }

  @Test
  public void delete() throws InterruptedException {
    // Usually creation, deletion of things like Deployments take some time. So let's wait for a while:
    // Wait for resources to get ready
    DeploymentReady deploymentReady = new DeploymentReady(client, "deployment1", currentNamespace);
    await().atMost(30, TimeUnit.MINUTES).until(deploymentReady);
    assertTrue(client.extensions().deployments().inNamespace(currentNamespace).delete(deployment1));
  }

  @Test
  public void waitTest() throws InterruptedException {
    // Wait for resources to get ready
    DeploymentReady deploymentReady = new DeploymentReady(client, "deployment1", currentNamespace);
    await().atMost(30, TimeUnit.MINUTES).until(deploymentReady);
    Deployment deploymentOne = client.extensions().deployments()
      .inNamespace(currentNamespace).withName("deployment1").get();
    assertTrue(Readiness.isDeploymentReady(deploymentOne));
  }

  @After
  public void cleanup() throws InterruptedException {
    try {
      if (client.extensions().deployments().inNamespace(currentNamespace).list().getItems().size() != 0) {
        client.extensions().deployments().inNamespace(currentNamespace).delete();
      }
      // Wait for resources to get destroyed
      DeploymentDelete deploymentDelete = new DeploymentDelete(client, "deployment1", currentNamespace);
      await().atMost(30, TimeUnit.MINUTES).until(deploymentDelete);
    } catch (NullPointerException exception){
      cleanup();
    }
  }

}
