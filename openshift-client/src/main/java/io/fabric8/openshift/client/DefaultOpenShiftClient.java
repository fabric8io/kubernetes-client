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

import io.fabric8.kubernetes.api.model.*;
import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinitionList;
import io.fabric8.kubernetes.api.model.apiextensions.DoneableCustomResourceDefinition;
import io.fabric8.kubernetes.client.AppsAPIGroupClient;
import io.fabric8.kubernetes.client.AutoscalingAPIGroupClient;
import io.fabric8.kubernetes.client.RequestConfig;
import io.fabric8.kubernetes.client.dsl.AppsAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.AutoscalingAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.FunctionCallable;
import io.fabric8.kubernetes.client.dsl.LogWatch;
import io.fabric8.kubernetes.client.dsl.ParameterMixedOperation;
import io.fabric8.kubernetes.client.dsl.NamespaceListVisitFromServerGetDeleteRecreateWaitApplicable;
import io.fabric8.kubernetes.client.WithRequestCallable;
import io.fabric8.kubernetes.client.dsl.ParameterNamespaceListVisitFromServerGetDeleteRecreateWaitApplicable;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.openshift.api.model.*;
import io.fabric8.openshift.client.dsl.BuildResource;
import io.fabric8.openshift.client.dsl.DeployableScalableResource;
import io.fabric8.openshift.client.dsl.internal.ImageStreamTagOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.RoleOperationsImpl;
import okhttp3.Authenticator;
import okhttp3.OkHttpClient;

