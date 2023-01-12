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

import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.http.WebSocket;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.kubernetes.client.utils.internal.SerialExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BooleanSupplier;

public class PortForwarderWebsocketListener implements WebSocket.Listener {

  private static final Logger logger = LoggerFactory.getLogger(PortForwarderWebsocketListener.class);
  private static final String LOG_PREFIX = "FWD";
  private static final String PROTOCOL_ERROR = "Protocol error";
  private static final int BUFFER_SIZE = 4096;

  private final ExecutorService pumperService = Executors.newSingleThreadExecutor();

  private final SerialExecutor serialExecutor;

  private final AtomicBoolean alive = new AtomicBoolean(true);

  final Collection<Throwable> clientThrowables = new CopyOnWriteArrayList<>();

  final Collection<Throwable> serverThrowables = new CopyOnWriteArrayList<>();

  private final ReadableByteChannel in;

  private final WritableByteChannel out;

  private int messagesRead = 0;

  public PortForwarderWebsocketListener(ReadableByteChannel in, WritableByteChannel out, Executor executor) {
    this.in = in;
    this.out = out;
    this.serialExecutor = new SerialExecutor(executor);
  }

  @Override
  public void onOpen(final WebSocket webSocket) {
    logger.debug("{}: onOpen", LOG_PREFIX);
    if (in != null) {
      pumperService.execute(() -> {
        try {
          pipe(in, webSocket, alive::get);
        } catch (IOException | InterruptedException e) {
          if (e instanceof InterruptedException) {
            Thread.currentThread().interrupt();
          }
          logger.debug("Error while writing client data");
          if (alive.get()) {
            clientThrowables.add(e);
            closeBothWays(webSocket, 1001, "Client error");
          }
        }
      });
    }
  }

  @Override
  public void onMessage(WebSocket webSocket, String text) {
    logger.debug("{}: onMessage(String)", LOG_PREFIX);
    onMessage(webSocket, ByteBuffer.wrap(text.getBytes(StandardCharsets.UTF_8)));
  }

  @Override
  public void onMessage(WebSocket webSocket, ByteBuffer buffer) {
    messagesRead++;
    if (messagesRead <= 2) {
      // skip the first two messages, containing the ports used internally
      webSocket.request();
      return;
    }

    if (!buffer.hasRemaining()) {
      KubernetesClientException e = new KubernetesClientException("Received an empty message");
      serverThrowables.add(e);
      logger.debug("Protocol error", e);
      closeBothWays(webSocket, 1002, PROTOCOL_ERROR);
      return;
    }

    byte channel = buffer.get();
    if (channel < 0 || channel > 1) {
      KubernetesClientException e = new KubernetesClientException(
          String.format("Received a wrong channel from the remote socket: %s", channel));
      serverThrowables.add(e);
      logger.debug("Protocol error", e);
      closeBothWays(webSocket, 1002, PROTOCOL_ERROR);
    } else if (channel == 1) {
      // Error channel
      // TODO: read the error
      KubernetesClientException e = new KubernetesClientException(
          String.format("Received an error from the remote socket"));
      serverThrowables.add(e);
      logger.debug("Server error", e);
      closeForwarder();
    } else {
      // Data
      if (out != null) {
        serialExecutor.execute(() -> {
          try {
            while (buffer.hasRemaining()) {
              int written = out.write(buffer); // channel byte already skipped
              if (written == 0) {
                // out is non-blocking, prevent a busy loop
                Thread.sleep(50);
              }
            }
            webSocket.request();
          } catch (IOException | InterruptedException e) {
            if (e instanceof InterruptedException) {
              Thread.currentThread().interrupt();
            }
            if (alive.get()) {
              clientThrowables.add(e);
              logger.debug("Error while forwarding data to the client", e);
              closeBothWays(webSocket, 1002, PROTOCOL_ERROR);
            }
          }
        });
      }
    }
  }

  @Override
  public void onClose(WebSocket webSocket, int code, String reason) {
    logger.debug("{}: onClose. Code={}, Reason={}", LOG_PREFIX, code, reason);
    if (alive.get()) {
      closeForwarder();
    }
  }

  @Override
  public void onError(WebSocket webSocket, Throwable t) {
    logger.debug("{}: Throwable received from websocket", LOG_PREFIX, t);
    if (alive.get()) {
      serverThrowables.add(t);
      closeForwarder();
    }
  }

  boolean isAlive() {
    return alive.get();
  }

  boolean errorOccurred() {
    return !clientThrowables.isEmpty() || !serverThrowables.isEmpty();
  }

  Collection<Throwable> getClientThrowables() {
    return clientThrowables;
  }

  Collection<Throwable> getServerThrowables() {
    return serverThrowables;
  }

  void closeBothWays(WebSocket webSocket, int code, String message) {
    logger.debug("{}: Closing with code {} and reason: {}", LOG_PREFIX, code, message);
    alive.set(false);
    try {
      webSocket.sendClose(code, message);
    } catch (Exception e) {
      serverThrowables.add(e);
      logger.debug("Error while closing the websocket", e);
    }
    closeForwarder();
  }

  private void closeForwarder() {
    alive.set(false);
    if (in != null) {
      Utils.closeQuietly(in);
    }
    if (out != null && out != in) {
      Utils.closeQuietly(out);
    }
    pumperService.shutdownNow();
    serialExecutor.shutdownNow();
  }

  private static void pipe(ReadableByteChannel in, WebSocket webSocket, BooleanSupplier isAlive)
      throws IOException, InterruptedException {
    final ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
    int read;
    do {
      buffer.clear();
      buffer.put((byte) 0); // channel byte
      read = in.read(buffer);
      if (read > 0) {
        buffer.flip();
        webSocket.send(buffer);
      } else if (read == 0) {
        // in is non-blocking, prevent a busy loop
        Thread.sleep(50);
      }
    } while (isAlive.getAsBoolean() && read >= 0);
  }

}
