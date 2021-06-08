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
package io.fabric8.kubernetes.client.dsl.internal;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.ListOptions;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.WatcherException;
import io.fabric8.kubernetes.client.utils.Utils;
import okhttp3.Request;
import okhttp3.WebSocket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class AbstractWatchManagerTest {

  @Test
  @DisplayName("closeEvent, is idempotent, multiple calls only close watcher once")
  void closeEventIsIdempotent() {
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
  void closeEventWithExceptionIsIdempotent() {
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
  @DisplayName("closeWebSocket, closes web socket with 1000 code (Normal Closure)")
  void closeWebSocket() {
    // Given
    final WebSocket webSocket = mock(WebSocket.class);
    // When
    WatchConnectionManager.closeWebSocket(webSocket);
    // Then
    verify(webSocket, times(1)).close(1000, null);
  }

  @Test
  @DisplayName("nextReconnectInterval, returns exponential interval values up to the provided limit")
  void nextReconnectInterval() {
    // Given
    final WatchManager<HasMetadata> awm = new WatchManager<>(
      null, mock(ListOptions.class), 0, 10, 5);
    // When-Then
    assertThat(awm.nextReconnectInterval()).isEqualTo(10);
    assertThat(awm.nextReconnectInterval()).isEqualTo(20);
    assertThat(awm.nextReconnectInterval()).isEqualTo(40);
    assertThat(awm.nextReconnectInterval()).isEqualTo(80);
    assertThat(awm.nextReconnectInterval()).isEqualTo(160);
    assertThat(awm.nextReconnectInterval()).isEqualTo(320);
    assertThat(awm.nextReconnectInterval()).isEqualTo(320);
  }

  @Test
  @DisplayName("cancelReconnect, with null attempt, should do nothing")
  void cancelReconnectNullAttempt() {
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
  void cancelReconnectNonNullAttempt() {
    // Given
    final ScheduledFuture<?> sf = mock(ScheduledFuture.class);
    final MockedStatic<Utils> utils = mockStatic(Utils.class);
    utils.when(() -> Utils.schedule(any(), any(), anyLong(), any())).thenReturn(sf);
    final WatcherAdapter<HasMetadata> watcher = new WatcherAdapter<>();
    final WatchManager<HasMetadata> awm = withDefaultWatchManager(watcher);
    awm.scheduleReconnect();
    // When
    awm.cancelReconnect();
    // Then
    verify(sf, times(1)).cancel(true);
  }

  @Test
  @DisplayName("isClosed, after close invocation, should return true")
  void isForceClosedWhenClosed() {
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
  void closeWithNonNullRunnerShouldCancelRunner() {
    // Given
    final WatcherAdapter<HasMetadata> watcher = new WatcherAdapter<>();
    final WatchManager<HasMetadata> awm = withDefaultWatchManager(watcher);
    // When
    awm.close();
    // Then
    assertThat(awm.closeCount.get()).isEqualTo(1);
  }

  private static <T extends HasMetadata> WatchManager<T> withDefaultWatchManager(Watcher<T> watcher) {
    return new WatchManager<>(
      watcher, mock(ListOptions.class, RETURNS_DEEP_STUBS), 1, 0, 0);
  }

  private static class WatcherAdapter<T> implements Watcher<T> {
    private final AtomicInteger closeCount = new AtomicInteger(0);

    @Override
    public void eventReceived(Action action, T resource) {}

    @Override
    public void onClose(WatcherException cause) {
      closeCount.addAndGet(1);
    }

    @Override
    public void onClose() {
      closeCount.addAndGet(1);
    }
  }

  private static final class WatchManager<T extends HasMetadata> extends AbstractWatchManager<T> {
    
    private final AtomicInteger closeCount = new AtomicInteger(0);

    public WatchManager(Watcher<T> watcher, ListOptions listOptions, int reconnectLimit, int reconnectInterval, int maxIntervalExponent) {
      super(watcher, listOptions, reconnectLimit, reconnectInterval, maxIntervalExponent, resourceVersion -> null, ()->null);
    }

    @Override
    protected void run(Request request) {
      
    }

    @Override
    protected void closeRequest() {
     closeCount.addAndGet(1); 
    }
    
    @Override
    protected void runWatch() {
    }
  }
}
