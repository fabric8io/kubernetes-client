package io.fabric8.kubernetes.client.vertx;

import io.fabric8.kubernetes.client.http.AsyncBody;
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.http.HttpResponse;
import io.vertx.core.MultiMap;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientResponse;
import io.vertx.core.http.RequestOptions;

import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

class VertxHttpRequest implements HttpRequest {

  private final RequestOptions options;
  private final Buffer body;

  public VertxHttpRequest(RequestOptions options, Buffer body) {
    this.options = options;
    this.body = body;
  }

  @Override
  public URI uri() {
    return URI.create(options.getURI());
  }

  @Override
  public String method() {
    return options.getMethod().name();
  }

  @Override
  public String bodyString() {
    return body.toString();
  }

  @Override
  public List<String> headers(String key) {
    return options.getHeaders().getAll(key);
  }

  public CompletableFuture<HttpResponse<AsyncBody>> consumeBytes(HttpClient client, AsyncBody.Consumer<List<ByteBuffer>> consumer) {
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
      return new HttpResponse<AsyncBody>() {

        @Override
        public List<String> headers(String key) {
          return VertxHttpRequest.this.headers().get(key);
        }

        @Override
        public Map<String, List<String>> headers() {
          return VertxHttpRequest.this.headers();
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
          return VertxHttpRequest.this;
        }

        @Override
        public Optional<HttpResponse<?>> previousResponse() {
          return Optional.empty();
        }

      };
    };
    return client.request(options).compose(request -> {
      if (body != null) {
        return request.send(body).map(responseHandler);
      }
      return request.send().map(responseHandler);
    }).toCompletionStage().toCompletableFuture();
  }

  @Override
  public Map<String, List<String>> headers() {
    MultiMap multiMap = options.getHeaders();
    return toHeadersMap(multiMap);
  }

  static Map<String, List<String>> toHeadersMap(MultiMap multiMap) {
    Map<String, List<String>> headers = new LinkedHashMap<>();
    multiMap.names().stream().forEach(k -> headers.put(k, multiMap.getAll(k)));
    return headers;
  }
}