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
	"log"
	"reflect"
	"strings"
	"time"

	appsapi "github.com/openshift/api/apps/v1"
	authapi "github.com/openshift/api/authorization/v1"
	buildapi "github.com/openshift/api/build/v1"
	helmapiv1beta1 "github.com/openshift/api/helm/v1beta1"
	imageapi "github.com/openshift/api/image/v1"
	networkapi "github.com/openshift/api/network/v1"
	oauthapi "github.com/openshift/api/oauth/v1"
	projectapi "github.com/openshift/api/project/v1"
	quotaapi "github.com/openshift/api/quota/v1"
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

	"os"

	"github.com/fabric8io/kubernetes-client/kubernetes-model-generator/pkg/schemagen"
)

type Schema struct {
	Info                                 apimachineryversion.Info
	APIGroup                             metav1.APIGroup
	APIGroupList                         metav1.APIGroupList
	BaseKubernetesList                   metav1.List
	ObjectMeta                           metav1.ObjectMeta
	TypeMeta                             metav1.TypeMeta
	SecurityContextConstraints           securityapi.SecurityContextConstraints
	SecurityContextConstraintsList       securityapi.SecurityContextConstraintsList
	PodSecurityPolicyReview              securityapi.PodSecurityPolicyReview
	PodSecurityPolicySelfSubjectReview   securityapi.PodSecurityPolicySelfSubjectReview
	PodSecurityPolicySubjectReview       securityapi.PodSecurityPolicySubjectReview
	RangeAllocation                      securityapi.RangeAllocation
	RangeAllocationList                  securityapi.RangeAllocationList
	Status                               metav1.Status
	Patch                                metav1.Patch
	ListOptions                          metav1.ListOptions
	DeleteOptions                        metav1.DeleteOptions
	CreateOptions                        metav1.CreateOptions
	UpdateOptions                        metav1.UpdateOptions
	GetOptions                           metav1.GetOptions
	PatchOptions                         metav1.PatchOptions
	Time                                 metav1.Time
	Quantity                             resource.Quantity
	BuildRequest                         buildapi.BuildRequest
	BuildList                            buildapi.BuildList
	BuildConfigList                      buildapi.BuildConfigList
	ImageList                            imageapi.ImageList
	ImageTag                             imageapi.ImageTag
	ImageTagList                         imageapi.ImageTagList
	ImageStreamList                      imageapi.ImageStreamList
	ImageStreamTagList                   imageapi.ImageStreamTagList
	ImageStreamImport                    imageapi.ImageStreamImport
	ImageStreamImage                     imageapi.ImageStreamImage
	ImageStreamMapping                   imageapi.ImageStreamMapping
	ImageSignature                       imageapi.ImageSignature
	DeploymentConfig                     appsapi.DeploymentConfig
	DeploymentConfigList                 appsapi.DeploymentConfigList
	Route                                routeapi.Route
	RouteList                            routeapi.RouteList
	Template                             templateapi.Template
	TemplateList                         templateapi.TemplateList
	TemplateInstance                     templateapi.TemplateInstance
	TemplateInstanceList                 templateapi.TemplateInstanceList
	BrokerTemplateInstance               templateapi.BrokerTemplateInstance
	BrokerTemplateInstanceList           templateapi.BrokerTemplateInstanceList
	TagEvent                             imageapi.TagEvent
	OAuthClient                          oauthapi.OAuthClient
	OAuthAccessToken                     oauthapi.OAuthAccessToken
	OAuthAuthorizeToken                  oauthapi.OAuthAuthorizeToken
	OAuthClientAuthorization             oauthapi.OAuthClientAuthorization
	OAuthAccessTokenList                 oauthapi.OAuthAccessTokenList
	OAuthAuthorizeTokenList              oauthapi.OAuthAuthorizeTokenList
	OAuthClientList                      oauthapi.OAuthClientList
	OAuthClientAuthorizationList         oauthapi.OAuthClientAuthorizationList
	OpenshiftClusterRoleScopeRestriction oauthapi.ClusterRoleScopeRestriction
	UserOAuthAccessToken                 oauthapi.UserOAuthAccessToken
	UserOAuthAccessTokenList             oauthapi.UserOAuthAccessTokenList
	TokenReview                          authenticationapi.TokenReview
	OpenshiftRole                        authapi.Role
	OpenshiftRoleList                    authapi.RoleList
	OpenshiftRoleBinding                 authapi.RoleBinding
	OpenshiftRoleBindingList             authapi.RoleBindingList
	OpenshiftRoleBindingRestriction      authapi.RoleBindingRestriction
	OpenShiftRoleBindingRestrictionList  authapi.RoleBindingRestrictionList
	OpenshiftRoleBindingRestrictionSpec  authapi.RoleBindingRestrictionSpec
	LocalSubjectAccessReview             authapi.LocalSubjectAccessReview
	LocalResourceAccessReview            authapi.LocalResourceAccessReview
	ResourceAccessReview                 authapi.ResourceAccessReview
	ResourceAccessReviewResponse         authapi.ResourceAccessReviewResponse
	SubjectAccessReview                  authapi.SubjectAccessReview
	SubjectAccessReviewResponse          authapi.SubjectAccessReviewResponse
	SubjectRulesReview                   authapi.SubjectRulesReview
	SelfSubjectRulesReview               authapi.SelfSubjectRulesReview
	OpenshiftClusterRole                 authapi.ClusterRole
	OpenshiftClusterRoleList             authapi.ClusterRoleList
	OpenshiftClusterRoleBinding          authapi.ClusterRoleBinding
	OpenshiftClusterRoleBindingList      authapi.ClusterRoleBindingList
	User                                 userapi.User
	UserList                             userapi.UserList
	Group                                userapi.Group
	GroupList                            userapi.GroupList
	Identity                             userapi.Identity
	IdentityList                         userapi.IdentityList
	UserIdentityMapping                  userapi.UserIdentityMapping
	Config                               configapi.Config
	RootPaths                            metav1.RootPaths
	Project                              projectapi.Project
	ProjectList                          projectapi.ProjectList
	ProjectRequest                       projectapi.ProjectRequest
	// Added JSONSchemaPropsorStringArray here because of
	// https://github.com/joelittlejohn/jsonschema2pojo/issues/866
	AggregationRule                 rbac.AggregationRule
	NetNamespace                    networkapi.NetNamespace
	NetNamespaceList                networkapi.NetNamespaceList
	ClusterNetwork                  networkapi.ClusterNetwork
	ClusterNetworkList              networkapi.ClusterNetworkList
	EgressNetworkPolicy             networkapi.EgressNetworkPolicy
	EgressNetworkPolicyList         networkapi.EgressNetworkPolicyList
	HostSubnet                      networkapi.HostSubnet
	HostSubnetList                  networkapi.HostSubnetList
	AppliedClusterResourceQuota     quotaapi.AppliedClusterResourceQuota
	AppliedClusterResourceQuotaList quotaapi.AppliedClusterResourceQuotaList
	ClusterResourceQuota            quotaapi.ClusterResourceQuota
	ClusterResourceQuotaList        quotaapi.ClusterResourceQuotaList
	HelmChartRepository             helmapiv1beta1.HelmChartRepository
	HelmChartRepositoryList         helmapiv1beta1.HelmChartRepositoryList
}

