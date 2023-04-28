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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
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
    CompletableFuture<WebSocket> future = client.newWebSocketBuilder().uri(URI.create("ws://localhost"))
        .buildAsync(new Listener() {
        });

    WebSocket ws = mock(WebSocket.class);

    // cancel the future before the websocket response
    future.cancel(true);
    client.getWsFutures().get(0).complete(new WebSocketResponse(new WebSocketUpgradeResponse(null, 101, ws), null));

    // ensure that the ws has been closed
    Mockito.verify(ws).sendClose(1000, null);
  }

  @Test
  void consumeBytesFutureCancel() {
    final HttpResponse<AsyncBody> asyncResp = new TestHttpResponse<AsyncBody>().withBody(mock(AsyncBody.class));

    CompletableFuture<HttpResponse<AsyncBody>> consumeFuture = client.consumeBytes(
        client.newHttpRequestBuilder().uri("http://localhost").build(),
        (value, asyncBody) -> {

        });

    // cancel the future before the response
    consumeFuture.cancel(true);
    client.getRespFutures().get(0).complete(asyncResp);
    Mockito.verify(asyncResp.body()).cancel();
  }

  @Test
  void sendAsyncFutureCancel() {
    final HttpResponse<AsyncBody> asyncResp = new TestHttpResponse<AsyncBody>().withBody(mock(AsyncBody.class));
    when(asyncResp.body().done()).thenReturn(new CompletableFuture<>());

    CompletableFuture<?> sendAsyncFuture = client.sendAsync(client.newHttpRequestBuilder().uri("http://localhost").build(),
        InputStream.class);

    // cancel the future before the response
    sendAsyncFuture.cancel(true);
    client.getRespFutures().get(0).complete(asyncResp);
    Mockito.verify(asyncResp.body()).cancel();
  }

  @Test
  void test10RetriesWithDefaultConfig() throws Exception {
    CompletableFuture<?> sendAsyncFuture = client.sendAsync(client.newHttpRequestBuilder().uri("http://localhost").build(),
        InputStream.class);

    client.getRespFutures().get(0).completeExceptionally(new IOException());
    IntStream.range(1, 11).forEach(i -> client.getRespFutures().add(client.getRespFutures().get(0)));

    try {
      sendAsyncFuture.get(30, TimeUnit.SECONDS);
      fail();
    } catch (ExecutionException e) {
      assertTrue(e.getCause() instanceof IOException);
    }
  }

  @Test
  void testHttpRetryWithMoreFailuresThanRetries() throws Exception {
    client = client.newBuilder().tag(new RequestConfigBuilder()
        .withRequestRetryBackoffLimit(3)
        .withRequestRetryBackoffInterval(50).build())
        .build();

    CompletableFuture<HttpResponse<AsyncBody>> consumeFuture = client.consumeBytes(
        client.newHttpRequestBuilder().uri("http://localhost").build(),
        (value, asyncBody) -> {

        });

    long start = System.currentTimeMillis();
    client.getRespFutures().get(0).completeExceptionally(new IOException());
    client.getRespFutures().add(client.getRespFutures().get(0));
    client.getRespFutures().add(client.getRespFutures().get(0));
    client.getRespFutures().add(CompletableFuture.completedFuture(new TestHttpResponse<AsyncBody>().withCode(500)));

    // should ultimately error with the final 500
    assertEquals(500, consumeFuture.get().code());
    long stop = System.currentTimeMillis();

    // should take longer than the delay
    assertTrue(stop - start >= 350); //50+100+200

    // only 4 requests issued
    assertEquals(4, client.getRespFutures().size());
  }

  @Test
  void testHttpRetryWithLessFailuresThanRetries() throws Exception {
    client = client.newBuilder().tag(new RequestConfigBuilder()
        .withRequestRetryBackoffLimit(3)
        .withRequestRetryBackoffInterval(50).build())
        .build();

    final HttpResponse<AsyncBody> error = new TestHttpResponse<AsyncBody>().withBody(Mockito.mock(AsyncBody.class))
        .withCode(500);
    client.getRespFutures().add(CompletableFuture.completedFuture(error));
    client.getRespFutures().add(CompletableFuture.completedFuture(error));
    client.getRespFutures().add(CompletableFuture.completedFuture(error));
    client.getRespFutures().add(CompletableFuture.completedFuture(new TestHttpResponse<AsyncBody>().withCode(200)));

    CompletableFuture<HttpResponse<AsyncBody>> consumeFuture = client.consumeBytes(
        client.newHttpRequestBuilder().uri("http://localhost").build(),
        (value, asyncBody) -> {
        });

    // should ultimately succeed with the final 200
    assertEquals(200, consumeFuture.get(2, TimeUnit.MINUTES).code());

    // only 4 requests issued
    assertEquals(4, client.getRespFutures().size());
  }

  @Test
  void testWebSocketWithLessFailuresThanRetries() throws Exception {
    client = client.newBuilder().tag(new RequestConfigBuilder()
        .withRequestRetryBackoffLimit(3)
        .withRequestRetryBackoffInterval(50).build())
        .build();

    WebSocket ws = mock(WebSocket.class);

    CompletableFuture<WebSocket> future = client.newWebSocketBuilder().uri(URI.create("ws://localhost"))
        .buildAsync(new Listener() {
        });

    client.getWsFutures().get(0)
        .completeExceptionally(new WebSocketHandshakeException(new WebSocketUpgradeResponse(null, 500, null)));
    client.getWsFutures().add(client.getWsFutures().get(0));
    client.getWsFutures()
        .add(CompletableFuture.completedFuture((new WebSocketResponse(new WebSocketUpgradeResponse(null, ws), null))));

    future.get(2, TimeUnit.MINUTES);

    assertEquals(3, client.getWsFutures().size());
  }

  @Test
  void testClosePreviousBeforeRetry() throws Exception {
    client = client.newBuilder().tag(new RequestConfigBuilder()
        .withRequestRetryBackoffLimit(1)
        .withRequestRetryBackoffInterval(50).build())
        .build();

    final HttpResponse<AsyncBody> error = new TestHttpResponse<AsyncBody>().withBody(Mockito.mock(AsyncBody.class))
        .withCode(503);
    client.getRespFutures().add(CompletableFuture.completedFuture(error));
    client.getRespFutures().add(CompletableFuture.completedFuture(new TestHttpResponse<AsyncBody>().withCode(200)));

    CompletableFuture<HttpResponse<AsyncBody>> consumeFuture = client.consumeBytes(
        client.newHttpRequestBuilder().uri("http://localhost").build(),
        (value, asyncBody) -> {
        });

    Mockito.verify(error.body()).cancel();

    // should ultimately succeed with the final 200
    assertEquals(200, consumeFuture.get(2, TimeUnit.MINUTES).code());

    // only 2 requests issued
    assertEquals(2, client.getRespFutures().size());
  }

}
