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
package io.fabric8.openshift.client.dsl.internal.apps;

import io.fabric8.openshift.api.model.Build;
import io.fabric8.openshift.api.model.BuildBuilder;
import io.fabric8.openshift.api.model.DeploymentConfig;
import io.fabric8.openshift.api.model.DeploymentConfigBuilder;
import io.fabric8.openshift.client.dsl.internal.apps.DeploymentConfigOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.build.BuildOperationsImpl;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.fabric8.openshift.client.dsl.internal.build.BuildOperationsImpl.OPENSHIFT_IO_BUILD_NAME;
import static io.fabric8.openshift.client.dsl.internal.apps.DeploymentConfigOperationsImpl.OPENSHIFT_IO_DEPLOYMENT_CONFIG_NAME;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OpenShiftDeploymentConfigPodOperationTest {
  @Test
  void testDeploymentConfigSelectorLabels() {
    // Given
    DeploymentConfig deploymentConfig = new DeploymentConfigBuilder()
      .withNewMetadata().withName("dc1").endMetadata()
      .build();

    // When
    Map<String, String> labels = DeploymentConfigOperationsImpl.getDeploymentConfigPodLabels(deploymentConfig);

    // Then
    assertNotNull(labels);
    assertEquals(deploymentConfig.getMetadata().getName(), labels.get(OPENSHIFT_IO_DEPLOYMENT_CONFIG_NAME));
  }

}
