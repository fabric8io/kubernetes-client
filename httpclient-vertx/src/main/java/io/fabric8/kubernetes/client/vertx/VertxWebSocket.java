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
import io.vertx.core.Future;
import io.vertx.core.buffer.Buffer;

import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

class VertxWebSocket implements WebSocket {

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
    ws.closeHandler(v -> listener.onClose(this, ws.closeStatusCode(), ws.closeReason()));
    ws.exceptionHandler(err -> listener.onError(this, err));
    listener.onOpen(this);
  }

  @Override
  public boolean send(ByteBuffer buffer) {
    Buffer vertxBuffer = Buffer.buffer(Unpooled.copiedBuffer(buffer));
    int len = vertxBuffer.length();
    pending.addAndGet(len);
    Future<Void> res = ws.writeBinaryMessage(vertxBuffer);
    res.onComplete(ignore -> pending.addAndGet(-len));
    return true;
  }

  @Override
  public boolean sendClose(int code, String reason) {
    ws.close((short) code, reason);
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
