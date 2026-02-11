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

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("StackBasedRecursionGuard")
class StackBasedRecursionGuardTest {

  @Test
  @DisplayName("allows recursion below the limit")
  void belowLimit() {
    StackBasedRecursionGuard guard = new StackBasedRecursionGuard();
    try {
      assertThat(guard.enter()).isTrue();
      assertThat(guard.getCurrentDepth()).isEqualTo(1);
    } finally {
      guard.exit();
    }
    assertThat(guard.getCurrentDepth()).isEqualTo(0);
  }

  @Test
  @DisplayName("returns false when depth exceeds limit")
  void exceedsLimit() {
    StackBasedRecursionGuard guard = new StackBasedRecursionGuard();
    AtomicBoolean hitFalse = new AtomicBoolean(false);

    // Manually create a scenario where we exceed the limit
    for (int i = 0; i < 8; i++) {
      assertThat(guard.enter()).isTrue();
    }

    // The 9th enter should return false
    assertThat(guard.enter()).isFalse();
    hitFalse.set(true);

    // Clean up all levels (including the failed one)
    for (int i = 0; i < 9; i++) {
      guard.exit();
    }

    assertThat(hitFalse.get()).isTrue();
    assertThat(guard.getCurrentDepth()).isEqualTo(0);
  }

  @Test
  @DisplayName("tracks depth correctly")
  void tracksDepth() {
    StackBasedRecursionGuard guard = new StackBasedRecursionGuard();

    assertThat(guard.getCurrentDepth()).isZero();

    assertThat(guard.enter()).isTrue(); // depth = 1
    assertThat(guard.getCurrentDepth()).isEqualTo(1);

    assertThat(guard.enter()).isTrue(); // depth = 2
    assertThat(guard.getCurrentDepth()).isEqualTo(2);

    guard.exit(); // depth = 1
    assertThat(guard.getCurrentDepth()).isEqualTo(1);

    guard.exit(); // depth = 0
    assertThat(guard.getCurrentDepth()).isZero();
  }

  @Test
  @DisplayName("handles nested enter/exit correctly")
  void nestedEnterExit() {
    StackBasedRecursionGuard guard = new StackBasedRecursionGuard();

    // First level
    assertThat(guard.enter()).isTrue();
    try {
      assertThat(guard.getCurrentDepth()).isEqualTo(1);

      // Second level
      assertThat(guard.enter()).isTrue();
      try {
        assertThat(guard.getCurrentDepth()).isEqualTo(2);

        // Third level
        assertThat(guard.enter()).isTrue();
        try {
          assertThat(guard.getCurrentDepth()).isEqualTo(3);
        } finally {
          guard.exit();
        }
        assertThat(guard.getCurrentDepth()).isEqualTo(2);
      } finally {
        guard.exit();
      }
      assertThat(guard.getCurrentDepth()).isEqualTo(1);
    } finally {
      guard.exit();
    }
    assertThat(guard.getCurrentDepth()).isZero();
  }

  @Test
  @DisplayName("resets depth after failed enter")
  void resetsAfterFailedEnter() {
    StackBasedRecursionGuard guard = new StackBasedRecursionGuard();

    // Fill up to the limit
    for (int i = 0; i < 8; i++) {
      assertThat(guard.enter()).isTrue();
    }
    assertThat(guard.getCurrentDepth()).isEqualTo(8);

    // Next enter should fail but still increment depth internally
    assertThat(guard.enter()).isFalse();
    assertThat(guard.getCurrentDepth()).isEqualTo(9);

    // Exit all levels
    for (int i = 0; i < 9; i++) {
      guard.exit();
    }
    assertThat(guard.getCurrentDepth()).isZero();

    // Should work again
    assertThat(guard.enter()).isTrue();
    guard.exit();
    assertThat(guard.getCurrentDepth()).isZero();
  }
}
