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

	kapi "k8s.io/api/core/v1"
	"k8s.io/apimachinery/pkg/api/resource"
	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
	"k8s.io/apimachinery/pkg/runtime"
	apimachineryversion "k8s.io/apimachinery/pkg/version"
	configapi "k8s.io/client-go/tools/clientcmd/api/v1"
	aggregator "k8s.io/kube-aggregator/pkg/apis/apiregistration/v1"

	"os"

	"github.com/fabric8io/kubernetes-client/kubernetes-model-generator/pkg/schemagen"
)

type Schema struct {
	Info                 apimachineryversion.Info
	APIGroup             metav1.APIGroup
	APIGroupList         metav1.APIGroupList
	APIResource          metav1.APIResource
	APIResourceList      metav1.APIResourceList
	BaseKubernetesList   metav1.List
	ObjectMeta           metav1.ObjectMeta
	TypeMeta             metav1.TypeMeta
	Status               metav1.Status
	Patch                metav1.Patch
	ListOptions          metav1.ListOptions
	DeleteOptions        metav1.DeleteOptions
	CreateOptions        metav1.CreateOptions
	UpdateOptions        metav1.UpdateOptions
	GetOptions           metav1.GetOptions
	PatchOptions         metav1.PatchOptions
	Time                 metav1.Time
	MicroTime            metav1.MicroTime
	RootPaths            metav1.RootPaths
	GroupKind            metav1.GroupKind
	GroupVersionKind     metav1.GroupVersionKind
	GroupVersionResource metav1.GroupVersionResource
	Quantity             resource.Quantity
	Condition            metav1.Condition
	WatchEvent           metav1.WatchEvent

	PodList                   kapi.PodList
	PodTemplateList           kapi.PodTemplateList
	PodExecOptions            kapi.PodExecOptions
	ReplicationControllerList kapi.ReplicationControllerList
	ServiceList               kapi.ServiceList
	EndpointPort              kapi.EndpointPort
	Endpoints                 kapi.Endpoints
	EndpointsList             kapi.EndpointsList
	Node                      kapi.Node
	NodeList                  kapi.NodeList
	EnvVar                    kapi.EnvVar
	Event                     kapi.Event
	EventList                 kapi.EventList
	EventSeries               kapi.EventSeries
	EventSource               kapi.EventSource
	Namespace                 kapi.Namespace
	NamespaceList             kapi.NamespaceList
	PersistentVolume          kapi.PersistentVolume
	PersistentVolumeList      kapi.PersistentVolumeList
	PersistentVolumeClaim     kapi.PersistentVolumeClaim
	PersistentVolumeClaimList kapi.PersistentVolumeClaimList
	ResourceQuota             kapi.ResourceQuota
	ResourceQuotaList         kapi.ResourceQuotaList
	Secret                    kapi.Secret
	SecretList                kapi.SecretList
	ServiceAccount            kapi.ServiceAccount
	ServiceAccountList        kapi.ServiceAccountList
	Binding                   kapi.Binding
	LimitRangeList            kapi.LimitRangeList
	ComponentStatus           kapi.ComponentStatus
	ComponentStatusList       kapi.ComponentStatusList
	ContainerStatus           kapi.ContainerStatus
	ConfigMap                 kapi.ConfigMap
	ConfigMapList             kapi.ConfigMapList
	Toleration                kapi.Toleration
	TopologySelectorTerm      kapi.TopologySelectorTerm
	Config                    configapi.Config
	APIService                aggregator.APIService
	APIServiceList            aggregator.APIServiceList
}

func main() {
	packages := []schemagen.PackageDescriptor{
		{"k8s.io/apimachinery/pkg/api/resource", "", "io.fabric8.kubernetes.api.model", "kubernetes_resource_", true},
		{"k8s.io/apimachinery/pkg/util/intstr", "", "io.fabric8.kubernetes.api.model", "kubernetes_apimachinery_pkg_util_intstr_", true},
		{"k8s.io/apimachinery/pkg/runtime", "", "io.fabric8.kubernetes.api.model.runtime", "kubernetes_apimachinery_pkg_runtime_", true},
		{"k8s.io/apimachinery/pkg/version", "", "io.fabric8.kubernetes.api.model.version", "kubernetes_apimachinery_pkg_version_", true},
		{"k8s.io/apimachinery/pkg/apis/meta/v1", "", "io.fabric8.kubernetes.api.model", "kubernetes_apimachinery_pkg_apis_", true},
		{"k8s.io/api/core/v1", "", "io.fabric8.kubernetes.api.model", "kubernetes_core_", true},
		{"k8s.io/kubernetes/pkg/util", "", "io.fabric8.kubernetes.api.model", "kubernetes_util_", true},
		{"k8s.io/kubernetes/pkg/api/errors", "", "io.fabric8.kubernetes.api.model", "kubernetes_errors_", true},
		{"k8s.io/client-go/tools/clientcmd/api/v1", "", "io.fabric8.kubernetes.api.model", "kubernetes_config_", true},
		{"k8s.io/kubernetes/pkg/api/unversioned", "", "io.fabric8.kubernetes.api.model", "api_", true},
		{"k8s.io/api/authentication/v1", "authentication.k8s.io", "io.fabric8.kubernetes.api.model.authentication", "kubernetes_authentication_", true},
		{"k8s.io/kube-aggregator/pkg/apis/apiregistration/v1", "apiregistration.k8s.io", "io.fabric8.kubernetes.api.model", "kubernetes_aggregator_", true},
	}

	typeMap := map[reflect.Type]reflect.Type{
		reflect.TypeOf(time.Time{}): reflect.TypeOf(""),
		reflect.TypeOf(struct{}{}):  reflect.TypeOf(""),
	}

	//	default the core raw to HasMetadata, rather than KubernetesResource
	manualTypeMap := map[reflect.Type]string{
		reflect.TypeOf(runtime.RawExtension{}): "io.fabric8.kubernetes.api.model.HasMetadata",
	}

	schema, err := schemagen.GenerateSchema(reflect.TypeOf(Schema{}), packages, typeMap, manualTypeMap, "core")
	if err != nil {
		fmt.Fprintf(os.Stderr, "An error occurred: %v", err)
		return
	}

	// since we default to HasMetadata we need specific overrides for watchevent and namedextension
	resourceProp := schemagen.JSONPropertyDescriptor{
		ExistingJavaTypeDescriptor: &schemagen.ExistingJavaTypeDescriptor{
			ExistingJavaType: "io.fabric8.kubernetes.api.model.KubernetesResource",
		},
	}
	schema.Resources["watchevent"].Properties["object"] = resourceProp
	schema.Resources["namedextension"].Properties["extension"] = resourceProp

	serdes := map[string]*schemagen.JavaSerDeDescriptor{
		"kubernetes_apimachinery_pkg_apis_MicroTime": &schemagen.JavaSerDeDescriptor{
			Serializer:   "io.fabric8.kubernetes.api.model.MicroTimeSerDes.Serializer.class",
			Deserializer: "io.fabric8.kubernetes.api.model.MicroTimeSerDes.Deserializer.class",
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
