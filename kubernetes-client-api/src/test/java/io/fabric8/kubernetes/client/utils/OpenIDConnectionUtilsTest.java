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

import io.fabric8.kubernetes.api.model.NamedContext;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.HttpResponse;
import io.fabric8.kubernetes.client.internal.KubeConfigUtils;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static io.fabric8.kubernetes.client.utils.OpenIDConnectionUtils.CLIENT_ID_KUBECONFIG;
import static io.fabric8.kubernetes.client.utils.OpenIDConnectionUtils.CLIENT_SECRET_KUBECONFIG;
import static io.fabric8.kubernetes.client.utils.OpenIDConnectionUtils.ID_TOKEN_KUBECONFIG;
import static io.fabric8.kubernetes.client.utils.OpenIDConnectionUtils.ID_TOKEN_PARAM;
import static io.fabric8.kubernetes.client.utils.OpenIDConnectionUtils.REFRESH_TOKEN_KUBECONFIG;
import static io.fabric8.kubernetes.client.utils.OpenIDConnectionUtils.REFRESH_TOKEN_PARAM;
import static io.fabric8.kubernetes.client.utils.OpenIDConnectionUtils.TOKEN_ENDPOINT_PARAM;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class OpenIDConnectionUtilsTest {
  HttpClient mockClient = Mockito.mock(HttpClient.class, Mockito.RETURNS_DEEP_STUBS);

  @Test
  void testLoadTokenURL() throws Exception {
    // Given
    String openIdIssuer = "https://accounts.example.com";
    String tokenEndpointResponse = "{\"issuer\": \"https://accounts.example.com\"," +
      " \"token_endpoint\": \"https://oauth2.exampleapis.com/token\"}";
    mockHttpClient(HttpURLConnection.HTTP_OK, tokenEndpointResponse);

    // When
    Map<String, Object> discoveryDocumentMap = OpenIDConnectionUtils.getOIDCDiscoveryDocumentAsMap(mockClient, openIdIssuer).get();

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
    Map<String, Object> discoveryDocumentAsMap = OpenIDConnectionUtils.getOIDCDiscoveryDocumentAsMap(mockClient, openIdIssuer).get();

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
    mockHttpClient(HttpURLConnection.HTTP_OK, "{\""+ ID_TOKEN_PARAM +"\":\"thisisatesttoken\",\"access_token\": \"thisisrefreshtoken\"," +
      "\"expires_in\": 3599," +
      "\"scope\": \"openid https://www.exampleapis.com/auth/userinfo.email\"," +
      "\"token_type\": \"Bearer\"}");

    // When
    Map<String, Object> response = OpenIDConnectionUtils.refreshOidcToken(mockClient, clientId, refreshToken, clientSecret, tokenEndpointUrl).get();

    // Then
    assertNotNull(response);
    assertEquals("thisisatesttoken", response.get(ID_TOKEN_PARAM));
  }

  @Test
  void testFetchOIDCProviderDiscoveryDocumentAndRefreshToken() throws Exception {
    // Given
    Map<String, Object> discoveryDocument = new HashMap<>();
    discoveryDocument.put(TOKEN_ENDPOINT_PARAM, "https://oauth2.exampleapis.com/token");
    String accessToken = "some.access.token";
    String clientId = "test-client-id";
    String refreshToken = "test-refresh-token";
    String clientSecret = "test-client-secret";
    mockHttpClient(HttpURLConnection.HTTP_OK, "{\""+ ID_TOKEN_PARAM +"\":\"thisisatesttoken\",\"access_token\": \"thisisrefreshtoken\"," +
      "\"expires_in\": 3599," +
      "\"scope\": \"openid https://www.exampleapis.com/auth/userinfo.email\"," +
      "\"token_type\": \"Bearer\"}");

    // When
    String newAccessToken = OpenIDConnectionUtils.getOIDCProviderTokenEndpointAndRefreshToken(mockClient,
      discoveryDocument, clientId, refreshToken, clientSecret, accessToken, false).get();

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
    Files.copy(getClass().getResourceAsStream("/test-kubeconfig-oidc"), Paths.get(tempFile.getPath()), StandardCopyOption.REPLACE_EXISTING);

    // When
    boolean isPersisted = OpenIDConnectionUtils.persistKubeConfigWithUpdatedToken(tempFile.getAbsolutePath(), openIdProviderResponse);

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
    String token = OpenIDConnectionUtils.resolveOIDCTokenFromAuthConfig(currentAuthProviderConfig, null).get();

    // Then
    assertEquals("id-token", token);
  }

  @Test
  void testgetParametersFromDiscoveryResponse() {
    // Given
    Map<String, Object> discoveryDocument = new HashMap<>();
    discoveryDocument.put("issuer", "https://api.login.example.com");
    discoveryDocument.put("token_endpoint", "https//api.login.example.com/oauth2/get_token");
    discoveryDocument.put("jwks_uri", "https//api.login.example.com/openid/v1/certs");

    // When + Then
    assertEquals("https//api.login.example.com/oauth2/get_token", OpenIDConnectionUtils.getParametersFromDiscoveryResponse(discoveryDocument, TOKEN_ENDPOINT_PARAM));
    assertEquals("", OpenIDConnectionUtils.getParametersFromDiscoveryResponse(discoveryDocument, "userinfo_endpoint"));
  }

  private void mockHttpClient(int responseCode, String responseAsStr) throws IOException {
    HttpResponse<String> mockSuccessResponse = mockResponse(responseCode, responseAsStr);
    when(mockClient.sendAsync(any(), Mockito.eq(String.class))).thenReturn(CompletableFuture.completedFuture(mockSuccessResponse));
  }

  private HttpResponse<String> mockResponse(int responseCode, String responseBody) {
    HttpResponse<String> response = Mockito.mock(HttpResponse.class, Mockito.CALLS_REAL_METHODS);
    Mockito.when(response.code()).thenReturn(responseCode);
    Mockito.when(response.body()).thenReturn(responseBody);
    return response;
  }
}
