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
package io.fabric8.kubernetes.client.utils;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class AsyncUtils {

  private AsyncUtils() {
  }

  /**
   * Returns the provided {@link CompletableFuture} that will complete exceptionally with a {@link TimeoutException}
   * if the provided {@link Duration} timeout period is exceeded.
   *
   * @param future the future to add a timeout to.
   * @param timeout the timeout duration.
   * @return the provided future with a timeout.
   * @param <T> the result type returned by the future.
   */
  public static <T> CompletableFuture<T> withTimeout(CompletableFuture<T> future, Duration timeout) {
    if (timeout != null && timeout.toMillis() > 0) {
      final Future<?> scheduled = Utils.schedule(Runnable::run, () -> future.completeExceptionally(new TimeoutException()),
          timeout.toMillis(), TimeUnit.MILLISECONDS);
      future.whenComplete((v, t) -> scheduled.cancel(true));
    }
    return future;
  }

  /**
   * Returns a new {@link CompletableFuture} that will complete once the action provided by the action supplier completes.
   * The action will be retried with an exponential backoff using the {@link ExponentialBackoffIntervalCalculator} as
   * long as the {@link ShouldRetry} predicate returns true.
   * Each action retrieval retry will time out after the provided timeout {@link Duration}.
   * 
   * @param action the action supplier.
   * @param onCancel consumes the intermediate result in case the returned future is cancelled or each time the action is
   *        retried.
   * @param timeout the timeout duration.
   * @param retryIntervalCalculator the retry interval calculator.
   * @param shouldRetry the predicate to compute if the action is to be retried.
   * @return a new {@link CompletableFuture} that will complete once the action provided by the action supplier completes.
   * @param <T> the result type returned by the future.
   */
  public static <T> CompletableFuture<T> retryWithExponentialBackoff(Supplier<CompletableFuture<T>> action,
      Consumer<T> onCancel, Duration timeout, ExponentialBackoffIntervalCalculator retryIntervalCalculator,
      ShouldRetry<T> shouldRetry) {
    final CompletableFuture<T> result = new CompletableFuture<>();
    retryWithExponentialBackoff(result, action, onCancel, timeout, retryIntervalCalculator, shouldRetry);
    return result;
  }

  private static <T> void retryWithExponentialBackoff(CompletableFuture<T> result, Supplier<CompletableFuture<T>> action,
      Consumer<T> onCancel, Duration timeout, ExponentialBackoffIntervalCalculator retryIntervalCalculator,
      ShouldRetry<T> shouldRetry) {
    withTimeout(action.get(), timeout).whenComplete((r, t) -> {
      if (retryIntervalCalculator.shouldRetry() && !result.isDone()) {
        final long retryInterval = retryIntervalCalculator.nextReconnectInterval();
        if (shouldRetry.shouldRetry(r, t, retryInterval)) {
          if (r != null) {
            onCancel.accept(r);
          }
          Utils.schedule(Runnable::run,
              () -> retryWithExponentialBackoff(result, action, onCancel, timeout, retryIntervalCalculator, shouldRetry),
              retryInterval, TimeUnit.MILLISECONDS);
          return;
        }
      }
      if (t != null) {
        result.completeExceptionally(t);
      } else if (!result.complete(r)) {
        onCancel.accept(r);
      }
    });
  }

  @FunctionalInterface
  public interface ShouldRetry<T> {
    boolean shouldRetry(T result, Throwable exception, long retryInterval);
  }
}
