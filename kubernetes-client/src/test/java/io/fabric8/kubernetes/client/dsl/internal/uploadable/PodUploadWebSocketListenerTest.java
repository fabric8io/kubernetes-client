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
import okhttp3.Response;
import okhttp3.WebSocket;
import okio.ByteString;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
    podUploadWebSocketListener.onOpen(mockedWebSocket, null);
    final byte[] toSend = new byte[]{1, 3, 3, 7, 0};

    podUploadWebSocketListener.send(toSend, 4);

    verify(mockedWebSocket, times(1))
      .send(eq(ByteString.of((byte) 0, (byte) 1, (byte) 3, (byte) 3, (byte) 7)));
  }

  @Test()
  void testCheckErrorHasErrorFromMessageShouldThrowException() {
    podUploadWebSocketListener.onMessage(null, ByteString.encodeUtf8("ACK"));
    podUploadWebSocketListener.onMessage(null, ByteString.encodeUtf8("![\"I'M AN ERROR\"]"));

    assertThrows(KubernetesClientException.class, () -> podUploadWebSocketListener.checkError());
  }

  @Test()
  void testCheckErrorHasErrorFromFailureShouldThrowException() {
    final Response mockResponse = Mockito.mock(Response.class, Mockito.RETURNS_DEEP_STUBS);
    when(mockResponse.code()).thenReturn(1337);
    when(mockResponse.message()).thenReturn("Error");
    when(mockResponse.body().toString()).thenReturn("Detailed error description");
    podUploadWebSocketListener.onFailure(null, null, mockResponse);

    assertThrows(KubernetesClientException.class, () -> podUploadWebSocketListener.checkError());
  }
}
