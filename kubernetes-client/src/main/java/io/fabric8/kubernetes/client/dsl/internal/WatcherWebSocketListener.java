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
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.WatcherException;
import io.fabric8.kubernetes.client.dsl.base.OperationSupport;
import io.fabric8.kubernetes.client.utils.Utils;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static java.net.HttpURLConnection.HTTP_OK;
import static java.net.HttpURLConnection.HTTP_UNAVAILABLE;

class WatcherWebSocketListener<T extends HasMetadata> extends WebSocketListener {
  protected static final Logger logger = LoggerFactory.getLogger(WatcherWebSocketListener.class);
  
  private final CompletableFuture<Void> startedFuture = new CompletableFuture<>();
  protected final AbstractWatchManager<T> manager;
  
  protected WatcherWebSocketListener(AbstractWatchManager<T> manager) {
    this.manager = manager;
  }
  
  @Override
  public void onOpen(final WebSocket webSocket, Response response) {
    WatchConnectionManager.closeBody(response);
    logger.debug("WebSocket successfully opened");
    manager.resetReconnectAttempts();
    startedFuture.complete(null);
  }
  
  @Override
  public void onFailure(WebSocket webSocket, Throwable t, Response response) {
    try {
      if (manager.isForceClosed()) {
        logger.debug("Ignoring onFailure for already closed/closing websocket", t);
        return;
      }
    
      if (response != null) {
        final int code = response.code();
        // We do not expect a 200 in response to the websocket connection. If it occurs, we throw
        // an exception and try the watch via a persistent HTTP Get.
        // Newer Kubernetes might also return 503 Service Unavailable in case WebSockets are not supported
        if (HTTP_OK == code || HTTP_UNAVAILABLE == code) {
          pushException(new KubernetesClientException("Received " + code + " on websocket", code, null));
          return;
        }
        Status status = OperationSupport.createStatus(response);
        logger.warn("Exec Failure: HTTP {}, Status: {} - {}", code, status.getCode(), status.getMessage());
        pushException(new KubernetesClientException(status));
      } else {
        logger.warn("Exec Failure {} {}", t.getClass().getName(), t.getMessage());
        pushException(new KubernetesClientException("Failed to start websocket", t));
      }
    } finally {
      WatchConnectionManager.closeBody(response);
    }
    
    if (manager.cannotReconnect()) {
      manager.close(new WatcherException("Connection failure", t));
      return;
    }
    
    manager.scheduleReconnect();
  }
  
  @Override
  public void onMessage(WebSocket webSocket, String text) {
    manager.onMessage(text);
  }
  
  private void pushException(KubernetesClientException exception) {
    if (!startedFuture.completeExceptionally(exception)) {
      logger.debug("Couldn't report exception", exception);
    }
  }
  
  @Override
  public void onMessage(WebSocket webSocket, ByteString bytes) {
    onMessage(webSocket, bytes.utf8());
  }
  
  @Override
  public void onClosing(WebSocket webSocket, int code, String reason) {
    logger.debug("Socket closing: {}", reason);
    webSocket.close(code, reason);
  }
  
  @Override
  public void onClosed(WebSocket webSocket, int code, String reason) {
    logger.debug("WebSocket close received. code: {}, reason: {}", code, reason);
    manager.scheduleReconnect();
  }
  
  protected void waitUntilReady() {
    Utils.waitUntilReadyOrFail(startedFuture, 10, TimeUnit.SECONDS);
  }
}
