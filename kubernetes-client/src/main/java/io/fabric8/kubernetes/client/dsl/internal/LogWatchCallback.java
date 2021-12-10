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

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.LogWatch;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.http.HttpResponse;
import io.fabric8.kubernetes.client.utils.InputStreamPumper;
import io.fabric8.kubernetes.client.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.net.URL;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiConsumer;

import static io.fabric8.kubernetes.client.utils.Utils.closeQuietly;

public class LogWatchCallback implements LogWatch, AutoCloseable, BiConsumer<HttpResponse<InputStream>, Throwable> {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogWatchCallback.class);

    private final Config config;
    private final OutputStream out;
    private final PipedInputStream output;
    private final Set<Closeable> toClose = new LinkedHashSet<>();

    private final ExecutorService executorService = Executors.newSingleThreadExecutor();
    private final AtomicBoolean closed = new AtomicBoolean(false);

  public LogWatchCallback(Config config, OutputStream out) {
    this.config = config;
    if (out == null) {
      this.out = new PipedOutputStream();
      this.output = new PipedInputStream();
      try {
        // connect so the user will get a ready to use inputstream, which will block until there is actually something to read.
        this.output.connect((PipedOutputStream) this.out);
      } catch (IOException e) {
        throw KubernetesClientException.launderThrowable(e);
      }
    } else {
      this.out = out;
      this.output = null;
    }
    if (this.out instanceof PipedOutputStream) {
      toClose.add(this.out);
    }
  }

    @Override
    public void close() {
        cleanUp();
    }

    /**
     * Performs the cleanup tasks:
     * 1. cancels the InputStream pumper
     * 2. closes all internally managed closeables (piped streams).
     *
     * The order of these tasks can't change or its likely that the pumper will through errors,
     * if the stream it uses closes before the pumper it self.
     */
    private void cleanUp() {
      if (!closed.compareAndSet(false, true)) {
        return;
      }

      executorService.shutdownNow();
      closeQuietly(toClose);
    }

    public LogWatchCallback callAndWait(HttpClient client, URL url) {
      HttpRequest request = client.newHttpRequestBuilder().url(url).build();
      HttpClient clone = client.newBuilder().readTimeout(0, TimeUnit.MILLISECONDS).build();
      CompletableFuture<HttpResponse<InputStream>> future = clone.sendAsync(request, InputStream.class).whenComplete(this);

      if (!Utils.waitUntilReady(future, config.getRequestTimeout(), TimeUnit.MILLISECONDS)) {
        if (LOGGER.isWarnEnabled()) {
          LOGGER.warn("Log watch request has not been opened within: {} millis.",config.getRequestTimeout());
        }
      }
      return this;
    }

    @Override
    public InputStream getOutput() {
        return output;
    }
    
    @Override
    public void accept(HttpResponse<InputStream> t, Throwable u) {
      if (u != null) {
        onFailure(u);
      }
      if (t != null) {
        onResponse(t);
      }
    }

    public void onFailure(Throwable u) {
        //If we have closed the watch ignore everything
        if (closed.get())  {
            return;
        }

        LOGGER.error("Log Callback Failure.", u);
        cleanUp();
    }

    public void onResponse(final HttpResponse<InputStream> response) {
      InputStream body = response.body();
      if (!executorService.isShutdown()) {
        // the task will be cancelled via shutdownNow
        InputStreamPumper.pump(body, out::write, executorService).whenComplete((o, t) -> {
          cleanUp();
          Utils.closeQuietly(body);
        });
      } else {
        Utils.closeQuietly(body);
      }
    }
}
