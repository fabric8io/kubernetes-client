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
package io.fabric8.kubernetes.client.impl;

import io.fabric8.kubernetes.api.model.APIGroup;
import io.fabric8.kubernetes.api.model.APIGroupBuilder;
import io.fabric8.kubernetes.api.model.APIGroupList;
import io.fabric8.kubernetes.api.model.APIResource;
import io.fabric8.kubernetes.api.model.APIResourceList;
import io.fabric8.kubernetes.api.model.APIService;
import io.fabric8.kubernetes.api.model.APIServiceList;
import io.fabric8.kubernetes.api.model.Binding;
import io.fabric8.kubernetes.api.model.ComponentStatus;
import io.fabric8.kubernetes.api.model.ComponentStatusList;
import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.ConfigMapList;
import io.fabric8.kubernetes.api.model.Endpoints;
import io.fabric8.kubernetes.api.model.EndpointsList;
import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.api.model.GenericKubernetesResourceList;
import io.fabric8.kubernetes.api.model.GroupVersionForDiscovery;
import io.fabric8.kubernetes.api.model.GroupVersionForDiscoveryBuilder;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesListBuilder;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.LimitRange;
import io.fabric8.kubernetes.api.model.LimitRangeList;
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
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.ServiceAccount;
import io.fabric8.kubernetes.api.model.ServiceAccountList;
import io.fabric8.kubernetes.api.model.ServiceList;
import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.api.model.apps.ReplicaSet;
import io.fabric8.kubernetes.api.model.apps.StatefulSet;
import io.fabric8.kubernetes.api.model.authentication.TokenReview;
import io.fabric8.kubernetes.api.model.batch.v1.Job;
import io.fabric8.kubernetes.api.model.certificates.v1beta1.CertificateSigningRequest;
import io.fabric8.kubernetes.api.model.certificates.v1beta1.CertificateSigningRequestList;
import io.fabric8.kubernetes.api.model.coordination.v1.Lease;
import io.fabric8.kubernetes.api.model.coordination.v1.LeaseList;
import io.fabric8.kubernetes.api.model.node.v1beta1.RuntimeClass;
import io.fabric8.kubernetes.api.model.node.v1beta1.RuntimeClassList;
import io.fabric8.kubernetes.client.AdmissionRegistrationAPIGroupDSL;
import io.fabric8.kubernetes.client.ApiVisitor;
import io.fabric8.kubernetes.client.ApiVisitor.ApiVisitResult;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientBuilder.ExecutorSupplier;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.NamespacedKubernetesClient;
import io.fabric8.kubernetes.client.RequestConfig;
import io.fabric8.kubernetes.client.V1AdmissionRegistrationAPIGroupDSL;
import io.fabric8.kubernetes.client.V1Alpha1AdmissionRegistrationAPIGroupDSL;
import io.fabric8.kubernetes.client.V1Alpha1NetworkAPIGroupDSL;
import io.fabric8.kubernetes.client.V1Alpha2DynamicResourceAllocationAPIGroupDSL;
import io.fabric8.kubernetes.client.V1ApiextensionAPIGroupDSL;
import io.fabric8.kubernetes.client.V1AuthenticationAPIGroupDSL;
import io.fabric8.kubernetes.client.V1AuthorizationAPIGroupDSL;
import io.fabric8.kubernetes.client.V1AutoscalingAPIGroupDSL;
import io.fabric8.kubernetes.client.V1NetworkAPIGroupDSL;
import io.fabric8.kubernetes.client.V1beta1AdmissionRegistrationAPIGroupDSL;
import io.fabric8.kubernetes.client.V1beta1ApiextensionAPIGroupDSL;
import io.fabric8.kubernetes.client.V1beta1AuthorizationAPIGroupDSL;
import io.fabric8.kubernetes.client.V1beta1NetworkAPIGroupDSL;
import io.fabric8.kubernetes.client.V2AutoscalingAPIGroupDSL;
import io.fabric8.kubernetes.client.V2beta1AutoscalingAPIGroupDSL;
import io.fabric8.kubernetes.client.V2beta2AutoscalingAPIGroupDSL;
import io.fabric8.kubernetes.client.VersionInfo;
import io.fabric8.kubernetes.client.WithRequestCallable;
import io.fabric8.kubernetes.client.dsl.ApiextensionsAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.AppsAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.AuthenticationAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.AuthorizationAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.AutoscalingAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.BatchAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.CertificatesAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.DiscoveryAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.DynamicResourceAllocationAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.EventingAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.ExtensionsAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.FlowControlAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.FunctionCallable;
import io.fabric8.kubernetes.client.dsl.InOutCreateable;
import io.fabric8.kubernetes.client.dsl.MetricAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NamespaceListVisitFromServerGetDeleteRecreateWaitApplicable;
import io.fabric8.kubernetes.client.dsl.NamespaceableResource;
import io.fabric8.kubernetes.client.dsl.NetworkAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.PodResource;
import io.fabric8.kubernetes.client.dsl.PolicyAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.RbacAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.RollableScalableResource;
import io.fabric8.kubernetes.client.dsl.SchedulingAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.ServiceAccountResource;
import io.fabric8.kubernetes.client.dsl.ServiceResource;
import io.fabric8.kubernetes.client.dsl.StorageAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.V1APIGroupDSL;
import io.fabric8.kubernetes.client.dsl.V1Alpha1AuthenticationAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.V1Alpha1CertificatesAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.V1BatchAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.V1Beta1AuthenticationAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.V1CertificatesAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.V1DiscoveryAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.V1EventingAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.V1PolicyAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.V1SchedulingAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.V1beta1BatchAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.V1beta1CertificatesAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.V1beta1DiscoveryAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.V1beta1EventingAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.V1beta1FlowControlAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.V1beta1PolicyAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.V1beta1SchedulingAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.V1beta2FlowControlAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.V1beta3FlowControlAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.base.ResourceDefinitionContext;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperation;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl;
import io.fabric8.kubernetes.client.dsl.internal.OperationContext;
import io.fabric8.kubernetes.client.dsl.internal.apps.v1.DeploymentOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.apps.v1.ReplicaSetOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.apps.v1.StatefulSetOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.batch.v1.JobOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.certificates.v1.CertificateSigningRequestOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.core.v1.PodOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.core.v1.ReplicationControllerOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.core.v1.ServiceAccountOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.core.v1.ServiceOperationsImpl;
import io.fabric8.kubernetes.client.extended.leaderelection.LeaderElectorBuilder;
import io.fabric8.kubernetes.client.extended.run.RunConfigBuilder;
import io.fabric8.kubernetes.client.extended.run.RunOperations;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.informers.SharedInformerFactory;
import io.fabric8.kubernetes.client.informers.impl.SharedInformerFactoryImpl;
import io.fabric8.kubernetes.client.utils.ApiVersionUtil;
import io.fabric8.kubernetes.client.utils.KubernetesSerialization;
import io.fabric8.kubernetes.client.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Class for Kubernetes Client implementing KubernetesClient interface.
 * It is thread safe.
 */
