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

import io.fabric8.kubernetes.api.model.BindingBuilder;
import io.fabric8.kubernetes.api.model.Node;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.PodSpecBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;

import java.util.UUID;

/**
 * This is an example of pod binding node.
 */
public class BindingExample {

  @SuppressWarnings("java:S106")
  public static void main(String[] args) {
    final String podName = "binding-example-" + UUID.randomUUID();
    try (final KubernetesClient client = new KubernetesClientBuilder().build()) {
      final String namespace;
      if (client.getConfiguration().getNamespace() != null) {
        namespace = client.getConfiguration().getNamespace();
      } else if (client.getNamespace() != null) {
        namespace = client.getNamespace();
      } else {
        namespace = client.namespaces().list().getItems().stream().findFirst()
            .orElseThrow(() -> new IllegalStateException("No namespace available")).getMetadata().getName();
      }

      client.pods().inNamespace(namespace).resource(new PodBuilder()
          .withMetadata(new ObjectMetaBuilder()
              .withName(podName)
              .build())
          .withSpec(new PodSpecBuilder()
              .withSchedulerName("random-scheduler-name-which-does-not-exist")
              .addNewContainer()
              .withName(podName)
              .withImage("nginx:latest")
              .endContainer()
              .build())
          .build()).create();
      final Node firstNode = client.nodes().list().getItems().stream().findFirst()
          .orElseThrow(() -> new IllegalStateException("No nodes available"));
      client.bindings().inNamespace(namespace).resource(new BindingBuilder()
          .withNewMetadata().withName(podName).endMetadata()
          .withNewTarget()
          .withKind(firstNode.getKind())
          .withApiVersion(firstNode.getApiVersion())
          .withName(firstNode.getMetadata().getName()).endTarget()
          .build()).create();
      System.out.printf("Successfully bound Pod %s to Node %s%n",
          podName, firstNode.getMetadata().getName());
    }
  }
}
