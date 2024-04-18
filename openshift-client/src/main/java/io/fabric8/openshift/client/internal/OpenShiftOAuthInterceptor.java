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
package io.fabric8.openshift.client.internal;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.authorization.v1.SelfSubjectAccessReview;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.http.HttpResponse;
import io.fabric8.kubernetes.client.utils.HttpClientUtils;
import io.fabric8.kubernetes.client.utils.OpenIDConnectionUtils;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.kubernetes.client.utils.TokenRefreshInterceptor;
import io.fabric8.kubernetes.client.utils.URLUtils;
import io.fabric8.openshift.api.model.LocalResourceAccessReview;
import io.fabric8.openshift.api.model.LocalSubjectAccessReview;
import io.fabric8.openshift.api.model.ResourceAccessReview;
import io.fabric8.openshift.api.model.SelfSubjectRulesReview;
import io.fabric8.openshift.api.model.SubjectAccessReview;
import io.fabric8.openshift.api.model.SubjectRulesReview;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import static java.net.HttpURLConnection.HTTP_UNAUTHORIZED;

/**
 * Controls openshift authentication. It will be based upon an oauth token that can either come from a "login" or from the
 * config / token provider.
 */
public class OpenShiftOAuthInterceptor extends TokenRefreshInterceptor {

  private static final String AUTHORIZATION = "Authorization";
  private static final String LOCATION = "Location";
  private static final String AUTHORIZATION_SERVER_PATH = ".well-known/oauth-authorization-server";
  private static final String AUTHORIZE_QUERY = "?response_type=token&client_id=openshift-challenging-client";

  private static final String BEFORE_TOKEN = "access_token=";
  private static final String AFTER_TOKEN = "&expires";
  private static final Set<String> RETRIABLE_RESOURCES = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
      HasMetadata.getPlural(LocalSubjectAccessReview.class),
      HasMetadata.getPlural(LocalResourceAccessReview.class),
      HasMetadata.getPlural(ResourceAccessReview.class),
      HasMetadata.getPlural(SelfSubjectRulesReview.class),
      HasMetadata.getPlural(SubjectRulesReview.class),
      HasMetadata.getPlural(SubjectAccessReview.class),
      HasMetadata.getPlural(SelfSubjectAccessReview.class))));

  public OpenShiftOAuthInterceptor(HttpClient client, Config config) {
    super(config, Instant.now(),
        newestConfig -> authorize(config, client).thenApply(token -> persistNewOAuthTokenIntoKubeConfig(config, token)));
  }

  @Override
  protected boolean useBasicAuth() {
    return false; // openshift does not support the basic auth header
  }

  @Override
  protected boolean useRemoteRefresh(Config newestConfig) {
    return isBasicAuth(); // if we have both username, and password, try to refresh
  }

  private static CompletableFuture<String> authorize(Config config, HttpClient client) {
    HttpClient.DerivedClientBuilder builder = client.newBuilder();
    builder.addOrReplaceInterceptor(TokenRefreshInterceptor.NAME, null);
    HttpClient clone = builder.build();

    URL url;
    try {
      url = new URL(URLUtils.join(config.getMasterUrl(), AUTHORIZATION_SERVER_PATH));
    } catch (MalformedURLException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
    CompletableFuture<HttpResponse<String>> responseFuture = clone.sendAsync(clone.newHttpRequestBuilder().url(url).build(),
        String.class);
    return responseFuture.thenCompose(response -> {
      if (!response.isSuccessful() || response.body() == null) {
        throw new KubernetesClientException("Unexpected response (" + response.code() + " " + response.message() + ")");
      }

      String body = response.body();
      try {
        Map<String, Object> jsonResponse = Serialization.unmarshal(body, Map.class);
        String authorizationServer = String.valueOf(jsonResponse.get("authorization_endpoint"));

        URL authorizeQuery = new URL(authorizationServer + AUTHORIZE_QUERY);
        String credential = HttpClientUtils.basicCredentials(config.getUsername(), config.getPassword());

        return clone.sendAsync(client.newHttpRequestBuilder().url(authorizeQuery).setHeader(AUTHORIZATION, credential).build(),
            String.class);
      } catch (Exception e) {
        throw KubernetesClientException.launderThrowable(e);
      }

    }).thenApply(response -> {
      HttpResponse<?> responseOrPrevious = response.previousResponse().isPresent() ? response.previousResponse().get()
          : response;

      List<String> location = responseOrPrevious.headers(LOCATION);
      String token = !location.isEmpty() ? location.get(0) : null;
      if (token == null || token.isEmpty()) {
        throw new KubernetesClientException("Unexpected response (" + responseOrPrevious.code() + " "
            + responseOrPrevious.message() + "), to the authorization request. Missing header:[" + LOCATION
            + "].  More than likely the username / password are not correct.");
      }
      token = token.substring(token.indexOf(BEFORE_TOKEN) + BEFORE_TOKEN.length());
      token = token.substring(0, token.indexOf(AFTER_TOKEN));
      return token;
    });
  }

  @Override
  protected boolean shouldFail(HttpResponse<?> response) {
    HttpRequest request = response.request();
    String url = request.uri().toString();
    String method = request.method();
    // always retry in case of authorization endpoints; since they also return 200 when no
    // authorization header is provided
    if (method.equals("POST") && RETRIABLE_RESOURCES.stream().anyMatch(url::endsWith)) {
      return false;
    }
    return response.code() != HTTP_UNAUTHORIZED;
  }

  private static String persistNewOAuthTokenIntoKubeConfig(Config config, String token) {
    if (token != null) {
      OpenIDConnectionUtils.persistOAuthToken(config, null, token);
    }
    return token;
  }

}
