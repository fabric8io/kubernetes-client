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
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.dsl.base.ResourceDefinitionContext;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperationsImpl;
import io.fabric8.kubernetes.client.extension.ExtensibleResource;
import io.fabric8.kubernetes.client.utils.KubernetesResourceUtil;

import java.util.function.BiFunction;

class ResourcedHasMetadataOperation<T extends HasMetadata, L extends KubernetesResourceList<T>, R extends Resource<T>>
    extends HasMetadataOperationsImpl<T, L> {

  private BiFunction<ExtensibleResource<T>, Client, R> adapter;

  public ResourcedHasMetadataOperation(OperationContext ctx, ResourceDefinitionContext resourceDefinitionContext, Class<T> type, Class<L> listType, BiFunction<ExtensibleResource<T>, Client, R> adapter) {
    super(ctx, resourceDefinitionContext, type, listType);
    this.adapter = adapter;
  }

  @Override
  protected R newResource(OperationContext context) {
    return adapter.apply(super.newInstance(context), new BaseClient(context));
  }
  
  @Override
  public HasMetadataOperationsImpl<T, L> newInstance(OperationContext context) {
    return new ResourcedHasMetadataOperation<>(context, this.rdc, type, listType, adapter);
  }
  
  public static <T extends HasMetadata, L extends KubernetesResourceList<T>, R extends Resource<T>> void register(
      Class<T> type, BiFunction<ExtensibleResource<T>, Client, R> target) {
    Handlers.register(type, (c) -> {
      return new ResourcedHasMetadataOperation<>(HasMetadataOperationsImpl.defaultContext(c), ResourceDefinitionContext.fromResourceType(type), type,
          KubernetesResourceUtil.inferListType(type), target);
    });
  }

}
