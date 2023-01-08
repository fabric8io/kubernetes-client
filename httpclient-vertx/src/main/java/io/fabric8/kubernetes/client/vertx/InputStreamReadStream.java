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

package io.fabric8.kubernetes.client.vertx;

import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.buffer.impl.VertxByteBufAllocator;
import io.vertx.core.http.HttpClientRequest;
import io.vertx.core.streams.ReadStream;
import io.vertx.core.streams.impl.InboundBuffer;

import java.io.IOException;
import java.io.InputStream;

class InputStreamReadStream implements ReadStream<Buffer> {

  private static final int CHUNK_SIZE = 2048;

  private final VertxHttpRequest vertxHttpRequest;
  private final InputStream is;
  private final HttpClientRequest request;
  private InboundBuffer<Buffer> inboundBuffer;
  private Handler<Throwable> exceptionHandler;
  private Handler<Void> endHandler;
  private byte[] bytes;

  public InputStreamReadStream(VertxHttpRequest vertxHttpRequest, InputStream is, HttpClientRequest request) {
    this.vertxHttpRequest = vertxHttpRequest;
    this.is = is;
    this.request = request;
  }

  @Override
  public ReadStream<Buffer> exceptionHandler(Handler<Throwable> handler) {
    exceptionHandler = handler;
    return this;
  }

  @Override
  public ReadStream<Buffer> handler(Handler<Buffer> handler) {
    boolean start = inboundBuffer == null && handler != null;
    if (start) {
      inboundBuffer = new InboundBuffer<>(vertxHttpRequest.vertx.getOrCreateContext());
      inboundBuffer.drainHandler(v -> {
        readChunk();
      });
    }
    if (handler != null) {
      inboundBuffer.handler(buff -> {
        if (buff == null) {
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
    Future<Buffer> fut = vertxHttpRequest.vertx.executeBlocking(p -> {
      if (bytes == null) {
        bytes = new byte[CHUNK_SIZE];
      }
      int amount;
      try {
        amount = is.read(bytes);
      } catch (IOException e) {
        p.fail(e);
        return;
      }
      if (amount == -1) {
        p.complete();
      } else {
        p.complete(
            Buffer.buffer(VertxByteBufAllocator.DEFAULT.heapBuffer(amount, Integer.MAX_VALUE).writeBytes(bytes, 0, amount)));
      }
    });
    fut.onComplete(ar -> {
      if (ar.succeeded()) {
        Buffer chunk = ar.result();
        if (chunk != null) {
          boolean writable = inboundBuffer.write(chunk);
          if (writable) {
            readChunk();
          } else {
            // Full
          }
        } else {
          inboundBuffer.write((Buffer) null);
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
  public ReadStream<Buffer> endHandler(Handler<Void> handler) {
    endHandler = handler;
    return this;
  }

  @Override
  public ReadStream<Buffer> pause() {
    inboundBuffer.pause();
    return this;
  }

  @Override
  public ReadStream<Buffer> resume() {
    inboundBuffer.resume();
    return this;
  }

  @Override
  public ReadStream<Buffer> fetch(long amount) {
    inboundBuffer.fetch(amount);
    return this;
  }
}
