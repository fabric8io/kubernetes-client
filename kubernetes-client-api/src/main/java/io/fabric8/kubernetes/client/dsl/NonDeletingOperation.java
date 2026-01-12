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
   * This method allows you to perform operations on any subresource of a Kubernetes resource,
   * similar to kubectl's {@code --subresource} flag. Subresources are specialized endpoints
   * that provide additional operations beyond standard CRUD operations.
   * <p>
   * <b>Common Kubernetes Subresources:</b>
   * <ul>
   * <li><b>status</b> - Updates the status stanza independently (use {@link #status()} convenience method)</li>
   * <li><b>scale</b> - Manages replica counts for scalable resources (Deployment, ReplicaSet, StatefulSet, etc.)</li>
   * <li><b>ephemeralcontainers</b> - Manages ephemeral containers for debugging Pods</li>
   * <li><b>binding</b> - Binds Pods to Nodes (typically handled by the Kubernetes scheduler)</li>
   * <li><b>approval</b> - Approves CertificateSigningRequests (use {@link #approval()} convenience method)</li>
   * <li><b>token</b> - Requests bound service account tokens (use ServiceAccountResource#requestToken())</li>
   * <li><b>Custom subresources</b> - Defined by CustomResourceDefinitions (CRDs)</li>
   * </ul>
   * <p>
   * <b>Example usage:</b>
   *
   * <pre>
   * {@code
   * // 1. Update ephemeral containers subresource (for debugging)
   * client.pods().withName("my-pod")
   *   .subresource("ephemeralcontainers")
   *   .edit(pod -> new PodBuilder(pod)
   *     .editSpec()
   *       .addNewEphemeralContainer()
   *         .withName("debugger")
   *         .withImage("busybox:latest")
   *         .withCommand("sh")
   *       .endEphemeralContainer()
   *     .endSpec()
   *     .build());
   *
   * // 2. Patch scale subresource to change replica count
   * //    (alternative to using the Scalable interface)
   * client.apps().deployments()
   *   .inNamespace("default")
   *   .withName("my-deployment")
   *   .subresource("scale")
   *   .patch(PatchContext.of(PatchType.JSON_MERGE),
   *     "{\"spec\":{\"replicas\":5}}");
   *
   * // 3. Get current scale information
   * Deployment deployment = client.apps().deployments()
   *   .inNamespace("default")
   *   .withName("my-deployment")
   *   .subresource("scale")
   *   .get();
   * Integer currentReplicas = deployment.getSpec().getReplicas();
   *
   * // 4. Update status subresource (prefer using status() method)
   * client.pods().resource(myPod)
   *   .subresource("status")
   *   .patch();
   *
   * // 5. Work with custom subresources on CRDs
   * client.resources(MyCustomResource.class)
   *   .inNamespace("default")
   *   .withName("my-resource")
   *   .subresource("my-custom-subresource")
   *   .edit(resource -> {
   *     // Modify the custom subresource
   *     return updatedResource;
   *   });
   * }
   * </pre>
   * <p>
   * <b>Note:</b> For common operations, consider using specialized methods or interfaces:
   * <ul>
   * <li>For status updates, use {@link #status()}, {@link #editStatus(UnaryOperator)}, or {@link #patchStatus()}</li>
   * <li>For scaling operations, use {@link io.fabric8.kubernetes.client.dsl.Scalable} interface methods</li>
   * <li>For Pod ephemeral containers, use {@link io.fabric8.kubernetes.client.dsl.PodResource#ephemeralContainers()}</li>
   * <li>For CertificateSigningRequest approval/denial, use {@link #approval()}</li>
   * </ul>
   *
   * @param subresource the name of the subresource (e.g., "status", "scale", "ephemeralcontainers", "binding", "approval")
   * @return an operation context for the specified subresource that supports edit, patch, and replace operations
   * @see #status()
   * @see #approval()
   * @see io.fabric8.kubernetes.client.dsl.Scalable
   * @see <a href="https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-uris">Kubernetes API Concepts - Subresources</a>
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

  /**
   * Provides edit, patch, and replace methods for the approval subresource.
   * <p>
   * This is a convenience method equivalent to {@code subresource("approval")}.
   * The approval subresource is primarily used with CertificateSigningRequests to approve
   * or deny certificate requests. When you update the approval subresource, you modify the
   * conditions in the status to indicate whether the request is approved or denied.
   * <p>
   * Example usage:
   *
   * <pre>
   * {@code
   * // Approve a CertificateSigningRequest
   * client.certificates().v1().certificateSigningRequests()
   *   .withName("my-csr")
   *   .approval()
   *   .edit(csr -> new CertificateSigningRequestBuilder(csr)
   *     .editStatus()
   *       .addNewCondition()
   *         .withType("Approved")
   *         .withStatus("True")
   *         .withReason("ApprovedByAdmin")
   *         .withMessage("This certificate was approved by administrator")
   *       .endCondition()
   *     .endStatus()
   *     .build());
   *
   * // Deny a CertificateSigningRequest
   * client.certificates().v1().certificateSigningRequests()
   *   .withName("my-csr")
   *   .approval()
   *   .edit(csr -> new CertificateSigningRequestBuilder(csr)
   *     .editStatus()
   *       .addNewCondition()
   *         .withType("Denied")
   *         .withStatus("True")
   *         .withReason("DeniedByPolicy")
   *         .withMessage("Certificate request does not meet security policy")
   *       .endCondition()
   *     .endStatus()
   *     .build());
   * }
   * </pre>
   *
   * @return an operation context for the approval subresource
   * @see #subresource(String)
   */
  default EditReplacePatchable<T> approval() {
    return subresource("approval");
  }



}
