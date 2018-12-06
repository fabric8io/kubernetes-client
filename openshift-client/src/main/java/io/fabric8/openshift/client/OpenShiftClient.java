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
import io.fabric8.kubernetes.client.VersionInfo;
import io.fabric8.kubernetes.client.dsl.*;
import io.fabric8.openshift.api.model.*;
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

  MixedOperation<OpenshiftRole, OpenshiftRoleList, DoneableOpenshiftRole, Resource<OpenshiftRole, DoneableOpenshiftRole>> roles();

  MixedOperation<OpenshiftRoleBinding, OpenshiftRoleBindingList, DoneableOpenshiftRoleBinding, Resource<OpenshiftRoleBinding, DoneableOpenshiftRoleBinding>>
  roleBindings();

  MixedOperation<Route, RouteList, DoneableRoute, Resource<Route, DoneableRoute>> routes();

  ParameterMixedOperation<Template, TemplateList, DoneableTemplate, TemplateResource<Template, KubernetesList, DoneableTemplate>> templates();

  NonNamespaceOperation<User, UserList, DoneableUser, Resource<User, DoneableUser>> users();

  NonNamespaceOperation<SecurityContextConstraints, SecurityContextConstraintsList, DoneableSecurityContextConstraints, Resource<SecurityContextConstraints, DoneableSecurityContextConstraints>> securityContextConstraints();

  SubjectAccessReviewOperation<CreateableSubjectAccessReview, CreateableLocalSubjectAccessReview> subjectAccessReviews();

  MixedOperation<OpenshiftClusterRoleBinding, OpenshiftClusterRoleBindingList, DoneableOpenshiftClusterRoleBinding, Resource<OpenshiftClusterRoleBinding, DoneableOpenshiftClusterRoleBinding>> clusterRoleBindings();

  /**
   * Returns the current logged in user details similar to the `oc whoami` command.
   */
  User currentUser();

  /**
   * Returns true if this cluster is a legacy openshift cluster or supports the given OpenShift API Group defined in {@link OpenShiftAPIGroups}
   */
  boolean supportsOpenShiftAPIGroup(String apiGroup);
}
