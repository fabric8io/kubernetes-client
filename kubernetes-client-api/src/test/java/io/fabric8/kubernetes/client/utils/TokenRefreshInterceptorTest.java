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
package io.fabric8.kubernetes.client.utils;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.http.StandardHttpRequest;
import io.fabric8.kubernetes.client.http.TestHttpResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static io.fabric8.kubernetes.client.Config.KUBERNETES_AUTH_SERVICEACCOUNT_TOKEN_FILE_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_AUTH_TRYKUBECONFIG_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_KUBECONFIG_FILE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

/**
 * Ignoring for now - the token refresh should be based upon the java 11 client or the provided client library and not okhttp
 */
class TokenRefreshInterceptorTest {

  @Test
  void shouldAutoconfigureAfter401() throws Exception {
    try {
      // Prepare kubeconfig for autoconfiguration
      File tempFile = Files.createTempFile("test", "kubeconfig").toFile();
      Files.copy(Objects.requireNonNull(getClass().getResourceAsStream("/token-refresh-interceptor/kubeconfig")),
          Paths.get(tempFile.getPath()), StandardCopyOption.REPLACE_EXISTING);
      System.setProperty(KUBERNETES_KUBECONFIG_FILE, tempFile.getAbsolutePath());

      HttpRequest.Builder builder = mock(HttpRequest.Builder.class, Mockito.RETURNS_SELF);

      // Call
      boolean reissue = new TokenRefreshInterceptor(Config.autoConfigure(null), null, Instant.now())
          .afterFailure(builder, new TestHttpResponse<>().withCode(401), null).get();
      Mockito.verify(builder).setHeader("Authorization", "Bearer token");
      assertTrue(reissue);
    } finally {
      // Remove any side effect
      System.clearProperty(KUBERNETES_KUBECONFIG_FILE);
    }
  }

  @Test
  void shouldAutoconfigureAfter1Minute() throws Exception {
    try {
      // Prepare kubeconfig for autoconfiguration
      File tempFile = Files.createTempFile("test", "kubeconfig").toFile();
      Files.copy(Objects.requireNonNull(getClass().getResourceAsStream("/token-refresh-interceptor/kubeconfig")),
          Paths.get(tempFile.getPath()), StandardCopyOption.REPLACE_EXISTING);
      System.setProperty(KUBERNETES_KUBECONFIG_FILE, tempFile.getAbsolutePath());

      HttpRequest.Builder builder = mock(HttpRequest.Builder.class, Mockito.RETURNS_SELF);

      // Call
      TokenRefreshInterceptor tokenRefreshInterceptor = new TokenRefreshInterceptor(Config.autoConfigure(null),
          null,
          Instant.now().minus(61, ChronoUnit.SECONDS));

      // Replace kubeconfig file
      Files.copy(Objects.requireNonNull(getClass().getResourceAsStream("/token-refresh-interceptor/kubeconfig.new")),
          Paths.get(tempFile.getPath()), StandardCopyOption.REPLACE_EXISTING);
      tokenRefreshInterceptor.before(builder, null, null);
      Mockito.verify(builder).setHeader("Authorization", "Bearer new token");
    } finally {
      // Remove any side effect
      System.clearProperty(KUBERNETES_KUBECONFIG_FILE);
    }
  }

  @Test
  @DisplayName("#4442 token auto refresh should not overwrite existing token when not applicable")
  void refreshShouldNotOverwriteExistingToken() throws Exception {
    // Given
    final Config originalConfig = spy(new ConfigBuilder(Config.empty())
        .withOauthToken("existing-token")
        .build());
    final Config autoConfig = new ConfigBuilder(Config.empty())
        .withOauthToken("") // empty token
        .build();
    when(originalConfig.refresh()).thenReturn(autoConfig);
    final TokenRefreshInterceptor tokenRefreshInterceptor = new TokenRefreshInterceptor(
        originalConfig, null, Instant.now().minusSeconds(61));
    // When
    final boolean result = tokenRefreshInterceptor
        .afterFailure(new StandardHttpRequest.Builder(), new TestHttpResponse<>().withCode(401), null).get();
    // Then
    assertThat(result).isFalse();
    assertThat(originalConfig).hasFieldOrPropertyWithValue("oauthToken", "existing-token");
  }

