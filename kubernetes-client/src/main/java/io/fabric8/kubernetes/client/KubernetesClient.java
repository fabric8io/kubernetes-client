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

import io.fabric8.kubernetes.api.model.APIService;
import io.fabric8.kubernetes.api.model.APIServiceList;
import io.fabric8.kubernetes.api.model.Binding;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.ConfigMapList;
import io.fabric8.kubernetes.api.model.ComponentStatus;
import io.fabric8.kubernetes.api.model.ComponentStatusList;
import io.fabric8.kubernetes.api.model.Endpoints;
import io.fabric8.kubernetes.api.model.EndpointsList;
import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.api.model.GenericKubernetesResourceList;
import io.fabric8.kubernetes.api.model.LimitRange;
import io.fabric8.kubernetes.api.model.LimitRangeList;
import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.NamespaceList;
import io.fabric8.kubernetes.api.model.Node;
import io.fabric8.kubernetes.api.model.NodeList;
import io.fabric8.kubernetes.api.model.PersistentVolume;
import io.fabric8.kubernetes.api.model.PersistentVolumeList;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaimList;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.api.model.ReplicationController;
import io.fabric8.kubernetes.api.model.ReplicationControllerList;
import io.fabric8.kubernetes.api.model.ResourceQuota;
import io.fabric8.kubernetes.api.model.ResourceQuotaList;
import io.fabric8.kubernetes.api.model.Secret;
import io.fabric8.kubernetes.api.model.SecretList;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.ServiceList;
import io.fabric8.kubernetes.api.model.ServiceAccount;
import io.fabric8.kubernetes.api.model.ServiceAccountList;
import io.fabric8.kubernetes.api.model.certificates.v1beta1.CertificateSigningRequest;
import io.fabric8.kubernetes.api.model.certificates.v1beta1.CertificateSigningRequestList;
import io.fabric8.kubernetes.api.model.authentication.TokenReview;
import io.fabric8.kubernetes.api.model.coordination.v1.Lease;
import io.fabric8.kubernetes.api.model.coordination.v1.LeaseList;
import io.fabric8.kubernetes.api.model.node.v1beta1.RuntimeClass;
import io.fabric8.kubernetes.api.model.node.v1beta1.RuntimeClassList;
import io.fabric8.kubernetes.client.dsl.*;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import io.fabric8.kubernetes.client.dsl.internal.RawCustomResourceOperationsImpl;
import io.fabric8.kubernetes.client.extended.leaderelection.LeaderElectorBuilder;
import io.fabric8.kubernetes.client.extended.run.RunOperations;
import io.fabric8.kubernetes.client.informers.SharedInformerFactory;

import java.io.InputStream;
import java.util.Collection;
import java.util.concurrent.ExecutorService;

/**
 * Main interface for Kubernetes client library.
 */
public interface KubernetesClient extends Client {

  /**
   * API entrypoint for apiextensions resources. Currently support both
   * v1 and v1beta1
   *
   * @return ApiextensionsAPIGroupDSL which routes to v1 or v1beta1
   */
  ApiextensionsAPIGroupDSL apiextensions();

  /**
   * API entrypoint for using CertificateSigningRequest(certificates.k8s.io/v1beta1)
   *
   * @deprecated Use `client.certificates().v1beta1().certificateSigningRequest` instead
   * @return {@link NonNamespaceOperation} for CertificateSigningRequest class
   */
  @Deprecated
  NonNamespaceOperation<CertificateSigningRequest, CertificateSigningRequestList, Resource<CertificateSigningRequest>> certificateSigningRequests();

  /**
   * API entrypoint for certificates.k8s.io APIGroup
   *
   * @return {@link CertificatesAPIGroupDSL} for Certificate API resources
   */
  CertificatesAPIGroupDSL certificates();

