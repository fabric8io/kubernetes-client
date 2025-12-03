/*
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

import io.fabric8.kubernetes.api.model.resource.v1.*;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.V1DynamicresourceAllocationAPIGroupDSL;
import io.fabric8.kubernetes.client.extension.ClientAdapter;

public class V1DynamicResourceAllocationAPIGroupClient extends
    ClientAdapter<V1DynamicResourceAllocationAPIGroupClient> implements V1DynamicresourceAllocationAPIGroupDSL {
  @Override
  public V1DynamicResourceAllocationAPIGroupClient newInstance() {
    return new V1DynamicResourceAllocationAPIGroupClient();
  }

  @Override
  public MixedOperation<ResourceClaim, ResourceClaimList, Resource<ResourceClaim>> resourceClaims() {
    return resources(ResourceClaim.class, ResourceClaimList.class);
  }

  @Override
  public MixedOperation<ResourceClaimTemplate, ResourceClaimTemplateList, Resource<ResourceClaimTemplate>> resourceClaimTemplates() {
    return resources(ResourceClaimTemplate.class, ResourceClaimTemplateList.class);
  }

  @Override
  public NonNamespaceOperation<DeviceClass, DeviceClassList, Resource<DeviceClass>> deviceClasses() {
    return resources(DeviceClass.class, DeviceClassList.class);
  }

  @Override
  public NonNamespaceOperation<ResourceSlice, ResourceSliceList, Resource<ResourceSlice>> resourcesSlices() {
    return resources(ResourceSlice.class, ResourceSliceList.class);
  }
}
