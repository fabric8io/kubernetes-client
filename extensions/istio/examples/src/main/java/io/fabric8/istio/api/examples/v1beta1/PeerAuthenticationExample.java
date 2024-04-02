/*
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
package io.fabric8.istio.api.examples.v1beta1;

import io.fabric8.istio.api.security.v1beta1.PeerAuthenticationBuilder;
import io.fabric8.istio.api.security.v1beta1.PeerAuthenticationList;
import io.fabric8.istio.api.security.v1beta1.PeerAuthenticationMutualTLSBuilder;
import io.fabric8.istio.api.security.v1beta1.PeerAuthenticationMutualTLSMode;
import io.fabric8.istio.api.type.v1beta1.WorkloadSelectorBuilder;
import io.fabric8.istio.client.IstioClient;
import io.fabric8.kubernetes.client.KubernetesClientException;

public class PeerAuthenticationExample {
  private static final String NAMESPACE = "test";

  public static void main(String[] args) {
    try {
      IstioClient client = ClientFactory.newClient(args);
      createResource(client);
      System.exit(0);
    } catch (KubernetesClientException ex) {
      System.err.println("Failed with " + ex.getMessage());
      System.exit(1);
    }
  }

  public static void createResource(IstioClient client) {
    System.out.println("Creating a PeerAuthentication entry");
    client.v1beta1().peerAuthentications().inNamespace(NAMESPACE).create(new PeerAuthenticationBuilder()
        .withNewMetadata()
        .withName("details-svc")
        .endMetadata()
        .withNewSpec()
        .withSelector(new WorkloadSelectorBuilder().addToMatchLabels("app", "reviews").build())
        .withMtls(new PeerAuthenticationMutualTLSBuilder().withMode(PeerAuthenticationMutualTLSMode.DISABLE).build())
        .endSpec()
        .build());

    System.out.println("Listing workload entry instances:");
    PeerAuthenticationList list = client.v1beta1().peerAuthentications().inNamespace(NAMESPACE).list();
    list.getItems().forEach(b -> System.out.println(b.getMetadata().getName()));
    System.out.println("Done");
  }
}
