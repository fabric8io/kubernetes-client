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
import io.fabric8.kubernetes.client.APIGroupNotAvailableException;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NamespaceQuotaExample {
  private static final Logger logger = LoggerFactory.getLogger(NamespaceQuotaExample.class);

  public static void main(String[] args) throws InterruptedException {
    String master = "https://localhost:8443";

    if (args.length == 1) {
      master = args[0];
    }

    Config config = new ConfigBuilder().withMasterUrl(master).build();
    try (final KubernetesClient client = new DefaultKubernetesClient(config)) {
      String namespace = "namespacetest";
      if (args.length > 2) {
        namespace = args[2];
      }
      try  {
        // Creating namespace
        Namespace ns = new NamespaceBuilder().withNewMetadata().withName(namespace).addToLabels("hello", "world").endMetadata().build();
        log("Created namespace", client.namespaces().create(ns));

        // Get namespace by name
        log("Get namespace by name", client.namespaces().withName(namespace).get());
        // Get namespace by label
        log("Get namespace by label", client.namespaces().withLabel("hello", "world").list());

        ResourceQuota quota = new ResourceQuotaBuilder().withNewMetadata().withName("quota-example").endMetadata().withNewSpec().addToHard("pods", new Quantity("5")).endSpec().build();
        log("Create resource quota", client.resourceQuotas().inNamespace(namespace).create(quota));

        try {
          log("Get jobs in namespace", client.batch().jobs().inNamespace(namespace).list());
        } catch (APIGroupNotAvailableException e) {
          log("Skipping jobs example - extensions API group not available");
        }
      } finally {
        // Delete namespace
        log("Deleted namespace", client.namespaces().withName(namespace).delete());
      }
    } catch (Exception e) {
      e.printStackTrace();
      logger.error(e.getMessage(), e);

      Throwable[] suppressed = e.getSuppressed();
      if (suppressed != null) {
        for (Throwable t : suppressed) {
          logger.error(t.getMessage(), t);
        }
      }
    }
  }

  private static void log(String action, Object obj) {
    logger.info("{}: {}", action, obj);
  }

  private static void log(String action) {
    logger.info(action);
  }
}
