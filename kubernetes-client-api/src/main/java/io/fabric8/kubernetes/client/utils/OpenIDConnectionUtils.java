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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.fabric8.kubernetes.api.model.AuthInfo;
import io.fabric8.kubernetes.api.model.AuthProviderConfig;
import io.fabric8.kubernetes.api.model.NamedAuthInfo;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.internal.KubeConfigUtils;
import io.fabric8.kubernetes.client.internal.SSLUtils;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.time.Instant;
import java.util.Base64;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import javax.net.ssl.KeyManager;
import javax.net.ssl.TrustManager;

/**
 * Utility class for OpenID token refresh.
 */
public class OpenIDConnectionUtils {
  private static final Logger LOGGER = LoggerFactory.getLogger(OpenIDConnectionUtils.class);

  public static final String ID_TOKEN_KUBECONFIG = "id-token";
  public static final String ISSUER_KUBECONFIG = "idp-issuer-url";
  public static final String REFRESH_TOKEN_KUBECONFIG = "refresh-token";
  private static final String REFRESH_TOKEN_PARAM = "refresh_token";
  public static final String GRANT_TYPE_PARAM = "grant_type";
  public static final String CLIENT_ID_PARAM = "client_id";
  public static final String CLIENT_SECRET_PARAM = "client_secret";
  public static final String CLIENT_ID_KUBECONFIG = "client-id";
  public static final String CLIENT_SECRET_KUBECONFIG = "client-secret";
  private static final String IDP_CERT_DATA = "idp-certificate-authority-data";
  private static final String WELL_KNOWN_OPENID_CONFIGURATION = ".well-known/openid-configuration";
  private static final String GRANT_TYPE_REFRESH_TOKEN = "refresh_token";
  private static final String JWT_TOKEN_EXPIRY_TIMESTAMP_KEY = "exp";
  private static final String JWT_PARTS_DELIMITER_REGEX = "\\.";
  private static final int TOKEN_EXPIRY_DELTA = 10;

  private OpenIDConnectionUtils() {
  }

  /**
   * Fetch OpenID Connect token from Kubeconfig, check whether it's still valid or not; If expired handle
   * token refresh with OpenID Connection provider APIs
   *
   * @param currentAuthProviderConfig current AuthInfo's AuthProvider config as a map
   * @return access token for interacting with Kubernetes API
   */
  public static CompletableFuture<String> resolveOIDCTokenFromAuthConfig(
      Config currentConfig, Map<String, String> currentAuthProviderConfig, HttpClient.Builder clientBuilder) {
    String originalToken = currentAuthProviderConfig.get(ID_TOKEN_KUBECONFIG);
    String idpCert = currentAuthProviderConfig.getOrDefault(IDP_CERT_DATA, getClientCertDataFromConfig(currentConfig));
    if (isTokenRefreshSupported(currentAuthProviderConfig)) {
      final HttpClient httpClient = initHttpClientWithPemCert(idpCert, clientBuilder);
      final CompletableFuture<String> result = getOpenIdConfiguration(httpClient, currentAuthProviderConfig)
          .thenCompose(openIdConfiguration -> refreshOpenIdToken(httpClient, currentAuthProviderConfig, openIdConfiguration))
          .thenApply(oAuthToken -> persistOAuthToken(currentConfig, oAuthToken, null))
          .thenApply(oAuthToken -> {
            if (oAuthToken == null || Utils.isNullOrEmpty(oAuthToken.idToken)) {
              LOGGER.warn("token response did not contain an id_token, either the scope \\\"openid\\\" wasn't " +
                  "requested upon login, or the provider doesn't support id_tokens as part of the refresh response.");
              return originalToken;
            }
            return oAuthToken.idToken;
          });
      result.whenComplete((s, t) -> httpClient.close());
      return result;
    }
    return CompletableFuture.completedFuture(originalToken);
  }

  /**
   * Whether we should try to do token refresh or not, checks whether refresh-token key is set in
   * HashMap or not
   *
   * @param currentAuthProviderConfig a HashMap of current AuthProvider configuration
   * @return boolean value whether refresh-token is present or not.
   */
  static boolean isTokenRefreshSupported(Map<String, String> currentAuthProviderConfig) {
    return Utils.isNotNull(currentAuthProviderConfig.get(REFRESH_TOKEN_KUBECONFIG));
  }

