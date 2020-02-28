/**
 * Copyright (C) 2015 Fabric8 Authors.
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
package io.fabric8.openshift.client.server.mock;

import io.fabric8.openshift.api.model.DeploymentConfig;
import io.fabric8.openshift.api.model.DeploymentConfigBuilder;
import io.fabric8.openshift.api.model.DeploymentConfigList;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@EnableRuleMigrationSupport
public class DeploymentConfigCrudTest {
  @Rule
  public OpenShiftServer server = new OpenShiftServer(true, true);

  @Test
  public void testCrud() {
    OpenShiftClient client = server.getOpenshiftClient();

    DeploymentConfig deploymentConfig1 = new DeploymentConfigBuilder().withNewMetadata()
      .withName("deploymentConfig1")
      .withNamespace("ns1")
      .addToLabels("testKey", "testValue")
      .endMetadata()
      .build();

    DeploymentConfig deploymentConfig2 = new DeploymentConfigBuilder().withNewMetadata()
      .withName("deploymentConfig2")
      .withNamespace("ns1")
      .addToLabels("testKey", "testValue")
      .endMetadata()
      .build();

    DeploymentConfig deploymentConfig3 = new DeploymentConfigBuilder().withNewMetadata()
      .withName("deploymentConfig3")
      .addToLabels("testKey", "testValue")
      .withNamespace("ns2")
      .endMetadata()
      .build();

    client.deploymentConfigs().inNamespace("ns1").create(deploymentConfig1);
    client.deploymentConfigs().inNamespace("ns1").create(deploymentConfig2);
    client.deploymentConfigs().inNamespace("ns2").create(deploymentConfig3);

    DeploymentConfigList aDeploymentConfigList = client.deploymentConfigs().list();
    assertNotNull(aDeploymentConfigList);
    assertEquals(0, aDeploymentConfigList.getItems().size());

    aDeploymentConfigList = client.deploymentConfigs().inAnyNamespace().list();
    assertNotNull(aDeploymentConfigList);
    assertEquals(3, aDeploymentConfigList.getItems().size());

    aDeploymentConfigList = client.deploymentConfigs().inNamespace("ns1").list();
    assertNotNull(aDeploymentConfigList);
    assertEquals(2, aDeploymentConfigList.getItems().size());

    aDeploymentConfigList = client.deploymentConfigs().inNamespace("ns1")
      .withLabels(Collections.singletonMap("testKey", "testValue")).list();
    assertNotNull(aDeploymentConfigList);
    assertEquals(2, aDeploymentConfigList.getItems().size());

    deploymentConfig3 = client.deploymentConfigs().inNamespace("ns2").withName("deploymentConfig3").edit()
      .editMetadata().addToLabels("testkey1","testvalue2").endMetadata()
      .done();
    assertNotNull(deploymentConfig3);
    assertEquals(2, deploymentConfig3.getMetadata().getLabels().size());

    // ! Doesn't work
    // boolean bDeleted = client.deploymentConfigs().inNamespace("ns1").withName("deploymentConfig2").delete();
    // assertTrue(bDeleted);
  }
}
