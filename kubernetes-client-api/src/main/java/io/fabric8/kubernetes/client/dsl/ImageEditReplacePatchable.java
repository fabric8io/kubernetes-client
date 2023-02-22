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

import java.util.Map;
import java.util.function.UnaryOperator;

/**
 * @deprecated will be removed in future versions
 */
@Deprecated
public interface ImageEditReplacePatchable<T> extends ImageUpdateable<T> {

  /**
   * Edit the context or current item and apply the result to trigger a rollout. It is resource dependent how the
   * new resource is applied.
   *
   * @param function
   * @return
   *
   * @deprecated client managed rollouts will be removed in future versions
   */
  @Deprecated
  T edit(UnaryOperator<T> function);

  /**
   * Mark the provided resource as paused
   *
   * @return updated resource
   *
   * @deprecated should be called prior to the timeout method
   */
  @Deprecated
  T pause();

  /**
   * Resume a paused resource. Paused resources will not be reconciled by a controller.
   * By resuming a resource, we allow it to be reconciled again.
   *
   * @return updated resource
   *
   * @deprecated should be called prior to the timeout method
   */
  @Deprecated
  T resume();

  /**
   * Restart a resource. Resource will be rollout restarted.
   *
   * @return updated resource
   *
   * @deprecated should be called prior to the timeout method
   */
  @Deprecated
  T restart();

  /**
   * Rollback to previous rollout.
   *
   * @return updated resource
   *
   * @deprecated should be called prior to the timeout method
   */
  @Deprecated
  T undo();

  /**
   * @deprecated should be called prior to the rolling method
   */
  @Deprecated
  @Override
  T updateImage(Map<String, String> containerToImageMap);

  /**
   * @deprecated should be called prior to the rolling method
   */
  @Deprecated
  @Override
  T updateImage(String image);

}
