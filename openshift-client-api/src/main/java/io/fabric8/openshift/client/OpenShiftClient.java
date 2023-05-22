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

import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.RequestConfig;
import io.fabric8.kubernetes.client.VersionInfo;
import io.fabric8.kubernetes.client.dsl.AppsAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.AutoscalingAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.BatchAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.ExtensionsAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.FunctionCallable;
import io.fabric8.kubernetes.client.dsl.Gettable;
import io.fabric8.kubernetes.client.dsl.InOutCreateable;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Nameable;
import io.fabric8.kubernetes.client.dsl.Namespaceable;
import io.fabric8.kubernetes.client.dsl.NamespacedInOutCreateable;
import io.fabric8.kubernetes.client.dsl.NetworkAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.ParameterMixedOperation;
import io.fabric8.kubernetes.client.dsl.RbacAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.SchedulingAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.StorageAPIGroupDSL;
import io.fabric8.kubernetes.client.extension.SupportTestingClient;
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

import java.net.URL;

public interface OpenShiftClient extends KubernetesClient, SupportTestingClient {

  public static final String BASE_API_GROUP = "openshift.io";

  /**
   * Get Url of the cluster
   *
   * @return {@link java.net.URL} of OpenShift Cluster
   */
  URL getOpenshiftUrl();

  /**
   * API entrypoint for accessing OpenShift config APIGroup resources(config.openshift.io/v1)
   *
   * @return {@link OpenShiftConfigAPIGroupDSL} which contains respective resources in this API group
   */
  OpenShiftConfigAPIGroupDSL config();

  /**
   * API entrypoint for accessing OpenShift console APIGroup resources(console.openshift.io/v1)
   *
   * @return {@link OpenShiftConsoleAPIGroupDSL} which contains respective resources in this API group
   */
  OpenShiftConsoleAPIGroupDSL console();

  /**
   * API entrypoint for accessing OpenShift Cluster Operator resources (autoscaling.openshift.io)
   *
   * @return {@link OpenShiftClusterAutoscalingAPIGroupDSL} which contains respective resources in this API group
   */
  OpenShiftClusterAutoscalingAPIGroupDSL clusterAutoscaling();

  /**
   * API entrypoint for accessing OpenShift Hive Operator resources (hive.openshift.io)
   *
   * @return {@link OpenShiftHiveAPIGroupDSL} which contains respective resources in this API group
   */
  OpenShiftHiveAPIGroupDSL hive();

  /**
   * API entrypoint for accessing OpenShift operator APIGroup resources(operator.openshift.io/v1 and
   * operator.openshift.io/v1alpha1)
   *
   * @return {@link OpenShiftOperatorAPIGroupDSL} which contains respective resources in this API group
   */
  OpenShiftOperatorAPIGroupDSL operator();

  /**
   * API entrypoint for accessing OpenShift operator hub APIGroup resources(operator.coreos.com/v1alpha1)
   *
   * @return {@link OpenShiftOperatorHubAPIGroupDSL} which contains respective resources in this API group
   */
  OpenShiftOperatorHubAPIGroupDSL operatorHub();

  /**
   * {@inheritDoc}
   */
  @Override
  ExtensionsAPIGroupDSL extensions();

  /**
   * {@inheritDoc}
   */
  @Override
  VersionInfo getVersion();

  /**
   * Get OpenShift version information from version/openshift
   *
   * @return VersionInfo object containing versioning information
   */
  VersionInfo getOpenShiftV3Version();

  /**
   * Get OpenShift server version
   * <br>
   * for more information use resources(ClusterVersion.class).list()
   *
   * @return version String
   */
  String getOpenShiftV4Version();

  /**
   * {@inheritDoc}
   */
  @Override
  AppsAPIGroupDSL apps();

  /**
   * {@inheritDoc}
   */
  @Override
  AutoscalingAPIGroupDSL autoscaling();

