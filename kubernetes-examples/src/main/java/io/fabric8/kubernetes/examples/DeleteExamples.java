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

import io.fabric8.kubernetes.api.model.NamespaceBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.KubernetesClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeleteExamples {

  private static final Logger logger = LoggerFactory.getLogger(DeleteExamples.class);

  private static final String NAMESPACE = "this-is-a-test";

  public static void main(String[] args) {
    try (KubernetesClient client = new KubernetesClientBuilder().build()) {
      try {
        logger.info("Create namespace: {}", client.namespaces()
            .resource(new NamespaceBuilder().withNewMetadata().withName(NAMESPACE).endMetadata().build())
            .create());
        logger.info("Deleted namespace: {}", client.namespaces().withName(NAMESPACE).delete());
        logger.info("Deleted testPod: {}", client.pods().inNamespace(NAMESPACE).withName("test-pod").delete());
        logger.info("Deleted pod by label: {}", client.pods().withLabel("this", "works").delete());
      } catch (KubernetesClientException e) {
        logger.error(e.getMessage(), e);
      } finally {
        client.namespaces().withName(NAMESPACE).delete();
      }
    }
  }

}
