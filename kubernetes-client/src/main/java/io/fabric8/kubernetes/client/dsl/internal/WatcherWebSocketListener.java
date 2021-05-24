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

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.WatcherException;
import io.fabric8.kubernetes.client.dsl.base.OperationSupport;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.net.HttpURLConnection.HTTP_OK;
import static java.net.HttpURLConnection.HTTP_UNAVAILABLE;

abstract class WatcherWebSocketListener<T> extends WebSocketListener {
  protected static final Logger logger = LoggerFactory.getLogger(WatcherWebSocketListener.class);
  
  protected final AtomicReference<WebSocket> webSocketRef;
  /**
   * True if an onOpen callback was received on the first connect attempt, ie. the watch was successfully started.
   */
  private final AtomicBoolean started = new AtomicBoolean(false);

  /**
   * Blocking queue for startup exceptions.
   */
  private final BlockingQueue<Object> queue;
  protected final AbstractWatchManager<T> manager;
  
  protected WatcherWebSocketListener(AbstractWatchManager<T> manager, BlockingQueue<Object> queue, AtomicReference<WebSocket> webSocketRef) {
    this.manager = manager;
    this.queue = queue;
    this.webSocketRef = webSocketRef;
  }
  
  @Override
  public void onOpen(final WebSocket webSocket, Response response) {
    if (response != null && response.body() != null) {
      response.body().close();
    }
    logger.debug("WebSocket successfully opened");
    webSocketRef.set(webSocket);
    manager.resetReconnectAttempts();
    started.set(true);
    queue.clear();
    queue.add(true);
  }
  
  @Override
  public void onFailure(WebSocket webSocket, Throwable t, Response response) {
    if (manager.isForceClosed()) {
      logger.debug("Ignoring onFailure for already closed/closing websocket", t);
      // avoid resource leak though
      if (response != null && response.body() != null) {
        response.body().close();
      }
      return;
    }
  
    if (response != null) {
      final int code = response.code();
      // We do not expect a 200 in response to the websocket connection. If it occurs, we throw
      // an exception and try the watch via a persistent HTTP Get.
      // Newer Kubernetes might also return 503 Service Unavailable in case WebSockets are not supported
      if (HTTP_OK == code || HTTP_UNAVAILABLE == code) {
        pushException(new KubernetesClientException("Received " + code + " on websocket", code, null));
        closeBody(response);
        return;
      } else {
        // We only need to queue startup failures.
        Status status = OperationSupport.createStatus(response);
        closeBody(response);
        logger.warn("Exec Failure: HTTP {}, Status: {} - {}", code, status.getCode(), status.getMessage(), t);
        if (!started.get()) {
          pushException(new KubernetesClientException(status));
        }
      }
    } else {
      logger.warn("Exec Failure", t);
      if (!started.get()) {
        pushException(new KubernetesClientException("Failed to start websocket", t));
      }
    }
    
    if (manager.cannotReconnect()) {
      manager.closeEvent(new WatcherException("Connection failure", t));
      return;
    }
    
    scheduleReconnect();
  }
  
  private void pushException(KubernetesClientException exception) {
    queue.clear();
    if (!queue.offer(exception)) {
      logger.debug("Couldn't add exception {} to queue", exception.getLocalizedMessage());
    }
  }
  
  private void closeBody(Response response) {
    if (response.body() != null) {
      response.body().close();
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
    if (manager.isForceClosed()) {
      logger.debug("Ignoring onClose for already closed/closing websocket");
      return;
    }
    if (manager.cannotReconnect()) {
      manager.closeEvent(new WatcherException("Connection unexpectedly closed"));
      return;
    }
    scheduleReconnect();
  }
  
  private void scheduleReconnect() {
    webSocketRef.set(null);
    manager.scheduleReconnect(() -> {
      try {
        manager.runWatch();
      } catch (Exception e) {
        // An unexpected error occurred and we didn't even get an onFailure callback.
        logger.error("Exception in reconnect", e);
        webSocketRef.set(null);
        manager.closeEvent(new WatcherException("Unhandled exception in reconnect attempt", e));
        manager.close();
      }
    }, true);
  }
}
