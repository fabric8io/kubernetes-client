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

import io.fabric8.kubernetes.client.BaseClient;
import io.fabric8.kubernetes.client.Config;
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
import io.fabric8.openshift.client.dsl.internal.controlplane.operator.PodNetworkConnectivityCheckOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.operator.AuthenticationOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.operator.CSISnapshotControllerOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.operator.CloudCredentialOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.operator.ClusterCSIDriverOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.operator.ConfigOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.operator.ConsoleOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.operator.DNSOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.ingress.operator.DNSRecordOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.operator.EtcdOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.operator.ImageContentSourcePolicyOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.imageregistry.operator.ImagePrunerOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.operator.IngressControllerOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.operator.KubeAPIServerOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.operator.KubeControllerManagerOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.operator.KubeSchedulerOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.operator.KubeStorageVersionMigratorOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.operator.NetworkOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.operator.OpenShiftAPIServerOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.operator.OpenShiftControllerManagerOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.operator.ServiceCAOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.operator.ServiceCatalogAPIServerOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.operator.ServiceCatalogControllerManagerOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.operator.StorageOperationsImpl;
import okhttp3.OkHttpClient;

public class OpenShiftOperatorAPIGroupClient extends BaseClient implements OpenShiftOperatorAPIGroupDSL {
  public OpenShiftOperatorAPIGroupClient() {
    super();
  }

  public OpenShiftOperatorAPIGroupClient(OkHttpClient httpClient, final Config config) {
    super(httpClient, config);
  }

  @Override
  public NonNamespaceOperation<Etcd, EtcdList, Resource<Etcd>> etcds() {
    return new EtcdOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<KubeStorageVersionMigrator, KubeStorageVersionMigratorList, Resource<KubeStorageVersionMigrator>> kubeStorageVersionMigrators() {
    return new KubeStorageVersionMigratorOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<KubeControllerManager, KubeControllerManagerList, Resource<KubeControllerManager>> kubeControllerManagers() {
    return new KubeControllerManagerOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<CSISnapshotController, CSISnapshotControllerList, Resource<CSISnapshotController>> csiSnapshotControllers() {
    return new CSISnapshotControllerOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<Network, NetworkList, Resource<Network>> networks() {
    return new NetworkOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<KubeScheduler, KubeSchedulerList, Resource<KubeScheduler>> kubeSchedulers() {
    return new KubeSchedulerOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<Console, ConsoleList, Resource<Console>> consoles() {
    return new ConsoleOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<ServiceCatalogControllerManager, ServiceCatalogControllerManagerList, Resource<ServiceCatalogControllerManager>> serviceCatalogControllerManagers() {
    return new ServiceCatalogControllerManagerOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<ServiceCA, ServiceCAList, Resource<ServiceCA>> serviceCAs() {
    return new ServiceCAOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<ImageContentSourcePolicy, ImageContentSourcePolicyList, Resource<ImageContentSourcePolicy>> imageContentSourcePolicies() {
    return new ImageContentSourcePolicyOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<DNS, DNSList, Resource<DNS>> dnses() {
    return new DNSOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public MixedOperation<DNSRecord, DNSRecordList, Resource<DNSRecord>> dnsRecords() {
    return new DNSRecordOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<OpenShiftControllerManager, OpenShiftControllerManagerList, Resource<OpenShiftControllerManager>> openShiftControllerManagers() {
    return new OpenShiftControllerManagerOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<OpenShiftAPIServer, OpenShiftAPIServerList, Resource<OpenShiftAPIServer>> openShiftAPIServers() {
    return new OpenShiftAPIServerOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<KubeAPIServer, KubeAPIServerList, Resource<KubeAPIServer>> kubeAPIServers() {
    return new KubeAPIServerOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public MixedOperation<IngressController, IngressControllerList, Resource<IngressController>> ingressControllers() {
    return new IngressControllerOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<ImagePruner, ImagePrunerList, Resource<ImagePruner>> imagePruners() {
    return new ImagePrunerOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public MixedOperation<PodNetworkConnectivityCheck, PodNetworkConnectivityCheckList, Resource<PodNetworkConnectivityCheck>> podNetworkConnectivityChecks() {
    return new PodNetworkConnectivityCheckOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<ServiceCatalogAPIServer, ServiceCatalogAPIServerList, Resource<ServiceCatalogAPIServer>> serviceCatalogAPIServers() {
    return new ServiceCatalogAPIServerOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<Storage, StorageList, Resource<Storage>> storages() {
    return new StorageOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<Authentication, AuthenticationList, Resource<Authentication>> authentications() {
    return new AuthenticationOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<CloudCredential, CloudCredentialList, Resource<CloudCredential>> cloudCredentials() {
    return new CloudCredentialOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<ClusterCSIDriver, ClusterCSIDriverList, Resource<ClusterCSIDriver>> clusterCSIDrivers() {
    return new ClusterCSIDriverOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<io.fabric8.openshift.api.model.operator.v1.Config, ConfigList, Resource<io.fabric8.openshift.api.model.operator.v1.Config>> configs() {
    return new ConfigOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }
}
