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
package io.fabric8.kubernetes.client.dsl;

import io.fabric8.kubernetes.api.model.resource.v1.*;
import io.fabric8.kubernetes.client.Client;

public interface V1DynamicresourceAllocationAPIGroupDSL extends Client {
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
