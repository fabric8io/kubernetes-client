/**
 * Copyright (C) 2015 Fabric8 Authors.
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

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.ListMeta;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.ServiceBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.ParameterNamespaceListVisitFromServerGetDeleteRecreateWaitApplicable;
import io.fabric8.kubernetes.client.server.mock.KubernetesServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;

import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

@EnableRuleMigrationSupport
public class ServiceTest {
  @Rule
  public KubernetesServer server = new KubernetesServer();

  public Service service;

  @Before
  public void prepareService() {
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
  public void testLoad() {
    KubernetesClient client = server.getClient();
    Service svc = client.services().load(getClass().getResourceAsStream("/test-service.yml")).get();
    assertNotNull(svc);
    assertEquals("httpbin", svc.getMetadata().getName());
  }

  @Test
  public void testCreate() {
    server.expect().post()
      .withPath("/api/v1/namespaces/test/services")
      .andReturn(200, service)
      .once();

    KubernetesClient client = server.getClient();
    Service responseSvc = client.services().inNamespace("test").create(service);
    assertNotNull(responseSvc);
    assertEquals("httpbin", responseSvc.getMetadata().getName());
  }

  @Test
  public void testReplace() throws InterruptedException {
    Service serviceFromServer = new ServiceBuilder(service)
      .editOrNewSpec().withClusterIP("10.96.129.1").endSpec().build();

    server.expect().get()
      .withPath("/api/v1/namespaces/test/services/httpbin")
      .andReturn(200, serviceFromServer)
      .times(3);

    server.expect().put()
      .withPath("/api/v1/namespaces/test/services/httpbin")
      .andReturn(200, serviceFromServer)
      .once();

    KubernetesClient client = server.getClient();
    Service responseSvc = client.services().inNamespace("test").createOrReplace(service);
    assertNotNull(responseSvc);
    assertEquals("httpbin", responseSvc.getMetadata().getName());

    RecordedRequest recordedRequest = server.getLastRequest();
    assertEquals("PUT", recordedRequest.getMethod());
    assertEquals("{\"apiVersion\":\"v1\",\"kind\":\"Service\",\"metadata\":{\"labels\":{\"app\":\"httpbin\"},\"name\":\"httpbin\"},\"spec\":{\"clusterIP\":\"10.96.129.1\",\"ports\":[{\"name\":\"http\",\"port\":5511,\"targetPort\":8080}],\"selector\":{\"deploymentconfig\":\"httpbin\"}}}",
      recordedRequest.getBody().readUtf8());
  }

  @Test
  public void testDelete() {
    server.expect().delete()
      .withPath("/api/v1/namespaces/test/services/httpbin")
      .andReturn(200, service)
      .once();

    KubernetesClient client = server.getClient();
    boolean isDeleted = client.services().inNamespace("test").withName("httpbin").delete();
    assertTrue(isDeleted);
  }

  @Test
  public void testUpdate() {
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

    KubernetesClient client = server.getClient();
    Service responseFromServer = client.services().inNamespace("test").withName("httpbin").edit()
      .editOrNewMetadata().addToLabels("foo", "bar").endMetadata()
      .done();

    assertNotNull(responseFromServer);
    assertEquals("bar", responseFromServer.getMetadata().getLabels().get("foo"));
  }
}
