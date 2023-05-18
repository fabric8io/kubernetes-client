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
package io.fabric8.kubernetes.client.dsl.internal;

import io.fabric8.kubernetes.client.RequestConfigBuilder;
import io.fabric8.kubernetes.client.StreamConsumer;
import io.fabric8.kubernetes.client.dsl.LogWatch;
import io.fabric8.kubernetes.client.http.AsyncBody;
import io.fabric8.kubernetes.client.http.BufferUtil;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.utils.internal.SerialExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class LogWatchCallback implements LogWatch, AutoCloseable {

  private static final Logger LOGGER = LoggerFactory.getLogger(LogWatchCallback.class);

  private final StreamConsumer consumer;
  private final boolean blocking;
  private final OperationContext context;
  private volatile InputStream output;

  private final AtomicBoolean closed = new AtomicBoolean(false);
  private final CompletableFuture<AsyncBody> asyncBody = new CompletableFuture<>();
  private final SerialExecutor serialExecutor;

  public LogWatchCallback(StreamConsumer consumer, boolean blocking, OperationContext context) {
    this.consumer = consumer;
    this.blocking = blocking;
    this.context = context;
    this.serialExecutor = new SerialExecutor(context.getExecutor());
  }

  @Override
  public void close() {
    cleanUp();
  }

  private void cleanUp() {
    if (!closed.compareAndSet(false, true)) {
      return;
    }
    asyncBody.thenAccept(AsyncBody::cancel);
    serialExecutor.shutdownNow();
  }

  public LogWatchCallback callAndWait(HttpClient client, URL url) {
    HttpRequest request = client.newHttpRequestBuilder().url(url).build();
    HttpClient clone = client.newBuilder()
        .tag(Optional.ofNullable(context.getRequestConfig()).map(RequestConfigBuilder::new).orElse(new RequestConfigBuilder())
            .withRequestTimeout(0).build())
        .readTimeout(0, TimeUnit.MILLISECONDS).build();

    if (consumer == null) {
      // we can pass the input stream directly to the consumer
      clone.sendAsync(request, InputStream.class).whenComplete((r, e) -> {
        if (e != null) {
          onFailure(e);
        }
        if (r != null) {
          this.output = r.body();
        }
      }).join();
    } else {
      // we need to write the bytes to the given output
      clone.consumeBytes(request, (buffers, a) -> ExecWebSocketListener.consume(consumer,
          ByteBuffer.wrap(BufferUtil.toArray(buffers)), blocking ? serialExecutor : Runnable::run, (t) -> postConsume(a, t)))
          .whenComplete((a, e) -> {
            if (e != null) {
              onFailure(e);
            }
            if (a != null) {
              asyncBody.complete(a.body());
              a.body().consume();
              a.body().done().whenComplete((v, t) -> CompletableFuture.runAsync(() -> {
                if (t != null) {
                  onFailure(t);
                } else {
                  cleanUp();
                }
              }, serialExecutor));
            }
          });
    }

    return this;
  }

  private void postConsume(AsyncBody a, Throwable t) {
    if (t != null) {
      a.cancel();
      onFailure(t);
    } else if (!closed.get()) {
      a.consume();
    } else {
      a.cancel();
    }
  }

  @Override
  public InputStream getOutput() {
    return output;
  }

  public void onFailure(Throwable u) {
    //If we have closed the watch ignore everything
    if (closed.get()) {
      return;
    }

    LOGGER.error("Log Callback Failure.", u);
    cleanUp();
  }

}