public class KubernetesClientImpl extends BaseClient implements NamespacedKubernetesClient {

  public static final Logger logger = LoggerFactory.getLogger(KubernetesClientImpl.class);

  public static final String KUBERNETES_VERSION_ENDPOINT = "version";

  /**
   * Used by test logic
   */
  public KubernetesClientImpl(HttpClient httpClient, Config config) {
    this(httpClient, config, () -> Runnable::run, new KubernetesSerialization());
  }

  public KubernetesClientImpl(HttpClient httpClient, Config config, ExecutorSupplier executorSupplier,
      KubernetesSerialization kubernetesSerialization) {
    super(httpClient, config, executorSupplier, kubernetesSerialization);

    registerDefaultAdapters();
    registerDefaultHandlers();
  }

  protected KubernetesClientImpl(BaseClient client) {
    super(client);
  }

  /**
   * Registers the default adapters for this client.
   */
  protected void registerDefaultAdapters() {
    // Register adapters
    Adapters adapters = getAdapters();
    adapters.registerClient(AppsAPIGroupDSL.class, new AppsAPIGroupClient());
    adapters.registerClient(AdmissionRegistrationAPIGroupDSL.class, new AdmissionRegistrationAPIGroupClient());
    adapters.registerClient(V1AdmissionRegistrationAPIGroupDSL.class, new V1AdmissionRegistrationAPIGroupClient());
    adapters.registerClient(V1beta1AdmissionRegistrationAPIGroupDSL.class,
        new V1beta1AdmissionRegistrationAPIGroupClient());
    adapters.registerClient(V1Alpha1AdmissionRegistrationAPIGroupDSL.class,
        new V1Alpha1AdmissionRegistrationAPIGroupClient());
    adapters.registerClient(AutoscalingAPIGroupDSL.class, new AutoscalingAPIGroupClient());
    adapters.registerClient(ApiextensionsAPIGroupDSL.class, new ApiextensionsAPIGroupClient());
    adapters.registerClient(AuthorizationAPIGroupDSL.class, new AuthorizationAPIGroupClient());
    adapters.registerClient(AuthenticationAPIGroupDSL.class, new AuthenticationAPIGroupClient());
    adapters.registerClient(V1AutoscalingAPIGroupDSL.class, new V1AutoscalingAPIGroupClient());
    adapters.registerClient(V2AutoscalingAPIGroupDSL.class, new V2AutoscalingAPIGroupClient());
    adapters.registerClient(V2beta1AutoscalingAPIGroupDSL.class, new V2beta1AutoscalingAPIGroupClient());
    adapters.registerClient(V2beta2AutoscalingAPIGroupDSL.class, new V2beta2AutoscalingAPIGroupClient());
    adapters.registerClient(BatchAPIGroupDSL.class, new BatchAPIGroupClient());
    adapters.registerClient(V1BatchAPIGroupDSL.class, new V1BatchAPIGroupClient());
    adapters.registerClient(V1beta1BatchAPIGroupDSL.class, new V1beta1BatchAPIGroupClient());
    adapters.registerClient(ExtensionsAPIGroupDSL.class, new ExtensionsAPIGroupClient());
    adapters.registerClient(EventingAPIGroupDSL.class, new EventingAPIGroupClient());
    adapters.registerClient(V1EventingAPIGroupDSL.class, new V1EventingAPIGroupClient());
    adapters.registerClient(V1beta1EventingAPIGroupDSL.class, new V1beta1EventingAPIGroupClient());
    adapters.registerClient(FlowControlAPIGroupDSL.class, new FlowControlAPIGroupClient());
    adapters.registerClient(V1beta1FlowControlAPIGroupDSL.class, new V1beta1FlowControlAPIGroupClient());
    adapters.registerClient(V1beta2FlowControlAPIGroupDSL.class, new V1beta2FlowControlAPIGroupClient());
    adapters.registerClient(V1beta3FlowControlAPIGroupDSL.class, new V1beta3FlowControlAPIGroupClient());
    adapters.registerClient(MetricAPIGroupDSL.class, new MetricAPIGroupClient());
    adapters.registerClient(NetworkAPIGroupDSL.class, new NetworkAPIGroupClient());
    adapters.registerClient(PolicyAPIGroupDSL.class, new PolicyAPIGroupClient());
    adapters.registerClient(V1PolicyAPIGroupDSL.class, new V1PolicyAPIGroupClient());
    adapters.registerClient(V1beta1PolicyAPIGroupDSL.class, new V1beta1PolicyAPIGroupClient());
    adapters.registerClient(RbacAPIGroupDSL.class, new RbacAPIGroupClient());
    adapters.registerClient(SchedulingAPIGroupDSL.class, new SchedulingAPIGroupClient());
    adapters.registerClient(V1SchedulingAPIGroupDSL.class, new V1SchedulingAPIGroupClient());
    adapters.registerClient(V1beta1SchedulingAPIGroupDSL.class, new V1beta1SchedulingAPIGroupClient());
    adapters.registerClient(StorageAPIGroupDSL.class, new StorageAPIGroupClient());
    adapters.registerClient(V1StorageAPIGroupClient.class, new V1StorageAPIGroupClient());
    adapters.registerClient(V1beta1StorageAPIGroupClient.class, new V1beta1StorageAPIGroupClient());
    adapters.registerClient(V1APIGroupDSL.class, new V1APIGroupClient());
    adapters.registerClient(V1ApiextensionAPIGroupDSL.class, new V1ApiextensionsAPIGroupClient());
    adapters.registerClient(V1beta1ApiextensionAPIGroupDSL.class, new V1beta1ApiextensionsAPIGroupClient());
    adapters.registerClient(V1AuthorizationAPIGroupDSL.class, new V1AuthorizationAPIGroupClient());
    adapters.registerClient(V1beta1AuthorizationAPIGroupDSL.class, new V1beta1AuthorizationAPIGroupClient());
    adapters.registerClient(V1AuthenticationAPIGroupDSL.class, new V1AuthenticationAPIGroupClient());
    adapters.registerClient(V1Alpha1AuthenticationAPIGroupDSL.class, new V1Alpha1AuthenticationAPIGroupClient());
    adapters.registerClient(V1Beta1AuthenticationAPIGroupDSL.class, new V1Beta1AuthenticationAPIGroupClient());
    adapters.registerClient(V1NetworkAPIGroupDSL.class, new V1NetworkAPIGroupClient());
    adapters.registerClient(V1beta1NetworkAPIGroupDSL.class, new V1beta1NetworkAPIGroupClient());
    adapters.registerClient(V1Alpha1NetworkAPIGroupDSL.class, new V1Alpha1NetworkAPIGroupClient());
    adapters.registerClient(DiscoveryAPIGroupDSL.class, new DiscoveryAPIGroupClient());
    adapters.registerClient(V1beta1DiscoveryAPIGroupDSL.class, new V1beta1DiscoveryAPIGroupClient());
    adapters.registerClient(V1DiscoveryAPIGroupDSL.class, new V1DiscoveryAPIGroupClient());
    adapters.registerClient(DynamicResourceAllocationAPIGroupDSL.class,
        new DynamicResourceAllocationAPIGroupClient());
    adapters.registerClient(V1Alpha2DynamicResourceAllocationAPIGroupDSL.class,
        new V1Alpha2DynamicResourceAllocationAPIGroupClient());
    adapters.registerClient(CertificatesAPIGroupDSL.class, new CertificatesAPIGroupClient());
    adapters.registerClient(V1CertificatesAPIGroupDSL.class, new V1CertificatesAPIGroupClient());
    adapters.registerClient(V1beta1CertificatesAPIGroupDSL.class, new V1beta1CertificatesAPIGroupClient());
    adapters.registerClient(V1Alpha1CertificatesAPIGroupDSL.class, new V1Alpha1CertificatesAPIGroupClient());
  }

