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

import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.extension.ClientAdapter;
import io.fabric8.tekton.client.dsl.V1alpha1APIGroupDSL;
import io.fabric8.tekton.pipeline.v1alpha1.ClusterTask;
import io.fabric8.tekton.pipeline.v1alpha1.ClusterTaskList;
import io.fabric8.tekton.pipeline.v1alpha1.Condition;
import io.fabric8.tekton.pipeline.v1alpha1.ConditionList;
import io.fabric8.tekton.pipeline.v1alpha1.Pipeline;
import io.fabric8.tekton.pipeline.v1alpha1.PipelineList;
import io.fabric8.tekton.pipeline.v1alpha1.PipelineRun;
import io.fabric8.tekton.pipeline.v1alpha1.PipelineRunList;
import io.fabric8.tekton.pipeline.v1alpha1.Task;
import io.fabric8.tekton.pipeline.v1alpha1.TaskList;
import io.fabric8.tekton.pipeline.v1alpha1.TaskRun;
import io.fabric8.tekton.pipeline.v1alpha1.TaskRunList;
import io.fabric8.tekton.resource.v1alpha1.PipelineResource;
import io.fabric8.tekton.resource.v1alpha1.PipelineResourceList;
import io.fabric8.tekton.triggers.v1alpha1.ClusterInterceptor;
import io.fabric8.tekton.triggers.v1alpha1.ClusterInterceptorList;
import io.fabric8.tekton.triggers.v1alpha1.ClusterTriggerBinding;
import io.fabric8.tekton.triggers.v1alpha1.ClusterTriggerBindingList;
import io.fabric8.tekton.triggers.v1alpha1.EventListener;
import io.fabric8.tekton.triggers.v1alpha1.EventListenerList;
import io.fabric8.tekton.triggers.v1alpha1.Trigger;
import io.fabric8.tekton.triggers.v1alpha1.TriggerBinding;
import io.fabric8.tekton.triggers.v1alpha1.TriggerBindingList;
import io.fabric8.tekton.triggers.v1alpha1.TriggerList;
import io.fabric8.tekton.triggers.v1alpha1.TriggerTemplate;
import io.fabric8.tekton.triggers.v1alpha1.TriggerTemplateList;

public class V1alpha1APIGroupClient extends ClientAdapter<V1alpha1APIGroupDSL> implements V1alpha1APIGroupDSL {
  public V1alpha1APIGroupClient() {
    super();
  }

  public V1alpha1APIGroupClient(Client client) {
    super(client);
  }

  @Override
  protected V1alpha1APIGroupDSL newInstance(Client client) {
    return new V1alpha1APIGroupClient(client);
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
  public MixedOperation<PipelineResource, PipelineResourceList, Resource<PipelineResource>> pipelineResources() {
    return resources(PipelineResource.class, PipelineResourceList.class);
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
  public MixedOperation<Condition, ConditionList, Resource<Condition>> conditions() {
    return resources(Condition.class, ConditionList.class);
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
  public MixedOperation<Trigger, TriggerList, Resource<Trigger>> triggers() {
    return resources(Trigger.class, TriggerList.class);
  }

  @Override
  public MixedOperation<EventListener, EventListenerList, Resource<EventListener>> eventListeners() {
    return resources(EventListener.class, EventListenerList.class);
  }

  @Override
  public NonNamespaceOperation<ClusterTask, ClusterTaskList, Resource<ClusterTask>> clusterTasks() {
    return resources(ClusterTask.class, ClusterTaskList.class);
  }

  @Override
  public NonNamespaceOperation<ClusterTriggerBinding, ClusterTriggerBindingList, Resource<ClusterTriggerBinding>> clusterTriggerBindings() {
    return resources(ClusterTriggerBinding.class, ClusterTriggerBindingList.class);
  }

  @Override
  public NonNamespaceOperation<ClusterInterceptor, ClusterInterceptorList, Resource<ClusterInterceptor>> clusterInterceptors() {
    return resources(ClusterInterceptor.class, ClusterInterceptorList.class);
  }
}
