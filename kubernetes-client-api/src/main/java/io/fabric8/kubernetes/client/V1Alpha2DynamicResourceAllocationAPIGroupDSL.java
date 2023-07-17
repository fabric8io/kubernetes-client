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

import io.fabric8.kubernetes.api.model.resource.v1alpha2.PodSchedulingContext;
import io.fabric8.kubernetes.api.model.resource.v1alpha2.PodSchedulingContextList;
import io.fabric8.kubernetes.api.model.resource.v1alpha2.ResourceClaim;
import io.fabric8.kubernetes.api.model.resource.v1alpha2.ResourceClaimList;
import io.fabric8.kubernetes.api.model.resource.v1alpha2.ResourceClaimTemplate;
import io.fabric8.kubernetes.api.model.resource.v1alpha2.ResourceClaimTemplateList;
import io.fabric8.kubernetes.api.model.resource.v1alpha2.ResourceClass;
import io.fabric8.kubernetes.api.model.resource.v1alpha2.ResourceClassList;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;

public interface V1Alpha2DynamicResourceAllocationAPIGroupDSL extends Client {
  /**
   * API entrypoint for resource.k8s.io/v1alpha1 ResourceClass
   *
   * @return {@link NonNamespaceOperation} for ResourceClass
   */
  NonNamespaceOperation<ResourceClass, ResourceClassList, Resource<ResourceClass>> resourceClasses();

  /**
   * API entrypoint for resource.k8s.io/v1alpha1 PodScheduling
   *
   * @return {@link MixedOperation} for PodScheduling
   */
  MixedOperation<PodSchedulingContext, PodSchedulingContextList, Resource<PodSchedulingContext>> podSchedulings();

  /**
   * API entrypoint for resource.k8s.io/v1alpha1 ResourceClaim
   *
   * @return {@link MixedOperation} for ResourceClaim
   */
  MixedOperation<ResourceClaim, ResourceClaimList, Resource<ResourceClaim>> resourceClaims();

  /**
   * API entrypoint for resource.k8s.io/v1alpha1 ResourceClaimTemplate
   *
   * @return {@link MixedOperation} for ResourceClaimTemplate
   */
  MixedOperation<ResourceClaimTemplate, ResourceClaimTemplateList, Resource<ResourceClaimTemplate>> resourceClaimTemplates();
}
