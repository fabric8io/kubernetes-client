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

public class InputStreamPumper implements Runnable, Closeable {

    private static final Logger LOGGER = LoggerFactory.getLogger(InputStreamReader.class);

    private final InputStream in;
    private final Callback<byte[]> callback;
    private final Runnable onClose;
    private final AtomicBoolean closed = new AtomicBoolean(false);

    private volatile boolean keepReading = true;
    private Thread thread;

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
            while (keepReading && !Thread.currentThread().isInterrupted()) {
              while (in.available() > 0 && keepReading && !Thread.currentThread().isInterrupted()) {
                int length = in.read(buffer);
                if (length < 0) {
                  throw new IOException("EOF has been reached!");
                }
                byte[] actual = new byte[length];
                System.arraycopy(buffer, 0, actual, 0, length);
                callback.call(actual);
              }
              Thread.sleep(50); // Pause to avoid tight loop if external proc is too slow
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
        } catch (InterruptedException e) {
          Thread.interrupted();
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
