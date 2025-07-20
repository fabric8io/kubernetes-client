/*
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
package io.fabric8.kubernetes.client.vertx5.adapters;

import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpClientRequest;
import io.vertx.core.streams.ReadStream;
import io.vertx.core.streams.impl.InboundBuffer;
import lombok.NonNull;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicInteger;

final class Vertx5InputStreamReadStream implements ReadStream<Buffer> {

  private static final int CHUNK_SIZE = 2048;
  private static final int MAX_DEPTH = 8;

  private final Buffer endSentinel;
  @NonNull
  private final Vertx5HttpRequest vertx5HttpRequest;
  @NonNull
  private final InputStream is;
  @NonNull
  private final HttpClientRequest request;
  private InboundBuffer<Buffer> inboundBuffer;
  private Handler<Throwable> exceptionHandler;
  private Handler<Void> endHandler;
  private byte[] bytes;

  Vertx5InputStreamReadStream(@NonNull final Vertx5HttpRequest vertx5HttpRequest,
      @NonNull final InputStream is,
      @NonNull final HttpClientRequest request) {
    this.vertx5HttpRequest = vertx5HttpRequest;
    this.is = is;
    this.request = request;
    this.endSentinel = Buffer.buffer();
  }

  @Override
  public ReadStream<Buffer> exceptionHandler(final Handler<Throwable> handler) {
    this.exceptionHandler = handler;
    return this;
  }

  private final ThreadLocal<AtomicInteger> counter = new ThreadLocal<AtomicInteger>() {
    @Override
    protected AtomicInteger initialValue() {
      return new AtomicInteger();
    }
  };

  @Override
  public ReadStream<Buffer> handler(final Handler<Buffer> handler) {
    final boolean start = inboundBuffer == null && handler != null;

    if (start) {
      inboundBuffer = new InboundBuffer<>(vertx5HttpRequest.getVertx().getOrCreateContext());
      inboundBuffer.drainHandler(v -> readChunk());
    }

    if (handler != null) {
      inboundBuffer.handler(buff -> {
        if (buff == endSentinel) {
          if (endHandler != null) {
            endHandler.handle(null);
          }
        } else {
          handler.handle(buff);
        }
      });
    } else {
      inboundBuffer.handler(null);
    }

    if (start) {
      readChunk();
    }

    return this;
  }

  private void readChunk() {
    final AtomicInteger atomicInteger = counter.get();
    try {
      final int depth = atomicInteger.getAndIncrement();
      if (depth < MAX_DEPTH) {
        readChunk2();
        return;
      }
    } finally {
      atomicInteger.decrementAndGet();
    }
    vertx5HttpRequest.getVertx().runOnContext(v -> readChunk());
  }

  private void readChunk2() {
    final Future<Buffer> fut = vertx5HttpRequest.getVertx().executeBlocking(() -> {
      if (bytes == null) {
        bytes = new byte[CHUNK_SIZE];
      }

      final int amount;
      try {
        amount = is.read(bytes);
      } catch (final IOException e) {
        throw new RuntimeException(e);
      }

      if (amount == -1) {
        return null; // End of stream
      } else {
        return Buffer.buffer().appendBytes(bytes, 0, amount);
      }
    });

    fut.onComplete(ar -> {
      if (ar.succeeded()) {
        final Buffer chunk = ar.result();
        if (chunk != null) {
          final boolean writable = inboundBuffer.write(chunk);
          if (writable) {
            readChunk();
          }
          // If not writable, we wait for drain handler to be called
        } else {
          inboundBuffer.write(endSentinel);
        }
      } else {
        if (exceptionHandler != null) {
          exceptionHandler.handle(ar.cause());
        }
        request.reset(0, ar.cause());
      }
    });
  }

  @Override
  public ReadStream<Buffer> endHandler(final Handler<Void> handler) {
    this.endHandler = handler;
    return this;
  }

  @Override
  public ReadStream<Buffer> pause() {
    if (inboundBuffer != null) {
      inboundBuffer.pause();
    }
    return this;
  }

  @Override
  public ReadStream<Buffer> resume() {
    if (inboundBuffer != null) {
      inboundBuffer.resume();
    }
    return this;
  }

  @Override
  public ReadStream<Buffer> fetch(final long amount) {
    if (inboundBuffer != null) {
      inboundBuffer.fetch(amount);
    }
    return this;
  }
}