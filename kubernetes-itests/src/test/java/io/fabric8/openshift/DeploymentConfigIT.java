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

import io.fabric8.openshift.api.model.*;
import io.fabric8.openshift.client.OpenShiftClient;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.openshift.impl.requirement.RequiresOpenshift;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(ArquillianConditionalRunner.class)
@RequiresOpenshift
public class DeploymentConfigIT {
  @ArquillianResource
  OpenShiftClient client;

  @ArquillianResource
  Session session;

  @Test
  public void testLoad() {
    String currentNamespace = session.getNamespace();
    DeploymentConfig deploymentConfig = client.deploymentConfigs().inNamespace(currentNamespace)
      .load(getClass().getResourceAsStream("/test-deploymentconfig.yml")).get();
    assertThat(deploymentConfig).isNotNull();
    assertEquals("frontend", deploymentConfig.getMetadata().getName());
  }

  @Test
  public void testCrud() {
    String currentNamespace = session.getNamespace();
    DeploymentConfig deploymentConfig1 = new DeploymentConfigBuilder()
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
    DeploymentConfig deploymentConfig2 = new DeploymentConfigBuilder()
      .withNewMetadata().withName("deploymentconfig2").endMetadata()
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

    client.deploymentConfigs().inNamespace(currentNamespace).create(deploymentConfig1);
    client.deploymentConfigs().inNamespace(currentNamespace).create(deploymentConfig2);

    DeploymentConfigList aDeploymentConfigList = client.deploymentConfigs().inNamespace(currentNamespace).list();
    assertThat(aDeploymentConfigList).isNotNull();
    assertEquals(2, aDeploymentConfigList.getItems().size());

    deploymentConfig1 = client.deploymentConfigs().inNamespace(currentNamespace).withName("deploymentconfig1").edit()
      .editSpec().withReplicas(3).endSpec().done();
    assertThat(deploymentConfig1).isNotNull();
    assertEquals(3, deploymentConfig1.getSpec().getReplicas().intValue());

    boolean bDeleted = client.deploymentConfigs().inNamespace(currentNamespace).withName("deploymentconfig2").delete();
    assertTrue(bDeleted);
  }
}
