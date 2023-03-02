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
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.http.HttpResponse;
import io.fabric8.kubernetes.client.http.Interceptor;

import java.net.HttpURLConnection;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.CompletableFuture;

/**
 * Interceptor for handling kube authentication. It will either be basic auth, or token based. This class takes responsibility
 * for refreshing expired OIDC tokens.
 */
public class TokenRefreshInterceptor implements Interceptor {

  public static final String AUTHORIZATION = "Authorization";

  public static final String NAME = "TOKEN";

  private final Config config;
  private HttpClient.Factory factory;

  private static final int REFRESH_INTERVAL_MINUTE = 1;

  private Instant latestRefreshTimestamp;

  public TokenRefreshInterceptor(Config config, HttpClient.Factory factory, Instant latestRefreshTimestamp) {
    this.config = config;
    this.latestRefreshTimestamp = latestRefreshTimestamp;
    this.factory = factory;
  }

  @Override
  public void before(BasicBuilder headerBuilder, HttpRequest request, RequestTags tags) {
    if (isBasicAuth()) {
      headerBuilder.header(AUTHORIZATION, HttpClientUtils.basicCredentials(config.getUsername(), config.getPassword()));
      return;
    }
    if (Utils.isNotNullOrEmpty(config.getOauthToken())) {
      headerBuilder.header(AUTHORIZATION, "Bearer " + config.getOauthToken());
    }
    if (isTimeToRefresh()) {
      refreshToken(headerBuilder);
    }
  }

  private boolean isBasicAuth() {
    return Utils.isNotNullOrEmpty(config.getUsername()) && Utils.isNotNullOrEmpty(config.getPassword());
  }

  private boolean isTimeToRefresh() {
    return latestRefreshTimestamp.plus(REFRESH_INTERVAL_MINUTE, ChronoUnit.MINUTES).isBefore(Instant.now());
  }

  @Override
  public CompletableFuture<Boolean> afterFailure(BasicBuilder headerBuilder, HttpResponse<?> response, RequestTags tags) {
    if (isBasicAuth()) {
      return CompletableFuture.completedFuture(false);
    }
    if (response.code() == HttpURLConnection.HTTP_UNAUTHORIZED) {
      return refreshToken(headerBuilder);
    }
    return CompletableFuture.completedFuture(false);
  }

  private CompletableFuture<Boolean> refreshToken(BasicBuilder headerBuilder) {
    if (config.getOauthTokenProvider() != null) {
      String tokenFromProvider = config.getOauthTokenProvider().getToken();
      if (tokenFromProvider != null && !tokenFromProvider.isEmpty()) {
        return CompletableFuture.completedFuture(overrideNewAccessTokenToConfig(tokenFromProvider, headerBuilder, config));
      }
    }
    if (config.getUserConfiguredOauthToken() != null && !config.getUserConfiguredOauthToken().isEmpty()) {
      return CompletableFuture
          .completedFuture(overrideNewAccessTokenToConfig(config.getUserConfiguredOauthToken(), headerBuilder, config));
    }
    Config newestConfig = config.refresh();
    final CompletableFuture<String> newAccessToken = extractNewAccessTokenFrom(newestConfig);

    return newAccessToken.thenApply(token -> overrideNewAccessTokenToConfig(token, headerBuilder, config));
  }

  private CompletableFuture<String> extractNewAccessTokenFrom(Config newestConfig) {
    if (isAuthProviderOidc(newestConfig) && OpenIDConnectionUtils.idTokenExpired(newestConfig)) {
      return OpenIDConnectionUtils.resolveOIDCTokenFromAuthConfig(config, newestConfig.getAuthProvider().getConfig(),
          factory.newBuilder());
    }

    return CompletableFuture.completedFuture(newestConfig.getOauthToken());
  }

  private boolean overrideNewAccessTokenToConfig(String newAccessToken, BasicBuilder headerBuilder, Config existConfig) {
    if (Utils.isNotNullOrEmpty(newAccessToken)) {
      headerBuilder.setHeader(AUTHORIZATION, "Bearer " + newAccessToken);
      existConfig.setAutoOAuthToken(newAccessToken);

      updateLatestRefreshTimestamp();

      return true;
    }

    return false;
  }

  private void updateLatestRefreshTimestamp() {
    latestRefreshTimestamp = Instant.now();
  }

  private static boolean isAuthProviderOidc(Config newestConfig) {
    return newestConfig.getAuthProvider() != null && newestConfig.getAuthProvider().getName().equalsIgnoreCase("oidc");
  }
}
