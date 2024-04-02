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
package io.fabric8.istio.test.v1beta1;

import io.fabric8.istio.api.security.v1beta1.PeerAuthentication;
import io.fabric8.istio.api.security.v1beta1.PeerAuthenticationBuilder;
import io.fabric8.istio.api.security.v1beta1.PeerAuthenticationMutualTLSBuilder;
import io.fabric8.istio.api.security.v1beta1.PeerAuthenticationMutualTLSMode;
import io.fabric8.istio.api.type.v1beta1.WorkloadSelectorBuilder;
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
class PeerAuthenticationTest {

  IstioClient client;
  KubernetesMockServer server;

  @Test
  @DisplayName("Should get a PeerAuthentication Entry")
  void testGet() {
    PeerAuthentication service2 = new PeerAuthenticationBuilder().withNewMetadata().withName("service2").endMetadata().build();
    server.expect().get().withPath("/apis/security.istio.io/v1beta1/namespaces/ns2/peerauthentications/service2")
        .andReturn(HttpURLConnection.HTTP_OK, service2)
        .once();

    PeerAuthentication service = client.v1beta1().peerAuthentications().inNamespace("ns2").withName("service2").get();
    assertNotNull(service);
    assertEquals("service2", service.getMetadata().getName());
  }

  @Test
  @DisplayName("Should Create a PeerAuthentication Entry")
  void testCreate() throws InterruptedException {
    PeerAuthentication service = new PeerAuthenticationBuilder()
        .withNewMetadata()
        .withName("details-svc")
        .endMetadata()
        .withNewSpec()
        .withSelector(new WorkloadSelectorBuilder().addToMatchLabels("app", "reviews").build())
        .withMtls(new PeerAuthenticationMutualTLSBuilder().withMode(PeerAuthenticationMutualTLSMode.STRICT).build())
        .endSpec()
        .build();

    server.expect().post().withPath("/apis/security.istio.io/v1beta1/namespaces/ns2/peerauthentications")
        .andReturn(HttpURLConnection.HTTP_OK, service)
        .once();
    service = client.v1beta1().peerAuthentications().inNamespace("ns2").create(service);
    assertNotNull(service);

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("{\"apiVersion\":\"security.istio.io/v1beta1\","
        + "\"kind\":\"PeerAuthentication\","
        + "\"metadata\":{\"name\":\"details-svc\"},"
        + "\"spec\":{\"mtls\":{\"mode\":\"STRICT\"},\"selector\":{\"matchLabels\":{\"app\":\"reviews\"}}}}",
        recordedRequest.getBody().readUtf8());
  }

  @Test
  @DisplayName("Should Delete a PeerAuthentication Entry")
  void testDelete() throws InterruptedException {
    server.expect().delete().withPath("/apis/security.istio.io/v1beta1/namespaces/ns3/peerauthentications/service3")
        .andReturn(HttpURLConnection.HTTP_OK, new PeerAuthenticationBuilder().build())
        .once();
    boolean deleted = client.v1beta1().peerAuthentications().inNamespace("ns3").withName("service3").delete().size() == 1;
    assertTrue(deleted);

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("{\"apiVersion\":\"v1\",\"kind\":\"DeleteOptions\",\"propagationPolicy\":\"Background\"}",
        recordedRequest.getBody().readUtf8());
  }

  @Test
  @DisplayName("Should delete with PropagationPolicy=Orphan")
  void testDeleteOrphan() throws InterruptedException {
    server.expect().delete().withPath("/apis/security.istio.io/v1beta1/namespaces/ns3/peerauthentications/service3")
        .andReturn(HttpURLConnection.HTTP_OK, new PeerAuthenticationBuilder().build())
        .once();
    Boolean deleted = client.v1beta1().peerAuthentications().inNamespace("ns3").withName("service3")
        .withPropagationPolicy(DeletionPropagation.ORPHAN).delete().size() == 1;
    assertTrue(deleted);

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("{\"apiVersion\":\"v1\",\"kind\":\"DeleteOptions\",\"propagationPolicy\":\"Orphan\"}",
        recordedRequest.getBody().readUtf8());
  }
}
