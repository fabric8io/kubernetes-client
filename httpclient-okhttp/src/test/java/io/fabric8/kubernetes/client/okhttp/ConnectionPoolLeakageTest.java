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
package io.fabric8.kubernetes.client.okhttp;

import io.fabric8.kubernetes.client.http.AsyncBody;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.HttpResponse;
import okhttp3.ConnectionPool;
import okhttp3.Protocol;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

class ConnectionPoolLeakageTest {

  private MockWebServer server;

  private ConnectionPool connectionPool;
  private OkHttpClientBuilderImpl clientBuilder;

  @BeforeEach
  void setUp() {
    server = new MockWebServer();
    final char[] chars = new char[10485760];
    Arrays.fill(chars, '1');
    server.enqueue(new MockResponse().setResponseCode(200).setChunkedBody(new String(chars), 1024));
    connectionPool = new ConnectionPool(10, 100, TimeUnit.SECONDS);
    clientBuilder = new OkHttpClientFactory().newBuilder();
    clientBuilder.getBuilder().connectionPool(connectionPool);
  }

  @AfterEach
  void tearDown() throws Exception {
    server.shutdown();
    connectionPool.evictAll();
  }

  @ParameterizedTest(name = "with protocol {0}")
  @DisplayName("consumeBytes should not leak connections")
  @ValueSource(strings = { "h2_prior_knowledge", "http/1.1" })
  void consumeBytes(String protocol) throws Exception {
    final Protocol p = Protocol.get(protocol);
    server.setProtocols(Collections.singletonList(p));
    server.start();
    clientBuilder.getBuilder().protocols(Collections.singletonList(p));
    try (HttpClient httpClient = clientBuilder.build()) {
      final HttpResponse<AsyncBody> asyncBodyResponse = httpClient.consumeBytes(
          httpClient.newHttpRequestBuilder().uri(server.url("/").toString()).build(),
          (value, asyncBody) -> {
            asyncBody.consume();
          })
          .get(10L, TimeUnit.SECONDS);
      assertThat(activeConnections()).isEqualTo(1);
      asyncBodyResponse.body().consume();
      asyncBodyResponse.body().done().get(10L, TimeUnit.SECONDS);
      assertThat(activeConnections()).isZero();
    }
  }

  private int activeConnections() {
    return connectionPool.connectionCount() - connectionPool.idleConnectionCount();
  }
}
