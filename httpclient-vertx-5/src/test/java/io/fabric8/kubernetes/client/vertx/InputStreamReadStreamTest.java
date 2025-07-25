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

import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpClientRequest;
import io.vertx.core.streams.ReadStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@DisplayName("InputStreamReadStream")
class InputStreamReadStreamTest {

  private Vertx vertx;
  private VertxHttpRequest vertxHttpRequest;

  @Mock
  private HttpClientRequest httpRequest;

  @Captor
  private ArgumentCaptor<Long> resetCodeCaptor;

  @Captor
  private ArgumentCaptor<Throwable> resetCauseCaptor;

  private AutoCloseable mocks;

  @BeforeEach
  void setUp() {
    mocks = MockitoAnnotations.openMocks(this);
    vertx = Vertx.vertx();
    vertxHttpRequest = new VertxHttpRequest(vertx, null, null);
  }

  @AfterEach
  void tearDown() throws Exception {
    if (mocks != null) {
      mocks.close();
    }
    if (vertx != null) {
      vertx.close();
    }
  }

  @Test
  @DisplayName("Should read data chunks from InputStream and emit them as buffers")
  void shouldReadDataChunksAndEmitBuffers() throws Exception {
    String testData = "Hello, World! This is test data for the InputStreamReadStream.";
    InputStream inputStream = new ByteArrayInputStream(testData.getBytes());
    InputStreamReadStream readStream = new InputStreamReadStream(vertxHttpRequest, inputStream, httpRequest);

    List<Buffer> receivedBuffers = new ArrayList<>();
    AtomicBoolean endCalled = new AtomicBoolean(false);
    CountDownLatch latch = new CountDownLatch(1);

    readStream
        .handler(receivedBuffers::add)
        .endHandler(v -> {
          endCalled.set(true);
          latch.countDown();
        });

    assertThat(latch.await(5, TimeUnit.SECONDS)).isTrue();
    assertThat(endCalled.get()).isTrue();
    assertThat(receivedBuffers).isNotEmpty();

    // Verify that all data was read correctly
    StringBuilder result = new StringBuilder();
    for (Buffer buffer : receivedBuffers) {
      result.append(buffer.toString());
    }
    assertThat(result.toString()).hasToString(testData);
  }

  @Test
  @DisplayName("Should handle empty InputStream")
  void shouldHandleEmptyInputStream() throws Exception {
    InputStream inputStream = new ByteArrayInputStream(new byte[0]);
    InputStreamReadStream readStream = new InputStreamReadStream(vertxHttpRequest, inputStream, httpRequest);

    List<Buffer> receivedBuffers = new ArrayList<>();
    AtomicBoolean endCalled = new AtomicBoolean(false);
    CountDownLatch latch = new CountDownLatch(1);

    readStream
        .handler(receivedBuffers::add)
        .endHandler(v -> {
          endCalled.set(true);
          latch.countDown();
        });

    assertThat(latch.await(5, TimeUnit.SECONDS)).isTrue();
    assertThat(endCalled.get()).isTrue();
    assertThat(receivedBuffers).isEmpty();
  }

  @Test
  @DisplayName("Should handle IOException from InputStream")
  void shouldHandleIOException() throws Exception {
    InputStream inputStream = new InputStream() {
      @Override
      public int read() throws IOException {
        throw new IOException("Test IO exception");
      }
    };
    InputStreamReadStream readStream = new InputStreamReadStream(vertxHttpRequest, inputStream, httpRequest);

    AtomicReference<Throwable> exceptionRef = new AtomicReference<>();
    CountDownLatch latch = new CountDownLatch(1);

    readStream
        .exceptionHandler(ex -> {
          exceptionRef.set(ex);
          latch.countDown();
        })
        .handler(buffer -> {
          // Should not be called
        });

    assertThat(latch.await(5, TimeUnit.SECONDS)).isTrue();
    assertThat(exceptionRef.get()).isNotNull();

    await().atMost(1, TimeUnit.SECONDS)
        .untilAsserted(() -> verify(httpRequest, times(1)).reset(anyLong(), any(Throwable.class)));
  }

  @Test
  @DisplayName("Should support pause and resume operations")
  void shouldSupportPauseAndResume() throws Exception {
    String testData = "Test data for pause/resume functionality";
    InputStream inputStream = new ByteArrayInputStream(testData.getBytes());
    InputStreamReadStream readStream = new InputStreamReadStream(vertxHttpRequest, inputStream, httpRequest);

    List<Buffer> receivedBuffers = new ArrayList<>();
    AtomicBoolean endCalled = new AtomicBoolean(false);
    CountDownLatch latch = new CountDownLatch(1);

    readStream.handler(receivedBuffers::add);
    readStream.endHandler(v -> {
      endCalled.set(true);
      latch.countDown();
    });

    // Pause immediately (this should still work)
    readStream.pause();

    // Resume to continue reading
    readStream.resume();

    assertThat(latch.await(5, TimeUnit.SECONDS)).isTrue();
    assertThat(endCalled.get()).isTrue();
    assertThat(receivedBuffers).isNotEmpty();
  }

  @Test
  @DisplayName("Should support fetch operation")
  void shouldSupportFetch() throws Exception {
    String testData = "Test data for fetch functionality";
    InputStream inputStream = new ByteArrayInputStream(testData.getBytes());
    InputStreamReadStream readStream = new InputStreamReadStream(vertxHttpRequest, inputStream, httpRequest);

    List<Buffer> receivedBuffers = new ArrayList<>();
    AtomicBoolean endCalled = new AtomicBoolean(false);
    CountDownLatch latch = new CountDownLatch(1);

    readStream
        .handler(receivedBuffers::add)
        .endHandler(v -> {
          endCalled.set(true);
          latch.countDown();
        });

    readStream.fetch(10); // Fetch some amount

    assertThat(latch.await(5, TimeUnit.SECONDS)).isTrue();
    assertThat(endCalled.get()).isTrue();
    assertThat(receivedBuffers).isNotEmpty();
  }

