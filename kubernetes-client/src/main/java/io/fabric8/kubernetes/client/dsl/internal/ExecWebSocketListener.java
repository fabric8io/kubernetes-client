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
import io.fabric8.kubernetes.api.model.StatusCause;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.ExecListener;
import io.fabric8.kubernetes.client.dsl.ExecListener.Response;
import io.fabric8.kubernetes.client.dsl.ExecWatch;
import io.fabric8.kubernetes.client.http.HttpResponse;
import io.fabric8.kubernetes.client.http.WebSocket;
import io.fabric8.kubernetes.client.http.WebSocketHandshakeException;
import io.fabric8.kubernetes.client.utils.InputStreamPumper;
import io.fabric8.kubernetes.client.utils.Serialization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import static io.fabric8.kubernetes.client.utils.Utils.closeQuietly;

/**
 * A {@link WebSocket.Listener} for exec operations.
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
public class ExecWebSocketListener implements ExecWatch, AutoCloseable, WebSocket.Listener {

    static final String CAUSE_REASON_EXIT_CODE = "ExitCode";
    static final String REASON_NON_ZERO_EXIT_CODE = "NonZeroExitCode";
    static final String STATUS_SUCCESS = "Success";

    private final class SimpleResponse implements Response {
    private final HttpResponse<?> response;

    private SimpleResponse(HttpResponse<?> response) {
      this.response = response;
    }

    @Override
    public int code() {
      return response.code();
    }

    @Override
    public String body() throws IOException {
      return response.bodyString();
    }
  }

    private static final Logger LOGGER = LoggerFactory.getLogger(ExecWebSocketListener.class);
    private static final String HEIGHT = "Height";
    private static final String WIDTH = "Width";

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

    private final ExecListener listener;

    private final AtomicBoolean closed = new AtomicBoolean(false);

    private final Set<Closeable> toClose = new LinkedHashSet<>();

    private final CompletableFuture<Integer> exitCode = new CompletableFuture<>();

    private ObjectMapper objectMapper;

    public ExecWebSocketListener(InputStream in, OutputStream out, OutputStream err, OutputStream errChannel, PipedOutputStream inputPipe, PipedInputStream outputPipe, PipedInputStream errorPipe, PipedInputStream errorChannelPipe, ExecListener listener, Integer bufferSize) {
        this.listener = listener;
        this.in = inputStreamOrPipe(in, inputPipe, toClose, bufferSize);
        this.out = outputStreamOrPipe(out, outputPipe, toClose);
        this.err = outputStreamOrPipe(err, errorPipe, toClose);
        this.errChannel = outputStreamOrPipe(errChannel, errorChannelPipe, toClose);

        this.input = inputPipe;
        this.output = outputPipe;
        this.error = errorPipe;
        this.errorChannel = errorChannelPipe;
        this.objectMapper = new ObjectMapper();
    }


    @Override
    public void close() {
      close(1000, "Closing...");
    }

    private void close(int code, String reason) {
      if (!exitCode.isDone()) {
        exitCode.completeExceptionally(new KubernetesClientException("Closed before exit code recieved"));
      }
      closeWebSocketOnce(code, reason);
      onClosed(code, reason);
    }

  /**
   * Performs the cleanup tasks:
   * 1. cancels the InputStream pumper
   * 2. closes all internally managed closeables (piped streams).
   *
   * The order of these tasks can't change or its likely that the pumper will throw errors,
   * if the stream it uses closes before the pumper it self.
   */
  private void cleanUpOnce() {
     executorService.shutdownNow();
     closeQuietly(toClose);
  }

    private void closeWebSocketOnce(int code, String reason) {
      if (closed.get()) {
        return;
      }

      try {
        WebSocket ws = webSocketRef.get();
        if (ws != null) {
          ws.sendClose(code, reason);
        }
      } catch (Throwable t) {
        LOGGER.debug("Error closing WebSocket.", t);
      }
    }

    @Override
    public void onOpen(WebSocket webSocket) {
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
            if (in != null && !executorService.isShutdown()) {
              // the task will be cancelled via shutdownNow
              InputStreamPumper.pump(InputStreamPumper.asInterruptible(in), this::send, executorService);
            }
        } catch (IOException e) {
          onError(webSocket, e);
        } finally {
            if (listener != null) {
                listener.onOpen();
            }
        }
    }

  @Override
  public void onError(WebSocket webSocket, Throwable t) {

      //If we already called onClosed() or onFailed() before, we need to abort.
      if (closed.compareAndSet(false, true) ) {
        //We are not going to notify the listener, sicne we've already called onClose(), so let's log a debug/warning.
        if (LOGGER.isWarnEnabled()) {
          LOGGER.warn("Received [{}], with message:[{}] after ExecWebSocketListener is closed, Ignoring.",t.getClass().getCanonicalName(),t.getMessage());
        }
        return;
      }

      HttpResponse<?> response = null;
      try {
        if (t instanceof WebSocketHandshakeException) {
          response = ((WebSocketHandshakeException)t).getResponse();
        }
        Status status = OperationSupport.createStatus(response);
        status.setMessage(t.getMessage());
        LOGGER.error("Exec Failure", t);
        cleanUpOnce();
      } finally {
        try {
          if (listener != null) {
            ExecListener.Response execResponse = null;
            if (response != null) {
              execResponse = new SimpleResponse(response);
            }
            listener.onFailure(t, execResponse);
          }
        } finally {
          exitCode.completeExceptionally(t);
        }
      }
    }

  @Override
  public void onMessage(WebSocket webSocket, ByteBuffer bytes) {
    // TODO: these could be blocking writes and may need moved to another thread
    // if we do that, we'll need to make the exit code wait on the final write
        try {
            byte streamID = bytes.get(0);
            bytes.position(1);
            ByteBuffer byteString = bytes.slice();
            if (byteString.remaining() > 0) {
                switch (streamID) {
                    case 1:
                        writeAndFlush(out, byteString);
                        break;
                    case 2:
                        writeAndFlush(err, byteString);
                        break;
                    case 3:
                        handleExitStatus(bytes);
                        writeAndFlush(errChannel, byteString);
                        // once the process is done, we can proactively close
                        this.close();
                        break;
                    default:
                        throw new IOException("Unknown stream ID " + streamID);
                }
            }
        } catch (IOException e) {
            throw KubernetesClientException.launderThrowable(e);
        }
    }


  private void handleExitStatus(ByteBuffer bytes) {
    Status status = null;
    int code = -1;
    try {
      String stringValue = StandardCharsets.UTF_8.decode(bytes).toString();
      status = Serialization.unmarshal(stringValue, Status.class);
      if (status != null) {
        code = parseExitCode(status);
      }
    } catch (Exception e) {
      LOGGER.warn("Could not determine exit code", e);
    }
    try {
      if (this.listener != null) {
        this.listener.onExit(code, status);
      }
    } finally {
      this.exitCode.complete(code);
    }
  }

  private void writeAndFlush(OutputStream stream, ByteBuffer byteString) throws IOException {
    if (stream != null) {
      Channels.newChannel(stream).write(byteString);
      if (stream instanceof PipedOutputStream) {
        stream.flush(); // immediately wake up the reader
      }
    }
  }

  @Override
  public void onClose(WebSocket webSocket, int code, String reason) {
    ExecWebSocketListener.this.close(code, reason);
  }

    private void onClosed(int code, String reason) {
       //If we already called onClosed() or onFailed() before, we need to abort.
       if (!closed.compareAndSet(false, true)) {
         return;
       }
       LOGGER.debug("Exec Web Socket: On Close with code:[{}], due to: [{}]", code, reason);
        try {
            cleanUpOnce();
        } finally {
            if (listener != null) {
              listener.onClose(code, reason);
            }
        }
    }

    @Override
    public OutputStream getInput() {
        return input;
    }

    @Override
    public InputStream getOutput() {
        return output;
    }

    @Override
    public InputStream getError() {
        return error;
    }

    @Override
    public InputStream getErrorChannel() {
        return errorChannel;
    }

    @Override
    public void resize(int cols, int rows) {
      if (cols < 0 || rows < 0) {
        return;
      }
      try {
        Map<String, Integer> map = new HashMap<>(4);
        map.put(HEIGHT, rows);
        map.put(WIDTH, cols);
        byte[] bytes = objectMapper.writeValueAsBytes(map);
        send(bytes, 0, bytes.length, (byte) 4);
      } catch (Exception e) {
        throw KubernetesClientException.launderThrowable(e);
      }
    }

    private void send(byte[] bytes, int offset, int length, byte flag) {
        if (length > 0) {
            WebSocket ws = webSocketRef.get();
            if (ws != null) {
                byte[] toSend = new byte[length + 1];
                toSend[0] = flag;
                System.arraycopy(bytes, offset, toSend, 1, length);
                ws.send(ByteBuffer.wrap(toSend));
            }
        }
    }

    private void send(byte[] bytes, int offset, int length) {
       send(bytes, offset, length, (byte)0);
    }


    private static InputStream inputStreamOrPipe(InputStream stream, PipedOutputStream out, Set<Closeable> toClose, Integer bufferSize) {
        if (stream != null) {
            return stream;
        } else if (out != null) {
            PipedInputStream pis = bufferSize == null ? new PipedInputStream() : new PipedInputStream(bufferSize.intValue());
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
            toClose.add(pos);
            return pos;
        } else {
            return null;
        }
    }

    public static int parseExitCode(Status status) {
      if (STATUS_SUCCESS.equals(status.getStatus())) {
        return 0;
      }
      if (REASON_NON_ZERO_EXIT_CODE.equals(status.getReason())) {
        if (status.getDetails() == null) {
          return -1;
        }
        List<StatusCause> causes = status.getDetails().getCauses();
        if (causes == null) {
          return -1;
        }
        return causes.stream()
            .filter(c -> CAUSE_REASON_EXIT_CODE.equals(c.getReason()))
            .map(StatusCause::getMessage)
            .map(Integer::valueOf)
            .findFirst()
            .orElse(-1);
      }
      return -1;
    }

    @Override
    public CompletableFuture<Integer> exitCode() {
      return exitCode;
    }

 }
