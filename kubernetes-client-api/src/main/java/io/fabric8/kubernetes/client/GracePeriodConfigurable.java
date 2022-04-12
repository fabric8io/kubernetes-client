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
package io.fabric8.kubernetes.client;

import io.fabric8.kubernetes.client.dsl.Deletable;

public interface GracePeriodConfigurable<T> extends Deletable {
  /**
   * The duration in seconds before the object should be deleted. Value must be non-negative integer.
   * The value zero indicates delete immediately. If this value is nil, the default grace period for
   * the specified type will be used. Defaults to a per object value if not specified. zero means
   * delete immediately.
   *
   * @param gracePeriodSeconds grace period integer value in seconds
   * @return the object for which grace period is configured
   */
  T withGracePeriod(long gracePeriodSeconds);
}
