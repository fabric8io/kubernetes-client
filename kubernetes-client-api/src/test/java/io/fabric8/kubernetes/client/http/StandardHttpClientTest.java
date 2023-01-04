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

import io.fabric8.kubernetes.client.http.AsyncBody.Consumer;
import io.fabric8.kubernetes.client.http.HttpClient.Factory;
import io.fabric8.kubernetes.client.http.WebSocket.Listener;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.net.URI;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.CompletableFuture;

class StandardHttpClientTest {

  @Test
  void futureCancel() {
    CompletableFuture<WebSocketResponse> wsFuture = new CompletableFuture<WebSocketResponse>();
    CompletableFuture<HttpResponse<AsyncBody>> respFuture = new CompletableFuture<HttpResponse<AsyncBody>>();
    StandardHttpClientBuilder<HttpClient, Factory, StandardHttpClientBuilder<HttpClient, Factory, ?>> builder = Mockito
        .mock(StandardHttpClientBuilder.class);
    StandardHttpClient<HttpClient, Factory, StandardHttpClientBuilder<HttpClient, Factory, ?>> client = new StandardHttpClient<HttpClient, Factory, StandardHttpClientBuilder<HttpClient, Factory, ?>>(
        builder) {

      @Override
      public void close() {
        throw new UnsupportedOperationException();
      }

      @Override
      public CompletableFuture<WebSocketResponse> buildWebSocketDirect(StandardWebSocketBuilder standardWebSocketBuilder,
          Listener listener) {
        return wsFuture;
      }

      @Override
      public CompletableFuture<HttpResponse<AsyncBody>> consumeBytesDirect(StandardHttpRequest request,
          Consumer<List<ByteBuffer>> consumer) {
        return respFuture;
      }
    };
    CompletableFuture<WebSocket> future = client.newWebSocketBuilder().uri(URI.create("ws://localhost"))
        .buildAsync(new Listener() {
        });

    WebSocket ws = Mockito.mock(WebSocket.class);

    // cancel the future before the websocket response
    future.cancel(true);
    wsFuture.complete(new WebSocketResponse(ws, null));

    // ensure that the ws has been closed
    Mockito.verify(ws).sendClose(1000, null);

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
    respFuture.complete(asyncResp);
    Mockito.verify(asyncResp.body()).cancel();
  }

}
