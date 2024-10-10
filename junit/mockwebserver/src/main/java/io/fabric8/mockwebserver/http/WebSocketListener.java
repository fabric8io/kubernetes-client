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
package io.fabric8.mockwebserver.http;

public abstract class WebSocketListener {

  /**
   * Invoked before the web socket is accepted and the handshake is complete
   */
  public void onBeforeAccept(WebSocket webSocket, Response response) {
  }

  /**
   * Invoked when a web socket has been accepted by the remote peer and may begin transmitting
   * messages.
   */
  public void onOpen(WebSocket webSocket, Response response) {
  }

  public void onMessage(WebSocket webSocket, String text) {
  }

  /**
   * Compatibility layer for OkHttp.
   *
   * @deprecated use {@link #onMessage(WebSocket, byte[])} instead.
   */
  @Deprecated
  public void onMessage(WebSocket webSocket, ByteString bytes) {
  }

  public final void onMessage(WebSocket webSocket, byte[] bytes) {
    onMessage(webSocket, ByteString.of(bytes));
  }

  /**
   * Invoked when the remote peer has indicated that no more incoming messages will be
   * transmitted.
   */
  public void onClosing(WebSocket webSocket, int code, String reason) {
  }

  /**
   * Invoked when both peers have indicated that no more messages will be transmitted and the
   * connection has been successfully released. No further calls to this listener will be made.
   */
  public void onClosed(WebSocket webSocket, int code, String reason) {
  }

  /**
   * Invoked when a web socket has been closed due to an error reading from or writing to the
   * network. Both outgoing and incoming messages may have been lost. No further calls to this
   * listener will be made.
   */
  public void onFailure(WebSocket webSocket, Throwable error, Response response) {
  }
}
