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

import io.fabric8.kubernetes.api.model.Binding;
import io.fabric8.kubernetes.api.model.Doneable;
import io.fabric8.kubernetes.api.model.DoneableBinding;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.ConfigMapList;
import io.fabric8.kubernetes.api.model.DoneableConfigMap;
import io.fabric8.kubernetes.api.model.ComponentStatus;
import io.fabric8.kubernetes.api.model.ComponentStatusList;
import io.fabric8.kubernetes.api.model.DoneableComponentStatus;
import io.fabric8.kubernetes.api.model.Endpoints;
import io.fabric8.kubernetes.api.model.EndpointsList;
import io.fabric8.kubernetes.api.model.DoneableEndpoints;
import io.fabric8.kubernetes.api.model.events.Event;
import io.fabric8.kubernetes.api.model.events.EventList;
import io.fabric8.kubernetes.api.model.events.DoneableEvent;
import io.fabric8.kubernetes.api.model.LimitRange;
import io.fabric8.kubernetes.api.model.LimitRangeList;
import io.fabric8.kubernetes.api.model.DoneableLimitRange;
import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.NamespaceList;
import io.fabric8.kubernetes.api.model.DoneableNamespace;
import io.fabric8.kubernetes.api.model.Node;
import io.fabric8.kubernetes.api.model.NodeList;
import io.fabric8.kubernetes.api.model.DoneableNode;
import io.fabric8.kubernetes.api.model.PersistentVolume;
import io.fabric8.kubernetes.api.model.PersistentVolumeList;
import io.fabric8.kubernetes.api.model.DoneablePersistentVolume;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaimList;
import io.fabric8.kubernetes.api.model.DoneablePersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.api.model.DoneablePod;
import io.fabric8.kubernetes.api.model.ReplicationController;
import io.fabric8.kubernetes.api.model.ReplicationControllerList;
import io.fabric8.kubernetes.api.model.DoneableReplicationController;
import io.fabric8.kubernetes.api.model.ResourceQuota;
import io.fabric8.kubernetes.api.model.ResourceQuotaList;
import io.fabric8.kubernetes.api.model.DoneableResourceQuota;
import io.fabric8.kubernetes.api.model.Secret;
import io.fabric8.kubernetes.api.model.SecretList;
import io.fabric8.kubernetes.api.model.DoneableSecret;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.ServiceList;
import io.fabric8.kubernetes.api.model.DoneableService;
import io.fabric8.kubernetes.api.model.ServiceAccount;
import io.fabric8.kubernetes.api.model.ServiceAccountList;
import io.fabric8.kubernetes.api.model.DoneableServiceAccount;
import io.fabric8.kubernetes.api.model.coordination.v1.DoneableLease;
import io.fabric8.kubernetes.api.model.coordination.v1.Lease;
import io.fabric8.kubernetes.api.model.coordination.v1.LeaseList;
import io.fabric8.kubernetes.client.dsl.*;
import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinitionList;
import io.fabric8.kubernetes.api.model.apiextensions.DoneableCustomResourceDefinition;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import io.fabric8.kubernetes.client.dsl.internal.RawCustomResourceOperationsImpl;
import io.fabric8.kubernetes.client.extended.leaderelection.LeaderElectorBuilder;
import io.fabric8.kubernetes.client.informers.SharedInformerFactory;

import java.io.InputStream;
import java.util.Collection;
import java.util.concurrent.ExecutorService;

/**
 * Main interface for Kubernetes client library.
 */
public interface KubernetesClient extends Client {

  /**
   * API entrypoint for CustomResourcedefinition(CRDs). This offers basic operations like
   * load, get, create, update, delete and watch for APIGroup apiextensions/v1beta1
   *
   * @return NonNamespaceOperation object for CustomResourceDefinition
   */
  NonNamespaceOperation<CustomResourceDefinition, CustomResourceDefinitionList, DoneableCustomResourceDefinition, Resource<CustomResourceDefinition, DoneableCustomResourceDefinition>> customResourceDefinitions();

