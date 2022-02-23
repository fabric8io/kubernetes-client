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
package io.fabric8.kubernetes.client.extended.run;

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;

public class RunOperations {

  private final KubernetesClient client;
  private final String namespace;
  private final RunConfigBuilder runConfigBuilder;

  public RunOperations(KubernetesClient client, String namespace, RunConfigBuilder runConfigBuilder) {
    this.client = client;
    this.namespace = namespace;
    this.runConfigBuilder = runConfigBuilder;
  }

  /**
   * Specify namespace for the operation
   *
   * @param namespace namespace in which resource needs to be created
   * @return {@link RunOperations} with injected namespace
   */
  public RunOperations inNamespace(String namespace) {
    return new RunOperations(client, namespace, runConfigBuilder);
  }

  /**
   * Specify image for the Pod
   *
   * @param image image as a string
   * @return {@link RunOperations} with image injected into {@link RunConfig}
   */
  public RunOperations withImage(String image) {
    return new RunOperations(client, namespace, runConfigBuilder.withImage(image));
  }

  /**
   * Specify name for the Pod
   *
   * @param name name of the pod to be created
   * @return {@link RunOperations} with name injected into {@link RunConfig}
   */
  public RunOperations withName(String name) {
    return new RunOperations(client, namespace, runConfigBuilder.withName(name));
  }

  /**
   * Specify complex configuration for Pod creating using {@link RunConfig}
   *
   * @param generatorRunConfig {@link RunConfig} which allows to provide configuring environment variables, labels, resources, ports etc
   * @return {@link RunOperations} with specified configuration
   */
  public RunOperations withRunConfig(RunConfig generatorRunConfig) {
    return new RunOperations(client, namespace, new RunConfigBuilder(generatorRunConfig));
  }

  /**
   * Apply the {@link RunConfig} onto the cluster and create Pod
   *
   * @return Pod which got created from the operation
   */
  public Pod done() {
    return client.pods().inNamespace(namespace).create(convertRunConfigIntoPod());
  }

  Pod convertRunConfigIntoPod() {
    RunConfig finalGeneratorConfig = runConfigBuilder.build();
    return new PodBuilder()
      .withMetadata(RunConfigUtil.getObjectMetadataFromRunConfig(finalGeneratorConfig))
      .withSpec(RunConfigUtil.getPodSpecFromRunConfig(finalGeneratorConfig))
      .build();
  }

}
