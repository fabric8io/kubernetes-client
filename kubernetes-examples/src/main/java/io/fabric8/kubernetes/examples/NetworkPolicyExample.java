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

import io.fabric8.kubernetes.api.model.networking.NetworkPolicy;
import io.fabric8.kubernetes.api.model.networking.NetworkPolicyBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.rmi.CORBA.Util;
import java.util.HashMap;

/**
 * Created by hshinde on 1/6/18.
 */
public class NetworkPolicyExample {
  private static final Logger logger = LoggerFactory.getLogger(PodLogExample.class);

  public static void main(String[] args) {
    String namespace = "myproject";

    KubernetesClient client = new DefaultKubernetesClient();

    NetworkPolicy networkPolicy = new NetworkPolicyBuilder()
                                        .withNewMetadata()
                                          .withName("test-network-policy")
                                        .endMetadata()
                                        .withNewSpec()
                                        .withNewPodSelector()
                                          .withMatchLabels( new HashMap<String, String>() {{
                                            put("role","db");
                                          }})
                                        .endPodSelector()
                                        .endSpec()
                                  .build();


    // create polict using NetworkPolicyBuilder object
    networkPolicy = client.network()
      .networkPolicies()
      .create(networkPolicy);

    // crate policy using YAML reosurce
    networkPolicy = client.network()
                                    .networkPolicies()
                                    .inNamespace(namespace)
                                    .load(NetworkPolicyExample.class.getResourceAsStream("/network-policy.yml"))
                                    .createOrReplace();

  }
}
