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
import io.fabric8.openshift.api.model.DoneableProject;
import io.fabric8.openshift.api.model.DoneableRole;
import io.fabric8.openshift.api.model.DoneableRoleBinding;
import io.fabric8.openshift.api.model.DoneableRoute;
import io.fabric8.openshift.api.model.DoneableSecurityContextConstraints;
import io.fabric8.openshift.api.model.DoneableTemplate;
import io.fabric8.openshift.api.model.DoneableUser;
import io.fabric8.openshift.client.dsl.*;

import java.net.URL;

public interface OpenShiftClient extends KubernetesClient {

  URL getOpenshiftUrl();

  ExtensionsAPIGroupDSL extensions();

  VersionInfo getVersion();

  AppsAPIGroupDSL apps();

  AutoscalingAPIGroupDSL autoscaling();

  NetworkAPIGroupDSL network();

  StorageAPIGroupDSL storage();

  BatchAPIGroupDSL batch();

  RbacAPIGroupDSL rbac();

  SchedulingAPIGroupDSL scheduling();
  
  SettingsAPIGroupDSL settings();

  MixedOperation<Build, BuildList, DoneableBuild, BuildResource<Build, DoneableBuild, String, LogWatch>> builds();

  MixedOperation<BuildConfig, BuildConfigList, DoneableBuildConfig, BuildConfigResource<BuildConfig, DoneableBuildConfig, Void, Build>> buildConfigs();

  MixedOperation<DeploymentConfig, DeploymentConfigList, DoneableDeploymentConfig, DeployableScalableResource<DeploymentConfig, DoneableDeploymentConfig>> deploymentConfigs();

  NonNamespaceOperation<Group, GroupList, DoneableGroup, Resource<Group, DoneableGroup>> groups();

  MixedOperation<ImageStream, ImageStreamList, DoneableImageStream, Resource<ImageStream, DoneableImageStream>> imageStreams();

  MixedOperation<ImageStreamTag, ImageStreamTagList, DoneableImageStreamTag, Resource<ImageStreamTag, DoneableImageStreamTag>> imageStreamTags();

  NonNamespaceOperation<OAuthAccessToken, OAuthAccessTokenList, DoneableOAuthAccessToken, Resource<OAuthAccessToken, DoneableOAuthAccessToken>> oAuthAccessTokens();

  NonNamespaceOperation<OAuthAuthorizeToken, OAuthAuthorizeTokenList, DoneableOAuthAuthorizeToken, Resource<OAuthAuthorizeToken, DoneableOAuthAuthorizeToken>> oAuthAuthorizeTokens();

  NonNamespaceOperation<OAuthClient, OAuthClientList, DoneableOAuthClient, Resource<OAuthClient, DoneableOAuthClient>> oAuthClients();

  NonNamespaceOperation<Project, ProjectList, DoneableProject, Resource<Project, DoneableProject>> projects();

  ProjectRequestOperation projectrequests();

  MixedOperation<Role, RoleList, DoneableRole, Resource<Role, DoneableRole>> roles();

  MixedOperation<RoleBinding, RoleBindingList, DoneableRoleBinding, Resource<RoleBinding, DoneableRoleBinding>>
  roleBindings();

  MixedOperation<Route, RouteList, DoneableRoute, Resource<Route, DoneableRoute>> routes();

  ParameterMixedOperation<Template, TemplateList, DoneableTemplate, TemplateResource<Template, KubernetesList, DoneableTemplate>> templates();

  NonNamespaceOperation<User, UserList, DoneableUser, Resource<User, DoneableUser>> users();

  NonNamespaceOperation<SecurityContextConstraints, SecurityContextConstraintsList, DoneableSecurityContextConstraints, Resource<SecurityContextConstraints, DoneableSecurityContextConstraints>> securityContextConstraints();

  SubjectAccessReviewOperation<CreateableSubjectAccessReview, CreateableLocalSubjectAccessReview, CreateableSelfSubjectAccessReview, CreateableSelfSubjectRulesReview> subjectAccessReviews();

  MixedOperation<ClusterRoleBinding, ClusterRoleBindingList, DoneableClusterRoleBinding, Resource<ClusterRoleBinding, DoneableClusterRoleBinding>> clusterRoleBindings();

  FunctionCallable<NamespacedOpenShiftClient> withRequestConfig(RequestConfig requestConfig);

  /**
   * Returns the current logged in user details similar to the `oc whoami` command.
   */
  User currentUser();

  /**
   * Returns true if this cluster is a legacy openshift cluster or supports the given OpenShift API Group defined in {@link OpenShiftAPIGroups}
   */
  boolean supportsOpenShiftAPIGroup(String apiGroup);
}
