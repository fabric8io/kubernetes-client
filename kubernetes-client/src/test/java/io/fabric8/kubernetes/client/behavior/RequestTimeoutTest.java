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

package io.fabric8.kubernetes.client.behavior;

import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.NamespacedKubernetesClient;
import io.fabric8.kubernetes.client.RequestConfigBuilder;
import io.fabric8.kubernetes.client.dsl.LogWatch;
import io.fabric8.kubernetes.client.http.AsyncBody;
import io.fabric8.kubernetes.client.http.TestAsyncBody;
import io.fabric8.kubernetes.client.http.TestHttpResponse;
import io.fabric8.kubernetes.client.http.TestStandardHttpClient;
import io.fabric8.kubernetes.client.http.TestStandardHttpClientFactory;
import io.fabric8.kubernetes.client.http.WebSocket;
import io.fabric8.kubernetes.client.http.WebSocketResponse;
import io.fabric8.kubernetes.client.http.WebSocketUpgradeResponse;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SuppressWarnings("resource")
@DisplayName("Request Timeout Behavior")
class RequestTimeoutTest {

  private TestStandardHttpClientFactory factory;
  private KubernetesClient client;

  @BeforeEach
  void setUp() {
    factory = new TestStandardHttpClientFactory();
    client = new KubernetesClientBuilder().withHttpClientFactory(factory).build();
  }

  @DisplayName("Standard Kubernetes Object operations have default timeout")
  @Test
  void standardOperationsHaveDefaultTimeout() {
    // Given
    factory.getInstances().iterator().next()
        .expect("/api/v1/namespaces/.+/pods.+", new TestHttpResponse<AsyncBody>().withCode(200).withBody(new TestAsyncBody()));
    // When
    client.pods().inNamespace("default").withName("foo").get();
    // Then
    assertThat(factory.getInstances())
        .singleElement()
        .extracting(TestStandardHttpClient::getRecordedConsumeBytesDirects)
        .asList()
        .hasSize(1)
        .singleElement()
        .extracting("request")
        .extracting("timeout")
        .asInstanceOf(InstanceOfAssertFactories.DURATION)
        .hasSeconds(10);
  }

  @DisplayName("Standard Kubernetes Object operations, with overridden request config, have overridden timeout")
  @Test
  void standardOperationsWithOverriddenRequestConfig() {
    // Given
    final KubernetesClient derivedClient = (KubernetesClient) client
        .newClient(new RequestConfigBuilder().withRequestTimeout(1337000).build());
    factory.getInstance(1)
        .expect("/api/v1/namespaces/.+/pods.+", new TestHttpResponse<AsyncBody>().withCode(200).withBody(new TestAsyncBody()));
    // When
    derivedClient.pods().inNamespace("default").withName("foo").get();
    // Then
    assertThat(factory.getInstances())
        .element(1)
        .extracting(TestStandardHttpClient::getRecordedConsumeBytesDirects)
        .asList()
        .hasSize(1)
        .singleElement()
        .extracting("request")
        .extracting("timeout")
        .asInstanceOf(InstanceOfAssertFactories.DURATION)
        .hasSeconds(1337);
  }

  @DisplayName("Standard Kubernetes Object operations, with overridden config, have overridden timeout")
  @Test
  void standardOperationsWithOverriddenConfig() {
    // Given
    final KubernetesClient derivedClient = new KubernetesClientBuilder()
        .withHttpClientFactory(factory)
        .withConfig(new ConfigBuilder(client.getConfiguration()).withRequestTimeout(1337000).build())
        .build();
    factory.getInstance(1)
        .expect("/api/v1/namespaces/.+/pods.+", new TestHttpResponse<AsyncBody>().withCode(200).withBody(new TestAsyncBody()));
    // When
    derivedClient.pods().inNamespace("default").withName("foo").get();
    // Then
    assertThat(factory.getInstances())
        .element(1)
        .extracting(TestStandardHttpClient::getRecordedConsumeBytesDirects)
        .asList()
        .hasSize(1)
        .singleElement()
        .extracting("request")
        .extracting("timeout")
        .asInstanceOf(InstanceOfAssertFactories.DURATION)
        .hasSeconds(1337);
  }

