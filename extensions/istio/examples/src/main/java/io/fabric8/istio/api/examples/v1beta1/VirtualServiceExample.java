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
package io.fabric8.istio.api.examples.v1beta1;

import io.fabric8.istio.api.networking.v1beta1.VirtualServiceBuilder;
import io.fabric8.istio.api.networking.v1beta1.VirtualServiceList;
import io.fabric8.istio.client.IstioClient;
import io.fabric8.kubernetes.client.KubernetesClientException;

public class VirtualServiceExample {

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
    System.out.println("Creating a virtual service");
    // Example from: https://istio.io/latest/docs/reference/config/networking/virtual-service/
    final String reviewsHost = "reviews.prod.svc.cluster.local";
    client.v1beta1().virtualServices().inNamespace(NAMESPACE).create(new VirtualServiceBuilder()
        .withNewMetadata()
        .withName("reviews-route")
        .endMetadata()
        .withNewSpec()
        .addToHosts(reviewsHost)
        .addNewHttp()
        .withName("reviews-v2-routes")
        .addNewMatch().withNewUri().withNewStringMatchPrefixType("/wpcatalog").endUri().endMatch()
        .addNewMatch().withNewUri().withNewStringMatchPrefixType("/consumercatalog").endUri().endMatch()
        .withNewRewrite().withUri("/newcatalog").endRewrite()
        .addNewRoute()
        .withNewDestination().withHost(reviewsHost).withSubset("v2").endDestination()
        .endRoute()
        .endHttp()
        .addNewHttp()
        .withName("reviews-v2-routes")
        .addNewRoute()
        .withNewDestination().withHost(reviewsHost).withSubset("v1").endDestination()
        .endRoute()
        .endHttp()
        .endSpec()
        .build());

    System.out.println("Listing Virtual Service Instances:");
    VirtualServiceList list = client.v1beta1().virtualServices().inNamespace(NAMESPACE).list();
    list.getItems().forEach(b -> System.out.println(b.getMetadata().getName()));
    System.out.println("Done");
  }
}
