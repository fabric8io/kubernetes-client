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

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.type.TypeFactory;
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
import io.fabric8.kubernetes.client.KubernetesClientBuilder.ExecutorSupplier;
import io.fabric8.kubernetes.client.dsl.ApiextensionsAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.AppsAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.AuthorizationAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.AutoscalingAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.BatchAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.CertificatesAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.DiscoveryAPIGroupDSL;
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
import io.fabric8.kubernetes.client.dsl.ParameterNamespaceListVisitFromServerGetDeleteRecreateWaitApplicable;
import io.fabric8.kubernetes.client.dsl.PodResource;
import io.fabric8.kubernetes.client.dsl.PolicyAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.RbacAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.RollableScalableResource;
import io.fabric8.kubernetes.client.dsl.SchedulingAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.ServiceResource;
import io.fabric8.kubernetes.client.dsl.StorageAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.V1APIGroupDSL;
import io.fabric8.kubernetes.client.dsl.V1BatchAPIGroupDSL;
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
import io.fabric8.kubernetes.client.dsl.base.ResourceDefinitionContext;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperation;
import io.fabric8.kubernetes.client.dsl.internal.NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl;
import io.fabric8.kubernetes.client.dsl.internal.apps.v1.DeploymentOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.apps.v1.ReplicaSetOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.apps.v1.StatefulSetOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.batch.v1.JobOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.certificates.v1.CertificateSigningRequestOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.core.v1.PodOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.core.v1.ReplicationControllerOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.core.v1.ServiceOperationsImpl;
import io.fabric8.kubernetes.client.extended.leaderelection.LeaderElectorBuilder;
import io.fabric8.kubernetes.client.extended.run.RunConfigBuilder;
import io.fabric8.kubernetes.client.extended.run.RunOperations;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.informers.SharedInformerFactory;
import io.fabric8.kubernetes.client.informers.impl.SharedInformerFactoryImpl;
import io.fabric8.kubernetes.client.utils.HttpClientUtils;
import io.fabric8.kubernetes.client.utils.Serialization;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Class for Default Kubernetes Client implementing KubernetesClient interface.
 * It is thread safe.
 *
 * @deprecated direct usage should no longer be needed. Please use the {@link KubernetesClientBuilder} instead.
 */
@Deprecated
public class DefaultKubernetesClient extends BaseClient implements NamespacedKubernetesClient {

  public static final String KUBERNETES_VERSION_ENDPOINT = "version";

  public DefaultKubernetesClient() {
    this(new ConfigBuilder().build());
  }

  public DefaultKubernetesClient(String masterUrl) {
    this(new ConfigBuilder().withMasterUrl(masterUrl).build());
  }

  public DefaultKubernetesClient(Config config) {
    this(HttpClientUtils.createHttpClient(config), config);
  }

  public DefaultKubernetesClient(HttpClient httpClient, Config config) {
    this(httpClient, config, null);
  }

