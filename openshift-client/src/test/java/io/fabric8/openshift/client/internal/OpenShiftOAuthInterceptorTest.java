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
package io.fabric8.openshift.client.internal;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.http.HttpResponse;
import io.fabric8.kubernetes.client.http.StandardHttpRequest;
import io.fabric8.kubernetes.client.http.TestHttpResponse;
import io.fabric8.kubernetes.client.http.WebSocket;
import io.fabric8.kubernetes.client.utils.TokenRefreshInterceptor;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.net.HttpURLConnection;
import java.net.URI;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;

import static java.net.HttpURLConnection.HTTP_FORBIDDEN;
import static java.net.HttpURLConnection.HTTP_UNAUTHORIZED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OpenShiftOAuthInterceptorTest {

  @Test
  void testBasicAuthNotUsed() {
    Config config = Config.empty();
    config.setUsername("user");
    config.setPassword("pass");

    HttpClient client = Mockito.mock(HttpClient.class);

    OpenShiftOAuthInterceptor interceptor = new OpenShiftOAuthInterceptor(client, config);

    StandardHttpRequest.Builder builder = new StandardHttpRequest.Builder();
    builder.uri("http://localhost");

    interceptor.before(builder, builder.build(), null);

    assertTrue(builder.build().headers(TokenRefreshInterceptor.AUTHORIZATION).isEmpty());
  }

  @Test
  void testTokenUsed() {
    Config config = Config.empty();
    config.setUsername("user");
    config.setPassword("pass");
    config.setOauthToken("token");

    HttpClient client = Mockito.mock(HttpClient.class);

    OpenShiftOAuthInterceptor interceptor = new OpenShiftOAuthInterceptor(client, config);

    StandardHttpRequest.Builder builder = new StandardHttpRequest.Builder();
    builder.uri("http://localhost");

    interceptor.before(builder, builder.build(), null);

    assertEquals(Collections.singletonList("Bearer token"), builder.build().headers(TokenRefreshInterceptor.AUTHORIZATION));
  }

  @Test
  void testTokenRefreshedFromConfig() {
    Config config = mockConfigRefresh();

    HttpClient client = Mockito.mock(HttpClient.class);

    OpenShiftOAuthInterceptor interceptor = new OpenShiftOAuthInterceptor(client, config);

    StandardHttpRequest.Builder builder = new StandardHttpRequest.Builder();
    builder.uri("http://localhost");

    interceptor.afterFailure(builder, TestHttpResponse.from(HttpURLConnection.HTTP_UNAUTHORIZED, "not for you")
        .withRequest(new StandardHttpRequest(null, URI.create("http://localhost"), "GET", null)), null);

    assertEquals(Collections.singletonList("Bearer token"), builder.build().headers(TokenRefreshInterceptor.AUTHORIZATION));
    Mockito.verify(config).setOauthToken("token");
  }

  @Test
  void testTokenRefreshedFromConfigForWebSocketBuilder() {
    Config config = mockConfigRefresh();
    Mockito.when(config.refresh().getOauthToken()).thenReturn("token");

    HttpClient client = Mockito.mock(HttpClient.class);
    OpenShiftOAuthInterceptor interceptor = new OpenShiftOAuthInterceptor(client, config);

    WebSocket.Builder builder = Mockito.mock(WebSocket.Builder.class, Mockito.RETURNS_DEEP_STUBS);

    interceptor.afterFailure(builder, TestHttpResponse.from(HttpURLConnection.HTTP_UNAUTHORIZED, "not for you")
        .withRequest(new StandardHttpRequest(null, URI.create("http://localhost"), "GET", null)), null);

    Mockito.verify(builder).setHeader(TokenRefreshInterceptor.AUTHORIZATION, "Bearer token");
    Mockito.verify(config).setOauthToken("token");
  }

  @Test
  void afterFailure_whenResponseCode403_thenShouldNotRefresh() {
    // Given
    HttpClient client = Mockito.mock(HttpClient.class);
    Config config = mockConfigRefresh();
    HttpResponse<?> httpResponse = mockHttpResponse(HTTP_FORBIDDEN);
    HttpRequest.Builder httpRequestBuilder = Mockito.mock(HttpRequest.Builder.class);
    OpenShiftOAuthInterceptor interceptor = new OpenShiftOAuthInterceptor(client, config);

    // When
    CompletableFuture<Boolean> result = interceptor.afterFailure(httpRequestBuilder, httpResponse, null);

    // Then
    assertThat(result).isCompletedWithValue(false);
  }

  @Test
  void afterFailure_whenResponseCode401_thenShouldRefresh() {
    // Given
    HttpClient client = Mockito.mock(HttpClient.class);
    Config config = mockConfigRefresh();
    HttpRequest.Builder httpRequestBuilder = Mockito.mock(HttpRequest.Builder.class);
    HttpResponse<?> httpResponse = mockHttpResponse(HTTP_UNAUTHORIZED);
    OpenShiftOAuthInterceptor interceptor = new OpenShiftOAuthInterceptor(client, config);

    // When
    CompletableFuture<Boolean> result = interceptor.afterFailure(httpRequestBuilder, httpResponse, null);

    // Then
    assertThat(result).isCompletedWithValue(true);
  }

  private Config mockConfigRefresh() {
    Config config = Mockito.mock(Config.class);
    Mockito.when(config.refresh()).thenReturn(config);
    Mockito.when(config.getOauthToken()).thenReturn("token");
    return config;
  }

  private HttpResponse<?> mockHttpResponse(int responseCode) {
    HttpRequest httpRequest = Mockito.mock(HttpRequest.class);
    HttpResponse<?> httpResponse = Mockito.mock(HttpResponse.class);
    Mockito.when(httpRequest.method()).thenReturn("GET");
    Mockito.when(httpRequest.uri())
        .thenReturn(URI.create("http://www.example.com/apis/routes.openshift.io/namespaces/foo/routes"));
    Mockito.when(httpResponse.request()).thenReturn(httpRequest);
    Mockito.when(httpResponse.code()).thenReturn(responseCode);
    return httpResponse;
  }

}