  /**
   * Typed API for managing CustomResources. You would need to provide POJOs for
   * CustomResource into this and with it you would be able to instantiate a client
   * specific to CustomResource.
   *
   * <p>
   *   Note: your CustomResource POJO (T in this context) must implement
   *   {@link io.fabric8.kubernetes.api.model.Namespaced} if it is a namespace-scoped resource.
   * </p>
   *
   * @param resourceType Class for CustomResource
   * @param <T> T type represents CustomResource type. If it's a namespaced resource, it must implement
   *           {@link io.fabric8.kubernetes.api.model.Namespaced}
   * @return returns a MixedOperation object with which you can do basic CustomResource operations
   */
  <T extends CustomResource> MixedOperation<T, KubernetesResourceList<T>, Resource<T>> customResources(Class<T> resourceType);

  /**
   * Typed API for managing CustomResources. You would need to provide POJOs for
   * CustomResource into this and with it you would be able to instantiate a client
   * specific to CustomResource.
   *
   * <p>
   *   Note: your CustomResource POJO (T in this context) must implement
   *   {@link io.fabric8.kubernetes.api.model.Namespaced} if it is a namespace-scoped resource.
   * </p>
   *
   * @param resourceType Class for CustomResource
   * @param listClass Class for list object for CustomResource
   * @param <T> T type represents CustomResource type. If it's a namespace-scoped resource, it must implement
   *           {@link io.fabric8.kubernetes.api.model.Namespaced}
   * @param <L> L type represents CustomResourceList type
   * @return returns a MixedOperation object with which you can do basic CustomResource operations
   */
  <T extends CustomResource, L extends KubernetesResourceList<T>> MixedOperation<T, L, Resource<T>> customResources(Class<T> resourceType, Class<L> listClass);


  /**
   * Typed API for managing CustomResources. You would need to provide POJOs for
   * CustomResource into this and with it you would be able to instantiate a client
   * specific to CustomResource.
   *
   * <p>
   *   Note: your CustomResource POJO (T in this context) must implement
   *   <a href="https://github.com/fabric8io/kubernetes-client/blob/master/kubernetes-model-generator/kubernetes-model-core/src/main/java/io/fabric8/kubernetes/api/model/Namespaced.java">
   *     io.fabric8.kubernetes.api.model.Namespaced
   *   </a> if it is a Namespaced scoped resource.
   * </p>
   *
   * @deprecated Since 5.x versions of client {@link CustomResourceDefinitionContext} is now configured via annotations
   *             inside POJOs, no need to provide it explicitly here.
   * @param crdContext CustomResourceDefinitionContext describes the core fields used to search for CustomResources
   * @param resourceType Class for CustomResource
   * @param listClass Class for list object for CustomResource
   * @param <T> T type represents CustomResource type. If it's Namespaced resource, it must implement
   *           io.fabric8.kubernetes.api.model.Namespaced
   * @param <L> L type represents CustomResourceList type
   * @return returns a MixedOperation object with which you can do basic CustomResource operations
   */
  @Deprecated
  <T extends HasMetadata, L extends KubernetesResourceList<T>> MixedOperation<T, L, Resource<T>> customResources(CustomResourceDefinitionContext crdContext, Class<T> resourceType, Class<L> listClass);
  
  /**
   * Semi-Typed API for managing {@link GenericKubernetesResource}s which can represent any resource.
   *
   * @param crdContext CustomResourceDefinitionContext describes the core fields
   * @return returns a MixedOperation object with which you can do basic operations
   */
  default MixedOperation<GenericKubernetesResource, GenericKubernetesResourceList, Resource<GenericKubernetesResource>> genericKubernetesResources(
      CustomResourceDefinitionContext crdContext) {
    return customResources(crdContext, GenericKubernetesResource.class, GenericKubernetesResourceList.class);
  }

  /**
   * Discovery API entrypoint for APIGroup discovery.k8s.io
   *
   * @return {@link DiscoveryAPIGroupDSL} with which you can access Discovery API resource objects
   */
  DiscoveryAPIGroupDSL discovery();

