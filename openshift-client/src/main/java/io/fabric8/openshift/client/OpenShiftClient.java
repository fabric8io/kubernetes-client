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

import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.RequestConfig;
import io.fabric8.kubernetes.client.VersionInfo;
import io.fabric8.kubernetes.client.dsl.*;
import io.fabric8.openshift.api.model.*;
import io.fabric8.openshift.api.model.HelmChartRepository;
import io.fabric8.openshift.api.model.HelmChartRepositoryList;
import io.fabric8.openshift.client.dsl.*;
import io.fabric8.openshift.client.dsl.internal.image.ImageSignatureOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.image.ImageStreamImageOperationsImpl;

import java.net.URL;

public interface OpenShiftClient extends KubernetesClient {

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
   * API entrypoint for accessing OpenShift operator APIGroup resources(operator.openshift.io/v1 and operator.openshift.io/v1alpha1)
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
  ExtensionsAPIGroupDSL extensions();

  /**
   * {@inheritDoc}
   */
  VersionInfo getVersion();

  /**
   * {@inheritDoc}
   */
  AppsAPIGroupDSL apps();

  /**
   * {@inheritDoc}
   */
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
  NetworkAPIGroupDSL network();

  /**
   * {@inheritDoc}
   */
  StorageAPIGroupDSL storage();

  /**
   * {@inheritDoc}
   */
  BatchAPIGroupDSL batch();

  /**
   * {@inheritDoc}
   */
  RbacAPIGroupDSL rbac();

  /**
   * {@inheritDoc}
   */
  SchedulingAPIGroupDSL scheduling();

  /**
   * API entrypoint for handling Build(build.openshift.io/v1)
   *
   * @return MixedOperation instance for Build object
   */
  MixedOperation<Build, BuildList, BuildResource<Build, LogWatch>> builds();

  /**
   * API entrypoint for handling BuildConfig(build.openshift.io/v1)
   *
   * @return MixedOperation instance for BuildConfig object
   */
  MixedOperation<BuildConfig, BuildConfigList, BuildConfigResource<BuildConfig, Void, Build>> buildConfigs();

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
   * @return {@link OpenShiftCreateOnlyResourceOperationsImpl} for ImageStreamImport
   */
  OpenShiftCreateOnlyResourceOperationsImpl<ImageStreamImport, ImageStreamImport> imageStreamImports();

  /**
   * API entrypoint for accessing ImageStreamMapping(image.openshift.io/v1)
   *
   * @return {@link OpenShiftCreateOnlyResourceOperationsImpl} for ImageStreamMapping
   */
  OpenShiftCreateOnlyResourceOperationsImpl<ImageStreamMapping, ImageStreamMapping> imageStreamMappings();

  /**
   * API entrypoint for accessing ImageStreamImage(image.openshift.io/v1)
   *
   * @return {@link ImageStreamImageOperationsImpl} for ImageStreamImage operations
   */
  ImageStreamImageOperationsImpl imageStreamImages();

  /**
   * API entrypoint for accessing ImageSignature(image.openshift.io/v1)
   *
   * @return {@link ImageSignatureOperationsImpl} for ImageSignature operations
   */
  ImageSignatureOperationsImpl imageSignatures();
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
   * API entrypoint for accessing PodSecurityPolicyReview (security.openshift.io/v1)
   *
   * @return InOutCreateable object for PodSecurityPolicyReview
   */
  OpenShiftCreateOnlyResourceOperationsImpl<PodSecurityPolicyReview, PodSecurityPolicyReview> podSecurityPolicyReviews();

  /**
   * API entrypoint for accessing PodSecurityPolicySelfSubjectReview (security.openshift.io/v1)
   *
   * @return InOutCreateable object for PodSecurityPolicySelfSubjectReview
   */
  OpenShiftCreateOnlyResourceOperationsImpl<PodSecurityPolicySelfSubjectReview, PodSecurityPolicySelfSubjectReview> podSecurityPolicySelfSubjectReviews();

  /**
   * API entrypoint for accessing PodSecurityPolicySubjectReview (security.openshift.io/v1)
   *
   * @return InOutCreateable object for PodSecurityPolicySubjectReview
   */
  OpenShiftCreateOnlyResourceOperationsImpl<PodSecurityPolicySubjectReview, PodSecurityPolicySubjectReview> podSecurityPolicySubjectReviews();

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
  MixedOperation<RoleBinding, RoleBindingList, Resource<RoleBinding>>
  roleBindings();

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
  ParameterMixedOperation<Template, TemplateList, TemplateResource<Template, KubernetesList>> templates();

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
   * @return {@link OpenShiftCreateOnlyResourceOperationsImpl} for LocalSubjectAccessReview
   */
  OpenShiftCreateOnlyResourceOperationsImpl<LocalSubjectAccessReview, SubjectAccessReviewResponse> localSubjectAccessReviews();

  /**
   * API entrypoint for LocalResourceAccessReview (authorization.openshift.io/v1)
   * This only supports create operation. ResourceAccessReviewResponse from server is returned as output
   *
   * @return {@link OpenShiftCreateOnlyResourceOperationsImpl} for LocalResourceAccessReview
   */
  OpenShiftCreateOnlyResourceOperationsImpl<LocalResourceAccessReview, ResourceAccessReviewResponse> localResourceAccessReviews();

  /**
   * API entrypoint for SelfSubjectRulesReview (authorization.openshift.io/v1)
   * This only supports create operation. SelfSubjectRulesReview from server is returned as output
   *
   * @return {@link OpenShiftCreateOnlyResourceOperationsImpl} for SelfSubjectRulesReview
   */
  OpenShiftCreateOnlyResourceOperationsImpl<SelfSubjectRulesReview, SelfSubjectRulesReview> selfSubjectRulesReviews();

  /**
   * API entrypoint for SubjectRulesReview (authorization.openshift.io/v1)
   * This only supports create operation. SubjectRulesReview from server is returned as output
   *
   * @return {@link OpenShiftCreateOnlyResourceOperationsImpl} for SubjectRulesReview
   */
  OpenShiftCreateOnlyResourceOperationsImpl<SubjectRulesReview, SubjectRulesReview> subjectRulesReviews();

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
   * @return {@link Createable} for UserIdentityMapping
   */
  Createable<UserIdentityMapping> userIdentityMappings();

  /**
   * API entrypoint for OpenShift Whereabouts CNI(Container Network Interface) Plugin model.
   *
   * @return {@link OpenShiftWhereaboutsAPIGroupDSL} which provides DSL methods for available resources.
   */
  OpenShiftWhereaboutsAPIGroupDSL whereabouts();
  /**
   * Returns true if this cluster is a legacy openshift cluster or supports the given OpenShift API Group defined in {@link OpenShiftAPIGroups}
   *
   * @param apiGroup API group as string
   * @return boolean value indicating cluster is legacy or supports APIGroups
   */
  boolean supportsOpenShiftAPIGroup(String apiGroup);
}
