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
package io.fabric8.openshift.client;

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
import io.fabric8.kubernetes.api.model.KubernetesList;
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
import io.fabric8.kubernetes.api.model.RootPaths;
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
import io.fabric8.kubernetes.client.AdmissionRegistrationAPIGroupClient;
import io.fabric8.kubernetes.client.AdmissionRegistrationAPIGroupDSL;
import io.fabric8.kubernetes.client.AppsAPIGroupClient;
import io.fabric8.kubernetes.client.AutoscalingAPIGroupClient;
import io.fabric8.kubernetes.client.BaseClient;
import io.fabric8.kubernetes.client.BatchAPIGroupClient;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.ExtensionsAPIGroupClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.MetricAPIGroupClient;
import io.fabric8.kubernetes.client.NamespacedKubernetesClient;
import io.fabric8.kubernetes.client.NetworkAPIGroupClient;
import io.fabric8.kubernetes.client.PolicyAPIGroupClient;
import io.fabric8.kubernetes.client.RbacAPIGroupClient;
import io.fabric8.kubernetes.client.RequestConfig;
import io.fabric8.kubernetes.client.SchedulingAPIGroupClient;
import io.fabric8.kubernetes.client.StorageAPIGroupClient;
import io.fabric8.kubernetes.client.V1APIGroupClient;
import io.fabric8.kubernetes.client.VersionInfo;
import io.fabric8.kubernetes.client.WithRequestCallable;
import io.fabric8.kubernetes.client.dsl.ApiextensionsAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.AppsAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.AuthorizationAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.AutoscalingAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.BatchAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.CertificatesAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.Createable;
import io.fabric8.kubernetes.client.dsl.DiscoveryAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.FunctionCallable;
import io.fabric8.kubernetes.client.dsl.InOutCreateable;
import io.fabric8.kubernetes.client.dsl.KubernetesListMixedOperation;
import io.fabric8.kubernetes.client.dsl.LogWatch;
import io.fabric8.kubernetes.client.dsl.MetricAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NamespaceListVisitFromServerGetDeleteRecreateWaitApplicable;
import io.fabric8.kubernetes.client.dsl.NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicable;
import io.fabric8.kubernetes.client.dsl.NetworkAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.ParameterMixedOperation;
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
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import io.fabric8.kubernetes.client.dsl.internal.CustomResourceOperationContext;
import io.fabric8.kubernetes.client.dsl.internal.CustomResourceOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.RawCustomResourceOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.coordination.v1.LeaseOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.core.v1.ComponentStatusOperationsImpl;
import io.fabric8.kubernetes.client.extended.leaderelection.LeaderElectorBuilder;
import io.fabric8.kubernetes.client.extended.run.RunConfigBuilder;
import io.fabric8.kubernetes.client.extended.run.RunOperations;
import io.fabric8.kubernetes.client.informers.SharedInformerFactory;
import io.fabric8.kubernetes.client.utils.BackwardsCompatibilityInterceptor;
import io.fabric8.kubernetes.client.utils.ImpersonatorInterceptor;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.openshift.api.model.Build;
import io.fabric8.openshift.api.model.BuildConfig;
import io.fabric8.openshift.api.model.BuildConfigList;
import io.fabric8.openshift.api.model.BuildList;
import io.fabric8.openshift.api.model.ClusterNetwork;
import io.fabric8.openshift.api.model.ClusterNetworkList;
import io.fabric8.openshift.api.model.ClusterRoleBinding;
import io.fabric8.openshift.api.model.ClusterRoleBindingList;
import io.fabric8.openshift.api.model.DeploymentConfig;
import io.fabric8.openshift.api.model.DeploymentConfigList;
import io.fabric8.openshift.api.model.EgressNetworkPolicy;
import io.fabric8.openshift.api.model.EgressNetworkPolicyList;
import io.fabric8.openshift.api.model.Group;
import io.fabric8.openshift.api.model.GroupList;
import io.fabric8.openshift.api.model.Image;
import io.fabric8.openshift.api.model.ImageList;
import io.fabric8.openshift.api.model.ImageStream;
import io.fabric8.openshift.api.model.ImageStreamList;
import io.fabric8.openshift.api.model.ImageStreamTag;
import io.fabric8.openshift.api.model.ImageStreamTagList;
import io.fabric8.openshift.api.model.ImageTag;
import io.fabric8.openshift.api.model.ImageTagList;
import io.fabric8.openshift.api.model.LocalSubjectAccessReview;
import io.fabric8.openshift.api.model.NetNamespace;
import io.fabric8.openshift.api.model.NetNamespaceList;
import io.fabric8.openshift.api.model.OAuthAccessToken;
import io.fabric8.openshift.api.model.OAuthAccessTokenList;
import io.fabric8.openshift.api.model.OAuthAuthorizeToken;
import io.fabric8.openshift.api.model.OAuthAuthorizeTokenList;
import io.fabric8.openshift.api.model.OAuthClient;
import io.fabric8.openshift.api.model.OAuthClientList;
import io.fabric8.openshift.api.model.RangeAllocation;
import io.fabric8.openshift.api.model.RangeAllocationList;
import io.fabric8.openshift.api.model.Role;
import io.fabric8.openshift.api.model.RoleBinding;
import io.fabric8.openshift.api.model.RoleBindingList;
import io.fabric8.openshift.api.model.RoleList;
import io.fabric8.openshift.api.model.Route;
import io.fabric8.openshift.api.model.RouteList;
import io.fabric8.openshift.api.model.SecurityContextConstraints;
import io.fabric8.openshift.api.model.SecurityContextConstraintsList;
import io.fabric8.openshift.api.model.SubjectAccessReview;
import io.fabric8.openshift.api.model.SubjectAccessReviewResponse;
import io.fabric8.openshift.api.model.Template;
import io.fabric8.openshift.api.model.TemplateList;
import io.fabric8.openshift.api.model.User;
import io.fabric8.openshift.api.model.UserList;
import io.fabric8.openshift.client.dsl.BuildConfigResource;
import io.fabric8.openshift.client.dsl.BuildResource;
import io.fabric8.openshift.client.dsl.DeployableScalableResource;
import io.fabric8.openshift.client.dsl.OpenShiftConfigAPIGroupDSL;
import io.fabric8.openshift.client.dsl.OpenShiftConsoleAPIGroupDSL;
import io.fabric8.openshift.client.dsl.OpenShiftMonitoringAPIGroupDSL;
import io.fabric8.openshift.client.dsl.OpenShiftOperatorAPIGroupDSL;
import io.fabric8.openshift.client.dsl.OpenShiftOperatorHubAPIGroupDSL;
import io.fabric8.openshift.client.dsl.OpenShiftQuotaAPIGroupDSL;
import io.fabric8.openshift.client.dsl.ProjectOperation;
import io.fabric8.openshift.client.dsl.ProjectRequestOperation;
import io.fabric8.openshift.client.dsl.TemplateResource;
import io.fabric8.openshift.client.dsl.internal.BuildConfigOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.BuildOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.ClusterNetworkOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.ClusterRoleBindingOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.DeploymentConfigOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.EgressNetworkPolicyOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.GroupOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.ImageOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.ImageStreamOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.ImageStreamTagOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.ImageTagOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.NetNamespaceOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.OAuthAccessTokenOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.OAuthAuthorizeTokenOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.OAuthClientOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.OpenShiftSubjectAccessReviewOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.ProjectOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.ProjectRequestsOperationImpl;
import io.fabric8.openshift.client.dsl.internal.RangeAllocationOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.RoleBindingOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.RoleOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.RouteOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.SecurityContextConstraintsOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.TemplateOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.UserOperationsImpl;
import io.fabric8.openshift.client.internal.OpenShiftClusterOperationsImpl;
import io.fabric8.openshift.client.internal.OpenShiftNamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl;
import io.fabric8.openshift.client.internal.OpenShiftOAuthInterceptor;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import okhttp3.Authenticator;
import okhttp3.OkHttpClient;

