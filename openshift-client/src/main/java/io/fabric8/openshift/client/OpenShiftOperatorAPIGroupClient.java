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
import io.fabric8.openshift.api.model.operator.v1.Authentication;
import io.fabric8.openshift.api.model.operator.v1.AuthenticationList;
import io.fabric8.openshift.api.model.operator.v1.CSISnapshotController;
import io.fabric8.openshift.api.model.operator.v1.CSISnapshotControllerList;
import io.fabric8.openshift.api.model.operator.v1.Console;
import io.fabric8.openshift.api.model.operator.v1.ConsoleList;
import io.fabric8.openshift.api.model.operator.v1.DNS;
import io.fabric8.openshift.api.model.operator.v1.DNSList;
import io.fabric8.openshift.api.model.operator.v1.DNSRecord;
import io.fabric8.openshift.api.model.operator.v1.DNSRecordList;
import io.fabric8.openshift.api.model.operator.v1.DoneableAuthentication;
import io.fabric8.openshift.api.model.operator.v1.DoneableCSISnapshotController;
import io.fabric8.openshift.api.model.operator.v1.DoneableConsole;
import io.fabric8.openshift.api.model.operator.v1.DoneableDNS;
import io.fabric8.openshift.api.model.operator.v1.DoneableDNSRecord;
import io.fabric8.openshift.api.model.operator.v1.DoneableEtcd;
import io.fabric8.openshift.api.model.operator.v1.DoneableImagePruner;
import io.fabric8.openshift.api.model.operator.v1.DoneableIngressController;
import io.fabric8.openshift.api.model.operator.v1.DoneableKubeAPIServer;
import io.fabric8.openshift.api.model.operator.v1.DoneableKubeControllerManager;
import io.fabric8.openshift.api.model.operator.v1.DoneableKubeScheduler;
import io.fabric8.openshift.api.model.operator.v1.DoneableKubeStorageVersionMigrator;
import io.fabric8.openshift.api.model.operator.v1.DoneableNetwork;
import io.fabric8.openshift.api.model.operator.v1.DoneableOpenShiftAPIServer;
import io.fabric8.openshift.api.model.operator.v1.DoneableOpenShiftControllerManager;
import io.fabric8.openshift.api.model.operator.v1.DoneableServiceCA;
import io.fabric8.openshift.api.model.operator.v1.DoneableServiceCatalogAPIServer;
import io.fabric8.openshift.api.model.operator.v1.DoneableServiceCatalogControllerManager;
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
import io.fabric8.openshift.api.model.operator.v1alpha1.DoneableImageContentSourcePolicy;
import io.fabric8.openshift.api.model.operator.v1alpha1.ImageContentSourcePolicy;
import io.fabric8.openshift.api.model.operator.v1alpha1.ImageContentSourcePolicyList;
import io.fabric8.openshift.client.dsl.OpenShiftOperatorAPIGroupDSL;
import io.fabric8.openshift.client.dsl.internal.AuthenticationOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.CSISnapshotControllerOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.ConsoleOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.DNSOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.DNSRecordOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.EtcdOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.ImageContentSourcePolicyOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.ImagePrunerOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.IngressControllerOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.KubeAPIServerOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.KubeControllerManagerOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.KubeSchedulerOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.KubeStorageVersionMigratorOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.NetworkOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.OpenShiftAPIServerOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.OpenShiftControllerManagerOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.ServiceCAOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.ServiceCatalogAPIServerOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.ServiceCatalogControllerManagerOperationsImpl;
import okhttp3.OkHttpClient;

public class OpenShiftOperatorAPIGroupClient extends BaseClient implements OpenShiftOperatorAPIGroupDSL {
  public OpenShiftOperatorAPIGroupClient() {
    super();
  }

  public OpenShiftOperatorAPIGroupClient(OkHttpClient httpClient, final Config config) {
    super(httpClient, config);
  }