  /**
   * Typed API for managing CustomResources. You would need to provide POJOs for
   * CustomResource into this and with it you would be able to instantiate a client
   * specific to CustomResource.
   *
   * @param crd CustomResourceDefinition object on basic of which this CustomResource was created
   * @param resourceType Class for CustomResource
   * @param listClass Class for list object for CustomResource
   * @param doneClass Class for Doneable CustomResource object
   * @param <T> T type represents CustomResource type
   * @param <L> L type represents CustomResourceList type
   * @param <D> D type represents DoneableCustomResource type
   * @return returns a MixedOperation object with which you can do basic CustomResource operations
   */
  <T extends HasMetadata, L extends KubernetesResourceList, D extends Doneable<T>> MixedOperation<T, L, D, Resource<T, D>> customResources(CustomResourceDefinition crd, Class<T> resourceType, Class<L> listClass, Class<D> doneClass);

  /**
   * Old API for dealing with CustomResources.
   *
   * @deprecated Use {@link #customResources(CustomResourceDefinition, Class, Class, Class)} instead.
   * @param crd Custom Resource Definition
   * @param resourceType resource type Pojo
   * @param listClass list class Pojo
   * @param doneClass Done class Pojo
   * @param <T> template argument for resource
   * @param <L> template argument for list
   * @param <D> template argument for doneable resource
   * @return Kubernetes client object for manipulating custom resource.
   */
  <T extends HasMetadata, L extends KubernetesResourceList, D extends Doneable<T>> MixedOperation<T, L, D, Resource<T, D>> customResource(CustomResourceDefinition crd, Class<T> resourceType, Class<L> listClass, Class<D> doneClass);

  /**
   * Extensions API entrypoint for APIGroup extensions/v1beta1
   *
   * @return ExtensionsAPIGroupDSL with which you can access entrypoints for extension objects
   */
  ExtensionsAPIGroupDSL extensions();

  /**
   * Get Kubernetes API server version
   *
   * @return VersionInfo object containing versioning information
   */
  VersionInfo getVersion();

  /**
   * Typeless API for interacting with CustomResources. You can do basic operations with CustomResources
   * without having any model. You just need to pass an object providing basic information of
   * CustomResource. CustomResource objects are parsed as HashMaps.
   *
   * @param customResourceDefinition CustomResourceDefinitionContext - information about CustomResource like versioning, namespaced or not and group etc
   * @return a RawCustomResourceOperations object which offers several functions for creating, deleting, updating, watching CustomResources.
   */
  RawCustomResourceOperationsImpl customResource(CustomResourceDefinitionContext customResourceDefinition);

  /**
   * API entrypoint for kubernetes resources with APIGroup apps/v1
   *
   * @return AppsAPIGroupDSL which offers entrypoints to specific resources in this API group
   */
  AppsAPIGroupDSL apps();

  /**
   * API entrypoint for kubernetes resources with APIGroup autoscaling/v2beta1
   *
   * @return AutoScalingAPIGroupDSL which offers entrypoints to specific resources in this API group
   */
  AutoscalingAPIGroupDSL autoscaling();

  /**
   * API entrypoint for kubernetes resources with APIGroup networking/v1
   *
   * @return NetworkAPIGroupDSL which offers entrypoints to specific resources in this APIGroup
   */
  NetworkAPIGroupDSL network();

  /**
   * API entrypoint for kubernetes resources with APIGroup storage/v1
   *
   * @return StorageAPIGroupDSL which offers entrypoints to specific resources in this APIGroup
   */
  StorageAPIGroupDSL storage();

  /**
   * API entrypoint for kubernetes resources with APIGroup settings/v1alpha1
   *
   * @return SettingsAPIGroupDSL which offers entrypoint to specific resources in this APIGroup
   */
  SettingsAPIGroupDSL settings();

  /**
   * API entrypoint for kubernetes resources with APIGroup batch/v1beta1
   *
   * @return BatchAPIGroupDSL which offers entrypoint to specific resources in this APIGroup
   */
  BatchAPIGroupDSL batch();

  /**
   * API entrypoint for kubernetes metrics
   *
   * @return MetricAPIGroupDSL which offers for fetching metrics
   */
  MetricAPIGroupDSL top();

  /**
   * API entrypoint for kubernetes resources with APIGroup policy/v1beta1
   *
   * @return PolicyAPIGroupDSL which offers entrypoint to specific resources in this APIGroup
   */
  PolicyAPIGroupDSL policy();

  /**
   * API entrypoint for kubernetes resources with APIGroup rbac/v1
   *
   * @return RbacAPIGroupDSL which offers entrypoint to specific resources in this APIGroup
   */
  RbacAPIGroupDSL rbac();