  @Test
  @DisplayName("#4442 token auto refresh should not overwrite existing token when provided by user")
  void refresh_whenNoAuthProvider_thenShouldInheritTokenFromOldConfig() throws Exception {
    // Given
    final Config originalConfig = new ConfigBuilder(Config.empty())
        .withOauthToken("existing-token")
        .build();
    final TokenRefreshInterceptor tokenRefreshInterceptor = new TokenRefreshInterceptor(
        originalConfig, null, Instant.now().minusSeconds(61));
    // When
    final boolean result = tokenRefreshInterceptor
        .afterFailure(new StandardHttpRequest.Builder(), new TestHttpResponse<>().withCode(401), null).get();
    // Then
    assertThat(result).isFalse();
    assertThat(originalConfig).hasFieldOrPropertyWithValue("oauthToken", "existing-token");
  }

  @Test
  void shouldReloadInClusterServiceAccount() throws Exception {
    try {
      // Write service account token file with value "expired" in it,
      // Set properties for it to be used instead of kubeconfig.
      File tokenFile = Files.createTempFile("test", "token").toFile();
      Files.write(tokenFile.toPath(), "expired".getBytes());
      System.setProperty(KUBERNETES_AUTH_SERVICEACCOUNT_TOKEN_FILE_SYSTEM_PROPERTY, tokenFile.getAbsolutePath());
      System.setProperty(KUBERNETES_AUTH_TRYKUBECONFIG_SYSTEM_PROPERTY, "false");

      HttpRequest.Builder builder = mock(HttpRequest.Builder.class, Mockito.RETURNS_SELF);

      // The expired token will be read at auto configure.
      TokenRefreshInterceptor interceptor = new TokenRefreshInterceptor(Config.autoConfigure(null), null, Instant.now());

      // Write new value to token file to simulate renewal.
      Files.write(tokenFile.toPath(), "renewed".getBytes());
      boolean reissue = interceptor.afterFailure(builder, new TestHttpResponse<>().withCode(401), null).get();

      // Make the call and check that renewed token was read at 401 Unauthorized.
      Mockito.verify(builder).setHeader("Authorization", "Bearer renewed");
      assertTrue(reissue);
    } finally {
      // Remove any side effect
      System.clearProperty(KUBERNETES_AUTH_SERVICEACCOUNT_TOKEN_FILE_SYSTEM_PROPERTY);
      System.clearProperty(KUBERNETES_AUTH_TRYKUBECONFIG_SYSTEM_PROPERTY);
    }
  }

  @Test
  void shouldRefreshOIDCToken() throws Exception {
    try {
      // Prepare kubeconfig for autoconfiguration
      File tempFile = Files.createTempFile("test", "kubeconfig").toFile();
      Files.copy(Objects.requireNonNull(getClass().getResourceAsStream("/token-refresh-interceptor/kubeconfig-oidc")),
          Paths.get(tempFile.getPath()), StandardCopyOption.REPLACE_EXISTING);
      System.setProperty(KUBERNETES_KUBECONFIG_FILE, tempFile.getAbsolutePath());

      // Prepare HTTP call that will fail with 401 Unauthorized to trigger OIDC token renewal.
      HttpRequest.Builder builder = mock(HttpRequest.Builder.class, Mockito.RETURNS_SELF);

      // Loads the initial kubeconfig, including initial token value.
      Config config = Config.autoConfigure(null);

      // Copy over new config with following auth provider configuration:
      // - refresh-token is set to null to avoid real network connection towards
      //   OIDC provider. This makes it unnecessary to mock the OIDC HTTP client.
      // - id-token to set to "renewed". Since the original id-token at autoconfigure
      //   had different value, we can be used the new value to assert/observe that
      //   401 Unauthorized triggers renewal when OIDC auth provider is used.
      Files.copy(Objects.requireNonNull(getClass().getResourceAsStream("/token-refresh-interceptor/kubeconfig-oidc")),
          Paths.get(tempFile.getPath()), StandardCopyOption.REPLACE_EXISTING);

      TokenRefreshInterceptor interceptor = new TokenRefreshInterceptor(config, mock(HttpClient.Factory.class),
          Instant.now());
      boolean reissue = interceptor.afterFailure(builder, new TestHttpResponse<>().withCode(401), null).get();

      // Make the call and check that renewed token was read at 401 Unauthorized.
      Mockito.verify(builder).setHeader("Authorization", "Bearer renewed");
      assertTrue(reissue);
    } finally {
      // Remove any side effect.
      System.clearProperty(KUBERNETES_KUBECONFIG_FILE);
    }

  }

