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

import io.fabric8.kubernetes.api.model.StatusBuilder;
import io.fabric8.kubernetes.api.model.StatusCause;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.http.WebSocket;
import io.fabric8.kubernetes.client.utils.KubernetesSerialization;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.nio.ByteBuffer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
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

}
