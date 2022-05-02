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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class InputStreamPumper {

  private static final int DEFAULT_BUFFER_SIZE = 8192;

  private InputStreamPumper() {
  }

  private static final Logger LOGGER = LoggerFactory.getLogger(InputStreamPumper.class);

  public interface Writable {

    void write(byte[] b, int off, int len) throws IOException;

  }

  /**
   * Relies on {@link InputStream#available()} and a Thread sleep to ensure that the reads are interruptible.
   */
  public static InputStream asInterruptible(InputStream is) {
    return new InputStream() {

      @Override
      public int read() {
        throw new UnsupportedOperationException();
      }

      @Override
      public int read(byte[] b, int off, int len) throws IOException {
        while (!Thread.currentThread().isInterrupted()) {
          if (is.available() > 0) {
            return is.read(b, off, len);
          }
          try {
            // The default sleep interval of 50 milliseconds came from the previous
            // incarnation of this code.  If this needs tweaked, it can be changed to a parameter.
            Thread.sleep(50);
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IOException(e);
          }
        }
        throw new IOException();
      }
    };
  }

  /**
   * See InputStream.transferTo(java.io.OutputStream) in Java 9 or later
   */
  public static void transferTo(InputStream in, Writable out) throws IOException {
    byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
    int length;
    while ((length = in.read(buffer, 0, buffer.length)) != -1) {
      out.write(buffer, 0, length);
    }
  }

  /**
   * Pumps the given {@link InputStream} into the {@link Writable} target via a task started in the given {@link Executor}.
   * <br>
   * The input is not closed by this call.
   * <br>
   * If the {@link InputStream} is not interruptible, such as System.in, use {@link #asInterruptible(InputStream)} to decorate
   * the stream for this call.
   */
  public static CompletableFuture<?> pump(InputStream in, Writable out, Executor executor) {
    return CompletableFuture.runAsync(() -> {
      try {
        InputStreamPumper.transferTo(in, out);
      } catch (InterruptedIOException e) {
        LOGGER.debug("Interrupted while pumping stream.", e);
      } catch (Exception e) {
        if (!Thread.currentThread().isInterrupted()) {
          LOGGER.error("Error while pumping stream.", e);
        } else {
          LOGGER.debug("Interrupted while pumping stream.");
        }
      }
    }, executor);
  }

  static class WritableOutputStream extends OutputStream {

    Writable writer;

    WritableOutputStream(Writable writer) {
      this.writer = writer;
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
      writer.write(b, off, len);
    }

    @Override
    public void write(int b) throws IOException {
      throw new UnsupportedOperationException();
    }

  }

  public static OutputStream writableOutputStream(Writable writer, Integer bufferSize) {
    return new BufferedOutputStream(new WritableOutputStream(writer), Utils.getNonNullOrElse(bufferSize, DEFAULT_BUFFER_SIZE));
  }

}