  /**
   * Registers default handlers for Kubernetes resources.
   */
  protected void registerDefaultHandlers() {
    // Register Handlers
    Handlers handlers = getHandlers();
    handlers.register(Pod.class, PodOperationsImpl::new);
    handlers.register(ServiceAccount.class, ServiceAccountOperationsImpl::new);
    handlers.register(Job.class, JobOperationsImpl::new);
    handlers.register(Service.class, ServiceOperationsImpl::new);
    handlers.register(Deployment.class, DeploymentOperationsImpl::new);
    handlers.register(io.fabric8.kubernetes.api.model.extensions.Deployment.class,
        io.fabric8.kubernetes.client.dsl.internal.extensions.v1beta1.DeploymentOperationsImpl::new);
    handlers.register(ReplicaSet.class, ReplicaSetOperationsImpl::new);
    handlers.register(io.fabric8.kubernetes.api.model.extensions.ReplicaSet.class,
        io.fabric8.kubernetes.client.dsl.internal.extensions.v1beta1.ReplicaSetOperationsImpl::new);
    handlers.register(ReplicationController.class, ReplicationControllerOperationsImpl::new);
    handlers.register(StatefulSet.class, StatefulSetOperationsImpl::new);
    handlers.register(io.fabric8.kubernetes.api.model.certificates.v1.CertificateSigningRequest.class,
        CertificateSigningRequestOperationsImpl::new);
    handlers.register(CertificateSigningRequest.class,
        io.fabric8.kubernetes.client.dsl.internal.certificates.v1beta1.CertificateSigningRequestOperationsImpl::new);
  }

