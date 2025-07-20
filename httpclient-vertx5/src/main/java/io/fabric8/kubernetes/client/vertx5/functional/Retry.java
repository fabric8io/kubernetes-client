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
package io.fabric8.kubernetes.client.vertx5.functional;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.function.Supplier;

@Value
@Builder
final class RetryConfig {
  @Builder.Default
  int maxAttempts = 3;
  @Builder.Default
  Duration initialDelay = Duration.ofMillis(100);
  @Builder.Default
  double backoffMultiplier = 2.0;
  @Builder.Default
  Duration maxDelay = Duration.ofSeconds(30);
  @Builder.Default
  Predicate<Throwable> retryCondition = throwable -> true;
}

final class Retry {

  static <T> CompletableFuture<Result<T>> withExponentialBackoff(
      @NonNull final Supplier<CompletableFuture<T>> operation,
      @NonNull final RetryConfig config,
      @NonNull final ScheduledExecutorService scheduler) {

    return executeWithRetry(operation, config, scheduler, 1, config.getInitialDelay());
  }

  private static <T> CompletableFuture<Result<T>> executeWithRetry(
      @NonNull final Supplier<CompletableFuture<T>> operation,
      @NonNull final RetryConfig config,
      @NonNull final ScheduledExecutorService scheduler,
      final int attempt,
      @NonNull final Duration currentDelay) {

    final CompletableFuture<Result<T>> result = new CompletableFuture<>();

    operation.get()
        .whenComplete((value, throwable) -> {
          if (throwable == null) {
            result.complete(Result.success(value));
            return;
          }

          if (attempt >= config.getMaxAttempts() || !config.getRetryCondition().test(throwable)) {
            result.complete(Result.failure(throwable));
            return;
          }

          final Duration nextDelay = calculateNextDelay(currentDelay, config);

          scheduler.schedule(
              () -> executeWithRetry(operation, config, scheduler, attempt + 1, nextDelay)
                  .whenComplete((retryResult, retryThrowable) -> {
                    if (retryThrowable != null) {
                      result.complete(Result.failure(retryThrowable));
                    } else {
                      result.complete(retryResult);
                    }
                  }),
              currentDelay.toMillis(),
              TimeUnit.MILLISECONDS);
        });

    return result;
  }

  private static Duration calculateNextDelay(@NonNull final Duration currentDelay, @NonNull final RetryConfig config) {
    final long nextDelayMillis = Math.min(
        (long) (currentDelay.toMillis() * config.getBackoffMultiplier()),
        config.getMaxDelay().toMillis());
    return Duration.ofMillis(nextDelayMillis);
  }
}