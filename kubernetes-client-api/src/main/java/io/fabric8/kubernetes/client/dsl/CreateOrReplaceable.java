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

public interface CreateOrReplaceable<T> extends Replaceable<T> {

  /**
   * Creates a provided resource in a Kubernetes Cluster. If creation
   * fails with a HTTP_CONFLICT, it tries to replace resource.
   *
   * @return created item returned in kubernetes api response
   *
   * @deprecated please use {@link ServerSideApplicable#serverSideApply()} or attempt a create then edit/patch operation.
   * @see <a href=
   *      "https://github.com/fabric8io/kubernetes-client/blob/master/doc/FAQ.md#alternatives-to-createOrReplace-and-replace"
   *      >Migration FAQ</a>
   */
  @Deprecated
  T createOrReplace();

  /**
   * Creates an item
   *
   * @return the item from the api server
   */
  T create();
}
