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

public interface CreateOrReplaceable<T> {

  /**
   * Creates a provided resource in a Kubernetes Cluster. If creation
   * fails with a HTTP_CONFLICT, it tries to replace resource.
   *
   * @param item to create or replace
   * @return created item returned in kubernetes api response
   */
  T createOrReplace(T item);

  T createOrReplace();
}
