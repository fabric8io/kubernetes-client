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
package io.fabric8.tekton.api.examples;

import io.fabric8.knative.internal.pkg.apis.Condition;
import io.fabric8.tekton.client.DefaultTektonClient;
import io.fabric8.tekton.client.TektonClient;
import io.fabric8.tekton.pipeline.v1.TaskRun;

import java.util.ArrayList;
import java.util.List;

public class TaskRunCancel {

  public static void main(String[] args) {
    try (TektonClient tektonClient = new DefaultTektonClient()) {

      String namespace = "default";
      TaskRun taskRun = tektonClient.v1().taskRuns().inNamespace(namespace).list().getItems().get(0);

      List<Condition> taskRunConditions = new ArrayList<>();
      Condition taskRunCancelCondition = new Condition();
      taskRunCancelCondition.setType("Succeeded");
      taskRunCancelCondition.setStatus("False");
      taskRunCancelCondition.setReason("TaskRunCancelled");
      taskRunCancelCondition.setMessage("The TaskRun was cancelled successfully.");
      taskRunConditions.add(taskRunCancelCondition);

      /*
       * The implementation needs to replace old conditions with the single status condition to be added.
       * Without this, you will receive back a "Not all Steps in the Task have finished executing" message
       */
      taskRun.getStatus().setConditions(taskRunConditions);

      tektonClient.v1().taskRuns().inNamespace(namespace).updateStatus(taskRun);
    }
  }
}
