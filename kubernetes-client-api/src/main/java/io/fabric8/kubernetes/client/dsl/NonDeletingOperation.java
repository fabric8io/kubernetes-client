/*
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

import java.util.function.Function;
import java.util.function.UnaryOperator;

public interface NonDeletingOperation<T> extends
    CreateOrReplaceable<T>,
    EditReplacePatchable<T>,
    Replaceable<T>, ItemReplacable<T>,
    ItemWritableOperation<T>,
    ServerSideApplicable<T> {

  /**
   * Alternative to {@link CreateOrReplaceable#createOrReplace()}.
   * <p>
   * Will attempt a create, and if that fails will perform the conflictAction.
   * <p>
   * Most commonly the conflictAction will be NonDeletingOperation::update or NonDeletingOperation::patch,
   * but you are free to provide whatever Function suits your needs.
   *
   * @param conflictAction to be performed it the create fails with a conflict
   * @return
   */
  T createOr(Function<NonDeletingOperation<T>, T> conflictAction);

  /**
   * Removes the resource version from the current item. If the operation context was
   * created by name, and without an item, this will fetch the item from the api server first.
   *
   * @return NonDeletingOperation that may act on the unlocked item
   */
  NonDeletingOperation<T> unlock();

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
   * Provides edit, patch, and replace methods for the given subresource.
   * <p>
   * This method allows you to perform operations on any subresource of a Kubernetes resource.
   * Common subresources include "status", "scale", "ephemeralcontainers", etc.
   * <p>
   * Example usage:
   *
   * <pre>
   * {@code
   * // Update ephemeral containers subresource
   * client.pods().withName("my-pod")
   *   .subresource("ephemeralcontainers")
   *   .edit(pod -> new PodBuilder(pod)
   *     .editSpec()
   *       .addNewEphemeralContainer()
   *         .withName("debugger")
   *         .withImage("busybox")
   *       .endEphemeralContainer()
   *     .endSpec()
   *     .build());
   *
   * // Patch status subresource
   * client.pods().resource(myPod)
   *   .subresource("status")
   *   .patch();
   * }
   * </pre>
   *
   * @param subresource the name of the subresource (e.g., "status", "scale", "ephemeralcontainers")
   * @return an operation context for the specified subresource
   * @see #status()
   */
  EditReplacePatchable<T> subresource(String subresource);

  /**
   * Provides edit, patch, and replace methods for the status subresource.
   * <p>
   * This is a convenience method equivalent to {@code subresource("status")}.
   * The status subresource is used to update the status stanza of a Kubernetes resource
   * without modifying the spec or metadata.
   * <p>
   * Example usage:
   *
   * <pre>
   * {@code
   * // Update custom resource status
   * client.resources(MyCustomResource.class)
   *   .withName("my-resource")
   *   .status()
   *   .edit(resource -> {
   *     resource.setStatus(new MyCustomResourceStatus());
   *     return resource;
   *   });
   *
   * // Patch status directly
   * myResource.getStatus().setPhase("Ready");
   * client.resource(myResource)
   *   .status()
   *   .patch();
   * }
   * </pre>
   *
   * @return an operation context for the status subresource
   * @see #subresource(String)
   * @see #editStatus(UnaryOperator)
   * @see #patchStatus()
   */
  default EditReplacePatchable<T> status() {
    return subresource("status");
  }

}
