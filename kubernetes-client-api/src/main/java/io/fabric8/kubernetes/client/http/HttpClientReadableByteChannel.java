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

import io.fabric8.kubernetes.client.http.HttpClient.AsyncBody;
import io.fabric8.kubernetes.client.http.HttpClient.BodyConsumer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ReadableByteChannel;
import java.util.LinkedList;
import java.util.List;

/**
 * Creates a blocking {@link ReadableByteChannel} from a {@link HttpResponse} containing an {@link AsyncBody}
 * <p>
 * May be useful eventually to provide a non-blocking channel as well.
 */
public class HttpClientReadableByteChannel implements ReadableByteChannel, BodyConsumer<List<ByteBuffer>> {

  private final LinkedList<ByteBuffer> buffers = new LinkedList<>();
  private Throwable failed;
  private boolean closed;
  private boolean done;
  private AsyncBody asyncBody;
  private ByteBuffer currentBuffer;
  private boolean consumeRequested;

  @Override
  public synchronized void consume(List<ByteBuffer> value, AsyncBody asyncBody) throws Exception {
    this.buffers.addAll(value);
    // could proactively consume based up some byte limit
    this.notifyAll();
    this.consumeRequested = false;
  }

  protected synchronized void onResponse(HttpResponse<AsyncBody> response) {
    asyncBody = response.body();
    asyncBody.done().whenComplete(this::onBodyDone);
    asyncBody.consume(); // pre-fetch the first results
    this.notifyAll();
  }

  private synchronized void onBodyDone(Void v, Throwable t) {
    if (t != null) {
      failed = t;
    }
    done = true;
    this.notifyAll();
  }

  @Override
  public synchronized void close() {
    if (this.closed) {
      return;
    }
    if (asyncBody != null) {
      asyncBody.cancel();
    }
    this.closed = true;
    this.notifyAll();
  }

  @Override
  public synchronized boolean isOpen() {
    return !closed;
  }

  @Override
  public synchronized int read(ByteBuffer arg0) throws IOException {
    if (closed) {
      throw new ClosedChannelException();
    }

    int read = 0;

    while (arg0.hasRemaining()) {
      while (currentBuffer == null || !currentBuffer.hasRemaining()) {
        if (buffers.isEmpty()) {
          if (failed != null) {
            throw new IOException("channel already closed with exception", failed);
          }
          if (read > 0) {
            return read;
          }
          if (done) {
            return -1;
          }
          if (!consumeRequested && this.asyncBody != null) {
            consumeRequested = true;
            this.asyncBody.consume();
            // the consume call may actually trigger result deliver
            // if it did, then just start the loop over
            if (!consumeRequested) {
              continue;
            }
          }
          try {
            this.wait(); // block until more buffers are delivered
          } catch (InterruptedException e) {
            close();
            Thread.currentThread().interrupt();
            throw new ClosedByInterruptException();
          }
        }

        currentBuffer = buffers.poll();
      }

      int remaining = Math.min(arg0.remaining(), currentBuffer.remaining());
      for (int i = 0; i < remaining; i++) {
        arg0.put(currentBuffer.get());
      }
      read += remaining;
    }

    return read;
  }

}
