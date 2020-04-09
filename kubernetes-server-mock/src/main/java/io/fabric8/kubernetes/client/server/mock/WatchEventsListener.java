package io.fabric8.kubernetes.client.server.mock;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.fabric8.kubernetes.api.model.WatchEvent;
import io.fabric8.mockwebserver.Context;
import io.fabric8.mockwebserver.internal.WebSocketMessage;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

class WatchEventsListener extends WebSocketListener {
  private final AtomicReference<WebSocket> webSocketRef = new AtomicReference<>();
  private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
  private final Queue<WatchEvent> watchEventQueue = new ConcurrentLinkedQueue<>();
  private final Context context;

  public WatchEventsListener(Context context) {
    this.context = context;
  }
  @Override
  public void onOpen(WebSocket webSocket, Response response) {
    webSocketRef.set(webSocket);
  }

  @Override
  public void onMessage(WebSocket webSocket, String text) {
    send(watchEventQueue, text);
  }

  @Override
  public void onMessage(WebSocket webSocket, ByteString bytes) {
    onMessage(webSocket, bytes.utf8());
  }

  @Override
  public void onClosing(WebSocket webSocket, int code, String reason) {
    super.onClosing(webSocket, code, reason);
    webSocketRef.get().close(code, reason);
  }

  private void send(Queue<WatchEvent> queue, String in) {
    if (queue != null && !queue.isEmpty()) {
      WatchEvent event = queue.poll();
      send(toWebSocketMessage(0L, event, true));
    } else {
      webSocketRef.get().close(1002, "Unexpected message:" + in);
    }
  }

  private void send(final WebSocketMessage message) {
    executor.schedule(new Runnable() {
      @Override
      public void run() {
        WebSocket ws = webSocketRef.get();
        if (ws != null) {
          if (message.isBinary()) {
            ws.send(ByteString.of(message.getBytes()));
          } else {
            ws.send(message.getBody());
          }
        }
      }
    }, message.getDelay(), TimeUnit.MILLISECONDS);
  }


  private WebSocketMessage toWebSocketMessage(Long delay, Object content, Boolean toBeRemoved) {
    if (content instanceof String) {
      return new WebSocketMessage(delay, (String) content, toBeRemoved);
    } else if (content instanceof WebSocketMessage) {
      return (WebSocketMessage) content;
    } else {
      try {
        return toWebSocketMessage(delay, context.getMapper().writeValueAsString(content), toBeRemoved);
      } catch (JsonProcessingException e) {
        throw new RuntimeException(e);
      }
    }
  }

  public Queue<WatchEvent> getEventQueue() {
    return watchEventQueue;
  }
}
