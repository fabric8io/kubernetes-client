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

import io.fabric8.kubernetes.api.model.ListOptions;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;

public interface Watchable<T> {

  /**
   * Watch returns {@link Watch} interface that watches requested resource
   *
   * @param watcher Watcher interface of Kubernetes resource
   * @return watch interface {@link Watch}
   */
  Watch watch(Watcher<T> watcher);

  /**
   * Watch returns {@link Watch} interface that watches requested resource
   * <p>
   * The passed in options may be modified as a side-effect of this call.
   * <br>
   * Values that already exist at this context, such as the labels, fields,
   * and resourceVersion will be overridden on the passed in options regardless of initial values.
   *
   * @param options options available for watch operation
   * @param watcher Watcher interface of Kubernetes resource
   * @return watch interface {@link Watch}
   */
  Watch watch(ListOptions options, Watcher<T> watcher);

  /**
   * Watch returns {@link Watch} interface that watches requested resource from
   * specified resourceVersion
   *
   * @param resourceVersion resource version from where to start watch
   * @param watcher Watcher interface of Kubernetes resource
   * @deprecated Please use {@link #watch(ListOptions, Watcher)} instead, it has a parameter of resourceVersion
   * @return watch interface {@link Watch}
   */
  @Deprecated
  Watch watch(String resourceVersion, Watcher<T> watcher);

}