/**
 * Class for Default Openshift Client implementing KubernetesClient interface.
 * It is thread safe.
 */
public class DefaultOpenShiftClient extends BaseClient implements NamespacedOpenShiftClient {

  private static final Map<String, Boolean> API_GROUPS_ENABLED_PER_URL = new HashMap<>();

  private final URL openShiftUrl;
  private final NamespacedKubernetesClient delegate;

  public DefaultOpenShiftClient() {
    this(new OpenShiftConfigBuilder().build());
  }

  public DefaultOpenShiftClient(String masterUrl) {
    this(new OpenShiftConfigBuilder().withMasterUrl(masterUrl).build());
  }

  public DefaultOpenShiftClient(final Config config) {
    this(new OpenShiftConfig(config));
  }

  public DefaultOpenShiftClient(final OpenShiftConfig config) {
    super(configWithApiGroupsEnabled(clientWithOpenShiftOAuthInterceptor(config), config));
    try {
      this.httpClient = clientWithOpenShiftOAuthInterceptor(this.httpClient, config);
      this.delegate = new DefaultKubernetesClient(this.httpClient, config);
      this.openShiftUrl = new URL(config.getOpenShiftUrl());
    } catch (MalformedURLException e) {
      throw new KubernetesClientException("Could not create client", e);
    }
  }

