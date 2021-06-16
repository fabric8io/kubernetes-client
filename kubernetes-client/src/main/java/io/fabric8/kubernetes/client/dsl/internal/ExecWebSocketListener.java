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

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.ExecListener;
import io.fabric8.kubernetes.client.dsl.ExecWatch;
import io.fabric8.kubernetes.client.dsl.base.OperationSupport;
import io.fabric8.kubernetes.client.utils.InputStreamPumper;
import io.fabric8.kubernetes.client.utils.NonBlockingInputStreamPumper;
import io.fabric8.kubernetes.client.utils.Utils;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import static io.fabric8.kubernetes.client.utils.Utils.closeQuietly;
import static io.fabric8.kubernetes.client.utils.Utils.shutdownExecutorService;

/**
 * A {@link WebSocketListener} for exec operations.
 *
 * This listener, is only responsible for the resources it creates. Externally passed resource, will not get closed,
 * by this listener.
 *
 * All other resources will be cleaned up once, ONLY when the close() method is called.
 *
 * ExecListener methods, onClose() and onFailure are mutually exclusive and are meant to be called once and only once.
 * Failures that propagate after a close() operation will not be propagated.
 *
 */
public class ExecWebSocketListener extends WebSocketListener implements ExecWatch, AutoCloseable {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExecWebSocketListener.class);
    private static final String HEIGHT = "Height";
    private static final String WIDTH = "Width";

    private final Config config;
    private final InputStream in;
    private final OutputStream out;
    private final OutputStream err;
    private final OutputStream errChannel;

    private final PipedOutputStream input;
    private final PipedInputStream output;
    private final PipedInputStream error;
    private final PipedInputStream errorChannel;

    private final AtomicReference<WebSocket> webSocketRef = new AtomicReference<>();
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();
    private final InputStreamPumper pumper;

    private final CompletableFuture<Void> startedFuture = new CompletableFuture<>();
    private final ExecListener listener;

    private final AtomicBoolean explicitlyClosed = new AtomicBoolean(false);

    private final AtomicBoolean failed = new AtomicBoolean(false);
    private final AtomicBoolean closed = new AtomicBoolean(false);
    private final AtomicBoolean cleaned = new AtomicBoolean(false);

    private final Set<Closeable> toClose = new LinkedHashSet<>();

    private ObjectMapper objectMapper;

    @Deprecated
    public ExecWebSocketListener(InputStream in, OutputStream out, OutputStream err, PipedOutputStream inputPipe, PipedInputStream outputPipe, PipedInputStream errorPipe, ExecListener listener) {
        this(new Config(), in, out, err, inputPipe, outputPipe, errorPipe, listener);
    }

    @Deprecated
    public ExecWebSocketListener(Config config, InputStream in, OutputStream out, OutputStream err, PipedOutputStream inputPipe, PipedInputStream outputPipe, PipedInputStream errorPipe, ExecListener listener) {
        this(config, in, out, err, null, inputPipe, outputPipe, errorPipe, null, listener, null);
    }

    @Deprecated
    public ExecWebSocketListener(Config config, InputStream in, OutputStream out, OutputStream err, OutputStream errChannel, PipedOutputStream inputPipe, PipedInputStream outputPipe, PipedInputStream errorPipe, PipedInputStream errorChannelPipe, ExecListener listener) {
        this(config, in, out, err, errChannel, inputPipe, outputPipe, errorPipe, errorChannelPipe, listener, null);
    }

    public ExecWebSocketListener(Config config, InputStream in, OutputStream out, OutputStream err, OutputStream errChannel, PipedOutputStream inputPipe, PipedInputStream outputPipe, PipedInputStream errorPipe, PipedInputStream errorChannelPipe, ExecListener listener, Integer bufferSize) {
        this.config = config;
        this.listener = listener;
        this.in = inputStreamOrPipe(in, inputPipe, toClose, bufferSize);
        this.out = outputStreamOrPipe(out, outputPipe, toClose);
        this.err = outputStreamOrPipe(err, errorPipe, toClose);
        this.errChannel = outputStreamOrPipe(errChannel, errorChannelPipe, toClose);

        this.input = inputPipe;
        this.output = outputPipe;
        this.error = errorPipe;
        this.errorChannel = errorChannelPipe;
        this.pumper = new NonBlockingInputStreamPumper(this.in, data -> {
            try {
                send(data);
            } catch (Exception e) {
                //
            }
        });
        this.objectMapper = new ObjectMapper();
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

    try {
      closeQuietly(pumper);
      shutdownExecutorService(executorService);
    } finally {
      closeQuietly(toClose);
    }
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
      Utils.waitUntilReadyOrFail(startedFuture, config.getWebsocketTimeout(), TimeUnit.MILLISECONDS);
    }

    @Override
    public void onOpen(WebSocket webSocket, Response response) {
        try {
            if (in instanceof PipedInputStream && input != null) {
                input.connect((PipedInputStream) in);
            }
            if (out instanceof PipedOutputStream && output != null) {
                output.connect((PipedOutputStream) out);
            }
            if (err instanceof PipedOutputStream && error != null) {
                error.connect((PipedOutputStream) err);
            }
            if (errChannel instanceof PipedOutputStream && errorChannel != null) {
                errorChannel.connect((PipedOutputStream) errChannel);
            }

            webSocketRef.set(webSocket);
            if (!executorService.isShutdown()) {
              executorService.submit(pumper);
              startedFuture.complete(null);
            }
        } catch (IOException e) {
          startedFuture.completeExceptionally(new KubernetesClientException(OperationSupport.createStatus(response)));
        } finally {
            if (listener != null) {
                listener.onOpen(response);
            }
        }
    }

  @Override
  public void onFailure(WebSocket webSocket, Throwable t, Response response) {

      //If we already called onClosed() or onFailed() before, we need to abort.
      if (explicitlyClosed.get() || closed.get() || !failed.compareAndSet(false, true) ) {
        //We are not going to notify the listener, sicne we've already called onClose(), so let's log a debug/warning.
        if (LOGGER.isDebugEnabled()) {
          LOGGER.warn("Received [" + t.getClass().getCanonicalName() + "], with message:[" + t.getMessage() + "] after ExecWebSocketListener is closed, Ignoring.");
        }
        return;
      }

      try {
        Status status = OperationSupport.createStatus(response);
        LOGGER.error("Exec Failure: HTTP:" + status.getCode() + ". Message:" + status.getMessage(), t);
        startedFuture.completeExceptionally(new KubernetesClientException(status));

        cleanUpOnce();
      } finally {
        if (listener != null) {
          listener.onFailure(t, response);
        }
      }
    }

    @Override
    public void onMessage(WebSocket webSocket, ByteString bytes) {
        try {
            byte streamID = bytes.getByte(0);
            ByteString byteString = bytes.substring(1);
            if (byteString.size() > 0) {
                switch (streamID) {
                    case 1:
                        if (out != null) {
                            out.write(byteString.toByteArray());
                        }
                        break;
                    case 2:
                        if (err != null) {
                            err.write(byteString.toByteArray());
                        }
                        break;
                    case 3:
                        if (errChannel != null) {
                            errChannel.write(byteString.toByteArray());
                        }
                        break;
                    default:
                        throw new IOException("Unknown stream ID " + streamID);
                }
            }
        } catch (IOException e) {
            throw KubernetesClientException.launderThrowable(e);
        }
    }

  @Override
  public void onClosing(WebSocket webSocket, int code, String reason) {
    ExecWebSocketListener.this.close(webSocket, code, reason);
  }

  @Override
    public void onClosed(WebSocket webSocket, int code, String reason) {
       //If we already called onClosed() or onFailed() before, we need to abort.
       if (!closed.compareAndSet(false, true) || failed.get()) {
         return;
       }
       LOGGER.debug("Exec Web Socket: On Close with code:[{}], due to: [{}]", code, reason);
        try {
            if (explicitlyClosed.get()) {
              cleanUpOnce();
            }
        } finally {
            if (listener != null) {
              listener.onClose(code, reason);
            }
        }
    }

    public OutputStream getInput() {
        return input;
    }

    public InputStream getOutput() {
        return output;
    }

    public InputStream getError() {
        return error;
    }

    public InputStream getErrorChannel() {
        return errorChannel;
    }

    public void resize(int cols, int rows) {
      if (cols < 0 || rows < 0) {
        return;
      }
      try {
        Map<String, Integer> map = new HashMap<>(4);
        map.put(HEIGHT, rows);
        map.put(WIDTH, cols);
        byte[] bytes = objectMapper.writeValueAsBytes(map);
        send(bytes, (byte) 4);
      } catch (Exception e) {
        throw KubernetesClientException.launderThrowable(e);
      }
    }

    private void send(byte[] bytes,byte flag) throws IOException {
        if (bytes.length > 0) {
            WebSocket ws = webSocketRef.get();
            if (ws != null) {
                byte[] toSend = new byte[bytes.length + 1];
                toSend[0] = flag;
                System.arraycopy(bytes, 0, toSend, 1, bytes.length);
                ws.send(ByteString.of(toSend));
            }
        }
    }

    private void send(byte[] bytes) throws IOException {
       send(bytes,(byte)0);
    }


    private static InputStream inputStreamOrPipe(InputStream stream, PipedOutputStream out, Set<Closeable> toClose, Integer bufferSize) {
        if (stream != null) {
            return stream;
        } else if (out != null) {
            PipedInputStream pis = bufferSize == null ? new PipedInputStream() : new PipedInputStream(bufferSize.intValue());
            toClose.add(out);
            toClose.add(pis);
            return pis;
        } else {
            return null;
        }
    }

    private static OutputStream outputStreamOrPipe(OutputStream stream, PipedInputStream in, Set<Closeable> toClose) {
        if (stream != null) {
            return stream;
        } else if (in != null) {
            PipedOutputStream pos = new PipedOutputStream();
            toClose.add(in);
            toClose.add(pos);
            return pos;
        } else {
            return null;
        }
    }
 }
