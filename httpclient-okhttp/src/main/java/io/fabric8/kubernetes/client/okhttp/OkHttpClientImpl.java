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

package io.fabric8.kubernetes.client.okhttp;

import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.http.AsyncBody;
import io.fabric8.kubernetes.client.http.AsyncBody.Consumer;
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.http.HttpResponse;
import io.fabric8.kubernetes.client.http.StandardHttpClient;
import io.fabric8.kubernetes.client.http.StandardHttpHeaders;
import io.fabric8.kubernetes.client.http.StandardHttpRequest;
import io.fabric8.kubernetes.client.http.StandardHttpRequest.BodyContent;
import io.fabric8.kubernetes.client.http.StandardHttpRequest.ByteArrayBodyContent;
import io.fabric8.kubernetes.client.http.StandardHttpRequest.InputStreamBodyContent;
import io.fabric8.kubernetes.client.http.StandardHttpRequest.StringBodyContent;
import io.fabric8.kubernetes.client.http.StandardWebSocketBuilder;
import io.fabric8.kubernetes.client.http.WebSocket.Listener;
import io.fabric8.kubernetes.client.http.WebSocketResponse;
import io.fabric8.kubernetes.client.utils.Utils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Internal;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.function.Function;

public class OkHttpClientImpl extends StandardHttpClient<OkHttpClientImpl, OkHttpClientFactory, OkHttpClientBuilderImpl> {

  static final transient Logger LOG = LoggerFactory.getLogger(OkHttpClientImpl.class);

  static final Map<String, MediaType> MEDIA_TYPES = new ConcurrentHashMap<>();

  public static final MediaType JSON = parseMediaType("application/json");

  static MediaType parseMediaType(String contentType) {
    MediaType result = MediaType.parse(contentType);
    MEDIA_TYPES.put(contentType, result);
    return result;
  }

  abstract static class OkHttpAsyncBody<T> implements AsyncBody {
    private final AsyncBody.Consumer<T> consumer;
    private final BufferedSource source;
    private final CompletableFuture<Void> done = new CompletableFuture<>();
    private boolean consuming;
    private boolean requested;
    private final Executor executor;

    OkHttpAsyncBody(AsyncBody.Consumer<T> consumer, BufferedSource source, Executor executor) {
      this.consumer = consumer;
      this.source = source;
      this.executor = executor;
    }

    @Override
    public void consume() {
      synchronized (this) {
        requested = true;
        if (consuming) {
          return;
        }
        consuming = true;
      }
      try {
        // consume should not block a caller, delegate to the dispatcher thread pool
        executor.execute(this::doConsume);
      } catch (Exception e) {
        // executor is likely shutdown
        Utils.closeQuietly(source);
        done.completeExceptionally(e);
      }
    }

    private void doConsume() {
      try {
        while (true) {
          synchronized (this) {
            if (!requested || done.isDone()) {
              consuming = false;
              return;
            }
            requested = false;
          }
          if (!source.exhausted()) { // this is a blocking call
            T value = process(source);
            consumer.consume(value, this);
          } else {
            // even if we've read everything an explicit close is still needed
            source.close();
            done.complete(null);
          }
        }
      } catch (Exception e) {
        Utils.closeQuietly(source);
        done.completeExceptionally(e);
      }
    }

    @Override
    public CompletableFuture<Void> done() {
      return done;
    }

    protected abstract T process(BufferedSource source) throws IOException;

    @Override
    public void cancel() {
      Utils.closeQuietly(source);
      done.cancel(false);
    }
  }

  static class OkHttpResponseImpl<T> implements HttpResponse<T> {

    private final Response response;
    private T body;
    private Class<T> type;

    public OkHttpResponseImpl(Response response, T body) {
      this.response = response;
      this.body = body;
    }

    public OkHttpResponseImpl(Response response, Class<T> type) throws IOException {
      this.response = response;
      this.type = type;
      ResponseBody responseBody = response.body();
      if (responseBody != null) {
        if (type == null) {
          responseBody.close();
        } else if (type == String.class) {
          body = (T) responseBody.string();
        } else if (type == Reader.class) {
          body = (T) responseBody.charStream();
        } else if (type == byte[].class) {
          body = (T) responseBody.bytes();
        } else {
          body = (T) responseBody.byteStream();
        }
      }
    }

