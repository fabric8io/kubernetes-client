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
package io.fabric8.openshift.client.dsl.internal.build;

import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.http.HttpResponse;
import io.fabric8.kubernetes.client.impl.BaseClient;
import io.fabric8.kubernetes.client.utils.KubernetesSerialization;
import io.fabric8.openshift.client.OpenShiftConfigBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URI;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BuildConfigOperationsImplTest {

  private BaseClient client;
  private HttpClient httpClient;

  @BeforeEach
  public void setUp() {
    httpClient = mock(HttpClient.class, Mockito.RETURNS_DEEP_STUBS);

    HttpRequest response = mock(HttpRequest.class, Mockito.CALLS_REAL_METHODS);
    when(response.method()).thenReturn("POST");
    when(response.uri()).thenReturn(URI.create("https://localhost:8443/"));

    when(httpClient.newBuilder()
        .build()).thenReturn(httpClient);
    when(httpClient.newHttpRequestBuilder()
        .post(any(), any(), anyLong())
        .header(any(), any())
        .timeout(anyLong(), any())
        .uri(any(String.class))
        .build()).thenReturn(response);

    client = mock(BaseClient.class, Mockito.RETURNS_SELF);
    Mockito.when(client.getKubernetesSerialization()).thenReturn(new KubernetesSerialization());
    Mockito.when(client.getHttpClient()).thenReturn(httpClient);
    Mockito.when(client.getConfiguration())
        .thenReturn(new OpenShiftConfigBuilder().withMasterUrl("https://localhost:8443/").build());
  }

  @Test
  void requestTimeoutDefaultsToZero() {
    assertThat(new BuildConfigOperationsImpl(client).getOperationContext().getTimeout())
        .isZero();
  }

  @Test
  void withTimeoutOverridesRequestTimeout() {
    final BuildConfigOperationsImpl buildConfigOperations = new BuildConfigOperationsImpl(client)
        .withTimeout(1337, TimeUnit.MILLISECONDS);
    assertThat(buildConfigOperations.getOperationContext().getTimeout())
        .isEqualTo(1337);
  }

  @Test
  void withTimeoutInMillisOverridesRequestTimeout() {
    final BuildConfigOperationsImpl buildConfigOperations = new BuildConfigOperationsImpl(client)
        .withTimeoutInMillis(1337);
    assertThat(buildConfigOperations.getOperationContext().getTimeout())
        .isEqualTo(1337);
  }

  @Test
  void testWriteToThrowsExceptionShouldAddEvents() {
    // Given
    String eventMessage = "FailedScheduling demo-1-7zkjd.1619493da51f6b6f some error";

    BuildConfigOperationsImpl impl = new BuildConfigOperationsImpl(client) {
      @Override
      protected String getRecentEvents() {
        return eventMessage;
      };
    };

    // When
    ByteArrayInputStream inputStream = new ByteArrayInputStream(new byte[0]);
    CompletableFuture<HttpResponse<byte[]>> future = new CompletableFuture<>();
    future.completeExceptionally(new IOException());
    when(httpClient.sendAsync(any(), eq(byte[].class))).thenReturn(future);

    KubernetesClientException exception = assertThrows(KubernetesClientException.class,
        () -> impl.submitToApiServer(inputStream, 0));

    // Then
    assertTrue(exception.getMessage().contains(eventMessage));
  }

  @Test
  void testWriteShouldCompleteSuccessfully() {
    // Given
    BuildConfigOperationsImpl impl = new BuildConfigOperationsImpl(client) {
      @Override
      protected String getRecentEvents() {
        throw new AssertionError();
      };
    };

    HttpResponse<byte[]> response = mock(HttpResponse.class, Mockito.CALLS_REAL_METHODS);
    when(response.code()).thenReturn(200);
    when(response.body()).thenReturn(new byte[0]);

    when(httpClient.sendAsync(any(), eq(byte[].class))).thenReturn(CompletableFuture.completedFuture(response));
    impl.submitToApiServer(new ByteArrayInputStream(new byte[0]), 0);

    Mockito.verify(response, Mockito.times(1)).body();
  }
}
