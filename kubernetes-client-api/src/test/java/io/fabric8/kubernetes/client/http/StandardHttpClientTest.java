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

import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.http.AsyncBody.Consumer;
import io.fabric8.kubernetes.client.http.HttpClient.Factory;
import io.fabric8.kubernetes.client.http.WebSocket.Listener;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class StandardHttpClientTest {

  private static final class TestableStandardHttpClient
      extends StandardHttpClient<HttpClient, Factory, StandardHttpClientBuilder<HttpClient, Factory, ?>> {
    List<CompletableFuture<WebSocketResponse>> wsFutures = new ArrayList<>();
    int wsIndex;
    List<CompletableFuture<HttpResponse<AsyncBody>>> respFutures = new ArrayList<>();
    int respIndex;

    private TestableStandardHttpClient() {
      super(Mockito.mock(StandardHttpClientBuilder.class));
    }

    @Override
    public void close() {
      throw new UnsupportedOperationException();
    }

    @Override
    public synchronized CompletableFuture<WebSocketResponse> buildWebSocketDirect(
        StandardWebSocketBuilder standardWebSocketBuilder,
        Listener listener) {
      if (wsFutures.size() <= wsIndex) {
        wsFutures.add(new CompletableFuture<>());
      }
      return wsFutures.get(wsIndex++);
    }

    @Override
    public synchronized CompletableFuture<HttpResponse<AsyncBody>> consumeBytesDirect(StandardHttpRequest request,
        Consumer<List<ByteBuffer>> consumer) {
      if (respFutures.size() <= respIndex) {
        respFutures.add(new CompletableFuture<>());
      }
      return respFutures.get(respIndex++);
    }
  }

  private TestableStandardHttpClient client;

  @BeforeEach
  void setup() {
    client = new TestableStandardHttpClient();
  }

  @Test
  void webSocketFutureCancel() {
    CompletableFuture<WebSocket> future = client.newWebSocketBuilder().uri(URI.create("ws://localhost"))
        .buildAsync(new Listener() {
        });

    WebSocket ws = Mockito.mock(WebSocket.class);

    // cancel the future before the websocket response
    future.cancel(true);
    client.wsFutures.get(0).complete(new WebSocketResponse(ws, null));

    // ensure that the ws has been closed
    Mockito.verify(ws).sendClose(1000, null);
  }

  @Test
  void consumeBytesFutureCancel() {
    HttpResponse<AsyncBody> asyncResp = Mockito.mock(HttpResponse.class, Mockito.RETURNS_DEEP_STUBS);
    Mockito.when(asyncResp.body()).thenReturn(Mockito.mock(AsyncBody.class));

    CompletableFuture<?> consumeFuture = client.consumeBytes(client.newHttpRequestBuilder().uri("http://localhost").build(),
        new Consumer<List<ByteBuffer>>() {
          @Override
          public void consume(List<ByteBuffer> value, AsyncBody asyncBody) throws Exception {

          }
        });

    // cancel the future before the response
    consumeFuture.cancel(true);
    client.respFutures.get(0).complete(asyncResp);
    Mockito.verify(asyncResp.body()).cancel();
  }

  @Test
  void sendAsyncFutureCancel() {
    HttpResponse<AsyncBody> asyncResp = Mockito.mock(HttpResponse.class, Mockito.RETURNS_DEEP_STUBS);
    Mockito.when(asyncResp.body()).thenReturn(Mockito.mock(AsyncBody.class));
    Mockito.when(asyncResp.body().done()).thenReturn(new CompletableFuture<>());

    CompletableFuture<?> sendAsyncFuture = client.sendAsync(client.newHttpRequestBuilder().uri("http://localhost").build(),
        InputStream.class);

    // cancel the future before the response
    sendAsyncFuture.cancel(true);
    client.respFutures.get(0).complete(asyncResp);
    Mockito.verify(asyncResp.body()).cancel();
  }

  @Test
  void testNoHttpRetryWithDefaultConfig() throws InterruptedException {
    CompletableFuture<?> sendAsyncFuture = client.sendAsync(client.newHttpRequestBuilder().uri("http://localhost").build(),
        InputStream.class);

    client.respFutures.get(0).completeExceptionally(new IOException());

    try {
      sendAsyncFuture.get();
      fail();
    } catch (ExecutionException e) {
      assertTrue(e.getCause() instanceof IOException);
    }
  }

  @Test
  void testHttpRetryWithMoreFailuresThanRetries() throws Exception {
    Mockito.when(client.builder.getRequestConfig())
        .thenReturn(new ConfigBuilder().withMasterUrl("https://172.17.0.2:8443").withNamespace("default")
            .withRequestRetryBackoffLimit(3).withRequestRetryBackoffInterval(50).build());

    CompletableFuture<HttpResponse<AsyncBody>> consumeFuture = client.consumeBytes(
        client.newHttpRequestBuilder().uri("http://localhost").build(),
        new Consumer<List<ByteBuffer>>() {
          @Override
          public void consume(List<ByteBuffer> value, AsyncBody asyncBody) throws Exception {

          }
        });

    HttpResponse<AsyncBody> error = Mockito.mock(HttpResponse.class);
    Mockito.when(error.code()).thenReturn(500);
    long start = System.currentTimeMillis();
    client.respFutures.get(0).completeExceptionally(new IOException());
    client.respFutures.add(client.respFutures.get(0));
    client.respFutures.add(client.respFutures.get(0));
    client.respFutures.add(CompletableFuture.completedFuture(error));

    // should ultimately error with the final 500
    assertEquals(500, consumeFuture.get().code());
    long stop = System.currentTimeMillis();

    // should take longer than the delay
    assertTrue(stop - start >= 350); //50+100+200

    // only 4 requests issued
    assertEquals(4, client.respFutures.size());
  }

  @Test
  void testHttpRetryWithLessFailuresThanRetries() throws Exception {
    Mockito.when(client.builder.getRequestConfig())
        .thenReturn(new ConfigBuilder().withMasterUrl("https://172.17.0.2:8443").withNamespace("default")
            .withRequestRetryBackoffLimit(3).withRequestRetryBackoffInterval(50).build());

    HttpResponse<AsyncBody> error = Mockito.mock(HttpResponse.class);
    Mockito.when(error.code()).thenReturn(500);
    client.respFutures.add(CompletableFuture.completedFuture(error));
    client.respFutures.add(CompletableFuture.completedFuture(error));
    client.respFutures.add(CompletableFuture.completedFuture(error));
    HttpResponse<AsyncBody> success = Mockito.mock(HttpResponse.class);
    Mockito.when(error.code()).thenReturn(200);
    client.respFutures.add(CompletableFuture.completedFuture(success));

    CompletableFuture<HttpResponse<AsyncBody>> consumeFuture = client.consumeBytes(
        client.newHttpRequestBuilder().uri("http://localhost").build(),
        new Consumer<List<ByteBuffer>>() {
          @Override
          public void consume(List<ByteBuffer> value, AsyncBody asyncBody) throws Exception {

          }
        });

    // should ultimately succeed with the final 500
    assertEquals(200, consumeFuture.get().code());

    // only 4 requests issued
    assertEquals(4, client.respFutures.size());
  }

  @Test
  void testWebSocketWithLessFailuresThanRetries() throws Exception {
    Mockito.when(client.builder.getRequestConfig())
        .thenReturn(new ConfigBuilder().withMasterUrl("https://172.17.0.2:8443").withNamespace("default")
            .withRequestRetryBackoffLimit(3).withRequestRetryBackoffInterval(50).build());

    WebSocket ws = Mockito.mock(WebSocket.class);

    CompletableFuture<WebSocket> future = client.newWebSocketBuilder().uri(URI.create("ws://localhost"))
        .buildAsync(new Listener() {
        });

    HttpResponse<AsyncBody> error = Mockito.mock(HttpResponse.class);
    Mockito.when(error.code()).thenReturn(500);
    client.wsFutures.get(0).completeExceptionally(new WebSocketHandshakeException(error));
    client.wsFutures.add(client.wsFutures.get(0));
    client.wsFutures.add(CompletableFuture.completedFuture((new WebSocketResponse(ws, null))));

    future.get();

    assertEquals(3, client.wsFutures.size());
  }

}
