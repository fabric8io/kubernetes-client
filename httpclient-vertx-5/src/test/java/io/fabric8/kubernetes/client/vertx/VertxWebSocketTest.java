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
package io.fabric8.kubernetes.client.vertx;

import io.fabric8.kubernetes.client.http.WebSocket;
import io.netty.handler.codec.http.websocketx.CorruptedWebSocketFrameException;
import io.netty.handler.codec.http.websocketx.WebSocketCloseStatus;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Promise;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpClosedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.net.ProtocolException;
import java.nio.ByteBuffer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DisplayName("VertxWebSocket")
class VertxWebSocketTest {

  @Mock
  private io.vertx.core.http.WebSocket vertxWebSocket;

  @Mock
  private WebSocket.Listener listener;

  @Captor
  private ArgumentCaptor<Handler<Buffer>> binaryMessageHandlerCaptor;

  @Captor
  private ArgumentCaptor<Handler<String>> textMessageHandlerCaptor;

  @Captor
  private ArgumentCaptor<Handler<Void>> endHandlerCaptor;

  @Captor
  private ArgumentCaptor<Handler<Throwable>> exceptionHandlerCaptor;

  private VertxWebSocket webSocket;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);

    // Setup mock chaining for handler registration
    when(vertxWebSocket.binaryMessageHandler(binaryMessageHandlerCaptor.capture())).thenReturn(vertxWebSocket);
    when(vertxWebSocket.textMessageHandler(textMessageHandlerCaptor.capture())).thenReturn(vertxWebSocket);
    when(vertxWebSocket.endHandler(endHandlerCaptor.capture())).thenReturn(vertxWebSocket);
    when(vertxWebSocket.exceptionHandler(exceptionHandlerCaptor.capture())).thenReturn(vertxWebSocket);

    webSocket = new VertxWebSocket(vertxWebSocket, listener);
  }

  @Test
  @DisplayName("Should setup event handlers and notify listener on initHandlers")
  void initHandlers_shouldSetupHandlersAndNotifyListener() {
    webSocket.initHandlers();

    verify(vertxWebSocket).binaryMessageHandler(any());
    verify(vertxWebSocket).textMessageHandler(any());
    verify(vertxWebSocket).endHandler(any());
    verify(vertxWebSocket).exceptionHandler(any());
    verify(listener).onOpen(webSocket);

    assertThat(binaryMessageHandlerCaptor.getValue()).isNotNull();
    assertThat(textMessageHandlerCaptor.getValue()).isNotNull();
    assertThat(endHandlerCaptor.getValue()).isNotNull();
    assertThat(exceptionHandlerCaptor.getValue()).isNotNull();
  }

  @Test
  @DisplayName("Should handle binary message with pause and listener callback")
  void binaryMessageHandler_shouldHandleBinaryMessageWithBackpressure() {
    webSocket.initHandlers();

    byte[] testData = "binary test data".getBytes();
    Buffer buffer = Buffer.buffer(testData);

    binaryMessageHandlerCaptor.getValue().handle(buffer);

    verify(vertxWebSocket).pause();

    ArgumentCaptor<ByteBuffer> byteBufferCaptor = ArgumentCaptor.forClass(ByteBuffer.class);
    verify(listener).onMessage(eq(webSocket), byteBufferCaptor.capture());

    ByteBuffer capturedBuffer = byteBufferCaptor.getValue();
    byte[] capturedBytes = new byte[capturedBuffer.remaining()];
    capturedBuffer.get(capturedBytes);
    assertThat(capturedBytes).isEqualTo(testData);
  }

  @Test
  @DisplayName("Should handle text message with pause and listener callback")
  void textMessageHandler_shouldHandleTextMessageWithBackpressure() {
    webSocket.initHandlers();

    String testMessage = "text test message";

    textMessageHandlerCaptor.getValue().handle(testMessage);

    verify(vertxWebSocket).pause();
    verify(listener).onMessage(webSocket, testMessage);
  }

  @Test
  @DisplayName("Should handle connection end with close status and reason")
  void endHandler_shouldHandleConnectionEndWithStatusAndReason() {
    webSocket.initHandlers();

    short closeCode = 1000;
    String closeReason = "Normal closure";
    when(vertxWebSocket.closeStatusCode()).thenReturn(closeCode);
    when(vertxWebSocket.closeReason()).thenReturn(closeReason);

    endHandlerCaptor.getValue().handle(null);

    verify(listener).onClose(webSocket, closeCode, closeReason);
  }

  @Test
  @DisplayName("Should handle exception with error mapping and connection cleanup")
  void exceptionHandler_shouldHandleExceptionWithMappingAndCleanup() {
    webSocket.initHandlers();

    RuntimeException originalError = new RuntimeException("Connection error");
    when(vertxWebSocket.isClosed()).thenReturn(false);

    exceptionHandlerCaptor.getValue().handle(originalError);

    verify(listener).onError(webSocket, originalError);
    verify(vertxWebSocket).close();
  }

  @Test
  @DisplayName("Should not close already closed socket in exception handler")
  void exceptionHandler_shouldNotCloseAlreadyClosedSocket() {
    webSocket.initHandlers();

    RuntimeException originalError = new RuntimeException("Connection error");
    when(vertxWebSocket.isClosed()).thenReturn(true);

    exceptionHandlerCaptor.getValue().handle(originalError);

    verify(listener).onError(webSocket, originalError);
    verify(vertxWebSocket, never()).close();
  }

  @Test
  @DisplayName("Should map CorruptedWebSocketFrameException to ProtocolException")
  void exceptionHandler_shouldMapCorruptedFrameException() {
    webSocket.initHandlers();

    var corruptedFrame = new CorruptedWebSocketFrameException(WebSocketCloseStatus.INVALID_PAYLOAD_DATA, "Corrupted frame",
        null);
    when(vertxWebSocket.isClosed()).thenReturn(false);

    exceptionHandlerCaptor.getValue().handle(corruptedFrame);

    ArgumentCaptor<Throwable> errorCaptor = ArgumentCaptor.forClass(Throwable.class);
    verify(listener).onError(eq(webSocket), errorCaptor.capture());

    Throwable mappedException = errorCaptor.getValue();
    assertThat(mappedException).isInstanceOf(ProtocolException.class);
    assertThat(mappedException.getCause()).isSameAs(corruptedFrame);
    assertThat(mappedException.getMessage()).isEqualTo("Corrupted frame");
  }

  @Test
  @DisplayName("Should map HttpClosedException to IOException")
  void exceptionHandler_shouldMapHttpClosedException() {
    webSocket.initHandlers();

    HttpClosedException httpClosed = new HttpClosedException("Connection closed");
    when(vertxWebSocket.isClosed()).thenReturn(false);

    exceptionHandlerCaptor.getValue().handle(httpClosed);

    ArgumentCaptor<Throwable> errorCaptor = ArgumentCaptor.forClass(Throwable.class);
    verify(listener).onError(eq(webSocket), errorCaptor.capture());

    Throwable mappedException = errorCaptor.getValue();
    assertThat(mappedException).isInstanceOf(IOException.class);
    assertThat(mappedException.getCause()).isSameAs(httpClosed);
    assertThat(mappedException.getMessage()).isEqualTo("WebSocket connection closed unexpectedly");
  }

  @Test
  @DisplayName("Should send array-backed ByteBuffer with zero-copy optimization")
  void send_shouldSendArrayBackedByteBufferWithZeroCopy() {
    byte[] testData = "test data for array buffer".getBytes();
    ByteBuffer buffer = ByteBuffer.wrap(testData);

    Future<Void> successfulWrite = Future.succeededFuture();
    when(vertxWebSocket.writeBinaryMessage(any(Buffer.class))).thenReturn(successfulWrite);

    boolean result = webSocket.send(buffer);

    assertThat(result).isTrue();
    assertThat(buffer.position()).isEqualTo(buffer.limit()); // Buffer consumed
    assertThat(webSocket.queueSize()).isZero(); // Synchronous completion

    ArgumentCaptor<Buffer> bufferCaptor = ArgumentCaptor.forClass(Buffer.class);
    verify(vertxWebSocket).writeBinaryMessage(bufferCaptor.capture());

    Buffer sentBuffer = bufferCaptor.getValue();
    assertThat(sentBuffer.getBytes()).isEqualTo(testData);
  }

  @Test
  @DisplayName("Should send direct ByteBuffer with array copy")
  void send_shouldSendDirectByteBufferWithCopy() {
    ByteBuffer buffer = ByteBuffer.allocateDirect(16);
    buffer.put("direct buffer".getBytes());
    buffer.flip();

    Future<Void> successfulWrite = Future.succeededFuture();
    when(vertxWebSocket.writeBinaryMessage(any(Buffer.class))).thenReturn(successfulWrite);

    boolean result = webSocket.send(buffer);

    assertThat(result).isTrue();
    assertThat(buffer.position()).isEqualTo(buffer.limit()); // Buffer consumed
    assertThat(webSocket.queueSize()).isZero(); // Synchronous completion

    verify(vertxWebSocket).writeBinaryMessage(any(Buffer.class));
  }

  @Test
  @DisplayName("Should handle immediate send failure")
  void send_shouldHandleImmediateSendFailure() {
    ByteBuffer buffer = ByteBuffer.wrap("test data".getBytes());

    RuntimeException writeError = new RuntimeException("Write failed");
    Future<Void> failedWrite = Future.failedFuture(writeError);
    when(vertxWebSocket.writeBinaryMessage(any(Buffer.class))).thenReturn(failedWrite);

    boolean result = webSocket.send(buffer);

    assertThat(result).isFalse();
    assertThat(webSocket.queueSize()).isZero(); // Should not track failed writes
  }

  @Test
  @DisplayName("Should handle asynchronous send completion")
  void send_shouldHandleAsynchronousSendCompletion() {
    ByteBuffer buffer = ByteBuffer.wrap("test data".getBytes());
    int expectedLength = buffer.remaining();

    Promise<Void> promise = Promise.promise();
    when(vertxWebSocket.writeBinaryMessage(any(Buffer.class))).thenReturn(promise.future());

    boolean result = webSocket.send(buffer);

    assertThat(result).isTrue();
    assertThat(webSocket.queueSize()).isEqualTo(expectedLength); // Should track pending write

    promise.tryComplete();

    assertThat(webSocket.queueSize()).isZero(); // Should clear pending count
  }

  @Test
  @DisplayName("Should handle asynchronous send failure")
  void send_shouldHandleAsynchronousSendFailure() {
    ByteBuffer buffer = ByteBuffer.wrap("test data".getBytes());
    int expectedLength = buffer.remaining();

    Promise<Void> writePromise = Promise.promise();
    when(vertxWebSocket.writeBinaryMessage(any(Buffer.class))).thenReturn(writePromise.future());

    boolean result = webSocket.send(buffer);

    // Should accept the send and track bytes
    assertThat(result).isTrue();
    assertThat(webSocket.queueSize()).isEqualTo(expectedLength);

    // Fail the async operation
    writePromise.tryFail("Async write failed");

    // Pending counter must be decremented
    assertThat(webSocket.queueSize()).isZero();
  }

  @Test
  @DisplayName("Should track queue size correctly across multiple sends")
  void queueSize_shouldTrackMultiplePendingOperations() {
    ByteBuffer buffer1 = ByteBuffer.wrap("first message".getBytes());
    ByteBuffer buffer2 = ByteBuffer.wrap("second message".getBytes());

    Promise<Void> writePromise1 = Promise.promise();
    Promise<Void> writePromise2 = Promise.promise();
    when(vertxWebSocket.writeBinaryMessage(any(Buffer.class)))
        .thenReturn(writePromise1.future())
        .thenReturn(writePromise2.future());

    // Send the first message
    webSocket.send(buffer1);
    int queueAfterFirst = (int) webSocket.queueSize();

    // Send the second message
    webSocket.send(buffer2);
    int queueAfterSecond = (int) webSocket.queueSize();

    assertThat(queueAfterFirst).isEqualTo("first message".length());
    assertThat(queueAfterSecond).isEqualTo("first message".length() + "second message".length());

    // Complete first async write
    writePromise1.tryComplete();
    assertThat(webSocket.queueSize()).isEqualTo("second message".length());

    // Complete second async write
    writePromise2.tryComplete();
    assertThat(webSocket.queueSize()).isZero();
  }

  @Test
  @DisplayName("Should send close frame and fetch final frame when not closed")
  void sendClose_shouldSendCloseFrameAndFetchFinalFrame() {
    int closeCode = 1000;
    String closeReason = "Normal closure";

    when(vertxWebSocket.isClosed()).thenReturn(false);
    when(vertxWebSocket.close((short) closeCode, closeReason)).thenReturn(Future.succeededFuture());

    boolean result = webSocket.sendClose(closeCode, closeReason);

    assertThat(result).isTrue();
    verify(vertxWebSocket).close((short) closeCode, closeReason);
    verify(vertxWebSocket).fetch(1);
  }

  @Test
  @DisplayName("Should return false when trying to close already closed socket")
  void sendClose_shouldReturnFalseWhenAlreadyClosed() {
    int closeCode = 1000;
    String closeReason = "Normal closure";

    when(vertxWebSocket.isClosed()).thenReturn(true);

    boolean result = webSocket.sendClose(closeCode, closeReason);

    assertThat(result).isFalse();
    verify(vertxWebSocket, never()).close(any(Short.class), any(String.class));
    verify(vertxWebSocket, never()).fetch(1);
  }

  @Test
  @DisplayName("Should handle close operation failure gracefully")
  void sendClose_shouldHandleCloseOperationFailureGracefully() {
    int closeCode = 1000;
    String closeReason = "Normal closure";

    when(vertxWebSocket.isClosed()).thenReturn(false);
    when(vertxWebSocket.close((short) closeCode, closeReason))
        .thenReturn(Future.failedFuture("Close failed"));

    boolean result = webSocket.sendClose(closeCode, closeReason);

    assertThat(result).isTrue(); // Should still return true for attempted close
    verify(vertxWebSocket).close((short) closeCode, closeReason);
    verify(vertxWebSocket).fetch(1);
  }

  @Test
  @DisplayName("Should request next frame by calling fetch")
  void request_shouldCallFetchOnVertxWebSocket() {
    webSocket.request();

    verify(vertxWebSocket).fetch(1);
  }

  @Test
  @DisplayName("Should maintain backpressure protocol across message handling")
  void backpressureProtocol_shouldMaintainFlowControl() {
    webSocket.initHandlers();

    var inOrder = inOrder(vertxWebSocket);

    // Send first message
    binaryMessageHandlerCaptor.getValue().handle(Buffer.buffer("message1"));
    // After a frame is delivered, Vert.x socket should pause
    inOrder.verify(vertxWebSocket).pause();

    // Application requests next frame
    webSocket.request();
    inOrder.verify(vertxWebSocket).fetch(1);

    // Send the second message
    textMessageHandlerCaptor.getValue().handle("message2");

    // The socket should pause again after delivering the second frame
    inOrder.verify(vertxWebSocket).pause();

    // No further interactions expected
    inOrder.verifyNoMoreInteractions();
  }

  @Test
  @DisplayName("Should return zero queue size initially")
  void queueSize_shouldReturnZeroInitially() {
    assertThat(webSocket.queueSize()).isZero();
  }
}
