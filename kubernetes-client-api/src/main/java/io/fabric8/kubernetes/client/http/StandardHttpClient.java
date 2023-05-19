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
import io.fabric8.kubernetes.client.utils.AsyncUtils;
import io.fabric8.kubernetes.client.utils.ExponentialBackoffIntervalCalculator;
import io.fabric8.kubernetes.client.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;
import java.net.URI;
import java.nio.ByteBuffer;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

public abstract class StandardHttpClient<C extends HttpClient, F extends HttpClient.Factory, T extends StandardHttpClientBuilder<C, F, ?>>
    implements HttpClient, RequestTags {

  // pads the fail-safe timeout to ensure we don't inadvertently timeout a request
  private static final long MAX_ADDITIONAL_REQUEST_TIMEOUT = TimeUnit.SECONDS.toMillis(5);

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
    final StandardHttpRequest standardHttpRequest = (StandardHttpRequest) request;
    return retryWithExponentialBackoff(
        standardHttpRequest,
        () -> consumeBytesOnce(standardHttpRequest, consumer),
        r -> r.body().cancel(),
        r -> r);
  }

  private CompletableFuture<HttpResponse<AsyncBody>> consumeBytesOnce(StandardHttpRequest standardHttpRequest,
      Consumer<List<ByteBuffer>> consumer) {
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
    cf.thenAccept(
        response -> builder.getInterceptors().values().forEach(i -> i.after(effectiveRequest, response, effectiveConsumer)));

    for (Interceptor interceptor : builder.getInterceptors().values()) {
      cf = cf.thenCompose(response -> {
        if (!HttpResponse.isSuccessful(response.code())) {
          return interceptor.afterFailure(copy, response, this)
              .thenCompose(b -> {
                if (Boolean.TRUE.equals(b)) {
                  // before starting another request, make sure the old one is cancelled / closed
                  response.body().cancel();
                  CompletableFuture<HttpResponse<AsyncBody>> result = consumeBytesDirect(copy.build(), effectiveConsumer);
                  result.thenAccept(
                      r -> builder.getInterceptors().values().forEach(i -> i.after(effectiveRequest, r, effectiveConsumer)));
                  return result;
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
  private <V> CompletableFuture<V> retryWithExponentialBackoff(
      StandardHttpRequest request, Supplier<CompletableFuture<V>> action, java.util.function.Consumer<V> onCancel,
      Function<V, HttpResponse<?>> responseExtractor) {
    final URI uri = request.uri();
    final RequestConfig requestConfig = getTag(RequestConfig.class);
    final ExponentialBackoffIntervalCalculator retryIntervalCalculator = ExponentialBackoffIntervalCalculator
        .from(requestConfig);
    final Duration timeout;
    if (request.getTimeout() != null && !request.getTimeout().isNegative() && !request.getTimeout().isZero()) {
      timeout = request.getTimeout().plusMillis(Math.min(request.getTimeout().toMillis(), MAX_ADDITIONAL_REQUEST_TIMEOUT));
    } else {
      timeout = null;
    }
    return AsyncUtils.retryWithExponentialBackoff(action, onCancel, timeout, retryIntervalCalculator,
        (response, throwable, retryInterval) -> {
          if (response != null) {
            HttpResponse<?> httpResponse = responseExtractor.apply(response);
            if (httpResponse != null) {
              final int code = httpResponse.code();
              if (code == 429 || code >= 500) {
                retryInterval = Math.max(retryAfterMillis(httpResponse), retryInterval);
                LOG.debug(
                    "HTTP operation on url: {} should be retried as the response code was {}, retrying after {} millis",
                    uri, code, retryInterval);
                return true;
              }
            }
          } else {
            if (throwable instanceof CompletionException) {
              throwable = throwable.getCause();
            }
            if (throwable instanceof IOException) {
              // TODO: may not be specific enough - incorrect ssl settings for example will get caught here
              LOG.debug(
                  String.format("HTTP operation on url: %s should be retried after %d millis because of IOException",
                      uri, retryInterval),
                  throwable);
              return true;
            }
          }
          return false;
        });
  }

  private long retryAfterMillis(HttpResponse<?> httpResponse) {
    String retryAfter = httpResponse.header("Retry-After");
    if (retryAfter != null) {
      try {
        return Integer.parseInt(retryAfter) * 1000L;
      } catch (NumberFormatException e) {
        // not a simple number
      }
      // Kubernetes does not seem to currently use this, but just in case
      try {
        ZonedDateTime after = ZonedDateTime.parse(retryAfter, DateTimeFormatter.RFC_1123_DATE_TIME);
        return after.toEpochSecond() * 1000 - System.currentTimeMillis();
      } catch (DateTimeParseException e1) {
        // not a recognized http date
      }
    }
    return 0; // we'll just use the default
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

    final CompletableFuture<WebSocketResponse> intermediate = retryWithExponentialBackoff(
        standardWebSocketBuilder.asHttpRequest(),
        () -> buildWebSocketOnce(standardWebSocketBuilder, listener),
        r -> Optional.ofNullable(r.webSocket).ifPresent(w -> w.sendClose(1000, null)),
        r -> r.webSocketUpgradeResponse);

    CompletableFuture<WebSocket> result = new CompletableFuture<>();

    // map to a websocket
    intermediate.whenComplete((r, t) -> {
      if (t != null) {
        result.completeExceptionally(t);
      } else {
        completeOrCancel(w -> w.sendClose(1000, null), result)
            .accept(r.webSocket,
                r.throwable != null
                    ? new WebSocketHandshakeException(r.webSocketUpgradeResponse).initCause(r.throwable)
                    : null);
      }
    });
    return result;
  }

  private CompletableFuture<WebSocketResponse> buildWebSocketOnce(StandardWebSocketBuilder standardWebSocketBuilder,
      Listener listener) {
    final StandardWebSocketBuilder copy = standardWebSocketBuilder.newBuilder();
    builder.getInterceptors().values().forEach(i -> i.before(copy, copy.asHttpRequest(), this));

    CompletableFuture<WebSocketResponse> cf = buildWebSocketDirect(copy, listener);
    cf.thenAccept(response -> builder.getInterceptors().values()
        .forEach(i -> i.after(response.webSocketUpgradeResponse.request(), response.webSocketUpgradeResponse, null)));

    for (Interceptor interceptor : builder.getInterceptors().values()) {
      cf = cf.thenCompose(response -> {
        if (response.throwable != null) {
          return interceptor.afterFailure(copy, response.webSocketUpgradeResponse, this).thenCompose(b -> {
            if (Boolean.TRUE.equals(b)) {
              return this.buildWebSocketDirect(copy, listener);
            }
            CompletableFuture<WebSocketResponse> result = CompletableFuture.completedFuture(response);
            result.thenAccept(r -> builder.getInterceptors().values()
                .forEach(i -> i.after(r.webSocketUpgradeResponse.request(), r.webSocketUpgradeResponse, null)));
            return result;
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
