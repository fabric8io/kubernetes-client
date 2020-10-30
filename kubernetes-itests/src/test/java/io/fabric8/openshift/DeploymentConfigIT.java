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

import io.fabric8.commons.ClusterEntity;
import io.fabric8.commons.ReadyEntity;
import io.fabric8.openshift.api.model.DeploymentConfig;
import io.fabric8.openshift.api.model.DeploymentConfigBuilder;
import io.fabric8.openshift.api.model.DeploymentConfigList;
import io.fabric8.openshift.client.OpenShiftClient;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.openshift.impl.requirement.RequiresOpenshift;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.BeforeClass;
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

  @BeforeClass
  public static void init() {
    ClusterEntity.apply(DeploymentConfigIT.class.getResourceAsStream("/deploymentconfig-it.yml"));
  }

  @Test
  public void load() {
    DeploymentConfig deploymentConfig = client.deploymentConfigs().inNamespace(session.getNamespace())
      .load(getClass().getResourceAsStream("/test-deploymentconfig.yml")).get();
    assertThat(deploymentConfig).isNotNull();
    assertEquals("frontend", deploymentConfig.getMetadata().getName());
  }

  @Test
  public void get() {
    assertNotNull(client.deploymentConfigs().inNamespace(session.getNamespace()).withName("dc-get").get());
  }

  @Test
  public void list() {
    DeploymentConfigList aDeploymentConfigList = client.deploymentConfigs().inNamespace(session.getNamespace()).list();
    assertThat(aDeploymentConfigList).isNotNull();
    assertTrue(aDeploymentConfigList.getItems().size() >= 1);
  }

  @Test
  public void update() {
    ReadyEntity<DeploymentConfig> deploymentConfigReady = new ReadyEntity<>(DeploymentConfig.class, client, "dc-update", session.getNamespace());
    DeploymentConfig deploymentConfig1 = client.deploymentConfigs().inNamespace(session.getNamespace()).withName("dc-update").edit(d -> new DeploymentConfigBuilder(d)
                                               .editSpec().withReplicas(3).endSpec().build());
    await().atMost(60, TimeUnit.SECONDS).until(deploymentConfigReady);
    assertThat(deploymentConfig1).isNotNull();
    assertEquals(3, deploymentConfig1.getSpec().getReplicas().intValue());
  }

  @Test
  public void delete() {
    ReadyEntity<DeploymentConfig> deploymentConfigReady = new ReadyEntity<>(DeploymentConfig.class, client, "dc-delete", session.getNamespace());
    await().atMost(30, TimeUnit.SECONDS).until(deploymentConfigReady);
    boolean bDeleted = client.deploymentConfigs().inNamespace(session.getNamespace()).withName("dc-delete").delete();
    assertTrue(bDeleted);
  }

  @Test
  public void createOrReplace() {
    // Given
    DeploymentConfig deploymentConfig = client.deploymentConfigs().inNamespace(session.getNamespace()).withName("dc-createorreplace").get();

    // When
    deploymentConfig.getSpec().getTemplate().getSpec().getContainers().get(0).setImage("openshift/hello-openshift:v3.8");
    deploymentConfig = client.deploymentConfigs().inNamespace(session.getNamespace()).createOrReplace(deploymentConfig);

    // Then
    assertNotNull(deploymentConfig);
    assertEquals("dc-createorreplace", deploymentConfig.getMetadata().getName());
    assertEquals("openshift/hello-openshift:v3.8", deploymentConfig.getSpec().getTemplate().getSpec().getContainers().get(0).getImage());
  }

}