    @Override
    public int code() {
      return response.code();
    }

    @Override
    public T body() {
      return body;
    }

    @Override
    public HttpRequest request() {
      String bodyString = null;
      Request request = response.request();
      if (request.body() != null) {
        Buffer buffer = new Buffer();
        try {
          request.body().writeTo(buffer);
          bodyString = buffer.readUtf8();
        } catch (IOException e) {
          // just ignore, the bodyString is only for informational purposes
        }
      }
      return new StandardHttpRequest(
          request.headers().toMultimap(),
          request.url().uri(),
          request.method(),
          bodyString);
    }

    @Override
    public Optional<HttpResponse<?>> previousResponse() {
      Response previous = response.priorResponse() != null ? response.priorResponse() : response;
      previous = previous.networkResponse() != null ? previous.networkResponse() : previous;
      try {
        return Optional.ofNullable(previous == response ? null : new OkHttpResponseImpl<>(previous, type));
      } catch (IOException e) {
        throw new IllegalArgumentException(e);
      }
    }

    @Override
    public List<String> headers(String key) {
      return response.headers(key);
    }

    @Override
    public Map<String, List<String>> headers() {
      return response.headers().toMultimap();
    }

  }

  private final okhttp3.OkHttpClient httpClient;

  public OkHttpClientImpl(OkHttpClient client, OkHttpClientBuilderImpl builder) {
    super(builder);
    this.httpClient = client;
  }

  @Override
  public void close() {
    if (LOG.isDebugEnabled()) {
      StringWriter writer = new StringWriter();
      PrintWriter printWriter = new PrintWriter(writer);
      new Exception().printStackTrace(printWriter);
      printWriter.close();
      String stack = writer.toString();
      stack = stack.substring(stack.indexOf("\n"));
      LOG.debug("Shutting down dispatcher {} at the following call stack: {}", this.httpClient.dispatcher(), stack);
    }
    ConnectionPool connectionPool = httpClient.connectionPool();

    Dispatcher dispatcher = httpClient.dispatcher();
    ExecutorService executorService = httpClient.dispatcher() != null ? httpClient.dispatcher().executorService() : null;

    if (dispatcher != null) {
      dispatcher.cancelAll();
    }

    if (connectionPool != null) {
      connectionPool.evictAll();

      // begin hack to terminate the idle task, which is not necessary after 4.3.0 - https://github.com/square/okhttp/commit/bc3ad111ad01100a77846f7dc433b0c0f5b58dba
      // to immediately clean it up, we need to notify the thread waiting on the ConnectionPool / RealConnectionPool
      Object realConnectionPool = connectionPool;

      try {
        // 3.14+ holds a delegate to the real pool
        Method method = Internal.class.getMethod("realConnectionPool", ConnectionPool.class);
        realConnectionPool = method.invoke(Internal.instance, connectionPool);
      } catch (Exception e) {
        // could be 3.12
      }
      synchronized (realConnectionPool) {
        realConnectionPool.notifyAll();
      }
    }

    if (executorService != null) {
      executorService.shutdownNow();
    }
  }

  private CompletableFuture<HttpResponse<AsyncBody>> sendAsync(HttpRequest request,
      Function<BufferedSource, AsyncBody> handler) {
    CompletableFuture<HttpResponse<AsyncBody>> future = new CompletableFuture<>();
    Call call = httpClient.newCall(requestBuilder((StandardHttpRequest) request).build());
    try {
      call.enqueue(new Callback() {

        @Override
        public void onResponse(Call call, Response response) throws IOException {
          BufferedSource source = response.body().source();

          AsyncBody asyncBody = handler.apply(source);

          future.complete(new OkHttpResponseImpl<>(response, asyncBody));
        }

        @Override
        public void onFailure(Call call, IOException e) {
          Throwable t = e;
          if (e instanceof InterruptedIOException && e.getCause() instanceof RejectedExecutionException) {
            t = wrapRejected((RejectedExecutionException) e.getCause());
          }
          future.completeExceptionally(t);
        }
      });
    } catch (RejectedExecutionException e) {
      throw wrapRejected(e);
    }
    future.whenComplete((r, t) -> {
      if (future.isCancelled()) {
        call.cancel();
      }
    });
    return future;
  }

