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

import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.NamespaceBuilder;
import io.fabric8.kubernetes.api.model.ServiceAccount;
import io.fabric8.kubernetes.api.model.ServiceAccountBuilder;
import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.api.model.apps.DeploymentBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeploymentExamples {

  private static final Logger logger = LoggerFactory.getLogger(DeploymentExamples.class);

  private static final String NAMESPACE = "this-is-a-test";

  public static void main(String[] args) {
    try (KubernetesClient client = new KubernetesClientBuilder().build()) {
      // Create a namespace for all our stuff
      Namespace ns = new NamespaceBuilder().withNewMetadata().withName(NAMESPACE).addToLabels("this", "rocks").endMetadata()
          .build();
      logger.info("Created namespace: {}", client.namespaces().resource(ns).createOrReplace());

      ServiceAccount fabric8 = new ServiceAccountBuilder().withNewMetadata().withName("fabric8").endMetadata().build();

      client.serviceAccounts().inNamespace(NAMESPACE).resource(fabric8).createOrReplace();
      try {
        Deployment deployment = new DeploymentBuilder()
            .withNewMetadata()
            .withName("nginx")
            .endMetadata()
            .withNewSpec()
            .withReplicas(1)
            .withNewTemplate()
            .withNewMetadata()
            .addToLabels("app", "nginx")
            .endMetadata()
            .withNewSpec()
            .addNewContainer()
            .withName("nginx")
            .withImage("nginx")
            .addNewPort()
            .withContainerPort(80)
            .endPort()
            .endContainer()
            .endSpec()
            .endTemplate()
            .withNewSelector()
            .addToMatchLabels("app", "nginx")
            .endSelector()
            .endSpec()
            .build();

        deployment = client.apps().deployments().inNamespace(NAMESPACE).resource(deployment).create();
        logger.info("Created deployment: {}", deployment);

        logger.info("Scaling up: {}", deployment.getMetadata().getName());
        client.apps().deployments().inNamespace(NAMESPACE).withName("nginx").scale(2, true);
        logger.info("Created replica sets: {}", client.apps().replicaSets().inNamespace(NAMESPACE).list().getItems());
        logger.info("Deleting: {}", deployment.getMetadata().getName());
        client.resource(deployment).delete();
      } finally {
        client.namespaces().withName(NAMESPACE).delete();
      }
      logger.info("Done.");
    }
  }
}
