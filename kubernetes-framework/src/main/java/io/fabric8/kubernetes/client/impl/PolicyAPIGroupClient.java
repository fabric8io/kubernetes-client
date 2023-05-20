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

import io.fabric8.kubernetes.api.model.policy.v1beta1.PodDisruptionBudget;
import io.fabric8.kubernetes.api.model.policy.v1beta1.PodDisruptionBudgetList;
import io.fabric8.kubernetes.api.model.policy.v1beta1.PodSecurityPolicy;
import io.fabric8.kubernetes.api.model.policy.v1beta1.PodSecurityPolicyList;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.PolicyAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.V1PolicyAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.V1beta1PolicyAPIGroupDSL;
import io.fabric8.kubernetes.client.extension.ClientAdapter;

public class PolicyAPIGroupClient extends ClientAdapter<PolicyAPIGroupClient> implements PolicyAPIGroupDSL {

  @Override
  public MixedOperation<PodDisruptionBudget, PodDisruptionBudgetList, Resource<PodDisruptionBudget>> podDisruptionBudget() {
    return resources(PodDisruptionBudget.class, PodDisruptionBudgetList.class);
  }

  @Override
  public MixedOperation<PodSecurityPolicy, PodSecurityPolicyList, Resource<PodSecurityPolicy>> podSecurityPolicies() {
    return resources(PodSecurityPolicy.class, PodSecurityPolicyList.class);
  }

  @Override
  public V1PolicyAPIGroupDSL v1() {
    return adapt(V1PolicyAPIGroupClient.class);
  }

  @Override
  public V1beta1PolicyAPIGroupDSL v1beta1() {
    return adapt(V1beta1PolicyAPIGroupClient.class);
  }

  @Override
  public PolicyAPIGroupClient newInstance() {
    return new PolicyAPIGroupClient();
  }
}
