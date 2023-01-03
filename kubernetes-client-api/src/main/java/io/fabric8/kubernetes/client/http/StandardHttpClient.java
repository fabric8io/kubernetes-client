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
import io.fabric8.kubernetes.client.http.WebSocket.Listener;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public abstract class StandardHttpClient<C extends HttpClient, F extends HttpClient.Factory, T extends StandardHttpClientBuilder<C, F, ?>>
    implements HttpClient {

  protected StandardHttpClientBuilder<C, F, T> builder;

  protected StandardHttpClient(StandardHttpClientBuilder<C, F, T> builder) {
    this.builder = builder;
  }

  public abstract CompletableFuture<WebSocketResponse> buildWebSocketDirect(
      StandardWebSocketBuilder standardWebSocketBuilder,
      Listener listener);

  public abstract CompletableFuture<HttpResponse<AsyncBody>> consumeBytesDirect(StandardHttpRequest request,
      Consumer<List<ByteBuffer>> consumer);

  @Override
  public DerivedClientBuilder newBuilder() {
    return builder.copy((C) this);
  }

  @Override
  public CompletableFuture<HttpResponse<AsyncBody>> consumeBytes(HttpRequest request, Consumer<List<ByteBuffer>> consumer) {
    StandardHttpRequest standardHttpRequest = (StandardHttpRequest) request;
    StandardHttpRequest.Builder copy = standardHttpRequest.newBuilder();
    for (Interceptor interceptor : builder.interceptors.values()) {
      Interceptor.useConfig(builder.requestConfig).apply(interceptor).before(copy, standardHttpRequest);
      standardHttpRequest = copy.build();
    }

    CompletableFuture<HttpResponse<AsyncBody>> cf = consumeBytesDirect(standardHttpRequest, consumer);

    for (Interceptor interceptor : builder.interceptors.values()) {
      cf = cf.thenCompose(response -> {
        if (!HttpResponse.isSuccessful(response.code())) {
          return Interceptor.useConfig(builder.requestConfig).apply(interceptor)
              .afterFailure(copy, response)
              .thenCompose(b -> {
                if (Boolean.TRUE.equals(b)) {
                  // before starting another request, make sure the old one is cancelled / closed
                  response.body().cancel();
                  return consumeBytesDirect(copy.build(), consumer);
                }
                return CompletableFuture.completedFuture(response);
              });
        }
        return CompletableFuture.completedFuture(response);
      });
    }

    return cf;
  }

  @Override
  public io.fabric8.kubernetes.client.http.WebSocket.Builder newWebSocketBuilder() {
    return new StandardWebSocketBuilder(this);
  }

  @Override
  public HttpRequest.Builder newHttpRequestBuilder() {
    // TODO: could move the consumeBytes or whatever method to the HttpRequest instead - that removes some casting
    return new StandardHttpRequest.Builder();
  }

  final CompletableFuture<WebSocket> buildWebSocket(StandardWebSocketBuilder standardWebSocketBuilder,
      Listener listener) {

    final StandardWebSocketBuilder copy = standardWebSocketBuilder.newBuilder();
    builder.getInterceptors().values().stream().map(Interceptor.useConfig(builder.requestConfig))
        .forEach(i -> i.before(copy, copy.asHttpRequest()));

    CompletableFuture<WebSocketResponse> cf = buildWebSocketDirect(copy, listener);
    for (Interceptor interceptor : builder.getInterceptors().values()) {
      cf = cf.thenCompose(response -> {
        if (response.wshse != null && response.wshse.getResponse() != null) {
          return Interceptor.useConfig(builder.requestConfig).apply(interceptor)
              .afterFailure(copy, response.wshse.getResponse()).thenCompose(b -> {
                if (Boolean.TRUE.equals(b)) {
                  return this.buildWebSocketDirect(copy, listener);
                }
                return CompletableFuture.completedFuture(response);
              });
        }
        return CompletableFuture.completedFuture(response);
      });
    }

    final CompletableFuture<WebSocket> result = new CompletableFuture<>();
    // map back to the expected convention with the future completed by the response exception
    cf.whenComplete(onWebSocketComplete(result));
    return result;

  }

  private static BiConsumer<WebSocketResponse, Throwable> onWebSocketComplete(CompletableFuture<WebSocket> result) {
    return (r, t) -> {
      if (t != null) {
        result.completeExceptionally(t);
      } else if (r != null) {
        if (r.wshse != null) {
          result.completeExceptionally(r.wshse);
        } else {
          result.complete(r.webSocket);
        }
      } else {
        // shouldn't happen
        result.complete(null);
      }
    };
  }

}
