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

import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.ServiceBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.Optional;

public class ServiceExample {

  private static final Logger logger = LoggerFactory.getLogger(ServiceExample.class);

  public static void main(String[] args) {
    try (KubernetesClient client = new KubernetesClientBuilder().build()) {
      String namespace = Optional.ofNullable(client.getNamespace()).orElse("default");
      if (args.length > 0) {
        namespace = args[0];
      }
      Service service = new ServiceBuilder()
          .withNewMetadata()
          .withName("my-service")
          .endMetadata()
          .withNewSpec()
          .withSelector(Collections.singletonMap("app", "MyApp"))
          .addNewPort()
          .withName("test-port")
          .withProtocol("TCP")
          .withPort(80)
          .withTargetPort(new IntOrString(9376))
          .endPort()
          .withType("LoadBalancer")
          .endSpec()
          .build();

      service = client.services().inNamespace(namespace).resource(service).create();
      logger.info("Created service with name {}", service.getMetadata().getName());

      String serviceURL = client.services().inNamespace(namespace).withName(service.getMetadata().getName())
          .getURL("test-port");
      logger.info("Service URL {}", serviceURL);
    }
  }
}
