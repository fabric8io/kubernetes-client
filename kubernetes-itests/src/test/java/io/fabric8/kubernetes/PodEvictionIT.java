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
package io.fabric8.kubernetes;

import io.fabric8.junit.jupiter.api.LoadKubernetesManifests;
import io.fabric8.junit.jupiter.api.RequireK8sVersionAtLeast;
import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.policy.v1.Eviction;
import io.fabric8.kubernetes.api.model.policy.v1.EvictionBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.PodResource;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RequireK8sVersionAtLeast(majorVersion = 1, minorVersion = 22)
@LoadKubernetesManifests("/podeviction-it.yml")
class PodEvictionIT {

  KubernetesClient client;

  Namespace namespace;

  @Test
  void evictWithV1PolicyEviction() {
    // Given
    String podName = "podeviction-it-with-v1-policy-eviction";
    Eviction eviction = new EvictionBuilder()
        .withNewMetadata()
        .withNamespace(namespace.getMetadata().getName())
        .withName(podName)
        .endMetadata()
        .build();

    // When
    boolean evicted = client.pods().withName(podName).evict(eviction);

    // Then
    assertTrue(evicted);
  }

  @Test
  void evictWithV1PolicyEvictionNonExistentPod() {
    // Given
    String podName = "podit-evict-non-existent-pod";
    Eviction eviction = new EvictionBuilder()
        .withNewMetadata()
        .withNamespace(namespace.getMetadata().getName())
        .withName(podName)
        .endMetadata()
        .build();
    final PodResource podOps = client.pods().withName(podName);

    // When + Then
    assertThrows(KubernetesClientException.class, () -> podOps.evict(eviction));
  }

}