  /**
   * OpenID providers publish their metadata at a well-known URL which looks like this:
   * https://[base-server-url]/.well-known/openid-configuration
   *
   * This method performs an HTTP GET at this public URL and fetches response as a Map.
   *
   * @param client HttpClient for doing HTTP Get to well known URL of OpenID provider
   * @param authProviderConfig OpenID Connect provider information
   * @return the OpenID Configuration as returned by the OpenID provider
   */
  private static CompletableFuture<OpenIdConfiguration> getOpenIdConfiguration(HttpClient client,
      Map<String, String> authProviderConfig) {
    final HttpRequest request = client.newHttpRequestBuilder()
        .uri(resolveWellKnownUrlForOpenIDIssuer(authProviderConfig)).build();
    return client.sendAsync(request, String.class).thenApply(response -> {
      try {
        if (response.isSuccessful() && response.body() != null) {
          return Serialization.unmarshal(response.body(), OpenIdConfiguration.class);
        } else {
          // Don't produce an error that's too huge (e.g. if we get HTML back for some reason).
          String responseBody = response.body();
          LOGGER.warn("oidc: failed to query metadata endpoint: {} {}", response.code(), responseBody);
        }
      } catch (Exception e) {
        LOGGER.warn("Could not refresh OIDC token, failure in getting refresh URL", e);
      }
      return null;
    });
  }

  /**
   * Issue Token Refresh HTTP Request to OIDC Provider
   */
  private static CompletableFuture<OAuthToken> refreshOpenIdToken(
      HttpClient httpClient, Map<String, String> authProviderConfig, OpenIdConfiguration openIdConfiguration) {
    if (openIdConfiguration == null || Utils.isNullOrEmpty(openIdConfiguration.tokenEndpoint)) {
      LOGGER.warn("oidc: discovery object doesn't contain a valid token endpoint: {}", openIdConfiguration);
      return CompletableFuture.completedFuture(null);
    }
    final HttpRequest request = initTokenRefreshHttpRequest(httpClient, authProviderConfig,
        openIdConfiguration.tokenEndpoint);
    return httpClient.sendAsync(request, String.class).thenApply(r -> {
      String body = r.body();
      if (body != null) {
        // Get response body as string
        if (r.isSuccessful()) {
          // Deserialize response body into a Map and return
          try {
            return Serialization.unmarshal(body, OAuthToken.class);
          } catch (Exception e) {
            LOGGER.warn("Failure in fetching refresh token: ", e);
          }
        } else {
          // Log error response body
          LOGGER.warn("Response: {}", body);
        }
      }
      return null;
    });
  }

  /**
   * Save Updated Access and Refresh token in local KubeConfig file and in-memory Config object.
   *
   * @param currentConfig current Config object.
   * @param oAuthToken OAuth token information as received from OpenID provider.
   * @param token new token to be persisted in KubeConfig (if not null).
   * @return the oAuthToken for chaining and further processing.
   */
  public static OAuthToken persistOAuthToken(Config currentConfig, OAuthToken oAuthToken, String token) {
    final Map<String, String> authProviderConfig = new HashMap<>();
    if (oAuthToken != null) {
      authProviderConfig.put(ID_TOKEN_KUBECONFIG, oAuthToken.idToken);
      authProviderConfig.put(REFRESH_TOKEN_KUBECONFIG, oAuthToken.refreshToken);
      // Persist in memory
      Optional.of(currentConfig).map(Config::getAuthProvider).map(AuthProviderConfig::getConfig)
          .ifPresent(c -> c.putAll(authProviderConfig));
    }
    // Persist in file
    if (currentConfig.getFile() != null && currentConfig.getCurrentContext() != null) {
      try {
        final io.fabric8.kubernetes.api.model.Config kubeConfig = KubeConfigUtils.parseConfig(currentConfig.getFile());
        final String userName = currentConfig.getCurrentContext().getContext().getUser();
        NamedAuthInfo namedAuthInfo = kubeConfig.getUsers().stream().filter(n -> n.getName().equals(userName)).findFirst()
            .orElseGet(() -> {
              NamedAuthInfo result = new NamedAuthInfo(userName, new AuthInfo());
              kubeConfig.getUsers().add(result);
              return result;
            });
        if (namedAuthInfo.getUser() == null) {
          namedAuthInfo.setUser(new AuthInfo());
        }
        if (namedAuthInfo.getUser().getAuthProvider() == null) {
          namedAuthInfo.getUser().setAuthProvider(new AuthProviderConfig());
        }
        namedAuthInfo.getUser().getAuthProvider().getConfig().putAll(authProviderConfig);
        if (Utils.isNotNullOrEmpty(token)) {
          namedAuthInfo.getUser().setToken(token);
        }
        KubeConfigUtils.persistKubeConfigIntoFile(kubeConfig, currentConfig.getFile().getAbsolutePath());
      } catch (IOException ex) {
        LOGGER.warn("oidc: failure while persisting new tokens into KUBECONFIG", ex);
      }
    }

    return oAuthToken;
  }

