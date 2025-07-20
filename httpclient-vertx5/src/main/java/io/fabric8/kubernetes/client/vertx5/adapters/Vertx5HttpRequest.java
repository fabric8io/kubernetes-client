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
package io.fabric8.kubernetes.client.vertx5.adapters;

import io.fabric8.kubernetes.client.http.AsyncBody;
import io.fabric8.kubernetes.client.http.HttpResponse;
import io.fabric8.kubernetes.client.http.StandardHttpRequest;
import io.fabric8.kubernetes.client.http.StandardHttpRequest.BodyContent;
import io.vertx.core.Future;
import io.vertx.core.MultiMap;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientResponse;
import io.vertx.core.http.RequestOptions;
import io.vertx.core.streams.ReadStream;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

@RequiredArgsConstructor
final class Vertx5HttpRequest {

  @NonNull
  private final Vertx vertx;
  @NonNull
  private final RequestOptions options;
  @NonNull
  private final StandardHttpRequest request;

  CompletableFuture<HttpResponse<AsyncBody>> consumeBytes(@NonNull final HttpClient client,
      @NonNull final AsyncBody.Consumer<List<ByteBuffer>> consumer) {

    final Function<HttpClientResponse, HttpResponse<AsyncBody>> responseHandler = resp -> {
      resp.pause();

      final AsyncBody result = new AsyncBody() {
        private final CompletableFuture<Void> done = new CompletableFuture<>();

        @Override
        public void consume() {
          resp.fetch(1);
        }

        @Override
        public CompletableFuture<Void> done() {
          return done;
        }

        @Override
        public void cancel() {
          resp.handler(null);
          resp.endHandler(null);
          resp.request().reset();
          done.cancel(false);
        }
      };

      resp.handler(buffer -> {
        try {
          consumer.consume(List.of(ByteBuffer.wrap(buffer.getBytes())), result);
        } catch (final Exception e) {
          resp.request().reset();
          result.done().completeExceptionally(e);
        }
      }).endHandler(end -> result.done().complete(null))
          .exceptionHandler(ex -> result.done().completeExceptionally(ex));

      return new Vertx5HttpResponse(result, resp, request);
    };

    return client.request(options).compose(clientRequest -> {
      final Future<HttpClientResponse> fut;
      final BodyContent body = this.request.body();

      if (body != null) {
        if (body instanceof StandardHttpRequest.StringBodyContent) {
          final Buffer buffer = Buffer.buffer(((StandardHttpRequest.StringBodyContent) body).getContent());
          fut = clientRequest.send(buffer);
        } else if (body instanceof StandardHttpRequest.ByteArrayBodyContent) {
          final Buffer buffer = Buffer.buffer(((StandardHttpRequest.ByteArrayBodyContent) body).getContent());
          fut = clientRequest.send(buffer);
        } else if (body instanceof StandardHttpRequest.InputStreamBodyContent) {
          final StandardHttpRequest.InputStreamBodyContent bodyContent = (StandardHttpRequest.InputStreamBodyContent) body;
          final InputStream is = bodyContent.getContent();
          final ReadStream<Buffer> stream = new Vertx5InputStreamReadStream(this, is, clientRequest);
          fut = clientRequest.send(stream);
        } else {
          fut = Future.failedFuture("Unsupported body content");
        }
      } else {
        fut = clientRequest.send();
      }

      return fut.map(responseHandler);
    }).toCompletionStage().toCompletableFuture();
  }

  static Map<String, List<String>> toHeadersMap(@NonNull final MultiMap multiMap) {
    final Map<String, List<String>> headers = new LinkedHashMap<>();
    multiMap.names().forEach(k -> headers.put(k, multiMap.getAll(k)));
    return headers;
  }

  Vertx getVertx() {
    return vertx;
  }
}