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

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Result monadic type")
class ResultTest {

  @Nested
  @DisplayName("Success creation and behavior")
  class SuccessCreationAndBehavior {

    @Test
    @DisplayName("should create successful result with value")
    void shouldCreateSuccessfulResultWithValue() {
      final String value = "test-value";
      final Result<String> result = Result.success(value);

      assertAll("Success properties",
          () -> assertTrue(result.isSuccess()),
          () -> assertFalse(result.isFailure()),
          () -> assertEquals(value, result.getValue()),
          () -> assertNull(result.getError()));
    }

    @Test
    @DisplayName("should create successful result with null value")
    void shouldCreateSuccessfulResultWithNullValue() {
      final Result<String> result = Result.success(null);

      assertAll("Success with null",
          () -> assertTrue(result.isSuccess()),
          () -> assertFalse(result.isFailure()),
          () -> assertNull(result.getValue()),
          () -> assertNull(result.getError()));
    }

    @Test
    @DisplayName("should handle complex objects as values")
    void shouldHandleComplexObjectsAsValues() {
      final TestObject testObject = new TestObject("name", 42);
      final Result<TestObject> result = Result.success(testObject);

      assertAll("Complex object success",
          () -> assertTrue(result.isSuccess()),
          () -> assertEquals(testObject, result.getValue()),
          () -> assertEquals("name", result.getValue().name),
          () -> assertEquals(42, result.getValue().value));
    }
  }

  @Nested
  @DisplayName("Failure creation and behavior")
  class FailureCreationAndBehavior {

    @Test
    @DisplayName("should create failed result with throwable")
    void shouldCreateFailedResultWithThrowable() {
      final Exception exception = new RuntimeException("test error");
      final Result<String> result = Result.failure(exception);

      assertAll("Failure properties",
          () -> assertFalse(result.isSuccess()),
          () -> assertTrue(result.isFailure()),
          () -> assertNull(result.getValue()),
          () -> assertEquals(exception, result.getError()));
    }

    @Test
    @DisplayName("should create failed result with checked exception")
    void shouldCreateFailedResultWithCheckedException() {
      final Exception exception = new Exception("checked exception");
      final Result<String> result = Result.failure(exception);

      assertAll("Checked exception failure",
          () -> assertTrue(result.isFailure()),
          () -> assertEquals(exception, result.getError()),
          () -> assertEquals("checked exception", result.getError().getMessage()));
    }

    @Test
    @DisplayName("should create failed result with custom exception")
    void shouldCreateFailedResultWithCustomException() {
      final CustomException exception = new CustomException("custom error", 500);
      final Result<String> result = Result.failure(exception);

      assertAll("Custom exception failure",
          () -> assertTrue(result.isFailure()),
          () -> assertInstanceOf(CustomException.class, result.getError()),
          () -> assertEquals(500, ((CustomException) result.getError()).errorCode));
    }
  }

  @Nested
  @DisplayName("Monadic operations - map")
  class MonadicOperationsMap {

    @Test
    @DisplayName("should map successful result value")
    void shouldMapSuccessfulResultValue() {
      final Result<Integer> result = Result.success(42);
      final Result<String> mapped = result.map(Object::toString);

      assertAll("Successful map",
          () -> assertTrue(mapped.isSuccess()),
          () -> assertEquals("42", mapped.getValue()));
    }

    @Test
    @DisplayName("should not map failed result")
    void shouldNotMapFailedResult() {
      final Exception exception = new RuntimeException("error");
      final Result<Integer> result = Result.failure(exception);
      final AtomicBoolean mapperCalled = new AtomicBoolean(false);

      final Result<String> mapped = result.map(value -> {
        mapperCalled.set(true);
        return value.toString();
      });

      assertAll("Failed map",
          () -> assertTrue(mapped.isFailure()),
          () -> assertEquals(exception, mapped.getError()),
          () -> assertFalse(mapperCalled.get()));
    }

    @Test
    @DisplayName("should handle mapper throwing exception")
    void shouldHandleMapperThrowingException() {
      final Result<Integer> result = Result.success(42);
      final RuntimeException mapperException = new RuntimeException("mapper error");

      final Result<String> mapped = result.map(value -> {
        throw mapperException;
      });

      assertAll("Mapper exception",
          () -> assertTrue(mapped.isFailure()),
          () -> assertEquals(mapperException, mapped.getError()));
    }

    @Test
    @DisplayName("should chain multiple map operations on success")
    void shouldChainMultipleMapOperationsOnSuccess() {
      final Result<Integer> result = Result.success(5);

      final Result<String> chained = result
          .map(x -> x * 2)
          .map(x -> x + 10)
          .map(Object::toString);

      assertAll("Chained map operations",
          () -> assertTrue(chained.isSuccess()),
          () -> assertEquals("20", chained.getValue()));
    }
  }

  @Nested
  @DisplayName("Monadic operations - flatMap")
  class MonadicOperationsFlatMap {

    @Test
    @DisplayName("should flatMap successful result to successful result")
    void shouldFlatMapSuccessfulResultToSuccessfulResult() {
      final Result<Integer> result = Result.success(42);

      final Result<String> flatMapped = result.flatMap(value -> Result.success("Value: " + value));

      assertAll("Successful flatMap",
          () -> assertTrue(flatMapped.isSuccess()),
          () -> assertEquals("Value: 42", flatMapped.getValue()));
    }

