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

import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;

/**
 * Interface that describes the operation that can be done on a Kubernetes resource (e.g. Pod, Service etc).
 * This is intended to act as the common denominator of resource operations. To accomodate resources with more specialized operations, this interface should be used as a base.
 * @param <T>   The resource type.
 * @param <D>   The "Inlineable / Doneable" type of the resource.
 */
public interface Resource<T, D> extends CreateOrReplaceable<T, T, D>, CreateFromServerGettable<T, T, D>,
  CascadingEditReplacePatchDeletable<T, T, D, Boolean>,
  VersionWatchable<Watch, Watcher<T>>,
  Waitable<T>, Readiable {
}
