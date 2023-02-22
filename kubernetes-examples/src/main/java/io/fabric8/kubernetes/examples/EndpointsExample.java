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

import io.fabric8.kubernetes.api.model.Endpoints;
import io.fabric8.kubernetes.api.model.EndpointsBuilder;
import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.NamespaceBuilder;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is an example of creating Endpoint.
 */
public class EndpointsExample {

  private static final Logger logger = LoggerFactory.getLogger(EndpointsExample.class);

  private static final String NAMESPACE = "endpoints-example";

  public static void main(String[] args) {
    try (KubernetesClient client = new KubernetesClientBuilder().build()) {
      Namespace ns = new NamespaceBuilder().withNewMetadata().withName(NAMESPACE).addToLabels("this", "rocks").endMetadata()
          .build();
      logger.info("Created namespace: {}", client.namespaces().resource(ns).createOrReplace());
      try {
        logger.info("Namespace: {}", ns);
        Deployment deployment = client.apps().deployments().inNamespace(NAMESPACE)
            .load(EndpointsExample.class.getResourceAsStream("/endpoints-deployment.yml")).item();
        logger.info("Deployment created");
        client.apps().deployments().inNamespace(NAMESPACE).resource(deployment).create();

        Service service = client.services().inNamespace(NAMESPACE)
            .load(EndpointsExample.class.getResourceAsStream("/endpoints-service.yml")).item();
        logger.info("Service created");
        client.services().inNamespace(NAMESPACE).resource(service).create();

        Endpoints endpoints = new EndpointsBuilder()
            .withNewMetadata().withName("external-web").withNamespace(NAMESPACE).endMetadata()
            .withSubsets().addNewSubset().addNewAddress().withIp("10.10.50.53").endAddress()
            .addNewPort().withPort(80).withName("apache").endPort()
            .endSubset()
            .build();
        logger.info("Endpoint created");
        client.endpoints().inNamespace(NAMESPACE).resource(endpoints).create();
        logger.info("Endpoint url");
        endpoints = client.endpoints().inNamespace(NAMESPACE).withName("external-web").get();
        logger.info("Endpoint Port {}", endpoints.getSubsets().get(0).getPorts().get(0).getName());
      } catch (Exception e) {
        logger.error("Exception occurred: {}", e.getMessage(), e);
      } finally {
        client.namespaces().withName(NAMESPACE).delete();
      }
    }
  }

}
