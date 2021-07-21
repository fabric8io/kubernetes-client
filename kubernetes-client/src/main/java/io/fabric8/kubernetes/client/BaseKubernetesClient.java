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

import static io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation.DEFAULT_PROPAGATION_POLICY;

import io.fabric8.kubernetes.api.model.APIService;
import io.fabric8.kubernetes.api.model.APIServiceList;
import io.fabric8.kubernetes.api.model.Binding;
import io.fabric8.kubernetes.api.model.ComponentStatus;
import io.fabric8.kubernetes.api.model.ComponentStatusList;
import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.ConfigMapList;
import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.api.model.Endpoints;
import io.fabric8.kubernetes.api.model.EndpointsList;
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
import io.fabric8.kubernetes.api.model.authentication.TokenReview;
import io.fabric8.kubernetes.api.model.certificates.v1beta1.CertificateSigningRequest;
import io.fabric8.kubernetes.api.model.certificates.v1beta1.CertificateSigningRequestList;
import io.fabric8.kubernetes.api.model.coordination.v1.Lease;
import io.fabric8.kubernetes.api.model.coordination.v1.LeaseList;
import io.fabric8.kubernetes.api.model.node.v1beta1.RuntimeClass;
import io.fabric8.kubernetes.api.model.node.v1beta1.RuntimeClassList;
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
import io.fabric8.kubernetes.client.dsl.InOutCreateable;
import io.fabric8.kubernetes.client.dsl.KubernetesListMixedOperation;
import io.fabric8.kubernetes.client.dsl.MetricAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NamespaceListVisitFromServerGetDeleteRecreateWaitApplicable;
import io.fabric8.kubernetes.client.dsl.NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicable;
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
import io.fabric8.kubernetes.client.dsl.Waitable;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import io.fabric8.kubernetes.client.dsl.internal.ClusterOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.CreateOnlyResourceOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.CustomResourceOperationContext;
import io.fabric8.kubernetes.client.dsl.internal.CustomResourceOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.KubernetesListOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableImpl;
import io.fabric8.kubernetes.client.dsl.internal.NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl;
import io.fabric8.kubernetes.client.dsl.internal.RawCustomResourceOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.certificates.v1beta1.CertificateSigningRequestOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.coordination.v1.LeaseOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.core.v1.APIServiceOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.core.v1.BindingOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.core.v1.ComponentStatusOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.core.v1.ConfigMapOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.core.v1.EndpointsOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.core.v1.LimitRangeOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.core.v1.NamespaceOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.core.v1.NodeOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.core.v1.PersistentVolumeClaimOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.core.v1.PersistentVolumeOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.core.v1.PodOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.core.v1.ReplicationControllerOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.core.v1.ResourceQuotaOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.core.v1.SecretOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.core.v1.ServiceAccountOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.core.v1.ServiceOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.node.v1beta1.RuntimeClassOperationsImpl;
import io.fabric8.kubernetes.client.extended.run.RunConfigBuilder;
import io.fabric8.kubernetes.client.extended.run.RunOperations;
import io.fabric8.kubernetes.client.informers.SharedInformerFactory;
import io.fabric8.kubernetes.client.utils.Serialization;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ExecutorService;

import okhttp3.OkHttpClient;

/**
 * Base class for all Kubernetes Clients implementing KubernetesClient interface.
 * It is thread safe.
 */
public abstract class BaseKubernetesClient<C extends Client> extends BaseClient implements GenericKubernetesClient<C> {

  protected BaseKubernetesClient() {
    super();
  }

  protected BaseKubernetesClient(String masterUrl) {
    super(masterUrl);
  }

  protected BaseKubernetesClient(Config config) {
    super(config);
  }

