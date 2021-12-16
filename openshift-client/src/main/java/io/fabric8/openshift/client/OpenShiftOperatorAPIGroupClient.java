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

public class OpenShiftOperatorAPIGroupClient extends BaseOpenShiftClient implements OpenShiftOperatorAPIGroupDSL {
  public OpenShiftOperatorAPIGroupClient() {
    super();
  }

  public OpenShiftOperatorAPIGroupClient(ClientContext clientContext) {
    super(clientContext);
  }

  @Override
  public NonNamespaceOperation<Etcd, EtcdList, Resource<Etcd>> etcds() {
    return OpenShiftHandlers.getOperation(Etcd.class, EtcdList.class, this);
  }

  @Override
  public NonNamespaceOperation<KubeStorageVersionMigrator, KubeStorageVersionMigratorList, Resource<KubeStorageVersionMigrator>> kubeStorageVersionMigrators() {
    return OpenShiftHandlers.getOperation(KubeStorageVersionMigrator.class, KubeStorageVersionMigratorList.class, this);
  }

  @Override
  public NonNamespaceOperation<KubeControllerManager, KubeControllerManagerList, Resource<KubeControllerManager>> kubeControllerManagers() {
    return OpenShiftHandlers.getOperation(KubeControllerManager.class, KubeControllerManagerList.class, this);
  }

  @Override
  public NonNamespaceOperation<CSISnapshotController, CSISnapshotControllerList, Resource<CSISnapshotController>> csiSnapshotControllers() {
    return OpenShiftHandlers.getOperation(CSISnapshotController.class, CSISnapshotControllerList.class, this);
  }

  @Override
  public NonNamespaceOperation<Network, NetworkList, Resource<Network>> networks() {
    return OpenShiftHandlers.getOperation(Network.class, NetworkList.class, this);
  }

  @Override
  public NonNamespaceOperation<KubeScheduler, KubeSchedulerList, Resource<KubeScheduler>> kubeSchedulers() {
    return OpenShiftHandlers.getOperation(KubeScheduler.class, KubeSchedulerList.class, this);
  }

  @Override
  public NonNamespaceOperation<Console, ConsoleList, Resource<Console>> consoles() {
    return OpenShiftHandlers.getOperation(Console.class, ConsoleList.class, this);
  }

  @Override
  public NonNamespaceOperation<ServiceCatalogControllerManager, ServiceCatalogControllerManagerList, Resource<ServiceCatalogControllerManager>> serviceCatalogControllerManagers() {
    return OpenShiftHandlers.getOperation(ServiceCatalogControllerManager.class, ServiceCatalogControllerManagerList.class, this);
  }

  @Override
  public NonNamespaceOperation<ServiceCA, ServiceCAList, Resource<ServiceCA>> serviceCAs() {
    return OpenShiftHandlers.getOperation(ServiceCA.class, ServiceCAList.class, this);
  }

  @Override
  public NonNamespaceOperation<ImageContentSourcePolicy, ImageContentSourcePolicyList, Resource<ImageContentSourcePolicy>> imageContentSourcePolicies() {
    return OpenShiftHandlers.getOperation(ImageContentSourcePolicy.class, ImageContentSourcePolicyList.class, this);
  }

  @Override
  public NonNamespaceOperation<DNS, DNSList, Resource<DNS>> dnses() {
    return OpenShiftHandlers.getOperation(DNS.class, DNSList.class, this);
  }

  @Override
  public MixedOperation<DNSRecord, DNSRecordList, Resource<DNSRecord>> dnsRecords() {
    return OpenShiftHandlers.getOperation(DNSRecord.class, DNSRecordList.class, this);
  }

  @Override
  public NonNamespaceOperation<OpenShiftControllerManager, OpenShiftControllerManagerList, Resource<OpenShiftControllerManager>> openShiftControllerManagers() {
    return OpenShiftHandlers.getOperation(OpenShiftControllerManager.class, OpenShiftControllerManagerList.class, this);
  }

  @Override
  public NonNamespaceOperation<OpenShiftAPIServer, OpenShiftAPIServerList, Resource<OpenShiftAPIServer>> openShiftAPIServers() {
    return OpenShiftHandlers.getOperation(OpenShiftAPIServer.class, OpenShiftAPIServerList.class, this);
  }

  @Override
  public NonNamespaceOperation<KubeAPIServer, KubeAPIServerList, Resource<KubeAPIServer>> kubeAPIServers() {
    return OpenShiftHandlers.getOperation(KubeAPIServer.class, KubeAPIServerList.class, this);
  }

  @Override
  public MixedOperation<IngressController, IngressControllerList, Resource<IngressController>> ingressControllers() {
    return OpenShiftHandlers.getOperation(IngressController.class, IngressControllerList.class, this);
  }

  @Override
  public NonNamespaceOperation<ImagePruner, ImagePrunerList, Resource<ImagePruner>> imagePruners() {
    return OpenShiftHandlers.getOperation(ImagePruner.class, ImagePrunerList.class, this);
  }

  @Override
  public MixedOperation<PodNetworkConnectivityCheck, PodNetworkConnectivityCheckList, Resource<PodNetworkConnectivityCheck>> podNetworkConnectivityChecks() {
    return OpenShiftHandlers.getOperation(PodNetworkConnectivityCheck.class, PodNetworkConnectivityCheckList.class, this);
  }

  @Override
  public NonNamespaceOperation<ServiceCatalogAPIServer, ServiceCatalogAPIServerList, Resource<ServiceCatalogAPIServer>> serviceCatalogAPIServers() {
    return OpenShiftHandlers.getOperation(ServiceCatalogAPIServer.class, ServiceCatalogAPIServerList.class, this);
  }

  @Override
  public NonNamespaceOperation<Storage, StorageList, Resource<Storage>> storages() {
    return OpenShiftHandlers.getOperation(Storage.class, StorageList.class, this);
  }

  @Override
  public NonNamespaceOperation<Authentication, AuthenticationList, Resource<Authentication>> authentications() {
    return OpenShiftHandlers.getOperation(Authentication.class, AuthenticationList.class, this);
  }

  @Override
  public NonNamespaceOperation<CloudCredential, CloudCredentialList, Resource<CloudCredential>> cloudCredentials() {
    return OpenShiftHandlers.getOperation(CloudCredential.class, CloudCredentialList.class, this);
  }

  @Override
  public NonNamespaceOperation<ClusterCSIDriver, ClusterCSIDriverList, Resource<ClusterCSIDriver>> clusterCSIDrivers() {
    return OpenShiftHandlers.getOperation(ClusterCSIDriver.class, ClusterCSIDriverList.class, this);
  }

  @Override
  public NonNamespaceOperation<io.fabric8.openshift.api.model.operator.v1.Config, ConfigList, Resource<io.fabric8.openshift.api.model.operator.v1.Config>> configs() {
    return OpenShiftHandlers.getOperation(io.fabric8.openshift.api.model.operator.v1.Config.class, ConfigList.class, this);
  }
}
