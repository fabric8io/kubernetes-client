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
package io.fabric8.kubernetes.client.http;

import io.fabric8.mockwebserver.DefaultMockServer;
import okhttp3.Headers;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.InetSocketAddress;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class AbstractHttpClientProxyTest {

  private static DefaultMockServer server;

  @BeforeAll
  static void beforeAll() {
    server = new DefaultMockServer(false);
    server.start();
  }

  @AfterAll
  static void afterAll() {
    server.shutdown();
  }

  protected abstract HttpClient.Factory getHttpClientFactory();

  @Test
  @DisplayName("Proxied HttpClient adds required headers to the request")
  void proxyConfigurationAddsRequiredHeaders() throws Exception {
    // Given
    final HttpClient.Builder builder = getHttpClientFactory().newBuilder()
        .proxyAddress(new InetSocketAddress("localhost", server.getPort()))
        .proxyAuthorization("auth:cred");
    try (HttpClient client = builder.build()) {
      // When
      client.sendAsync(client.newHttpRequestBuilder()
          .uri(String.format("http://0.0.0.0:%s/not-found", server.getPort())).build(), String.class)
          .get(10L, TimeUnit.SECONDS);
      // Then
      assertThat(server.getLastRequest())
          .extracting(RecordedRequest::getHeaders)
          .extracting(Headers::toMultimap)
          .hasFieldOrPropertyWithValue("Host", Collections.singletonList("0.0.0.0:" + server.getPort()))
          .hasFieldOrPropertyWithValue("Proxy-Authorization", Collections.singletonList("auth:cred"));
    }
  }
}
