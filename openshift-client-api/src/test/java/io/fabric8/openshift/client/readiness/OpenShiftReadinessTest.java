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
package io.fabric8.openshift.client.readiness;

import io.fabric8.kubernetes.client.readiness.Readiness;
import io.fabric8.openshift.api.model.DeploymentConfig;
import io.fabric8.openshift.api.model.DeploymentConfigBuilder;
import io.fabric8.openshift.api.model.ImageStreamBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OpenShiftReadinessTest {

  private Readiness readiness;

  @BeforeEach
  void setUp() {
    readiness = OpenShiftReadiness.getInstance();
  }

  @Test
  void testOpenShiftReadinessWithDeploymentConfig() {
    DeploymentConfig dc = new DeploymentConfigBuilder()
        .withNewSpec().withReplicas(2).endSpec()
        .withNewStatus().withAvailableReplicas(2).withReplicas(2).endStatus()
        .build();

    assertTrue(readiness.isReady(dc));
  }

  @Test
  void testOpenShiftReadinessWithNonReadinessApplicableResource() {
    assertTrue(readiness.isReady(new ImageStreamBuilder().withNewMetadata().withName("is1").endMetadata().build()));
  }

  @Test
  void testOpenShiftReadinessWithNullResource() {
    assertFalse(readiness.isReady(null));
  }
}
