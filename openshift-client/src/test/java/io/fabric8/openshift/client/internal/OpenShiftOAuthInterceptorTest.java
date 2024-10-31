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
package io.fabric8.openshift.client.internal;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.http.AsyncBody;
import io.fabric8.kubernetes.client.http.StandardHttpRequest;
import io.fabric8.kubernetes.client.http.StandardWebSocketBuilder;
import io.fabric8.kubernetes.client.http.TestAsyncBody;
import io.fabric8.kubernetes.client.http.TestHttpResponse;
import io.fabric8.kubernetes.client.http.TestStandardHttpClient;
import io.fabric8.kubernetes.client.http.TestStandardHttpClientFactory;
import io.fabric8.kubernetes.client.utils.Serialization;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;

import static io.fabric8.kubernetes.client.http.TestStandardHttpClientFactory.Mode.SINGLETON;
import static java.nio.file.StandardOpenOption.CREATE;
import static org.assertj.core.api.Assertions.assertThat;

class OpenShiftOAuthInterceptorTest {

  private TestStandardHttpClientFactory clientFactory;
  private TestStandardHttpClient client;
  @TempDir
  private Path tempDir;
  private Path kubeConfigFile;
  private io.fabric8.kubernetes.api.model.ConfigBuilder kubeConfigOriginal;

  @BeforeEach
  void setUp() {
    clientFactory = new TestStandardHttpClientFactory(SINGLETON);
    client = clientFactory.newBuilder().build();
    kubeConfigFile = tempDir.resolve("config.yaml");
    kubeConfigOriginal = new io.fabric8.kubernetes.api.model.ConfigBuilder()
        .addNewUser()
        .withName("user")
        .withNewUser()
        .endUser()
        .endUser()
        .addNewCluster()
        .withName("cluster")
        .withNewCluster()
        .withServer("https://example.com")
        .endCluster()
        .endCluster()
        .addNewContext()
        .withName("current-context")
        .withNewContext()
        .withUser("user")
        .withCluster("cluster")
        .endContext()
        .endContext()
        .withCurrentContext("current-context");
  }

  @AfterEach
  void tearDown() {
    client.close();
  }

  @Test
  void basicAuthNotUsed() {
    // Given
    final var config = new ConfigBuilder(Config.empty()).withUsername("user").withPassword("pass").build();
    final var interceptor = new OpenShiftOAuthInterceptor(client, config);
    final var builder = client.newHttpRequestBuilder().uri("https://localhost");
    // When
    interceptor.before(builder, builder.build(), null);
    // Then
    assertThat(builder.build().headers("Authorization")).containsExactly("Bearer invalid");
  }

  @Test
  void tokenIsUsed() {
    // Given
    final var config = new ConfigBuilder(Config.empty()).withUsername("user").withPassword("pass").build();
    config.setAutoOAuthToken("token");
    final var interceptor = new OpenShiftOAuthInterceptor(client, config);
    final var builder = client.newHttpRequestBuilder().uri("https://localhost");
    // When
    interceptor.before(builder, builder.build(), null);
    // Then
    assertThat(builder.build().headers("Authorization")).containsExactly("Bearer token");
  }

  @Test
  void tokenIsRefreshedFromConfigFile() throws IOException {
    // Given
    kubeConfigOriginal.editFirstUser().editUser().withToken("original-token").endUser().endUser();
    Files.writeString(kubeConfigFile, Serialization.asYaml(kubeConfigOriginal.build()), CREATE);
    final Config initialConfig = Config.fromKubeconfig(kubeConfigFile.toFile());
    final var kubeConfigRefreshed = kubeConfigOriginal
        .editFirstUser().editUser().withToken("refreshed-token-from-config").endUser().endUser().build();
    Files.writeString(kubeConfigFile, Serialization.asYaml(kubeConfigRefreshed), CREATE);
    final var interceptor = new OpenShiftOAuthInterceptor(client, initialConfig);
    final var builder = client.newHttpRequestBuilder().uri("https://localhost");
    // When
    interceptor.afterFailure(builder, TestHttpResponse.from(401, "not for you")
        .withRequest(new StandardHttpRequest(null, URI.create("https://localhost"), "GET", null)), null);
    // Then
    assertThat(builder.build().headers("Authorization")).containsExactly("Bearer refreshed-token-from-config");
    assertThat(initialConfig)
        .returns(null, Config::getOauthToken)
        .returns("refreshed-token-from-config", Config::getAutoOAuthToken);
  }

