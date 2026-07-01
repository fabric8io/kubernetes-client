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
package io.fabric8.kubernetes.client.server.mock;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.api.model.WatchEvent;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.mockwebserver.Context;
import io.fabric8.mockwebserver.crud.AttributeSet;
import io.fabric8.mockwebserver.http.Response;
import io.fabric8.mockwebserver.http.WebSocket;
import io.fabric8.mockwebserver.http.WebSocketListener;
import io.fabric8.mockwebserver.internal.WebSocketMessage;
import org.slf4j.Logger;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
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
  // Guards open and pendingMessages so the buffer-vs-drain handoff in onOpen is atomic
  // with respect to concurrent sendWebSocketResponse calls (#7867).
  private final Object sendLock = new Object();
  // false until onOpen has populated webSocketRef. While false, outgoing events are
  // buffered instead of scheduled: a scheduled task would otherwise dereference a null
  // webSocketRef and the resulting NPE would be silently swallowed by the executor,
  // dropping the event.
  private boolean open;
  private final Queue<WebSocketMessage> pendingMessages = new ArrayDeque<>();

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
    final List<WebSocketMessage> buffered;
    synchronized (sendLock) {
      open = true;
      buffered = new ArrayList<>(pendingMessages);
      pendingMessages.clear();
    }
    // Run the initial-sync action first so the watcher observes the initial ADDED events
    // ahead of anything that was buffered during the open-race window.
    onOpenAction.accept(this);
    // Replay events that arrived before the WebSocket was available (#7867). Scheduling
    // them after the initial sync preserves the ADDED-before-MODIFIED ordering on the
    // single-threaded executor.
    buffered.forEach(this::scheduleSend);
  }

  @Override
  public void onClosing(WebSocket webSocket, int code, String reason) {
    // Queue the close behind any pending sends so events scheduled before the
    // client-initiated WebSocket close are not lost when the Vert.x event loop
    // processes the close ahead of the executor draining its queue (#7857).
    try {
      executor.schedule(() -> {
        WebSocket ws = webSocketRef.get();
        if (ws != null) {
          ws.close(code, reason);
        }
      }, 0L, TimeUnit.SECONDS);
    } catch (RejectedExecutionException e) {
      // Executor already shut down by an earlier onClosed/onFailure; the socket is
      // gone and any pending events have been drained or dropped. Mirrors the
      // defensive pattern in WebSocketSession#send (#7841).
      logger.debug("Skipping queued close: executor already shut down ({})", e.getMessage());
    }
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
    // Abnormal termination: transport is already broken, so deliberately do NOT
    // route the close through the executor (see onClosing). Any queued events
    // could not be delivered anyway.
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
    synchronized (sendLock) {
      if (!open) {
        // WebSocket not yet available: buffer the event until onOpen drains it, instead
        // of scheduling a send that would NPE on the null webSocketRef and be dropped (#7867).
        pendingMessages.add(message);
        return;
      }
    }
    scheduleSend(message);
  }

  private void scheduleSend(WebSocketMessage message) {
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