func main() {
	packages := []schemagen.PackageDescriptor{
		{"k8s.io/api/core/v1", "", "io.fabric8.kubernetes.api.model", "kubernetes_core_", false},
		{"k8s.io/apimachinery/pkg/api/resource", "", "io.fabric8.kubernetes.api.model", "kubernetes_resource_", false},
		{"k8s.io/apimachinery/pkg/util/intstr", "", "io.fabric8.kubernetes.api.model", "kubernetes_apimachinery_pkg_util_intstr_", false},
		{"k8s.io/apimachinery/pkg/runtime", "", "io.fabric8.openshift.api.model.runtime", "kubernetes_apimachinery_pkg_runtime_", false},
		{"k8s.io/apimachinery/pkg/version", "", "io.fabric8.kubernetes.api.model.version", "kubernetes_apimachinery_pkg_version_", false},
		{"k8s.io/kubernetes/pkg/util", "", "io.fabric8.kubernetes.api.model", "kubernetes_util_", false},
		{"k8s.io/kubernetes/pkg/api/errors", "", "io.fabric8.kubernetes.api.model", "kubernetes_errors_", false},
		{"k8s.io/client-go/tools/clientcmd/api/v1", "", "io.fabric8.kubernetes.api.model", "kubernetes_config_", false},
		{"k8s.io/kubernetes/pkg/api/unversioned", "", "io.fabric8.kubernetes.api.model", "api_", false},
		{"k8s.io/api/authentication/v1", "authentication.k8s.io", "io.fabric8.kubernetes.api.model.authentication", "kubernetes_authentication_", false},
		{"k8s.io/apiextensions-apiserver/pkg/apis/apiextensions/v1beta1", "", "io.fabric8.kubernetes.api.model.apiextensions", "kubernetes_apiextensions_", false},
		{"k8s.io/apimachinery/pkg/apis/meta/v1", "", "io.fabric8.kubernetes.api.model", "kubernetes_apimachinery_", false},
		{"k8s.io/api/rbac/v1", "rbac.authorization.k8s.io", "io.fabric8.kubernetes.api.model.rbac", "kubernetes_rbac_", false},
		{"github.com/openshift/api/build/v1", "", "io.fabric8.openshift.api.model", "os_build_", true},
		{"github.com/openshift/api/apps/v1", "", "io.fabric8.openshift.api.model", "os_deploy_", true},
		{"github.com/openshift/api/image/v1", "", "io.fabric8.openshift.api.model", "os_image_", true},
		{"github.com/openshift/api/oauth/v1", "", "io.fabric8.openshift.api.model", "os_oauth_", true},
		{"github.com/openshift/api/route/v1", "", "io.fabric8.openshift.api.model", "os_route_", true},
		{"github.com/openshift/api/template/v1", "", "io.fabric8.openshift.api.model", "os_template_", true},
		{"github.com/openshift/api/user/v1", "", "io.fabric8.openshift.api.model", "os_user_", true},
		{"github.com/openshift/api/authorization/v1", "", "io.fabric8.openshift.api.model", "os_authorization_", true},
		{"github.com/openshift/api/project/v1", "", "io.fabric8.openshift.api.model", "os_project_", true},
		{"github.com/openshift/api/security/v1", "", "io.fabric8.openshift.api.model", "os_security_", true},
		{"github.com/openshift/api/network/v1", "", "io.fabric8.openshift.api.model", "os_network_", true},
		{"github.com/openshift/api/config/v1", "", "io.fabric8.openshift.api.model.config.v1", "os_config_v1_", false},
		{"github.com/openshift/api/quota/v1", "", "io.fabric8.openshift.api.model", "os_quota_", true},
		{"github.com/openshift/api/helm/v1beta1", "", "io.fabric8.openshift.api.model", "os_helm_v1beta1_", true},
	}

	typeMap := map[reflect.Type]reflect.Type{
		reflect.TypeOf(time.Time{}): reflect.TypeOf(""),
		reflect.TypeOf(struct{}{}):  reflect.TypeOf(""),
	}
	schema, err := schemagen.GenerateSchema(reflect.TypeOf(Schema{}), packages, typeMap, map[reflect.Type]string{}, "openshift")
	if err != nil {
		fmt.Fprintf(os.Stderr, "An error occurred: %v", err)
		return
	}

    // maintain the existing mapping
	schema.Resources["image"].Properties["dockerImageMetadata"] = schemagen.JSONPropertyDescriptor{
        ExistingJavaTypeDescriptor: &schemagen.ExistingJavaTypeDescriptor{
            ExistingJavaType: "io.fabric8.openshift.api.model.runtime.RawExtension",
        },
    }
    // top level template objects need to be typed/hasmetadata to do anything
	schema.Resources["template"].Properties["objects"] = schemagen.JSONPropertyDescriptor{
        ExistingJavaTypeDescriptor: &schemagen.ExistingJavaTypeDescriptor{
            ExistingJavaType: "java.util.List<io.fabric8.kubernetes.api.model.HasMetadata>",
        },
    } 

	serdes := map[string]*schemagen.JavaSerDeDescriptor{
		"os_template_Template": &schemagen.JavaSerDeDescriptor{
			Deserializer: "io.fabric8.openshift.api.model.TemplateDeserializer.class",
		},
	}

	for definitionKey, descriptor := range serdes {
		val := schema.Definitions[definitionKey]
		val.JavaSerDeDescriptor = descriptor
		schema.Definitions[definitionKey] = val
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
