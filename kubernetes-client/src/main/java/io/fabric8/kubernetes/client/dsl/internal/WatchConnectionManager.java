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
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.ListOptions;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.dsl.base.BaseOperation;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

/**
 * Manages a WebSocket and listener per request
 */
public class WatchConnectionManager<T extends HasMetadata, L extends KubernetesResourceList<T>> extends AbstractWatchManager<T> {
  
  private static final Logger logger = LoggerFactory.getLogger(WatchConnectionManager.class);
  
  protected WatcherWebSocketListener<T> listener;
  private WebSocket websocket;
  
  static void closeWebSocket(WebSocket webSocket) {
    if (webSocket != null) {
      logger.debug("Closing websocket {}", webSocket);
      try {
        if (!webSocket.close(1000, null)) {
          logger.debug("Websocket already closed {}", webSocket);
        }
      } catch (IllegalStateException e) {
        logger.error("invalid code for websocket: {} {}", e.getClass(), e.getMessage());
      }
    }
  }
  
  static void closeBody(Response response) {
    if (response != null && response.body() != null) {
      response.body().close();
    }
  }

  public WatchConnectionManager(final OkHttpClient client, final BaseOperation<T, L, ?> baseOperation, final ListOptions listOptions, final Watcher<T> watcher, final int reconnectInterval, final int reconnectLimit, long websocketTimeout, int maxIntervalExponent) throws MalformedURLException {
    super(watcher, baseOperation, listOptions, reconnectLimit, reconnectInterval, maxIntervalExponent, () -> client.newBuilder()
            .readTimeout(websocketTimeout, TimeUnit.MILLISECONDS)
            .build());
  }
  
  public WatchConnectionManager(final OkHttpClient client, final BaseOperation<T, L, ?> baseOperation, final ListOptions listOptions, final Watcher<T> watcher, final int reconnectInterval, final int reconnectLimit, long websocketTimeout) throws MalformedURLException {
    // Default max 32x slowdown from base interval
    this(client, baseOperation, listOptions, watcher, reconnectInterval, reconnectLimit, websocketTimeout, 5);
  }
  
  @Override
  protected synchronized void closeRequest() {
    closeWebSocket(websocket);
    websocket = null;
  }

  public void waitUntilReady() {
    getListener().waitUntilReady(this.client.readTimeoutMillis());
  }

  synchronized WatcherWebSocketListener<T> getListener() {
    return listener;
  }

  @Override
  protected synchronized void run(Request request) {
    this.listener = new WatcherWebSocketListener<>(this);
    this.websocket = client.newWebSocket(request, this.listener);    
  }

}
