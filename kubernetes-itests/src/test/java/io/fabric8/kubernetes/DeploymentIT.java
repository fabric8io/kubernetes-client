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
import org.junit.Test;
import org.junit.runner.RunWith;

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

  @Test
  public void testLoad() {
    String currentNamespace = session.getNamespace();
    Deployment aDeployment = client.extensions().deployments().inNamespace(currentNamespace).load(getClass().getResourceAsStream("/test-deployments.yml")).get();
    assertThat(aDeployment).isNotNull();
    assertEquals("nginx-deployment", aDeployment.getMetadata().getName());
  }

  @Test
  public void testCrud() throws InterruptedException {
    String currentNamespace = session.getNamespace();
    Deployment deployment1 = new DeploymentBuilder()
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
    Deployment deployment2 = new DeploymentBuilder()
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

    client.extensions().deployments().inNamespace(currentNamespace).create(deployment1);
    client.extensions().deployments().inNamespace(currentNamespace).create(deployment2);

    DeploymentList aDeploymentList = client.extensions().deployments().inNamespace(currentNamespace).list();
    assertThat(aDeploymentList).isNotNull();
    assertEquals(2, aDeploymentList.getItems().size());

    deployment1 = client.extensions().deployments().inNamespace(currentNamespace).withName("deployment1").edit()
      .editSpec().withReplicas(3).and().done();
    assertThat(deployment1).isNotNull();
    assertEquals(3, deployment1.getSpec().getReplicas().intValue());

    Thread.sleep(6000);
    boolean bDeleted = client.extensions().deployments().inNamespace(currentNamespace).delete();
    assertTrue(bDeleted);
  }
}
