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
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

public interface Result<T> {

  static <T> Result<T> success(final T value) {
    return new Success<>(value);
  }

  static <T> Result<T> failure(final Throwable error) {
    return new Failure<>(error);
  }

  default boolean isSuccess() {
    return this instanceof Success;
  }

  default boolean isFailure() {
    return this instanceof Failure;
  }

  default T getValue() {
    if (this instanceof Success) {
      return ((Success<T>) this).value;
    }
    return null;
  }

  default Throwable getError() {
    if (this instanceof Failure) {
      return ((Failure<T>) this).error;
    }
    return null;
  }

  default <U> U fold(final Function<T, U> successMapper, final Function<Throwable, U> failureMapper) {
    if (this instanceof Success) {
      final Success<T> success = (Success<T>) this;
      return successMapper.apply(success.value);
    } else {
      final Failure<T> failure = (Failure<T>) this;
      return failureMapper.apply(failure.error);
    }
  }

  default <U> Result<U> map(final Function<T, U> mapper) {
    if (this instanceof Success) {
      final Success<T> success = (Success<T>) this;
      try {
        return success(mapper.apply(success.getValue()));
      } catch (final Exception e) {
        return failure(e);
      }
    } else {
      final Failure<T> failure = (Failure<T>) this;
      return failure(failure.getError());
    }
  }

  default <U> Result<U> flatMap(final Function<T, Result<U>> mapper) {
    if (this instanceof Success) {
      final Success<T> success = (Success<T>) this;
      try {
        return mapper.apply(success.getValue());
      } catch (final Exception e) {
        return failure(e);
      }
    } else {
      final Failure<T> failure = (Failure<T>) this;
      return failure(failure.getError());
    }
  }

  default Result<T> onSuccess(final Consumer<T> action) {
    if (this instanceof Success) {
      final Success<T> success = (Success<T>) this;
      action.accept(success.getValue());
    }
    return this;
  }

  default Result<T> onFailure(final Consumer<Throwable> action) {
    if (this instanceof Failure) {
      final Failure<T> failure = (Failure<T>) this;
      action.accept(failure.getError());
    }
    return this;
  }

  default Optional<T> toOptional() {
    if (this instanceof Success) {
      final Success<T> success = (Success<T>) this;
      return Optional.of(success.getValue());
    } else {
      return Optional.empty();
    }
  }

  default T orElseThrow() {
    if (this instanceof Success) {
      final Success<T> success = (Success<T>) this;
      return success.getValue();
    } else {
      final Failure<T> failure = (Failure<T>) this;
      if (failure.getError() instanceof RuntimeException) {
        throw (RuntimeException) failure.getError();
      }
      throw new RuntimeException(failure.getError());
    }
  }

  @Value
  @RequiredArgsConstructor(access = AccessLevel.PACKAGE)
  final class Success<T> implements Result<T> {
    T value;
  }

  @Value
  @RequiredArgsConstructor(access = AccessLevel.PACKAGE)
  final class Failure<T> implements Result<T> {
    @NonNull
    Throwable error;
  }
}