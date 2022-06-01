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
package io.fabric8.kubernetes.client.dsl.internal;

import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.api.model.ListOptionsBuilder;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.client.BaseClient;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.KubernetesClientTimeoutException;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.internal.core.v1.PodOperationsImpl;
import io.fabric8.kubernetes.client.extension.ExtensibleResource;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.http.HttpResponse;
import io.fabric8.kubernetes.client.http.TestHttpRequest;
import io.fabric8.kubernetes.client.http.TestHttpResponse;
import io.fabric8.kubernetes.client.utils.CommonThreadPool;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.kubernetes.client.utils.URLUtils;
import io.fabric8.kubernetes.client.utils.Utils;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BaseOperationTest {

  @Test
  void testSimpleFieldQueryParamConcatenation() {
    Map<String, String> fieldsMap = new HashMap<>();
    fieldsMap.put("yesKey1", "yesValue1");
    fieldsMap.put("yesKey2", "yesValue2");

    PodOperationsImpl operation = new PodOperationsImpl(new PodOperationContext(), new OperationContext());
    operation = (PodOperationsImpl) operation
        .withFields(fieldsMap)
        .withField("yesKey2", "overrideValue2")
        .withoutField("noKey1", "noValue1")
        .withoutField("noKey2", "noValue2");

    final String fieldQueryParam = operation.getFieldQueryParam();
    // Use contains to not be depending on map key/value pair ordering
    assertThat(fieldQueryParam, containsString("yesKey1=yesValue1"));
    assertThat(fieldQueryParam, containsString("yesKey2=overrideValue2"));
    assertThat(fieldQueryParam, containsString("noKey1!=noValue1"));
    assertThat(fieldQueryParam, containsString("noKey2!=noValue2"));
  }

  @Test
  void testSkippingFieldNotMatchingNullValues() {
    PodOperationsImpl operation = new PodOperationsImpl(new PodOperationContext(), new OperationContext());
    operation = (PodOperationsImpl) operation
        .withField("key1", "value1")
        .withoutField("key2", "value2")
        .withoutField("key2", null)
        .withoutField("key2", "")
        .withoutField("key2", "value3")
        .withoutField("key10", "value11")
        .withoutField("key10", ""); // Once more to make sure no accidental trailing comma is added

    assertThat(operation.getFieldQueryParam(), is(equalTo("key1=value1,key2!=value2,key2!=value3,key10!=value11")));
  }

  @Test
  void testFilterContextModification() {
    PodOperationsImpl operation = new PodOperationsImpl(new PodOperationContext(), new OperationContext());
    operation.withField("x", "y");
    // should not modify the existing context
    assertTrue(Utils.isNullOrEmpty(operation.getFieldQueryParam()));
  }

  @Test
  void testDefaultGracePeriod() {
    final BaseOperation operation = new BaseOperation(new OperationContext());

    assertThat(operation.getGracePeriodSeconds(), is(-1L));
  }

  @Test
  void testChainingGracePeriodAndPropagationPolicy() {
    final BaseOperation operation = new BaseOperation(new OperationContext());
    ExtensibleResource operationWithPropagationPolicy = operation
        .withPropagationPolicy(DeletionPropagation.FOREGROUND);
    assertThat(operationWithPropagationPolicy, is(notNullValue()));
    assertNotNull(operationWithPropagationPolicy.withGracePeriod(10));
  }

  @Test
  void testListOptions() throws MalformedURLException {
    // Given
    URL url = new URL("https://172.17.0.2:8443/api/v1/namespaces/default/pods");
    final BaseOperation<Pod, PodList, Resource<Pod>> operation = new BaseOperation<>(new OperationContext());

    // When and Then
    assertEquals(URLUtils.join(url.toString(), "?limit=5"),
        operation.fetchListUrl(url, new ListOptionsBuilder()
            .withLimit(5L)
            .build()).toString());
    assertEquals(
        URLUtils.join(url.toString(),
            "?limit=5&continue=eyJ2IjoibWV0YS5rOHMuaW8vdjEiLCJydiI6MjE0NDUzLCJzdGFydCI6ImV0Y2QtbWluaWt1YmVcdTAwMDAifQ"),
        operation.fetchListUrl(url, new ListOptionsBuilder()
            .withLimit(5L)
            .withContinue("eyJ2IjoibWV0YS5rOHMuaW8vdjEiLCJydiI6MjE0NDUzLCJzdGFydCI6ImV0Y2QtbWluaWt1YmVcdTAwMDAifQ")
            .build()).toString());
    assertEquals(URLUtils.join(url.toString(),
        "?limit=5&continue=eyJ2IjoibWV0YS5rOHMuaW8vdjEiLCJydiI6MjE0NDUzLCJzdGFydCI6ImV0Y2QtbWluaWt1YmVcdTAwMDAifQ&fieldSelector=status.phase%3DRunning"),
        operation.fetchListUrl(url, new ListOptionsBuilder()
            .withLimit(5L)
            .withContinue("eyJ2IjoibWV0YS5rOHMuaW8vdjEiLCJydiI6MjE0NDUzLCJzdGFydCI6ImV0Y2QtbWluaWt1YmVcdTAwMDAifQ")
            .withFieldSelector("status.phase=Running")
            .build()).toString());
    assertEquals(URLUtils.join(url.toString(),
        "?limit=5&continue=eyJ2IjoibWV0YS5rOHMuaW8vdjEiLCJydiI6MjE0NDUzLCJzdGFydCI6ImV0Y2QtbWluaWt1YmVcdTAwMDAifQ&fieldSelector=status.phase%3DRunning&resourceVersion=210448"),
        operation.fetchListUrl(url, new ListOptionsBuilder()
            .withLimit(5L)
            .withContinue("eyJ2IjoibWV0YS5rOHMuaW8vdjEiLCJydiI6MjE0NDUzLCJzdGFydCI6ImV0Y2QtbWluaWt1YmVcdTAwMDAifQ")
            .withFieldSelector("status.phase=Running")
            .withResourceVersion("210448")
            .build()).toString());
    assertEquals(URLUtils.join(url.toString(),
        "?limit=5&continue=eyJ2IjoibWV0YS5rOHMuaW8vdjEiLCJydiI6MjE0NDUzLCJzdGFydCI6ImV0Y2QtbWluaWt1YmVcdTAwMDAifQ&labelSelector=%21node-role.kubernetes.io%2Fmaster&resourceVersion=210448"),
        operation.fetchListUrl(url, new ListOptionsBuilder()
            .withLimit(5L)
            .withContinue("eyJ2IjoibWV0YS5rOHMuaW8vdjEiLCJydiI6MjE0NDUzLCJzdGFydCI6ImV0Y2QtbWluaWt1YmVcdTAwMDAifQ")
            .withLabelSelector("!node-role.kubernetes.io/master")
            .withResourceVersion("210448")
            .build()).toString());
    assertEquals(URLUtils.join(url.toString(),
        "?limit=5&continue=eyJ2IjoibWV0YS5rOHMuaW8vdjEiLCJydiI6MjE0NDUzLCJzdGFydCI6ImV0Y2QtbWluaWt1YmVcdTAwMDAifQ&labelSelector=%21node-role.kubernetes.io%2Fmaster&resourceVersion=210448&timeoutSeconds=10"),
        operation.fetchListUrl(url, new ListOptionsBuilder()
            .withLimit(5L)
            .withContinue("eyJ2IjoibWV0YS5rOHMuaW8vdjEiLCJydiI6MjE0NDUzLCJzdGFydCI6ImV0Y2QtbWluaWt1YmVcdTAwMDAifQ")
            .withLabelSelector("!node-role.kubernetes.io/master")
            .withResourceVersion("210448")
            .withTimeoutSeconds(10L)
            .build()).toString());
    assertEquals(URLUtils.join(url.toString(),
        "?limit=5&continue=eyJ2IjoibWV0YS5rOHMuaW8vdjEiLCJydiI6MjE0NDUzLCJzdGFydCI6ImV0Y2QtbWluaWt1YmVcdTAwMDAifQ&labelSelector=%21node-role.kubernetes.io%2Fmaster&resourceVersion=210448&timeoutSeconds=10&allowWatchBookmarks=true"),
        operation.fetchListUrl(url, new ListOptionsBuilder()
            .withLimit(5L)
            .withContinue("eyJ2IjoibWV0YS5rOHMuaW8vdjEiLCJydiI6MjE0NDUzLCJzdGFydCI6ImV0Y2QtbWluaWt1YmVcdTAwMDAifQ")
            .withLabelSelector("!node-role.kubernetes.io/master")
            .withResourceVersion("210448")
            .withTimeoutSeconds(10L)
            .withAllowWatchBookmarks(true)
            .build()).toString());
    assertEquals(URLUtils.join(url.toString(),
        "?limit=5&continue=eyJ2IjoibWV0YS5rOHMuaW8vdjEiLCJydiI6MjE0NDUzLCJzdGFydCI6ImV0Y2QtbWluaWt1YmVcdTAwMDAifQ&labelSelector=%21node-role.kubernetes.io%2Fmaster&resourceVersion=210448&timeoutSeconds=10&allowWatchBookmarks=true&watch=true"),
        operation.fetchListUrl(url, new ListOptionsBuilder()
            .withLimit(5L)
            .withContinue("eyJ2IjoibWV0YS5rOHMuaW8vdjEiLCJydiI6MjE0NDUzLCJzdGFydCI6ImV0Y2QtbWluaWt1YmVcdTAwMDAifQ")
            .withLabelSelector("!node-role.kubernetes.io/master")
            .withResourceVersion("210448")
            .withTimeoutSeconds(10L)
            .withAllowWatchBookmarks(true)
            .withWatch(true)
            .build()).toString());
    assertEquals(URLUtils.join(url.toString(), "?resourceVersion=210448"), operation.fetchListUrl(url, new ListOptionsBuilder()
        .withResourceVersion("210448")
        .build()).toString());
    assertEquals(URLUtils.join(url.toString(), "?timeoutSeconds=10"), operation.fetchListUrl(url, new ListOptionsBuilder()
        .withTimeoutSeconds(10L)
        .build()).toString());
    assertEquals(URLUtils.join(url.toString(), "?watch=true"), operation.fetchListUrl(url, new ListOptionsBuilder()
        .withWatch(true)
        .build()).toString());
  }

  @Test
  void testGetWriteOperationUrlWithDryRunEnabled() throws MalformedURLException {
    // Given
    BaseOperation baseOp = new BaseOperation(new OperationContext()
        .withClient(mockClient(null, new ConfigBuilder().withMasterUrl("https://172.17.0.2:8443").build()))
        .withPlural("pods")
        .withDryRun(true));
    baseOp.setType(Pod.class);
    baseOp.setListType(PodList.class);

    // When
    URL result = baseOp.getResourceURLForWriteOperation(new URL("https://172.17.0.2:8443/api/v1/namespaces/ns1/pods/foo"));

    // Then
    assertNotNull(result);
    assertEquals("https://172.17.0.2:8443/api/v1/namespaces/ns1/pods/foo?dryRun=All", result.toString());
  }

  @Test
  void testGetWriteOperationUrlWithDryRunDisabled() throws MalformedURLException {
    // Given
    BaseOperation baseOp = new BaseOperation(new OperationContext()
        .withClient(mockClient(null, new ConfigBuilder().withMasterUrl("https://172.17.0.2:8443").build()))
        .withPlural("pods"));
    baseOp.setType(Pod.class);
    baseOp.setListType(PodList.class);

    // When
    URL result = baseOp.getResourceURLForWriteOperation(new URL("https://172.17.0.2:8443/api/v1/namespaces/ns1/pods/foo"));

    // Then
    assertNotNull(result);
    assertEquals("https://172.17.0.2:8443/api/v1/namespaces/ns1/pods/foo", result.toString());
  }

  private HttpClient newHttpClientWithSomeFailures(final AtomicInteger httpExecutionCounter, final int numFailures) {
    HttpClient mockClient = mock(HttpClient.class, Mockito.RETURNS_DEEP_STUBS);
    HttpRequest.Builder mockRequestBuilder = mock(HttpRequest.Builder.class, Mockito.RETURNS_SELF);
    when(mockClient.newHttpRequestBuilder()).thenReturn(mockRequestBuilder);
    when(mockRequestBuilder.build()).thenReturn(new TestHttpRequest().withUri("https://k8s.example.com"));
    when(mockClient.sendAsync(Mockito.any(), Mockito.eq(byte[].class))).thenAnswer(
        invocation -> {
          int count = httpExecutionCounter.getAndIncrement();
          if (count < numFailures) {
            // Altering the type of the error for each call:
            // even numbered calls (including the first call) fail with an IOException and odd numbered calls fail with HTTP response 500
            if (count % 2 == 0) {
              CompletableFuture<HttpResponse<InputStream>> result = new CompletableFuture<>();
              result.completeExceptionally(new IOException("For example java.net.ConnectException"));
              return result;
            }
            return CompletableFuture.completedFuture(new TestHttpResponse<>().withCode(500));
          }
          Pod podNoLabels = new PodBuilder().withNewMetadata().withName("pod1").withNamespace("test").and().build();
          return CompletableFuture.completedFuture(
              TestHttpResponse.from(200, Serialization.asJson(podNoLabels)));
        });
    return mockClient;
  }

  @Test
  void testNoHttpRetryWithDefaultConfig() {
    final AtomicInteger httpExecutionCounter = new AtomicInteger(0);
    HttpClient mockClient = newHttpClientWithSomeFailures(httpExecutionCounter, 1000);
    BaseOperation<Pod, PodList, Resource<Pod>> baseOp = new BaseOperation(new OperationContext()
        .withClient(mockClient(mockClient,
            new ConfigBuilder().withMasterUrl("https://172.17.0.2:8443").withNamespace("default").build()))
        .withPlural("pods")
        .withName("test-pod"));
    baseOp.setType(Pod.class);

    // When
    Exception exception = assertThrows(KubernetesClientException.class, () -> {
      Pod result = baseOp.get();
    });

    // Then
    assertTrue(exception.getCause().getMessage().contains("For example java.net.ConnectException"),
        "As the first failure is an IOException the message of the causedBy expected to contain the given text: 'For example java.net.ConnectException'!");
    assertEquals(1, httpExecutionCounter.get());
  }

  @Test
  void testHttpRetryWithMoreFailuresThanRetries() {
    final AtomicInteger httpExecutionCounter = new AtomicInteger(0);
    HttpClient mockClient = newHttpClientWithSomeFailures(httpExecutionCounter, 1000);
    BaseOperation<Pod, PodList, Resource<Pod>> baseOp = new BaseOperation(new OperationContext()
        .withClient(mockClient(mockClient,
            new ConfigBuilder().withMasterUrl("https://172.17.0.2:8443").withNamespace("default")
                .withRequestRetryBackoffLimit(3).withRequestRetryBackoffInterval(100).build()))
        .withPlural("pods")
        .withName("test-pod"));
    baseOp.setType(Pod.class);

    // When
    Exception exception = assertThrows(KubernetesClientException.class, () -> {
      Pod result = baseOp.get();
    });

    // Then
    assertTrue(exception.getMessage().contains("Internal Server Error"),
        "As the last failure, the 3rd one, is not an IOException the message expected to contain: 'Internal Server Error'!");
    assertEquals(4, httpExecutionCounter.get(), "Expected 4 calls: one normal try and 3 backoff retries!");
  }

  @Test
  void testHttpRetryWithLessFailuresThanRetries() {
    final AtomicInteger httpExecutionCounter = new AtomicInteger(0);
    HttpClient mockClient = newHttpClientWithSomeFailures(httpExecutionCounter, 2);
    BaseOperation<Pod, PodList, Resource<Pod>> baseOp = new BaseOperation(new OperationContext()
        .withClient(mockClient(mockClient,
            new ConfigBuilder().withMasterUrl("https://172.17.0.2:8443").withNamespace("default")
                .withRequestRetryBackoffLimit(3).build()))
        .withPlural("pods")
        .withName("test-pod"));
    baseOp.setType(Pod.class);

    // When
    Pod result = baseOp.get();

    // Then
    assertNotNull(result);
    assertEquals(3, httpExecutionCounter.get(), "Expected 3 calls: 2 failures and 1 success!");
  }

  @Test
  void testMissingNamespace() {
    BaseOperation<Pod, PodList, Resource<Pod>> baseOp = new BaseOperation<>(new OperationContext()
        .withClient(mockClient(null, new ConfigBuilder().withMasterUrl("https://172.17.0.2:8443").build()))
        .withNamespace(null)
        .withPlural("pods")
        .withName("test-pod"));
    baseOp.setType(Pod.class);

    // When
    Exception exception = assertThrows(KubernetesClientException.class, baseOp::get);

    // Then
    assertTrue(exception.getMessage().contains("namespace"), exception.getMessage());
  }

  @Test
  void testWaitUntilFailureCompletion() {
    final AtomicInteger httpExecutionCounter = new AtomicInteger(0);
    HttpClient mockClient = newHttpClientWithSomeFailures(httpExecutionCounter, 2);
    CompletableFuture<List<Pod>> future = new CompletableFuture<>();
    BaseOperation<Pod, PodList, Resource<Pod>> baseOp = new BaseOperation(new OperationContext()
        .withClient(mockClient(mockClient, new ConfigBuilder().withMasterUrl("https://172.17.0.2:8443").build()))
        .withPlural("pods")
        .withName("test-pod")) {

      @Override
      public CompletableFuture<List<Pod>> informOnCondition(Predicate condition) {
        return future;
      }

    };
    baseOp.setType(Pod.class);

    // When
    try {
      baseOp.waitUntilCondition(Objects::isNull, 1, TimeUnit.MILLISECONDS);
      fail("should timeout");
    } catch (KubernetesClientTimeoutException e) {

    }

    // Then
    assertTrue(future.isCancelled());
  }

  private BaseClient mockClient(HttpClient httpClient, Config config) {
    BaseClient client = Mockito.mock(BaseClient.class, Mockito.RETURNS_SELF);
    Mockito.when(client.getHttpClient()).thenReturn(httpClient);
    Mockito.when(client.getConfiguration()).thenReturn(config);
    Mockito.when(client.getExecutor()).thenReturn(CommonThreadPool.get());
    return client;
  }
}
