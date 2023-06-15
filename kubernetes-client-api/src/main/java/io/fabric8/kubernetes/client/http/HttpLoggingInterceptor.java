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

import io.fabric8.kubernetes.client.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

import static io.fabric8.kubernetes.client.http.BufferUtil.copy;

public class HttpLoggingInterceptor implements Interceptor {

  private final HttpLogger httpLogger;

  public HttpLoggingInterceptor() {
    this(LoggerFactory.getLogger(HttpLoggingInterceptor.class));
  }

  public HttpLoggingInterceptor(Logger logger) {
    this.httpLogger = new HttpLogger(logger);
  }

  @Override
  public AsyncBody.Consumer<List<ByteBuffer>> consumer(AsyncBody.Consumer<List<ByteBuffer>> consumer, HttpRequest request) {
    return new DeferredLoggingConsumer(httpLogger, request, consumer);
  }

  @Override
  public void after(HttpRequest request, HttpResponse<?> response, AsyncBody.Consumer<List<ByteBuffer>> consumer) {
    if (response instanceof WebSocketUpgradeResponse) {
      httpLogger.logWsStart();
      httpLogger.logRequest(request);
      httpLogger.logResponse(response);
      httpLogger.logWsEnd();
    } else {
      DeferredLoggingConsumer deferredLoggingConsumer = consumer.unwrap(DeferredLoggingConsumer.class);
      if (response.body() instanceof AsyncBody && deferredLoggingConsumer != null) {
        deferredLoggingConsumer.processAsyncBody((AsyncBody) response.body(), response);
      } else {
        // currently not possible
        httpLogger.logStart();
        httpLogger.logRequest(request);
        httpLogger.logResponse(response);
        httpLogger.logEnd();
      }
    }
  }

  private static final class DeferredLoggingConsumer
      implements AsyncBody.Consumer<List<ByteBuffer>> {

    private static final long MAX_BODY_SIZE = 2097152L; // 2MiB

    private final HttpLogger httpLogger;
    private final HttpRequest originalRequest;
    private final AsyncBody.Consumer<List<ByteBuffer>> originalConsumer;
    private final AtomicLong responseBodySize;
    private final Queue<ByteBuffer> responseBody;
    private final AtomicBoolean bodyTruncated = new AtomicBoolean();

    public DeferredLoggingConsumer(HttpLogger httpLogger, HttpRequest originalRequest,
        AsyncBody.Consumer<List<ByteBuffer>> originalConsumer) {
      this.httpLogger = httpLogger;
      this.originalRequest = originalRequest;
      this.originalConsumer = originalConsumer;
      responseBodySize = new AtomicLong(0);
      responseBody = new ConcurrentLinkedQueue<>();
    }

    @Override
    public void consume(List<ByteBuffer> value, AsyncBody asyncBody) throws Exception {
      try {
        value.stream().forEach(bb -> {
          if (responseBodySize.addAndGet(bb.remaining()) < MAX_BODY_SIZE && !bodyTruncated.get()
              && BufferUtil.isPlainText(bb)) {
            responseBody.add(copy(bb));
          } else {
            bodyTruncated.set(true);
          }
        });
      } finally {
        originalConsumer.consume(value, asyncBody);
      }
    }

    @Override
    public <U> U unwrap(Class<U> target) {
      return Optional.ofNullable(AsyncBody.Consumer.super.unwrap(target)).orElse(originalConsumer.unwrap(target));
    }

    /**
     * Registers the asyncBody.done() callback.
     *
     * @param asyncBody the AsyncBody instance to register the callback on the done() future.
     * @param response
     */
    private void processAsyncBody(AsyncBody asyncBody, HttpResponse<?> response) {
      asyncBody.done().whenComplete((Void v, Throwable throwable) -> {
        httpLogger.logStart();
        // TODO: we also have access to the response.request, which may be different than originalRequest
        httpLogger.logRequest(originalRequest);
        httpLogger.logResponse(response);
        httpLogger.logResponseBody(responseBody, responseBodySize.get(), bodyTruncated.get());
        httpLogger.logEnd();
        responseBody.clear();
      });
    }
  }

  private static final class HttpLogger {
    private final Logger logger;

    private HttpLogger(Logger logger) {
      this.logger = logger;
    }

    void logRequest(HttpRequest request) {
      if (logger.isTraceEnabled() && request != null) {
        logger.trace("> {} {}", request.method(), request.uri());
        request.headers().forEach((h, vv) -> vv.forEach(v -> logger.trace("> {}: {}", h, v)));
        if (!Utils.isNullOrEmpty(request.bodyString())) {
          logger.trace(request.bodyString());
        }
      }
    }

    void logResponse(HttpResponse<?> response) {
      if (logger.isTraceEnabled() && response != null) {
        logger.trace("< {} {}", response.code(), response.message());
        response.headers().forEach((h, vv) -> vv.forEach(v -> logger.trace("< {}: {}", h, v)));
      }
    }

    void logResponseBody(Queue<ByteBuffer> responseBody, long bytesReceived, boolean truncated) {
      if (logger.isTraceEnabled()) {
        final StringBuilder bodyString = new StringBuilder();
        if (responseBody != null && !responseBody.isEmpty()) {
          while (!responseBody.isEmpty()) {
            bodyString.append(StandardCharsets.UTF_8.decode(responseBody.poll()));
          }
        }

        // we'll typically have bytes == content length,
        // but it can be less if binary, truncated, or an error happened
        if (truncated) {
          bodyString.append("... body bytes ").append(bytesReceived);
        }
        logger.trace(bodyString.toString());
      }
    }

    void logStart() {
      if (logger.isTraceEnabled()) {
        logger.trace("-HTTP START-");
      }
    }

    void logEnd() {
      if (logger.isTraceEnabled()) {
        logger.trace("-HTTP END-");
      }
    }

    void logWsStart() {
      if (logger.isTraceEnabled()) {
        logger.trace("-WS START-");
      }
    }

    void logWsEnd() {
      if (logger.isTraceEnabled()) {
        logger.trace("-WS END-");
      }
    }
  }
}
