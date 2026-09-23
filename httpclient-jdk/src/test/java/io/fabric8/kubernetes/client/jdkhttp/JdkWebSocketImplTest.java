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
package io.fabric8.kubernetes.client.jdkhttp;

import io.fabric8.kubernetes.client.http.WebSocket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.after;
import static org.mockito.Mockito.clearInvocations;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class JdkWebSocketImplTest {

  private java.net.http.WebSocket jdkWebSocket;

  @BeforeEach
  void setUp() {
    jdkWebSocket = mock(java.net.http.WebSocket.class);
    when(jdkWebSocket.sendPing(any())).thenReturn(CompletableFuture.completedFuture(jdkWebSocket));
  }

  @Test
  @DisplayName("With a ping interval, sends pings while open and stops once closed (the ping task doesn't outlive the socket)")
  void pingsStopOnClose() {
    // Given
    final JdkWebSocketImpl webSocket = new JdkWebSocketImpl(new WebSocket.Listener() {
    }, Duration.ofMillis(10));
    webSocket.onOpen(jdkWebSocket);
    verify(jdkWebSocket, timeout(5000).atLeast(2)).sendPing(any());
    // When
    webSocket.onClose(jdkWebSocket, 1000, "done");
    clearInvocations(jdkWebSocket);
    // Then
    verify(jdkWebSocket, after(200).atMost(1)).sendPing(any());
  }

  @Test
  @DisplayName("With a ping interval, stops sending pings after an error")
  void pingsStopOnError() {
    // Given
    final JdkWebSocketImpl webSocket = new JdkWebSocketImpl(new WebSocket.Listener() {
    }, Duration.ofMillis(10));
    webSocket.onOpen(jdkWebSocket);
    verify(jdkWebSocket, timeout(5000).atLeast(2)).sendPing(any());
    // When
    webSocket.onError(jdkWebSocket, new Exception("broken"));
    clearInvocations(jdkWebSocket);
    // Then
    verify(jdkWebSocket, after(200).atMost(1)).sendPing(any());
  }

  @Test
  @DisplayName("Without a ping interval, sends no pings")
  void noPingsWithoutInterval() {
    new JdkWebSocketImpl(new WebSocket.Listener() {
    }, null).onOpen(jdkWebSocket);
    verify(jdkWebSocket, after(200).never()).sendPing(any());
  }
}
