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
package io.fabric8.kubernetes.client.dsl.internal.core.v1;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.LocalPortForward;
import io.fabric8.kubernetes.client.PortForward;
import io.fabric8.kubernetes.client.http.TestStandardHttpClient;
import io.fabric8.kubernetes.client.http.TestStandardHttpClientFactory;
import io.fabric8.kubernetes.client.http.WebSocket;
import io.fabric8.kubernetes.client.http.WebSocketResponse;
import io.fabric8.kubernetes.client.http.WebSocketUpgradeResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;

class ServiceOperationsImplTest {

  private static final String POD_LIST_JSON = "{\"apiVersion\":\"v1\",\"kind\":\"PodList\",\"items\":[" +
      "{\"apiVersion\":\"v1\",\"kind\":\"Pod\",\"metadata\":{\"name\":\"test-pod\",\"namespace\":\"test\"}}" +
      "]}";

  private TestStandardHttpClientFactory factory;
  private KubernetesClient client;

  @BeforeEach
  void setUp() {
    factory = new TestStandardHttpClientFactory(TestStandardHttpClientFactory.Mode.SINGLETON);
    client = new KubernetesClientBuilder().withConfig(Config.empty()).withHttpClientFactory(factory).build();
  }

  static Stream<Arguments> portForwardSuccessScenarios() {
    return Stream.of(
        Arguments.of("single pod",
            "{\"apiVersion\":\"v1\",\"kind\":\"PodList\",\"items\":[{\"apiVersion\":\"v1\",\"kind\":\"Pod\",\"metadata\":{\"name\":\"test-pod\",\"namespace\":\"test\"}}]}"),
        Arguments.of("multiple pods",
            "{\"apiVersion\":\"v1\",\"kind\":\"PodList\",\"items\":[{\"apiVersion\":\"v1\",\"kind\":\"Pod\",\"metadata\":{\"name\":\"test-pod-1\",\"namespace\":\"test\"}},{\"apiVersion\":\"v1\",\"kind\":\"Pod\",\"metadata\":{\"name\":\"test-pod-2\",\"namespace\":\"test\"}}]}"));
  }

  @Nested
  @DisplayName("PortForward")
  class PortForwardTests {

    @Test
    @DisplayName("should throw exception when no pods exist")
    void whenNoPodsExist_thenThrowException() {
      // Given - Empty pod list
      String emptyPodListJson = "{\"apiVersion\":\"v1\",\"kind\":\"PodList\",\"items\":[]}";

      factory.expect("/api/v1/namespaces/test/services/test-service", 200,
          "{\"apiVersion\":\"v1\",\"kind\":\"Service\",\"metadata\":{\"name\":\"test-service\",\"namespace\":\"test\"}," +
              "\"spec\":{\"selector\":{\"app\":\"test\"},\"ports\":[{\"port\":8080,\"targetPort\":8080}]}}");
      factory.expect("/api/v1/namespaces/test/pods", 200, emptyPodListJson);

      // When - Then
      assertThatThrownBy(() -> client.services().inNamespace("test").withName("test-service").portForward(8080))
          .isInstanceOf(IllegalStateException.class)
          .hasMessageContaining("Could not find matching pod for service");
    }

    @Test
    @DisplayName("should throw exception when service not found")
    void whenServiceNotFound_thenThrowException() {
      // Given - Service not found
      factory.expect("/api/v1/namespaces/test/services/test-service", 404,
          "{\"kind\":\"Status\",\"status\":\"Failure\",\"message\":\"services \\\"test-service\\\" not found\",\"code\":404}");

      // When - Then
      assertThatThrownBy(() -> client.services().inNamespace("test").withName("test-service").portForward(8080))
          .hasMessageContaining("not found");
    }

    @ParameterizedTest(name = "should succeed with {0}")
    @MethodSource("io.fabric8.kubernetes.client.dsl.internal.core.v1.ServiceOperationsImplTest#portForwardSuccessScenarios")
    void whenPodsExist_thenDelegateSuccessfully(@SuppressWarnings("unused") String scenario, String podListJson)
        throws Exception {
      // Given
      factory.expect("/api/v1/namespaces/test/services/test-service", 200,
          "{\"apiVersion\":\"v1\",\"kind\":\"Service\",\"metadata\":{\"name\":\"test-service\",\"namespace\":\"test\"}," +
              "\"spec\":{\"selector\":{\"app\":\"test\"},\"ports\":[{\"port\":8080,\"targetPort\":9090}]}}");
      factory.expect("/api/v1/namespaces/test/pods", 200, podListJson);

      // When/Then - If no exception is thrown, the test passes
      try (LocalPortForward pf = client.services().inNamespace("test").withName("test-service").portForward(8080)) {
        assertThat(pf).isNotNull();
      }
    }

