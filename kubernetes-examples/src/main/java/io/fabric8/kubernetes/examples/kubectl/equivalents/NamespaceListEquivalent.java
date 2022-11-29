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
package io.fabric8.kubernetes.examples.kubectl.equivalents;

import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.KubernetesClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NamespaceListEquivalent {
  private static final Logger logger = LoggerFactory.getLogger(NamespaceListEquivalent.class);

  public static void main(String[] args) {
    logger.info("Creating Kubernetes client");
    try (final KubernetesClient client = new KubernetesClientBuilder().build()) {
      logger.info("Kubernetes client successfully created");

      // List all namespaces
      client.namespaces()
          .list()
          .getItems()
          .stream()
          .map(Namespace::getMetadata)
          .map(ObjectMeta::getName)
          .forEach(logger::info);

    } catch (KubernetesClientException aException) {
      logger.error("Problem encountered in Kubernetes Client");
      aException.printStackTrace();
    }
  }
}
