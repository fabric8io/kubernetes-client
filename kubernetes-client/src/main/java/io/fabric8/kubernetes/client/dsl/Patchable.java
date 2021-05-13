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
import io.fabric8.kubernetes.client.dsl.base.PatchType;

public interface Patchable<T> {

  /**
   * Update field(s) of a resource using a JSON patch.
   *
   * <br>It is the same as calling {@link #patch(PatchContext, Object)} with {@link PatchType#JSON} specified.
   *
   * WARNING: This may overwrite concurrent changes (between when you obtained your item and the current state) in an unexpected way.
   * Consider using edit instead.
   *
   * @param item item to be patched with patched values
   * @return returns deserialized version of api server response
   */
  default T patch(T item) {
    return patch(new PatchContext.Builder().withPatchType(PatchType.JSON).build(), item);
  }

  /**
   * Update field(s) of a resource using type specified in {@link PatchContext}(defaults to strategic merge if not specified).
   *
   * <ul>
   * <li>{@link PatchType#JSON} - will create a JSON patch against the current item.
   * WARNING: This may overwrite concurrent changes (between when you obtained your item and the current state) in an unexpected way.
   * Consider using edit instead.
   * <li>{@link PatchType#JSON_MERGE} - will send the serialization of the item as a JSON MERGE patch.
   * Set the resourceVersion to null to prevent optimistic locking.
   * <li>{@link PatchType#STRATEGIC_MERGE} - will send the serialization of the item as a STRATEGIC MERGE patch.
   * Set the resourceVersion to null to prevent optimistic locking.
   * </ul>
   *
   * @param item item to be patched with patched values
   * @param patchContext {@link PatchContext} for patch request
   * @return returns deserialized version of api server response
   */
  T patch(PatchContext patchContext, T item);

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