import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.ConfigMapList;
import io.fabric8.kubernetes.api.model.DoneableConfigMap;
import io.fabric8.kubernetes.client.BaseClient;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.ExtensionsAPIGroupClient;
import io.fabric8.kubernetes.client.NamespacedKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.KubernetesListMixedOperation;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.PodResource;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.RollableScalableResource;
import io.fabric8.kubernetes.client.dsl.NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicable;
import io.fabric8.kubernetes.client.dsl.internal.ComponentStatusOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.CustomResourceDefinitionOperationsImpl;
import io.fabric8.openshift.client.dsl.BuildConfigResource;
import io.fabric8.openshift.client.dsl.ProjectRequestOperation;
import io.fabric8.openshift.client.dsl.SubjectAccessReviewOperation;
import io.fabric8.openshift.client.dsl.TemplateResource;
import io.fabric8.openshift.client.dsl.CreateableLocalSubjectAccessReview;
import io.fabric8.openshift.client.dsl.CreateableSubjectAccessReview;
import io.fabric8.openshift.client.dsl.internal.BuildConfigOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.BuildOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.SubjectAccessReviewOperationImpl;
import io.fabric8.openshift.client.dsl.internal.ClusterRoleBindingOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.DeploymentConfigOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.GroupOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.ImageStreamOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.OAuthAccessTokenOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.OAuthAuthorizeTokenOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.OAuthClientOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.PolicyBindingOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.PolicyOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.ProjectOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.ProjectRequestsOperationImpl;
import io.fabric8.openshift.client.dsl.internal.RoleBindingOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.RouteOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.TemplateOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.UserOperationsImpl;
import io.fabric8.openshift.client.internal.OpenShiftOAuthInterceptor;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class DefaultOpenShiftClient extends BaseClient implements NamespacedOpenShiftClient {

  private URL openShiftUrl;
  private NamespacedKubernetesClient delegate;

  public DefaultOpenShiftClient() throws KubernetesClientException {
    this(new OpenShiftConfigBuilder().build());
  }

  public DefaultOpenShiftClient(String masterUrl) throws KubernetesClientException {
    this(new OpenShiftConfigBuilder().withMasterUrl(masterUrl).build());
  }

  public DefaultOpenShiftClient(final Config config) throws KubernetesClientException {
    this(new OpenShiftConfig(config));
  }

  public DefaultOpenShiftClient(final OpenShiftConfig config) throws KubernetesClientException {
    super(config);
    try {
      this.httpClient = clientWithOpenShiftOAuthInterceptor(this.httpClient);
      this.delegate = new DefaultKubernetesClient(this.httpClient, config);
      this.openShiftUrl = new URL(config.getOpenShiftUrl());
    } catch (MalformedURLException e) {
      throw new KubernetesClientException("Could not create client", e);
    }
  }

  public DefaultOpenShiftClient(OkHttpClient httpClient, OpenShiftConfig config) throws KubernetesClientException {
    super(httpClient, config);
    try {
      this.delegate = new DefaultKubernetesClient(clientWithOpenShiftOAuthInterceptor(httpClient), config);
      this.openShiftUrl = new URL(config.getOpenShiftUrl());
    } catch (MalformedURLException e) {
      throw new KubernetesClientException("Could not create client", e);
    }
  }

  public static DefaultOpenShiftClient fromConfig(String config) {
    return new DefaultOpenShiftClient(Serialization.unmarshal(config, OpenShiftConfig.class));
  }

  public static DefaultOpenShiftClient fromConfig(InputStream is) {
    return new DefaultOpenShiftClient(Serialization.unmarshal(is, OpenShiftConfig.class));
  }

  private OkHttpClient clientWithOpenShiftOAuthInterceptor(OkHttpClient httpClient) {
    httpClient = httpClient.newBuilder().authenticator(Authenticator.NONE).build();
    OkHttpClient.Builder builder = httpClient.newBuilder();
    builder.interceptors().clear();
    return builder.addInterceptor(new OpenShiftOAuthInterceptor(httpClient, OpenShiftConfig.wrap(getConfiguration()))).build();
  }

  @Override
  public URL getOpenshiftUrl() {
    return openShiftUrl;
  }

  @Override
  public MixedOperation<ComponentStatus, ComponentStatusList, DoneableComponentStatus, Resource<ComponentStatus, DoneableComponentStatus>> componentstatuses() {
    return new ComponentStatusOperationsImpl(httpClient, getConfiguration());
  }

  @Override
  public ParameterNamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata, Boolean> load(InputStream is) {
    return delegate.load(is);
  }

  @Override
  public NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicable<HasMetadata, Boolean> resource(HasMetadata item) {
    return delegate.resource(item);
  }

  @Override
  public NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicable<HasMetadata, Boolean> resource(String s) {
    return delegate.resource(s);
  }

  @Override
  public NamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata, Boolean> resourceList(KubernetesResourceList is) {
    return delegate.resourceList(is);
  }

  @Override
  public NamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata, Boolean> resourceList(HasMetadata... items) {
    return delegate.resourceList(items);
  }

  @Override
  public NamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata, Boolean> resourceList(Collection<HasMetadata> items) {
    return delegate.resourceList(items);
  }

  @Override
  public ParameterNamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata, Boolean> resourceList(String s) {
    return delegate.resourceList(s);
  }

  @Override
  public MixedOperation<Endpoints, EndpointsList, DoneableEndpoints, Resource<Endpoints, DoneableEndpoints>> endpoints() {
    return delegate.endpoints();
  }

  @Override
  public MixedOperation<Event, EventList, DoneableEvent, Resource<Event, DoneableEvent>> events() {
    return delegate.events();
  }

  @Override
  public NonNamespaceOperation<Namespace, NamespaceList, DoneableNamespace, Resource<Namespace, DoneableNamespace>> namespaces() {
    return delegate.namespaces();
  }

  @Override
  public NonNamespaceOperation<Node, NodeList, DoneableNode, Resource<Node, DoneableNode>> nodes() {
    return delegate.nodes();
  }

  @Override
  public NonNamespaceOperation<PersistentVolume, PersistentVolumeList, DoneablePersistentVolume, Resource<PersistentVolume, DoneablePersistentVolume>> persistentVolumes() {
    return delegate.persistentVolumes();
  }

  @Override
  public MixedOperation<PersistentVolumeClaim, PersistentVolumeClaimList, DoneablePersistentVolumeClaim, Resource<PersistentVolumeClaim, DoneablePersistentVolumeClaim>> persistentVolumeClaims() {
    return delegate.persistentVolumeClaims();
  }

  @Override
  public MixedOperation<Pod, PodList, DoneablePod, PodResource<Pod, DoneablePod>> pods() {
    return delegate.pods();
  }

  @Override
  public MixedOperation<ReplicationController, ReplicationControllerList, DoneableReplicationController, RollableScalableResource<ReplicationController, DoneableReplicationController>> replicationControllers() {
    return delegate.replicationControllers();
  }

  @Override
  public MixedOperation<ResourceQuota, ResourceQuotaList, DoneableResourceQuota, Resource<ResourceQuota, DoneableResourceQuota>> resourceQuotas() {
    return delegate.resourceQuotas();
  }

  @Override
  public MixedOperation<Secret, SecretList, DoneableSecret, Resource<Secret, DoneableSecret>> secrets() {
    return delegate.secrets();
  }

  @Override
  public MixedOperation<Service, ServiceList, DoneableService, Resource<Service, DoneableService>> services() {
    return delegate.services();
  }

  @Override
  public MixedOperation<ServiceAccount, ServiceAccountList, DoneableServiceAccount, Resource<ServiceAccount, DoneableServiceAccount>> serviceAccounts() {
    return delegate.serviceAccounts();
  }

  @Override
  public KubernetesListMixedOperation lists() {
    return delegate.lists();
  }

  @Override
  public NonNamespaceOperation<SecurityContextConstraints, SecurityContextConstraintsList, DoneableSecurityContextConstraints, Resource<SecurityContextConstraints, DoneableSecurityContextConstraints>> securityContextConstraints() {
    return delegate.securityContextConstraints();
  }

  @Override
  public MixedOperation<ConfigMap, ConfigMapList, DoneableConfigMap, Resource<ConfigMap, DoneableConfigMap>> configMaps() {
    return delegate.configMaps();
  }

  @Override
  public MixedOperation<LimitRange, LimitRangeList, DoneableLimitRange, Resource<LimitRange, DoneableLimitRange>> limitRanges() {
    return delegate.limitRanges();
  }

  @Override
  public NonNamespaceOperation<CustomResourceDefinition, CustomResourceDefinitionList, DoneableCustomResourceDefinition, Resource<CustomResourceDefinition, DoneableCustomResourceDefinition>> customResourceDefinitions() {
    return new CustomResourceDefinitionOperationsImpl(httpClient, getConfiguration());
  }

  @Override
  public MixedOperation<Build, BuildList, DoneableBuild, BuildResource<Build, DoneableBuild, String, LogWatch>> builds() {
    return new BuildOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()), getNamespace());
  }

  @Override
  public MixedOperation<BuildConfig, BuildConfigList, DoneableBuildConfig, BuildConfigResource<BuildConfig, DoneableBuildConfig, Void, Build>> buildConfigs() {
    return new BuildConfigOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()), getNamespace());
  }

  @Override
  public MixedOperation<DeploymentConfig, DeploymentConfigList, DoneableDeploymentConfig, DeployableScalableResource<DeploymentConfig, DoneableDeploymentConfig>> deploymentConfigs() {
    return new DeploymentConfigOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()), getNamespace());
  }

  @Override
  public MixedOperation<Group, GroupList, DoneableGroup, Resource<Group, DoneableGroup>> groups() {
    return new GroupOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()), getNamespace());
  }

  @Override
  public MixedOperation<ImageStream, ImageStreamList, DoneableImageStream, Resource<ImageStream, DoneableImageStream>> imageStreams() {
    return new ImageStreamOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()), getNamespace());
  }

  @Override
  public MixedOperation<ImageStreamTag, ImageStreamTagList, DoneableImageStreamTag, Resource<ImageStreamTag, DoneableImageStreamTag>> imageStreamTags() {
    return new ImageStreamTagOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()), getNamespace());
  }

  @Override
  public NonNamespaceOperation<OAuthAccessToken, OAuthAccessTokenList, DoneableOAuthAccessToken, Resource<OAuthAccessToken, DoneableOAuthAccessToken>> oAuthAccessTokens() {
    return new OAuthAccessTokenOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<OAuthAuthorizeToken, OAuthAuthorizeTokenList, DoneableOAuthAuthorizeToken, Resource<OAuthAuthorizeToken, DoneableOAuthAuthorizeToken>> oAuthAuthorizeTokens() {
    return new OAuthAuthorizeTokenOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<OAuthClient, OAuthClientList, DoneableOAuthClient, Resource<OAuthClient, DoneableOAuthClient>> oAuthClients() {
    return new OAuthClientOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public MixedOperation<Policy, PolicyList, DoneablePolicy, Resource<Policy, DoneablePolicy>> policies() {
    return new PolicyOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()), getNamespace());
  }

  @Override
  public MixedOperation<PolicyBinding, PolicyBindingList, DoneablePolicyBinding, Resource<PolicyBinding, DoneablePolicyBinding>> policyBindings() {
    return new PolicyBindingOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()), getNamespace());
  }

  @Override
  public NonNamespaceOperation<Project, ProjectList, DoneableProject, Resource<Project, DoneableProject>> projects() {
    return new ProjectOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public ProjectRequestOperation projectrequests() {
    return new ProjectRequestsOperationImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public MixedOperation<Role, RoleList, DoneableRole, Resource<Role, DoneableRole>> roles() {
    return new RoleOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()), getNamespace());
  }

  @Override
  public MixedOperation<RoleBinding, RoleBindingList, DoneableRoleBinding, Resource<RoleBinding, DoneableRoleBinding>> roleBindings() {
    return new RoleBindingOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()), getNamespace());
  }

  @Override
  public MixedOperation<Route, RouteList, DoneableRoute, Resource<Route, DoneableRoute>> routes() {
    return new RouteOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()), getNamespace());
  }

  @Override
  public ParameterMixedOperation<Template, TemplateList, DoneableTemplate, TemplateResource<Template, KubernetesList, DoneableTemplate>> templates() {
    return new TemplateOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()), getNamespace());
  }

  @Override
  public MixedOperation<User, UserList, DoneableUser, Resource<User, DoneableUser>> users() {
    return new UserOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()), getNamespace());
  }

  @Override
  public SubjectAccessReviewOperation<CreateableSubjectAccessReview, CreateableLocalSubjectAccessReview> subjectAccessReviews() {
    return new SubjectAccessReviewOperationImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()), null, getNamespace());
  }

  @Override
  public MixedOperation<ClusterRoleBinding, ClusterRoleBindingList, DoneableClusterRoleBinding, Resource<ClusterRoleBinding, DoneableClusterRoleBinding>> clusterRoleBindings() {
    return new ClusterRoleBindingOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()), getNamespace());
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
  public AppsAPIGroupDSL apps() {
    return adapt(AppsAPIGroupClient.class);
  }

  @Override
  public AutoscalingAPIGroupDSL autoscaling() {
    return adapt(AutoscalingAPIGroupClient.class);
  }

  @Override
  public FunctionCallable<NamespacedOpenShiftClient> withRequestConfig(RequestConfig requestConfig) {
    return new WithRequestCallable<NamespacedOpenShiftClient>(this, requestConfig);
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
