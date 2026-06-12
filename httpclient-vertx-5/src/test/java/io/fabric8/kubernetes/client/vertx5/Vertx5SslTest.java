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

import io.fabric8.kubernetes.client.RequestConfigBuilder;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.http.HttpResponse;
import io.fabric8.kubernetes.client.internal.SSLUtils;
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

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Vertx5SslTest {

  private Vertx vertx;
  private HttpServer server;
  private int port;
  private volatile Handler<HttpServerRequest> requestHandler;
  private HttpClient.Factory clientFactory = new Vertx5HttpClientFactory();
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
  @DisplayName("HTTPS rejects an untrusted server certificate instead of falling back to a permissive trust")
  void httpsRejectsUntrustedCertificate() throws Exception {
    requestHandler = req -> req.response().end("OK");
    // Default JVM trust store does not contain the server's self-signed certificate, so the unified
    // TLS configuration must reject it rather than silently trusting everything.
    final TrustManager[] untrustingManagers = SSLUtils.trustManagers(null, null, false, null, null);
    final HttpClient client = clientFactory.newBuilder()
        .sslContext(null, untrustingManagers)
        // Disable retries so the handshake failure surfaces on the first attempt instead of being
        // retried until the get() timeout.
        .tag(new RequestConfigBuilder().withRequestRetryBackoffLimit(0).build())
        .build();
    final HttpRequest request = client.newHttpRequestBuilder().uri("https://localhost:" + port).build();
    assertThrows(ExecutionException.class, () -> client.sendAsync(request, String.class).get(10, TimeUnit.SECONDS));
  }
}
