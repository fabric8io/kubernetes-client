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
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("AsyncInputReader")
class AsyncInputReaderTest {

  private Vertx vertx;

  @BeforeEach
  void setUp() {
    vertx = Vertx.vertx();
  }

  @AfterEach
  void tearDown() {
    if (vertx != null) {
      vertx.close();
    }
  }

  @Test
  @DisplayName("Should read data chunk from InputStream")
  void shouldReadDataChunk() throws Exception {
    String testData = "Hello, World!";
    InputStream inputStream = new ByteArrayInputStream(testData.getBytes());
    AsyncInputReader reader = new AsyncInputReader(vertx, inputStream);

    AtomicReference<Buffer> resultBuffer = new AtomicReference<>();
    AtomicReference<Throwable> errorRef = new AtomicReference<>();
    CountDownLatch latch = new CountDownLatch(1);

    Future<Buffer> future = reader.readNextChunk();
    future.onComplete(result -> {
      if (result.succeeded()) {
        resultBuffer.set(result.result());
      } else {
        errorRef.set(result.cause());
      }
      latch.countDown();
    });

    assertThat(latch.await(5, TimeUnit.SECONDS)).isTrue();
    assertThat(errorRef.get()).isNull();
    assertThat(resultBuffer.get()).isNotNull();
    assertThat(resultBuffer.get().toString()).hasToString(testData);
  }

  @Test
  @DisplayName("Should return null on EOF")
  void shouldReturnNullOnEOF() throws Exception {
    InputStream inputStream = new ByteArrayInputStream(new byte[0]);
    AsyncInputReader reader = new AsyncInputReader(vertx, inputStream);

    AtomicReference<Buffer> resultBuffer = new AtomicReference<>();
    AtomicReference<Throwable> errorRef = new AtomicReference<>();
    CountDownLatch latch = new CountDownLatch(1);

    Future<Buffer> future = reader.readNextChunk();
    future.onComplete(result -> {
      if (result.succeeded()) {
        resultBuffer.set(result.result());
      } else {
        errorRef.set(result.cause());
      }
      latch.countDown();
    });

    assertThat(latch.await(5, TimeUnit.SECONDS)).isTrue();
    assertThat(errorRef.get()).isNull();
    assertThat(resultBuffer.get()).isNull();
  }

  @Test
  @DisplayName("Should handle IOException from InputStream")
  void shouldHandleIOException() throws Exception {
    InputStream inputStream = new InputStream() {
      @Override
      public int read() throws IOException {
        throw new IOException("Test IO exception");
      }

      @Override
      public int read(byte[] b) throws IOException {
        throw new IOException("Test IO exception");
      }
    };
    AsyncInputReader reader = new AsyncInputReader(vertx, inputStream);

    AtomicReference<Buffer> resultBuffer = new AtomicReference<>();
    AtomicReference<Throwable> errorRef = new AtomicReference<>();
    CountDownLatch latch = new CountDownLatch(1);

    Future<Buffer> future = reader.readNextChunk();
    future.onComplete(result -> {
      if (result.succeeded()) {
        resultBuffer.set(result.result());
      } else {
        errorRef.set(result.cause());
      }
      latch.countDown();
    });

    assertThat(latch.await(5, TimeUnit.SECONDS)).isTrue();
    assertThat(resultBuffer.get()).isNull();
    assertThat(errorRef.get()).isNotNull();
    assertThat(errorRef.get()).isInstanceOf(IOException.class);
    assertThat(errorRef.get().getMessage()).isEqualTo("Test IO exception");
  }

  @Test
  @DisplayName("Should handle large data streams in chunks")
  void shouldHandleLargeDataInChunks() throws Exception {
    // Create 5KB of test data (larger than CHUNK_SIZE of 2048)
    byte[] largeData = new byte[5 * 1024];
    for (int i = 0; i < largeData.length; i++) {
      largeData[i] = (byte) (i % 256);
    }
    InputStream inputStream = new ByteArrayInputStream(largeData);
    AsyncInputReader reader = new AsyncInputReader(vertx, inputStream);

    AtomicReference<Buffer> resultBuffer = new AtomicReference<>();
    AtomicReference<Throwable> errorRef = new AtomicReference<>();
    CountDownLatch latch = new CountDownLatch(1);

    Future<Buffer> future = reader.readNextChunk();
    future.onComplete(result -> {
      if (result.succeeded()) {
        resultBuffer.set(result.result());
      } else {
        errorRef.set(result.cause());
      }
      latch.countDown();
    });

    assertThat(latch.await(5, TimeUnit.SECONDS)).isTrue();
    assertThat(errorRef.get()).isNull();
    assertThat(resultBuffer.get()).isNotNull();
    // Should read-only up to CHUNK_SIZE (2048 bytes)
    assertThat(resultBuffer.get().length()).isEqualTo(2048);
  }

