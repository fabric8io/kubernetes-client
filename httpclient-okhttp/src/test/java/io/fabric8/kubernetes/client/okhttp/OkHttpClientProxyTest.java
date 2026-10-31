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
package io.fabric8.kubernetes.client.okhttp;

import io.fabric8.kubernetes.client.http.AbstractHttpClientProxyTest;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.HttpResponse;
import io.fabric8.mockwebserver.DefaultMockServer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

import static io.fabric8.kubernetes.client.utils.HttpClientUtils.basicCredentials;
import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings({ "java:S2187", "HttpUrlsUsage" })
public class OkHttpClientProxyTest extends AbstractHttpClientProxyTest {
  @Override
  protected HttpClient.Factory getHttpClientFactory() {
    return new OkHttpClientFactory();
  }

  @Test
  @DisplayName("Proxied HttpClient with credentials the proxy rejects, returns the proxy's 407 instead of sending them again")
  void rejectedProxyCredentialsAreNotSentAgain() throws Exception {
    final DefaultMockServer proxy = new DefaultMockServer(false);
    proxy.start();
    try (HttpClient client = getHttpClientFactory().newBuilder()
        .proxyAddress(new InetSocketAddress("localhost", proxy.getPort()))
        .proxyAuthorization(basicCredentials("user", "wrong"))
        .build()) {
      // Given
      proxy.expect().get().withPath("http://example.com/rejected")
          .andReturn(407, "wrong credentials")
          .withHeader("Proxy-Authenticate", "Basic realm=\"proxy\"")
          .always();
      // When
      final HttpResponse<String> response = client
          .sendAsync(client.newHttpRequestBuilder().uri("http://example.com/rejected").build(), String.class)
          .get(10L, TimeUnit.SECONDS);
      // Then
      assertThat(response)
          .returns(407, HttpResponse::code)
          .returns("wrong credentials", HttpResponse::body);
      assertThat(proxy.getRequestCount()).as("the challenge should be answered once").isEqualTo(2);
    } finally {
      proxy.shutdown();
    }
  }
}