  /**
   * API entrypoint for accessing OpenShift Machine Config Operator resources (machineconfiguration.openshift.io)
   *
   * @return {@link MachineConfigurationAPIGroupDSL} which contains respective resources in this ApiGroup
   */
  MachineConfigurationAPIGroupDSL machineConfigurations();

  /*
   * API entrypoint for accessing OpenShift Machine APIGroup resources(machine.openshift.io/v1beta1)
   *
   * @return {@link OpenShiftMachineAPIGroupDSL} which contains respective resources in this API group
   */
  OpenShiftMachineAPIGroupDSL machine();

  /**
   * API entrypoint for accessing OpenShift operator APIGroup resources(monitoring.coreos.com/v1)
   *
   * @return {@link OpenShiftMonitoringAPIGroupDSL} which contains respective resources in this API group
   */
  OpenShiftMonitoringAPIGroupDSL monitoring();

  /**
   * API entrypoint for handling NetNamespace(network.openshift.io/v1)
   *
   * @return NonNamespaceOperation instance for NetNamespace object
   */
  NonNamespaceOperation<NetNamespace, NetNamespaceList, Resource<NetNamespace>> netNamespaces();

  /**
   * API entrypoint for handling ClusterNetwork(network.openshift.io/v1)
   *
   * @return NonNamespaceOperation instance for ClusterNetwork object
   */
  NonNamespaceOperation<ClusterNetwork, ClusterNetworkList, Resource<ClusterNetwork>> clusterNetworks();

  /**
   * API entrypoint for handling EgressNetworkPolicy(network.openshift.io/v1)
   *
   * @return MixedOperation instance for EgressNetworkPolicy object
   */
  MixedOperation<EgressNetworkPolicy, EgressNetworkPolicyList, Resource<EgressNetworkPolicy>> egressNetworkPolicies();

  /**
   * API entrypoint for HostSubnet (network.openshift.io/v1)
   *
   * @return {@link NonNamespaceOperation} for HostSubnet
   */
  NonNamespaceOperation<HostSubnet, HostSubnetList, Resource<HostSubnet>> hostSubnets();

  /**
   * {@inheritDoc}
   */
  @Override
  NetworkAPIGroupDSL network();

  /**
   * {@inheritDoc}
   */
  @Override
  StorageAPIGroupDSL storage();

  /**
   * {@inheritDoc}
   */
  @Override
  BatchAPIGroupDSL batch();

  /**
   * {@inheritDoc}
   */
  @Override
  RbacAPIGroupDSL rbac();

  /**
   * {@inheritDoc}
   */
  @Override
  SchedulingAPIGroupDSL scheduling();

  /**
   * API entrypoint for APIRequestCount (apiserver.openshift.io/v1)
   *
   * @return {@link NonNamespaceOperation} for APIRequestCoutn
   */
  NonNamespaceOperation<APIRequestCount, APIRequestCountList, Resource<APIRequestCount>> apiRequestCounts();

  /**
   * API entrypoint for BareMetalHost(metal3.io/v1alpha1)
   *
   * @return {@link MixedOperation} for BareMetalHost
   */
  MixedOperation<BareMetalHost, BareMetalHostList, Resource<BareMetalHost>> bareMetalHosts();

  /**
   * API entrypoint for handling Build(build.openshift.io/v1)
   *
   * @return MixedOperation instance for Build object
   */
  MixedOperation<Build, BuildList, BuildResource> builds();

  /**
   * API entrypoint for handling BuildConfig(build.openshift.io/v1)
   *
   * @return MixedOperation instance for BuildConfig object
   */
  MixedOperation<BuildConfig, BuildConfigList, BuildConfigResource<BuildConfig, Void, Build>> buildConfigs();

  /**
   * API entrypoint for CredentialsRequest (cloudcredential.openshift.io/v1)
   *
   * @return {@link MixedOperation} for CredentialsRequest
   */
  MixedOperation<CredentialsRequest, CredentialsRequestList, Resource<CredentialsRequest>> credentialsRequests();

