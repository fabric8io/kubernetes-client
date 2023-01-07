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

package io.fabric8.kubernetes.client.okhttp;

import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.http.WebSocket;
import io.fabric8.kubernetes.client.http.WebSocketHandshakeException;
import io.fabric8.kubernetes.client.http.WebSocketResponse;
import io.fabric8.kubernetes.client.okhttp.OkHttpClientImpl.OkHttpResponseImpl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocketListener;
import okio.ByteString;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class OkHttpWebSocketImpl implements WebSocket {

  private okhttp3.WebSocket webSocket;
  private Runnable requestMethod;

  public OkHttpWebSocketImpl(okhttp3.WebSocket webSocket, Runnable requestMethod) {
    this.webSocket = webSocket;
    this.requestMethod = requestMethod;
  }

  @Override
  public boolean send(ByteBuffer buffer) {
    return webSocket.send(ByteString.of(buffer));
  }

  @Override
  public boolean sendClose(int code, String reason) {
    return webSocket.close(code, reason);
  }

  @Override
  public long queueSize() {
    return webSocket.queueSize();
  }

  @Override
  public void request() {
    requestMethod.run();
  }

  public static CompletableFuture<WebSocketResponse> buildAsync(OkHttpClient httpClient, Request request, Listener listener) {
    CompletableFuture<WebSocketResponse> future = new CompletableFuture<>();
    httpClient.newWebSocket(request, new WebSocketListener() {
      private volatile boolean opened;
      private boolean more = true;
      private ReentrantLock lock = new ReentrantLock();
      private Condition moreRequested = lock.newCondition();

      @Override
      public void onFailure(okhttp3.WebSocket webSocket, Throwable t, Response response) {
        if (response != null) {
          response.close();
        }
        if (!opened) {
          if (response != null) {
            try {
              future.complete(new WebSocketResponse(null,
                  // passing null as the type ensures that the response body is closed
                  new WebSocketHandshakeException(new OkHttpResponseImpl<>(response, null)).initCause(t)));
            } catch (IOException e) {
              // can't happen
            }
          } else {
            future.completeExceptionally(t);
          }
        } else {
          listener.onError(new OkHttpWebSocketImpl(webSocket, this::request), t);
        }
      }

      @Override
      public void onOpen(okhttp3.WebSocket webSocket, Response response) {
        opened = true;
        if (response != null) {
          response.close();
        }
        OkHttpWebSocketImpl value = new OkHttpWebSocketImpl(webSocket, this::request);
        listener.onOpen(value);
        future.complete(new WebSocketResponse(value, null));
      }

      @Override
      public void onMessage(okhttp3.WebSocket webSocket, ByteString bytes) {
        awaitMoreRequest();
        listener.onMessage(new OkHttpWebSocketImpl(webSocket, this::request), bytes.asByteBuffer());
      }

      @Override
      public void onMessage(okhttp3.WebSocket webSocket, String text) {
        awaitMoreRequest();
        listener.onMessage(new OkHttpWebSocketImpl(webSocket, this::request), text);
      }

      /**
       * To back pressure OkHttp, we need to hold the socket processing thread before
       * it delivers more results than expected
       */
      private void awaitMoreRequest() {
        lock.lock();
        try {
          while (!more) {
            // arbitrary timeout to make it clearer that messages are not being processed
            // - likely due to streams returned off of websocket not being read
            // by default okhttp seems to silently hang on thread exhaustion
            // hopefully this will help avoid having to get a thread dump
            if (!moreRequested.await(30, TimeUnit.SECONDS)) {
              throw new KubernetesClientException(
                  "OkHttp HttpClient thread is waiting too long for the consumption of previous websocket message");
            }
          }
          more = false;
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
          throw KubernetesClientException.launderThrowable(e);
        } finally {
          lock.unlock();
        }
      }

      private void request() {
        lock.lock();
        try {
          more = true;
          moreRequested.signalAll();
        } finally {
          lock.unlock();
        }
      }

      @Override
      public void onClosing(okhttp3.WebSocket webSocket, int code, String reason) {
        awaitMoreRequest();
        listener.onClose(new OkHttpWebSocketImpl(webSocket, this::request), code, reason);
      }

    });
    return future;
  }

}
