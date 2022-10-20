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
package io.fabric8.openclustermanagement.client.dsl;

import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.openclustermanagement.api.model.governancepolicypropagator.policy.v1.PlacementBinding;
import io.fabric8.openclustermanagement.api.model.governancepolicypropagator.policy.v1.PlacementBindingList;
import io.fabric8.openclustermanagement.api.model.governancepolicypropagator.policy.v1.Policy;
import io.fabric8.openclustermanagement.api.model.governancepolicypropagator.policy.v1.PolicyList;
import io.fabric8.openclustermanagement.api.model.governancepolicypropagator.policy.v1beta1.PolicyAutomation;
import io.fabric8.openclustermanagement.api.model.governancepolicypropagator.policy.v1beta1.PolicyAutomationList;

public interface OpenClusterManagementPolicyAPIGroupDSL extends Client {
  /**
   * API entrypoint for Policy (policy.open-cluster-management.io/v1)
   * 
   * @return {@link MixedOperation} for Policy
   */
  MixedOperation<Policy, PolicyList, Resource<Policy>> policies();

  /**
   * API entrypoint for PlacementBinding (policy.open-cluster-management.io/v1)
   * 
   * @return {@link MixedOperation} for PlacementBinding
   */
  MixedOperation<PlacementBinding, PlacementBindingList, Resource<PlacementBinding>> placementBindings();

  /**
   * API entrypoint for PolicyAutomation (policy.open-cluster-management.io/v1beta1)
   * 
   * @return {@link MixedOperation} for PolicyAutomation
   */
  MixedOperation<PolicyAutomation, PolicyAutomationList, Resource<PolicyAutomation>> policyAutomations();
}
