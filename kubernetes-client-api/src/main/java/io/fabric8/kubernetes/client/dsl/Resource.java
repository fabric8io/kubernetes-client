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

import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.client.FromServerGettable;
import io.fabric8.kubernetes.client.GracePeriodConfigurable;

/**
 * Interface that describes the operation that can be done on a Kubernetes resource (e.g. Pod, Service etc).
 * This is intended to act as the common denominator of resource operations. To accommodate resources with more specialized
 * operations, this interface should be used as a base.
 *
 * @param <T> The resource type.
 */
public interface Resource<T> extends
    FromServerGettable<T>,
    Lockable<ReplaceDeletable<T>>,
    WatchAndWaitable<T>, Versionable<WatchAndWaitable<T>>,
    WritableOperation<T>,
    DryRunable<WritableOperation<T>>,
    Requirable<T>, Readiable, Informable<T> {

  /**
   * deletes dependent resources. Sets `orphanDependents` field to `false` when set `true`
   *
   * @deprecated Please Use {@link io.fabric8.kubernetes.client.PropagationPolicyConfigurable} instead. This field has been deprecated since 1.7.
   * @param enabled whether dependents should be orphaned or not.
   * @return resource
   */
  @Deprecated
  default GracePeriodConfigurable<? extends Deletable> cascading(boolean enabled) {
    if (!enabled) {
      return withPropagationPolicy(DeletionPropagation.ORPHAN);
    }
    return this;
  }

}