  @Test
  @DisplayName("Should handle large data streams")
  void shouldHandleLargeDataStreams() throws Exception {
    // Create 10KB of test data
    byte[] largeData = new byte[10 * 1024];
    for (int i = 0; i < largeData.length; i++) {
      largeData[i] = (byte) (i % 256);
    }
    InputStream inputStream = new ByteArrayInputStream(largeData);
    InputStreamReadStream readStream = new InputStreamReadStream(vertxHttpRequest, inputStream, httpRequest);

    List<Buffer> receivedBuffers = new ArrayList<>();
    AtomicBoolean endCalled = new AtomicBoolean(false);
    CountDownLatch latch = new CountDownLatch(1);

    readStream
        .handler(receivedBuffers::add)
        .endHandler(v -> {
          endCalled.set(true);
          latch.countDown();
        });

    assertThat(latch.await(10, TimeUnit.SECONDS)).isTrue();
    assertThat(endCalled.get()).isTrue();
    assertThat(receivedBuffers).isNotEmpty();

    // Verify all data was read
    int totalBytes = receivedBuffers.stream().mapToInt(Buffer::length).sum();
    assertThat(totalBytes).isEqualTo(largeData.length);
  }

  @Test
  @DisplayName("Should allow setting null handler to stop reading")
  void shouldAllowNullHandler() {
    String testData = "Test data";
    InputStream inputStream = new ByteArrayInputStream(testData.getBytes());
    InputStreamReadStream readStream = new InputStreamReadStream(vertxHttpRequest, inputStream, httpRequest);

    // Set a handler first, then set to null
    readStream.handler(buffer -> {
      // Initial handler
    });

    ReadStream<Buffer> result = readStream.handler(null);

    assertThat(result).isSameAs(readStream);
    // No exception should be thrown
  }

  @Test
  @DisplayName("Should call exception handler when provided")
  void shouldCallExceptionHandlerWhenProvided() throws Exception {
    InputStream inputStream = new InputStream() {
      @Override
      public int read() throws IOException {
        throw new IOException("Simulated IO error");
      }
    };
    InputStreamReadStream readStream = new InputStreamReadStream(vertxHttpRequest, inputStream, httpRequest);

    AtomicReference<Throwable> caughtException = new AtomicReference<>();
    CountDownLatch latch = new CountDownLatch(1);

    readStream
        .exceptionHandler(ex -> {
          caughtException.set(ex);
          latch.countDown();
        })
        .handler(buffer -> {
          // Should not be called due to exception
        });

    assertThat(latch.await(5, TimeUnit.SECONDS)).isTrue();
    assertThat(caughtException.get()).isNotNull();
    assertThat(caughtException.get()).isInstanceOf(IOException.class);

    await().atMost(1, TimeUnit.SECONDS)
        .untilAsserted(() -> verify(httpRequest).reset(resetCodeCaptor.capture(), resetCauseCaptor.capture()));
    assertThat(resetCodeCaptor.getValue()).isZero();
    assertThat(resetCauseCaptor.getValue()).isSameAs(caughtException.get());
  }

  @Test
  @DisplayName("Should handle backpressure correctly")
  void shouldHandleBackpressure() throws Exception {
    // Slow consuming input stream
    String testData = "A".repeat(5000); // 5KB of data
    InputStream inputStream = new ByteArrayInputStream(testData.getBytes());
    InputStreamReadStream readStream = new InputStreamReadStream(vertxHttpRequest, inputStream, httpRequest);

    List<Buffer> receivedBuffers = new ArrayList<>();
    AtomicInteger handlerCallCount = new AtomicInteger(0);
    AtomicBoolean endCalled = new AtomicBoolean(false);
    CountDownLatch latch = new CountDownLatch(1);

    //Handler with artificial delay to simulate slow consumption
    readStream
        .handler(buffer -> {
          handlerCallCount.incrementAndGet();
          receivedBuffers.add(buffer);
          // Small delay to simulate processing
          await().pollDelay(Duration.ofMillis(1)).until(() -> true);
        })
        .endHandler(v -> {
          endCalled.set(true);
          latch.countDown();
        });

    assertThat(latch.await(10, TimeUnit.SECONDS)).isTrue();
    assertThat(endCalled.get()).isTrue();
    assertThat(receivedBuffers).isNotEmpty();
    assertThat(handlerCallCount.get()).isGreaterThan(0);
  }

  @Test
  @DisplayName("Should handle pause and resume with proper flow control")
  void shouldHandlePauseResumeFlowControl() throws Exception {
    String testData = "Test data for pause functionality";
    InputStream inputStream = new ByteArrayInputStream(testData.getBytes());
    InputStreamReadStream readStream = new InputStreamReadStream(vertxHttpRequest, inputStream, httpRequest);

    List<Buffer> receivedBuffers = new ArrayList<>();
    AtomicBoolean endCalled = new AtomicBoolean(false);
    CountDownLatch latch = new CountDownLatch(1);

    // Set handler and end handler first
    readStream.handler(receivedBuffers::add);
    readStream.endHandler(v -> {
      endCalled.set(true);
      latch.countDown();
    });

    // Pause and resume to test flow control
    readStream.pause();
    readStream.resume();

    assertThat(latch.await(5, TimeUnit.SECONDS)).isTrue();
    assertThat(endCalled.get()).isTrue();
    assertThat(receivedBuffers).isNotEmpty();
  }
}
