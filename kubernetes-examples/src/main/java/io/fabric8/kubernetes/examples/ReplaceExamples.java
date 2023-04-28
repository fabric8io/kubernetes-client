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
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.utils.Serialization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReplaceExamples {

  private static final Logger logger = LoggerFactory.getLogger(ReplaceExamples.class);

  private static final String NAMESPACE = "this-is-a-test";

  public static void main(String[] args) {
    final ConfigBuilder configBuilder = new ConfigBuilder();
    if (args.length > 0) {
      configBuilder.withMasterUrl(args[0]);
      logger.info("Using master with URL: {}", args[0]);
    }
    try (KubernetesClient client = new KubernetesClientBuilder().withConfig(configBuilder.build()).build()) {
      try {
        final Namespace namespace = client.namespaces().resource(
            new NamespaceBuilder().withNewMetadata().withName(NAMESPACE).endMetadata().build())
            .create();
        logger.info("Create namespace: {}", NAMESPACE);

        Pod createdPod = client.pods().inNamespace(namespace.getMetadata().getName()).resource(new PodBuilder()
            .withNewMetadata()
            .withName("test-pod")
            .addToLabels("server", "nginx")
            .endMetadata()
            .withNewSpec()
            .addNewContainer().withName("nginx").withImage("nginx")
            .addNewPort().withContainerPort(80).endPort()
            .endContainer()
            .endSpec()
            .build())
            .create();
        logger.info("Created Pod: {}", createdPod.getMetadata().getName());
        logger.info(Serialization.asYaml(createdPod));

        Pod updatedPod = client.pods().inNamespace(NAMESPACE).withName("test-pod").edit(p -> new PodBuilder(p)
            .editMetadata()
            .addToLabels("server2", "nginx2")
            .and().build());
        logger.info("Replaced Pod: {}", updatedPod.getMetadata().getName());
        logger.info(Serialization.asYaml(updatedPod));

      } catch (KubernetesClientException e) {
        logger.error(e.getMessage(), e);
      } finally {
        client.namespaces().withName(NAMESPACE).delete();
      }
    }
  }

}
