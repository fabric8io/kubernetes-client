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
package io.fabric8.kubernetes.client.dsl.internal.core.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.api.model.authentication.TokenRequest;
import io.fabric8.kubernetes.api.model.authentication.TokenRequestBuilder;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.ServiceAccountResource;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.http.TestHttpResponse;
import io.fabric8.kubernetes.client.impl.BaseClient;
import io.fabric8.kubernetes.client.utils.KubernetesSerialization;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static java.net.HttpURLConnection.HTTP_CREATED;
import static java.net.HttpURLConnection.HTTP_NOT_FOUND;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ServiceAccountOperationsImplTest {
  private ServiceAccountOperationsImpl serviceAccountOperations;
  private HttpClient mockedHttpClient;

  @BeforeEach
  void setUp() {
    Client mockedClient = mock(Client.class);
    BaseClient mockedBaseClient = mock(BaseClient.class);
    mockedHttpClient = mock(HttpClient.class);
    when(mockedClient.getConfiguration()).thenReturn(new ConfigBuilder()
        .withMasterUrl("http://test.kubernetes.server")
        .build());
    when(mockedClient.getHttpClient()).thenReturn(mockedHttpClient);
    when(mockedClient.adapt(BaseClient.class)).thenReturn(mockedBaseClient);
    when(mockedBaseClient.getKubernetesSerialization()).thenReturn(new KubernetesSerialization(new ObjectMapper(), false));
    serviceAccountOperations = new ServiceAccountOperationsImpl(mockedClient);
  }

  @Test
  void tokenRequest_whenApiServerCallSuccessful_thenReturnTokenInTokenRequestStatus() throws URISyntaxException {
    // Given
    String responseFromServer = "{\"kind\":\"TokenRequest\",\"apiVersion\":\"authentication.k8s.io/v1\"," +
        "\"status\":{\"token\":\"my.secret.token\",\"expirationTimestamp\":\"2023-06-14T18:42:15Z\"}}";
    HttpRequest.Builder mockHttpRequestBuilder = createMockHttpRequestBuilder();
    HttpRequest mockHttpRequest = createMockHttpRequest(mockHttpRequestBuilder);
    when(mockedHttpClient.sendAsync(mockHttpRequest, byte[].class))
        .thenReturn(CompletableFuture.completedFuture(new TestHttpResponse<byte[]>().withCode(HTTP_CREATED)
            .withBody(responseFromServer.getBytes(StandardCharsets.UTF_8))));
    TokenRequest tokenRequest = new TokenRequestBuilder()
        .withNewSpec()
        .withAudiences("http://example.svc")
        .endSpec()
        .build();

    // When
    TokenRequest updatedTokenRequest = serviceAccountOperations.inNamespace("test").withName("my-serviceaccount")
        .tokenRequest(tokenRequest);

    // Then
    verify(mockHttpRequestBuilder, times(1)).post(eq("application/json"), anyString());
    ArgumentCaptor<URL> urlArgumentCaptor = ArgumentCaptor.forClass(URL.class);
    verify(mockHttpRequestBuilder, times(1)).url(urlArgumentCaptor.capture());
    assertThat(urlArgumentCaptor.getValue()).hasPath("/api/v1/namespaces/test/serviceaccounts/my-serviceaccount/token");
    assertThat(updatedTokenRequest)
        .hasFieldOrPropertyWithValue("status.token", "my.secret.token")
        .hasFieldOrPropertyWithValue("status.expirationTimestamp", "2023-06-14T18:42:15Z");
  }

  @Test
  void tokenRequest_whenApiServerRequestFailure_thenThrowException() throws URISyntaxException {
    String responseFromServer = "{\"kind\":\"Status\",\"apiVersion\":\"v1\",\"status\":\"Failure\",\"message\":\"serviceaccount my-serviceaccount not found\",\"reason\":\"NotFound\",\"details\":{\"name\":\"my-service-account\",\"kind\":\"serviceaccounts\"},\"code\":404}";
    HttpRequest.Builder mockHttpRequestBuilder = createMockHttpRequestBuilder();
    HttpRequest mockHttpRequest = createMockHttpRequest(mockHttpRequestBuilder);
    when(mockedHttpClient.sendAsync(mockHttpRequest, byte[].class))
        .thenReturn(CompletableFuture.completedFuture(new TestHttpResponse<byte[]>().withCode(HTTP_NOT_FOUND)
            .withBody(responseFromServer.getBytes(StandardCharsets.UTF_8))));
    ServiceAccountResource serviceAccountResource = serviceAccountOperations.inNamespace("test").withName("my-serviceaccount");

    // When
    assertThatExceptionOfType(KubernetesClientException.class)
        .isThrownBy(serviceAccountResource::tokenRequest)
        .withMessageContaining("serviceaccount my-serviceaccount not found")
        .hasFieldOrPropertyWithValue("code", HTTP_NOT_FOUND)
        .hasFieldOrPropertyWithValue("status.code", HTTP_NOT_FOUND)
        .hasFieldOrPropertyWithValue("status.message", "serviceaccount my-serviceaccount not found")
        .hasFieldOrPropertyWithValue("status.reason", "NotFound");
  }

  private HttpRequest createMockHttpRequest(HttpRequest.Builder mockHttpRequestBuilder) throws URISyntaxException {
    HttpRequest mockHttpRequest = mock(HttpRequest.class);
    when(mockHttpRequestBuilder.build()).thenReturn(mockHttpRequest);
    when(mockHttpRequest.uri())
        .thenReturn(new URI("http://test.kubernetes.server/api/v1/namespaces/test/serviceaccounts/my-serviceaccount/token"));
    when(mockHttpRequest.method()).thenReturn("POST");
    return mockHttpRequest;
  }

  private HttpRequest.Builder createMockHttpRequestBuilder() {
    HttpRequest.Builder mockHttpRequestBuilder = mock(HttpRequest.Builder.class);
    when(mockedHttpClient.newHttpRequestBuilder()).thenReturn(mockHttpRequestBuilder);
    when(mockHttpRequestBuilder.post(anyString(), anyString())).thenReturn(mockHttpRequestBuilder);
    when(mockHttpRequestBuilder.url(any(URL.class))).thenReturn(mockHttpRequestBuilder);
    when(mockHttpRequestBuilder.timeout(anyLong(), any(TimeUnit.class))).thenReturn(mockHttpRequestBuilder);
    return mockHttpRequestBuilder;
  }
}