  @DisplayName("Standard Kubernetes Object operations, with overridden config, have overridden timeout")
  // n.b. Config and nested values should be immutable.
  // Users should not follow this path.
  @Test
  void standardOperationsHaveOverriddenTimeoutInConfig() {
    // Given
    factory.getInstances().iterator().next()
        .expect("/api/v1/namespaces/.+/pods.+", new TestHttpResponse<AsyncBody>().withCode(200).withBody(new TestAsyncBody()));
    // When
    client.getConfiguration().getRequestConfig().setRequestTimeout(1337000);
    client.pods().inNamespace("default").withName("foo").get();
    // Then
    assertThat(factory.getInstances())
        .singleElement()
        .extracting(TestStandardHttpClient::getRecordedConsumeBytesDirects)
        .asList()
        .hasSize(1)
        .singleElement()
        .extracting("request")
        .extracting("timeout")
        .asInstanceOf(InstanceOfAssertFactories.DURATION)
        .hasSeconds(1337);
  }

  @DisplayName("Standard Kubernetes Object operations, withRequestConfig, derives a client (new instance) with the overridden request configuration timeout")
  @Test
  void standardOperationsHaveOverriddenTimeoutWithRequestConfig() {
    // When
    client.adapt(NamespacedKubernetesClient.class)
        .withRequestConfig(new RequestConfigBuilder().withRequestTimeout(3000).build())
        .call(c -> {
          factory.getInstance(1)
              .expect("/api/v1/namespaces/.+/pods.+",
                  new TestHttpResponse<AsyncBody>().withCode(200).withBody(new TestAsyncBody()));
          return c.pods().inNamespace("default").withName("foo").get();
        });
    // Then
    assertThat(factory.getInstances())
        .hasSize(2)
        .element(1)
        .extracting(TestStandardHttpClient::getRecordedConsumeBytesDirects)
        .asList()
        .hasSize(1)
        .singleElement()
        .extracting("request")
        .extracting("timeout")
        .asInstanceOf(InstanceOfAssertFactories.DURATION)
        .hasSeconds(3);
    assertThat(client.getConfiguration().getRequestTimeout()).isEqualTo(10000);
  }

  @DisplayName("HTTP log retrieval, with no follow, has default timeout")
  // Uses OperationSupport.handleRaw
  @Test
  void httpLogNoFollowOperationsDefaultTimeout() {
    // Given
    informPodReady("foo")
        .expect("/api/v1/namespaces/.+/pods/foo/log",
            new TestHttpResponse<AsyncBody>().withCode(200).withBody(new TestAsyncBody()));
    // When
    client.pods().inNamespace("default").withName("foo").getLog();
    // Then
    assertThat(factory.getInstances())
        .singleElement()
        .extracting(TestStandardHttpClient::getRecordedConsumeBytesDirects)
        .asList()
        .hasSize(2)
        .element(1)
        .extracting("request")
        .extracting("timeout")
        .asInstanceOf(InstanceOfAssertFactories.DURATION)
        .hasSeconds(10);
  }

  @DisplayName("HTTP log retrieval, with follow, has no timeout")
  // LogWatchCallback performs HTTP requests
  @Test
  void httpLogFollowOperationsNoTimeout() {
    // Given
    informPodReady("foo")
        .expect("/api/v1/namespaces/.+/pods/foo/log",
            new TestHttpResponse<AsyncBody>().withCode(200).withBody(new TestAsyncBody()));
    // When
    try (LogWatch ignore = client.pods().inNamespace("default").withName("foo").watchLog()) {
      // Then
      assertThat(factory.getInstances())
          .singleElement()
          .extracting(TestStandardHttpClient::getRecordedConsumeBytesDirects)
          .asList()
          .hasSize(2)
          .element(1)
          .extracting("request")
          .extracting("timeout")
          .isNull();
    }
  }