  /**
   * Event API entrypoint for APIGroup events.k8s.io
   *
   * <b>Note:</b> This should not be confused with v1.Event
   *
   * @return {@link EventingAPIGroupDSL} with which you can access Events API resources objects.
   */
  EventingAPIGroupDSL events();

  /**
   * Extensions API entrypoint for APIGroup extensions/v1beta1
   *
   * @return ExtensionsAPIGroupDSL with which you can access entrypoints for extension objects
   */
  ExtensionsAPIGroupDSL extensions();

  /**
   * FlowControl APIServer API for apigroup flowcontrol.apiserver.k8s.io
   *
   * @return {@link FlowControlAPIGroupDSL} with which you can access entry points for FlowControl objects
   */
  FlowControlAPIGroupDSL flowControl();

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
   * API entrypoint for kubernetes resources with APIGroup admissionregistration.k8s.io/v1beta1
   *
   * @return AdmissionRegistrationAPIGroupDSL which offers entrypoints to specific resources in this API group
   */
  AdmissionRegistrationAPIGroupDSL admissionRegistration();

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
  MixedOperation<ComponentStatus, ComponentStatusList, Resource<ComponentStatus>> componentstatuses();

  /**
   * Load a Kubernetes resource object from file InputStream
   *
   * @param is File input stream object containing json/yaml content
   * @return deserialized object
   */
  ParameterNamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata> load(InputStream is);

  /**
   * Load a Kubernetes list object
   *
   * @param s kubernetes list as string
   * @return deserialized KubernetesList object
   */
  ParameterNamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata> resourceList(String s);

  /**
   * KubernetesResourceList operations
   *
   * @param list KubernetesResourceList object containing kubernetes resource items
   * @return operations object for KubernetesResourceList
   */
  NamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata> resourceList(KubernetesResourceList list);

  /**
   * KubernetesResourceList operations
   *
   * @param items array of HasMetadata values
   * @return operations object for Kubernetes list
   */
  NamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata> resourceList(HasMetadata... items);

  /**
   * KubernetesResourceList operations
   *
   * @param items a collection containing HasMetadata values
   * @return operations object for Kubernetes list
   */
  NamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata> resourceList(Collection<HasMetadata> items);

  /**
   * KubernetesResource operations. You can pass any Kubernetes resource as a HasMetadata object and do
   * all operations
   *
   * @param is Kubernetes resource object
   * @param <T> type of Kubernetes resource
   * @return operations object for Kubernetes resource
   */
  <T extends HasMetadata> NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicable<T> resource(T is);

  /**
   * KubernetesResource operations. You can pass any Kubernetes resource as string object and do
   * all operations
   *
   * @param s Kubernetes resource object as string
   * @return operations object for Kubernetes resource
   */
  NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicable<HasMetadata> resource(String s);

  /**
   * Operations for Binding resource in APIgroup core/v1
   *
   * @return MixedOperation object for doing operations for Binding
   */
  MixedOperation<Binding, KubernetesResourceList<Binding>, Resource<Binding>> bindings();

  /**
   * API entrypoint for Endpoints with APIGroup core/v1
   *
   * @return MixedOperation object for doing operations for Endpoints
   */
  MixedOperation<Endpoints, EndpointsList, Resource<Endpoints>> endpoints();

  /**
   * API entrypoint for namespace related operations in Kubernetes. Namespace (core/v1)
   *
   * @return NonNamespaceOperation object for Namespace related operations
   */
  NonNamespaceOperation< Namespace, NamespaceList, Resource<Namespace>> namespaces();

  /**
   * API entrypoint for node related operations in Kubernetes. Node (core/v1)
   *
   * @return NonNamespaceOperation object for Node related operations
   */
  NonNamespaceOperation<Node, NodeList, Resource<Node>> nodes();

  /**
   * API entrypoint for PersistentVolume related operations. PersistentVolume (core/v1)
   *
   * @return NonNamespaceOperation object for PersistentVolume related operations.
   */
  NonNamespaceOperation<PersistentVolume, PersistentVolumeList, Resource<PersistentVolume>> persistentVolumes();

