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
import io.fabric8.mockwebserver.http.Response;
import io.fabric8.mockwebserver.http.WebSocketListener;
import io.vertx.core.Handler;
import io.vertx.core.http.ServerWebSocket;

public class ServerWebSocketHandler implements Handler<ServerWebSocket> {

  private static final int WEBSOCKET_CLOSE_CODE_SERVER_ERROR = 1011;

  private final RecordedRequest request;
  private final Response response;

  public ServerWebSocketHandler(RecordedRequest request, Response response) {
    this.request = request;
    this.response = response;
  }

  @Override
  public void handle(ServerWebSocket serverWebSocket) {
    final WebSocketListener wsListener = response.getWebSocketListener();
    final VertxMockWebSocket mockWebSocket = new VertxMockWebSocket(request, serverWebSocket);
    // Important to call onBeforeAccept before configuring so that WebSockets get registered by dispatchers, handlers, and so on
    wsListener.onBeforeAccept(mockWebSocket, response);
    configureWebSocket(serverWebSocket, mockWebSocket, wsListener);
    wsListener.onOpen(mockWebSocket, response);
    serverWebSocket.fetch(1);
  }

  public void configureWebSocket(ServerWebSocket serverWebSocket, VertxMockWebSocket mockWebSocket,
      WebSocketListener wsListener) {
    serverWebSocket.textMessageHandler(text -> {
      wsListener.onMessage(mockWebSocket, text);
      serverWebSocket.fetch(1);
    });
    serverWebSocket.binaryMessageHandler(buff -> {
      wsListener.onMessage(mockWebSocket, buff.getBytes());
      serverWebSocket.fetch(1);
    });
    serverWebSocket.frameHandler(frame -> {
      if (frame.isClose()) {
        wsListener.onClosing(mockWebSocket, frame.closeStatusCode(), frame.closeReason());
      }
      serverWebSocket.fetch(1);
    });
    // use end, not close, because close is processed immediately vs. end is in frame order
    serverWebSocket.endHandler(v -> wsListener.onClosed(
        mockWebSocket,
        serverWebSocket.closeStatusCode() == null ? WEBSOCKET_CLOSE_CODE_SERVER_ERROR
            : serverWebSocket.closeStatusCode(),
        serverWebSocket.closeReason()));
    serverWebSocket.exceptionHandler(err -> wsListener.onFailure(mockWebSocket, err, response));
  }
}
