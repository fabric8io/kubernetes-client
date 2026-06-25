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

import java.io.IOException;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLException;
import javax.net.ssl.TrustManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
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

  @Test
  @DisplayName("Untrusted cert fails fast with default retry policy instead of draining ~19s backoff")
  void untrustedCertFailsFastWithDefaultRetryPolicy() throws Exception {
    // JVM default trust managers won't trust the server's self-signed cert
    TrustManager[] untrustedManagers = SSLUtils.trustManagers(null, null, false, null, null);
    try (HttpClient client = getHttpClientFactory().newBuilder().sslContext(null, untrustedManagers).build()) {
      long start = System.nanoTime();
      CompletableFuture<WebSocket> future = client.newWebSocketBuilder()
          .uri(URI.create(server.url("secure-ws")))
          .buildAsync(new WebSocket.Listener() {
          });
      assertThatThrownBy(() -> future.get(10, TimeUnit.SECONDS))
          .isInstanceOf(ExecutionException.class)
          .cause()
          .isInstanceOf(IOException.class)
          .satisfies(cause -> assertThat(hasSslExceptionInTree(cause))
              .as("cause/suppressed tree should contain an SSLException: %s", cause)
              .isTrue());
      long elapsedMs = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start);
      assertThat(elapsedMs)
          .as("should fail fast, not drain the ~19s default backoff schedule")
          .isLessThan(10_000);
    }
  }

  private static boolean hasSslExceptionInTree(Throwable throwable) {
    Set<Throwable> visited = Collections.newSetFromMap(new IdentityHashMap<>());
    return hasSslExceptionInTree(throwable, visited);
  }

  private static boolean hasSslExceptionInTree(Throwable throwable, Set<Throwable> visited) {
    if (throwable == null || !visited.add(throwable)) {
      return false;
    }
    if (throwable instanceof SSLException) {
      return true;
    }
    if (hasSslExceptionInTree(throwable.getCause(), visited)) {
      return true;
    }
    for (Throwable suppressed : throwable.getSuppressed()) {
      if (hasSslExceptionInTree(suppressed, visited)) {
        return true;
      }
    }
    return false;
  }
}
