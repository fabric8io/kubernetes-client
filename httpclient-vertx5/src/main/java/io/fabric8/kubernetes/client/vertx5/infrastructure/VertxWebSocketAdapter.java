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
package io.fabric8.kubernetes.client.vertx5.infrastructure;

import io.fabric8.kubernetes.client.http.WebSocket;
import io.vertx.core.Future;
import io.vertx.core.buffer.Buffer;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

@RequiredArgsConstructor
public final class VertxWebSocketAdapter implements WebSocket {

  private static final Logger LOG = LoggerFactory.getLogger(VertxWebSocketAdapter.class);

  @NonNull
  private final io.vertx.core.http.WebSocket vertxWebSocket;
  private final AtomicInteger pending = new AtomicInteger();

  @Override
  public boolean send(@NonNull final ByteBuffer buffer) {
    final byte[] bytes = new byte[buffer.remaining()];
    buffer.get(bytes);
    final Buffer vertxBuffer = Buffer.buffer(bytes);
    final int len = vertxBuffer.length();
    pending.addAndGet(len);

    final Future<Void> result = vertxWebSocket.writeBinaryMessage(vertxBuffer);
    if (result.isComplete()) {
      pending.addAndGet(-len);
      return result.succeeded();
    }

    result.onComplete(asyncResult -> {
      if (asyncResult.failed()) {
        LOG.error("Queued write did not succeed", asyncResult.cause());
      }
      pending.addAndGet(-len);
    });

    return true;
  }

  @Override
  public synchronized boolean sendClose(final int code, final String reason) {
    if (vertxWebSocket.isClosed()) {
      return false;
    }

    final Future<Void> result = vertxWebSocket.close((short) code, reason);
    result.onComplete(asyncResult -> {
      vertxWebSocket.fetch(1);
      if (asyncResult.failed()) {
        LOG.error("Queued close did not succeed", asyncResult.cause());
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
    vertxWebSocket.fetch(1);
  }
}