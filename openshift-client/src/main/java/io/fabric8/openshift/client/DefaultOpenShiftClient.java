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

import io.fabric8.kubernetes.api.model.ComponentStatus;
import io.fabric8.kubernetes.api.model.ComponentStatusList;
import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.RootPaths;
import io.fabric8.kubernetes.client.BaseKubernetesClient;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ExtensionsAPIGroupClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.RequestConfig;
import io.fabric8.kubernetes.client.VersionInfo;
import io.fabric8.kubernetes.client.WithRequestCallable;
import io.fabric8.kubernetes.client.dsl.FunctionCallable;
import io.fabric8.kubernetes.client.dsl.InOutCreateable;
import io.fabric8.kubernetes.client.dsl.LogWatch;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NamespaceListVisitFromServerGetDeleteRecreateWaitApplicable;
import io.fabric8.kubernetes.client.dsl.NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicable;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.ParameterMixedOperation;
import io.fabric8.kubernetes.client.dsl.ParameterNamespaceListVisitFromServerGetDeleteRecreateWaitApplicable;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.Waitable;
import io.fabric8.kubernetes.client.dsl.internal.CreateOnlyResourceOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.NamespacedCreateOnlyResourceOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.core.v1.ComponentStatusOperationsImpl;
import io.fabric8.kubernetes.client.extended.leaderelection.LeaderElectorBuilder;
import io.fabric8.kubernetes.client.utils.BackwardsCompatibilityInterceptor;
import io.fabric8.kubernetes.client.utils.ImpersonatorInterceptor;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.openshift.api.model.BrokerTemplateInstance;
import io.fabric8.openshift.api.model.BrokerTemplateInstanceList;
import io.fabric8.openshift.api.model.Build;
import io.fabric8.openshift.api.model.BuildConfig;
import io.fabric8.openshift.api.model.BuildConfigList;
import io.fabric8.openshift.api.model.BuildList;
import io.fabric8.openshift.api.model.ClusterNetwork;
import io.fabric8.openshift.api.model.ClusterNetworkList;
import io.fabric8.openshift.api.model.ClusterRole;
import io.fabric8.openshift.api.model.ClusterRoleBinding;
import io.fabric8.openshift.api.model.ClusterRoleBindingList;
import io.fabric8.openshift.api.model.ClusterRoleList;
import io.fabric8.openshift.api.model.DeploymentConfig;
import io.fabric8.openshift.api.model.DeploymentConfigList;
import io.fabric8.openshift.api.model.EgressNetworkPolicy;
import io.fabric8.openshift.api.model.EgressNetworkPolicyList;
import io.fabric8.openshift.api.model.Group;
import io.fabric8.openshift.api.model.GroupList;
import io.fabric8.openshift.api.model.HelmChartRepository;
import io.fabric8.openshift.api.model.HelmChartRepositoryList;
import io.fabric8.openshift.api.model.HostSubnet;
import io.fabric8.openshift.api.model.HostSubnetList;
import io.fabric8.openshift.api.model.Identity;
import io.fabric8.openshift.api.model.IdentityList;
import io.fabric8.openshift.api.model.Image;
import io.fabric8.openshift.api.model.ImageList;
import io.fabric8.openshift.api.model.ImageSignature;
import io.fabric8.openshift.api.model.ImageStream;
import io.fabric8.openshift.api.model.ImageStreamImage;
import io.fabric8.openshift.api.model.ImageStreamImport;
import io.fabric8.openshift.api.model.ImageStreamList;
import io.fabric8.openshift.api.model.ImageStreamMapping;
import io.fabric8.openshift.api.model.ImageStreamTag;
import io.fabric8.openshift.api.model.ImageStreamTagList;
import io.fabric8.openshift.api.model.ImageTag;
import io.fabric8.openshift.api.model.ImageTagList;
import io.fabric8.openshift.api.model.LocalResourceAccessReview;
import io.fabric8.openshift.api.model.LocalSubjectAccessReview;
import io.fabric8.openshift.api.model.NetNamespace;
import io.fabric8.openshift.api.model.NetNamespaceList;
import io.fabric8.openshift.api.model.OAuthAccessToken;
import io.fabric8.openshift.api.model.OAuthAccessTokenList;
import io.fabric8.openshift.api.model.OAuthAuthorizeToken;
import io.fabric8.openshift.api.model.OAuthAuthorizeTokenList;
import io.fabric8.openshift.api.model.OAuthClient;
import io.fabric8.openshift.api.model.OAuthClientAuthorization;
import io.fabric8.openshift.api.model.OAuthClientAuthorizationList;
import io.fabric8.openshift.api.model.OAuthClientList;
import io.fabric8.openshift.api.model.PodSecurityPolicyReview;
import io.fabric8.openshift.api.model.PodSecurityPolicySelfSubjectReview;
import io.fabric8.openshift.api.model.PodSecurityPolicySubjectReview;
import io.fabric8.openshift.api.model.RangeAllocation;
import io.fabric8.openshift.api.model.RangeAllocationList;
import io.fabric8.openshift.api.model.ResourceAccessReview;
import io.fabric8.openshift.api.model.ResourceAccessReviewResponse;
import io.fabric8.openshift.api.model.Role;
import io.fabric8.openshift.api.model.RoleBinding;
import io.fabric8.openshift.api.model.RoleBindingList;
import io.fabric8.openshift.api.model.RoleBindingRestriction;
import io.fabric8.openshift.api.model.RoleBindingRestrictionList;
import io.fabric8.openshift.api.model.RoleList;
import io.fabric8.openshift.api.model.Route;
import io.fabric8.openshift.api.model.RouteList;
import io.fabric8.openshift.api.model.SecurityContextConstraints;
import io.fabric8.openshift.api.model.SecurityContextConstraintsList;
import io.fabric8.openshift.api.model.SelfSubjectRulesReview;
import io.fabric8.openshift.api.model.SubjectAccessReview;
import io.fabric8.openshift.api.model.SubjectAccessReviewResponse;
import io.fabric8.openshift.api.model.SubjectRulesReview;
import io.fabric8.openshift.api.model.Template;
import io.fabric8.openshift.api.model.TemplateInstance;
import io.fabric8.openshift.api.model.TemplateInstanceList;
import io.fabric8.openshift.api.model.TemplateList;
import io.fabric8.openshift.api.model.User;
import io.fabric8.openshift.api.model.UserIdentityMapping;
import io.fabric8.openshift.api.model.UserList;
import io.fabric8.openshift.api.model.UserOAuthAccessToken;
import io.fabric8.openshift.api.model.UserOAuthAccessTokenList;
import io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1.CredentialsRequest;
import io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1.CredentialsRequestList;
import io.fabric8.openshift.api.model.miscellaneous.cncf.cni.v1.NetworkAttachmentDefinition;
import io.fabric8.openshift.api.model.miscellaneous.cncf.cni.v1.NetworkAttachmentDefinitionList;
import io.fabric8.openshift.api.model.miscellaneous.imageregistry.operator.v1.ConfigList;
import io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1.BareMetalHost;
import io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1.BareMetalHostList;
import io.fabric8.openshift.api.model.miscellaneous.network.operator.v1.OperatorPKI;
import io.fabric8.openshift.api.model.miscellaneous.network.operator.v1.OperatorPKIList;
import io.fabric8.openshift.client.dsl.BuildConfigResource;
import io.fabric8.openshift.client.dsl.BuildResource;
import io.fabric8.openshift.client.dsl.DeployableScalableResource;
import io.fabric8.openshift.client.dsl.MachineConfigurationAPIGroupDSL;
import io.fabric8.openshift.client.dsl.OpenShiftClusterAutoscalingAPIGroupDSL;
import io.fabric8.openshift.client.dsl.OpenShiftConfigAPIGroupDSL;
import io.fabric8.openshift.client.dsl.OpenShiftConsoleAPIGroupDSL;
import io.fabric8.openshift.client.dsl.OpenShiftMachineAPIGroupDSL;
import io.fabric8.openshift.client.dsl.OpenShiftMonitoringAPIGroupDSL;
import io.fabric8.openshift.client.dsl.OpenShiftOperatorAPIGroupDSL;
import io.fabric8.openshift.client.dsl.OpenShiftOperatorHubAPIGroupDSL;
import io.fabric8.openshift.client.dsl.OpenShiftQuotaAPIGroupDSL;
import io.fabric8.openshift.client.dsl.OpenShiftStorageVersionMigratorApiGroupDSL;
import io.fabric8.openshift.client.dsl.OpenShiftTunedAPIGroupDSL;
import io.fabric8.openshift.client.dsl.OpenShiftWhereaboutsAPIGroupDSL;
import io.fabric8.openshift.client.dsl.ProjectOperation;
import io.fabric8.openshift.client.dsl.ProjectRequestOperation;
import io.fabric8.openshift.client.dsl.TemplateResource;
import io.fabric8.openshift.client.dsl.internal.authorization.ClusterRoleOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.ProjectRequestsOperationImpl;
import io.fabric8.openshift.client.dsl.internal.apps.DeploymentConfigOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.authorization.ClusterRoleBindingOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.authorization.RoleBindingOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.authorization.RoleBindingRestrictionOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.authorization.RoleOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.build.BuildConfigOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.build.BuildOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.cloudcredential.CredentialsRequestOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.core.BareMetalHostOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.core.NetworkAttachmentDefinitionOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.core.TemplateOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.helm.HelmChartRepositoryOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.image.ImageSignatureOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.image.ImageStreamImageOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.network.ClusterNetworkOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.network.EgressNetworkPolicyOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.network.HostSubnetOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.network.operator.OperatorPKIOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.oauth.OAuthClientAuthorizationOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.oauth.UserOAuthAccessTokenOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.template.BrokerTemplateInstanceOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.template.TemplateInstanceOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.user.GroupOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.image.ImageOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.image.ImageStreamOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.image.ImageStreamTagOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.image.ImageTagOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.network.NetNamespaceOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.oauth.OAuthAccessTokenOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.oauth.OAuthAuthorizeTokenOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.oauth.OAuthClientOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.project.ProjectOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.route.RouteOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.security.RangeAllocationOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.security.SecurityContextConstraintsOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.user.IdentityOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.user.UserOperationsImpl;
import io.fabric8.openshift.client.internal.OpenShiftClusterOperationsImpl;
import io.fabric8.openshift.client.internal.OpenShiftNamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableImpl;
import io.fabric8.openshift.client.internal.OpenShiftNamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl;
import io.fabric8.openshift.client.internal.OpenShiftOAuthInterceptor;
import okhttp3.Authenticator;
import okhttp3.OkHttpClient;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Class for Default Openshift Client implementing KubernetesClient interface.
 * It is thread safe.
 */
