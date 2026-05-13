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
package io.fabric8.mockwebserver.vertx;

import io.fabric8.mockwebserver.http.RecordedRequest;
import io.fabric8.mockwebserver.http.WebSocket;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.ServerWebSocket;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VertxMockWebSocket implements WebSocket {

  private static final Logger logger = Logger.getLogger(VertxMockWebSocket.class.getName());

  // Bound for the worst-case wait when a write Future is still pending on return.
  // Writes here are localhost-only and bounded by the test message size (kB-MB), so
  // 30s is generous enough to absorb CI scheduling jitter without ever masking a real
  // hang inside Vert.x.
  private static final long WRITE_AWAIT_SECONDS = 30L;

  private final RecordedRequest request;
  private final ServerWebSocket webSocket;
  private volatile boolean closing;

  public VertxMockWebSocket(RecordedRequest request, ServerWebSocket webSocket) {
    this.request = request;
    this.webSocket = webSocket;
    closing = false;
  }

  @Override
  public RecordedRequest request() {
    return request;
  }

  @Override
  public boolean send(String text) {
    return awaitWrite(webSocket.writeTextMessage(text));
  }

  @Override
  public boolean send(byte[] bytes) {
    return awaitWrite(webSocket.writeBinaryMessage(Buffer.buffer(bytes)));
  }

  // Block the calling thread until the Vert.x write Future completes. WebSocketSession
  // calls this from its dedicated executor and triggers closeActiveSocketsIfApplicable()
  // immediately afterwards; if we return while a multi-frame write is still in flight,
  // the close races the trailing frames and the client never receives them (#7775).
  // When the caller is itself on a Vert.x context (e.g. a custom WebSocketListener
  // handling onMessage), we can't block — the same event loop has to drive the write to
  // completion — so we fall through to fire-and-forget.
  private static boolean awaitWrite(Future<Void> send) {
    if (send.isComplete()) {
      return send.succeeded();
    }
    if (Vertx.currentContext() != null) {
      // TODO(#7775): a custom WebSocketListener.onMessage that re-enters send is still
      // exposed to the original close/write race because we can't block the very event
      // loop that has to drive the Future to completion. No known caller hits this today.
      return true;
    }
    try {
      send.toCompletionStage().toCompletableFuture().get(WRITE_AWAIT_SECONDS, TimeUnit.SECONDS);
      return true;
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      return false;
    } catch (TimeoutException e) {
      // 30s without a Vert.x write completion is a hang inside Vert.x/Netty, not a normal
      // path. Log it so a future flake doesn't surface only as "client never received the
      // message" downstream.
      logger.log(Level.WARNING, e,
          () -> String.format("VertxMockWebSocket write did not complete within %ds", WRITE_AWAIT_SECONDS));
      return false;
    } catch (ExecutionException e) {
      return false;
    }
  }

  @Override
  public synchronized boolean close(int code, String reason) {
    if (!closing) {
      closing = true;
      webSocket.close((short) code, reason);
    }
    return true;
  }
}
