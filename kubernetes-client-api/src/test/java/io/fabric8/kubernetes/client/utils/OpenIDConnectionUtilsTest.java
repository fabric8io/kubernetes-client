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

import io.fabric8.kubernetes.api.model.AuthProviderConfigBuilder;
import io.fabric8.kubernetes.api.model.NamedContext;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.HttpResponse;
import io.fabric8.kubernetes.client.internal.KubeConfigUtils;
import io.fabric8.kubernetes.client.internal.SSLUtils;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Instant;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static io.fabric8.kubernetes.client.utils.OpenIDConnectionUtils.CLIENT_ID_KUBECONFIG;
import static io.fabric8.kubernetes.client.utils.OpenIDConnectionUtils.CLIENT_SECRET_KUBECONFIG;
import static io.fabric8.kubernetes.client.utils.OpenIDConnectionUtils.ID_TOKEN_KUBECONFIG;
import static io.fabric8.kubernetes.client.utils.OpenIDConnectionUtils.ID_TOKEN_PARAM;
import static io.fabric8.kubernetes.client.utils.OpenIDConnectionUtils.ISSUER_KUBECONFIG;
import static io.fabric8.kubernetes.client.utils.OpenIDConnectionUtils.REFRESH_TOKEN_KUBECONFIG;
import static io.fabric8.kubernetes.client.utils.OpenIDConnectionUtils.REFRESH_TOKEN_PARAM;
import static io.fabric8.kubernetes.client.utils.OpenIDConnectionUtils.TOKEN_ENDPOINT_PARAM;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

class OpenIDConnectionUtilsTest {
  HttpClient mockClient = mock(HttpClient.class, Mockito.RETURNS_DEEP_STUBS);

  @Test
  void testLoadTokenURL() throws Exception {
    // Given
    String openIdIssuer = "https://accounts.example.com";
    String tokenEndpointResponse = "{\"issuer\": \"https://accounts.example.com\"," +
        " \"token_endpoint\": \"https://oauth2.exampleapis.com/token\"}";
    mockHttpClient(HttpURLConnection.HTTP_OK, tokenEndpointResponse);

    // When
    Map<String, Object> discoveryDocumentMap = OpenIDConnectionUtils.getOIDCDiscoveryDocumentAsMap(mockClient, openIdIssuer)
        .get();

    // Then
    assertNotNull(discoveryDocumentMap);
    assertEquals("https://oauth2.exampleapis.com/token", discoveryDocumentMap.get(TOKEN_ENDPOINT_PARAM));
  }

  @Test
  void testLoadTokenURLWhenNotFound() throws Exception {
    // Given
    String openIdIssuer = "https://accounts.example.com";
    String tokenEndpointResponse = "{}";
    mockHttpClient(HttpURLConnection.HTTP_NOT_FOUND, tokenEndpointResponse);

    // When
    Map<String, Object> discoveryDocumentAsMap = OpenIDConnectionUtils.getOIDCDiscoveryDocumentAsMap(mockClient, openIdIssuer)
        .get();

    // Then
    assertTrue(discoveryDocumentAsMap.isEmpty());
  }

  @Test
  void testGetWellKnownUrlForOpenIDIssuer() {
    // Given
    String openIdIssuer = "https://accounts.example.com";

    // When
    String wellKnownUrl = OpenIDConnectionUtils.getWellKnownUrlForOpenIDIssuer(openIdIssuer);

    // Then
    assertEquals("https://accounts.example.com/.well-known/openid-configuration", wellKnownUrl);
  }

  @Test
  void testRefreshOidcToken() throws Exception {
    // Given
    String clientId = "test-client-id";
    String refreshToken = "test-refresh-token";
    String clientSecret = "test-client-secret";
    String tokenEndpointUrl = "https://oauth2.exampleapis.com/token";
    mockHttpClient(HttpURLConnection.HTTP_OK,
        "{\"" + ID_TOKEN_PARAM + "\":\"thisisatesttoken\",\"access_token\": \"thisisrefreshtoken\"," +
            "\"expires_in\": 3599," +
            "\"scope\": \"openid https://www.exampleapis.com/auth/userinfo.email\"," +
            "\"token_type\": \"Bearer\"}");

    // When
    Map<String, Object> response = OpenIDConnectionUtils
        .refreshOidcToken(mockClient, clientId, refreshToken, clientSecret, tokenEndpointUrl).get();

    // Then
    assertNotNull(response);
    assertEquals("thisisatesttoken", response.get(ID_TOKEN_PARAM));
  }

  @Test
  void testFetchOIDCProviderDiscoveryDocumentAndRefreshToken() throws Exception {
    // Given
    Map<String, Object> discoveryDocument = new HashMap<>();
    discoveryDocument.put(TOKEN_ENDPOINT_PARAM, "https://oauth2.exampleapis.com/token");
    String clientId = "test-client-id";
    String refreshToken = "test-refresh-token";
    String clientSecret = "test-client-secret";
    mockHttpClient(HttpURLConnection.HTTP_OK,
        "{\"" + ID_TOKEN_PARAM + "\":\"thisisatesttoken\",\"access_token\": \"thisisrefreshtoken\"," +
            "\"expires_in\": 3599," +
            "\"scope\": \"openid https://www.exampleapis.com/auth/userinfo.email\"," +
            "\"token_type\": \"Bearer\"}");

    // When
    String newAccessToken = String.valueOf(OpenIDConnectionUtils.refreshOidcToken(mockClient,
        clientId, refreshToken, clientSecret,
        OpenIDConnectionUtils.getParametersFromDiscoveryResponse(discoveryDocument, TOKEN_ENDPOINT_PARAM)).get()
        .get(ID_TOKEN_PARAM));

    // Then
    assertNotNull(newAccessToken);
    assertEquals("thisisatesttoken", newAccessToken);
  }

