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

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("AsyncOperations utility")
class AsyncOperationsTest {

  @Nested
  @DisplayName("Timeout handling")
  class TimeoutHandling {

    @Test
    @DisplayName("should complete successfully within timeout")
    @Timeout(2)
    void shouldCompleteSuccessfullyWithinTimeout() throws Exception {
      final CompletableFuture<String> originalFuture = CompletableFuture.supplyAsync(() -> {
        try {
          Thread.sleep(100);
          return "success";
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
          throw new RuntimeException(e);
        }
      });

      final CompletableFuture<Result<String>> resultFuture = AsyncOperations
          .withTimeout(originalFuture, Duration.ofSeconds(1));

      final Result<String> result = resultFuture.get(2, TimeUnit.SECONDS);

      assertAll("Successful completion within timeout",
          () -> assertTrue(result.isSuccess()),
          () -> assertEquals("success", result.getValue()));
    }

    @Test
    @DisplayName("should handle timeout properly")
    @Timeout(2)
    void shouldHandleTimeoutProperly() throws Exception {
      final CompletableFuture<String> slowFuture = CompletableFuture.supplyAsync(() -> {
        try {
          Thread.sleep(2000);
          return "too slow";
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
          throw new RuntimeException(e);
        }
      });

      final CompletableFuture<Result<String>> resultFuture = AsyncOperations
          .withTimeout(slowFuture, Duration.ofMillis(100));

      final Result<String> result = resultFuture.get(2, TimeUnit.SECONDS);

      assertAll("Timeout handling",
          () -> assertTrue(result.isFailure()),
          () -> assertInstanceOf(TimeoutException.class, result.getError()));
    }

    @Test
    @DisplayName("should handle exception in original future")
    @Timeout(2)
    void shouldHandleExceptionInOriginalFuture() throws Exception {
      final RuntimeException originalException = new RuntimeException("original error");
      final CompletableFuture<String> failingFuture = CompletableFuture.supplyAsync(() -> {
        throw originalException;
      });

      final CompletableFuture<Result<String>> resultFuture = AsyncOperations
          .withTimeout(failingFuture, Duration.ofSeconds(1));

      final Result<String> result = resultFuture.get(2, TimeUnit.SECONDS);

      assertAll("Exception handling",
          () -> assertTrue(result.isFailure()),
          () -> assertEquals(originalException, result.getError()));
    }

    @Test
    @DisplayName("should handle zero timeout")
    @Timeout(2)
    void shouldHandleZeroTimeout() throws Exception {
      final CompletableFuture<String> future = CompletableFuture.completedFuture("immediate");

      final CompletableFuture<Result<String>> resultFuture = AsyncOperations
          .withTimeout(future, Duration.ZERO);

      final Result<String> result = resultFuture.get(2, TimeUnit.SECONDS);

      // Zero timeout may succeed if the future completes immediately
      if (result.isSuccess()) {
        assertEquals("immediate", result.getValue());
      } else {
        assertInstanceOf(TimeoutException.class, result.getError());
      }
    }
  }

  @Nested
  @DisplayName("Supplier wrapping")
  class SupplierWrapping {

    @Test
    @DisplayName("should wrap successful supplier")
    @Timeout(2)
    void shouldWrapSuccessfulSupplier() throws Exception {
      final CompletableFuture<Result<String>> resultFuture = AsyncOperations
          .fromSupplier(() -> "supplier result");

      final Result<String> result = resultFuture.get(2, TimeUnit.SECONDS);

      assertAll("Successful supplier",
          () -> assertTrue(result.isSuccess()),
          () -> assertEquals("supplier result", result.getValue()));
    }

    @Test
    @DisplayName("should wrap failing supplier")
    @Timeout(2)
    void shouldWrapFailingSupplier() throws Exception {
      final RuntimeException supplierException = new RuntimeException("supplier error");

      final CompletableFuture<Result<String>> resultFuture = AsyncOperations
          .fromSupplier(() -> {
            throw supplierException;
          });

      final Result<String> result = resultFuture.get(2, TimeUnit.SECONDS);

      assertAll("Failing supplier",
          () -> assertTrue(result.isFailure()),
          () -> assertEquals(supplierException, result.getError()));
    }

