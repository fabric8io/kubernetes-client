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

import io.fabric8.tekton.client.*;
import io.fabric8.tekton.resource.v1alpha1.PipelineResource;
import io.fabric8.tekton.resource.v1alpha1.PipelineResourceBuilder;

public class PipelineResourceCreate {

  public static void main(String[] args) {
    try (TektonClient client = ClientFactory.newClient(args)) {
      String namespace = "default";
      PipelineResource resource = new PipelineResourceBuilder()
          .withNewMetadata()
          .withName("client-repo")
          .endMetadata()
          .withNewSpec()
          .withType("git")
          .addNewParam()
          .withName("revision")
          .withValue("v4.2.2")
          .endParam()
          .addNewParam()
          .withName("url")
          .withValue("https://github.com/fabric8io/kubernetes-client")
          .endParam()
          .endSpec()
          .build();

      System.out.println(
          "Created:" + client.v1alpha1().pipelineResources().inNamespace(namespace).create(resource).getMetadata().getName());
    }
    System.exit(0);
  }
}
