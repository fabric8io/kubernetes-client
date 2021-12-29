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
package io.fabric8.openshift.client;

import io.fabric8.kubernetes.client.ClientContext;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.openshift.api.model.hive.v1.Checkpoint;
import io.fabric8.openshift.api.model.hive.v1.CheckpointList;
import io.fabric8.openshift.api.model.hive.v1.ClusterClaim;
import io.fabric8.openshift.api.model.hive.v1.ClusterClaimList;
import io.fabric8.openshift.api.model.hive.v1.ClusterDeployment;
import io.fabric8.openshift.api.model.hive.v1.ClusterDeploymentList;
import io.fabric8.openshift.api.model.hive.v1.ClusterDeprovision;
import io.fabric8.openshift.api.model.hive.v1.ClusterDeprovisionList;
import io.fabric8.openshift.api.model.hive.v1.ClusterImageSet;
import io.fabric8.openshift.api.model.hive.v1.ClusterImageSetList;
import io.fabric8.openshift.api.model.hive.v1.ClusterPool;
import io.fabric8.openshift.api.model.hive.v1.ClusterPoolList;
import io.fabric8.openshift.api.model.hive.v1.ClusterProvision;
import io.fabric8.openshift.api.model.hive.v1.ClusterProvisionList;
import io.fabric8.openshift.api.model.hive.v1.ClusterRelocate;
import io.fabric8.openshift.api.model.hive.v1.ClusterRelocateList;
import io.fabric8.openshift.api.model.hive.v1.ClusterState;
import io.fabric8.openshift.api.model.hive.v1.ClusterStateList;
import io.fabric8.openshift.api.model.hive.v1.DNSZone;
import io.fabric8.openshift.api.model.hive.v1.DNSZoneList;
import io.fabric8.openshift.api.model.hive.v1.HiveConfig;
import io.fabric8.openshift.api.model.hive.v1.HiveConfigList;
import io.fabric8.openshift.api.model.hive.v1.MachinePool;
import io.fabric8.openshift.api.model.hive.v1.MachinePoolList;
import io.fabric8.openshift.api.model.hive.v1.MachinePoolNameLease;
import io.fabric8.openshift.api.model.hive.v1.MachinePoolNameLeaseList;
import io.fabric8.openshift.api.model.hive.v1.SelectorSyncIdentityProvider;
import io.fabric8.openshift.api.model.hive.v1.SelectorSyncIdentityProviderList;
import io.fabric8.openshift.api.model.hive.v1.SelectorSyncSet;
import io.fabric8.openshift.api.model.hive.v1.SelectorSyncSetList;
import io.fabric8.openshift.api.model.hive.v1.SyncIdentityProvider;
import io.fabric8.openshift.api.model.hive.v1.SyncIdentityProviderList;
import io.fabric8.openshift.api.model.hive.v1.SyncSet;
import io.fabric8.openshift.api.model.hive.v1.SyncSetList;
import io.fabric8.openshift.client.dsl.OpenShiftHiveAPIGroupDSL;

public class OpenShiftHiveAPIGroupClient extends BaseOpenShiftClient implements OpenShiftHiveAPIGroupDSL {
  public OpenShiftHiveAPIGroupClient() {
    super();
  }

  public OpenShiftHiveAPIGroupClient(ClientContext clientContext) {
    super(clientContext);
  }

  @Override
  public MixedOperation<Checkpoint, CheckpointList, Resource<Checkpoint>> checkpoints() {
    return OpenShiftHandlers.getOperation(Checkpoint.class, CheckpointList.class, this);
  }

  @Override
  public MixedOperation<ClusterClaim, ClusterClaimList, Resource<ClusterClaim>> clusterClaims() {
    return OpenShiftHandlers.getOperation(ClusterClaim.class, ClusterClaimList.class, this);
  }

