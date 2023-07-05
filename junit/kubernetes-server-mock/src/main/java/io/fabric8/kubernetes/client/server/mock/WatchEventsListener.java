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
package io.fabric8.kubernetes.client.server.mock;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.api.model.WatchEvent;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.mockwebserver.Context;
import io.fabric8.mockwebserver.crud.AttributeSet;
import io.fabric8.mockwebserver.internal.WebSocketMessage;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import org.slf4j.Logger;

import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

class WatchEventsListener extends WebSocketListener {
  private final AtomicReference<WebSocket> webSocketRef = new AtomicReference<>();
  private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
  private final AttributeSet attributeSet;
  private final Context context;
  private final Set<WatchEventsListener> watchEventListenerList;
  private final Logger logger;
  private final Consumer<WatchEventsListener> onOpenAction;

  public WatchEventsListener(Context context, AttributeSet attributeSet, final Set<WatchEventsListener> watchEventListenerList,
      Logger logger, Consumer<WatchEventsListener> onOpenAction) {
    this.logger = logger;
    this.context = context;
    this.attributeSet = attributeSet;
    this.watchEventListenerList = watchEventListenerList;
    this.onOpenAction = onOpenAction;
  }

  public boolean attributeMatches(AttributeSet set) {
    return set.matches(attributeSet);
  }

  @Override
  public void onOpen(WebSocket webSocket, Response response) {
    webSocketRef.set(webSocket);
    onOpenAction.accept(this);
  }

  @Override
  public void onClosing(WebSocket webSocket, int code, String reason) {
    webSocketRef.get().close(code, reason);
  }

  @Override
  public void onClosed(WebSocket webSocket, int code, String reason) {
    if (webSocketRef.get() != null) {
      webSocketRef.get().close(code, reason);
    }
    executor.shutdown();
    try {
      executor.awaitTermination(1, TimeUnit.MINUTES);
    } catch (InterruptedException e) {
      logger.debug("Interrupted waiting for the executor service to shutdown: {}", e.getMessage());
      Thread.currentThread().interrupt();
    }
    watchEventListenerList.remove(this);
  }

  @Override
  public void onFailure(WebSocket webSocket, Throwable t, Response response) {
    webSocket.close(1000, t.getMessage());
    executor.shutdown();
    try {
      executor.awaitTermination(1, TimeUnit.MINUTES);
    } catch (InterruptedException e) {
      logger.debug("Interrupted waiting for the executor service to shutdown: {}", e.getMessage());
      Thread.currentThread().interrupt();
    }
    watchEventListenerList.remove(this);
  }

  public void sendWebSocketResponse(String object, Watcher.Action action) {
    WebSocketMessage message = toWebSocketMessage(context,
        new WatchEvent(Serialization.unmarshal(object, GenericKubernetesResource.class), action.name()));
    executor.schedule(() -> webSocketRef.get().send(message.getBody()), message.getDelay(), TimeUnit.SECONDS);
  }

  private static WebSocketMessage toWebSocketMessage(Context context, Object content) {
    return toWebSocketMessage(context, content, true);
  }

  private static WebSocketMessage toWebSocketMessage(Context context, Object content, Boolean toBeRemoved) {
    return toWebSocketMessage(context, 0L, content, toBeRemoved);
  }

  private static WebSocketMessage toWebSocketMessage(Context context, Long delay, Object content, Boolean toBeRemoved) {
    if (content instanceof String) {
      return new WebSocketMessage(delay, (String) content, toBeRemoved);
    } else if (content instanceof WebSocketMessage) {
      return (WebSocketMessage) content;
    } else {
      try {
        return toWebSocketMessage(context, delay, context.getMapper().writeValueAsString(content), toBeRemoved);
      } catch (JsonProcessingException e) {
        throw new IllegalArgumentException(e);
      }
    }
  }
}
