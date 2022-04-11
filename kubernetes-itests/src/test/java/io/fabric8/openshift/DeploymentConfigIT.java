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

import io.fabric8.commons.ReadyEntity;
import io.fabric8.jupiter.api.LoadKubernetesManifests;
import io.fabric8.jupiter.api.RequireK8sSupport;
import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.openshift.api.model.DeploymentConfig;
import io.fabric8.openshift.api.model.DeploymentConfigBuilder;
import io.fabric8.openshift.api.model.DeploymentConfigList;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RequireK8sSupport(DeploymentConfig.class)
@LoadKubernetesManifests("/deploymentconfig-it.yml")
class DeploymentConfigIT {

  OpenShiftClient client;

  Namespace namespace;

  @Test
  void load() {
    DeploymentConfig deploymentConfig = client.deploymentConfigs().inNamespace(namespace.getMetadata().getName())
      .load(getClass().getResourceAsStream("/test-deploymentconfig.yml")).get();
    assertThat(deploymentConfig).isNotNull();
    assertEquals("frontend", deploymentConfig.getMetadata().getName());
  }

  @Test
  void get() {
    assertNotNull(client.deploymentConfigs().inNamespace(namespace.getMetadata().getName()).withName("dc-get").get());
  }

  @Test
  void list() {
    DeploymentConfigList aDeploymentConfigList = client.deploymentConfigs().inNamespace(namespace.getMetadata().getName()).list();
    assertThat(aDeploymentConfigList).isNotNull();
    assertTrue(aDeploymentConfigList.getItems().size() >= 1);
  }

  @Test
  void update() {
    ReadyEntity<DeploymentConfig> deploymentConfigReady = new ReadyEntity<>(DeploymentConfig.class, client, "dc-update", namespace.getMetadata().getName());
    DeploymentConfig deploymentConfig1 = client.deploymentConfigs().inNamespace(namespace.getMetadata().getName()).withName("dc-update").edit(d -> new DeploymentConfigBuilder(d)
                                               .editSpec().withReplicas(3).endSpec().build());
    await().atMost(60, TimeUnit.SECONDS).until(deploymentConfigReady);
    assertThat(deploymentConfig1).isNotNull();
    assertEquals(3, deploymentConfig1.getSpec().getReplicas().intValue());
  }

  @Test
  void delete() {
    ReadyEntity<DeploymentConfig> deploymentConfigReady = new ReadyEntity<>(DeploymentConfig.class, client, "dc-delete", namespace.getMetadata().getName());
    await().atMost(30, TimeUnit.SECONDS).until(deploymentConfigReady);
    boolean bDeleted = client.deploymentConfigs().inNamespace(namespace.getMetadata().getName()).withName("dc-delete").delete();
    assertTrue(bDeleted);
  }

  @Test
  void createOrReplace() {
    // Given
    DeploymentConfig deploymentConfig = client.deploymentConfigs().inNamespace(namespace.getMetadata().getName()).withName("dc-createorreplace").get();

    // When
    deploymentConfig.getSpec().getTemplate().getSpec().getContainers().get(0).setImage("openshift/hello-openshift:v3.8");
    deploymentConfig = client.deploymentConfigs().inNamespace(namespace.getMetadata().getName()).createOrReplace(deploymentConfig);

    // Then
    assertNotNull(deploymentConfig);
    assertEquals("dc-createorreplace", deploymentConfig.getMetadata().getName());
    assertEquals("openshift/hello-openshift:v3.8", deploymentConfig.getSpec().getTemplate().getSpec().getContainers().get(0).getImage());
  }

}
