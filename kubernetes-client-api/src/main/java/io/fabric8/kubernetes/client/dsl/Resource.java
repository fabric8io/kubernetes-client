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
import io.fabric8.kubernetes.client.ResourceNotFoundException;

/**
 * Interface that describes the operation that can be done on a Kubernetes resource (e.g. Pod, Service etc).
 * This is intended to act as the common denominator of resource operations. To accommodate resources with more specialized
 * operations, this interface should be used as a base.
 *
 * @param <T> The resource type.
 */
public interface Resource<T> extends
    Scalable<T>,
    FromServerGettable<T>,
    WatchAndWaitable<T>,
    WritableOperation<T>,
    DryRunable<WritableOperation<T>>,
    Informable<T> {

  /**
   * deletes dependent resources. Sets `orphanDependents` field to `false` when set `true`
   *
   * @deprecated Please Use {@link DeletableWithOptions#withPropagationPolicy(DeletionPropagation)} instead. This field has been
   *             deprecated since 1.7.
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

  /**
   * Check if the resource is ready. If no readiness check exists, this is just an existence check.
   * <p>
   * Note: for resources other than Node, Deployment, ReplicaSet, StatefulSet, Pod, ReplicationController, and DeploymentConfig
   * readiness is simply an existence check.
   * <p>
   * Also note this obtains the latest version of the resource from the server even if the context item
   * is present.
   *
   * @return true if the resource exists and is ready.
   */
  boolean isReady();

  /**
   * Perform a {@link Gettable#get()}, but throws an exception if the server resource does not exist.
   *
   * @return the item or throws an exception if the item doesn't exist.
   * @throws io.fabric8.kubernetes.client.KubernetesClientException if an error occurs
   * @throws io.fabric8.kubernetes.client.ResourceNotFoundException if resource is absent
   */
  T require() throws ResourceNotFoundException;

  ReplaceDeletable<T> lockResourceVersion();

  ReplaceDeletable<T> lockResourceVersion(String resourceVersion);

  /**
   * Get the item used to create the current operation context if available.
   *
   * @return the current item if provided via the load, resource, or resourceList method, or null if this resource was created
   *         just from a class.
   */
  T item();

}
