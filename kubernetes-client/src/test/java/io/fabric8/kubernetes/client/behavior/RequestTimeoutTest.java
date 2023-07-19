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

import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.api.model.PodListBuilder;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.NamespacedKubernetesClient;
import io.fabric8.kubernetes.client.RequestConfigBuilder;
import io.fabric8.kubernetes.client.dsl.LogWatch;
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
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

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
    factory.expect("/api/v1/namespaces/.+/pods.+", 200);
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
    factory.getInstance(1).expect("/api/v1/namespaces/.+/pods.+", 200);
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
    factory.getInstance(1).expect("/api/v1/namespaces/.+/pods.+", 200);
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
    factory.expect("/api/v1/namespaces/.+/pods.+", 200);
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
          factory.getInstance(1).expect("/api/v1/namespaces/.+/pods.+", 200);
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
    informPodReady("foo");
    factory.expect("/api/v1/namespaces/.+/pods/foo/log", 200);
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
    informPodReady("foo");
    factory.expect("/api/v1/namespaces/.+/pods/foo/log", 200);
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
    factory.times(2).forEach(f -> f.expect("/apis/apps/v1/namespaces/.+/deployments/foo/scale",
        200, "{\"spec\":{\"replicas\":0}}"));
    factory.expect("/apis/apps/v1/namespaces/.+/deployments/foo", 200);
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
    factory.expect("/api/v1/namespaces/.+/pods/foo", 200);
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
    factory.times(2).forEach(i -> {
      informPodReady("bar");
      factory.getInstances().iterator().next()
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

  private void informPodReady(String podName) {
    final PodList podReadyList = new PodListBuilder()
        .withNewMetadata().endMetadata()
        .addNewItem()
        .withNewMetadata().withName(podName).endMetadata()
        .withNewSpec().addNewContainer().withName(podName).endContainer().endSpec()
        .withNewStatus().addNewCondition().withType("Ready").withStatus("True").endCondition().endStatus()
        .endItem()
        .build();
    factory.expect("/api/v1/namespaces/.+/pods", 200, client.getKubernetesSerialization().asJson(podReadyList));
  }
}
