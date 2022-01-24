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
import io.fabric8.openclustermanagement.client.dsl.OpenClusterManagementClustersAPIGroupDSL;

public class OpenClusterManagementClustersAPIGroupClient extends BaseClient implements OpenClusterManagementClustersAPIGroupDSL {

  public OpenClusterManagementClustersAPIGroupClient() {
    super();
  }

  public OpenClusterManagementClustersAPIGroupClient(ClientContext clientContext) {
    super(clientContext);
  }

  @Override
  public NonNamespaceOperation<ManagedCluster, ManagedClusterList, Resource<ManagedCluster>> managedClusters() {
    return Handlers.getOperation(ManagedCluster.class, ManagedClusterList.class, this);
  }

  @Override
  public NonNamespaceOperation<ManagedClusterSet, ManagedClusterSetList, Resource<ManagedClusterSet>> managedClusterSets() {
    return Handlers.getOperation(ManagedClusterSet.class, ManagedClusterSetList.class, this);
  }

  @Override
  public MixedOperation<ManagedClusterSetBinding, ManagedClusterSetBindingList, Resource<ManagedClusterSetBinding>> managedClusterSetBindings() {
    return Handlers.getOperation(ManagedClusterSetBinding.class, ManagedClusterSetBindingList.class, this);
  }

  @Override
  public MixedOperation<Placement, PlacementList, Resource<Placement>> placements() {
    return Handlers.getOperation(Placement.class, PlacementList.class, this);
  }

  @Override
  public MixedOperation<PlacementDecision, PlacementDecisionList, Resource<PlacementDecision>> placementDecisions() {
    return Handlers.getOperation(PlacementDecision.class, PlacementDecisionList.class, this);
  }
}