  @Override
  public NamespacedKubernetesClient inNamespace(String name) {
    return newClient(createInNamespaceContext(name, false), NamespacedKubernetesClient.class);
  }

  protected OperationContext createInNamespaceContext(String name, boolean any) {
    if (!any && name == null) {
      throw new KubernetesClientException("namespace cannot be null");
    }
    return HasMetadataOperationsImpl.defaultContext(this).withNamespace(name);
  }

  @Override
  public LeaderElectorBuilder leaderElector() {
    return new LeaderElectorBuilder(this, this.getExecutor());
  }

  @Override
  public FunctionCallable<? extends NamespacedKubernetesClient> withRequestConfig(RequestConfig requestConfig) {
    return new WithRequestCallable<>(this, requestConfig);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public NonNamespaceOperation<ComponentStatus, ComponentStatusList, Resource<ComponentStatus>> componentstatuses() {
    return resources(ComponentStatus.class, ComponentStatusList.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public NamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata> load(InputStream is) {
    return resourceListFor(kubernetesSerialization.unmarshal(is));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public NamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata> resourceList(KubernetesResourceList item) {
    return resourceListFor(item);
  }

  public NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl resourceListFor(Object item) {
    return new NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl(this, item);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public NamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata> resourceList(HasMetadata... items) {
    return resourceList(new KubernetesListBuilder().withItems(items).build());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public NamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata> resourceList(
      Collection<? extends HasMetadata> items) {
    return resourceList(new KubernetesListBuilder().withItems(new ArrayList<>(items)).build());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public NamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata> resourceList(String s) {
    return resourceListFor(kubernetesSerialization.unmarshal(s));
  }

  @Override
  public <T extends HasMetadata> NamespaceableResource<T> resource(T item) {
    // lookup the operation given the item
    ResourceHandler<T, ?> resourceHandler = getHandlers().get(item, this);
    HasMetadataOperation<T, ?, ?> op = resourceHandler.operation(this, null);
    return new NamespaceableResourceAdapter<>(item, op);
  }

  private NamespaceableResource<HasMetadata> resource(Object resource) {
    if (resource instanceof HasMetadata) {
      return resource((HasMetadata) resource);
    }
    throw new KubernetesClientException("Unable to create a valid resource from the provided object (" +
        resource.getClass().getName() + ")");
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public NamespaceableResource<HasMetadata> resource(String s) {
    return resource(kubernetesSerialization.<Object> unmarshal(s));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public NamespaceableResource<HasMetadata> resource(InputStream is) {
    return resource(kubernetesSerialization.<Object> unmarshal(is));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public MixedOperation<Binding, KubernetesResourceList<Binding>, Resource<Binding>> bindings() {
    return resources(Binding.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public MixedOperation<Endpoints, EndpointsList, Resource<Endpoints>> endpoints() {
    return resources(Endpoints.class, EndpointsList.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public NonNamespaceOperation<Namespace, NamespaceList, Resource<Namespace>> namespaces() {
    return resources(Namespace.class, NamespaceList.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public NonNamespaceOperation<Node, NodeList, Resource<Node>> nodes() {
    return resources(Node.class, NodeList.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public NonNamespaceOperation<PersistentVolume, PersistentVolumeList, Resource<PersistentVolume>> persistentVolumes() {
    return resources(PersistentVolume.class, PersistentVolumeList.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public MixedOperation<PersistentVolumeClaim, PersistentVolumeClaimList, Resource<PersistentVolumeClaim>> persistentVolumeClaims() {
    return resources(PersistentVolumeClaim.class, PersistentVolumeClaimList.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public MixedOperation<Pod, PodList, PodResource> pods() {
    return new PodOperationsImpl(this);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public MixedOperation<ReplicationController, ReplicationControllerList, RollableScalableResource<ReplicationController>> replicationControllers() {
    return new ReplicationControllerOperationsImpl(this);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public MixedOperation<ResourceQuota, ResourceQuotaList, Resource<ResourceQuota>> resourceQuotas() {
    return resources(ResourceQuota.class, ResourceQuotaList.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public SchedulingAPIGroupDSL scheduling() {
    return adapt(SchedulingAPIGroupClient.class);
  }

  @Override
  public MixedOperation<Secret, SecretList, Resource<Secret>> secrets() {
    return resources(Secret.class, SecretList.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public MixedOperation<Service, ServiceList, ServiceResource<Service>> services() {
    return new ServiceOperationsImpl(this);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public MixedOperation<ServiceAccount, ServiceAccountList, ServiceAccountResource> serviceAccounts() {
    return new ServiceAccountOperationsImpl(this);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public NonNamespaceOperation<APIService, APIServiceList, Resource<APIService>> apiServices() {
    return resources(APIService.class, APIServiceList.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public MixedOperation<ConfigMap, ConfigMapList, Resource<ConfigMap>> configMaps() {
    return resources(ConfigMap.class, ConfigMapList.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public MixedOperation<LimitRange, LimitRangeList, Resource<LimitRange>> limitRanges() {
    return resources(LimitRange.class, LimitRangeList.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ApiextensionsAPIGroupDSL apiextensions() {
    return adapt(ApiextensionsAPIGroupClient.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public NonNamespaceOperation<CertificateSigningRequest, CertificateSigningRequestList, Resource<CertificateSigningRequest>> certificateSigningRequests() {
    return resources(CertificateSigningRequest.class, CertificateSigningRequestList.class);
  }

  @Override
  public CertificatesAPIGroupDSL certificates() {
    return adapt(CertificatesAPIGroupClient.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public AuthorizationAPIGroupDSL authorization() {
    return adapt(AuthorizationAPIGroupClient.class);
  }

  @Override
  public AuthenticationAPIGroupDSL authentication() {
    return adapt(AuthenticationAPIGroupClient.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public InOutCreateable<TokenReview, TokenReview> tokenReviews() {
    return getHandlers().getNonListingOperation(TokenReview.class, this);
  }

  @Override
  public MixedOperation<GenericKubernetesResource, GenericKubernetesResourceList, Resource<GenericKubernetesResource>> genericKubernetesResources(
      String apiVersion, String kind) {
    ResourceDefinitionContext context = getHandlers().getResourceDefinitionContext(apiVersion, kind, this);
    if (context == null) {
      throw new KubernetesClientException(
          "Could not find the metadata for the given apiVersion and kind, please pass a ResourceDefinitionContext instead");
    }
    return genericKubernetesResources(context);
  }

  @Override
  public MixedOperation<GenericKubernetesResource, GenericKubernetesResourceList, Resource<GenericKubernetesResource>> genericKubernetesResources(
      ResourceDefinitionContext context) {
    return newHasMetadataOperation(context, GenericKubernetesResource.class, GenericKubernetesResourceList.class);
  }

  @Override
  public DiscoveryAPIGroupDSL discovery() {
    return adapt(DiscoveryAPIGroupClient.class);
  }

  @Override
  public DynamicResourceAllocationAPIGroupDSL dynamicResourceAllocation() {
    return adapt(DynamicResourceAllocationAPIGroupClient.class);
  }

  @Override
  public EventingAPIGroupDSL events() {
    return adapt(EventingAPIGroupClient.class);
  }

  @Override
  public NamespacedKubernetesClient inAnyNamespace() {
    return newClient(createInNamespaceContext(null, true), NamespacedKubernetesClient.class);
  }

  @Override
  protected KubernetesClientImpl copy() {
    return new KubernetesClientImpl(this);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ExtensionsAPIGroupDSL extensions() {
    return adapt(ExtensionsAPIGroupClient.class);
  }

  @Override
  public FlowControlAPIGroupDSL flowControl() {
    return adapt(FlowControlAPIGroupClient.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public VersionInfo getVersion() {
    return getVersionInfo(KUBERNETES_VERSION_ENDPOINT);
  }

  @Override
  public VersionInfo getKubernetesVersion() {
    return getVersionInfo(KUBERNETES_VERSION_ENDPOINT);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public V1APIGroupDSL v1() {
    return adapt(V1APIGroupClient.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public AdmissionRegistrationAPIGroupDSL admissionRegistration() {
    return adapt(AdmissionRegistrationAPIGroupClient.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public AppsAPIGroupDSL apps() {
    return adapt(AppsAPIGroupClient.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public AutoscalingAPIGroupDSL autoscaling() {
    return adapt(AutoscalingAPIGroupClient.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public NetworkAPIGroupDSL network() {
    return adapt(NetworkAPIGroupClient.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public StorageAPIGroupDSL storage() {
    return adapt(StorageAPIGroupClient.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public BatchAPIGroupDSL batch() {
    return adapt(BatchAPIGroupClient.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public MetricAPIGroupDSL top() {
    return adapt(MetricAPIGroupClient.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public PolicyAPIGroupDSL policy() {
    return adapt(PolicyAPIGroupClient.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public RbacAPIGroupDSL rbac() {
    return adapt(RbacAPIGroupClient.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public SharedInformerFactory informers() {
    return new SharedInformerFactoryImpl(this);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public MixedOperation<Lease, LeaseList, Resource<Lease>> leases() {
    return resources(Lease.class, LeaseList.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public RunOperations run() {
    return new RunOperations(this, new RunConfigBuilder().build());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public NonNamespaceOperation<RuntimeClass, RuntimeClassList, Resource<RuntimeClass>> runtimeClasses() {
    return resources(RuntimeClass.class, RuntimeClassList.class);
  }

  @Override
  public Client newClient(RequestConfig requestConfig) {
    return newClient(HasMetadataOperationsImpl.defaultContext(this).withRequestConfig(requestConfig), Client.class);
  }

  @Override
  public void visitResources(ApiVisitor visitor) {
    if (visitGroups(visitor, Arrays.asList(new APIGroupBuilder().withName("")
        .withVersions(new GroupVersionForDiscoveryBuilder().withGroupVersion("v1").build()).build()))) {
      return; // user terminated
    }
    APIGroupList apiGroups = getApiGroups();
    if (apiGroups != null) {
      visitGroups(visitor, apiGroups.getGroups());
    }
  }

  private boolean visitGroups(ApiVisitor visitor, List<APIGroup> groups) {
    for (APIGroup group : groups) {
      switch (visitor.visitApiGroup(group.getName())) {
        case TERMINATE:
          return true;
        case SKIP:
          continue;
        case CONTINUE:
          for (GroupVersionForDiscovery groupForDiscovery : group.getVersions()) {
            String groupVersion = groupForDiscovery.getGroupVersion();
            String groupName = Utils.getNonNullOrElse(ApiVersionUtil.trimGroupOrNull(groupVersion), "");
            String version = ApiVersionUtil.trimVersion(groupVersion);
            ApiVisitResult versionResult = visitor.visitApiGroupVersion(groupName, version);
            switch (versionResult) {
              case TERMINATE:
                return true;
              case SKIP:
                continue;
              case CONTINUE:
                APIResourceList apiResources = this.getApiResources(groupVersion);
                if (apiResources == null) {
                  if (logger.isDebugEnabled()) {
                    logger.debug("{} is discoverable, but is not yet populating an APIResource list", groupVersion);
                  }
                  continue;
                }
                for (APIResource resource : apiResources.getResources()) {
                  if (resource.getName().contains("/")) { // skip subresources
                    continue;
                  }
                  ApiVisitResult resourceResult = visitor.visitResource(groupName, version, resource,
                      this.genericKubernetesResources(ResourceDefinitionContext.fromApiResource(groupVersion, resource)));
                  if (resourceResult == ApiVisitResult.TERMINATE) {
                    return true;
                  }
                }
            }
          }
      }
    }
    return false;
  }

}
