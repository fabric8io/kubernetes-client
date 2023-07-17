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

import io.fabric8.kubernetes.api.model.resource.v1alpha2.PodSchedulingContext;
import io.fabric8.kubernetes.api.model.resource.v1alpha2.PodSchedulingContextList;
import io.fabric8.kubernetes.api.model.resource.v1alpha2.ResourceClaim;
import io.fabric8.kubernetes.api.model.resource.v1alpha2.ResourceClaimList;
import io.fabric8.kubernetes.api.model.resource.v1alpha2.ResourceClaimTemplate;
import io.fabric8.kubernetes.api.model.resource.v1alpha2.ResourceClaimTemplateList;
import io.fabric8.kubernetes.api.model.resource.v1alpha2.ResourceClass;
import io.fabric8.kubernetes.api.model.resource.v1alpha2.ResourceClassList;
import io.fabric8.kubernetes.client.V1Alpha2DynamicResourceAllocationAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.extension.ClientAdapter;

public class V1Alpha2DynamicResourceAllocationAPIGroupClient extends
    ClientAdapter<V1Alpha2DynamicResourceAllocationAPIGroupClient> implements V1Alpha2DynamicResourceAllocationAPIGroupDSL {
  @Override
  public V1Alpha2DynamicResourceAllocationAPIGroupClient newInstance() {
    return new V1Alpha2DynamicResourceAllocationAPIGroupClient();
  }

  @Override
  public NonNamespaceOperation<ResourceClass, ResourceClassList, Resource<ResourceClass>> resourceClasses() {
    return resources(ResourceClass.class, ResourceClassList.class);
  }

  @Override
  public MixedOperation<PodSchedulingContext, PodSchedulingContextList, Resource<PodSchedulingContext>> podSchedulings() {
    return resources(PodSchedulingContext.class, PodSchedulingContextList.class);
  }

  @Override
  public MixedOperation<ResourceClaim, ResourceClaimList, Resource<ResourceClaim>> resourceClaims() {
    return resources(ResourceClaim.class, ResourceClaimList.class);
  }

  @Override
  public MixedOperation<ResourceClaimTemplate, ResourceClaimTemplateList, Resource<ResourceClaimTemplate>> resourceClaimTemplates() {
    return resources(ResourceClaimTemplate.class, ResourceClaimTemplateList.class);
  }
}
