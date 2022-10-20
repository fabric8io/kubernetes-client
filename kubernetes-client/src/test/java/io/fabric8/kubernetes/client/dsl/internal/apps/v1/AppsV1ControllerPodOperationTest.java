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
package io.fabric8.kubernetes.client.dsl.internal.apps.v1;

import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.api.model.apps.DeploymentBuilder;
import io.fabric8.kubernetes.api.model.apps.ReplicaSet;
import io.fabric8.kubernetes.api.model.apps.ReplicaSetBuilder;
import io.fabric8.kubernetes.api.model.apps.StatefulSet;
import io.fabric8.kubernetes.api.model.apps.StatefulSetBuilder;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AppsV1ControllerPodOperationTest {
  @Test
  void testDeploymentSelectorLabels() {
    // Given
    Deployment deployment = new DeploymentBuilder()
        .withNewSpec()
        .withNewTemplate()
        .withNewMetadata()
        .addToLabels("foo", "bar")
        .addToLabels("one", "two")
        .endMetadata()
        .endTemplate()
        .endSpec()
        .build();

    // When
    Map<String, String> labels = DeploymentOperationsImpl.getDeploymentSelectorLabels(deployment);

    // Then
    assertNotNull(labels);
    assertEquals(deployment.getSpec().getTemplate().getMetadata().getLabels().size(), labels.size());
    assertEquals("bar", labels.get("foo"));
    assertEquals("two", labels.get("one"));
  }

  @Test
  void testReplicaSetSelectorLabels() {
    // Given
    ReplicaSet replicaSet = new ReplicaSetBuilder()
        .withNewSpec()
        .withNewSelector()
        .addToMatchLabels("foo", "bar")
        .endSelector()
        .endSpec()
        .build();

    // When
    Map<String, String> labels = ReplicaSetOperationsImpl.getReplicaSetSelectorLabels(replicaSet);

    // Then
    assertNotNull(labels);
    assertEquals(replicaSet.getSpec().getSelector().getMatchLabels().size(), labels.size());
    assertEquals("bar", labels.get("foo"));
  }

  @Test
  void testStatefulSetSelectorLabels() {
    // Given
    StatefulSet statefulSet = new StatefulSetBuilder()
        .withNewSpec()
        .withNewTemplate()
        .withNewMetadata()
        .addToLabels("foo", "bar")
        .addToLabels("one", "two")
        .endMetadata()
        .endTemplate()
        .endSpec()
        .build();

    // When
    Map<String, String> labels = StatefulSetOperationsImpl.getStatefulSetSelectorLabels(statefulSet);

    // Then
    assertNotNull(labels);
    assertEquals(statefulSet.getSpec().getTemplate().getMetadata().getLabels().size(), labels.size());
    assertEquals("bar", labels.get("foo"));
    assertEquals("two", labels.get("one"));
  }
}
