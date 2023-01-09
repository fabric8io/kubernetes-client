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
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

import static org.junit.Assert.assertEquals;

public class SslTest {

  private Vertx vertx;
  private HttpServer server;
  private volatile Handler<HttpServerRequest> requestHandler;
  private HttpClient.Factory clientFactory = new VertxHttpClientFactory();
  private TrustManager[] trustManagers;

  @Before
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
    server.listen(8443).toCompletionStage().toCompletableFuture().get(20, TimeUnit.SECONDS);
    TrustManagerFactory tmf = cert.trustOptions().getTrustManagerFactory(vertx);
    trustManagers = tmf.getTrustManagers();
  }

  @After
  public void after() throws Exception {
    vertx.close().toCompletionStage().toCompletableFuture().get(20, TimeUnit.SECONDS);
  }

  @Test
  public void testGet() throws Exception {
    requestHandler = req -> {
      req.response().end("OK");
    };
    HttpClient.Builder builder = clientFactory.newBuilder().sslContext(null, trustManagers);
    HttpClient client = builder.build();
    HttpRequest request = client.newHttpRequestBuilder().uri("https://localhost:8443").build();
    HttpResponse<String> resp = client.sendAsync(request, String.class).get(10, TimeUnit.SECONDS);
    assertEquals(200, resp.code());
    assertEquals("OK", resp.bodyString());
  }
}
