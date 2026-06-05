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
import io.fabric8.kubernetes.api.model.ListOptions;
import io.fabric8.kubernetes.api.model.StatusBuilder;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.WatcherException;
import io.fabric8.kubernetes.client.dsl.internal.AbstractWatchManager.WatchRequestState;
import io.fabric8.kubernetes.client.http.TestStandardHttpClientFactory;
import io.fabric8.kubernetes.client.utils.KubernetesSerialization;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class AbstractWatchManagerTest {

  @Test
  @DisplayName("closeEvent, is idempotent, multiple calls only close watcher once")
  void closeEventIsIdempotent() throws MalformedURLException {
    // Given
    final WatcherAdapter<HasMetadata> watcher = new WatcherAdapter<>();
    final WatchManager<HasMetadata> awm = withDefaultWatchManager(watcher);
    // When
    for (int it = 0; it < 10; it++) {
      awm.closeEvent();
    }
    // Then
    assertThat(watcher.closeCount.get()).isEqualTo(1);
  }

  @Test
  @DisplayName("closeEvent, with Exception, is idempotent, multiple calls only close watcher once")
  void closeEventWithExceptionIsIdempotent() throws MalformedURLException {
    // Given
    final WatcherAdapter<HasMetadata> watcher = new WatcherAdapter<>();
    final WatchManager<HasMetadata> awm = withDefaultWatchManager(watcher);
    // When
    for (int it = 0; it < 10; it++) {
      awm.close(new WatcherException("Mock"));
    }
    // Then
    assertThat(watcher.closeCount.get()).isEqualTo(1);
  }

  @Test
  void closeEventWithExceptionIsIdempotentWithReconnecting() throws MalformedURLException {
    // Given
    final WatcherAdapter<HasMetadata> watcher = new WatcherAdapter<HasMetadata>() {
      @Override
      public boolean reconnecting() {
        return true;
      }
    };
    final WatchManager<HasMetadata> awm = withDefaultWatchManager(watcher);
    // When
    for (int it = 0; it < 10; it++) {
      awm.close(new WatcherException("Mock"));
    }
    // Then
    assertThat(watcher.closeCount.get()).isEqualTo(1);
  }

  @Test
  @DisplayName("nextReconnectInterval, returns exponential interval values up to the provided limit")
  void nextReconnectInterval() throws MalformedURLException {
    // Given
    final WatchManager<HasMetadata> awm = new WatchManager<>(
        null, mock(ListOptions.class), 0, 10);
    // When-Then
    assertThat(awm.nextReconnectInterval()).isEqualTo(10);
    assertThat(awm.nextReconnectInterval()).isEqualTo(20);
    assertThat(awm.nextReconnectInterval()).isEqualTo(40);
    assertThat(awm.nextReconnectInterval()).isEqualTo(80);
    assertThat(awm.nextReconnectInterval()).isEqualTo(160);
    assertThat(awm.nextReconnectInterval()).isEqualTo(320);
    assertThat(awm.nextReconnectInterval()).isEqualTo(320);

    // should pick up the interval from the status
    awm.onStatus(new StatusBuilder().withNewDetails().withRetryAfterSeconds(7).endDetails().build(), new WatchRequestState());
    assertThat(awm.nextReconnectInterval()).isEqualTo(7000L);
    // should go back to the base interval after that
    assertThat(awm.nextReconnectInterval()).isEqualTo(320);
  }

  @Test
  @DisplayName("cancelReconnect, with null attempt, should do nothing")
  void cancelReconnectNullAttempt() throws MalformedURLException {
    // Given
    final ScheduledFuture<?> sf = spy(ScheduledFuture.class);
    final WatcherAdapter<HasMetadata> watcher = new WatcherAdapter<>();
    final WatchManager<HasMetadata> awm = withDefaultWatchManager(watcher);
    // When
    awm.cancelReconnect();
    // Then
    verify(sf, times(0)).cancel(true);
  }

  @Test
  @DisplayName("cancelReconnect, with non-null attempt, should cancel")
  void cancelReconnectNonNullAttempt() throws MalformedURLException {
    // Given
    final WatcherAdapter<HasMetadata> watcher = new WatcherAdapter<>();
    final AtomicReference<CompletableFuture<Void>> scheduled = new AtomicReference<>();
    final WatchManager<HasMetadata> awm = new WatchManager<HasMetadata>(
        watcher, mock(ListOptions.class, RETURNS_DEEP_STUBS), 1, 60_000) {
      @Override
      protected CompletableFuture<Void> schedule(Runnable command, long delay, TimeUnit unit) {
        CompletableFuture<Void> f = new CompletableFuture<>();
        scheduled.set(f);
        return f;
      }
    };

    awm.scheduleReconnect(new WatchRequestState());
    // When
    awm.cancelReconnect();
    // Then
    assertThat(scheduled.get()).isNotNull();
    assertThat(scheduled.get().isCancelled()).isTrue();
  }

  @Test
  void reconnectRace() throws Exception {
    // Given
    final WatcherAdapter<HasMetadata> watcher = new WatcherAdapter<>();
    CompletableFuture<Void> done = new CompletableFuture<Void>();
    final WatchManager<HasMetadata> awm = new WatchManager<HasMetadata>(
        watcher, mock(ListOptions.class, RETURNS_DEEP_STUBS), 1, 0) {

      boolean first = true;

      @Override
      protected void startWatch() {
        if (first) {
          first = false;
          // simulate failing before the call to startWatch finishes
          ForkJoinPool.commonPool().execute(() -> scheduleReconnect(new WatchRequestState()));
          try {
            Thread.sleep(100);
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new AssertionError(e);
          }
        } else {
          done.complete(null);
        }
      }
    };

    // When
    awm.cancelReconnect();
    // Then

    assertThat(done).succeedsWithin(Duration.ofSeconds(5));
  }

  @Test
  @DisplayName("isClosed, after close invocation, should return true")
  void isForceClosedWhenClosed() throws MalformedURLException {
    // Given
    final WatcherAdapter<HasMetadata> watcher = new WatcherAdapter<>();
    final WatchManager<HasMetadata> awm = withDefaultWatchManager(watcher);
    // When
    awm.close();
    // Then
    assertThat(awm.isForceClosed()).isTrue();
  }

  @Test
  @DisplayName("close, after close invocation, should return true")
  void closeWithNonNullRunnerShouldCancelRunner() throws MalformedURLException {
    // Given
    final WatcherAdapter<HasMetadata> watcher = new WatcherAdapter<>();
    final WatchManager<HasMetadata> awm = withDefaultWatchManager(watcher);
    // When
    awm.startWatch();
    awm.close();
    // Then
    assertThat(awm.closeCount.get()).isEqualTo(1);
  }

  @Test
  @DisplayName("watchEnded, clean close with no messages within 2s, resets resourceVersion to force re-list (GKE stale-rv bug)")
  void watchEndedResetsResourceVersionOnQuickCleanClose() throws MalformedURLException {
    // Given
    final WatchManager<HasMetadata> awm = withDefaultWatchManager(new WatcherAdapter<>());
    awm.resourceVersion.set("12345");
    WatchRequestState state = new WatchRequestState();
    state.startedAtMs = System.currentTimeMillis(); // simulates GKE: connection rejected immediately
    awm.latestRequestState = state;
    // When - clean close (t=null), zero messages, within the 2s threshold
    awm.watchEnded(null, state);
    // Then - resourceVersion must be cleared so the next reconnect does a fresh re-list
    assertThat(awm.resourceVersion.get()).isNull();
  }

  @Test
  @DisplayName("watchEnded, clean close with no messages but connection was old, preserves resourceVersion")
  void watchEndedPreservesResourceVersionOnOldCleanClose() throws MalformedURLException {
    // Given
    final WatchManager<HasMetadata> awm = withDefaultWatchManager(new WatcherAdapter<>());
    awm.resourceVersion.set("12345");
    WatchRequestState state = new WatchRequestState();
    state.startedAtMs = System.currentTimeMillis() - 5_000; // simulates legitimate idle disconnect after 5s
    awm.latestRequestState = state;
    // When - clean close (t=null), zero messages, but connection was alive well past the 2s threshold
    awm.watchEnded(null, state);
    // Then - resourceVersion must be preserved; reconnect can resume from last known position
    assertThat(awm.resourceVersion.get()).isEqualTo("12345");
  }

  @Test
  @DisplayName("watchEnded, clean close after messages were received, preserves resourceVersion")
  void watchEndedPreservesResourceVersionWhenMessagesReceived() throws MalformedURLException {
    // Given
    final WatchManager<HasMetadata> awm = withDefaultWatchManager(new WatcherAdapter<>());
    awm.resourceVersion.set("12345");
    WatchRequestState state = new WatchRequestState();
    state.startedAtMs = System.currentTimeMillis(); // connection is fresh
    state.messageReceived.set(true); // but at least one message was processed
    awm.latestRequestState = state;
    // When - clean close (t=null), messages were received, within the 2s threshold
    awm.watchEnded(null, state);
    // Then - resourceVersion must be preserved; messages prove the rv was accepted
    assertThat(awm.resourceVersion.get()).isEqualTo("12345");
  }

  @Test
  void testWebSocketCloseReconnectHandling() throws Exception {
    // Given
    final WatcherAdapter<HasMetadata> watcher = new WatcherAdapter<>();
    final WatchManager<HasMetadata> awm = withDefaultWatchManager(watcher);
    // When
    WatchRequestState state = new WatchRequestState();
    awm.latestRequestState = state;
    awm.watchEnded(null, state);
    // Then
    assertThat(state.reconnected).isTrue();
  }

  @Test
  void testWebSocketExceptionHandling() throws Exception {
    // Given
    final WatcherAdapter<HasMetadata> watcher = new WatcherAdapter<>();
    final WatchManager<HasMetadata> awm = withDefaultWatchManager(watcher);
    // When
    awm.latestRequestState = new WatchRequestState();
    // unknown exception
    awm.watchEnded(new Throwable(), awm.latestRequestState);
    // Then
    assertThat(awm.latestRequestState.reconnected).isTrue();
    assertThat(awm.isForceClosed()).isFalse();

    // should only terminate on a protocol exception
    awm.watchEnded(new ProtocolException(), awm.latestRequestState);
    // Then
    assertThat(awm.isForceClosed()).isTrue();
  }

  @Test
  void testWebSocketExceptionHandlingStaleState() throws Exception {
    // Given
    final WatcherAdapter<HasMetadata> watcher = new WatcherAdapter<>();
    final WatchManager<HasMetadata> awm = withDefaultWatchManager(watcher);
    // When
    WatchRequestState state = new WatchRequestState();

    // won't terminate on a protocol exception that is stale
    awm.watchEnded(new ProtocolException(), state);
    // Then
    assertThat(awm.isForceClosed()).isFalse();
  }

  @Test
  @DisplayName("onMessage, enqueues body on the SerialExecutor instead of running it on the caller thread")
  void onMessageEnqueuesBodyOnSerialExecutor() throws MalformedURLException {
    // Given a watch manager whose SerialExecutor uses a capture executor that does not run tasks
    final LinkedBlockingDeque<Runnable> captured = new LinkedBlockingDeque<>();
    final WatchManager<HasMetadata> awm = new WatchManager<>(
        new WatcherAdapter<>(), mock(ListOptions.class, RETURNS_DEEP_STUBS), 1, 60_000, captured::add);
    final AtomicBoolean completionFired = new AtomicBoolean();
    // When a message arrives
    awm.onMessage("not-valid-json", awm.latestRequestState, () -> completionFired.set(true));
    // Then the body has not yet run: a task was queued, completion has not fired
    assertThat(captured).hasSize(1);
    assertThat(completionFired).isFalse();
    // And when the captured task is drained
    captured.poll().run();
    // Then the completion callback fires
    assertThat(completionFired).isTrue();
  }

  @Test
  @DisplayName("onMessage, completion callback fires even when deserialization throws")
  void onMessageCompletionFiresOnException() throws MalformedURLException {
    // Given a watch manager whose SerialExecutor runs tasks synchronously on the caller
    final WatchManager<HasMetadata> awm = withDefaultWatchManager(new WatcherAdapter<>());
    final AtomicBoolean completionFired = new AtomicBoolean();
    // When a message that will fail deserialization arrives
    awm.onMessage("not-valid-json", awm.latestRequestState, () -> completionFired.set(true));
    // Then the completion callback has still fired (back-pressure must not stall on deserialize errors)
    assertThat(completionFired).isTrue();
  }

  @Test
  @DisplayName("onMessage, a throwing completion callback is swallowed so the SerialExecutor keeps draining")
  void onMessageThrowingCompletionDoesNotStallExecutor() throws MalformedURLException {
    // Given a watch manager whose SerialExecutor runs tasks synchronously
    final WatchManager<HasMetadata> awm = withDefaultWatchManager(new WatcherAdapter<>());
    final AtomicInteger secondCompletionFired = new AtomicInteger();
    // When a first message uses a completion that throws
    awm.onMessage("not-valid-json", awm.latestRequestState, () -> {
      throw new RuntimeException("re-arm explodes");
    });
    // And a second message uses a normal completion
    awm.onMessage("not-valid-json", awm.latestRequestState, secondCompletionFired::incrementAndGet);
    // Then the second completion still fired — the executor was not wedged by the first failure
    assertThat(secondCompletionFired).hasValue(1);
  }

  @Test
  @DisplayName("onMessage, after the SerialExecutor has been shut down, completion fires inline so back-pressure never wedges")
  void onMessageCompletionFiresInlineWhenExecutorShutdown() throws MalformedURLException {
    // Given a watch manager whose SerialExecutor has been shut down
    final WatchManager<HasMetadata> awm = withDefaultWatchManager(new WatcherAdapter<>());
    awm.serialExecutor.shutdownNow();
    final AtomicBoolean completionFired = new AtomicBoolean();
    // When a message arrives after shutdown
    awm.onMessage("doesn't matter", awm.latestRequestState, () -> completionFired.set(true));
    // Then the completion callback fires synchronously
    assertThat(completionFired).isTrue();
  }

  @Test
  @DisplayName("onMessage, preserves arrival ordering across multiple frames")
  void onMessagePreservesOrderingAcrossFrames() throws MalformedURLException {
    // Given a watch manager whose SerialExecutor uses a capture executor that runs tasks on demand
    final LinkedBlockingDeque<Runnable> captured = new LinkedBlockingDeque<>();
    final WatchManager<HasMetadata> awm = new WatchManager<>(
        new WatcherAdapter<>(), mock(ListOptions.class, RETURNS_DEEP_STUBS), 1, 60_000, captured::add);
    final java.util.List<Integer> completionOrder = new java.util.concurrent.CopyOnWriteArrayList<>();
    // When three frames arrive in quick succession
    awm.onMessage("frame-1", awm.latestRequestState, () -> completionOrder.add(1));
    awm.onMessage("frame-2", awm.latestRequestState, () -> completionOrder.add(2));
    awm.onMessage("frame-3", awm.latestRequestState, () -> completionOrder.add(3));
    // Then nothing has been delivered yet
    assertThat(completionOrder).isEmpty();
    // And when the queue is fully drained (SerialExecutor's wrapper schedules the next task in finally)
    while (!captured.isEmpty()) {
      captured.poll().run();
    }
    // Then completions fired in arrival order
    assertThat(completionOrder).containsExactly(1, 2, 3);
  }

  private static <T extends HasMetadata> WatchManager<T> withDefaultWatchManager(Watcher<T> watcher)
      throws MalformedURLException {
    // Use a non-zero reconnect interval so that the reconnect task scheduled on
    // SHARED_SCHEDULER cannot fire mid-test and replace latestRequestState before
    // assertions on its `reconnected` flag run.
    return new WatchManager<>(
        watcher, mock(ListOptions.class, RETURNS_DEEP_STUBS), 1, 60_000);
  }

  private static class WatcherAdapter<T> implements Watcher<T> {
    private final AtomicInteger closeCount = new AtomicInteger(0);

    @Override
    public void eventReceived(Action action, T resource) {
    }

    @Override
    public void onClose(WatcherException cause) {
      closeCount.addAndGet(1);
    }

    @Override
    public void onClose() {
      closeCount.addAndGet(1);
    }
  }

  static BaseOperation mockOperation() {
    return mockOperation(Runnable::run);
  }

  static BaseOperation mockOperation(Executor executor) {
    BaseOperation operation = mock(BaseOperation.class, Mockito.RETURNS_DEEP_STUBS);
    Mockito.when(operation.getOperationContext().getExecutor()).thenReturn(executor);
    Mockito.when(operation.getKubernetesSerialization()).thenReturn(new KubernetesSerialization());
    Mockito.when(operation.appendListOptionParams(Mockito.any(), Mockito.any())).thenCallRealMethod();
    return operation;
  }

  private static class WatchManager<T extends HasMetadata> extends AbstractWatchManager<T> {

    private final AtomicInteger closeCount = new AtomicInteger(0);

    public WatchManager(Watcher<T> watcher, ListOptions listOptions, int reconnectLimit, int reconnectInterval)
        throws MalformedURLException {
      super(watcher, mockOperation(), listOptions, reconnectLimit, reconnectInterval,
          new TestStandardHttpClientFactory().newBuilder().build());
    }

    public WatchManager(Watcher<T> watcher, ListOptions listOptions, int reconnectLimit, int reconnectInterval,
        Executor executor) throws MalformedURLException {
      super(watcher, mockOperation(executor), listOptions, reconnectLimit, reconnectInterval,
          new TestStandardHttpClientFactory().newBuilder().build());
    }

    @Override
    protected void start(URL url, Map<String, String> headers, WatchRequestState state) {

    }

    @Override
    public void closeCurrentRequest() {
      closeCount.addAndGet(1);
    }

    @Override
    protected void startWatch() {
      this.latestRequestState = new WatchRequestState();
    }
  }
}
