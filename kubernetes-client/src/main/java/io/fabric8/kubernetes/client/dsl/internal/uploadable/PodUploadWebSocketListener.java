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

import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.api.model.StatusCause;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.http.WebSocket;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.kubernetes.client.utils.Utils;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.TimeUnit;

public class PodUploadWebSocketListener implements WebSocket.Listener {

  private static final byte FLAG_STDIN = (byte) 0;
  private static final long MAX_QUEUE_SIZE = 16 * 1024 * 1024L;

  private final CompletableFuture<WebSocket> webSocketRef = new CompletableFuture<>();
  private final CompletableFuture<Void> completeFuture = new CompletableFuture<>();

  @Override
  public void onOpen(WebSocket webSocket) {
    webSocketRef.complete(webSocket);
  }

  @Override
  public void onMessage(WebSocket webSocket, ByteBuffer bytes) {
    byte streamID = bytes.get(0);
    if (bytes.remaining() > 1) {
      bytes.position(1);
      KubernetesClientException exception = null;
      String stringValue = StandardCharsets.UTF_8.decode(bytes).toString();
      if (streamID == 3) {
        try {
          Status status = Serialization.unmarshal(stringValue, Status.class);
          if (status != null) {
            if (parseExitCode(status) == 0) {
              completeFuture.complete(null);
              return;
            }
            exception = new KubernetesClientException(status);
          }
        } catch (Exception e) {
          // can't determine an exit code, just use the whole message as the error
        }
      }
      if (exception == null) {
        exception = new KubernetesClientException(stringValue);
      }
      completeFuture.completeExceptionally(exception);
    }
  }

  @Override
  public void onClose(WebSocket webSocket, int code, String reason) {
    completeFuture.complete(null);
  }

  @Override
  public void onError(WebSocket webSocket, Throwable t) {
    webSocketRef.completeExceptionally(t);
    completeFuture.completeExceptionally(t);
  }

  final void checkError() {
    if (completeFuture.isDone()) {
      try {
        completeFuture.getNow(null);
      } catch (CompletionException e) {
        throw KubernetesClientException.launderThrowable(e.getCause());
      }
    }
  }

  final void waitUntilReady(int timeoutMilliseconds) {
    Utils.waitUntilReadyOrFail(webSocketRef, timeoutMilliseconds, TimeUnit.MILLISECONDS);
  }

  final void waitUntilComplete(int timeoutMilliseconds) throws InterruptedException {
    while (webSocketRef.getNow(null).queueSize() > 0 && !completeFuture.isDone()) {
      checkError();
      Thread.sleep(50);
    }
    webSocketRef.getNow(null).sendClose(1000, "Operation completed");
    Utils.waitUntilReadyOrFail(completeFuture, timeoutMilliseconds, TimeUnit.MILLISECONDS);
    checkError();
  }

  final void send(byte[] data, int length) {
    checkError();
    waitForQueue(length);
    byte[] toSend = new byte[length + 1];
    toSend[0] = FLAG_STDIN;
    System.arraycopy(data, 0, toSend, 1, length);
    webSocketRef.getNow(null).send(ByteBuffer.wrap(toSend));
  }

  final void waitForQueue(int length) {
    try {
      while (webSocketRef.getNow(null).queueSize() + length > MAX_QUEUE_SIZE && !Thread.interrupted()) {
        checkError();
        Thread.sleep(50L);
      }
    } catch(InterruptedException ex) {
      Thread.currentThread().interrupt();
    }
  }

  private int parseExitCode(Status status) {
    if ("Success".equals(status.getStatus())) {
      return 0;
    }
    if ("NonZeroExitCode".equals(status.getReason())) {
      if (status.getDetails() == null) {
        return -1;
      }
      List<StatusCause> causes = status.getDetails().getCauses();
      if (causes == null) {
        return -1;
      }
      return causes.stream()
          .filter(c -> "ExitCode".equals(c.getReason()))
          .map(StatusCause::getMessage)
          .map(Integer::valueOf)
          .findFirst()
          .orElse(-1);
    }
    return 1;
  }

}