  public DefaultOpenShiftClient(OkHttpClient httpClient, OpenShiftConfig config) {
    super(httpClient, configWithApiGroupsEnabled(httpClient, config));
    try {
      this.httpClient = clientWithOpenShiftOAuthInterceptor(httpClient, getConfiguration());
      this.delegate = new DefaultKubernetesClient(this.httpClient, config);
      this.openShiftUrl = new URL(config.getOpenShiftUrl());
    } catch (MalformedURLException e) {
      throw new KubernetesClientException("Could not create client", e);
    }
  }

  private static OpenShiftConfig configWithApiGroupsEnabled(OkHttpClient httpClient, OpenShiftConfig config) {
    String url = config.getMasterUrl();
    Boolean openshiftApiGroupsEnabled = API_GROUPS_ENABLED_PER_URL.containsKey(url);
    if (openshiftApiGroupsEnabled) {
      return config;
    }

    if (!config.isDisableApiGroupCheck()) {
      return config.withOpenshiftApiGroupsEnabled(false);
    }

    Boolean enabled = OpenshiftAdapterSupport.isOpenShiftAPIGroups(httpClient, url);
    API_GROUPS_ENABLED_PER_URL.put(url, enabled);
   return config.withOpenshiftApiGroupsEnabled(enabled);
  }

  public static DefaultOpenShiftClient fromConfig(String config) {
    return new DefaultOpenShiftClient(Serialization.unmarshal(config, OpenShiftConfig.class));
  }

  public static DefaultOpenShiftClient fromConfig(InputStream is) {
    return new DefaultOpenShiftClient(Serialization.unmarshal(is, OpenShiftConfig.class));
  }

  private static OkHttpClient clientWithOpenShiftOAuthInterceptor(Config config) {
    return clientWithOpenShiftOAuthInterceptor(null, config);
  }

  static OkHttpClient clientWithOpenShiftOAuthInterceptor(OkHttpClient httpClient, Config config) {
    OkHttpClient.Builder builder = httpClient != null ?
      httpClient.newBuilder().authenticator(Authenticator.NONE) :
      new OkHttpClient.Builder().authenticator(Authenticator.NONE);

    builder.interceptors().clear();
    return builder.addInterceptor(new OpenShiftOAuthInterceptor(httpClient, OpenShiftConfig.wrap(config)))
      .addInterceptor(new ImpersonatorInterceptor(config))
      .addInterceptor(new BackwardsCompatibilityInterceptor())
      .build();
  }

