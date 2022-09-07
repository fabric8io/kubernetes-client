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
package io.fabric8.tekton;

import io.fabric8.kubernetes.api.KubernetesResourceMappingProvider;
import io.fabric8.kubernetes.api.model.KubernetesResource;

import java.util.HashMap;
import java.util.Map;

public class TektonTriggersResourceMappingProvider implements KubernetesResourceMappingProvider {

  public final Map<String, Class<? extends KubernetesResource>> mappings = new HashMap<>();

  public TektonTriggersResourceMappingProvider() {
    mappings.put("triggers.tekton.dev/v1alpha1#TriggerTemplate", io.fabric8.tekton.triggers.v1alpha1.TriggerTemplate.class);
    mappings.put("triggers.tekton.dev/v1alpha1#TriggerBinding", io.fabric8.tekton.triggers.v1alpha1.TriggerBinding.class);
    mappings.put("triggers.tekton.dev/v1alpha1#EventListener", io.fabric8.tekton.triggers.v1alpha1.EventListener.class);
    mappings.put("triggers.tekton.dev/v1alpha1#ClusterTriggerBinding",
        io.fabric8.tekton.triggers.v1alpha1.ClusterTriggerBinding.class);
    mappings.put("triggers.tekton.dev/v1alpha1#Trigger", io.fabric8.tekton.triggers.v1alpha1.Trigger.class);
    mappings.put("triggers.tekton.dev/v1alpha1#ClusterInterceptor",
        io.fabric8.tekton.triggers.v1alpha1.ClusterInterceptor.class);
  }

  public Map<String, Class<? extends KubernetesResource>> getMappings() {
    return mappings;
  }
}
