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
import io.fabric8.kubernetes.client.http.BasicBuilder;
import io.fabric8.kubernetes.client.http.HttpResponse;
import io.fabric8.kubernetes.client.http.Interceptor;

import java.net.HttpURLConnection;

/**
 * Interceptor for handling expired OIDC tokens.
 */
public class TokenRefreshInterceptor implements Interceptor {
  
  public static final String NAME = "TOKEN"; 
  
  private final Config config;
  
  public TokenRefreshInterceptor(Config config) {
    this.config = config;
  }
  
  @Override
  public boolean afterFailure(BasicBuilder headerBuilder, HttpResponse<?> response) {
    boolean resubmit = false;
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
        // Delete old Authorization header and append new one
        headerBuilder
          .setHeader("Authorization", "Bearer " + newAccessToken);
        config.setOauthToken(newAccessToken);
        resubmit = true;
      }
    }
    return resubmit;
  }

}
