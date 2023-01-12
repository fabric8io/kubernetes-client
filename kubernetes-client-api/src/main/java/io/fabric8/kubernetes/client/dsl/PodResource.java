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
package io.fabric8.kubernetes.client.dsl;

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.policy.v1.Eviction;

public interface PodResource extends Resource<Pod>,
    Loggable,
    Containerable<String, ContainerResource>,
    ContainerResource,
    EphemeralContainersResource,
    PortForwardable {

  /**
   * Evicts resource, respecting {@link io.fabric8.kubernetes.api.model.policy.v1beta1.PodDisruptionBudget}
   *
   * @return value indicating object was evicted or not
   * @throws io.fabric8.kubernetes.client.KubernetesClientException if an error occurs, including if the Pod is not found.
   */
  boolean evict();

  /**
   * Evicts a pod from its node subject to certain policies and safety constraints.
   *
   * @param eviction Eviction object
   * @return value indicating object was evicted or not
   * @throws io.fabric8.kubernetes.client.KubernetesClientException if an error occurs, including if the Pod is not found.
   */
  boolean evict(Eviction eviction);

  /**
   * Manage ephemeral containers for a pod.
   *
   * @return ephemeral containers resource operations
   */
  EphemeralContainersResource ephemeralContainers();

}
