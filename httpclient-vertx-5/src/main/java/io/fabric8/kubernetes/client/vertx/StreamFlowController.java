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

import io.vertx.core.Context;
import io.vertx.core.Handler;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.streams.impl.InboundBuffer;

class StreamFlowController {

  private final Buffer endSentinel;
  private InboundBuffer<Buffer> inboundBuffer;
  private Handler<Void> endHandler;

  StreamFlowController() {
    this.endSentinel = Buffer.buffer();
  }

  void initialize(final Context context, final Runnable drainHandler) {
    inboundBuffer = new InboundBuffer<>(context);
    inboundBuffer.drainHandler(v -> drainHandler.run());
  }

  boolean isInitialized() {
    return inboundBuffer != null;
  }

  void configureDataHandler(final Handler<Buffer> dataHandler) {
    if (dataHandler != null) {
      inboundBuffer.handler(buffer -> {
        if (buffer == endSentinel) {
          if (endHandler != null) {
            endHandler.handle(null);
          }
        } else {
          dataHandler.handle(buffer);
        }
      });
    } else {
      inboundBuffer.handler(null);
    }
  }

  void setEndHandler(final Handler<Void> handler) {
    this.endHandler = handler;
  }

  boolean writeChunk(final Buffer chunk) {
    return inboundBuffer.write(chunk);
  }

  void writeEndSentinel() {
    inboundBuffer.write(endSentinel);
  }

  void pause() {
    if (inboundBuffer != null) {
      inboundBuffer.pause();
    }
  }

  void resume() {
    if (inboundBuffer != null) {
      inboundBuffer.resume();
    }
  }

  void fetch(final long amount) {
    if (inboundBuffer != null) {
      inboundBuffer.fetch(amount);
    }
  }
}
