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

package io.fabric8.kubernetes.client.utils.internal;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.assertFalse;

class SerialExecutorTest {

  @Test
  void clearInterrupt() {
    ExecutorService es = Executors.newSingleThreadExecutor();
    SerialExecutor serialExecutor = new SerialExecutor(es);

    CompletableFuture<Thread> future = new CompletableFuture<>();
    serialExecutor.execute(() -> {
      future.complete(Thread.currentThread());
      while (!Thread.currentThread().isInterrupted()) {
        try {
          Thread.sleep(10);
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
        }
      }
      throw new RuntimeException();
    });
    CompletableFuture<Boolean> interrupted = new CompletableFuture<>();
    serialExecutor.execute(() -> {
      interrupted.complete(Thread.currentThread().isInterrupted());
    });

    Thread t = future.join();
    t.interrupt(); // interrupt the first task
    assertFalse(interrupted.join()); // make sure the second is not interrrupted
  }

}