  /**
   * API entrypoint for kubernetes resources with APIGroup scheduling/v1beta1
   *
   * @return SchedulingAPIGroupDSL which offers entrypoint to specific resources in this APIGroup
   */
  SchedulingAPIGroupDSL scheduling();

  /**
   * API entrypoint for dealing with core/v1/ComponentStatus
   *
   * @return MixedOperation object with which you can do basic operations for ComponentStatus
   */
  MixedOperation<ComponentStatus, ComponentStatusList, DoneableComponentStatus, Resource<ComponentStatus, DoneableComponentStatus>> componentstatuses();

  /**
   * Load a Kubernetes resource object from file InputStream
   *
   * @param is File input stream object containing json/yaml content
   * @return deserialized object
   */
  ParameterNamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata,Boolean> load(InputStream is);

  /**
   * Load a Kubernetes list object
   *
   * @param s kubernetes list as string
   * @return deserialized KubernetesList object
   */
  ParameterNamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata, Boolean> resourceList(String s);

  /**
   * KubernetesResourceList operations
   *
   * @param list KubernetesResourceList object containing kubernetes resource items
   * @return operations object for KubernetesResourceList
   */
  NamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata, Boolean> resourceList(KubernetesResourceList list);

  /**
   * KubernetesResourceList operations
   *
   * @param items array of HasMetadata values
   * @return operations object for Kubernetes list
   */
  NamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata, Boolean> resourceList(HasMetadata... items);

  /**
   * KubernetesResourceList operations
   *
   * @param items a collection containing HasMetadata values
   * @return operations object for Kubernetes list
   */
  NamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata, Boolean> resourceList(Collection<HasMetadata> items);

  /**
   * KubernetesResource operations. You can pass any Kubernetes resource as a HasMetadata object and do
   * all operations
   *
   * @param is Kubernetes resource object
   * @param <T> type of Kubernetes resource
   * @return operations object for Kubernetes resource
   */
  <T extends HasMetadata> NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicable<T ,Boolean> resource(T is);

  /**
   * KubernetesResource operations. You can pass any Kubernetes resource as string object and do
   * all operations
   *
   * @param s Kubernetes resource object as string
   * @return operations object for Kubernetes resource
   */
  NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicable<HasMetadata,Boolean> resource(String s);

  /**
   * Operations for Binding resource in APIgroup core/v1
   *
   * @return MixedOperation object for doing operations for Binding
   */
  MixedOperation<Binding, KubernetesResourceList, DoneableBinding, Resource<Binding, DoneableBinding>> bindings();

  /**
   * API entrypoint for Endpoints with APIGroup core/v1
   *
   * @return MixedOperation object for doing operations for Endpoints
   */
  MixedOperation<Endpoints, EndpointsList, DoneableEndpoints, Resource<Endpoints, DoneableEndpoints>> endpoints();

  /**
   * API entrypoint for getting events in Kubernetes. Events (events/v1beta1)
   *
   * @return MixedOperation object for doing operations for Events
   */
  MixedOperation<Event, EventList, DoneableEvent, Resource<Event, DoneableEvent>> events();

  /**
   * API entrypoint for namespace related operations in Kubernetes. Namespace (core/v1)
   *
   * @return NonNamespaceOperation object for Namespace related operations
   */
  NonNamespaceOperation< Namespace, NamespaceList, DoneableNamespace, Resource<Namespace, DoneableNamespace>> namespaces();

  /**
   * API entrypoint for node related operations in Kubernetes. Node (core/v1)
   *
   * @return NonNamespaceOperation object for Node related operations
   */
  NonNamespaceOperation<Node, NodeList, DoneableNode, Resource<Node, DoneableNode>> nodes();

  /**
   * API entrypoint for PersistentVolume related operations. PersistentVolume (core/v1)
   *
   * @return NonNamespaceOperation object for PersistentVolume related operations.
   */
  NonNamespaceOperation<PersistentVolume, PersistentVolumeList, DoneablePersistentVolume, Resource<PersistentVolume, DoneablePersistentVolume>> persistentVolumes();

