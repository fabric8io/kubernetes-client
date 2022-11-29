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
import io.fabric8.openclustermanagement.api.model.discovery.v1alpha1.DiscoveredCluster;
import io.fabric8.openclustermanagement.api.model.discovery.v1alpha1.DiscoveredClusterList;
import io.fabric8.openclustermanagement.api.model.discovery.v1alpha1.DiscoveryConfig;
import io.fabric8.openclustermanagement.api.model.discovery.v1alpha1.DiscoveryConfigList;

public interface OpenClusterManagementDiscoveryAPIGroupDSL extends Client {
  /**
   * API entrypoint for DiscoveredCluster (discovery.open-cluster-management.io/v1alpha1)
   * 
   * @return {@link MixedOperation} for DiscoveredCluster
   */
  MixedOperation<DiscoveredCluster, DiscoveredClusterList, Resource<DiscoveredCluster>> discoveredClusters();

  /**
   * API entrypoint for DiscoveryConfig (discovery.open-cluster-management.io/v1alpha1)
   * 
   * @return {@link MixedOperation} for DiscoveryConfig
   */
  MixedOperation<DiscoveryConfig, DiscoveryConfigList, Resource<DiscoveryConfig>> discoveryConfigs();
}
