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

import io.fabric8.kubernetes.client.http.HttpClient.ProxyType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

import java.net.URI;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StandardHttpClientBuilderTest {

  private static final String PROXY_AUTHORIZATION = "Other kind of auth";

  @ParameterizedTest(name = "{0}")
  @CsvSource({ "http://example.com, true", "ws://example.com, true", "https://example.com, false",
      "wss://example.com, false", "HTTPS://example.com, false", "WSS://example.com, false" })
  @DisplayName("addPlainHttpProxyAuthInterceptor, sets Proxy-Authorization only on requests the HTTP proxy reads, never on the ones it tunnels to the API server")
  void plainHttpProxyAuthInterceptorSkipsTunneledRequests(String uri, boolean expectHeader) {
    // Given
    final TestStandardHttpClientBuilder builder = builder(ProxyType.HTTP, false);
    final HttpRequest.Builder requestBuilder = new StandardHttpRequest.Builder().uri(uri);
    // When
    builder.getInterceptors().get("PROXY-AUTH").before(requestBuilder, requestBuilder.build(), null);
    // Then
    assertThat(requestBuilder.build().headers(StandardHttpHeaders.PROXY_AUTHORIZATION))
        .isEqualTo(expectHeader ? List.of(PROXY_AUTHORIZATION) : List.of());
  }

  @ParameterizedTest(name = "webSocketsTunneled={0}")
  @CsvSource({ "false, true", "true, false" })
  @DisplayName("addPlainHttpProxyAuthInterceptor, sets Proxy-Authorization on a plain WebSocket upgrade only if the client doesn't tunnel it")
  void plainHttpProxyAuthInterceptorSkipsTunneledWebSockets(boolean webSocketsTunneled, boolean expectHeader) {
    // Given
    final TestStandardHttpClientBuilder builder = builder(ProxyType.HTTP, webSocketsTunneled);
    final StandardWebSocketBuilder webSocketBuilder = (StandardWebSocketBuilder) builder.build().newWebSocketBuilder()
        .uri(URI.create("http://example.com"));
    // When
    builder.getInterceptors().get("PROXY-AUTH").before(webSocketBuilder, webSocketBuilder.asHttpRequest(), null);
    // Then
    assertThat(webSocketBuilder.asHttpRequest().headers(StandardHttpHeaders.PROXY_AUTHORIZATION))
        .isEqualTo(expectHeader ? List.of(PROXY_AUTHORIZATION) : List.of());
  }

  @ParameterizedTest
  @EnumSource(value = ProxyType.class, names = { "SOCKS4", "SOCKS5" })
  @DisplayName("addPlainHttpProxyAuthInterceptor, adds no interceptor for SOCKS proxies, which never read HTTP headers")
  void plainHttpProxyAuthInterceptorNotAddedForSocks(ProxyType proxyType) {
    final TestStandardHttpClientBuilder builder = new TestStandardHttpClientFactory().newBuilder();
    builder.proxyType(proxyType).proxyAuthorization(PROXY_AUTHORIZATION);
    builder.addPlainHttpProxyAuthInterceptor(false);
    assertThat(builder.getInterceptors()).doesNotContainKey("PROXY-AUTH");
  }

  @Test
  @DisplayName("addPlainHttpProxyAuthInterceptor, adds no interceptor without proxy credentials")
  void plainHttpProxyAuthInterceptorNotAddedWithoutCredentials() {
    final TestStandardHttpClientBuilder builder = new TestStandardHttpClientFactory().newBuilder();
    builder.addPlainHttpProxyAuthInterceptor(false);
    assertThat(builder.getInterceptors()).doesNotContainKey("PROXY-AUTH");
  }

  private static TestStandardHttpClientBuilder builder(ProxyType proxyType, boolean webSocketsTunneled) {
    final TestStandardHttpClientBuilder builder = new TestStandardHttpClientFactory().newBuilder();
    builder.proxyType(proxyType).proxyAuthorization(PROXY_AUTHORIZATION);
    builder.addPlainHttpProxyAuthInterceptor(webSocketsTunneled);
    assertThat(builder.getInterceptors()).containsKey("PROXY-AUTH");
    return builder;
  }
}