  @Test
  void testPersistKubeConfigWithUpdatedToken() throws IOException {
    // Given
    Map<String, Object> openIdProviderResponse = new HashMap<>();
    openIdProviderResponse.put(ID_TOKEN_PARAM, "id-token-updated");
    openIdProviderResponse.put(REFRESH_TOKEN_PARAM, "refresh-token-updated");
    File tempFile = Files.createTempFile("test", "kubeconfig").toFile();
    Files.copy(getClass().getResourceAsStream("/test-kubeconfig-oidc"), Paths.get(tempFile.getPath()),
        StandardCopyOption.REPLACE_EXISTING);

    Config theConfig = Config.fromKubeconfig(null, IOHelpers.readFully(new FileInputStream(tempFile), StandardCharsets.UTF_8),
        tempFile.getAbsolutePath());

    // When
    boolean isPersisted = OpenIDConnectionUtils.persistKubeConfigWithUpdatedToken(theConfig,
        openIdProviderResponse);

    // Then
    assertTrue(isPersisted);
    io.fabric8.kubernetes.api.model.Config config = KubeConfigUtils.parseConfig(tempFile);
    assertNotNull(config);
    NamedContext currentNamedContext = KubeConfigUtils.getCurrentContext(config);
    assertNotNull(currentNamedContext);
    int currentUserIndex = KubeConfigUtils.getNamedUserIndexFromConfig(config, currentNamedContext.getContext().getUser());
    assertTrue(currentUserIndex > 0);
    Map<String, String> authProviderConfig = config.getUsers().get(currentUserIndex).getUser().getAuthProvider().getConfig();
    assertFalse(authProviderConfig.isEmpty());
    assertEquals("id-token-updated", authProviderConfig.get(ID_TOKEN_KUBECONFIG));
    assertEquals("refresh-token-updated", authProviderConfig.get(REFRESH_TOKEN_KUBECONFIG));
  }

  @Test
  void testResolveOIDCTokenFromAuthConfigShouldReturnOldTokenWhenRefreshNotSupported() throws Exception {
    // Given
    Map<String, String> currentAuthProviderConfig = new HashMap<>();
    currentAuthProviderConfig.put(CLIENT_ID_KUBECONFIG, "client-id");
    currentAuthProviderConfig.put(CLIENT_SECRET_KUBECONFIG, "client-secret");
    currentAuthProviderConfig.put(ID_TOKEN_KUBECONFIG, "id-token");

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
      currentAuthProviderConfig.put(CLIENT_ID_KUBECONFIG, "client-id");
      currentAuthProviderConfig.put(CLIENT_SECRET_KUBECONFIG, "client-secret");
      currentAuthProviderConfig.put(ID_TOKEN_KUBECONFIG, "id-token");
      currentAuthProviderConfig.put(REFRESH_TOKEN_KUBECONFIG, "refresh-token");
      currentAuthProviderConfig.put(ISSUER_KUBECONFIG, "https://iam.cloud.example.com/identity");
      Config config = new ConfigBuilder(Config.empty()).withCaCertData("cert").build();
      HttpClient.Builder builder = mock(HttpClient.Builder.class);
      HttpClient httpClient = mock(HttpClient.class, RETURNS_DEEP_STUBS);
      when(builder.build()).thenReturn(httpClient);

      // When
      OpenIDConnectionUtils.resolveOIDCTokenFromAuthConfig(config, currentAuthProviderConfig, builder).get();

      // Then
      String decodedCert = new String(java.util.Base64.getDecoder().decode("cert"));
      sslUtilsMockedStatic.verify(() -> SSLUtils.trustManagers(eq(decodedCert), isNull(), anyBoolean(), isNull(), isNull()));
      sslUtilsMockedStatic.verify(
          () -> SSLUtils.keyManagers(eq(decodedCert), isNull(), isNull(), isNull(), isNull(), isNull(), isNull(), isNull()));
    }
  }

  @Test
  void testgetParametersFromDiscoveryResponse() {
    // Given
    Map<String, Object> discoveryDocument = new HashMap<>();
    discoveryDocument.put("issuer", "https://api.login.example.com");
    discoveryDocument.put("token_endpoint", "https//api.login.example.com/oauth2/get_token");
    discoveryDocument.put("jwks_uri", "https//api.login.example.com/openid/v1/certs");

    // When + Then
    assertEquals("https//api.login.example.com/oauth2/get_token",
        OpenIDConnectionUtils.getParametersFromDiscoveryResponse(discoveryDocument, TOKEN_ENDPOINT_PARAM));
    assertEquals("", OpenIDConnectionUtils.getParametersFromDiscoveryResponse(discoveryDocument, "userinfo_endpoint"));
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

  private void mockHttpClient(int responseCode, String responseAsStr) throws IOException {
    HttpResponse<String> mockSuccessResponse = mockResponse(responseCode, responseAsStr);
    when(mockClient.sendAsync(any(), eq(String.class)))
        .thenReturn(CompletableFuture.completedFuture(mockSuccessResponse));
  }

  private HttpResponse<String> mockResponse(int responseCode, String responseBody) {
    HttpResponse<String> response = mock(HttpResponse.class, Mockito.CALLS_REAL_METHODS);
    Mockito.when(response.code()).thenReturn(responseCode);
    Mockito.when(response.body()).thenReturn(responseBody);
    return response;
  }

  private Config createNewConfigWithAuthProviderIdToken(String idToken) {
    return new ConfigBuilder(Config.empty())
        .withAuthProvider(new AuthProviderConfigBuilder()
            .addToConfig(ID_TOKEN_KUBECONFIG, idToken)
            .build())
        .build();
  }
}
