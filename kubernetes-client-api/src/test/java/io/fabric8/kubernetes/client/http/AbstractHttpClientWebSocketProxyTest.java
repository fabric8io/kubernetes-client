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
package io.fabric8.kubernetes.client.http;

import io.fabric8.kubernetes.client.internal.SSLUtils;
import io.fabric8.mockwebserver.Context;
import io.fabric8.mockwebserver.DefaultMockServer;
import io.fabric8.mockwebserver.MockWebServer;
import io.fabric8.mockwebserver.ServerRequest;
import io.fabric8.mockwebserver.ServerResponse;
import io.fabric8.mockwebserver.dsl.HttpMethod;
import io.fabric8.mockwebserver.http.Headers;
import io.fabric8.mockwebserver.http.RecordedRequest;
import io.fabric8.mockwebserver.internal.MockDispatcher;
import io.fabric8.mockwebserver.internal.SimpleRequest;
import io.fabric8.mockwebserver.internal.SimpleResponse;
import io.fabric8.mockwebserver.utils.ResponseProvider;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.URI;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class AbstractHttpClientWebSocketProxyTest {

  private static Map<ServerRequest, Queue<ServerResponse>> responses;
  private static DefaultMockServer proxyServer;

  @BeforeAll
  static void beforeAll() {
    responses = new HashMap<>();
    proxyServer = new DefaultMockServer(new Context(), new MockWebServer(), responses,
        new MockDispatcher(responses), false);
    proxyServer.start();
  }

  @AfterAll
  static void afterAll() {
    proxyServer.shutdown();
  }

  protected abstract HttpClient.Factory getHttpClientFactory();

  @Test
  @DisplayName("Proxied WebSocket uses configured HTTP proxy")
  protected void proxiedWebSocketUsesConfiguredHttpProxy() throws Exception {
    final URI targetUri = URI.create(
        "https://127.0.0.1:" + findUnusedLocalPort() + "/proxied-websocket");
    final AtomicReference<RecordedRequest> connectRequest = new AtomicReference<>();
    final ResponseProvider<String> responseProvider = new ResponseProvider<String>() {

      @Override
      public String getBody(RecordedRequest request) {
        connectRequest.compareAndSet(null, request);
        return "\n";
      }

      @Override
      public void setHeaders(Headers headers) {
      }

      @Override
      public int getStatusCode(RecordedRequest request) {
        return 200;
      }

      @Override
      public Headers getHeaders() {
        return new Headers.Builder().build();
      }
    };

    responses.computeIfAbsent(
        new SimpleRequest(HttpMethod.CONNECT, targetUri.getAuthority()), k -> new ArrayDeque<>())
        .add(new SimpleResponse(true, responseProvider, null));

    try (HttpClient client = getHttpClientFactory().newBuilder()
        .sslContext(null, SSLUtils.trustManagers(null, null, true, null, null))
        .proxyAddress(new InetSocketAddress("localhost", proxyServer.getPort()))
        .proxyType(HttpClient.ProxyType.HTTP)
        .build()) {
      client.newWebSocketBuilder()
          .uri(targetUri)
          .connectTimeout(1L, TimeUnit.SECONDS)
          .buildAsync(new WebSocket.Listener() {
          })
          .exceptionally(t -> null);

      Awaitility.await().atMost(10L, TimeUnit.SECONDS).untilAsserted(
          () -> assertThat(connectRequest)
              .doesNotHaveNullValue()
              .hasValueMatching(r -> targetUri.getAuthority().equals(r.getPath())));
    }
  }

  private static int findUnusedLocalPort() throws IOException {
    try (ServerSocket socket = new ServerSocket(0, 1, InetAddress.getLoopbackAddress())) {
      return socket.getLocalPort();
    }
  }
}
