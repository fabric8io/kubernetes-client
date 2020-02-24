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
import io.fabric8.tekton.pipeline.v1alpha1.ClusterTask;
import io.fabric8.tekton.pipeline.v1alpha1.Pipeline;
import io.fabric8.tekton.pipeline.v1alpha1.PipelineRun;
import io.fabric8.tekton.pipeline.v1alpha1.Task;
import io.fabric8.tekton.pipeline.v1alpha1.TaskRun;
import io.fabric8.tekton.resource.v1alpha1.PipelineResource;

import java.util.HashMap;
import java.util.Map;

public class TektonResourceMappingProvider implements KubernetesResourceMappingProvider {

    public final Map<String, Class<? extends KubernetesResource>> mappings = new HashMap<>();

    public TektonResourceMappingProvider () {
        mappings.put("tekton.dev/v1alpha1#Pipeline", Pipeline.class);
        mappings.put("tekton.dev/v1alpha1#PipelineRun", PipelineRun.class);
        mappings.put("tekton.dev/v1alpha1#PipelineResource", PipelineResource.class);
        mappings.put("tekton.dev/v1alpha1#Task", Task.class);
        mappings.put("tekton.dev/v1alpha1#TaskRun", TaskRun.class);
        mappings.put("tekton.dev/v1alpha1#ClusterTask", ClusterTask.class);
    }
     
    public Map<String, Class<? extends KubernetesResource>> getMappings() {
        return mappings;
    }
}
