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
import io.fabric8.tekton.pipeline.v1beta1.Task;
import io.fabric8.tekton.pipeline.v1beta1.TaskBuilder;
import io.fabric8.tekton.pipeline.v1beta1.TaskList;

public class TaskCreate {
  public static void main(String[] args) {
    try (TektonClient tektonClient = new DefaultTektonClient()) {
      String namespace = "default";
      Task task = new TaskBuilder()
          .withNewMetadata().withName("read-task").endMetadata()
          .withNewSpec()
          .withNewResources()
          .addNewInput()
          .withName("workspace").withType("git")
          .endInput()
          .endResources()
          .addNewStep()
          .withName("readme").withImage("ubuntu").withScript("cat workspace/README.md")
          .endStep()
          .endSpec()
          .build();

      // Create Task
      task = tektonClient.v1beta1().tasks().inNamespace(namespace).create(task);
      System.out.println("Created: " + task.getMetadata().getName());

      // List Task
      TaskList taskList = tektonClient.v1beta1().tasks().inNamespace(namespace).list();
      System.out.println("There are " + taskList.getItems().size() + " Tasks in " + namespace);
    }
  }
}
