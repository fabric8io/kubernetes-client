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

import java.net.URL;

import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.AppsAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.AutoscalingAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.ParameterMixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.ExtensionsAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.LogWatch;
import io.fabric8.openshift.api.model.Build;
import io.fabric8.openshift.api.model.BuildConfig;
import io.fabric8.openshift.api.model.BuildConfigList;
import io.fabric8.openshift.api.model.BuildList;
import io.fabric8.openshift.api.model.ClusterRoleBinding;
import io.fabric8.openshift.api.model.ClusterRoleBindingList;
import io.fabric8.openshift.api.model.DeploymentConfig;
import io.fabric8.openshift.api.model.DeploymentConfigList;
import io.fabric8.openshift.api.model.DoneableBuild;
import io.fabric8.openshift.api.model.DoneableBuildConfig;
import io.fabric8.openshift.api.model.DoneableClusterRoleBinding;
import io.fabric8.openshift.api.model.DoneableDeploymentConfig;
import io.fabric8.openshift.api.model.DoneableGroup;
import io.fabric8.openshift.api.model.DoneableImageStream;
import io.fabric8.openshift.api.model.DoneableImageStreamTag;
import io.fabric8.openshift.api.model.DoneableOAuthAccessToken;
import io.fabric8.openshift.api.model.DoneableOAuthAuthorizeToken;
import io.fabric8.openshift.api.model.DoneableOAuthClient;
import io.fabric8.openshift.api.model.DoneablePolicy;
import io.fabric8.openshift.api.model.DoneablePolicyBinding;
import io.fabric8.openshift.api.model.DoneableProject;
import io.fabric8.openshift.api.model.DoneableRole;
import io.fabric8.openshift.api.model.DoneableRoleBinding;
import io.fabric8.openshift.api.model.DoneableRoute;
import io.fabric8.openshift.api.model.DoneableTemplate;
import io.fabric8.openshift.api.model.DoneableUser;
import io.fabric8.openshift.api.model.Group;
import io.fabric8.openshift.api.model.GroupList;
import io.fabric8.openshift.api.model.ImageStream;
import io.fabric8.openshift.api.model.ImageStreamList;
import io.fabric8.openshift.api.model.ImageStreamTag;
import io.fabric8.openshift.api.model.ImageStreamTagList;
import io.fabric8.openshift.api.model.OAuthAccessToken;
import io.fabric8.openshift.api.model.OAuthAccessTokenList;
import io.fabric8.openshift.api.model.OAuthAuthorizeToken;
import io.fabric8.openshift.api.model.OAuthAuthorizeTokenList;
import io.fabric8.openshift.api.model.OAuthClient;
import io.fabric8.openshift.api.model.OAuthClientList;
import io.fabric8.openshift.api.model.Policy;
import io.fabric8.openshift.api.model.PolicyBinding;
import io.fabric8.openshift.api.model.PolicyBindingList;
import io.fabric8.openshift.api.model.PolicyList;
import io.fabric8.openshift.api.model.Project;
import io.fabric8.openshift.api.model.ProjectList;
import io.fabric8.openshift.api.model.Role;
import io.fabric8.openshift.api.model.RoleBinding;
import io.fabric8.openshift.api.model.RoleBindingList;
import io.fabric8.openshift.api.model.RoleList;
import io.fabric8.openshift.api.model.Route;
import io.fabric8.openshift.api.model.RouteList;
import io.fabric8.openshift.api.model.Template;
import io.fabric8.openshift.api.model.TemplateList;
import io.fabric8.openshift.api.model.User;
import io.fabric8.openshift.api.model.UserList;
import io.fabric8.openshift.client.dsl.BuildConfigResource;
import io.fabric8.openshift.client.dsl.BuildResource;
import io.fabric8.openshift.client.dsl.DeployableScalableResource;
import io.fabric8.openshift.client.dsl.ProjectRequestOperation;
import io.fabric8.openshift.client.dsl.SubjectAccessReviewOperation;
import io.fabric8.openshift.client.dsl.TemplateResource;
import io.fabric8.openshift.client.dsl.CreateableLocalSubjectAccessReview;
import io.fabric8.openshift.client.dsl.CreateableSubjectAccessReview;

