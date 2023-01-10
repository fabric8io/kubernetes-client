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

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.StandardHttpHeaders;
import io.fabric8.kubernetes.client.http.StandardHttpRequest;
import io.fabric8.kubernetes.client.http.TestHttpResponse;
import io.fabric8.kubernetes.client.utils.TokenRefreshInterceptor;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.net.HttpURLConnection;
import java.net.URI;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

class OpenShiftOAuthInterceptorTest {

  @Test
  void testBasicAuthNotUsed() {
    Config config = Config.empty();
    config.setUsername("user");
    config.setPassword("pass");

    HttpClient client = Mockito.mock(HttpClient.class);

    OpenShiftOAuthInterceptor interceptor = new OpenShiftOAuthInterceptor(client, config);

    StandardHttpRequest.Builder builder = new StandardHttpRequest.Builder();
    builder.uri("http://localhost");

    interceptor.before(builder, new StandardHttpHeaders());

    assertTrue(builder.build().headers(TokenRefreshInterceptor.AUTHORIZATION).isEmpty());
  }

  @Test
  void testTokenUsed() {
    Config config = Config.empty();
    config.setUsername("user");
    config.setPassword("pass");
    config.setOauthToken("token");

    HttpClient client = Mockito.mock(HttpClient.class);

    OpenShiftOAuthInterceptor interceptor = new OpenShiftOAuthInterceptor(client, config);

    StandardHttpRequest.Builder builder = new StandardHttpRequest.Builder();
    builder.uri("http://localhost");

    interceptor.before(builder, new StandardHttpHeaders());

    assertEquals(Collections.singletonList("Bearer token"), builder.build().headers(TokenRefreshInterceptor.AUTHORIZATION));
  }

  @Test
  void testTokenRefreshedFromConfig() {
    Config config = Mockito.mock(Config.class, RETURNS_DEEP_STUBS);
    Mockito.when(config.refresh().getOauthToken()).thenReturn("token");

    HttpClient client = Mockito.mock(HttpClient.class);

    OpenShiftOAuthInterceptor interceptor = new OpenShiftOAuthInterceptor(client, config);

    StandardHttpRequest.Builder builder = new StandardHttpRequest.Builder();
    builder.uri("http://localhost");

    interceptor.afterFailure(builder, TestHttpResponse.from(HttpURLConnection.HTTP_UNAUTHORIZED, "not for you")
        .withRequest(new StandardHttpRequest(null, URI.create("http://localhost"), "GET", null)));

    assertEquals(Collections.singletonList("Bearer token"), builder.build().headers(TokenRefreshInterceptor.AUTHORIZATION));
    Mockito.verify(config).setOauthToken("token");
  }

}
