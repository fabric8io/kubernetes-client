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

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;

/**
 * Provides an InputStream that is non-blocking to the producer
 * and that will request more input when needed.
 */
public class ExecWatchInputStream extends InputStream {

  private static final int BUFFER_SIZE = 1 << 15;

  private final LinkedList<ByteBuffer> buffers = new LinkedList<>();
  private boolean complete;
  private boolean closed;
  private Throwable failed;
  private ByteBuffer currentBuffer;

  private final Runnable request;
  private final int bufferSize;

  public ExecWatchInputStream(Runnable request) {
    this(request, BUFFER_SIZE);
  }

  public ExecWatchInputStream(Runnable request, int bufferSize) {
    this.request = request;
    this.bufferSize = bufferSize;
  }

  void onExit(Integer exitCode, Throwable t) {
    synchronized (buffers) {
      if (complete) {
        return;
      }
      complete = true;
      if (t != null) {
        failed = t;
      } else if (exitCode != null && exitCode != 0) {
        failed = new KubernetesClientException("process exited with a non-zero exit code: " + exitCode);
      }
      buffers.notifyAll();
    }
  }

  void consume(List<ByteBuffer> value) {
    synchronized (buffers) {
      if (closed) {
        // even if closed there may be other streams
        // so keep pulling
        request.run();
        return;
      }
      assert !complete || failed == null;
      buffers.addAll(value);
      buffers.notifyAll();
      if ((currentBuffer != null ? currentBuffer.remaining() : 0)
          + buffers.stream().mapToInt(ByteBuffer::remaining).sum() < bufferSize) {
        request.run();
      }
    }
  }

  private ByteBuffer current() throws IOException {
    synchronized (buffers) {
      while (currentBuffer == null || !currentBuffer.hasRemaining()) {
        // Check whether the stream is closed or exhausted
        if (closed) {
          throw new IOException("closed", failed);
        }
        if (buffers.isEmpty()) {
          if (complete) {
            if (failed != null) {
              throw new IOException("closed", failed);
            }
            return null;
          }
          requestMoreIfNeeded();
        }

        currentBuffer = buffers.poll();

        if (currentBuffer == null && !complete) {
          try {
            buffers.wait();
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
          }
        }
      }
      return currentBuffer;
    }
  }

  /**
   * Adapted from HttpResponseInputStream
   */
  @Override
  public int read(byte[] bytes, int off, int len) throws IOException {
    // get the buffer to read from, possibly blocking if
    // none is available
    ByteBuffer buffer = current();
    if (buffer == null) {
      return -1;
    }

    // don't attempt to read more than what is available
    // in the current buffer.
    int read = Math.min(buffer.remaining(), len);
    assert read > 0 && read <= buffer.remaining();

    // buffer.get() will do the boundary check for us.
    buffer.get(bytes, off, read);
    return read;
  }

  @Override
  public int read() throws IOException {
    byte[] single = new byte[1];
    if (read(single) == -1) {
      return -1;
    }
    return single[0] & 0xFF;
  }

  @Override
  public void close() throws IOException {
    synchronized (buffers) {
      if (this.closed) {
        return;
      }
      this.closed = true;
      requestMoreIfNeeded();
      this.buffers.clear();
      buffers.notifyAll();
    }
  }

  private void requestMoreIfNeeded() {
    if (currentBuffer != null) {
      this.currentBuffer = null;
      this.request.run();
    }
  }

}