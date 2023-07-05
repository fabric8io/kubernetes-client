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
import io.fabric8.kubernetes.client.NamespacedKubernetesClient;

public class RunOperations {

  public class RunConfigNested extends RunConfigFluent<RunConfigNested> {

    RunConfigNested() {
      super(runConfig); // copy the existing properties
    }

    public Pod done() {
      RunConfig runConfig = new RunConfigBuilder(this).build();
      return withRunConfig(runConfig).done();
    }

  }

  private final KubernetesClient client;
  private final RunConfig runConfig;

  public RunOperations(KubernetesClient client, RunConfig runConfig) {
    this.client = client;
    this.runConfig = runConfig;
  }

  /**
   * Specify namespace for the operation
   *
   * @param namespace namespace in which resource needs to be created
   * @return {@link RunOperations} with injected namespace
   */
  public RunOperations inNamespace(String namespace) {
    return new RunOperations(client.adapt(NamespacedKubernetesClient.class).inNamespace(namespace), runConfig);
  }

  /**
   * Specify image for the Pod
   *
   * @param image image as a string
   * @return {@link RunOperations} with image injected into {@link RunConfig}
   */
  public RunOperations withImage(String image) {
    return new RunOperations(client, new RunConfigBuilder(runConfig).withImage(image).build());
  }

  /**
   * Specify name for the Pod
   *
   * @param name name of the pod to be created
   * @return {@link RunOperations} with name injected into {@link RunConfig}
   */
  public RunOperations withName(String name) {
    return new RunOperations(client, new RunConfigBuilder(runConfig).withName(name).build());
  }

  /**
   * Specify complex configuration for Pod creating using {@link RunConfig}.
   * <br>
   * WARNING: this will overwrite any of the previous calls, such as withName to this context
   *
   * @param generatorRunConfig {@link RunConfig} which allows to provide configuring environment variables, labels, resources,
   *        ports etc
   * @return {@link RunOperations} with specified configuration
   * @deprecated use {@link #withNewRunConfig()} instead
   */
  @Deprecated
  public RunOperations withRunConfig(RunConfig generatorRunConfig) {
    return new RunOperations(client, new RunConfigBuilder(generatorRunConfig).build());
  }

  /**
   * Provides access to a nested {@link RunConfig} builder that inherits the current
   * values for name and image if they are already set. Call the {@link RunConfigNested#done()} method to create the {@link Pod}
   *
   * @return
   */
  public RunConfigNested withNewRunConfig() {
    return new RunConfigNested();
  }

  /**
   * Apply the {@link RunConfig} onto the cluster and create Pod
   *
   * @return Pod which got created from the operation
   */
  public Pod done() {
    return client.pods().resource(convertRunConfigIntoPod()).create();
  }

  Pod convertRunConfigIntoPod() {
    return new PodBuilder()
        .withMetadata(RunConfigUtil.getObjectMetadataFromRunConfig(runConfig))
        .withSpec(RunConfigUtil.getPodSpecFromRunConfig(runConfig))
        .build();
  }

}
