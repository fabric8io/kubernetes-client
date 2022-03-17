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

import io.fabric8.kubernetes.client.dsl.LogWatch;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.HttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedOutputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import static io.fabric8.kubernetes.client.utils.Utils.closeQuietly;

public class LogWatchCallback implements LogWatch, AutoCloseable {

  private static final Logger LOGGER = LoggerFactory.getLogger(LogWatchCallback.class);

  private OutputStream out;
  private WritableByteChannel outChannel;
  private volatile InputStream output;
  private final Set<Closeable> toClose = new LinkedHashSet<>();

  private final AtomicBoolean closed = new AtomicBoolean(false);

  public LogWatchCallback(OutputStream out) {
    this.out = out;
    if (this.out instanceof PipedOutputStream) {
      toClose.add(this.out);
    }
    if (out != null) {
      outChannel = Channels.newChannel(out);
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

    closeQuietly(toClose);
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
      clone.consumeBytes(request, (buffers, a) -> {
        // assuming non-blocking - which may not be valid
        // if we need to change this, then we'll have to delegate this to an executor
        for (ByteBuffer byteBuffer : buffers) {
          outChannel.write(byteBuffer);
        }
        a.consume();
      }).whenComplete((a, e) -> {
        if (e != null) {
          onFailure(e);
        }
        if (a != null) {
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
