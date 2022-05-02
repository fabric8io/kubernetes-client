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
package io.fabric8.knative.test;

import io.fabric8.knative.client.KnativeClient;
import io.fabric8.knative.serving.v1.Service;
import io.fabric8.knative.serving.v1.ServiceBuilder;
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
class ServiceTest {

  KnativeClient client;
  KubernetesMockServer server;

  @Test
  @DisplayName("Should get a Knative Service")
  void testGet() {
    Service service2 = new ServiceBuilder().withNewMetadata().withName("service2").endMetadata().build();
    server.expect().get().withPath("/apis/serving.knative.dev/v1/namespaces/ns2/services/service2")
        .andReturn(HttpURLConnection.HTTP_OK, service2)
        .once();

    Service service = client.services().inNamespace("ns2").withName("service2").get();
    assertNotNull(service);
    assertEquals("service2", service.getMetadata().getName());
  }

  @Test
  @DisplayName("Should Create a Knative Service")
  void testCreate() {
    Service service = new ServiceBuilder().withNewMetadata().withName("service").endMetadata().build();
    server.expect().post().withPath("/apis/serving.knative.dev/v1/namespaces/ns2/services")
        .andReturn(HttpURLConnection.HTTP_OK, service)
        .once();
    service = client.services().inNamespace("ns2").create(service);
    assertNotNull(service);
  }

  @Test
  @DisplayName("Should Delete a Knative Service")
  void testDelete() throws InterruptedException {
    server.expect().delete().withPath("/apis/serving.knative.dev/v1/namespaces/ns3/services/service3")
        .andReturn(HttpURLConnection.HTTP_OK, new ServiceBuilder().build())
        .once();
    boolean deleted = client.services().inNamespace("ns3").withName("service3").delete().size() == 1;
    assertTrue(deleted);

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("{\"apiVersion\":\"v1\",\"kind\":\"DeleteOptions\",\"propagationPolicy\":\"Background\"}",
        recordedRequest.getBody().readUtf8());
  }

  @Test
  @DisplayName("Should delete with PropagationPolicy=Orphan")
  void testDeleteOrphan() throws InterruptedException {
    server.expect().delete().withPath("/apis/serving.knative.dev/v1/namespaces/ns3/services/service3")
        .andReturn(HttpURLConnection.HTTP_OK, new ServiceBuilder().build())
        .once();
    Boolean deleted = client.services().inNamespace("ns3").withName("service3")
        .withPropagationPolicy(DeletionPropagation.ORPHAN).delete().size() == 1;
    assertTrue(deleted);

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("{\"apiVersion\":\"v1\",\"kind\":\"DeleteOptions\",\"propagationPolicy\":\"Orphan\"}",
        recordedRequest.getBody().readUtf8());
  }
}