  /**
   * API entrypoint for handling DeploymentConfig(apps.openshift.io/v1)
   *
   * @return MixedOperation instance for DeploymentConfig object
   */
  MixedOperation<DeploymentConfig, DeploymentConfigList, DeployableScalableResource<DeploymentConfig>> deploymentConfigs();

  /**
   * API entrypoint for handling Group(user.openshift.io/v1)
   *
   * @return NonNamespaceOperation instance for Group object
   */
  NonNamespaceOperation<Group, GroupList, Resource<Group>> groups();

  /**
   * API entrypoint for handling HelmChartRepository(helm.openshift.io/v1beta1)
   *
   * @return {@link NonNamespaceOperation} for HelmChartRepository
   */
  NonNamespaceOperation<HelmChartRepository, HelmChartRepositoryList, Resource<HelmChartRepository>> helmChartRepositories();

  /**
   * API entrypoint for accessing Image(image.openshift.io/v1)
   *
   * @return Non Namespace Operation object for Image
   */
  NonNamespaceOperation<Image, ImageList, Resource<Image>> images();

  /**
   * API entrypoint for accessing ImageTag(image.openshift.io/v1)
   *
   * @return MixedOperation object for ImageTag
   */
  MixedOperation<ImageTag, ImageTagList, Resource<ImageTag>> imageTags();

  /**
   * API entrypoint for accessing ImageStream(image.openshift.io/v1)
   *
   * @return MixedOperation object for ImageStream
   */
  MixedOperation<ImageStream, ImageStreamList, Resource<ImageStream>> imageStreams();

  /**
   * API entrypoint for accessing ImageStreamTag(image.openshift.io/v1)
   *
   * @return MixedOperation object for ImageStreamTag
   */
  MixedOperation<ImageStreamTag, ImageStreamTagList, Resource<ImageStreamTag>> imageStreamTags();

  /**
   * API entrypoint for accessing ImageStreamImport(image.openshift.io/v1)
   *
   * @return {@link NamespacedInOutCreateable} for ImageStreamImport
   */
  NamespacedInOutCreateable<ImageStreamImport, ImageStreamImport> imageStreamImports();

  /**
   * API entrypoint for accessing ImageStreamMapping(image.openshift.io/v1)
   *
   * @return {@link NamespacedInOutCreateable} for ImageStreamMapping
   */
  NamespacedInOutCreateable<ImageStreamMapping, ImageStreamMapping> imageStreamMappings();

  /**
   * API entrypoint for accessing ImageStreamImage(image.openshift.io/v1)
   *
   * @return {@link Namespaceable} for ImageStreamImage operations
   */
  Namespaceable<Nameable<? extends Gettable<ImageStreamImage>>> imageStreamImages();

  /**
   * API entrypoint for accessing ImageSignature(image.openshift.io/v1)
   *
   * @return {@link NameableCreateOrDeleteable} for ImageSignature operations
   */
  NameableCreateOrDeleteable imageSignatures();

  /**
   * API entrypoint for Config(imageregistry.operator.openshift.io/v1)
   *
   * @return {@link NonNamespaceOperation} for Config
   */
  NonNamespaceOperation<io.fabric8.openshift.api.model.miscellaneous.imageregistry.operator.v1.Config, io.fabric8.openshift.api.model.miscellaneous.imageregistry.operator.v1.ConfigList, Resource<io.fabric8.openshift.api.model.miscellaneous.imageregistry.operator.v1.Config>> imageRegistryOperatorConfigs();

  /**
   * API entrypoint for accessing NetworkAttachmentDefinition(k8s.cni.cncf.io/v1)
   *
   * @return {@link MixedOperation} for NetworkAttachmentDefinition
   */
  MixedOperation<NetworkAttachmentDefinition, NetworkAttachmentDefinitionList, Resource<NetworkAttachmentDefinition>> networkAttachmentDefinitions();

