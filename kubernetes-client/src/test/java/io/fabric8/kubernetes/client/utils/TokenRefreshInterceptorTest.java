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
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.junit.Ignore;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

import static io.fabric8.kubernetes.client.Config.KUBERNETES_KUBECONFIG_FILE;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_AUTH_SERVICEACCOUNT_TOKEN_FILE_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_AUTH_TRYKUBECONFIG_SYSTEM_PROPERTY;

/**
 * Ignoring for now - the token refresh should be based upon the java 11 client or the provided client library and not okhttp
 */
@Disabled
public class TokenRefreshInterceptorTest {

  @Test
  public void shouldAutoconfigureAfter401() throws IOException {
    try {
      // Prepare kubeconfig for autoconfiguration
      File tempFile = Files.createTempFile("test", "kubeconfig").toFile();
      Files.copy(Objects.requireNonNull(getClass().getResourceAsStream("/test-kubeconfig-tokeninterceptor")), Paths.get(tempFile.getPath()), StandardCopyOption.REPLACE_EXISTING);
      System.setProperty(KUBERNETES_KUBECONFIG_FILE, tempFile.getAbsolutePath());

      // Prepare http call
      Interceptor.Chain chain = Mockito.mock(Interceptor.Chain.class, Mockito.RETURNS_DEEP_STUBS);
      Request req = new Request.Builder().url("http://mock").build();
      Mockito.when(chain.request()).thenReturn(req);
      final Response.Builder responseBuilder = new Response.Builder()
        .request(req)
        .protocol(Protocol.HTTP_1_1)
        .message("")
        .body(ResponseBody.create(MediaType.parse("text"), "foo"));
      Mockito.when(chain.proceed(Mockito.any())).thenReturn(responseBuilder.code(HttpURLConnection.HTTP_UNAUTHORIZED).build(), responseBuilder.code(HttpURLConnection.HTTP_OK).build());

      // Call
      //new TokenRefreshInterceptor(Config.autoConfigure(null)).intercept(chain);
      Mockito.verify(chain).proceed(Mockito.argThat(argument -> "Bearer token".equals(argument.header("Authorization"))));
    } finally {
      // Remove any side effect
      System.clearProperty(KUBERNETES_KUBECONFIG_FILE);
    }
  }

  @Test
  void shouldReloadInClusterServiceAccount() throws IOException {
    try {
      // Write service account token file with value "expired" in it,
      // Set properties for it to be used instead of kubeconfig.
      File tokenFile = Files.createTempFile("test", "token").toFile();
      Files.write(tokenFile.toPath(), "expired".getBytes());
      System.setProperty(KUBERNETES_AUTH_SERVICEACCOUNT_TOKEN_FILE_SYSTEM_PROPERTY, tokenFile.getAbsolutePath());
      System.setProperty(KUBERNETES_AUTH_TRYKUBECONFIG_SYSTEM_PROPERTY, "false");

      // Prepare HTTP call that will fail with 401 Unauthorized to trigger service account token reload.
      Interceptor.Chain chain = Mockito.mock(Interceptor.Chain.class, Mockito.RETURNS_DEEP_STUBS);
      Request req = new Request.Builder().url("http://mock").build();
      Mockito.when(chain.request()).thenReturn(req);
      final Response.Builder responseBuilder = new Response.Builder()
          .request(req)
          .protocol(Protocol.HTTP_1_1)
          .message("")
          .body(ResponseBody.create(MediaType.parse("text"), "foo"));
      Mockito.when(chain.proceed(Mockito.any())).thenReturn(
          responseBuilder.code(HttpURLConnection.HTTP_UNAUTHORIZED).build(),
          responseBuilder.code(HttpURLConnection.HTTP_OK).build());

      // The expired token will be read at auto configure.
      TokenRefreshInterceptor interceptor = new TokenRefreshInterceptor(Config.autoConfigure(null));

      // Write new value to token file to simulate renewal.
      Files.write(tokenFile.toPath(), "renewed".getBytes());
      //interceptor.intercept(chain);

      // Make the call and check that renewed token was read at 401 Unauthorized.
      Mockito.verify(chain)
        .proceed(Mockito.argThat(argument -> "Bearer renewed".equals(argument.header("Authorization"))));
    } finally {
      // Remove any side effect
      System.clearProperty(KUBERNETES_AUTH_SERVICEACCOUNT_TOKEN_FILE_SYSTEM_PROPERTY);
      System.clearProperty(KUBERNETES_AUTH_TRYKUBECONFIG_SYSTEM_PROPERTY);
    }
  }

  @Test
  void shouldRefreshOIDCToken() throws IOException {
    try {
      // Prepare kubeconfig for autoconfiguration
      File tempFile = Files.createTempFile("test", "kubeconfig").toFile();
      Files.copy(Objects.requireNonNull(getClass().getResourceAsStream("/test-kubeconfig-oidc")),
          Paths.get(tempFile.getPath()), StandardCopyOption.REPLACE_EXISTING);
      System.setProperty(KUBERNETES_KUBECONFIG_FILE, tempFile.getAbsolutePath());

      // Prepare HTTP call that will fail with 401 Unauthorized to trigger OIDC token renewal.
      Interceptor.Chain chain = Mockito.mock(Interceptor.Chain.class, Mockito.RETURNS_DEEP_STUBS);
      Request req = new Request.Builder().url("http://mock").build();
      Mockito.when(chain.request()).thenReturn(req);
      final Response.Builder responseBuilder = new Response.Builder()
          .request(req).protocol(Protocol.HTTP_1_1)
          .message("")
          .body(ResponseBody.create(MediaType.parse("text"), "foo"));
      Mockito.when(chain.proceed(Mockito.any())).thenReturn(
          responseBuilder.code(HttpURLConnection.HTTP_UNAUTHORIZED).build(),
          responseBuilder.code(HttpURLConnection.HTTP_OK).build());

      // Loads the initial kubeconfig, including initial token value.
      Config config = Config.autoConfigure(null);

      // Copy over new config with following auth provider configuration:
      // - refresh-token is set to null to avoid real network connection towards
      //   OIDC provider. This makes it unnecessary to mock the OIDC HTTP client.
      // - id-token to set to "renewed". Since the original id-token at autoconfigure
      //   had different value, we can be used the new value to assert/observe that
      //   401 Unauthorized triggers renewal when OIDC auth provider is used.
      Files.copy(Objects.requireNonNull(getClass().getResourceAsStream("/test-kubeconfig-tokeninterceptor-oidc")),
          Paths.get(tempFile.getPath()), StandardCopyOption.REPLACE_EXISTING);

      //new TokenRefreshInterceptor(config).intercept(chain);

      // Make the call and check that renewed token was read at 401 Unauthorized.
      Mockito.verify(chain)
          .proceed(Mockito.argThat(argument -> "Bearer renewed".equals(argument.header("Authorization"))));
    } finally {
      // Remove any side effect.
      System.clearProperty(KUBERNETES_KUBECONFIG_FILE);
    }

  }
}
