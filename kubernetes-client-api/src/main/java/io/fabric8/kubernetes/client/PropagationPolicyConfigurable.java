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

import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.client.dsl.Deletable;

public interface PropagationPolicyConfigurable<T> extends Deletable {
  /**
   * Whether and how garbage collection will be performed.
   * Either this field or OrphanDependents may be set, but not both.
   *
   * <p>
   * The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default
   * policy.
   *
   * <p>
   * Acceptable values are:
   * <br>
   * 'Orphan' - orphan the dependents;
   * <br>
   * 'Background' - allow the garbage collector to delete the dependents in the background;
   * <br>
   * 'Foreground' - a cascading policy that deletes all dependents in the foreground.
   *
   * @param propagationPolicy propagation policy in form of string {@link DeletionPropagation}
   * @return resource
   */
  T withPropagationPolicy(DeletionPropagation propagationPolicy);
}
