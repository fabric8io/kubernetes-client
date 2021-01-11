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

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import io.fabric8.kubernetes.client.utils.Utils;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;

abstract class WebSocketClientRunner<T> extends AbstractWatchManager.ClientRunner {
  private final AtomicReference<WebSocket> webSocketRef = new AtomicReference<>();
  private final BlockingQueue<Object> queue = new ArrayBlockingQueue<>(1);
  
  protected WebSocketClientRunner(OkHttpClient client) {
    super(client);
  }
  
  @Override
  public void run(Request request) {
    client().newWebSocket(request, newListener(queue, webSocketRef));
  }
  
  abstract WatcherWebSocketListener<T> newListener(BlockingQueue<Object> queue, AtomicReference<WebSocket> webSocketRef);
  
  @Override
  public void close() {
    AbstractWatchManager.closeWebSocket(webSocketRef.getAndSet(null));
  }
  
  @Override
  public void waitUntilReady() {
    Utils.waitUntilReady(queue, 10, TimeUnit.SECONDS);
  }
}
