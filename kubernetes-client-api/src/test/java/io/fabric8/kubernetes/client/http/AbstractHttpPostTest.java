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

import io.fabric8.kubernetes.client.RequestConfigBuilder;
import io.fabric8.mockwebserver.DefaultMockServer;
import io.fabric8.mockwebserver.http.RecordedRequest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class AbstractHttpPostTest {

  private static DefaultMockServer server;

  @BeforeAll
  static void beforeAll() {
    server = new DefaultMockServer(false);
    server.start();
  }

  @AfterAll
  static void afterAll() {
    server.shutdown();
  }

  protected abstract HttpClient.Factory getHttpClientFactory();

  protected abstract Class<? extends Exception> getConnectionFailedExceptionType();

  @Test
  @DisplayName("String body, should send a POST request with body")
  public void postStringBody() throws Exception {
    // When
    try (HttpClient client = getHttpClientFactory().newBuilder().build()) {
      client
          .sendAsync(client.newHttpRequestBuilder()
              .uri(server.url("/post-string"))
              .post("text/plain", "A string body")
              .build(), String.class)
          .get(10L, TimeUnit.SECONDS);
    }
    // Then
    assertThat(server.getLastRequest())
        .returns("POST", RecordedRequest::getMethod)
        .returns("A string body", rr -> rr.getBody().readUtf8())
        .extracting(rr -> rr.getHeader("Content-Type")).asString()
        .startsWith("text/plain");
  }

  @Test
  @DisplayName("InputStream body, should send a POST request with body")
  public void postInputStreamBody() throws Exception {
    // When
    try (HttpClient client = getHttpClientFactory().newBuilder().build()) {
      client
          .sendAsync(client.newHttpRequestBuilder()
              .uri(server.url("/post-input-stream"))
              .post("text/plain", new ByteArrayInputStream("A string body".getBytes(StandardCharsets.UTF_8)), -1)
              .build(), String.class)
          .get(10L, TimeUnit.SECONDS);
    }
    // Then
    assertThat(server.getLastRequest())
        .returns("POST", RecordedRequest::getMethod)
        .returns("A string body", rr -> rr.getBody().readUtf8())
        .extracting(rr -> rr.getHeader("Content-Type")).asString()
        .startsWith("text/plain");
  }

  @Test
  @DisplayName("byte[] body, should send a POST request with body")
  public void postBytesBody() throws Exception {
    // When
    try (HttpClient client = getHttpClientFactory().newBuilder().build()) {
      client
          .sendAsync(client.newHttpRequestBuilder()
              .uri(server.url("/post-bytes"))
              .post("text/plain", "A string body".getBytes(StandardCharsets.UTF_8))
              .build(), String.class)
          .get(10L, TimeUnit.SECONDS);
    }
    // Then
    assertThat(server.getLastRequest())
        .returns("POST", RecordedRequest::getMethod)
        .returns("A string body", rr -> rr.getBody().readUtf8())
        .extracting(rr -> rr.getHeader("Content-Type")).asString()
        .startsWith("text/plain");
  }

  @Test
  @DisplayName("FormData body, should send a POST request with body")
  public void postFormDataBody() throws Exception {
    // When
    try (HttpClient client = getHttpClientFactory().newBuilder().build()) {
      client
          .sendAsync(client.newHttpRequestBuilder()
              .uri(server.url("/post-bytes"))
              .post(Collections.singletonMap("field", "value"))
              .build(), String.class)
          .get(10L, TimeUnit.SECONDS);
    }
    // Then
    assertThat(server.getLastRequest())
        .returns("POST", RecordedRequest::getMethod)
        .returns("field=value", rr -> rr.getBody().readUtf8())
        .extracting(rr -> rr.getHeader("Content-Type")).asString()
        .startsWith("application/x-www-form-urlencoded");
  }

  @Test
  public void expectContinue() throws Exception {
    server.expect().post().withPath("/post-expect-continue").andReturn(200, "").always();

    // When
    try (HttpClient client = getHttpClientFactory().newBuilder().build()) {
      final CompletableFuture<HttpResponse<String>> response = client
          .sendAsync(client.newHttpRequestBuilder()
              .post(Collections.emptyMap())
              .uri(server.url("/post-expect-continue"))
              .expectContinue()
              .build(), String.class);

      // Then
      assertThat(response).succeedsWithin(10, TimeUnit.SECONDS);
      assertThat(server.getLastRequest())
          .returns("POST", RecordedRequest::getMethod)
          .extracting(rr -> rr.getHeader("Expect")).asString()
          .isEqualTo("100-continue");
    }
  }

  @Test
  public void expectFailure() throws IOException, URISyntaxException {
    try (final ServerSocket serverSocket = new ServerSocket(0)) {

      try (HttpClient client = getHttpClientFactory().newBuilder()
          .tag(new RequestConfigBuilder().withRequestRetryBackoffLimit(0).build()).build()) {
        final URI uri = uriForPath(serverSocket, "/post-failing");
        serverSocket.close();

        // When
        final CompletableFuture<HttpResponse<String>> response = client
            .sendAsync(client.newHttpRequestBuilder()
                .post("text/plain", new ByteArrayInputStream("A string body".getBytes(StandardCharsets.UTF_8)), -1)
                .uri(uri)
                .timeout(250, TimeUnit.MILLISECONDS)
                .build(), String.class);

        // Then
        assertThat(response).failsWithin(30, TimeUnit.SECONDS)
            .withThrowableOfType(ExecutionException.class)
            .withCauseInstanceOf(getConnectionFailedExceptionType());
      }
    }
  }

  private static URI uriForPath(ServerSocket socket, String path) throws URISyntaxException {
    final InetAddress httpServerAddress = socket.getInetAddress();
    return new URI(String.format("http://%s:%s%s", httpServerAddress.getHostName(), socket.getLocalPort(), path));
  }

}
