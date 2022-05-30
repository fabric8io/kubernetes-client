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
package io.fabric8.kubernetes.client.jetty;

import io.fabric8.kubernetes.client.http.WebSocket;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.websocket.api.Session;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.util.LinkedHashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class JettyWebSocketTest {

  @Test
  @DisplayName("Remote WebSocket binary message, notifies first onMessage with no back pressure")
  void webSocketBinaryNotifiesOnMessage() {
    // Given
    final var listener = new Listener();
    // When
    new JettyWebSocket(listener).onWebSocketBinary(new byte[] { 1, 3, 3, 7 }, 0, 4);
    // Then
    assertThat(listener.events)
        .containsOnlyKeys("onMessage")
        .extracting("onMessage", InstanceOfAssertFactories.type(Object[].class))
        .extracting(o -> o[0], InstanceOfAssertFactories.type(ByteBuffer.class))
        .extracting(BufferUtil::toArray, InstanceOfAssertFactories.type(byte[].class))
        .isEqualTo(new byte[] { 1, 3, 3, 7 });
  }

  @Test
  @DisplayName("Remote WebSocket text message, notifies first onMessage with no back pressure")
  void webSocketTextNotifiesOnMessage() {
    // Given
    final var listener = new Listener();
    // When
    new JettyWebSocket(listener).onWebSocketText("the message");
    // Then
    assertThat(listener.events)
        .containsOnlyKeys("onMessage")
        .extracting("onMessage", InstanceOfAssertFactories.type(Object[].class))
        .extracting(o -> o[0], InstanceOfAssertFactories.type(String.class))
        .isEqualTo("the message");
  }

  @Test
  @DisplayName("Remote WebSocket close, notifies onClose")
  void webSocketCloseNotifiesOnClose() {
    // Given
    final var listener = new Listener();
    // When
    new JettyWebSocket(listener).onWebSocketClose(1337, "closed");
    // Then
    assertThat(listener.events)
        .containsOnly(entry("onClose", new Object[] { 1337, "closed" }));
  }

  @Test
  @DisplayName("Remote WebSocket connect, notifies onOpen")
  void webSocketConnectNotifiesOnOpen() {
    // Given
    final var listener = new Listener();
    // When
    new JettyWebSocket(listener).onWebSocketConnect(null);
    // Then
    assertThat(listener.events).containsOnlyKeys("onOpen");
  }

  @Test
  @DisplayName("Remote WebSocket error, notifies onError")
  void webSocketErrorNotifiesOnError() {
    // Given
    final var listener = new Listener();
    // When
    new JettyWebSocket(listener).onWebSocketError(new Exception("WebSocket Error!"));
    // Then
    assertThat(listener.events)
        .containsOnlyKeys("onError")
        .extracting("onError", InstanceOfAssertFactories.type(Object[].class))
        .extracting(o -> o[0], InstanceOfAssertFactories.throwable(Exception.class))
        .hasMessage("WebSocket Error!");
  }

  @Test
  @DisplayName("Remote WebSocket error, ignored if connection is already closed and is ClosedChannelException")
  void webSocketErrorIgnoredWhenClosed() {
    // Given
    final var listener = new Listener();
    final var jws = new JettyWebSocket(listener);
    jws.onWebSocketClose(1000, "closed");
    // When
    jws.onWebSocketError(new ClosedChannelException());
    // Then
    assertThat(listener.events)
        .containsOnlyKeys("onClose");
  }

  @Test
  @DisplayName("Remote WebSocket error, notifies onClose if connection is already closed and is NOT ClosedChannelException")
  void webSocketErrorNotifiesOnErrorWhenClosedAndNotClosedChannelException() {
    // Given
    final var listener = new Listener();
    final var jws = new JettyWebSocket(listener);
    jws.onWebSocketClose(1000, "closed");
    // When
    jws.onWebSocketError(new Exception("NOT ClosedChannelException"));
    // Then
    assertThat(listener.events)
        .containsOnlyKeys("onClose", "onError")
        .extracting("onError", InstanceOfAssertFactories.type(Object[].class))
        .extracting(o -> o[0], InstanceOfAssertFactories.throwable(Exception.class))
        .hasMessage("NOT ClosedChannelException");
  }

  @Test
  @DisplayName("backPressure, onWebSocketText processes first frame and waits for request() call")
  void backPressure() throws Exception {
    final var executor = Executors.newSingleThreadExecutor();
    try {
      final var buffer = new StringBuffer();
      final var messages = new String[] { "Hell", "o ", "World!" };
      final BlockingQueue<String> lock = new ArrayBlockingQueue<>(3);
      final var ws = new JettyWebSocket(new WebSocket.Listener() {
        @Override
        public void onMessage(WebSocket webSocket, String text) {
          buffer.append(text);
        }
      });
      executor.execute(() -> {
        for (var m : messages) {
          ws.onWebSocketText(m);
          assertTrue(lock.offer(m));
        }
      });
      lock.poll(1, TimeUnit.SECONDS);
      assertThat(buffer).hasToString("Hell");
      ws.request();
      lock.poll(1, TimeUnit.SECONDS);
      assertThat(buffer).hasToString("Hello ");
      ws.request();
      lock.poll(1, TimeUnit.SECONDS);
      assertThat(buffer).hasToString("Hello World!");
    } finally {
      executor.shutdownNow();
    }
  }

  @Test
  @DisplayName("sendClose, sends close message if connection is open")
  void sendCloseWhenConnectionIsOpen() {
    // Given
    final var jws = new JettyWebSocket(new Listener());
    final var session = mock(Session.class);
    jws.setWebSocketSession(session);
    when(session.isOpen()).thenReturn(true);
    // When
    jws.sendClose(1000, "Closing");
    // Then
    verify(session).close(1000, "Closing");
  }

  @Test
  @DisplayName("sendClose, ignored if connection is closed")
  void sendCloseIgnoredWhenConnectionIsClosed() {
    // Given
    final var jws = new JettyWebSocket(new Listener());
    final var session = mock(Session.class);
    jws.setWebSocketSession(session);
    when(session.isOpen()).thenReturn(false);
    // When
    jws.sendClose(1000, "Closing");
    // Then
    verify(session, times(0)).close(anyInt(), anyString());
  }

  @Test
  @DisplayName("sendClose, ignored if connection is already closed")
  void sendCloseIgnoredWhenAlreadyClosed() {
    // Given
    final var jws = new JettyWebSocket(new Listener());
    final var session = mock(Session.class);
    jws.setWebSocketSession(session);
    when(session.isOpen()).thenReturn(true);
    jws.sendClose(1000, "Closing");
    // When
    jws.sendClose(1000, "Closing twice");
    // Then
    verify(session, times(1)).close(anyInt(), anyString());
    verify(session).close(1000, "Closing");
  }

  @Test
  @DisplayName("send increases queueSize")
  void sendIncreasesQueueSize() {
    // Given
    final var jws = new JettyWebSocket(new Listener());
    final var session = mock(Session.class, RETURNS_DEEP_STUBS);
    jws.setWebSocketSession(session);
    when(session.isOpen()).thenReturn(true);
    // When
    jws.send(ByteBuffer.wrap(new byte[] {1, 3, 3, 7}));
    // Then
    assertThat(jws.queueSize()).isEqualTo(4L);
  }

  private static final class Listener implements WebSocket.Listener {
    private final LinkedHashMap<String, Object[]> events = new LinkedHashMap<>();

    @Override
    public void onOpen(WebSocket webSocket) {
      events.put("onOpen", null);
    }

    @Override
    public void onMessage(WebSocket webSocket, String text) {
      events.put("onMessage", new Object[] { text });
    }

    @Override
    public void onMessage(WebSocket webSocket, ByteBuffer bytes) {
      events.put("onMessage", new Object[] { bytes });
    }

    @Override
    public void onClose(WebSocket webSocket, int code, String reason) {
      events.put("onClose", new Object[] { code, reason });
    }

    @Override
    public void onError(WebSocket webSocket, Throwable error) {
      events.put("onError", new Object[] { error });
    }
  }
}
