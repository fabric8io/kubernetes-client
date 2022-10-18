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
package io.fabric8.openshift.client.impl;

import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.extension.ClientAdapter;
import io.fabric8.openshift.api.model.operator.controlplane.v1alpha1.PodNetworkConnectivityCheck;
import io.fabric8.openshift.api.model.operator.controlplane.v1alpha1.PodNetworkConnectivityCheckList;
import io.fabric8.openshift.api.model.operator.v1.Authentication;
import io.fabric8.openshift.api.model.operator.v1.AuthenticationList;
import io.fabric8.openshift.api.model.operator.v1.CSISnapshotController;
import io.fabric8.openshift.api.model.operator.v1.CSISnapshotControllerList;
import io.fabric8.openshift.api.model.operator.v1.CloudCredential;
import io.fabric8.openshift.api.model.operator.v1.CloudCredentialList;
import io.fabric8.openshift.api.model.operator.v1.ClusterCSIDriver;
import io.fabric8.openshift.api.model.operator.v1.ClusterCSIDriverList;
import io.fabric8.openshift.api.model.operator.v1.ConfigList;
import io.fabric8.openshift.api.model.operator.v1.Console;
import io.fabric8.openshift.api.model.operator.v1.ConsoleList;
import io.fabric8.openshift.api.model.operator.v1.DNS;
import io.fabric8.openshift.api.model.operator.v1.DNSList;
import io.fabric8.openshift.api.model.operator.v1.DNSRecord;
import io.fabric8.openshift.api.model.operator.v1.DNSRecordList;
import io.fabric8.openshift.api.model.operator.v1.Etcd;
import io.fabric8.openshift.api.model.operator.v1.EtcdList;
import io.fabric8.openshift.api.model.operator.v1.ImagePruner;
import io.fabric8.openshift.api.model.operator.v1.ImagePrunerList;
import io.fabric8.openshift.api.model.operator.v1.IngressController;
import io.fabric8.openshift.api.model.operator.v1.IngressControllerList;
import io.fabric8.openshift.api.model.operator.v1.KubeAPIServer;
import io.fabric8.openshift.api.model.operator.v1.KubeAPIServerList;
import io.fabric8.openshift.api.model.operator.v1.KubeControllerManager;
import io.fabric8.openshift.api.model.operator.v1.KubeControllerManagerList;
import io.fabric8.openshift.api.model.operator.v1.KubeScheduler;
import io.fabric8.openshift.api.model.operator.v1.KubeSchedulerList;
import io.fabric8.openshift.api.model.operator.v1.KubeStorageVersionMigrator;
import io.fabric8.openshift.api.model.operator.v1.KubeStorageVersionMigratorList;
import io.fabric8.openshift.api.model.operator.v1.Network;
import io.fabric8.openshift.api.model.operator.v1.NetworkList;
import io.fabric8.openshift.api.model.operator.v1.OpenShiftAPIServer;
import io.fabric8.openshift.api.model.operator.v1.OpenShiftAPIServerList;
import io.fabric8.openshift.api.model.operator.v1.OpenShiftControllerManager;
import io.fabric8.openshift.api.model.operator.v1.OpenShiftControllerManagerList;
import io.fabric8.openshift.api.model.operator.v1.ServiceCA;
import io.fabric8.openshift.api.model.operator.v1.ServiceCAList;
import io.fabric8.openshift.api.model.operator.v1.ServiceCatalogAPIServer;
import io.fabric8.openshift.api.model.operator.v1.ServiceCatalogAPIServerList;
import io.fabric8.openshift.api.model.operator.v1.ServiceCatalogControllerManager;
import io.fabric8.openshift.api.model.operator.v1.ServiceCatalogControllerManagerList;
import io.fabric8.openshift.api.model.operator.v1.Storage;
import io.fabric8.openshift.api.model.operator.v1.StorageList;
import io.fabric8.openshift.api.model.operator.v1alpha1.ImageContentSourcePolicy;
import io.fabric8.openshift.api.model.operator.v1alpha1.ImageContentSourcePolicyList;
import io.fabric8.openshift.client.dsl.OpenShiftOperatorAPIGroupDSL;

