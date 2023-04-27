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

package io.fabric8.kubernetes.client.http;

import java.util.concurrent.CompletableFuture;

/**
 * A simplified java.util.concurrent.Flow.Subscription and a future tracking done.
 * <br>
 * The body should be consumed until the end or cancelled.
 */
public interface AsyncBody {
  /**
   * Called to deliver results to the {@link AsyncBody.Consumer}
   */
  void consume();

  /**
   * Tracks the completion of the body.
   *
   * @return the future
   */
  CompletableFuture<Void> done();

  void cancel();

  /**
   * A functional interface for consuming async result bodies
   */
  @FunctionalInterface
  interface Consumer<T> {
    void consume(T value, AsyncBody asyncBody) throws Exception;

    default <U> U unwrap(Class<U> target) {
      if (this.getClass().equals(target)) {
        return (U) this;
      }
      return null;
    }

  }
}
