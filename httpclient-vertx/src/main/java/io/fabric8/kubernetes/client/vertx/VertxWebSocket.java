package io.fabric8.kubernetes.client.vertx;

import io.fabric8.kubernetes.client.http.WebSocket;
import io.netty.buffer.Unpooled;
import io.vertx.core.Future;
import io.vertx.core.buffer.Buffer;

import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

class VertxWebSocket implements WebSocket {

  private io.vertx.core.http.WebSocket ws;
  private final AtomicInteger pending = new AtomicInteger();
  private final Listener listener;

  VertxWebSocket(io.vertx.core.http.WebSocket ws, Listener listener) {
    this.ws = ws;
    this.listener = listener;
  }

  void init() {
    ws.binaryMessageHandler(msg -> {
      listener.onMessage(this, msg.getByteBuf().nioBuffer());
      ws.pause();
    });
    ws.textMessageHandler(msg -> {
      listener.onMessage(this, msg);
      ws.pause();
    });
    ws.closeHandler(v -> listener.onClose(this, ws.closeStatusCode(), ws.closeReason()));
    ws.exceptionHandler(err -> listener.onError(this, err));
    listener.onOpen(this);
  }

  @Override
  public boolean send(ByteBuffer buffer) {
    Buffer vertxBuffer = Buffer.buffer(Unpooled.copiedBuffer(buffer));
    int len = vertxBuffer.length();
    pending.addAndGet(len);
    Future<Void> res = ws.writeBinaryMessage(vertxBuffer);
    res.onComplete(ignore -> pending.addAndGet(-len));
    return true;
  }

  @Override
  public boolean sendClose(int code, String reason) {
    ws.close((short) code, reason);
    return true;
  }

  @Override
  public long queueSize() {
    return pending.get();
  }

  @Override
  public void request() {
    ws.fetch(1);
  }
}