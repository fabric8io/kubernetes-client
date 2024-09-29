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
package io.fabric8.openshift;

import io.fabric8.junit.jupiter.api.KubernetesTest;
import io.fabric8.junit.jupiter.api.RequireK8sSupport;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.ServiceBuilder;
import io.fabric8.kubernetes.client.dsl.NonDeletingOperation;
import io.fabric8.openshift.api.model.Route;
import io.fabric8.openshift.api.model.RouteBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@KubernetesTest(createEphemeralNamespace = false)
@RequireK8sSupport(Route.class)
class ServiceToURLIT {

  OpenShiftClient client;

  @BeforeEach
  public void init() {
    Service svc1 = new ServiceBuilder()
        .withNewMetadata()
        .withName("svc1")
        .endMetadata()
        .withNewSpec()
        .withSelector(Collections.singletonMap("app", "MyApp"))
        .addNewPort()
        .withName("http")
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
    Service svc2 = new ServiceBuilder()
        .withNewMetadata().withName("svc2").endMetadata()
        .withNewSpec().withType("ExternalName").withExternalName("my.database.example.com")
        .addNewPort().withName("80").withProtocol("TCP").withPort(80).endPort()
        .endSpec()
        .withNewStatus()
        .withNewLoadBalancer()
        .addNewIngress()
        .withIp("146.148.47.155")
        .endIngress()
        .endLoadBalancer()
        .endStatus()
        .build();

    client.services().resource(svc1).createOr(NonDeletingOperation::update);
    client.services().resource(svc2).createOr(NonDeletingOperation::update);
  }

  @Test
  void getURL() {
    // Testing NodePort Impl
    String url = client.services().withName("svc1").getURL("http");
    assertNotNull(url);

    // Testing Ingress Impl
    if (client.supports(io.fabric8.kubernetes.api.model.extensions.Ingress.class)) {
      io.fabric8.kubernetes.api.model.extensions.Ingress ingress = client.extensions().ingresses()
          .load(getClass().getResourceAsStream("/test-ingress-extensions.yml"))
          .item();
      client.extensions().ingresses().resource(ingress).create();
    } else if (client.supports(io.fabric8.kubernetes.api.model.networking.v1.Ingress.class)) {
      io.fabric8.kubernetes.api.model.networking.v1.Ingress ingress = client.network().v1().ingresses()
          .load(getClass().getResourceAsStream("/service-to-url-it-network-v1-ingress.yml"))
          .item();
      client.network().v1().ingresses().resource(ingress).create();
    }

    url = client.services().withName("svc2").getURL("80");
    assertNotNull(url);

    // Testing OpenShift Route Impl
    Service svc3 = client.services().resource(new ServiceBuilder()
        .withNewMetadata().withName("svc3").endMetadata()
        .withNewSpec()
        .addNewPort().withName("80").withProtocol("TCP").withPort(80).endPort()
        .endSpec()
        .build())
        .create();

    OpenShiftClient openshiftClient = client.adapt(OpenShiftClient.class);
    openshiftClient.routes().resource(new RouteBuilder()
        .withNewMetadata().withName(svc3.getMetadata().getName()).endMetadata()
        .withNewSpec()
        .withHost("www.example.com")
        .withNewTo().withName(svc3.getMetadata().getName()).withKind("Service").endTo()
        .endSpec()
        .build())
        .create();

    url = client.services().withName("svc3").getURL("80");
    assertNotNull(url);
  }
}
