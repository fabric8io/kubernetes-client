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

  flowcontrolv1alpha1 "k8s.io/api/flowcontrol/v1alpha1"
  flowcontrolv1beta1 "k8s.io/api/flowcontrol/v1beta1"
  flowcontrolv1beta2 "k8s.io/api/flowcontrol/v1beta2"
  flowcontrolv1beta3 "k8s.io/api/flowcontrol/v1beta3"
  apiserverinternalv1alpha1 "k8s.io/api/apiserverinternal/v1alpha1"


  "log"
  "reflect"
  "strings"
  "time"

  "os"

  "github.com/fabric8io/kubernetes-client/kubernetes-model-generator/pkg/schemagen"
)

type Schema struct {
  V1alpha1FlowSchema                       flowcontrolv1alpha1.FlowSchema
  V1alpha1FlowSchemaList                   flowcontrolv1alpha1.FlowSchemaList
  V1alpha1PriorityLevelConfiguration       flowcontrolv1alpha1.PriorityLevelConfiguration
  V1alpha1PriorityLevelConfigurationList   flowcontrolv1alpha1.PriorityLevelConfigurationList
  V1beta1FlowSchema                        flowcontrolv1beta1.FlowSchema
  V1beta1FlowSchemaList                    flowcontrolv1beta1.FlowSchemaList
  V1beta1PriorityLevelConfiguration        flowcontrolv1beta1.PriorityLevelConfiguration
  V1beta1PriorityLevelConfigurationList    flowcontrolv1beta1.PriorityLevelConfigurationList
  V1beta2FlowSchema                        flowcontrolv1beta2.FlowSchema
  V1beta2FlowSchemaList                    flowcontrolv1beta2.FlowSchemaList
  V1beta2PriorityLevelConfiguration        flowcontrolv1beta2.PriorityLevelConfiguration
  V1beta2PriorityLevelConfigurationList    flowcontrolv1beta2.PriorityLevelConfigurationList
  V1beta3FlowSchema                        flowcontrolv1beta3.FlowSchema
  V1beta3FlowSchemaList                    flowcontrolv1beta3.FlowSchemaList
  V1beta3PriorityLevelConfiguration        flowcontrolv1beta3.PriorityLevelConfiguration
  V1beta3PriorityLevelConfigurationList    flowcontrolv1beta3.PriorityLevelConfigurationList
  V1Alpha1StorageVersion                   apiserverinternalv1alpha1.StorageVersion
  V1Alpha1StorageVersionList               apiserverinternalv1alpha1.StorageVersionList
}

func main() {
  packages := []schemagen.PackageDescriptor{
    {"k8s.io/apimachinery/pkg/util/intstr", "", "io.fabric8.kubernetes.api.model", "kubernetes_apimachinery_pkg_util_intstr_", false},
    {"k8s.io/apimachinery/pkg/runtime", "", "io.fabric8.kubernetes.api.model.runtime", "kubernetes_apimachinery_pkg_runtime_", false},
    {"k8s.io/apimachinery/pkg/version", "", "io.fabric8.kubernetes.api.model.version", "kubernetes_apimachinery_pkg_version_", false},
    {"k8s.io/apimachinery/pkg/apis/meta/v1", "", "io.fabric8.kubernetes.api.model", "kubernetes_apimachinery_", false},
    {"k8s.io/api/core/v1", "", "io.fabric8.kubernetes.api.model", "kubernetes_core_", false},
    {"k8s.io/api/flowcontrol/v1alpha1", "flowcontrol.apiserver.k8s.io", "io.fabric8.kubernetes.api.model.flowcontrol.v1alpha1", "kubernetes_flowcontrol_v1alpha1_", true},
    {"k8s.io/api/flowcontrol/v1beta1", "flowcontrol.apiserver.k8s.io", "io.fabric8.kubernetes.api.model.flowcontrol.v1beta1", "kubernetes_flowcontrol_v1beta1_", true},
    {"k8s.io/api/flowcontrol/v1beta2", "flowcontrol.apiserver.k8s.io", "io.fabric8.kubernetes.api.model.flowcontrol.v1beta2", "kubernetes_flowcontrol_v1beta2_", true},
    {"k8s.io/api/flowcontrol/v1beta3", "flowcontrol.apiserver.k8s.io", "io.fabric8.kubernetes.api.model.flowcontrol.v1beta3", "kubernetes_flowcontrol_v1beta3_", true},
    {"k8s.io/api/apiserverinternal/v1alpha1", "internal.apiserver.k8s.io", "io.fabric8.kubernetes.api.model.internal.apiserver.v1alpha1", "kubernetes_internal_apiserver_v1alpha1_", true},
  }

  typeMap := map[reflect.Type]reflect.Type{
    reflect.TypeOf(time.Time{}): reflect.TypeOf(""),
    reflect.TypeOf(struct{}{}):  reflect.TypeOf(""),
  }
  schema, err := schemagen.GenerateSchema(reflect.TypeOf(Schema{}), packages, typeMap, map[reflect.Type]string{},"flowcontrol")
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
