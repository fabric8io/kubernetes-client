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

import io.fabric8.istio.api.networking.v1beta1.ServiceEntryBuilder;
import io.fabric8.istio.api.networking.v1beta1.ServiceEntryList;
import io.fabric8.istio.api.networking.v1beta1.ServiceEntryLocation;
import io.fabric8.istio.api.networking.v1beta1.ServicePortBuilder;
import io.fabric8.istio.client.IstioClient;
import io.fabric8.kubernetes.client.KubernetesClientException;

public class ServiceEntryExample {
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
    System.out.println("Creating a service entry");
    // Example from: https://istio.io/latest/docs/reference/config/networking/service-entry/
    client.v1beta1().serviceEntries().inNamespace(NAMESPACE).create(new ServiceEntryBuilder()
        .withNewMetadata()
        .withName("external-svc-https")
        .endMetadata()
        .withNewSpec()
        .withHosts("api.dropboxapi.com", "www.googleapis.com")
        .withLocation(ServiceEntryLocation.MESH_INTERNAL)
        .withPorts(new ServicePortBuilder().withName("https").withProtocol("TLS").withNumber(443).build())
        .endSpec()
        .build());

    System.out.println("Listing Virtual Service Instances:");
    ServiceEntryList list = client.v1beta1().serviceEntries().inNamespace(NAMESPACE).list();
    list.getItems().forEach(b -> System.out.println(b.getMetadata().getName()));
    System.out.println("Done");
  }
}
