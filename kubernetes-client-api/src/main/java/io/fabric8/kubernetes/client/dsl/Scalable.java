package io.fabric8.kubernetes.client.dsl;

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

import io.fabric8.kubernetes.api.model.autoscaling.v1.Scale;

public interface Scalable<T> {

  /**
   * Scale the resource to given count
   *
   * @param count the desired instance count
   * @return the resource
   */
  T scale(int count);

  /**
   * Scale the resource to given count
   *
   * @param count the desired instance count
   * @param wait if true, wait for the number of instances to exist - no guarantee is made
   *        as to readiness
   * @return the resource
   * @deprecated use {@link TimeoutableScalable} instead
   */
  @Deprecated
  T scale(int count, boolean wait);

  default Scale scale() {
    return scale(null);
  }

  Scale scale(Scale scale);

}
