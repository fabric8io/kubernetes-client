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
package io.fabric8.kubernetes.client.impl;

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.ServiceBuilder;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.PodResource;
import io.fabric8.kubernetes.client.dsl.base.PatchContext;
import io.fabric8.kubernetes.client.dsl.base.PatchType;
import io.fabric8.kubernetes.client.dsl.internal.OperationSupport;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.http.HttpRequest.Builder;
import io.fabric8.kubernetes.client.http.StandardHttpRequest;
import io.fabric8.kubernetes.client.http.TestHttpResponse;
import io.fabric8.kubernetes.client.utils.KubernetesSerialization;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class PatchTest {
  private HttpClient mockClient;
  private KubernetesClient kubernetesClient;
  private List<HttpRequest.Builder> builders;

  @BeforeEach
  public void setUp() throws IOException {
    // TODO: fully mocking makes this logic more difficult and basically copied in other tests, we may want to rely on an actual implementation instead
    builders = new ArrayList<>();
    this.mockClient = Mockito.mock(HttpClient.class, Mockito.RETURNS_DEEP_STUBS);
    when(mockClient.sendAsync(any(), Mockito.eq(byte[].class)))
        .thenReturn(CompletableFuture.completedFuture(TestHttpResponse.from(200, "{}")));
    Config config = new ConfigBuilder().withMasterUrl("https://localhost:8443/").build();
    kubernetesClient = new KubernetesClientImpl(mockClient, config, () -> Runnable::run,
        new KubernetesSerialization());
    when(mockClient.newHttpRequestBuilder()).thenAnswer(answer -> {
      HttpRequest.Builder result = Mockito.mock(HttpRequest.Builder.class, Mockito.RETURNS_SELF);
      when(result.build()).thenReturn(new StandardHttpRequest.Builder().uri("https://localhost:8443/").build());
      builders.add(result);
      return result;
    });
  }

  @AfterEach
  public void tearDown() {
    kubernetesClient.close();
    kubernetesClient = null;
  }

  @Test
  void testJsonPatch() {
    // Given

    // When
    kubernetesClient.pods().inNamespace("ns1").withName("foo")
        .patch("{\"metadata\":{\"annotations\":{\"bob\":\"martin\"}}}");

    // Then
    verify(mockClient, times(2)).sendAsync(any(), any());
    assertRequest("GET", "/api/v1/namespaces/ns1/pods/foo", null);
    assertRequest(1, "PATCH", "/api/v1/namespaces/ns1/pods/foo", null, OperationSupport.STRATEGIC_MERGE_JSON_PATCH);
  }

  @Test
  void testJsonMergePatch() {
    // Given
    PatchContext patchContext = new PatchContext.Builder()
        .withPatchType(PatchType.JSON_MERGE)
        .build();

    // When
    kubernetesClient.pods().inNamespace("ns1").withName("foo")
        .patch(patchContext, "{\"metadata\":{\"annotations\":{\"bob\":\"martin\"}}}");

    // Then
    verify(mockClient, times(2)).sendAsync(any(), any());
    assertRequest("GET", "/api/v1/namespaces/ns1/pods/foo", null);
    assertRequest(1, "PATCH", "/api/v1/namespaces/ns1/pods/foo", null, OperationSupport.JSON_MERGE_PATCH);
  }

  @Test
  void testYamlPatchConvertedToJson() {
    // Given

    // When
    kubernetesClient.pods().inNamespace("ns1").withName("foo").patch("metadata:\n  annotations:\n    bob: martin");

    // Then
    verify(mockClient, times(2)).sendAsync(any(), any());
    assertRequest("GET", "/api/v1/namespaces/ns1/pods/foo", null);
    assertRequest(1, "PATCH", "/api/v1/namespaces/ns1/pods/foo", null, OperationSupport.STRATEGIC_MERGE_JSON_PATCH);
  }

  @Test
  void testPatchThrowExceptionWhenResourceNotFound() {
    // Given
    when(mockClient.sendAsync(any(), Mockito.eq(byte[].class)))
        .thenReturn(CompletableFuture.completedFuture(new TestHttpResponse<byte[]>().withCode(404)));

    // When
    PodResource podResource = kubernetesClient.pods()
        .inNamespace("ns1")
        .withName("foo");
    KubernetesClientException e = assertThrows(KubernetesClientException.class,
        () -> podResource.patch("{\"metadata\":{\"annotations\":{\"bob\":\"martin\"}}}"));

    // Then
    verify(mockClient).sendAsync(any(), any());
    assertRequest("GET", "/api/v1/namespaces/ns1/pods/foo", null);
    assertEquals(HttpURLConnection.HTTP_NOT_FOUND, e.getCode());
  }

  @Test
  void testJsonPatchWithPositionalArrays() {
    // Given
    PatchContext patchContext = new PatchContext.Builder().withPatchType(PatchType.JSON).build();

    // When
    kubernetesClient.pods().inNamespace("ns1").withName("foo")
        .patch(patchContext,
            "[{\"op\": \"replace\", \"path\":\"/spec/containers/0/image\", \"value\":\"foo/gb-frontend:v4\"}]");

    // Then
    verify(mockClient, times(2)).sendAsync(any(), any());
    assertRequest("GET", "/api/v1/namespaces/ns1/pods/foo", null);
    assertRequest(1, "PATCH", "/api/v1/namespaces/ns1/pods/foo", null, OperationSupport.JSON_PATCH);
  }

  @Test
  void testPatchWithPatchOptions() {
    // Given

    // When
    kubernetesClient.pods().inNamespace("ns1").withName("foo")
        .patch(new PatchContext.Builder()
            .withFieldManager("fabric8")
            .withDryRun(Collections.singletonList("All"))
            .build(), "{\"metadata\":{\"annotations\":{\"bob\":\"martin\"}}}");

    // Then
    verify(mockClient, times(2)).sendAsync(any(), any());
    assertRequest("GET", "/api/v1/namespaces/ns1/pods/foo", null);
    assertRequest(1, "PATCH", "/api/v1/namespaces/ns1/pods/foo", "fieldManager=fabric8&dryRun=All",
        OperationSupport.STRATEGIC_MERGE_JSON_PATCH);
  }

  @Test
  void testServerSideApplyWithPatchOptions() {
    // Given

    // When
    kubernetesClient.pods().inNamespace("ns1")
        .resource(new PodBuilder().withNewMetadata().withName("pod1").endMetadata().build())
        .fieldManager("x").forceConflicts().serverSideApply();

    // Then
    verify(mockClient, times(1)).sendAsync(any(), any());
    assertRequest(0, "PATCH", "/api/v1/namespaces/ns1/pods/pod1", "fieldManager=x&force=true",
        PatchType.SERVER_SIDE_APPLY.getContentType());
  }

  @Test
  void testResourceListServerSideApply() {
    // Given
    Pod pod = new PodBuilder().withNewMetadata().withName("pod1").withNamespace("default").endMetadata().build();
    Service svc = new ServiceBuilder().withNewMetadata().withName("svc1").endMetadata().build();
    // When
    kubernetesClient.resourceList(pod, svc).inNamespace("ns1").fieldManager("x")
        .forceConflicts().serverSideApply();

    // Then
    verify(mockClient, times(2)).sendAsync(any(), any());
    assertRequest(0, "PATCH", "/api/v1/namespaces/ns1/pods/pod1", "fieldManager=x&force=true",
        PatchType.SERVER_SIDE_APPLY.getContentType());
    assertRequest(1, "PATCH", "/api/v1/namespaces/ns1/services/svc1", "fieldManager=x&force=true",
        PatchType.SERVER_SIDE_APPLY.getContentType());
  }

  private void assertRequest(String method, String url, String queryParam) {
    assertRequest(0, method, url, queryParam, null);
  }

  private void assertRequest(int index, String method, String url, String queryParam, String contentType) {
    ArgumentCaptor<URL> urlCaptor = ArgumentCaptor.forClass(URL.class);
    Builder mock = builders.get(index);
    verify(mock).url(urlCaptor.capture());
    URL capturedURL = urlCaptor.getValue();
    assertEquals(url, capturedURL.getPath());

    validateMethod(method, contentType, mock);

    assertEquals(queryParam, capturedURL.getQuery());
  }

  static void validateMethod(String method, String contentType, Builder mock) {
    ArgumentCaptor<String> contentTypeCaptor = ArgumentCaptor.forClass(String.class);
    switch (method) {
      case "DELETE":
        Mockito.verify(mock).delete(contentTypeCaptor.capture(), any());
        break;
      case "POST":
        Mockito.verify(mock).post(contentTypeCaptor.capture(), any(String.class));
        break;
      case "PUT":
        Mockito.verify(mock).put(contentTypeCaptor.capture(), any());
        break;
      case "PATCH":
        Mockito.verify(mock).patch(contentTypeCaptor.capture(), any());
        break;
      default:
        break; //TODO: validate GET, but that explicit call was removed
    }

    if (contentType != null) {
      assertEquals(contentType, contentTypeCaptor.getValue());
    }
  }

}
