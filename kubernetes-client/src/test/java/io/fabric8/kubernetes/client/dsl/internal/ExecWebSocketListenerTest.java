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
import io.fabric8.kubernetes.client.dsl.internal.PodOperationContext.StreamContext;
import io.fabric8.kubernetes.client.http.WebSocket;
import io.fabric8.kubernetes.client.utils.KubernetesSerialization;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
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
      final String successJson = new KubernetesSerialization().asJson(new StatusBuilder().withStatus("Success").build());
      final byte[] channel3 = ("" + successJson).getBytes(StandardCharsets.UTF_8);
      listener.onMessage(mockedWebSocket, ByteBuffer.wrap(channel3));

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
