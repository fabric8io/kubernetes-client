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
package io.fabric8.kubernetes.client.utils.internal;

import io.fabric8.kubernetes.client.KubernetesClientException;

import java.util.function.Supplier;

public class OptionalDependencyWrapper {

  private OptionalDependencyWrapper() {
  }

  /**
   * Runs the provided {@link Supplier} implementation and catches any {@link NoClassDefFoundError}
   *
   * @param supplier implementation to safely run
   * @param message to display for caught exceptions (e.g. "Base64InputStream class is provided by
   *        commons-codec"
   * @param <R> type of supplier
   * @return run object
   */
  public static <R> R wrapRunWithOptionalDependency(Supplier<R> supplier, String message) {

    try {
      return supplier.get();
    } catch (NoClassDefFoundError ex) {
      throw new KubernetesClientException(String.format(
          "%s, an optional dependency. To use this functionality you must explicitly add this dependency to the classpath.",
          message), ex);
    }
  }
}
