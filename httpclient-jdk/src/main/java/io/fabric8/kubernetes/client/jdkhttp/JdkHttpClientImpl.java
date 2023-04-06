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

package io.fabric8.kubernetes.client.jdkhttp;

import io.fabric8.kubernetes.client.http.AsyncBody;
import io.fabric8.kubernetes.client.http.AsyncBody.Consumer;
import io.fabric8.kubernetes.client.http.BufferUtil;
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.http.HttpResponse;
import io.fabric8.kubernetes.client.http.StandardHttpClient;
import io.fabric8.kubernetes.client.http.StandardHttpRequest;
import io.fabric8.kubernetes.client.http.StandardHttpRequest.BodyContent;
import io.fabric8.kubernetes.client.http.StandardHttpRequest.ByteArrayBodyContent;
import io.fabric8.kubernetes.client.http.StandardHttpRequest.InputStreamBodyContent;
import io.fabric8.kubernetes.client.http.StandardHttpRequest.StringBodyContent;
import io.fabric8.kubernetes.client.http.StandardWebSocketBuilder;
import io.fabric8.kubernetes.client.http.WebSocket;
import io.fabric8.kubernetes.client.http.WebSocket.Listener;
import io.fabric8.kubernetes.client.http.WebSocketResponse;
import io.fabric8.kubernetes.client.http.WebSocketUpgradeResponse;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest.BodyPublisher;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.http.HttpResponse.BodySubscriber;
import java.net.http.HttpResponse.ResponseInfo;
import java.nio.ByteBuffer;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import static io.fabric8.kubernetes.client.http.StandardHttpHeaders.CONTENT_TYPE;

/**
 * TODO:
 * - Mapping to a Reader is always UTF-8
 * - determine if write timeout should be implemented
 */
public class JdkHttpClientImpl extends StandardHttpClient<JdkHttpClientImpl, JdkHttpClientFactory, JdkHttpClientBuilderImpl> {

  /**
   * Adapts the BodyHandler to immediately complete the body
   */
  private static final class BodyHandlerAdapter implements BodyHandler<AsyncBody> {
    private final AsyncBodySubscriber<?> subscriber;
    private final BodyHandler<Void> handler;

    private BodyHandlerAdapter(AsyncBodySubscriber<?> subscriber, BodyHandler<Void> handler) {
      this.subscriber = subscriber;
      this.handler = handler;
    }

    @Override
    public BodySubscriber<AsyncBody> apply(ResponseInfo responseInfo) {
      BodySubscriber<Void> bodySubscriber = handler.apply(responseInfo);
      return new BodySubscriber<AsyncBody>() {
        CompletableFuture<AsyncBody> cf = CompletableFuture.completedFuture(subscriber);

        @Override
        public void onSubscribe(Subscription subscription) {
          bodySubscriber.onSubscribe(subscription);
        }

        @Override
        public void onNext(List<ByteBuffer> item) {
          // there doesn't seem to be a guarantee that the buffer won't be modified by the caller
          // after passing it in, so we'll create a copy
          bodySubscriber.onNext(item.stream().map(BufferUtil::copy).collect(Collectors.toList()));
        }

        @Override
        public void onError(Throwable throwable) {
          bodySubscriber.onError(throwable);
        }

        @Override
        public void onComplete() {
          bodySubscriber.onComplete();
        }

        @Override
        public CompletionStage<AsyncBody> getBody() {
          return cf;
        }
      };
    }
  }

  private static final class AsyncBodySubscriber<T> implements Subscriber<T>, AsyncBody {
    private final AsyncBody.Consumer<T> consumer;
    private final CompletableFuture<Void> done = new CompletableFuture<Void>();
    private final CompletableFuture<Flow.Subscription> subscription = new CompletableFuture<>();

    private AsyncBodySubscriber(AsyncBody.Consumer<T> consumer) {
      this.consumer = consumer;
    }

