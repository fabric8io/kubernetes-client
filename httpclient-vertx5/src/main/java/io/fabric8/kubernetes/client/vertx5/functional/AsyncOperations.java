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

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class AsyncOperations {

  public static <T> CompletableFuture<Result<T>> withTimeout(
      @NonNull final CompletableFuture<T> future,
      @NonNull final Duration timeout) {

    final CompletableFuture<Result<T>> resultFuture = new CompletableFuture<>();

    future
        .orTimeout(timeout.toMillis(), TimeUnit.MILLISECONDS)
        .whenComplete((value, throwable) -> {
          if (throwable != null) {
            // Unwrap CompletionException to get original cause
            final Throwable actualThrowable = throwable instanceof CompletionException && throwable.getCause() != null
                ? throwable.getCause()
                : throwable;
            resultFuture.complete(Result.failure(actualThrowable));
          } else {
            resultFuture.complete(Result.success(value));
          }
        });

    return resultFuture;
  }

  public static <T> CompletableFuture<Result<T>> fromSupplier(@NonNull final Supplier<T> supplier) {
    return CompletableFuture.supplyAsync(() -> {
      try {
        return Result.success(supplier.get());
      } catch (final Exception e) {
        return Result.failure(e);
      }
    });
  }

  public static <T> CompletableFuture<Result<T>> fromResult(@NonNull final Result<T> result) {
    return CompletableFuture.completedFuture(result);
  }

  public static <T> CompletableFuture<T> unwrapResult(@NonNull final CompletableFuture<Result<T>> future) {
    final CompletableFuture<T> unwrapped = new CompletableFuture<>();

    future.whenComplete((result, throwable) -> {
      if (throwable != null) {
        unwrapped.completeExceptionally(throwable);
        return;
      }

      if (result instanceof Result.Success) {
        final Result.Success<T> success = (Result.Success<T>) result;
        unwrapped.complete(success.getValue());
      } else {
        final Result.Failure<T> failure = (Result.Failure<T>) result;
        unwrapped.completeExceptionally(failure.getError());
      }
    });

    return unwrapped;
  }

  public static <T> CompletableFuture<T> failedFuture(@NonNull final Throwable throwable) {
    final CompletableFuture<T> future = new CompletableFuture<>();
    future.completeExceptionally(throwable);
    return future;
  }
}