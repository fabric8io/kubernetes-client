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

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ReadableByteChannel;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Supplier;

/**
 * Creates a blocking {@link ReadableByteChannel} from a {@link HttpResponse} containing an {@link AsyncBody}
 * <p>
 * May be useful eventually to provide a non-blocking channel as well.
 */
public class HttpClientReadableByteChannel implements ReadableByteChannel, AsyncBody.Consumer<List<ByteBuffer>> {

  private final LinkedList<ByteBuffer> buffers = new LinkedList<>();
  private Throwable failed;
  private boolean closed;
  private boolean done;
  private CompletableFuture<AsyncBody> asyncBodyFuture = new CompletableFuture<>();
  private ByteBuffer currentBuffer;
  private ReentrantLock lock = new ReentrantLock();
  private Condition condition = lock.newCondition();

  @Override
  public void consume(List<ByteBuffer> value, AsyncBody asyncBody) throws Exception {
    doLockedAndSignal(() -> this.buffers.addAll(value));
  }

  protected void onResponse(HttpResponse<AsyncBody> response) {
    AsyncBody asyncBody = response.body();
    asyncBodyFuture.complete(asyncBody);
    asyncBody.done().whenComplete(this::onBodyDone);
    asyncBody.consume(); // pre-fetch the first results
    doLockedAndSignal(() -> null);
  }

  private void onBodyDone(Void v, Throwable t) {
    doLockedAndSignal(() -> {
      if (t != null) {
        failed = t;
      }
      done = true;
      return null;
    });
  }

  <T> T doLockedAndSignal(Supplier<T> run) {
    lock.lock();
    try {
      condition.signalAll();
      return run.get();
    } finally {
      lock.unlock();
    }
  }

  @Override
  public void close() {
    if (doLockedAndSignal(() -> {
      if (this.closed) {
        return false;
      }
      this.closed = true;
      return true;
    })) {
      asyncBodyFuture.thenAccept(AsyncBody::cancel);
    }
  }

  @Override
  public synchronized boolean isOpen() {
    return !closed;
  }

  @Override
  public int read(ByteBuffer arg0) throws IOException {
    lock.lock();
    try {
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
            lock.unlock();
            try {
              // relinquish the lock to consume more
              this.asyncBodyFuture.thenAccept(AsyncBody::consume);
            } finally {
              lock.lock();
            }
            try {
              while (!done && buffers.isEmpty()) {
                condition.await(); // block until more buffers are delivered
              }
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
    } finally {
      if (lock.isHeldByCurrentThread()) {
        lock.unlock();
      }
    }
  }

}