  @Override
  public URL getOpenshiftUrl() {
    return openShiftUrl;
  }

  @Override
  public OpenShiftConfigAPIGroupDSL config() {
    return adapt(OpenShiftConfigAPIGroupClient.class);
  }

  @Override
  public OpenShiftConsoleAPIGroupDSL console() {
    return adapt(OpenShiftConsoleAPIGroupClient.class);
  }

  @Override
  public OpenShiftOperatorAPIGroupDSL operator() {
    return adapt(OpenShiftOperatorAPIGroupClient.class);
  }

  @Override
  public OpenShiftOperatorHubAPIGroupDSL operatorHub() {
    return adapt(OpenShiftOperatorHubAPIGroupClient.class);
  }

  @Override
  public MixedOperation<ComponentStatus, ComponentStatusList, Resource<ComponentStatus>> componentstatuses() {
    return new ComponentStatusOperationsImpl(httpClient, getConfiguration());
  }

  @Override
  public ParameterNamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata> load(InputStream is) {
    return new OpenShiftNamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl(httpClient, getConfiguration(), getNamespace(), null, false, false, new ArrayList<>(), is, null, true, DeletionPropagation.BACKGROUND, false) {
    };
  }

  @Override
  public NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicable<HasMetadata> resource(HasMetadata item) {
    return delegate.resource(item);
  }

  @Override
  public NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicable<HasMetadata> resource(String s) {
    return delegate.resource(s);
  }

  @Override
  public NamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata> resourceList(KubernetesResourceList item) {
    return new OpenShiftNamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl(httpClient, getConfiguration(), getNamespace(), null, false, false, new ArrayList<>(), item, null, DeletionPropagation.BACKGROUND, true, false) {
    };
  }

  @Override
  public NamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata> resourceList(HasMetadata... items) {
    return resourceList(new KubernetesListBuilder().withItems(items).build());
  }

  @Override
  public NamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata> resourceList(Collection<HasMetadata> items) {
    return delegate.resourceList(items);
  }

  @Override
  public ParameterNamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata> resourceList(String s) {
    return new OpenShiftNamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl(httpClient, getConfiguration(), getNamespace(), null, false, false, new ArrayList<>(), s, null, DeletionPropagation.BACKGROUND, true, false) {
    };
  }

  @Override
  public MixedOperation<Endpoints, EndpointsList, Resource<Endpoints>> endpoints() {
    return delegate.endpoints();
  }

  @Override
  public MixedOperation<Binding, KubernetesResourceList<Binding>, Resource<Binding>> bindings() {
    return delegate.bindings();
  }

  @Override
  public NonNamespaceOperation<Namespace, NamespaceList, Resource<Namespace>> namespaces() {
    return delegate.namespaces();
  }

  @Override
  public NonNamespaceOperation<Node, NodeList, Resource<Node>> nodes() {
    return delegate.nodes();
  }

  @Override
  public NonNamespaceOperation<PersistentVolume, PersistentVolumeList, Resource<PersistentVolume>> persistentVolumes() {
    return delegate.persistentVolumes();
  }

  @Override
  public MixedOperation<PersistentVolumeClaim, PersistentVolumeClaimList, Resource<PersistentVolumeClaim>> persistentVolumeClaims() {
    return delegate.persistentVolumeClaims();
  }

  @Override
  public MixedOperation<Pod, PodList, PodResource<Pod>> pods() {
    return delegate.pods();
  }

  @Override
  public MixedOperation<ReplicationController, ReplicationControllerList, RollableScalableResource<ReplicationController>> replicationControllers() {
    return delegate.replicationControllers();
  }

  @Override
  public MixedOperation<ResourceQuota, ResourceQuotaList, Resource<ResourceQuota>> resourceQuotas() {
    return delegate.resourceQuotas();
  }

