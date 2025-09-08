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
import io.vertx.core.Future;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpClosedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Vert.x 5 WebSocket adapter implementing Fabric8's {@link WebSocket} SPI with backpressure support.
 * 
 * <p>
 * This class bridges Vert.x's native WebSocket implementation to Fabric8's WebSocket abstraction,
 * enabling Kubernetes WebSocket operations like exec, port-forward, logs streaming, and watch APIs.
 * 
 * <h3>Thread Safety</h3>
 * <p>
 * Thread-safe for concurrent access. All Vert.x callbacks execute on the event-loop thread,
 * while public methods may be called from any thread. Internal state is protected using atomic operations.
 * 
 * <h3>Backpressure Protocol</h3>
 * <p>
 * Implements flow control to prevent overwhelming the consumer:
 * <ul>
 * <li>WebSocket pauses after each message delivery</li>
 * <li>Consumer must call {@link #request()} to receive the next frame</li>
 * <li>Violating this protocol will cause the connection to stall</li>
 * </ul>
 * 
 * <h3>Error Handling</h3>
 * <p>
 * Translates Vert.x-specific exceptions to standard Java types:
 * <ul>
 * <li>{@link CorruptedWebSocketFrameException} → {@link ProtocolException}</li>
 * <li>{@link HttpClosedException} → {@link IOException}</li>
 * </ul>
 */
class VertxWebSocket implements WebSocket {

  private static final Logger LOG = LoggerFactory.getLogger(VertxWebSocket.class);

  /** The underlying Vert.x WebSocket providing the network transport */
  private final io.vertx.core.http.WebSocket webSocket;

  /** Atomic counter tracking bytes pending transmission for backpressure control */
  private final AtomicInteger pendingBytesCount = new AtomicInteger();

  /** Callback handler for WebSocket lifecycle events and message delivery */
  private final Listener eventListener;

  /**
   * Creates a new Vert.x WebSocket adapter.
   * 
   * @param webSocket the underlying Vert.x WebSocket connection
   * @param eventListener callback handler for WebSocket events and messages
   */
  VertxWebSocket(final io.vertx.core.http.WebSocket webSocket, final Listener eventListener) {
    this.webSocket = webSocket;
    this.eventListener = eventListener;
  }

  /**
   * Initializes WebSocket handlers and notifies the listener that the connection is ready.
   * Called by the owning HttpClient once the underlying Vert.x WebSocket is established.
   */
  void initHandlers() {
    setupEventHandlers();
    eventListener.onOpen(this);
  }

  /**
   * Registers Vert.x event handlers and translates them to Fabric8 WebSocket callbacks.
   * Implements backpressure by pausing after each message until {@link #request()} is called.
   */
  private void setupEventHandlers() {
    // Handle binary messages (e.g., exec terminal data)
    webSocket.binaryMessageHandler(buffer -> {
      webSocket.pause();
      eventListener.onMessage(this, ByteBuffer.wrap(buffer.getBytes()));
    });

    // Handle text messages (e.g., JSON watch events, logs)
    webSocket.textMessageHandler(text -> {
      webSocket.pause();
      eventListener.onMessage(this, text);
    });

    // Handle connection close (use end handler for proper frame ordering)
    webSocket.endHandler(unused -> eventListener.onClose(this, webSocket.closeStatusCode(), webSocket.closeReason()));

    // Handle connection errors with proper cleanup
    webSocket.exceptionHandler(error -> {
      try {
        eventListener.onError(this, mapVertxErrorToStandardException(error));
      } finally {
        // Ensure connection is closed after error notification
        if (!webSocket.isClosed()) {
          webSocket.close();
        }
      }
    });
  }

  /**
   * Maps Vert.x-specific exceptions to standard Java exception types expected by Fabric8 SPI.
   * 
   * @param vertxError the original Vert.x exception
   * @return a standard Java exception suitable for the WebSocket SPI
   */
  private static Throwable mapVertxErrorToStandardException(final Throwable vertxError) {
    if (vertxError instanceof CorruptedWebSocketFrameException) {
      return new ProtocolException(vertxError.getMessage()).initCause(vertxError);
    }
    if (vertxError instanceof HttpClosedException) {
      return new IOException("WebSocket connection closed unexpectedly", vertxError);
    }
    return vertxError;
  }

  /**
   * Logs failures from asynchronous WebSocket operations that cannot be propagated to the caller.
   * 
   * @param asyncOperation the asynchronous operation to monitor for failures
   */
  private void logAsyncOperationFailures(final Future<?> asyncOperation) {
    asyncOperation.onFailure(error -> LOG.error("Asynchronous WebSocket operation failed", error));
  }

  /**
   * Sends binary data over the WebSocket connection.
   * 
   * <p>
   * Optimizes for zero-copy when possible by using array-backed ByteBuffers directly.
   * For direct ByteBuffers, copies data to avoid blocking the event loop.
   * 
   * <p>
   * Updates the pending bytes counter for backpressure monitoring and supports
   * both synchronous and asynchronous transmission completion.
   * 
   * @param buffer the binary data to send; position will be advanced to limit
   * @return true if the message was queued successfully, false if immediate failure occurred
   */
  @Override
  public boolean send(final ByteBuffer buffer) {
    final Buffer vertxBuffer = convertToVertxBuffer(buffer);
    final int messageLength = vertxBuffer.length();

    // Track pending bytes for backpressure
    pendingBytesCount.addAndGet(messageLength);

    final Future<Void> writeOperation = webSocket.writeBinaryMessage(vertxBuffer);

    // Handle immediate failure
    if (writeOperation.failed()) {
      pendingBytesCount.addAndGet(-messageLength);
      LOG.error("WebSocket binary message send failed immediately", writeOperation.cause());
      return false;
    }

    // Handle synchronous success
    if (writeOperation.isComplete()) {
      pendingBytesCount.addAndGet(-messageLength);
      return true;
    }

    // Handle asynchronous completion
    writeOperation.onComplete(result -> {
      if (result.failed()) {
        LOG.error("WebSocket binary message send failed asynchronously", result.cause());
      }
      pendingBytesCount.addAndGet(-messageLength);
    });

    return true;
  }

  /**
   * Converts a Java ByteBuffer to a Vert.x Buffer, optimizing for zero-copy when possible.
   * 
   * @param buffer the source ByteBuffer; position will be advanced to limit
   * @return a Vert.x Buffer containing the data
   */
  private Buffer convertToVertxBuffer(final ByteBuffer buffer) {
    if (buffer.hasArray()) {
      // Zero-copy optimization for array-backed buffers
      final Buffer vertxBuffer = Buffer.buffer(buffer.remaining()).setBytes(0, buffer);
      buffer.position(buffer.limit());
      return vertxBuffer;
    } else {
      // Copy for direct buffers to avoid blocking event loop
      final Buffer vertxBuffer = Buffer.buffer(buffer.remaining());
      final byte[] tempArray = new byte[buffer.remaining()];
      buffer.get(tempArray);
      return vertxBuffer.appendBytes(tempArray);
    }
  }

  /**
   * Initiates a graceful WebSocket close handshake with the specified status code and reason.
   * 
   * <p>
   * Sends a close frame to the remote endpoint and ensures the end handler can fire
   * by requesting one final frame. This allows proper cleanup and close event delivery.
   * 
   * @param code the WebSocket close status code (e.g., 1000 for normal closure)
   * @param reason human-readable explanation for the closure (maybe null)
   * @return true if close was initiated, false if connection was already closed
   */
  @Override
  public boolean sendClose(final int code, final String reason) {
    if (webSocket.isClosed()) {
      return false;
    }

    logAsyncOperationFailures(webSocket.close((short) code, reason));

    // Request one frame to ensure the end handler fires for proper cleanup
    webSocket.fetch(1);

    return true;
  }

  /**
   * Returns the number of bytes currently queued for transmission.
   * 
   * <p>
   * This value represents the backpressure state of the WebSocket connection.
   * High values indicate the remote endpoint may be slower at consuming data
   * than this endpoint is producing it.
   * 
   * @return the number of bytes pending transmission
   */
  @Override
  public long queueSize() {
    return pendingBytesCount.get();
  }

  /**
   * Requests delivery of the next WebSocket frame, resuming the paused connection.
   * 
   * <p>
   * This method implements the backpressure protocol by allowing the consumer
   * to control the flow of incoming messages. Must be called after each message
   * is processed to receive later frames.
   * 
   * <p>
   * Failure to call this method will cause the WebSocket to remain paused
   * indefinitely after the first message delivery.
   */
  @Override
  public void request() {
    webSocket.fetch(1);
  }
}
