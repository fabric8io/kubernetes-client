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

import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.policy.v1.PodDisruptionBudget;
import io.fabric8.kubernetes.api.model.policy.v1.PodDisruptionBudgetBuilder;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.KubernetesClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;

public class PodDisruptionBudgetExample {
  private static final Logger logger = LoggerFactory.getLogger(PodDisruptionBudgetExample.class);

  public static void main(String[] args) {
    final ConfigBuilder configBuilder = new ConfigBuilder();
    if (args.length > 0) {
      configBuilder.withMasterUrl(args[0]);
      logger.info("Using master with URL: {}", args[0]);
    }
    try (KubernetesClient client = new KubernetesClientBuilder().withConfig(configBuilder.build()).build()) {
      final String namespace = "default";
      PodDisruptionBudget podDisruptionBudget = new PodDisruptionBudgetBuilder()
          .withNewMetadata().withName("zk-pkb").endMetadata()
          .withNewSpec()
          .withMaxUnavailable(new IntOrString("1%"))
          .withNewSelector()
          .withMatchLabels(Collections.singletonMap("app", "zookeeper"))
          .endSelector()
          .endSpec()
          .build();

      logger.info("Current namespace is {}", namespace);
      client.policy().v1().podDisruptionBudget().inNamespace(namespace).resource(podDisruptionBudget).createOrReplace();

    } catch (KubernetesClientException e) {
      logger.error("Could not create resource: {}", e.getMessage(), e);
    }
  }
}
