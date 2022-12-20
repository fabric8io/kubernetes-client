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
package io.fabric8.kubernetes.client.mock;

import io.fabric8.kubernetes.api.model.EndpointAddressBuilder;
import io.fabric8.kubernetes.api.model.EndpointPortBuilder;
import io.fabric8.kubernetes.api.model.EndpointSubsetBuilder;
import io.fabric8.kubernetes.api.model.Endpoints;
import io.fabric8.kubernetes.api.model.EndpointsBuilder;
import io.fabric8.kubernetes.api.model.EndpointsListBuilder;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.ServiceBuilder;
import io.fabric8.kubernetes.api.model.ServiceListBuilder;
import io.fabric8.kubernetes.api.model.extensions.IngressListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@EnableKubernetesMockClient
class ServiceTest {

  KubernetesMockServer server;
  KubernetesClient client;

  Service service;

  @BeforeEach
  void prepareService() {
    service = new ServiceBuilder()
        .withNewMetadata()
        .withName("httpbin")
        .withLabels(Collections.singletonMap("app", "httpbin"))
        .endMetadata()
        .withNewSpec()
        .addNewPort()
        .withName("http")
        .withPort(5511)
        .withTargetPort(new IntOrString(8080))
        .endPort()
        .addToSelector("deploymentconfig", "httpbin")
        .endSpec()
        .build();
  }

  @Test
  void testLoad() {
    Service svc = client.services().load(getClass().getResourceAsStream("/test-service.yml")).item();
    assertNotNull(svc);
    assertEquals("httpbin", svc.getMetadata().getName());
  }

  @Test
  void testCreate() {
    server.expect().post()
        .withPath("/api/v1/namespaces/test/services")
        .andReturn(200, service)
        .once();

    Service responseSvc = client.services().inNamespace("test").create(service);
    assertNotNull(responseSvc);
    assertEquals("httpbin", responseSvc.getMetadata().getName());
  }

  @Test
  void testReplace() throws InterruptedException {
    helpTestReplace(client.services());
  }

  @Test
  void testReplaceWithResources() throws InterruptedException {
    helpTestReplace(client.resources(Service.class));
  }

  private void helpTestReplace(MixedOperation<Service, ?, ? extends Resource<Service>> services)
      throws InterruptedException {
    Service serviceFromServer = new ServiceBuilder(service)
        .editOrNewSpec().withClusterIP("10.96.129.1").endSpec().build();
    Service serviceUpdated = new ServiceBuilder(service)
        .editOrNewSpec().withClusterIP("10.96.129.1").endSpec()
        .editMetadata().addToAnnotations("foo", "bar").endMetadata()
        .build();

    server.expect().get()
        .withPath("/api/v1/namespaces/test/services/httpbin")
        .andReturn(HttpURLConnection.HTTP_OK, serviceFromServer)
        .times(3);

    server.expect().post()
        .withPath("/api/v1/namespaces/test/services")
        .andReturn(HttpURLConnection.HTTP_CONFLICT, serviceFromServer)
        .once();

    server.expect().put()
        .withPath("/api/v1/namespaces/test/services/httpbin")
        .andReturn(HttpURLConnection.HTTP_OK, serviceUpdated)
        .once();

    Service responseSvc = services.inNamespace("test")
        .createOrReplace(new ServiceBuilder(service).editMetadata()
            .addToAnnotations("foo", "bar")
            .endMetadata()
            .build());
    assertNotNull(responseSvc);
    assertEquals("httpbin", responseSvc.getMetadata().getName());

    RecordedRequest recordedRequest = server.getLastRequest();
    assertEquals("PUT", recordedRequest.getMethod());
    assertEquals(
        "{\"apiVersion\":\"v1\",\"kind\":\"Service\",\"metadata\":{\"annotations\":{\"foo\":\"bar\"},\"labels\":{\"app\":\"httpbin\"},\"name\":\"httpbin\"},\"spec\":{\"clusterIP\":\"10.96.129.1\",\"ports\":[{\"name\":\"http\",\"port\":5511,\"targetPort\":8080}],\"selector\":{\"deploymentconfig\":\"httpbin\"}}}",
        recordedRequest.getBody().readUtf8());
  }

