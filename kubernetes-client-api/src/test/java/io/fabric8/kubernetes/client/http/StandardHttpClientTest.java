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

import io.fabric8.kubernetes.client.RequestConfigBuilder;
import io.fabric8.kubernetes.client.http.WebSocket.Listener;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class StandardHttpClientTest {

  private TestStandardHttpClient client;

  @BeforeEach
  void setup() {
    client = new TestStandardHttpClientFactory().newBuilder().build();
  }

  @Test
  void webSocketFutureCancel() {
    WebSocket ws = mock(WebSocket.class);
    final CompletableFuture<WebSocketResponse> wsResponsefuture = new CompletableFuture<>();
    client.wsExpect(".*", wsResponsefuture);

    CompletableFuture<WebSocket> future = client.newWebSocketBuilder().uri(URI.create("ws://localhost"))
        .buildAsync(new Listener() {
        });

    // cancel the future before the websocket response
    future.cancel(true);
    wsResponsefuture.complete(new WebSocketResponse(new WebSocketUpgradeResponse(null, 101), ws));

    // ensure that the ws has been closed
    Mockito.verify(ws).sendClose(1000, null);
  }

  @Test
  void consumeBytesFutureCancel() {
    final HttpResponse<AsyncBody> asyncResp = new TestHttpResponse<AsyncBody>().withBody(mock(AsyncBody.class));
    final CompletableFuture<HttpResponse<AsyncBody>> responseFuture = new CompletableFuture<>();
    client.expect("/path", responseFuture);

    CompletableFuture<HttpResponse<AsyncBody>> consumeFuture = client.consumeBytes(
        client.newHttpRequestBuilder().uri("http://localhost/path").build(),
        (value, asyncBody) -> {

        });

    // cancel the future before the response
    consumeFuture.cancel(true);
    responseFuture.complete(asyncResp);
    Mockito.verify(asyncResp.body()).cancel();
  }

  @Test
  void sendAsyncFutureCancel() {
    final HttpResponse<AsyncBody> asyncResp = new TestHttpResponse<AsyncBody>().withBody(mock(AsyncBody.class));
    when(asyncResp.body().done()).thenReturn(new CompletableFuture<>());
    final CompletableFuture<HttpResponse<AsyncBody>> responseFuture = new CompletableFuture<>();
    client.expect("/path", responseFuture);

    CompletableFuture<?> sendAsyncFuture = client.sendAsync(client.newHttpRequestBuilder().uri("http://localhost/path").build(),
        InputStream.class);

    // cancel the future before the response
    sendAsyncFuture.cancel(true);
    responseFuture.complete(asyncResp);
    Mockito.verify(asyncResp.body()).cancel();
  }

  @Test
  void test10RetriesWithDefaultConfig() {
    IntStream.range(0, 11).forEach(i -> client.expect(".*", new IOException(i + " - Unreachable!")));

    CompletableFuture<?> sendAsyncFuture = client.sendAsync(client.newHttpRequestBuilder().uri("http://localhost").build(),
        InputStream.class);

    assertThatThrownBy(() -> sendAsyncFuture.get(30, TimeUnit.SECONDS))
        .isInstanceOf(ExecutionException.class)
        .cause()
        .isInstanceOf(IOException.class)
        .hasMessage("10 - Unreachable!");
  }

  @Test
  void testHttpRetryWithMoreFailuresThanRetries() throws Exception {
    client = client.newBuilder().tag(new RequestConfigBuilder()
        .withRequestRetryBackoffLimit(3)
        .withRequestRetryBackoffInterval(50).build())
        .build();

    IntStream.range(0, 3).forEach(i -> client.expect(".*", new IOException("Unreachable!")));
    client.expect(".*", new TestHttpResponse<AsyncBody>().withCode(403));

    CompletableFuture<HttpResponse<AsyncBody>> consumeFuture = client.consumeBytes(
        client.newHttpRequestBuilder().uri("http://localhost").build(),
        (value, asyncBody) -> {

        });

    long start = System.currentTimeMillis();

    // should ultimately error with the final 500
    assertEquals(403, consumeFuture.get().code());
    long stop = System.currentTimeMillis();

    // should take longer than the delay
    assertTrue(stop - start >= 350); //50+100+200

    // only 4 requests issued
    assertThat(client.getRecordedConsumeBytesDirects())
        .hasSize(4);
  }

  @Test
  void testHttpRetryWithLessFailuresThanRetries() throws Exception {
    client = client.newBuilder().tag(new RequestConfigBuilder()
        .withRequestRetryBackoffLimit(3)
        .withRequestRetryBackoffInterval(50).build())
        .build();
    final HttpResponse<AsyncBody> error = new TestHttpResponse<AsyncBody>().withCode(500).withBody(new TestAsyncBody());
    IntStream.range(0, 3).forEach(i -> client.expect(".*", error));
    client.expect(".*", new TestHttpResponse<AsyncBody>().withCode(200));

    CompletableFuture<HttpResponse<AsyncBody>> consumeFuture = client.consumeBytes(
        client.newHttpRequestBuilder().uri("http://localhost").build(),
        (value, asyncBody) -> {
        });

    // should ultimately succeed with the final 200
    assertEquals(200, consumeFuture.get(2, TimeUnit.MINUTES).code());

    // only 4 requests issued
    assertThat(client.getRecordedConsumeBytesDirects())
        .hasSize(4);
  }

  @Test
  void testWebSocketWithLessFailuresThanRetries() throws Exception {
    client = client.newBuilder().tag(new RequestConfigBuilder()
        .withRequestRetryBackoffLimit(3)
        .withRequestRetryBackoffInterval(50).build())
        .build();
    final WebSocketResponse error = new WebSocketResponse(new WebSocketUpgradeResponse(null, 500), new IOException());
    IntStream.range(0, 2).forEach(i -> client.wsExpect(".*", error));
    client.wsExpect(".*", new WebSocketResponse(new WebSocketUpgradeResponse(null), mock(WebSocket.class)));

    CompletableFuture<WebSocket> future = client.newWebSocketBuilder().uri(URI.create("ws://localhost"))
        .buildAsync(new Listener() {
        });

    future.get(2, TimeUnit.MINUTES);

    assertThat(client.getRecordedBuildWebSocketDirects())
        .hasSize(3);
  }

  @Test
  void testClosePreviousBeforeRetry() throws Exception {
    client = client.newBuilder().tag(new RequestConfigBuilder()
        .withRequestRetryBackoffLimit(1)
        .withRequestRetryBackoffInterval(50).build())
        .build();

    final HttpResponse<AsyncBody> error = new TestHttpResponse<AsyncBody>().withBody(Mockito.mock(AsyncBody.class))
        .withCode(503);
    client.expect(".*", error);
    client.expect(".*", new TestHttpResponse<AsyncBody>().withCode(200));

    CompletableFuture<HttpResponse<AsyncBody>> consumeFuture = client.consumeBytes(
        client.newHttpRequestBuilder().uri("http://localhost").build(),
        (value, asyncBody) -> {
        });

    Mockito.verify(error.body()).cancel();

    // should ultimately succeed with the final 200
    assertEquals(200, consumeFuture.get(2, TimeUnit.MINUTES).code());

    // only 2 requests issued
    assertThat(client.getRecordedConsumeBytesDirects())
        .hasSize(2);
  }

  @Test
  void testRequestTimeout() {
    client.expect(".*", new CompletableFuture<>());
    CompletableFuture<HttpResponse<AsyncBody>> consumeFuture = client.consumeBytes(
        client.newHttpRequestBuilder().uri("http://localhost").timeout(1, TimeUnit.MILLISECONDS).build(),
        (value, asyncBody) -> {
        });

    Awaitility.await().atMost(10, TimeUnit.SECONDS).until(consumeFuture::isDone);
    assertThatThrownBy(consumeFuture::get)
        .isInstanceOf(ExecutionException.class).hasCauseInstanceOf(TimeoutException.class);
  }

  @Test
  void testMultiValueHeader() {
    TestHttpResponse<Void> response = new TestHttpResponse<>(Collections.singletonMap("header", Arrays.asList("a", "b")));
    assertEquals("a,b", response.header("header"));
  }

  @Test
  void retryAfterWithNoHeaderDefaultsToZero() {
    assertEquals(0, StandardHttpClient.retryAfterMillis(new TestHttpResponse<>()));

  }

  @ParameterizedTest(name = "{index}: retryAfter={0} has a retry interval between {1} and {2} milliseconds")
  @MethodSource("testRetryAfterParsingData")
  void testRetryAfterParsing(List<String> retryAfter, int lowerBound, int upperBound) {
    assertThat(StandardHttpClient.retryAfterMillis(new TestHttpResponse<>(Collections.singletonMap("Retry-After", retryAfter))))
        .isGreaterThanOrEqualTo(lowerBound)
        .isLessThanOrEqualTo(upperBound);
  }

  public static Stream<Arguments> testRetryAfterParsingData() {
    return Stream.of(
        Arguments.of(Collections.emptyList(), 0, 0),
        Arguments.of(Collections.singletonList("2"), 2000, 2000),
        Arguments.of(Collections.singletonList("invalid"), 0, 0),
        Arguments.of(
            Collections.singletonList(ZonedDateTime.now().plusSeconds(10).format(DateTimeFormatter.RFC_1123_DATE_TIME)), 1001,
            10000));
  }

}
