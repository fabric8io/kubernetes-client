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

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public interface AnyNamespaceOperation<T, L, R> extends FilterWatchListDeletable<T, L, R>,
    ItemWritableOperation<T> {

  /**
   * Indicates that modifications should not be persisted. All dry run stages will be processed. the request is still
   * processed as typical request: the fields are defaulted, the object is validated, it goes through the validation
   * admission chain, and through the mutating admission chain, and then the final object is returned to the user as
   * it normally would, without being persisted.
   *
   * @return write operations which are applicable for dry run
   * @deprecated use Resource.dryRun()
   */
  @Deprecated
  ItemWritableOperation<T> dryRun();

  /**
   * Indicates whether modifications should not be persisted or not. If enabled, All dry run stages will be processed.
   * the request is still processed as typical request: the fields are defaulted, the object is validated, it goes through
   * the validation admission chain, and through the mutating admission chain, and then the final object is returned
   * to the user as it normally would, without being persisted.
   *
   * @param isDryRun whether dry run is enabled or disabled
   * @return write operations which are applicable for dry run
   * @deprecated use Resource.dryRun()
   */
  @Deprecated
  ItemWritableOperation<T> dryRun(boolean isDryRun);

  /**
   * Delete the given items.
   *
   * @param items
   * @return true
   *
   * @deprecated use {@link KubernetesClient#resourceList(java.util.Collection)} delete instead
   *
   */
  @Deprecated
  default boolean delete(T... items) {
    return delete(Arrays.asList(items));
  }

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

  /**
   * Load from an {@link InputStream}.
   *
   * @param is The input stream.
   * @return returns de-serialized object
   */
  R load(InputStream is);

  /**
   * Load from a {@link URL}.
   *
   * @param url The url.
   * @return returns de-serialized object
   */
  R load(URL url);

  /**
   * Load from a {@link File}.
   *
   * @param file The file.
   * @return returns de-serialized object
   */
  R load(File file);

  /**
   * Load from path.
   *
   * @param path The path.
   * @return returns de-serialized object
   */
  R load(String path);

  /**
   * Provide a {@link Resource} for the given item
   *
   * @param item
   * @return the resource upon which operations can be performed
   */
  R resource(T item);

}
