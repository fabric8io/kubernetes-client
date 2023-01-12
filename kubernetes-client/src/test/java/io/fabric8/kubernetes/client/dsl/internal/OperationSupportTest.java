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

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.http.HttpResponse;
import io.fabric8.kubernetes.client.http.StandardHttpRequest;
import io.fabric8.kubernetes.client.http.TestHttpResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class OperationSupportTest {

  private OperationSupport operationSupport;

  @BeforeEach
  void setUp() {
    final OperationContext context = new OperationContext().withClient(mock(Client.class, RETURNS_DEEP_STUBS));
    when(context.getClient().getConfiguration()).thenReturn(Config.empty());
    operationSupport = new OperationSupport(context);
  }

  @DisplayName("checkName, should use operation or item name")
  @ParameterizedTest(name = "{index}: operationName: ''{1}'' itemName: ''{2}'', expects: ''{0}''")
  @MethodSource("checkNameInput")
  void checkName(String expected, String operationName, String itemName) {
    // Given
    operationSupport = new OperationSupport(operationSupport.context.withName(operationName));
    final Pod item = new PodBuilder().withNewMetadata().withName(itemName).endMetadata().build();
    // When
    final String result = operationSupport.checkName(item);
    // Then
    assertThat(result).isEqualTo(expected);
  }

  static Stream<Arguments> checkNameInput() {
    return Stream.of(
        arguments(null, null, null),
        arguments("operation", "operation", null),
        arguments("item", null, "item"),
        arguments("operation-item-are-the-same", "operation-item-are-the-same", "operation-item-are-the-same"));
  }

  @Test
  @DisplayName("checkName, with different operation and item name, throws Exception")
  void checkNameWithDifferentOperationAndItemNameThrowsException() {
    // Given
    operationSupport = new OperationSupport(operationSupport.context.withName("operation-name"));
    final Pod item = new PodBuilder().withNewMetadata().withName("item-name").endMetadata().build();
    // When
    final KubernetesClientException result = assertThrows(KubernetesClientException.class,
        () -> operationSupport.checkName(item));
    // Then
    assertThat(result).hasMessageContaining("Name mismatch. Item name:item-name. Operation name:operation-name.");
  }

  @Test
  @DisplayName("assertResponse, with successful code, should do nothing")
  void assertResponseCodeSuccessful() {
    // Given
    final HttpRequest request = new StandardHttpRequest.Builder().uri("https://example.com").build();
    final HttpResponse<String> response = new TestHttpResponse<String>().withCode(200);
    // When - Then
    assertDoesNotThrow(() -> operationSupport.assertResponseCode(request, response));
  }

  @Test
  @DisplayName("assertResponse, with client error, should throw exception")
  void assertResponseCodeClientError() throws Exception {
    // Given
    final HttpRequest request = new StandardHttpRequest.Builder().method("GET", null, null).uri(new URI("https://example.com"))
        .build();
    final HttpResponse<String> response = new TestHttpResponse<String>().withCode(400);
    // When
    final KubernetesClientException result = assertThrows(KubernetesClientException.class,
        () -> operationSupport.assertResponseCode(request, response));
    // Then
    assertThat(result).hasMessageContaining("Failure executing: GET at: https://example.com. Message: Bad Request.");
  }

  @Test
  @DisplayName("assertResponse, with client error and custom message, should throw exception")
  void assertResponseCodeClientErrorAndCustomMessage() throws Exception {
    // Given
    operationSupport.getConfig().getErrorMessages().put(400, "Custom message");
    final HttpRequest request = new StandardHttpRequest.Builder().method("GET", null, null).uri(new URI("https://example.com"))
        .build();
    final HttpResponse<String> response = new TestHttpResponse<String>().withCode(400);
    // When
    final KubernetesClientException result = assertThrows(KubernetesClientException.class,
        () -> operationSupport.assertResponseCode(request, response));
    // Then
    assertThat(result)
        .hasMessageContaining("Failure executing: GET at: https://example.com. Message: Custom message Bad Request.");
  }

  @Test
  void getResourceURL() throws MalformedURLException {
    assertThat(operationSupport.getResourceUrl()).hasToString("https://kubernetes.default.svc/api/v1");

    OperationSupport pods = new OperationSupport(operationSupport.context.withPlural("pods"));
    assertThat(pods.getResourceUrl().toString()).hasToString("https://kubernetes.default.svc/api/v1/pods");

    pods = new OperationSupport(pods.context.withName("pod-1"));
    assertThat(pods.getResourceUrl()).hasToString("https://kubernetes.default.svc/api/v1/pods/pod-1");

    pods = new OperationSupport(pods.context.withSubresource("ephemeralcontainers"));
    assertThat(pods.getResourceUrl())
        .hasToString("https://kubernetes.default.svc/api/v1/pods/pod-1/ephemeralcontainers");

    pods = new OperationSupport(pods.context.withNamespace("default"));
    assertThat(pods.getResourceUrl())
        .hasToString("https://kubernetes.default.svc/api/v1/namespaces/default/pods/pod-1/ephemeralcontainers");

    OperationSupport subresourceWithoutName = new OperationSupport(
        operationSupport.context.withPlural("Pods").withSubresource("pod-1"));
    assertThrows(KubernetesClientException.class, () -> subresourceWithoutName.getResourceUrl());
  }

  @Test
  void getResourceURLStatus() throws MalformedURLException {
    OperationSupport pods = new OperationSupport(operationSupport.context.withPlural("pods"));
    assertThat(pods.getResourceUrl("default", "pod-1", true))
        .hasToString("https://kubernetes.default.svc/api/v1/namespaces/default/pods/pod-1/status");
    assertThat(pods.getResourceUrl("default", "pod-1", false))
        .hasToString("https://kubernetes.default.svc/api/v1/namespaces/default/pods/pod-1");

    OperationSupport podsSubresource = new OperationSupport(pods.context.withSubresource("ephemeralcontainers"));
    assertThat(podsSubresource.getResourceUrl("default", "pod-1", true))
        .hasToString("https://kubernetes.default.svc/api/v1/namespaces/default/pods/pod-1/status");
    assertThat(podsSubresource.getResourceUrl("default", "pod-1", false))
        .hasToString("https://kubernetes.default.svc/api/v1/namespaces/default/pods/pod-1/ephemeralcontainers");

    assertThrows(KubernetesClientException.class, () -> {
      operationSupport.getResourceUrl("default", null, true);
    }, "status requires name");
  }

}
