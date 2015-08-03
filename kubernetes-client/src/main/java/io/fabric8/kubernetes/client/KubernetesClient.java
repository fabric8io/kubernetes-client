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

import io.fabric8.kubernetes.api.model.*;
import io.fabric8.kubernetes.client.dsl.*;
import io.fabric8.openshift.api.model.DoneableTemplate;
import io.fabric8.openshift.api.model.Template;
import io.fabric8.openshift.api.model.TemplateList;

import java.net.URL;


public interface KubernetesClient extends AutoCloseable {

  URL getMasterUrl();

  RootPaths rootPaths();

  ClientOperation<Endpoints, EndpointsList, DoneableEndpoints, Resource<Endpoints, DoneableEndpoints, Boolean>> endpoints();

  ClientOperation<Event, EventList, DoneableEvent, Resource<Event, DoneableEvent, Boolean>> events();

  ClientNonNamespaceOperation<Namespace, NamespaceList, DoneableNamespace, Resource<Namespace, DoneableNamespace, Boolean>> namespaces();

  ClientNonNamespaceOperation<Node, NodeList, DoneableNode, Resource<Node, DoneableNode, Boolean>> nodes();

  ClientOperation<PersistentVolume, PersistentVolumeList, DoneablePersistentVolume, Resource<PersistentVolume, DoneablePersistentVolume, Boolean>> persistentVolumes();

  ClientOperation<PersistentVolumeClaim, PersistentVolumeClaimList, DoneablePersistentVolumeClaim, Resource<PersistentVolumeClaim, DoneablePersistentVolumeClaim, Boolean>> persistentVolumeClaims();

  ClientOperation<Pod, PodList, DoneablePod, Resource<Pod, DoneablePod, Boolean>> pods();

  ClientOperation<ReplicationController, ReplicationControllerList, DoneableReplicationController, ScaleableResource<ReplicationController, DoneableReplicationController, Boolean>> replicationControllers();

  ClientOperation<ResourceQuota, ResourceQuotaList, DoneableResourceQuota, Resource<ResourceQuota, DoneableResourceQuota, Boolean>> resourceQuotas();

  ClientOperation<Secret, SecretList, DoneableSecret, Resource<Secret, DoneableSecret, Boolean>> secrets();

  ClientOperation<Service, ServiceList, DoneableService, Resource<Service, DoneableService, Boolean>> services();

  ClientOperation<ServiceAccount, ServiceAccountList, DoneableServiceAccount, Resource<ServiceAccount, DoneableServiceAccount, Boolean>> serviceAccounts();

  ClientOperation<Template, TemplateList, DoneableTemplate, ProcessableResource<Template, DoneableTemplate, Boolean>> templates();

  void close();

}
