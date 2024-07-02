/*
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

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.http.TestHttpResponse;
import io.fabric8.kubernetes.client.utils.KubernetesSerialization;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class APIVersionsTest {
  private HttpClient mockClient;
  private KubernetesClient kubernetesClient;
  private List<HttpRequest.Builder> builders;

  @BeforeEach
  public void setUp() throws IOException {
    builders = new ArrayList<>();
    this.mockClient = Mockito.mock(HttpClient.class, Mockito.RETURNS_DEEP_STUBS);
    Config config = new ConfigBuilder().withMasterUrl("https://localhost:8443/").build();
    when(mockClient.sendAsync(any(), Mockito.eq(byte[].class)))
        .thenReturn(CompletableFuture.completedFuture(TestHttpResponse.from(200,
            "{\"kind\":\"Pod\", \"apiVersion\":\"v1\"}")));
    kubernetesClient = new KubernetesClientImpl(mockClient, config, () -> Runnable::run,
        new KubernetesSerialization());
    Mockito.when(mockClient.newHttpRequestBuilder()).thenAnswer(answer -> {
      HttpRequest.Builder result = Mockito.mock(HttpRequest.Builder.class, Mockito.RETURNS_SELF);
      builders.add(result);
      return result;
    });
  }

  @AfterEach
  void tearDown() {
    kubernetesClient.close();
    kubernetesClient = null;
  }

  @Test
  void getApiVersions() {
    // When
    kubernetesClient.getAPIVersions();
    // Then
    verify(mockClient).sendAsync(any(), any());
    ArgumentCaptor<String> stringCaptor = ArgumentCaptor.forClass(String.class);
    verify(builders.get(0)).uri(stringCaptor.capture());
    assertThat(stringCaptor.getValue())
        .isEqualTo("https://localhost:8443/api");
  }
}
