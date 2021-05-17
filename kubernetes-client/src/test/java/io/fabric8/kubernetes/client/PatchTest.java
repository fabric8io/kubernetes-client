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

import io.fabric8.kubernetes.client.dsl.base.PatchContext;
import io.fabric8.kubernetes.client.dsl.base.PatchType;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Collections;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class PatchTest {
  private Call mockCall;
  private OkHttpClient mockClient;
  private KubernetesClient kubernetesClient;

  @BeforeEach
  public void setUp() throws IOException {
    this.mockClient = Mockito.mock(OkHttpClient.class, Mockito.RETURNS_DEEP_STUBS);
    Config config = new ConfigBuilder().withMasterUrl("https://localhost:8443/").build();
    mockCall = mock(Call.class);
    Response mockResponse = new Response.Builder()
      .request(new Request.Builder().url("http://mock").build())
      .protocol(Protocol.HTTP_1_1)
      .code(HttpURLConnection.HTTP_OK)
      .body(ResponseBody.create(MediaType.get("application/json"), "{\"metadata\":{\"name\":\"foo\"}}"))
      .message("mock")
      .build();
    when(mockCall.execute())
      .thenReturn(mockResponse, mockResponse);
    when(mockClient.newCall(any())).thenReturn(mockCall);
    kubernetesClient = new DefaultKubernetesClient(mockClient, config);
  }

  @Test
  void testJsonPatch() {
    // Given
    ArgumentCaptor<Request> captor = ArgumentCaptor.forClass(Request.class);

    // When
    kubernetesClient.pods().inNamespace("ns1").withName("foo")
      .patch("{\"metadata\":{\"annotations\":{\"bob\":\"martin\"}}}");

    // Then
    verify(mockClient, times(2)).newCall(captor.capture());
    assertRequest(captor.getAllValues().get(0), "GET", "/api/v1/namespaces/ns1/pods/foo", null);
    assertRequest(captor.getAllValues().get(1), "PATCH", "/api/v1/namespaces/ns1/pods/foo", null);
    assertBodyContentType("strategic-merge-patch+json", captor.getAllValues().get(1));
  }

  @Test
  void testJsonMergePatch() {
    // Given
    ArgumentCaptor<Request> captor = ArgumentCaptor.forClass(Request.class);
    PatchContext patchContext = new PatchContext.Builder()
      .withPatchType(PatchType.JSON_MERGE)
      .build();

    // When
    kubernetesClient.pods().inNamespace("ns1").withName("foo")
      .patch(patchContext, "{\"metadata\":{\"annotations\":{\"bob\":\"martin\"}}}");

    // Then
    verify(mockClient, times(2)).newCall(captor.capture());
    assertRequest(captor.getAllValues().get(0), "GET", "/api/v1/namespaces/ns1/pods/foo", null);
    assertRequest(captor.getAllValues().get(1), "PATCH", "/api/v1/namespaces/ns1/pods/foo", null);
    assertBodyContentType("merge-patch+json", captor.getAllValues().get(1));
  }

  @Test
  void testYamlPatchConvertedToJson() {
    // Given
    ArgumentCaptor<Request> captor = ArgumentCaptor.forClass(Request.class);

    // When
    kubernetesClient.pods().inNamespace("ns1").withName("foo").patch("metadata:\n  annotations:\n    bob: martin");

    // Then
    verify(mockClient, times(2)).newCall(captor.capture());
    assertRequest(captor.getAllValues().get(0), "GET", "/api/v1/namespaces/ns1/pods/foo", null);
    assertRequest(captor.getAllValues().get(1), "PATCH", "/api/v1/namespaces/ns1/pods/foo", null);
    assertBodyContentType("strategic-merge-patch+json", captor.getAllValues().get(1));
  }

  @Test
  void testPatchThrowExceptionWhenResourceNotFound() throws IOException {
    // Given
    when(mockCall.execute()).thenReturn(new Response.Builder()
      .request(new Request.Builder().url("http://mock").build())
      .protocol(Protocol.HTTP_1_1)
      .code(HttpURLConnection.HTTP_NOT_FOUND)
      .body(ResponseBody.create(MediaType.get("application/json"), "{}"))
      .message("mock")
      .build());
    ArgumentCaptor<Request> captor = ArgumentCaptor.forClass(Request.class);

    // When
    KubernetesClientException e = assertThrows(KubernetesClientException.class,
        () -> kubernetesClient.pods()
            .inNamespace("ns1")
            .withName("foo")
            .patch("{\"metadata\":{\"annotations\":{\"bob\":\"martin\"}}}"));

    // Then
    verify(mockClient, times(1)).newCall(captor.capture());
    assertRequest(captor.getValue(), "GET", "/api/v1/namespaces/ns1/pods/foo", null);
    assertEquals(HttpURLConnection.HTTP_NOT_FOUND, e.getCode());
  }

  @Test
  void testJsonPatchWithPositionalArrays() {
    // Given
    ArgumentCaptor<Request> captor = ArgumentCaptor.forClass(Request.class);
    PatchContext patchContext = new PatchContext.Builder().withPatchType(PatchType.JSON).build();

    // When
    kubernetesClient.pods().inNamespace("ns1").withName("foo")
      .patch(patchContext, "[{\"op\": \"replace\", \"path\":\"/spec/containers/0/image\", \"value\":\"foo/gb-frontend:v4\"}]");

    // Then
    verify(mockClient, times(2)).newCall(captor.capture());
    assertRequest(captor.getAllValues().get(0), "GET", "/api/v1/namespaces/ns1/pods/foo", null);
    assertRequest(captor.getAllValues().get(1), "PATCH", "/api/v1/namespaces/ns1/pods/foo", null);
    assertBodyContentType("json-patch+json", captor.getAllValues().get(1));
  }

  @Test
  void testPatchWithPatchOptions() {
    // Given
    ArgumentCaptor<Request> captor = ArgumentCaptor.forClass(Request.class);

    // When
    kubernetesClient.pods().inNamespace("ns1").withName("foo")
      .patch(new PatchContext.Builder()
        .withFieldManager("fabric8")
        .withDryRun(Collections.singletonList("All"))
        .build(), "{\"metadata\":{\"annotations\":{\"bob\":\"martin\"}}}");

    // Then
    verify(mockClient, times(2)).newCall(captor.capture());
    assertRequest(captor.getAllValues().get(0), "GET", "/api/v1/namespaces/ns1/pods/foo", null);
    assertRequest(captor.getAllValues().get(1), "PATCH", "/api/v1/namespaces/ns1/pods/foo", "fieldManager=fabric8&dryRun=All");
    assertBodyContentType("strategic-merge-patch+json", captor.getAllValues().get(1));
  }

  private void assertRequest(Request request, String method, String url, String queryParam) {
    assertThat(request.url().encodedPath()).isEqualTo(url);
    assertThat(request.method()).isEqualTo(method);
    assertThat(request.url().encodedQuery()).isEqualTo(queryParam);
  }

  private void assertBodyContentType(String expectedContentSubtype, Request request) {
    AssertionsForClassTypes.assertThat(request.body().contentType()).isNotNull();
    AssertionsForClassTypes.assertThat(request.body().contentType().type()).isEqualTo("application");
    AssertionsForClassTypes.assertThat(request.body().contentType().subtype()).isEqualTo(expectedContentSubtype);
  }
}
