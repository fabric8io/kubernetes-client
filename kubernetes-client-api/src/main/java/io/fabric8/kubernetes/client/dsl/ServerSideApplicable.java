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

public interface ServerSideApplicable<T> {

  /**
   * Perform a Kubernetes server-side apply operation.
   *
   * Under the hood it's an HTTP PATCH operation using the <code>application/apply-patch+yaml</code> Content-Type.
   *
   * @see <a href="https://kubernetes.io/docs/reference/using-api/server-side-apply/">Kubernetes User Guide: Server-Side
   *      Apply</a>
   * @return the patched item from the API server.
   */
  T serverSideApply();

  /**
   * FieldManager is a name associated with the actor or entity that is making these changes.
   * <p>
   * The value must be less than or 128 characters long, and only contain printable characters
   * <p>
   * the default value is "fabric8"
   *
   * @param manager
   * @return {@link ServerSideApplicable} for continued operations
   */
  ServerSideApplicable<T> fieldManager(String manager);

  /**
   * Force this request / fieldManager to take ownership over conflicting fields.
   *
   * @return {@link ServerSideApplicable} for continued operations
   */
  ServerSideApplicable<T> forceConflicts();

}
