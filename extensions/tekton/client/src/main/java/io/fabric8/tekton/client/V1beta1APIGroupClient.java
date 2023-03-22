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
package io.fabric8.tekton.client;

import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.extension.ClientAdapter;
import io.fabric8.tekton.client.dsl.V1beta1APIGroupDSL;
import io.fabric8.tekton.pipeline.v1beta1.ClusterTask;
import io.fabric8.tekton.pipeline.v1beta1.ClusterTaskList;
import io.fabric8.tekton.pipeline.v1beta1.CustomRun;
import io.fabric8.tekton.pipeline.v1beta1.CustomRunList;
import io.fabric8.tekton.pipeline.v1beta1.Pipeline;
import io.fabric8.tekton.pipeline.v1beta1.PipelineList;
import io.fabric8.tekton.pipeline.v1beta1.PipelineRun;
import io.fabric8.tekton.pipeline.v1beta1.PipelineRunList;
import io.fabric8.tekton.pipeline.v1beta1.Task;
import io.fabric8.tekton.pipeline.v1beta1.TaskList;
import io.fabric8.tekton.pipeline.v1beta1.TaskRun;
import io.fabric8.tekton.pipeline.v1beta1.TaskRunList;
import io.fabric8.tekton.resolution.v1beta1.ResolutionRequest;
import io.fabric8.tekton.resolution.v1beta1.ResolutionRequestList;
import io.fabric8.tekton.triggers.v1beta1.ClusterTriggerBinding;
import io.fabric8.tekton.triggers.v1beta1.ClusterTriggerBindingList;
import io.fabric8.tekton.triggers.v1beta1.EventListener;
import io.fabric8.tekton.triggers.v1beta1.EventListenerList;
import io.fabric8.tekton.triggers.v1beta1.Trigger;
import io.fabric8.tekton.triggers.v1beta1.TriggerBinding;
import io.fabric8.tekton.triggers.v1beta1.TriggerBindingList;
import io.fabric8.tekton.triggers.v1beta1.TriggerList;
import io.fabric8.tekton.triggers.v1beta1.TriggerTemplate;
import io.fabric8.tekton.triggers.v1beta1.TriggerTemplateList;

public class V1beta1APIGroupClient extends ClientAdapter<V1beta1APIGroupClient> implements V1beta1APIGroupDSL {

  @Override
  public V1beta1APIGroupClient newInstance() {
    return new V1beta1APIGroupClient();
  }

  @Override
  public MixedOperation<Pipeline, PipelineList, Resource<Pipeline>> pipelines() {
    return resources(Pipeline.class, PipelineList.class);
  }

  @Override
  public MixedOperation<PipelineRun, PipelineRunList, Resource<PipelineRun>> pipelineRuns() {
    return resources(PipelineRun.class, PipelineRunList.class);
  }

  @Override
  public MixedOperation<Task, TaskList, Resource<Task>> tasks() {
    return resources(Task.class, TaskList.class);
  }

  @Override
  public MixedOperation<TaskRun, TaskRunList, Resource<TaskRun>> taskRuns() {
    return resources(TaskRun.class, TaskRunList.class);
  }

  @Override
  public MixedOperation<CustomRun, CustomRunList, Resource<CustomRun>> customRuns() {
    return resources(CustomRun.class, CustomRunList.class);
  }

  @Override
  public NonNamespaceOperation<ClusterTask, ClusterTaskList, Resource<ClusterTask>> clusterTasks() {
    return resources(ClusterTask.class, ClusterTaskList.class);
  }

  @Override
  public MixedOperation<Trigger, TriggerList, Resource<Trigger>> triggers() {
    return resources(Trigger.class, TriggerList.class);
  }

  @Override
  public MixedOperation<TriggerTemplate, TriggerTemplateList, Resource<TriggerTemplate>> triggerTemplates() {
    return resources(TriggerTemplate.class, TriggerTemplateList.class);
  }

  @Override
  public MixedOperation<TriggerBinding, TriggerBindingList, Resource<TriggerBinding>> triggerBindings() {
    return resources(TriggerBinding.class, TriggerBindingList.class);
  }

  @Override
  public MixedOperation<EventListener, EventListenerList, Resource<EventListener>> eventListeners() {
    return resources(EventListener.class, EventListenerList.class);
  }

  @Override
  public NonNamespaceOperation<ClusterTriggerBinding, ClusterTriggerBindingList, Resource<ClusterTriggerBinding>> clusterTriggerBindings() {
    return resources(ClusterTriggerBinding.class, ClusterTriggerBindingList.class);
  }

  @Override
  public MixedOperation<ResolutionRequest, ResolutionRequestList, Resource<ResolutionRequest>> resolutionRequests() {
    return resources(ResolutionRequest.class, ResolutionRequestList.class);
  }
}
