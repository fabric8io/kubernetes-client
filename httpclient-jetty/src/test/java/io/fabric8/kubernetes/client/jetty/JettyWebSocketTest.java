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
package io.fabric8.kubernetes.client.jetty;

import io.fabric8.kubernetes.client.RequestConfigBuilder;
import io.fabric8.kubernetes.client.http.WebSocket;
import io.fabric8.mockwebserver.DefaultMockServer;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.websocket.api.Callback;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.exceptions.MessageTooLargeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.net.ProtocolException;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.entry;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.after;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class JettyWebSocketTest {

  @Test
  void webSocketExceptionConversion() {
    // Given
    final var listener = new Listener();
    final var jws = new JettyWebSocket(listener);
    jws.onWebSocketOpen(mock(Session.class));
    listener.events.clear();
    // When
    jws.onWebSocketError(new MessageTooLargeException("too big"));
    // Then
    assertThat(listener.events)
        .containsOnlyKeys("onError")
        .extracting("onError", InstanceOfAssertFactories.type(Object[].class))
        .extracting(o -> o[0], InstanceOfAssertFactories.type(ProtocolException.class))
        .extracting(ProtocolException::getCause).isInstanceOf(MessageTooLargeException.class);
  }

  @Test
  @DisplayName("Remote WebSocket binary message, notifies onMessage")
  void webSocketBinaryNotifiesOnMessage() {
    // Given
    final var listener = new Listener();
    // When
    new JettyWebSocket(listener).onWebSocketBinary(ByteBuffer.wrap(new byte[] { 1, 3, 3, 7 }), Callback.NOOP);
    // Then
    assertThat(listener.events)
        .containsOnlyKeys("onMessage")
        .extracting("onMessage", InstanceOfAssertFactories.type(Object[].class))
        .extracting(o -> o[0], InstanceOfAssertFactories.type(ByteBuffer.class))
        .extracting(BufferUtil::toArray, InstanceOfAssertFactories.type(byte[].class))
        .isEqualTo(new byte[] { 1, 3, 3, 7 });
  }

  @Test
  @DisplayName("Remote WebSocket binary message, completes the Jetty callback and delivers a copy that outlives the Jetty buffer")
  void webSocketBinaryCompletesCallbackAndDeliversCopy() {
    // Given
    final var listener = new Listener();
    final var payload = ByteBuffer.wrap(new byte[] { 1, 3, 3, 7 });
    final var callback = new Callback.Completable();
    // When
    new JettyWebSocket(listener).onWebSocketBinary(payload, callback);
    // Jetty recycles the buffer once the callback completes
    payload.clear().put(new byte[] { 0, 0, 0, 0 });
    // Then
    assertThat(callback).isCompleted();
    assertThat(listener.events)
        .extracting("onMessage", InstanceOfAssertFactories.type(Object[].class))
        .extracting(o -> o[0], InstanceOfAssertFactories.type(ByteBuffer.class))
        .extracting(BufferUtil::toArray, InstanceOfAssertFactories.type(byte[].class))
        .isEqualTo(new byte[] { 1, 3, 3, 7 });
  }

  @Test
  @DisplayName("Remote WebSocket binary message, a listener failure propagates and leaves the Jetty callback for Jetty to fail once")
  void webSocketBinaryListenerFailureLeavesCallbackToJetty() {
    // Given
    final var callback = new Callback.Completable();
    final var jws = new JettyWebSocket(new WebSocket.Listener() {
      @Override
      public void onMessage(WebSocket webSocket, ByteBuffer bytes) {
        throw new IllegalStateException("listener failed");
      }
    });
    final var payload = ByteBuffer.wrap(new byte[] { 1 });
    // When
    assertThatThrownBy(() -> jws.onWebSocketBinary(payload, callback))
        .hasMessage("listener failed");
    // Then
    assertThat(callback).isNotDone();
  }

  @Test
  @DisplayName("Remote WebSocket text message, notifies onMessage")
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
  @DisplayName("Remote WebSocket close, notifies onClose and completes the Jetty callback")
  void webSocketCloseNotifiesOnClose() {
    // Given
    final var listener = new Listener();
    final var callback = new Callback.Completable();
    // When
    new JettyWebSocket(listener).onWebSocketClose(1337, "closed", callback);
    // Then
    assertThat(listener.events)
        .containsOnly(entry("onClose", new Object[] { 1337, "closed" }));
    assertThat(callback).isCompleted();
  }

  @Test
  @DisplayName("Remote WebSocket open, notifies onOpen")
  void webSocketOpenNotifiesOnOpen() {
    // Given
    final var listener = new Listener();
    // When
    new JettyWebSocket(listener).onWebSocketOpen(mock(Session.class));
    // Then
    assertThat(listener.events).containsOnlyKeys("onOpen");
  }

  @Test
  @DisplayName("Remote WebSocket error, notifies onError")
  void webSocketErrorNotifiesOnError() {
    // Given
    final var listener = new Listener();
    final var jws = new JettyWebSocket(listener);
    jws.onWebSocketOpen(mock(Session.class));
    listener.events.clear();
    // When
    jws.onWebSocketError(new Exception("WebSocket Error!"));
    // Then
    assertThat(listener.events)
        .containsOnlyKeys("onError")
        .extracting("onError", InstanceOfAssertFactories.type(Object[].class))
        .extracting(o -> o[0], InstanceOfAssertFactories.throwable(Exception.class))
        .hasMessage("WebSocket Error!");
  }

  @Test
  @DisplayName("WebSocket error before open (failed handshake), doesn't notify the listener: the connect future carries it and the handshake may be retried with the same listener")
  void webSocketErrorBeforeOpenIsNotNotified() {
    // Given
    final var listener = new Listener();
    // When
    new JettyWebSocket(listener).onWebSocketError(new Exception("handshake failed"));
    // Then
    assertThat(listener.events).isEmpty();
  }

  @Test
  @DisplayName("WebSocket upgrade retried after a 503, opens without the listener having been notified of the failed attempt")
  void retriedUpgradeDoesNotNotifyListenerOfFailedAttempt() throws Exception {
    final var server = new DefaultMockServer(false);
    server.start();
    try (var client = new JettyHttpClientFactory().newBuilder()
        .tag(new RequestConfigBuilder().withRequestRetryBackoffLimit(1).withRequestRetryBackoffInterval(10).build())
        .build()) {
      // Given
      server.expect().withPath("/retried-upgrade").andReturn(503, "unavailable").once();
      server.expect().withPath("/retried-upgrade")
          .andUpgradeToWebSocket()
          .open()
          .done()
          .always();
      final List<Throwable> errors = new CopyOnWriteArrayList<>();
      // When
      client.newWebSocketBuilder()
          .uri(URI.create(server.url("/retried-upgrade")))
          .buildAsync(new WebSocket.Listener() {
            @Override
            public void onError(WebSocket webSocket, Throwable error) {
              errors.add(error);
            }
          })
          .get(10L, TimeUnit.SECONDS);
      // Then
      assertThat(errors)
          .as("ExecWebSocketListener and WatcherWebSocketListener end for good on onError, before the retry opens")
          .isEmpty();
    } finally {
      server.shutdown();
    }
  }

  @Test
  @DisplayName("Remote WebSocket error, ignored if connection is already closed and is ClosedChannelException")
  void webSocketErrorIgnoredWhenClosed() {
    // Given
    final var listener = new Listener();
    final var jws = new JettyWebSocket(listener);
    jws.onWebSocketOpen(mock(Session.class));
    listener.events.clear();
    jws.onWebSocketClose(1000, "closed", Callback.NOOP);
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
    jws.onWebSocketOpen(mock(Session.class));
    listener.events.clear();
    jws.onWebSocketClose(1000, "closed", Callback.NOOP);
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
  @DisplayName("Remote WebSocket error, ignored if the output is closed and is ClosedChannelException")
  void webSocketErrorIgnoredWhenOutputClosed() {
    // Given
    final var listener = new Listener();
    final var jws = new JettyWebSocket(listener);
    jws.onWebSocketOpen(Mockito.mock(Session.class));
    listener.events.clear();
    jws.sendClose(1000, "Closing");
    // When
    jws.onWebSocketError(new ClosedChannelException());
    // Then
    assertThat(listener.events).isEmpty();

    jws.onWebSocketClose(1000, "Closed", Callback.NOOP);
    assertThat(listener.events)
        .containsOnlyKeys("onClose");
  }

  @Test
  @DisplayName("onWebSocketOpen, demands the first message only after the listener's onOpen returns")
  void openDemandsFirstMessageAfterOnOpen() {
    // Given
    final List<String> events = new ArrayList<>();
    final var session = mock(Session.class);
    doAnswer(i -> events.add("demand")).when(session).demand();
    final var jws = new JettyWebSocket(new WebSocket.Listener() {
      @Override
      public void onOpen(WebSocket webSocket) {
        events.add("onOpen");
      }
    });
    // When
    jws.onWebSocketOpen(session);
    // Then
    assertThat(events).containsExactly("onOpen", "demand");
  }

  @Test
  @DisplayName("request() from the listener's onOpen, demands only once onOpen returns")
  void requestFromOnOpenDemandsAfterOnOpenReturns() {
    // Given
    final List<String> events = new ArrayList<>();
    final var session = mock(Session.class);
    doAnswer(i -> events.add("demand")).when(session).demand();
    final var jws = new JettyWebSocket(new WebSocket.Listener() {
      @Override
      public void onOpen(WebSocket webSocket) {
        webSocket.request();
        events.add("onOpen returns");
      }
    });
    // When
    jws.onWebSocketOpen(session);
    // Then
    assertThat(events).containsExactly("onOpen returns", "demand");
  }

  @Test
  @DisplayName("onWebSocketPing and onWebSocketPong aren't overridden, so that Jetty answers pings and demands again by itself")
  void pingAndPongAreLeftToJetty() throws Exception {
    assertThat(JettyWebSocket.class.getMethod("onWebSocketPing", ByteBuffer.class).getDeclaringClass())
        .isEqualTo(Session.Listener.class);
    assertThat(JettyWebSocket.class.getMethod("onWebSocketPong", ByteBuffer.class).getDeclaringClass())
        .isEqualTo(Session.Listener.class);
  }

  @Test
  @DisplayName("message delivery, doesn't demand the next message until request() is called")
  void messageDeliveryWaitsForRequest() {
    // Given
    final var session = mock(Session.class);
    final var jws = new JettyWebSocket(new Listener());
    jws.onWebSocketOpen(session);
    // When
    jws.onWebSocketText("first");
    // Then
    verify(session, times(1)).demand();
    // When
    jws.request();
    // Then
    verify(session, times(2)).demand();
  }

  @Test
  @DisplayName("request() while a demand is pending, doesn't demand again (Jetty throws ReadPendingException)")
  void requestWhileDemandPendingDoesNotDemandAgain() {
    // Given
    final var session = mock(Session.class);
    final var jws = new JettyWebSocket(new Listener());
    jws.onWebSocketOpen(session);
    // When
    jws.request();
    jws.request();
    // Then
    verify(session, times(1)).demand();
  }

  @Test
  @DisplayName("request() calls ahead of delivery, are each served with one demand once the pending one is fulfilled")
  void requestsAheadOfDeliveryAreKept() {
    // Given
    final var session = mock(Session.class);
    final var jws = new JettyWebSocket(new Listener());
    jws.onWebSocketOpen(session);
    jws.request();
    jws.request();
    // When
    jws.onWebSocketText("first");
    // Then
    verify(session, times(2)).demand();
    // When
    jws.onWebSocketText("second");
    // Then
    verify(session, times(3)).demand();
    // When
    jws.onWebSocketText("third");
    // Then
    verify(session, times(3)).demand();
  }

  @Test
  @DisplayName("request() from the listener's onOpen, demands a single message and keeps the request for the next one")
  void requestFromOnOpenIsKept() {
    // Given
    final var session = mock(Session.class);
    final var jws = new JettyWebSocket(new WebSocket.Listener() {
      @Override
      public void onOpen(WebSocket webSocket) {
        webSocket.request();
      }

      @Override
      public void onMessage(WebSocket webSocket, String text) {
        // no request
      }
    });
    // When
    jws.onWebSocketOpen(session);
    // Then
    verify(session, times(1)).demand();
    // When
    jws.onWebSocketText("first");
    // Then
    verify(session, times(2)).demand();
    // When
    jws.onWebSocketText("second");
    // Then
    verify(session, times(2)).demand();
  }

  @Test
  @DisplayName("request() after the remote close, doesn't demand")
  void requestAfterCloseDoesNotDemand() {
    // Given
    final var session = mock(Session.class);
    final var jws = new JettyWebSocket(new Listener());
    jws.onWebSocketOpen(session);
    jws.onWebSocketClose(1000, "closed", Callback.NOOP);
    // When
    jws.request();
    // Then
    verify(session, times(1)).demand();
  }

  @Test
  @DisplayName("listener calling request() more than once per message, receives every message")
  void repeatedRequestReceivesEveryMessage() throws Exception {
    final var server = new DefaultMockServer(false);
    server.start();
    try (var client = new JettyHttpClientFactory().newBuilder().build()) {
      // Given
      server.expect().withPath("/repeated-request")
          .andUpgradeToWebSocket()
          .open("1", "2", "3")
          .done()
          .always();
      final BlockingQueue<String> received = new LinkedBlockingQueue<>();
      // When
      client.newWebSocketBuilder()
          .uri(URI.create(server.url("/repeated-request")))
          .buildAsync(new WebSocket.Listener() {
            @Override
            public void onMessage(WebSocket webSocket, String text) {
              received.add(text);
              webSocket.request();
              webSocket.request();
            }
          }).get(10L, TimeUnit.SECONDS);
      // Then
      final List<String> messages = new ArrayList<>();
      for (int i = 0; i < 3; i++) {
        messages.add(received.poll(10L, TimeUnit.SECONDS));
      }
      assertThat(messages).containsExactly("1", "2", "3");
    } finally {
      server.shutdown();
    }
  }

  @Test
  @DisplayName("sendClose, sends close message if connection is open")
  void sendCloseWhenConnectionIsOpen() {
    // Given
    final var jws = new JettyWebSocket(new Listener());
    final var session = mock(Session.class);
    jws.onWebSocketOpen(session);
    when(session.isOpen()).thenReturn(true);
    // When
    jws.sendClose(1000, "Closing");
    // Then
    verify(session).close(Mockito.anyInt(), Mockito.anyString(), Mockito.any());
  }

  @Test
  @DisplayName("sendClose, ignored if connection is closed")
  void sendCloseIgnoredWhenConnectionIsClosed() {
    // Given
    final var jws = new JettyWebSocket(new Listener());
    final var session = mock(Session.class);
    jws.onWebSocketOpen(session);
    when(session.isOpen()).thenReturn(false);
    // When
    jws.sendClose(1000, "Closing");
    // Then
    verify(session, times(0)).close(Mockito.anyInt(), Mockito.anyString(), Mockito.any());
  }

  @Test
  @DisplayName("sendClose, ignored if connection is already closed")
  void sendCloseIgnoredWhenAlreadyClosed() {
    // Given
    final var jws = new JettyWebSocket(new Listener());
    final var session = mock(Session.class);
    jws.onWebSocketOpen(session);
    when(session.isOpen()).thenReturn(true);
    jws.sendClose(1000, "Closing");
    // When
    when(session.isOpen()).thenReturn(false);
    assertFalse(jws.sendClose(1000, "Closing twice"));
    // Then
    verify(session, times(1)).close(Mockito.anyInt(), Mockito.anyString(), Mockito.any());
  }

  @Test
  @DisplayName("send increases queueSize")
  void sendIncreasesQueueSize() {
    // Given
    final var jws = new JettyWebSocket(new Listener());
    final var session = mock(Session.class);
    jws.onWebSocketOpen(session);
    when(session.isOpen()).thenReturn(true);
    // When
    jws.send(ByteBuffer.wrap(new byte[] { 1, 3, 3, 7 }));
    // Then
    assertThat(jws.queueSize()).isEqualTo(4L);
  }

  @Test
  @DisplayName("send, drains queueSize once Jetty completes the write")
  void sendDrainsQueueSizeOnWriteSuccess() {
    // Given
    final var jws = new JettyWebSocket(new Listener());
    final var session = mock(Session.class);
    jws.onWebSocketOpen(session);
    when(session.isOpen()).thenReturn(true);
    jws.send(ByteBuffer.wrap(new byte[] { 1, 3, 3, 7 }));
    final var writeCallback = ArgumentCaptor.forClass(Callback.class);
    verify(session).sendBinary(Mockito.any(), writeCallback.capture());
    // When
    writeCallback.getValue().succeed();
    // Then
    assertThat(jws.queueSize()).isZero();
  }

  @Test
  @DisplayName("send, drains queueSize and disconnects when the write fails")
  void sendDrainsQueueSizeAndDisconnectsOnWriteFailure() {
    // Given
    final var jws = new JettyWebSocket(new Listener());
    final var session = mock(Session.class);
    jws.onWebSocketOpen(session);
    when(session.isOpen()).thenReturn(true);
    jws.send(ByteBuffer.wrap(new byte[] { 1, 3, 3, 7 }));
    final var writeCallback = ArgumentCaptor.forClass(Callback.class);
    verify(session).sendBinary(Mockito.any(), writeCallback.capture());
    // When
    writeCallback.getValue().fail(new ClosedChannelException());
    // Then
    assertThat(jws.queueSize()).isZero();
    verify(session).disconnect();
  }

  @Test
  @DisplayName("With a ping interval, sends pings while open and stops once closed (the ping task doesn't outlive the socket)")
  void pingsStopOnClose() {
    // Given
    final Session session = mock(Session.class);
    final var jws = new JettyWebSocket(new Listener(), Duration.ofMillis(10));
    jws.onWebSocketOpen(session);
    verify(session, timeout(5000).atLeast(2)).sendPing(Mockito.any(), Mockito.any());
    // When
    jws.onWebSocketClose(1000, "done", Callback.NOOP);
    Mockito.clearInvocations(session);
    // Then
    verify(session, after(200).atMost(1)).sendPing(Mockito.any(), Mockito.any());
  }

  @Test
  @DisplayName("Without a ping interval, sends no pings")
  void noPingsWithoutInterval() {
    final Session session = mock(Session.class);
    new JettyWebSocket(new Listener()).onWebSocketOpen(session);
    verify(session, after(200).never()).sendPing(Mockito.any(), Mockito.any());
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
