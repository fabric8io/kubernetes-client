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

import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionList;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CRDLoadExample {

  private static final Logger logger = LoggerFactory.getLogger(CRDLoadExample.class);

  public static void main(String[] args) {
    try (final KubernetesClient client = new KubernetesClientBuilder().build()) {
      // List all Custom resources.
      logger.info("Listing all current Custom Resource Definitions :");
      CustomResourceDefinitionList crdList = client.apiextensions().v1().customResourceDefinitions().list();
      crdList.getItems().forEach(crd -> logger.info(crd.getMetadata().getName()));

      // Creating a custom resource from yaml
      CustomResourceDefinition aCustomResourceDefinition = client.apiextensions().v1().customResourceDefinitions()
          .load(CRDLoadExample.class.getResourceAsStream("/crd.yml")).item();
      logger.info("Creating CRD...");
      client.apiextensions().v1().customResourceDefinitions().resource(aCustomResourceDefinition).create();

      logger.info("Updated Custom Resource Definitions: ");
      client.apiextensions().v1().customResourceDefinitions().list().getItems()
          .forEach(crd -> logger.info(crd.getMetadata().getName()));

    }
  }
}
