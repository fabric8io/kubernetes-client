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
package io.fabric8.kubernetes.client.dsl.internal;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.ListOptions;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.http.AsyncBody;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.HttpResponse;
import io.fabric8.kubernetes.client.http.TestHttpResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WatchHttpManagerTest {

  @Test
  void testReconnectOnException() throws MalformedURLException, InterruptedException {
    CompletableFuture<HttpResponse<AsyncBody>> future = new CompletableFuture<>();
    CountDownLatch reconnect = new CountDownLatch(1);

    setupHttpWatch(future, reconnect);

    future.completeExceptionally(new IOException());
    assertTrue(reconnect.await(1, TimeUnit.SECONDS));
  }

  @Test
  void testReconnectOnFailedResponse() throws MalformedURLException, InterruptedException {
    CompletableFuture<HttpResponse<AsyncBody>> future = new CompletableFuture<>();
    CountDownLatch reconnect = new CountDownLatch(1);

    setupHttpWatch(future, reconnect);

    AsyncBody mockBody = Mockito.mock(AsyncBody.class);
    future.complete(new TestHttpResponse<AsyncBody>().withCode(429).withBody(mockBody));
    Mockito.verify(mockBody).cancel();
    assertTrue(reconnect.await(1, TimeUnit.SECONDS));
  }

  @Test
  void testNoReconnectOnHttpGone() throws MalformedURLException, InterruptedException {
    CompletableFuture<HttpResponse<AsyncBody>> future = new CompletableFuture<>();
    CountDownLatch reconnect = new CountDownLatch(1);

    setupHttpWatch(future, reconnect);

    AsyncBody mockBody = Mockito.mock(AsyncBody.class);
    future.complete(new TestHttpResponse<AsyncBody>().withCode(HttpURLConnection.HTTP_GONE).withBody(mockBody));
    Mockito.verify(mockBody).cancel();
    assertFalse(reconnect.await(1, TimeUnit.SECONDS));
  }

  @Test
  @DisplayName("chunk back-pressure: a.consume() fires only after every enqueued onMessage task drains")
  @SuppressWarnings("unchecked")
  void chunkConsumeIsDeferredUntilAllEnqueuedTasksComplete() throws Exception {
    // Given an HttpClient whose consumeBytes captures the body consumer; the
    // operation's executor captures runnables instead of running them, so we
    // can prove the deferral
    final LinkedBlockingDeque<Runnable> captured = new LinkedBlockingDeque<>();
    final HttpClient client = Mockito.mock(HttpClient.class, Mockito.RETURNS_DEEP_STUBS);
    final BaseOperation baseOperation = AbstractWatchManagerTest.mockOperation(captured::add);
    Mockito.when(baseOperation.getNamespacedUrl()).thenReturn(new URL("http://localhost"));
    final ArgumentCaptor<AsyncBody.Consumer<List<ByteBuffer>>> consumerCaptor = ArgumentCaptor
        .forClass(AsyncBody.Consumer.class);
    Mockito.when(client.consumeBytes(Mockito.any(), consumerCaptor.capture()))
        .thenReturn(new CompletableFuture<>());
    final WatchHTTPManager<HasMetadata, KubernetesResourceList<HasMetadata>> manager = new WatchHTTPManager<>(
        client, baseOperation, Mockito.mock(ListOptions.class), Mockito.mock(Watcher.class), 1, 60_000);
    // Pre-mark the request state closed so onMessage bodies short-circuit at the
    // state.closed check instead of running real deserialization (and pulling in
    // the close-on-bad-JSON cascade). The back-pressure mechanism we are testing
    // sits in onMessage's finally block, which fires regardless.
    manager.latestRequestState.closed.set(true);
    // The captured consumer is the lambda inside WatchHTTPManager.start
    final AsyncBody.Consumer<List<ByteBuffer>> consumer = consumerCaptor.getValue();
    // When invoked with a chunk that contains three newline-delimited frames
    final AsyncBody asyncBody = Mockito.mock(AsyncBody.class);
    final ByteBuffer chunk = ByteBuffer.wrap("frame1\nframe2\nframe3\n".getBytes(StandardCharsets.UTF_8));
    consumer.consume(Collections.singletonList(chunk), asyncBody);
    // Then asyncBody.consume() has NOT been called yet: three deserialize tasks
    // are queued (one in the capture executor, two more in the SerialExecutor's
    // internal queue, which only push to the underlying executor as the previous
    // task finishes via scheduleNext)
    Mockito.verify(asyncBody, Mockito.never()).consume();
    assertThat(captured).hasSize(1);
    // Draining one task at a time, asyncBody.consume() must remain quiet until the last
    captured.poll().run();
    Mockito.verify(asyncBody, Mockito.never()).consume();
    captured.poll().run();
    Mockito.verify(asyncBody, Mockito.never()).consume();
    captured.poll().run();
    // Then asyncBody.consume() fires exactly once after the last task drains
    Mockito.verify(asyncBody, Mockito.times(1)).consume();
    assertThat(captured).isEmpty();
  }

  @Test
  @DisplayName("empty chunk: a.consume() fires immediately when no newline-delimited frames are present")
  @SuppressWarnings("unchecked")
  void emptyChunkConsumesImmediately() throws Exception {
    final LinkedBlockingDeque<Runnable> captured = new LinkedBlockingDeque<>();
    final HttpClient client = Mockito.mock(HttpClient.class, Mockito.RETURNS_DEEP_STUBS);
    final BaseOperation baseOperation = AbstractWatchManagerTest.mockOperation(captured::add);
    Mockito.when(baseOperation.getNamespacedUrl()).thenReturn(new URL("http://localhost"));
    final ArgumentCaptor<AsyncBody.Consumer<List<ByteBuffer>>> consumerCaptor = ArgumentCaptor
        .forClass(AsyncBody.Consumer.class);
    Mockito.when(client.consumeBytes(Mockito.any(), consumerCaptor.capture()))
        .thenReturn(new CompletableFuture<>());
    new WatchHTTPManager<HasMetadata, KubernetesResourceList<HasMetadata>>(client, baseOperation,
        Mockito.mock(ListOptions.class), Mockito.mock(Watcher.class), 1, 60_000);
    final AsyncBody.Consumer<List<ByteBuffer>> consumer = consumerCaptor.getValue();
    // When invoked with a chunk that has no newline (partial frame, still buffering)
    final AsyncBody asyncBody = Mockito.mock(AsyncBody.class);
    consumer.consume(Collections.singletonList(
        ByteBuffer.wrap("partial".getBytes(StandardCharsets.UTF_8))), asyncBody);
    // Then asyncBody.consume() fires immediately (no tasks to wait for)
    Mockito.verify(asyncBody, Mockito.times(1)).consume();
    assertThat(captured).isEmpty();
  }

  private void setupHttpWatch(CompletableFuture<HttpResponse<AsyncBody>> future, CountDownLatch reconnect)
      throws MalformedURLException {
    HttpClient client = Mockito.mock(HttpClient.class, Mockito.RETURNS_DEEP_STUBS);
    BaseOperation baseOperation = AbstractWatchManagerTest.mockOperation();
    Mockito.when(baseOperation.getNamespacedUrl()).thenReturn(new URL("http://localhost"));
    Mockito.when(client.consumeBytes(Mockito.any(), Mockito.any())).thenReturn(future);

    WatchHTTPManager<HasMetadata, KubernetesResourceList<HasMetadata>> watch = new WatchHTTPManager(client,
        baseOperation, Mockito.mock(ListOptions.class), Mockito.mock(Watcher.class), 1, 0) {

      @Override
      void scheduleReconnect(WatchRequestState state) {
        reconnect.countDown();
      }
    };
  }

}
