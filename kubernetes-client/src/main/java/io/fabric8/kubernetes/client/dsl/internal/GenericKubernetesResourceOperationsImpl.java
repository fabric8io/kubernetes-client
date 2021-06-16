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
package io.fabric8.kubernetes.client.dsl.internal;

import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.api.model.GenericKubernetesResourceList;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.BaseOperation;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;

public class GenericKubernetesResourceOperationsImpl
  extends HasMetadataOperation<GenericKubernetesResource, GenericKubernetesResourceList, Resource<GenericKubernetesResource>> {

  private final boolean resourceNamespaced;

  public GenericKubernetesResourceOperationsImpl(OperationContext context, boolean resourceNamespaced) {
    super(context);
    this.resourceNamespaced = resourceNamespaced;
    this.type = GenericKubernetesResource.class;
    this.listType = GenericKubernetesResourceList.class;
  }

  @Override
  public BaseOperation<GenericKubernetesResource, GenericKubernetesResourceList, Resource<GenericKubernetesResource>> newInstance(OperationContext context) {
    return new GenericKubernetesResourceOperationsImpl(context, resourceNamespaced);
  }

  @Override
  public boolean isResourceNamespaced() {
    return resourceNamespaced;
  }
}
