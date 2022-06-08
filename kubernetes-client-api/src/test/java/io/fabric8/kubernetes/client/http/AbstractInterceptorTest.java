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
package io.fabric8.kubernetes.client.http;

import io.fabric8.mockwebserver.DefaultMockServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class AbstractInterceptorTest {

  private static DefaultMockServer server;

  @BeforeAll
  static void beforeAll() {
    server = new DefaultMockServer(false);
    server.start();
  }

  @AfterAll
  static void afterAll() {
    server.shutdown();
  }

  protected abstract HttpClient.Factory getHttpClientFactory();

  @Test
  @DisplayName("before, should add a header to the HTTP request")
  public void beforeAddsHeaderToRequest() throws Exception {
    // Given
    final HttpClient.Builder builder = getHttpClientFactory().newBuilder()
        .addOrReplaceInterceptor("test", new Interceptor() {
          @Override
          public void before(BasicBuilder builder, HttpHeaders headers) {
            builder.header("Test-Header", "Test-Value");
          }
        });
    // When
    try (HttpClient client = builder.build()) {
      client.sendAsync(client.newHttpRequestBuilder().uri(server.url("/intercept-before")).build(), String.class)
          .get(10L, TimeUnit.SECONDS);
    }
    // Then
    assertThat(server.getLastRequest().getHeaders().toMultimap())
        .containsEntry("test-header", Collections.singletonList("Test-Value"));
  }

  @Test
  @DisplayName("afterFailure (HTTP), replaces the HttpResponse produced by HttpClient.sendAsync")
  public void afterHttpFailureReplacesResponseInSendAsync() throws Exception {
    // Given
    server.expect().withPath("/intercepted-url").andReturn(200, "This works").always();
    final HttpClient.Builder builder = getHttpClientFactory().newBuilder()
        .addOrReplaceInterceptor("test", new Interceptor() {
          @Override
          public CompletableFuture<Boolean> afterFailure(BasicBuilder builder, HttpResponse<?> response) {
            builder.uri(URI.create(server.url("/intercepted-url")));
            return CompletableFuture.completedFuture(true);
          }
        });
    // When
    try (HttpClient client = builder.build()) {
      final HttpResponse<String> result = client
          .sendAsync(client.newHttpRequestBuilder().uri(server.url("/not-found")).build(), String.class)
          .get(10L, TimeUnit.SECONDS);
      // Then
      assertThat(result)
          .returns("This works", HttpResponse::body)
          .returns(200, HttpResponse::code);
    }
  }

  @Test
  @DisplayName("afterFailure (HTTP), replaces the HttpResponse produced by HttpClient.consumeLines")
  public void afterHttpFailureReplacesResponseInConsumeLines() throws Exception {
    // Given
    server.expect().withPath("/intercepted-url").andReturn(200, "This works").always();
    final HttpClient.Builder builder = getHttpClientFactory().newBuilder()
        .addOrReplaceInterceptor("test", new Interceptor() {
          @Override
          public CompletableFuture<Boolean> afterFailure(BasicBuilder builder, HttpResponse<?> response) {
            builder.uri(URI.create(server.url("/intercepted-url")));
            return CompletableFuture.completedFuture(true);
          }
        });
    final CompletableFuture<String> result = new CompletableFuture<>();
    // When
    try (HttpClient client = builder.build()) {
      final HttpResponse<HttpClient.AsyncBody> asyncR = client.consumeLines(
          client.newHttpRequestBuilder().uri(server.url("/not-found")).build(), (s, ab) -> {
            result.complete(s);
            ab.consume();
          })
          .get(10L, TimeUnit.SECONDS);
      asyncR.body().consume();
      asyncR.body().done().get(10L, TimeUnit.SECONDS);
      // Then
      assertThat(result.get()).isEqualTo("This works");
    }
  }

  @Test
  @DisplayName("afterFailure (HTTP), replaces the HttpResponse produced by HttpClient.consumeBytes")
  public void afterHttpFailureReplacesResponseInConsumeBytes() throws Exception {
    // Given
    server.expect().withPath("/intercepted-url").andReturn(200, "This works").always();
    final HttpClient.Builder builder = getHttpClientFactory().newBuilder()
        .addOrReplaceInterceptor("test", new Interceptor() {
          @Override
          public CompletableFuture<Boolean> afterFailure(BasicBuilder builder, HttpResponse<?> response) {
            builder.uri(URI.create(server.url("/intercepted-url")));
            return CompletableFuture.completedFuture(true);
          }
        });
    final CompletableFuture<String> result = new CompletableFuture<>();
    // When
    try (HttpClient client = builder.build()) {
      final HttpResponse<HttpClient.AsyncBody> asyncR = client.consumeBytes(
          client.newHttpRequestBuilder().uri(server.url("/not-found")).build(),
          (s, ab) -> {
            result.complete(StandardCharsets.UTF_8.decode(s.iterator().next()).toString());
            ab.consume();
          })
          .get(10L, TimeUnit.SECONDS);
      asyncR.body().consume();
      asyncR.body().done().get(10L, TimeUnit.SECONDS);
      // Then
      assertThat(result.get()).isEqualTo("This works");
    }
  }

  @Test
  @DisplayName("interceptors should be applied in the order they were added")
  public void interceptorsAreAppliedInOrder() throws Exception {
    // Given
    final HttpClient.Builder builder = getHttpClientFactory().newBuilder()
        .addOrReplaceInterceptor("first", new Interceptor() {
          @Override
          public void before(BasicBuilder builder, HttpHeaders headers) {
            builder.header("Test-Header", "Test-Value");
          }
        })
        .addOrReplaceInterceptor("second", new Interceptor() {
          @Override
          public void before(BasicBuilder builder, HttpHeaders headers) {
            builder.setHeader("Test-Header", "Test-Value-Override");
          }
        });
    // When
    try (HttpClient client = builder.build()) {
      client.sendAsync(client.newHttpRequestBuilder().uri(server.url("/intercept-before")).build(), String.class)
          .get(10L, TimeUnit.SECONDS);
    }
    // Then
    assertThat(server.getLastRequest().getHeaders().toMultimap())
        .containsEntry("test-header", Collections.singletonList("Test-Value-Override"));
  }
}
