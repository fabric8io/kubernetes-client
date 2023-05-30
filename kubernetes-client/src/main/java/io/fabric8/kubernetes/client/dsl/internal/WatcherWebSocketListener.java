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
package io.fabric8.kubernetes.client.dsl.internal;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.client.dsl.internal.AbstractWatchManager.WatchRequestState;
import io.fabric8.kubernetes.client.http.WebSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

class WatcherWebSocketListener<T extends HasMetadata> implements WebSocket.Listener {
  protected static final Logger logger = LoggerFactory.getLogger(WatcherWebSocketListener.class);

  protected final WatchRequestState state;
  protected final AbstractWatchManager<T> manager;

  protected WatcherWebSocketListener(AbstractWatchManager<T> manager, WatchRequestState state) {
    this.manager = manager;
    this.state = state;
  }

  @Override
  public void onOpen(final WebSocket webSocket) {
    logger.debug("WebSocket successfully opened");
    manager.resetReconnectAttempts(state);
  }

  @Override
  public void onError(WebSocket webSocket, Throwable t) {
    manager.watchEnded(t, state);
  }

  @Override
  public void onMessage(WebSocket webSocket, String text) {
    try {
      manager.onMessage(text, state);
    } finally {
      webSocket.request();
    }
  }

  @Override
  public void onMessage(WebSocket webSocket, ByteBuffer bytes) {
    onMessage(webSocket, StandardCharsets.UTF_8.decode(bytes).toString());
  }

  @Override
  public void onClose(WebSocket webSocket, int code, String reason) {
    logger.debug("WebSocket close received. code: {}, reason: {}", code, reason);
    try {
      webSocket.sendClose(code, reason);
    } finally {
      manager.watchEnded(null, state);
    }
  }

}
