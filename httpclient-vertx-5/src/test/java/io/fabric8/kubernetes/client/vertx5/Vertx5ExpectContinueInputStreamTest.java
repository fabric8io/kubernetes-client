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
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.net.URI;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Vertx5ExpectContinueInputStream")
class Vertx5ExpectContinueInputStreamTest {

  private Vertx vertx;
  private int serverPort;
  private final AtomicBoolean continueSent = new AtomicBoolean(false);
  private final HttpClient.Factory factory = new Vertx5HttpClientFactory();

  @BeforeEach
  void setUp() throws Exception {
    vertx = Vertx.vertx();
    continueSent.set(false);

    HttpServer server = vertx.createHttpServer();
    server.requestHandler(req -> {
      if ("100-continue".equalsIgnoreCase(req.getHeader("Expect"))) {
        continueSent.set(true);
        req.response().writeContinue();
      }
      req.bodyHandler(body -> req.response().setStatusCode(200).end("OK:" + body.length()));
    });

    server.listen(0).toCompletionStage().toCompletableFuture().get(20, TimeUnit.SECONDS);
    serverPort = server.actualPort();
  }

  @AfterEach
  void after() throws Exception {
    vertx.close().toCompletionStage().toCompletableFuture().get(20, TimeUnit.SECONDS);
  }

  @Test
  @DisplayName("Should upload InputStream with Expect: 100-continue and known length")
  void testInputStreamWithExpectContinueAndKnownLength() throws Exception {
    byte[] data = new byte[256 * 1024]; // 256 KiB
    InputStream is = new ByteArrayInputStream(data);

    try (HttpClient client = factory.newBuilder().build()) {
      HttpRequest request = client.newHttpRequestBuilder()
          .uri(URI.create("http://localhost:" + serverPort + "/upload"))
          .expectContinue()
          .post("application/octet-stream", is, data.length)
          .build();

      HttpResponse<String> response = client.sendAsync(request, String.class).get();

      assertThat(response.code()).isEqualTo(200);
      assertThat(response.body()).isEqualTo("OK:" + data.length);
      assertThat(continueSent.get()).isTrue();
    }
  }

  @Test
  @DisplayName("Should upload InputStream with Expect: 100-continue and unknown length")
  void testInputStreamWithExpectContinueAndUnknownLength() throws Exception {
    byte[] data = new byte[256 * 1024]; // 256 KiB
    InputStream is = new SequenceInputStream(new ByteArrayInputStream(data), InputStream.nullInputStream());

    try (HttpClient client = factory.newBuilder().build()) {
      HttpRequest request = client.newHttpRequestBuilder()
          .uri(URI.create("http://localhost:" + serverPort + "/upload"))
          .expectContinue()
          .post("application/octet-stream", is, -1)
          .build();

      HttpResponse<String> response = client.sendAsync(request, String.class).get();

      assertThat(response.code()).isEqualTo(200);
      assertThat(response.body()).isEqualTo("OK:" + data.length);
      assertThat(continueSent.get()).isTrue();
    }
  }

  @Test
  @DisplayName("Should upload InputStream without Expect: 100-continue")
  void testInputStreamWithoutExpectContinue() throws Exception {
    byte[] data = new byte[256 * 1024]; // 256 KiB
    InputStream is = new ByteArrayInputStream(data);

    try (HttpClient client = factory.newBuilder().build()) {
      HttpRequest request = client.newHttpRequestBuilder()
          .uri(URI.create("http://localhost:" + serverPort + "/upload"))
          .post("application/octet-stream", is, data.length)
          .build();

      HttpResponse<String> response = client.sendAsync(request, String.class).get();

      assertThat(response.code()).isEqualTo(200);
      assertThat(response.body()).isEqualTo("OK:" + data.length);
      assertThat(continueSent.get()).isFalse();
    }
  }
}