    @Test
    @DisplayName("should handle supplier returning null")
    @Timeout(2)
    void shouldHandleSupplierReturningNull() throws Exception {
      final CompletableFuture<Result<String>> resultFuture = AsyncOperations
          .fromSupplier(() -> null);

      final Result<String> result = resultFuture.get(2, TimeUnit.SECONDS);

      assertAll("Null supplier result",
          () -> assertTrue(result.isSuccess()),
          () -> assertNull(result.getValue()));
    }

    @Test
    @DisplayName("should handle complex supplier computations")
    @Timeout(2)
    void shouldHandleComplexSupplierComputations() throws Exception {
      final CompletableFuture<Result<Integer>> resultFuture = AsyncOperations
          .fromSupplier(() -> {
            int sum = 0;
            for (int i = 1; i <= 100; i++) {
              sum += i;
            }
            return sum;
          });

      final Result<Integer> result = resultFuture.get(2, TimeUnit.SECONDS);

      assertAll("Complex computation",
          () -> assertTrue(result.isSuccess()),
          () -> assertEquals(5050, result.getValue()));
    }
  }

  @Nested
  @DisplayName("Result wrapping")
  class ResultWrapping {

    @Test
    @DisplayName("should wrap successful result")
    @Timeout(2)
    void shouldWrapSuccessfulResult() throws Exception {
      final Result<String> originalResult = Result.success("wrapped value");

      final CompletableFuture<Result<String>> resultFuture = AsyncOperations
          .fromResult(originalResult);

      final Result<String> result = resultFuture.get(2, TimeUnit.SECONDS);

      assertAll("Wrapped successful result",
          () -> assertTrue(result.isSuccess()),
          () -> assertEquals("wrapped value", result.getValue()),
          () -> assertEquals(originalResult, result));
    }

    @Test
    @DisplayName("should wrap failed result")
    @Timeout(2)
    void shouldWrapFailedResult() throws Exception {
      final Exception originalException = new RuntimeException("wrapped error");
      final Result<String> originalResult = Result.failure(originalException);

      final CompletableFuture<Result<String>> resultFuture = AsyncOperations
          .fromResult(originalResult);

      final Result<String> result = resultFuture.get(2, TimeUnit.SECONDS);

      assertAll("Wrapped failed result",
          () -> assertTrue(result.isFailure()),
          () -> assertEquals(originalException, result.getError()),
          () -> assertEquals(originalResult, result));
    }
  }

  @Nested
  @DisplayName("Result unwrapping")
  class ResultUnwrapping {

    @Test
    @DisplayName("should unwrap successful result")
    @Timeout(2)
    void shouldUnwrapSuccessfulResult() throws Exception {
      final CompletableFuture<Result<String>> resultFuture = CompletableFuture
          .completedFuture(Result.success("unwrapped value"));

      final CompletableFuture<String> unwrapped = AsyncOperations
          .unwrapResult(resultFuture);

      final String value = unwrapped.get(2, TimeUnit.SECONDS);

      assertEquals("unwrapped value", value);
    }

    @Test
    @DisplayName("should unwrap failed result as exception")
    @Timeout(2)
    void shouldUnwrapFailedResultAsException() {
      final RuntimeException originalException = new RuntimeException("unwrapped error");
      final CompletableFuture<Result<String>> resultFuture = CompletableFuture
          .completedFuture(Result.failure(originalException));

      final CompletableFuture<String> unwrapped = AsyncOperations
          .unwrapResult(resultFuture);

      final ExecutionException exception = assertThrows(ExecutionException.class, () -> unwrapped.get(2, TimeUnit.SECONDS));

      assertEquals(originalException, exception.getCause());
    }

