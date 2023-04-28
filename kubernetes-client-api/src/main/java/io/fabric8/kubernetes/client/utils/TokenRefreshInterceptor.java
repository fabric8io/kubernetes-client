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
import java.util.function.Function;

/**
 * Interceptor for handling kube authentication. It will either be basic auth, or token based. This class takes responsibility
 * for refreshing expired OIDC tokens.
 */
public class TokenRefreshInterceptor implements Interceptor {

  public static final String AUTHORIZATION = "Authorization";

  public static final String NAME = "TOKEN";

  protected final Config config;
  private final Function<Config, CompletableFuture<String>> remoteRefresh;

  private static final int REFRESH_INTERVAL_MINUTE = 1;

  private volatile Instant latestRefreshTimestamp;

  public TokenRefreshInterceptor(Config config, HttpClient.Factory factory, Instant latestRefreshTimestamp) {
    this(config, latestRefreshTimestamp,
        newestConfig -> OpenIDConnectionUtils.resolveOIDCTokenFromAuthConfig(config, newestConfig.getAuthProvider().getConfig(),
            factory.newBuilder()));
  }

  public TokenRefreshInterceptor(Config config, Instant latestRefreshTimestamp,
      Function<Config, CompletableFuture<String>> remoteRefresh) {
    this.config = config;
    this.remoteRefresh = remoteRefresh;
    this.latestRefreshTimestamp = latestRefreshTimestamp;
  }

  @Override
  public void before(BasicBuilder headerBuilder, HttpRequest request, RequestTags tags) {
    if (useBasicAuth()) {
      headerBuilder.header(AUTHORIZATION, HttpClientUtils.basicCredentials(config.getUsername(), config.getPassword()));
      return;
    }

    String token = getEffectiveOauthToken(config);

    if (Utils.isNotNullOrEmpty(token)) {
      headerBuilder.header(AUTHORIZATION, "Bearer " + token);
    }
    if (isTimeToRefresh()) {
      refreshToken(headerBuilder);
    }
  }

  private static String getEffectiveOauthToken(Config config) {
    if (config.getOauthTokenProvider() != null) {
      return config.getOauthTokenProvider().getToken();
    }
    if (config.getOauthToken() != null) {
      return config.getOauthToken();
    }
    return config.getAutoOAuthToken();
  }

  protected boolean useBasicAuth() {
    return isBasicAuth();
  }

  final protected boolean isBasicAuth() {
    return Utils.isNotNullOrEmpty(config.getUsername()) && Utils.isNotNullOrEmpty(config.getPassword());
  }

  private boolean isTimeToRefresh() {
    return latestRefreshTimestamp.plus(REFRESH_INTERVAL_MINUTE, ChronoUnit.MINUTES).isBefore(Instant.now());
  }

  @Override
  public CompletableFuture<Boolean> afterFailure(BasicBuilder headerBuilder, HttpResponse<?> response, RequestTags tags) {
    if (shouldFail(response)) {
      return CompletableFuture.completedFuture(false);
    }
    return refreshToken(headerBuilder);
  }

  protected boolean shouldFail(HttpResponse<?> response) {
    return useBasicAuth() || response.code() != HttpURLConnection.HTTP_UNAUTHORIZED;
  }

  private CompletableFuture<Boolean> refreshToken(BasicBuilder headerBuilder) {
    if (config.getOauthTokenProvider() != null) {
      String tokenFromProvider = config.getOauthTokenProvider().getToken();
      return CompletableFuture.completedFuture(overrideNewAccessTokenToConfig(tokenFromProvider, headerBuilder));
    }
    if (config.getOauthToken() != null) {
      return CompletableFuture.completedFuture(false);
    }
    Config newestConfig = config.refresh();
    final CompletableFuture<String> newAccessToken = extractNewAccessTokenFrom(newestConfig);

    return newAccessToken.thenApply(token -> overrideNewAccessTokenToConfig(token, headerBuilder));
  }

  private CompletableFuture<String> extractNewAccessTokenFrom(Config newestConfig) {
    if (useRemoteRefresh(newestConfig)) {
      // TODO: determine the appropriate fall-back behavior.  If the result here is null, do we use the non-remote token
      return remoteRefresh.apply(newestConfig);
    }

    return CompletableFuture.completedFuture(getEffectiveOauthToken(newestConfig));
  }

  protected boolean useRemoteRefresh(Config newestConfig) {
    // TODO: in a hard failure scenario, should we skip the expired check
    return isAuthProviderOidc(newestConfig) && OpenIDConnectionUtils.idTokenExpired(newestConfig);
  }

  private boolean overrideNewAccessTokenToConfig(String newAccessToken, BasicBuilder headerBuilder) {
    if (Utils.isNotNullOrEmpty(newAccessToken)) {
      headerBuilder.setHeader(AUTHORIZATION, "Bearer " + newAccessToken);
      config.setAutoOAuthToken(newAccessToken);

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
