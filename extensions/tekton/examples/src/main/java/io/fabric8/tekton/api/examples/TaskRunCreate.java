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

import io.fabric8.tekton.client.DefaultTektonClient;
import io.fabric8.tekton.client.TektonClient;
import io.fabric8.tekton.pipeline.v1.StepBuilder;
import io.fabric8.tekton.pipeline.v1.Task;
import io.fabric8.tekton.pipeline.v1.TaskBuilder;
import io.fabric8.tekton.pipeline.v1.TaskRun;
import io.fabric8.tekton.pipeline.v1.TaskRunBuilder;
import io.fabric8.tekton.pipeline.v1.TaskRunList;

import java.util.UUID;

public class TaskRunCreate {
  public static void main(String[] args) {
    try (TektonClient tektonClient = new DefaultTektonClient()) {
      String namespace = "default";

      Task task = new TaskBuilder()
          .withNewMetadata().withName("hello-world-" + UUID.randomUUID()).endMetadata()
          .withNewSpec()
          .withSteps(
              new StepBuilder()
                  .withName("hello")
                  .withImage("alpine")
                  .withCommand("#!/bin/sh\necho Hello world!")
                  .build())
          .endSpec()
          .build();

      TaskRun taskRun = new TaskRunBuilder()
          .withNewMetadata().withGenerateName("run-hello-world-").endMetadata()
          .withNewSpec().withNewTaskRef().withName(task.getMetadata().getName()).endTaskRef().endSpec()
          .build();

      // Create Task
      task = tektonClient.v1().tasks().inNamespace(namespace).resource(task).create();
      System.out.println("Created: " + task.getMetadata().getName());

      // Create TaskRun
      taskRun = tektonClient.v1().taskRuns().inNamespace(namespace).resource(taskRun).create();
      System.out.println("Created: " + taskRun.getMetadata().getName());

      // List TaskRun
      TaskRunList taskRunList = tektonClient.v1().taskRuns().inNamespace(namespace).list();
      System.out.println("There are " + taskRunList.getItems().size() + " TaskRun objects in " + namespace);
    }
  }
}
