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

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.RootPaths;
import io.fabric8.kubernetes.api.model.StatusDetails;
import io.fabric8.kubernetes.client.BaseClient;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.ExtensionsAPIGroupClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.RequestConfig;
import io.fabric8.kubernetes.client.VersionInfo;
import io.fabric8.kubernetes.client.WithRequestCallable;
import io.fabric8.kubernetes.client.dsl.CreateOrDeleteable;
import io.fabric8.kubernetes.client.dsl.FunctionCallable;
import io.fabric8.kubernetes.client.dsl.Gettable;
import io.fabric8.kubernetes.client.dsl.InOutCreateable;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Nameable;
import io.fabric8.kubernetes.client.dsl.NamespaceListVisitFromServerGetDeleteRecreateWaitApplicable;
import io.fabric8.kubernetes.client.dsl.Namespaceable;
import io.fabric8.kubernetes.client.dsl.NamespacedInOutCreateable;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.ParameterMixedOperation;
import io.fabric8.kubernetes.client.dsl.ParameterNamespaceListVisitFromServerGetDeleteRecreateWaitApplicable;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperation;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.utils.HttpClientUtils;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.kubernetes.client.utils.TokenRefreshInterceptor;
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
import io.fabric8.openshift.api.model.ClusterVersion;
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
import io.fabric8.openshift.api.model.ProjectRequest;
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
import io.fabric8.openshift.api.model.miscellaneous.apiserver.v1.APIRequestCount;
import io.fabric8.openshift.api.model.miscellaneous.apiserver.v1.APIRequestCountList;
import io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1.CredentialsRequest;
import io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1.CredentialsRequestList;
import io.fabric8.openshift.api.model.miscellaneous.cncf.cni.v1.NetworkAttachmentDefinition;
import io.fabric8.openshift.api.model.miscellaneous.cncf.cni.v1.NetworkAttachmentDefinitionList;
import io.fabric8.openshift.api.model.miscellaneous.imageregistry.operator.v1.ConfigList;
import io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1.BareMetalHost;
import io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1.BareMetalHostList;
import io.fabric8.openshift.api.model.miscellaneous.network.operator.v1.EgressRouter;
import io.fabric8.openshift.api.model.miscellaneous.network.operator.v1.EgressRouterList;
import io.fabric8.openshift.api.model.miscellaneous.network.operator.v1.OperatorPKI;
import io.fabric8.openshift.api.model.miscellaneous.network.operator.v1.OperatorPKIList;
import io.fabric8.openshift.client.dsl.BuildConfigResource;
import io.fabric8.openshift.client.dsl.BuildResource;
import io.fabric8.openshift.client.dsl.DeployableScalableResource;
import io.fabric8.openshift.client.dsl.MachineConfigurationAPIGroupDSL;
import io.fabric8.openshift.client.dsl.NameableCreateOrDeleteable;
import io.fabric8.openshift.client.dsl.OpenShiftClusterAutoscalingAPIGroupDSL;
import io.fabric8.openshift.client.dsl.OpenShiftConfigAPIGroupDSL;
import io.fabric8.openshift.client.dsl.OpenShiftConsoleAPIGroupDSL;
import io.fabric8.openshift.client.dsl.OpenShiftHiveAPIGroupDSL;
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
import io.fabric8.openshift.client.dsl.internal.apps.DeploymentConfigOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.authorization.RoleBindingOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.build.BuildConfigOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.build.BuildOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.core.TemplateOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.project.ProjectOperationsImpl;
import io.fabric8.openshift.client.internal.OpenShiftNamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl;
import io.fabric8.openshift.client.internal.OpenShiftOAuthInterceptor;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.text.ParseException;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * Class for Default Openshift Client implementing KubernetesClient interface.
 * It is thread safe.
 *
 * @deprecated direct usage should no longer be needed. Please use the {@link KubernetesClientBuilder} instead.
 */