public class OpenShiftOperatorAPIGroupClient extends ClientAdapter<OpenShiftOperatorAPIGroupClient>
    implements OpenShiftOperatorAPIGroupDSL {

  @Override
  public NonNamespaceOperation<Etcd, EtcdList, Resource<Etcd>> etcds() {
    return resources(Etcd.class, EtcdList.class);
  }

  @Override
  public NonNamespaceOperation<KubeStorageVersionMigrator, KubeStorageVersionMigratorList, Resource<KubeStorageVersionMigrator>> kubeStorageVersionMigrators() {
    return resources(KubeStorageVersionMigrator.class, KubeStorageVersionMigratorList.class);
  }

  @Override
  public NonNamespaceOperation<KubeControllerManager, KubeControllerManagerList, Resource<KubeControllerManager>> kubeControllerManagers() {
    return resources(KubeControllerManager.class, KubeControllerManagerList.class);
  }

  @Override
  public NonNamespaceOperation<CSISnapshotController, CSISnapshotControllerList, Resource<CSISnapshotController>> csiSnapshotControllers() {
    return resources(CSISnapshotController.class, CSISnapshotControllerList.class);
  }

  @Override
  public NonNamespaceOperation<Network, NetworkList, Resource<Network>> networks() {
    return resources(Network.class, NetworkList.class);
  }

  @Override
  public NonNamespaceOperation<KubeScheduler, KubeSchedulerList, Resource<KubeScheduler>> kubeSchedulers() {
    return resources(KubeScheduler.class, KubeSchedulerList.class);
  }

  @Override
  public NonNamespaceOperation<Console, ConsoleList, Resource<Console>> consoles() {
    return resources(Console.class, ConsoleList.class);
  }

  @Override
  public NonNamespaceOperation<ServiceCatalogControllerManager, ServiceCatalogControllerManagerList, Resource<ServiceCatalogControllerManager>> serviceCatalogControllerManagers() {
    return resources(ServiceCatalogControllerManager.class, ServiceCatalogControllerManagerList.class);
  }

  @Override
  public NonNamespaceOperation<ServiceCA, ServiceCAList, Resource<ServiceCA>> serviceCAs() {
    return resources(ServiceCA.class, ServiceCAList.class);
  }

  @Override
  public NonNamespaceOperation<ImageContentSourcePolicy, ImageContentSourcePolicyList, Resource<ImageContentSourcePolicy>> imageContentSourcePolicies() {
    return resources(ImageContentSourcePolicy.class, ImageContentSourcePolicyList.class);
  }

  @Override
  public NonNamespaceOperation<DNS, DNSList, Resource<DNS>> dnses() {
    return resources(DNS.class, DNSList.class);
  }

  @Override
  public MixedOperation<DNSRecord, DNSRecordList, Resource<DNSRecord>> dnsRecords() {
    return resources(DNSRecord.class, DNSRecordList.class);
  }

  @Override
  public NonNamespaceOperation<OpenShiftControllerManager, OpenShiftControllerManagerList, Resource<OpenShiftControllerManager>> openShiftControllerManagers() {
    return resources(OpenShiftControllerManager.class, OpenShiftControllerManagerList.class);
  }

  @Override
  public NonNamespaceOperation<OpenShiftAPIServer, OpenShiftAPIServerList, Resource<OpenShiftAPIServer>> openShiftAPIServers() {
    return resources(OpenShiftAPIServer.class, OpenShiftAPIServerList.class);
  }

  @Override
  public NonNamespaceOperation<KubeAPIServer, KubeAPIServerList, Resource<KubeAPIServer>> kubeAPIServers() {
    return resources(KubeAPIServer.class, KubeAPIServerList.class);
  }

  @Override
  public MixedOperation<IngressController, IngressControllerList, Resource<IngressController>> ingressControllers() {
    return resources(IngressController.class, IngressControllerList.class);
  }

  @Override
  public NonNamespaceOperation<ImagePruner, ImagePrunerList, Resource<ImagePruner>> imagePruners() {
    return resources(ImagePruner.class, ImagePrunerList.class);
  }

  @Override
  public MixedOperation<PodNetworkConnectivityCheck, PodNetworkConnectivityCheckList, Resource<PodNetworkConnectivityCheck>> podNetworkConnectivityChecks() {
    return resources(PodNetworkConnectivityCheck.class, PodNetworkConnectivityCheckList.class);
  }

  @Override
  public NonNamespaceOperation<ServiceCatalogAPIServer, ServiceCatalogAPIServerList, Resource<ServiceCatalogAPIServer>> serviceCatalogAPIServers() {
    return resources(ServiceCatalogAPIServer.class, ServiceCatalogAPIServerList.class);
  }

  @Override
  public NonNamespaceOperation<Storage, StorageList, Resource<Storage>> storages() {
    return resources(Storage.class, StorageList.class);
  }

  @Override
  public NonNamespaceOperation<Authentication, AuthenticationList, Resource<Authentication>> authentications() {
    return resources(Authentication.class, AuthenticationList.class);
  }

  @Override
  public NonNamespaceOperation<CloudCredential, CloudCredentialList, Resource<CloudCredential>> cloudCredentials() {
    return resources(CloudCredential.class, CloudCredentialList.class);
  }

  @Override
  public NonNamespaceOperation<ClusterCSIDriver, ClusterCSIDriverList, Resource<ClusterCSIDriver>> clusterCSIDrivers() {
    return resources(ClusterCSIDriver.class, ClusterCSIDriverList.class);
  }

  @Override
  public NonNamespaceOperation<io.fabric8.openshift.api.model.operator.v1.Config, ConfigList, Resource<io.fabric8.openshift.api.model.operator.v1.Config>> configs() {
    return resources(io.fabric8.openshift.api.model.operator.v1.Config.class, ConfigList.class);
  }

  @Override
  public OpenShiftOperatorAPIGroupClient newInstance() {
    return new OpenShiftOperatorAPIGroupClient();
  }
}
