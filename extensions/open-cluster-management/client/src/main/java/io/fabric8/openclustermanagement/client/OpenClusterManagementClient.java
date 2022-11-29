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

import io.fabric8.kubernetes.client.Client;
import io.fabric8.openclustermanagement.client.dsl.OpenClusterManagementAgentAPIGroupDSL;
import io.fabric8.openclustermanagement.client.dsl.OpenClusterManagementAppsAPIGroupDSL;
import io.fabric8.openclustermanagement.client.dsl.OpenClusterManagementClustersAPIGroupDSL;
import io.fabric8.openclustermanagement.client.dsl.OpenClusterManagementDiscoveryAPIGroupDSL;
import io.fabric8.openclustermanagement.client.dsl.OpenClusterManagementOperatorAPIGroupDSL;
import io.fabric8.openclustermanagement.client.dsl.OpenClusterManagementPolicyAPIGroupDSL;
import io.fabric8.openclustermanagement.client.dsl.OpenClusterManagementSearchAPIGroupDSL;

public interface OpenClusterManagementClient extends Client {
  /**
   * API entrypoint for resources in apps.open-cluster-management.io apiGroup
   * 
   * @return {@link OpenClusterManagementAppsAPIGroupDSL}
   */
  OpenClusterManagementAppsAPIGroupDSL apps();

  /**
   * API entrypoint for resources in agent.open-cluster-management.io apiGroup
   * 
   * @return {@link OpenClusterManagementAgentAPIGroupDSL}
   */
  OpenClusterManagementAgentAPIGroupDSL agents();

  /**
   * API entrypoint for resources in clusters.open-cluster-management.io apiGroup
   * 
   * @return {@link OpenClusterManagementClustersAPIGroupDSL}
   */
  OpenClusterManagementClustersAPIGroupDSL clusters();

  /**
   * API entrypoint for resources in discovery.open-cluster-management.io apiGroup
   * 
   * @return {@link OpenClusterManagementDiscoveryAPIGroupDSL}
   */
  OpenClusterManagementDiscoveryAPIGroupDSL discovery();

  /**
   * API entrypoint for resources in observability.open-cluster-management.io apiGroup
   * 
   * @return {@link OpenClusterManagementObservabilityAPIGroupClient}
   */
  OpenClusterManagementObservabilityAPIGroupClient observability();

  /**
   * API entrypoint for resources in operator.open-cluster-management.io apiGroup
   * 
   * @return {@link OpenClusterManagementOperatorAPIGroupDSL}
   */
  OpenClusterManagementOperatorAPIGroupDSL operator();

  /**
   * API entrypoint for resources in policy.open-cluster-management.io apiGroup
   * 
   * @return {@link OpenClusterManagementPolicyAPIGroupDSL}
   */
  OpenClusterManagementPolicyAPIGroupDSL policy();

  /**
   * API entrypoint for resources in search.open-cluster-management.io apiGroup
   * 
   * @return {@link OpenClusterManagementSearchAPIGroupDSL}
   */
  OpenClusterManagementSearchAPIGroupDSL search();
}
