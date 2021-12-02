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
  metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
  apimachineryversion "k8s.io/apimachinery/pkg/version"
  runtime "k8s.io/apimachinery/pkg/runtime"
  "log"
  "reflect"
  "strings"
  "time"

  "os"
  cloudcredential "github.com/openshift/cloud-credential-operator/pkg/apis/cloudcredential/v1"
  networkattachment "github.com/k8snetworkplumbingwg/network-attachment-definition-client/pkg/apis/k8s.cni.cncf.io/v1"
  baremetal "github.com/metal3-io/baremetal-operator/apis/metal3.io/v1alpha1"
  clusternetworkoperator "github.com/openshift/cluster-network-operator/pkg/apis/network/v1"
  networkoperator "github.com/openshift/api/networkoperator/v1"
  apiserver "github.com/openshift/api/apiserver/v1"
  imageregistry "github.com/openshift/api/imageregistry/v1"
  operatorv1 "github.com/openshift/api/operator/v1"

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
  CredentialsRequest                       cloudcredential.CredentialsRequest
  CredentialsRequestList                   cloudcredential.CredentialsRequestList
  NetworkAttachmentDefinition              networkattachment.NetworkAttachmentDefinition
  NetworkAttachmentDefinitionList          networkattachment.NetworkAttachmentDefinitionList
  BareMetalHost                            baremetal.BareMetalHost
  BareMetalHostList                        baremetal.BareMetalHostList
  OperatorPKI                              clusternetworkoperator.OperatorPKI
  OperatorPKIList                          clusternetworkoperator.OperatorPKIList
  EgressRouter                             networkoperator.EgressRouter
  EgressRouterList                         networkoperator.EgressRouterList
  Config                                   imageregistry.Config
  ConfigList                               imageregistry.ConfigList
  APIRequestCount                          apiserver.APIRequestCount
  APIRequestCountList                      apiserver.APIRequestCountList
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
    {"github.com/openshift/api/config/v1", "", "io.fabric8.openshift.api.model", "os_config_v1_", false},
    {"github.com/openshift/cloud-credential-operator/pkg/apis/cloudcredential/v1", "cloudcredential", "io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1", "os_cloudcredential_v1_", true},
    {"github.com/k8snetworkplumbingwg/network-attachment-definition-client/pkg/apis/k8s.cni.cncf.io/v1", "k8s.cni.cncf.io", "io.fabric8.openshift.api.model.miscellaneous.cncf.cni.v1", "os_cncf_cni_v1_", true},
    {"github.com/metal3-io/baremetal-operator/apis/metal3.io/v1alpha1", "metal3.io", "io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1", "os_metal3_v1alpha1_", true},
    {"github.com/openshift/cluster-network-operator/pkg/apis/network/v1", "network.operator", "io.fabric8.openshift.api.model.miscellaneous.network.operator.v1", "os_network_operator_v1_", true},
    {"github.com/openshift/api/networkoperator/v1", "network.operator", "io.fabric8.openshift.api.model.miscellaneous.network.operator.v1", "os_network_operator_v1_", true},
    {"github.com/openshift/api/imageregistry/v1", "imageregistry.operator", "io.fabric8.openshift.api.model.miscellaneous.imageregistry.operator.v1", "os_imageregistry_v1_", true},
    {"github.com/openshift/api/apiserver/v1", "apiserver", "io.fabric8.openshift.api.model.miscellaneous.apiserver.v1", "os_apiserver_v1_", true},
  }

  typeMap := map[reflect.Type]reflect.Type{
    reflect.TypeOf(time.Time{}): reflect.TypeOf(""),
    reflect.TypeOf(struct{}{}):  reflect.TypeOf(""),
  }
  manualTypeMap := map[reflect.Type]string {
    reflect.TypeOf(runtime.RawExtension{}): "java.util.Map<String, Object>",
    reflect.TypeOf(operatorv1.GenerationStatus{}): "io.fabric8.openshift.api.model.operator.v1.GenerationStatus",
    reflect.TypeOf(operatorv1.OperatorCondition{}): "io.fabric8.openshift.api.model.operator.v1.OperatorCondition",
  }
  schema, err := schemagen.GenerateSchema(reflect.TypeOf(Schema{}), packages, typeMap, manualTypeMap,"miscellaneous")
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
