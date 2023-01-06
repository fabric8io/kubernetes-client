package io.fabric8.kubernetes.client.vertx;

import io.fabric8.kubernetes.client.http.AsyncBody;
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.http.HttpResponse;
import io.fabric8.kubernetes.client.http.StandardHttpRequest;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.MultiMap;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.buffer.impl.VertxByteBufAllocator;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientResponse;
import io.vertx.core.http.RequestOptions;
import io.vertx.core.streams.ReadStream;
import io.vertx.core.streams.impl.InboundBuffer;

import java.io.IOException;
import java.io.InputStream;
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

  private final Vertx vertx;
  private final RequestOptions options;
  private final StandardHttpRequest.BodyContent body;

  public VertxHttpRequest(Vertx vertx, RequestOptions options, StandardHttpRequest.BodyContent body) {
    this.vertx = vertx;
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
      Future<HttpClientResponse> fut;
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

          ReadStream<Buffer> stream = new ReadStream<>() {

            private InboundBuffer<Buffer> inboundBuffer;
            private Handler<Throwable> exceptionHandler;
            private Handler<Void> endHandler;
            byte[] bytes;

            @Override
            public ReadStream<Buffer> exceptionHandler(Handler<Throwable> handler) {
              exceptionHandler = handler;
              return this;
            }
            @Override
            public ReadStream<Buffer> handler(Handler<Buffer> handler) {
              boolean start = inboundBuffer == null && handler != null;
              if (start) {
                inboundBuffer = new InboundBuffer<>(vertx.getOrCreateContext());
                inboundBuffer.drainHandler(v -> {
                  readChunk();
                });
              }
              if (handler != null) {
                inboundBuffer.handler(buff -> {
                  if (buff == null) {
                    if (endHandler != null) {
                      endHandler.handle(null);
                    }
                  } else {
                    handler.handle(buff);
                  }
                });
              } else {
                inboundBuffer.handler(null);
              }
              if (start) {
                readChunk();
              }
              return this;
            }
            private void readChunk() {
              Future<Buffer> fut = vertx.executeBlocking(p -> {
                if (bytes == null) {
                  bytes = new byte[1024];
                }
                int amount;
                try {
                  amount = is.read(bytes);
                } catch (IOException e) {
                  p.fail(e);
                  return;
                }
                if (amount == -1) {
                  p.complete();
                } else {
                  p.complete(Buffer.buffer(VertxByteBufAllocator.DEFAULT.heapBuffer(amount, Integer.MAX_VALUE).writeBytes(bytes, 0, amount)));
                }
              });
              fut.onComplete(ar -> {
                if (ar.succeeded()) {
                  Buffer chunk = ar.result();
                  if (chunk != null) {
                    boolean writable = inboundBuffer.write(chunk);
                    if (writable) {
                      readChunk();
                    } else {
                      // Full
                    }
                  } else {
                    inboundBuffer.write((Buffer) null);
                  }
                } else {
                  request.reset(0, ar.cause());
                }
              });
            }
            @Override
            public ReadStream<Buffer> endHandler(Handler<Void> handler) {
              endHandler = handler;
              return this;
            }
            @Override
            public ReadStream<Buffer> pause() {
              inboundBuffer.pause();
              return this;
            }
            @Override
            public ReadStream<Buffer> resume() {
              inboundBuffer.resume();
              return this;
            }
            @Override
            public ReadStream<Buffer> fetch(long amount) {
              inboundBuffer.fetch(amount);
              return this;
            }
          };
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
