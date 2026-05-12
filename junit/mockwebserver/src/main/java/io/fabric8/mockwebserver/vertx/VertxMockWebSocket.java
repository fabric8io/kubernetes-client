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
    final Future<Void> send = webSocket.writeTextMessage(text);
    // Diagnostic for #7756: writeTextMessage completes asynchronously; without an explicit failure
    // handler any async write error is silently dropped, which would leave the server believing the
    // message was delivered while the client never sees it. Log and swallow (preserve behavior).
    send.onFailure(t -> logger.log(Level.SEVERE, t,
        () -> String.format("VertxMockWebSocket.writeTextMessage future failed (ws=%s, length=%d)",
            Integer.toHexString(System.identityHashCode(webSocket)), text.length())));
    if (send.isComplete()) {
      return send.succeeded();
    }
    return true;
  }

  @Override
  public boolean send(byte[] bytes) {
    final Future<Void> send = webSocket.writeBinaryMessage(Buffer.buffer(bytes));
    // Diagnostic for #7756: see send(String) above.
    send.onFailure(t -> logger.log(Level.SEVERE, t,
        () -> String.format("VertxMockWebSocket.writeBinaryMessage future failed (ws=%s, length=%d)",
            Integer.toHexString(System.identityHashCode(webSocket)), bytes.length)));
    if (send.isComplete()) {
      return send.succeeded();
    }
    return true;
  }

  @Override
  public synchronized boolean close(int code, String reason) {
    if (!closing) {
      closing = true;
      // Diagnostic for #7756: capture async close failures (same rationale as send() above).
      webSocket.close((short) code, reason).onFailure(t -> logger.log(Level.SEVERE, t,
          () -> String.format("VertxMockWebSocket.close future failed (ws=%s, code=%d, reason=%s)",
              Integer.toHexString(System.identityHashCode(webSocket)), code, reason)));
    }
    return true;
  }
}
