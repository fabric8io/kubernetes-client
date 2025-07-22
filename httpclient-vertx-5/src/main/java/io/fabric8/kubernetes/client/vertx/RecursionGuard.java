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

import lombok.NoArgsConstructor;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Guards against stack overflow by tracking recursion depth per thread.
 * When depth exceeds the limit, callers should use async scheduling instead.
 */
@NoArgsConstructor
class RecursionGuard {

  /**
   * Maximum recursion depth before requiring async scheduling.
   * Value preserved from original Vert.x 4 implementation.
   */
  private static final int MAX_RECURSION_DEPTH = 8;

  private final ThreadLocal<AtomicInteger> depthCounter = ThreadLocal.withInitial(AtomicInteger::new);

  /**
   * Increments the depth counter for the current thread.
   *
   * @return {@code true} when the current depth is within the limit
   */
  boolean enter() {
    return depthCounter.get().getAndIncrement() < MAX_RECURSION_DEPTH;
  }

  /** Decrements the depth counter for the current thread. */
  void exit() {
    depthCounter.get().decrementAndGet();
  }

  /** Clears the ThreadLocal counter. */
  void cleanup() {
    depthCounter.remove();
  }
}