  /**
   * API entrypoint for accessing OAuthAccessToken(oauth.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for OAuthAccessToken
   */
  NonNamespaceOperation<OAuthAccessToken, OAuthAccessTokenList, Resource<OAuthAccessToken>> oAuthAccessTokens();

  /**
   * API entrypoint for accessing OAuthAuthorizeToken(oauth.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for OAuthAuthorizeToken
   */
  NonNamespaceOperation<OAuthAuthorizeToken, OAuthAuthorizeTokenList, Resource<OAuthAuthorizeToken>> oAuthAuthorizeTokens();

  /**
   * API entrypoint for accessing OAuthClient(oauth.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for OAuthClient
   */
  NonNamespaceOperation<OAuthClient, OAuthClientList, Resource<OAuthClient>> oAuthClients();

  /**
   * API entrypoint for accessing OAuthClientAuthorization(oauth.openshift.io/v1)
   *
   * @return NonNamespaceOperation for OAuthClientAuthorization
   */
  NonNamespaceOperation<OAuthClientAuthorization, OAuthClientAuthorizationList, Resource<OAuthClientAuthorization>> oAuthClientAuthorizations();

  /**
   * API entrypoint for OperatorPKI(network.operator.openshift.io/v1)
   *
   * @return {@link MixedOperation} for OperatorPKI
   */
  MixedOperation<OperatorPKI, OperatorPKIList, Resource<OperatorPKI>> operatorPKIs();

  /**
   * API entrypoint for EgressRouter (network.operator.openshift.io/v1)
   *
   * @return {@link MixedOperation} for EgressRouter
   */
  MixedOperation<EgressRouter, EgressRouterList, Resource<EgressRouter>> egressRouters();

  /**
   * API entrypoint for accessing PodSecurityPolicyReview (security.openshift.io/v1)
   *
   * @return InOutCreateable object for PodSecurityPolicyReview
   */
  NamespacedInOutCreateable<PodSecurityPolicyReview, PodSecurityPolicyReview> podSecurityPolicyReviews();

  /**
   * API entrypoint for accessing PodSecurityPolicySelfSubjectReview (security.openshift.io/v1)
   *
   * @return InOutCreateable object for PodSecurityPolicySelfSubjectReview
   */
  NamespacedInOutCreateable<PodSecurityPolicySelfSubjectReview, PodSecurityPolicySelfSubjectReview> podSecurityPolicySelfSubjectReviews();

  /**
   * API entrypoint for accessing PodSecurityPolicySubjectReview (security.openshift.io/v1)
   *
   * @return InOutCreateable object for PodSecurityPolicySubjectReview
   */
  NamespacedInOutCreateable<PodSecurityPolicySubjectReview, PodSecurityPolicySubjectReview> podSecurityPolicySubjectReviews();

  /**
   * API entrypoint for accessing Project operations(project.openshift.io/v1)
   *
   * @return {@link ProjectOperation} for Project specific operations
   */
  ProjectOperation projects();

  /**
   * API entrypoint for accessing ProjectRequest operations(project.openshift.io/v1)
   *
   * @return {@link ProjectRequestOperation} for ProjectRequest specific operations
   */
  ProjectRequestOperation projectrequests();

  /**
   * API entrypoint for accessing OpenShift Quota APIGroup resources(quota.openshift.io/v1)
   *
   * @return {@link OpenShiftQuotaAPIGroupDSL} which contains operations for respective resources inside the APIGroup
   */
  OpenShiftQuotaAPIGroupDSL quotas();

  /**
   * API entrypoint for accessing Role(authorization.openshift.io/v1)
   *
   * @return MixedOperation object for Role
   */
  MixedOperation<Role, RoleList, Resource<Role>> roles();

  /**
   * API entrypoint for accessing RoleBinding(authorization.openshift.io/v1)
   *
   * @return MixedOperation object for RoleBinding
   */
  MixedOperation<RoleBinding, RoleBindingList, Resource<RoleBinding>> roleBindings();

