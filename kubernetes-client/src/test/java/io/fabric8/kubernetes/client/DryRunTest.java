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
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.io.IOException;
import java.net.HttpURLConnection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class DryRunTest {
  private OkHttpClient mockClient;
  private KubernetesClient kubernetesClient;

  @BeforeEach
  public void setUp() throws IOException {
    this.mockClient = Mockito.mock(OkHttpClient.class, Mockito.RETURNS_DEEP_STUBS);
    Config config = new ConfigBuilder().withMasterUrl("https://localhost:8443/").build();
    Call mockCall = mock(Call.class);
    Response mockResponse = new Response.Builder()
      .request(new Request.Builder().url("http://mock").build())
      .protocol(Protocol.HTTP_1_1)
      .code(HttpURLConnection.HTTP_OK)
      .body(ResponseBody.create(MediaType.get("application/json"), "{}"))
      .message("mock")
      .build();
    when(mockCall.execute())
      .thenReturn(mockResponse);
    when(mockClient.newCall(any())).thenReturn(mockCall);
    kubernetesClient = new DefaultKubernetesClient(mockClient, config);
  }

  @Test
  void testDryRunDisable() {
    ArgumentCaptor<Request> captor = ArgumentCaptor.forClass(Request.class);

    // When
    Pod pod = kubernetesClient.pods().inNamespace("ns1").withName("foo").dryRun(false).create(getPod("pod1"));

    // Then
    verify(mockClient).newCall(captor.capture());
    assertRequest(captor.getValue(), "POST", "/api/v1/namespaces/ns1/pods", null);
    assertNotNull(pod);
  }

  @Test
  void testDryRunEnable() {
    ArgumentCaptor<Request> captor = ArgumentCaptor.forClass(Request.class);

    // When
    Pod pod = kubernetesClient.pods().inNamespace("ns1").withName("foo").dryRun(true).create(getPod("pod1"));

    // Then
    verify(mockClient).newCall(captor.capture());
    assertRequest(captor.getValue(), "POST", "/api/v1/namespaces/ns1/pods", "dryRun=All");
    assertNotNull(pod);
  }

  @Test
  void testCreate() {
    // Given
    ArgumentCaptor<Request> captor = ArgumentCaptor.forClass(Request.class);

    // When
    Pod pod = kubernetesClient.pods().inNamespace("ns1").withName("foo").dryRun().create(getPod("pod1"));

    // Then
    verify(mockClient).newCall(captor.capture());
    assertRequest(captor.getValue(), "POST", "/api/v1/namespaces/ns1/pods", "dryRun=All");
    assertNotNull(pod);
  }

  @Test
  void testCreateOrReplace() {
    // Given
    ArgumentCaptor<Request> captor = ArgumentCaptor.forClass(Request.class);

    // When
    Pod pod = kubernetesClient.pods().inNamespace("ns1").withName("foo").dryRun().createOrReplace(getPod("pod1"));

    // Then
    verify(mockClient).newCall(captor.capture());
    assertNotNull(pod);
    assertRequest(captor.getValue(), "POST", "/api/v1/namespaces/ns1/pods", "dryRun=All");
  }

  @Test
  void testPatch() {
    // Given
    ArgumentCaptor<Request> captor = ArgumentCaptor.forClass(Request.class);

    // When
    kubernetesClient.pods().inNamespace("ns1").withName("pod1").dryRun().patch(getPod("pod1"));

    // Then
    verify(mockClient, times(2)).newCall(captor.capture());
    assertRequest(captor.getValue(), "PATCH", "/api/v1/namespaces/ns1/pods/pod1", "dryRun=All");
  }

  @Test
  void testReplace() {
    // Given
    ArgumentCaptor<Request> captor = ArgumentCaptor.forClass(Request.class);

    // When
    kubernetesClient.pods().inNamespace("ns1").withName("pod1").dryRun().replace(getPod("pod1"));

    // Then
    verify(mockClient, times(2)).newCall(captor.capture());
    assertRequest(captor.getValue(), "PUT", "/api/v1/namespaces/ns1/pods/pod1", "dryRun=All");
  }

  @Test
  void testDelete() {
    // Given
    ArgumentCaptor<Request> captor = ArgumentCaptor.forClass(Request.class);

    // When
    kubernetesClient.pods().inNamespace("ns1").withName("pod1").dryRun().withPropagationPolicy(DeletionPropagation.BACKGROUND).delete();

    // Then
    verify(mockClient).newCall(captor.capture());
    assertRequest(captor.getValue(), "DELETE", "/api/v1/namespaces/ns1/pods/pod1", "dryRun=All");
  }

  @Test
  void testResourceCreateOrReplace() {
    // Given
    ArgumentCaptor<Request> captor = ArgumentCaptor.forClass(Request.class);

    // When
    kubernetesClient.resource(getPod("pod1")).inNamespace("ns1").dryRun().createOrReplace();

    // Then
    verify(mockClient, times(1)).newCall(captor.capture());
    assertRequest(captor.getValue(), "POST", "/api/v1/namespaces/ns1/pods", "dryRun=All");
  }

  @Test
  void testResourceDelete() {
    // Given
    ArgumentCaptor<Request> captor = ArgumentCaptor.forClass(Request.class);

    // When
    kubernetesClient.resource(getPod("pod1")).inNamespace("ns1").dryRun().withPropagationPolicy(DeletionPropagation.BACKGROUND).delete();

    // Then
    verify(mockClient).newCall(captor.capture());
    assertRequest(captor.getValue(), "DELETE", "/api/v1/namespaces/ns1/pods/pod1", "dryRun=All");
  }

  @Test
  void testResourceListCreateOrReplace() {
    // Given
    Pod pod = getPod("pod1");
    Service svc = new ServiceBuilder().withNewMetadata().withName("svc1").endMetadata().build();
    ArgumentCaptor<Request> captor = ArgumentCaptor.forClass(Request.class);

    // When
    kubernetesClient.resourceList(pod, svc).inNamespace("ns1").dryRun().createOrReplace();

    // Then
    verify(mockClient, times(2)).newCall(captor.capture());
    assertRequest(captor.getAllValues().get(0), "POST", "/api/v1/namespaces/ns1/services", "dryRun=All");
    assertRequest(captor.getAllValues().get(1), "POST", "/api/v1/namespaces/ns1/pods", "dryRun=All");
  }

  @Test
  void testResourceListDelete() {
    // Given
    Pod pod = getPod("pod1");
    Service svc = new ServiceBuilder().withNewMetadata().withName("svc1").endMetadata().build();
    ArgumentCaptor<Request> captor = ArgumentCaptor.forClass(Request.class);

    // When
    kubernetesClient.resourceList(pod, svc).inNamespace("ns1").dryRun().withPropagationPolicy(DeletionPropagation.BACKGROUND).delete();

    // Then
    verify(mockClient, times(2)).newCall(captor.capture());
    assertRequest(captor.getAllValues().get(0), "DELETE", "/api/v1/namespaces/ns1/services/svc1", "dryRun=All");
    assertRequest(captor.getAllValues().get(1), "DELETE", "/api/v1/namespaces/ns1/pods/pod1", "dryRun=All");
  }

  private Pod getPod(String name) {
    return new PodBuilder().withNewMetadata().withName(name).endMetadata().build();
  }

  private void assertRequest(Request request, String method, String url, String queryParam) {
    assertEquals(url, request.url().encodedPath());
    assertEquals(method, request.method());
    assertEquals(queryParam, request.url().encodedQuery());
  }
}
