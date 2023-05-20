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

package io.fabric8.kubernetes.client.impl;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.client.dsl.Namespaceable;
import io.fabric8.kubernetes.client.dsl.NamespaceableResource;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperation;
import io.fabric8.kubernetes.client.extension.ResourceAdapter;

/**
 * Provides a wrapper to namespace a resource.
 * <p>
 * {@link NamespaceableResource} is not {@link Namespaceable} to allow for future versions of the logic
 * to be consolidated.
 * <p>
 * With generic typed interface design Namespacable&lt;X&gt; and Namespaceable&lt;Y&gt; are considered incompatible no matter
 * the types for X and Y,
 * but NamespaceableX and NamespaceableY can be polymorphic. As long as there is no usage expectation
 * like instanceof Namespaceable - then it would be fine to have the non-generic versions.
 * <p>
 * The constructor and the inNamespace method determine the namespacing rules:
 * - if the item is namespaced, the resource context will use that namespace as that is not currently the default behavior of
 * withItem
 */
public class NamespaceableResourceAdapter<T extends HasMetadata> extends ResourceAdapter<T>
    implements NamespaceableResource<T> {

  protected final T item;
  protected final HasMetadataOperation<T, ?, ?> operation;

  public NamespaceableResourceAdapter(T item, HasMetadataOperation<T, ?, ?> op) {
    super(op.resource(item));
    this.operation = op;
    this.item = item;
  }

  @Override
  public Resource<T> inNamespace(String name) {
    return operation.inNamespace(name).resource(item);
  }

}
