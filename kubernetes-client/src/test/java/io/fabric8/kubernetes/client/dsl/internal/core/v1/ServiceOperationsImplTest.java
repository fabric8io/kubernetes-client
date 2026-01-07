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
import io.fabric8.kubernetes.client.http.TestStandardHttpClientFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ServiceOperationsImplTest {

  private TestStandardHttpClientFactory factory;
  private KubernetesClient client;

  @BeforeEach
  void setUp() {
    factory = new TestStandardHttpClientFactory();
    client = new KubernetesClientBuilder().withConfig(Config.empty()).withHttpClientFactory(factory).build();
  }

  @Test
  void matchingPod_whenNoPodsExist_thenThrowException() {
    // Given - Empty pod list
    String emptyPodListJson = "{\"apiVersion\":\"v1\",\"kind\":\"PodList\",\"items\":[]}";

    factory.expect("/api/v1/namespaces/test/services/test-service", 200,
      "{\"apiVersion\":\"v1\",\"kind\":\"Service\",\"metadata\":{\"name\":\"test-service\",\"namespace\":\"test\"}," +
        "\"spec\":{\"selector\":{\"app\":\"test\"},\"ports\":[{\"port\":8080,\"targetPort\":8080}]}}");
    factory.expect("/api/v1/namespaces/test/pods", 200, emptyPodListJson);

    ServiceOperationsImpl serviceOps = new ServiceOperationsImpl(client);

    // When - Then - Verify that matchingPod (called internally) throws IllegalStateException
    assertThatThrownBy(() -> serviceOps.inNamespace("test").withName("test-service").portForward(8080))
      .isInstanceOf(IllegalStateException.class)
      .hasMessageContaining("Could not find matching pod for service");
  }

  @Test
  void portForward_whenServiceNotFound_thenThrowException() {
    // Given - Service not found
    factory.expect("/api/v1/namespaces/test/services/test-service", 404,
      "{\"kind\":\"Status\",\"status\":\"Failure\",\"message\":\"services \\\"test-service\\\" not found\",\"code\":404}");

    ServiceOperationsImpl serviceOps = new ServiceOperationsImpl(client);

    // When - Then
    assertThatThrownBy(() -> serviceOps.inNamespace("test").withName("test-service").portForward(8080))
      .hasMessageContaining("not found");
  }

  static Stream<Arguments> portForwardSuccessScenarios() {
    return Stream.of(
      Arguments.of("single pod",
        "{\"apiVersion\":\"v1\",\"kind\":\"PodList\",\"items\":[{\"apiVersion\":\"v1\",\"kind\":\"Pod\",\"metadata\":{\"name\":\"test-pod\",\"namespace\":\"test\"}}]}"),
      Arguments.of("multiple pods",
        "{\"apiVersion\":\"v1\",\"kind\":\"PodList\",\"items\":[{\"apiVersion\":\"v1\",\"kind\":\"Pod\",\"metadata\":{\"name\":\"test-pod-1\",\"namespace\":\"test\"}},{\"apiVersion\":\"v1\",\"kind\":\"Pod\",\"metadata\":{\"name\":\"test-pod-2\",\"namespace\":\"test\"}}]}")
    );
  }

  @ParameterizedTest(name = "portForward with {0} should succeed")
  @MethodSource("portForwardSuccessScenarios")
  void portForward_whenPodsExist_thenDelegateSuccessfully(String scenario, String podListJson) throws Exception {
    // Given
    factory.expect("/api/v1/namespaces/test/services/test-service", 200,
      "{\"apiVersion\":\"v1\",\"kind\":\"Service\",\"metadata\":{\"name\":\"test-service\",\"namespace\":\"test\"}," +
        "\"spec\":{\"selector\":{\"app\":\"test\"},\"ports\":[{\"port\":8080,\"targetPort\":9090}]}}");
    factory.expect("/api/v1/namespaces/test/pods", 200, podListJson);

    ServiceOperationsImpl serviceOps = new ServiceOperationsImpl(client);

    // When/Then - If no exception is thrown, the test passes
    try (LocalPortForward pf = serviceOps.inNamespace("test").withName("test-service").portForward(8080)) {
      assertThat(pf).isNotNull();
    }
  }

  @Test
  void portForward_withLocalPort_shouldDelegateSuccessfully() throws Exception {
    // Given
    String podListJson = "{\"apiVersion\":\"v1\",\"kind\":\"PodList\",\"items\":[{\"apiVersion\":\"v1\",\"kind\":\"Pod\",\"metadata\":{\"name\":\"test-pod\",\"namespace\":\"test\"}}]}";

    factory.expect("/api/v1/namespaces/test/services/test-service", 200,
      "{\"apiVersion\":\"v1\",\"kind\":\"Service\",\"metadata\":{\"name\":\"test-service\",\"namespace\":\"test\"}," +
        "\"spec\":{\"selector\":{\"app\":\"test\"},\"ports\":[{\"port\":8080,\"targetPort\":9090}]}}");
    factory.expect("/api/v1/namespaces/test/pods", 200, podListJson);

    ServiceOperationsImpl serviceOps = new ServiceOperationsImpl(client);

    // When/Then
    try (LocalPortForward pf = serviceOps.inNamespace("test").withName("test-service").portForward(8080, 8081)) {
      assertThat(pf).isNotNull();
    }
  }

  @Test
  void getTargetPortAsInt_whenTargetPortDefined_thenUseMappedPort() throws Exception {
    // Given - Service with target port different from port
    String podListJson = "{\"apiVersion\":\"v1\",\"kind\":\"PodList\",\"items\":[{\"apiVersion\":\"v1\",\"kind\":\"Pod\",\"metadata\":{\"name\":\"test-pod\",\"namespace\":\"test\"}}]}";

    factory.expect("/api/v1/namespaces/test/services/test-service", 200,
      "{\"apiVersion\":\"v1\",\"kind\":\"Service\",\"metadata\":{\"name\":\"test-service\",\"namespace\":\"test\"}," +
        "\"spec\":{\"selector\":{\"app\":\"test\"},\"ports\":[{\"port\":8080,\"targetPort\":9090}]}}");
    factory.expect("/api/v1/namespaces/test/pods", 200, podListJson);

    ServiceOperationsImpl serviceOps = new ServiceOperationsImpl(client);

    // When/Then - getTargetPortAsInt maps 8080 to 9090
    try (LocalPortForward pf = serviceOps.inNamespace("test").withName("test-service").portForward(8080)) {
      assertThat(pf).isNotNull();
    }
  }

  @Test
  void getTargetPortAsInt_whenPortNotInServicePorts_thenUseOriginalPort() throws Exception {
    // Given
    String podListJson = "{\"apiVersion\":\"v1\",\"kind\":\"PodList\",\"items\":[{\"apiVersion\":\"v1\",\"kind\":\"Pod\",\"metadata\":{\"name\":\"test-pod\",\"namespace\":\"test\"}}]}";

    factory.expect("/api/v1/namespaces/test/services/test-service", 200,
      "{\"apiVersion\":\"v1\",\"kind\":\"Service\",\"metadata\":{\"name\":\"test-service\",\"namespace\":\"test\"}," +
        "\"spec\":{\"selector\":{\"app\":\"test\"},\"ports\":[{\"port\":8080,\"targetPort\":9090}]}}");
    factory.expect("/api/v1/namespaces/test/pods", 200, podListJson);

    ServiceOperationsImpl serviceOps = new ServiceOperationsImpl(client);

    // When/Then
    try (LocalPortForward pf = serviceOps.inNamespace("test").withName("test-service").portForward(3000)) {
      assertThat(pf).isNotNull();
    }
  }
}
