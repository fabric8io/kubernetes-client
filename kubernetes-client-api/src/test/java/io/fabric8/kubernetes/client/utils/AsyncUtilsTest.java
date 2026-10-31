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
package io.fabric8.kubernetes.client.utils;

import org.awaitility.Awaitility;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

import static io.fabric8.kubernetes.client.utils.AsyncUtils.retryWithExponentialBackoff;
import static io.fabric8.kubernetes.client.utils.AsyncUtils.withTimeout;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AsyncUtilsTest {

  @Test
  @DisplayName("withTimeout, future is cancelled when timeout is exceeded")
  void withTimeout_timeout() {
    final CompletableFuture<Void> future = new CompletableFuture<>();
    withTimeout(future, Duration.ofMillis(1));
    assertThatThrownBy(() -> future.get(100, TimeUnit.MILLISECONDS))
        .isInstanceOf(ExecutionException.class)
        .hasCauseInstanceOf(TimeoutException.class);
  }

  @Test
  @DisplayName("withTimeout, future is completed before timeout is exceeded")
  void withTimeout_completes() throws Exception {
    final CompletableFuture<Void> future = new CompletableFuture<>();
    withTimeout(future, Duration.ofMillis(100));
    Utils.schedule(Runnable::run, () -> future.complete(null), 1, TimeUnit.MILLISECONDS);
    assertThat(future.get(100, TimeUnit.MILLISECONDS)).isNull();
  }

  @Test
  @DisplayName("withTimeout, timeout=0, future remains intact")
  void withTimeout_notApplicable() {
    final CompletableFuture<Void> future = new CompletableFuture<>();
    withTimeout(future, Duration.ofMillis(0));
    assertThat(future.getNow(null)).isNull();
  }

  @Test
  @DisplayName("withTimeout, timeout>0, future has alternative Timeout result")
  void withTimeout_applicableTimeout() {
    final CompletableFuture<Void> future = new CompletableFuture<>();
    withTimeout(future, Duration.ofMillis(1));
    Awaitility.await()
        .pollInterval(Duration.ofMillis(10))
        .atMost(Duration.ofSeconds(5))
        .until(future::isDone);
    assertThatThrownBy(() -> future.getNow(null))
        .isInstanceOf(CompletionException.class)
        .hasCauseInstanceOf(TimeoutException.class);
  }

  @Test
  @DisplayName("retryWithExponentialBackoff, action is timed out")
  void retryWithExponentialBackoff_timeout() {
    // Given
    final Supplier<CompletableFuture<Void>> action = CompletableFuture::new;
    final CompletableFuture<Void> onCancel = new CompletableFuture<>();
    final ExponentialBackoffIntervalCalculator retryIntervalCalculator = new ExponentialBackoffIntervalCalculator(1, 1);
    final AsyncUtils.ShouldRetry<Void> shouldRetry = (v, t, retryInterval) -> retryInterval;
    // When
    final CompletableFuture<Void> result = retryWithExponentialBackoff(action, onCancel::complete, Duration.ofMillis(1),
        retryIntervalCalculator, shouldRetry);
    // Then
    assertThatThrownBy(() -> result.get(100000, TimeUnit.MILLISECONDS))
        .isInstanceOf(ExecutionException.class)
        .hasCauseInstanceOf(TimeoutException.class);
    assertThat(onCancel).isNotDone();
  }

  @Test
  @DisplayName("retryWithExponentialBackoff, with no retry, should invoke onCancel on action completion with cancelled future")
  void retryWithExponentialBackoff_withCancelledFuture_onCancel() {
    // Given
    final CompletableFuture<Void> action = new CompletableFuture<>();
    final Supplier<CompletableFuture<Void>> actionSupplier = () -> action;
    final CompletableFuture<Void> onCancel = new CompletableFuture<>();
    final ExponentialBackoffIntervalCalculator retryIntervalCalculator = new ExponentialBackoffIntervalCalculator(1, 0);
    final AsyncUtils.ShouldRetry<Void> shouldRetry = (v, t, retryInterval) -> -1;
    // When
    final CompletableFuture<Void> result = retryWithExponentialBackoff(actionSupplier, onCancel::complete,
        Duration.ZERO, retryIntervalCalculator, shouldRetry);
    result.cancel(false);
    action.complete(null);
    // Then
    assertThat(onCancel)
        .isDone()
        .isCompleted()
        .isNotCancelled();
  }

  @Test
  @DisplayName("retryWithExponentialBackoff, with retry, should invoke onCancel on action completion before retrying")
  void retryWithExponentialBackoff_withCompletedResult_onCancel() throws Exception {
    // Given
    final CompletableFuture<Boolean> action = new CompletableFuture<>();
    final Supplier<CompletableFuture<Boolean>> actionSupplier = () -> action;
    final CompletableFuture<Boolean> onCancel = new CompletableFuture<>();
    final ExponentialBackoffIntervalCalculator retryIntervalCalculator = new ExponentialBackoffIntervalCalculator(1, 1);
    final AsyncUtils.ShouldRetry<Boolean> shouldRetry = (v, t, retryInterval) -> retryInterval;
    // When
    CompletableFuture<Boolean> result = retryWithExponentialBackoff(actionSupplier, onCancel::complete,
        Duration.ZERO, retryIntervalCalculator, shouldRetry);
    action.complete(true);
    result.get(150, TimeUnit.MILLISECONDS);
    // Then
    assertThat(onCancel)
        .isDone()
        .isCompleted()
        .isNotCancelled();
  }

  @Test
  @DisplayName("retryWithExponentialBackoff, with no retry, should complete future on action completion")
  void retryWithExponentialBackoff_complete() {
    // Given
    final CompletableFuture<Void> action = new CompletableFuture<>();
    final Supplier<CompletableFuture<Void>> actionSupplier = () -> action;
    final CompletableFuture<Void> onCancel = new CompletableFuture<>();
    final ExponentialBackoffIntervalCalculator retryIntervalCalculator = new ExponentialBackoffIntervalCalculator(1, 0);
    final AsyncUtils.ShouldRetry<Void> shouldRetry = (v, t, retryInterval) -> -1;
    // When
    final CompletableFuture<Void> result = retryWithExponentialBackoff(actionSupplier, onCancel::complete,
        Duration.ZERO, retryIntervalCalculator, shouldRetry);
    action.complete(null);
    // Then
    assertThat(onCancel).isNotDone();
    assertThat(result).isDone().isCompletedWithValue(null);
  }

  @Test
  @DisplayName("retryWithExponentialBackoff, with retry, should complete future exceptionally when the retried action throws")
  void retryWithExponentialBackoff_retriedActionThrows() {
    // Given
    final AtomicInteger attempts = new AtomicInteger();
    final IllegalStateException failure = new IllegalStateException("Token refresh failed");
    final Supplier<CompletableFuture<Void>> actionSupplier = () -> {
      if (attempts.incrementAndGet() == 1) {
        return CompletableFuture.failedFuture(new IOException("Connection reset"));
      }
      throw failure;
    };
    final ExponentialBackoffIntervalCalculator retryIntervalCalculator = new ExponentialBackoffIntervalCalculator(1, 3);
    final AsyncUtils.ShouldRetry<Void> shouldRetry = (v, t, retryInterval) -> t instanceof IOException ? retryInterval : -1;
    // When
    final CompletableFuture<Void> result = retryWithExponentialBackoff(actionSupplier, v -> {
    }, Duration.ofMillis(100), retryIntervalCalculator, shouldRetry);
    // Then
    assertThatThrownBy(() -> result.get(5, TimeUnit.SECONDS))
        .isInstanceOf(ExecutionException.class)
        .hasCause(failure);
    assertThat(attempts).hasValue(2);
  }

  @Test
  @DisplayName("retryWithExponentialBackoff, should complete future exceptionally when the retry decision throws")
  void retryWithExponentialBackoff_shouldRetryThrows() {
    // Given
    final CompletableFuture<String> action = new CompletableFuture<>();
    final IllegalStateException failure = new IllegalStateException("Retry decision failed");
    final ExponentialBackoffIntervalCalculator retryIntervalCalculator = new ExponentialBackoffIntervalCalculator(1, 3);
    final AsyncUtils.ShouldRetry<String> shouldRetry = (v, t, retryInterval) -> {
      throw failure;
    };
    // When
    final CompletableFuture<String> result = retryWithExponentialBackoff(() -> action, v -> {
    }, Duration.ZERO, retryIntervalCalculator, shouldRetry);
    action.complete("Response");
    // Then
    assertThat(result).isCompletedExceptionally();
    assertThatThrownBy(result::join)
        .isInstanceOf(CompletionException.class)
        .hasCause(failure);
    assertThat(failure.getSuppressed()).isEmpty();
  }

  @Test
  @DisplayName("retryWithExponentialBackoff, should complete future with the retry decision failure, keeping the failed attempt's error as suppressed")
  void retryWithExponentialBackoff_shouldRetryThrowsAfterFailedAttempt() {
    // Given
    final CompletableFuture<String> action = new CompletableFuture<>();
    final IOException attemptFailure = new IOException("Connection refused");
    final IllegalStateException failure = new IllegalStateException("Retry decision failed");
    final ExponentialBackoffIntervalCalculator retryIntervalCalculator = new ExponentialBackoffIntervalCalculator(1, 3);
    final AsyncUtils.ShouldRetry<String> shouldRetry = (v, t, retryInterval) -> {
      throw failure;
    };
    // When
    final CompletableFuture<String> result = retryWithExponentialBackoff(() -> action, v -> {
    }, Duration.ZERO, retryIntervalCalculator, shouldRetry);
    action.completeExceptionally(attemptFailure);
    // Then
    assertThat(result).isCompletedExceptionally();
    assertThatThrownBy(result::join)
        .isInstanceOf(CompletionException.class)
        .hasCause(failure);
    assertThat(failure.getSuppressed()).containsExactly(attemptFailure);
  }

  @Test
  @DisplayName("retryWithExponentialBackoff, should complete future with the failed attempt's error when the retry decision rethrows it")
  void retryWithExponentialBackoff_shouldRetryRethrowsAttemptFailure() {
    // Given
    final CompletableFuture<String> action = new CompletableFuture<>();
    final IllegalStateException attemptFailure = new IllegalStateException("Connection refused");
    final ExponentialBackoffIntervalCalculator retryIntervalCalculator = new ExponentialBackoffIntervalCalculator(1, 3);
    final AsyncUtils.ShouldRetry<String> shouldRetry = (v, t, retryInterval) -> {
      throw (IllegalStateException) t;
    };
    // When
    final CompletableFuture<String> result = retryWithExponentialBackoff(() -> action, v -> {
    }, Duration.ZERO, retryIntervalCalculator, shouldRetry);
    action.completeExceptionally(attemptFailure);
    // Then
    assertThat(result).isCompletedExceptionally();
    assertThatThrownBy(result::join)
        .isInstanceOf(CompletionException.class)
        .hasCause(attemptFailure);
    assertThat(attemptFailure.getSuppressed()).isEmpty();
  }

  @Test
  @DisplayName("retryWithExponentialBackoff, with retry, should complete future exceptionally when onCancel throws before retrying")
  void retryWithExponentialBackoff_onCancelThrowsBeforeRetry() {
    // Given
    final CompletableFuture<String> action = new CompletableFuture<>();
    final IllegalStateException failure = new IllegalStateException("Response cleanup failed");
    final ExponentialBackoffIntervalCalculator retryIntervalCalculator = new ExponentialBackoffIntervalCalculator(1, 3);
    final AsyncUtils.ShouldRetry<String> shouldRetry = (v, t, retryInterval) -> retryInterval;
    // When
    final CompletableFuture<String> result = retryWithExponentialBackoff(() -> action, v -> {
      throw failure;
    }, Duration.ZERO, retryIntervalCalculator, shouldRetry);
    action.complete("Retryable response");
    // Then
    assertThat(result).isCompletedExceptionally();
    assertThatThrownBy(result::join)
        .isInstanceOf(CompletionException.class)
        .hasCause(failure);
  }
}
