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

import io.fabric8.istio.api.networking.v1beta1.IstioEgressListenerBuilder;
import io.fabric8.istio.api.networking.v1beta1.Sidecar;
import io.fabric8.istio.api.networking.v1beta1.SidecarBuilder;
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
class SidecarTest {

  IstioClient client;
  KubernetesMockServer server;

  @Test
  @DisplayName("Should get a Sidecar")
  void testGet() {
    Sidecar service2 = new SidecarBuilder().withNewMetadata().withName("service2").endMetadata().build();
    server.expect().get().withPath("/apis/networking.istio.io/v1beta1/namespaces/ns2/sidecars/service2")
        .andReturn(HttpURLConnection.HTTP_OK, service2)
        .once();

    Sidecar service = client.v1beta1().sidecars().inNamespace("ns2").withName("service2").get();
    assertNotNull(service);
    assertEquals("service2", service.getMetadata().getName());
  }

  @Test
  @DisplayName("Should Create a Sidecar")
  void testCreate() throws InterruptedException {
    // Example from: https://istio.io/latest/docs/reference/config/networking/sidecar/
    Sidecar service = new SidecarBuilder()
        .withNewMetadata()
        .withName("default")
        .endMetadata()
        .withNewSpec()
        .withEgress(new IstioEgressListenerBuilder()
            .withHosts("./*", "istio-system/*").build())
        .endSpec()
        .build();

    server.expect().post().withPath("/apis/networking.istio.io/v1beta1/namespaces/ns2/sidecars")
        .andReturn(HttpURLConnection.HTTP_OK, service)
        .once();
    service = client.v1beta1().sidecars().inNamespace("ns2").create(service);
    assertNotNull(service);

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("{\"apiVersion\":\"networking.istio.io/v1beta1\","
        + "\"kind\":\"Sidecar\","
        + "\"metadata\":{\"name\":\"default\"},"
        + "\"spec\":{\"egress\":[{\"hosts\":[\"./*\",\"istio-system/*\"]}]}}",
        recordedRequest.getBody().readUtf8());
  }

  @Test
  @DisplayName("Should Delete a Sidecar")
  void testDelete() throws InterruptedException {
    server.expect().delete().withPath("/apis/networking.istio.io/v1beta1/namespaces/ns3/sidecars/service3")
        .andReturn(HttpURLConnection.HTTP_OK, new SidecarBuilder().build())
        .once();
    Boolean deleted = client.v1beta1().sidecars().inNamespace("ns3").withName("service3").delete();
    assertTrue(deleted);

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("{\"apiVersion\":\"v1\",\"kind\":\"DeleteOptions\",\"propagationPolicy\":\"Background\"}",
        recordedRequest.getBody().readUtf8());
  }

  @Test
  @DisplayName("Should delete with PropagationPolicy=Orphan")
  void testDeleteOrphan() throws InterruptedException {
    server.expect().delete().withPath("/apis/networking.istio.io/v1beta1/namespaces/ns3/sidecars/service3")
        .andReturn(HttpURLConnection.HTTP_OK, new SidecarBuilder().build())
        .once();
    Boolean deleted = client.v1beta1().sidecars().inNamespace("ns3").withName("service3")
        .withPropagationPolicy(DeletionPropagation.ORPHAN).delete();
    assertTrue(deleted);

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("{\"apiVersion\":\"v1\",\"kind\":\"DeleteOptions\",\"propagationPolicy\":\"Orphan\"}",
        recordedRequest.getBody().readUtf8());
  }
}
