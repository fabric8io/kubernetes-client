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

import io.fabric8.kubernetes.client.http.WebSocket;
import io.fabric8.kubernetes.client.utils.CommonThreadPool;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.MockedStatic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class PortForwarderWebsocketListenerTest {

  private WebSocket webSocket;
  private ReadableByteChannel in;
  private WritableByteChannel out;
  private ByteArrayOutputStream outputContent;
  private PortForwarderWebsocketListener listener;

  @BeforeEach
  void setUp() {
    webSocket = mock(WebSocket.class);
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
    ArgumentCaptor<ByteBuffer> contentTypeCaptor = ArgumentCaptor.forClass(ByteBuffer.class);
    // Then
    verify(webSocket, timeout(10_000).times(1)).send(contentTypeCaptor.capture());
    assertThat(contentTypeCaptor.getValue())
        .extracting(StandardCharsets.UTF_8::decode)
        .extracting(CharBuffer::toString).asString()
        .startsWith("THIS IS A TEST");
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
    verify(webSocket, timeout(10_000).times(1)).sendClose(anyInt(), anyString());
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
    assertThat(in.isOpen()).isFalse();
    assertThat(out.isOpen()).isFalse();
  }

  @Test
  void onClose_shouldCloseChannels() {
    listener = new PortForwarderWebsocketListener(in, out, CommonThreadPool.get());
    listener.onClose(webSocket, 1337, "Test ended");
    // Then
    assertThat(listener.getServerThrowables()).isEmpty();
    assertThat(in.isOpen()).isFalse();
    assertThat(out.isOpen()).isFalse();
  }

  @Test
  void onMessage_shouldSkipTwoMessagesAndPipeTheThird() {
    listener = new PortForwarderWebsocketListener(in, out, CommonThreadPool.get());
    doAnswer(i -> {
      listener.onMessage(webSocket, "SKIP 2");
      return true;
    }).doAnswer(i -> {
      listener.onMessage(webSocket, ByteBuffer.wrap(
          ByteBuffer.allocate(18).put((byte) 0).put("PROCESSED MESSAGE".getBytes(StandardCharsets.UTF_8)).array()));
      return true;
    })
        .doNothing()
        .when(webSocket).request();
    listener.onMessage(webSocket, "SKIP 1");
    // Then
    verify(webSocket, timeout(10_000).times(3)).request();
    assertThat(outputContent.toString()).contains("PROCESSED MESSAGE");
  }

  @Test
  void onMessage_withEmptyMessage_shouldEndWithError() {
    listener = new PortForwarderWebsocketListener(in, out, CommonThreadPool.get());
    doAnswer(i -> {
      listener.onMessage(webSocket, "SKIP 2");
      return true;
    }).doAnswer(i -> {
      listener.onMessage(webSocket, ByteBuffer.wrap(new byte[0]));
      return true;
    }).when(webSocket).request();
    listener.onMessage(webSocket, "SKIP 1");
    // Then
    verify(webSocket, timeout(10_000)).sendClose(1002, "Protocol error");
    assertThat(outputContent.toString()).isEmpty();
    assertThat(listener.errorOccurred()).isTrue();
    assertThat(listener.getServerThrowables()).isNotEmpty();
    assertThat(in.isOpen()).isFalse();
    assertThat(out.isOpen()).isFalse();
  }

  @Test
  void onMessage_withServerClose_shouldSkipTwoMessagesAndPipeTheThird() {
    listener = new PortForwarderWebsocketListener(in, out, CommonThreadPool.get());
    doAnswer(i -> {
      listener.onMessage(webSocket, "SKIP 2");
      return true;
    }).doAnswer(i -> {
      listener.onMessage(webSocket, ByteBuffer.wrap(
          ByteBuffer.allocate(18).put((byte) 0).put("PROCESSED MESSAGE".getBytes(StandardCharsets.UTF_8)).array()));
      return true;
    }).doAnswer(i -> {
      listener.onClose(webSocket, 31337, "Transmission complete");
      return true;
    }).when(webSocket).request();
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
    try (MockedStatic<LoggerFactory> loggerFactory = mockStatic(LoggerFactory.class)) {
      final Logger logger = mock(Logger.class);
      loggerFactory.when(() -> LoggerFactory.getLogger(PortForwarderWebsocketListener.class)).thenReturn(logger);
      listener = new PortForwarderWebsocketListener(in, out, CommonThreadPool.get());
      doAnswer(i -> {
        listener.onMessage(webSocket, "SKIP 2");
        return true;
      }).doAnswer(i -> {
        listener.onMessage(webSocket, ByteBuffer.wrap(
            ByteBuffer.allocate(18).put((byte) 5).put("WRONG CHANNEL".getBytes(StandardCharsets.UTF_8)).array()));
        return true;
      })
          .doNothing()
          .when(webSocket).request();
      listener.onMessage(webSocket, "SKIP 1");
      // Then
      verify(webSocket, timeout(10_000)).sendClose(1002, "Protocol error");
      assertThat(outputContent.toString()).isEmpty();
      assertThat(listener.errorOccurred()).isTrue();
      assertThat(listener.getServerThrowables().iterator().next().getMessage())
          .isEqualTo("Received a wrong channel from the remote socket: 5");
    }

  }
}
