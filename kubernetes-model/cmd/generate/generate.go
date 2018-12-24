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
	imageapi "github.com/openshift/api/image/v1"
	networkapi "github.com/openshift/api/network/v1"
	oauthapi "github.com/openshift/api/oauth/v1"
	projectapi "github.com/openshift/api/project/v1"
	routeapi "github.com/openshift/api/route/v1"
	securityapi "github.com/openshift/api/security/v1"
	templateapi "github.com/openshift/api/template/v1"
	userapi "github.com/openshift/api/user/v1"
	k8sappsapi "k8s.io/api/apps/v1"
	authenticationapi "k8s.io/api/authentication/v1"
	k8sauthapi "k8s.io/api/authorization/v1"
        autoscalingapiv2beta1 "k8s.io/api/autoscaling/v2beta1"
	batchapiv1 "k8s.io/api/batch/v1"
	batchapiv1beta1 "k8s.io/api/batch/v1beta1"
	kapi "k8s.io/api/core/v1"
	extensions "k8s.io/api/extensions/v1beta1"
        events "k8s.io/api/events/v1beta1"
	networking "k8s.io/api/networking/v1"
	policy "k8s.io/api/policy/v1beta1"
	rbac "k8s.io/api/rbac/v1"
        settings "k8s.io/api/settings/v1alpha1"
	storageclassapi "k8s.io/api/storage/v1"
	apiextensions "k8s.io/apiextensions-apiserver/pkg/apis/apiextensions/v1beta1"
	resource "k8s.io/apimachinery/pkg/api/resource"
	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
	apimachineryversion "k8s.io/apimachinery/pkg/version"
	configapi "k8s.io/client-go/tools/clientcmd/api/v1"
	watch "k8s.io/kubernetes/pkg/watch/json"
        scheduling "k8s.io/api/scheduling/v1beta1"
        admission "k8s.io/api/admission/v1beta1"
        admissionregistration "k8s.io/api/admissionregistration/v1beta1"
        certificates "k8s.io/api/certificates/v1beta1"
	"log"
	"reflect"
	"strings"
	"time"

	"os"

	"github.com/fabric8io/kubernetes-client/kubernetes-model/pkg/schemagen"
)