    @Test
    @DisplayName("should succeed with local port specified")
    void withLocalPort_shouldDelegateSuccessfully() throws Exception {
      // Given
      factory.expect("/api/v1/namespaces/test/services/test-service", 200,
          "{\"apiVersion\":\"v1\",\"kind\":\"Service\",\"metadata\":{\"name\":\"test-service\",\"namespace\":\"test\"}," +
              "\"spec\":{\"selector\":{\"app\":\"test\"},\"ports\":[{\"port\":8080,\"targetPort\":9090}]}}");
      factory.expect("/api/v1/namespaces/test/pods", 200, POD_LIST_JSON);

      // When/Then
      try (LocalPortForward pf = client.services().inNamespace("test").withName("test-service").portForward(8080, 8081)) {
        assertThat(pf).isNotNull();
      }
    }

    @Nested
    @DisplayName("Target Port Resolution")
    class TargetPortResolution {

      @Test
      @DisplayName("should use target port (9090) instead of service port (8080) in WebSocket URL")
      void shouldUseTargetPortInWebSocketUrl() throws Exception {
        // Given
        TestStandardHttpClient httpClient = factory.getInstance(0);
        httpClient.expect("/api/v1/namespaces/test/services/test-service", 200,
            "{\"apiVersion\":\"v1\",\"kind\":\"Service\",\"metadata\":{\"name\":\"test-service\",\"namespace\":\"test\"}," +
                "\"spec\":{\"selector\":{\"app\":\"test\"},\"ports\":[{\"port\":8080,\"targetPort\":9090}]}}");
        httpClient.expect("/api/v1/namespaces/test/pods", 200, POD_LIST_JSON);
        httpClient.wsExpect(".*/portforward.*",
            new WebSocketResponse(new WebSocketUpgradeResponse(null), mock(WebSocket.class)));

        // When - Use channel-based portForward which triggers WebSocket connection immediately
        PipedOutputStream out = new PipedOutputStream();
        PipedInputStream in = new PipedInputStream(out);
        ReadableByteChannel inChannel = Channels.newChannel(in);
        WritableByteChannel outChannel = Channels.newChannel(out);

        PortForward pf = client.services()
            .inNamespace("test")
            .withName("test-service")
            .portForward(8080, inChannel, outChannel);
        assertThat(pf).isNotNull();
        pf.close();

        // Then - Verify the WebSocket URL contains the target port (9090), not the service port (8080)
        assertThat(httpClient.getRecordedBuildWebSocketDirects())
            .hasSize(1)
            .first()
            .satisfies(recorded -> {
              String uri = recorded.getStandardWebSocketBuilder().asHttpRequest().uri().toString();
              assertThat(uri)
                  .as("WebSocket URL should contain target port 9090, not service port 8080")
                  .contains("portforward?ports=9090")
                  .doesNotContain("ports=8080");
            });
      }

      @Test
      @DisplayName("should use original port when port is not found in service spec")
      void whenPortNotInServicePorts_shouldUseOriginalPortInWebSocketUrl() throws Exception {
        // Given
        TestStandardHttpClient httpClient = factory.getInstance(0);
        httpClient.expect("/api/v1/namespaces/test/services/test-service", 200,
            "{\"apiVersion\":\"v1\",\"kind\":\"Service\",\"metadata\":{\"name\":\"test-service\",\"namespace\":\"test\"}," +
                "\"spec\":{\"selector\":{\"app\":\"test\"},\"ports\":[{\"port\":8080,\"targetPort\":9090}]}}");
        httpClient.expect("/api/v1/namespaces/test/pods", 200, POD_LIST_JSON);
        httpClient.wsExpect(".*/portforward.*",
            new WebSocketResponse(new WebSocketUpgradeResponse(null), mock(WebSocket.class)));

        // When - Use port 3000 which is not defined in the service
        PipedOutputStream out = new PipedOutputStream();
        PipedInputStream in = new PipedInputStream(out);
        ReadableByteChannel inChannel = Channels.newChannel(in);
        WritableByteChannel outChannel = Channels.newChannel(out);

        PortForward pf = client.services()
            .inNamespace("test")
            .withName("test-service")
            .portForward(3000, inChannel, outChannel);
        assertThat(pf).isNotNull();
        pf.close();

        // Then - Verify the WebSocket URL contains the original port (3000) as fallback
        assertThat(httpClient.getRecordedBuildWebSocketDirects())
            .hasSize(1)
            .first()
            .satisfies(recorded -> {
              String uri = recorded.getStandardWebSocketBuilder().asHttpRequest().uri().toString();
              assertThat(uri)
                  .as("WebSocket URL should use original port 3000 as fallback")
                  .contains("portforward?ports=3000");
            });
      }