  /**
   * API entrypoint for PersistentVolumeClaim related operations. PersistentVolumeClaim (core/v1)
   *
   * @return MixedOperation object for PersistentVolumeClaim related operations.
   */
  MixedOperation<PersistentVolumeClaim, PersistentVolumeClaimList, Resource<PersistentVolumeClaim>> persistentVolumeClaims();

  /**
   * API entrypoint for Pod related operations. Pod (core/v1)
   *
   * @return MixedOperation object for Pod related operations
   */
  MixedOperation<Pod, PodList, PodResource<Pod>> pods();

  /**
   * API entrypoint for ReplicationController related operations. ReplicationController (core/v1)
   *
   * @return MixedOperation object for ReplicationController related operations.
   */
  MixedOperation<ReplicationController, ReplicationControllerList, RollableScalableResource<ReplicationController>> replicationControllers();

  /**
   * API entrypoint for ResourceQuota related operations. ResourceQuota (core/v1)
   *
   * @return MixedOperation object for ResourceQuota related operations.
   */
  MixedOperation<ResourceQuota, ResourceQuotaList, Resource<ResourceQuota>> resourceQuotas();

  /**
   * API entrypoint for Secret related operations. Secret (core/v1)
   *
   * @return MixedOperation object for Secret related operations.
   */
  MixedOperation<Secret, SecretList, Resource<Secret>> secrets();

  /**
   * API entrypoint for Service related operations. Service (core/v1)
   *
   * @return MixedOperation object for Service related operations.
   */
  MixedOperation<Service, ServiceList, ServiceResource<Service>> services();

  /**
   * API entrypoint for ServiceAccount related operations. ServiceAccount (core/v1)
   *
   * @return MixedOperation object for ServiceAccount related operations.
   */
  MixedOperation<ServiceAccount, ServiceAccountList, Resource<ServiceAccount>> serviceAccounts();

  /**
   * API entrypoint for APIService related operations. APIService (apiregistration.k8s.io/v1)
   *
   * @return MixedOperation object for APIService related operations
   */
  MixedOperation<APIService, APIServiceList, Resource<APIService>> apiServices();

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
  MixedOperation<ConfigMap, ConfigMapList, Resource<ConfigMap>> configMaps();

  /**
   * API entrypoint for LimitRange related operations. LimitRange (core/v1)
   *
   * @return MixedOperation object for LimitRange related operations.
   */
  MixedOperation<LimitRange, LimitRangeList, Resource<LimitRange>> limitRanges();

  /**
   * Authorization operations. (authorization.k8s.io/v1 and authorization.k8s.io/v1beta1)
   *
   * @return AuthorizationAPIGroupDSL object for dealing with Authorization objects
   */
  AuthorizationAPIGroupDSL authorization();

  /**
   * API for creating authentication.k8s.io/v1 TokenReviews
   *
   * @return InOutCreateable instance for creating TokenReview object
   */
  InOutCreateable<TokenReview, TokenReview> tokenReviews();

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
  MixedOperation<Lease, LeaseList, Resource<Lease>> leases();

  /**
   * API entrypoint for Core Kubernetes Resources (core/v1). Right now other core
   * resources have their own DSL entrypoints. But in future, all core/v1 resources
   * would be added here.
   *
   * @return V1APIGroupDSL DSL object for core v1 resources
   */
  V1APIGroupDSL v1();

  /**
   * Run a Pod (core/v1)
   *
   * @return returns {@link RunOperations} that allows you to run a pod based on few parameters(e.g. name, image etc)
   */
  RunOperations run();

  /**
   * API entrypoint for RuntimeClass (node.k8s.io/v1beta1)
   *
   * @return {@link NonNamespaceOperation} for RuntimeClass
   */
  NonNamespaceOperation<RuntimeClass, RuntimeClassList, Resource<RuntimeClass>> runtimeClasses();
}
