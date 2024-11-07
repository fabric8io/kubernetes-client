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
package io.fabric8.kubernetes.client.utils;

import io.fabric8.kubernetes.api.model.AuthProviderConfig;
import io.fabric8.kubernetes.api.model.AuthProviderConfigBuilder;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.http.TestStandardHttpClient;
import io.fabric8.kubernetes.client.http.TestStandardHttpClientBuilder;
import io.fabric8.kubernetes.client.http.TestStandardHttpClientFactory;
import io.fabric8.kubernetes.client.internal.SSLUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.MockedStatic;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.Instant;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import static io.fabric8.kubernetes.client.http.TestStandardHttpClientFactory.Mode.SINGLETON;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mockStatic;

class OpenIDConnectionUtilsTest {

  private TestStandardHttpClient httpClient;
  private TestStandardHttpClientBuilder singletonHttpClientBuilder;

  @BeforeEach
  void setUp() {
    final TestStandardHttpClientFactory factory = new TestStandardHttpClientFactory(SINGLETON);
    httpClient = factory.newBuilder().build();
    singletonHttpClientBuilder = factory.newBuilder();
  }

  @Test
  void resolveOIDCTokenFromAuthConfigShouldReturnOldTokenWhenRefreshNotSupported() throws Exception {
    // Given
    Map<String, String> currentAuthProviderConfig = new HashMap<>();
    currentAuthProviderConfig.put("client-id", "client-id");
    currentAuthProviderConfig.put("client-secret", "client-secret");
    currentAuthProviderConfig.put("id-token", "id-token");

    // When
    String token = OpenIDConnectionUtils.resolveOIDCTokenFromAuthConfig(Config.empty(), currentAuthProviderConfig, null).get();

    // Then
    assertEquals("id-token", token);
  }

  @Test
  void resolveOIDCTokenFromAuthConfig_whenIDPCertNotPresentInAuthConfig_thenUseCertFromConfig() throws Exception {
    try (MockedStatic<SSLUtils> sslUtilsMockedStatic = mockStatic(SSLUtils.class)) {
      // Given
      Map<String, String> currentAuthProviderConfig = new HashMap<>();
      currentAuthProviderConfig.put("client-id", "client-id");
      currentAuthProviderConfig.put("client-secret", "client-secret");
      currentAuthProviderConfig.put("id-token", "id-token");
      currentAuthProviderConfig.put("refresh-token", "refresh-token");
      currentAuthProviderConfig.put("idp-issuer-url", "https://iam.cloud.example.com/identity");
      Config config = new ConfigBuilder(Config.empty())
          .withCaCertData("cert")
          .withAuthProvider(new AuthProviderConfig())
          .build();
      httpClient.expect("/identity/.well-known/openid-configuration", 200, "{" +
          "\"issuer\":\"https://iam.cloud.example.com/identity\"," +
          "\"token_endpoint\":\"https://iam.cloud.example.com/identity/token\"" +
          "}");
      httpClient.expect("/identity/token", 200, "{" +
          "\"id_token\":\"thisisatesttoken\"," +
          "\"access_token\":\"thisisrefreshtoken\"," +
          "\"expires_in\":3599," +
          "\"scope\":\"openid https://www.exampleapis.com/auth/userinfo.email\"," +
          "\"token_type\":\"Bearer\"" +
          "}");

      // When
      OpenIDConnectionUtils.resolveOIDCTokenFromAuthConfig(config, currentAuthProviderConfig, singletonHttpClientBuilder).get();

      // Then
      String decodedCert = new String(java.util.Base64.getDecoder().decode("cert"));
      sslUtilsMockedStatic.verify(() -> SSLUtils.trustManagers(eq(decodedCert), isNull(), anyBoolean(), isNull(), isNull()));
      sslUtilsMockedStatic.verify(
          () -> SSLUtils.keyManagers(eq(decodedCert), isNull(), isNull(), isNull(), isNull(), isNull(), isNull(), isNull()));
    }
  }