      @Test
      @DisplayName("should use original port when target port is a named port (String)")
      void whenTargetPortIsNamedPort_shouldFallbackToOriginalPort() throws Exception {
        // Given - Service with named target port
        TestStandardHttpClient httpClient = factory.getInstance(0);
        httpClient.expect("/api/v1/namespaces/test/services/test-service", 200,
            "{\"apiVersion\":\"v1\",\"kind\":\"Service\",\"metadata\":{\"name\":\"test-service\",\"namespace\":\"test\"}," +
                "\"spec\":{\"selector\":{\"app\":\"test\"},\"ports\":[{\"port\":80,\"targetPort\":\"http\"}]}}");
        httpClient.expect("/api/v1/namespaces/test/pods", 200, POD_LIST_JSON);
        httpClient.wsExpect(".*/portforward.*",
            new WebSocketResponse(new WebSocketUpgradeResponse(null), mock(WebSocket.class)));

        // When
        PipedOutputStream out = new PipedOutputStream();
        PipedInputStream in = new PipedInputStream(out);
        ReadableByteChannel inChannel = Channels.newChannel(in);
        WritableByteChannel outChannel = Channels.newChannel(out);

        PortForward pf = client.services()
            .inNamespace("test")
            .withName("test-service")
            .portForward(80, inChannel, outChannel);
        assertThat(pf).isNotNull();
        pf.close();

        // Then - Named ports are not resolved, so it falls back to the original port
        assertThat(httpClient.getRecordedBuildWebSocketDirects())
            .hasSize(1)
            .first()
            .satisfies(recorded -> {
              String uri = recorded.getStandardWebSocketBuilder().asHttpRequest().uri().toString();
              assertThat(uri)
                  .as("WebSocket URL should fall back to original port 80 when targetPort is a named port")
                  .contains("portforward?ports=80");
            });
      }

      @Test
      @DisplayName("should resolve correct target port from service with multiple ports")
      void withMultiplePorts_shouldResolveCorrectTargetPort() throws Exception {
        // Given - Service with multiple ports
        TestStandardHttpClient httpClient = factory.getInstance(0);
        httpClient.expect("/api/v1/namespaces/test/services/test-service", 200,
            "{\"apiVersion\":\"v1\",\"kind\":\"Service\",\"metadata\":{\"name\":\"test-service\",\"namespace\":\"test\"}," +
                "\"spec\":{\"selector\":{\"app\":\"test\"},\"ports\":[" +
                "{\"name\":\"http\",\"port\":80,\"targetPort\":8080}," +
                "{\"name\":\"https\",\"port\":443,\"targetPort\":8443}," +
                "{\"name\":\"metrics\",\"port\":9090,\"targetPort\":9091}" +
                "]}}");
        httpClient.expect("/api/v1/namespaces/test/pods", 200, POD_LIST_JSON);
        httpClient.wsExpect(".*/portforward.*",
            new WebSocketResponse(new WebSocketUpgradeResponse(null), mock(WebSocket.class)));

        // When - Forward the HTTPS port (443)
        PipedOutputStream out = new PipedOutputStream();
        PipedInputStream in = new PipedInputStream(out);
        ReadableByteChannel inChannel = Channels.newChannel(in);
        WritableByteChannel outChannel = Channels.newChannel(out);

        PortForward pf = client.services()
            .inNamespace("test")
            .withName("test-service")
            .portForward(443, inChannel, outChannel);
        assertThat(pf).isNotNull();
        pf.close();

        // Then - Should resolve to target port 8443
        assertThat(httpClient.getRecordedBuildWebSocketDirects())
            .hasSize(1)
            .first()
            .satisfies(recorded -> {
              String uri = recorded.getStandardWebSocketBuilder().asHttpRequest().uri().toString();
              assertThat(uri)
                  .as("WebSocket URL should resolve service port 443 to target port 8443")
                  .contains("portforward?ports=8443");
            });
      }
    }
  }
}
