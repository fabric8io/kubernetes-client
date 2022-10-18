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
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.client.dsl.base.ResourceDefinitionContext;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.OperationContext;
import io.fabric8.kubernetes.client.extension.ExtensibleResourceAdapter;

// TODO: add type checking of the resource class
// here that would be adapter.getClass, in the base HasMetadataOperationsImpl it would be this.getClass()
// on a call to resources(class, class, class) we can check to see if that class is an instance of the requested resource class
class ResourcedHasMetadataOperation<T extends HasMetadata, L extends KubernetesResourceList<T>>
    extends HasMetadataOperationsImpl<T, L> {

  private ExtensibleResourceAdapter<T> adapter;

  public ResourcedHasMetadataOperation(OperationContext ctx, ResourceDefinitionContext resourceDefinitionContext, Class<T> type,
      Class<L> listType, ExtensibleResourceAdapter<T> adapter) {
    super(ctx, resourceDefinitionContext, type, listType);
    this.adapter = adapter;
  }

  @Override
  protected ExtensibleResourceAdapter<T> newResource(OperationContext context) {
    ExtensibleResourceAdapter<T> result = adapter.newInstance();
    result.init(super.newInstance(context), context.getClient());
    return result;
  }

  @Override
  public HasMetadataOperationsImpl<T, L> newInstance(OperationContext context) {
    return new ResourcedHasMetadataOperation<>(context, this.rdc, type, listType, adapter);
  }

}
