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
package io.fabric8.chaosmesh.api.model;

import io.fabric8.kubernetes.api.KubernetesResourceMappingProvider;
import io.fabric8.kubernetes.api.model.KubernetesResource;

import java.util.HashMap;
import java.util.Map;

public class ChaosMeshResourceMappingProvider implements KubernetesResourceMappingProvider {

  public final Map<String, Class<? extends KubernetesResource>> mappings = new HashMap<>();

  public ChaosMeshResourceMappingProvider() {
    mappings.put("chaos-mesh.org/v1alpha1#IoChaos", io.fabric8.chaosmesh.v1alpha1.IoChaos.class);
    mappings.put("chaos-mesh.org/v1alpha1#KernelChaos", io.fabric8.chaosmesh.v1alpha1.KernelChaos.class);
    mappings.put("chaos-mesh.org/v1alpha1#NetworkChaos", io.fabric8.chaosmesh.v1alpha1.NetworkChaos.class);
    mappings.put("chaos-mesh.org/v1alpha1#PodChaos", io.fabric8.chaosmesh.v1alpha1.PodChaos.class);
    mappings.put("chaos-mesh.org/v1alpha1#PodIoChaos", io.fabric8.chaosmesh.v1alpha1.PodIoChaos.class);
    mappings.put("chaos-mesh.org/v1alpha1#PodNetworkChaos", io.fabric8.chaosmesh.v1alpha1.PodNetworkChaos.class);
    mappings.put("chaos-mesh.org/v1alpha1#StressChaos", io.fabric8.chaosmesh.v1alpha1.StressChaos.class);
    mappings.put("chaos-mesh.org/v1alpha1#TimeChaos", io.fabric8.chaosmesh.v1alpha1.TimeChaos.class);
    mappings.put("chaos-mesh.org/v1alpha1#JVMChaos", io.fabric8.chaosmesh.v1alpha1.JVMChaos.class);
    mappings.put("chaos-mesh.org/v1alpha1#HTTPChaos", io.fabric8.chaosmesh.v1alpha1.HTTPChaos.class);
    mappings.put("chaos-mesh.org/v1alpha1#DNSChaos", io.fabric8.chaosmesh.v1alpha1.DNSChaos.class);
    mappings.put("chaos-mesh.org/v1alpha1#AwsChaos", io.fabric8.chaosmesh.v1alpha1.AwsChaos.class);
  }

  public Map<String, Class<? extends KubernetesResource>> getMappings() {
    return mappings;
  }
}
