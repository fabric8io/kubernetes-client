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
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.openclustermanagement.api.model.multiclusterhub.operator.v1.MultiClusterHub;
import io.fabric8.openclustermanagement.api.model.multiclusterhub.operator.v1.MultiClusterHubList;
import io.fabric8.openclustermanagement.api.model.operator.v1.ClusterManager;
import io.fabric8.openclustermanagement.api.model.operator.v1.ClusterManagerList;
import io.fabric8.openclustermanagement.api.model.operator.v1.Klusterlet;
import io.fabric8.openclustermanagement.api.model.operator.v1.KlusterletList;

public interface OpenClusterManagementOperatorAPIGroupDSL extends Client {
  /**
   * API entrypoint for MultiClusterHub (operator.open-cluster-management.io/v1)
   * 
   * @return {@link MixedOperation} for MultiClusterHub
   */
  MixedOperation<MultiClusterHub, MultiClusterHubList, Resource<MultiClusterHub>> multiClusterHubs();

  /**
   * API entrypoint for Klusterlet (operator.open-cluster-management.io/v1)
   * 
   * @return {@link NonNamespaceOperation} for Klusterlet
   */
  NonNamespaceOperation<Klusterlet, KlusterletList, Resource<Klusterlet>> klusterlets();

  /**
   * API entrypoint for ClusterManager (operator.open-cluster-management.io/v1)
   * 
   * @return {@link NonNamespaceOperation} for ClusterManager
   */
  NonNamespaceOperation<ClusterManager, ClusterManagerList, Resource<ClusterManager>> clusterManagers();
}
