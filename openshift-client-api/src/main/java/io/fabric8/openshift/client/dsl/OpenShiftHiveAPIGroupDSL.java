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
package io.fabric8.openshift.client.dsl;

import io.fabric8.kubernetes.client.Client;
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

public interface OpenShiftHiveAPIGroupDSL extends Client {
  MixedOperation<Checkpoint, CheckpointList, Resource<Checkpoint>> checkpoints();

  MixedOperation<ClusterClaim, ClusterClaimList, Resource<ClusterClaim>> clusterClaims();

  MixedOperation<ClusterDeployment, ClusterDeploymentList, Resource<ClusterDeployment>> clusterDeployments();

  MixedOperation<ClusterDeprovision, ClusterDeprovisionList, Resource<ClusterDeprovision>> clusterDeprovisions();

  MixedOperation<ClusterProvision, ClusterProvisionList, Resource<ClusterProvision>> clusterProvisions();

  NonNamespaceOperation<ClusterImageSet, ClusterImageSetList, Resource<ClusterImageSet>> clusterImageSets();

  MixedOperation<ClusterPool, ClusterPoolList, Resource<ClusterPool>> clusterPools();

  MixedOperation<ClusterRelocate, ClusterRelocateList, Resource<ClusterRelocate>> clusterRelocates();

  MixedOperation<ClusterState, ClusterStateList, Resource<ClusterState>> clusterStates();

  MixedOperation<DNSZone, DNSZoneList, Resource<DNSZone>> dnsZones();

  NonNamespaceOperation<HiveConfig, HiveConfigList, Resource<HiveConfig>> hiveConfigs();

  MixedOperation<MachinePoolNameLease, MachinePoolNameLeaseList, Resource<MachinePoolNameLease>> machinePoolNameLeases();

  MixedOperation<MachinePool, MachinePoolList, Resource<MachinePool>> machinePools();

  NonNamespaceOperation<SelectorSyncIdentityProvider, SelectorSyncIdentityProviderList, Resource<SelectorSyncIdentityProvider>> selectorSyncIdentityProviders();

  NonNamespaceOperation<SelectorSyncSet, SelectorSyncSetList, Resource<SelectorSyncSet>> selectorSyncSets();

  MixedOperation<SyncIdentityProvider, SyncIdentityProviderList, Resource<SyncIdentityProvider>> syncIdentityProviders();

  MixedOperation<SyncSet, SyncSetList, Resource<SyncSet>> syncSets();
}
