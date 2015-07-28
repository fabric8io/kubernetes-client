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
import io.fabric8.kubernetes.api.model.RootPaths;
import io.fabric8.kubernetes.api.model.Secret;
import io.fabric8.kubernetes.api.model.SecretList;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.ServiceAccount;
import io.fabric8.kubernetes.api.model.ServiceAccountList;
import io.fabric8.kubernetes.api.model.ServiceList;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Operation;
import io.fabric8.kubernetes.client.dsl.ProcessableResource;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.ScaleableResource;
import io.fabric8.openshift.api.model.DoneableTemplate;
import io.fabric8.openshift.api.model.Template;
import io.fabric8.openshift.api.model.TemplateList;

import java.net.URL;


public interface KubernetesClient extends AutoCloseable {

  URL getMasterUrl();

  RootPaths rootPaths();

  Operation<Endpoints, EndpointsList, DoneableEndpoints, Void, Boolean, Resource<Endpoints, DoneableEndpoints, Void, Boolean>> endpoints();

  Operation<Event, EventList, DoneableEvent, Void, Boolean, Resource<Event, DoneableEvent, Void, Boolean>> events();

  NonNamespaceOperation<Namespace, NamespaceList, DoneableNamespace, Void, Boolean, Resource<Namespace, DoneableNamespace, Void, Boolean>> namespaces();

  NonNamespaceOperation<Node, NodeList, DoneableNode, Void, Boolean, Resource<Node, DoneableNode, Void, Boolean>> nodes();

  Operation<PersistentVolume, PersistentVolumeList, DoneablePersistentVolume, Void, Boolean, Resource<PersistentVolume, DoneablePersistentVolume, Void, Boolean>> persistentVolumes();

  Operation<PersistentVolumeClaim, PersistentVolumeClaimList,  DoneablePersistentVolumeClaim, Void, Boolean, Resource<PersistentVolumeClaim, DoneablePersistentVolumeClaim, Void, Boolean>> persistentVolumeClaims();

  Operation<Pod, PodList, DoneablePod, Void, Boolean, Resource<Pod, DoneablePod, Void, Boolean>> pods();

  Operation<ReplicationController, ReplicationControllerList, DoneableReplicationController, Void, Boolean, ScaleableResource<ReplicationController, DoneableReplicationController, Void, Boolean>> replicationControllers();

  Operation<ResourceQuota, ResourceQuotaList, DoneableResourceQuota, Void, Boolean, Resource<ResourceQuota, DoneableResourceQuota, Void, Boolean>> resourceQuotas();

  Operation<Secret, SecretList,  DoneableSecret, Void, Boolean,Resource<Secret, DoneableSecret, Void, Boolean>> secrets();

  Operation<Service, ServiceList,  DoneableService, Void, Boolean, Resource<Service, DoneableService, Void, Boolean>> services();

  Operation<ServiceAccount, ServiceAccountList,  DoneableServiceAccount, Void, Boolean, Resource<ServiceAccount, DoneableServiceAccount, Void, Boolean>> serviceAccounts();

  Operation<Template, TemplateList, DoneableTemplate, Void, Boolean, ProcessableResource<Template, DoneableTemplate, Void, Boolean>> templates();

  void close();

}
