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

import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerBuilder;
import io.fabric8.kubernetes.api.model.ContainerPortBuilder;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.PodSpec;
import io.fabric8.kubernetes.api.model.PodSpecBuilder;

public class GeneratorRunConfigUtil {
  private static final String DEFAULT_RESTART_POLICY = "Always";
  private GeneratorRunConfigUtil() { }

  public static ObjectMeta getObjectMetadataFromRunConfig(GeneratorRunConfig generatorRunConfig) {
    ObjectMetaBuilder objectMetaBuilder = new ObjectMetaBuilder();
    if (generatorRunConfig.getName() != null) {
      objectMetaBuilder.withName(generatorRunConfig.getName());
      objectMetaBuilder.addToLabels("run", generatorRunConfig.getName());
    }

    if (generatorRunConfig.getLabels() != null) {
      objectMetaBuilder.addToLabels(generatorRunConfig.getLabels());
    }

    return objectMetaBuilder.build();
  }

  public static PodSpec getPodSpecFromRunConfig(GeneratorRunConfig generatorRunConfig) {
    PodSpecBuilder podSpecBuilder = new PodSpecBuilder();
    if (generatorRunConfig.getRestartPolicy() != null) {
      podSpecBuilder.withRestartPolicy(generatorRunConfig.getRestartPolicy());
    } else {
      podSpecBuilder.withRestartPolicy(DEFAULT_RESTART_POLICY);
    }

    if (generatorRunConfig.getServiceAccount() != null) {
      podSpecBuilder.withServiceAccountName(generatorRunConfig.getServiceAccount());
    }

    podSpecBuilder.addToContainers(getContainersFromRunConfig(generatorRunConfig));

    return podSpecBuilder.build();
  }

  public static Container getContainersFromRunConfig(GeneratorRunConfig generatorRunConfig) {
    ContainerBuilder containerBuilder = new ContainerBuilder();
    if (generatorRunConfig.getName() != null) {
      containerBuilder.withName(generatorRunConfig.getName());
    }

    if (generatorRunConfig.getImage() != null) {
      containerBuilder.withImage(generatorRunConfig.getImage());
    }

    if (generatorRunConfig.getImagePullPolicy() != null) {
      containerBuilder.withImagePullPolicy(generatorRunConfig.getImagePullPolicy());
    }

    if (generatorRunConfig.getEnv() != null) {
      containerBuilder.withEnv(KubernetesResourceUtil.convertMapToEnvVarList(generatorRunConfig.getEnv()));
    }

    if (generatorRunConfig.getPort() > 0) {
      containerBuilder.withPorts(new ContainerPortBuilder()
        .withContainerPort(generatorRunConfig.getPort())
        .build());
    }

    if (generatorRunConfig.getLimits() != null) {
      containerBuilder.editOrNewResources()
        .addToLimits(generatorRunConfig.getLimits())
        .endResources();
    }

    if (generatorRunConfig.getRequests() != null) {
      containerBuilder.editOrNewResources()
        .addToRequests(generatorRunConfig.getRequests())
        .endResources();
    }
    return containerBuilder.build();
  }
}
