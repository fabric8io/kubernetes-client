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

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class TestStandardHttpClient
    extends StandardHttpClient<TestStandardHttpClient, TestStandardHttpClientFactory, TestStandardHttpClientBuilder> {

  private final Map<String, Expectation> expectations;
  @Getter
  private final List<RecordedBuildWebSocketDirect> recordedBuildWebSocketDirects;
  @Getter
  private final List<RecordedConsumeBytesDirect> recordedConsumeBytesDirects;

  protected TestStandardHttpClient(TestStandardHttpClientBuilder builder, AtomicBoolean closed) {
    super(builder, closed);
    expectations = new HashMap<>();
    recordedBuildWebSocketDirects = new ArrayList<>();
    recordedConsumeBytesDirects = new ArrayList<>();
  }

  @Override
  public void doClose() {
    expectations.values().forEach(e -> {
      e.futures.clear();
      e.wsFutures.clear();
    });
    expectations.clear();
  }

  @Override
  public synchronized CompletableFuture<WebSocketResponse> buildWebSocketDirect(
      StandardWebSocketBuilder standardWebSocketBuilder,
      WebSocket.Listener listener) {
    final CompletableFuture<WebSocketResponse> future;
    try {
      future = find(standardWebSocketBuilder.asHttpRequest().uri()).wsFutures.poll()
          .get(standardWebSocketBuilder, listener);
    } catch (Exception e) {
      throw new AssertionError("Unexpected exception", e);
    }
    recordedBuildWebSocketDirects.add(new RecordedBuildWebSocketDirect(standardWebSocketBuilder, listener, future));
    return future;
  }

  @Override
  public synchronized CompletableFuture<HttpResponse<AsyncBody>> consumeBytesDirect(StandardHttpRequest request,
      AsyncBody.Consumer<List<ByteBuffer>> consumer) {
    final CompletableFuture<HttpResponse<AsyncBody>> future;
    try {
      future = find(request.uri()).futures.poll().get(request, consumer);
    } catch (Exception e) {
      throw new AssertionError("Unexpected exception", e);
    }
    recordedConsumeBytesDirects.add(new RecordedConsumeBytesDirect(request, consumer, future));
    return future;
  }

  @Override
  public TestStandardHttpClientBuilder newBuilder() {
    return (TestStandardHttpClientBuilder) super.newBuilder();
  }

  private Expectation find(URI uri) {
    final String path = uri.getPath();
    for (Map.Entry<String, Expectation> e : expectations.entrySet()) {
      if (path.matches(e.getKey())) {
        return e.getValue();
      }
    }
    throw new AssertionError("Missing expectation for path: " + path);
  }

  public final TestStandardHttpClient expect(String pathRegex, Throwable exception) {
    final CompletableFuture<HttpResponse<AsyncBody>> future = new CompletableFuture<>();
    future.completeExceptionally(exception);
    return expect(pathRegex, future);
  }

  public final TestStandardHttpClient wsExpect(String pathRegex, WebSocketResponse webSocketResponse) {
    return wsExpect(pathRegex, CompletableFuture.completedFuture(webSocketResponse));
  }

  public final TestStandardHttpClient expect(String pathRegex, HttpResponse<AsyncBody> response) {
    return expect(pathRegex, CompletableFuture.completedFuture(response));
  }

  public final TestStandardHttpClient wsExpect(String pathRegex, CompletableFuture<WebSocketResponse> future) {
    return wsExpect(pathRegex, (s, l) -> future);
  }

  public final TestStandardHttpClient expect(String pathRegex, CompletableFuture<HttpResponse<AsyncBody>> future) {
    return expect(pathRegex, (r, c) -> future);
  }

  public final TestStandardHttpClient wsExpect(String pathRegex, WsFutureProvider wsFuture) {
    final Expectation expectation = expectations.compute(pathRegex, (k, v) -> v == null ? new Expectation() : v);
    expectation.wsFutures.add(wsFuture);
    return this;
  }

  public final TestStandardHttpClient expect(String pathRegex, int statusCode) {
    return expect(pathRegex, statusCode, (byte[]) null);
  }

  public final TestStandardHttpClient expect(String pathRegex, int statusCode, String body) {
    return expect(pathRegex, statusCode, body.getBytes(StandardCharsets.UTF_8));
  }

  public final TestStandardHttpClient expect(String pathRegex, int statusCode, byte[] body) {
    final Expectation expectation = expectations.compute(pathRegex, (k, v) -> v == null ? new Expectation() : v);
    expectation.futures.add((r, c) -> {
      final AsyncBody asyncBody = new TestAsyncBody();
      if (body != null) {
        c.consume(Collections.singletonList(ByteBuffer.wrap(body)), asyncBody);
      }
      return CompletableFuture.completedFuture(new TestHttpResponse<AsyncBody>().withCode(statusCode).withBody(asyncBody));
    });
    return this;
  }

  public final TestStandardHttpClient expect(String pathRegex, FutureProvider future) {
    final Expectation expectation = expectations.compute(pathRegex, (k, v) -> v == null ? new Expectation() : v);
    expectation.futures.add(future);
    return this;
  }

  @FunctionalInterface
  public interface WsFutureProvider {
    CompletableFuture<WebSocketResponse> get(
        StandardWebSocketBuilder standardWebSocketBuilder, WebSocket.Listener listener) throws Exception;
  }

  @FunctionalInterface
  public interface FutureProvider {
    CompletableFuture<HttpResponse<AsyncBody>> get(
        StandardHttpRequest request, AsyncBody.Consumer<List<ByteBuffer>> consumer) throws Exception;
  }

  public static final class Expectation {
    private final ConcurrentLinkedQueue<WsFutureProvider> wsFutures = new ConcurrentLinkedQueue<>();
    private final ConcurrentLinkedQueue<FutureProvider> futures = new ConcurrentLinkedQueue<>();

  }

  @AllArgsConstructor
  @Getter
  public static final class RecordedBuildWebSocketDirect {
    private final StandardWebSocketBuilder standardWebSocketBuilder;
    private final WebSocket.Listener listener;
    private final CompletableFuture<WebSocketResponse> future;
  }

  @AllArgsConstructor
  @Getter
  public static final class RecordedConsumeBytesDirect {
    private final StandardHttpRequest request;
    private final AsyncBody.Consumer<List<ByteBuffer>> consumer;
    private final CompletableFuture<HttpResponse<AsyncBody>> future;
  }
}
