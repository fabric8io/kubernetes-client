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
package io.fabric8.kubernetes.client.vertx;

import io.vertx.core.Handler;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpClientRequest;
import io.vertx.core.streams.ReadStream;

import java.io.InputStream;

class InputStreamReadStream implements ReadStream<Buffer> {

  private final VertxHttpRequest vertxHttpRequest;
  private final HttpClientRequest request;
  private final AsyncInputReader reader;
  private final StackBasedRecursionGuard recursionGuard;
  private final StreamFlowController flowController;

  private Handler<Throwable> exceptionHandler;

  InputStreamReadStream(VertxHttpRequest vertxHttpRequest, InputStream inputStream, HttpClientRequest request) {
    this.vertxHttpRequest = vertxHttpRequest;
    this.request = request;
    this.reader = new AsyncInputReader(vertxHttpRequest.vertx, inputStream);
    this.recursionGuard = new StackBasedRecursionGuard();
    this.flowController = new StreamFlowController();
  }

  @Override
  public ReadStream<Buffer> exceptionHandler(final Handler<Throwable> handler) {
    exceptionHandler = handler;
    return this;
  }

  @Override
  public ReadStream<Buffer> handler(final Handler<Buffer> handler) {
    final boolean shouldStart = !flowController.isInitialized() && handler != null;

    if (shouldStart) {
      flowController.initialize(vertxHttpRequest.vertx.getOrCreateContext(), this::readChunk);
    }

    flowController.configureDataHandler(handler);

    if (shouldStart) {
      readChunk();
    }

    return this;
  }

  private void readChunk() {
    if (recursionGuard.enter()) {
      try {
        executeBlockingRead();
      } finally {
        recursionGuard.exit();
      }
    } else {
      vertxHttpRequest.vertx.runOnContext(v -> readChunk());
    }
  }

  private void executeBlockingRead() {
    reader.readNextChunk().onComplete(this::handleReadResult);
  }

  private void handleReadResult(final io.vertx.core.AsyncResult<Buffer> result) {
    if (result.succeeded()) {
      final Buffer chunk = result.result();
      if (chunk != null) {
        final boolean canContinueWriting = flowController.writeChunk(chunk);
        if (canContinueWriting) {
          readChunk();
        }
        // If buffer is full, readChunk will be called by drain handler
      } else {
        flowController.writeEndSentinel();
        // No cleanup needed with stack-based approach
      }
    } else {
      handleReadError(result.cause());
    }
  }

  private void handleReadError(final Throwable cause) {
    request.reset(0, cause);
    if (exceptionHandler != null) {
      exceptionHandler.handle(cause);
    }
  }

  @Override
  public ReadStream<Buffer> endHandler(Handler<Void> handler) {
    flowController.setEndHandler(handler);
    return this;
  }

  @Override
  public ReadStream<Buffer> pause() {
    flowController.pause();
    return this;
  }

  @Override
  public ReadStream<Buffer> resume() {
    flowController.resume();
    return this;
  }

  @Override
  public ReadStream<Buffer> fetch(long amount) {
    flowController.fetch(amount);
    return this;
  }
}
