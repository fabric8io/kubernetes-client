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

import io.fabric8.kubernetes.client.http.BufferUtil;
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.http.WebSocket;
import io.fabric8.kubernetes.client.http.WebSocketResponse;
import io.fabric8.kubernetes.client.http.WebSocketUpgradeResponse;
import io.fabric8.kubernetes.client.utils.Utils;
import org.eclipse.jetty.websocket.api.Callback;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.UpgradeResponse;
import org.eclipse.jetty.websocket.api.exceptions.CloseException;
import org.eclipse.jetty.websocket.api.exceptions.UpgradeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

// Explicit demand (not Session.Listener.AutoDemanding). Don't override onWebSocketPing/onWebSocketPong: Jetty only
// answers pings and demands again by itself when they aren't, otherwise the socket stalls after the first ping
public class JettyWebSocket implements WebSocket, Session.Listener {

  private static final Logger logger = LoggerFactory.getLogger(JettyWebSocket.class);

  private final WebSocket.Listener listener;
  private final AtomicLong sendQueue;
  private final CompletableFuture<Void> terminated = new CompletableFuture<>();
  private final AtomicBoolean outputClosed = new AtomicBoolean();
  @SuppressWarnings("java:S3077") // volatile publishes the session reference; Jetty Session is thread-safe
  private volatile Session webSocketSession;
  // request() calls not turned into a Jetty demand yet, onOpen implies the first one
  private long requested = 1;
  // Jetty allows a single pending demand, a second one throws ReadPendingException
  private boolean demandPending;
  // demand only once the listener's onOpen has returned, and not after the close
  private boolean receiving;

  public JettyWebSocket(WebSocket.Listener listener) {
    this.listener = listener;
    sendQueue = new AtomicLong();
  }

  @Override
  public boolean send(ByteBuffer buffer) {
    if (outputClosed.get() || terminated.isDone() || !webSocketSession.isOpen()) {
      return false;
    }
    buffer = BufferUtil.copy(buffer);
    final int size = buffer.remaining();
    sendQueue.addAndGet(size);
    webSocketSession.sendBinary(buffer, Callback.from(() -> sendQueue.addAndGet(-size), x -> {
      sendQueue.addAndGet(-size);
      if (webSocketSession.isOpen()) {
        logger.warn("Queued write did not succeed", x);
      }
      webSocketSession.disconnect(); // prevent further writes
    }));
    return true;
  }

  @Override
  public boolean sendClose(int code, String reason) {
    if (!outputClosed.compareAndSet(false, true) || !webSocketSession.isOpen()) {
      return false;
    }
    webSocketSession.close(code, reason, Callback.from(() -> {
      CompletableFuture<Void> future = Utils.schedule(Runnable::run, webSocketSession::disconnect, 1, TimeUnit.MINUTES);
      terminated.whenComplete((v, ignored) -> future.cancel(true));
    }, x -> {
      logger.warn("Queued close did not succeed", x);
      webSocketSession.disconnect(); // immediately terminate
    }));
    return true;
  }

  @Override
  public long queueSize() {
    return sendQueue.get();
  }

  @Override
  public void request() {
    synchronized (this) {
      requested++;
    }
    demand();
  }

  private void demand() {
    synchronized (this) {
      if (!receiving || demandPending || requested == 0) {
        return;
      }
      demandPending = true;
      requested--;
    }
    webSocketSession.demand();
  }

  @Override
  public void onWebSocketOpen(Session session) {
    this.webSocketSession = session;
    listener.onOpen(this);
    synchronized (this) {
      receiving = true;
    }
    demand();
  }

  @Override
  public void onWebSocketBinary(ByteBuffer payload, Callback callback) {
    // Jetty reuses the payload buffer once the callback completes, and fails the callback itself if the listener throws
    final ByteBuffer copy = BufferUtil.copy(payload);
    onMessage(() -> listener.onMessage(this, copy.asReadOnlyBuffer()));
    callback.succeed();
  }

  @Override
  public void onWebSocketText(String message) {
    onMessage(() -> listener.onMessage(this, message));
  }

  private void onMessage(Runnable notifyListener) {
    synchronized (this) {
      demandPending = false;
    }
    notifyListener.run();
    // serve the request() calls made before this message was delivered
    demand();
  }

  @Override
  public void onWebSocketClose(int statusCode, String reason, Callback callback) {
    synchronized (this) {
      receiving = false;
    }
    terminated.complete(null);
    listener.onClose(this, statusCode, reason);
    callback.succeed();
  }

  /**
   * The semantics here are different than jdk/okhttp - onClose will be
   * invoked after this, if it has not already been called. So we need to skip
   * erroneously notifying
   */
  @Override
  public void onWebSocketError(Throwable cause) {
    if (cause instanceof ClosedChannelException && (outputClosed.get() || !terminated.complete(null))) {
      // TODO: Check better
      //  It appears to be a race condition in Jetty:
      // - The server sends a close frame (but we haven't received it)
      // - Client enqueues a sendClose -> webSocketSession.close(code, reason)
      // - Jetty/client receives the  remote close -> onWebSocketClose
      // - Jetty sends the enqueued close frame, but the socket was already closed in the previous step
      // - Jetty throws a ClosedChannelException
      return;
    }
    if (cause instanceof CloseException) {
      cause = new ProtocolException().initCause(cause);
    }
    listener.onError(this, cause);
  }

  static WebSocketResponse toWebSocketResponse(HttpRequest httpRequest, UpgradeException ex) {
    final WebSocketUpgradeResponse webSocketUpgradeResponse = new WebSocketUpgradeResponse(httpRequest,
        ex.getResponseStatusCode());
    return new WebSocketResponse(webSocketUpgradeResponse, ex);
  }

  static WebSocketResponse toWebSocketResponse(HttpRequest httpRequest, WebSocket ws, Session session) {
    final UpgradeResponse jettyUpgradeResponse = session.getUpgradeResponse();
    final WebSocketUpgradeResponse fabric8UpgradeResponse = new WebSocketUpgradeResponse(
        httpRequest, jettyUpgradeResponse.getStatusCode(), jettyUpgradeResponse.getHeaders());
    return new WebSocketResponse(fabric8UpgradeResponse, ws);
  }
}
