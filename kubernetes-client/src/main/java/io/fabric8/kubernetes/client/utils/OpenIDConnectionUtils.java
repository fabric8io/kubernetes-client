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

import com.fasterxml.jackson.core.JsonProcessingException;
import io.fabric8.kubernetes.api.model.NamedContext;
import io.fabric8.kubernetes.client.internal.KubeConfigUtils;
import io.fabric8.kubernetes.client.internal.SSLUtils;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.util.Collections;
import java.util.Map;

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

  private OpenIDConnectionUtils() { }

  /**
   * Fetch OpenID Connect token from Kubeconfig, check whether it's still valid or not; If expired handle
   * token refresh with OpenID Connection provider APIs
   *
   * @param currentAuthProviderConfig current AuthInfo's AuthProvider config as a map
   * @return access token for interacting with Kubernetes API
   */
  public static String resolveOIDCTokenFromAuthConfig(Map<String, String> currentAuthProviderConfig) {
    String accessToken = currentAuthProviderConfig.get(ID_TOKEN_KUBECONFIG);
    String issuer = currentAuthProviderConfig.get(ISSUER_KUBECONFIG);
    String clientId = currentAuthProviderConfig.get(CLIENT_ID_KUBECONFIG);
    String refreshToken = currentAuthProviderConfig.get(REFRESH_TOKEN_KUBECONFIG);
    String clientSecret = currentAuthProviderConfig.getOrDefault(CLIENT_SECRET_KUBECONFIG, "");
    String idpCert = currentAuthProviderConfig.get(IDP_CERT_DATA);
    if (isTokenRefreshSupported(currentAuthProviderConfig)) {
      return getOIDCProviderTokenEndpointAndRefreshToken(issuer, clientId, refreshToken, clientSecret, accessToken, idpCert);
    }
    return accessToken;
  }

  /**
   * Get OIDC Provider discovery token_endpoint and issue refresh request
   *
   * @param client OkHttp Client
   * @param wellKnownOpenIdConfiguration OIDC Provider Discovery Document
   * @param clientId client id as string
   * @param refreshToken refresh token
   * @param clientSecret client secret
   * @param accessToken old access token
   * @param shouldPersistUpdatedTokenInKubeConfig boolean value whether to modify kubeconfig file in disc or not
   * @return returns access token(either updated or old) depending upon response from provider
   */
  static String getOIDCProviderTokenEndpointAndRefreshToken(OkHttpClient client, Map<String, Object> wellKnownOpenIdConfiguration, String clientId, String refreshToken, String clientSecret, String accessToken, boolean shouldPersistUpdatedTokenInKubeConfig) {
    String oidcTokenEndpoint = getParametersFromDiscoveryResponse(wellKnownOpenIdConfiguration, TOKEN_ENDPOINT_PARAM);
    try {
      String freshAccessToken = OpenIDConnectionUtils.refreshToken(client, oidcTokenEndpoint, clientId, refreshToken, clientSecret, shouldPersistUpdatedTokenInKubeConfig);
      if (freshAccessToken != null) {
        accessToken = freshAccessToken;
      }
    } catch (Exception e) {
      LOGGER.warn("Could not refresh OIDC token: {}", e.getMessage());
    }
    return accessToken;
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
   * Issue Token refresh request
   *
   * @param client okhttp client
   * @param oidcTokenEndpoint OIDC provider token endpoint
   * @param clientId client id
   * @param refreshToken refresh token for token refreshing
   * @param clientSecret client secret
   * @param shouldPersistUpdatedTokenInKubeConfig boolean value whether to update local kubeconfig file or not
   * @return access token received from OpenID Connection provider
   */
  static String refreshToken(OkHttpClient client, String oidcTokenEndpoint, String clientId, String refreshToken, String clientSecret, boolean shouldPersistUpdatedTokenInKubeConfig) {
    try {
      Map<String, Object> response = refreshOidcToken(client, clientId, refreshToken, clientSecret, oidcTokenEndpoint);

      if (!response.containsKey(ID_TOKEN_PARAM)) {
        LOGGER.warn("token response did not contain an id_token, either the scope \\\"openid\\\" wasn't " +
          "requested upon login, or the provider doesn't support id_tokens as part of the refresh response.");
        return null;
      }

      // Persist new config and if successful, update the in memory config.
      if (shouldPersistUpdatedTokenInKubeConfig && !persistKubeConfigWithUpdatedToken(response)) {
        LOGGER.warn("oidc: failure while persisting new tokens into KUBECONFIG");
      }
      return String.valueOf(response.get(ID_TOKEN_PARAM));
    } catch (IOException e) {
      LOGGER.warn("Failure in fetching refresh token: ", e);
    }
    return null;
  }


  /**
   * Issue Token Refresh HTTP Request to OIDC Provider
   *
   * @param client OkHttp Client for issuing HTTP request
   * @param clientId client id
   * @param refreshToken refresh token
   * @param clientSecret client secret
   * @param tokenURL OpenID Connection provider's token refresh url
   * @return response as HashMap
   * @throws IOException in case of any error in contacting OIDC provider
   */
  static Map<String, Object> refreshOidcToken(OkHttpClient client, String clientId, String refreshToken, String clientSecret, String tokenURL) throws IOException {
    try (Response response = client.newCall(getTokenRefreshHttpRequest(tokenURL, clientId, refreshToken, clientSecret)).execute()) {
      String responseBody;
      if (response.body() != null) {
        // Get response body as string
        responseBody = response.body().string();
        if (response.isSuccessful()) {
          // Deserialize response body into a Map and return
          return convertJsonStringToMap(responseBody);
        } else {
          // Log error response body
          LOGGER.warn("Response: {}", responseBody);
        }
      }
    }
    return Collections.emptyMap();
  }

  /**
   * OpenID providers publish their metadata at a well-known URL OpenID providers publish their metadata
   * at a well-known URL which looks like this: https://[base-server-url]/.well-known/openid-configuration
   * This method performs an Http Get at this public URL and fetches response as a HashMap
   *
   * @param client OkHttpClient for doing HTTP Get to well known URL of OpenID provider
   * @param issuer OpenID Connect provider issuer URL
   * @return a HashMap of Discovery document
   */
  static Map<String, Object> getOIDCDiscoveryDocumentAsMap(OkHttpClient client, String issuer) {
    try (Response response = client.newCall(getDiscoveryDocumentHttpRequest(issuer)).execute()) {
      if (response.isSuccessful() && response.body() != null) {
        return convertJsonStringToMap(response.body().string());
      } else {
        // Don't produce an error that's too huge (e.g. if we get HTML back for some reason).
        String responseBody = response.body() != null ? response.body().string() : null;
        LOGGER.warn("oidc: failed to query metadata endpoint: {} {}", response.code(), responseBody);
      }
    } catch (IOException e) {
      LOGGER.warn("Could not refresh OIDC token, failure in getting refresh URL", e);
    }
    return Collections.emptyMap();
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
   * @param kubeConfigPath Path to KubeConfig (by default .kube/config)
   * @param updatedAuthProviderConfig updated AuthProvider configuration
   * @return boolean value whether update was successful not not
   * @throws IOException in case of any failure while writing file
   */
  static boolean persistKubeConfigWithUpdatedToken(String kubeConfigPath, Map<String, Object> updatedAuthProviderConfig) throws IOException {
    io.fabric8.kubernetes.api.model.Config config = KubeConfigUtils.parseConfig(new File(kubeConfigPath));
    NamedContext currentNamedContext = KubeConfigUtils.getCurrentContext(config);

    if (currentNamedContext != null) {
      // Update users > auth-provider > config
      int currentUserIndex = KubeConfigUtils.getNamedUserIndexFromConfig(config, currentNamedContext.getContext().getUser());
      Map<String, String> authProviderConfig = config.getUsers().get(currentUserIndex).getUser().getAuthProvider().getConfig();
      authProviderConfig.put(ID_TOKEN_KUBECONFIG, String.valueOf(updatedAuthProviderConfig.get(ID_TOKEN_PARAM)));
      authProviderConfig.put(REFRESH_TOKEN_KUBECONFIG, String.valueOf(updatedAuthProviderConfig.get(REFRESH_TOKEN_PARAM)));
      config.getUsers().get(currentUserIndex).getUser().getAuthProvider().setConfig(authProviderConfig);

      // Persist changes to KUBECONFIG
      try {
        KubeConfigUtils.persistKubeConfigIntoFile(config, kubeConfigPath);
        return true;
      } catch (IOException exception) {
        LOGGER.warn("failed to write file {}", kubeConfigPath, exception);
      }
    }
    return false;
  }

  private static Map<String, Object> convertJsonStringToMap(String jsonString) throws JsonProcessingException {
    return Serialization.jsonMapper().readValue(jsonString, Map.class);
  }

  private static SSLContext getSSLContext(String idpCert) {
    SSLContext sslContext = null;

    if (idpCert != null) {
      // fist, lets get the pem
      String pemCert = new String(java.util.Base64.getDecoder().decode(idpCert));

      try {
        TrustManager[] trustManagers = SSLUtils.trustManagers(pemCert, null, false, null, null);
        KeyManager[] keyManagers = SSLUtils.keyManagers(pemCert, null, null, null, null, null, null, null);
        sslContext = SSLUtils.sslContext(keyManagers, trustManagers);
      } catch (KeyStoreException |
        KeyManagementException |
        InvalidKeySpecException |
        NoSuchAlgorithmException |
        IOException |
        UnrecoverableKeyException |
        CertificateException e) {
        throw new RuntimeException("Could not import idp certificate", e);
      }
    }
    return sslContext;
  }

  private static OkHttpClient getOkHttpClient(SSLContext sslContext, String pemCert) {
    OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
    if (sslContext != null) {
      clientBuilder.sslSocketFactory(sslContext.getSocketFactory(), getTrustManagerForAllCerts(pemCert));
    }
    return clientBuilder.build();
  }

  private static X509TrustManager getTrustManagerForAllCerts(String pemCert) {
    X509TrustManager trustManager = null;
    try {
      TrustManager[] trustManagers = SSLUtils.trustManagers(pemCert, null, false, null, null);
      if (trustManagers != null && trustManagers.length == 1) {
        trustManager = (X509TrustManager) trustManagers[0];
      }
    } catch (CertificateException | NoSuchAlgorithmException | KeyStoreException | IOException e) {
      LOGGER.warn("Could not get trust manager");
    }
    return trustManager;
  }

  private static Request getTokenRefreshHttpRequest(String tokenEndpointUrl, String clientId, String refreshToken, String clientSecret) throws JsonProcessingException {
    HttpUrl.Builder httpUrlBuilder = HttpUrl.get(tokenEndpointUrl).newBuilder();

    RequestBody requestBody = getRequestBodyContentForRefresh(clientId, refreshToken, clientSecret);
    Request.Builder requestBuilder = new Request.Builder().post(requestBody).url(httpUrlBuilder.build());
    String credentials =
      java.util.Base64.getEncoder()
        .encodeToString((clientId + ':' + clientSecret).getBytes(StandardCharsets.UTF_8));
    requestBuilder.addHeader("Authorization", "Basic " + credentials);
    requestBuilder.addHeader("Content-Type", "application/x-www-form-urlencoded");
    return requestBuilder.build();
  }

  private static Request getDiscoveryDocumentHttpRequest(String issuer) throws MalformedURLException {
    URL wellKnown = new URL(getWellKnownUrlForOpenIDIssuer(issuer));
    return new Request.Builder()
      .url(wellKnown)
      .build();
  }

  private static RequestBody getRequestBodyContentForRefresh(String clientId, String refreshToken, String clientSecret) {
    return  new FormBody.Builder()
      .add(REFRESH_TOKEN_PARAM, refreshToken)
      .add(GRANT_TYPE_PARAM, GRANT_TYPE_REFRESH_TOKEN)
      .add(CLIENT_ID_PARAM, clientId)
      .add(CLIENT_SECRET_PARAM, clientSecret)
      .build();
  }

  private static String getOIDCProviderTokenEndpointAndRefreshToken(String issuer, String clientId, String refreshToken, String clientSecret, String accessToken, String idpCert) {
    OkHttpClient okHttpClient = getOkHttpClient(getSSLContext(idpCert), idpCert);
    try {
      Map<String, Object> wellKnownOpenIdConfiguration = getOIDCDiscoveryDocumentAsMap(okHttpClient, issuer);
      return getOIDCProviderTokenEndpointAndRefreshToken(okHttpClient, wellKnownOpenIdConfiguration, clientId, refreshToken, clientSecret, accessToken, true);
    } finally {
      HttpClientUtils.close(okHttpClient);
    }
  }

  private static boolean persistKubeConfigWithUpdatedToken(Map<String, Object> updatedAuthProviderConfig) throws IOException {
    return persistKubeConfigWithUpdatedToken(io.fabric8.kubernetes.client.Config.getKubeconfigFilename(), updatedAuthProviderConfig);
  }
}