type Schema struct {
	Info                                  apimachineryversion.Info
	BaseKubernetesList                    metav1.List
	ObjectMeta                            metav1.ObjectMeta
	TypeMeta                              metav1.TypeMeta
	Initializer                           metav1.Initializer
	Initializers                          metav1.Initializers
	PodList                               kapi.PodList
	PodTemplateList                       kapi.PodTemplateList
	ReplicationControllerList             kapi.ReplicationControllerList
	ServiceList                           kapi.ServiceList
	Endpoints                             kapi.Endpoints
	EndpointsList                         kapi.EndpointsList
	EventList                             kapi.EventList
	Node                                  kapi.Node
	NodeList                              kapi.NodeList
	EnvVar                                kapi.EnvVar
	Namespace                             kapi.Namespace
	NamespaceList                         kapi.NamespaceList
	PersistentVolume                      kapi.PersistentVolume
	PersistentVolumeList                  kapi.PersistentVolumeList
	PersistentVolumeClaim                 kapi.PersistentVolumeClaim
	PersistentVolumeClaimList             kapi.PersistentVolumeClaimList
	ResourceQuota                         kapi.ResourceQuota
	ResourceQuotaList                     kapi.ResourceQuotaList
	Secret                                kapi.Secret
	SecretList                            kapi.SecretList
	SecurityContextConstraints            securityapi.SecurityContextConstraints
	SecurityContextConstraintsList        securityapi.SecurityContextConstraintsList
	ServiceAccount                        kapi.ServiceAccount
	ServiceAccountList                    kapi.ServiceAccountList
	Status                                metav1.Status
	Patch                                 metav1.Patch
	Binding                               kapi.Binding
	LimitRangeList                        kapi.LimitRangeList
	DeleteOptions                         metav1.DeleteOptions
	Quantity                              resource.Quantity
	BuildRequest                          buildapi.BuildRequest
	BuildList                             buildapi.BuildList
	BuildConfigList                       buildapi.BuildConfigList
	ImageList                             imageapi.ImageList
	ImageStreamList                       imageapi.ImageStreamList
	ImageStreamTagList                    imageapi.ImageStreamTagList
	ImageStreamImport                     imageapi.ImageStreamImport
	DeploymentConfig                      appsapi.DeploymentConfig
	DeploymentConfigList                  appsapi.DeploymentConfigList
	Route                                 routeapi.Route
	RouteList                             routeapi.RouteList
	ComponentStatusList                   kapi.ComponentStatusList
	ContainerStatus                       kapi.ContainerStatus
	Template                              templateapi.Template
	TemplateList                          templateapi.TemplateList
	TagEvent                              imageapi.TagEvent
	OAuthClient                           oauthapi.OAuthClient
	OAuthAccessToken                      oauthapi.OAuthAccessToken
	OAuthAuthorizeToken                   oauthapi.OAuthAuthorizeToken
	OAuthClientAuthorization              oauthapi.OAuthClientAuthorization
	OAuthAccessTokenList                  oauthapi.OAuthAccessTokenList
	OAuthAuthorizeTokenList               oauthapi.OAuthAuthorizeTokenList
	OAuthClientList                       oauthapi.OAuthClientList
	OAuthClientAuthorizationList          oauthapi.OAuthClientAuthorizationList
	TokenReview                           authenticationapi.TokenReview
	K8sSubjectAccessReview                k8sauthapi.SubjectAccessReview
	K8sLocalSubjectAccessReview           k8sauthapi.LocalSubjectAccessReview
	OpenshiftRole                         authapi.Role
	OpenshiftRoleList                     authapi.RoleList
	OpenshiftRoleBinding                  authapi.RoleBinding
	OpenshiftRoleBindingList              authapi.RoleBindingList
	OpenshiftRoleBindingRestriction       authapi.RoleBindingRestriction
	LocalSubjectAccessReview              authapi.LocalSubjectAccessReview
	SubjectAccessReview                   authapi.SubjectAccessReview
  SubjectAccessReviewResponse           authapi.SubjectAccessReviewResponse
	OpenshiftClusterRole                  authapi.ClusterRole
	OpenshiftClusterRoleBinding           authapi.ClusterRoleBinding
	OpenshiftClusterRoleBindingList       authapi.ClusterRoleBindingList
	User                                  userapi.User
	UserList                              userapi.UserList
	Group                                 userapi.Group
	GroupList                             userapi.GroupList
	Identity                              userapi.Identity
	IdentityList                          userapi.IdentityList
	Config                                configapi.Config
	WatchEvent                            watch.WatchEvent
	RootPaths                             metav1.RootPaths
	Project                               projectapi.Project
	ProjectList                           projectapi.ProjectList
	ProjectRequest                        projectapi.ProjectRequest
	Job                                   batchapiv1.Job
	JobList                               batchapiv1.JobList
	CronJob                               batchapiv1beta1.CronJob
	CronJobList                           batchapiv1beta1.CronJobList
	Scale                                 extensions.Scale
	HorizontalPodAutoscaler               autoscalingapiv2beta1.HorizontalPodAutoscaler
	HorizontalPodAutoscalerList           autoscalingapiv2beta1.HorizontalPodAutoscalerList
	Deployment                            k8sappsapi.Deployment
	DeploymentList                        k8sappsapi.DeploymentList
	DeploymentRollback                    extensions.DeploymentRollback
	PodSecurityPolicy                     extensions.PodSecurityPolicy
	PodSecurityPolicyList                 extensions.PodSecurityPolicyList
	PodDisruptionBudget                   policy.PodDisruptionBudget
	PodDisruptionBudgetList               policy.PodDisruptionBudgetList
	StatefulSet                           k8sappsapi.StatefulSet
	StatefulSetList                       k8sappsapi.StatefulSetList
	DaemonSet                             k8sappsapi.DaemonSet
	DaemonSetList                         k8sappsapi.DaemonSetList
	Ingress                               extensions.Ingress
	IngressList                           extensions.IngressList
	ReplicaSet                            k8sappsapi.ReplicaSet
	ReplicaSetList                        k8sappsapi.ReplicaSetList
	NetworkPolicy                         networking.NetworkPolicy
	NetworkPolicyList                     networking.NetworkPolicyList
	ConfigMap                             kapi.ConfigMap
	ConfigMapList                         kapi.ConfigMapList
	Toleration                            kapi.Toleration
	CustomResourceDefinition              apiextensions.CustomResourceDefinition
	CustomResourceDefinitionList          apiextensions.CustomResourceDefinitionList
	CustomResourceDefinitionSpec          apiextensions.CustomResourceDefinitionSpec
	CustomResourceDefinitionNames         apiextensions.CustomResourceDefinitionNames
	CustomResourceDefinitionCondition     apiextensions.CustomResourceDefinitionCondition
	CustomResourceDefinitionStatus        apiextensions.CustomResourceDefinitionStatus
	// Added JSONSchemaPropsorStringArray here because of
	// https://github.com/joelittlejohn/jsonschema2pojo/issues/866
	JSONSchemaPropsorStringArray          apiextensions.JSONSchemaPropsOrStringArray
	StorageClass                          storageclassapi.StorageClass
	StorageClassList                      storageclassapi.StorageClassList
	AggregationRule                       rbac.AggregationRule
	Role                                  rbac.Role
	RoleList                              rbac.RoleList
	RoleBinding                           rbac.RoleBinding
	RoleBindingList                       rbac.RoleBindingList
	NetNameSpace                          networkapi.NetNamespace
	NetNameSpaceList                      networkapi.NetNamespaceList
	ClusterRole                           rbac.ClusterRole
	ClusterRoleList                       rbac.ClusterRoleList
	ClusterRoleBinding                    rbac.ClusterRoleBinding
	ClusterRoleBindingList                rbac.ClusterRoleBindingList
  PodPreset                             settings.PodPreset
  PodPresetSpec                         settings.PodPresetSpec
  PodPresetList                         settings.PodPresetList
  PriorityClass                         scheduling.PriorityClass
  PriorityClassList                     scheduling.PriorityClassList
  Event                                 events.Event
  EventSeries                           events.EventSeries
  EventSeriesState                      events.EventSeriesState
  AdmissionReview                       admission.AdmissionReview
  AdmissionRequest                      admission.AdmissionRequest
  AdmissionResponse                     admission.AdmissionResponse
  PatchType                             admission.PatchType
  Operation                             admission.Operation
  Rule                                  admissionregistration.Rule
  ValidatingWebhookConfiguration        admissionregistration.ValidatingWebhookConfiguration
  ValidatingWebhookConfigurationList    admissionregistration.ValidatingWebhookConfigurationList
  MutatingWebhookConfiguration          admissionregistration.MutatingWebhookConfiguration
  MutatingWebhookConfigurationList      admissionregistration.MutatingWebhookConfigurationList
  AdmissionWebhook                      admissionregistration.Webhook
  RuleWithOperations                    admissionregistration.RuleWithOperations
  CertificateSigningRequest             certificates.CertificateSigningRequest
  CertificateSigningRequestSpec         certificates.CertificateSigningRequestSpec
  CertificateSigningRequestStatus       certificates.CertificateSigningRequestStatus
  CertificateSigningRequestCondition    certificates.CertificateSigningRequestCondition
  CertificateSigningRequestList         certificates.CertificateSigningRequestList
}

