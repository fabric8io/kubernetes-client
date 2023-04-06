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

import io.fabric8.kubernetes.client.RequestConfig;
import io.fabric8.kubernetes.client.http.AsyncBody.Consumer;
import io.fabric8.kubernetes.client.http.Interceptor.RequestTags;
import io.fabric8.kubernetes.client.http.WebSocket.Listener;
import io.fabric8.kubernetes.client.utils.ExponentialBackoffIntervalCalculator;
import io.fabric8.kubernetes.client.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

public abstract class StandardHttpClient<C extends HttpClient, F extends HttpClient.Factory, T extends StandardHttpClientBuilder<C, F, ?>>
    implements HttpClient, RequestTags {

  private static final Logger LOG = LoggerFactory.getLogger(StandardHttpClient.class);

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
  public <V> CompletableFuture<HttpResponse<V>> sendAsync(HttpRequest request, Class<V> type) {
    CompletableFuture<HttpResponse<V>> upstream = HttpResponse.SupportedResponses.from(type).sendAsync(request, this);
    final CompletableFuture<HttpResponse<V>> result = new CompletableFuture<>();
    upstream.whenComplete(completeOrCancel(r -> {
      if (r.body() instanceof Closeable) {
        Utils.closeQuietly((Closeable) r.body());
      }
    }, result));
    return result;
  }

  @Override
  public CompletableFuture<HttpResponse<AsyncBody>> consumeBytes(HttpRequest request, Consumer<List<ByteBuffer>> consumer) {
    CompletableFuture<HttpResponse<AsyncBody>> result = new CompletableFuture<>();

    retryWithExponentialBackoff(result, () -> consumeBytesOnce(request, consumer), request.uri(), HttpResponse::code,
        r -> r.body().cancel());
    return result;
  }

  private CompletableFuture<HttpResponse<AsyncBody>> consumeBytesOnce(HttpRequest request,
      Consumer<List<ByteBuffer>> consumer) {
    StandardHttpRequest standardHttpRequest = (StandardHttpRequest) request;
    StandardHttpRequest.Builder copy = standardHttpRequest.newBuilder();
    for (Interceptor interceptor : builder.getInterceptors().values()) {
      interceptor.before(copy, standardHttpRequest, this);
      standardHttpRequest = copy.build();
    }
    final StandardHttpRequest effectiveRequest = standardHttpRequest;

    for (Interceptor interceptor : builder.getInterceptors().values()) {
      consumer = interceptor.consumer(consumer, effectiveRequest);
    }
    final Consumer<List<ByteBuffer>> effectiveConsumer = consumer;

    CompletableFuture<HttpResponse<AsyncBody>> cf = consumeBytesDirect(effectiveRequest, effectiveConsumer);

    for (Interceptor interceptor : builder.getInterceptors().values()) {
      cf = cf.thenCompose(response -> {
        interceptor.after(effectiveRequest, response);
        if (!HttpResponse.isSuccessful(response.code())) {
          return interceptor.afterFailure(copy, response, this)
              .thenCompose(b -> {
                if (Boolean.TRUE.equals(b)) {
                  // before starting another request, make sure the old one is cancelled / closed
                  response.body().cancel();
                  return consumeBytesDirect(copy.build(), effectiveConsumer);
                }
                return CompletableFuture.completedFuture(response);
              });
        }
        return CompletableFuture.completedFuture(response);
      });
    }
    return cf;
  }

  private static <V> BiConsumer<? super V, ? super Throwable> completeOrCancel(java.util.function.Consumer<V> cancel,
      final CompletableFuture<V> result) {
    return (r, t) -> {
      if (t != null) {
        result.completeExceptionally(t);
      } else {
        if (!result.complete(r)) {
          cancel.accept(r);
        }
      }
    };
  }

  /**
   * Will retry the action if needed based upon the retry settings provided by the ExponentialBackoffIntervalCalculator.
   */
  protected <V> void retryWithExponentialBackoff(CompletableFuture<V> result,
      Supplier<CompletableFuture<V>> action, URI uri, Function<V, Integer> codeExtractor,
      java.util.function.Consumer<V> cancel, ExponentialBackoffIntervalCalculator retryIntervalCalculator) {

    action.get()
        .whenComplete((response, throwable) -> {
          if (retryIntervalCalculator.shouldRetry() && !result.isDone()) {
            long retryInterval = retryIntervalCalculator.nextReconnectInterval();
            boolean retry = false;
            if (response != null) {
              Integer code = codeExtractor.apply(response);
              if (code != null && code >= 500) {
                LOG.debug("HTTP operation on url: {} should be retried as the response code was {}, retrying after {} millis",
                    uri, code, retryInterval);
                retry = true;
                cancel.accept(response);
              }
            } else if (throwable instanceof IOException) {
              LOG.debug(String.format("HTTP operation on url: %s should be retried after %d millis because of IOException",
                  uri, retryInterval), throwable);
              retry = true;
            }
            if (retry) {
              Utils.schedule(Runnable::run,
                  () -> retryWithExponentialBackoff(result, action, uri, codeExtractor, cancel, retryIntervalCalculator),
                  retryInterval,
                  TimeUnit.MILLISECONDS);
              return;
            }
          }
          completeOrCancel(cancel, result).accept(response, throwable);
        });
  }

  protected <V> void retryWithExponentialBackoff(CompletableFuture<V> result,
      Supplier<CompletableFuture<V>> action, URI uri, Function<V, Integer> codeExtractor,
      java.util.function.Consumer<V> cancel) {
    retryWithExponentialBackoff(result, action, uri, codeExtractor, cancel,
        ExponentialBackoffIntervalCalculator.from(getTag(RequestConfig.class)));
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

    CompletableFuture<WebSocketResponse> intermediate = new CompletableFuture<>();

    retryWithExponentialBackoff(intermediate, () -> buildWebSocketOnce(standardWebSocketBuilder, listener),
        standardWebSocketBuilder.asHttpRequest().uri(),
        r -> Optional.ofNullable(r.wshse).map(WebSocketHandshakeException::getResponse).map(HttpResponse::code).orElse(null),
        r -> Optional.ofNullable(r.webSocketUpgradeResponse.getWebSocket()).ifPresent(w -> w.sendClose(1000, null)));

    CompletableFuture<WebSocket> result = new CompletableFuture<>();

    // map to a websocket
    intermediate.whenComplete((r, t) -> {
      if (t != null) {
        result.completeExceptionally(t);
      } else {
        completeOrCancel(w -> w.sendClose(1000, null), result)
            .accept(r.webSocketUpgradeResponse.getWebSocket(), r.wshse);
      }
    });
    return result;
  }

  private CompletableFuture<WebSocketResponse> buildWebSocketOnce(StandardWebSocketBuilder standardWebSocketBuilder,
      Listener listener) {
    final StandardWebSocketBuilder copy = standardWebSocketBuilder.newBuilder();
    builder.getInterceptors().values().forEach(i -> i.before(copy, copy.asHttpRequest(), this));

    CompletableFuture<WebSocketResponse> cf = buildWebSocketDirect(copy, listener);
    for (Interceptor interceptor : builder.getInterceptors().values()) {
      cf = cf.thenCompose(response -> {
        interceptor.after(response.webSocketUpgradeResponse.request(), response.webSocketUpgradeResponse);
        if (response.wshse != null && response.wshse.getResponse() != null) {
          return interceptor.afterFailure(copy, response.wshse.getResponse(), this).thenCompose(b -> {
            if (Boolean.TRUE.equals(b)) {
              return this.buildWebSocketDirect(copy, listener);
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
  public <V> V getTag(Class<V> type) {
    return type.cast(builder.tags.get(type));
  }

}
