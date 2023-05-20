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

import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.dsl.NamespacedInOutCreateable;
import io.fabric8.kubernetes.client.dsl.base.ResourceDefinitionContext;

public class CreateOnlyResourceOperationsImpl<I extends KubernetesResource, O extends KubernetesResource>
    extends CreateOnlyResourceOperation<I, O> implements NamespacedInOutCreateable<I, O> {

  private final ResourceDefinitionContext rdc;
  private Class<I> inputType;

  public CreateOnlyResourceOperationsImpl(Client client, ResourceDefinitionContext rdc, Class<I> inputType,
      Class<O> outputType) {
    this(HasMetadataOperationsImpl.defaultContext(client), rdc, inputType, outputType);
  }

  public CreateOnlyResourceOperationsImpl(OperationContext context, ResourceDefinitionContext rdc, Class<I> inputType,
      Class<O> outputType) {
    super(context.withApiGroupName(rdc.getGroup())
        .withApiGroupVersion(rdc.getVersion())
        .withPlural(rdc.getPlural()));
    this.inputType = inputType;
    this.type = outputType;

    this.rdc = rdc;

    // use the group / version from the context, not from the item
    // the item is allowed to differ as long as it can be parsed as the current type
    this.apiGroupName = rdc.getGroup();
    this.apiGroupVersion = rdc.getVersion();
  }

  @Override
  public boolean isResourceNamespaced() {
    return rdc.isNamespaceScoped();
  }

  @Override
  public CreateOnlyResourceOperationsImpl<I, O> inNamespace(String name) {
    return new CreateOnlyResourceOperationsImpl<>(context.withNamespace(name), rdc, inputType, type);
  }

}
