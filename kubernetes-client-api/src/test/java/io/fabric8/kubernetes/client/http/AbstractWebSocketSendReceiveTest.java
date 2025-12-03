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
package io.fabric8.kubernetes.client.http;

import io.fabric8.mockwebserver.DefaultMockServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class AbstractWebSocketSendReceiveTest {

  private static DefaultMockServer server;

  @BeforeAll
  static void beforeAll() {
    server = new DefaultMockServer(false);
    server.start();
  }

  @AfterAll
  static void afterAll() {
    server.shutdown();
  }

  protected abstract HttpClient.Factory getHttpClientFactory();

  @Test
  @DisplayName("send, emits a message to the server (the server responds to this message)")
  void sendEmitsMessageToWebSocketServer() throws Exception {
    try (
        final HttpClient client = getHttpClientFactory().newBuilder().build();
        // ensure that a derived builder works
        final var derivedClient = client.newBuilder().build()) {
      // Given
      server.expect().withPath("/send-text")
          .andUpgradeToWebSocket()
          .open()
          .expect("GiveMeSomething")
          .andEmit("received")
          .always()
          .done()
          .always();
      final BlockingQueue<String> receivedText = new ArrayBlockingQueue<>(1);
      // TODO: JDK HttpClient implementation doesn't work with ws URIs
      // - Currently we are using an HttpRequest.Builder which is then
      //   mapped to a WebSocket.Builder. We should probably use the WebSocket.Builder
      //   directly
      //.uri(URI.create(String.format("ws://%s:%s/send-text", server.getHostName(), server.getPort())))
      final var ws = derivedClient.newWebSocketBuilder()
          .uri(URI.create(server.url("send-text")))
          .buildAsync(new WebSocket.Listener() {
            @Override
            public void onMessage(WebSocket webSocket, String text) {
              assertTrue(receivedText.offer(text));
            }
          }).get(10L, TimeUnit.SECONDS);
      // When
      ws.send(ByteBuffer.wrap("GiveMeSomething".getBytes(StandardCharsets.UTF_8)));
      final String result = receivedText.poll(10L, TimeUnit.SECONDS);
      // Then
      assertThat(result).isEqualTo("received");
    }
  }

  @Test
  @DisplayName("receive multiframe message")
  void multiframeReceive() throws Exception {
    final String multiframe = "a".repeat(66000);
    try (
        final HttpClient client = getHttpClientFactory().newBuilder().build();
        // ensure that a derived builder works
        final var derivedClient = client.newBuilder().build()) {
      // Given
      server.expect().withPath("/receive-text")
          .andUpgradeToWebSocket()
          .open()
          .waitFor(5)
          .andEmit("received")
          .waitFor(5)
          .andEmit(multiframe)
          .done()
          .always();
      final BlockingQueue<String> receivedText = new ArrayBlockingQueue<>(1);
      // TODO: JDK HttpClient implementation doesn't work with ws URIs
      // - Currently we are using an HttpRequest.Builder which is then
      //   mapped to a WebSocket.Builder. We should probably use the WebSocket.Builder
      //   directly
      //.uri(URI.create(String.format("ws://%s:%s/receive-text", server.getHostName(), server.getPort())))
      derivedClient.newWebSocketBuilder()
          .uri(URI.create(server.url("receive-text")))
          .buildAsync(new WebSocket.Listener() {
            @Override
            public void onMessage(WebSocket webSocket, String text) {
              assertTrue(receivedText.offer(text));
              webSocket.request();
            }
          }).get(10L, TimeUnit.SECONDS);
      // When
      String result = receivedText.poll(10L, TimeUnit.SECONDS);
      // Then
      assertThat(result).isEqualTo("received");

      result = receivedText.poll(10L, TimeUnit.SECONDS);
      // Then
      assertThat(result).isEqualTo(multiframe);
    }
  }

}
