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

package io.fabric8.openshift;

import io.fabric8.commons.DeleteEntity;
import io.fabric8.commons.ReadyEntity;
import io.fabric8.openshift.api.model.DeploymentConfig;
import io.fabric8.openshift.api.model.DeploymentConfigBuilder;
import io.fabric8.openshift.api.model.DeploymentConfigList;
import io.fabric8.openshift.client.OpenShiftClient;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.openshift.impl.requirement.RequiresOpenshift;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static org.junit.Assert.assertEquals;

@RunWith(ArquillianConditionalRunner.class)
@RequiresOpenshift
public class DeploymentConfigIT {
  @ArquillianResource
  OpenShiftClient client;

  @ArquillianResource
  Session session;

  private DeploymentConfig deploymentConfig1;

  private String currentNamespace;

  @Before
  public void init() {
    currentNamespace = session.getNamespace();
    deploymentConfig1 = new DeploymentConfigBuilder()
      .withNewMetadata().withName("deploymentconfig1").endMetadata()
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

    client.deploymentConfigs().inNamespace(currentNamespace).create(deploymentConfig1);
  }

  @Test
  public void load() {
    DeploymentConfig deploymentConfig = client.deploymentConfigs().inNamespace(currentNamespace)
      .load(getClass().getResourceAsStream("/test-deploymentconfig.yml")).get();
    assertThat(deploymentConfig).isNotNull();
    assertEquals("frontend", deploymentConfig.getMetadata().getName());
  }

  @Test
  public void get() {
    assertNotNull(client.deploymentConfigs().inNamespace(currentNamespace).withName("deploymentconfig1").get());
  }

  @Test
  public void list() {
    DeploymentConfigList aDeploymentConfigList = client.deploymentConfigs().inNamespace(currentNamespace).list();
    assertThat(aDeploymentConfigList).isNotNull();
    assertEquals(1, aDeploymentConfigList.getItems().size());
  }

  @Test
  public void update() {
    ReadyEntity<DeploymentConfig> deploymentConfigReady = new ReadyEntity<>(DeploymentConfig.class, client, "deploymentconfig1", currentNamespace);
    deploymentConfig1 = client.deploymentConfigs().inNamespace(currentNamespace).withName("deploymentconfig1").edit()
      .editSpec().withReplicas(3).endSpec().done();
    await().atMost(60, TimeUnit.SECONDS).until(deploymentConfigReady);
    assertThat(deploymentConfig1).isNotNull();
    assertEquals(3, deploymentConfig1.getSpec().getReplicas().intValue());
  }

  @Test
  public void delete() throws InterruptedException {
    ReadyEntity<DeploymentConfig> deploymentConfigReady = new ReadyEntity<>(DeploymentConfig.class, client, "deploymentconfig1", currentNamespace);
    await().atMost(30, TimeUnit.SECONDS).until(deploymentConfigReady);
    boolean bDeleted = client.deploymentConfigs().inNamespace(currentNamespace).withName("deploymentconfig1").delete();
    assertTrue(bDeleted);
  }

  @After
  public void cleanup() throws InterruptedException {
    client.deploymentConfigs().inNamespace(currentNamespace).delete();

    DeleteEntity<DeploymentConfig> deploymentConfigDelete = new DeleteEntity<>(DeploymentConfig.class, client, "deploymentconfig1", currentNamespace);
    await().atMost(90, TimeUnit.SECONDS).until(deploymentConfigDelete);
  }
}
