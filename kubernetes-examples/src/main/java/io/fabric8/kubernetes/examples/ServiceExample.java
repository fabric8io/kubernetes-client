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
import io.fabric8.kubernetes.api.model.extensions.Ingress;
import io.fabric8.kubernetes.api.model.extensions.IngressBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;

public class ServiceExample {
  private static final Logger logger = LoggerFactory.getLogger(ServiceExample.class);

  public static void main(String args[]) {
    try (final KubernetesClient client = new DefaultKubernetesClient()) {
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
        .withNewStatus()
        .withNewLoadBalancer()
        .addNewIngress()
        .withIp("146.148.47.155")
        .endIngress()
        .endLoadBalancer()
        .endStatus()
        .build();

      service = client.services().inNamespace(client.getNamespace()).create(service);
      log("Created service with name ", service.getMetadata().getName());

      String serviceURL = client.services().inNamespace(client.getNamespace()).withName(service.getMetadata().getName()).getURL("test-port");
      log("Service URL", serviceURL);

    }
  }

  private static void log(String action, Object obj) {
    logger.info("{}: {}", action, obj);
  }

  private static void log(String action) {
    logger.info(action);
  }
}
