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

import io.fabric8.istio.api.networking.v1beta1.Destination;
import io.fabric8.istio.api.networking.v1beta1.HTTPMatchRequestBuilder;
import io.fabric8.istio.api.networking.v1beta1.HTTPRewriteBuilder;
import io.fabric8.istio.api.networking.v1beta1.HTTPRouteBuilder;
import io.fabric8.istio.api.networking.v1beta1.HTTPRouteDestinationBuilder;
import io.fabric8.istio.api.networking.v1beta1.StringMatch;
import io.fabric8.istio.api.networking.v1beta1.StringMatchPrefix;
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
    client.v1beta1().virtualServices().inNamespace(NAMESPACE).create(new VirtualServiceBuilder()
      .withNewMetadata()
      .withName("reviews-route")
      .endMetadata()
      .withNewSpec()
      .withHosts("reviews-v2-routes")
      .withHttp(
        new HTTPRouteBuilder().withName("reviews-v2-routes")
          .withMatch(
            new HTTPMatchRequestBuilder().withUri(new StringMatch(new StringMatchPrefix("/wpcatalog"))).build(),
            new HTTPMatchRequestBuilder().withUri(new StringMatch(new StringMatchPrefix("/consumercatalog"))).build()
          )
          .withRewrite(new HTTPRewriteBuilder().withUri("/newcatalog").build())
          .withRoute(
            new HTTPRouteDestinationBuilder().withDestination(new Destination("reviews.prod.svc.cluster.local", null, "v2"))
              .build())
          .build()
      )
      .endSpec()
      .build());

    System.out.println("Listing Virtual Service Instances:");
    VirtualServiceList list = client.v1beta1().virtualServices().inNamespace(NAMESPACE).list();
    list.getItems().forEach(b -> System.out.println(b.getMetadata().getName()));
    System.out.println("Done");
  }
}
