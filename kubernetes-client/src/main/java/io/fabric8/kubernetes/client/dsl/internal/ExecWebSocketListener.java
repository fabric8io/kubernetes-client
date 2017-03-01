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
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.ExecListener;
import io.fabric8.kubernetes.client.dsl.ExecWatch;
import io.fabric8.kubernetes.client.dsl.base.OperationSupport;
import io.fabric8.kubernetes.client.utils.InputStreamPumper;
import io.fabric8.kubernetes.client.utils.Utils;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class ExecWebSocketListener extends WebSocketListener implements ExecWatch, AutoCloseable {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExecWebSocketListener.class);

    private final InputStream in;
    private final OutputStream out;
    private final OutputStream err;

    private final PipedOutputStream input;
    private final PipedInputStream output;
    private final PipedInputStream error;

    private final AtomicReference<WebSocket> webSocketRef = new AtomicReference<>();
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();
    private final InputStreamPumper pumper;

    private final AtomicBoolean started = new AtomicBoolean(false);
    private final ArrayBlockingQueue<Object> queue = new ArrayBlockingQueue<>(1);
    private final ExecListener listener;
    private final AtomicBoolean executorClosed = new AtomicBoolean(false);
    private final AtomicBoolean webSocketClosed = new AtomicBoolean(false);

    public ExecWebSocketListener(InputStream in, OutputStream out, OutputStream err, PipedOutputStream inputPipe, PipedInputStream outputPipe, PipedInputStream errorPipe, ExecListener listener) {
        this.listener = listener;
        this.in = inputStreamOrPipe(in, inputPipe);
        this.out = outputStreamOrPipe(out, outputPipe);
        this.err = outputStreamOrPipe(err, errorPipe);

        this.input = inputPipe;
        this.output = outputPipe;
        this.error = errorPipe;
        this.pumper = new InputStreamPumper(this.in, new Callback<byte[]>() {
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
        try {
         closeExecutor();
         closeWebSocket(code, reason);
        } finally {
          if (listener != null) {
            listener.onClose(code, reason);
          }
        }
    }

    private void closeExecutor() {
      if (!executorClosed.compareAndSet(false, true)) {
        return;
      }

      pumper.close();
      executorService.shutdownNow();
      try {
        if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
          LOGGER.debug("ExecutorService was not cleanly shutdown, after waiting for 10 seconds.");
        }
      } catch (Throwable t) {
        LOGGER.debug("Error shutting down ExecutorService.", t);
      }
    }

    private void closeWebSocket(int code, String reason) {
      if (!webSocketClosed.compareAndSet(false, true)) {
        return;
      }

      WebSocket ws = webSocketRef.get();
      try {
        if (ws != null) {
          ws.close(code, reason);
        }
      } catch (Throwable t) {
        LOGGER.debug("Error closing WebSocket.", t);
      }
    }

    public void waitUntilReady() {
      Utils.waitUntilReady(queue, 10, TimeUnit.SECONDS);
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
      try {
        Status status = OperationSupport.createStatus(response);
        LOGGER.error("Exec Failure: HTTP:" + status.getCode() + ". Message:" + status.getMessage(), t);
        //We only need to queue startup failures.
        if (!started.get()) {
          queue.add(new KubernetesClientException(status));
        }
        closeExecutor();
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
                        if (err != null) {
                            err.write(byteString.toByteArray());
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
    webSocket.close(code, reason);
  }

  @Override
    public void onClosed(WebSocket webSocket, int code, String reason) {
        webSocketClosed.set(true);
        LOGGER.debug("Exec Web Socket: On Close with code:[{}], due to: [{}]", code, reason);
        try {
            closeExecutor();
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

    private static InputStream inputStreamOrPipe(InputStream stream, PipedOutputStream out) {
        if (stream != null) {
            return stream;
        } else if (out != null) {
            return new PipedInputStream();
        } else {
            return null;
        }
    }

    private static OutputStream outputStreamOrPipe(OutputStream stream, PipedInputStream in) {
        if (stream != null) {
            return stream;
        } else if (in != null) {
            return new PipedOutputStream();
        } else {
            return null;
        }
    }
 }
