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
import okhttp3.Request;
import okhttp3.Response;

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
      String currentContextName = null;
      String newAccessToken = null;

      if (config.getCurrentContext() != null) {
        currentContextName = config.getCurrentContext().getName();
      }
      Config newestConfig = Config.autoConfigure(currentContextName);
      if (newestConfig.getAuthProvider() != null && newestConfig.getAuthProvider().getName().equalsIgnoreCase("oidc")) {
        newAccessToken = OpenIDConnectionUtils.resolveOIDCTokenFromAuthConfig(newestConfig.getAuthProvider().getConfig());
      } else {
        newAccessToken = newestConfig.getOauthToken();
      }

      if (newAccessToken != null) {
        response.close();
        // Delete old Authorization header and append new one
        Request authReqWithUpdatedToken = chain.request().newBuilder()
          .header("Authorization", "Bearer " + newAccessToken).build();
        config.setOauthToken(newAccessToken);
        response = chain.proceed(authReqWithUpdatedToken);
      }
    }
    return response;
  }
}