  /**
   * API entrypoint for PersistentVolumeClaim related operations. PersistentVolumeClaim (core/v1)
   *
   * @return MixedOperation object for PersistentVolumeClaim related operations.
   */
  MixedOperation<PersistentVolumeClaim, PersistentVolumeClaimList, DoneablePersistentVolumeClaim, Resource<PersistentVolumeClaim, DoneablePersistentVolumeClaim>> persistentVolumeClaims();

  /**
   * API entrypoint for Pod related operations. Pod (core/v1)
   *
   * @return MixedOperation object for Pod related operations
   */
  MixedOperation<Pod, PodList, DoneablePod, PodResource<Pod, DoneablePod>> pods();

  /**
   * API entrypoint for ReplicationController related operations. ReplicationController (core/v1)
   *
   * @return MixedOperation object for ReplicationController related operations.
   */
  MixedOperation<ReplicationController, ReplicationControllerList, DoneableReplicationController, RollableScalableResource<ReplicationController, DoneableReplicationController>> replicationControllers();

  /**
   * API entrypoint for ResourceQuota related operations. ResourceQuota (core/v1)
   *
   * @return MixedOperation object for ResourceQuota related operations.
   */
  MixedOperation<ResourceQuota, ResourceQuotaList, DoneableResourceQuota, Resource<ResourceQuota, DoneableResourceQuota>> resourceQuotas();

  /**
   * API entrypoint for Secret related operations. Secret (core/v1)
   *
   * @return MixedOperation object for Secret related operations.
   */
  MixedOperation<Secret, SecretList, DoneableSecret, Resource<Secret, DoneableSecret>> secrets();

  /**
   * API entrypoint for Service related operations. Service (core/v1)
   *
   * @return MixedOperation object for Service related operations.
   */
  MixedOperation<Service, ServiceList, DoneableService, ServiceResource<Service, DoneableService>> services();

  /**
   * API entrypoint for ServiceAccount related operations. ServiceAccount (core/v1)
   *
   * @return MixedOperation object for ServiceAccount related operations.
   */
  MixedOperation<ServiceAccount, ServiceAccountList, DoneableServiceAccount, Resource<ServiceAccount, DoneableServiceAccount>> serviceAccounts();

  /**
   * List related operations.
   *
   * @return KubernetesListMixedOperations object for Kubernetes List
   */
  KubernetesListMixedOperation lists();

  /**
   * API entrypoint for ConfigMap related operations. ConfigMap (core/v1)
   *
   * @return MixedOperation object for ConfigMap related operations.
   */
  MixedOperation<ConfigMap, ConfigMapList, DoneableConfigMap, Resource<ConfigMap, DoneableConfigMap>> configMaps();

  /**
   * API entrypoint for LimitRange related operations. LimitRange (core/v1)
   *
   * @return MixedOperation object for LimitRange related operations.
   */
  MixedOperation<LimitRange, LimitRangeList, DoneableLimitRange, Resource<LimitRange, DoneableLimitRange>> limitRanges();

  /**
   * SubjectAccessReview operations. (authorization/v1)
   *
   * @return SubjectAccessReviewDSL object for dealing with SubjectAccessReviewOperations
   */
  SubjectAccessReviewDSL subjectAccessReviewAuth();

  /**
   * Get an instance of Kubernetes Client informer factory. It allows you to construct and
   * cache informers for API types. With it you can subscribe to all the events related to
   * your Kubernetes type. It's like watch but a bit organized.
   *
   * @return SharedInformerFactory object
   */
  SharedInformerFactory informers();

  /**
   * Get an instance of Kubernetes Client informer factory. It allows you to construct and
   * cache informers for API types. With it you can subscribe to all the events related to
   * your Kubernetes type. It's like watch but a bit organized.
   *
   * @param executorService thread pool for informer factory
   * @return SharedInformerFactory object
   */
  SharedInformerFactory informers(ExecutorService executorService);

  /**
   * API entrypoint for <code>LeaderElector</code> implementation for leader election.
   *
   * @param <C> type parameter for the Namespaceable KubernetesClient
   * @return LeaderElectorBuilder to build LeaderElector instances
   */
  <C extends Namespaceable<C> & KubernetesClient> LeaderElectorBuilder<C> leaderElector();

  /**
   * API entrypoint for {@link Lease} related operations. Lease (coordination.k8s.io/v1)
   *
   * @return MixedOperation object for Lease related operations.
   */
  MixedOperation<Lease, LeaseList, DoneableLease, Resource<Lease, DoneableLease>> leases();
}
