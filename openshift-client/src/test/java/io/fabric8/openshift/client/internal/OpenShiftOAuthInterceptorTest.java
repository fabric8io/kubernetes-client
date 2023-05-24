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

import io.fabric8.kubernetes.api.model.ContextBuilder;
import io.fabric8.kubernetes.api.model.NamedAuthInfoBuilder;
import io.fabric8.kubernetes.api.model.NamedContextBuilder;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.http.HttpResponse;
import io.fabric8.kubernetes.client.http.StandardHttpRequest;
import io.fabric8.kubernetes.client.http.TestHttpResponse;
import io.fabric8.kubernetes.client.http.WebSocket;
import io.fabric8.kubernetes.client.internal.KubeConfigUtils;
import io.fabric8.kubernetes.client.utils.TokenRefreshInterceptor;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.Collections;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import static java.net.HttpURLConnection.HTTP_FORBIDDEN;
import static java.net.HttpURLConnection.HTTP_OK;
import static java.net.HttpURLConnection.HTTP_UNAUTHORIZED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Answers.RETURNS_SELF;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class OpenShiftOAuthInterceptorTest {

  @Test
  void testBasicAuthNotUsed() {
    Config config = Config.empty();
    config.setUsername("user");
    config.setPassword("pass");

    HttpClient client = mock(HttpClient.class);

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
    config.setAutoOAuthToken("token");

    HttpClient client = mock(HttpClient.class);

    OpenShiftOAuthInterceptor interceptor = new OpenShiftOAuthInterceptor(client, config);

    StandardHttpRequest.Builder builder = new StandardHttpRequest.Builder();
    builder.uri("http://localhost");

    interceptor.before(builder, builder.build(), null);

    assertEquals(Collections.singletonList("Bearer token"), builder.build().headers(TokenRefreshInterceptor.AUTHORIZATION));
  }

  @Test
  void testTokenRefreshedFromConfig() {
    Config config = mockConfigRefresh();

    HttpClient client = mock(HttpClient.class);

    OpenShiftOAuthInterceptor interceptor = new OpenShiftOAuthInterceptor(client, config);

    StandardHttpRequest.Builder builder = new StandardHttpRequest.Builder();
    builder.uri("http://localhost");

    interceptor.afterFailure(builder, TestHttpResponse.from(HttpURLConnection.HTTP_UNAUTHORIZED, "not for you")
        .withRequest(new StandardHttpRequest(null, URI.create("http://localhost"), "GET", null)), null);

    assertEquals(Collections.singletonList("Bearer token"), builder.build().headers(TokenRefreshInterceptor.AUTHORIZATION));
    verify(config).setAutoOAuthToken("token");
  }

  @Test
  void afterFailure_whenTokenSetByUser_thenNoRefresh() {
    // Given
    Config config = mock(Config.class, RETURNS_DEEP_STUBS);
    when(config.getAutoOAuthToken()).thenReturn(null);
    when(config.getOauthToken()).thenReturn("token-set-by-user");
    when(config.refresh()).thenReturn(config);
    HttpClient client = mock(HttpClient.class);
    HttpRequest.Builder builder = mock(HttpRequest.Builder.class, RETURNS_SELF);
    OpenShiftOAuthInterceptor interceptor = new OpenShiftOAuthInterceptor(client, config);

    // When
    CompletableFuture<Boolean> result = interceptor.afterFailure(builder,
        TestHttpResponse.from(HttpURLConnection.HTTP_UNAUTHORIZED, "not for you")
            .withRequest(new StandardHttpRequest(null, URI.create("http://localhost"), "GET", null)),
        null);

    // Then
    assertThat(result).isCompletedWithValue(false);
  }

  @Test
  void afterFailure_whenOAuthTokenProviderPresent_thenUseTokenFromProvider() {
    // Given
    Config config = mock(Config.class, RETURNS_DEEP_STUBS);
    when(config.getOauthTokenProvider()).thenReturn(() -> "token-from-oauthtokenprovider");
    HttpClient client = mock(HttpClient.class);
    HttpRequest.Builder builder = mock(HttpRequest.Builder.class, RETURNS_SELF);
    builder.uri("http://localhost");
    OpenShiftOAuthInterceptor interceptor = new OpenShiftOAuthInterceptor(client, config);

    // When
    CompletableFuture<Boolean> result = interceptor.afterFailure(builder,
        TestHttpResponse.from(HttpURLConnection.HTTP_UNAUTHORIZED, "not for you")
            .withRequest(new StandardHttpRequest(null, URI.create("http://localhost"), "GET", null)),
        null);

    // Then - could try to detect that it hasn't changed, but for now we'll just proceed with the same
    assertThat(result).isCompletedWithValue(true);
    verify(builder).setHeader("Authorization", "Bearer token-from-oauthtokenprovider");
  }

  @Test
  void afterFailure_withUsernamePassword_thenShouldAuthorize() {
    try (MockedStatic<KubeConfigUtils> kubeConfigUtilsMockedStatic = mockStatic(KubeConfigUtils.class)) {
      // Given
      Config config = mock(Config.class, RETURNS_DEEP_STUBS);
      when(config.getOauthTokenProvider()).thenReturn(null);
      io.fabric8.kubernetes.api.model.Config kubeConfigContent = mock(io.fabric8.kubernetes.api.model.Config.class);
      HttpClient client = mock(HttpClient.class);
      HttpRequest.Builder builder = mock(HttpRequest.Builder.class, RETURNS_SELF);
      HttpRequest httpRequest = mock(HttpRequest.class);
      HttpClient.DerivedClientBuilder derivedClientBuilder = mock(HttpClient.DerivedClientBuilder.class);
      HttpResponse<Object> authEndpointHttpResponse = mock(HttpResponse.class);
      HttpResponse<Object> authResponse = mock(HttpResponse.class);
      CompletableFuture<HttpResponse<Object>> authEndpointResponseCompletableFuture = new CompletableFuture<>();
      CompletableFuture<HttpResponse<Object>> authResponseCompletableFuture = new CompletableFuture<>();
      authEndpointResponseCompletableFuture.complete(authEndpointHttpResponse);
      authResponseCompletableFuture.complete(authResponse);
      when(config.getUsername()).thenReturn("user");
      when(config.getPassword()).thenReturn("pass");
      when(config.getMasterUrl()).thenReturn("http://localhost:8443");
      when(config.getCurrentContext()).thenReturn(new NamedContextBuilder()
          .withContext(new ContextBuilder()
              .withUser("testuser")
              .build())
          .build());
      when(config.getFile()).thenReturn(new File("kube/config"));
      when(kubeConfigContent.getUsers()).thenReturn(Collections.singletonList(new NamedAuthInfoBuilder()
          .withName("testuser")
          .build()));
      when(client.newBuilder()).thenReturn(derivedClientBuilder);
      when(client.newHttpRequestBuilder()).thenReturn(builder);
      when(builder.url(any())).thenReturn(builder);
      when(builder.build()).thenReturn(httpRequest);
      when(derivedClientBuilder.build()).thenReturn(client);
      when(authEndpointHttpResponse.isSuccessful()).thenReturn(true);
      when(authEndpointHttpResponse.code()).thenReturn(HTTP_OK);
      when(authEndpointHttpResponse.body()).thenReturn("{\"authorization_endpoint\":\"https://oauth-test/oauth/authorize\"}");
      when(authResponse.previousResponse()).thenReturn(Optional.empty());
      when(authResponse.headers("Location")).thenReturn(Collections.singletonList(
          "https://oauth-test/oauth/token/implicit#access_token=sha256~secret&expires_in=86400&scope=user%3Afull&token_type=Bearer"));
      when(client.sendAsync(any(), any()))
          .thenReturn(authEndpointResponseCompletableFuture)
          .thenReturn(authResponseCompletableFuture);
      kubeConfigUtilsMockedStatic.when(() -> KubeConfigUtils.parseConfig(any())).thenReturn(kubeConfigContent);
      OpenShiftOAuthInterceptor interceptor = new OpenShiftOAuthInterceptor(client, config);

      // When
      CompletableFuture<Boolean> result = interceptor.afterFailure(builder,
          TestHttpResponse.from(HttpURLConnection.HTTP_UNAUTHORIZED, "not for you")
              .withRequest(new StandardHttpRequest(null, URI.create("http://localhost"), "GET", null)),
          null);

      // Then
      assertThat(result).isCompletedWithValue(true);
      kubeConfigUtilsMockedStatic.verify(() -> KubeConfigUtils.persistKubeConfigIntoFile(any(), anyString()));
    }
  }

  @Test
  void testTokenRefreshedFromConfigForWebSocketBuilder() {
    Config config = mockConfigRefresh();
    when(config.refresh().getAutoOAuthToken()).thenReturn("token");

    HttpClient client = mock(HttpClient.class);
    OpenShiftOAuthInterceptor interceptor = new OpenShiftOAuthInterceptor(client, config);

    WebSocket.Builder builder = mock(WebSocket.Builder.class, RETURNS_DEEP_STUBS);

    interceptor.afterFailure(builder, TestHttpResponse.from(HttpURLConnection.HTTP_UNAUTHORIZED, "not for you")
        .withRequest(new StandardHttpRequest(null, URI.create("http://localhost"), "GET", null)), null);

    verify(builder).setHeader(TokenRefreshInterceptor.AUTHORIZATION, "Bearer token");
    verify(config).setAutoOAuthToken("token");
  }

  @Test
  void afterFailure_whenResponseCode403_thenShouldNotRefresh() {
    // Given
    HttpClient client = mock(HttpClient.class);
    Config config = mockConfigRefresh();
    HttpResponse<?> httpResponse = mockHttpResponse(HTTP_FORBIDDEN);
    HttpRequest.Builder httpRequestBuilder = mock(HttpRequest.Builder.class);
    OpenShiftOAuthInterceptor interceptor = new OpenShiftOAuthInterceptor(client, config);

    // When
    CompletableFuture<Boolean> result = interceptor.afterFailure(httpRequestBuilder, httpResponse, null);

    // Then
    assertThat(result).isCompletedWithValue(false);
  }

  @Test
  void afterFailure_whenResponseCode401_thenShouldRefresh() {
    // Given
    HttpClient client = mock(HttpClient.class);
    Config config = mockConfigRefresh();
    HttpRequest.Builder httpRequestBuilder = mock(HttpRequest.Builder.class);
    HttpResponse<?> httpResponse = mockHttpResponse(HTTP_UNAUTHORIZED);
    OpenShiftOAuthInterceptor interceptor = new OpenShiftOAuthInterceptor(client, config);

    // When
    CompletableFuture<Boolean> result = interceptor.afterFailure(httpRequestBuilder, httpResponse, null);

    // Then
    assertThat(result).isCompletedWithValue(true);
  }

  private Config mockConfigRefresh() {
    Config config = mock(Config.class);
    Config refreshedConfig = mock(Config.class);
    when(refreshedConfig.getAutoOAuthToken()).thenReturn("token");
    when(config.refresh()).thenReturn(refreshedConfig);
    return config;
  }

  private HttpResponse<?> mockHttpResponse(int responseCode) {
    HttpRequest httpRequest = mock(HttpRequest.class);
    HttpResponse<?> httpResponse = mock(HttpResponse.class);
    when(httpRequest.method()).thenReturn("GET");
    when(httpRequest.uri())
        .thenReturn(URI.create("http://www.example.com/apis/routes.openshift.io/namespaces/foo/routes"));
    when(httpResponse.request()).thenReturn(httpRequest);
    when(httpResponse.code()).thenReturn(responseCode);
    return httpResponse;
  }

}
