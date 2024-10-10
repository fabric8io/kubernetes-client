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

import io.fabric8.kubernetes.client.RequestConfigBuilder;
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
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.InetSocketAddress;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import static io.fabric8.kubernetes.client.utils.HttpClientUtils.basicCredentials;
import static org.assertj.core.api.Assertions.assertThat;

public abstract class AbstractHttpClientProxyHttpsTest {

  private static Map<ServerRequest, Queue<ServerResponse>> responses;
  private static DefaultMockServer proxyServer;

  @BeforeAll
  static void beforeAll() {
    responses = new HashMap<>();
    proxyServer = new DefaultMockServer(new Context(), new MockWebServer(), responses, new MockDispatcher(responses), false);
    proxyServer.start();
  }

  @AfterAll
  static void afterAll() {
    proxyServer.shutdown();
  }

  protected abstract HttpClient.Factory getHttpClientFactory();

  @Test
  @DisplayName("Proxied HttpClient with basic authorization adds required headers to the request")
  protected void proxyConfigurationAddsRequiredHeadersForHttps() throws Exception {
    final AtomicReference<RecordedRequest> initialConnectRequest = new AtomicReference<>();
    final ResponseProvider<String> bodyProvider = new ResponseProvider<String>() {

      @Override
      public String getBody(RecordedRequest request) {
        return "\n";
      }

      @Override
      public void setHeaders(Headers headers) {
      }

      @Override
      public int getStatusCode(RecordedRequest request) {
        if (request.getHeader(StandardHttpHeaders.PROXY_AUTHORIZATION) != null) {
          initialConnectRequest.compareAndSet(null, request);
          return 200;
        }
        return 407;
      }

      @Override
      public Headers getHeaders() {
        return new Headers.Builder().add("Proxy-Authenticate", "Basic").build();
      }

    };
    responses.computeIfAbsent(new SimpleRequest(HttpMethod.CONNECT, "example.com:443"), k -> new ArrayDeque<>())
        .add(new SimpleResponse(true, bodyProvider, null, 0, TimeUnit.SECONDS));
    // Given
    final HttpClient.Builder builder = getHttpClientFactory().newBuilder()
        .sslContext(null, SSLUtils.trustManagers(null, null, true, null, null))
        .proxyAddress(new InetSocketAddress("localhost", proxyServer.getPort()))
        .proxyAuthorization(basicCredentials("auth", "cred"));
    builder.tag(new RequestConfigBuilder().withRequestRetryBackoffInterval(1).build());
    try (HttpClient client = builder.build()) {
      // When (just send and ignore response, we only care about the CONNECT request headers)
      client.sendAsync(client.newHttpRequestBuilder().uri("https://example.com/proxied").build(), String.class)
          .exceptionally(t -> null)
          .get(30, TimeUnit.SECONDS);
      // Then
      assertThat(initialConnectRequest)
          .doesNotHaveNullValue()
          .hasValueMatching(r -> r.getHeader("Proxy-Authorization").equals("Basic YXV0aDpjcmVk"));
    }
  }
}