    @Test
    @DisplayName("should flatMap successful result to failed result")
    void shouldFlatMapSuccessfulResultToFailedResult() {
      final Result<Integer> result = Result.success(42);
      final Exception exception = new RuntimeException("flatMap error");

      final Result<String> flatMapped = result.flatMap(value -> Result.failure(exception));

      assertAll("Successful to failed flatMap",
          () -> assertTrue(flatMapped.isFailure()),
          () -> assertEquals(exception, flatMapped.getError()));
    }

    @Test
    @DisplayName("should not flatMap failed result")
    void shouldNotFlatMapFailedResult() {
      final Exception originalException = new RuntimeException("original error");
      final Result<Integer> result = Result.failure(originalException);
      final AtomicBoolean flatMapperCalled = new AtomicBoolean(false);

      final Result<String> flatMapped = result.flatMap(value -> {
        flatMapperCalled.set(true);
        return Result.success("should not be called");
      });

      assertAll("Failed flatMap",
          () -> assertTrue(flatMapped.isFailure()),
          () -> assertEquals(originalException, flatMapped.getError()),
          () -> assertFalse(flatMapperCalled.get()));
    }

    @Test
    @DisplayName("should handle flatMapper throwing exception")
    void shouldHandleFlatMapperThrowingException() {
      final Result<Integer> result = Result.success(42);
      final RuntimeException flatMapperException = new RuntimeException("flatMapper error");

      final Result<String> flatMapped = result.flatMap(value -> {
        throw flatMapperException;
      });

      assertAll("FlatMapper exception",
          () -> assertTrue(flatMapped.isFailure()),
          () -> assertEquals(flatMapperException, flatMapped.getError()));
    }

    @Test
    @DisplayName("should chain flatMap operations")
    void shouldChainFlatMapOperations() {
      final Result<Integer> result = Result.success(5);

      final Result<String> chained = result
          .flatMap(x -> Result.success(x * 2))
          .flatMap(x -> Result.success(x + 10))
          .flatMap(x -> Result.success("Result: " + x));

      assertAll("Chained flatMap operations",
          () -> assertTrue(chained.isSuccess()),
          () -> assertEquals("Result: 20", chained.getValue()));
    }
  }

  @Nested
  @DisplayName("Fold operations")
  class FoldOperations {

    @Test
    @DisplayName("should fold successful result using success mapper")
    void shouldFoldSuccessfulResultUsingSuccessMapper() {
      final Result<Integer> result = Result.success(42);

      final String folded = result.fold(
          value -> "Success: " + value,
          error -> "Error: " + error.getMessage());

      assertEquals("Success: 42", folded);
    }

    @Test
    @DisplayName("should fold failed result using failure mapper")
    void shouldFoldFailedResultUsingFailureMapper() {
      final Exception exception = new RuntimeException("test error");
      final Result<Integer> result = Result.failure(exception);

      final String folded = result.fold(
          value -> "Success: " + value,
          error -> "Error: " + error.getMessage());

      assertEquals("Error: test error", folded);
    }

    @Test
    @DisplayName("should handle fold mappers throwing exceptions")
    void shouldHandleFoldMappersThrowingExceptions() {
      final Result<Integer> successResult = Result.success(42);
      final RuntimeException mapperException = new RuntimeException("mapper error");

      assertThrows(RuntimeException.class, () -> successResult.fold(
          value -> {
            throw mapperException;
          },
          error -> "Error: " + error.getMessage()));
    }

    @Test
    @DisplayName("should fold to different types")
    void shouldFoldToDifferentTypes() {
      final Result<String> result = Result.success("123");

      final Integer folded = result.fold(
          Integer::parseInt,
          error -> -1);

      assertEquals(123, folded);
    }
  }

  @Nested
  @DisplayName("Type safety and generics")
  class TypeSafetyAndGenerics {

    @Test
    @DisplayName("should maintain type safety through transformations")
    void shouldMaintainTypeSafetyThroughTransformations() {
      final Result<String> stringResult = Result.success("hello");
      final Result<Integer> intResult = stringResult.map(String::length);
      final Result<Boolean> boolResult = intResult.map(length -> length > 3);

      assertAll("Type transformations",
          () -> assertTrue(boolResult.isSuccess()),
          () -> assertTrue(boolResult.getValue()));
    }

    @Test
    @DisplayName("should handle nested generic types")
    void shouldHandleNestedGenericTypes() {
      final Result<Result<String>> nestedResult = Result.success(Result.success("nested"));

      final Result<String> flattened = nestedResult.flatMap(Function.identity());

      assertAll("Nested generics",
          () -> assertTrue(flattened.isSuccess()),
          () -> assertEquals("nested", flattened.getValue()));
    }
  }

  private static class TestObject {
    final String name;
    final int value;

    TestObject(String name, int value) {
      this.name = name;
      this.value = value;
    }
  }

  private static class CustomException extends Exception {
    final int errorCode;

    CustomException(String message, int errorCode) {
      super(message);
      this.errorCode = errorCode;
    }
  }
}