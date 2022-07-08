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
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.HttpHeaders;
import io.fabric8.kubernetes.client.http.HttpResponse;
import io.fabric8.kubernetes.client.http.Interceptor;

import java.net.HttpURLConnection;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

/**
 * Interceptor for handling expired OIDC tokens.
 */
public class TokenRefreshInterceptor implements Interceptor {

  public static final String NAME = "TOKEN";

  private final Config config;
  private HttpClient.Factory factory;

  private Instant lastRefresh;

  public TokenRefreshInterceptor(Config config, HttpClient.Factory factory) {
    this.config = config;
    this.lastRefresh = Instant.now();
    this.factory = factory;
  }

  @Override
  public void before(BasicBuilder headerBuilder, HttpHeaders headers) {
    if (timeToRefresh()) {
      refreshToken(headerBuilder);
    }
  }

  @Override
  public boolean afterFailure(BasicBuilder headerBuilder, HttpResponse<?> response) {
    if (response.code() == HttpURLConnection.HTTP_UNAUTHORIZED) {
      return refreshToken(headerBuilder);
    }
    return false;
  }

  private boolean refreshToken(BasicBuilder headerBuilder) {
    boolean resubmit = false;
    String currentContextName = null;
    if (config.getCurrentContext() != null) {
      currentContextName = config.getCurrentContext().getName();
    }
    String newAccessToken;
    Config newestConfig = Config.autoConfigure(currentContextName);
    if (newestConfig.getAuthProvider() != null && newestConfig.getAuthProvider().getName().equalsIgnoreCase("oidc")) {
      newAccessToken = OpenIDConnectionUtils.resolveOIDCTokenFromAuthConfig(newestConfig.getAuthProvider().getConfig(),
        factory.newBuilder());
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
    return resubmit;
  }

  private boolean timeToRefresh() {
    return lastRefresh.plus(1, ChronoUnit.MINUTES).isBefore(Instant.now());
  }

  // For testing only
  void setLastRefresh(Instant lastRefresh) {
    this.lastRefresh = lastRefresh;
  }
}
