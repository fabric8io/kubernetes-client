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

import io.fabric8.kubernetes.api.model.AuthInfo;
import io.fabric8.kubernetes.api.model.NamedAuthInfo;
import io.fabric8.kubernetes.api.model.NamedContext;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.http.HttpResponse;
import io.fabric8.kubernetes.client.internal.KubeConfigUtils;
import io.fabric8.kubernetes.client.internal.SSLUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.time.Instant;
import java.util.Base64;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import javax.net.ssl.KeyManager;
import javax.net.ssl.TrustManager;

/**
 * Utility class for OpenID token refresh.
 */
public class OpenIDConnectionUtils {
  private static final Logger LOGGER = LoggerFactory.getLogger(OpenIDConnectionUtils.class);

  public static final String EMPTY = "";
  public static final String ID_TOKEN_KUBECONFIG = "id-token";
  public static final String ISSUER_KUBECONFIG = "idp-issuer-url";
  public static final String REFRESH_TOKEN_KUBECONFIG = "refresh-token";
  public static final String REFRESH_TOKEN_PARAM = "refresh_token";
  public static final String GRANT_TYPE_PARAM = "grant_type";
  public static final String CLIENT_ID_PARAM = "client_id";
  public static final String CLIENT_SECRET_PARAM = "client_secret";
  public static final String ID_TOKEN_PARAM = "id_token";
  public static final String ACCESS_TOKEN_PARAM = "access_token";
  public static final String CLIENT_ID_KUBECONFIG = "client-id";
  public static final String CLIENT_SECRET_KUBECONFIG = "client-secret";
  public static final String IDP_CERT_DATA = "idp-certificate-authority-data";
  public static final String TOKEN_ENDPOINT_PARAM = "token_endpoint";
  public static final String WELL_KNOWN_OPENID_CONFIGURATION = ".well-known/openid-configuration";
  public static final String GRANT_TYPE_REFRESH_TOKEN = "refresh_token";
  private static final String JWT_TOKEN_EXPIRY_TIMESTAMP_KEY = "exp";
  public static final String JWT_PARTS_DELIMITER_REGEX = "\\.";
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
  public static CompletableFuture<String> resolveOIDCTokenFromAuthConfig(Config currentConfig,
      Map<String, String> currentAuthProviderConfig,
      HttpClient.Builder clientBuilder) {
    String accessToken = currentAuthProviderConfig.get(ID_TOKEN_KUBECONFIG);
    String issuer = currentAuthProviderConfig.get(ISSUER_KUBECONFIG);
    String clientId = currentAuthProviderConfig.get(CLIENT_ID_KUBECONFIG);
    String refreshToken = currentAuthProviderConfig.get(REFRESH_TOKEN_KUBECONFIG);
    String clientSecret = currentAuthProviderConfig.getOrDefault(CLIENT_SECRET_KUBECONFIG, "");
    String idpCert = currentAuthProviderConfig.getOrDefault(IDP_CERT_DATA, currentConfig.getCaCertData());
    if (isTokenRefreshSupported(currentAuthProviderConfig)) {
      return getOIDCProviderTokenEndpointAndRefreshToken(issuer, clientId, refreshToken, clientSecret, idpCert, clientBuilder)
          .thenApply(map -> {
            Object token = map.get(ID_TOKEN_PARAM);
            if (token == null) {
              LOGGER.warn("token response did not contain an id_token, either the scope \\\"openid\\\" wasn't " +
                  "requested upon login, or the provider doesn't support id_tokens as part of the refresh response.");
              return accessToken;
            }

            // Persist new config and if successful, update the in memory config.
            try {
              persistKubeConfigWithUpdatedToken(currentConfig, map);
            } catch (IOException e) {
              LOGGER.warn("oidc: failure while persisting new tokens into KUBECONFIG", e);
            }

            return String.valueOf(token);
          });
    }
    return CompletableFuture.completedFuture(accessToken);
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
   * Issue Token Refresh HTTP Request to OIDC Provider
   *
   * @param client Http Client for issuing HTTP request
   * @param clientId client id
   * @param refreshToken refresh token
   * @param clientSecret client secret
   * @param tokenURL OpenID Connection provider's token refresh url
   * @return response as HashMap
   * @throws IOException in case of any error in contacting OIDC provider
   */
  static CompletableFuture<Map<String, Object>> refreshOidcToken(HttpClient client, String clientId, String refreshToken,
      String clientSecret, String tokenURL) {
    HttpRequest request = getTokenRefreshHttpRequest(client, tokenURL, clientId, refreshToken, clientSecret);
    CompletableFuture<HttpResponse<String>> response = client.sendAsync(request, String.class);
    return response.thenApply(r -> {
      String body = r.body();
      if (body != null) {
        // Get response body as string
        if (r.isSuccessful()) {
          // Deserialize response body into a Map and return
          try {
            return convertJsonStringToMap(body);
          } catch (Exception e) {
            LOGGER.warn("Failure in fetching refresh token: ", e);
          }
        } else {
          // Log error response body
          LOGGER.warn("Response: {}", body);
        }
      }
      return Collections.emptyMap();
    });
  }

  /**
   * OpenID providers publish their metadata at a well-known URL OpenID providers publish their metadata
   * at a well-known URL which looks like this: https://[base-server-url]/.well-known/openid-configuration
   * This method performs an Http Get at this public URL and fetches response as a HashMap
   *
   * @param client HttpClient for doing HTTP Get to well known URL of OpenID provider
   * @param issuer OpenID Connect provider issuer URL
   * @return a HashMap of Discovery document
   */
  static CompletableFuture<Map<String, Object>> getOIDCDiscoveryDocumentAsMap(HttpClient client, String issuer) {
    HttpRequest request = client.newHttpRequestBuilder().uri(getWellKnownUrlForOpenIDIssuer(issuer)).build();
    return client.sendAsync(request, String.class).thenApply(response -> {
      try {
        if (response.isSuccessful() && response.body() != null) {
          return convertJsonStringToMap(response.body());
        } else {
          // Don't produce an error that's too huge (e.g. if we get HTML back for some reason).
          String responseBody = response.body();
          LOGGER.warn("oidc: failed to query metadata endpoint: {} {}", response.code(), responseBody);
        }
      } catch (Exception e) {
        LOGGER.warn("Could not refresh OIDC token, failure in getting refresh URL", e);
      }
      return Collections.emptyMap();
    });
  }

  /**
   * Well known URL for getting OpenID Connect metadata.
   * https://openid.net/specs/openid-connect-discovery-1_0.html#ProviderConfig
   *
   * @param issuer issuing authority URL
   * @return well known URL for corresponding OpenID provider
   */
  static String getWellKnownUrlForOpenIDIssuer(String issuer) {
    return URLUtils.join(issuer, "/", WELL_KNOWN_OPENID_CONFIGURATION);
  }

  /**
   * Parses a specified parameter from OpenID Connect Discovery document
   *
   * @param responseAsJson discovery document as HashMap
   * @param key parameter whose value needs to be fetched
   * @return value of parameter passed.
   */
  static String getParametersFromDiscoveryResponse(Map<String, Object> responseAsJson, String key) {
    // Metadata object. We only care about the token_endpoint, the thing endpoint
    // we'll be refreshing against.
    //
    // https://openid.net/specs/openid-connect-discovery-1_0.html#ProviderMetadata
    if (responseAsJson.containsKey(key)) {
      return String.valueOf(responseAsJson.get(key));
    } else {
      LOGGER.warn("oidc: oidc: discovery object doesn't contain a {}", key);
    }
    return EMPTY;
  }

  /**
   * Save Updated Access and Refresh token in local KubeConfig file.
   *
   * @param updatedAuthProviderConfig updated AuthProvider configuration
   * @return boolean value whether update was successful or not
   * @throws IOException in case of any failure while writing file
   */
  static boolean persistKubeConfigWithUpdatedToken(Config currentConfig, Map<String, Object> updatedAuthProviderConfig)
      throws IOException {
    return persistKubeConfigWithUpdatedAuthInfo(currentConfig, a -> {
      Map<String, String> authProviderConfig = a.getAuthProvider().getConfig();
      authProviderConfig.put(ID_TOKEN_KUBECONFIG, String.valueOf(updatedAuthProviderConfig.get(ID_TOKEN_PARAM)));
      authProviderConfig.put(REFRESH_TOKEN_KUBECONFIG, String.valueOf(updatedAuthProviderConfig.get(REFRESH_TOKEN_PARAM)));
    });
  }

  /**
   * Return true if the Config can be updated. false if not for a variety of reasons:
   * - a kubeconfig file was not used
   * - there's no current context
   */
  public static boolean persistKubeConfigWithUpdatedAuthInfo(Config currentConfig, Consumer<AuthInfo> updateAction)
      throws IOException {
    if (currentConfig.getFile() == null) {
      return false;
    }
    io.fabric8.kubernetes.api.model.Config config = KubeConfigUtils.parseConfig(currentConfig.getFile());
    NamedContext currentNamedContext = currentConfig.getCurrentContext();

    if (currentNamedContext == null) {
      return false;
    }
    String userName = currentNamedContext.getContext().getUser();

    NamedAuthInfo namedAuthInfo = config.getUsers().stream().filter(n -> n.getName().equals(userName)).findFirst()
        .orElseGet(() -> {
          NamedAuthInfo result = new NamedAuthInfo(userName, new AuthInfo());
          config.getUsers().add(result);
          return result;
        });
    if (namedAuthInfo.getUser() == null) {
      namedAuthInfo.setUser(new AuthInfo());
    }
    updateAction.accept(namedAuthInfo.getUser());
    // Persist changes to KUBECONFIG
    KubeConfigUtils.persistKubeConfigIntoFile(config, currentConfig.getFile().getAbsolutePath());
    return true;
  }

  private static Map<String, Object> convertJsonStringToMap(String jsonString) {
    return Serialization.unmarshal(jsonString, Map.class);
  }

  private static HttpClient getDefaultHttpClientWithPemCert(String idpCert, HttpClient.Builder clientBuilder) {
    TrustManager[] trustManagers = null;
    KeyManager[] keyManagers = null;
    // fist, lets get the pem
    String pemCert = new String(java.util.Base64.getDecoder().decode(idpCert));

    try {
      trustManagers = SSLUtils.trustManagers(pemCert, null, false, null, null);
      keyManagers = SSLUtils.keyManagers(pemCert, null, null, null, null, null, null, null);
    } catch (KeyStoreException | InvalidKeySpecException | NoSuchAlgorithmException | IOException | UnrecoverableKeyException
        | CertificateException e) {
      throw new RuntimeException("Could not import idp certificate", e);
    }

    clientBuilder.sslContext(keyManagers, trustManagers);
    return clientBuilder.build();
  }

  private static HttpRequest getTokenRefreshHttpRequest(HttpClient client, String tokenEndpointUrl, String clientId,
      String refreshToken, String clientSecret) {
    HttpRequest.Builder httpRequestBuilder = client.newHttpRequestBuilder().uri(tokenEndpointUrl);

    Map<String, String> requestBody = getRequestBodyContentForRefresh(clientId, refreshToken, clientSecret);
    String credentials = java.util.Base64.getEncoder()
        .encodeToString((clientId + ':' + clientSecret).getBytes(StandardCharsets.UTF_8));
    httpRequestBuilder.header("Authorization", "Basic " + credentials);
    httpRequestBuilder.post(requestBody);
    return httpRequestBuilder.build();
  }

  private static Map<String, String> getRequestBodyContentForRefresh(String clientId, String refreshToken,
      String clientSecret) {
    Map<String, String> result = new LinkedHashMap<>();
    result.put(REFRESH_TOKEN_PARAM, refreshToken);
    result.put(GRANT_TYPE_PARAM, GRANT_TYPE_REFRESH_TOKEN);
    result.put(CLIENT_ID_PARAM, clientId);
    result.put(CLIENT_SECRET_PARAM, clientSecret);
    return result;
  }

  private static CompletableFuture<Map<String, Object>> getOIDCProviderTokenEndpointAndRefreshToken(String issuer,
      String clientId, String refreshToken, String clientSecret, String idpCert, HttpClient.Builder clientBuilder) {
    HttpClient newClient = getDefaultHttpClientWithPemCert(idpCert, clientBuilder);
    CompletableFuture<Map<String, Object>> result = getOIDCDiscoveryDocumentAsMap(newClient, issuer)
        .thenCompose(wellKnownOpenIdConfiguration -> {
          String oidcTokenEndpoint = getParametersFromDiscoveryResponse(wellKnownOpenIdConfiguration, TOKEN_ENDPOINT_PARAM);

          return refreshOidcToken(newClient, clientId, refreshToken, clientSecret, oidcTokenEndpoint);
        });
    result.whenComplete((s, t) -> newClient.close());
    return result;
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
}
