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

import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.ServiceBuilder;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.FieldValidateable.Validation;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.http.HttpRequest.Builder;
import io.fabric8.kubernetes.client.http.TestHttpResponse;
import io.fabric8.kubernetes.client.utils.KubernetesSerialization;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class DryRunTest {

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
  void testDryRunDisable() {
    // When
    Pod pod = kubernetesClient.pods().inNamespace("ns1").withName("foo").dryRun(false).create(withPod("pod1"));
    // Then
    verify(mockClient).sendAsync(any(), any());
    assertRequest("POST", "/api/v1/namespaces/ns1/pods", null);
    assertNotNull(pod);
  }

  @Test
  void testDryRunEnable() {
    // When
    Pod pod = kubernetesClient.pods().inNamespace("ns1").withName("foo").dryRun(true).create(withPod("pod1"));
    // Then
    verify(mockClient).sendAsync(any(), any());
    assertRequest("POST", "/api/v1/namespaces/ns1/pods", "dryRun=All");
    assertNotNull(pod);
  }

  @Test
  void testCreate() {
    // When
    Pod pod = kubernetesClient.pods().inNamespace("ns1").withName("foo").dryRun().create(withPod("pod1"));
    // Then
    verify(mockClient).sendAsync(any(), any());
    assertRequest("POST", "/api/v1/namespaces/ns1/pods", "dryRun=All");
    assertNotNull(pod);
  }

  @Test
  void testCreateOrReplace() {
    // When
    Pod pod = kubernetesClient.pods().inNamespace("ns1").dryRun().createOrReplace(withPod("pod1"));
    // Then
    verify(mockClient).sendAsync(any(), any());
    assertNotNull(pod);
    assertRequest("POST", "/api/v1/namespaces/ns1/pods", "dryRun=All");
  }

  @Test
  void testPatch() {
    // When
    kubernetesClient.pods().inNamespace("ns1").withName("pod1").dryRun().patch(withPod("pod1"));
    // Then
    verify(mockClient, times(2)).sendAsync(any(), any());
    assertRequest(1, "PATCH", "/api/v1/namespaces/ns1/pods/pod1", "dryRun=All");
  }

  @Test
  void testReplace() {
    // When
    kubernetesClient.pods().inNamespace("ns1").withName("pod-replace").dryRun().replace(withPod("pod-replace"));
    // Then
    verify(mockClient, times(2)).sendAsync(any(), any());
    assertRequest(1, "PUT", "/api/v1/namespaces/ns1/pods/pod-replace", "dryRun=All");
  }

  @Test
  void testDelete() {
    // When
    kubernetesClient.pods().inNamespace("ns1").withName("pod1").dryRun().withPropagationPolicy(DeletionPropagation.BACKGROUND)
        .delete();
    // Then
    verify(mockClient).sendAsync(any(), any());
    assertRequest("DELETE", "/api/v1/namespaces/ns1/pods/pod1", "dryRun=All");
  }

  @Test
  void testResourceCreateOrReplace() {
    // When
    kubernetesClient.resource(withPod("pod1")).inNamespace("ns1").dryRun().createOrReplace();
    // Then
    verify(mockClient).sendAsync(any(), any());
    assertRequest("POST", "/api/v1/namespaces/ns1/pods", "dryRun=All");
  }

  @Test
  void testResourceDelete() {
    // When
    kubernetesClient.resource(withPod("pod1")).inNamespace("ns1").dryRun().withPropagationPolicy(DeletionPropagation.BACKGROUND)
        .delete();
    // Then
    verify(mockClient).sendAsync(any(), any());
    assertRequest("DELETE", "/api/v1/namespaces/ns1/pods/pod1", "dryRun=All");
  }

  @Test
  void testResourceListCreateOrReplace() {
    // Given
    Pod pod = withPod("pod1");
    Service svc = new ServiceBuilder().withNewMetadata().withName("svc1").endMetadata().build();
    // When
    kubernetesClient.resourceList(pod, svc).inNamespace("ns1").dryRun().createOrReplace();
    // Then
    verify(mockClient, times(2)).sendAsync(any(), any());
    assertRequest("POST", "/api/v1/namespaces/ns1/pods", "dryRun=All");
    assertRequest(1, "POST", "/api/v1/namespaces/ns1/services", "dryRun=All");
  }

  @Test
  void testResourceListDelete() {
    // Given
    Pod pod = withPod("pod1");
    Service svc = new ServiceBuilder().withNewMetadata().withName("svc1").endMetadata().build();

    // When
    kubernetesClient.resourceList(pod, svc).inNamespace("ns1").dryRun().withPropagationPolicy(DeletionPropagation.BACKGROUND)
        .delete();

    // Then
    verify(mockClient, times(2)).sendAsync(any(), any());
    assertRequest("DELETE", "/api/v1/namespaces/ns1/pods/pod1", "dryRun=All");
    assertRequest(1, "DELETE", "/api/v1/namespaces/ns1/services/svc1", "dryRun=All");
  }

  @Test
  void testCreateFieldValidation() {
    // When
    Pod pod = kubernetesClient.resource(withPod("pod1")).fieldValidation(Validation.WARN).create();
    // Then
    verify(mockClient).sendAsync(any(), any());
    assertRequest("POST", "/api/v1/namespaces/default/pods", "fieldValidation=Warn");

    assertNotNull(pod);
  }

  @Test
  void testCreateResourceListFieldValidation() {
    // When
    kubernetesClient.resourceList(withPod("pod1")).fieldValidation(Validation.IGNORE).create();
    // Then
    verify(mockClient).sendAsync(any(), any());
    assertRequest("POST", "/api/v1/namespaces/default/pods", "fieldValidation=Ignore");
  }

  @Test
  void testPatchFieldValidation() {
    // When
    kubernetesClient.resource(withPod("pod1")).fieldValidation(Validation.STRICT).patch();
    // Then
    verify(mockClient, times(2)).sendAsync(any(), any());
    assertRequest(1, "PATCH", "/api/v1/namespaces/default/pods/pod1", "fieldValidation=Strict");
  }

  private Pod withPod(String name) {
    return new PodBuilder().withNewMetadata().withName(name).withNamespace("default").endMetadata().build();
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
