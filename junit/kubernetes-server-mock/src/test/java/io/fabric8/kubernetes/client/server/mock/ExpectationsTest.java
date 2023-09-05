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
package io.fabric8.kubernetes.client.server.mock;

import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.http.HttpResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Kubernetes Mock Server Expectations")
class ExpectationsTest {
  private KubernetesMockServer server;
  private KubernetesClient client;
  private HttpClient httpClient;
  private HttpRequest.Builder request;

  @BeforeEach
  void setUp() {
    server = new KubernetesMockServer();
    server.start();
    client = server.createClient();
    httpClient = client.getHttpClient();
    request = httpClient.newHttpRequestBuilder();
  }

  @AfterEach
  void tearDown() {
    client.close();
  }

  @Nested
  @DisplayName("POST")
  class Post {

    @Test
    void postOk() {
      // Given
      server.expect()
          .post()
          .withPath("/api/post/ok")
          .andReturn(200, "ok")
          .once();
      // When
      final String result = client.raw("/api/post/ok", "POST", null);
      // Then
      assertThat(result).isEqualTo("ok");
    }

    @Test
    void postTooManyRequests() throws Exception {
      // Given
      server.expect()
          .post()
          .withPath("/api/post/too-many-requests")
          .andReturn(429, "Too Many Requests")
          .once();
      client.getConfiguration().setRequestRetryBackoffLimit(0);
      // When
      final HttpResponse<String> result = httpClient
          .sendAsync(request.uri(absolute("api/post/too-many-requests")).method("POST", null, null).build(), String.class)
          .get(10, TimeUnit.SECONDS);
      // Then
      assertThat(result)
          .returns(429, HttpResponse::code)
          .returns("Too Many Requests", HttpResponse::body);
    }

    @Test
    void postServerError() throws Exception {
      // Given
      server.expect()
          .post()
          .withPath("/api/post/server-error")
          .andReturn(500, "Server error")
          .once();
      client.getConfiguration().setRequestRetryBackoffLimit(0);
      // When
      final HttpResponse<String> result = httpClient
          .sendAsync(request.uri(absolute("api/post/server-error")).method("POST", null, null).build(), String.class)
          .get(10, TimeUnit.SECONDS);
      // Then
      assertThat(result)
          .returns(500, HttpResponse::code)
          .returns("Server error", HttpResponse::body);
    }

  }

  private String absolute(String relative) {
    return client.getConfiguration().getMasterUrl() + relative;
  }
}