    @Override
    public void onSubscribe(Subscription subscription) {
      if (this.subscription.isDone()) {
        subscription.cancel();
        return;
      }
      this.subscription.complete(subscription);
    }

    @Override
    public void onNext(T item) {
      try {
        if (item == null) {
          done.complete(null);
        } else {
          consumer.consume(item, this);
        }
      } catch (Exception e) {
        subscription.thenAccept(Subscription::cancel);
        done.completeExceptionally(e);
      }
    }

    @Override
    public void onError(Throwable throwable) {
      done.completeExceptionally(throwable);
    }

    @Override
    public void onComplete() {
      done.complete(null);
    }

    @Override
    public void consume() {
      if (done.isDone()) {
        return;
      }
      this.subscription.thenAccept(s -> s.request(1));
    }

    @Override
    public CompletableFuture<Void> done() {
      return done;
    }

    @Override
    public void cancel() {
      subscription.thenAccept(Subscription::cancel);
      done.cancel(false);
    }

  }

  private static class JdkHttpResponseImpl<T> implements HttpResponse<T> {

    private java.net.http.HttpResponse<?> response;
    private T body;

    public JdkHttpResponseImpl(java.net.http.HttpResponse<T> response) {
      this(response, response.body());
    }

    public JdkHttpResponseImpl(java.net.http.HttpResponse<?> response, T body) {
      this.response = response;
      this.body = body;
    }

    @Override
    public List<String> headers(String key) {
      return response.headers().allValues(key);
    }

    @Override
    public Map<String, List<String>> headers() {
      return response.headers().map();
    }

    @Override
    public int code() {
      return response.statusCode();
    }

    @Override
    public T body() {
      return body;
    }

    @Override
    public HttpRequest request() {
      java.net.http.HttpRequest request = response.request();
      // TODO: could try to subscribe to the request body, will just assume a null body for now
      return new StandardHttpRequest(request.headers().map(), request.uri(), request.method(), null);
    }

    @Override
    public Optional<HttpResponse<?>> previousResponse() {
      return response.previousResponse().map(JdkHttpResponseImpl::new);
    }

  }

  private java.net.http.HttpClient httpClient;

  public JdkHttpClientImpl(JdkHttpClientBuilderImpl builder, HttpClient httpClient) {
    super(builder);
    this.httpClient = httpClient;
  }

  @Override
  public void close() {
    if (this.httpClient == null) {
      return;
    }
    builder.getClientFactory().closeHttpClient(this);
    // help with default cleanup, which is based upon garbage collection
    this.httpClient = null;
  }

  @Override
  public DerivedClientBuilder newBuilder() {
    return this.builder.copy(this);
  }

  @Override
  public CompletableFuture<HttpResponse<AsyncBody>> consumeBytesDirect(StandardHttpRequest request,
      Consumer<List<ByteBuffer>> consumer) {
    AsyncBodySubscriber<List<ByteBuffer>> subscriber = new AsyncBodySubscriber<>(consumer);
    BodyHandler<Void> handler = BodyHandlers.fromSubscriber(subscriber);
    BodyHandler<AsyncBody> handlerAdapter = new BodyHandlerAdapter(subscriber, handler);

    return this.getHttpClient().sendAsync(requestBuilder(request).build(), handlerAdapter)
        .thenApply(r -> new JdkHttpResponseImpl<>(r, r.body()));
  }