  private KubernetesClientException wrapRejected(RejectedExecutionException e) {
    return new KubernetesClientException("The okhttp client executor has been shutdown.  "
        + "More than likely this is because the KubernetesClient.close method (see debug logging) has been called "
        + "- please ensure that is intentional. Dispatcher: " + this.httpClient.dispatcher(), e);
  }

  public okhttp3.OkHttpClient getOkHttpClient() {
    return httpClient;
  }

  private okhttp3.Request.Builder newRequestBuilder() {
    return new Request.Builder();
  }

  @Override
  public CompletableFuture<HttpResponse<AsyncBody>> consumeBytesDirect(StandardHttpRequest request,
      Consumer<List<ByteBuffer>> consumer) {
    Function<BufferedSource, AsyncBody> handler = s -> new OkHttpAsyncBody<List<ByteBuffer>>(consumer, s,
        this.httpClient.dispatcher().executorService()) {
      @Override
      protected List<ByteBuffer> process(BufferedSource source) throws IOException {
        // read only what is available otherwise okhttp will block trying to read
        // a whole fetch size 8k worth
        return Collections.singletonList(ByteBuffer.wrap(source.readByteArray(source.buffer().size())));
      }
    };
    return sendAsync(request, handler);
  }

  Request.Builder requestBuilder(StandardHttpRequest request) {
    okhttp3.Request.Builder requestBuilder = newRequestBuilder();

    BodyContent body = request.body();
    if (body != null) {
      String contentType = request.getContentType();
      if (body instanceof StringBodyContent) {
        requestBuilder.method(request.method(),
            RequestBody.create(OkHttpClientImpl.parseMediaType(contentType), ((StringBodyContent) body).getContent()));
      } else if (body instanceof ByteArrayBodyContent) {
        requestBuilder.method(request.method(),
            RequestBody.create(OkHttpClientImpl.parseMediaType(contentType), ((ByteArrayBodyContent) body).getContent()));
      } else if (body instanceof InputStreamBodyContent) {
        InputStreamBodyContent bodyContent = (InputStreamBodyContent) body;
        requestBuilder.method(request.method(), new RequestBody() {

          @Override
          public void writeTo(BufferedSink sink) throws IOException {
            try (final BufferedInputStream bis = new BufferedInputStream(bodyContent.getContent());
                final Source source = Okio.source(bis)) {
              sink.writeAll(source);
            }
          }

          @Override
          public MediaType contentType() {
            return OkHttpClientImpl.parseMediaType(contentType);
          }

          @Override
          public long contentLength() throws IOException {
            return bodyContent.getLength();
          }
        });
      } else {
        throw new AssertionError("Unsupported body content");
      }
    }

    request.headers().entrySet().stream()
        .forEach(e -> e.getValue().stream().forEach(v -> requestBuilder.addHeader(e.getKey(), v)));
    try {
      requestBuilder.url(request.uri().toURL());
    } catch (MalformedURLException e) {
      throw new IllegalArgumentException(request.uri().toString(), e);
    }
    if (request.isExpectContinue()) {
      requestBuilder.header(StandardHttpHeaders.EXPECT, StandardHttpHeaders.EXPECT_CONTINUE);
    }
    return requestBuilder;
  }

  @Override
  public CompletableFuture<WebSocketResponse> buildWebSocketDirect(StandardWebSocketBuilder standardWebSocketBuilder,
      Listener listener) {
    final StandardHttpRequest fabric8Request = standardWebSocketBuilder.asHttpRequest();
    Request.Builder requestBuilder = requestBuilder(fabric8Request);
    if (standardWebSocketBuilder.getSubprotocol() != null) {
      requestBuilder.header("Sec-WebSocket-Protocol", standardWebSocketBuilder.getSubprotocol());
    }
    return OkHttpWebSocketImpl.buildAsync(httpClient, fabric8Request, requestBuilder.build(), listener);
  }

}
