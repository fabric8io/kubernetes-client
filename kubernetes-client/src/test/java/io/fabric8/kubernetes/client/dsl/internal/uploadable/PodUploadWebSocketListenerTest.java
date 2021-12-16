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
package io.fabric8.kubernetes.client.dsl.internal.uploadable;

import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.http.WebSocket;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.nio.ByteBuffer;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

class PodUploadWebSocketListenerTest {

  private PodUploadWebSocketListener podUploadWebSocketListener;

  @BeforeEach
  void setUp() {
    podUploadWebSocketListener = new PodUploadWebSocketListener();
  }

  @AfterEach
  void tearDown() {
    podUploadWebSocketListener = null;
  }

  @Test
  void testSendShouldTruncateAndSendFlaggedWebSocketData() {
    final WebSocket mockedWebSocket = Mockito.mock(WebSocket.class);
    podUploadWebSocketListener.onOpen(mockedWebSocket);
    final byte[] toSend = new byte[]{1, 3, 3, 7, 0};

    podUploadWebSocketListener.send(toSend, 4);

    verify(mockedWebSocket, times(1))
      .send(eq(ByteBuffer.wrap(new byte[] {(byte) 0, (byte) 1, (byte) 3, (byte) 3, (byte) 7})));
  }

  @Test()
  void testCheckErrorHasErrorFromMessageShouldThrowException() {
    podUploadWebSocketListener.onMessage(null, ByteBuffer.wrap("Error".getBytes()));

    assertThrows(KubernetesClientException.class, () -> podUploadWebSocketListener.checkError());
  }

  @Test()
  void testCheckErrorHasErrorFromFailureShouldThrowException() {
    podUploadWebSocketListener.onError(null, new IOException("here"));

    assertThrows(KubernetesClientException.class, () -> podUploadWebSocketListener.checkError());
  }
}
