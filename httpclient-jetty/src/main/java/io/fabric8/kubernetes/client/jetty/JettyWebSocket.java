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
import io.fabric8.kubernetes.client.http.WebSocket;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.WebSocketListener;
import org.eclipse.jetty.websocket.api.WriteCallback;

import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class JettyWebSocket implements WebSocket, WebSocketListener {
  private final WebSocket.Listener listener;
  private final AtomicLong sendQueue;
  private final Lock lock;
  private final Condition backPressure;
  private final AtomicBoolean closed;
  private boolean moreMessages;
  private Session webSocketSession;

  public JettyWebSocket(WebSocket.Listener listener) {
    this.listener = listener;
    sendQueue = new AtomicLong();
    lock = new ReentrantLock();
    backPressure = lock.newCondition();
    closed = new AtomicBoolean();
    moreMessages = true;
  }

  @Override
  public boolean send(ByteBuffer buffer) {
    if (closed.get() || !webSocketSession.isOpen()) {
      return false;
    }
    final int size = buffer.remaining();
    sendQueue.addAndGet(size);
    webSocketSession.getRemote().sendBytes(buffer, new WriteCallback() {
      @Override
      public void writeFailed(Throwable x) {
        sendQueue.addAndGet(-size);
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
    if (webSocketSession.isOpen() && !closed.getAndSet(true)) {
      webSocketSession.close(code, reason);
      return true;
    }
    return false;
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
    closed.set(true);
    listener.onClose(this, statusCode, reason);
  }

  @Override
  public void onWebSocketConnect(Session session) {
    listener.onOpen(this);
  }

  @Override
  public void onWebSocketError(Throwable cause) {
    if (cause instanceof ClosedChannelException && closed.get()) {
      // TODO: Check better
      //  It appears to be a race condition in Jetty:
      // - The server sends a close frame (but we haven't received it)
      // - Client enqueues a sendClose -> webSocketSession.close(code, reason)
      // - Jetty/client receives the  remote close -> onWebSocketClose
      // - Jetty sends the enqueued close frame, but the socket was already closed in the previous step
      // - Jetty throws a ClosedChannelException
      return;
    }
    listener.onError(this, cause);
  }

  public JettyWebSocket setWebSocketSession(Session webSocketSession) {
    this.webSocketSession = webSocketSession;
    return this;
  }

  private void backPressure() {
    try {
      lock.lock();
      while (!moreMessages) {
        backPressure.await();
      }
      moreMessages = false;
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw KubernetesClientException.launderThrowable(e);
    } finally {
      lock.unlock();
    }
  }
}