func main() {
	packages := []schemagen.PackageDescriptor{
		{"k8s.io/api/core/v1", "", "io.fabric8.kubernetes.api.model", "kubernetes_core_"},
		{"k8s.io/apimachinery/pkg/api/resource", "", "io.fabric8.kubernetes.api.model", "kubernetes_resource_"},
		{"k8s.io/apimachinery/pkg/util/intstr", "", "io.fabric8.kubernetes.api.model", "kubernetes_apimachinery_pkg_util_intstr_"},
		{"k8s.io/apimachinery/pkg/runtime", "", "io.fabric8.kubernetes.api.model.runtime", "kubernetes_apimachinery_pkg_runtime_"},
		{"k8s.io/apimachinery/pkg/version", "", "io.fabric8.kubernetes.api.model.version", "kubernetes_apimachinery_pkg_version_"},
		{"k8s.io/kubernetes/pkg/util", "", "io.fabric8.kubernetes.api.model", "kubernetes_util_"},
		{"k8s.io/kubernetes/pkg/watch/json", "", "io.fabric8.kubernetes.api.model", "kubernetes_watch_"},
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
		{"k8s.io/kubernetes/pkg/api/unversioned", "", "io.fabric8.kubernetes.api.model", "api_"},
		{"k8s.io/api/extensions/v1beta1", "", "io.fabric8.kubernetes.api.model.extensions", "kubernetes_extensions_"},
		{"k8s.io/api/policy/v1beta1", "", "io.fabric8.kubernetes.api.model.policy", "kubernetes_policy_"},
		{"k8s.io/api/authentication/v1", "authentication.k8s.io", "io.fabric8.kubernetes.api.model.authentication", "kubernetes_authentication_"},
		{"k8s.io/api/authorization/v1", "authorization.k8s.io", "io.fabric8.kubernetes.api.model.authorization", "kubernetes_authorization_"},
		{"k8s.io/api/apps/v1", "", "io.fabric8.kubernetes.api.model.apps", "kubernetes_apps_"},
		{"k8s.io/api/batch/v1beta1", "", "io.fabric8.kubernetes.api.model.batch", "kubernetes_batch_"},
		{"k8s.io/api/batch/v1", "", "io.fabric8.kubernetes.api.model.batch", "kubernetes_batch_"},
		{"k8s.io/api/autoscaling/v2beta1", "", "io.fabric8.kubernetes.api.model", "kubernetes_autoscaling_"},
		{"k8s.io/apiextensions-apiserver/pkg/apis/apiextensions/v1beta1", "", "io.fabric8.kubernetes.api.model.apiextensions", "kubernetes_apiextensions_"},
		{"k8s.io/apimachinery/pkg/apis/meta/v1", "", "io.fabric8.kubernetes.api.model", "kubernetes_apimachinery_"},
		{"k8s.io/api/networking/v1", "networking.k8s.io", "io.fabric8.kubernetes.api.model.networking", "kubernetes_networking_"},
		{"k8s.io/api/storage/v1", "storage.k8s.io", "io.fabric8.kubernetes.api.model.storage", "kubernetes_storageclass_"},
		{"k8s.io/api/rbac/v1", "rbac.authorization.k8s.io", "io.fabric8.kubernetes.api.model.rbac", "kubernetes_rbac_"},
                {"k8s.io/api/settings/v1alpha1", "settings.k8s.io", "io.fabric8.kubernetes.api.model.settings", "kubernetes_settings_"},
		{"k8s.io/api/scheduling/v1beta1", "scheduling.k8s.io", "io.fabric8.kubernetes.api.model.scheduling", "kubernetes_scheduling_"},
		{"k8s.io/api/events/v1beta1", "events.k8s.io", "io.fabric8.kubernetes.api.model.events", "kubernetes_events_"},
		{"k8s.io/api/admission/v1beta1", "admission.k8s.io", "io.fabric8.kubernetes.api.model.admission", "kubernetes_admission_"},
		{"k8s.io/api/admissionregistration/v1beta1", "admissionregistration.k8s.io", "io.fabric8.kubernetes.api.model.admissionregistration", "kubernetes_admissionregistration_"},
		{"k8s.io/api/certificates/v1beta1", "certificates.k8s.io", "io.fabric8.kubernetes.api.model.certificates", "kubernetes_certificates_"},
	}

	typeMap := map[reflect.Type]reflect.Type{
		reflect.TypeOf(time.Time{}): reflect.TypeOf(""),
		reflect.TypeOf(struct{}{}):  reflect.TypeOf(""),
	}
	schema, err := schemagen.GenerateSchema(reflect.TypeOf(Schema{}), packages, typeMap)
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
