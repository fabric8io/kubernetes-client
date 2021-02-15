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

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.api.model.ListOptions;
import io.fabric8.kubernetes.client.Watcher;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.WebSocket;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicReference;

/**
 * This class just replicates WatchConnectionManager in handling watch connections but
 * instead of using a solid type for deserializing events, it uses plain strings.
 *
 */
public class RawWatchConnectionManager extends AbstractWatchManager<String> {
  public RawWatchConnectionManager(OkHttpClient okHttpClient, HttpUrl.Builder watchUrlBuilder, ListOptions listOptions, ObjectMapper objectMapper, final Watcher<String> watcher, int reconnectLimit, int reconnectInterval, int maxIntervalExponent)  {
    super(watcher, listOptions, reconnectLimit, reconnectInterval, maxIntervalExponent, new RawRequestBuilder(watchUrlBuilder));
    
    initRunner(new WebSocketClientRunner<String>(okHttpClient) {
      @Override
      WatcherWebSocketListener<String> newListener(BlockingQueue<Object> queue, AtomicReference<WebSocket> webSocketRef) {
        return new RawWatcherWebSocketListener(RawWatchConnectionManager.this, queue, webSocketRef,  objectMapper);
      }
  
      @Override
      OkHttpClient cloneAndCustomize(OkHttpClient client) {
        return okHttpClient.newBuilder().build();
      }
    });
    runWatch();
  }
  
  private static class RawWatcherWebSocketListener extends WatcherWebSocketListener<String> {
    private final ObjectMapper objectMapper;
  
    public RawWatcherWebSocketListener(AbstractWatchManager<String> manager, BlockingQueue<Object> queue, AtomicReference<WebSocket> webSocketRef, ObjectMapper objectMapper) {
      super(manager, queue, webSocketRef);
      this.objectMapper = objectMapper;
    }
  
    @Override
    public void onMessage(WebSocket webSocket, String text) {
      try {
        Map<String, Object> watchEvent = objectMapper.readValue(text, HashMap.class);
      
        String watchEventType = watchEvent.get("type").toString();
        String watchObjectAsString = objectMapper.writeValueAsString(watchEvent.get("object"));
      
        manager.eventReceived(Watcher.Action.valueOf(watchEventType), watchObjectAsString);
      
      } catch (IOException exception) {
        logger.error("Failed to deserialize watch response: " + exception.getMessage());
      }
    }
  }
}
