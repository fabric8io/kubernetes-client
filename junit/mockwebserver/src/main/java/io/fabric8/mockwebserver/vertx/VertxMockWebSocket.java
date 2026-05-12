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
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.ServerWebSocket;

import java.util.logging.Level;
import java.util.logging.Logger;

public class VertxMockWebSocket implements WebSocket {

  private static final Logger logger = Logger.getLogger(VertxMockWebSocket.class.getName());

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
    final String wsId = Integer.toHexString(System.identityHashCode(webSocket));
    logger.log(Level.INFO, () -> String.format(
        "VertxMockWebSocket.writeTextMessage entered (ws=%s, length=%d)", wsId, text.length()));
    final Future<Void> send = webSocket.writeTextMessage(text);
    // Diagnostic for #7756: writeTextMessage completes asynchronously. Logging both outcomes makes
    // the "future never completed" case distinguishable from "succeeded" or "failed" — silence
    // after the entry log now strictly means the future never settled.
    send.onSuccess(v -> logger.log(Level.INFO,
        () -> String.format("VertxMockWebSocket.writeTextMessage succeeded (ws=%s, length=%d)", wsId, text.length())));
    send.onFailure(t -> logger.log(Level.SEVERE, t,
        () -> String.format("VertxMockWebSocket.writeTextMessage future failed (ws=%s, length=%d)", wsId, text.length())));
    if (send.isComplete()) {
      return send.succeeded();
    }
    return true;
  }

  @Override
  public boolean send(byte[] bytes) {
    final String wsId = Integer.toHexString(System.identityHashCode(webSocket));
    logger.log(Level.INFO, () -> String.format(
        "VertxMockWebSocket.writeBinaryMessage entered (ws=%s, length=%d)", wsId, bytes.length));
    final Future<Void> send = webSocket.writeBinaryMessage(Buffer.buffer(bytes));
    // Diagnostic for #7756: see send(String) above.
    send.onSuccess(v -> logger.log(Level.INFO,
        () -> String.format("VertxMockWebSocket.writeBinaryMessage succeeded (ws=%s, length=%d)", wsId, bytes.length)));
    send.onFailure(t -> logger.log(Level.SEVERE, t,
        () -> String.format("VertxMockWebSocket.writeBinaryMessage future failed (ws=%s, length=%d)", wsId, bytes.length)));
    if (send.isComplete()) {
      return send.succeeded();
    }
    return true;
  }

  @Override
  public synchronized boolean close(int code, String reason) {
    if (!closing) {
      closing = true;
      final String wsId = Integer.toHexString(System.identityHashCode(webSocket));
      logger.log(Level.INFO, () -> String.format(
          "VertxMockWebSocket.close entered (ws=%s, code=%d, reason=%s)", wsId, code, reason));
      // Diagnostic for #7756: capture both close outcomes (success vs ClosedChannelException) so we
      // can correlate with the matching writeBinaryMessage / writeTextMessage result on the same ws.
      final Future<Void> closeFuture = webSocket.close((short) code, reason);
      closeFuture.onSuccess(v -> logger.log(Level.INFO,
          () -> String.format("VertxMockWebSocket.close succeeded (ws=%s, code=%d, reason=%s)", wsId, code, reason)));
      closeFuture.onFailure(t -> logger.log(Level.SEVERE, t,
          () -> String.format("VertxMockWebSocket.close future failed (ws=%s, code=%d, reason=%s)", wsId, code, reason)));
    }
    return true;
  }
}
