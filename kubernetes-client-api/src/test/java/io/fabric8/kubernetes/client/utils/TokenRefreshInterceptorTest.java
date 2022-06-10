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

import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.GoogleCredentials;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.http.TestHttpResponse;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

import static io.fabric8.kubernetes.client.Config.KUBERNETES_AUTH_SERVICEACCOUNT_TOKEN_FILE_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_AUTH_TRYKUBECONFIG_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_KUBECONFIG_FILE;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

      HttpRequest.Builder builder = Mockito.mock(HttpRequest.Builder.class, Mockito.RETURNS_SELF);

      // Call
      boolean reissue = new TokenRefreshInterceptor(Config.autoConfigure(null), null)
          .afterFailure(builder, new TestHttpResponse<>().withCode(401)).get();
      Mockito.verify(builder).setHeader("Authorization", "Bearer token");
      assertTrue(reissue);
    } finally {
      // Remove any side effect
      System.clearProperty(KUBERNETES_KUBECONFIG_FILE);
    }
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

      HttpRequest.Builder builder = Mockito.mock(HttpRequest.Builder.class, Mockito.RETURNS_SELF);

      // The expired token will be read at auto configure.
      TokenRefreshInterceptor interceptor = new TokenRefreshInterceptor(Config.autoConfigure(null), null);

      // Write new value to token file to simulate renewal.
      Files.write(tokenFile.toPath(), "renewed".getBytes());
      boolean reissue = interceptor.afterFailure(builder, new TestHttpResponse<>().withCode(401)).get();

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
      HttpRequest.Builder builder = Mockito.mock(HttpRequest.Builder.class, Mockito.RETURNS_SELF);

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

      TokenRefreshInterceptor interceptor = new TokenRefreshInterceptor(config, Mockito.mock(HttpClient.Factory.class));
      boolean reissue = interceptor.afterFailure(builder, new TestHttpResponse<>().withCode(401)).get();

      // Make the call and check that renewed token was read at 401 Unauthorized.
      Mockito.verify(builder).setHeader("Authorization", "Bearer renewed");
      assertTrue(reissue);
    } finally {
      // Remove any side effect.
      System.clearProperty(KUBERNETES_KUBECONFIG_FILE);
    }

  }

  @Test
  void shouldRefreshGCPToken() throws Exception {
    try {
      // Prepare kubeconfig for autoconfiguration
      File tempFile = Files.createTempFile("test", "kubeconfig").toFile();
      Files.copy(Objects.requireNonNull(getClass().getResourceAsStream("/token-refresh-interceptor/kubeconfig-gcp")),
        Paths.get(tempFile.getPath()), StandardCopyOption.REPLACE_EXISTING);
      System.setProperty(KUBERNETES_KUBECONFIG_FILE, tempFile.getAbsolutePath());

      String fakeToken = "new-fake-token";
      String fakeTokenExpiry = "2121-08-05T02:30:24Z";
      GoogleCredentials mockGC = Mockito.mock(GoogleCredentials.class);
      GCPAuthenticatorUtils.setCredentials(mockGC);
      Mockito.when(mockGC.getAccessToken())
        .thenReturn(new AccessToken(fakeToken, Date.from(Instant.parse(fakeTokenExpiry))));

      // Prepare HTTP call that will fail with 401 Unauthorized to trigger GCP token renewal.
      HttpRequest.Builder builder = Mockito.mock(HttpRequest.Builder.class, Mockito.RETURNS_SELF);

      // Loads the initial kubeconfig.
      Config config = Config.autoConfigure(null);

      // Copy over new config with following gcp auth provider configuration:
      Files.copy(Objects.requireNonNull(getClass().getResourceAsStream("/token-refresh-interceptor/kubeconfig-gcp")),
        Paths.get(tempFile.getPath()), StandardCopyOption.REPLACE_EXISTING);

      TokenRefreshInterceptor interceptor = new TokenRefreshInterceptor(config, Mockito.mock(HttpClient.Factory.class));
      boolean reissue = interceptor.afterFailure(builder, new TestHttpResponse<>().withCode(401)).get();

      // Make the call and check that renewed token was read at 401 Unauthorized.
      Mockito.verify(builder).setHeader("Authorization", "Bearer new-fake-token");
      assertTrue(reissue);
    } finally {
      // Remove any side effect.
      System.clearProperty(KUBERNETES_KUBECONFIG_FILE);
    }
  }
}
