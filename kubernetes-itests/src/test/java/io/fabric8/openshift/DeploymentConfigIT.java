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

import io.fabric8.junit.jupiter.api.LoadKubernetesManifests;
import io.fabric8.junit.jupiter.api.RequireK8sSupport;
import io.fabric8.openshift.api.model.DeploymentConfig;
import io.fabric8.openshift.api.model.DeploymentConfigList;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RequireK8sSupport(DeploymentConfig.class)
@LoadKubernetesManifests("/deploymentconfig-it.yml")
class DeploymentConfigIT {

  OpenShiftClient client;

  @Test
  void load() {
    DeploymentConfig deploymentConfig = client.deploymentConfigs()
        .load(getClass().getResourceAsStream("/test-deploymentconfig.yml")).item();
    assertThat(deploymentConfig).isNotNull();
    assertEquals("frontend", deploymentConfig.getMetadata().getName());
  }

  @Test
  void get() {
    assertNotNull(client.deploymentConfigs().withName("dc-get").get());
  }

  @Test
  void list() {
    DeploymentConfigList aDeploymentConfigList = client.deploymentConfigs().list();
    assertThat(aDeploymentConfigList).isNotNull();
    assertTrue(aDeploymentConfigList.getItems().size() >= 1);
  }

  @Test
  void update() {
    DeploymentConfig deploymentConfig1 = client.deploymentConfigs().withName("dc-update")
        .accept(dc -> {
          dc.getMetadata().setResourceVersion(null);
          dc.getMetadata().getAnnotations().put("new", "annotation");
        });
    assertThat(deploymentConfig1).isNotNull();
    assertEquals("annotation", deploymentConfig1.getMetadata().getAnnotations().get("new"));
  }

  @Test
  void scale() {
    DeploymentConfig result = client.deploymentConfigs().withName("dc-scale").scale(2);
    assertThat(result)
        .isNotNull()
        .hasFieldOrPropertyWithValue("spec.replicas", 2);
  }

  @Test
  void delete() {
    client.deploymentConfigs().withName("dc-delete").waitUntilCondition(Objects::nonNull, 30, TimeUnit.SECONDS);
    boolean bDeleted = client.deploymentConfigs().withName("dc-delete").delete().size() == 1;
    assertTrue(bDeleted);
  }

  @Test
  void createOrReplace() {
    // Given
    DeploymentConfig deploymentConfig = client.deploymentConfigs().withName("dc-createorreplace").get();

    // When
    deploymentConfig.getSpec().getTemplate().getSpec().getContainers().get(0).setImage("openshift/hello-openshift:v3.8");
    deploymentConfig = client.deploymentConfigs().createOrReplace(deploymentConfig);

    // Then
    assertNotNull(deploymentConfig);
    assertEquals("dc-createorreplace", deploymentConfig.getMetadata().getName());
    assertEquals("openshift/hello-openshift:v3.8",
        deploymentConfig.getSpec().getTemplate().getSpec().getContainers().get(0).getImage());
  }

}
