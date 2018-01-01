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
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class DeploymentIT {
  @ArquillianResource
  KubernetesClient client;

  @ArquillianResource
  Session session;

  private Deployment deployment1, deployment2;

  private String currentNamespace;

  @Before
  public void init() {
    currentNamespace = session.getNamespace();
    deployment1 = new DeploymentBuilder()
      .withNewMetadata().withName("deployment1").endMetadata()
      .withNewSpec()
      .withReplicas(2)
      .withNewTemplate()
      .withNewMetadata()
      .addToLabels("app", "database")
      .endMetadata()
      .withNewSpec()
      .addNewContainer()
      .withName("mysql")
      .withImage("openshift/mysql-55-centos7")
      .endContainer()
      .endSpec()
      .endTemplate()
      .endSpec()
      .build();
    deployment2 = new DeploymentBuilder()
      .withNewMetadata().withName("deployment2").endMetadata()
      .withNewSpec()
      .withReplicas(1)
      .withNewTemplate()
      .withNewMetadata()
      .addToLabels("name", "frontend")
      .endMetadata()
      .withNewSpec()
      .addNewContainer()
      .withName("helloworld")
      .withImage("openshift/origin-ruby-sample")
      .addNewPort()
      .withContainerPort(8080)
      .endPort()
      .endContainer()
      .endSpec()
      .endTemplate()
      .endSpec()
      .build();

    client.extensions().deployments().inNamespace(currentNamespace).createOrReplace(deployment1);
    client.extensions().deployments().inNamespace(currentNamespace).createOrReplace(deployment2);
  }

  @Test
  public void create() {
    Deployment aDeployment = client.extensions().deployments().inNamespace(currentNamespace).load(getClass().getResourceAsStream("/test-deployments.yml")).get();
    assertThat(aDeployment).isNotNull();
    assertEquals("nginx-deployment", aDeployment.getMetadata().getName());
  }

  @Test
  public void get() {
    deployment1 = client.extensions().deployments().inNamespace(currentNamespace)
      .withName("deployment1").get();
    assertNotNull(deployment1);
    deployment2 = client.extensions().deployments().inNamespace(currentNamespace)
      .withName("deployment2").get();
    assertNotNull(deployment2);
  }

  @Test
  public void list() {
    DeploymentList aDeploymentList = client.extensions().deployments().inNamespace(currentNamespace).list();
    assertThat(aDeploymentList).isNotNull();
    assertEquals(2, aDeploymentList.getItems().size());
  }

  @Test
  public void update() {
    deployment1 = client.extensions().deployments().inNamespace(currentNamespace).withName("deployment1").edit()
      .editSpec().withReplicas(3).and().done();
    assertThat(deployment1).isNotNull();
    assertEquals(3, deployment1.getSpec().getReplicas().intValue());
  }

  @Test
  public void delete() throws InterruptedException {
    // Usually creation, deletion of things like Deployments take some time. So let's wait for a while:
    Thread.sleep(6000);
    assertTrue(client.extensions().deployments().inNamespace(currentNamespace).delete());
  }

  @After
  public void cleanup() throws InterruptedException {
    Thread.sleep(6000);
    client.extensions().deployments().inNamespace(currentNamespace).delete();
  }
}
