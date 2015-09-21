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
package io.fabric8.kubernetes.client;

import com.ning.http.client.AsyncHttpClient;
import io.fabric8.kubernetes.api.model.DoneableEndpoints;
import io.fabric8.kubernetes.api.model.DoneableEvent;
import io.fabric8.kubernetes.api.model.DoneableNamespace;
import io.fabric8.kubernetes.api.model.DoneableNode;
import io.fabric8.kubernetes.api.model.DoneablePersistentVolume;
import io.fabric8.kubernetes.api.model.DoneablePersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.DoneablePod;
import io.fabric8.kubernetes.api.model.DoneableReplicationController;
import io.fabric8.kubernetes.api.model.DoneableResourceQuota;
import io.fabric8.kubernetes.api.model.DoneableSecret;
import io.fabric8.kubernetes.api.model.DoneableSecurityContextConstraints;
import io.fabric8.kubernetes.api.model.DoneableService;
import io.fabric8.kubernetes.api.model.DoneableServiceAccount;
import io.fabric8.kubernetes.api.model.Endpoints;
import io.fabric8.kubernetes.api.model.EndpointsList;
import io.fabric8.kubernetes.api.model.Event;
import io.fabric8.kubernetes.api.model.EventList;
import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.NamespaceList;
import io.fabric8.kubernetes.api.model.Node;
import io.fabric8.kubernetes.api.model.NodeList;
import io.fabric8.kubernetes.api.model.PersistentVolume;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaimList;
import io.fabric8.kubernetes.api.model.PersistentVolumeList;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.api.model.ReplicationController;
import io.fabric8.kubernetes.api.model.ReplicationControllerList;
import io.fabric8.kubernetes.api.model.ResourceQuota;
import io.fabric8.kubernetes.api.model.ResourceQuotaList;
import io.fabric8.kubernetes.api.model.Secret;
import io.fabric8.kubernetes.api.model.SecretList;
import io.fabric8.kubernetes.api.model.SecurityContextConstraints;
import io.fabric8.kubernetes.api.model.SecurityContextConstraintsList;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.ServiceAccount;
import io.fabric8.kubernetes.api.model.ServiceAccountList;
import io.fabric8.kubernetes.api.model.ServiceList;
import io.fabric8.kubernetes.client.dsl.ClientKubernetesListMixedOperation;
import io.fabric8.kubernetes.client.dsl.ClientLoggableResource;
import io.fabric8.kubernetes.client.dsl.ClientNonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.ClientResource;
import io.fabric8.kubernetes.client.dsl.ClientRollableScallableResource;
import io.fabric8.kubernetes.client.dsl.internal.ClientMixedOperation;
import io.fabric8.kubernetes.client.dsl.internal.EndpointsOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.EventOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.KubernetesListOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.NamespaceOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.NodeOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.PersistentVolumeClaimOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.PersistentVolumeOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.PodOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.ReplicationControllerOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.ResourceQuotaOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.SecretOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.SecurityContextConstraintsOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.ServiceAccountOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.ServiceOperationsImpl;

public class DefaultKubernetesClient extends BaseClient implements KubernetesClient {
  public DefaultKubernetesClient() throws KubernetesClientException {
    super();
  }

  public DefaultKubernetesClient(AsyncHttpClient httpClient, Config config) throws KubernetesClientException {
    super(httpClient, config);
  }

  public DefaultKubernetesClient(Config config) throws KubernetesClientException {
    super(config);
  }

  public DefaultKubernetesClient(String masterUrl) throws KubernetesClientException {
    super(masterUrl);
  }

  @Override
  public ClientMixedOperation<KubernetesClient, Endpoints, EndpointsList, DoneableEndpoints, ClientResource<Endpoints, DoneableEndpoints>> endpoints() {
    return new EndpointsOperationsImpl(this);
  }

  @Override
  public ClientMixedOperation<KubernetesClient, Event, EventList, DoneableEvent, ClientResource<Event, DoneableEvent>> events() {
    return new EventOperationsImpl(this);
  }

  @Override
  public ClientNonNamespaceOperation<KubernetesClient, Namespace, NamespaceList, DoneableNamespace, ClientResource<Namespace, DoneableNamespace>> namespaces() {
    return new NamespaceOperationsImpl(this);
  }

  @Override
  public ClientNonNamespaceOperation<KubernetesClient, Node, NodeList, DoneableNode, ClientResource<Node, DoneableNode>> nodes() {
    return new NodeOperationsImpl(this);
  }

  @Override
  public ClientMixedOperation<KubernetesClient, PersistentVolume, PersistentVolumeList, DoneablePersistentVolume, ClientResource<PersistentVolume, DoneablePersistentVolume>> persistentVolumes() {
    return new PersistentVolumeOperationsImpl(this);
  }

  @Override
  public ClientMixedOperation<KubernetesClient, PersistentVolumeClaim, PersistentVolumeClaimList, DoneablePersistentVolumeClaim, ClientResource<PersistentVolumeClaim, DoneablePersistentVolumeClaim>> persistentVolumeClaims() {
    return new PersistentVolumeClaimOperationsImpl(this);
  }

  @Override
  public ClientMixedOperation<KubernetesClient, Pod, PodList, DoneablePod, ClientLoggableResource<Pod, DoneablePod>> pods() {
    return new PodOperationsImpl(this);
  }

  @Override
  public ClientMixedOperation<KubernetesClient, ReplicationController, ReplicationControllerList, DoneableReplicationController, ClientRollableScallableResource<ReplicationController, DoneableReplicationController>> replicationControllers() {
    return new ReplicationControllerOperationsImpl(this);
  }

  @Override
  public ClientMixedOperation<KubernetesClient, ResourceQuota, ResourceQuotaList, DoneableResourceQuota, ClientResource<ResourceQuota, DoneableResourceQuota>> resourceQuotas() {
    return new ResourceQuotaOperationsImpl(this);
  }

  @Override
  public ClientMixedOperation<KubernetesClient, Secret, SecretList, DoneableSecret, ClientResource<Secret, DoneableSecret>> secrets() {
    return new SecretOperationsImpl(this);
  }

  @Override
  public ClientMixedOperation<KubernetesClient, Service, ServiceList, DoneableService, ClientResource<Service, DoneableService>> services() {
    return new ServiceOperationsImpl(this);
  }

  @Override
  public ClientMixedOperation<KubernetesClient, ServiceAccount, ServiceAccountList, DoneableServiceAccount, ClientResource<ServiceAccount, DoneableServiceAccount>> serviceAccounts() {
    return new ServiceAccountOperationsImpl(this);
  }

  @Override
  public ClientKubernetesListMixedOperation<KubernetesClient> lists() {
    return new KubernetesListOperationsImpl(this);
  }

  @Override
  public ClientNonNamespaceOperation<KubernetesClient, SecurityContextConstraints, SecurityContextConstraintsList, DoneableSecurityContextConstraints, ClientResource<SecurityContextConstraints, DoneableSecurityContextConstraints>> securityContextConstraints() {
    return new SecurityContextConstraintsOperationsImpl(this);
  }

  @Override
  public KubernetesClient inNamespace(String namespace)
  {
    Config updated = new ConfigBuilder(getConfiguration()).withNamespace(namespace).build();
    return new DefaultKubernetesClient(getHttpClient(), updated);
  }
}
