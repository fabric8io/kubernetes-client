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
package io.fabric8.kubernetes.client.http;

import io.fabric8.mockwebserver.DefaultMockServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for handling small and empty HTTP responses.
 *
 * <p>
 * These tests verify that HTTP client implementations correctly handle responses
 * that arrive very quickly, particularly when the response body is small or empty.
 * This is important because some implementations may have race conditions where
 * the response body is consumed before handlers are set up.
 *
 * <p>
 * The race condition occurs in async HTTP clients when:
 * <ol>
 * <li>A request is sent and the response arrives very quickly</li>
 * <li>The response body (if small) is received and processed before the async
 * handler transformation runs</li>
 * <li>The response ends before handlers can be attached</li>
 * <li>Attempting to attach handlers throws an exception</li>
 * </ol>
 */
public abstract class AbstractHttpClientSmallResponseTest {

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
  @DisplayName("consumeBytes handles empty response body")
  void consumeBytesHandlesEmptyResponse() throws Exception {
    server.expect().withPath("/empty").andReturn(200, "").always();
    try (HttpClient client = getHttpClientFactory().newBuilder().build()) {
      final StringBuffer responseText = new StringBuffer();
      final HttpResponse<AsyncBody> response = client.consumeBytes(
          client.newHttpRequestBuilder().uri(server.url("/empty")).build(),
          (value, asyncBody) -> {
            responseText.append(value.stream().map(StandardCharsets.UTF_8::decode)
                .map(CharBuffer::toString).collect(Collectors.joining()));
            asyncBody.consume();
          })
          .get(10L, TimeUnit.SECONDS);
      assertThat(response.code()).isEqualTo(200);
      response.body().consume();
      response.body().done().get(10L, TimeUnit.SECONDS);
      assertThat(responseText.toString()).isEmpty();
    }
  }

  @Test
  @DisplayName("consumeBytes handles very small response body")
  void consumeBytesHandlesSmallResponse() throws Exception {
    server.expect().withPath("/small").andReturn(200, "OK").always();
    try (HttpClient client = getHttpClientFactory().newBuilder().build()) {
      final StringBuffer responseText = new StringBuffer();
      final HttpResponse<AsyncBody> response = client.consumeBytes(
          client.newHttpRequestBuilder().uri(server.url("/small")).build(),
          (value, asyncBody) -> {
            responseText.append(value.stream().map(StandardCharsets.UTF_8::decode)
                .map(CharBuffer::toString).collect(Collectors.joining()));
            asyncBody.consume();
          })
          .get(10L, TimeUnit.SECONDS);
      assertThat(response.code()).isEqualTo(200);
      response.body().consume();
      response.body().done().get(10L, TimeUnit.SECONDS);
      assertThat(responseText.toString()).isEqualTo("OK");
    }
  }

  @Test
  @DisplayName("consumeBytes handles 204 No Content response")
  void consumeBytesHandles204NoContent() throws Exception {
    server.expect().withPath("/no-content").andReturn(204, "").always();
    try (HttpClient client = getHttpClientFactory().newBuilder().build()) {
      final StringBuffer responseText = new StringBuffer();
      final HttpResponse<AsyncBody> response = client.consumeBytes(
          client.newHttpRequestBuilder().uri(server.url("/no-content")).build(),
          (value, asyncBody) -> {
            responseText.append(value.stream().map(StandardCharsets.UTF_8::decode)
                .map(CharBuffer::toString).collect(Collectors.joining()));
            asyncBody.consume();
          })
          .get(10L, TimeUnit.SECONDS);
      assertThat(response.code()).isEqualTo(204);
      response.body().consume();
      response.body().done().get(10L, TimeUnit.SECONDS);
      assertThat(responseText.toString()).isEmpty();
    }
  }

  @Test
  @DisplayName("Rapid sequential requests with small responses complete successfully")
  void rapidSequentialRequestsWithSmallResponses() throws Exception {
    server.expect().withPath("/rapid").andReturn(200, "x").always();
    try (HttpClient client = getHttpClientFactory().newBuilder().build()) {
      final int requestCount = 100;
      for (int i = 0; i < requestCount; i++) {
        final StringBuffer responseText = new StringBuffer();
        final HttpResponse<AsyncBody> response = client.consumeBytes(
            client.newHttpRequestBuilder().uri(server.url("/rapid")).build(),
            (value, asyncBody) -> {
              responseText.append(value.stream().map(StandardCharsets.UTF_8::decode)
                  .map(CharBuffer::toString).collect(Collectors.joining()));
              asyncBody.consume();
            })
            .get(10L, TimeUnit.SECONDS);
        assertThat(response.code()).isEqualTo(200);
        response.body().consume();
        response.body().done().get(10L, TimeUnit.SECONDS);
        assertThat(responseText.toString()).isEqualTo("x");
      }
    }
  }