  @Test
  void resolveOIDCTokenFromAuthConfig_whenIDPCertNotPresentInAuthConfig_thenUseCertFileFromConfig(@TempDir File temporaryFolder)
      throws Exception {
    try (MockedStatic<SSLUtils> sslUtilsMockedStatic = mockStatic(SSLUtils.class)) {
      // Given
      File caCertFile = new File(temporaryFolder, "ca.crt");
      Files.write(caCertFile.toPath(), "cert".getBytes(StandardCharsets.UTF_8));
      Map<String, String> currentAuthProviderConfig = new HashMap<>();
      currentAuthProviderConfig.put("client-id", "client-id");
      currentAuthProviderConfig.put("client-secret", "client-secret");
      currentAuthProviderConfig.put("id-token", "id-token");
      currentAuthProviderConfig.put("refresh-token", "refresh-token");
      currentAuthProviderConfig.put("idp-issuer-url", "https://iam.cloud.example.com/identity");
      Config config = new ConfigBuilder(Config.empty())
          .withCaCertFile(caCertFile.getAbsolutePath())
          .withAuthProvider(new AuthProviderConfig())
          .build();
      httpClient.expect("/identity/.well-known/openid-configuration", 200, "{" +
          "\"issuer\":\"https://iam.cloud.example.com/identity\"," +
          "\"token_endpoint\":\"https://iam.cloud.example.com/identity/token\"" +
          "}");
      httpClient.expect("/identity/token", 200, "{" +
          "\"id_token\":\"thisisatesttoken\"," +
          "\"access_token\":\"thisisrefreshtoken\"," +
          "\"expires_in\":3599," +
          "\"scope\":\"openid https://www.exampleapis.com/auth/userinfo.email\"," +
          "\"token_type\":\"Bearer\"" +
          "}");

      // When
      OpenIDConnectionUtils.resolveOIDCTokenFromAuthConfig(config, currentAuthProviderConfig, singletonHttpClientBuilder).get();

      // Then
      sslUtilsMockedStatic.verify(() -> SSLUtils.trustManagers(eq("cert"), isNull(), anyBoolean(), isNull(), isNull()));
      sslUtilsMockedStatic.verify(
          () -> SSLUtils.keyManagers(eq("cert"), isNull(), isNull(), isNull(), isNull(), isNull(), isNull(), isNull()));
    }
  }

  @Test
  void idTokenExpired_whenEmptyFormatProvided_thenReturnTrue() {
    assertThat(OpenIDConnectionUtils.idTokenExpired(createNewConfigWithAuthProviderIdToken(""))).isTrue();
  }

  @Test
  void idTokenExpired_whenInvalidJwtTokenFormatProvided_thenReturnTrue() {
    assertThat(OpenIDConnectionUtils.idTokenExpired(createNewConfigWithAuthProviderIdToken("invalid-jwt-token"))).isTrue();
  }

  @Test
  void idTokenExpired_whenInvalidJwtPayloadProvided_thenReturnTrue() {
    assertThat(OpenIDConnectionUtils.idTokenExpired(createNewConfigWithAuthProviderIdToken("header.payload.signature")))
        .isTrue();
  }

  @Test
  void idTokenExpired_whenOldTokenProvided_thenReturnTrue() {
    // Given
    String token = "eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJodHRwczovL21sYi50cmVtb2xvLmxhbjo4MDQzL2F1dGgvaWRwL29pZGMiLCJhdWQiOiJrdWJlcm5ldGVzIiwiZXhwIjoxNDc0NTk2NjY5LCJqdGkiOiI2RDUzNXoxUEpFNjJOR3QxaWVyYm9RIiwiaWF0IjoxNDc0NTk2MzY5LCJuYmYiOjE0NzQ1OTYyNDksInN1YiI6Im13aW5kdSIsInVzZXJfcm9sZSI6WyJ1c2VycyIsIm5ldy1uYW1lc3BhY2Utdmlld2VyIl0sImVtYWlsIjoibXdpbmR1QG5vbW9yZWplZGkuY29tIn0.f2As579n9VNoaKzoF-dOQGmXkFKf1FMyNV0-va_B63jn-_n9LGSCca_6IVMP8pO-Zb4KvRqGyTP0r3HkHxYy5c81AnIh8ijarruczl-TK_yF5akjSTHFZD-0gRzlevBDiH8Q79NAr-ky0P4iIXS8lY9Vnjch5MF74Zx0c3alKJHJUnnpjIACByfF2SCaYzbWFMUNat-K1PaUk5-ujMBG7yYnr95xD-63n8CO8teGUAAEMx6zRjzfhnhbzX-ajwZLGwGUBT4WqjMs70-6a7_8gZmLZb2az1cZynkFRj2BaCkVT3A2RrjeEwZEtGXlMqKJ1_I2ulrOVsYx01_yD35-rw";

    // When + Then
    assertThat(OpenIDConnectionUtils.idTokenExpired(createNewConfigWithAuthProviderIdToken(token))).isTrue();
  }

  @Test
  void idTokenExpired_whenTokenStillNotExpired_thenReturnFalse() {
    // Given
    Instant tokenExp = Instant.now().plusSeconds(30);
    String payload = "{\"exp\": " + tokenExp.getEpochSecond() + "}";
    String token = "header." + Base64.getEncoder().encodeToString(payload.getBytes()) + ".signature";

    // When + Then
    assertThat(OpenIDConnectionUtils.idTokenExpired(createNewConfigWithAuthProviderIdToken(token))).isFalse();
  }

  private Config createNewConfigWithAuthProviderIdToken(String idToken) {
    return new ConfigBuilder(Config.empty())
        .withAuthProvider(new AuthProviderConfigBuilder()
            .addToConfig("id-token", idToken)
            .build())
        .build();
  }
}
