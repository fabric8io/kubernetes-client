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

import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.http.BufferUtil;
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.http.WebSocket;
import io.fabric8.kubernetes.client.http.WebSocketResponse;
import io.fabric8.kubernetes.client.http.WebSocketUpgradeResponse;
import io.fabric8.kubernetes.client.utils.Utils;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.UpgradeResponse;
import org.eclipse.jetty.websocket.api.WebSocketListener;
import org.eclipse.jetty.websocket.api.WriteCallback;
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
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class JettyWebSocket implements WebSocket, WebSocketListener {

  private static final Logger LOG = LoggerFactory.getLogger(JettyWebSocket.class);

  private final WebSocket.Listener listener;
  private final AtomicLong sendQueue;
  private final Lock lock;
  private final Condition backPressure;
  private final CompletableFuture<Void> terminated = new CompletableFuture<>();
  private final AtomicBoolean outputClosed = new AtomicBoolean();
  private boolean moreMessages;
  private volatile Session webSocketSession;

  public JettyWebSocket(WebSocket.Listener listener) {
    this.listener = listener;
    sendQueue = new AtomicLong();
    lock = new ReentrantLock();
    backPressure = lock.newCondition();
    moreMessages = true;
  }

  @Override
  public boolean send(ByteBuffer buffer) {
    if (outputClosed.get() || terminated.isDone() || !webSocketSession.isOpen()) {
      return false;
    }
    buffer = BufferUtil.copy(buffer);
    final int size = buffer.remaining();
    sendQueue.addAndGet(size);
    webSocketSession.getRemote().sendBytes(buffer, new WriteCallback() {
      @Override
      public void writeFailed(Throwable x) {
        sendQueue.addAndGet(-size);
        if (webSocketSession.isOpen()) {
          LOG.warn("Queued write did not succeed", x);
        }
        webSocketSession.disconnect(); // prevent further writes
      }

      @Override
      public void writeSuccess() {
        sendQueue.addAndGet(-size);
      }
    });
    return true;
  }

  @Override
  public boolean sendClose(int code, String reason) {
    if (!outputClosed.compareAndSet(false, true) || !webSocketSession.isOpen()) {
      return false;
    }
    webSocketSession.close(code, reason, new WriteCallback() {
      @Override
      public void writeFailed(Throwable x) {
        LOG.warn("Queued close did not succeed", x);
        webSocketSession.disconnect(); // immediately terminate
      }

      @Override
      public void writeSuccess() {
        CompletableFuture<Void> future = Utils.schedule(Runnable::run, webSocketSession::disconnect, 1, TimeUnit.MINUTES);
        terminated.whenComplete((v, ignored) -> future.cancel(true));
      }
    });
    return true;
  }

  @Override
  public long queueSize() {
    return sendQueue.get();
  }

  @Override
  public void request() {
    try {
      lock.lock();
      moreMessages = true;
      backPressure.signalAll();
    } finally {
      lock.unlock();
    }
  }

  @Override
  public void onWebSocketBinary(byte[] payload, int offset, int len) {
    backPressure();
    final var buffer = ByteBuffer.allocate(len);
    buffer.put(payload, offset, len).rewind();
    listener.onMessage(this, buffer.asReadOnlyBuffer());
  }

  @Override
  public void onWebSocketText(String message) {
    backPressure();
    listener.onMessage(this, message);
  }

  @Override
  public void onWebSocketClose(int statusCode, String reason) {
    terminated.complete(null);
    listener.onClose(this, statusCode, reason);
  }

  @Override
  public void onWebSocketConnect(Session session) {
    this.webSocketSession = session;
    listener.onOpen(this);
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

  private void backPressure() {
    try {
      lock.lock();
      while (!moreMessages) {
        // arbitrary timeout to make it clearer that messages are not being processed
        // - likely due to streams returned off of websocket not being read
        // the jetty thread pool won't throw an exception until we're at least 8k jobs behind
        // hopefully this will help avoid having to get a thread dump
        if (!backPressure.await(30, TimeUnit.SECONDS)) {
          throw new KubernetesClientException(
              "Jetty HttpClient thread is waiting too long for the consumption of previous websocket message");
        }
      }
      moreMessages = false;
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw KubernetesClientException.launderThrowable(e);
    } finally {
      lock.unlock();
    }
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
