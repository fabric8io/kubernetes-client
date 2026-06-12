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
package io.fabric8.kubernetes.client.vertx5;

import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.http.HttpResponse;
import io.fabric8.kubernetes.client.http.WebSocket;
import io.vertx.core.Vertx;
import io.vertx.core.http.ClientAuth;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.core.net.SelfSignedCertificate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.KeyManager;
import javax.net.ssl.TrustManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Mutual-TLS (client certificate) coverage for the unified SSL configuration. The unify change
 * (fabric8io/kubernetes-client#7907) also moved the HTTP path's key material from a pre-built
 * {@code SSLContext} carried inside a custom {@code SslContextFactory} to {@code KeyCertOptions},
 * so this verifies that the client still presents its certificate over both HTTP and WebSocket
 * (client-certificate kubeconfig auth, exercised by the E2E suite).
 */
class Vertx5MutualTlsTest {

  private Vertx vertx;
  private HttpServer server;
  private int port;
  private final HttpClient.Factory clientFactory = new Vertx5HttpClientFactory();
  private KeyManager[] keyManagers;
  private TrustManager[] trustManagers;

  @BeforeEach
  public void before() throws Exception {
    final SelfSignedCertificate serverCert = SelfSignedCertificate.create();
    final SelfSignedCertificate clientCert = SelfSignedCertificate.create();
    vertx = Vertx.vertx();
    server = vertx.createHttpServer(new HttpServerOptions()
        .setSsl(true)
        .setKeyCertOptions(serverCert.keyCertOptions())
        .setClientAuth(ClientAuth.REQUIRED)
        .setTrustOptions(clientCert.trustOptions()))
        .requestHandler(req -> req.response().end("OK"))
        .webSocketHandler(ws -> ws.writeTextMessage("hello"));
    server.listen(0).toCompletionStage().toCompletableFuture().get(20, TimeUnit.SECONDS);
    port = server.actualPort();
    // The client trusts the server's certificate and presents its own (which the server trusts).
    keyManagers = clientCert.keyCertOptions().getKeyManagerFactory(vertx).getKeyManagers();
    trustManagers = serverCert.trustOptions().getTrustManagerFactory(vertx).getTrustManagers();
  }

  @AfterEach
  public void after() throws Exception {
    vertx.close().toCompletionStage().toCompletableFuture().get(20, TimeUnit.SECONDS);
  }

  @Test
  @DisplayName("HTTP-over-mutual-TLS presents the client certificate and completes the request")
  void httpOverMutualTls() throws Exception {
    try (HttpClient client = clientFactory.newBuilder().sslContext(keyManagers, trustManagers).build()) {
      final HttpRequest request = client.newHttpRequestBuilder().uri("https://localhost:" + port).build();
      final HttpResponse<String> resp = client.sendAsync(request, String.class).get(10, TimeUnit.SECONDS);
      assertEquals(200, resp.code());
      assertEquals("OK", resp.bodyString());
    }
  }

  @Test
  @DisplayName("WebSocket-over-mutual-TLS presents the client certificate and completes the upgrade")
  void webSocketOverMutualTls() throws Exception {
    try (HttpClient client = clientFactory.newBuilder().sslContext(keyManagers, trustManagers).build()) {
      final BlockingQueue<String> receivedText = new ArrayBlockingQueue<>(1);
      client.newWebSocketBuilder()
          .uri(URI.create("https://localhost:" + port))
          .buildAsync(new WebSocket.Listener() {
            @Override
            public void onMessage(WebSocket webSocket, String text) {
              assertTrue(receivedText.offer(text));
            }
          }).get(10, TimeUnit.SECONDS);
      assertEquals("hello", receivedText.poll(10, TimeUnit.SECONDS));
    }
  }
}
