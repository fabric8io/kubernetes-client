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
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.ResourceQuota;
import io.fabric8.kubernetes.api.model.ResourceQuotaBuilder;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NamespaceQuotaExample {

  private static final Logger logger = LoggerFactory.getLogger(NamespaceQuotaExample.class);

  private static final String NAMESPACE = "namepsace-test";

  public static void main(String[] args) {
    final ConfigBuilder configBuilder = new ConfigBuilder();
    if (args.length > 0) {
      configBuilder.withMasterUrl(args[0]);
    }
    try (KubernetesClient client = new KubernetesClientBuilder().withConfig(configBuilder.build()).build()) {
      String namespace = NAMESPACE;
      if (args.length > 2) {
        namespace = args[2];
      }
      try {
        // Creating namespace
        Namespace ns = new NamespaceBuilder().withNewMetadata().withName(namespace).addToLabels("hello", "world").endMetadata()
            .build();
        logger.info("Created namespace: {}", client.namespaces().resource(ns).create().getMetadata().getName());

        // Get namespace by name
        logger.info("Get namespace by name: {}", client.namespaces().withName(namespace).get());
        // Get namespace by label
        logger.info("Get namespace by label:");
        client.namespaces().withLabel("hello", "world").list().getItems()
            .forEach(n -> logger.info(" - {}", n.getMetadata().getName()));

        final ResourceQuota quota = client.resourceQuotas().inNamespace(namespace).resource(
            new ResourceQuotaBuilder()
                .withNewMetadata().withName("quota-example").endMetadata()
                .withNewSpec().addToHard("pods", new Quantity("5")).endSpec()
                .build())
            .createOrReplace();
        logger.info("Create resource quota: {}", quota.getMetadata().getName());

        logger.info("Listing jobs in namespace");
        client.batch().v1().jobs().inNamespace(namespace).list().getItems()
            .forEach(j -> logger.info(" - {}", j.getMetadata().getName()));
      } finally {
        // Delete namespace
        client.namespaces().withName(namespace).delete();
        logger.info("Deleted namespace: {}", namespace);
      }
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      Throwable[] suppressed = e.getSuppressed();
      if (suppressed != null) {
        for (Throwable t : suppressed) {
          logger.error(t.getMessage(), t);
        }
      }
    }
  }
}
