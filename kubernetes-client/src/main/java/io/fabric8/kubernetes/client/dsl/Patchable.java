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

import io.fabric8.kubernetes.client.dsl.base.PatchContext;

public interface Patchable<T> {

  /**
   * Update field(s) of a resource using a JSON patch.
   * 
   * <br>WARNING: This call assumes the base object is the current one on the server.
   * It may overwrite existing changes.
   *
   * @param item item to be patched with patched values
   * @return returns deserialized version of api server response
   */
  T patch(T item);
  
  /**
   * Update field(s) of a resource using a JSON patch, using the base object
   * as the comparison for the patch.
   *
   * @param item item to be patched with patched values
   * @param item base to be compared with to generate the patch, use null for the current
   * @return returns deserialized version of api server response
   */
  T patch(T base, T item);

  /**
   * Update field(s) of a resource using strategic merge patch.
   *
   * @param patch The patch to be applied to the resource JSON file.
   * @return returns deserialized version of api server response
   */
  default T patch(String patch) {
    return patch(null, patch);
  }

  /**
   * Update field(s) of a resource using type specified in {@link PatchContext}(defaults to strategic merge if not specified).
   *
   * @param patchContext {@link PatchContext} for patch request
   * @param patch The patch to be applied to the resource JSON file.
   * @return The patch to be applied to the resource JSON file.
   */
  T patch(PatchContext patchContext, String patch);

}
