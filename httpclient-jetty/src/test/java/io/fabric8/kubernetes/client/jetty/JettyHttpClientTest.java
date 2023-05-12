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

import io.fabric8.kubernetes.client.http.HttpClient.DerivedClientBuilder;
import io.fabric8.kubernetes.client.http.StandardHttpClientBuilder;
import io.fabric8.kubernetes.client.http.TlsVersion;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.websocket.client.WebSocketClient;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

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
        null, httpClient, webSocketClient)) {
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
        .tlsVersions(TlsVersion.SSL_3_0)
        .followAllRedirects();
    try (var firstClient = new JettyHttpClient(
        originalBuilder, httpClient, webSocketClient)) {
      // When
      final var result = firstClient.newBuilder();
      // Then
      assertThat(result)
          .isNotNull()
          .isInstanceOf(DerivedClientBuilder.class)
          .isNotSameAs(originalBuilder);
      final var expected = Map.of(
          "getTlsVersions", new TlsVersion[] { TlsVersion.SSL_3_0 },
          "isFollowRedirects", true);
      for (var entry : expected.entrySet()) {
        final var method = StandardHttpClientBuilder.class.getMethod(entry.getKey());
        assertThat(method.invoke(result))
            .isEqualTo(method.invoke(originalBuilder))
            .isEqualTo(entry.getValue());
      }
      var connectTimeout = StandardHttpClientBuilder.class.getDeclaredField("connectTimeout");
      connectTimeout.setAccessible(true);
      assertThat(connectTimeout.get(result)).isEqualTo(Duration.ofSeconds(1337));
      assertThat(connectTimeout.get(originalBuilder)).isEqualTo(Duration.ofSeconds(1337));
      connectTimeout.setAccessible(false);
    }
  }

}
