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

public interface OpenShiftOperatorAPIGroupDSL extends Client {
  /**
   * API entrypoint for Etcd related operations(operator.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for Etcd type
   */
  NonNamespaceOperation<Etcd, EtcdList, DoneableEtcd, Resource<Etcd, DoneableEtcd>> etcds();
  /**
   * API entrypoint for KubeStorageVersionMigrator related operations(operator.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for KubeStorageVersionMigrator type
   */
  NonNamespaceOperation<KubeStorageVersionMigrator, KubeStorageVersionMigratorList, DoneableKubeStorageVersionMigrator, Resource<KubeStorageVersionMigrator, DoneableKubeStorageVersionMigrator>> kubeStorageVersionMigrators();
  /**
   * API entrypoint for KubeControllerManager related operations(operator.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for KubeControllerManager type
   */
  NonNamespaceOperation<KubeControllerManager, KubeControllerManagerList, DoneableKubeControllerManager, Resource<KubeControllerManager, DoneableKubeControllerManager>> kubeControllerManagers();
  /**
   * API entrypoint for CSISnapshotController related operations(operator.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for CSISnapshotController type
   */
  NonNamespaceOperation<CSISnapshotController, CSISnapshotControllerList, DoneableCSISnapshotController, Resource<CSISnapshotController, DoneableCSISnapshotController>> csiSnapshotControllers();
  /**
   * API entrypoint for Network related operations(operator.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for Network type
   */
  NonNamespaceOperation<Network, NetworkList, DoneableNetwork, Resource<Network, DoneableNetwork>> networks();
  /**
   * API entrypoint for KubeScheduler related operations(operator.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for KubeScheduler type
   */
  NonNamespaceOperation<KubeScheduler, KubeSchedulerList, DoneableKubeScheduler, Resource<KubeScheduler, DoneableKubeScheduler>> kubeSchedulers();
  /**
   * API entrypoint for Console related operations(operator.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for Console type
   */
  NonNamespaceOperation<Console, ConsoleList, DoneableConsole, Resource<Console, DoneableConsole>> consoles();
  /**
   * API entrypoint for ServiceCatalogControllerManager related operations(operator.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for ServiceCatalogControllerManager type
   */
  NonNamespaceOperation<ServiceCatalogControllerManager, ServiceCatalogControllerManagerList, DoneableServiceCatalogControllerManager, Resource<ServiceCatalogControllerManager, DoneableServiceCatalogControllerManager>> serviceCatalogControllerManagers();
  /**
   * API entrypoint for ServiceCA related operations(operator.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for ServiceCA type
   */
  NonNamespaceOperation<ServiceCA, ServiceCAList, DoneableServiceCA, Resource<ServiceCA, DoneableServiceCA>> serviceCAs();
  /**
   * API entrypoint for ImageContentSourcePolicy related operations(operator.openshift.io/v1alpha1)
   *
   * @return NonNamespaceOperation object for ImageContentSourcePolicy type
   */
  NonNamespaceOperation<ImageContentSourcePolicy, ImageContentSourcePolicyList, DoneableImageContentSourcePolicy, Resource<ImageContentSourcePolicy, DoneableImageContentSourcePolicy>> imageContentSourcePolicies();
  /**
   * API entrypoint for DNS related operations(operator.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for DNS type
   */
  NonNamespaceOperation<DNS, DNSList, DoneableDNS, Resource<DNS, DoneableDNS>> dnses();
  /**
   * API entrypoint for DNSRecord related operations(operator.openshift.io/v1)
   *
   * @return MixedOperation object for DNSRecord type
   */
  MixedOperation<DNSRecord, DNSRecordList, DoneableDNSRecord, Resource<DNSRecord, DoneableDNSRecord>> dnsRecords();
  /**
   * API entrypoint for OpenShiftControllerManager related operations(operator.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for OpenShiftControllerManager type
   */
  NonNamespaceOperation<OpenShiftControllerManager, OpenShiftControllerManagerList, DoneableOpenShiftControllerManager, Resource<OpenShiftControllerManager, DoneableOpenShiftControllerManager>> openShiftControllerManagers();
  /**
   * API entrypoint for OpenShiftAPIServer related operations(operator.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for OpenShiftAPIServer type
   */
  NonNamespaceOperation<OpenShiftAPIServer, OpenShiftAPIServerList, DoneableOpenShiftAPIServer, Resource<OpenShiftAPIServer, DoneableOpenShiftAPIServer>> openShiftAPIServers();
  /**
   * API entrypoint for KubeAPIServer related operations(operator.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for KubeAPIServer type
   */
  NonNamespaceOperation<KubeAPIServer, KubeAPIServerList, DoneableKubeAPIServer, Resource<KubeAPIServer, DoneableKubeAPIServer>> kubeAPIServers();
  /**
   * API entrypoint for IngressController related operations(operator.openshift.io/v1)
   *
   * @return MixedOperation object for IngressController type
   */
  MixedOperation<IngressController, IngressControllerList, DoneableIngressController, Resource<IngressController, DoneableIngressController>> ingressControllers();
  /**
   * API entrypoint for ImagePruner related operations(imageregistry.operator.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for ImagePruner type
   */
  NonNamespaceOperation<ImagePruner, ImagePrunerList, DoneableImagePruner, Resource<ImagePruner, DoneableImagePruner>> imagePruners();
  /**
   * API entrypoint for ServiceCatalogAPIServer related operations(operator.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for ServiceCatalogAPIServer type
   */
  NonNamespaceOperation<ServiceCatalogAPIServer, ServiceCatalogAPIServerList, DoneableServiceCatalogAPIServer, Resource<ServiceCatalogAPIServer, DoneableServiceCatalogAPIServer>> serviceCatalogAPIServers();
  /**
   * API entrypoint for Authentication related operations(operator.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for Authentication type
   */
  NonNamespaceOperation<Authentication, AuthenticationList, DoneableAuthentication, Resource<Authentication, DoneableAuthentication>> authentications();
}