public class DefaultOpenShiftClient extends BaseKubernetesClient<NamespacedOpenShiftClient> implements NamespacedOpenShiftClient {

  private static final Map<String, Boolean> API_GROUPS_ENABLED_PER_URL = new HashMap<>();
  public static final String AUTHORIZATION_OPENSHIFT_IO = "authorization.openshift.io";
  public static final String V1_APIVERSION = "v1";
  private static final String SECURITY_OPENSHIFT_APIGROUP = "security.openshift.io";
  private static final String IMAGE_OPENSHIFT_APIGROUP = "image.openshift.io";

  private final URL openShiftUrl;

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
      this.openShiftUrl = new URL(config.getOpenShiftUrl());
    } catch (MalformedURLException e) {
      throw new KubernetesClientException("Could not create client", e);
    }
  }

  public DefaultOpenShiftClient(OkHttpClient httpClient, OpenShiftConfig config) {
    super(httpClient, configWithApiGroupsEnabled(httpClient, config));
    try {
      this.httpClient = clientWithOpenShiftOAuthInterceptor(httpClient, getConfiguration());
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
  public OpenShiftClusterAutoscalingAPIGroupDSL clusterAutoscaling() {
    return adapt(OpenShiftClusterAutoscalingAPIGroupClient.class);
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
  public NamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata> resourceList(KubernetesResourceList item) {
    return new OpenShiftNamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl(httpClient, getConfiguration(), getNamespace(), null, false, false, new ArrayList<>(), item, null, DeletionPropagation.BACKGROUND, true, false) {
    };
  }

  @Override
  public ParameterNamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata> resourceList(String s) {
    return new OpenShiftNamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl(httpClient, getConfiguration(), getNamespace(), null, false, false, new ArrayList<>(), s, null, DeletionPropagation.BACKGROUND, true, false) {
    };
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
  public MixedOperation<CredentialsRequest, CredentialsRequestList, Resource<CredentialsRequest>> credentialsRequests() {
    return new CredentialsRequestOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
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
  public NonNamespaceOperation<HelmChartRepository, HelmChartRepositoryList, Resource<HelmChartRepository>> helmChartRepositories() {
    return new HelmChartRepositoryOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
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
  public NamespacedCreateOnlyResourceOperationsImpl<ImageStreamImport, ImageStreamImport> imageStreamImports() {
    return new NamespacedCreateOnlyResourceOperationsImpl<>(getHttpClient(), getConfiguration(), IMAGE_OPENSHIFT_APIGROUP, V1_APIVERSION, HasMetadata.getPlural(ImageStreamImport.class), ImageStreamImport.class);
  }

  @Override
  public NamespacedCreateOnlyResourceOperationsImpl<ImageStreamMapping, ImageStreamMapping> imageStreamMappings() {
    return new NamespacedCreateOnlyResourceOperationsImpl<>(getHttpClient(), getConfiguration(), IMAGE_OPENSHIFT_APIGROUP, V1_APIVERSION, HasMetadata.getPlural(ImageStreamMapping.class), ImageStreamMapping.class);
  }

  @Override
  public ImageStreamImageOperationsImpl imageStreamImages() {
    return new ImageStreamImageOperationsImpl(getHttpClient(), getConfiguration(), IMAGE_OPENSHIFT_APIGROUP, V1_APIVERSION, HasMetadata.getPlural(ImageStreamImage.class));
  }

  @Override
  public ImageSignatureOperationsImpl imageSignatures() {
    return new ImageSignatureOperationsImpl(getHttpClient(), getConfiguration(), IMAGE_OPENSHIFT_APIGROUP, V1_APIVERSION, HasMetadata.getPlural(ImageSignature.class));
  }

  @Override
  public NonNamespaceOperation<io.fabric8.openshift.api.model.miscellaneous.imageregistry.operator.v1.Config, ConfigList, Resource<io.fabric8.openshift.api.model.miscellaneous.imageregistry.operator.v1.Config>> imageRegistryOperatorConfigs() {
    return new io.fabric8.openshift.client.dsl.internal.imageregistry.operator.ConfigOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public MixedOperation<NetworkAttachmentDefinition, NetworkAttachmentDefinitionList, Resource<NetworkAttachmentDefinition>> networkAttachmentDefinitions() {
    return new NetworkAttachmentDefinitionOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
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
  public NamespacedCreateOnlyResourceOperationsImpl<PodSecurityPolicyReview, PodSecurityPolicyReview> podSecurityPolicyReviews() {
    return new NamespacedCreateOnlyResourceOperationsImpl<>(getHttpClient(), getConfiguration(), SECURITY_OPENSHIFT_APIGROUP, V1_APIVERSION, HasMetadata.getPlural(PodSecurityPolicyReview.class), PodSecurityPolicyReview.class);
  }

  @Override
  public NonNamespaceOperation<OAuthClientAuthorization, OAuthClientAuthorizationList, Resource<OAuthClientAuthorization>> oAuthClientAuthorizations() {
    return new OAuthClientAuthorizationOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public MixedOperation<OperatorPKI, OperatorPKIList, Resource<OperatorPKI>> operatorPKIs() {
    return new OperatorPKIOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NamespacedCreateOnlyResourceOperationsImpl<PodSecurityPolicySelfSubjectReview, PodSecurityPolicySelfSubjectReview> podSecurityPolicySelfSubjectReviews() {
    return new NamespacedCreateOnlyResourceOperationsImpl<>(getHttpClient(), getConfiguration(), SECURITY_OPENSHIFT_APIGROUP, V1_APIVERSION, HasMetadata.getPlural(PodSecurityPolicySelfSubjectReview.class), PodSecurityPolicySelfSubjectReview.class);
  }

  @Override
  public NamespacedCreateOnlyResourceOperationsImpl<PodSecurityPolicySubjectReview, PodSecurityPolicySubjectReview> podSecurityPolicySubjectReviews() {
    return new NamespacedCreateOnlyResourceOperationsImpl<>(getHttpClient(), getConfiguration(), SECURITY_OPENSHIFT_APIGROUP, V1_APIVERSION, HasMetadata.getPlural(PodSecurityPolicySubjectReview.class), PodSecurityPolicySubjectReview.class);
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
  public MixedOperation<TemplateInstance, TemplateInstanceList, Resource<TemplateInstance>> templateInstances() {
    return new TemplateInstanceOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public OpenShiftTunedAPIGroupDSL tuned() {
    return adapt(OpenShiftTunedAPIGroupClient.class);
  }

  @Override
  public NonNamespaceOperation<BrokerTemplateInstance, BrokerTemplateInstanceList, Resource<BrokerTemplateInstance>> brokerTemplateInstances() {
    return new BrokerTemplateInstanceOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
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
  public MixedOperation<RoleBindingRestriction, RoleBindingRestrictionList, Resource<RoleBindingRestriction>> roleBindingRestrictions() {
    return new RoleBindingRestrictionOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
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
    return versionInfo == null ? super.getVersion() : versionInfo;
  }

  @Override
  public MachineConfigurationAPIGroupDSL machineConfigurations() {
    return adapt(OpenShiftMachineConfigurationAPIGroupClient.class);
  }

  @Override
  public OpenShiftMachineAPIGroupDSL machine() {
    return adapt(OpenShiftMachineAPIGroupClient.class);
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
  public NonNamespaceOperation<HostSubnet, HostSubnetList, Resource<HostSubnet>> hostSubnets() {
    return new HostSubnetOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public MixedOperation<BareMetalHost, BareMetalHostList, Resource<BareMetalHost>> bareMetalHosts() {
    return new BareMetalHostOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public InOutCreateable<SubjectAccessReview, SubjectAccessReviewResponse> subjectAccessReviews() {
    return new CreateOnlyResourceOperationsImpl<>(httpClient, getConfiguration(), AUTHORIZATION_OPENSHIFT_IO, V1_APIVERSION, HasMetadata.getPlural(SubjectAccessReview.class), SubjectAccessReviewResponse.class);
  }

  @Override
  public InOutCreateable<ResourceAccessReview, ResourceAccessReviewResponse> resourceAccessReviews() {
    return new CreateOnlyResourceOperationsImpl<>(httpClient, getConfiguration(), AUTHORIZATION_OPENSHIFT_IO, V1_APIVERSION, HasMetadata.getPlural(ResourceAccessReview.class), ResourceAccessReviewResponse.class);
  }

  @Override
  public NamespacedCreateOnlyResourceOperationsImpl<LocalSubjectAccessReview, SubjectAccessReviewResponse> localSubjectAccessReviews() {
    return new NamespacedCreateOnlyResourceOperationsImpl<>(httpClient, getConfiguration(), AUTHORIZATION_OPENSHIFT_IO, V1_APIVERSION, HasMetadata.getPlural(LocalSubjectAccessReview.class), SubjectAccessReviewResponse.class);
  }

  @Override
  public NamespacedCreateOnlyResourceOperationsImpl<LocalResourceAccessReview, ResourceAccessReviewResponse> localResourceAccessReviews() {
    return new NamespacedCreateOnlyResourceOperationsImpl<>(httpClient, getConfiguration(), AUTHORIZATION_OPENSHIFT_IO, V1_APIVERSION, HasMetadata.getPlural(LocalResourceAccessReview.class), ResourceAccessReviewResponse.class);
  }

  @Override
  public NamespacedCreateOnlyResourceOperationsImpl<SelfSubjectRulesReview, SelfSubjectRulesReview> selfSubjectRulesReviews() {
    return new NamespacedCreateOnlyResourceOperationsImpl<>(httpClient, getConfiguration(), AUTHORIZATION_OPENSHIFT_IO, V1_APIVERSION, HasMetadata.getPlural(SelfSubjectRulesReview.class), SelfSubjectRulesReview.class);
  }

  @Override
  public NamespacedCreateOnlyResourceOperationsImpl<SubjectRulesReview, SubjectRulesReview> subjectRulesReviews() {
    return new NamespacedCreateOnlyResourceOperationsImpl<>(httpClient, getConfiguration(), AUTHORIZATION_OPENSHIFT_IO, V1_APIVERSION, HasMetadata.getPlural(SubjectRulesReview.class), SubjectRulesReview.class);
  }

  @Override
  public OpenShiftStorageVersionMigratorApiGroupDSL kubeStorageVersionMigrator() {
    return adapt(OpenShiftStorageVersionMigratorApiGroupClient.class);
  }

  @Override
  public NonNamespaceOperation<ClusterRole, ClusterRoleList, Resource<ClusterRole>> clusterRoles() {
    return new ClusterRoleOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public LeaderElectorBuilder<NamespacedOpenShiftClient> leaderElector() {
    return new LeaderElectorBuilder<>(this);
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
  public NonNamespaceOperation<Identity, IdentityList, Resource<Identity>> identities() {
    return new IdentityOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public InOutCreateable<UserIdentityMapping, UserIdentityMapping> userIdentityMappings() {
    return new CreateOnlyResourceOperationsImpl<>(getHttpClient(), getConfiguration(), "user.openshift.io", "v1", HasMetadata.getPlural(UserIdentityMapping.class), UserIdentityMapping.class);
  }

  @Override
  public NonNamespaceOperation<UserOAuthAccessToken, UserOAuthAccessTokenList, Resource<UserOAuthAccessToken>> userOAuthAccessTokens() {
    return new UserOAuthAccessTokenOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public OpenShiftWhereaboutsAPIGroupDSL whereabouts() {
    return adapt(OpenShiftWhereaboutsAPIGroupClient.class);
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

  @Override
  public NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicable<HasMetadata> resource(HasMetadata item) {
    return new OpenShiftNamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableImpl(httpClient, getConfiguration(), getNamespace(), null, false, false, new ArrayList<>(), item, -1, DeletionPropagation.BACKGROUND, true, Waitable.DEFAULT_INITIAL_BACKOFF_MILLIS, Waitable.DEFAULT_BACKOFF_MULTIPLIER, false);
  }

}