  @Override
  public MixedOperation<Secret, SecretList, Resource<Secret>> secrets() {
    return delegate.secrets();
  }

  @Override
  public MixedOperation<Service, ServiceList, ServiceResource<Service>> services() {
    return delegate.services();
  }

  @Override
  public MixedOperation<ServiceAccount, ServiceAccountList, Resource<ServiceAccount>> serviceAccounts() {
    return delegate.serviceAccounts();
  }

  @Override
  public MixedOperation<APIService, APIServiceList, Resource<APIService>> apiServices() {
    return delegate.apiServices();
  }

  @Override
  public KubernetesListMixedOperation lists() {
    return delegate.lists();
  }

  @Override
  public MixedOperation<ConfigMap, ConfigMapList, Resource<ConfigMap>> configMaps() {
    return delegate.configMaps();
  }

  @Override
  public MixedOperation<LimitRange, LimitRangeList, Resource<LimitRange>> limitRanges() {
    return delegate.limitRanges();
  }

  @Override
  public <T extends CustomResource>  MixedOperation<T, KubernetesResourceList<T>, Resource<T>> customResources(Class<T> resourceType ) {
    return new CustomResourceOperationsImpl<>(new CustomResourceOperationContext().withOkhttpClient(httpClient).withConfig(getConfiguration()).withCrdContext(CustomResourceDefinitionContext.fromCustomResourceType(resourceType)).withType(resourceType));
  }


  @Override
  public <T extends CustomResource, L extends KubernetesResourceList<T>> MixedOperation<T, L, Resource<T>> customResources(Class<T> resourceType, Class<L> listClass) {
    return new CustomResourceOperationsImpl<>(new CustomResourceOperationContext().withOkhttpClient(httpClient).withConfig(getConfiguration()).withCrdContext(CustomResourceDefinitionContext.fromCustomResourceType(resourceType)).withType(resourceType).withListType(listClass));
  }

  @Override
  public <T extends HasMetadata, L extends KubernetesResourceList<T>> MixedOperation<T, L, Resource<T>> customResources(CustomResourceDefinitionContext crdContext, Class<T> resourceType, Class<L> listClass) {
    return new CustomResourceOperationsImpl<>(new CustomResourceOperationContext().withOkhttpClient(httpClient).withConfig(getConfiguration()).withCrdContext(crdContext).withType(resourceType).withListType(listClass));
  }

  @Override
  public DiscoveryAPIGroupDSL discovery() {
    return delegate.discovery();
  }

  @Override
  public ApiextensionsAPIGroupDSL apiextensions() {
    return delegate.apiextensions();
  }

  @Override
  public NonNamespaceOperation<CertificateSigningRequest, CertificateSigningRequestList, Resource<CertificateSigningRequest>> certificateSigningRequests() {
    return delegate.certificateSigningRequests();
  }

  @Override
  public CertificatesAPIGroupDSL certificates() {
    return delegate.certificates();
  }

  @Override
  public AuthorizationAPIGroupDSL authorization() {
    return delegate.authorization();
  }

  @Override
  public Createable<TokenReview> tokenReviews() {
    return delegate.tokenReviews();
  }

  public RawCustomResourceOperationsImpl customResource(CustomResourceDefinitionContext customResourceDefinition) {
    return new RawCustomResourceOperationsImpl(httpClient, getConfiguration(), customResourceDefinition);
  }

