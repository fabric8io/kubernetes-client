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
package io.fabric8.kubernetes.client.dsl.internal.uploadable;

import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.http.WebSocket;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class PodUploadWebSocketListener implements WebSocket.Listener {

  private static final byte FLAG_STDIN = (byte) 0;
  private static final long MAX_QUEUE_SIZE = 16 * 1024 * 1024L;

  private final AtomicReference<WebSocket> webSocketRef;
  private final AtomicReference<String> error;
  private final CountDownLatch readyLatch;
  private final CountDownLatch completeLatch;

  PodUploadWebSocketListener() {
    this.webSocketRef = new AtomicReference<>();
    this.error = new AtomicReference<>();
    this.readyLatch = new CountDownLatch(1);
    this.completeLatch = new CountDownLatch(1);
  }

  @Override
  public void onOpen(WebSocket webSocket) {
    webSocketRef.set(webSocket);
  }

  @Override
  public void onMessage(WebSocket webSocket, ByteBuffer bytes) {
    if (readyLatch.getCount() > 0 && bytes.remaining() == 1) {
      readyLatch.countDown();
    } else if (bytes.remaining() > 1) {
      bytes.position(1);
      error.set(StandardCharsets.UTF_8.decode(bytes).toString());
    }
  }
  
  @Override
  public void onClose(WebSocket webSocket, int code, String reason) {
    completeLatch.countDown();
  }

  @Override
  public void onError​(WebSocket webSocket, Throwable t) {
    error.set(String.format("PodUploadWebSocketListener failed with - %s", t.getMessage()));
    while (readyLatch.getCount() > 0) {
      readyLatch.countDown();
    }
    while (completeLatch.getCount() > 0) {
      completeLatch.countDown();
    }
  }

  final void checkError() {
    if (error.get() != null && !error.get().trim().isEmpty()) {
      throw new KubernetesClientException(error.get());
    }
  }

  final void waitUntilReady(int timeoutMilliseconds) throws IOException, InterruptedException {
    if (!readyLatch.await(timeoutMilliseconds, TimeUnit.MILLISECONDS)) {
      checkError();
      throw new IOException("Connection to server timed out");
    }
  }

  final void waitUntilComplete(int timeoutMilliseconds) throws IOException, InterruptedException {
    while (webSocketRef.get().queueSize() > 0 && completeLatch.getCount() > 0) {
      checkError();
      Thread.sleep(50);
    }
    webSocketRef.get().sendClose(1000, "Operation completed");
    if (!completeLatch.await(timeoutMilliseconds, TimeUnit.MILLISECONDS)) {
      throw new IOException("Upload operation timed out before completing");
    }
    checkError();
  }

  final void send(byte[] data, int length) {
    checkError();
    waitForQueue(length);
    byte[] toSend = new byte[length + 1];
    toSend[0] = FLAG_STDIN;
    System.arraycopy(data, 0, toSend, 1, length);
    webSocketRef.get().send(ByteBuffer.wrap(toSend));
  }

  final void waitForQueue(int length) {
    try {
      while (webSocketRef.get().queueSize() + length > MAX_QUEUE_SIZE && !Thread.interrupted()) {
        checkError();
        Thread.sleep(50L);
      }
    } catch(InterruptedException ex) {
      Thread.currentThread().interrupt();
    }
  }
}
