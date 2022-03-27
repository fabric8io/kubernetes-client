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

package io.fabric8.openshift.client.osgi;

import io.fabric8.kubernetes.api.model.ComponentStatus;
import io.fabric8.kubernetes.api.model.ComponentStatusList;
import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.RequestConfig;
import io.fabric8.kubernetes.client.VersionInfo;
import io.fabric8.kubernetes.client.dsl.FunctionCallable;
import io.fabric8.kubernetes.client.dsl.Gettable;
import io.fabric8.kubernetes.client.dsl.InOutCreateable;
import io.fabric8.kubernetes.client.dsl.LogWatch;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Nameable;
import io.fabric8.kubernetes.client.dsl.Namespaceable;
import io.fabric8.kubernetes.client.dsl.NamespacedInOutCreateable;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.ParameterMixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.osgi.NamespacedKubernetesClientAdapter;
import io.fabric8.kubernetes.client.utils.URLUtils;
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
import io.fabric8.openshift.client.NamespacedOpenShiftClient;
import io.fabric8.openshift.client.OpenShiftClient;
import io.fabric8.openshift.client.OpenShiftConfigBuilder;
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
import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.ConfigurationPolicy;
import org.apache.felix.scr.annotations.Deactivate;
import org.apache.felix.scr.annotations.Service;

import java.net.URL;
import java.util.Map;

import static io.fabric8.kubernetes.client.Config.KUBERNETES_API_VERSION_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_AUTH_BASIC_PASSWORD_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_AUTH_BASIC_USERNAME_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_CA_CERTIFICATE_DATA_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_CA_CERTIFICATE_FILE_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_CLIENT_CERTIFICATE_DATA_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_CLIENT_CERTIFICATE_FILE_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_CLIENT_KEY_ALGO_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_CLIENT_KEY_DATA_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_CLIENT_KEY_FILE_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_CLIENT_KEY_PASSPHRASE_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_HTTPS_PROXY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_HTTP_PROXY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_MASTER_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_NAMESPACE_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_NO_PROXY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_OAUTH_TOKEN_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_REQUEST_TIMEOUT_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_WATCH_RECONNECT_INTERVAL_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_WATCH_RECONNECT_LIMIT_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_WEBSOCKET_PING_INTERVAL_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_WEBSOCKET_TIMEOUT_SYSTEM_PROPERTY;
import static io.fabric8.openshift.client.OpenShiftConfig.DEFAULT_BUILD_TIMEOUT;
import static io.fabric8.openshift.client.OpenShiftConfig.OPENSHIFT_BUILD_TIMEOUT_SYSTEM_PROPERTY;
import static io.fabric8.openshift.client.OpenShiftConfig.OPENSHIFT_URL_SYSTEM_PROPERTY;

