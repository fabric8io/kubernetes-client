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
package io.fabric8.mockwebserver;

public class MockServerException extends RuntimeException {

  private static final long serialVersionUID = 2158577731194403856L;

  public MockServerException(String message) {
    super(message);
  }

  public MockServerException(String message, Throwable cause) {
    super(message, cause);
  }

  /**
   * Wraps the provided {@link Throwable} in a MockServerException in case it's checked exception.
   *
   * <p>
   * For RuntimeException instances, the original exception is returned.
   *
   * @param cause Throwable to wrap.
   * @return the original exception in case it's unchecked, or a MockServerException wrapping it.
   */
  public static RuntimeException launderThrowable(Throwable cause) {
    return launderThrowable("An error has occurred.", cause);
  }

  /**
   * Wraps the provided {@link Throwable} in a MockServerException in case it's checked exception.
   *
   * <p>
   * For RuntimeException instances, the original exception is returned.
   *
   * @param message Message to use for the exception.
   * @param cause Throwable to wrap.
   * @return the original exception in case it's unchecked, or a MockServerException wrapping it.
   */
  public static RuntimeException launderThrowable(String message, Throwable cause) {
    if (cause instanceof RuntimeException) {
      return (RuntimeException) cause;
    } else if (cause instanceof Error) {
      throw (Error) cause;
    } else if (cause instanceof InterruptedException) {
      Thread.currentThread().interrupt();
    }
    throw new MockServerException(message, cause);
  }
}
