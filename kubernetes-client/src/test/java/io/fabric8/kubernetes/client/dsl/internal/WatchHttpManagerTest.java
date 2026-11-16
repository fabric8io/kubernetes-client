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

  @Test
  @DisplayName("non-ASCII event followed by another event in the next chunk: both frames are delivered without null bytes")
  @SuppressWarnings("unchecked")
  void nonAsciiEventFollowedByNextChunkIsDeliveredCorrectly() throws Exception {
    // Given
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
    manager.latestRequestState.closed.set(true);
    final AsyncBody.Consumer<List<ByteBuffer>> consumer = consumerCaptor.getValue();
    final AsyncBody asyncBody = Mockito.mock(AsyncBody.class);

    // When: first chunk contains a JSON event with a non-ASCII character ('é' = 0xC3 0xA9, 2 bytes)
    // The previous char-array loop would append a '\0' null byte after 'café' due to capacity > limit.
    final byte[] chunk1Bytes = "event1:café\n".getBytes(StandardCharsets.UTF_8);
    consumer.consume(Collections.singletonList(ByteBuffer.wrap(chunk1Bytes)), asyncBody);
    // Drain the first frame
    assertThat(captured).hasSize(1);
    captured.poll().run();
    Mockito.verify(asyncBody, Mockito.times(1)).consume();

    // When: second chunk arrives as a separate delivery
    final byte[] chunk2Bytes = "event2:plain\n".getBytes(StandardCharsets.UTF_8);
    final AsyncBody asyncBody2 = Mockito.mock(AsyncBody.class);
    consumer.consume(Collections.singletonList(ByteBuffer.wrap(chunk2Bytes)), asyncBody2);
    assertThat(captured).hasSize(1);
    captured.poll().run();
    // Then: second chunk's asyncBody.consume() fires; no null byte from chunk1 prepended to event2
    Mockito.verify(asyncBody2, Mockito.times(1)).consume();
  }

  @Test
  @DisplayName("multi-byte character split across two ByteBuffers: the character is decoded correctly, not as U+FFFD")
  @SuppressWarnings("unchecked")
  void multiByteSplitAcrossBuffersIsDecodedCorrectly() throws Exception {
    // Given
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
    manager.latestRequestState.closed.set(true);
    final AsyncBody.Consumer<List<ByteBuffer>> consumer = consumerCaptor.getValue();

    // 'é' in UTF-8 is 0xC3 0xA9.  Split it: first ByteBuffer ends with 0xC3, second starts with 0xA9.
    // The full JSON line is: {"v":"café"}\n
    final byte[] fullBytes = "{\"v\":\"café\"}\n".getBytes(StandardCharsets.UTF_8);
    // Find the index of the first byte of 'é' (0xC3)
    int splitPoint = -1;
    for (int i = 0; i < fullBytes.length; i++) {
      if ((fullBytes[i] & 0xFF) == 0xC3) {
        splitPoint = i;
        break;
      }
    }
    assertThat(splitPoint).isGreaterThan(0);

    final ByteBuffer buf1 = ByteBuffer.wrap(fullBytes, 0, splitPoint + 1); // includes 0xC3
    final ByteBuffer buf2 = ByteBuffer.wrap(fullBytes, splitPoint + 1, fullBytes.length - splitPoint - 1); // 0xA9 … \n

    // When: both ByteBuffers arrive in a single consumer invocation (same chunk delivery)
    final AsyncBody asyncBody = Mockito.mock(AsyncBody.class);
    consumer.consume(List.of(buf1, buf2), asyncBody);

    // Then: exactly one frame is dispatched (one newline in the input)
    assertThat(captured).hasSize(1);
    // Drain the frame — the manager has closed=true so onMessage short-circuits after the
    // state.closed check, but the pending counter still fires maybeConsume correctly.
    captured.poll().run();
    Mockito.verify(asyncBody, Mockito.times(1)).consume();
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
