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
package io.fabric8.kubernetes.client.readiness;

import io.fabric8.kubernetes.api.model.ServiceBuilder;
import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.api.model.apps.DeploymentBuilder;
import io.fabric8.kubernetes.api.model.apps.StatefulSet;
import io.fabric8.kubernetes.api.model.apps.StatefulSetSpec;
import io.fabric8.kubernetes.api.model.apps.StatefulSetStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ReadinessTest {

  private Readiness readiness;

  @BeforeEach
  void setUp() {
    readiness = Readiness.getInstance();
  }

  @Test
  void testStatefulSetReadinessNoSpecNoStatus() {
    StatefulSet statefulSet = new StatefulSet();
    assertFalse(readiness.isReady(statefulSet));
    assertFalse(Readiness.isStatefulSetReady(statefulSet));
  }

  @Test
  void testStatefulSetReadinessNoSpec() {
    StatefulSetStatus status = new StatefulSetStatus();

    StatefulSet statefulSet = new StatefulSet();
    statefulSet.setStatus(status);

    assertFalse(readiness.isReady(statefulSet));
    assertFalse(Readiness.isStatefulSetReady(statefulSet));

    status.setReadyReplicas(1);

    assertFalse(readiness.isReady(statefulSet));
    assertFalse(Readiness.isStatefulSetReady(statefulSet));
  }

  @Test
  void testStatefulSetReadinessNoStatus() {
    StatefulSetSpec spec = new StatefulSetSpec();
    spec.setReplicas(1);

    StatefulSet statefulSet = new StatefulSet();
    statefulSet.setSpec(spec);

    assertFalse(readiness.isReady(statefulSet));
    assertFalse(Readiness.isStatefulSetReady(statefulSet));

  }

  @Test
  void testStatefulSetReadinessNotEnoughReadyReplicas() {
    StatefulSetStatus status = new StatefulSetStatus();
    status.setReadyReplicas(1);
    status.setReplicas(2);

    StatefulSetSpec spec = new StatefulSetSpec();
    spec.setReplicas(2);

    StatefulSet statefulSet = new StatefulSet();
    statefulSet.setStatus(status);
    statefulSet.setSpec(spec);

    assertFalse(readiness.isReady(statefulSet));
    assertFalse(Readiness.isStatefulSetReady(statefulSet));
  }

  @Test
  void testStatefulSetReadiness() {
    StatefulSetStatus status = new StatefulSetStatus();
    status.setReadyReplicas(2);
    status.setReplicas(2);

    StatefulSetSpec spec = new StatefulSetSpec();
    spec.setReplicas(2);

    StatefulSet statefulSet = new StatefulSet();
    statefulSet.setStatus(status);
    statefulSet.setSpec(spec);

    assertTrue(readiness.isReady(statefulSet));
    assertTrue(Readiness.isStatefulSetReady(statefulSet));
  }

  @Test
  void testReadinessWithNonNullResource() {
    assertTrue(readiness.isReady(new ServiceBuilder().withNewMetadata().withName("svc1").endMetadata().build()));
  }

  @Test
  void testReadinessNullResource() {
    assertFalse(readiness.isReady(null));
  }

  @Test
  void testDeploymentWithNoReplicas() {
    Deployment d = new DeploymentBuilder().withNewSpec().withReplicas(0).endSpec().build();

    assertTrue(readiness.isReady(d));
  }
}
