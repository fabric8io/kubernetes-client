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

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperation;

public interface ResourceHandler<T extends HasMetadata, V extends VisitableBuilder<T, V>> {

  /**
   * Edit the specified resource.
   * 
   * @param item The resource to edit.
   * @return The resource editor.
   */
  V edit(T item);

  /**
   * Create the operation support for the current resource
   * 
   * @param client The client state
   * @param listType The list type
   * @return The {@link HasMetadataOperation}
   */
  <L extends KubernetesResourceList<T>> HasMetadataOperation<T, L, Resource<T>> operation(Client client, Class<L> listType);

  /**
   * @return true if there is a specialized operation associated with this handler
   */
  boolean hasOperation();

}
