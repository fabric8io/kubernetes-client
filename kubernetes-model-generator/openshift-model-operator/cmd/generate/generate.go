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
  "k8s.io/apimachinery/pkg/api/resource"
  metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
  apimachineryversion "k8s.io/apimachinery/pkg/version"
  "log"
  "reflect"
  "strings"
  "time"
  imageregistry "github.com/openshift/api/imageregistry/v1"
  openshiftconfigapi "github.com/openshift/api/config/v1"
  operatorv1 "github.com/openshift/api/operator/v1"
  operatorv1alpha1 "github.com/openshift/api/operator/v1alpha1"
  operatoringressv1 "github.com/openshift/api/operatoringress/v1"
  operatorcontrolpanev1alpha1 "github.com/openshift/api/operatorcontrolplane/v1alpha1"
  authorizationv1 "k8s.io/api/authorization/v1"

  "os"

  "github.com/fabric8io/kubernetes-client/kubernetes-model-generator/pkg/schemagen"
)

type Schema struct {
  Info                                     apimachineryversion.Info
  APIGroup                                 metav1.APIGroup
  APIGroupList                             metav1.APIGroupList
  BaseKubernetesList                       metav1.List
  ObjectMeta                               metav1.ObjectMeta
  TypeMeta                                 metav1.TypeMeta
  Status                                   metav1.Status
  Patch                                    metav1.Patch
  Time                                     metav1.Time
  Quantity                                 resource.Quantity
  SecretNameReference                      openshiftconfigapi.SecretNameReference
  ConfigMapFileReference                   openshiftconfigapi.ConfigMapFileReference
  Authentication                           operatorv1.Authentication
  AuthenticationList                       operatorv1.AuthenticationList
  Console                                  operatorv1.Console
  ConsoleList                              operatorv1.ConsoleList
  CSISnapshotController                    operatorv1.CSISnapshotController
  CSISnapshotControllerList                operatorv1.CSISnapshotControllerList
  DNS                                      operatorv1.DNS
  DNSList                                  operatorv1.DNSList
  Etcd                                     operatorv1.Etcd
  EtcdList                                 operatorv1.EtcdList
  IngressController                        operatorv1.IngressController
  IngressControllerList                    operatorv1.IngressControllerList
  KubeAPIServer                            operatorv1.KubeAPIServer
  KubeAPIServerList                        operatorv1.KubeAPIServerList
  KubeControllerManager                    operatorv1.KubeControllerManager
  KubeControllerManagerList                operatorv1.KubeControllerManagerList
  KubeScheduler                            operatorv1.KubeScheduler
  KubeSchedulerList                        operatorv1.KubeSchedulerList
  KubeStorageVersionMigrator               operatorv1.KubeStorageVersionMigrator
  KubeStorageVersionMigratorList           operatorv1.KubeStorageVersionMigratorList
  Network                                  operatorv1.Network
  NetworkList                              operatorv1.NetworkList
  OpenShiftAPIServer                       operatorv1.OpenShiftAPIServer
  OpenShiftAPIServerList                   operatorv1.OpenShiftAPIServerList
  OpenShiftContollerManager                operatorv1.OpenShiftControllerManager
  OpenShiftControllerManagerList           operatorv1.OpenShiftControllerManagerList
  CloudCredential                          operatorv1.CloudCredential
  CloudCredentialList                      operatorv1.CloudCredentialList
  ClusterCSIDriver                         operatorv1.ClusterCSIDriver
  ClusterCSIDriverList                     operatorv1.ClusterCSIDriverList
  Config                                   operatorv1.Config
  ConfigList                               operatorv1.ConfigList
  ServiceCA                                operatorv1.ServiceCA
  ServiceCAList                            operatorv1.ServiceCAList
  ServiceCatalogAPIServer                  operatorv1.ServiceCatalogAPIServer
  ServiceCatalogAPIServerList              operatorv1.ServiceCatalogAPIServerList
  ServiceCatalogControllerManager          operatorv1.ServiceCatalogControllerManager
  ServiceCatalogControllerManagerList      operatorv1.ServiceCatalogControllerManagerList
  Storage                                  operatorv1.Storage
  StorageList                              operatorv1.StorageList
  DNSRecord                                operatoringressv1.DNSRecord
  DNSRecordList                            operatoringressv1.DNSRecordList
  ImageContentSourcePolicy                 operatorv1alpha1.ImageContentSourcePolicy
  ImageContentSourcePolicyList             operatorv1alpha1.ImageContentSourcePolicyList
  ImagePruner                              imageregistry.ImagePruner
  ImagePrunerList                          imageregistry.ImagePrunerList
  PodNetworkConnectivityCheck              operatorcontrolpanev1alpha1.PodNetworkConnectivityCheck
  PodNetworkConnectivityCheckList          operatorcontrolpanev1alpha1.PodNetworkConnectivityCheckList
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
    {"k8s.io/kubernetes/pkg/api/unversioned", "", "io.fabric8.kubernetes.api.model", "api_", false},
    {"k8s.io/apimachinery/pkg/apis/meta/v1", "", "io.fabric8.kubernetes.api.model", "kubernetes_apimachinery_", false},
    {"github.com/openshift/api/config/v1", "", "io.fabric8.openshift.api.model.config.v1", "os_config_v1_", false},
    {"github.com/openshift/api/operator/v1", "", "io.fabric8.openshift.api.model.operator.v1", "os_operator_v1_", true},
    {"github.com/openshift/api/operator/v1alpha1", "", "io.fabric8.openshift.api.model.operator.v1alpha1", "os_operator_v1alpha1_", true},
    {"github.com/openshift/api/imageregistry/v1", "imageregistry.operator", "io.fabric8.openshift.api.model.operator.v1", "os_imageregistry_v1_", true},
    {"github.com/openshift/api/operatoringress/v1", "ingress.operator", "io.fabric8.openshift.api.model.operator.v1", "os_operator_v1_", true},
    {"github.com/openshift/api/operatorcontrolplane/v1alpha1", "controlplane.operator", "io.fabric8.openshift.api.model.operator.controlplane.v1alpha1", "os_operator_controlpane_v1alpha1_", true},
	}

  typeMap := map[reflect.Type]reflect.Type{
    reflect.TypeOf(time.Time{}): reflect.TypeOf(""),
    reflect.TypeOf(struct{}{}):  reflect.TypeOf(""),
  }
  manualTypeMap := map[reflect.Type]string {
    reflect.TypeOf(authorizationv1.ResourceAttributes{}): "io.fabric8.kubernetes.api.model.authorization.v1.ResourceAttributes",
  }
  schema, err := schemagen.GenerateSchema(reflect.TypeOf(Schema{}), packages, typeMap, manualTypeMap,"operator")
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
