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

import io.fabric8.kubernetes.api.model.DoneableLimitRange;
import io.fabric8.kubernetes.api.model.LimitRange;
import io.fabric8.kubernetes.api.model.LimitRangeList;
import io.fabric8.kubernetes.client.dsl.ClientScaleableResource;
import io.fabric8.openshift.api.model.*;
import io.fabric8.openshift.client.dsl.internal.ImageStreamTagOperationsImpl;
import okhttp3.Authenticator;
import okhttp3.OkHttpClient;

import io.fabric8.kubernetes.api.model.ComponentStatus;
import io.fabric8.kubernetes.api.model.ComponentStatusList;
import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.ConfigMapList;
import io.fabric8.kubernetes.api.model.DoneableComponentStatus;
import io.fabric8.kubernetes.api.model.DoneableConfigMap;
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
import io.fabric8.kubernetes.api.model.DoneableSecurityContextConstraints;
import io.fabric8.kubernetes.api.model.DoneableService;
import io.fabric8.kubernetes.api.model.DoneableServiceAccount;
import io.fabric8.kubernetes.api.model.Endpoints;
import io.fabric8.kubernetes.api.model.EndpointsList;
import io.fabric8.kubernetes.api.model.Event;
import io.fabric8.kubernetes.api.model.EventList;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesList;
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
import io.fabric8.kubernetes.api.model.SecurityContextConstraints;
import io.fabric8.kubernetes.api.model.SecurityContextConstraintsList;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.ServiceAccount;
import io.fabric8.kubernetes.api.model.ServiceAccountList;
import io.fabric8.kubernetes.api.model.ServiceList;
import io.fabric8.kubernetes.client.BaseClient;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.ExtensionsAPIGroupClient;
import io.fabric8.kubernetes.client.NamespacedKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.ClientKubernetesListMixedOperation;
import io.fabric8.kubernetes.client.dsl.ClientMixedOperation;
import io.fabric8.kubernetes.client.dsl.ClientNonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.ClientPodResource;
import io.fabric8.kubernetes.client.dsl.ClientResource;
import io.fabric8.kubernetes.client.dsl.ClientRollableScallableResource;
import io.fabric8.kubernetes.client.dsl.NamespaceVisitFromServerGetDeleteRecreateApplicable;
import io.fabric8.kubernetes.client.dsl.internal.ComponentStatusOperationsImpl;
import io.fabric8.openshift.client.dsl.ClientBuildConfigResource;
import io.fabric8.openshift.client.dsl.ClientProjectRequestOperation;
import io.fabric8.openshift.client.dsl.ClientSubjectAccessReviewOperation;
import io.fabric8.openshift.client.dsl.ClientTemplateResource;
import io.fabric8.openshift.client.dsl.CreateableLocalSubjectAccessReview;
import io.fabric8.openshift.client.dsl.CreateableSubjectAccessReview;
import io.fabric8.openshift.client.dsl.internal.BuildConfigOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.BuildOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.ClientSubjectAccessReviewOperationImpl;
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
import java.util.List;

public class DefaultOpenShiftClient extends BaseClient implements NamespacedOpenShiftClient {

  private URL openShiftUrl;
  private NamespacedKubernetesClient delegate;

  public DefaultOpenShiftClient() throws KubernetesClientException {
    this(new OpenShiftConfigBuilder().build());
  }

  public DefaultOpenShiftClient(final Config config) throws KubernetesClientException {
    this(new OpenShiftConfig(config));
  }

  public DefaultOpenShiftClient(final OpenShiftConfig config) throws KubernetesClientException {
    super(config);
    try {
      this.delegate = new DefaultKubernetesClient(clientWithOpenShiftOAuthInterceptor(httpClient), config);
      this.openShiftUrl = new URL(config.getOpenShiftUrl());
    } catch (MalformedURLException e) {
      throw new KubernetesClientException("Could not create client", e);
    }
  }

  public DefaultOpenShiftClient(String masterUrl) throws KubernetesClientException {
    this(new OpenShiftConfigBuilder().withMasterUrl(masterUrl).build());
  }

