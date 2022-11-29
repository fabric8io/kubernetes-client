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
import io.fabric8.openclustermanagement.api.model.cluster.v1.ManagedCluster;
import io.fabric8.openclustermanagement.api.model.cluster.v1.ManagedClusterList;
import io.fabric8.openclustermanagement.api.model.cluster.v1alpha1.Placement;
import io.fabric8.openclustermanagement.api.model.cluster.v1alpha1.PlacementDecision;
import io.fabric8.openclustermanagement.api.model.cluster.v1alpha1.PlacementDecisionList;
import io.fabric8.openclustermanagement.api.model.cluster.v1alpha1.PlacementList;
import io.fabric8.openclustermanagement.api.model.cluster.v1beta1.ManagedClusterSet;
import io.fabric8.openclustermanagement.api.model.cluster.v1beta1.ManagedClusterSetBinding;
import io.fabric8.openclustermanagement.api.model.cluster.v1beta1.ManagedClusterSetBindingList;
import io.fabric8.openclustermanagement.api.model.cluster.v1beta1.ManagedClusterSetList;

public interface OpenClusterManagementClustersAPIGroupDSL extends Client {
  /**
   * API entrypoint for ManagedCluster (cluster.open-cluster-management.io/v1)
   * 
   * @return {@link NonNamespaceOperation} for ManagedCluster
   */
  NonNamespaceOperation<ManagedCluster, ManagedClusterList, Resource<ManagedCluster>> managedClusters();

  /**
   * API entrypoint for ManagedClusterSet (cluster.open-cluster-management.io/v1beta1)
   * 
   * @return {@link NonNamespaceOperation} for ManagedClusterSet
   */
  NonNamespaceOperation<ManagedClusterSet, ManagedClusterSetList, Resource<ManagedClusterSet>> managedClusterSets();

  /**
   * API entrypoint for ManagedClusterSetBinding (cluster.open-cluster-management.io/v1beta1)
   * 
   * @return {@link MixedOperation} for ManagedClusterSetBinding
   */
  MixedOperation<ManagedClusterSetBinding, ManagedClusterSetBindingList, Resource<ManagedClusterSetBinding>> managedClusterSetBindings();

  /**
   * API entrypoint for Placement (cluster.open-cluster-management.io/v1alpha1)
   * 
   * @return {@link MixedOperation} for Placement
   */
  MixedOperation<Placement, PlacementList, Resource<Placement>> placements();

  /**
   * API entrypoint for PlacementDecision (cluster.open-cluster-management.io/v1alpha1)
   * 
   * @return {@link MixedOperation} for PlacementDecision
   */
  MixedOperation<PlacementDecision, PlacementDecisionList, Resource<PlacementDecision>> placementDecisions();
}
