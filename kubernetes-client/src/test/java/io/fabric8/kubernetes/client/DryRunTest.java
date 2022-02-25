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
package io.fabric8.kubernetes.client;

import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.ServiceBuilder;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.http.HttpRequest.Builder;
import io.fabric8.kubernetes.client.http.HttpResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class DryRunTest {
  private HttpClient mockClient;
  private KubernetesClient kubernetesClient;
  private List<HttpRequest.Builder> builders = new ArrayList<>();

  @BeforeEach
  public void setUp() throws IOException {
    builders.clear();
    this.mockClient = Mockito.mock(HttpClient.class, Mockito.RETURNS_DEEP_STUBS);
    Config config = new ConfigBuilder().withMasterUrl("https://localhost:8443/").build();
    HttpResponse<InputStream> mockResponse = MockHttpClientUtils.buildResponse(HttpURLConnection.HTTP_OK, "{}");
    when(mockClient.send(any(), Mockito.eq(InputStream.class))).thenReturn(mockResponse);
    kubernetesClient = new DefaultKubernetesClient(mockClient, config);
    Mockito.when(mockClient.newHttpRequestBuilder()).thenAnswer(answer -> {
      HttpRequest.Builder result = Mockito.mock(HttpRequest.Builder.class, Mockito.RETURNS_SELF);
      builders.add(result);
      return result;
    });
  }

  @Test
  void testDryRunDisable() throws IOException {
    // When
    Pod pod = kubernetesClient.pods().inNamespace("ns1").withName("foo").dryRun(false).create(getPod("pod1"));

    // Then
    verify(mockClient).send(any(), any());
    assertRequest("POST", "/api/v1/namespaces/ns1/pods", null);
    assertNotNull(pod);
  }

  @Test
  void testDryRunEnable() throws IOException {
    // When
    Pod pod = kubernetesClient.pods().inNamespace("ns1").withName("foo").dryRun(true).create(getPod("pod1"));

    // Then
    verify(mockClient).send(any(), any());
    assertRequest("POST", "/api/v1/namespaces/ns1/pods", "dryRun=All");
    assertNotNull(pod);
  }

  @Test
  void testCreate() throws IOException {
    // Given

    // When
    Pod pod = kubernetesClient.pods().inNamespace("ns1").withName("foo").dryRun().create(getPod("pod1"));

    // Then
    verify(mockClient).send(any(), any());
    assertRequest("POST", "/api/v1/namespaces/ns1/pods", "dryRun=All");
    assertNotNull(pod);
  }

  @Test
  void testCreateOrReplace() throws IOException {
    // Given

    // When
    Pod pod = kubernetesClient.pods().inNamespace("ns1").withName("foo").dryRun().createOrReplace(getPod("pod1"));

    // Then
    verify(mockClient).send(any(), any());
    assertNotNull(pod);
    assertRequest("POST", "/api/v1/namespaces/ns1/pods", "dryRun=All");
  }

  @Test
  void testPatch() throws IOException {
    // Given

    // When
    kubernetesClient.pods().inNamespace("ns1").withName("pod1").dryRun().patch(getPod("pod1"));

    // Then
    verify(mockClient, times(2)).send(any(), any());
    assertRequest(1, "PATCH", "/api/v1/namespaces/ns1/pods/pod1", "dryRun=All");
  }

  @Test
  void testReplace() throws IOException {
    // Given

    // When
    kubernetesClient.pods().inNamespace("ns1").withName("pod1").dryRun().replace(getPod("pod1"));

    // Then
    verify(mockClient, times(2)).send(any(), any());
    assertRequest(1, "PUT", "/api/v1/namespaces/ns1/pods/pod1", "dryRun=All");
  }

  @Test
  void testDelete() throws IOException {
    // Given

    // When
    kubernetesClient.pods().inNamespace("ns1").withName("pod1").dryRun().withPropagationPolicy(DeletionPropagation.BACKGROUND).delete();

    // Then
    verify(mockClient).send(any(), any());
    assertRequest("DELETE", "/api/v1/namespaces/ns1/pods/pod1", "dryRun=All");
  }

  @Test
  void testResourceCreateOrReplace() throws IOException {
    // Given

    // When
    kubernetesClient.resource(getPod("pod1")).inNamespace("ns1").dryRun().createOrReplace();

    // Then
    verify(mockClient).send(any(), any());
    assertRequest("POST", "/api/v1/namespaces/ns1/pods", "dryRun=All");
  }

  @Test
  void testResourceDelete() throws IOException {
    // Given

    // When
    kubernetesClient.resource(getPod("pod1")).inNamespace("ns1").dryRun().withPropagationPolicy(DeletionPropagation.BACKGROUND).delete();

    // Then
    verify(mockClient).send(any(), any());
    assertRequest("DELETE", "/api/v1/namespaces/ns1/pods/pod1", "dryRun=All");
  }

  @Test
  void testResourceListCreateOrReplace() throws IOException {
    // Given
    Pod pod = getPod("pod1");
    Service svc = new ServiceBuilder().withNewMetadata().withName("svc1").endMetadata().build();

    // When
    kubernetesClient.resourceList(pod, svc).inNamespace("ns1").dryRun().createOrReplace();

    // Then
    verify(mockClient, times(2)).send(any(), any());
    assertRequest("POST", "/api/v1/namespaces/ns1/pods", "dryRun=All");
    assertRequest(1, "POST", "/api/v1/namespaces/ns1/services", "dryRun=All");
  }

  @Test
  void testResourceListDelete() throws IOException {
    // Given
    Pod pod = getPod("pod1");
    Service svc = new ServiceBuilder().withNewMetadata().withName("svc1").endMetadata().build();

    // When
    kubernetesClient.resourceList(pod, svc).inNamespace("ns1").dryRun().withPropagationPolicy(DeletionPropagation.BACKGROUND).delete();

    // Then
    verify(mockClient, times(2)).send(any(), any());
    assertRequest("DELETE", "/api/v1/namespaces/ns1/pods/pod1", "dryRun=All");
    assertRequest(1, "DELETE", "/api/v1/namespaces/ns1/services/svc1", "dryRun=All");
  }

  private Pod getPod(String name) {
    return new PodBuilder().withNewMetadata().withName(name).endMetadata().build();
  }

  private void assertRequest(String method, String url, String queryParam) {
    assertRequest(0, method, url, queryParam);
  }
  
  private void assertRequest(int index, String method, String url, String queryParam) {
    ArgumentCaptor<URL> urlCaptor = ArgumentCaptor.forClass(URL.class);
    Builder mock = builders.get(index);
    verify(mock).url(urlCaptor.capture());
    
    URL capturedURL = urlCaptor.getValue();
    assertEquals(url, capturedURL.getPath());
    PatchTest.validateMethod(method, null, mock);
    
    assertEquals(queryParam, capturedURL.getQuery());
  }
}
