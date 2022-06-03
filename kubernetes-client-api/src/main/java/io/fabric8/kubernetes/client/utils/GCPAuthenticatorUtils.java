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
import com.google.common.annotations.VisibleForTesting;
import io.fabric8.kubernetes.api.model.NamedContext;
import io.fabric8.kubernetes.client.internal.KubeConfigUtils;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility class for GCP token refresh.
 */
public class GCPAuthenticatorUtils {

  private static final Logger LOGGER = LoggerFactory.getLogger(GCPAuthenticatorUtils.class);

  public static final String EMPTY = "";
  public static final String ACCESS_TOKEN_PARAM = "access_token";
  public static final String EXPIRY_PARAM = "expiry";
  public static final String SCOPES = "scopes";
  public static final String[] DEFAULT_SCOPES =
    new String[]{
      "https://www.googleapis.com/auth/cloud-platform",
      "https://www.googleapis.com/auth/userinfo.email"
    };
  private static GoogleCredentials credentials;

  private GCPAuthenticatorUtils() {
  }

  /**
   *  Google Application Credentials-based refresh
   *  https://cloud.google.com/kubernetes-engine/docs/how-to/api-server-authentication#environments-without-gcloud
   * @param currentAuthProviderConfig current AuthInfo's AuthProvider config as a map
   * @return access token for interacting with Google Kubernetes API
   */
  public static CompletableFuture<String> resolveTokenFromAuthConfig(
    Map<String, String> currentAuthProviderConfig) {
    String[] scopes = parseScopes(currentAuthProviderConfig);
    try {
      if (credentials == null) {
        credentials = GoogleCredentials.getApplicationDefault().createScoped(scopes);
      }
      AccessToken accessToken = credentials.getAccessToken();
      currentAuthProviderConfig.put(ACCESS_TOKEN_PARAM, accessToken.getTokenValue());
      currentAuthProviderConfig.put(EXPIRY_PARAM,
        accessToken.getExpirationTime().toInstant().toString());
      persistKubeConfigWithUpdatedToken(currentAuthProviderConfig);
      CompletableFuture.completedFuture(accessToken.getTokenValue());
    } catch (IOException e) {
      throw new RuntimeException("The Application Default Credentials are not available.", e);
    }
    return CompletableFuture.completedFuture(currentAuthProviderConfig.get(ACCESS_TOKEN_PARAM));
  }

  public static String[] parseScopes(Map<String, String> config) {
    String scopes = (String) config.get(SCOPES);
    if (scopes == null) {
      return DEFAULT_SCOPES;
    }
    if (scopes.isEmpty()) {
      return new String[]{};
    }
    return scopes.split(",");
  }

  /**
   * Save Updated Access and Refresh token in local KubeConfig file.
   *
   * @param kubeConfigPath Path to KubeConfig (by default .kube/config)
   * @param updatedAuthProviderConfig updated AuthProvider configuration
   * @return boolean value whether update was successful not not
   * @throws IOException in case of any failure while writing file
   */
  static boolean persistKubeConfigWithUpdatedToken(String kubeConfigPath,
    Map<String, String> updatedAuthProviderConfig)
    throws IOException {
    io.fabric8.kubernetes.api.model.Config config = KubeConfigUtils.parseConfig(
      new File(kubeConfigPath));
    NamedContext currentNamedContext = KubeConfigUtils.getCurrentContext(config);

    if (currentNamedContext != null) {
      // Update users > auth-provider > config
      int currentUserIndex = KubeConfigUtils.getNamedUserIndexFromConfig(config,
        currentNamedContext.getContext().getUser());
      Map<String, String> authProviderConfig = config.getUsers().get(currentUserIndex).getUser()
        .getAuthProvider().getConfig();
      authProviderConfig.put(ACCESS_TOKEN_PARAM, updatedAuthProviderConfig.get(ACCESS_TOKEN_PARAM));
      authProviderConfig.put(EXPIRY_PARAM, updatedAuthProviderConfig.get(EXPIRY_PARAM));
      config.getUsers().get(currentUserIndex).getUser().getAuthProvider()
        .setConfig(authProviderConfig);

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

  private static boolean persistKubeConfigWithUpdatedToken(
    Map<String, String> updatedAuthProviderConfig) throws IOException {
    return persistKubeConfigWithUpdatedToken(
      io.fabric8.kubernetes.client.Config.getKubeconfigFilename(),
      updatedAuthProviderConfig);
  }

  @VisibleForTesting
  static void setCredentials(GoogleCredentials cre){
    credentials = cre;
  }
}
