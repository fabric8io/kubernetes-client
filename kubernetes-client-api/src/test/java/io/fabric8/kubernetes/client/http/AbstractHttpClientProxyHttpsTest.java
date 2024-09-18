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
import io.fabric8.mockwebserver.DefaultMockServer;
import io.fabric8.mockwebserver.utils.ResponseProvider;
import okhttp3.Headers;
import okhttp3.mockwebserver.RecordedRequest;
import okhttp3.mockwebserver.SocketPolicy;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.assertTrue;

public abstract class AbstractHttpClientProxyHttpsTest {

  protected static DefaultMockServer server;

  @BeforeAll
  static void beforeAll() {
    server = new DefaultMockServer(true);
    server.setHttpsTunnelProxy(true);
    server.start();
  }

  @AfterAll
  static void afterAll() {
    server.shutdown();
  }

  protected abstract HttpClient.Factory getHttpClientFactory();

  @Test
  @DisplayName("Proxied HttpClient adds required headers to the request")
  protected void proxyConfigurationAddsRequiredHeadersForHttps() throws Exception {
    AtomicBoolean authenticated = new AtomicBoolean();
    server.expect().connect().withPath("/").andReply(new ResponseProvider<String>() {

      @Override
      public String getBody(RecordedRequest request) {
        return "";
      }

      @Override
      public void setHeaders(Headers headers) {

      }

      @Override
      public int getStatusCode(RecordedRequest request) {
        server.setDefaultSocketPolicy(SocketPolicy.UPGRADE_TO_SSL_AT_END); // for jetty to upgrade after the challenge
        boolean auth = request.getHeader(StandardHttpHeaders.PROXY_AUTHORIZATION) != null;
        if (auth) {
          authenticated.set(true);
        }
        return auth ? 200 : 407;
      }

      @Override
      public Headers getHeaders() {
        return new Headers.Builder().add("Proxy-Authenticate", "Basic").build();
      }

    }).always();
    // Given
    final HttpClient.Builder builder = getHttpClientFactory().newBuilder()
        .sslContext(null, SSLUtils.trustManagers(null, null, true, null, null))
        .proxyAddress(new InetSocketAddress("localhost", server.getPort()))
        .proxyBasicCredentials("auth", "cred");
    try (HttpClient client = builder.build()) {
      // When
      client.sendAsync(client.newHttpRequestBuilder()
          .uri(String.format("https://0.0.0.0:%s/not-found", server.getPort() + 1)).build(), String.class)
          .get(30, TimeUnit.SECONDS);

      // if it fails, then authorization was not set
      assertTrue(authenticated.get());
    }
  }
}
