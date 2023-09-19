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

package io.fabric8.mockwebserver.internal;

import io.fabric8.mockwebserver.MockServerException;
import io.fabric8.mockwebserver.dsl.HttpMethod;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.mockwebserver.RecordedRequest;
import okio.ByteString;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class WebSocketSession extends WebSocketListener {

  private final List<WebSocketMessage> open;
  private final WebSocketMessage failure;
  private final Exception cause;

  private final Collection<WebSocket> activeSockets = ConcurrentHashMap.newKeySet();
  private final Collection<UUID> pendingMessages = ConcurrentHashMap.newKeySet();
  private final Map<Object, Queue<WebSocketMessage>> requestEvents = new HashMap<>();
  private final Map<Object, Queue<WebSocketMessage>> sentWebSocketMessagesRequestEvents = new HashMap<>();
  private final Map<SimpleRequest, Queue<WebSocketMessage>> httpRequestEvents = new HashMap<>();
  private final List<WebSocketMessage> timedEvents = new ArrayList<>();

  private final ScheduledExecutorService executor;

  public WebSocketSession(List<WebSocketMessage> open, WebSocketMessage failure, Exception cause) {
    this.open = open;
    this.failure = failure;
    this.cause = cause;
    this.executor = Executors.newScheduledThreadPool(1);
  }

  @Override
  public void onClosing(WebSocket webSocket, int code, String reason) {
    webSocket.close(code, reason);
  }

  @Override
  public void onOpen(WebSocket webSocket, Response response) {
    activeSockets.add(webSocket);
    //Schedule all timed events
    for (WebSocketMessage msg : open) {
      send(webSocket, msg);
    }

    for (WebSocketMessage msg : timedEvents) {
      send(webSocket, msg);
    }
    closeActiveSocketsIfApplicable();
  }

  @Override
  public void onMessage(WebSocket webSocket, ByteString bytes) {
    onMessage(webSocket, bytes.utf8());
  }

  @Override
  public void onMessage(WebSocket webSocket, String in) {
    Queue<WebSocketMessage> queue = requestEvents.get(in);
    send(webSocket, queue, in);
  }

  @Override
  public void onClosed(WebSocket webSocket, int code, String reason) {
    activeSockets.remove(webSocket);
  }

  private void send(WebSocket ws, Queue<WebSocketMessage> queue, String in) {
    if (queue != null && !queue.isEmpty()) {
      WebSocketMessage msg = queue.peek();
      send(ws, msg);
      if (msg.isToBeRemoved()) {
        queue.remove();
      }
      checkIfShouldSendAgain(ws, msg);
    } else {
      ws.close(1002, "Unexpected message:" + in);
    }
  }

  private void checkIfShouldSendAgain(WebSocket ws, WebSocketMessage msg) {
    String text = msg.isBinary() ? ByteString.of(msg.getBytes()).utf8() : msg.getBody();
    if (sentWebSocketMessagesRequestEvents.containsKey(text)) {
      Queue<WebSocketMessage> queue = sentWebSocketMessagesRequestEvents.get(text);
      send(ws, queue, text);
    }
  }

  public void dispatch(RecordedRequest request) {
    HttpMethod method = HttpMethod.valueOf(request.getMethod());
    String path = request.getPath();
    SimpleRequest key = new SimpleRequest(method, path);
    SimpleRequest keyForAnyMethod = new SimpleRequest(path);
    if (httpRequestEvents.containsKey(key)) {
      Queue<WebSocketMessage> queue = httpRequestEvents.get(key);
      activeSockets.forEach(ws -> send(ws, queue, "from http " + path));
    } else if (httpRequestEvents.containsKey(keyForAnyMethod)) {
      Queue<WebSocketMessage> queue = httpRequestEvents.get(keyForAnyMethod);
      activeSockets.forEach(ws -> send(ws, queue, "from http " + path));
    }
  }

  public List<WebSocketMessage> getOpen() {
    return open;
  }

  public WebSocketMessage getFailure() {
    return failure;
  }

  public Exception getCause() {
    return cause;
  }

  public Map<Object, Queue<WebSocketMessage>> getRequestEvents() {
    return requestEvents;
  }

  public List<WebSocketMessage> getTimedEvents() {
    return timedEvents;
  }

  public Map<Object, Queue<WebSocketMessage>> getSentWebSocketMessagesRequestEvents() {
    return sentWebSocketMessagesRequestEvents;
  }

  public Map<SimpleRequest, Queue<WebSocketMessage>> getHttpRequestEvents() {
    return httpRequestEvents;
  }

  private void send(final WebSocket ws, final WebSocketMessage message) {
    final UUID id = UUID.randomUUID();
    pendingMessages.add(id);
    executor.schedule(() -> {
      if (ws != null) {
        if (message.isBinary()) {
          ws.send(ByteString.of(message.getBytes()));
        } else {
          ws.send(message.getBody());
        }
        pendingMessages.remove(id);
      }
      closeActiveSocketsIfApplicable();
    }, message.getDelay(), TimeUnit.MILLISECONDS);
  }

  public void closeActiveSocketsIfApplicable() {
    if (pendingMessages.isEmpty() && requestEvents.isEmpty() && httpRequestEvents.isEmpty()
        && sentWebSocketMessagesRequestEvents.isEmpty()) {
      activeSockets.forEach(ws -> ws.close(1000, "Closing..."));
    }
  }

  public void shutdown() {
    try {
      executor.shutdown();
      if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
        executor.shutdownNow();
      }
    } catch (InterruptedException e) {
      throw MockServerException.launderThrowable(e);
    }
  }
}
