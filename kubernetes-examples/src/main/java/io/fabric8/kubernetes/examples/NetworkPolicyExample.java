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

import io.fabric8.kubernetes.api.model.networking.v1.NetworkPolicy;
import io.fabric8.kubernetes.api.model.networking.v1.NetworkPolicyBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;

/**
 * Created by hshinde on 1/6/18.
 */
public class NetworkPolicyExample {
  private static final Logger logger = LoggerFactory.getLogger(NetworkPolicyExample.class);

  public static void main(String[] args) {
    String namespace = "default";
    if (args.length > 0) {
      namespace = args[0];
    }
    try (KubernetesClient client = new KubernetesClientBuilder().build()) {
      NetworkPolicy networkPolicy = new NetworkPolicyBuilder()
          .withNewMetadata()
          .withName("test-network-policy")
          .endMetadata()
          .withNewSpec()
          .withNewPodSelector()
          .withMatchLabels(Collections.singletonMap("role", "db"))
          .endPodSelector()
          .endSpec()
          .build();

      // create policy using NetworkPolicyBuilder object
      networkPolicy = client.network()
          .v1()
          .networkPolicies()
          .inNamespace(namespace)
          .resource(networkPolicy)
          .createOrReplace();
      logger.info("NetworkPolicy {}/{} created via builders", namespace, networkPolicy.getMetadata().getName());

      // crate policy using YAML resource
      networkPolicy = client.network()
          .v1()
          .networkPolicies()
          .inNamespace(namespace)
          .load(NetworkPolicyExample.class.getResourceAsStream("/network-policy.yml"))
          .createOrReplace();
      logger.info("NetworkPolicy {}/{} created via YAML manifest", namespace, networkPolicy.getMetadata().getName());

    }
  }
}
