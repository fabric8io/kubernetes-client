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
package io.fabric8.kubernetes.client.dsl;

import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

public interface Waitable<T, P> {

  T waitUntilReady(long amount, TimeUnit timeUnit);

  /**
   * Wait for the given condition to be true.
   * <p>
   * The processing of events will be in the IO thread, blocking operations should be avoided.
   * 
   * @param condition
   * @param amount
   * @param timeUnit
   * @return the result that passes the given condition
   */
  T waitUntilCondition(Predicate<P> condition, long amount, TimeUnit timeUnit);

}
