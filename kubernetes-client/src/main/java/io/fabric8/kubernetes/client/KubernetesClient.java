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
import io.fabric8.kubernetes.api.model.*;
import io.fabric8.kubernetes.client.dsl.ClientNonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.ClientOperation;
import io.fabric8.kubernetes.client.dsl.ClientResource;
import io.fabric8.kubernetes.client.dsl.ReplicationControllerClientResource;

import java.net.URL;


public interface KubernetesClient extends ConfigAware<Config>, AutoCloseable{

  <T extends Extension> T adapt(Class<T> type);

  AsyncHttpClient getHttpClient();

  URL getMasterUrl();

  RootPaths rootPaths();

  ClientOperation<KubernetesClient, Endpoints, EndpointsList, DoneableEndpoints, ClientResource<Endpoints, DoneableEndpoints>> endpoints();

  ClientOperation<KubernetesClient, Event, EventList, DoneableEvent, ClientResource<Event, DoneableEvent>> events();

  ClientNonNamespaceOperation<KubernetesClient, Namespace, NamespaceList, DoneableNamespace, ClientResource<Namespace, DoneableNamespace>> namespaces();

  ClientNonNamespaceOperation<KubernetesClient, Node, NodeList, DoneableNode, ClientResource<Node, DoneableNode>> nodes();

  ClientOperation<KubernetesClient, PersistentVolume, PersistentVolumeList, DoneablePersistentVolume, ClientResource<PersistentVolume, DoneablePersistentVolume>> persistentVolumes();

  ClientOperation<KubernetesClient, PersistentVolumeClaim, PersistentVolumeClaimList, DoneablePersistentVolumeClaim, ClientResource<PersistentVolumeClaim, DoneablePersistentVolumeClaim>> persistentVolumeClaims();

  ClientOperation<KubernetesClient, Pod, PodList, DoneablePod, ClientResource<Pod, DoneablePod>> pods();

  ClientOperation<KubernetesClient, ReplicationController, ReplicationControllerList, DoneableReplicationController, ReplicationControllerClientResource<ReplicationController, DoneableReplicationController>> replicationControllers();

  ClientOperation<KubernetesClient, ResourceQuota, ResourceQuotaList, DoneableResourceQuota, ClientResource<ResourceQuota, DoneableResourceQuota>> resourceQuotas();

  ClientOperation<KubernetesClient, Secret, SecretList, DoneableSecret, ClientResource<Secret, DoneableSecret>> secrets();

  ClientOperation<KubernetesClient, Service, ServiceList, DoneableService, ClientResource<Service, DoneableService>> services();

  ClientOperation<KubernetesClient, ServiceAccount, ServiceAccountList, DoneableServiceAccount, ClientResource<ServiceAccount, DoneableServiceAccount>> serviceAccounts();

  ClientNonNamespaceOperation<KubernetesClient, SecurityContextConstraints, SecurityContextConstraintsList, DoneableSecurityContextConstraints, ClientResource<SecurityContextConstraints, DoneableSecurityContextConstraints>> securityContextConstraints();

  void close();

}
