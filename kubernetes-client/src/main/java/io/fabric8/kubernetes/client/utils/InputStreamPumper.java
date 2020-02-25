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
package io.fabric8.kubernetes.client.utils;

import io.fabric8.kubernetes.client.Callback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.util.concurrent.atomic.AtomicBoolean;

@Deprecated
// This is going to be an abstract class in the future.
// Use NonBlockingInputStreamPumper or BlockingInputStreamPumper instead.
public class InputStreamPumper implements Runnable, Closeable {

    private static final Logger LOGGER = LoggerFactory.getLogger(InputStreamReader.class);

    final InputStream in;
    final Callback<byte[]> callback;
    final Runnable onClose;
    final AtomicBoolean closed = new AtomicBoolean(false);

    volatile boolean keepReading = true;
    Thread thread;

    public InputStreamPumper(InputStream in, Callback<byte[]> callback) {
      this(in, callback, null);
    }

    public InputStreamPumper(InputStream in, Callback<byte[]> callback, Runnable onClose) {
        this.in = in;
        this.callback = callback;
        this.onClose = onClose;
    }

    @Override
    public void run() {
        synchronized (this) {
          thread = Thread.currentThread();
        }
        byte[] buffer = new byte[1024];
        try {
          int length;
          while (keepReading && !Thread.currentThread().isInterrupted() && (length = in.read(buffer)) != -1) {
                byte[] actual = new byte[length];
                System.arraycopy(buffer, 0, actual, 0, length);
                callback.call(actual);
              }
        } catch (IOException e) {
          if (!keepReading) {
            return;
          }
          if (!thread.isInterrupted()) {
            LOGGER.error("Error while pumping stream.", e);
          } else {
            LOGGER.debug("Interrupted while pumping stream.");
          }
        } finally {
          close();
        }
    }

    public synchronized void close() {
        keepReading = false;
        if (thread != null && !thread.isInterrupted()) {
            thread.interrupt();
        }

        if (closed.compareAndSet(false, true) && onClose != null) {
          onClose.run();
        }
    }
}