  @Test
  void afterFailure_whenTokenUpdatedPostRefreshUsingExecCredentials_thenUseUpdatedToken()
      throws ExecutionException, InterruptedException {
    // Given
    final Config oldConfig = mock(Config.class);
    final Config newConfig = mock(Config.class);
    HttpRequest.Builder builder = mock(HttpRequest.Builder.class, Mockito.RETURNS_SELF);
    when(oldConfig.refresh()).thenReturn(newConfig);
    when(newConfig.getOauthToken()).thenReturn("token-from-exec-credentials");
    final TokenRefreshInterceptor tokenRefreshInterceptor = new TokenRefreshInterceptor(
        oldConfig, null, Instant.now().minusSeconds(61));
    // When
    final boolean result = tokenRefreshInterceptor
        .afterFailure(builder, new TestHttpResponse<>().withCode(401), null).get();
    // Then
    assertThat(result).isTrue();
    Mockito.verify(builder).setHeader("Authorization", "Bearer token-from-exec-credentials");
  }

  @Test
  void afterFailure_whenTokenFromOAuthTokenProvider_thenUseUpdatedToken() throws ExecutionException, InterruptedException {
    // Given
    final Config oldConfig = mock(Config.class);
    HttpRequest.Builder builder = mock(HttpRequest.Builder.class, Mockito.RETURNS_SELF);
    when(oldConfig.getOauthTokenProvider()).thenReturn(() -> "token-from-oauthtokenprovider");
    final TokenRefreshInterceptor tokenRefreshInterceptor = new TokenRefreshInterceptor(
        oldConfig, null, Instant.now().minusSeconds(61));
    // When
    final boolean result = tokenRefreshInterceptor
        .afterFailure(builder, new TestHttpResponse<>().withCode(401), null).get();
    // Then
    assertThat(result).isTrue();
    Mockito.verify(builder).setHeader("Authorization", "Bearer token-from-oauthtokenprovider");
  }

  @Test
  void afterFailure_whenBasicAuth_thenCompleteWithFalse() {
    // Given
    final Config config = mock(Config.class);
    when(config.getUsername()).thenReturn("kubeadmin");
    when(config.getPassword()).thenReturn("secret");
    final TokenRefreshInterceptor tokenRefreshInterceptor = new TokenRefreshInterceptor(
        config, null, Instant.now().minusSeconds(61));

    // When
    CompletableFuture<Boolean> result = tokenRefreshInterceptor.afterFailure(null, null, null);

    // Then
    assertThat(result).isCompletedWithValue(false);
  }

  @Test
  void before_whenBasicAuth_thenUseCredentialsInHeader() {
    // Given
    final Config config = mock(Config.class);
    HttpRequest.Builder builder = mock(HttpRequest.Builder.class, Mockito.RETURNS_SELF);
    when(config.getUsername()).thenReturn("kubeadmin");
    when(config.getPassword()).thenReturn("secret");
    final TokenRefreshInterceptor tokenRefreshInterceptor = new TokenRefreshInterceptor(
        config, null, Instant.now().minusSeconds(61));

    // When
    tokenRefreshInterceptor.before(builder, null, null);

    // Then
    Mockito.verify(builder).header("Authorization", HttpClientUtils.basicCredentials("kubeadmin", "secret"));
  }
}
