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

package io.fabric8.kubernetes.client.jdkhttp;

import io.fabric8.kubernetes.client.http.BufferUtil;
import io.fabric8.kubernetes.client.http.WebSocket;
import io.fabric8.kubernetes.client.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

class JdkWebSocketImpl implements WebSocket, java.net.http.WebSocket.Listener {

  private static final Logger LOG = LoggerFactory.getLogger(JdkWebSocketImpl.class);

  private volatile java.net.http.WebSocket webSocket;
  private final AtomicLong queueSize = new AtomicLong();
  private final Listener listener;
  private final StringBuilder stringBuilder = new StringBuilder();
  private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
  private final WritableByteChannel byteChannel = Channels.newChannel(byteArrayOutputStream);
  private final CompletableFuture<Void> terminated = new CompletableFuture<>();

  public JdkWebSocketImpl(Listener listener) {
    this.listener = listener;
  }

  @Override
  public CompletionStage<?> onBinary(java.net.http.WebSocket webSocket, ByteBuffer data, boolean last) {
    try {
      byteChannel.write(data);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    if (last) {
      ByteBuffer value = ByteBuffer.wrap(byteArrayOutputStream.toByteArray());
      byteArrayOutputStream.reset();
      listener.onMessage(this, value);
    } else {
      webSocket.request(1);
    }
    return null;
  }

  @Override
  public CompletionStage<?> onText(java.net.http.WebSocket webSocket, CharSequence data, boolean last) {
    stringBuilder.append(data);
    if (last) {
      String value = stringBuilder.toString();
      stringBuilder.setLength(0);
      listener.onMessage(this, value);
    } else {
      webSocket.request(1);
    }
    return null;
  }

  @Override
  public CompletionStage<?> onClose(java.net.http.WebSocket webSocket, int statusCode, String reason) {
    terminated.complete(null);
    listener.onClose(this, statusCode, reason);
    return null; // should immediately initiate an implicit sendClose
  }

  @Override
  public void onError(java.net.http.WebSocket webSocket, Throwable error) {
    terminated.complete(null);
    listener.onError(this, error);
  }

  @Override
  public void onOpen(java.net.http.WebSocket webSocket) {
    this.webSocket = webSocket;
    webSocket.request(1);
    listener.onOpen(this);
  }

  @Override
  public boolean send(ByteBuffer buffer) {
    buffer = BufferUtil.copy(buffer);
    final int size = buffer.remaining();
    queueSize.addAndGet(size);
    CompletableFuture<java.net.http.WebSocket> cf = webSocket.sendBinary(buffer, true);
    if (cf.isDone()) {
      queueSize.addAndGet(-size);
      return !cf.isCompletedExceptionally();
    }
    cf.whenComplete((b, t) -> {
      if (t != null) {
        LOG.warn("Queued write did not succeed", t);
        abort();
      }
      queueSize.addAndGet(-size);
    });
    return true;
  }

  @Override
  public synchronized boolean sendClose(int code, String reason) {
    if (webSocket.isOutputClosed()) {
      return false;
    }
    CompletableFuture<java.net.http.WebSocket> cf = webSocket.sendClose(code, reason == null ? "Closing" : reason);
    cf = cf.whenComplete((w, t) -> {
      if (t != null) {
        LOG.warn("Queued close did not succeed", t);
        abort();
      } else if (w != null) {
        webSocket.request(1); // there may not be demand, so request more
        CompletableFuture<Void> future = Utils.schedule(Runnable::run, this::abort, 1, TimeUnit.MINUTES);
        terminated.whenComplete((v, ignored) -> future.cancel(true));
      }
    });
    return !cf.isCompletedExceptionally();
  }

  private void abort() {
    if (!webSocket.isOutputClosed() || !webSocket.isInputClosed()) {
      LOG.warn("Aborting WebSocket due to a write error or failure with sendClose");
      webSocket.abort();
      if (terminated.complete(null)) {
        listener.onClose(this, 1006, "Aborted the WebSocket");
      }
    }
  }

  @Override
  public long queueSize() {
    return queueSize.get();
  }

  @Override
  public void request() {
    this.webSocket.request(1);
  }

}
