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

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.client.dsl.PodResource;
import io.fabric8.kubernetes.client.dsl.base.PatchContext;
import io.fabric8.kubernetes.client.dsl.base.PatchType;
import io.fabric8.kubernetes.client.dsl.internal.OperationSupport;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.http.HttpRequest.Builder;
import io.fabric8.kubernetes.client.http.HttpResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
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
  private List<HttpRequest.Builder> builders = new ArrayList<>();

  @BeforeEach
  public void setUp() throws IOException {
    // TODO: fully mocking makes this logic more difficult and basically copied in other tests, we may want to rely on an actual implementation instead
    builders.clear();
    this.mockClient = Mockito.mock(HttpClient.class, Mockito.RETURNS_DEEP_STUBS);
    Config config = new ConfigBuilder().withMasterUrl("https://localhost:8443/").build();
    HttpResponse<byte[]> mockResponse = MockHttpClientUtils.buildResponse(HttpURLConnection.HTTP_OK, "{}");
    when(mockClient.sendAsync(any(), Mockito.eq(byte[].class)))
        .thenReturn(CompletableFuture.completedFuture(mockResponse));
    kubernetesClient = new DefaultKubernetesClient(mockClient, config);
    Mockito.when(mockClient.newHttpRequestBuilder()).thenAnswer(answer -> {
      HttpRequest.Builder result = Mockito.mock(HttpRequest.Builder.class, Mockito.RETURNS_SELF);
      HttpRequest request = Mockito.mock(HttpRequest.class, Mockito.RETURNS_DEEP_STUBS);
      Mockito.when(request.uri()).thenReturn(URI.create("https://localhost:8443/"));
      Mockito.when(result.build()).thenReturn(request);
      builders.add(result);
      return result;
    });
  }

  @Test
  void testJsonPatch() throws IOException {
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
  void testJsonMergePatch() throws IOException {
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
  void testYamlPatchConvertedToJson() throws IOException {
    // Given

    // When
    kubernetesClient.pods().inNamespace("ns1").withName("foo").patch("metadata:\n  annotations:\n    bob: martin");

    // Then
    verify(mockClient, times(2)).sendAsync(any(), any());
    assertRequest("GET", "/api/v1/namespaces/ns1/pods/foo", null);
    assertRequest(1, "PATCH", "/api/v1/namespaces/ns1/pods/foo", null, OperationSupport.STRATEGIC_MERGE_JSON_PATCH);
  }

  @Test
  void testPatchThrowExceptionWhenResourceNotFound() throws IOException {
    // Given
    HttpResponse<byte[]> mockResponse = MockHttpClientUtils.buildResponse(HttpURLConnection.HTTP_NOT_FOUND, "{}");
    when(mockClient.sendAsync(any(), Mockito.eq(byte[].class)))
        .thenReturn(CompletableFuture.completedFuture(mockResponse));

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
  void testJsonPatchWithPositionalArrays() throws IOException {
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
  void testPatchWithPatchOptions() throws IOException {
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
