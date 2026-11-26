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

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.SequenceInputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Vertx5ExpectContinueInputStream")
class Vertx5ExpectContinueInputStreamTest {

  private Vertx vertx;
  private int serverPort;
  private final AtomicBoolean continueSent = new AtomicBoolean(false);
  private final AtomicReference<String> contentLength = new AtomicReference<>();
  private final AtomicReference<String> transferEncoding = new AtomicReference<>();
  private final HttpClient.Factory factory = new Vertx5HttpClientFactory();

  @BeforeEach
  void setUp() throws Exception {
    vertx = Vertx.vertx();
    continueSent.set(false);

    HttpServer server = vertx.createHttpServer();
    server.requestHandler(req -> {
      contentLength.set(req.getHeader("Content-Length"));
      transferEncoding.set(req.getHeader("Transfer-Encoding"));
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
  @DisplayName("Expect: 100-continue with a known-length InputStream completes and sends the body with Content-Length")
  void testInputStreamWithExpectContinueAndKnownLength() throws Exception {
    byte[] data = new byte[256 * 1024]; // 256 KiB
    InputStream is = new ByteArrayInputStream(data);

    try (HttpClient client = factory.newBuilder().build()) {
      HttpRequest request = client.newHttpRequestBuilder()
          .uri(URI.create("http://localhost:" + serverPort + "/upload"))
          .expectContinue()
          .post("application/octet-stream", is, data.length)
          .build();

      HttpResponse<String> response = client.sendAsync(request, String.class).get(10, TimeUnit.SECONDS);

      assertThat(response.code()).isEqualTo(200);
      assertThat(response.body()).isEqualTo("OK:" + data.length);
      assertThat(continueSent.get()).isTrue();
      assertThat(contentLength.get()).isEqualTo(String.valueOf(data.length));
      assertThat(transferEncoding.get()).isNull();
    }
  }

  @Test
  @DisplayName("Expect: 100-continue with an unknown-length InputStream completes and sends the body chunked")
  void testInputStreamWithExpectContinueAndUnknownLength() throws Exception {
    byte[] data = new byte[256 * 1024]; // 256 KiB
    InputStream is = new SequenceInputStream(new ByteArrayInputStream(data), InputStream.nullInputStream());

    try (HttpClient client = factory.newBuilder().build()) {
      HttpRequest request = client.newHttpRequestBuilder()
          .uri(URI.create("http://localhost:" + serverPort + "/upload"))
          .expectContinue()
          .post("application/octet-stream", is, -1)
          .build();

      HttpResponse<String> response = client.sendAsync(request, String.class).get(10, TimeUnit.SECONDS);

      assertThat(response.code()).isEqualTo(200);
      assertThat(response.body()).isEqualTo("OK:" + data.length);
      assertThat(continueSent.get()).isTrue();
      assertThat(contentLength.get()).isNull();
      assertThat(transferEncoding.get()).isEqualTo("chunked");
    }
  }

  @Test
  @DisplayName("A known-length InputStream without Expect: 100-continue is sent with Content-Length")
  void testInputStreamWithoutExpectContinue() throws Exception {
    byte[] data = new byte[256 * 1024]; // 256 KiB
    InputStream is = new ByteArrayInputStream(data);

    try (HttpClient client = factory.newBuilder().build()) {
      HttpRequest request = client.newHttpRequestBuilder()
          .uri(URI.create("http://localhost:" + serverPort + "/upload"))
          .post("application/octet-stream", is, data.length)
          .build();

      HttpResponse<String> response = client.sendAsync(request, String.class).get(10, TimeUnit.SECONDS);

      assertThat(response.code()).isEqualTo(200);
      assertThat(response.body()).isEqualTo("OK:" + data.length);
      assertThat(continueSent.get()).isFalse();
      assertThat(contentLength.get()).isEqualTo(String.valueOf(data.length));
      assertThat(transferEncoding.get()).isNull();
    }
  }

  @Test
  @DisplayName("An interim 100 that never arrives does not prevent the body from being sent")
  void testInputStreamWithExpectContinueButNoInterimResponse() throws Exception {
    byte[] data = new byte[256 * 1024]; // 256 KiB
    int port = startRawServer(0);

    try (HttpClient client = factory.newBuilder().build()) {
      HttpRequest request = client.newHttpRequestBuilder()
          .uri(URI.create("http://localhost:" + port + "/upload"))
          .expectContinue()
          .post("application/octet-stream", new ByteArrayInputStream(data), data.length)
          .build();

      // The server answers only after the whole body has been received, so a client
      // that waits for a 100-continue that never comes times out instead of completing.
      HttpResponse<String> response = client.sendAsync(request, String.class).get(20, TimeUnit.SECONDS);
      assertThat(response.code()).isEqualTo(200);
      assertThat(response.body()).isEqualTo("OK:" + data.length);
    }
  }

  @Test
  @DisplayName("A duplicated interim 100 response does not send the single-use body twice")
  void testInputStreamWithExpectContinueAndDuplicatedInterimResponse() throws Exception {
    byte[] data = new byte[256 * 1024]; // 256 KiB
    int port = startRawServer(2);

    try (HttpClient client = factory.newBuilder().build()) {
      HttpRequest request = client.newHttpRequestBuilder()
          .uri(URI.create("http://localhost:" + port + "/upload"))
          .expectContinue()
          .post("application/octet-stream", new ByteArrayInputStream(data), data.length)
          .build();

      // A second 100 firing the body write again used to fail the request with
      // 'Request already complete' and trigger retries sending an already consumed stream.
      HttpResponse<String> response = client.sendAsync(request, String.class).get(20, TimeUnit.SECONDS);
      assertThat(response.code()).isEqualTo(200);
      assertThat(response.body()).isEqualTo("OK:" + data.length);
    }
  }

  /**
   * Minimal one-shot raw-socket HTTP server for exact control over interim responses, which the
   * Vert.x server cannot provide: it reads a single request head plus its Content-Length body,
   * sends the given number of {@code 100 Continue} interim responses before reading the body,
   * and answers {@code 200 OK:<body length>} only once the whole body has been received.
   *
   * @param interim100s number of 100 Continue interim responses to send (0, 1, 2, ...)
   * @return the local port the server listens on
   */
  private static int startRawServer(int interim100s) throws Exception {
    ServerSocket serverSocket = new ServerSocket(0, 1, InetAddress.getLoopbackAddress());
    Thread serverThread = new Thread(() -> {
      try (ServerSocket socket = serverSocket; Socket connection = socket.accept()) {
        connection.setSoTimeout(20_000);
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(connection.getInputStream(), StandardCharsets.ISO_8859_1));
        String requestLine = reader.readLine();
        long contentLength = 0;
        String header;
        while ((header = reader.readLine()) != null && !header.isEmpty()) {
          int colon = header.indexOf(':');
          if (colon > 0 && header.substring(0, colon).trim().equalsIgnoreCase("Content-Length")) {
            contentLength = Long.parseLong(header.substring(colon + 1).trim());
          }
        }
        assertThat(requestLine).startsWith("POST");
        OutputStream out = connection.getOutputStream();
        for (int i = 0; i < interim100s; i++) {
          out.write("HTTP/1.1 100 Continue\r\n\r\n".getBytes(StandardCharsets.ISO_8859_1));
        }
        out.flush();
        long remaining = contentLength;
        char[] buffer = new char[8192];
        while (remaining > 0) {
          int read = reader.read(buffer, 0, (int) Math.min(buffer.length, remaining));
          assertThat(read).isPositive();
          remaining -= read;
        }
        byte[] body = ("OK:" + contentLength).getBytes(StandardCharsets.US_ASCII);
        out.write(("HTTP/1.1 200 OK\r\nContent-Type: text/plain\r\nContent-Length: " + body.length
            + "\r\nConnection: close\r\n\r\n").getBytes(StandardCharsets.ISO_8859_1));
        out.write(body);
        out.flush();
      } catch (Exception expectedOnClientDisconnect) {
        // the client may close the connection once it has the response
      }
    });
    serverThread.setDaemon(true);
    serverThread.start();
    return serverSocket.getLocalPort();
  }
}
