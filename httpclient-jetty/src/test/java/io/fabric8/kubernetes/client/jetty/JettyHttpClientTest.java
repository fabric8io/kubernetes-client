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
package io.fabric8.kubernetes.client.jetty;

import io.fabric8.kubernetes.client.http.TestHttpRequest;
import io.fabric8.kubernetes.client.http.TlsVersion;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.websocket.client.WebSocketClient;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class JettyHttpClientTest {

  private HttpClient httpClient;
  private WebSocketClient webSocketClient;

  @BeforeEach
  void setUp() {
    httpClient = new HttpClient();
    webSocketClient = new WebSocketClient();
  }

  @AfterEach
  void tearDown() throws Exception {
    webSocketClient.stop();
    httpClient.stop();
  }

  @Test
  @DisplayName("close, should close all underlying clients")
  void closeShouldCloseClients() {
    try (var jettyHttpClient = new JettyHttpClient(
        null, httpClient, webSocketClient, Collections.emptyList(), null)) {
      // When
      jettyHttpClient.close();
      // Then
      assertThat(httpClient.isStopped()).isTrue();
      assertThat(webSocketClient.isStopped()).isTrue();
    }
  }

  @Test
  @DisplayName("newBuilder instantiates a DerivedJettyHttpClientBuilder")
  void newBuilderInstantiatesJettyHttpClientBuilderWithSameSettings() throws Exception {
    // Given
    final var originalBuilder = new JettyHttpClientBuilder(null);
    originalBuilder
        .connectTimeout(1337, TimeUnit.SECONDS)
        .readTimeout(1337, TimeUnit.SECONDS)
        .tlsVersions(TlsVersion.SSL_3_0)
        .followAllRedirects();
    try (var firstClient = new JettyHttpClient(
        originalBuilder, httpClient, webSocketClient, Collections.emptyList(), null)) {
      // When
      final var result = firstClient.newBuilder()
          .readTimeout(313373, TimeUnit.SECONDS);
      // Then
      assertThat(result)
          .isNotNull()
          .isInstanceOf(DerivedJettyHttpClientBuilder.class)
          .isNotSameAs(originalBuilder);
      final var expected = Map.of(
          "tlsVersions", new TlsVersion[] { TlsVersion.SSL_3_0 },
          "followAllRedirects", true);
      for (var entry : expected.entrySet()) {
        final var field = JettyHttpClientBuilder.class.getDeclaredField(entry.getKey());
        field.setAccessible(true);
        assertThat(field.get(result))
            .isEqualTo(field.get(originalBuilder))
            .isEqualTo(entry.getValue());
        field.setAccessible(false);
      }
      var readTimeout = DerivedJettyHttpClientBuilder.class.getDeclaredField("readTimeout");
      readTimeout.setAccessible(true);
      assertThat(readTimeout.get(result)).isEqualTo(Duration.ofSeconds(313373));
      assertThat(readTimeout.get(originalBuilder)).isEqualTo(Duration.ofSeconds(1337));
      readTimeout.setAccessible(false);
    }
  }

  @Test
  @DisplayName("sendAsync with unsupported type throws Exception")
  void sendAsyncUnsupportedType() {
    try (var jettyHttpClient = new JettyHttpClient(
        null, httpClient, webSocketClient, Collections.emptyList(), null)) {
      // When
      final var result = assertThrows(IllegalArgumentException.class,
          () -> jettyHttpClient.sendAsync(null, Integer.class));
      // Then
      assertThat(result).hasMessage("Unsupported response type: java.lang.Integer");
    }
  }

  @Test
  @DisplayName("sendAsync with unsupported HttpRequest throws Exception")
  void sendAsyncUnsupportedHttpRequest() {
    try (var jettyHttpClient = new JettyHttpClient(
        new JettyHttpClientBuilder(null), httpClient, webSocketClient, Collections.emptyList(), null)) {
      // When
      final var request = new TestHttpRequest();
      final var result = assertThrows(IllegalArgumentException.class,
          () -> jettyHttpClient.sendAsync(request, String.class));
      // Then
      assertThat(result).hasMessage("Only StandardHttpRequest is supported");
    }
  }

  @Test
  @DisplayName("newWebSocketBuilder instantiates a JettyWebSocketBuilder")
  void newWebSocketBuilderInstantiatesJettyWebSocketBuilder() {
    try (var jettyHttpClient = new JettyHttpClient(
        new JettyHttpClientBuilder(null), httpClient, webSocketClient, Collections.emptyList(), null)) {
      // When
      final var result = jettyHttpClient.newWebSocketBuilder();
      // Then
      assertThat(result).isNotNull().isInstanceOf(JettyWebSocketBuilder.class);
    }
  }

  @Test
  @DisplayName("getFactory returns original factory")
  void getFactoryReturnsOriginal() {
    // Given
    final var factory = new JettyHttpClientFactory();
    try (var jettyHttpClient = new JettyHttpClient(
        null, httpClient, webSocketClient, Collections.emptyList(), factory)) {
      // When
      final var f1 = jettyHttpClient.getFactory();
      final var f2 = jettyHttpClient.getFactory();
      // Then
      assertThat(f1).isSameAs(f2).isSameAs(factory);
    }
  }
}
