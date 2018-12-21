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
package io.fabric8.kubernetes.api.model;

import io.fabric8.openshift.api.model.*;

import java.util.HashMap;
import java.util.Map;


@Deprecated
public enum KubernetesKind {

  List(KubernetesList.class),
  SecurityContextConstraints(SecurityContextConstraints.class),
  SecurityContextConstraintsList(SecurityContextConstraintsList.class),
  ServiceAccount(ServiceAccount.class),
  ServiceAccountList(ServiceAccountList.class),
  Service(Service.class),
  ServiceList(ServiceList.class),
  Pod(Pod.class),
  PodList(PodList.class),
  ReplicationController(ReplicationController.class),
  ReplicationControllerList(ReplicationControllerList.class),
  Namespace(Namespace.class),
  NamespaceList(NamespaceList.class),
  Secret(Secret.class),
  SecretList(SecretList.class),
  Endpoints(Endpoints.class),
  EndpointsList(EndpointsList.class),
  Node(Node.class),
  NodeList(NodeList.class),
  Build(Build.class),
  BuildList(BuildList.class),
  BuildConfig(BuildConfig.class),
  BuildConfigList(BuildConfigList.class),
  DeploymentConfig(DeploymentConfig.class),
  DeploymentConfigList(DeploymentConfigList.class),
  Image(Image.class),
  ImageList(ImageList.class),
  ImageStream(ImageStream.class),
  ImageStreamList(ImageStreamList.class),
  NameTagEventList(NamedTagEventList.class),
  Route(Route.class),
  RouteList(RouteList.class),
  Template(Template.class),
  TemplateList(TemplateList.class),
  OAuthClient(OAuthClient.class),
  OAuthClientList(OAuthClientList.class),
  OAuthClientAuthorization(OAuthClientAuthorization.class),
  OAuthClientAuthorizationList(OAuthClientAuthorizationList.class),
  OAuthAuthorizeToken(OAuthAuthorizeToken.class),
  OAuthAuthorizeTokenList(OAuthAuthorizeTokenList.class),
  OAuthAccessToken(OAuthAccessToken.class),
  OAuthAccessTokenList(OAuthAccessTokenList.class),
  Role(OpenshiftRole.class),
  RoleList(OpenshiftRoleList.class),
  RoleBinding(OpenshiftRoleBinding.class),
  RoleBindingList(OpenshiftRoleBindingList.class),
  ClusterRoleBinding(OpenshiftClusterRoleBinding.class),
  ClusterRoleBindingList(OpenshiftClusterRoleBindingList.class),
  User(User.class),
  UserList(UserList.class),
  Group(Group.class),
  GroupList(GroupList.class),
  Identity(Identity.class),
  IdentityList(IdentityList.class),
  PersistentVolume(PersistentVolume.class),
  PersistentVolumeList(PersistentVolumeList.class),
  PersistentVolumeClaim(PersistentVolumeClaim.class),
  PersistentVolumeClaimList(PersistentVolumeClaimList.class),
  SubjectAccessReview(SubjectAccessReview.class),
  SubjectAccessReviewResponse(SubjectAccessReviewResponse.class),
  LocalSubjectAccessReview(LocalSubjectAccessReview.class),
  Project(Project.class),
  ProjectRequest(ProjectRequest.class);

  private static final Map<String, Class<? extends KubernetesResource>> map = new HashMap<>();

  static {
    for (KubernetesKind kind : KubernetesKind.values()) {
      map.put(kind.name(), kind.type);
    }
  }

  private final Class<? extends KubernetesResource> type;

  KubernetesKind(Class type) {
    this.type = type;
  }

  public Class getType() {
    return type;
  }

  public static Class<? extends KubernetesResource> getTypeForName(String name) {
    return map.get(name);
  }
}