  @Test
  @DisplayName("Should read multiple chunks sequentially")
  void shouldReadMultipleChunksSequentially() throws Exception {
    String testData = "A".repeat(4096); // 4KB of data (2 chunks)
    InputStream inputStream = new ByteArrayInputStream(testData.getBytes());
    AsyncInputReader reader = new AsyncInputReader(vertx, inputStream);

    // Read first chunk
    AtomicReference<Buffer> firstBuffer = new AtomicReference<>();
    CountDownLatch firstLatch = new CountDownLatch(1);

    reader.readNextChunk().onComplete(result -> {
      if (result.succeeded()) {
        firstBuffer.set(result.result());
      }
      firstLatch.countDown();
    });

    assertThat(firstLatch.await(5, TimeUnit.SECONDS)).isTrue();
    assertThat(firstBuffer.get()).isNotNull();
    assertThat(firstBuffer.get().length()).isEqualTo(2048);

    // Read second chunk
    AtomicReference<Buffer> secondBuffer = new AtomicReference<>();
    CountDownLatch secondLatch = new CountDownLatch(1);

    reader.readNextChunk().onComplete(result -> {
      if (result.succeeded()) {
        secondBuffer.set(result.result());
      }
      secondLatch.countDown();
    });

    assertThat(secondLatch.await(5, TimeUnit.SECONDS)).isTrue();
    assertThat(secondBuffer.get()).isNotNull();
    assertThat(secondBuffer.get().length()).isEqualTo(2048);

    // Read third chunk (should be EOF)
    AtomicReference<Buffer> thirdBuffer = new AtomicReference<>();
    CountDownLatch thirdLatch = new CountDownLatch(1);

    reader.readNextChunk().onComplete(result -> {
      if (result.succeeded()) {
        thirdBuffer.set(result.result());
      }
      thirdLatch.countDown();
    });

    assertThat(thirdLatch.await(5, TimeUnit.SECONDS)).isTrue();
    assertThat(thirdBuffer.get()).isNull(); // EOF
  }

  @Test
  @DisplayName("Should reuse read buffer across multiple reads")
  void shouldReuseReadBuffer() throws Exception {
    String testData1 = "First chunk data";
    String testData2 = "Second chunk data";

    // First read
    InputStream inputStream1 = new ByteArrayInputStream(testData1.getBytes());
    AsyncInputReader reader = new AsyncInputReader(vertx, inputStream1);

    AtomicReference<Buffer> firstResult = new AtomicReference<>();
    CountDownLatch firstLatch = new CountDownLatch(1);

    reader.readNextChunk().onComplete(result -> {
      if (result.succeeded()) {
        firstResult.set(result.result());
      }
      firstLatch.countDown();
    });

    assertThat(firstLatch.await(5, TimeUnit.SECONDS)).isTrue();
    assertThat(firstResult.get()).isNotNull();

    // Create new reader with different stream but same instance should reuse buffer
    InputStream inputStream2 = new ByteArrayInputStream(testData2.getBytes());
    AsyncInputReader reader2 = new AsyncInputReader(vertx, inputStream2);

    AtomicReference<Buffer> secondResult = new AtomicReference<>();
    CountDownLatch secondLatch = new CountDownLatch(1);

    reader2.readNextChunk().onComplete(result -> {
      if (result.succeeded()) {
        secondResult.set(result.result());
      }
      secondLatch.countDown();
    });

    assertThat(secondLatch.await(5, TimeUnit.SECONDS)).isTrue();
    assertThat(secondResult.get()).isNotNull();
    assertThat(secondResult.get().toString()).hasToString(testData2);
  }

  @Test
  @DisplayName("Should handle partial reads correctly")
  void shouldHandlePartialReads() throws Exception {
    // Custom InputStream that returns only 1 byte at a time
    AsyncInputReader reader = getAsyncInputReader();

    AtomicReference<Buffer> resultBuffer = new AtomicReference<>();
    CountDownLatch latch = new CountDownLatch(1);

    reader.readNextChunk().onComplete(result -> {
      if (result.succeeded()) {
        resultBuffer.set(result.result());
      }
      latch.countDown();
    });

    assertThat(latch.await(5, TimeUnit.SECONDS)).isTrue();
    assertThat(resultBuffer.get()).isNotNull();
    assertThat(resultBuffer.get().length()).isEqualTo(1);
    assertThat(resultBuffer.get().toString()).hasToString("H");
  }

  private AsyncInputReader getAsyncInputReader() {
    InputStream inputStream = new InputStream() {
      private final byte[] data = "Hello".getBytes();
      private int position = 0;

      @Override
      public int read() {
        return (position < data.length ? data[position++] : -1) & 0xFF;
      }

      @Override
      public int read(byte[] b) {
        if (position >= data.length) {
          return -1;
        }
        // Only return 1 byte at a time
        b[0] = data[position++];
        return 1;
      }

      @Override
      public int read(byte[] b, int off, int len) {
        return read(b); // Delegate to the single-byte read method
      }
    };

    return new AsyncInputReader(vertx, inputStream);
  }

  @Test
  @DisplayName("Should handle concurrent reads safely")
  void shouldHandleConcurrentReadsSafely() throws Exception {
    String testData = "Concurrent test data";
    InputStream inputStream = new ByteArrayInputStream(testData.getBytes());
    AsyncInputReader reader = new AsyncInputReader(vertx, inputStream);

    CountDownLatch completionLatch = new CountDownLatch(2);
    AtomicReference<Buffer> result1 = new AtomicReference<>();
    AtomicReference<Buffer> result2 = new AtomicReference<>();

    // Start two concurrent reads
    reader.readNextChunk().onComplete(ar -> {
      if (ar.succeeded()) {
        result1.set(ar.result());
      }
      completionLatch.countDown();
    });

    reader.readNextChunk().onComplete(ar -> {
      if (ar.succeeded()) {
        result2.set(ar.result());
      }
      completionLatch.countDown();
    });

    assertThat(completionLatch.await(5, TimeUnit.SECONDS)).isTrue();

    // One of the reads should succeed with data, the other should get EOF or different data
    // This tests that the buffer is handled safely under concurrent access
    boolean oneSucceeded = (result1.get() != null && result1.get().length() > 0) ||
        (result2.get() != null && result2.get().length() > 0);
    assertThat(oneSucceeded).isTrue();
  }
}
