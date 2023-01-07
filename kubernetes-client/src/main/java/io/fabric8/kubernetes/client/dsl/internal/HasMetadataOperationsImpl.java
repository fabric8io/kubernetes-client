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

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.ResourceDefinitionContext;
import io.fabric8.kubernetes.client.impl.BaseClient;
import io.fabric8.kubernetes.client.utils.Utils;

import static io.fabric8.kubernetes.client.utils.KubernetesResourceUtil.inferListType;

public class HasMetadataOperationsImpl<T extends HasMetadata, L extends KubernetesResourceList<T>>
    extends HasMetadataOperation<T, L, Resource<T>> implements MixedOperation<T, L, Resource<T>> {

  protected final ResourceDefinitionContext rdc;

  public HasMetadataOperationsImpl(Client client, ResourceDefinitionContext rdc, Class<T> type, Class<L> listType) {
    this(defaultContext(client), rdc, type, listType);
  }

  public static OperationContext defaultContext(Client client) {
    return Utils.getNonNullOrElse(
        client.adapt(BaseClient.class).getOperationContext(),
        new OperationContext().withClient(client).withPropagationPolicy(DEFAULT_PROPAGATION_POLICY));
  }

  public HasMetadataOperationsImpl(OperationContext context, ResourceDefinitionContext rdc, Class<T> type, Class<L> listType) {
    super(context.withApiGroupName(rdc.getGroup())
        .withApiGroupVersion(rdc.getVersion())
        .withPlural(rdc.getPlural()), type, listType != null ? listType : (Class) inferListType(type));

    this.rdc = rdc;
  }

  @Override
  public HasMetadataOperationsImpl<T, L> newInstance(OperationContext context) {
    return new HasMetadataOperationsImpl<>(context, rdc, type, listType);
  }

  @Override
  public boolean isResourceNamespaced() {
    return rdc.isNamespaceScoped();
  }

  public OperationContext getOperationContext() {
    return this.context;
  }

}
