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
package io.fabric8.kubernetes.client.dsl.internal.core.v1;

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.PodSpec;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.internal.OperationContext;
import io.fabric8.kubernetes.client.dsl.internal.PodOperationContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PodOperationsImplTest {

  private PodOperationsImpl podOperations;

  @BeforeEach
  void setUp() {
    podOperations = new PodOperationsImpl(new PodOperationContext(), new OperationContext());
  }

  @Test
  void validateOrDefaultContainerIdDefaultName() {
    // use first container
    Pod pod = new PodBuilder()
        .withNewMetadata()
        .withName("pod-1")
        .endMetadata()
        .withNewSpec()
        .addNewContainer()
        .withName("a")
        .endContainer()
        .addNewContainer()
        .withName("b")
        .endContainer()
        .endSpec()
        .build();
    assertEquals("a", podOperations.validateOrDefaultContainerId(null, pod));

    // use annotated default container
    pod = new PodBuilder(pod)
        .editMetadata()
        .addToAnnotations(PodOperationsImpl.DEFAULT_CONTAINER_ANNOTATION_NAME, "b")
        .endMetadata()
        .build();
    assertEquals("b", podOperations.validateOrDefaultContainerId(null, pod));

    // fallback to first container if default not found
    pod = new PodBuilder(pod)
        .editMetadata()
        .addToAnnotations(PodOperationsImpl.DEFAULT_CONTAINER_ANNOTATION_NAME, "c")
        .endMetadata()
        .build();
    assertEquals("a", podOperations.validateOrDefaultContainerId(null, pod));
  }

  @Test
  void validateOrDefaultContainerIdDefaultNameEmptyContainers() {
    Pod pod = new Pod();
    // null spec
    assertThrows(KubernetesClientException.class, () -> podOperations.validateOrDefaultContainerId(null, pod));

    // null containers
    pod.setSpec(new PodSpec());
    pod.getSpec().setContainers(null);
    assertThrows(KubernetesClientException.class, () -> podOperations.validateOrDefaultContainerId(null, pod));

    // empty containers
    pod.setSpec(new PodSpec());
    assertThrows(KubernetesClientException.class, () -> podOperations.validateOrDefaultContainerId(null, pod));
  }

  @Test
  void validateOrDefaultContainerIdByName() {
    Pod pod = new PodBuilder()
        .withNewMetadata()
        .withName("pod-1")
        .endMetadata()
        .withNewSpec()
        .addNewInitContainer()
        .withName("a")
        .endInitContainer()
        .addNewContainer()
        .withName("b")
        .endContainer()
        .addNewEphemeralContainer()
        .withName("c")
        .endEphemeralContainer()
        .endSpec()
        .build();

    assertEquals("a", podOperations.validateOrDefaultContainerId("a", pod));
    assertEquals("b", podOperations.validateOrDefaultContainerId("b", pod));
    assertEquals("c", podOperations.validateOrDefaultContainerId("c", pod));
    assertThrows(KubernetesClientException.class, () -> podOperations.validateOrDefaultContainerId("d", pod));
  }

  @Test
  void validateOrDefaultContainerIdByNameEmptyContainers() {
    Pod pod = new PodBuilder()
        .withNewMetadata()
        .withName("pod-1")
        .endMetadata()
        .build();

    // null spec
    pod.setSpec(null);
    assertThrows(KubernetesClientException.class, () -> podOperations.validateOrDefaultContainerId("a", pod));

    // null containers
    pod.setSpec(new PodSpec());
    pod.getSpec().setContainers(null);
    pod.getSpec().setEphemeralContainers(null);
    assertThrows(KubernetesClientException.class, () -> podOperations.validateOrDefaultContainerId("a", pod));

    // empty containers
    pod.setSpec(new PodSpec());
    assertThrows(KubernetesClientException.class, () -> podOperations.validateOrDefaultContainerId("a", pod));
  }

}