  @Test
  void testDelete() {
    server.expect().delete()
        .withPath("/api/v1/namespaces/test/services/httpbin")
        .andReturn(200, service)
        .once();

    boolean isDeleted = client.services().inNamespace("test").withName("httpbin").delete().size() == 1;
    assertTrue(isDeleted);
  }

  @Test
  void testUpdate() {
    Service serviceFromServer = new ServiceBuilder(service)
        .editOrNewMetadata().addToLabels("foo", "bar").endMetadata()
        .editOrNewSpec().withClusterIP("10.96.129.1").endSpec().build();

    server.expect().get()
        .withPath("/api/v1/namespaces/test/services/httpbin")
        .andReturn(200, serviceFromServer)
        .times(3);
    server.expect().patch()
        .withPath("/api/v1/namespaces/test/services/httpbin")
        .andReturn(200, serviceFromServer)
        .once();

    Service responseFromServer = client.services().inNamespace("test").withName("httpbin").edit(s -> new ServiceBuilder(s)
        .editOrNewMetadata().addToLabels("foo", "bar").endMetadata()
        .build());

    assertNotNull(responseFromServer);
    assertEquals("bar", responseFromServer.getMetadata().getLabels().get("foo"));
  }

  @Test
  void testGetUrlFromClusterIPService() {
    // Given
    Service service = new ServiceBuilder()
        .withNewMetadata().withName("svc1").endMetadata()
        .withNewSpec()
        .withClusterIP("187.30.14.32")
        .addNewPort()
        .withName("http")
        .withPort(8080)
        .withProtocol("TCP")
        .withNewTargetPort(8080)
        .endPort()
        .withType("ClusterIP")
        .endSpec()
        .build();
    server.expect().get().withPath("/api/v1/namespaces/ns1/services/svc1")
        .andReturn(HttpURLConnection.HTTP_OK, service).always();
    server.expect().get().withPath("/apis/extensions/v1beta1/namespaces/ns1/ingresses")
        .andReturn(HttpURLConnection.HTTP_OK, new IngressListBuilder().build()).always();

    // When
    String url = client.services().inNamespace("ns1").withName("svc1").getURL("http");

    // Then
    assertEquals("tcp://187.30.14.32:8080", url);
  }

  @Test
  void testWaitUntilReady() throws InterruptedException {
    // Given
    Service svc1 = new ServiceBuilder().withNewMetadata().withName("svc1").endMetadata().build();
    Endpoints endpoint = new EndpointsBuilder()
        .withNewMetadata().withName("svc1").endMetadata()
        .addToSubsets(new EndpointSubsetBuilder()
            .addToAddresses(new EndpointAddressBuilder().withIp("192.168.64.13").build())
            .addToPorts(new EndpointPortBuilder().withPort(8443).build())
            .build())
        .build();
    server.expect().get().withPath("/api/v1/namespaces/ns1/endpoints?fieldSelector=metadata.name%3Dsvc1")
        .andReturn(HttpURLConnection.HTTP_OK,
            new EndpointsListBuilder().withItems(endpoint).withNewMetadata().withResourceVersion("1").endMetadata().build())
        .once();
    server.expect().get().withPath("/api/v1/namespaces/ns1/services?fieldSelector=metadata.name%3Dsvc1")
        .andReturn(HttpURLConnection.HTTP_OK,
            new ServiceListBuilder().withItems(svc1).withNewMetadata().withResourceVersion("1").endMetadata().build())
        .once();
    server.expect().get().withPath("/api/v1/namespaces/ns1/services/svc1")
        .andReturn(HttpURLConnection.HTTP_OK, svc1)
        .once();

    // When
    Service service = client.services()
        .inNamespace("ns1")
        .withName("svc1")
        .waitUntilReady(60, TimeUnit.SECONDS);

    // Then
    assertNotNull(service);
  }
}
