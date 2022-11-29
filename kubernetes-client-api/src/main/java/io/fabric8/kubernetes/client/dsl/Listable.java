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

public interface Listable<T> {
  T list();

  /**
   * List resources from APIServer.
   * 
   * @deprecated : Please use {@link #list(ListOptions)} instead
   *
   * @param limitVal number of resources to list
   * @param continueVal an offset to pick listing from
   * @return resource list
   */
  @Deprecated
  T list(Integer limitVal, String continueVal);

  /**
   * List resource from Kubernetes API server.
   * <p>
   * The passed in options may be modified as a side-effect of this call.
   * <br>
   * Values that already exist at this context, such as the labels and fields will be overridden
   * on the passed in options regardless of initial values.
   *
   * @param listOptions ListOptions is the query options to a standard REST list call.
   * @return list of resource type
   */
  T list(ListOptions listOptions);
}
