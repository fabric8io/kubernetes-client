/*
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

import io.fabric8.kubernetes.api.model.StatusBuilder;
import io.fabric8.kubernetes.api.model.StatusCause;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.ExecListener;
import io.fabric8.kubernetes.client.dsl.internal.PodOperationContext.StreamContext;
import io.fabric8.kubernetes.client.http.WebSocket;
import io.fabric8.kubernetes.client.utils.KubernetesSerialization;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

class ExecWebSocketListenerTest {

  @Test
  void testParseExitCodeSuccess() {
    assertEquals(0, ExecWebSocketListener
        .parseExitCode(new StatusBuilder().withStatus(ExecWebSocketListener.STATUS_SUCCESS).build()));
  }

  @Test
  void testParseExitCodeInvalid() {
    assertEquals(-1, ExecWebSocketListener
        .parseExitCode(new StatusBuilder().withStatus("don't know").build()));
  }

  @Test
  void testParseExitCodeNonZeroInvalid() {
    assertEquals(-1, ExecWebSocketListener
        .parseExitCode(new StatusBuilder().withStatus("Failed")
            .withReason(ExecWebSocketListener.REASON_NON_ZERO_EXIT_CODE)
            .build()));
  }

  @Test
  void testParseExitCodeNonZero() {
    assertEquals(126, ExecWebSocketListener
        .parseExitCode(new StatusBuilder().withStatus("Failed")
            .withReason(ExecWebSocketListener.REASON_NON_ZERO_EXIT_CODE)
            .withNewDetails().withCauses(new StatusCause("ExitCode", "126", ExecWebSocketListener.CAUSE_REASON_EXIT_CODE))
            .endDetails()
            .build()));
  }

  @Test
  void testSendShouldTruncateAndSendFlaggedWebSocketData() {
    final WebSocket mockedWebSocket = Mockito.mock(WebSocket.class);
    Mockito.when(mockedWebSocket.send(Mockito.any())).thenReturn(true);

    ExecWebSocketListener listner = newExecWebSocketListener(new PodOperationContext());

    listner.onOpen(mockedWebSocket);
    final byte[] toSend = new byte[] { 1, 3, 3, 7, 0 };

    listner.sendWithErrorChecking(toSend, 0, 4);

    verify(mockedWebSocket, times(1))
        .send(ByteBuffer.wrap(new byte[] { (byte) 0, (byte) 1, (byte) 3, (byte) 3, (byte) 7 }));
  }

  @Test
  void testCheckErrorHasErrorFromMessageShouldThrowException() {
    ExecWebSocketListener listener = newExecWebSocketListener(
        new PodOperationContext().toBuilder().terminateOnError(true).build());

    listener.onMessage(null, ByteBuffer.wrap(new byte[] { (byte) 2, (byte) 1, (byte) 1 }));

    assertThrows(KubernetesClientException.class, () -> listener.checkError());
  }

  @Test
  void testCheckErrorHasErrorFromFailureShouldThrowException() {
    ExecWebSocketListener listener = newExecWebSocketListener(new PodOperationContext());

    listener.onError(null, new IOException("here"));

    assertThrows(KubernetesClientException.class, () -> listener.checkError());
  }

  private ExecWebSocketListener newExecWebSocketListener(PodOperationContext context) {
    return new ExecWebSocketListener(context, Runnable::run, new KubernetesSerialization());
  }

  @Test
  void testGracefulClose() {
    ExecWebSocketListener listener = newExecWebSocketListener(new PodOperationContext());
    WebSocket mock = Mockito.mock(WebSocket.class);
    listener.onOpen(mock);
    listener.close();

    assertFalse(listener.exitCode().isDone());
    verify(mock).sendClose(Mockito.anyInt(), Mockito.anyString());
  }

  @Test
  void testOnClose() {
    ExecWebSocketListener listener = newExecWebSocketListener(new PodOperationContext());
    WebSocket mock = Mockito.mock(WebSocket.class);
    listener.onClose(mock, 1000, "testing");

    assertNull(listener.exitCode().join());
  }

  @Test
  void onMessageChannel3CompletesExitAfterPendingChannel1Writes() throws Exception {
    final CountDownLatch writeStarted = new CountDownLatch(1);
    final CountDownLatch releaseWrite = new CountDownLatch(1);
    final OutputStream blockingOut = new OutputStream() {
      @Override
      public void write(int b) {
      }

      @Override
      public void write(byte[] b, int off, int len) throws IOException {
        writeStarted.countDown();
        try {
          if (!releaseWrite.await(5, TimeUnit.SECONDS)) {
            throw new IOException("write was not released");
          }
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
          throw new IOException(e);
        }
      }
    };
    final PodOperationContext context = new PodOperationContext().toBuilder()
        .output(new StreamContext(blockingOut))
        .build();
    final ExecutorService asyncExecutor = Executors.newSingleThreadExecutor();
    try {
      final ExecWebSocketListener listener = new ExecWebSocketListener(context, asyncExecutor, new KubernetesSerialization());
      final WebSocket mockedWebSocket = Mockito.mock(WebSocket.class);
      listener.onOpen(mockedWebSocket);

      // Channel 1 (stdout) message: queues an async write that will block until released
      listener.onMessage(mockedWebSocket, ByteBuffer.wrap(new byte[] { (byte) 1, (byte) 'p', (byte) 'a', (byte) 'y' }));
      assertTrue(writeStarted.await(2, TimeUnit.SECONDS), "expected the channel 1 async write to start");

      // Channel 3 (exit-success) message fires while the previous write is still in flight
      final byte[] successJson = new KubernetesSerialization().asJson(new StatusBuilder().withStatus("Success").build())
          .getBytes(StandardCharsets.UTF_8);
      final ByteBuffer channel3 = ByteBuffer.allocate(successJson.length + 1).put((byte) 3).put(successJson);
      channel3.flip();
      listener.onMessage(mockedWebSocket, channel3);

      // The exitCode must NOT complete before the pending channel 1 write has been processed.
      // Without the fix, exitCode is completed synchronously inside onMessage and this assertion fails.
      assertThrows(TimeoutException.class, () -> listener.exitCode().get(200, TimeUnit.MILLISECONDS),
          "exitCode must not complete before pending channel 1 async writes finish");

      releaseWrite.countDown();
      assertEquals(0, listener.exitCode().get(2, TimeUnit.SECONDS));
    } finally {
      asyncExecutor.shutdownNow();
    }
  }

  @Test
  void onErrorAfterChannel3StatusPrefersParsedExitCodeOverConnectionClose() throws Exception {
    // Reproduces the race in PodTest.testExecWithExitCode: channel-3 status frame is
    // received and queues handleExitStatus through the SerialExecutor; the peer then
    // closes the connection and onError fires before the deferred task runs.
    final Queue<Runnable> manualQueue = new ArrayDeque<>();
    final Executor manualExecutor = manualQueue::offer;

    final ExecWebSocketListener listener = new ExecWebSocketListener(new PodOperationContext(), manualExecutor,
        new KubernetesSerialization());
    final WebSocket mockedWebSocket = Mockito.mock(WebSocket.class);
    listener.onOpen(mockedWebSocket);

    // Channel 3: NonZeroExitCode=1 status frame
    final byte[] failureJson = new KubernetesSerialization().asJson(new StatusBuilder()
        .withStatus("Failure")
        .withReason("NonZeroExitCode")
        .withNewDetails().withCauses(new StatusCause("ExitCode", "1", "ExitCode")).endDetails()
        .build()).getBytes(StandardCharsets.UTF_8);
    final ByteBuffer channel3 = ByteBuffer.allocate(failureJson.length + 1)
        .put((byte) 3).put(failureJson);
    channel3.flip();
    listener.onMessage(mockedWebSocket, channel3);
    assertFalse(listener.exitCode().isDone(),
        "exitCode must remain pending while handleExitStatus is queued in the executor");

    // The connection closes before the deferred handleExitStatus has a chance to run
    listener.onError(mockedWebSocket, new IOException("Connection was closed"));
    assertFalse(listener.exitCode().isDone(),
        "exitCode must not be completed exceptionally while the queued handleExitStatus is still pending");

    // Drain: handleExitStatus must run first (parsed exit code), then the failure task
    // observes exitCode is already done and only logs.
    Runnable next;
    while ((next = manualQueue.poll()) != null) {
      next.run();
    }

    assertEquals(1, listener.exitCode().get(2, TimeUnit.SECONDS),
        "exitCode must resolve to the parsed value, not the connection-close exception");
  }

  @Test
  void onErrorWithExecListenerInvokesOnFailureWithThrowable() {
    final Queue<Runnable> manualQueue = new ArrayDeque<>();
    final Executor manualExecutor = manualQueue::offer;
    final java.util.concurrent.atomic.AtomicReference<Throwable> capturedThrowable = new java.util.concurrent.atomic.AtomicReference<>();
    final java.util.concurrent.atomic.AtomicReference<ExecListener.Response> capturedResponse = new java.util.concurrent.atomic.AtomicReference<>();
    final ExecListener execListener = new ExecListener() {
      @Override
      public void onFailure(Throwable t, Response failureResponse) {
        capturedThrowable.set(t);
        capturedResponse.set(failureResponse);
      }

      @Override
      public void onClose(int code, String reason) {
      }
    };
    final PodOperationContext context = new PodOperationContext().toBuilder()
        .execListener(execListener)
        .build();
    final ExecWebSocketListener listener = new ExecWebSocketListener(context, manualExecutor, new KubernetesSerialization());
    listener.onOpen(Mockito.mock(WebSocket.class));

    final IOException boom = new IOException("boom");
    listener.onError(null, boom);

    Runnable next;
    while ((next = manualQueue.poll()) != null) {
      next.run();
    }

    assertThat(capturedThrowable.get()).isSameAs(boom);
    assertNull(capturedResponse.get(), "non-handshake errors must not provide a SimpleResponse");
    assertThrows(KubernetesClientException.class, listener::checkError);
  }

  @Test
  void onErrorWithoutPendingExitStatusCompletesExitExceptionally() {
    final Queue<Runnable> manualQueue = new ArrayDeque<>();
    final Executor manualExecutor = manualQueue::offer;
    final ExecWebSocketListener listener = new ExecWebSocketListener(new PodOperationContext(), manualExecutor,
        new KubernetesSerialization());
    listener.onOpen(Mockito.mock(WebSocket.class));

    listener.onError(null, new IOException("boom"));
    assertFalse(listener.exitCode().isDone(),
        "exitCode completion is deferred through the SerialExecutor on error");

    Runnable next;
    while ((next = manualQueue.poll()) != null) {
      next.run();
    }

    assertThrows(KubernetesClientException.class, listener::checkError);
  }

  @Test
  void onMessageChannel2TerminateOnErrorCompletesExitAfterPendingChannel1Writes() throws Exception {
    final CountDownLatch writeStarted = new CountDownLatch(1);
    final CountDownLatch releaseWrite = new CountDownLatch(1);
    final OutputStream blockingOut = new OutputStream() {
      @Override
      public void write(int b) {
      }

      @Override
      public void write(byte[] b, int off, int len) throws IOException {
        writeStarted.countDown();
        try {
          if (!releaseWrite.await(5, TimeUnit.SECONDS)) {
            throw new IOException("write was not released");
          }
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
          throw new IOException(e);
        }
      }
    };
    final PodOperationContext context = new PodOperationContext().toBuilder()
        .output(new StreamContext(blockingOut))
        .terminateOnError(true)
        .build();
    final ExecutorService asyncExecutor = Executors.newSingleThreadExecutor();
    try {
      final ExecWebSocketListener listener = new ExecWebSocketListener(context, asyncExecutor, new KubernetesSerialization());
      final WebSocket mockedWebSocket = Mockito.mock(WebSocket.class);
      listener.onOpen(mockedWebSocket);

      // Channel 1 (stdout) message: queues an async write that will block until released
      listener.onMessage(mockedWebSocket, ByteBuffer.wrap(new byte[] { (byte) 1, (byte) 'p', (byte) 'a', (byte) 'y' }));
      assertTrue(writeStarted.await(2, TimeUnit.SECONDS), "expected the channel 1 async write to start");

      // Channel 2 (stderr) with terminateOnError=true: completes exitCode exceptionally
      listener.onMessage(mockedWebSocket,
          ByteBuffer.wrap(new byte[] { (byte) 2, (byte) 'b', (byte) 'o', (byte) 'o', (byte) 'm' }));

      // The exitCode must NOT complete (exceptionally) before the pending channel 1 write has been processed.
      assertThrows(TimeoutException.class, () -> listener.exitCode().get(200, TimeUnit.MILLISECONDS),
          "exitCode must not complete before pending channel 1 async writes finish");

      releaseWrite.countDown();
      final ExecutionException ex = assertThrows(ExecutionException.class,
          () -> listener.exitCode().get(2, TimeUnit.SECONDS));
      assertThat(ex.getCause()).isInstanceOf(KubernetesClientException.class);
    } finally {
      asyncExecutor.shutdownNow();
    }
  }

}