    @Test
    @DisplayName("should handle exception in result future")
    @Timeout(2)
    void shouldHandleExceptionInResultFuture() {
      final RuntimeException futureException = new RuntimeException("future error");
      final CompletableFuture<Result<String>> resultFuture = CompletableFuture
          .failedFuture(futureException);

      final CompletableFuture<String> unwrapped = AsyncOperations
          .unwrapResult(resultFuture);

      final ExecutionException exception = assertThrows(ExecutionException.class, () -> unwrapped.get(2, TimeUnit.SECONDS));

      assertEquals(futureException, exception.getCause());
    }
  }

  @Nested
  @DisplayName("Failed future creation")
  class FailedFutureCreation {

    @Test
    @DisplayName("should create failed future with exception")
    @Timeout(2)
    void shouldCreateFailedFutureWithException() {
      final RuntimeException testException = new RuntimeException("test error");

      final CompletableFuture<String> failedFuture = AsyncOperations
          .failedFuture(testException);

      final ExecutionException exception = assertThrows(ExecutionException.class, () -> failedFuture.get(2, TimeUnit.SECONDS));

      assertEquals(testException, exception.getCause());
    }

    @Test
    @DisplayName("should create failed future with checked exception")
    @Timeout(2)
    void shouldCreateFailedFutureWithCheckedException() {
      final Exception checkedException = new Exception("checked error");

      final CompletableFuture<String> failedFuture = AsyncOperations
          .failedFuture(checkedException);

      final ExecutionException exception = assertThrows(ExecutionException.class, () -> failedFuture.get(2, TimeUnit.SECONDS));

      assertEquals(checkedException, exception.getCause());
    }

    @Test
    @DisplayName("should maintain failed state")
    @Timeout(2)
    void shouldMaintainFailedState() {
      final RuntimeException testException = new RuntimeException("test error");

      final CompletableFuture<String> failedFuture = AsyncOperations
          .failedFuture(testException);

      assertAll("Failed future state",
          () -> assertTrue(failedFuture.isDone()),
          () -> assertTrue(failedFuture.isCompletedExceptionally()),
          () -> assertFalse(failedFuture.isCancelled()));
    }
  }

  @Nested
  @DisplayName("Integration scenarios")
  class IntegrationScenarios {

    @Test
    @DisplayName("should chain operations correctly")
    @Timeout(3)
    void shouldChainOperationsCorrectly() throws Exception {
      final CompletableFuture<String> initialFuture = CompletableFuture
          .supplyAsync(() -> "initial");

      // Step 1: Apply timeout to initial future
      final CompletableFuture<Result<String>> timeoutResult = AsyncOperations
          .withTimeout(initialFuture, Duration.ofSeconds(1));

      final Result<String> stringResult = timeoutResult.get(3, TimeUnit.SECONDS);
      assertTrue(stringResult.isSuccess());

      // Step 2: Calculate length
      final CompletableFuture<Result<Integer>> lengthResult = AsyncOperations
          .fromSupplier(() -> stringResult.getValue().length());

      final Result<Integer> finalResult = lengthResult.get(3, TimeUnit.SECONDS);
      assertTrue(finalResult.isSuccess());
      assertEquals(7, finalResult.getValue()); // "initial".length()
    }

    @Test
    @DisplayName("should handle mixed success and failure scenarios")
    @Timeout(2)
    void shouldHandleMixedSuccessAndFailureScenarios() throws Exception {
      // First operation succeeds
      final CompletableFuture<Result<String>> firstResult = AsyncOperations
          .fromSupplier(() -> "first");

      // Second operation fails
      final RuntimeException secondException = new RuntimeException("second fails");
      final CompletableFuture<Result<String>> secondResult = AsyncOperations
          .fromSupplier(() -> {
            throw secondException;
          });

      final Result<String> first = firstResult.get(2, TimeUnit.SECONDS);
      final Result<String> second = secondResult.get(2, TimeUnit.SECONDS);

      assertAll("Mixed scenarios",
          () -> assertTrue(first.isSuccess()),
          () -> assertEquals("first", first.getValue()),
          () -> assertTrue(second.isFailure()),
          () -> assertEquals(secondException, second.getError()));
    }
  }
}