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
import java.util.Map;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiConsumer;

public class HttpLoggingInterceptor implements Interceptor {

  private final HttpLogger httpLogger;
  private final Map<UUID, DeferredLoggingConsumer> activeConsumers;

  public HttpLoggingInterceptor() {
    this(LoggerFactory.getLogger(HttpLoggingInterceptor.class));
  }

  public HttpLoggingInterceptor(Logger logger) {
    this.httpLogger = new HttpLogger(logger);
    activeConsumers = new ConcurrentHashMap<>();
  }

  @Override
  public AsyncBody.Consumer<List<ByteBuffer>> consumer(AsyncBody.Consumer<List<ByteBuffer>> consumer, HttpRequest request) {
    final DeferredLoggingConsumer interceptedConsumer = new DeferredLoggingConsumer(httpLogger, request, consumer,
        () -> activeConsumers.remove(request.id()));
    activeConsumers.put(request.id(), interceptedConsumer);
    return interceptedConsumer;
  }

  @Override
  public void after(HttpRequest request, HttpResponse<?> response) {
    if (response instanceof WebSocketUpgradeResponse) {
      httpLogger.logWsStart();
      httpLogger.logRequest(request);
      httpLogger.logResponse(response);
      httpLogger.logWsEnd();
    } else {
      activeConsumers.computeIfPresent(request.id(), (id, consumer) -> {
        consumer.originalResponse.set(response);
        if (response.body() instanceof AsyncBody) {
          consumer.processAsyncBody((AsyncBody) response.body());
        }
        return consumer;
      });
    }
  }

  private static final class DeferredLoggingConsumer
      implements AsyncBody.Consumer<List<ByteBuffer>>, BiConsumer<Void, Throwable> {

    private final HttpLogger httpLogger;
    private final HttpRequest originalRequest;
    private final AsyncBody.Consumer<List<ByteBuffer>> originalConsumer;
    private final Runnable cleanUp;
    private final AtomicReference<HttpResponse<?>> originalResponse;
    private final AtomicBoolean asyncBodyDoneProcessed;
    private final Queue<ByteBuffer> responseBody;

    public DeferredLoggingConsumer(HttpLogger httpLogger, HttpRequest originalRequest,
        AsyncBody.Consumer<List<ByteBuffer>> originalConsumer, Runnable cleanUp) {
      this.httpLogger = httpLogger;
      this.originalRequest = originalRequest;
      this.originalConsumer = originalConsumer;
      this.cleanUp = cleanUp;
      originalResponse = new AtomicReference<>();
      asyncBodyDoneProcessed = new AtomicBoolean(false);
      responseBody = new ConcurrentLinkedQueue<>();
    }

    @Override
    public void consume(List<ByteBuffer> value, AsyncBody asyncBody) throws Exception {
      if (!value.isEmpty() && BufferUtil.isPlainText(value.iterator().next())) {
        value.stream().map(BufferUtil::copy).forEach(responseBody::add); // Potential leak
      }
      originalConsumer.consume(value, asyncBody);
    }

    @Override
    public void accept(Void v, Throwable throwable) {
      httpLogger.logStart();
      httpLogger.logRequest(originalRequest);
      if (originalResponse.get() != null) {
        httpLogger.logResponse(originalResponse.get());
        httpLogger.logResponseBody(responseBody);
      }
      httpLogger.logEnd();
      responseBody.clear();
      cleanUp.run();
    }

    /**
     * Registers the asyncBody.done() callback.
     *
     * @param asyncBody the AsyncBody instance to register the callback on the done() future.
     */
    private void processAsyncBody(AsyncBody asyncBody) {
      if (asyncBodyDoneProcessed.compareAndSet(false, true)) {
        asyncBody.done().whenComplete(this);
      }
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

    void logResponseBody(Queue<ByteBuffer> responseBody) {
      if (logger.isTraceEnabled() && responseBody != null && !responseBody.isEmpty()) {
        final StringBuilder bodyString = new StringBuilder();
        while (!responseBody.isEmpty()) {
          bodyString.append(StandardCharsets.UTF_8.decode(responseBody.poll()));
        }
        if (bodyString.length() > 0) {
          logger.trace(bodyString.toString());
        }
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
