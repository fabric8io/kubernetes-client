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
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("StreamFlowController")
class StreamFlowControllerTest {

  private Vertx vertx;
  private Context context;
  private StreamFlowController controller;

  @BeforeEach
  void setUp() {
    vertx = Vertx.vertx();
    context = vertx.getOrCreateContext();
    controller = new StreamFlowController();
  }

  @AfterEach
  void tearDown() {
    if (vertx != null) {
      vertx.close();
    }
  }

  @Test
  @DisplayName("Should not be initialized before initialize() is called")
  void shouldNotBeInitializedBeforeInitialize() {
    assertThat(controller.isInitialized()).isFalse();
  }

  @Test
  @DisplayName("Should be initialized after initialize() is called")
  void shouldBeInitializedAfterInitialize() {
    controller.initialize(context, () -> {
    });

    assertThat(controller.isInitialized()).isTrue();
  }

  @Test
  @DisplayName("Should handle data chunks and end handler in Vert.x context")
  void shouldHandleDataChunksAndEndHandlerInVertxContext() throws Exception {
    List<Buffer> receivedBuffers = new ArrayList<>();
    AtomicBoolean endHandlerCalled = new AtomicBoolean(false);
    CountDownLatch dataLatch = new CountDownLatch(2);
    CountDownLatch endLatch = new CountDownLatch(1);

    vertx.runOnContext(v -> {
      controller.initialize(context, () -> {
      });
      controller.configureDataHandler(buffer -> {
        receivedBuffers.add(buffer);
        dataLatch.countDown();
      });
      controller.setEndHandler(h -> {
        endHandlerCalled.set(true);
        endLatch.countDown();
      });

      // Write data chunks
      controller.writeChunk(Buffer.buffer("Hello"));
      controller.writeChunk(Buffer.buffer("World"));

      // Write end sentinel
      controller.writeEndSentinel();
    });

    assertThat(dataLatch.await(5, TimeUnit.SECONDS)).isTrue();
    assertThat(endLatch.await(5, TimeUnit.SECONDS)).isTrue();

    assertThat(receivedBuffers).hasSize(2);
    assertThat(receivedBuffers.get(0).toString()).hasToString("Hello");
    assertThat(receivedBuffers.get(1).toString()).hasToString("World");
    assertThat(endHandlerCalled.get()).isTrue();
  }

  @Test
  @DisplayName("Should handle null handlers gracefully")
  void shouldHandleNullHandlersGracefully() throws Exception {
    CountDownLatch latch = new CountDownLatch(1);

    vertx.runOnContext(v -> {
      controller.initialize(context, () -> {
      });
      controller.configureDataHandler(null);
      controller.setEndHandler(null);

      // Should not throw exceptions
      controller.writeChunk(Buffer.buffer("test"));
      controller.writeEndSentinel();

      latch.countDown();
    });

    assertThat(latch.await(5, TimeUnit.SECONDS)).isTrue();
  }

  @Test
  @DisplayName("Should handle multiple end sentinels")
  void shouldHandleMultipleEndSentinels() throws Exception {
    AtomicBoolean endHandlerCalled = new AtomicBoolean(false);
    CountDownLatch latch = new CountDownLatch(1);

    vertx.runOnContext(v -> {
      controller.initialize(context, () -> {
      });
      controller.configureDataHandler(buffer -> {
      });
      controller.setEndHandler(h -> {
        endHandlerCalled.set(true);
        latch.countDown();
      });

      // Write multiple end sentinels - should call handler for first one
      controller.writeEndSentinel();
      controller.writeEndSentinel();
    });

    assertThat(latch.await(5, TimeUnit.SECONDS)).isTrue();
    assertThat(endHandlerCalled.get()).isTrue();
  }

  @Test
  @DisplayName("Should handle complex flow control operations")
  void shouldHandleComplexFlowControlOperations() throws Exception {
    List<Buffer> receivedBuffers = new ArrayList<>();
    AtomicBoolean endHandlerCalled = new AtomicBoolean(false);
    CountDownLatch dataLatch = new CountDownLatch(3);
    CountDownLatch endLatch = new CountDownLatch(1);

    vertx.runOnContext(v -> {
      controller.initialize(context, () -> {
      });
      controller.configureDataHandler(buffer -> {
        receivedBuffers.add(buffer);
        dataLatch.countDown();
      });
      controller.setEndHandler(h -> {
        endHandlerCalled.set(true);
        endLatch.countDown();
      });

      // Complex sequence of operations
      controller.writeChunk(Buffer.buffer("first"));
      controller.pause();
      controller.writeChunk(Buffer.buffer("second"));
      controller.resume();
      controller.fetch(1);
      controller.writeChunk(Buffer.buffer("third"));
      controller.writeEndSentinel();
    });

    assertThat(dataLatch.await(5, TimeUnit.SECONDS)).isTrue();
    assertThat(endLatch.await(5, TimeUnit.SECONDS)).isTrue();

    assertThat(receivedBuffers).hasSize(3);
    assertThat(receivedBuffers.get(0).toString()).hasToString("first");
    assertThat(receivedBuffers.get(1).toString()).hasToString("second");
    assertThat(receivedBuffers.get(2).toString()).hasToString("third");
    assertThat(endHandlerCalled.get()).isTrue();
  }

  @Test
  @DisplayName("Should properly separate end sentinel from data")
  void shouldProperlySeparateEndSentinelFromData() throws Exception {
    List<Buffer> receivedBuffers = new ArrayList<>();
    AtomicBoolean endHandlerCalled = new AtomicBoolean(false);
    CountDownLatch dataLatch = new CountDownLatch(2);
    CountDownLatch endLatch = new CountDownLatch(1);

    vertx.runOnContext(v -> {
      controller.initialize(context, () -> {
      });
      controller.configureDataHandler(buffer -> {
        // Should only receive actual data, not the end sentinel
        receivedBuffers.add(buffer);
        dataLatch.countDown();
      });
      controller.setEndHandler(h -> {
        endHandlerCalled.set(true);
        endLatch.countDown();
      });

      // Write data and then end sentinel
      controller.writeChunk(Buffer.buffer("data1"));
      controller.writeChunk(Buffer.buffer("data2"));
      controller.writeEndSentinel();
    });

    assertThat(dataLatch.await(5, TimeUnit.SECONDS)).isTrue();
    assertThat(endLatch.await(5, TimeUnit.SECONDS)).isTrue();

    // Should only have received data chunks, not the end sentinel
    assertThat(receivedBuffers).hasSize(2);
    assertThat(receivedBuffers.get(0).toString()).hasToString("data1");
    assertThat(receivedBuffers.get(1).toString()).hasToString("data2");
    assertThat(endHandlerCalled.get()).isTrue();
  }
}