@Component(immediate = true, configurationPid = "io.fabric8.openshift.client", policy = ConfigurationPolicy.OPTIONAL)
@Service({ OpenShiftClient.class, NamespacedOpenShiftClient.class })
public class ManagedOpenShiftClient extends NamespacedKubernetesClientAdapter<NamespacedOpenShiftClient>
    implements NamespacedOpenShiftClient {

  public ManagedOpenShiftClient() {
    super(NamespacedOpenShiftClient.class);
  }

  @Activate
  public void activate(Map<String, Object> properties) {
    final OpenShiftConfigBuilder builder = new OpenShiftConfigBuilder();

    if (properties.containsKey(KUBERNETES_MASTER_SYSTEM_PROPERTY)) {
      builder.withMasterUrl((String) properties.get(KUBERNETES_MASTER_SYSTEM_PROPERTY));
    }
    if (properties.containsKey(KUBERNETES_API_VERSION_SYSTEM_PROPERTY)) {
      builder.withApiVersion((String) properties.get(KUBERNETES_API_VERSION_SYSTEM_PROPERTY));
    }
    if (properties.containsKey(KUBERNETES_NAMESPACE_SYSTEM_PROPERTY)) {
      builder.withNamespace((String) properties.get(KUBERNETES_NAMESPACE_SYSTEM_PROPERTY));
    }
    if (properties.containsKey(KUBERNETES_CA_CERTIFICATE_FILE_SYSTEM_PROPERTY)) {
      builder.withCaCertFile((String) properties.get(KUBERNETES_CA_CERTIFICATE_FILE_SYSTEM_PROPERTY));
    }
    if (properties.containsKey(KUBERNETES_CA_CERTIFICATE_DATA_SYSTEM_PROPERTY)) {
      builder.withCaCertData((String) properties.get(KUBERNETES_CA_CERTIFICATE_DATA_SYSTEM_PROPERTY));
    }
    if (properties.containsKey(KUBERNETES_CLIENT_CERTIFICATE_FILE_SYSTEM_PROPERTY)) {
      builder.withClientCertFile((String) properties.get(KUBERNETES_CLIENT_CERTIFICATE_FILE_SYSTEM_PROPERTY));
    }
    if (properties.containsKey(KUBERNETES_CLIENT_CERTIFICATE_DATA_SYSTEM_PROPERTY)) {
      builder.withClientCertData((String) properties.get(KUBERNETES_CLIENT_CERTIFICATE_DATA_SYSTEM_PROPERTY));
    }
    if (properties.containsKey(KUBERNETES_CLIENT_KEY_FILE_SYSTEM_PROPERTY)) {
      builder.withClientKeyFile((String) properties.get(KUBERNETES_CLIENT_KEY_FILE_SYSTEM_PROPERTY));
    }
    if (properties.containsKey(KUBERNETES_CLIENT_KEY_DATA_SYSTEM_PROPERTY)) {
      builder.withClientKeyData((String) properties.get(KUBERNETES_CLIENT_KEY_DATA_SYSTEM_PROPERTY));
    }
    if (properties.containsKey(KUBERNETES_CLIENT_KEY_ALGO_SYSTEM_PROPERTY)) {
      builder.withClientKeyAlgo((String) properties.get(KUBERNETES_CLIENT_KEY_ALGO_SYSTEM_PROPERTY));
    }
    if (properties.containsKey(KUBERNETES_CLIENT_KEY_PASSPHRASE_SYSTEM_PROPERTY)) {
      builder.withClientKeyPassphrase((String) properties.get(KUBERNETES_CLIENT_KEY_PASSPHRASE_SYSTEM_PROPERTY));
    }
    if (properties.containsKey(KUBERNETES_AUTH_BASIC_USERNAME_SYSTEM_PROPERTY)) {
      builder.withUsername((String) properties.get(KUBERNETES_AUTH_BASIC_USERNAME_SYSTEM_PROPERTY));
    }
    if (properties.containsKey(KUBERNETES_AUTH_BASIC_PASSWORD_SYSTEM_PROPERTY)) {
      builder.withPassword((String) properties.get(KUBERNETES_AUTH_BASIC_PASSWORD_SYSTEM_PROPERTY));
    }
    if (properties.containsKey(KUBERNETES_OAUTH_TOKEN_SYSTEM_PROPERTY)) {
      builder.withOauthToken((String) properties.get(KUBERNETES_OAUTH_TOKEN_SYSTEM_PROPERTY));
    }
    if (properties.containsKey(KUBERNETES_WATCH_RECONNECT_INTERVAL_SYSTEM_PROPERTY)) {
      builder.withWatchReconnectInterval(
          Integer.parseInt((String) properties.get(KUBERNETES_WATCH_RECONNECT_INTERVAL_SYSTEM_PROPERTY)));
    }
    if (properties.containsKey(KUBERNETES_WATCH_RECONNECT_LIMIT_SYSTEM_PROPERTY)) {
      builder
          .withWatchReconnectLimit(Integer.parseInt((String) properties.get(KUBERNETES_WATCH_RECONNECT_LIMIT_SYSTEM_PROPERTY)));
    }
    if (properties.containsKey(KUBERNETES_REQUEST_TIMEOUT_SYSTEM_PROPERTY)) {
      builder.withRequestTimeout(Integer.parseInt((String) properties.get(KUBERNETES_REQUEST_TIMEOUT_SYSTEM_PROPERTY)));
    }
    if (properties.containsKey(KUBERNETES_HTTP_PROXY)) {
      builder.withHttpProxy((String) properties.get(KUBERNETES_HTTP_PROXY));
    }
    if (properties.containsKey(KUBERNETES_HTTPS_PROXY)) {
      builder.withHttpsProxy((String) properties.get(KUBERNETES_HTTPS_PROXY));
    }
    if (properties.containsKey(KUBERNETES_NO_PROXY)) {
      String noProxyProperty = (String) properties.get(KUBERNETES_NO_PROXY);
      builder.withNoProxy(noProxyProperty.split(","));
    }
    if (properties.containsKey(OPENSHIFT_URL_SYSTEM_PROPERTY)) {
      builder.withOpenShiftUrl((String) properties.get(OPENSHIFT_URL_SYSTEM_PROPERTY));
    } else {
      builder.withOpenShiftUrl(URLUtils.join(builder.getMasterUrl(), "oapi", builder.getOapiVersion()));
    }
    if (properties.containsKey(OPENSHIFT_BUILD_TIMEOUT_SYSTEM_PROPERTY)) {
      builder.withBuildTimeout(Integer.parseInt((String) properties.get(OPENSHIFT_BUILD_TIMEOUT_SYSTEM_PROPERTY)));
    } else {
      builder.withBuildTimeout(DEFAULT_BUILD_TIMEOUT);
    }
    if (properties.containsKey(KUBERNETES_WEBSOCKET_TIMEOUT_SYSTEM_PROPERTY)) {
      builder.withWebsocketTimeout(Long.parseLong((String) properties.get(KUBERNETES_WEBSOCKET_TIMEOUT_SYSTEM_PROPERTY)));
    }
    if (properties.containsKey(KUBERNETES_WEBSOCKET_PING_INTERVAL_SYSTEM_PROPERTY)) {
      builder.withWebsocketPingInterval(
          Long.parseLong((String) properties.get(KUBERNETES_WEBSOCKET_PING_INTERVAL_SYSTEM_PROPERTY)));
    }

    NamespacedOpenShiftClient delegate = new KubernetesClientBuilder().withConfig(builder.build()).build()
        .adapt(NamespacedOpenShiftClient.class);
    this.init(delegate);
  }

  @Deactivate
  public void deactivate() {
    getClient().close();
  }

  @Override
  public URL getOpenshiftUrl() {
    return getClient().getOpenshiftUrl();
  }

  @Override
  public OpenShiftConfigAPIGroupDSL config() {
    return getClient().config();
  }

  @Override
  public OpenShiftConsoleAPIGroupDSL console() {
    return getClient().console();
  }

  @Override
  public OpenShiftClusterAutoscalingAPIGroupDSL clusterAutoscaling() {
    return getClient().clusterAutoscaling();
  }

  @Override
  public OpenShiftHiveAPIGroupDSL hive() {
    return getClient().hive();
  }

  @Override
  public OpenShiftOperatorAPIGroupDSL operator() {
    return getClient().operator();
  }

  @Override
  public OpenShiftOperatorHubAPIGroupDSL operatorHub() {
    return getClient().operatorHub();
  }

  @Override
  public MixedOperation<Build, BuildList, BuildResource<Build, LogWatch>> builds() {
    return getClient().builds();
  }

  @Override
  public NonNamespaceOperation<ComponentStatus, ComponentStatusList, Resource<ComponentStatus>> componentstatuses() {
    return getClient().componentstatuses();
  }

  @Override
  public MixedOperation<BuildConfig, BuildConfigList, BuildConfigResource<BuildConfig, Void, Build>> buildConfigs() {
    return getClient().buildConfigs();
  }

  @Override
  public MixedOperation<CredentialsRequest, CredentialsRequestList, Resource<CredentialsRequest>> credentialsRequests() {
    return getClient().credentialsRequests();
  }

  @Override
  public MixedOperation<DeploymentConfig, DeploymentConfigList, DeployableScalableResource<DeploymentConfig>> deploymentConfigs() {
    return getClient().deploymentConfigs();
  }

  @Override
  public NonNamespaceOperation<Group, GroupList, Resource<Group>> groups() {
    return getClient().groups();
  }

  @Override
  public NonNamespaceOperation<HelmChartRepository, HelmChartRepositoryList, Resource<HelmChartRepository>> helmChartRepositories() {
    return getClient().helmChartRepositories();
  }

  @Override
  public NonNamespaceOperation<Image, ImageList, Resource<Image>> images() {
    return getClient().images();
  }

  @Override
  public MixedOperation<ImageTag, ImageTagList, Resource<ImageTag>> imageTags() {
    return getClient().imageTags();
  }

  @Override
  public MixedOperation<ImageStream, ImageStreamList, Resource<ImageStream>> imageStreams() {
    return getClient().imageStreams();
  }

  @Override
  public MixedOperation<ImageStreamTag, ImageStreamTagList, Resource<ImageStreamTag>> imageStreamTags() {
    return getClient().imageStreamTags();
  }

  @Override
  public NamespacedInOutCreateable<ImageStreamImport, ImageStreamImport> imageStreamImports() {
    return getClient().imageStreamImports();
  }

  @Override
  public NamespacedInOutCreateable<ImageStreamMapping, ImageStreamMapping> imageStreamMappings() {
    return getClient().imageStreamMappings();
  }

  @Override
  public Namespaceable<Nameable<? extends Gettable<ImageStreamImage>>> imageStreamImages() {
    return getClient().imageStreamImages();
  }

  @Override
  public NameableCreateOrDeleteable imageSignatures() {
    return getClient().imageSignatures();
  }

  @Override
  public NonNamespaceOperation<io.fabric8.openshift.api.model.miscellaneous.imageregistry.operator.v1.Config, ConfigList, Resource<io.fabric8.openshift.api.model.miscellaneous.imageregistry.operator.v1.Config>> imageRegistryOperatorConfigs() {
    return getClient().imageRegistryOperatorConfigs();
  }

  @Override
  public MixedOperation<NetworkAttachmentDefinition, NetworkAttachmentDefinitionList, Resource<NetworkAttachmentDefinition>> networkAttachmentDefinitions() {
    return getClient().networkAttachmentDefinitions();
  }

  @Override
  public NonNamespaceOperation<OAuthAccessToken, OAuthAccessTokenList, Resource<OAuthAccessToken>> oAuthAccessTokens() {
    return getClient().oAuthAccessTokens();
  }

  @Override
  public NonNamespaceOperation<OAuthAuthorizeToken, OAuthAuthorizeTokenList, Resource<OAuthAuthorizeToken>> oAuthAuthorizeTokens() {
    return getClient().oAuthAuthorizeTokens();
  }

  @Override
  public NonNamespaceOperation<OAuthClient, OAuthClientList, Resource<OAuthClient>> oAuthClients() {
    return getClient().oAuthClients();
  }

  @Override
  public NamespacedInOutCreateable<PodSecurityPolicyReview, PodSecurityPolicyReview> podSecurityPolicyReviews() {
    return getClient().podSecurityPolicyReviews();
  }

  @Override
  public NonNamespaceOperation<OAuthClientAuthorization, OAuthClientAuthorizationList, Resource<OAuthClientAuthorization>> oAuthClientAuthorizations() {
    return getClient().oAuthClientAuthorizations();
  }

  @Override
  public MixedOperation<OperatorPKI, OperatorPKIList, Resource<OperatorPKI>> operatorPKIs() {
    return getClient().operatorPKIs();
  }

  @Override
  public MixedOperation<EgressRouter, EgressRouterList, Resource<EgressRouter>> egressRouters() {
    return getClient().egressRouters();
  }

  @Override
  public NamespacedInOutCreateable<PodSecurityPolicySelfSubjectReview, PodSecurityPolicySelfSubjectReview> podSecurityPolicySelfSubjectReviews() {
    return getClient().podSecurityPolicySelfSubjectReviews();
  }

  @Override
  public NamespacedInOutCreateable<PodSecurityPolicySubjectReview, PodSecurityPolicySubjectReview> podSecurityPolicySubjectReviews() {
    return getClient().podSecurityPolicySubjectReviews();
  }

  @Override
  public OpenShiftQuotaAPIGroupDSL quotas() {
    return getClient().quotas();
  }

  @Override
  public ProjectOperation projects() {
    return getClient().projects();
  }

  @Override
  public ProjectRequestOperation projectrequests() {
    return getClient().projectrequests();
  }

  @Override
  public MixedOperation<Role, RoleList, Resource<Role>> roles() {
    return getClient().roles();
  }

  @Override
  public MixedOperation<RoleBinding, RoleBindingList, Resource<RoleBinding>> roleBindings() {
    return getClient().roleBindings();
  }

  @Override
  public MixedOperation<Route, RouteList, Resource<Route>> routes() {
    return getClient().routes();
  }

  @Override
  public ParameterMixedOperation<Template, TemplateList, TemplateResource<Template, KubernetesList>> templates() {
    return getClient().templates();
  }

  @Override
  public MixedOperation<TemplateInstance, TemplateInstanceList, Resource<TemplateInstance>> templateInstances() {
    return getClient().templateInstances();
  }

  @Override
  public OpenShiftTunedAPIGroupDSL tuned() {
    return getClient().tuned();
  }

  @Override
  public NonNamespaceOperation<BrokerTemplateInstance, BrokerTemplateInstanceList, Resource<BrokerTemplateInstance>> brokerTemplateInstances() {
    return getClient().brokerTemplateInstances();
  }

  @Override
  public NonNamespaceOperation<User, UserList, Resource<User>> users() {
    return getClient().users();
  }

  @Override
  public MixedOperation<ClusterRoleBinding, ClusterRoleBindingList, Resource<ClusterRoleBinding>> clusterRoleBindings() {
    return getClient().clusterRoleBindings();
  }

  @Override
  public MixedOperation<RoleBindingRestriction, RoleBindingRestrictionList, Resource<RoleBindingRestriction>> roleBindingRestrictions() {
    return getClient().roleBindingRestrictions();
  }

  @Override
  public VersionInfo getOpenShiftV3Version() {
    return getClient().getOpenShiftV3Version();
  }

  @Override
  public String getOpenShiftV4Version() {
    return getClient().getOpenShiftV4Version();
  }

  @Override
  public MachineConfigurationAPIGroupDSL machineConfigurations() {
    return getClient().machineConfigurations();
  }

  @Override
  public OpenShiftMachineAPIGroupDSL machine() {
    return getClient().machine();
  }

  @Override
  public OpenShiftMonitoringAPIGroupDSL monitoring() {
    return getClient().monitoring();
  }

  @Override
  public NonNamespaceOperation<NetNamespace, NetNamespaceList, Resource<NetNamespace>> netNamespaces() {
    return getClient().netNamespaces();
  }

  @Override
  public NonNamespaceOperation<ClusterNetwork, ClusterNetworkList, Resource<ClusterNetwork>> clusterNetworks() {
    return getClient().clusterNetworks();
  }

  @Override
  public MixedOperation<EgressNetworkPolicy, EgressNetworkPolicyList, Resource<EgressNetworkPolicy>> egressNetworkPolicies() {
    return getClient().egressNetworkPolicies();
  }

  @Override
  public NonNamespaceOperation<HostSubnet, HostSubnetList, Resource<HostSubnet>> hostSubnets() {
    return getClient().hostSubnets();
  }

  @Override
  public NonNamespaceOperation<APIRequestCount, APIRequestCountList, Resource<APIRequestCount>> apiRequestCounts() {
    return getClient().apiRequestCounts();
  }

  @Override
  public MixedOperation<BareMetalHost, BareMetalHostList, Resource<BareMetalHost>> bareMetalHosts() {
    return getClient().bareMetalHosts();
  }

  @Override
  public InOutCreateable<SubjectAccessReview, SubjectAccessReviewResponse> subjectAccessReviews() {
    return getClient().subjectAccessReviews();
  }

  @Override
  public InOutCreateable<ResourceAccessReview, ResourceAccessReviewResponse> resourceAccessReviews() {
    return getClient().resourceAccessReviews();
  }

  @Override
  public NamespacedInOutCreateable<LocalSubjectAccessReview, SubjectAccessReviewResponse> localSubjectAccessReviews() {
    return getClient().localSubjectAccessReviews();
  }

  @Override
  public NamespacedInOutCreateable<LocalResourceAccessReview, ResourceAccessReviewResponse> localResourceAccessReviews() {
    return getClient().localResourceAccessReviews();
  }

  @Override
  public NamespacedInOutCreateable<SelfSubjectRulesReview, SelfSubjectRulesReview> selfSubjectRulesReviews() {
    return getClient().selfSubjectRulesReviews();
  }

  @Override
  public NamespacedInOutCreateable<SubjectRulesReview, SubjectRulesReview> subjectRulesReviews() {
    return getClient().subjectRulesReviews();
  }

  @Override
  public OpenShiftStorageVersionMigratorApiGroupDSL kubeStorageVersionMigrator() {
    return getClient().kubeStorageVersionMigrator();
  }

  @Override
  public NonNamespaceOperation<ClusterRole, ClusterRoleList, Resource<ClusterRole>> clusterRoles() {
    return getClient().clusterRoles();
  }

  @Override
  public FunctionCallable<NamespacedOpenShiftClient> withRequestConfig(RequestConfig requestConfig) {
    return getClient().withRequestConfig(requestConfig);
  }

  @Override
  public User currentUser() {
    return getClient().currentUser();
  }

  @Override
  public NonNamespaceOperation<Identity, IdentityList, Resource<Identity>> identities() {
    return getClient().identities();
  }

  @Override
  public InOutCreateable<UserIdentityMapping, UserIdentityMapping> userIdentityMappings() {
    return null;
  }

  @Override
  public OpenShiftWhereaboutsAPIGroupDSL whereabouts() {
    return getClient().whereabouts();
  }

  @Override
  public boolean supportsOpenShiftAPIGroup(String apiGroup) {
    return getClient().supportsOpenShiftAPIGroup(apiGroup);
  }

  @Override
  public NonNamespaceOperation<RangeAllocation, RangeAllocationList, Resource<RangeAllocation>> rangeAllocations() {
    return getClient().rangeAllocations();
  }

  @Override
  public NonNamespaceOperation<SecurityContextConstraints, SecurityContextConstraintsList, Resource<SecurityContextConstraints>> securityContextConstraints() {
    return getClient().securityContextConstraints();
  }

  @Override
  public NonNamespaceOperation<UserOAuthAccessToken, UserOAuthAccessTokenList, Resource<UserOAuthAccessToken>> userOAuthAccessTokens() {
    return getClient().userOAuthAccessTokens();
  }

  @Override
  public boolean isSupported() {
    return getClient().isSupported();
  }

  @Override
  public ManagedOpenShiftClient newInstance() {
    return new ManagedOpenShiftClient();
  }

  @Override
  public ManagedOpenShiftClient inAnyNamespace() {
    ManagedOpenShiftClient result = newInstance();
    result.init(getClient().inAnyNamespace());
    return result;
  }

  @Override
  public ManagedOpenShiftClient inNamespace(String namespace) {
    ManagedOpenShiftClient result = newInstance();
    result.init(getClient().inNamespace(namespace));
    return result;
  }

}
