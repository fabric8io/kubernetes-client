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

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;
import io.fabric8.kubernetes.client.dsl.base.ResourceDefinitionContext;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperationsImpl;
import io.fabric8.kubernetes.client.utils.KubernetesResourceUtil;
import io.fabric8.kubernetes.client.utils.Utils;
import okhttp3.OkHttpClient;

import java.lang.reflect.InvocationTargetException;
import java.util.function.BiFunction;

class ResourceHandlerImpl<T extends HasMetadata, V extends VisitableBuilder<T, V>> implements ResourceHandler<T, V> {
  
  private final ResourceDefinitionContext context;
  private final Class<T> type;
  private final Class<V> builderClass;
  private final Class<? extends KubernetesResourceList<T>> defaultListClass;
  private final BiFunction<OkHttpClient, Config, HasMetadataOperation<T, ?, Resource<T>>> operationConstructor;
  
  ResourceHandlerImpl(Class<T> type, BiFunction<OkHttpClient, Config, HasMetadataOperation<T, ?, Resource<T>>> operationConstructor) {
    this.type = type;
    this.context = ResourceDefinitionContext.fromResourceType(type);
    this.builderClass = KubernetesResourceUtil.inferBuilderType(type);
    this.defaultListClass = (Class<? extends KubernetesResourceList<T>>) KubernetesResourceUtil.inferListType(type);
    this.operationConstructor = operationConstructor;
  }
  
  ResourceHandlerImpl(Class<T> type, Class<? extends KubernetesResourceList<T>> listClass, ResourceDefinitionContext context) {
    this.type = type;
    this.context = context;
    this.defaultListClass = listClass;
    this.builderClass = null;
    this.operationConstructor = null;
  }
  
  @Override
  public V edit(T item) {
    if (this.builderClass == null) {
      throw new KubernetesClientException(String.format("Cannot edit %s with visitors, no builder was found", type.getName()));
    }
    try {
      return this.builderClass.getDeclaredConstructor(item.getClass()).newInstance(item);
    } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
        | NoSuchMethodException | SecurityException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  @Override
  public <L extends KubernetesResourceList<T>> HasMetadataOperation<T, L, Resource<T>> operation(OkHttpClient client, Config config, Class<L> listType) {
    if (operationConstructor != null) {
      if (listType != null && !listType.isAssignableFrom(defaultListClass)) {
        throw new IllegalArgumentException(String.format("Handler type %s with list %s not compatible with %s", type, defaultListClass.getName(), listType.getName()));
      }
      return (HasMetadataOperation<T, L, Resource<T>>) operationConstructor.apply(client, config);
    }
    return new HasMetadataOperationsImpl<>(client, config, context, type, (Class)Utils.getNonNullOrElse(listType, defaultListClass));
  }
  
  @Override
  public boolean hasOperation() {
    return operationConstructor != null;
  }
  
}
