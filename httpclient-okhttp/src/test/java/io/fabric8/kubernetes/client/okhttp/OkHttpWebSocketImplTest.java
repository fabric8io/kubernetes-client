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
package io.fabric8.kubernetes.client.okhttp;

import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.WebSocket;
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
import java.util.Base64;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

class OkHttpWebSocketImplTest {

  private static final String WEBSOCKET_GUID = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";

  @Test
  @DisplayName("a Close without status code (reported as 1005) is answered with 1000 instead of failing the WebSocket")
  void closeWithoutStatusCodeIsAnsweredWithNormalClosure() throws Exception {
    try (ServerSocket serverSocket = new ServerSocket(0, 1, InetAddress.getLoopbackAddress())) {
      // Given a server that sends an empty Close frame right after the handshake
      final CompletableFuture<Integer> serverReceivedCloseCode = CompletableFuture
          .supplyAsync(() -> sendCloseWithoutStatusCode(serverSocket));
      final CompletableFuture<Integer> clientReceivedClose = new CompletableFuture<>();
      try (HttpClient client = new OkHttpClientFactory().newBuilder().build()) {
        // When
        client.newWebSocketBuilder()
            .uri(URI.create("http://127.0.0.1:" + serverSocket.getLocalPort() + "/"))
            .buildAsync(new WebSocket.Listener() {
              @Override
              public void onClose(WebSocket webSocket, int code, String reason) {
                clientReceivedClose.complete(code);
              }

              @Override
              public void onError(WebSocket webSocket, Throwable error) {
                clientReceivedClose.completeExceptionally(error);
              }
            }).get(10L, TimeUnit.SECONDS);
        // Then
        assertThat(clientReceivedClose).succeedsWithin(10, TimeUnit.SECONDS).isEqualTo(1005);
        assertThat(serverReceivedCloseCode).succeedsWithin(10, TimeUnit.SECONDS).isEqualTo(1000);
      }
    }
  }

  /**
   * Accepts one WebSocket handshake, sends a Close frame without payload (RFC 6455 5.5.1 allows it, the receiver
   * reports 1005) and returns the status code of the Close frame the client answers with.
   */
  private static int sendCloseWithoutStatusCode(ServerSocket serverSocket) {
    try (Socket socket = serverSocket.accept()) {
      socket.setSoTimeout(10_000);
      final InputStream in = socket.getInputStream();
      final OutputStream out = socket.getOutputStream();
      final String accept = Base64.getEncoder().encodeToString(MessageDigest.getInstance("SHA-1")
          .digest((webSocketKey(in) + WEBSOCKET_GUID).getBytes(StandardCharsets.US_ASCII)));
      out.write(("HTTP/1.1 101 Switching Protocols\r\nUpgrade: websocket\r\nConnection: Upgrade\r\n" +
          "Sec-WebSocket-Accept: " + accept + "\r\n\r\n").getBytes(StandardCharsets.US_ASCII));
      out.write(new byte[] { (byte) 0x88, 0x00 }); // FIN + Close opcode, no payload
      out.flush();
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
