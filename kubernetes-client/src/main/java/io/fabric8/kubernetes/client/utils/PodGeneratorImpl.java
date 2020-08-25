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
package io.fabric8.kubernetes.client.utils;

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.dsl.internal.core.v1.PodOperationsImpl;
import okhttp3.OkHttpClient;

public class PodGeneratorImpl {
  private final OkHttpClient client;
  private final Config config;
  private final String namespace;
  private final GeneratorRunConfigBuilder generatorRunConfigBuilder;

  public PodGeneratorImpl(OkHttpClient client, Config config, String namespace, GeneratorRunConfigBuilder runConfig) {
    this.client = client;
    this.config = config;
    this.namespace = namespace;
    this.generatorRunConfigBuilder = runConfig;
  }

  /**
   * Specify namespace for the operation
   *
   * @param namespace namespace in which resource needs to be created
   * @return {@link PodGeneratorImpl} with injected namespace
   */
  public PodGeneratorImpl inNamespace(String namespace) {
    return new PodGeneratorImpl(this.client, this.config, namespace, this.generatorRunConfigBuilder);
  }

  /**
   * Specify image for the Pod
   *
   * @param image image as a string
   * @return {@link PodGeneratorImpl} with image injected into {@link GeneratorRunConfig}
   */
  public PodGeneratorImpl withImage(String image) {
    return new PodGeneratorImpl(this.client, this.config, namespace, this.generatorRunConfigBuilder.withImage(image));
  }

  /**
   * Specify name for the Pod
   *
   * @param name name of the pod to be created
   * @return {@link PodGeneratorImpl} with name injected into {@link GeneratorRunConfig}
   */
  public PodGeneratorImpl withName(String name) {
    return new PodGeneratorImpl(this.client, this.config, namespace, this.generatorRunConfigBuilder.withName(name));
  }

  /**
   * Specify complex configuration for Pod creating using {@link GeneratorRunConfig}
   *
   * @param generatorRunConfig {@link GeneratorRunConfig} which allows to provide configuring environment variables, labels, resources, ports etc
   * @return {@link PodGeneratorImpl} with specified configuration
   */
  public PodGeneratorImpl withRunConfig(GeneratorRunConfig generatorRunConfig) {
    return new PodGeneratorImpl(this.client, this.config, namespace, new GeneratorRunConfigBuilder(generatorRunConfig));
  }

  /**
   * Apply the {@link GeneratorRunConfig} onto the cluster and create Pod
   *
   * @return Pod which got created from the operation
   */
  public Pod done() {
    PodOperationsImpl podOperations = new PodOperationsImpl(client, config, namespace);
    return podOperations.create(convertRunConfigIntoPod());
  }

  protected Pod convertRunConfigIntoPod() {
    GeneratorRunConfig finalGeneratorConfig = generatorRunConfigBuilder.build();
    return new PodBuilder()
      .withMetadata(GeneratorRunConfigUtil.getObjectMetadataFromRunConfig(finalGeneratorConfig))
      .withSpec(GeneratorRunConfigUtil.getPodSpecFromRunConfig(finalGeneratorConfig))
      .build();
  }
}
