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

import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinitionList;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class CRDLoadExample {
  private static Logger logger = LoggerFactory.getLogger(CRDLoadExample.class);

  public static void main(String args[]) throws IOException {
    try (final KubernetesClient client = new DefaultKubernetesClient()) {
      // List all Custom resources.
      log("Listing all current Custom Resource Definitions :");
      CustomResourceDefinitionList crdList = client.customResourceDefinitions().list();
      crdList.getItems().forEach(crd -> log(crd.getMetadata().getName()));

      // Creating a custom resource from yaml
      CustomResourceDefinition aCustomResourceDefinition = client.customResourceDefinitions().load(CRDLoadExample.class.getResourceAsStream("/crd.yml")).get();
      log("Creating CRD...");
      client.customResourceDefinitions().create(aCustomResourceDefinition);

      log("Updated Custom Resource Definitions: ");
      client.customResourceDefinitions().list().getItems().forEach(crd -> log(crd.getMetadata().getName()));

    }
  }

  private static void log(String action, Object obj) {
    logger.info("{}: {}", action, obj);
  }

  private static void log(String action) {
    logger.info(action);
  }
}