  @Test
  @DisplayName("Concurrent requests with small responses complete successfully")
  void concurrentRequestsWithSmallResponses() throws Exception {
    server.expect().withPath("/concurrent").andReturn(200, "y").always();
    try (HttpClient client = getHttpClientFactory().newBuilder().build()) {
      final int concurrentRequests = 50;
      final CountDownLatch startLatch = new CountDownLatch(1);
      final CountDownLatch completionLatch = new CountDownLatch(concurrentRequests);
      final AtomicInteger successCount = new AtomicInteger(0);
      final List<Throwable> errors = Collections.synchronizedList(new ArrayList<>());

      for (int i = 0; i < concurrentRequests; i++) {
        CompletableFuture.runAsync(() -> {
          try {
            startLatch.await();
            final StringBuffer responseText = new StringBuffer();
            final HttpResponse<AsyncBody> response = client.consumeBytes(
                client.newHttpRequestBuilder().uri(server.url("/concurrent")).build(),
                (value, asyncBody) -> {
                  responseText.append(value.stream().map(StandardCharsets.UTF_8::decode)
                      .map(CharBuffer::toString).collect(Collectors.joining()));
                  asyncBody.consume();
                })
                .get(30L, TimeUnit.SECONDS);
            response.body().consume();
            response.body().done().get(30L, TimeUnit.SECONDS);
            if (response.code() == 200 && "y".equals(responseText.toString())) {
              successCount.incrementAndGet();
            }
          } catch (Exception e) {
            errors.add(e);
          } finally {
            completionLatch.countDown();
          }
        });
      }

      startLatch.countDown();
      assertThat(completionLatch.await(60L, TimeUnit.SECONDS))
          .as("All concurrent requests should complete within timeout")
          .isTrue();
      assertThat(errors)
          .as("No errors should occur during concurrent requests")
          .isEmpty();
      assertThat(successCount.get())
          .as("All concurrent requests should succeed")
          .isEqualTo(concurrentRequests);
    }
  }

  @Test
  @DisplayName("sendAsync handles empty response body")
  void sendAsyncHandlesEmptyResponse() throws Exception {
    server.expect().withPath("/empty-send").andReturn(200, "").always();
    try (HttpClient client = getHttpClientFactory().newBuilder().build()) {
      final HttpResponse<String> response = client.sendAsync(
          client.newHttpRequestBuilder().uri(server.url("/empty-send")).build(),
          String.class)
          .get(10L, TimeUnit.SECONDS);
      assertThat(response.code()).isEqualTo(200);
      assertThat(response.body()).isEmpty();
    }
  }

  @Test
  @DisplayName("sendAsync handles 204 No Content")
  void sendAsyncHandles204NoContent() throws Exception {
    server.expect().withPath("/no-content-send").andReturn(204, "").always();
    try (HttpClient client = getHttpClientFactory().newBuilder().build()) {
      final HttpResponse<String> response = client.sendAsync(
          client.newHttpRequestBuilder().uri(server.url("/no-content-send")).build(),
          String.class)
          .get(10L, TimeUnit.SECONDS);
      assertThat(response.code()).isEqualTo(204);
      assertThat(response.body()).isEmpty();
    }
  }

  @Test
  @DisplayName("Rapid sequential sendAsync requests complete successfully")
  void rapidSequentialSendAsyncRequests() throws Exception {
    server.expect().withPath("/rapid-send").andReturn(200, "z").always();
    try (HttpClient client = getHttpClientFactory().newBuilder().build()) {
      final int requestCount = 100;
      for (int i = 0; i < requestCount; i++) {
        final HttpResponse<String> response = client.sendAsync(
            client.newHttpRequestBuilder().uri(server.url("/rapid-send")).build(),
            String.class)
            .get(10L, TimeUnit.SECONDS);
        assertThat(response.code()).isEqualTo(200);
        assertThat(response.body()).isEqualTo("z");
      }
    }
  }

  @Test
  @DisplayName("Concurrent sendAsync requests complete successfully")
  void concurrentSendAsyncRequests() throws Exception {
    server.expect().withPath("/concurrent-send").andReturn(200, "w").always();
    try (HttpClient client = getHttpClientFactory().newBuilder().build()) {
      final int concurrentRequests = 50;
      final CountDownLatch startLatch = new CountDownLatch(1);
      final CountDownLatch completionLatch = new CountDownLatch(concurrentRequests);
      final AtomicInteger successCount = new AtomicInteger(0);
      final List<Throwable> errors = Collections.synchronizedList(new ArrayList<>());

      for (int i = 0; i < concurrentRequests; i++) {
        CompletableFuture.runAsync(() -> {
          try {
            startLatch.await();
            final HttpResponse<String> response = client.sendAsync(
                client.newHttpRequestBuilder().uri(server.url("/concurrent-send")).build(),
                String.class)
                .get(30L, TimeUnit.SECONDS);
            if (response.code() == 200 && "w".equals(response.body())) {
              successCount.incrementAndGet();
            }
          } catch (Exception e) {
            errors.add(e);
          } finally {
            completionLatch.countDown();
          }
        });
      }

      startLatch.countDown();
      assertThat(completionLatch.await(60L, TimeUnit.SECONDS))
          .as("All concurrent requests should complete within timeout")
          .isTrue();
      assertThat(errors)
          .as("No errors should occur during concurrent requests")
          .isEmpty();
      assertThat(successCount.get())
          .as("All concurrent requests should succeed")
          .isEqualTo(concurrentRequests);
    }
  }
}