  public DefaultKubernetesClient(HttpClient httpClient, Config config, ExecutorSupplier executorSupplier) {
    super(httpClient, config, executorSupplier);

    this.getAdapters().registerClient(AppsAPIGroupDSL.class, new AppsAPIGroupClient());
    this.getAdapters().registerClient(AdmissionRegistrationAPIGroupDSL.class, new AdmissionRegistrationAPIGroupClient());
    this.getAdapters().registerClient(V1AdmissionRegistrationAPIGroupDSL.class, new V1AdmissionRegistrationAPIGroupClient());
    this.getAdapters().registerClient(V1beta1AdmissionRegistrationAPIGroupDSL.class,
        new V1beta1AdmissionRegistrationAPIGroupClient());
    this.getAdapters().registerClient(AutoscalingAPIGroupDSL.class, new AutoscalingAPIGroupClient());
    this.getAdapters().registerClient(ApiextensionsAPIGroupDSL.class, new ApiextensionsAPIGroupClient());
    this.getAdapters().registerClient(AuthorizationAPIGroupDSL.class, new AuthorizationAPIGroupClient());
    this.getAdapters().registerClient(V1AutoscalingAPIGroupDSL.class, new V1AutoscalingAPIGroupClient());
    this.getAdapters().registerClient(V2beta1AutoscalingAPIGroupDSL.class, new V2beta1AutoscalingAPIGroupClient());
    this.getAdapters().registerClient(V2beta2AutoscalingAPIGroupDSL.class, new V2beta2AutoscalingAPIGroupClient());
    this.getAdapters().registerClient(BatchAPIGroupDSL.class, new BatchAPIGroupClient());
    this.getAdapters().registerClient(V1BatchAPIGroupDSL.class, new V1BatchAPIGroupClient());
    this.getAdapters().registerClient(V1beta1BatchAPIGroupDSL.class, new V1beta1BatchAPIGroupClient());
    this.getAdapters().registerClient(ExtensionsAPIGroupDSL.class, new ExtensionsAPIGroupClient());
    this.getAdapters().registerClient(EventingAPIGroupDSL.class, new EventingAPIGroupClient());
    this.getAdapters().registerClient(V1EventingAPIGroupDSL.class, new V1EventingAPIGroupClient());
    this.getAdapters().registerClient(V1beta1EventingAPIGroupDSL.class, new V1beta1EventingAPIGroupClient());
    this.getAdapters().registerClient(FlowControlAPIGroupDSL.class, new FlowControlAPIGroupClient());
    this.getAdapters().registerClient(V1beta1FlowControlAPIGroupDSL.class, new V1beta1FlowControlAPIGroupClient());
    this.getAdapters().registerClient(MetricAPIGroupDSL.class, new MetricAPIGroupClient());
    this.getAdapters().registerClient(NetworkAPIGroupDSL.class, new NetworkAPIGroupClient());
    this.getAdapters().registerClient(PolicyAPIGroupDSL.class, new PolicyAPIGroupClient());
    this.getAdapters().registerClient(V1PolicyAPIGroupDSL.class, new V1PolicyAPIGroupClient());
    this.getAdapters().registerClient(V1beta1PolicyAPIGroupDSL.class, new V1beta1PolicyAPIGroupClient());
    this.getAdapters().registerClient(RbacAPIGroupDSL.class, new RbacAPIGroupClient());
    this.getAdapters().registerClient(SchedulingAPIGroupDSL.class, new SchedulingAPIGroupClient());
    this.getAdapters().registerClient(V1SchedulingAPIGroupDSL.class, new V1SchedulingAPIGroupClient());
    this.getAdapters().registerClient(V1beta1SchedulingAPIGroupDSL.class, new V1beta1SchedulingAPIGroupClient());
    this.getAdapters().registerClient(StorageAPIGroupDSL.class, new StorageAPIGroupClient());
    this.getAdapters().registerClient(V1StorageAPIGroupClient.class, new V1StorageAPIGroupClient());
    this.getAdapters().registerClient(V1beta1StorageAPIGroupClient.class, new V1beta1StorageAPIGroupClient());
    this.getAdapters().registerClient(V1APIGroupDSL.class, new V1APIGroupClient());
    this.getAdapters().registerClient(V1ApiextensionAPIGroupDSL.class, new V1ApiextensionsAPIGroupClient());
    this.getAdapters().registerClient(V1beta1ApiextensionAPIGroupDSL.class, new V1beta1ApiextensionsAPIGroupClient());
    this.getAdapters().registerClient(V1AuthorizationAPIGroupDSL.class, new V1AuthorizationAPIGroupClient());
    this.getAdapters().registerClient(V1beta1AuthorizationAPIGroupDSL.class, new V1beta1AuthorizationAPIGroupClient());
    this.getAdapters().registerClient(V1NetworkAPIGroupDSL.class, new V1NetworkAPIGroupClient());
    this.getAdapters().registerClient(V1beta1NetworkAPIGroupDSL.class, new V1beta1NetworkAPIGroupClient());
    this.getAdapters().registerClient(DiscoveryAPIGroupDSL.class, new DiscoveryAPIGroupClient());
    this.getAdapters().registerClient(V1beta1DiscoveryAPIGroupDSL.class, new V1beta1DiscoveryAPIGroupClient());
    this.getAdapters().registerClient(V1DiscoveryAPIGroupDSL.class, new V1DiscoveryAPIGroupClient());
    this.getAdapters().registerClient(CertificatesAPIGroupDSL.class, new CertificatesAPIGroupClient());
    this.getAdapters().registerClient(V1CertificatesAPIGroupDSL.class, new V1CertificatesAPIGroupClient());
    this.getAdapters().registerClient(V1beta1CertificatesAPIGroupDSL.class, new V1beta1CertificatesAPIGroupClient());

    this.getHandlers().register(Pod.class, PodOperationsImpl::new);
    this.getHandlers().register(Job.class, JobOperationsImpl::new);
    this.getHandlers().register(Service.class, ServiceOperationsImpl::new);
    this.getHandlers().register(Deployment.class, DeploymentOperationsImpl::new);
    this.getHandlers().register(io.fabric8.kubernetes.api.model.extensions.Deployment.class,
        io.fabric8.kubernetes.client.dsl.internal.extensions.v1beta1.DeploymentOperationsImpl::new);
    this.getHandlers().register(ReplicaSet.class, ReplicaSetOperationsImpl::new);
    this.getHandlers().register(io.fabric8.kubernetes.api.model.extensions.ReplicaSet.class,
        io.fabric8.kubernetes.client.dsl.internal.extensions.v1beta1.ReplicaSetOperationsImpl::new);
    this.getHandlers().register(ReplicationController.class, ReplicationControllerOperationsImpl::new);
    this.getHandlers().register(StatefulSet.class, StatefulSetOperationsImpl::new);
    this.getHandlers().register(io.fabric8.kubernetes.api.model.certificates.v1.CertificateSigningRequest.class,
        CertificateSigningRequestOperationsImpl::new);
  }

