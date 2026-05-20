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

import io.fabric8.kubernetes.client.http.TestWebSocket;
import io.fabric8.kubernetes.client.utils.CommonThreadPool;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PortForwarderWebsocketListenerTest {

  private TestWebSocket webSocket;
  private ReadableByteChannel in;
  private WritableByteChannel out;
  private ByteArrayOutputStream outputContent;
  private PortForwarderWebsocketListener listener;

  @BeforeEach
  void setUp() {
    webSocket = new TestWebSocket();
    in = Channels.newChannel(new ByteArrayInputStream("THIS IS A TEST".getBytes(StandardCharsets.UTF_8)));
    outputContent = new ByteArrayOutputStream();
    out = Channels.newChannel(outputContent);
  }

  @AfterEach
  void tearDown() throws IOException {
    if (listener != null) {
      listener.onClose(null, 1337, "Test ended");
    }
    out.close();
    outputContent.close();
    in.close();
  }

  @Test
  void onOpen_shouldPipeInChannelToWebSocket() {
    listener = new PortForwarderWebsocketListener(in, out, CommonThreadPool.get());
    listener.onOpen(webSocket);
    // Then
    assertThat(webSocket.firstSent())
        .succeedsWithin(10, TimeUnit.SECONDS, InstanceOfAssertFactories.type(ByteBuffer.class))
        .satisfies(buf -> {
          final byte[] copy = new byte[buf.remaining()];
          buf.duplicate().get(copy);
          assertThat(new String(copy, StandardCharsets.UTF_8)).startsWith("\u0000THIS IS A TEST");
        });
    // Single send for the 14-byte payload; pipe() exits on EOF before a second send.
    assertThat(webSocket.getSent()).hasSize(1);
    assertThat(in.isOpen()).isTrue();
    assertThat(out.isOpen()).isTrue();
  }

  @Test
  void onOpen_withException_shouldCloseWebSocketAndStoreException() throws IOException {
    final ReadableByteChannel inWithException = mock(ReadableByteChannel.class);
    when(inWithException.read(any())).thenThrow(new IOException("Error reading packets"));
    listener = new PortForwarderWebsocketListener(inWithException, out, CommonThreadPool.get());
    listener.onOpen(webSocket);
    // Then
    assertThat(webSocket.firstClose()).succeedsWithin(10, TimeUnit.SECONDS);
    assertThat(listener.getClientThrowables())
        .singleElement()
        .asInstanceOf(InstanceOfAssertFactories.throwable(IOException.class))
        .hasMessage("Error reading packets");
  }

  @Test
  void onError_shouldStoreExceptionAndCloseChannels() {
    listener = new PortForwarderWebsocketListener(in, out, CommonThreadPool.get());
    listener.onError(webSocket, new RuntimeException("Server error"));
    // Then
    assertThat(listener.getServerThrowables())
        .singleElement()
        .asInstanceOf(InstanceOfAssertFactories.throwable(RuntimeException.class))
        .hasMessage("Server error");
    Awaitility.await().atMost(1, TimeUnit.SECONDS).until(() -> !in.isOpen());
    assertThat(out.isOpen()).isFalse();
  }

  @Test
  void onClose_shouldCloseChannels() {
    listener = new PortForwarderWebsocketListener(in, out, CommonThreadPool.get());
    listener.onClose(webSocket, 1337, "Test ended");
    // Then
    Awaitility.await().atMost(1, TimeUnit.SECONDS).until(() -> !in.isOpen());
    assertThat(listener.getServerThrowables()).isEmpty();
    assertThat(out.isOpen()).isFalse();
  }

  @Test
  void onMessage_shouldSkipTwoMessagesAndPipeTheThird() {
    listener = new PortForwarderWebsocketListener(in, out, CommonThreadPool.get());
    webSocket
        .onRequest(() -> listener.onMessage(webSocket, "SKIP 2"))
        .onRequest(() -> listener.onMessage(webSocket, ByteBuffer.wrap(
            ByteBuffer.allocate(18).put((byte) 0).put("PROCESSED MESSAGE".getBytes(StandardCharsets.UTF_8)).array())));
    // third request is intentionally unscripted (no-op)
    listener.onMessage(webSocket, "SKIP 1");
    // Then
    await().atMost(10, TimeUnit.SECONDS).until(() -> webSocket.requestCount() >= 3);
    assertThat(webSocket.requestCount()).isEqualTo(3);
    assertThat(outputContent.toString()).contains("PROCESSED MESSAGE");
  }

  @Test
  void onMessage_withEmptyMessage_shouldEndWithError() {
    listener = new PortForwarderWebsocketListener(in, out, CommonThreadPool.get());
    webSocket
        .onRequest(() -> listener.onMessage(webSocket, "SKIP 2"))
        .onRequest(() -> listener.onMessage(webSocket, ByteBuffer.wrap(new byte[0])));
    listener.onMessage(webSocket, "SKIP 1");
    // Then
    assertThat(webSocket.firstClose())
        .succeedsWithin(10, TimeUnit.SECONDS)
        .isEqualTo(new TestWebSocket.CloseFrame(1002, "Protocol error"));
    await().atMost(10, TimeUnit.SECONDS).until(() -> !listener.isAlive());
    assertThat(outputContent.toString()).isEmpty();
    assertThat(listener.errorOccurred()).isTrue();
    assertThat(listener.getServerThrowables()).isNotEmpty();
    await().atMost(1, TimeUnit.SECONDS).until(() -> !in.isOpen());
    assertThat(out.isOpen()).isFalse();
  }

  @Test
  void onMessage_withServerClose_shouldSkipTwoMessagesAndPipeTheThird() {
    listener = new PortForwarderWebsocketListener(in, out, CommonThreadPool.get());
    webSocket
        .onRequest(() -> listener.onMessage(webSocket, "SKIP 2"))
        .onRequest(() -> listener.onMessage(webSocket, ByteBuffer.wrap(
            ByteBuffer.allocate(18).put((byte) 0).put("PROCESSED MESSAGE".getBytes(StandardCharsets.UTF_8)).array())))
        .onRequest(() -> listener.onClose(webSocket, 31337, "Transmission complete"));
    listener.onMessage(webSocket, "SKIP 1");
    // Then
    await().atMost(10, TimeUnit.SECONDS).until(() -> !listener.isAlive());
    assertThat(outputContent.toString()).contains("PROCESSED MESSAGE");
    assertThat(listener.errorOccurred()).isFalse();
    assertThat(in.isOpen()).isFalse();
    assertThat(out.isOpen()).isFalse();
  }

  @Test
  void onMessage_withWrongChannel_shouldLogAndEndWithError() {
    listener = new PortForwarderWebsocketListener(in, out, CommonThreadPool.get());
    webSocket
        .onRequest(() -> listener.onMessage(webSocket, "SKIP 2"))
        .onRequest(() -> listener.onMessage(webSocket, ByteBuffer.wrap(
            ByteBuffer.allocate(18).put((byte) 5).put("WRONG CHANNEL".getBytes(StandardCharsets.UTF_8)).array())));
    // third request is intentionally unscripted (no-op)
    listener.onMessage(webSocket, "SKIP 1");
    // Then
    assertThat(webSocket.firstClose())
        .succeedsWithin(10, TimeUnit.SECONDS)
        .isEqualTo(new TestWebSocket.CloseFrame(1002, "Protocol error"));
    await().atMost(10, TimeUnit.SECONDS).until(() -> !listener.isAlive());
    assertThat(outputContent.toString()).isEmpty();
    assertThat(listener.errorOccurred()).isTrue();
    assertThat(listener.getServerThrowables().iterator().next().getMessage())
        .isEqualTo("Received a wrong channel from the remote socket: 5");
  }
}