  /**
   * Well known URL for getting OpenID Connect metadata.
   * https://openid.net/specs/openid-connect-discovery-1_0.html#ProviderConfig
   *
   * @param authProviderConfig containing the issuing authority URL
   * @return well known URL for corresponding OpenID provider
   */
  private static String resolveWellKnownUrlForOpenIDIssuer(Map<String, String> authProviderConfig) {
    return URLUtils.join(authProviderConfig.get(ISSUER_KUBECONFIG), "/", WELL_KNOWN_OPENID_CONFIGURATION);
  }

  private static HttpClient initHttpClientWithPemCert(String idpCert, HttpClient.Builder clientBuilder) {
    // fist, lets get the pem
    String pemCert = new String(java.util.Base64.getDecoder().decode(idpCert));
    try {
      final TrustManager[] trustManagers = SSLUtils.trustManagers(pemCert, null, false, null, null);
      final KeyManager[] keyManagers = SSLUtils.keyManagers(pemCert, null, null, null, null, null, null, null);

      clientBuilder.sslContext(keyManagers, trustManagers);
      return clientBuilder.build();
    } catch (KeyStoreException | InvalidKeySpecException | NoSuchAlgorithmException | IOException | UnrecoverableKeyException
        | CertificateException e) {
      throw KubernetesClientException.launderThrowable("Could not import idp certificate", e);
    }
  }

  private static HttpRequest initTokenRefreshHttpRequest(
      HttpClient client, Map<String, String> authProviderConfig, String tokenRefreshUrl) {

    final String clientId = authProviderConfig.get(CLIENT_ID_KUBECONFIG);
    final String clientSecret = authProviderConfig.getOrDefault(CLIENT_SECRET_KUBECONFIG, "");
    final HttpRequest.Builder httpRequestBuilder = client.newHttpRequestBuilder().uri(tokenRefreshUrl);
    final String credentials = java.util.Base64.getEncoder().encodeToString((clientId + ':' + clientSecret)
        .getBytes(StandardCharsets.UTF_8));
    httpRequestBuilder.header("Authorization", "Basic " + credentials);

    final Map<String, String> requestBody = new LinkedHashMap<>();
    requestBody.put(REFRESH_TOKEN_PARAM, authProviderConfig.get(REFRESH_TOKEN_KUBECONFIG));
    requestBody.put(GRANT_TYPE_PARAM, GRANT_TYPE_REFRESH_TOKEN);
    requestBody.put(CLIENT_ID_PARAM, clientId);
    requestBody.put(CLIENT_SECRET_PARAM, clientSecret);

    httpRequestBuilder.post(requestBody);
    return httpRequestBuilder.build();
  }

  public static boolean idTokenExpired(Config config) {
    if (config.getAuthProvider() != null && config.getAuthProvider().getConfig() != null) {
      Map<String, String> authProviderConfig = config.getAuthProvider().getConfig();
      String accessToken = authProviderConfig.get(ID_TOKEN_KUBECONFIG);
      if (isValidJwt(accessToken)) {
        try {
          String[] jwtParts = accessToken.split(JWT_PARTS_DELIMITER_REGEX);
          String jwtPayload = jwtParts[1];
          String jwtPayloadDecoded = new String(Base64.getDecoder().decode(jwtPayload));
          Map<String, Object> jwtPayloadMap = Serialization.unmarshal(jwtPayloadDecoded, Map.class);
          int expiryTimestampInSeconds = (Integer) jwtPayloadMap.get(JWT_TOKEN_EXPIRY_TIMESTAMP_KEY);
          return Instant.ofEpochSecond(expiryTimestampInSeconds)
              .minusSeconds(TOKEN_EXPIRY_DELTA)
              .isBefore(Instant.now());
        } catch (Exception e) {
          return true;
        }
      }
    }
    return true;
  }

  private static boolean isValidJwt(String token) {
    if (token != null && !token.isEmpty()) {
      String[] jwtParts = token.split(JWT_PARTS_DELIMITER_REGEX);
      return jwtParts.length == 3;
    }
    return false;
  }

  private static String getClientCertDataFromConfig(Config config) {
    if (config.getCaCertData() != null && !config.getCaCertData().isEmpty()) {
      return config.getCaCertData();
    }
    try {
      if (config.getCaCertFile() != null) {
        return java.util.Base64.getEncoder().encodeToString(Files.readAllBytes(Paths.get(config.getCaCertFile())));
      }
    } catch (IOException e) {
      LOGGER.debug("Failure in reading certificate data from {}", config.getCaCertFile());
    }
    return null;
  }

  @Setter
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static final class OpenIdConfiguration {
    @JsonProperty("token_endpoint")
    private String tokenEndpoint;
  }

  @Setter
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static final class OAuthToken {
    @JsonProperty("id_token")
    private String idToken;
    @JsonProperty("refresh_token")
    private String refreshToken;
  }
}
