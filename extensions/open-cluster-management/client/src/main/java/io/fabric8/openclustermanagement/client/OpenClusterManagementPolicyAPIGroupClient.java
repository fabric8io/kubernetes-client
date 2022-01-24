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
package io.fabric8.openclustermanagement.client;

import io.fabric8.kubernetes.client.BaseClient;
import io.fabric8.kubernetes.client.ClientContext;
import io.fabric8.kubernetes.client.Handlers;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.openclustermanagement.api.model.governancepolicypropagator.policy.v1.PlacementBinding;
import io.fabric8.openclustermanagement.api.model.governancepolicypropagator.policy.v1.PlacementBindingList;
import io.fabric8.openclustermanagement.api.model.governancepolicypropagator.policy.v1.Policy;
import io.fabric8.openclustermanagement.api.model.governancepolicypropagator.policy.v1.PolicyList;
import io.fabric8.openclustermanagement.api.model.governancepolicypropagator.policy.v1beta1.PolicyAutomation;
import io.fabric8.openclustermanagement.api.model.governancepolicypropagator.policy.v1beta1.PolicyAutomationList;
import io.fabric8.openclustermanagement.client.dsl.OpenClusterManagementPolicyAPIGroupDSL;

public class OpenClusterManagementPolicyAPIGroupClient extends BaseClient implements OpenClusterManagementPolicyAPIGroupDSL {

  public OpenClusterManagementPolicyAPIGroupClient() {
    super();
  }

  public OpenClusterManagementPolicyAPIGroupClient(ClientContext clientContext) {
    super(clientContext);
  }

  @Override
  public MixedOperation<Policy, PolicyList, Resource<Policy>> policies() {
    return Handlers.getOperation(Policy.class, PolicyList.class, this);
  }

  @Override
  public MixedOperation<PlacementBinding, PlacementBindingList, Resource<PlacementBinding>> placementBindings() {
    return Handlers.getOperation(PlacementBinding.class, PlacementBindingList.class, this);
  }

  @Override
  public MixedOperation<PolicyAutomation, PolicyAutomationList, Resource<PolicyAutomation>> policyAutomations() {
    return Handlers.getOperation(PolicyAutomation.class, PolicyAutomationList.class, this);
  }
}
