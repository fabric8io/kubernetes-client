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
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.client.ClientState;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.dsl.base.ResourceDefinitionContext;
import io.fabric8.kubernetes.client.utils.ApiVersionUtil;
import io.fabric8.kubernetes.internal.KubernetesDeserializer;

import static io.fabric8.kubernetes.client.utils.KubernetesResourceUtil.inferListType;

public class HasMetadataOperationsImpl<T extends HasMetadata, L extends KubernetesResourceList<T>> extends HasMetadataOperation<T, L, Resource<T>> implements MixedOperation<T, L, Resource<T>> {

  private final ResourceDefinitionContext rdc;
  
  public HasMetadataOperationsImpl(ClientState clientState, ResourceDefinitionContext rdc, Class<T> type, Class<L> listType) {
    this(defaultContext(clientState), rdc, type, listType);
  }
  
  public static OperationContext defaultContext(OperationContext context, ClientState clientState) {
    return context.withHttpClient(clientState.getHttpClient()).withConfig(clientState.getConfiguration()).withPropagationPolicy(DEFAULT_PROPAGATION_POLICY);
  }
    
  public static OperationContext defaultContext(ClientState clientState) {
    return defaultContext(new OperationContext(), clientState);
  }

  public HasMetadataOperationsImpl(OperationContext context, ResourceDefinitionContext rdc, Class<T> type, Class<L> listType) {
    super(context.withApiGroupName(rdc.getGroup())
      .withApiGroupVersion(rdc.getVersion())
      .withPlural(rdc.getPlural()), type, listType != null ? listType : (Class) inferListType(type));

    this.rdc = rdc;

    // use the group / version from the context, not from the item
    // the item is allowed to differ as long as it can be parsed as the current type
    this.apiGroupName = rdc.getGroup();
    this.apiGroupVersion = rdc.getVersion();
    this.apiVersion = ApiVersionUtil.joinApiGroupAndVersion(getAPIGroupName(), getAPIGroupVersion());

    if (!GenericKubernetesResource.class.isAssignableFrom(type)) {
      // TODO: the static nature of these registrations is problematic, 
      // we should ensure that we aren't redefining an existing type
      KubernetesDeserializer.registerCustomKind(apiVersion, kind(rdc), type);
      if (KubernetesResource.class.isAssignableFrom(this.listType)) {
        KubernetesDeserializer.registerCustomKind(this.listType.getSimpleName(), (Class<? extends KubernetesResource>) this.listType);
      }
    }
  }
  
  @Override
  protected void validateOperation(Class<T> type) {
    // don't validate
  }

  @Override
  public HasMetadataOperationsImpl<T, L> newInstance(OperationContext context) {
    return new HasMetadataOperationsImpl<>(context, rdc, type, listType);
  }

  private String kind(ResourceDefinitionContext context) {
    return context.getKind() != null ? context.getKind() : getKind();
  }

  @Override
  public boolean isResourceNamespaced() {
    return rdc.isNamespaceScoped();
  }

  public OperationContext getOperationContext() {
    return this.context;
  }
  
}
