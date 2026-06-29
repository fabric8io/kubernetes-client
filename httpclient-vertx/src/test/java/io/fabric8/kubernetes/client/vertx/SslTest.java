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
package io.fabric8.kubernetes.client.vertx;

import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.http.HttpResponse;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.net.SelfSignedCertificate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SslTest {

  private Vertx vertx;
  private HttpServer server;
  private int port;
  private volatile Handler<HttpServerRequest> requestHandler;
  private HttpClient.Factory clientFactory = new VertxHttpClientFactory();
  private TrustManager[] trustManagers;

  @BeforeEach
  public void before() throws Exception {
    SelfSignedCertificate cert = SelfSignedCertificate.create();
    vertx = Vertx.vertx();
    server = vertx.createHttpServer(new HttpServerOptions()
        .setSsl(true)
        .setKeyCertOptions(cert.keyCertOptions()))
        .requestHandler(req -> {
          Handler<HttpServerRequest> handler = requestHandler;
          if (handler != null) {
            handler.handle(req);
          } else {
            req.response().setStatusCode(404).end();
          }
        });
    server.listen(0).toCompletionStage().toCompletableFuture().get(20, TimeUnit.SECONDS);
    port = server.actualPort();
    TrustManagerFactory tmf = cert.trustOptions().getTrustManagerFactory(vertx);
    trustManagers = tmf.getTrustManagers();
  }

  @AfterEach
  public void after() throws Exception {
    vertx.close().toCompletionStage().toCompletableFuture().get(20, TimeUnit.SECONDS);
  }

  @Test
  void testGet() throws Exception {
    requestHandler = req -> {
      req.response().end("OK");
    };
    HttpClient.Builder builder = clientFactory.newBuilder().sslContext(null, trustManagers);
    HttpClient client = builder.build();
    HttpRequest request = client.newHttpRequestBuilder().uri("https://localhost:" + port).build();
    HttpResponse<String> resp = client.sendAsync(request, String.class).get(10, TimeUnit.SECONDS);
    assertEquals(200, resp.code());
    assertEquals("OK", resp.bodyString());
  }

  @Test
  @DisplayName("TLS warm-up defaults to CONTEXT so existing clients keep the #7922 eager context pre-build unchanged")
  void tlsWarmupDefaultsToContext() {
    assertEquals(TlsWarmup.CONTEXT, new VertxHttpClientFactory().getTlsWarmup());
  }

  @Test
  @DisplayName("A null TLS warm-up mode falls back to CONTEXT rather than disabling the warm-up")
  void tlsWarmupSetterRejectsNull() {
    final VertxHttpClientFactory factory = new VertxHttpClientFactory();
    factory.setTlsWarmup(null);
    assertEquals(TlsWarmup.CONTEXT, factory.getTlsWarmup());
  }

  @Test
  @DisplayName("setTlsWarmup round-trips each mode (OFF, CONTEXT, FULL) through getTlsWarmup")
  void tlsWarmupRoundTripsAllModes() {
    final VertxHttpClientFactory factory = new VertxHttpClientFactory();
    factory.setTlsWarmup(TlsWarmup.OFF);
    assertEquals(TlsWarmup.OFF, factory.getTlsWarmup());
    factory.setTlsWarmup(TlsWarmup.FULL);
    assertEquals(TlsWarmup.FULL, factory.getTlsWarmup());
    factory.setTlsWarmup(TlsWarmup.CONTEXT);
    assertEquals(TlsWarmup.CONTEXT, factory.getTlsWarmup());
  }

  @Test
  @DisplayName("FULL TLS warm-up is harmless and idempotent: two successive FULL client builds both connect over HTTPS")
  void fullTlsWarmupIsHarmlessAndIdempotent() throws Exception {
    requestHandler = req -> req.response().end("OK");
    final VertxHttpClientFactory factory = new VertxHttpClientFactory();
    factory.setTlsWarmup(TlsWarmup.FULL);
    for (int i = 0; i < 2; i++) {
      try (HttpClient client = factory.newBuilder().sslContext(null, trustManagers).build()) {
        HttpRequest request = client.newHttpRequestBuilder().uri("https://localhost:" + port).build();
        HttpResponse<String> resp = client.sendAsync(request, String.class).get(30, TimeUnit.SECONDS);
        assertEquals(200, resp.code());
        assertEquals("OK", resp.bodyString());
      }
    }
  }

  @Test
  @DisplayName("OFF TLS warm-up skips the eager context pre-build yet a client built with it still connects over HTTPS")
  void offTlsWarmupClientConnectsOverHttps() throws Exception {
    requestHandler = req -> req.response().end("OK");
    final VertxHttpClientFactory factory = new VertxHttpClientFactory();
    factory.setTlsWarmup(TlsWarmup.OFF);
    try (HttpClient client = factory.newBuilder().sslContext(null, trustManagers).build()) {
      HttpRequest request = client.newHttpRequestBuilder().uri("https://localhost:" + port).build();
      HttpResponse<String> resp = client.sendAsync(request, String.class).get(10, TimeUnit.SECONDS);
      assertEquals(200, resp.code());
      assertEquals("OK", resp.bodyString());
    }
  }
}
