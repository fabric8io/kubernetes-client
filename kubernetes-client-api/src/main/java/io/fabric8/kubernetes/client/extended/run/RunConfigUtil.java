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

import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerBuilder;
import io.fabric8.kubernetes.api.model.ContainerPortBuilder;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.PodSpec;
import io.fabric8.kubernetes.api.model.PodSpecBuilder;
import io.fabric8.kubernetes.client.utils.KubernetesResourceUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static io.fabric8.kubernetes.client.utils.Utils.isNotNullOrEmpty;
import static io.fabric8.kubernetes.client.utils.Utils.isNullOrEmpty;

public class RunConfigUtil {
  private static final String DEFAULT_RESTART_POLICY = "Always";

  private RunConfigUtil() {
  }

  public static ObjectMeta getObjectMetadataFromRunConfig(RunConfig generatorRunConfig) {
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

  public static PodSpec getPodSpecFromRunConfig(RunConfig generatorRunConfig) {
    PodSpecBuilder podSpecBuilder = new PodSpecBuilder();
    if (generatorRunConfig.getRestartPolicy() != null) {
      podSpecBuilder.withRestartPolicy(generatorRunConfig.getRestartPolicy());
    } else {
      podSpecBuilder.withRestartPolicy(DEFAULT_RESTART_POLICY);
    }

    if (generatorRunConfig.getServiceAccount() != null) {
      podSpecBuilder.withServiceAccountName(generatorRunConfig.getServiceAccount());
    }

    podSpecBuilder.addToContainers(containerFromConfig(generatorRunConfig));

    return podSpecBuilder.build();
  }

  static Container containerFromConfig(RunConfig runConfig) {
    final ContainerBuilder containerBuilder = new ContainerBuilder();
    containerBuilder.withName(runConfig.getName());
    containerBuilder.withImage(runConfig.getImage());
    containerBuilder.withImagePullPolicy(runConfig.getImagePullPolicy());
    containerBuilder.withArgs(argsFromConfig(runConfig));
    containerBuilder.withCommand(commandFromConfig(runConfig));

    if (runConfig.getEnv() != null) {
      containerBuilder.withEnv(KubernetesResourceUtil.convertMapToEnvVarList(runConfig.getEnv()));
    }

    if (runConfig.getPort() > 0) {
      containerBuilder.withPorts(new ContainerPortBuilder()
          .withContainerPort(runConfig.getPort())
          .build());
    }

    if (runConfig.getLimits() != null) {
      containerBuilder.editOrNewResources()
          .addToLimits(runConfig.getLimits())
          .endResources();
    }

    if (runConfig.getRequests() != null) {
      containerBuilder.editOrNewResources()
          .addToRequests(runConfig.getRequests())
          .endResources();
    }
    return containerBuilder.build();
  }

  private static String[] argsFromConfig(RunConfig runConfig) {
    if (isNullOrEmpty(runConfig.getCommand()) && runConfig.getArgs() != null) {
      return runConfig.getArgs().toArray(new String[0]);
    }
    return new String[0];
  }

  private static String[] commandFromConfig(RunConfig runConfig) {
    if (isNotNullOrEmpty(runConfig.getCommand())) {
      final List<String> command = new ArrayList<>(Collections.singletonList(runConfig.getCommand()));
      if (runConfig.getArgs() != null) {
        command.addAll(runConfig.getArgs());
      }
      return command.toArray(new String[0]);
    }
    return new String[0];
  }
}