  @Override
  public MixedOperation<ClusterDeployment, ClusterDeploymentList, Resource<ClusterDeployment>> clusterDeployments() {
    return OpenShiftHandlers.getOperation(ClusterDeployment.class, ClusterDeploymentList.class, this);
  }

  @Override
  public MixedOperation<ClusterDeprovision, ClusterDeprovisionList, Resource<ClusterDeprovision>> clusterDeprovisions() {
    return OpenShiftHandlers.getOperation(ClusterDeprovision.class, ClusterDeprovisionList.class, this);
  }

  @Override
  public MixedOperation<ClusterProvision, ClusterProvisionList, Resource<ClusterProvision>> clusterProvisions() {
    return OpenShiftHandlers.getOperation(ClusterProvision.class, ClusterProvisionList.class, this);
  }

  @Override
  public NonNamespaceOperation<ClusterImageSet, ClusterImageSetList, Resource<ClusterImageSet>> clusterImageSets() {
    return OpenShiftHandlers.getOperation(ClusterImageSet.class, ClusterImageSetList.class, this);
  }

  @Override
  public MixedOperation<ClusterPool, ClusterPoolList, Resource<ClusterPool>> clusterPools() {
    return OpenShiftHandlers.getOperation(ClusterPool.class, ClusterPoolList.class, this);
  }

  @Override
  public MixedOperation<ClusterRelocate, ClusterRelocateList, Resource<ClusterRelocate>> clusterRelocates() {
    return OpenShiftHandlers.getOperation(ClusterRelocate.class, ClusterRelocateList.class, this);
  }

  @Override
  public MixedOperation<ClusterState, ClusterStateList, Resource<ClusterState>> clusterStates() {
    return OpenShiftHandlers.getOperation(ClusterState.class, ClusterStateList.class, this);
  }

  @Override
  public MixedOperation<DNSZone, DNSZoneList, Resource<DNSZone>> dnsZones() {
    return OpenShiftHandlers.getOperation(DNSZone.class, DNSZoneList.class, this);
  }

  @Override
  public NonNamespaceOperation<HiveConfig, HiveConfigList, Resource<HiveConfig>> hiveConfigs() {
    return OpenShiftHandlers.getOperation(HiveConfig.class, HiveConfigList.class, this);
  }

  @Override
  public MixedOperation<MachinePoolNameLease, MachinePoolNameLeaseList, Resource<MachinePoolNameLease>> machinePoolNameLeases() {
    return OpenShiftHandlers.getOperation(MachinePoolNameLease.class, MachinePoolNameLeaseList.class, this);
  }

  @Override
  public MixedOperation<MachinePool, MachinePoolList, Resource<MachinePool>> machinePools() {
    return OpenShiftHandlers.getOperation(MachinePool.class, MachinePoolList.class, this);
  }

  @Override
  public NonNamespaceOperation<SelectorSyncIdentityProvider, SelectorSyncIdentityProviderList, Resource<SelectorSyncIdentityProvider>> selectorSyncIdentityProviders() {
    return OpenShiftHandlers.getOperation(SelectorSyncIdentityProvider.class, SelectorSyncIdentityProviderList.class, this);
  }

  @Override
  public NonNamespaceOperation<SelectorSyncSet, SelectorSyncSetList, Resource<SelectorSyncSet>> selectorSyncSets() {
    return OpenShiftHandlers.getOperation(SelectorSyncSet.class, SelectorSyncSetList.class, this);
  }

  @Override
  public MixedOperation<SyncIdentityProvider, SyncIdentityProviderList, Resource<SyncIdentityProvider>> syncIdentityProviders() {
    return OpenShiftHandlers.getOperation(SyncIdentityProvider.class, SyncIdentityProviderList.class, this);
  }

  @Override
  public MixedOperation<SyncSet, SyncSetList, Resource<SyncSet>> syncSets() {
    return OpenShiftHandlers.getOperation(SyncSet.class, SyncSetList.class, this);
  }
}
