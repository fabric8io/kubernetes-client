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

import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.LogWatch;
import io.fabric8.kubernetes.client.dsl.base.OperationSupport;
import io.fabric8.kubernetes.client.utils.Utils;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import static io.fabric8.kubernetes.client.utils.Utils.closeQuietly;

public class LogWatchCallback extends WebSocketListener implements LogWatch, AutoCloseable {

  private static final Logger LOGGER = LoggerFactory.getLogger(LogWatchCallback.class);

  private final Config config;
  private final OutputStream out;
  private final PipedInputStream output;
  private final Set<Closeable> toClose = new LinkedHashSet<>();

  private final AtomicBoolean started = new AtomicBoolean(false);
  private final ArrayBlockingQueue<Object> queue = new ArrayBlockingQueue<>(1);
  private final ExecutorService executorService = Executors.newSingleThreadExecutor();
  private final AtomicBoolean closed = new AtomicBoolean(false);

  private final AtomicReference<WebSocket> webSocketRef = new AtomicReference<>();
  private final AtomicBoolean explicitlyClosed = new AtomicBoolean(false);
  private final AtomicBoolean failed = new AtomicBoolean(false);
  private final AtomicBoolean cleaned = new AtomicBoolean(false);

  @Deprecated
  public LogWatchCallback(OutputStream out) {
    this(new Config(), out);
  }

  public LogWatchCallback(Config config, OutputStream out) {
    this.config = config;
    if (out == null) {
      this.out = new PipedOutputStream();
      this.output = new PipedInputStream();
      toClose.add(this.out);
      toClose.add(this.output);
    } else {
      this.out = out;
      this.output = null;
    }

    //We need to connect the pipe here, because onResponse might not be called in time (if log is empty)
    //This will cause a `Pipe not connected` exception for everyone that tries to read. By always opening
    //the pipe the user will get a ready to use inputstream , which will block until there is actually something to read.
    if (this.out instanceof PipedOutputStream && this.output != null) {
      try {
        this.output.connect((PipedOutputStream) this.out);
      } catch (IOException e) {
        throw KubernetesClientException.launderThrowable(e);
      }
    }
  }

  @Override
  public void close() {
    close(1000, "Closing...");
  }

  public void close(int code, String reason) {
    close(webSocketRef.get(), code, reason);
  }

  private void close(WebSocket ws, int code, String reason) {
    explicitlyClosed.set(true);
    closeWebSocketOnce(code, reason);
    onClosed(ws, code, reason);
  }

  /**
   * Performs the cleanup tasks:
   * 1. closes the InputStream pumper
   * 2. closes all internally managed closeables (piped streams).
   *
   * The order of these tasks can't change or its likely that the pumper will throw errors,
   * if the stream it uses closes before the pumper it self.
   */
  private void cleanUpOnce() {
    if (!cleaned.compareAndSet(false, true)) {
      return;
    }
    closeQuietly(toClose);
  }

  private void closeWebSocketOnce(int code, String reason) {
    if (closed.get()) {
      return;
    }

    try {
      WebSocket ws = webSocketRef.get();
      if (ws != null) {
        ws.close(code, reason);
      }
    } catch (Throwable t) {
      LOGGER.debug("Error closing WebSocket.", t);
    }
  }

  public void waitUntilReady() {
    Utils.waitUntilReady(queue, config.getWebsocketTimeout(), TimeUnit.MILLISECONDS);
  }

  public InputStream getOutput() {
    return output;
  }

  @Override
  public void onOpen(WebSocket webSocket, Response response){
    try{
      webSocketRef.set(webSocket);
      started.set(true);
      queue.add(true);
    } catch (Exception e) {
      queue.add(new KubernetesClientException(OperationSupport.createStatus(response)));
    }
  }

  @Override
  public void onMessage(WebSocket webSocket, ByteString bytes){
    try {
      if(bytes.size()==0) {
        return ;
      } else {
        if(out!=null){
          out.write(bytes.toByteArray());}
      }
    } catch (IOException e) {
      LOGGER.error("Error in writing : " + e.getMessage());
    }
  }

  @Override
  public void onFailure(WebSocket webSocket, Throwable t, Response response){
    if (explicitlyClosed.get() || closed.get() || !failed.compareAndSet(false, true) ) {
      if (LOGGER.isDebugEnabled()) {
        LOGGER.warn("Received [" + t.getClass().getCanonicalName() + "], with message:[" + t.getMessage() + "]");
      }
      return;
    }
    try {
      Status status = OperationSupport.createStatus(response);
      LOGGER.error("Exec Failure: HTTP:" + status.getCode() + ". Message:" + status.getMessage(), t);
      if (!started.get()) {
        queue.add(new KubernetesClientException(status));
      }
      cleanUpOnce();
    }
    catch (Exception e) {
      LOGGER.error("Exec Failure exception: " + e.getMessage());
    }
  }

  @Override
  public void onClosing(WebSocket webSocket, int code, String reason) {
    LogWatchCallback.this.close(webSocket, code, reason);
  }

  @Override
  public void onClosed(WebSocket webSocket, int code, String reason) {
    if (!closed.compareAndSet(false, true) || failed.get()) {
      return;
    }
    LOGGER.debug("Web Socket: On Close with code:[{}], due to: [{}]", code, reason);
    try {
      if (explicitlyClosed.get()) {
        cleanUpOnce();
      }
    }
    catch (Exception e) {
      LOGGER.error("Error in fetching closing status: " + e.getMessage());
    }
  }
}
