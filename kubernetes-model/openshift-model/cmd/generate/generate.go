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
package main

import (
  "bytes"
  "encoding/json"
  "fmt"
  appsapi "github.com/openshift/api/apps/v1"
  authapi "github.com/openshift/api/authorization/v1"
  buildapi "github.com/openshift/api/build/v1"
  openshiftconfigapi "github.com/openshift/api/config/v1"
  imageapi "github.com/openshift/api/image/v1"
  networkapi "github.com/openshift/api/network/v1"
  oauthapi "github.com/openshift/api/oauth/v1"
  projectapi "github.com/openshift/api/project/v1"
  routeapi "github.com/openshift/api/route/v1"
  securityapi "github.com/openshift/api/security/v1"
  templateapi "github.com/openshift/api/template/v1"
  userapi "github.com/openshift/api/user/v1"
  authenticationapi "k8s.io/api/authentication/v1"
  rbac "k8s.io/api/rbac/v1" // depends
  "k8s.io/apimachinery/pkg/api/resource"
  metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
  apimachineryversion "k8s.io/apimachinery/pkg/version"
  configapi "k8s.io/client-go/tools/clientcmd/api/v1"
  "log"
  "reflect"
  "strings"
  "time"

  "os"

  "github.com/fabric8io/kubernetes-client/kubernetes-model/pkg/schemagen"
)

type Schema struct {
  Info                                     apimachineryversion.Info
  APIGroup                                 metav1.APIGroup
  APIGroupList                             metav1.APIGroupList
  BaseKubernetesList                       metav1.List
  ObjectMeta                               metav1.ObjectMeta
  TypeMeta                                 metav1.TypeMeta
  SecurityContextConstraints               securityapi.SecurityContextConstraints
  SecurityContextConstraintsList           securityapi.SecurityContextConstraintsList
  Status                                   metav1.Status
  Patch                                    metav1.Patch
  ListOptions                              metav1.ListOptions
  DeleteOptions                            metav1.DeleteOptions
  CreateOptions                            metav1.CreateOptions
  UpdateOptions                            metav1.UpdateOptions
  GetOptions                               metav1.GetOptions
  PatchOptions                             metav1.PatchOptions
  Time                                     metav1.Time
  Quantity                                 resource.Quantity
  BuildRequest                             buildapi.BuildRequest
  BuildList                                buildapi.BuildList
  BuildConfigList                          buildapi.BuildConfigList
  ImageList                                imageapi.ImageList
  ImageStreamList                          imageapi.ImageStreamList
  ImageStreamTagList                       imageapi.ImageStreamTagList
  ImageStreamImport                        imageapi.ImageStreamImport
  DeploymentConfig                         appsapi.DeploymentConfig
  DeploymentConfigList                     appsapi.DeploymentConfigList
  Route                                    routeapi.Route
  RouteList                                routeapi.RouteList
  Template                                 templateapi.Template
  TemplateList                             templateapi.TemplateList
  TagEvent                                 imageapi.TagEvent
  OAuthClient                              oauthapi.OAuthClient
  OAuthAccessToken                         oauthapi.OAuthAccessToken
  OAuthAuthorizeToken                      oauthapi.OAuthAuthorizeToken
  OAuthClientAuthorization                 oauthapi.OAuthClientAuthorization
  OAuthAccessTokenList                     oauthapi.OAuthAccessTokenList
  OAuthAuthorizeTokenList                  oauthapi.OAuthAuthorizeTokenList
  OAuthClientList                          oauthapi.OAuthClientList
  OAuthClientAuthorizationList             oauthapi.OAuthClientAuthorizationList
  OpenshiftClusterRoleScopeRestriction     oauthapi.ClusterRoleScopeRestriction
  TokenReview                              authenticationapi.TokenReview
  OpenshiftRole                            authapi.Role
  OpenshiftRoleList                        authapi.RoleList
  OpenshiftRoleBinding                     authapi.RoleBinding
  OpenshiftRoleBindingList                 authapi.RoleBindingList
  OpenshiftRoleBindingRestriction          authapi.RoleBindingRestriction
  OpenshiftRoleBindingRestrictionSpec      authapi.RoleBindingRestrictionSpec
  LocalSubjectAccessReview                 authapi.LocalSubjectAccessReview
  SubjectAccessReview                      authapi.SubjectAccessReview
  SubjectAccessReviewResponse              authapi.SubjectAccessReviewResponse
  OpenshiftClusterRole                     authapi.ClusterRole
  OpenshiftClusterRoleList                 authapi.ClusterRoleList
  OpenshiftClusterRoleBinding              authapi.ClusterRoleBinding
  OpenshiftClusterRoleBindingList          authapi.ClusterRoleBindingList
  User                                     userapi.User
  UserList                                 userapi.UserList
  Group                                    userapi.Group
  GroupList                                userapi.GroupList
  Identity                                 userapi.Identity
  IdentityList                             userapi.IdentityList
  Config                                   configapi.Config
  RootPaths                                metav1.RootPaths
  Project                                  projectapi.Project
  ProjectList                              projectapi.ProjectList
  ProjectRequest                           projectapi.ProjectRequest
  // Added JSONSchemaPropsorStringArray here because of
  // https://github.com/joelittlejohn/jsonschema2pojo/issues/866
  AggregationRule                          rbac.AggregationRule
  Role                                     rbac.Role
  RoleList                                 rbac.RoleList
  RoleBinding                              rbac.RoleBinding
  RoleBindingList                          rbac.RoleBindingList
  NetNamespace                             networkapi.NetNamespace
  NetNamespaceList                         networkapi.NetNamespaceList
  ClusterRole                              rbac.ClusterRole
  ClusterRoleList                          rbac.ClusterRoleList
  ClusterRoleBinding                       rbac.ClusterRoleBinding
  ClusterRoleBindingList                   rbac.ClusterRoleBindingList
  ClusterVersion                           openshiftconfigapi.ClusterVersion
  ClusterVersionList                       openshiftconfigapi.ClusterVersionList
}

