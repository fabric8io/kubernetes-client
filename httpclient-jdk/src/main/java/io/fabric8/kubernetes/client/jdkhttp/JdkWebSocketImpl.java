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

package io.fabric8.kubernetes.client.jdkhttp;

import io.fabric8.kubernetes.client.http.WebSocket;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

class JdkWebSocketImpl implements WebSocket {

  static class BuilderImpl implements Builder {

    private JdkHttpClientImpl httpClientImpl;
    private java.net.http.HttpRequest.Builder builder;
    String subprotocol;

    public BuilderImpl(JdkHttpClientImpl jdkHttpClientImpl) {
      this(jdkHttpClientImpl, HttpRequest.newBuilder());
    }

    public BuilderImpl(JdkHttpClientImpl httpClientImpl, java.net.http.HttpRequest.Builder copy) {
      this.httpClientImpl = httpClientImpl;
      this.builder = copy;
    }

    @Override
    public CompletableFuture<WebSocket> buildAsync(Listener listener) {
      return httpClientImpl.buildAsync(this, listener);
    }

    @Override
    public Builder header(String name, String value) {
      builder.header(name, value);
      return this;
    }

    @Override
    public Builder setHeader(String k, String v) {
      builder.setHeader(k, v);
      return this;
    }

    @Override
    public Builder uri(URI uri) {
      builder.uri(uri);
      return this;
    }

    @Override
    public BuilderImpl subprotocol(String protocol) {
      this.subprotocol = protocol;
      return this;
    }

    public HttpRequest asRequest() {
      return this.builder.build();
    }

    public BuilderImpl copy() {
      return new BuilderImpl(httpClientImpl, builder.copy()).subprotocol(subprotocol);
    }

  }

  static final class ListenerAdapter implements java.net.http.WebSocket.Listener {

    private final Listener listener;
    private final AtomicLong queueSize;
    private final StringBuilder stringBuilder = new StringBuilder();
    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    private final WritableByteChannel byteChannel = Channels.newChannel(byteArrayOutputStream);

    ListenerAdapter(Listener listener, AtomicLong queueSize) {
      this.listener = listener;
      this.queueSize = queueSize;
    }

    @Override
    public CompletionStage<?> onBinary(java.net.http.WebSocket webSocket, ByteBuffer data, boolean last) {
      try {
        byteChannel.write(data);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
      webSocket.request(1);
      if (last) {
        ByteBuffer value = ByteBuffer.wrap(byteArrayOutputStream.toByteArray());
        byteArrayOutputStream.reset();
        listener.onMessage(new JdkWebSocketImpl(queueSize, webSocket), value);
      }
      return null;
    }

    @Override
    public CompletionStage<?> onText(java.net.http.WebSocket webSocket, CharSequence data, boolean last) {
      stringBuilder.append(data);
      webSocket.request(1);
      if (last) {
        String value = stringBuilder.toString();
        stringBuilder.setLength(0);
        listener.onMessage(new JdkWebSocketImpl(queueSize, webSocket), value);
      }
      return null;
    }

    @Override
    public CompletionStage<?> onClose(java.net.http.WebSocket webSocket, int statusCode, String reason) {
      listener.onClose(new JdkWebSocketImpl(queueSize, webSocket), statusCode, reason);
      return null;
    }

    @Override
    public void onError(java.net.http.WebSocket webSocket, Throwable error) {
      listener.onError(new JdkWebSocketImpl(queueSize, webSocket), error);
    }

    @Override
    public void onOpen(java.net.http.WebSocket webSocket) {
      webSocket.request(1);
      listener.onOpen(new JdkWebSocketImpl(queueSize, webSocket));
    }
  }

  private java.net.http.WebSocket webSocket;
  private AtomicLong queueSize;

  public JdkWebSocketImpl(AtomicLong queueSize, java.net.http.WebSocket webSocket) {
    this.queueSize = queueSize;
    this.webSocket = webSocket;
  }

  @Override
  public boolean send(ByteBuffer buffer) {
    final int size = buffer.remaining();
    queueSize.addAndGet(size);
    CompletableFuture<java.net.http.WebSocket> cf = webSocket.sendBinary(buffer, true);
    cf.whenComplete((b, t) -> queueSize.addAndGet(-size));
    return asBoolean(cf);
  }

  /**
   * If there is an illegalstateexception or other immediate failure, return
   * false, otherwise it should have been enqueued
   */
  private boolean asBoolean(CompletableFuture<java.net.http.WebSocket> cf) {
    try {
      cf.getNow(null);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  @Override
  public boolean sendClose(int code, String reason) {
    CompletableFuture<java.net.http.WebSocket> cf = webSocket.sendClose(code, reason == null ? "Closing" : reason);
    // matches the behavior of the okhttp implementation and will ensure input closure after 1 minute 
    cf.thenRunAsync(() -> webSocket.abort(), CompletableFuture.delayedExecutor(1, TimeUnit.MINUTES));
    return asBoolean(cf);
  }

  @Override
  public long queueSize() {
    return queueSize.get();
  }

}
