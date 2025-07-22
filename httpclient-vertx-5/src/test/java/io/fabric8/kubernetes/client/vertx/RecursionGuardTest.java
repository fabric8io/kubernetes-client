package io.fabric8.kubernetes.client.vertx;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("RecursionGuard")
class RecursionGuardTest {

  @Test
  @DisplayName("allows recursion below the limit")
  void belowLimit() {
    RecursionGuard guard = new RecursionGuard();
    try {
      assertThat(guard.enter()).isTrue();
    } finally {
      guard.exit();
    }
  }

  @Test
  @DisplayName("returns false when depth exceeds limit")
  void exceedsLimit() {
    RecursionGuard guard = new RecursionGuard();
    AtomicBoolean hitFalse = new AtomicBoolean(false);
    dive(guard, 0, hitFalse);
    assertThat(hitFalse).isTrue();
  }

  private void dive(RecursionGuard guard, int depth, AtomicBoolean hitFalse) {
    if (guard.enter()) {
      try {
        if (depth < 12)
          dive(guard, depth + 1, hitFalse);
      } finally {
        guard.exit();
      }
    } else {
      hitFalse.set(true);
    }
  }

  @Test
  @DisplayName("resets counter after cleanup")
  void resetsAfterCleanup() {
    RecursionGuard guard = new RecursionGuard();
    guard.enter();
    guard.exit();
    guard.cleanup();
    try {
      assertThat(guard.enter()).isTrue();
    } finally {
      guard.exit();
    }
  }

  @Test
  @DisplayName("maintains separate counters per thread")
  void separateCountersPerThread() throws InterruptedException {
    RecursionGuard guard = new RecursionGuard();
    CountDownLatch done = new CountDownLatch(2);
    AtomicReference<Boolean> t1 = new AtomicReference<>();
    AtomicReference<Boolean> t2 = new AtomicReference<>();

    Runnable task = () -> {
      try {
        boolean ok = guard.enter();
        t1.compareAndSet(null, ok);
        t2.compareAndSet(null, ok);
      } finally {
        guard.exit();
        done.countDown();
      }
    };

    new Thread(task).start();
    new Thread(task).start();

    assertThat(done.await(5, TimeUnit.SECONDS)).isTrue();
    assertThat(t1.get()).isTrue();
    assertThat(t2.get()).isTrue();
  }

  @Test
  @DisplayName("supports concurrent access")
  void concurrentAccess() throws InterruptedException {
    RecursionGuard guard = new RecursionGuard();
    ExecutorService pool = Executors.newFixedThreadPool(4);
    CountDownLatch latch = new CountDownLatch(20);

    for (int i = 0; i < 20; i++) {
      pool.submit(() -> {
        try {
          assertThat(guard.enter()).isTrue();
        } finally {
          guard.exit();
          latch.countDown();
        }
      });
    }

    assertThat(latch.await(5, TimeUnit.SECONDS)).isTrue();
    pool.shutdownNow();
  }
}
