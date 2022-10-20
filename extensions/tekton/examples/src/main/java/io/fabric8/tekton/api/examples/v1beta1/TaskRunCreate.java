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
package io.fabric8.tekton.api.examples.v1beta1;

import io.fabric8.tekton.client.DefaultTektonClient;
import io.fabric8.tekton.client.TektonClient;
import io.fabric8.tekton.pipeline.v1beta1.TaskRun;
import io.fabric8.tekton.pipeline.v1beta1.TaskRunBuilder;
import io.fabric8.tekton.pipeline.v1beta1.TaskRunList;

public class TaskRunCreate {
  public static void main(String[] args) {
    try (TektonClient tektonClient = new DefaultTektonClient()) {
      String namespace = "default";
      TaskRun taskRun = new TaskRunBuilder()
          .withNewMetadata().withGenerateName("build-gcs-targz-").endMetadata()
          .withNewSpec()
          .withNewTaskSpec()
          .withNewResources()
          .addNewInput().withName("source").withType("storage").endInput()
          .endResources()
          .addNewStep().withImage("ubuntu").withScript("cat source/file.txt").endStep()
          .endTaskSpec()
          .withNewResources()
          .addNewInput()
          .withName("source")
          .withNewResourceSpec()
          .withType("storage")
          .addNewParam().withName("location").withValue("gs://build-crd-tests/archive.tar.gz").endParam()
          .addNewParam().withName("artifactType").withValue("TarGzArchive").endParam()
          .addNewParam().withName("type").withValue("build-gcs").endParam()
          .endResourceSpec()
          .endInput()
          .endResources()
          .endSpec()
          .build();

      // Create TaskRun
      taskRun = tektonClient.v1beta1().taskRuns().inNamespace(namespace).create(taskRun);
      System.out.println("Created: " + taskRun.getMetadata().getName());

      // List TaskRun
      TaskRunList taskRunList = tektonClient.v1beta1().taskRuns().inNamespace(namespace).list();
      System.out.println("There are " + taskRunList.getItems().size() + " TaskRun objects in " + namespace);
    }
  }
}
