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
