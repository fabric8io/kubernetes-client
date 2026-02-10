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

import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import lombok.RequiredArgsConstructor;

import java.io.InputStream;

@RequiredArgsConstructor
class AsyncInputReader {

  private static final int CHUNK_SIZE = 2048;

  private final Vertx vertx;
  private final InputStream inputStream;
  private byte[] readBuffer;

  Future<Buffer> readNextChunk() {
    return vertx.executeBlocking(() -> {
      if (readBuffer == null) {
        readBuffer = new byte[CHUNK_SIZE];
      }
      final int bytesRead = inputStream.read(readBuffer);
      if (bytesRead == -1) {
        return null; // EOF
      }
      return Buffer.buffer().appendBytes(readBuffer, 0, bytesRead);
    });
  }
}
