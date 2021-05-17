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

package io.fabric8.openshift.client.internal;

import com.fasterxml.jackson.databind.JsonNode;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.kubernetes.client.utils.URLUtils;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.openshift.client.OpenShiftConfig;
import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.atomic.AtomicReference;

import static java.net.HttpURLConnection.HTTP_FORBIDDEN;
import static java.net.HttpURLConnection.HTTP_UNAUTHORIZED;

public class OpenShiftOAuthInterceptor implements Interceptor {

  private static final String AUTHORIZATION = "Authorization";
  private static final String LOCATION = "Location";
  private static final String AUTHORIZATION_SERVER_PATH = ".well-known/oauth-authorization-server";
  private static final String AUTHORIZE_QUERY = "?response_type=token&client_id=openshift-challenging-client";

  private static final String BEFORE_TOKEN = "access_token=";
  private static final String AFTER_TOKEN = "&expires";
  private static final String K8S_AUTHORIZATION = "authorization.k8s.io";
  private static final String OPENSHIFT_AUTHORIZATION = "authorization.openshift.io";

  private final OkHttpClient client;
  private final OpenShiftConfig config;
  private final AtomicReference<String> oauthToken = new AtomicReference<>();

  public OpenShiftOAuthInterceptor(OkHttpClient client, OpenShiftConfig config) {
    this.client = client;
    this.config = config;
  }

  @Override
  public Response intercept(Chain chain) throws IOException {
    Request request = chain.request();

    //Build new request
    Request.Builder builder = request.newBuilder();

    String token = oauthToken.get();
    // avoid overwriting basic auth token with stale bearer token
    if (Utils.isNotNullOrEmpty(token) && Utils.isNullOrEmpty(request.header(AUTHORIZATION))) {
      setAuthHeader(builder, token);
    }

    request = builder.build();
    Response response = chain.proceed(request);

    //If response is Forbidden or Unauthorized, try to obtain a token via authorize() or via config.
    if (isResponseSuccessful(request, response)) {
      return response;
    } else if (Utils.isNotNullOrEmpty(config.getUsername()) && Utils.isNotNullOrEmpty(config.getPassword())) {
      synchronized (client) {
        // current token (if exists) is borked, don't resend
        oauthToken.set(null);
        token = authorize();
        if (token != null) {
          oauthToken.set(token);
        }
      }
    } else if (Utils.isNotNullOrEmpty(config.getOauthToken())) {
      token = config.getOauthToken();
      oauthToken.set(token);
    }


    //If token was obtained, then retry request using the obtained token.
    if (Utils.isNotNullOrEmpty(token)) {
      // Close the previous response to prevent leaked connections.
      response.body().close();

      setAuthHeader(builder, token);
      request = builder.build();
      return chain.proceed(request); //repeat request with new token
    } else {
      return response;
    }
  }

  private void setAuthHeader(Request.Builder builder, String token) {
    if (token != null) {
      builder.header(AUTHORIZATION, String.format("Bearer %s", token));
    }
  }

  private  String authorize() {
    try {
      OkHttpClient.Builder builder = client.newBuilder();
      builder.interceptors().remove(this);
      OkHttpClient clone = builder.build();

      URL url = new URL(URLUtils.join(config.getMasterUrl(), AUTHORIZATION_SERVER_PATH));
      Response response = clone.newCall(new Request.Builder().get().url(url).build()).execute();

      if (!response.isSuccessful() || response.body() == null) {
        throw new KubernetesClientException("Unexpected response (" + response.code() + " " + response.message() + ")");
      }

      String body = response.body().string();
      JsonNode jsonResponse = Serialization.jsonMapper().readTree(body);
      String authorizationServer = jsonResponse.get("authorization_endpoint").asText();
      response.close();

      url = new URL(authorizationServer + AUTHORIZE_QUERY);

      String credential = Credentials.basic(config.getUsername(), config.getPassword());
      response = clone.newCall(new Request.Builder().get().url(url).header(AUTHORIZATION, credential).build()).execute();

      response.close();
      response = response.priorResponse() != null ? response.priorResponse() : response;
      response = response.networkResponse() != null ? response.networkResponse() : response;
      String token = response.header(LOCATION);
      if (token == null || token.isEmpty()) {
        throw new KubernetesClientException("Unexpected response (" + response.code() + " " + response.message() + "), to the authorization request. Missing header:[" + LOCATION + "]!");
      }
      token = token.substring(token.indexOf(BEFORE_TOKEN) + BEFORE_TOKEN.length());
      token = token.substring(0, token.indexOf(AFTER_TOKEN));
      return token;
    } catch (Exception e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  private boolean isResponseSuccessful(Request request, Response response) {
    String url = request.url().toString();
    // always retry in case of authorization endpoints; since they also return 200 when no
    // authorization header is provided
    if (url.contains(K8S_AUTHORIZATION) || url.contains(OPENSHIFT_AUTHORIZATION)) {
      return false;
    }
    return response.code() != HTTP_UNAUTHORIZED && response.code() != HTTP_FORBIDDEN;
  }
}