  /**
   * API entrypoint for accessing Route(route.openshift.io/v1)
   *
   * @return MixedOperation object for Route
   */
  MixedOperation<Route, RouteList, Resource<Route>> routes();

  /**
   * API entrypoint for accessing Template(template.openshift.io/v1)
   *
   * @return {@link ParameterMixedOperation} object for Template operations
   */
  ParameterMixedOperation<Template, TemplateList, TemplateResource> templates();

  /**
   * API entrypoint for TemplateInstance(template.openshift.io/v1)
   *
   * @return {@link MixedOperation} for TemplateInstance
   */
  MixedOperation<TemplateInstance, TemplateInstanceList, Resource<TemplateInstance>> templateInstances();

  /**
   * API entrypoint for OpenShift Node Tuning operator model(tuned.openshift.io/v1)
   *
   * @return {@link OpenShiftTunedAPIGroupDSL} for access to various available resources
   */
  OpenShiftTunedAPIGroupDSL tuned();

  /**
   * API entrypoint for BrokerTemplateInstance(template.openshift.io/v1)
   *
   * @return {@link NonNamespaceOperation} for BrokerTemplateInstance
   */
  NonNamespaceOperation<BrokerTemplateInstance, BrokerTemplateInstanceList, Resource<BrokerTemplateInstance>> brokerTemplateInstances();

  /**
   * API entrypoint for accessing User(user.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for User
   */
  NonNamespaceOperation<User, UserList, Resource<User>> users();

  /**
   * API entrypoint for accessing RangeAllocation(security.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for RangeAllocation
   */
  NonNamespaceOperation<RangeAllocation, RangeAllocationList, Resource<RangeAllocation>> rangeAllocations();

  /**
   * API entrypoint for accessing SecurityContextConstraints(security.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for SecurityContextConstraints
   */
  NonNamespaceOperation<SecurityContextConstraints, SecurityContextConstraintsList, Resource<SecurityContextConstraints>> securityContextConstraints();

  /**
   * API entrypoint for SubjectAccessReview (authorization.openshift.io/v1)
   * This only supports create operation. SubjectAccessReviewResponse from server is returned as output
   *
   * @return {@link InOutCreateable} for SubjectAccessReview
   */
  InOutCreateable<SubjectAccessReview, SubjectAccessReviewResponse> subjectAccessReviews();

  /**
   * API entrypoint for ResourceAccessReview (authorization.openshift.io/v1)
   * This only supports create operation. ResourceAccessReviewResponse from server is returned as output
   *
   * @return {@link InOutCreateable} for ResourceAccessReview
   */
  InOutCreateable<ResourceAccessReview, ResourceAccessReviewResponse> resourceAccessReviews();

  /**
   * API entrypoint for LocalSubjectAccessReview (authorization.openshift.io/v1)
   * This only supports create operation. SubjectAccessReviewResponse from server is returned as output
   *
   * @return {@link NamespacedInOutCreateable} for LocalSubjectAccessReview
   */
  NamespacedInOutCreateable<LocalSubjectAccessReview, SubjectAccessReviewResponse> localSubjectAccessReviews();

  /**
   * API entrypoint for LocalResourceAccessReview (authorization.openshift.io/v1)
   * This only supports create operation. ResourceAccessReviewResponse from server is returned as output
   *
   * @return {@link NamespacedInOutCreateable} for LocalResourceAccessReview
   */
  NamespacedInOutCreateable<LocalResourceAccessReview, ResourceAccessReviewResponse> localResourceAccessReviews();

  /**
   * API entrypoint for SelfSubjectRulesReview (authorization.openshift.io/v1)
   * This only supports create operation. SelfSubjectRulesReview from server is returned as output
   *
   * @return {@link NamespacedInOutCreateable} for SelfSubjectRulesReview
   */
  NamespacedInOutCreateable<SelfSubjectRulesReview, SelfSubjectRulesReview> selfSubjectRulesReviews();

