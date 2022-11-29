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
import io.fabric8.openshift.api.model.operator.v1.Config;
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

public interface OpenShiftOperatorAPIGroupDSL extends Client {
  /**
   * API entrypoint for Authentication related operations(operator.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for Authentication type
   */
  NonNamespaceOperation<Authentication, AuthenticationList, Resource<Authentication>> authentications();

  NonNamespaceOperation<CloudCredential, CloudCredentialList, Resource<CloudCredential>> cloudCredentials();

  NonNamespaceOperation<ClusterCSIDriver, ClusterCSIDriverList, Resource<ClusterCSIDriver>> clusterCSIDrivers();

  NonNamespaceOperation<Config, ConfigList, Resource<Config>> configs();

  /**
   * API entrypoint for Etcd related operations(operator.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for Etcd type
   */
  NonNamespaceOperation<Etcd, EtcdList, Resource<Etcd>> etcds();

  /**
   * API entrypoint for KubeStorageVersionMigrator related operations(operator.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for KubeStorageVersionMigrator type
   */
  NonNamespaceOperation<KubeStorageVersionMigrator, KubeStorageVersionMigratorList, Resource<KubeStorageVersionMigrator>> kubeStorageVersionMigrators();

  /**
   * API entrypoint for KubeControllerManager related operations(operator.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for KubeControllerManager type
   */
  NonNamespaceOperation<KubeControllerManager, KubeControllerManagerList, Resource<KubeControllerManager>> kubeControllerManagers();

  /**
   * API entrypoint for CSISnapshotController related operations(operator.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for CSISnapshotController type
   */
  NonNamespaceOperation<CSISnapshotController, CSISnapshotControllerList, Resource<CSISnapshotController>> csiSnapshotControllers();

  /**
   * API entrypoint for Network related operations(operator.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for Network type
   */
  NonNamespaceOperation<Network, NetworkList, Resource<Network>> networks();

  /**
   * API entrypoint for KubeScheduler related operations(operator.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for KubeScheduler type
   */
  NonNamespaceOperation<KubeScheduler, KubeSchedulerList, Resource<KubeScheduler>> kubeSchedulers();

  /**
   * API entrypoint for Console related operations(operator.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for Console type
   */
  NonNamespaceOperation<Console, ConsoleList, Resource<Console>> consoles();

  /**
   * API entrypoint for ServiceCatalogControllerManager related operations(operator.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for ServiceCatalogControllerManager type
   */
  NonNamespaceOperation<ServiceCatalogControllerManager, ServiceCatalogControllerManagerList, Resource<ServiceCatalogControllerManager>> serviceCatalogControllerManagers();

  /**
   * API entrypoint for ServiceCA related operations(operator.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for ServiceCA type
   */
  NonNamespaceOperation<ServiceCA, ServiceCAList, Resource<ServiceCA>> serviceCAs();

  /**
   * API entrypoint for ImageContentSourcePolicy related operations(operator.openshift.io/v1alpha1)
   *
   * @return NonNamespaceOperation object for ImageContentSourcePolicy type
   */
  NonNamespaceOperation<ImageContentSourcePolicy, ImageContentSourcePolicyList, Resource<ImageContentSourcePolicy>> imageContentSourcePolicies();

  /**
   * API entrypoint for DNS related operations(operator.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for DNS type
   */
  NonNamespaceOperation<DNS, DNSList, Resource<DNS>> dnses();

  /**
   * API entrypoint for DNSRecord related operations(operator.openshift.io/v1)
   *
   * @return MixedOperation object for DNSRecord type
   */
  MixedOperation<DNSRecord, DNSRecordList, Resource<DNSRecord>> dnsRecords();

  /**
   * API entrypoint for OpenShiftControllerManager related operations(operator.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for OpenShiftControllerManager type
   */
  NonNamespaceOperation<OpenShiftControllerManager, OpenShiftControllerManagerList, Resource<OpenShiftControllerManager>> openShiftControllerManagers();

  /**
   * API entrypoint for OpenShiftAPIServer related operations(operator.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for OpenShiftAPIServer type
   */
  NonNamespaceOperation<OpenShiftAPIServer, OpenShiftAPIServerList, Resource<OpenShiftAPIServer>> openShiftAPIServers();

  /**
   * API entrypoint for KubeAPIServer related operations(operator.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for KubeAPIServer type
   */
  NonNamespaceOperation<KubeAPIServer, KubeAPIServerList, Resource<KubeAPIServer>> kubeAPIServers();

  /**
   * API entrypoint for IngressController related operations(operator.openshift.io/v1)
   *
   * @return MixedOperation object for IngressController type
   */
  MixedOperation<IngressController, IngressControllerList, Resource<IngressController>> ingressControllers();

  /**
   * API entrypoint for ImagePruner related operations(imageregistry.operator.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for ImagePruner type
   */
  NonNamespaceOperation<ImagePruner, ImagePrunerList, Resource<ImagePruner>> imagePruners();

  /**
   * API entrypoint for PodNetworkConnectivityCheck (controlpane.operator.openshift.io/v1alpha1)
   * 
   * @return {@link MixedOperation} for PodNetworkConnectivityCheck
   */
  MixedOperation<PodNetworkConnectivityCheck, PodNetworkConnectivityCheckList, Resource<PodNetworkConnectivityCheck>> podNetworkConnectivityChecks();

  /**
   * API entrypoint for ServiceCatalogAPIServer related operations(operator.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for ServiceCatalogAPIServer type
   */
  NonNamespaceOperation<ServiceCatalogAPIServer, ServiceCatalogAPIServerList, Resource<ServiceCatalogAPIServer>> serviceCatalogAPIServers();

  /**
   * API entrypoing for Storage (operator.openshift.io/v1)
   * 
   * @return {@link NonNamespaceOperation} for Storage
   */
  NonNamespaceOperation<Storage, StorageList, Resource<Storage>> storages();
}
