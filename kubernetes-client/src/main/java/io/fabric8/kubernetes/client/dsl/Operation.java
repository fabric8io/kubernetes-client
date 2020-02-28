/**
 * Copyright (C) 2015 Fabric8 Authors.
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

import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;

/**
 * The entry point to client operations.
 * @param <T>   The Kubernetes resource type.
 * @param <L>   The list variant of the Kubernetes resource type.
 * @param <D>   The doneable variant of the Kubernetes resource type.
 * @param <R>   The resource operations.
 */
public interface Operation<T, L, D, R>
  extends
  AnyNamespaceable<FilterWatchListMultiDeletable<T, L, Boolean, Watch, Watcher<T>>>,
  Namespaceable<NonNamespaceOperation<T, L, D, R>>,
  FilterWatchListMultiDeletable<T, L, Boolean, Watch, Watcher<T>>,
  Loadable<R> {
}
