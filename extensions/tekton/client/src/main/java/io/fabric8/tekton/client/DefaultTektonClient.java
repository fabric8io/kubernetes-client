/**
 * Copyright (C) 2015 Fabric8 Authors.
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

import okhttp3.OkHttpClient;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.RequestConfig;
import io.fabric8.kubernetes.client.WithRequestCallable;
import io.fabric8.kubernetes.client.dsl.FunctionCallable;
import io.fabric8.kubernetes.client.BaseClient;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;

import io.fabric8.tekton.pipeline.v1alpha1.*;
import io.fabric8.tekton.client.internal.*;

public class DefaultTektonClient extends BaseClient implements NamespacedTektonClient {

    public DefaultTektonClient() {
        super();
    }

    public DefaultTektonClient(Config configuration) {
        super(configuration);
    }

    public DefaultTektonClient(OkHttpClient httpClient, Config configuration) {
        super(httpClient, configuration);
    }

    @Override
    public NamespacedTektonClient inAnyNamespace() {
        return inNamespace(null);
    }

    @Override
    public NamespacedTektonClient inNamespace(String namespace) {
        Config updated = new ConfigBuilder(getConfiguration())
                .withNamespace(namespace)
                .build();

        return new DefaultTektonClient(getHttpClient(), updated);
    }
  @Override
  public FunctionCallable<NamespacedTektonClient> withRequestConfig(RequestConfig requestConfig) {
    return new WithRequestCallable<NamespacedTektonClient>(this, requestConfig);
  }

  public MixedOperation<Pipeline, PipelineList, DoneablePipeline, Resource<Pipeline, DoneablePipeline>> pipelines() {
    return new PipelineOperationsImpl(this.getHttpClient(), this.getConfiguration());
  }

  public MixedOperation<PipelineRun, PipelineRunList, DoneablePipelineRun, Resource<PipelineRun, DoneablePipelineRun>> pipelineRuns() {
    return new PipelineRunOperationsImpl(this.getHttpClient(), this.getConfiguration());
  }

  public MixedOperation<PipelineResource, PipelineResourceList, DoneablePipelineResource, Resource<PipelineResource, DoneablePipelineResource>> pipelineResources() {
    return new PipelineResourceOperationsImpl(this.getHttpClient(), this.getConfiguration());
  }

  public MixedOperation<Task, TaskList, DoneableTask, Resource<Task, DoneableTask>> tasks() {
    return new TaskOperationsImpl(this.getHttpClient(), this.getConfiguration());
  }
  public MixedOperation<TaskRun, TaskRunList, DoneableTaskRun, Resource<TaskRun, DoneableTaskRun>> taskRuns() {
    return new TaskRunOperationsImpl(this.getHttpClient(), this.getConfiguration());
  }
  public MixedOperation<Condition, ConditionList, DoneableCondition, Resource<Condition, DoneableCondition>> conditions() {
    return new ConditionOperationsImpl(this.getHttpClient(), this.getConfiguration());
  }

  public NonNamespaceOperation<ClusterTask, ClusterTaskList, DoneableClusterTask, Resource<ClusterTask, DoneableClusterTask>> clusterTasks() {
    return new ClusterTaskOperationsImpl(this.getHttpClient(), this.getConfiguration());
  }

}
