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
import io.fabric8.kubernetes.client.dsl.internal.PodOperationContext.StreamContext;
import io.fabric8.kubernetes.client.http.HttpResponse;
import io.fabric8.kubernetes.client.http.WebSocket;
import io.fabric8.kubernetes.client.http.WebSocketHandshakeException;
import io.fabric8.kubernetes.client.utils.InputStreamPumper;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.kubernetes.client.utils.internal.SerialExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

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

  private static final long MAX_QUEUE_SIZE = 16 * 1024 * 1024L;

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

  @FunctionalInterface
  public interface MessageHandler {

    void handle(ByteBuffer bytes) throws IOException;

  }

  private final class ListenerStream {
    private MessageHandler handler;
    private ExecWatchInputStream inputStream;
    private String name;

    public ListenerStream(String name) {
      this.name = name;
    }

    private void handle(ByteBuffer byteString, WebSocket webSocket) throws IOException {
      if (handler != null) {
        handler.handle(byteString);
      } else {
        if (LOGGER.isDebugEnabled()) {
          String message = ExecWebSocketListener.toString(byteString);
          if (message.length() > 200) {
            message = message.substring(0, 197) + "...";
          }
          LOGGER.debug("exec message received on channel {}: {}", name, message);
        }
        webSocket.request();
      }
    }
  }

  static final Logger LOGGER = LoggerFactory.getLogger(ExecWebSocketListener.class);
  private static final String HEIGHT = "Height";
  private static final String WIDTH = "Width";

  private final InputStream in;
  private final OutputStream input;

  private final ListenerStream out;
  private final ListenerStream error;
  private final ListenerStream errorChannel;

  private final boolean terminateOnError;
  private final ExecListener listener;

  private final AtomicReference<WebSocket> webSocketRef = new AtomicReference<>();
  private final ExecutorService executorService = Executors.newSingleThreadExecutor();
  private final SerialExecutor serialExecutor;
  private final AtomicBoolean closed = new AtomicBoolean(false);
  private final CompletableFuture<Integer> exitCode = new CompletableFuture<>();
  private ObjectMapper objectMapper = new ObjectMapper();

  public static String toString(ByteBuffer buffer) {
    return StandardCharsets.UTF_8.decode(buffer).toString();
  }

  public ExecWebSocketListener(PodOperationContext context) {
    this(context, Runnable::run);
  }

  public ExecWebSocketListener(PodOperationContext context, Executor executor) {
    this.listener = context.getExecListener();

    Integer bufferSize = context.getBufferSize();
    if (context.isRedirectingIn()) {
      this.input = InputStreamPumper.writableOutputStream(this::sendWithErrorChecking, bufferSize);
      this.in = null;
    } else {
      this.input = null;
      this.in = context.getIn();
    }

    this.terminateOnError = context.isTerminateOnError();
    this.out = createStream("stdOut", context.getOutput());
    this.error = createStream("stdErr", context.getError());
    this.errorChannel = createStream("errorChannel", context.getErrorChannel());
    this.serialExecutor = new SerialExecutor(executor);
  }

  private ListenerStream createStream(String name, StreamContext streamContext) {
    ListenerStream stream = new ListenerStream(name);
    if (streamContext == null) {
      return stream;
    }
    OutputStream os = streamContext.getOutputStream();
    if (os == null) {
      // redirecting
      stream.inputStream = new ExecWatchInputStream(() -> this.webSocketRef.get().request());
      this.exitCode.whenComplete(stream.inputStream::onExit);
      stream.handler = b -> stream.inputStream.consume(Arrays.asList(b));
    } else {
      WritableByteChannel channel = Channels.newChannel(os);
      stream.handler = b -> asyncWrite(channel, b);
    }
    return stream;
  }

  private void asyncWrite(WritableByteChannel channel, ByteBuffer b) {
    CompletableFuture.runAsync(() -> {
      try {
        channel.write(b);
      } catch (IOException e) {
        throw KubernetesClientException.launderThrowable(e);
      }
    }, serialExecutor).whenComplete((v, t) -> {
      webSocketRef.get().request();
      if (t != null) {
        if (closed.get()) {
          LOGGER.debug("Stream write failed after close", t);
        } else {
          // This could happen if the user simply closes their stream prior to completion
          LOGGER.warn("Stream write failed", t);
        }
      }
    });
  }

  @Override
  public void close() {
    // simply sends a close, which will shut down the output
    // it's expected that the server will respond with a close, but if not the input will be shutdown implicitly
    closeWebSocketOnce(1000, "Closing...");
  }

  /**
   * Performs the cleanup tasks:
   * 1. cancels the InputStream pumper
   * 2. closes all pending message work
   */
  private void cleanUpOnce() {
    executorService.shutdownNow();
    serialExecutor.shutdownNow();
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
      // ensure onClose is processed
      this.exitCode.whenComplete((i, t) -> webSocket.request());
      webSocketRef.set(webSocket);
      if (in != null && !executorService.isShutdown()) {
        // the task will be cancelled via shutdownNow
        // TODO: this does not work if the inputstream does not support available
        InputStreamPumper.pump(InputStreamPumper.asInterruptible(in), this::send, executorService);
      }
    } finally {
      if (listener != null) {
        listener.onOpen();
      }
    }
  }

  @Override
  public void onError(WebSocket webSocket, Throwable t) {

    //If we already called onClosed() or onFailed() before, we need to abort.
    if (!closed.compareAndSet(false, true)) {
      //We are not going to notify the listener, sicne we've already called onClose(), so let's log a debug/warning.
      if (LOGGER.isWarnEnabled()) {
        LOGGER.warn("Received [{}], with message:[{}] after ExecWebSocketListener is closed, Ignoring.",
            t.getClass().getCanonicalName(), t.getMessage());
      }
      return;
    }

    HttpResponse<?> response = null;
    try {
      if (t instanceof WebSocketHandshakeException) {
        response = ((WebSocketHandshakeException) t).getResponse();
      }
      Status status = OperationSupport.createStatus(response);
      status.setMessage(t.getMessage());
      cleanUpOnce();
    } finally {
      if (exitCode.isDone()) {
        LOGGER.debug("Exec failure after done", t);
      } else {
        try {
          if (listener != null) {
            ExecListener.Response execResponse = null;
            if (response != null) {
              execResponse = new SimpleResponse(response);
            }
            listener.onFailure(t, execResponse);
          } else {
            LOGGER.error("Exec Failure", t);
          }
        } finally {
          exitCode.completeExceptionally(t);
        }
      }
    }
  }

  @Override
  public void onMessage(WebSocket webSocket, ByteBuffer bytes) {
    boolean close = false;
    try {
      byte streamID = bytes.get(0);
      bytes.position(1);
      ByteBuffer byteString = bytes.slice();
      if (byteString.remaining() == 0) {
        webSocket.request();
        return;
      }
      switch (streamID) {
        case 1:
          out.handle(byteString, webSocket);
          break;
        case 2:
          if (terminateOnError) {
            String stringValue = toString(bytes);
            exitCode.completeExceptionally(new KubernetesClientException(stringValue));
            close = true;
          } else {
            error.handle(byteString, webSocket);
          }
          break;
        case 3:
          close = true;
          try {
            errorChannel.handle(bytes, webSocket);
          } finally {
            handleExitStatus(byteString);
          }
          break;
        default:
          throw new IOException("Unknown stream ID " + streamID);
      }
    } catch (IOException e) {
      throw KubernetesClientException.launderThrowable(e);
    } finally {
      if (close) {
        this.close();
      }
    }
  }

  private void handleExitStatus(ByteBuffer bytes) {
    Status status = null;
    int code = -1;
    try {
      String stringValue = toString(bytes);
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

  @Override
  public void onClose(WebSocket webSocket, int code, String reason) {
    if (!exitCode.isDone()) {
      exitCode.complete(null);
    }
    closeWebSocketOnce(code, reason);
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
    return out.inputStream;
  }

  @Override
  public InputStream getError() {
    return error.inputStream;
  }

  @Override
  public InputStream getErrorChannel() {
    return errorChannel.inputStream;
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
      waitForQueue(length);
      WebSocket ws = webSocketRef.get();
      byte[] toSend = new byte[length + 1];
      toSend[0] = flag;
      System.arraycopy(bytes, offset, toSend, 1, length);
      if (!ws.send(ByteBuffer.wrap(toSend))) {
        this.exitCode.completeExceptionally(new IOException("could not send"));
      }
    }
  }

  private void send(byte[] bytes, int offset, int length) {
    send(bytes, offset, length, (byte) 0);
  }

  void sendWithErrorChecking(byte[] bytes, int offset, int length) {
    checkError();
    send(bytes, offset, length);
    checkError();
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

  final void waitForQueue(int length) {
    try {
      while (webSocketRef.get().queueSize() + length > MAX_QUEUE_SIZE && !Thread.interrupted()) {
        checkError();
        Thread.sleep(50L);
      }
    } catch (InterruptedException ex) {
      Thread.currentThread().interrupt();
    }
  }

  final void checkError() {
    if (exitCode.isDone()) {
      try {
        exitCode.getNow(null);
      } catch (CompletionException e) {
        throw KubernetesClientException.launderThrowable(e.getCause());
      }
    }
  }

}