  java.net.http.HttpRequest.Builder requestBuilder(StandardHttpRequest request) {
    java.net.http.HttpRequest.Builder requestBuilder = java.net.http.HttpRequest.newBuilder();

    Duration readTimeout = this.builder.getReadTimeout();
    if (readTimeout != null && !java.time.Duration.ZERO.equals(readTimeout)) {
      requestBuilder.timeout(readTimeout);
    }

    request.headers().entrySet().stream()
        .forEach(e -> e.getValue().stream().forEach(v -> requestBuilder.header(e.getKey(), v)));
    if (request.getContentType() != null) {
      requestBuilder.setHeader(CONTENT_TYPE, request.getContentType());
    }

    BodyContent body = request.body();
    if (body != null) {
      if (body instanceof StringBodyContent) {
        requestBuilder.method(request.method(), BodyPublishers.ofString(((StringBodyContent) body).getContent()));
      } else if (body instanceof ByteArrayBodyContent) {
        requestBuilder.method(request.method(), BodyPublishers.ofByteArray(((ByteArrayBodyContent) body).getContent()));
      } else if (body instanceof InputStreamBodyContent) {
        InputStreamBodyContent bodyContent = (InputStreamBodyContent) body;
        BodyPublisher publisher = BodyPublishers.ofInputStream(bodyContent::getContent);
        requestBuilder.method(request.method(), new BodyPublisher() {

          @Override
          public void subscribe(Subscriber<? super ByteBuffer> subscriber) {
            publisher.subscribe(subscriber);
          }

          @Override
          public long contentLength() {
            return bodyContent.getLength();
          }
        });
      } else {
        throw new AssertionError("Unsupported body content");
      }
    }

    requestBuilder.uri(request.uri());
    if (request.isExpectContinue() && this.builder.getClientFactory().useExpectContinue()) {
      requestBuilder.expectContinue(true);
    }
    return requestBuilder;
  }

  @Override
  public CompletableFuture<WebSocketResponse> buildWebSocketDirect(
      StandardWebSocketBuilder standardWebSocketBuilder, Listener listener) {
    final StandardHttpRequest request = standardWebSocketBuilder.asHttpRequest();
    java.net.http.WebSocket.Builder newBuilder = this.getHttpClient().newWebSocketBuilder();
    request.headers().forEach((k, v) -> v.forEach(s -> newBuilder.header(k, s)));
    if (standardWebSocketBuilder.getSubprotocol() != null) {
      newBuilder.subprotocols(standardWebSocketBuilder.getSubprotocol());
    }
    // the Watch logic sets a websocketTimeout as the readTimeout
    // TODO: this should probably be made clearer in the docs
    Duration readTimeout = this.builder.getReadTimeout();
    if (readTimeout != null && !java.time.Duration.ZERO.equals(readTimeout)) {
      newBuilder.connectTimeout(readTimeout);
    }

    AtomicLong queueSize = new AtomicLong();

    // use a responseholder to convey both the exception and the websocket
    CompletableFuture<WebSocketResponse> response = new CompletableFuture<>();

    URI uri = WebSocket.toWebSocketUri(request.uri());
    newBuilder.buildAsync(uri, new JdkWebSocketImpl.ListenerAdapter(listener, queueSize)).whenComplete((jdkWebSocket, t) -> {
      if (t instanceof CompletionException && t.getCause() != null) {
        t = t.getCause();
      }
      final JdkWebSocketImpl fabric8WebSocket = new JdkWebSocketImpl(queueSize, jdkWebSocket);
      if (t instanceof java.net.http.WebSocketHandshakeException) {
        final java.net.http.HttpResponse<?> jdkResponse = ((java.net.http.WebSocketHandshakeException) t).getResponse();
        final WebSocketUpgradeResponse upgradeResponse = new WebSocketUpgradeResponse(
            request, jdkResponse.statusCode(), jdkResponse.headers().map(), fabric8WebSocket);
        response.complete(new WebSocketResponse(upgradeResponse,
            new io.fabric8.kubernetes.client.http.WebSocketHandshakeException(upgradeResponse).initCause(t)));
      } else if (t != null) {
        response.completeExceptionally(t);
      } else {
        response.complete(new WebSocketResponse(new WebSocketUpgradeResponse(request, fabric8WebSocket), null));
      }
    });

    return response;
  }

  java.net.http.HttpClient getHttpClient() {
    if (httpClient == null) {
      throw new IllegalStateException("Client already closed");
    }
    return httpClient;
  }

}