  protected BaseKubernetesClient(OkHttpClient httpClient, Config config) {
    super(httpClient, config);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public MixedOperation<ComponentStatus, ComponentStatusList, Resource<ComponentStatus>> componentstatuses() {
    return new ComponentStatusOperationsImpl(httpClient, getConfiguration());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ParameterNamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata> load(InputStream is) {
    return new NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl(httpClient, getConfiguration(), getNamespace(), null, false, false, new ArrayList<>(), is, null, true, DeletionPropagation.BACKGROUND, false) {
    };
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public NamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata> resourceList(KubernetesResourceList item) {
    return new NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl(httpClient, getConfiguration(), getNamespace(), null, false, false, new ArrayList<>(), item, null, DeletionPropagation.BACKGROUND, true, false) {
    };
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
  public NamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata> resourceList(Collection<HasMetadata> items) {
    return resourceList(new KubernetesListBuilder().withItems(new ArrayList<>(items)).build());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ParameterNamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata> resourceList(String s) {
    return new NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl(httpClient, getConfiguration(), getNamespace(), null, false, false, new ArrayList<>(), s, null, DeletionPropagation.BACKGROUND, true, false) {
    };
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicable<HasMetadata> resource(HasMetadata item) {
    return new NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableImpl(httpClient, getConfiguration(), getNamespace(), null, false, false, new ArrayList<>(), item, -1, DeletionPropagation.BACKGROUND, true, Waitable.DEFAULT_INITIAL_BACKOFF_MILLIS, Waitable.DEFAULT_BACKOFF_MULTIPLIER, false);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicable<HasMetadata> resource(String s) {
    return resource((HasMetadata)Serialization.unmarshal(s));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public MixedOperation<Binding, KubernetesResourceList<Binding>, Resource<Binding>> bindings() {
    return new BindingOperationsImpl(httpClient, getConfiguration());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public MixedOperation<Endpoints, EndpointsList, Resource<Endpoints>> endpoints() {
    return new EndpointsOperationsImpl(httpClient, getConfiguration());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public NonNamespaceOperation<Namespace, NamespaceList, Resource<Namespace>> namespaces() {
    return new NamespaceOperationsImpl(httpClient, getConfiguration());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public NonNamespaceOperation<Node, NodeList, Resource<Node>> nodes() {
    return new NodeOperationsImpl(httpClient, getConfiguration());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public NonNamespaceOperation<PersistentVolume, PersistentVolumeList, Resource<PersistentVolume>> persistentVolumes() {
    return new PersistentVolumeOperationsImpl(httpClient, getConfiguration());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public MixedOperation<PersistentVolumeClaim, PersistentVolumeClaimList, Resource<PersistentVolumeClaim>> persistentVolumeClaims() {
    return new PersistentVolumeClaimOperationsImpl(httpClient, getConfiguration());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public MixedOperation<Pod, PodList, PodResource<Pod>> pods() {
    return new PodOperationsImpl(httpClient, getConfiguration());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public MixedOperation<ReplicationController, ReplicationControllerList, RollableScalableResource<ReplicationController>> replicationControllers() {
    return new ReplicationControllerOperationsImpl(httpClient, getConfiguration());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public MixedOperation<ResourceQuota, ResourceQuotaList, Resource<ResourceQuota>> resourceQuotas() {
    return new ResourceQuotaOperationsImpl(httpClient, getConfiguration());
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
    return new SecretOperationsImpl(httpClient, getConfiguration());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public MixedOperation<Service, ServiceList, ServiceResource<Service>> services() {
    return new ServiceOperationsImpl(httpClient, getConfiguration());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public MixedOperation<ServiceAccount, ServiceAccountList, Resource<ServiceAccount>> serviceAccounts() {
    return new ServiceAccountOperationsImpl(httpClient, getConfiguration());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public MixedOperation<APIService, APIServiceList, Resource<APIService>> apiServices() {
    return new APIServiceOperationsImpl(httpClient, getConfiguration());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public KubernetesListMixedOperation lists() {
    return new KubernetesListOperationsImpl(httpClient, getConfiguration(), getNamespace());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public MixedOperation<ConfigMap, ConfigMapList, Resource<ConfigMap>> configMaps() {
    return new ConfigMapOperationsImpl(httpClient, getConfiguration());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public MixedOperation<LimitRange, LimitRangeList, Resource<LimitRange>> limitRanges() {
    return new LimitRangeOperationsImpl(httpClient, getConfiguration());
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
    return new CertificateSigningRequestOperationsImpl(httpClient, getConfiguration());
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
    return new CreateOnlyResourceOperationsImpl<>(httpClient, getConfiguration(), "authentication.k8s.io", "v1", HasMetadata.getPlural(TokenReview.class), TokenReview.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public <T extends CustomResource> MixedOperation<T, KubernetesResourceList<T>, Resource<T>> customResources(Class<T> resourceType) {
    return customResources(resourceType, null);
  }


  /**
   * {@inheritDoc}
   */
  @Override
  public <T extends CustomResource, L extends KubernetesResourceList<T>> MixedOperation<T, L, Resource<T>> customResources(Class<T> resourceType, Class<L> listClass) {
    return customResources(CustomResourceDefinitionContext.fromCustomResourceType(resourceType), resourceType, listClass);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public <T extends HasMetadata, L extends KubernetesResourceList<T>> MixedOperation<T, L, Resource<T>> customResources(CustomResourceDefinitionContext crdContext, Class<T> resourceType, Class<L> listClass) {
    return new CustomResourceOperationsImpl<>(new CustomResourceOperationContext().withOkhttpClient(httpClient).withConfig(getConfiguration())
      .withCrdContext(crdContext)
      .withType(resourceType)
      .withListType(listClass)
      .withPropagationPolicy(DEFAULT_PROPAGATION_POLICY));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public RawCustomResourceOperationsImpl customResource(CustomResourceDefinitionContext customResourceDefinition) {
    return new RawCustomResourceOperationsImpl(httpClient, getConfiguration(), customResourceDefinition);
  }

  @Override
  public DiscoveryAPIGroupDSL discovery() {
    return adapt(DiscoveryAPIGroupClient.class);
  }

  @Override
  public EventingAPIGroupDSL events() {
    return adapt(EventingAPIGroupClient.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public C inAnyNamespace() {
    return inNamespace(null);
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
    return getVersion(this);
  }

  public static VersionInfo getVersion(BaseClient client) {
    return new ClusterOperationsImpl(client.httpClient, client.getConfiguration(),
      ClusterOperationsImpl.KUBERNETES_VERSION_ENDPOINT).fetchVersion();
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
  public NetworkAPIGroupDSL network() { return adapt(NetworkAPIGroupClient.class); }

  /**
   * {@inheritDoc}
   */
  @Override
  public StorageAPIGroupDSL storage() { return adapt(StorageAPIGroupClient.class); }

  /**
   * {@inheritDoc}
   */
  @Override
  public BatchAPIGroupDSL batch() { return adapt(BatchAPIGroupClient.class); }

  /**
   * {@inheritDoc}
   */
  @Override
  public MetricAPIGroupDSL top() { return adapt(MetricAPIGroupClient.class); }

  /**
   * {@inheritDoc}
   */
  @Override
  public PolicyAPIGroupDSL policy() { return adapt(PolicyAPIGroupClient.class); }

  /**
   * {@inheritDoc}
   */
  @Override
  public RbacAPIGroupDSL rbac() { return adapt(RbacAPIGroupClient.class); }

  /**
   * {@inheritDoc}
   */
  @Override
  public SharedInformerFactory informers() {
    return new SharedInformerFactory(httpClient, getConfiguration());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public SharedInformerFactory informers(ExecutorService executorService) {
    return new SharedInformerFactory(executorService, httpClient, getConfiguration());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public MixedOperation<Lease, LeaseList, Resource<Lease>> leases() {
    return new LeaseOperationsImpl(httpClient, getConfiguration());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public RunOperations run() {
    return new RunOperations(httpClient, getConfiguration(), getNamespace(), new RunConfigBuilder());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public NonNamespaceOperation<RuntimeClass, RuntimeClassList, Resource<RuntimeClass>> runtimeClasses() {
    return new RuntimeClassOperationsImpl(httpClient, getConfiguration());
  }
  
}