  /**
   * API entrypoint for SubjectRulesReview (authorization.openshift.io/v1)
   * This only supports create operation. SubjectRulesReview from server is returned as output
   *
   * @return {@link NamespacedInOutCreateable} for SubjectRulesReview
   */
  NamespacedInOutCreateable<SubjectRulesReview, SubjectRulesReview> subjectRulesReviews();

  /**
   * API entrypoint for accessing resources in Kube Storage Version Migrator(migration.k8s.io/v1alpha1)
   *
   * @return {@link OpenShiftStorageVersionMigratorApiGroupDSL} for accessing resources available in apiGroup
   */
  OpenShiftStorageVersionMigratorApiGroupDSL kubeStorageVersionMigrator();

  /**
   * API entrypoint for ClusterRole (authorization.openshift.io/v1)
   *
   * @return {@link NonNamespaceOperation} for ClusterRole
   */
  NonNamespaceOperation<ClusterRole, ClusterRoleList, Resource<ClusterRole>> clusterRoles();

  /**
   * API entrypoint for accessing ClusterRoleBinding(authorization.openshift.io/v1)
   *
   * @return MixedOperation object for ClusterRoleBinding
   */
  MixedOperation<ClusterRoleBinding, ClusterRoleBindingList, Resource<ClusterRoleBinding>> clusterRoleBindings();

  /**
   * API entrypoint for RoleBindingRestriction (authorization.openshift.io/v1)
   *
   * @return {@link MixedOperation} for RoleBindingRestriction
   */
  MixedOperation<RoleBindingRestriction, RoleBindingRestrictionList, Resource<RoleBindingRestriction>> roleBindingRestrictions();

  /**
   * Configure Request Config
   *
   * @param requestConfig request configuration for connection
   * @return {@link NamespacedOpenShiftClient} configured with specified RequestConfig
   */
  FunctionCallable<NamespacedOpenShiftClient> withRequestConfig(RequestConfig requestConfig);

  /**
   * Returns the current logged in user details similar to the `oc whoami` command.
   *
   * @return User as currently logged in user
   */
  User currentUser();

  /**
   * API entrypoint for Identity(user.openshift.io/v1)
   *
   * @return {@link NonNamespaceOperation} for Identity
   */
  NonNamespaceOperation<Identity, IdentityList, Resource<Identity>> identities();

  /**
   * API entrypoint for UserIdentityMapping(user.openshift.io/v1)
   * Note: This only works with create operation
   *
   * @return {@link UserIdentityMapping} for UserIdentityMapping
   */
  InOutCreateable<UserIdentityMapping, UserIdentityMapping> userIdentityMappings();

  /**
   * API entrypoint for UserOAuthAccessToken(oauth.openshift.io/v1)
   * <p>
   * Note: Only GET and DELETE operations are supported by APIServer for this resource.
   * </p>
   *
   * @return {@link NonNamespaceOperation} for UserOAuthAccessToken
   */
  NonNamespaceOperation<UserOAuthAccessToken, UserOAuthAccessTokenList, Resource<UserOAuthAccessToken>> userOAuthAccessTokens();

  /**
   * API entrypoint for OpenShift Whereabouts CNI(Container Network Interface) Plugin model.
   *
   * @return {@link OpenShiftWhereaboutsAPIGroupDSL} which provides DSL methods for available resources.
   */
  OpenShiftWhereaboutsAPIGroupDSL whereabouts();

  /**
   * Returns true if this cluster is a legacy openshift cluster or supports the given OpenShift API Group defined in
   * {@link OpenShiftAPIGroups}
   *
   * @param apiGroup API group as string
   * @return boolean value indicating cluster is legacy or supports APIGroups
   */
  boolean supportsOpenShiftAPIGroup(String apiGroup);
}
