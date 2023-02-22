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
package io.fabric8.kubernetes.examples;

import io.fabric8.kubernetes.api.model.ContainerBuilder;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.scheduling.v1.PriorityClass;
import io.fabric8.kubernetes.api.model.scheduling.v1.PriorityClassBuilder;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.KubernetesClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;

public class PodPriorityExample {

  private static final Logger logger = LoggerFactory.getLogger(PodPriorityExample.class);

  public static void main(String[] args) {
    final ConfigBuilder configBuilder = new ConfigBuilder();
    if (args.length > 0) {
      configBuilder.withMasterUrl(args[0]);
      logger.info("Using master with URL: {}", args[0]);
    }
    try (KubernetesClient client = new KubernetesClientBuilder().withConfig(configBuilder.build()).build()) {
      PriorityClass priorityClass = new PriorityClassBuilder()
          .withNewMetadata().withName("high-priority").endMetadata()
          .withValue(100000)
          .withGlobalDefault(false)
          .withDescription("This priority class should be used for XYZ service pods only.")
          .build();
      client.scheduling().v1().priorityClasses().resource(priorityClass).create();

      client.pods().inNamespace("default").resource(new PodBuilder()
          .withNewMetadata().withName("nginx").withLabels(Collections.singletonMap("env", "test")).endMetadata()
          .withNewSpec()
          .addToContainers(
              new ContainerBuilder().withName("nginx").withImage("nginx").withImagePullPolicy("IfNotPresent").build())
          .withPriorityClassName("high-priority")
          .endSpec()
          .build())
          .create();
    } catch (KubernetesClientException e) {
      logger.error("Could not create resource: {}", e.getMessage(), e);
    }
  }
}
