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
import io.fabric8.kubernetes.client.utils.InputStreamPumper;
import io.fabric8.kubernetes.client.utils.Utils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import static io.fabric8.kubernetes.client.utils.Utils.closeQuietly;
import static io.fabric8.kubernetes.client.utils.Utils.shutdownExecutorService;

public class LogWatchCallback implements LogWatch, Callback, AutoCloseable {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogWatchCallback.class);

    private final Config config;
    private final OutputStream out;
    private final PipedInputStream output;
    private final Set<Closeable> toClose = new LinkedHashSet<>();

    private final AtomicBoolean started = new AtomicBoolean(false);
    private final ArrayBlockingQueue<Object> queue = new ArrayBlockingQueue<>(1);
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();
    private final AtomicBoolean closed = new AtomicBoolean(false);

    private InputStreamPumper pumper;

    @Deprecated
    public LogWatchCallback(OutputStream out) {
        this(new Config(), out);
    }

  public LogWatchCallback(Config config, OutputStream out) {
    this.config = config;
    if (out == null) {
      this.out = new PipedOutputStream();
      this.output = new PipedInputStream();
      toClose.add(this.out);
      toClose.add(this.output);
    } else {
      this.out = out;
      this.output = null;
    }

    //We need to connect the pipe here, because onResponse might not be called in time (if log is empty)
    //This will cause a `Pipe not connected` exception for everyone that tries to read. By always opening
    //the pipe the user will get a ready to use inputstream, which will block until there is actually something to read.
    if (this.out instanceof PipedOutputStream && this.output != null) {
      try {
        this.output.connect((PipedOutputStream) this.out);
      } catch (IOException e) {
        throw KubernetesClientException.launderThrowable(e);
      }
    }
  }

    @Override
    public void close() {
        cleanUp();
    }

    /**
     * Performs the cleanup tasks:
     * 1. closes the InputStream pumper
     * 2. closes all internally managed closeables (piped streams).
     *
     * The order of these tasks can't change or its likely that the pumper will through errors,
     * if the stream it uses closes before the pumper it self.
     */
    private void cleanUp() {
      try {
        if (!closed.compareAndSet(false, true)) {
          return;
        }

        closeQuietly(pumper);
        shutdownExecutorService(executorService);
      } finally {
        closeQuietly(toClose);
      }
    }

    public void waitUntilReady() {
      if (!Utils.waitUntilReady(queue, config.getRequestTimeout(), TimeUnit.MILLISECONDS)) {
        if (LOGGER.isDebugEnabled()) {
          LOGGER.warn("Log watch request has not been opened within: " + config.getRequestTimeout() + " millis.");
        }
      }
    }

    public InputStream getOutput() {
        return output;
    }

    @Override
    public void onFailure(Call call, IOException ioe) {
        //If we have closed the watch ignore everything
        if (closed.get())  {
            return;
        }

        LOGGER.error("Log Callback Failure.", ioe);
        //We only need to queue startup failures.
        if (!started.get()) {
            queue.add(ioe);
        }
    }

    @Override
    public void onResponse(Call call, final Response response) throws IOException {
       pumper = new InputStreamPumper(response.body().byteStream(), new io.fabric8.kubernetes.client.Callback<byte[]>(){
            @Override
            public void call(byte[] input) {
                try {
                    out.write(input);
                } catch (IOException e) {
                    throw KubernetesClientException.launderThrowable(e);
                }
            }
        }, new Runnable() {
            @Override
            public void run() {
                response.close();
            }
        });
        executorService.submit(pumper);
        started.set(true);
        queue.add(true);

    }
}