  @Override
  public NonNamespaceOperation<Etcd, EtcdList, DoneableEtcd, Resource<Etcd, DoneableEtcd>> etcds() {
    return new EtcdOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<KubeStorageVersionMigrator, KubeStorageVersionMigratorList, DoneableKubeStorageVersionMigrator, Resource<KubeStorageVersionMigrator, DoneableKubeStorageVersionMigrator>> kubeStorageVersionMigrators() {
    return new KubeStorageVersionMigratorOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<KubeControllerManager, KubeControllerManagerList, DoneableKubeControllerManager, Resource<KubeControllerManager, DoneableKubeControllerManager>> kubeControllerManagers() {
    return new KubeControllerManagerOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<CSISnapshotController, CSISnapshotControllerList, DoneableCSISnapshotController, Resource<CSISnapshotController, DoneableCSISnapshotController>> csiSnapshotControllers() {
    return new CSISnapshotControllerOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<Network, NetworkList, DoneableNetwork, Resource<Network, DoneableNetwork>> networks() {
    return new NetworkOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<KubeScheduler, KubeSchedulerList, DoneableKubeScheduler, Resource<KubeScheduler, DoneableKubeScheduler>> kubeSchedulers() {
    return new KubeSchedulerOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<Console, ConsoleList, DoneableConsole, Resource<Console, DoneableConsole>> consoles() {
    return new ConsoleOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<ServiceCatalogControllerManager, ServiceCatalogControllerManagerList, DoneableServiceCatalogControllerManager, Resource<ServiceCatalogControllerManager, DoneableServiceCatalogControllerManager>> serviceCatalogControllerManagers() {
    return new ServiceCatalogControllerManagerOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<ServiceCA, ServiceCAList, DoneableServiceCA, Resource<ServiceCA, DoneableServiceCA>> serviceCAs() {
    return new ServiceCAOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<ImageContentSourcePolicy, ImageContentSourcePolicyList, DoneableImageContentSourcePolicy, Resource<ImageContentSourcePolicy, DoneableImageContentSourcePolicy>> imageContentSourcePolicies() {
    return new ImageContentSourcePolicyOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<DNS, DNSList, DoneableDNS, Resource<DNS, DoneableDNS>> dnses() {
    return new DNSOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public MixedOperation<DNSRecord, DNSRecordList, DoneableDNSRecord, Resource<DNSRecord, DoneableDNSRecord>> dnsRecords() {
    return new DNSRecordOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<OpenShiftControllerManager, OpenShiftControllerManagerList, DoneableOpenShiftControllerManager, Resource<OpenShiftControllerManager, DoneableOpenShiftControllerManager>> openShiftControllerManagers() {
    return new OpenShiftControllerManagerOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<OpenShiftAPIServer, OpenShiftAPIServerList, DoneableOpenShiftAPIServer, Resource<OpenShiftAPIServer, DoneableOpenShiftAPIServer>> openShiftAPIServers() {
    return new OpenShiftAPIServerOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<KubeAPIServer, KubeAPIServerList, DoneableKubeAPIServer, Resource<KubeAPIServer, DoneableKubeAPIServer>> kubeAPIServers() {
    return new KubeAPIServerOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public MixedOperation<IngressController, IngressControllerList, DoneableIngressController, Resource<IngressController, DoneableIngressController>> ingressControllers() {
    return new IngressControllerOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<ImagePruner, ImagePrunerList, DoneableImagePruner, Resource<ImagePruner, DoneableImagePruner>> imagePruners() {
    return new ImagePrunerOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<ServiceCatalogAPIServer, ServiceCatalogAPIServerList, DoneableServiceCatalogAPIServer, Resource<ServiceCatalogAPIServer, DoneableServiceCatalogAPIServer>> serviceCatalogAPIServers() {
    return new ServiceCatalogAPIServerOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<Authentication, AuthenticationList, DoneableAuthentication, Resource<Authentication, DoneableAuthentication>> authentications() {
    return new AuthenticationOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }
}
