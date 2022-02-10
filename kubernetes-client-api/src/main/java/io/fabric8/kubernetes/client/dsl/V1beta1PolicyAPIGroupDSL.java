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
package io.fabric8.kubernetes.client.dsl;

import io.fabric8.kubernetes.api.model.policy.v1beta1.PodDisruptionBudget;
import io.fabric8.kubernetes.api.model.policy.v1beta1.PodDisruptionBudgetList;
import io.fabric8.kubernetes.api.model.policy.v1beta1.PodSecurityPolicy;
import io.fabric8.kubernetes.api.model.policy.v1beta1.PodSecurityPolicyList;
import io.fabric8.kubernetes.client.Client;

public interface V1beta1PolicyAPIGroupDSL extends Client {
  /**
   * DSL entrypoint for policy/v1beta1 PodDisruptionBudget
   *
   * @return {@link MixedOperation} for PodDisruptionBudget resource
   */
  MixedOperation<PodDisruptionBudget, PodDisruptionBudgetList, Resource<PodDisruptionBudget>> podDisruptionBudget();

  /**
   * DSL entrypoint for policy/v1beta1 PodSecurityPolicy
   *
   * @return {@link MixedOperation} for PodSecurityPolicy resource
   */
  NonNamespaceOperation<PodSecurityPolicy, PodSecurityPolicyList, Resource<PodSecurityPolicy>> podSecurityPolicies();
}
