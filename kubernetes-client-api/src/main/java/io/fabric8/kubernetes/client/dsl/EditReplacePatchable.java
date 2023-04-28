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
   * Update field(s) of a resource using a JSON patch. The patch is computed against the context item.
   * <p>
   * It is the same as calling {@link #patch(PatchContext, Object)} with {@link PatchType#JSON} specified.
   * <p>
   * WARNING: If no context item is available the latest version of that resource will be used as the base
   * to compute the diff. If you did not intend for the latest version to be your base, this may overwrite
   * concurrent changes (between when you obtained your item and the current state) in an unexpected way.
   * <p>
   * Consider using edit, which allows for a known base, and a builder instead.
   * <p>
   * WARNING: For some resource types there is an attempt to make this operation more like
   * an apply by considering implicit server side state as not being part of the patch. This behavior will be
   * removed in future versions, you should instead construct the resource to be patched from a resource obtained
   * from the api server or use patch method that is tolerant to missing state, or
   * {@link ServerSideApplicable#serverSideApply()}
   * <p>
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
   * <li>{@link PatchType#JSON} - will create a JSON patch against the current item
   * <li>{@link PatchType#JSON_MERGE} - will send the serialization of the item as a JSON MERGE patch.
   * Set the resourceVersion to null to prevent optimistic locking.
   * <li>{@link PatchType#STRATEGIC_MERGE} - will send the serialization of the item as a STRATEGIC MERGE patch.
   * Set the resourceVersion to null to prevent optimistic locking.
   * <li>{@link PatchType#SERVER_SIDE_APPLY} - will send the serialization of the item as a SERVER SIDE APPLY patch.
   * You may explicitly set the {@link PatchContext#getFieldManager()} as well to override the default.
   * </ul>
   *
   * WARNING: For a JSON patch and some resource types there is an attempt to make this operation more like
   * an apply by considering implicit server side state as not being part of the patch. This behavior will be
   * removed in future versions, you should instead construct the resource to be patched from a resource obtained
   * from the api server or use patch method that is tolerant to missing state, or
   * {@link ServerSideApplicable#serverSideApply()}
   * <p>
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
   * This method has the same patching behavior as {@link #patch(PatchContext)}, with
   * {@link PatchType#JSON_MERGE} but against the status subresource.
   * <p>
   * Set the resourceVersion to null to prevent optimistic locking.
   *
   * @return updated object
   */
  T patchStatus();

  /**
   * Update field(s) of a resource using a JSON patch which will be computed using the latest
   * server state as the base.
   * <p>
   * It is the same as calling {@link #patch(PatchContext)} with {@link PatchType#JSON} specified.
   * <p>
   * WARNING: If you did not intend for the latest version to be your base, this may overwrite
   * concurrent changes (between when you obtained your item and the current state) in an unexpected way.
   * <p>
   * Consider using edit instead.
   *
   * WARNING: For some resource types there is an attempt to make this operation more like
   * an apply by considering implicit server side state as not being part of the patch. This behavior will be
   * removed in future versions, you should instead construct the resource to be patched from a resource obtained
   * from the api server or use patch method that is tolerant to missing state, or
   * {@link ServerSideApplicable#serverSideApply()}
   * <p>
   *
   * @return returns deserialized version of api server response
   */
  T patch();

  /**
   * Update field(s) of a resource using type specified in {@link PatchContext}(defaults to strategic merge if not specified).
   * <p>
   * For use when you are providing a complete object to be patched:
   * resource(item).patch(PatchContext.of(PatchType.SERVER_SIDE_APPLY))
   *
   * <ul>
   * <li>{@link PatchType#JSON} - will create a JSON patch using the latest server state as the base
   * <li>{@link PatchType#JSON_MERGE} - will send the serialization of the item as a JSON MERGE patch.
   * Set the resourceVersion to null to prevent optimistic locking.
   * <li>{@link PatchType#STRATEGIC_MERGE} - will send the serialization of the item as a STRATEGIC MERGE patch.
   * Set the resourceVersion to null to prevent optimistic locking.
   * <li>{@link PatchType#SERVER_SIDE_APPLY} - will send the serialization of the item as a SERVER SIDE APPLY patch.
   * You may explicitly set the {@link PatchContext#getFieldManager()} as well to override the default.
   * </ul>
   *
   * WARNING: For a JSON patch and some resource types there is an attempt to make this operation more like
   * an apply by considering implicit server side state as not being part of the patch. This behavior will be
   * removed in future versions, you should instead construct the resource to be patched from a resource obtained
   * from the api server or use patch method that is tolerant to missing state, or
   * {@link ServerSideApplicable#serverSideApply()}
   * <p>
   *
   * @param patchContext {@link PatchContext} for patch request
   * @return returns deserialized version of api server response
   */
  T patch(PatchContext patchContext);

}
