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

import java.net.URI;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
final class Validation {

  static Result<URI> validateUri(final String uri) {
    if (uri == null || uri.trim().isEmpty()) {
      return Result.failure(new IllegalArgumentException("URI cannot be null or empty"));
    }

    try {
      final URI parsed = URI.create(uri.trim());
      if (parsed.getScheme() == null) {
        return Result.failure(new IllegalArgumentException("URI must have a scheme"));
      }
      return Result.success(parsed);
    } catch (final IllegalArgumentException e) {
      return Result.failure(new IllegalArgumentException("Invalid URI format: " + uri, e));
    }
  }

  static Result<Duration> validateTimeout(final Duration timeout) {
    if (timeout == null) {
      return Result.failure(new IllegalArgumentException("Timeout cannot be null"));
    }

    if (timeout.isNegative() || timeout.isZero()) {
      return Result.failure(new IllegalArgumentException("Timeout must be positive"));
    }

    return Result.success(timeout);
  }

  static Result<String> validateHttpMethod(@NonNull final String method) {
    if (method.trim().isEmpty()) {
      return Result.failure(new IllegalArgumentException("HTTP method cannot be empty"));
    }

    final String upperMethod = method.trim().toUpperCase();
    final List<String> validMethods = List.of("GET", "POST", "PUT", "DELETE", "PATCH", "HEAD", "OPTIONS");

    if (!validMethods.contains(upperMethod)) {
      return Result.failure(new IllegalArgumentException("Invalid HTTP method: " + method));
    }

    return Result.success(upperMethod);
  }

  static <K, V> Result<Map<K, V>> validateHeaders(final Map<K, V> headers) {
    if (headers == null) {
      return Result.failure(new IllegalArgumentException("Headers cannot be null"));
    }

    final boolean hasNullKeys = headers.keySet().stream().anyMatch(Objects::isNull);
    if (hasNullKeys) {
      return Result.failure(new IllegalArgumentException("Header keys cannot be null"));
    }

    return Result.success(headers);
  }

  static <T> Result<T> validateNotNull(final T value, final String fieldName) {
    if (value == null) {
      return Result.failure(new IllegalArgumentException(fieldName + " cannot be null"));
    }
    return Result.success(value);
  }

  static <T> Result<T> validate(final T value, @NonNull final Predicate<T> condition, final String errorMessage) {
    if (!condition.test(value)) {
      return Result.failure(new IllegalArgumentException(errorMessage));
    }
    return Result.success(value);
  }
}