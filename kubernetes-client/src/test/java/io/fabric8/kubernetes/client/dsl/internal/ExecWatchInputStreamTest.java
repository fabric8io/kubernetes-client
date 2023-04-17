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

package io.fabric8.kubernetes.client.dsl.internal;

import org.awaitility.Awaitility;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExecWatchInputStreamTest {

  @Test
  void testExceptionalExit() throws IOException {
    AtomicInteger count = new AtomicInteger();
    ExecWatchInputStream is = new ExecWatchInputStream(() -> count.getAndIncrement());
    is.onExit(null, new Exception());
    assertThrows(IOException.class, () -> is.read());
    assertEquals(0, count.get());
  }

  @Test
  void testNormalExit() throws IOException {
    AtomicInteger count = new AtomicInteger();
    ExecWatchInputStream is = new ExecWatchInputStream(() -> count.getAndIncrement());
    is.onExit(0, null);
    assertEquals(-1, is.read());
    assertEquals(0, count.get());
  }

  @Test
  void testNonZeroExit() throws IOException {
    AtomicInteger count = new AtomicInteger();
    ExecWatchInputStream is = new ExecWatchInputStream(() -> count.getAndIncrement());
    is.onExit(1, null);
    assertThrows(IOException.class, () -> is.read());
  }

  @Test
  void testConsumerAfterClose() throws IOException {
    AtomicInteger count = new AtomicInteger();
    ExecWatchInputStream is = new ExecWatchInputStream(() -> count.getAndIncrement());
    is.close();
    assertEquals(0, count.get());
    is.consume(Collections.singletonList(ByteBuffer.allocate(1)));
    // should simply keep going
    assertEquals(1, count.get());
  }

  @Test
  void testConsume() throws IOException {
    AtomicInteger count = new AtomicInteger();
    ExecWatchInputStream is = new ExecWatchInputStream(() -> count.getAndIncrement(), 0);
    is.consume(Collections.singletonList(ByteBuffer.allocate(1)));

    assertEquals(0, is.read());

    assertEquals(0, count.get());

    CompletableFuture<Void> readFuture = CompletableFuture.runAsync(() -> {
      try {
        is.read();
      } catch (IOException e) {
        throw new AssertionError(e);
      }
    });

    // make sure another result was requested
    Awaitility.await().atMost(1, TimeUnit.SECONDS).until(() -> count.get() == 1);

    is.consume(Collections.singletonList(ByteBuffer.allocate(1)));
    readFuture.join();
  }

  @Test
  void testConsumeBuffering() throws IOException {
    AtomicInteger count = new AtomicInteger();
    ExecWatchInputStream is = new ExecWatchInputStream(() -> count.getAndIncrement(), 2);
    is.consume(Collections.singletonList(ByteBuffer.allocate(1)));

    // should keep going as the amount is less than the buffer size
    assertEquals(1, count.get());

    is.consume(Collections.singletonList(ByteBuffer.allocate(1)));

    // should not request as we're at the buffer limit
    assertEquals(1, count.get());
  }

  @Test
  void testCompleteInlineWithRequestMore() throws IOException {
    AtomicReference<ExecWatchInputStream> is = new AtomicReference<>();
    ExecWatchInputStream execWatchInputStream = new ExecWatchInputStream(() -> is.get().onExit(0, null));
    is.set(execWatchInputStream);
    // the first consume is implicit
    execWatchInputStream.consume(Collections.singletonList(ByteBuffer.allocate(1)));
    is.get().read();
    Awaitility.await().atMost(1, TimeUnit.SECONDS).until(() -> execWatchInputStream.read() == -1);
  }

}
