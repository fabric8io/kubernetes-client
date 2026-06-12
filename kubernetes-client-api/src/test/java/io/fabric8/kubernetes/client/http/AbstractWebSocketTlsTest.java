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

import io.fabric8.kubernetes.client.internal.SSLUtils;
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

import javax.net.ssl.TrustManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class AbstractWebSocketTlsTest {

  private static DefaultMockServer server;
  private static TrustManager[] trustManagers;

  @BeforeAll
  static void beforeAll() throws Exception {
    server = new DefaultMockServer(true);
    server.start();
    // Trust only the server's self-signed certificate (not the JVM default trust store), so the
    // handshake exercises the supplied trust material exactly as a real cluster CA would.
    trustManagers = SSLUtils.trustManagers(null, server.getSelfSignedCertificate().certificatePath(), false, null, null);
  }

  @AfterAll
  static void afterAll() {
    server.shutdown();
  }

  protected abstract HttpClient.Factory getHttpClientFactory();

  @Test
  @DisplayName("WebSocket-over-TLS completes the upgrade trusting the supplied certificate and round-trips a message")
  void secureWebSocketConnectsAndRoundTripsMessage() throws Exception {
    try (HttpClient client = getHttpClientFactory().newBuilder().sslContext(null, trustManagers).build()) {
      // Given
      server.expect().withPath("/secure-ws")
          .andUpgradeToWebSocket()
          .open()
          .expect("GiveMeSomething")
          .andEmit("received")
          .always()
          .done()
          .always();
      final BlockingQueue<String> receivedText = new ArrayBlockingQueue<>(1);
      final WebSocket ws = client.newWebSocketBuilder()
          .uri(URI.create(server.url("secure-ws")))
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
}
