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

import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.LogWatch;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.utils.internal.SerialExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class LogWatchCallback implements LogWatch, AutoCloseable {

  private static final Logger LOGGER = LoggerFactory.getLogger(LogWatchCallback.class);

  private OutputStream out;
  private WritableByteChannel outChannel;
  private volatile InputStream output;

  private final AtomicBoolean closed = new AtomicBoolean(false);
  private volatile Optional<HttpClient.AsyncBody> asyncBody = Optional.empty();
  private final SerialExecutor serialExecutor;

  public LogWatchCallback(OutputStream out, Executor executor) {
    this.out = out;
    if (out != null) {
      outChannel = Channels.newChannel(out);
    }
    this.serialExecutor = new SerialExecutor(executor);
  }

  @Override
  public void close() {
    cleanUp();
  }

  private void cleanUp() {
    if (!closed.compareAndSet(false, true)) {
      return;
    }
    asyncBody.ifPresent(HttpClient.AsyncBody::cancel);
    serialExecutor.shutdownNow();
  }

  public LogWatchCallback callAndWait(HttpClient client, URL url) {
    HttpRequest request = client.newHttpRequestBuilder().url(url).build();
    HttpClient clone = client.newBuilder().readTimeout(0, TimeUnit.MILLISECONDS).build();

    if (out == null) {
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
      // we don't know if the write will be blocking, so hand it off to another thread
      clone.consumeBytes(request, (buffers, a) -> CompletableFuture.runAsync(() -> {
        for (ByteBuffer byteBuffer : buffers) {
          try {
            outChannel.write(byteBuffer);
          } catch (IOException e1) {
            throw KubernetesClientException.launderThrowable(e1);
          }
        }
      }, serialExecutor).whenComplete((v, t) -> {
        if (t != null) {
          a.cancel();
          onFailure(t);
        } else if (!closed.get()) {
          a.consume();
        } else {
          a.cancel();
        }
      })).whenComplete((a, e) -> {
        if (e != null) {
          onFailure(e);
        }
        if (a != null) {
          asyncBody = Optional.of(a.body());
          a.body().consume();
          a.body().done().whenComplete((v, t) -> {
            if (t != null) {
              onFailure(t);
            } else {
              cleanUp();
            }
          });
        }
      });
    }

    return this;
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
