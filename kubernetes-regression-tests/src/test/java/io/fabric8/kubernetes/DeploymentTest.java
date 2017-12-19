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

import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.NamespaceBuilder;
import io.fabric8.kubernetes.api.model.extensions.Deployment;
import io.fabric8.kubernetes.api.model.extensions.DeploymentBuilder;
import io.fabric8.kubernetes.api.model.extensions.DeploymentList;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class DeploymentTest {
  public static KubernetesClient client;

  public static String currentNamespace;

  @BeforeClass
  public static void init() {
    client = new DefaultKubernetesClient();
    currentNamespace = "rt-" + RandomStringUtils.randomAlphanumeric(6).toLowerCase();
    Namespace aNamespace = new NamespaceBuilder().withNewMetadata().withName(currentNamespace).and().build();
    client.namespaces().create(aNamespace);
  }

  @AfterClass
  public static void cleanup() {
    client.namespaces().withName(currentNamespace).delete();
    client.close();
  }

  @Test
  public void testLoad() {
    Deployment aDeployment = client.extensions().deployments().inNamespace(currentNamespace).load(getClass().getResourceAsStream("/test-deployments.yml")).get();
    assertThat(aDeployment).isNotNull();
    assertEquals("nginx-deployment", aDeployment.getMetadata().getName());
  }

  @Test
  public void testCrud() {
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

    boolean bDeleted = client.extensions().deployments().inNamespace(currentNamespace).withName("deployment2").delete();
    assertTrue(bDeleted);
  }
}