func main() {
  customTypeNames := map[string]string{
    "K8sSubjectAccessReview": "SubjectAccessReview",
    "K8sLocalSubjectAccessReview":  "LocalSubjectAccessReview",
    "JSONSchemaPropsorStringArray": "JSONSchemaPropsOrStringArray",
  }
  packages := []schemagen.PackageDescriptor{
    {"k8s.io/api/core/v1", "", "io.fabric8.kubernetes.api.model", "kubernetes_core_"},
    {"k8s.io/apimachinery/pkg/api/resource", "", "io.fabric8.kubernetes.api.model", "kubernetes_resource_"},
    {"k8s.io/apimachinery/pkg/util/intstr", "", "io.fabric8.kubernetes.api.model", "kubernetes_apimachinery_pkg_util_intstr_"},
    {"k8s.io/apimachinery/pkg/runtime", "", "io.fabric8.openshift.api.model.runtime", "kubernetes_apimachinery_pkg_runtime_"},
    {"k8s.io/apimachinery/pkg/version", "", "io.fabric8.kubernetes.api.model.version", "kubernetes_apimachinery_pkg_version_"},
    {"k8s.io/kubernetes/pkg/util", "", "io.fabric8.kubernetes.api.model", "kubernetes_util_"},
    {"k8s.io/kubernetes/pkg/api/errors", "", "io.fabric8.kubernetes.api.model", "kubernetes_errors_"},
    {"k8s.io/client-go/tools/clientcmd/api/v1", "", "io.fabric8.kubernetes.api.model", "kubernetes_config_"},
    {"github.com/openshift/api/build/v1", "", "io.fabric8.openshift.api.model", "os_build_"},
    {"github.com/openshift/api/apps/v1", "", "io.fabric8.openshift.api.model", "os_deploy_"},
    {"github.com/openshift/api/image/v1", "", "io.fabric8.openshift.api.model", "os_image_"},
    {"github.com/openshift/api/oauth/v1", "", "io.fabric8.openshift.api.model", "os_oauth_"},
    {"github.com/openshift/api/route/v1", "", "io.fabric8.openshift.api.model", "os_route_"},
    {"github.com/openshift/api/template/v1", "", "io.fabric8.openshift.api.model", "os_template_"},
    {"github.com/openshift/api/user/v1", "", "io.fabric8.openshift.api.model", "os_user_"},
    {"github.com/openshift/api/authorization/v1", "", "io.fabric8.openshift.api.model", "os_authorization_"},
    {"github.com/openshift/api/project/v1", "", "io.fabric8.openshift.api.model", "os_project_"},
    {"github.com/openshift/api/security/v1", "", "io.fabric8.openshift.api.model", "os_security_"},
    {"github.com/openshift/api/network/v1", "", "io.fabric8.openshift.api.model", "os_network_"},
    {"github.com/openshift/api/config/v1", "", "io.fabric8.openshift.api.model", "os_config_"},
    {"k8s.io/kubernetes/pkg/api/unversioned", "", "io.fabric8.kubernetes.api.model", "api_"},
    {"k8s.io/api/authentication/v1", "authentication.k8s.io", "io.fabric8.kubernetes.api.model.authentication", "kubernetes_authentication_"},
    {"k8s.io/apiextensions-apiserver/pkg/apis/apiextensions/v1beta1", "", "io.fabric8.kubernetes.api.model.apiextensions", "kubernetes_apiextensions_"},
    {"k8s.io/apimachinery/pkg/apis/meta/v1", "", "io.fabric8.kubernetes.api.model", "kubernetes_apimachinery_"},
    {"k8s.io/api/rbac/v1", "rbac.authorization.k8s.io", "io.fabric8.kubernetes.api.model.rbac", "kubernetes_rbac_"},
  }

  typeMap := map[reflect.Type]reflect.Type{
    reflect.TypeOf(time.Time{}): reflect.TypeOf(""),
    reflect.TypeOf(struct{}{}):  reflect.TypeOf(""),
  }
  schema, err := schemagen.GenerateSchema(reflect.TypeOf(Schema{}), packages, typeMap, customTypeNames, "openshift")
  if err != nil {
    fmt.Fprintf(os.Stderr, "An error occurred: %v", err)
    return
  }

  args := os.Args[1:]
  if len(args) < 1 || args[0] != "validation" {
    schema.Resources = nil
  }

  b, err := json.Marshal(&schema)
  if err != nil {
    log.Fatal(err)
  }
  result := string(b)
  result = strings.Replace(result, "\"additionalProperty\":", "\"additionalProperties\":", -1)

  var out bytes.Buffer
  err = json.Indent(&out, []byte(result), "", "  ")
  if err != nil {
    log.Fatal(err)
  }

  fmt.Println(out.String())
}
