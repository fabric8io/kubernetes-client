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

// TODO should be renamed when deprecations are removed
public interface TimeoutImageEditReplacePatchable<T> extends
    Timeoutable, ImageEditReplacePatchable<T> {

  /**
   * Sets the timeout for each pod scaling operation during the rollout
   * <p>
   * Applies only to ReplicaSets and ReplicationControllers
   *
   * @deprecated client managed rollouts will be removed in future versions
   */
  @Deprecated
  @Override
  ImageEditReplacePatchable<T> withTimeout(long timeout, TimeUnit unit);

  /**
   * Sets the timeout for each pod scaling operation during the rollout
   * <p>
   * Applies only to ReplicaSets and ReplicationControllers
   *
   * @deprecated client managed rollouts will be removed in future versions
   */
  @Deprecated
  @Override
  ImageEditReplacePatchable<T> withTimeoutInMillis(long timeoutInMillis);

  /**
   * Mark the provided resource as paused
   *
   * @return updated resource
   */
  @Override
  T pause();

  /**
   * Resume a paused resource. Paused resources will not be reconciled by a controller.
   * By resuming a resource, we allow it to be reconciled again.
   *
   * @return updated resource
   */
  @Override
  T resume();

  /**
   * Restart a resource. Resource will be rollout restarted.
   *
   * @return updated resource
   */
  @Override
  T restart();

  /**
   * Rollback to previous rollout.
   *
   * @return updated resource
   */
  @Override
  T undo();

}
