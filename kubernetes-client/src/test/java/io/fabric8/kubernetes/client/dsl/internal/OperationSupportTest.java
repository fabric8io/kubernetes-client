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

import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.http.HttpResponse;
import io.fabric8.kubernetes.client.http.TestHttpRequest;
import io.fabric8.kubernetes.client.http.TestHttpResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.URI;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
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

  @Test
  @DisplayName("assertResponse, with successful code, should do nothing")
  void assertResponseCodeSuccessful() {
    // Given
    final HttpRequest request = new TestHttpRequest();
    final HttpResponse<String> response = new TestHttpResponse<String>().withCode(200);
    // When - Then
    assertDoesNotThrow(() -> operationSupport.assertResponseCode(request, response));
  }

  @Test
  @DisplayName("assertResponse, with client error, should throw exception")
  void assertResponseCodeClientError() throws Exception {
    // Given
    final HttpRequest request = new TestHttpRequest().withMethod("GET").withUri(new URI("https://example.com"));
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
    final HttpRequest request = new TestHttpRequest().withMethod("GET").withUri(new URI("https://example.com"));
    final HttpResponse<String> response = new TestHttpResponse<String>().withCode(400);
    // When
    final KubernetesClientException result = assertThrows(KubernetesClientException.class,
        () -> operationSupport.assertResponseCode(request, response));
    // Then
    assertThat(result)
        .hasMessageContaining("Failure executing: GET at: https://example.com. Message: Custom message Bad Request.");
  }
}
