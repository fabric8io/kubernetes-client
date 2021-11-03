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
import io.fabric8.openshift.client.OpenShiftConfig;
import io.fabric8.openshift.client.OpenShiftConfigBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

class BuildConfigOperationsImplTest {
  @Mock
  HttpClient httpClient;

  @Mock
  OpenShiftConfig config;

  @BeforeEach
  public void setUp() {
    this.httpClient = Mockito.mock(HttpClient.class, Mockito.RETURNS_DEEP_STUBS);

    HttpRequest response = Mockito.mock(HttpRequest.class, Mockito.CALLS_REAL_METHODS);
    when(response.method()).thenReturn("POST");
    when(response.uri()).thenReturn(URI.create("https://localhost:8443/"));

    when(this.httpClient.newBuilder()
        .readTimeout(anyLong(), any())
        .writeTimeout(anyLong(), any())
        .build()).thenReturn(httpClient);
    when(this.httpClient.newHttpRequestBuilder()
        .post(any(), any(), anyLong())
        .header(any(), any())
        .uri(any(String.class))
        .build()).thenReturn(response);

    this.config = new OpenShiftConfigBuilder().withMasterUrl("https://localhost:8443/").build();
  }

  @Test
  void testWriteToThrowsExceptionShouldAddEvents() throws IOException {
    // Given
    String eventMessage = "FailedScheduling demo-1-7zkjd.1619493da51f6b6f some error";

    BuildConfigOperationsImpl impl = new BuildConfigOperationsImpl(httpClient, config) {
      @Override
      protected String getRecentEvents() {
        return eventMessage;
      };
    };

    // When
    KubernetesClientException exception = assertThrows(KubernetesClientException.class,
      () -> impl.submitToApiServer(new ByteArrayInputStream(new byte[0]), 0));

    // Then
    assertTrue(exception.getMessage().contains(eventMessage));
  }

  @Test
  void testWriteShouldCompleteSuccessfully() throws IOException {
    // Given
    BuildConfigOperationsImpl impl = new BuildConfigOperationsImpl(httpClient, config) {
      @Override
      protected String getRecentEvents() {
        throw new AssertionError();
      };
    };

    HttpResponse<InputStream> response = Mockito.mock(HttpResponse.class, Mockito.CALLS_REAL_METHODS);
    when(response.code()).thenReturn(200);
    when(response.body()).thenReturn(new ByteArrayInputStream(new byte[0]));

    when(httpClient.send(any(), eq(InputStream.class))).thenReturn(response);
    impl.submitToApiServer(new ByteArrayInputStream(new byte[0]), 0);

    Mockito.verify(response, Mockito.times(1)).body();
  }
}
