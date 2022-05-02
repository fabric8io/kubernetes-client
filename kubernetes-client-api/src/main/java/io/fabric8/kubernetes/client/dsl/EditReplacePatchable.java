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

import io.fabric8.kubernetes.api.builder.TypedVisitor;
import io.fabric8.kubernetes.api.builder.Visitor;
import io.fabric8.kubernetes.client.dsl.base.PatchContext;
import io.fabric8.kubernetes.client.dsl.base.PatchType;

import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public interface EditReplacePatchable<T>
    extends Replaceable<T> {

  /**
   * Issues a JSON patch against the item based upon the changes made to the object returned by the function.
   *
   * <p>
   * It is generally convenient to use a Builder constructed off of the item.
   *
   * @param function to modify the item
   * @return returns deserialized version of api server response
   */
  T edit(UnaryOperator<T> function);

  /**
   * Issues a JSON patch against the item based upon the changes made to the object by the visitors.
   *
   * @param visitors to modify the Builder
   * @return returns deserialized version of api server response
   */
  T edit(Visitor... visitors);

  /**
   * Issues a JSON patch against the item based upon the changes made to the object by the visitor.
   *
   * @param visitorType to create a {@link TypedVisitor}
   * @param visitor to modify the Builder
   * @return returns deserialized version of api server response
   */
  <V> T edit(Class<V> visitorType, Visitor<V> visitor);

  /**
   * Issues a JSON patch against the item based upon the changes made by the function provided as argument
   *
   * @param function to modify the item
   * @return returns deserialized version of api server response
   */
  T accept(Consumer<T> function);

  /**
   * Update field(s) of a resource using a JSON patch.
   *
   * <br>
   * It is the same as calling {@link #patch(PatchContext, Object)} with {@link PatchType#JSON} specified.
   *
   * WARNING: This may overwrite concurrent changes (between when you obtained your item and the current state) in an unexpected
   * way.
   * Consider using edit instead or ensure you have called load or resource to define the base of your patch
   *
   * @param item to be patched with patched values
   * @return returns deserialized version of api server response
   */
  default T patch(T item) {
    return patch(PatchContext.of(PatchType.JSON), item);
  }

  /**
   * Update field(s) of a resource using type specified in {@link PatchContext}(defaults to strategic merge if not specified).
   *
   * <ul>
   * <li>{@link PatchType#JSON} - will create a JSON patch against the current item. See the note in {@link #patch(Object)}
   * about what is used for the base object.
   * <li>{@link PatchType#JSON_MERGE} - will send the serialization of the item as a JSON MERGE patch.
   * Set the resourceVersion to null to prevent optimistic locking.
   * <li>{@link PatchType#STRATEGIC_MERGE} - will send the serialization of the item as a STRATEGIC MERGE patch.
   * Set the resourceVersion to null to prevent optimistic locking.
   * <li>{@link PatchType#SERVER_SIDE_APPLY} - will send the serialization of the item as a SERVER SIDE APPLY patch.
   * You may explicitly set the {@link PatchContext#getFieldManager()} as well to override the default.
   * </ul>
   *
   * @param item to be patched with patched values
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
   * @return updated object
   */
  T patch(PatchContext patchContext, String patch);

  /**
   * Edit the status subresource
   *
   * @param function to produce a modified status
   * @return updated object
   */
  T editStatus(UnaryOperator<T> function);

  /**
   * Does a PATCH request to the /status subresource ignoring changes to anything except the status stanza.
   * <p>
   * This method has the same patching behavior as {@link #patch(PatchContext, Object)}, with
   * {@link PatchType#JSON_MERGE} but against the status subresource.
   * <p>
   * Set the resourceVersion to null to prevent optimistic locking.
   *
   * @return updated object
   */
  T patchStatus();
}
