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
package io.fabric8.kubernetes.client;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;

public class SharedInformerOperationsImpl<T extends HasMetadata, L extends KubernetesResourceList<T>, R extends Resource<T>> extends HasMetadataOperation<T, L, R> {
  private final boolean resourceNamespaced;

  public SharedInformerOperationsImpl(OperationContext context, boolean resourceNamespaced) {
    super(context);
    this.resourceNamespaced = resourceNamespaced;
  }

  @Override
  public boolean isResourceNamespaced() {
    return resourceNamespaced;
  }
}
