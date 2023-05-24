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

package io.fabric8.kubernetes.client.http;

import java.util.Objects;

/*
 * manusa: We may be able to remove this class and replace with separate WebSocketUpgradeResponse|WebSocketHandshakeException handled by the future
 * but we can't yet as there isn't a composable form of handle
 */
public class WebSocketResponse {
  final WebSocketUpgradeResponse webSocketUpgradeResponse;
  final Throwable throwable;
  final WebSocket webSocket;

  public WebSocketResponse(WebSocketUpgradeResponse webSocketUpgradeResponse, Throwable throwable) {
    this.webSocketUpgradeResponse = Objects.requireNonNull(webSocketUpgradeResponse);
    this.throwable = Objects.requireNonNull(throwable);
    this.webSocket = null;
  }

  public WebSocketResponse(WebSocketUpgradeResponse webSocketUpgradeResponse, WebSocket webSocket) {
    this.webSocketUpgradeResponse = Objects.requireNonNull(webSocketUpgradeResponse);
    this.webSocket = Objects.requireNonNull(webSocket);
    this.throwable = null;
  }

}
