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
package io.fabric8.istio.test.v1beta1;

import io.fabric8.istio.api.networking.v1beta1.DestinationRule;
import io.fabric8.istio.api.networking.v1beta1.DestinationRuleBuilder;
import io.fabric8.istio.api.networking.v1beta1.LoadBalancerSettingsBuilder;
import io.fabric8.istio.api.networking.v1beta1.LoadBalancerSettingsConsistentHash;
import io.fabric8.istio.api.networking.v1beta1.LoadBalancerSettingsConsistentHashLBBuilder;
import io.fabric8.istio.api.networking.v1beta1.LoadBalancerSettingsConsistentHashLBHttpHeaderName;
import io.fabric8.istio.api.networking.v1beta1.LoadBalancerSettingsSimple;
import io.fabric8.istio.api.networking.v1beta1.LoadBalancerSettingsSimpleLB;
import io.fabric8.istio.client.IstioClient;
import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableKubernetesMockClient
class DestinationRuleTest {

  IstioClient client;
  KubernetesMockServer server;

  @Test
  @DisplayName("Should get a Destination Rule")
  void testGet() {
    DestinationRule service2 = new DestinationRuleBuilder().withNewMetadata().withName("service2").endMetadata().build();
    server.expect().get().withPath("/apis/networking.istio.io/v1beta1/namespaces/ns2/destinationrules/service2")
        .andReturn(HttpURLConnection.HTTP_OK, service2)
        .once();

    DestinationRule service = client.v1beta1().destinationRules().inNamespace("ns2").withName("service2").get();
    assertNotNull(service);
    assertEquals("service2", service.getMetadata().getName());
  }

  @Test
  @DisplayName("Should Create a Destination Rule with simple settings")
  void testCreateWithSimpleSettings() throws InterruptedException {
    // Example from: https://istio.io/latest/docs/reference/config/networking/destination-rule/
    DestinationRule service = new DestinationRuleBuilder()
        .withNewMetadata()
        .withName("reviews-route")
        .endMetadata()
        .withNewSpec()
        .withHost("ratings.prod.svc.cluster.local")
        .withNewTrafficPolicy()
        .withLoadBalancer(
            new LoadBalancerSettingsBuilder().withLbPolicy(new LoadBalancerSettingsSimple(LoadBalancerSettingsSimpleLB.RANDOM))
                .build())
        .endTrafficPolicy()
        .endSpec()
        .build();

    server.expect().post().withPath("/apis/networking.istio.io/v1beta1/namespaces/ns2/destinationrules")
        .andReturn(HttpURLConnection.HTTP_OK, service)
        .once();
    service = client.v1beta1().destinationRules().inNamespace("ns2").create(service);
    assertNotNull(service);

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("{\"apiVersion\":\"networking.istio.io/v1beta1\","
        + "\"kind\":\"DestinationRule\","
        + "\"metadata\":{\"name\":\"reviews-route\"},"
        + "\"spec\":{"
        + "\"host\":\"ratings.prod.svc.cluster.local\","
        + "\"trafficPolicy\":{\"loadBalancer\":{\"simple\":\"RANDOM\"}}}}",
        recordedRequest.getBody().readUtf8());
  }

  @Test
  @DisplayName("Should Create a Destination Rule with consistent hash settings")
  void testCreateWithConsistentHashSettings() throws InterruptedException {
    // Example from: https://istio.io/latest/docs/reference/config/networking/destination-rule/
    DestinationRule service = new DestinationRuleBuilder()
        .withNewMetadata()
        .withName("reviews-route")
        .endMetadata()
        .withNewSpec()
        .withHost("ratings.prod.svc.cluster.local")
        .withNewTrafficPolicy()
        .withLoadBalancer(
            new LoadBalancerSettingsBuilder().withLbPolicy(
                new LoadBalancerSettingsConsistentHash(new LoadBalancerSettingsConsistentHashLBBuilder().withHashKey(
                    new LoadBalancerSettingsConsistentHashLBHttpHeaderName("x-user")).build()))
                .build())
        .endTrafficPolicy()
        .endSpec()
        .build();

    server.expect().post().withPath("/apis/networking.istio.io/v1beta1/namespaces/ns2/destinationrules")
        .andReturn(HttpURLConnection.HTTP_OK, service)
        .once();
    service = client.v1beta1().destinationRules().inNamespace("ns2").create(service);
    assertNotNull(service);

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("{\"apiVersion\":\"networking.istio.io/v1beta1\","
        + "\"kind\":\"DestinationRule\","
        + "\"metadata\":{\"name\":\"reviews-route\"},"
        + "\"spec\":{"
        + "\"host\":\"ratings.prod.svc.cluster.local\","
        + "\"trafficPolicy\":{\"loadBalancer\":{\"consistentHash\":{\"httpHeaderName\":\"x-user\"}}}}}",
        recordedRequest.getBody().readUtf8());
  }

  @Test
  @DisplayName("Should Delete a Destination Rule")
  void testDelete() throws InterruptedException {
    server.expect().delete().withPath("/apis/networking.istio.io/v1beta1/namespaces/ns3/destinationrules/service3")
        .andReturn(HttpURLConnection.HTTP_OK, new DestinationRuleBuilder().build())
        .once();
    boolean deleted = client.v1beta1().destinationRules().inNamespace("ns3").withName("service3").delete().size() == 1;
    assertTrue(deleted);

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("{\"apiVersion\":\"v1\",\"kind\":\"DeleteOptions\",\"propagationPolicy\":\"Background\"}",
        recordedRequest.getBody().readUtf8());
  }

  @Test
  @DisplayName("Should delete with PropagationPolicy=Orphan")
  void testDeleteOrphan() throws InterruptedException {
    server.expect().delete().withPath("/apis/networking.istio.io/v1beta1/namespaces/ns3/destinationrules/service3")
        .andReturn(HttpURLConnection.HTTP_OK, new DestinationRuleBuilder().build())
        .once();
    Boolean deleted = client.v1beta1().destinationRules().inNamespace("ns3").withName("service3")
        .withPropagationPolicy(DeletionPropagation.ORPHAN).delete().size() == 1;
    assertTrue(deleted);

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("{\"apiVersion\":\"v1\",\"kind\":\"DeleteOptions\",\"propagationPolicy\":\"Orphan\"}",
        recordedRequest.getBody().readUtf8());
  }
}
