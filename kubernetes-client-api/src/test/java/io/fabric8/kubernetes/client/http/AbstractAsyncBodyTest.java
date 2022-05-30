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
package io.fabric8.kubernetes.client.http;

import io.fabric8.mockwebserver.DefaultMockServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public abstract class AbstractAsyncBodyTest {

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

  @Test
  @DisplayName("Lines are processed and consumed only after the consume() invocation")
  public void consumeLinesProcessedAfterConsume() throws Exception {
    try (final HttpClient client = getHttpClientFactory().newBuilder().build()) {
      server.expect().withPath("/consume-lines")
          .andReturn(200, "This is the response body\n")
          .always();
      final StringBuffer responseText = new StringBuffer();
      final HttpResponse<HttpClient.AsyncBody> asyncBodyResponse = client.consumeLines(
          client.newHttpRequestBuilder().uri(server.url("/consume-lines")).build(),
          (value, asyncBody) -> {
            responseText.append(value);
            asyncBody.done().complete(null); // OkHttp requires this, not sure if it should
          })
          .get(10L, TimeUnit.SECONDS);
      assertThat(responseText).isEmpty();
      asyncBodyResponse.body().consume();
      asyncBodyResponse.body().done().get(10L, TimeUnit.SECONDS);
      assertThat(responseText).contains("This is the response body");
    }
  }

  @Test
  @DisplayName("Lines are not processed when cancel() invocation")
  public void consumeLinesNotProcessedIfCancelled() throws Exception {
    try (final HttpClient client = getHttpClientFactory().newBuilder().build()) {
      server.expect().withPath("/cancel")
          .andReturn(200, "This would be the response body")
          .always();
      final StringBuffer responseText = new StringBuffer();
      final HttpResponse<HttpClient.AsyncBody> asyncBodyResponse = client
          .consumeLines(client.newHttpRequestBuilder()
              .uri(server.url("/cancel")).build(), (value, asyncBody) -> responseText.append(value))
          .get(10L, TimeUnit.SECONDS);
      asyncBodyResponse.body().cancel();
      asyncBodyResponse.body().consume();
      final CompletableFuture<Void> doneFuture = asyncBodyResponse.body().done();
      assertThrows(CancellationException.class, () -> doneFuture.get(10L, TimeUnit.SECONDS));
      assertThat(responseText).isEmpty();
    }
  }

  @Test
  @DisplayName("Bytes are processed and consumed only after the consume() invocation")
  public void consumeByteBufferLinesProcessedAfterConsume() throws Exception {
    try (final HttpClient client = getHttpClientFactory().newBuilder().build()) {
      server.expect().withPath("/consume-bytes")
          .andReturn(200, "This is the response body as bytes")
          .always();
      final StringBuffer responseText = new StringBuffer();
      final HttpResponse<HttpClient.AsyncBody> asyncBodyResponse = client.consumeBytes(
          client.newHttpRequestBuilder().uri(server.url("/consume-bytes")).build(),
          (value, asyncBody) -> {
            responseText.append(value.stream().map(StandardCharsets.UTF_8::decode)
                .map(CharBuffer::toString).collect(Collectors.joining()));
            asyncBody.done().complete(null); // OkHttp requires this, not sure if it should
          })
          .get(10L, TimeUnit.SECONDS);
      assertThat(responseText).isEmpty();
      asyncBodyResponse.body().consume();
      asyncBodyResponse.body().done().get(10L, TimeUnit.SECONDS);
      assertThat(responseText).contains("This is the response body as bytes");
    }
  }

}
