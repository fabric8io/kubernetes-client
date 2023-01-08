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

import io.fabric8.kubernetes.client.Config;
import io.fabric8.mockwebserver.DefaultMockServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class AbstractInterceptorTest {

  private static DefaultMockServer server;

  @BeforeEach
  void startServer() {
    server = new DefaultMockServer(false);
    server.start();
  }

  @AfterEach
  void stopServer() {
    server.shutdown();
  }

  protected abstract HttpClient.Factory getHttpClientFactory();

  @Test
  @DisplayName("before (HTTP), should add a header to the HTTP request")
  public void beforeHttpAddsHeaderToRequest() throws Exception {
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
  @DisplayName("before (HTTP), should modify the HTTP request URI")
  public void beforeHttpModifiesRequestUri() throws Exception {
    // Given
    final HttpClient.Builder builder = getHttpClientFactory().newBuilder()
        .addOrReplaceInterceptor("test", new Interceptor() {
          @Override
          public void before(BasicBuilder builder, HttpHeaders headers) {
            builder.uri(URI.create(server.url("valid-url")));
          }
        });
    // When
    try (HttpClient client = builder.build()) {
      client.sendAsync(client.newHttpRequestBuilder().uri(server.url("/invalid-url")).build(), String.class)
          .get(10L, TimeUnit.SECONDS);
    }
    // Then
    assertThat(server.getRequestCount()).isEqualTo(1);
    assertThat(server.getLastRequest().getPath()).isEqualTo("/valid-url");
  }

  @Test
  @DisplayName("before (WS), should add a header to the HTTP request")
  public void beforeWsAddsHeaderToRequest() throws Exception {
    // Given
    server.expect().withPath("/intercept-before")
        .andUpgradeToWebSocket()
        .open().done().always();
    final HttpClient.Builder builder = getHttpClientFactory().newBuilder()
        .addOrReplaceInterceptor("test", new Interceptor() {
          @Override
          public void before(BasicBuilder builder, HttpHeaders headers) {
            builder.header("Test-Header", "Test-Value");
          }
        });
    try (HttpClient client = builder.build()) {
      // When
      client.newWebSocketBuilder()
          .uri(URI.create(server.url("intercept-before")))
          .buildAsync(new WebSocket.Listener() {
          }).get(10L, TimeUnit.SECONDS);
    }
    // Then
    assertThat(server.getLastRequest().getHeaders().toMultimap())
        .containsEntry("test-header", Collections.singletonList("Test-Value"));
  }

  @Test
  @DisplayName("before (WS), should modify the HTTP request URI")
  public void beforeWsModifiesRequestUri() throws Exception {
    // Given
    server.expect().withPath("/valid-url")
        .andUpgradeToWebSocket()
        .open().done().always();
    final HttpClient.Builder builder = getHttpClientFactory().newBuilder()
        .addOrReplaceInterceptor("test", new Interceptor() {
          @Override
          public void before(BasicBuilder builder, HttpHeaders headers) {
            builder.uri(URI.create(server.url("valid-url")));
          }
        });
    try (HttpClient client = builder.build()) {
      // When
      client.newWebSocketBuilder()
          .uri(URI.create(server.url("invalid-url")))
          .buildAsync(new WebSocket.Listener() {
          }).get(10L, TimeUnit.SECONDS);
    }
    // Then
    assertThat(server.getRequestCount()).isEqualTo(1);
    assertThat(server.getLastRequest().getPath()).isEqualTo("/valid-url");
  }

  @Test
  @DisplayName("afterFailure (HTTP), replaces the HttpResponse produced by HttpClient.sendAsync")
  public void afterHttpFailureReplacesResponseInSendAsync() throws Exception {
    // Given
    server.expect().withPath("/intercepted-url").andReturn(200, "This works").once();
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
  @DisplayName("afterFailure (HTTP), replaces the HttpResponse produced by HttpClient.consumeBytes")
  public void afterHttpFailureReplacesResponseInConsumeBytes() throws Exception {
    // Given
    server.expect().withPath("/intercepted-url").andReturn(200, "This works").once();
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
      final HttpResponse<AsyncBody> asyncR = client.consumeBytes(
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
  @DisplayName("afterFailure (HTTP), previous consumed response bodies are closed")
  public void afterHttpFailurePreviousResponsesAreClosed() throws Exception {
    // Given
    server.expect().withPath("/intercepted-url").andReturn(200, "This works").once();
    final Set<HttpResponse<?>> interceptedResponses = ConcurrentHashMap.newKeySet();
    final HttpClient.Builder builder = getHttpClientFactory().newBuilder()
        .addOrReplaceInterceptor("invalid-url", new Interceptor() {
          @Override
          public CompletableFuture<Boolean> afterFailure(BasicBuilder builder, HttpResponse<?> response) {
            builder.uri(URI.create(server.url("/still-not-found")));
            interceptedResponses.add(response);
            return CompletableFuture.completedFuture(true);
          }
        })
        .addOrReplaceInterceptor("valid-url", new Interceptor() {
          @Override
          public CompletableFuture<Boolean> afterFailure(BasicBuilder builder, HttpResponse<?> response) {
            builder.uri(URI.create(server.url("/intercepted-url")));
            interceptedResponses.add(response);
            return CompletableFuture.completedFuture(true);
          }
        });
    // When
    try (HttpClient client = builder.build()) {
      client.consumeBytes(
          client.newHttpRequestBuilder().uri(server.url("/not-found")).build(),
          (s, ab) -> ab.consume())
          .get(10, TimeUnit.SECONDS);
    }
    // Then
    assertThat(interceptedResponses)
        .hasSize(2)
        .extracting(r -> ((AsyncBody) r.body()).done().isDone())
        .containsOnly(true, true);
  }

  @Test
  @DisplayName("afterFailure (HTTP) sees the overridden RequestConfig")
  public void afterHttpFailureSuppliedConfig() throws Exception {
    // Given
    server.expect().withPath("/intercepted-url").andReturn(200, "This works").once();
    server.expect().withPath("/other-url").andReturn(200, "Overridden").once();
    final HttpClient.Builder builder = getHttpClientFactory().newBuilder()
        .addOrReplaceInterceptor("test", new ConfigAwareInterceptor());
    // When
    try (HttpClient client = builder.build()) {
      Config config = Config.empty();
      config.setImpersonateUsername("other-url");
      HttpClient derivedClient = client.newBuilder().requestConfig(config).build();

      final HttpResponse<String> result = derivedClient
          .sendAsync(derivedClient.newHttpRequestBuilder().uri(server.url("/not-found")).build(), String.class)
          .get(10L, TimeUnit.SECONDS);
      // Then
      assertThat(result)
          .returns("Overridden", HttpResponse::body)
          .returns(200, HttpResponse::code);
    }
  }

  @Test
  @DisplayName("afterFailure (WS), replaces the URL and returns true, should reconnect to valid URL")
  public void afterWSFailureTODOReplacesResponseInSendAsync() throws Exception {
    // Given
    server.expect().withPath("/valid-url")
        .andUpgradeToWebSocket()
        .open().done().always();
    final HttpClient.Builder builder = getHttpClientFactory().newBuilder()
        .addOrReplaceInterceptor("test", new Interceptor() {
          @Override
          public CompletableFuture<Boolean> afterFailure(BasicBuilder builder, HttpResponse<?> response) {
            builder.uri(URI.create(server.url("valid-url")));
            return CompletableFuture.completedFuture(true);
          }
        });
    try (HttpClient client = builder.build()) {
      // When
      client.newWebSocketBuilder()
          .uri(URI.create(server.url("invalid-url")))
          .buildAsync(new WebSocket.Listener() {
          }).get(10L, TimeUnit.SECONDS);
    }
    // Then
    assertThat(server.getRequestCount()).isEqualTo(2);
    assertThat(server.getLastRequest().getPath()).isEqualTo("/valid-url");
  }

  @Test
  @DisplayName("interceptors (HTTP) should be applied in the order they were added")
  public void interceptorsHttpAreAppliedInOrder() throws Exception {
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

  @Test
  @DisplayName("interceptors (WS) should be applied in the order they were added")
  public void interceptorWssAreAppliedInOrder() throws Exception {
    // Given
    server.expect().withPath("/intercept-before")
        .andUpgradeToWebSocket()
        .open().done().always();
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
    try (HttpClient client = builder.build()) {
      // When
      client.newWebSocketBuilder()
          .uri(URI.create(server.url("intercept-before")))
          .buildAsync(new WebSocket.Listener() {
          }).get(10L, TimeUnit.SECONDS);
    }
    // Then
    assertThat(server.getLastRequest().getHeaders().toMultimap())
        .containsEntry("test-header", Collections.singletonList("Test-Value-Override"));
  }

  private static final class ConfigAwareInterceptor implements Interceptor {

    private Config config;

    @Override
    public CompletableFuture<Boolean> afterFailure(BasicBuilder builder, HttpResponse<?> response) {
      String endpoint = "intercepted-url";
      if (config != null && config.getImpersonateUsername() != null) {
        endpoint = config.getImpersonateUsername();
      }
      builder.uri(URI.create(server.url("/" + endpoint)));
      return CompletableFuture.completedFuture(true);
    }

    @Override
    public Interceptor withConfig(Config config) {
      ConfigAwareInterceptor result = new ConfigAwareInterceptor();
      result.config = config;
      return result;
    }
  }
}
