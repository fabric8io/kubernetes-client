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

package io.fabric8.kubernetes.client.vertx;

import io.fabric8.kubernetes.client.http.AsyncBody;
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.http.HttpResponse;
import io.fabric8.kubernetes.client.http.StandardHttpHeaders;
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

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

class VertxHttpRequest {

  private static final class VertxHttpResponse extends StandardHttpHeaders implements HttpResponse<AsyncBody> {
    private final AsyncBody result;
    private final HttpClientResponse resp;
    private final HttpRequest request;

    private VertxHttpResponse(AsyncBody result, HttpClientResponse resp, HttpRequest request) {
      super(toHeadersMap(resp.headers()));
      this.result = result;
      this.resp = resp;
      this.request = request;
    }

    @Override
    public int code() {
      return resp.statusCode();
    }

    @Override
    public AsyncBody body() {
      return result;
    }

    @Override
    public HttpRequest request() {
      return request;
    }

    @Override
    public Optional<HttpResponse<?>> previousResponse() {
      return Optional.empty();
    }
  }

  final Vertx vertx;
  private final RequestOptions options;
  private StandardHttpRequest request;

  public VertxHttpRequest(Vertx vertx, RequestOptions options, StandardHttpRequest request) {
    this.vertx = vertx;
    this.options = options;
    this.request = request;
  }

  public CompletableFuture<HttpResponse<AsyncBody>> consumeBytes(HttpClient client,
      AsyncBody.Consumer<List<ByteBuffer>> consumer) {
    Function<HttpClientResponse, HttpResponse<AsyncBody>> responseHandler = resp -> {
      resp.pause();
      AsyncBody result = new AsyncBody() {
        final CompletableFuture<Void> done = new CompletableFuture<>();

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
          consumer.consume(Arrays.asList(ByteBuffer.wrap(buffer.getBytes())), result);
        } catch (Exception e) {
          resp.request().reset();
          result.done().completeExceptionally(e);
        }
      }).endHandler(end -> result.done().complete(null));
      return new VertxHttpResponse(result, resp, request);
    };
    return client.request(options).compose(request -> {
      Future<HttpClientResponse> fut;
      BodyContent body = this.request.body();
      if (body != null) {
        if (body instanceof StandardHttpRequest.StringBodyContent) {
          Buffer buffer = Buffer.buffer(((StandardHttpRequest.StringBodyContent) body).getContent());
          fut = request.send(buffer);
        } else if (body instanceof StandardHttpRequest.ByteArrayBodyContent) {
          Buffer buffer = Buffer.buffer(((StandardHttpRequest.ByteArrayBodyContent) body).getContent());
          fut = request.send(buffer);
        } else if (body instanceof StandardHttpRequest.InputStreamBodyContent) {
          StandardHttpRequest.InputStreamBodyContent bodyContent = (StandardHttpRequest.InputStreamBodyContent) body;
          InputStream is = bodyContent.getContent();

          ReadStream<Buffer> stream = new InputStreamReadStream(this, is, request);
          fut = request.send(stream);
        } else {
          fut = Future.failedFuture("Unsupported body content");
        }
      } else {
        fut = request.send();
      }
      return fut.map(responseHandler);
    }).toCompletionStage().toCompletableFuture();
  }

  static Map<String, List<String>> toHeadersMap(MultiMap multiMap) {
    Map<String, List<String>> headers = new LinkedHashMap<>();
    multiMap.names().forEach(k -> headers.put(k, multiMap.getAll(k)));
    return headers;
  }

}
