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
import io.fabric8.kubernetes.client.Callback;
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
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
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

    private final Config config;
    private final InputStream stdin;
    private final OutputStream stdout;
    private final OutputStream stderr;
    private final OutputStream error;

    private final PipedOutputStream stdinPipe;
    private final PipedInputStream stdoutPipe;
    private final PipedInputStream stderrPipe;
    private final PipedInputStream errorPipe;

    private final AtomicReference<WebSocket> webSocketRef = new AtomicReference<>();
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();
    private final InputStreamPumper pumper;

    private final AtomicBoolean started = new AtomicBoolean(false);
    private final ArrayBlockingQueue<Object> queue = new ArrayBlockingQueue<>(1);
    private final ExecListener listener;

    private final AtomicBoolean explicitlyClosed = new AtomicBoolean(false);

    private final AtomicBoolean failed = new AtomicBoolean(false);
    private final AtomicBoolean closed = new AtomicBoolean(false);
    private final AtomicBoolean cleaned = new AtomicBoolean(false);

    private final Set<Closeable> toClose = new LinkedHashSet<>();

    @Deprecated
    public ExecWebSocketListener(InputStream stdin, OutputStream stdout, OutputStream stderr, PipedOutputStream stdinPipe, PipedInputStream stdoutPipe, PipedInputStream stderrPipe, ExecListener listener) {
        this(new Config(), stdin, stdout, stderr, stdinPipe, stdoutPipe, stderrPipe, listener);
    }

    @Deprecated
    public ExecWebSocketListener(Config config, InputStream stdin, OutputStream stdout, OutputStream stderr, PipedOutputStream stdinPipe, PipedInputStream stdoutPipe, PipedInputStream stderrPipe, ExecListener listener) {
        this(config, stdin, stdout, stderr, null, stdinPipe, stdoutPipe, stderrPipe, null, listener);
    }

    public ExecWebSocketListener(Config config, InputStream stdin, OutputStream stdout, OutputStream stderr, OutputStream error, PipedOutputStream stdinPipe, PipedInputStream stdoutPipe, PipedInputStream stderrPipe, PipedInputStream errorPipe, ExecListener listener) {
        this.config = config;
        this.listener = listener;
        this.stdin = inputStreamOrPipe(stdin, stdinPipe, toClose);
        this.stdout = outputStreamOrPipe(stdout, stdoutPipe, toClose);
        this.stderr = outputStreamOrPipe(stderr, stderrPipe, toClose);
        this.error = outputStreamOrPipe(error, errorPipe, toClose);

        this.stdinPipe = stdinPipe;
        this.stdoutPipe = stdoutPipe;
        this.stderrPipe = stderrPipe;
        this.errorPipe = errorPipe;
        this.pumper = new NonBlockingInputStreamPumper(this.stdin, new Callback<byte[]>() {
            @Override
            public void call(byte[] data) {
                try {
                    send(data);
                } catch (Exception e) {
                    //
                }
            }
        });
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
      Utils.waitUntilReady(queue, config.getWebsocketTimeout(), TimeUnit.MILLISECONDS);
    }

    @Override
    public void onOpen(WebSocket webSocket, Response response) {
        try {
            if (stdin instanceof PipedInputStream && stdinPipe != null) {
                stdinPipe.connect((PipedInputStream) stdin);
            }
            if (stdout instanceof PipedOutputStream && stdoutPipe != null) {
                stdoutPipe.connect((PipedOutputStream) stdout);
            }
            if (stderr instanceof PipedOutputStream && stderrPipe != null) {
                stderrPipe.connect((PipedOutputStream) stderr);
            }
            if (error instanceof PipedOutputStream && errorPipe != null) {
                errorPipe.connect((PipedOutputStream) error);
            }

            webSocketRef.set(webSocket);
            executorService.submit(pumper);
            started.set(true);
            queue.add(true);
        } catch (IOException e) {
            queue.add(new KubernetesClientException(OperationSupport.createStatus(response)));
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
        //We only need to queue startup failures.
        if (!started.get()) {
          queue.add(new KubernetesClientException(status));
        }

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
                        if (stdout != null) {
                            stdout.write(byteString.toByteArray());
                        }
                        break;
                    case 2:
                        if (stderr != null) {
                            stderr.write(byteString.toByteArray());
                        }
                        break;
                    case 3:
                        if (error != null) {
                            error.write(byteString.toByteArray());
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

    @Deprecated
    public OutputStream getInput() {
        return this.getStdinPipe();
    }

    @Deprecated
    public InputStream getOutput() {
        return this.getStdoutPipe();
    }

    @Deprecated
    public InputStream getError() {
        return this.getStderrPipe();
    }

    public OutputStream getStdinPipe() {
        return stdinPipe;
    }

    public InputStream getStdoutPipe() {
        return stdoutPipe;
    }

    public InputStream getStderrPipe() {
        return stderrPipe;
    }

    public InputStream getErrorPipe() {
        return errorPipe;
    }

    private void send(byte[] bytes) throws IOException {
        if (bytes.length > 0) {
            WebSocket ws = webSocketRef.get();
            if (ws != null) {
                byte[] toSend = new byte[bytes.length + 1];
                toSend[0] = 0;
                System.arraycopy(bytes, 0, toSend, 1, bytes.length);
                ws.send(ByteString.of(toSend));
            }
        }
    }

    private static InputStream inputStreamOrPipe(InputStream stream, PipedOutputStream out, Set<Closeable> toClose) {
        if (stream != null) {
            return stream;
        } else if (out != null) {
            PipedInputStream pis = new PipedInputStream();
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
