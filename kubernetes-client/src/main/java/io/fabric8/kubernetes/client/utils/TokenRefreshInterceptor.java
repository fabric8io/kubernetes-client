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
import io.fabric8.kubernetes.api.model.Context;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.internal.KubeConfigUtils;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * Interceptor for handling expired OIDC tokens.
 */
public class TokenRefreshInterceptor implements Interceptor {
  private final Config config;
  public TokenRefreshInterceptor(Config config) {
    this.config = config;
  }

  @Override
  public Response intercept(Chain chain) throws IOException {
    Request request = chain.request();
    Response response = chain.proceed(request);
    if (response.code() == HttpURLConnection.HTTP_UNAUTHORIZED) {
      io.fabric8.kubernetes.api.model.Config kubeConfig = KubeConfigUtils.parseConfig(new File(Config.getKubeconfigFilename()));
      Context currentContext = null;
      String currentContextName = null;
      if (config.getCurrentContext() != null) {
        currentContext = config.getCurrentContext().getContext();
        currentContextName = config.getCurrentContext().getName();
      }
      AuthInfo currentAuthInfo = KubeConfigUtils.getUserAuthInfo(kubeConfig, currentContext);
      // Check if AuthProvider is set or not
      if (currentAuthInfo != null) {
        response.close();
        String newAccessToken;
        // Check if AuthProvider is set to oidc
        if (currentAuthInfo.getAuthProvider() != null && currentAuthInfo.getAuthProvider().getName().equalsIgnoreCase("oidc")) {
          newAccessToken = OpenIDConnectionUtils.resolveOIDCTokenFromAuthConfig(currentAuthInfo.getAuthProvider().getConfig());
        } else {
          Config newestConfig = Config.autoConfigure(currentContextName);
          newAccessToken = newestConfig.getOauthToken();
        }
        // Delete old Authorization header and append new one
        Request authReqWithUpdatedToken = chain.request().newBuilder()
          .header("Authorization", "Bearer " + newAccessToken).build();
        config.setOauthToken(newAccessToken);
        return chain.proceed(authReqWithUpdatedToken);
      }
    }
    return response;
  }
}
