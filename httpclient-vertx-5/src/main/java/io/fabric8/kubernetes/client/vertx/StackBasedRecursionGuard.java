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

/**
 * Stack-based recursion guard that prevents stack overflow by tracking call depth.
 * 
 * <p>
 * This implementation uses a simple instance variable to track recursion depth,
 * eliminating ThreadLocal usage and potential memory leaks. Each instance is tied
 * to a specific component (like InputStreamReadStream) and tracks recursion for
 * that component only.
 * </p>
 * 
 * <p>
 * Usage pattern:
 * </p>
 * <pre>{@code
 * private void recursiveMethod() {
 *   if (recursionGuard.enter()) {
 *     try {
 *       // Recursive logic here
 *       recursiveMethod(); // May call this method again
 *     } finally {
 *       recursionGuard.exit();
 *     }
 *   } else {
 *     // Schedule async execution to avoid stack overflow
 *     vertx.runOnContext(v -> recursiveMethod());
 *   }
 * }
 * }</pre>
 * 
 * @since 7.4.0
 */
class StackBasedRecursionGuard {

  /**
   * Maximum recursion depth before requiring async scheduling.
   * Value preserved from original Vert.x 4 implementation.
   */
  private static final int MAX_RECURSION_DEPTH = 8;

  /**
   * Current recursion depth for this instance.
   * No synchronization needed as this is tied to single component instance.
   */
  private int depth = 0;

  /**
   * Attempts to enter a recursive call.
   *
   * @return {@code true} if recursion is within safe limits and can proceed synchronously,
   *         {@code false} if recursion depth is too high and caller should use async scheduling
   */
  boolean enter() {
    return depth++ < MAX_RECURSION_DEPTH;
  }

  /**
   * Exits a recursive call, decreasing the depth counter.
   * Must be called in a finally block to ensure proper cleanup.
   */
  void exit() {
    depth--;
  }

  /**
   * Returns current recursion depth.
   * Useful for testing and debugging.
   * 
   * @return current depth count
   */
  int getCurrentDepth() {
    return depth;
  }
}