  @DisplayName("Scale operation has default timeout")
  @Test
  void scaleHasDefaultTimeout() {
    // Given
    final TestStandardHttpClient httpClient = factory.getInstances().iterator().next();
    final TestStandardHttpClient.FutureProvider future = (r, c) -> {
      final AsyncBody body = new TestAsyncBody();
      c.consume(Collections.singletonList(
          ByteBuffer.wrap(("{\"spec\":{\"replicas\":0}}").getBytes(StandardCharsets.UTF_8))), body);
      return CompletableFuture.completedFuture(new TestHttpResponse<AsyncBody>().withCode(200).withBody(body));
    };
    IntStream.range(0, 2).forEach(i -> httpClient.expect("/apis/apps/v1/namespaces/.+/deployments/foo/scale", future));
    httpClient.expect("/apis/apps/v1/namespaces/.+/deployments/foo",
        new TestHttpResponse<AsyncBody>().withCode(200).withBody(new TestAsyncBody()));
    // When
    client.apps().deployments().inNamespace("default").withName("foo").scale(1);
    // Then
    assertThat(factory.getInstances())
        .singleElement()
        .extracting(TestStandardHttpClient::getRecordedConsumeBytesDirects)
        .asList()
        .hasSize(3)
        .extracting("request.timeout")
        .allMatch(d -> d.equals(Duration.ofSeconds(10)));
  }

  @DisplayName("Delete operations have default timeout")
  @Test
  void deleteHasDefaultTimeout() {
    // Given
    factory.getInstances().iterator().next()
        .expect("/api/v1/namespaces/.+/pods/foo",
            new TestHttpResponse<AsyncBody>().withCode(200).withBody(new TestAsyncBody()));
    // When
    client.pods().inNamespace("default").withName("foo").delete();
    // Then
    assertThat(factory.getInstances())
        .singleElement()
        .extracting(TestStandardHttpClient::getRecordedConsumeBytesDirects)
        .asList()
        .hasSize(1)
        .singleElement()
        .extracting("request")
        .extracting("timeout")
        .asInstanceOf(InstanceOfAssertFactories.DURATION)
        .hasSeconds(10);
  }

  @DisplayName("Upload WS requests have default timeout for upgrade")
  @Test
  void uploadWsUpgradeHasDefaultTimeout() throws Exception {
    // Given
    final WebSocket webSocket = mock(WebSocket.class);
    when(webSocket.send(any())).thenReturn(true);
    final TestStandardHttpClient.WsFutureProvider future = (s, l) -> {
      l.onOpen(webSocket);
      l.onClose(webSocket, 0, "done");
      return CompletableFuture.completedFuture(new WebSocketResponse(new WebSocketUpgradeResponse(null), webSocket));
    };
    IntStream.range(0, 2).forEach(i -> {
      informPodReady("bar")
          .wsExpect("/api/v1/namespaces/.+/pods/bar/exec", future);
    });
    // When
    try (ByteArrayInputStream bis = new ByteArrayInputStream("baz".getBytes(StandardCharsets.UTF_8))) {
      client.pods().inNamespace("default").withName("bar").file("/temp/file").upload(bis);
    }
    // Then
    assertThat(factory.getInstances())
        .singleElement()
        .extracting(TestStandardHttpClient::getRecordedBuildWebSocketDirects)
        .asInstanceOf(InstanceOfAssertFactories.list(TestStandardHttpClient.RecordedBuildWebSocketDirect.class))
        // One for Upload, One for checksum
        .hasSize(2)
        .extracting(r -> r.getStandardWebSocketBuilder().asHttpRequest().getTimeout())
        .allMatch(d -> d.equals(Duration.ofSeconds(10)));
  }

  private TestStandardHttpClient informPodReady(String podName) {
    return factory.getInstances().iterator().next()
        .expect("/api/v1/namespaces/.+/pods", (r, c) -> {
          final AsyncBody body = new TestAsyncBody();
          c.consume(Collections.singletonList(
              ByteBuffer.wrap(("{" +
                  "\"metadata\": {}," +
                  "\"items\":[{" +
                  "\"metadata\":{\"name\":\"" + podName + "\"}," +
                  "\"spec\":{\"containers\":[{\"name\":\"" + podName + "\"}]}," +
                  "\"status\":{\"conditions\":[{\"type\":\"Ready\",\"status\":true}]}" +
                  "}]" +
                  "}").getBytes(StandardCharsets.UTF_8))),
              body);
          return CompletableFuture.completedFuture(new TestHttpResponse<AsyncBody>().withCode(200).withBody(body));
        });
  }
}