  protected DefaultKubernetesClient(Config config, BaseClient client) {
    super(config, client);
  }

  public static DefaultKubernetesClient fromConfig(String config) {
    return new DefaultKubernetesClient(Serialization.unmarshal(config, Config.class));
  }

  public static DefaultKubernetesClient fromConfig(InputStream is) {
    return new DefaultKubernetesClient(Serialization.unmarshal(is, Config.class));
  }

  @Override
  public NamespacedKubernetesClient inNamespace(String name) {
    return newInstance(createInNamespaceConfig(name, false));
  }

  protected Config createInNamespaceConfig(String name, boolean any) {
    if (!any && name == null) {
      throw new KubernetesClientException("namespace cannot be null");
    }
    Config copy = configCopy();
    copy.setNamespace(name);
    copy.setDefaultNamespace(false);
    return copy;
  }

  protected Config configCopy() {
    return new ConfigBuilder(getConfiguration()).build();
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
  public ParameterNamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata> load(InputStream is) {
    return resourceListFor(is);
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
  public ParameterNamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata> resourceList(String s) {
    return resourceListFor(s);
  }

  @Override
  public <T extends HasMetadata> NamespaceableResource<T> resource(T item) {
    // lookup the operation given the item
    ResourceHandler<T, ?> resourceHandler = getHandlers().get(item, this);
    HasMetadataOperation<T, ?, ?> op = resourceHandler.operation(this, null);
    return new NamespaceableResourceAdapter<>(item, op);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public NamespaceableResource<HasMetadata> resource(String s) {
    return resource((HasMetadata) Serialization.unmarshal(s));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public MixedOperation<Binding, KubernetesResourceList<Binding>, Resource<Binding>> bindings() {
    return resources(Binding.class,
        (Class<KubernetesResourceList<Binding>>) TypeFactory.rawClass(new TypeReference<KubernetesResourceList<Binding>>() {
        }.getType()));
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
  public MixedOperation<ServiceAccount, ServiceAccountList, Resource<ServiceAccount>> serviceAccounts() {
    return resources(ServiceAccount.class, ServiceAccountList.class);
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
  public EventingAPIGroupDSL events() {
    return adapt(EventingAPIGroupClient.class);
  }

  @Override
  public NamespacedKubernetesClient inAnyNamespace() {
    return newInstance(createInNamespaceConfig(null, true));
  }

  @Override
  protected DefaultKubernetesClient newInstance(Config config) {
    return new DefaultKubernetesClient(config, this);
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
    return new RunOperations(this, new RunConfigBuilder());
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
    Config copyConfig = configCopy();
    Config.setRequestConfig(copyConfig, requestConfig);
    HttpClient client = this.httpClient.getFactory().createHttpClient(copyConfig);
    DefaultKubernetesClient result = newInstance(copyConfig);
    result.httpClient = client;
    result.setDerivedFields();
    return result;
  }

}