public interface OpenShiftClient extends KubernetesClient {

  URL getOpenshiftUrl();

  ExtensionsAPIGroupDSL extensions();

  AppsAPIGroupDSL apps();

  AutoscalingAPIGroupDSL autoscaling();

  MixedOperation<Build, BuildList, DoneableBuild, BuildResource<Build, DoneableBuild, String, LogWatch>> builds();

  MixedOperation<BuildConfig, BuildConfigList, DoneableBuildConfig, BuildConfigResource<BuildConfig, DoneableBuildConfig, Void, Build>> buildConfigs();

  MixedOperation<DeploymentConfig, DeploymentConfigList, DoneableDeploymentConfig, DeployableScalableResource<DeploymentConfig, DoneableDeploymentConfig>> deploymentConfigs();

  NonNamespaceOperation<Group, GroupList, DoneableGroup, Resource<Group, DoneableGroup>> groups();

  MixedOperation<ImageStream, ImageStreamList, DoneableImageStream, Resource<ImageStream, DoneableImageStream>> imageStreams();

  MixedOperation<ImageStreamTag, ImageStreamTagList, DoneableImageStreamTag, Resource<ImageStreamTag, DoneableImageStreamTag>> imageStreamTags();

  NonNamespaceOperation<OAuthAccessToken, OAuthAccessTokenList, DoneableOAuthAccessToken, Resource<OAuthAccessToken, DoneableOAuthAccessToken>> oAuthAccessTokens();

  NonNamespaceOperation<OAuthAuthorizeToken, OAuthAuthorizeTokenList, DoneableOAuthAuthorizeToken, Resource<OAuthAuthorizeToken, DoneableOAuthAuthorizeToken>> oAuthAuthorizeTokens();

  NonNamespaceOperation<OAuthClient, OAuthClientList, DoneableOAuthClient, Resource<OAuthClient, DoneableOAuthClient>> oAuthClients();

  MixedOperation<Policy, PolicyList, DoneablePolicy, Resource<Policy, DoneablePolicy>> policies();

  MixedOperation<PolicyBinding, PolicyBindingList, DoneablePolicyBinding, Resource<PolicyBinding, DoneablePolicyBinding>> policyBindings();

  NonNamespaceOperation<Project, ProjectList, DoneableProject, Resource<Project, DoneableProject>> projects();

  ProjectRequestOperation projectrequests();

  MixedOperation<Role, RoleList, DoneableRole, Resource<Role, DoneableRole>> roles();

  MixedOperation<RoleBinding, RoleBindingList, DoneableRoleBinding, Resource<RoleBinding, DoneableRoleBinding>>
  roleBindings();

  MixedOperation<Route, RouteList, DoneableRoute, Resource<Route, DoneableRoute>> routes();

  ParameterMixedOperation<Template, TemplateList, DoneableTemplate, TemplateResource<Template, KubernetesList, DoneableTemplate>> templates();

  NonNamespaceOperation<User, UserList, DoneableUser, Resource<User, DoneableUser>> users();

  SubjectAccessReviewOperation<CreateableSubjectAccessReview, CreateableLocalSubjectAccessReview> subjectAccessReviews();

  MixedOperation<ClusterRoleBinding, ClusterRoleBindingList, DoneableClusterRoleBinding, Resource<ClusterRoleBinding, DoneableClusterRoleBinding>> clusterRoleBindings();

  /**
   * Returns the current logged in user details similar to the `oc whoami` command.
   */
  User currentUser();

  /**
   * Returns true if this cluster is a legacy openshift cluster or supports the given OpenShift API Group defined in {@link OpenShiftAPIGroups}
   */
  boolean supportsOpenShiftAPIGroup(String apiGroup);
}
