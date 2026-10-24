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
package io.fabric8.kubernetes.client.jdkhttp;

import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.WebSocket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.time.Duration;
import java.util.Base64;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.after;
import static org.mockito.Mockito.clearInvocations;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class JdkWebSocketImplTest {

  private static final String WEBSOCKET_GUID = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";

  private java.net.http.WebSocket jdkWebSocket;

  @BeforeEach
  void setUp() {
    jdkWebSocket = mock(java.net.http.WebSocket.class);
    when(jdkWebSocket.sendPing(any())).thenReturn(CompletableFuture.completedFuture(jdkWebSocket));
  }

  @Test
  @DisplayName("With a ping interval, sends pings while open and stops once closed (the ping task doesn't outlive the socket)")
  void pingsStopOnClose() {
    // Given
    final JdkWebSocketImpl webSocket = new JdkWebSocketImpl(new WebSocket.Listener() {
    }, Duration.ofMillis(10));
    webSocket.onOpen(jdkWebSocket);
    verify(jdkWebSocket, timeout(5000).atLeast(2)).sendPing(any());
    // When
    webSocket.onClose(jdkWebSocket, 1000, "done");
    clearInvocations(jdkWebSocket);
    // Then
    verify(jdkWebSocket, after(200).atMost(1)).sendPing(any());
  }

  @Test
  @DisplayName("With a ping interval, stops sending pings after an error")
  void pingsStopOnError() {
    // Given
    final JdkWebSocketImpl webSocket = new JdkWebSocketImpl(new WebSocket.Listener() {
    }, Duration.ofMillis(10));
    webSocket.onOpen(jdkWebSocket);
    verify(jdkWebSocket, timeout(5000).atLeast(2)).sendPing(any());
    // When
    webSocket.onError(jdkWebSocket, new Exception("broken"));
    clearInvocations(jdkWebSocket);
    // Then
    verify(jdkWebSocket, after(200).atMost(1)).sendPing(any());
  }

  @Test
  @DisplayName("Without a ping interval, sends no pings")
  void noPingsWithoutInterval() {
    new JdkWebSocketImpl(new WebSocket.Listener() {
    }, null).onOpen(jdkWebSocket);
    verify(jdkWebSocket, after(200).never()).sendPing(any());
  }

  @Test
  @DisplayName("A listener echoing the 1006 (closed abnormally) of a connection dropped without Close frame closes with 1000 instead of failing the WebSocket")
  void echoedAbnormalClosureIsSentAsNormalClosure() throws Exception {
    try (ServerSocket serverSocket = new ServerSocket(0, 1, InetAddress.getLoopbackAddress())) {
      // Given a server that drops the connection right after the handshake, without a Close frame
      final CompletableFuture<Integer> serverReceivedCloseCode = CompletableFuture
          .supplyAsync(() -> dropConnectionWithoutCloseFrame(serverSocket));
      final CompletableFuture<Integer> clientReceivedClose = new CompletableFuture<>();
      try (HttpClient client = new JdkHttpClientFactory().newBuilder().build()) {
        // When the listener echoes the received code, as the watch does
        client.newWebSocketBuilder()
            .uri(URI.create("http://127.0.0.1:" + serverSocket.getLocalPort() + "/"))
            .buildAsync(new WebSocket.Listener() {
              @Override
              public void onClose(WebSocket webSocket, int code, String reason) {
                clientReceivedClose.complete(code);
                webSocket.sendClose(code, reason);
              }

              @Override
              public void onError(WebSocket webSocket, Throwable error) {
                clientReceivedClose.completeExceptionally(error);
              }
            }).get(10L, TimeUnit.SECONDS);
        // Then
        assertThat(clientReceivedClose).succeedsWithin(10, TimeUnit.SECONDS).isEqualTo(1006);
        assertThat(serverReceivedCloseCode).succeedsWithin(10, TimeUnit.SECONDS).isEqualTo(1000);
      }
    }
  }

  /**
   * Accepts one WebSocket handshake, shuts down the output without sending a Close frame (the client reports 1006)
   * and returns the status code of the Close frame the client sends.
   */
  private static int dropConnectionWithoutCloseFrame(ServerSocket serverSocket) {
    try (Socket socket = serverSocket.accept()) {
      socket.setSoTimeout(10_000);
      final InputStream in = socket.getInputStream();
      final OutputStream out = socket.getOutputStream();
      final String accept = Base64.getEncoder().encodeToString(MessageDigest.getInstance("SHA-1")
          .digest((webSocketKey(in) + WEBSOCKET_GUID).getBytes(StandardCharsets.US_ASCII)));
      out.write(("HTTP/1.1 101 Switching Protocols\r\nUpgrade: websocket\r\nConnection: Upgrade\r\n" +
          "Sec-WebSocket-Accept: " + accept + "\r\n\r\n").getBytes(StandardCharsets.US_ASCII));
      out.flush();
      socket.shutdownOutput(); // the client reads the end of the stream, as when the API server goes away
      // Client frames are masked: FIN + Close opcode, mask bit + 2-byte length, 4-byte mask, 2-byte status code
      final byte[] frame = in.readNBytes(8);
      assertThat(frame).hasSize(8).startsWith((byte) 0x88, (byte) 0x82);
      return ((frame[6] ^ frame[2]) & 0xFF) << 8 | ((frame[7] ^ frame[3]) & 0xFF);
    } catch (IOException | GeneralSecurityException e) {
      throw new IllegalStateException(e);
    }
  }

  private static String webSocketKey(InputStream in) throws IOException {
    final ByteArrayOutputStream headers = new ByteArrayOutputStream();
    while (!headers.toString(StandardCharsets.US_ASCII).endsWith("\r\n\r\n")) {
      final int b = in.read();
      if (b == -1) {
        throw new IOException("Connection closed before the end of the handshake request");
      }
      headers.write(b);
    }
    for (String line : headers.toString(StandardCharsets.US_ASCII).split("\r\n")) {
      if (line.toLowerCase(Locale.ROOT).startsWith("sec-websocket-key:")) {
        return line.substring(line.indexOf(':') + 1).trim();
      }
    }
    throw new IOException("Handshake request without Sec-WebSocket-Key");
  }
}
