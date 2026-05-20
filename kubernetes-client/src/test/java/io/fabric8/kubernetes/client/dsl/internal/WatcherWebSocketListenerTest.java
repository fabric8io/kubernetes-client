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
import io.fabric8.kubernetes.client.dsl.internal.AbstractWatchManager.WatchRequestState;
import io.fabric8.kubernetes.client.http.WebSocket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class WatcherWebSocketListenerTest {

  @Test
  @DisplayName("onMessage, defers webSocket.request() until the offloaded manager task completes")
  @SuppressWarnings("unchecked")
  void onMessageDefersRequestUntilTaskCompletes() {
    // Given
    final AbstractWatchManager<HasMetadata> manager = mock(AbstractWatchManager.class);
    final WatchRequestState state = new WatchRequestState();
    final WatcherWebSocketListener<HasMetadata> listener = new WatcherWebSocketListener<>(manager, state);
    final WebSocket ws = mock(WebSocket.class);
    final ArgumentCaptor<Runnable> completionCaptor = ArgumentCaptor.forClass(Runnable.class);
    // When
    listener.onMessage(ws, "text-frame");
    // Then the manager was invoked with the text, state and a completion callback
    verify(manager).onMessage(eq("text-frame"), eq(state), completionCaptor.capture());
    // And webSocket.request() has NOT been invoked yet (back-pressure: only after the task completes)
    verify(ws, never()).request();
    // When the captured completion fires (simulating SerialExecutor task completion)
    completionCaptor.getValue().run();
    // Then webSocket.request() is invoked exactly once
    verify(ws, times(1)).request();
  }

  @Test
  @DisplayName("onMessage(ByteBuffer), routes through the text-frame path so back-pressure is preserved")
  @SuppressWarnings("unchecked")
  void onMessageByteBufferRoutesThroughTextPath() {
    // Given
    final AbstractWatchManager<HasMetadata> manager = mock(AbstractWatchManager.class);
    final WatchRequestState state = new WatchRequestState();
    final WatcherWebSocketListener<HasMetadata> listener = new WatcherWebSocketListener<>(manager, state);
    final WebSocket ws = mock(WebSocket.class);
    // When
    listener.onMessage(ws, java.nio.ByteBuffer.wrap("text-frame".getBytes(java.nio.charset.StandardCharsets.UTF_8)));
    // Then the manager is invoked with the decoded text and a completion callback
    verify(manager).onMessage(eq("text-frame"), eq(state), any(Runnable.class));
    // And webSocket.request() has NOT been invoked synchronously
    verify(ws, never()).request();
  }
}
