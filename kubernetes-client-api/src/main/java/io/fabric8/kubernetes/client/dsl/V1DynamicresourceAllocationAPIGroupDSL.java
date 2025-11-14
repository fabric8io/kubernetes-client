package io.fabric8.kubernetes.client.dsl;

import io.fabric8.kubernetes.api.model.resource.v1.*;

public interface V1DynamicresourceAllocationAPIGroupDSL {
  /**
   * API entrypoint for resource.k8s.io/v1 ResourceClaim
   *
   * @return {@link MixedOperation} for ResourceClaim
   */
  MixedOperation<ResourceClaim, ResourceClaimList, Resource<ResourceClaim>> resourceClaims();

  /**
   * API entrypoint for resource.k8s.io/v1 ResourceClaimTemplate
   *
   * @return {@link MixedOperation} for ResourceClaimTemplate
   */
  MixedOperation<ResourceClaimTemplate, ResourceClaimTemplateList, Resource<ResourceClaimTemplate>> resourceClaimTemplates();

  /**
   * API entrypoint for resource.k8s.io/v1 DeviceClass (cluster-scoped)
   *
   * @return {@link NonNamespaceOperation} for DeviceClass
   */
  NonNamespaceOperation<DeviceClass, DeviceClassList, Resource<DeviceClass>> deviceClasses();

  /**
   * API entrypoint for resource.k8s.io/v1 ResourceSlice (cluster-scoped)
   *
   * @return {@link NonNamespaceOperation} for ResourceSlice
   */
  NonNamespaceOperation<ResourceSlice, ResourceSliceList, Resource<ResourceSlice>> resourcesSlices();
}
