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

import io.fabric8.kubernetes.client.KubernetesClient;

import java.util.List;

public interface FilterWatchListMultiDeletable<T, L, R> extends FilterWatchListDeletable<T, L, R>, Deletable {

  /**
   * Delete the given item.
   *
   * @param item to delete
   * @return false if the item is not found
   *
   */
  boolean delete(T item);

  /**
   * Delete the given items.
   *
   * @param items
   * @return true
   *
   * @deprecated use {@link KubernetesClient#resourceList(java.util.Collection)} delete instead
   */
  @Deprecated
  boolean delete(List<T> items);

}
