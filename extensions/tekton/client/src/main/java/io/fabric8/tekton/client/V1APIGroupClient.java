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
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.extension.ClientAdapter;
import io.fabric8.tekton.client.dsl.V1APIGroupDSL;
import io.fabric8.tekton.pipeline.v1.Pipeline;
import io.fabric8.tekton.pipeline.v1.PipelineList;
import io.fabric8.tekton.pipeline.v1.PipelineRun;
import io.fabric8.tekton.pipeline.v1.PipelineRunList;
import io.fabric8.tekton.pipeline.v1.Task;
import io.fabric8.tekton.pipeline.v1.TaskList;
import io.fabric8.tekton.pipeline.v1.TaskRun;
import io.fabric8.tekton.pipeline.v1.TaskRunList;

public class V1APIGroupClient extends ClientAdapter<V1APIGroupClient> implements V1APIGroupDSL {

  @Override
  public V1APIGroupClient newInstance() {
    return new V1APIGroupClient();
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
}