@Deprecated
public class DefaultOpenShiftClient extends DefaultKubernetesClient
    implements NamespacedOpenShiftClient {

  public static final String OPENSHIFT_VERSION_ENDPOINT = "version/openshift";

  private URL openShiftUrl;

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
    this(HttpClientUtils.createHttpClient(config), config);
  }

  public DefaultOpenShiftClient(HttpClient httpClient, OpenShiftConfig config) {
    super(httpClient, config);
  }

  DefaultOpenShiftClient(Client client) {
    super(client.getConfiguration(), client.adapt(BaseClient.class));
  }

  DefaultOpenShiftClient(Config config, DefaultOpenShiftClient client) {
    super(config, client);
    this.openShiftUrl = client.openShiftUrl;
  }

  public static DefaultOpenShiftClient fromConfig(String config) {
    return new DefaultOpenShiftClient(Serialization.unmarshal(config, OpenShiftConfig.class));
  }

  public static DefaultOpenShiftClient fromConfig(InputStream is) {
    return new DefaultOpenShiftClient(Serialization.unmarshal(is, OpenShiftConfig.class));
  }

  @Override
  public URL getOpenshiftUrl() {
    return openShiftUrl;
  }

  @Override
  public OpenShiftConfig getConfiguration() {
    return OpenShiftConfig.wrap(super.getConfiguration());
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
  public OpenShiftHiveAPIGroupDSL hive() {
    return adapt(OpenShiftHiveAPIGroupClient.class);
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
  public ParameterNamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata> load(InputStream is) {
    return new OpenShiftNamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl(this, is);
  }

  @Override
  public NamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata> resourceList(KubernetesResourceList item) {
    return new OpenShiftNamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl(this, item);
  }

  @Override
  public ParameterNamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata> resourceList(String s) {
    return new OpenShiftNamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl(this, s);
  }

  @Override
  public MixedOperation<Build, BuildList, BuildResource> builds() {
    return new BuildOperationsImpl(this);
  }

  @Override
  public MixedOperation<BuildConfig, BuildConfigList, BuildConfigResource<BuildConfig, Void, Build>> buildConfigs() {
    return new BuildConfigOperationsImpl(this);
  }

  @Override
  public MixedOperation<CredentialsRequest, CredentialsRequestList, Resource<CredentialsRequest>> credentialsRequests() {
    return resources(CredentialsRequest.class, CredentialsRequestList.class);
  }

  @Override
  public MixedOperation<DeploymentConfig, DeploymentConfigList, DeployableScalableResource<DeploymentConfig>> deploymentConfigs() {
    return new DeploymentConfigOperationsImpl(this);
  }

  @Override
  public MixedOperation<Group, GroupList, Resource<Group>> groups() {
    return resources(Group.class, GroupList.class);
  }

  @Override
  public NonNamespaceOperation<HelmChartRepository, HelmChartRepositoryList, Resource<HelmChartRepository>> helmChartRepositories() {
    return resources(HelmChartRepository.class, HelmChartRepositoryList.class);
  }

  @Override
  public NonNamespaceOperation<Image, ImageList, Resource<Image>> images() {
    return resources(Image.class, ImageList.class);
  }

  @Override
  public MixedOperation<ImageTag, ImageTagList, Resource<ImageTag>> imageTags() {
    return resources(ImageTag.class, ImageTagList.class);
  }

  @Override
  public MixedOperation<ImageStream, ImageStreamList, Resource<ImageStream>> imageStreams() {
    return resources(ImageStream.class, ImageStreamList.class);
  }

  @Override
  public MixedOperation<ImageStreamTag, ImageStreamTagList, Resource<ImageStreamTag>> imageStreamTags() {
    return resources(ImageStreamTag.class, ImageStreamTagList.class);
  }

  @Override
  public NamespacedInOutCreateable<ImageStreamImport, ImageStreamImport> imageStreamImports() {
    return getHandlers().getNamespacedHasMetadataCreateOnlyOperation(ImageStreamImport.class, this);
  }

  @Override
  public NamespacedInOutCreateable<ImageStreamMapping, ImageStreamMapping> imageStreamMappings() {
    return getHandlers().getNamespacedHasMetadataCreateOnlyOperation(ImageStreamMapping.class, this);
  }

  @Override
  public Namespaceable<Nameable<? extends Gettable<ImageStreamImage>>> imageStreamImages() {
    HasMetadataOperation<ImageStreamImage, ?, Resource<ImageStreamImage>> operation = getHandlers()
        .getNonListingOperation(ImageStreamImage.class, this);
    return operation::inNamespace;
  }

  @Override
  public NameableCreateOrDeleteable imageSignatures() {
    HasMetadataOperation<ImageSignature, ?, Resource<ImageSignature>> operation = getHandlers()
        .getNonListingOperation(ImageSignature.class, this);
    return new NameableCreateOrDeleteable() {

      @Override
      public List<StatusDetails> delete() {
        return operation.delete();
      }

      @Override
      public ImageSignature create(ImageSignature item) {
        return operation.create(item);
      }

      @Override
      public CreateOrDeleteable<ImageSignature> withName(String name) {
        return new CreateOrDeleteable<ImageSignature>() {

          @Override
          public ImageSignature create(ImageSignature item) {
            return operation.withName(name).create(item);
          }

          @Override
          public List<StatusDetails> delete() {
            return operation.withName(name).delete();
          }

        };
      }
    };
  }

  @Override
  public NonNamespaceOperation<io.fabric8.openshift.api.model.miscellaneous.imageregistry.operator.v1.Config, ConfigList, Resource<io.fabric8.openshift.api.model.miscellaneous.imageregistry.operator.v1.Config>> imageRegistryOperatorConfigs() {
    return resources(io.fabric8.openshift.api.model.miscellaneous.imageregistry.operator.v1.Config.class,
        ConfigList.class);
  }

  @Override
  public MixedOperation<NetworkAttachmentDefinition, NetworkAttachmentDefinitionList, Resource<NetworkAttachmentDefinition>> networkAttachmentDefinitions() {
    return resources(NetworkAttachmentDefinition.class, NetworkAttachmentDefinitionList.class);
  }

  @Override
  public NonNamespaceOperation<OAuthAccessToken, OAuthAccessTokenList, Resource<OAuthAccessToken>> oAuthAccessTokens() {
    return resources(OAuthAccessToken.class, OAuthAccessTokenList.class);
  }

  @Override
  public NonNamespaceOperation<OAuthAuthorizeToken, OAuthAuthorizeTokenList, Resource<OAuthAuthorizeToken>> oAuthAuthorizeTokens() {
    return resources(OAuthAuthorizeToken.class, OAuthAuthorizeTokenList.class);
  }

  @Override
  public NonNamespaceOperation<OAuthClient, OAuthClientList, Resource<OAuthClient>> oAuthClients() {
    return resources(OAuthClient.class, OAuthClientList.class);
  }

  @Override
  public NamespacedInOutCreateable<PodSecurityPolicyReview, PodSecurityPolicyReview> podSecurityPolicyReviews() {
    return OpenShiftHandlers.getCreateOnlyResourceOperation(PodSecurityPolicyReview.class, PodSecurityPolicyReview.class, this);
  }

  @Override
  public NonNamespaceOperation<OAuthClientAuthorization, OAuthClientAuthorizationList, Resource<OAuthClientAuthorization>> oAuthClientAuthorizations() {
    return resources(OAuthClientAuthorization.class, OAuthClientAuthorizationList.class);
  }

  @Override
  public MixedOperation<OperatorPKI, OperatorPKIList, Resource<OperatorPKI>> operatorPKIs() {
    return resources(OperatorPKI.class, OperatorPKIList.class);
  }

  @Override
  public MixedOperation<EgressRouter, EgressRouterList, Resource<EgressRouter>> egressRouters() {
    return resources(EgressRouter.class, EgressRouterList.class);
  }

  @Override
  public NamespacedInOutCreateable<PodSecurityPolicySelfSubjectReview, PodSecurityPolicySelfSubjectReview> podSecurityPolicySelfSubjectReviews() {
    return OpenShiftHandlers.getCreateOnlyResourceOperation(PodSecurityPolicySelfSubjectReview.class,
        PodSecurityPolicySelfSubjectReview.class, this);
  }

  @Override
  public NamespacedInOutCreateable<PodSecurityPolicySubjectReview, PodSecurityPolicySubjectReview> podSecurityPolicySubjectReviews() {
    return OpenShiftHandlers.getCreateOnlyResourceOperation(PodSecurityPolicySubjectReview.class,
        PodSecurityPolicySubjectReview.class, this);
  }

  @Override
  public ProjectOperation projects() {
    return new ProjectOperationsImpl(this);
  }

  @Override
  public OpenShiftQuotaAPIGroupDSL quotas() {
    return adapt(OpenShiftQuotaAPIGroupClient.class);
  }

  @Override
  public NonNamespaceOperation<RangeAllocation, RangeAllocationList, Resource<RangeAllocation>> rangeAllocations() {
    return resources(RangeAllocation.class, RangeAllocationList.class);
  }

  @Override
  public NonNamespaceOperation<SecurityContextConstraints, SecurityContextConstraintsList, Resource<SecurityContextConstraints>> securityContextConstraints() {
    return resources(SecurityContextConstraints.class, SecurityContextConstraintsList.class);
  }

  @Override
  public ProjectRequestOperation projectrequests() {
    MixedOperation<ProjectRequest, KubernetesResourceList<ProjectRequest>, Resource<ProjectRequest>> op = resources(
        ProjectRequest.class, null);

    return item -> op.resource(item).create();
  }

  @Override
  public MixedOperation<Role, RoleList, Resource<Role>> roles() {
    return resources(Role.class, RoleList.class);
  }

  @Override
  public MixedOperation<RoleBinding, RoleBindingList, Resource<RoleBinding>> roleBindings() {
    return new RoleBindingOperationsImpl(this);
  }

  @Override
  public MixedOperation<Route, RouteList, Resource<Route>> routes() {
    return resources(Route.class, RouteList.class);
  }

  @Override
  public ParameterMixedOperation<Template, TemplateList, TemplateResource<Template, KubernetesList>> templates() {
    return new TemplateOperationsImpl(this);
  }

  @Override
  public MixedOperation<TemplateInstance, TemplateInstanceList, Resource<TemplateInstance>> templateInstances() {
    return resources(TemplateInstance.class, TemplateInstanceList.class);
  }

  @Override
  public OpenShiftTunedAPIGroupDSL tuned() {
    return adapt(OpenShiftTunedAPIGroupClient.class);
  }

  @Override
  public NonNamespaceOperation<BrokerTemplateInstance, BrokerTemplateInstanceList, Resource<BrokerTemplateInstance>> brokerTemplateInstances() {
    return resources(BrokerTemplateInstance.class, BrokerTemplateInstanceList.class);
  }

  @Override
  public MixedOperation<User, UserList, Resource<User>> users() {
    return resources(User.class, UserList.class);
  }

  @Override
  public MixedOperation<ClusterRoleBinding, ClusterRoleBindingList, Resource<ClusterRoleBinding>> clusterRoleBindings() {
    return resources(ClusterRoleBinding.class, ClusterRoleBindingList.class);
  }

  @Override
  public MixedOperation<RoleBindingRestriction, RoleBindingRestrictionList, Resource<RoleBindingRestriction>> roleBindingRestrictions() {
    return resources(RoleBindingRestriction.class, RoleBindingRestrictionList.class);
  }

  @Override
  public NamespacedOpenShiftClient inNamespace(String namespace) {
    return new DefaultOpenShiftClient(createInNamespaceConfig(namespace, false), this);
  }

  @Override
  protected Config configCopy() {
    return new OpenShiftConfigBuilder(getConfiguration()).build();
  }

  @Override
  public ExtensionsAPIGroupClient extensions() {
    return adapt(ExtensionsAPIGroupClient.class);
  }

  @SuppressWarnings("unchecked")
  @Override
  public VersionInfo getVersion() {
    for (Supplier<VersionInfo> supplier : new Supplier[] {
        this::getOpenShiftV3Version,
        this::getOpenShiftV4VersionInfo
    }) {
      try {
        final VersionInfo vi = supplier.get();
        if (vi != null) {
          return vi;
        }
      } catch (Exception ex) {
        // try next
      }
    }
    return super.getVersion();
  }

  @Override
  public VersionInfo getKubernetesVersion() {
    return super.getVersion();
  }

  @Override
  public VersionInfo getOpenShiftV3Version() {
    return getVersionInfo(OPENSHIFT_VERSION_ENDPOINT);
  }

  private VersionInfo getOpenShiftV4VersionInfo() {
    return resources(ClusterVersion.class).list().getItems().stream().findFirst().map(clusterVersion -> {
      String[] versionParts = clusterVersion.getStatus().getDesired().getVersion().split("\\.");
      VersionInfo.Builder versionInfoBuilder = new VersionInfo.Builder();
      if (versionParts.length > 2) {
        versionInfoBuilder.withMajor(versionParts[0]);
        versionInfoBuilder.withMinor(versionParts[1] + "." + versionParts[2]);
      }
      try {
        versionInfoBuilder.withBuildDate(clusterVersion.getMetadata().getCreationTimestamp());
      } catch (ParseException e) {
        return null;
      }
      return versionInfoBuilder.build();
    }).orElse(null);
  }

  @Override
  public String getOpenShiftV4Version() {
    return resources(ClusterVersion.class).list().getItems().stream().findFirst()
        .map(cv -> cv.getStatus().getDesired().getVersion()).orElse(null);
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
  public OpenShiftMonitoringAPIGroupDSL monitoring() {
    return adapt(OpenShiftMonitoringAPIGroupClient.class);
  }

  @Override
  public NonNamespaceOperation<NetNamespace, NetNamespaceList, Resource<NetNamespace>> netNamespaces() {
    return resources(NetNamespace.class, NetNamespaceList.class);
  }

  @Override
  public NonNamespaceOperation<ClusterNetwork, ClusterNetworkList, Resource<ClusterNetwork>> clusterNetworks() {
    return resources(ClusterNetwork.class, ClusterNetworkList.class);
  }

  @Override
  public MixedOperation<EgressNetworkPolicy, EgressNetworkPolicyList, Resource<EgressNetworkPolicy>> egressNetworkPolicies() {
    return resources(EgressNetworkPolicy.class, EgressNetworkPolicyList.class);
  }

  @Override
  public NonNamespaceOperation<HostSubnet, HostSubnetList, Resource<HostSubnet>> hostSubnets() {
    return resources(HostSubnet.class, HostSubnetList.class);
  }

  @Override
  public NonNamespaceOperation<APIRequestCount, APIRequestCountList, Resource<APIRequestCount>> apiRequestCounts() {
    return resources(APIRequestCount.class, APIRequestCountList.class);
  }

  @Override
  public MixedOperation<BareMetalHost, BareMetalHostList, Resource<BareMetalHost>> bareMetalHosts() {
    return resources(BareMetalHost.class, BareMetalHostList.class);
  }

  @Override
  public InOutCreateable<SubjectAccessReview, SubjectAccessReviewResponse> subjectAccessReviews() {
    return OpenShiftHandlers.getCreateOnlyResourceOperation(SubjectAccessReview.class, SubjectAccessReviewResponse.class, this);
  }

  @Override
  public InOutCreateable<ResourceAccessReview, ResourceAccessReviewResponse> resourceAccessReviews() {
    return OpenShiftHandlers.getCreateOnlyResourceOperation(ResourceAccessReview.class, ResourceAccessReviewResponse.class,
        this);
  }

  @Override
  public NamespacedInOutCreateable<LocalSubjectAccessReview, SubjectAccessReviewResponse> localSubjectAccessReviews() {
    return OpenShiftHandlers.getCreateOnlyResourceOperation(LocalSubjectAccessReview.class, SubjectAccessReviewResponse.class,
        this);
  }

  @Override
  public NamespacedInOutCreateable<LocalResourceAccessReview, ResourceAccessReviewResponse> localResourceAccessReviews() {
    return OpenShiftHandlers.getCreateOnlyResourceOperation(LocalResourceAccessReview.class, ResourceAccessReviewResponse.class,
        this);
  }

  @Override
  public NamespacedInOutCreateable<SelfSubjectRulesReview, SelfSubjectRulesReview> selfSubjectRulesReviews() {
    return OpenShiftHandlers.getCreateOnlyResourceOperation(SelfSubjectRulesReview.class, SelfSubjectRulesReview.class, this);
  }

  @Override
  public NamespacedInOutCreateable<SubjectRulesReview, SubjectRulesReview> subjectRulesReviews() {
    return OpenShiftHandlers.getCreateOnlyResourceOperation(SubjectRulesReview.class, SubjectRulesReview.class, this);
  }

  @Override
  public OpenShiftStorageVersionMigratorApiGroupDSL kubeStorageVersionMigrator() {
    return adapt(OpenShiftStorageVersionMigratorApiGroupClient.class);
  }

  @Override
  public NonNamespaceOperation<ClusterRole, ClusterRoleList, Resource<ClusterRole>> clusterRoles() {
    return resources(ClusterRole.class, ClusterRoleList.class);
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
    return resources(Identity.class, IdentityList.class);
  }

  @Override
  public InOutCreateable<UserIdentityMapping, UserIdentityMapping> userIdentityMappings() {
    return getHandlers().getNonListingOperation(UserIdentityMapping.class, this);
  }

  @Override
  public NonNamespaceOperation<UserOAuthAccessToken, UserOAuthAccessTokenList, Resource<UserOAuthAccessToken>> userOAuthAccessTokens() {
    return resources(UserOAuthAccessToken.class, UserOAuthAccessTokenList.class);
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
  protected void setDerivedFields() {
    OpenShiftConfig wrapped = OpenShiftConfig.wrap(config);
    this.config = wrapped;
    HttpClient.DerivedClientBuilder builder = httpClient.newBuilder().authenticatorNone();
    this.httpClient = builder
        .addOrReplaceInterceptor(TokenRefreshInterceptor.NAME, new OpenShiftOAuthInterceptor(httpClient, wrapped))
        .build();
    try {
      this.openShiftUrl = new URL(wrapped.getOpenShiftUrl());
    } catch (MalformedURLException e) {
      throw new KubernetesClientException("Could not create client", e);
    }
    super.setDerivedFields();
  }

  @Override
  public NamespacedOpenShiftClient inAnyNamespace() {
    return new DefaultOpenShiftClient(createInNamespaceConfig(null, true), this);
  }

  /**
   * Checks if a custom URL for OpenShift has been used.
   *
   * @param config The openshift configuration.
   * @return True if both master and openshift url have the same root.
   */
  static boolean hasCustomOpenShiftUrl(OpenShiftConfig config) {
    try {
      URI masterUri = new URI(config.getMasterUrl()).resolve("/");
      URI openshfitUri = new URI(config.getOpenShiftUrl()).resolve("/");
      return !masterUri.equals(openshfitUri);
    } catch (Exception e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  @Override
  public boolean isSupported() {
    OpenShiftConfig oConfig = getConfiguration();
    return hasCustomOpenShiftUrl(oConfig)
        || oConfig.isDisableApiGroupCheck()
        || hasApiGroup(BASE_API_GROUP, false);
  }

  @Override
  protected DefaultOpenShiftClient newInstance(Config config) {
    return new DefaultOpenShiftClient(config, this);
  }

}