  @Override
  public MixedOperation<Build, BuildList, BuildResource<Build, LogWatch>> builds() {
    return new BuildOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public MixedOperation<BuildConfig, BuildConfigList, BuildConfigResource<BuildConfig, Void, Build>> buildConfigs() {
    return new BuildConfigOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public MixedOperation<DeploymentConfig, DeploymentConfigList, DeployableScalableResource<DeploymentConfig>> deploymentConfigs() {
    return new DeploymentConfigOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public MixedOperation<Group, GroupList, Resource<Group>> groups() {
    return new GroupOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<Image, ImageList, Resource<Image>> images() {
    return new ImageOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public MixedOperation<ImageTag, ImageTagList, Resource<ImageTag>> imageTags() {
    return new ImageTagOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public MixedOperation<ImageStream, ImageStreamList, Resource<ImageStream>> imageStreams() {
    return new ImageStreamOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public MixedOperation<ImageStreamTag, ImageStreamTagList, Resource<ImageStreamTag>> imageStreamTags() {
    return new ImageStreamTagOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<OAuthAccessToken, OAuthAccessTokenList, Resource<OAuthAccessToken>> oAuthAccessTokens() {
    return new OAuthAccessTokenOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<OAuthAuthorizeToken, OAuthAuthorizeTokenList, Resource<OAuthAuthorizeToken>> oAuthAuthorizeTokens() {
    return new OAuthAuthorizeTokenOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<OAuthClient, OAuthClientList, Resource<OAuthClient>> oAuthClients() {
    return new OAuthClientOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public ProjectOperation projects() {
    return new ProjectOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public OpenShiftQuotaAPIGroupDSL quotas() {
    return adapt(OpenShiftQuotaAPIGroupClient.class);
  }

  @Override
  public NonNamespaceOperation<RangeAllocation, RangeAllocationList, Resource<RangeAllocation>> rangeAllocations() {
    return new RangeAllocationOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<SecurityContextConstraints, SecurityContextConstraintsList, Resource<SecurityContextConstraints>> securityContextConstraints() {
    return new SecurityContextConstraintsOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public ProjectRequestOperation projectrequests() {
    return new ProjectRequestsOperationImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public MixedOperation<Role, RoleList, Resource<Role>> roles() {
    return new RoleOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public MixedOperation<RoleBinding, RoleBindingList, Resource<RoleBinding>> roleBindings() {
    return new RoleBindingOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public MixedOperation<Route, RouteList, Resource<Route>> routes() {
    return new RouteOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public ParameterMixedOperation<Template, TemplateList, TemplateResource<Template, KubernetesList>> templates() {
    return new TemplateOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public MixedOperation<User, UserList, Resource<User>> users() {
    return new UserOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public MixedOperation<ClusterRoleBinding, ClusterRoleBindingList, Resource<ClusterRoleBinding>> clusterRoleBindings() {
    return new ClusterRoleBindingOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NamespacedOpenShiftClient inNamespace(String namespace) {
    OpenShiftConfig updated = new OpenShiftConfigBuilder(new OpenShiftConfig(getConfiguration()))
      .withOpenShiftUrl(openShiftUrl.toString())
      .withNamespace(namespace)
      .build();
    return new DefaultOpenShiftClient(httpClient, updated);
  }

  @Override
  public NamespacedOpenShiftClient inAnyNamespace() {
    return inNamespace(null);
  }

  @Override
  public ExtensionsAPIGroupClient extensions() {
    return adapt(ExtensionsAPIGroupClient.class);
  }

  @Override
  public VersionInfo getVersion() {
    final VersionInfo versionInfo = new OpenShiftClusterOperationsImpl(httpClient,
      getConfiguration(), OpenShiftClusterOperationsImpl.OPENSHIFT_VERSION_ENDPOINT).fetchVersion();
    return versionInfo == null ? DefaultKubernetesClient.getVersion(this) : versionInfo;
  }

  @Override
  public V1APIGroupDSL v1() {
    return adapt(V1APIGroupClient.class);
  }

  @Override
  public RunOperations run() {
    return new RunOperations(httpClient, getConfiguration(), getNamespace(), new RunConfigBuilder());
  }

  @Override
  public NonNamespaceOperation<RuntimeClass, RuntimeClassList, Resource<RuntimeClass>> runtimeClasses() {
    return delegate.runtimeClasses();
  }

  @Override
  public AdmissionRegistrationAPIGroupDSL admissionRegistration() {
    return adapt(AdmissionRegistrationAPIGroupClient.class);
  }

  @Override
  public AppsAPIGroupDSL apps() {
    return adapt(AppsAPIGroupClient.class);
  }

  @Override
  public AutoscalingAPIGroupDSL autoscaling() {
    return adapt(AutoscalingAPIGroupClient.class);
  }

  @Override
  public OpenShiftMonitoringAPIGroupDSL monitoring() { return adapt(OpenShiftMonitoringAPIGroupClient.class); }

  @Override
  public NonNamespaceOperation<NetNamespace, NetNamespaceList, Resource<NetNamespace>> netNamespaces() {
    return new NetNamespaceOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<ClusterNetwork, ClusterNetworkList, Resource<ClusterNetwork>> clusterNetworks() {
    return new ClusterNetworkOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public MixedOperation<EgressNetworkPolicy, EgressNetworkPolicyList, Resource<EgressNetworkPolicy>> egressNetworkPolicies() {
    return new EgressNetworkPolicyOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NetworkAPIGroupDSL network() { return adapt(NetworkAPIGroupClient.class); }

  @Override
  public StorageAPIGroupDSL storage() { return adapt(StorageAPIGroupClient.class); }

  @Override
  public InOutCreateable<SubjectAccessReview, SubjectAccessReviewResponse> subjectAccessReviews() {
    return new OpenShiftSubjectAccessReviewOperationsImpl(httpClient, getConfiguration(), "authorization.openshift.io", "v1", Utils.getPluralFromKind(SubjectAccessReview.class.getSimpleName()));
  }

  @Override
  public OpenShiftLocalSubjectAccessReviewOperationsImpl localSubjectAccessReviews() {
    return new OpenShiftLocalSubjectAccessReviewOperationsImpl(httpClient, getConfiguration(), "authorization.openshift.io", "v1", Utils.getPluralFromKind(LocalSubjectAccessReview.class.getSimpleName()));
  }

  @Override
  public BatchAPIGroupDSL batch() { return adapt(BatchAPIGroupClient.class); }

  @Override
  public MetricAPIGroupDSL top() { return adapt(MetricAPIGroupClient.class); }

  @Override
  public PolicyAPIGroupDSL policy() { return adapt(PolicyAPIGroupClient.class); }

  @Override
  public RbacAPIGroupDSL rbac() { return adapt(RbacAPIGroupClient.class); }

  @Override
  public SchedulingAPIGroupDSL scheduling() { return adapt(SchedulingAPIGroupClient.class); }

  @Override
  public SharedInformerFactory informers() { return new SharedInformerFactory(ForkJoinPool.commonPool(), httpClient, getConfiguration()); }

  @Override
  public SharedInformerFactory informers(ExecutorService executorService) { return new SharedInformerFactory(executorService, httpClient, getConfiguration()); }

  /**
   * {@inheritDoc}
   */
  @Override
  public LeaderElectorBuilder<NamespacedOpenShiftClient> leaderElector() {
    return new LeaderElectorBuilder<>(this);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public MixedOperation<Lease, LeaseList, Resource<Lease>> leases() {
    return new LeaseOperationsImpl(httpClient, getConfiguration());
  }

  @Override
  public FunctionCallable<NamespacedOpenShiftClient> withRequestConfig(RequestConfig requestConfig) {
    return new WithRequestCallable<>(this, requestConfig);
  }

  @Override
  public User currentUser() {
    return users().withName("~").get();
  }

  @Override
  public boolean supportsOpenShiftAPIGroup(String apiGroup) {
    String apiGroupPath = "/apis/" + apiGroup;
    RootPaths rootPaths = rootPaths();
    if (rootPaths != null) {
      List<String> paths = rootPaths.getPaths();
      if (paths != null) {
        for (String path : paths) {
          if (Objects.equals("/oapi", path) || Objects.equals("oapi", path) || Objects.equals(apiGroupPath, path)) {
            return true;
          }
        }
      }
    }
    return false;
  }
}