  @Test
  void tokenIsRefreshedFromConfigFileForWs() throws IOException {
    // Given
    kubeConfigOriginal.editFirstUser().editUser().withToken("original-token").endUser().endUser();
    Files.writeString(kubeConfigFile, Serialization.asYaml(kubeConfigOriginal.build()), CREATE);
    final Config initialConfig = Config.fromKubeconfig(kubeConfigFile.toFile());
    final var kubeConfigRefreshed = kubeConfigOriginal
        .editFirstUser().editUser().withToken("refreshed-token-from-config").endUser().endUser().build();
    Files.writeString(kubeConfigFile, Serialization.asYaml(kubeConfigRefreshed), CREATE);
    final var interceptor = new OpenShiftOAuthInterceptor(client, initialConfig);
    final var builder = client.newWebSocketBuilder().uri(URI.create("wss://localhost"));
    // When
    interceptor.afterFailure(builder, TestHttpResponse.from(401, "not for you")
        .withRequest(new StandardHttpRequest(null, URI.create("wss://localhost"), "GET", null)), null);
    // Then
    assertThat(builder)
        .asInstanceOf(InstanceOfAssertFactories.type(StandardWebSocketBuilder.class))
        .extracting(StandardWebSocketBuilder::asHttpRequest)
        .returns("Bearer refreshed-token-from-config", r -> r.header("Authorization"));
  }

  @Test
  void afterFailure_whenTokenSetByUser_thenNoRefresh() {
    // Given
    final var config = new ConfigBuilder(Config.empty())
        .withOauthToken("manually-set-token")
        .build();
    final var builder = client.newHttpRequestBuilder().uri("https://localhost");
    final var interceptor = new OpenShiftOAuthInterceptor(client, config);
    // When
    CompletableFuture<Boolean> result = interceptor.afterFailure(builder,
        TestHttpResponse.from(401, "not for you")
            .withRequest(new StandardHttpRequest(null, URI.create("https://localhost"), "GET", null)),
        null);
    // Then
    assertThat(result).isCompletedWithValue(false);
    assertThat(config)
        .returns("manually-set-token", Config::getOauthToken)
        .returns(null, Config::getAutoOAuthToken);
  }

  @Test
  void afterFailure_whenOAuthTokenProviderPresent_thenUseTokenFromProvider() {
    // Given
    final var config = new ConfigBuilder(Config.empty())
        .withOauthTokenProvider(() -> "token-from-oauth-token-provider")
        .build();
    final var builder = client.newHttpRequestBuilder().uri("https://localhost");
    final var interceptor = new OpenShiftOAuthInterceptor(client, config);
    // When
    CompletableFuture<Boolean> result = interceptor.afterFailure(builder,
        TestHttpResponse.from(401, "not for you")
            .withRequest(new StandardHttpRequest(null, URI.create("https://localhost"), "GET", null)),
        null);
    // Then
    assertThat(result).isCompletedWithValue(true);
    assertThat(builder.build().headers("Authorization"))
        .containsExactly("Bearer token-from-oauth-token-provider");
  }

  @Test
  void afterFailure_withUsernamePassword_thenShouldAuthorizeAndPersistNewToken() throws IOException {
    // Given
    kubeConfigOriginal.editFirstUser().editUser().withUsername("username").withPassword("pa33word").endUser().endUser();
    Files.writeString(kubeConfigFile, Serialization.asYaml(kubeConfigOriginal.build()), CREATE);
    final var initialConfig = Config.fromKubeconfig(kubeConfigFile.toFile());
    final var builder = client.newHttpRequestBuilder().uri("https://localhost");
    final var interceptor = new OpenShiftOAuthInterceptor(client, initialConfig);
    clientFactory.expect("/.well-known/oauth-authorization-server", 200,
        "{\"authorization_endpoint\":\"https://oauth-test/oauth/authorize\"}");
    clientFactory.expect("/oauth/authorize", CompletableFuture.completedFuture(new TestHttpResponse<AsyncBody>()
        .withHeader("Location",
            "https://oauth-test/oauth/token/implicit#access_token=sha256~refreshed&expires_in=86400&scope=user%3Afull&token_type=Bearer")
        .withBody(new TestAsyncBody())));
    // When
    CompletableFuture<Boolean> result = interceptor.afterFailure(builder,
        TestHttpResponse.from(401, "not for you")
            .withRequest(new StandardHttpRequest(null, URI.create("https://localhost"), "GET", null)),
        null);
    // Then
    assertThat(result).isCompletedWithValue(true);
    assertThat(builder.build().headers("Authorization")).containsExactly("Bearer sha256~refreshed");
    final var updatedConfig = Config.fromKubeconfig(kubeConfigFile.toFile());
    assertThat(updatedConfig)
        .returns(null, Config::getOauthToken)
        .returns("sha256~refreshed", Config::getAutoOAuthToken);
  }

  @Test
  void afterFailure_whenResponseCode403_thenShouldNotRefresh() {
    // Given
    final var initialConfig = Config.empty();
    final var builder = client.newHttpRequestBuilder().uri("https://localhost");
    final var interceptor = new OpenShiftOAuthInterceptor(client, initialConfig);
    // When
    CompletableFuture<Boolean> result = interceptor.afterFailure(builder,
        TestHttpResponse.from(403, "FORBIDDEN")
            .withRequest(new StandardHttpRequest(null, URI.create("https://localhost"), "GET", null)),
        null);
    // Then
    assertThat(result).isCompletedWithValue(false);
  }

}
