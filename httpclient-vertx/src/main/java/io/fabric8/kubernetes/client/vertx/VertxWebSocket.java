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

package io.fabric8.kubernetes.client.vertx;

import io.fabric8.kubernetes.client.http.WebSocket;
import io.netty.buffer.Unpooled;
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

class VertxWebSocket implements WebSocket {

  private static final Logger LOG = LoggerFactory.getLogger(VertxWebSocket.class);

  private final io.vertx.core.http.WebSocket ws;
  private final AtomicInteger pending = new AtomicInteger();
  private final Listener listener;

  VertxWebSocket(io.vertx.core.http.WebSocket ws, Listener listener) {
    this.ws = ws;
    this.listener = listener;
  }

  void init() {
    ws.binaryMessageHandler(msg -> {
      ws.pause();
      listener.onMessage(this, msg.getByteBuf().nioBuffer());
    });
    ws.textMessageHandler(msg -> {
      ws.pause();
      listener.onMessage(this, msg);
    });
    // use end, not close, because close is processed immediately vs. end is in frame order
    ws.endHandler(v -> listener.onClose(this, ws.closeStatusCode(), ws.closeReason()));
    ws.exceptionHandler(err -> {
      try {
        if (err instanceof CorruptedWebSocketFrameException) {
          err = new ProtocolException().initCause(err);
        } else if (err instanceof HttpClosedException) {
          err = new IOException(err);
        }
        listener.onError(this, err);
      } finally {
        // onError should be terminal
        if (!ws.isClosed()) {
          ws.close();
        }
      }
    });
    listener.onOpen(this);
  }

  @Override
  public boolean send(ByteBuffer buffer) {
    Buffer vertxBuffer = Buffer.buffer(Unpooled.copiedBuffer(buffer));
    int len = vertxBuffer.length();
    pending.addAndGet(len);
    Future<Void> res = ws.writeBinaryMessage(vertxBuffer);
    if (res.isComplete()) {
      pending.addAndGet(-len);
      return res.succeeded();
    }
    res.onComplete(result -> {
      if (result.cause() != null) {
        LOG.error("Queued write did not succeed", result.cause());
      }
      pending.addAndGet(-len);
    });
    return true;
  }

  @Override
  public synchronized boolean sendClose(int code, String reason) {
    if (ws.isClosed()) {
      return false;
    }
    Future<Void> res = ws.close((short) code, reason);
    res.onComplete(result -> {
      ws.fetch(1);
      if (result.cause() != null) {
        LOG.error("Queued close did not succeed", result.cause());
      }
    });
    return true;
  }

  @Override
  public long queueSize() {
    return pending.get();
  }

  @Override
  public void request() {
    ws.fetch(1);
  }
}