  protected DefaultOpenShiftClient(OkHttpClient httpClient, OpenShiftConfig config) throws KubernetesClientException {
    super(httpClient, config);
    try {
      this.delegate = new DefaultKubernetesClient(clientWithOpenShiftOAuthInterceptor(httpClient), config);
      this.openShiftUrl = new URL(config.getOpenShiftUrl());
    } catch (MalformedURLException e) {
      throw new KubernetesClientException("Could not create client", e);
    }
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
  public ClientMixedOperation<ComponentStatus, ComponentStatusList, DoneableComponentStatus, ClientResource<ComponentStatus, DoneableComponentStatus>> componentstatuses() {
    return new ComponentStatusOperationsImpl(httpClient, getConfiguration());
  }

  @Override
  public NamespaceVisitFromServerGetDeleteRecreateApplicable<List<HasMetadata>, Boolean> load(InputStream is) {
    return delegate.load(is);
  }

  @Override
  public NamespaceVisitFromServerGetDeleteRecreateApplicable<List<HasMetadata>, Boolean> resource(HasMetadata item) {
    return delegate.resource(item);
  }

  @Override
  public ClientMixedOperation<Endpoints, EndpointsList, DoneableEndpoints, ClientResource<Endpoints, DoneableEndpoints>> endpoints() {
    return delegate.endpoints();
  }

  @Override
  public ClientMixedOperation<Event, EventList, DoneableEvent, ClientResource<Event, DoneableEvent>> events() {
    return delegate.events();
  }

  @Override
  public ClientNonNamespaceOperation<Namespace, NamespaceList, DoneableNamespace, ClientResource<Namespace, DoneableNamespace>> namespaces() {
    return delegate.namespaces();
  }

  @Override
  public ClientNonNamespaceOperation<Node, NodeList, DoneableNode, ClientResource<Node, DoneableNode>> nodes() {
    return delegate.nodes();
  }

  @Override
  public ClientNonNamespaceOperation<PersistentVolume, PersistentVolumeList, DoneablePersistentVolume, ClientResource<PersistentVolume, DoneablePersistentVolume>> persistentVolumes() {
    return delegate.persistentVolumes();
  }

  @Override
  public ClientMixedOperation<PersistentVolumeClaim, PersistentVolumeClaimList, DoneablePersistentVolumeClaim, ClientResource<PersistentVolumeClaim, DoneablePersistentVolumeClaim>> persistentVolumeClaims() {
    return delegate.persistentVolumeClaims();
  }

  @Override
  public ClientMixedOperation<Pod, PodList, DoneablePod, ClientPodResource<Pod, DoneablePod>> pods() {
    return delegate.pods();
  }

  @Override
  public ClientMixedOperation<ReplicationController, ReplicationControllerList, DoneableReplicationController, ClientRollableScallableResource<ReplicationController, DoneableReplicationController>> replicationControllers() {
    return delegate.replicationControllers();
  }

  @Override
  public ClientMixedOperation<ResourceQuota, ResourceQuotaList, DoneableResourceQuota, ClientResource<ResourceQuota, DoneableResourceQuota>> resourceQuotas() {
    return delegate.resourceQuotas();
  }

  @Override
  public ClientMixedOperation<Secret, SecretList, DoneableSecret, ClientResource<Secret, DoneableSecret>> secrets() {
    return delegate.secrets();
  }

  @Override
  public ClientMixedOperation<Service, ServiceList, DoneableService, ClientResource<Service, DoneableService>> services() {
    return delegate.services();
  }

  @Override
  public ClientMixedOperation<ServiceAccount, ServiceAccountList, DoneableServiceAccount, ClientResource<ServiceAccount, DoneableServiceAccount>> serviceAccounts() {
    return delegate.serviceAccounts();
  }

  @Override
  public ClientKubernetesListMixedOperation lists() {
    return delegate.lists();
  }

  @Override
  public ClientNonNamespaceOperation<SecurityContextConstraints, SecurityContextConstraintsList, DoneableSecurityContextConstraints, ClientResource<SecurityContextConstraints, DoneableSecurityContextConstraints>> securityContextConstraints() {
    return delegate.securityContextConstraints();
  }

  @Override
  public ClientMixedOperation<ConfigMap, ConfigMapList, DoneableConfigMap, ClientResource<ConfigMap, DoneableConfigMap>> configMaps() {
    return delegate.configMaps();
  }

  @Override
  public ClientMixedOperation<LimitRange, LimitRangeList, DoneableLimitRange, ClientResource<LimitRange, DoneableLimitRange>> limitRanges() {
    return delegate.limitRanges();
  }

  @Override
  public ClientMixedOperation<Build, BuildList, DoneableBuild, ClientResource<Build, DoneableBuild>> builds() {
    return new BuildOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()), getNamespace());
  }

  @Override
  public ClientMixedOperation<BuildConfig, BuildConfigList, DoneableBuildConfig, ClientBuildConfigResource<BuildConfig, DoneableBuildConfig, Void, Build>> buildConfigs() {
    return new BuildConfigOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()), getNamespace());
  }

  @Override
  public ClientMixedOperation<DeploymentConfig, DeploymentConfigList, DoneableDeploymentConfig, ClientScaleableResource<DeploymentConfig, DoneableDeploymentConfig>> deploymentConfigs() {
    return new DeploymentConfigOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()), getNamespace());
  }

  @Override
  public ClientMixedOperation<Group, GroupList, DoneableGroup, ClientResource<Group, DoneableGroup>> groups() {
    return new GroupOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()), getNamespace());
  }

  @Override
  public ClientMixedOperation<ImageStream, ImageStreamList, DoneableImageStream, ClientResource<ImageStream, DoneableImageStream>> imageStreams() {
    return new ImageStreamOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()), getNamespace());
  }

  @Override
  public ClientMixedOperation<ImageStreamTag, ImageStreamTagList, DoneableImageStreamTag, ClientResource<ImageStreamTag, DoneableImageStreamTag>> imageStreamTags() {
    return new ImageStreamTagOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()), getNamespace());
  }

  @Override
  public ClientNonNamespaceOperation<OAuthAccessToken, OAuthAccessTokenList, DoneableOAuthAccessToken, ClientResource<OAuthAccessToken, DoneableOAuthAccessToken>> oAuthAccessTokens() {
    return new OAuthAccessTokenOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public ClientNonNamespaceOperation<OAuthAuthorizeToken, OAuthAuthorizeTokenList, DoneableOAuthAuthorizeToken, ClientResource<OAuthAuthorizeToken, DoneableOAuthAuthorizeToken>> oAuthAuthorizeTokens() {
    return new OAuthAuthorizeTokenOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public ClientNonNamespaceOperation<OAuthClient, OAuthClientList, DoneableOAuthClient, ClientResource<OAuthClient, DoneableOAuthClient>> oAuthClients() {
    return new OAuthClientOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public ClientMixedOperation<Policy, PolicyList, DoneablePolicy, ClientResource<Policy, DoneablePolicy>> policies() {
    return new PolicyOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()), getNamespace());
  }

  @Override
  public ClientMixedOperation<PolicyBinding, PolicyBindingList, DoneablePolicyBinding, ClientResource<PolicyBinding, DoneablePolicyBinding>> policyBindings() {
    return new PolicyBindingOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()), getNamespace());
  }

  @Override
  public ClientNonNamespaceOperation<Project, ProjectList, DoneableProject, ClientResource<Project, DoneableProject>> projects() {
    return new ProjectOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public ClientProjectRequestOperation projectrequests() {
    return new ProjectRequestsOperationImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public ClientMixedOperation<RoleBinding, RoleBindingList, DoneableRoleBinding, ClientResource<RoleBinding, DoneableRoleBinding>> roleBindings() {
    return new RoleBindingOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()), getNamespace());
  }

  @Override
  public ClientMixedOperation<Route, RouteList, DoneableRoute, ClientResource<Route, DoneableRoute>> routes() {
    return new RouteOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()), getNamespace());
  }

  @Override
  public ClientMixedOperation<Template, TemplateList, DoneableTemplate, ClientTemplateResource<Template, KubernetesList, DoneableTemplate>> templates() {
    return new TemplateOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()), getNamespace());
  }

  @Override
  public ClientMixedOperation<User, UserList, DoneableUser, ClientResource<User, DoneableUser>> users() {
    return new UserOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()), getNamespace());
  }

  @Override
  public ClientSubjectAccessReviewOperation<CreateableSubjectAccessReview, CreateableLocalSubjectAccessReview> subjectAccessReviews() {
    return new ClientSubjectAccessReviewOperationImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()), null, getNamespace());
  }

  @Override
  public ClientMixedOperation<ClusterRoleBinding, ClusterRoleBindingList, DoneableClusterRoleBinding, ClientResource<ClusterRoleBinding, DoneableClusterRoleBinding>> clusterRoleBindings() {
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
}
