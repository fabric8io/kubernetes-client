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
  // Dependencies of rbac
  metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
  "k8s.io/apimachinery/pkg/api/resource"
  apimachineryversion "k8s.io/apimachinery/pkg/version"

  autoscalingapiv2 "k8s.io/api/autoscaling/v2"
  autoscalingapiv1 "k8s.io/api/autoscaling/v1"
  autoscalingapiv2beta1 "k8s.io/api/autoscaling/v2beta1"
  autoscalingapiv2beta2 "k8s.io/api/autoscaling/v2beta2"

  "log"
  "reflect"
  "strings"
  "time"

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
  ListOptions                              metav1.ListOptions
  DeleteOptions                            metav1.DeleteOptions
  CreateOptions                            metav1.CreateOptions
  UpdateOptions                            metav1.UpdateOptions
  GetOptions                               metav1.GetOptions
  PatchOptions                             metav1.PatchOptions
  Time                                     metav1.Time
  RootPaths                                metav1.RootPaths
  Quantity                                 resource.Quantity

  Scale                                    autoscalingapiv1.Scale
  V2HorizontalPodAutoscaler                autoscalingapiv2.HorizontalPodAutoscaler
  V2HorizontalPodAutoscalerList            autoscalingapiv2.HorizontalPodAutoscalerList
  V1HorizontalPodAutoscaler                autoscalingapiv1.HorizontalPodAutoscaler
  V1HorizontalPodAutoscalerList            autoscalingapiv1.HorizontalPodAutoscalerList
  V2beta1HorizontalPodAutoscaler           autoscalingapiv2beta1.HorizontalPodAutoscaler
  V2beta1HorizontalPodAutoscalerList       autoscalingapiv2beta1.HorizontalPodAutoscalerList
  V2beta2HorizontalPodAutoscaler           autoscalingapiv2beta2.HorizontalPodAutoscaler
  V2beta2HorizontalPodAutoscalerList       autoscalingapiv2beta2.HorizontalPodAutoscalerList
}

func main() {
  packages := []schemagen.PackageDescriptor{
    {"k8s.io/apimachinery/pkg/util/intstr", "", "io.fabric8.kubernetes.api.model", "kubernetes_apimachinery_pkg_util_intstr_", false},
    {"k8s.io/apimachinery/pkg/runtime", "", "io.fabric8.kubernetes.api.model.runtime", "kubernetes_apimachinery_pkg_runtime_", false},
    {"k8s.io/apimachinery/pkg/version", "", "io.fabric8.kubernetes.api.model.version", "kubernetes_apimachinery_pkg_version_", false},
    {"k8s.io/apimachinery/pkg/apis/meta/v1", "", "io.fabric8.kubernetes.api.model", "kubernetes_apimachinery_", false},
    {"k8s.io/apimachinery/pkg/api/resource", "", "io.fabric8.kubernetes.api.model", "kubernetes_resource_", false},
    {"k8s.io/api/autoscaling/v2beta2", "autoscaling", "io.fabric8.kubernetes.api.model.autoscaling.v2beta2", "kubernetes_autoscaling_v2beta2_", true},
    {"k8s.io/api/autoscaling/v2beta1", "autoscaling", "io.fabric8.kubernetes.api.model.autoscaling.v2beta1", "kubernetes_autoscaling_v2beta1_", true},
    {"k8s.io/api/autoscaling/v1", "autoscaling", "io.fabric8.kubernetes.api.model.autoscaling.v1", "kubernetes_autoscaling_v1_", true},
    {"k8s.io/api/autoscaling/v2", "autoscaling", "io.fabric8.kubernetes.api.model.autoscaling.v2", "kubernetes_autoscaling_v2_", true},
  }

  typeMap := map[reflect.Type]reflect.Type{
    reflect.TypeOf(time.Time{}): reflect.TypeOf(""),
    reflect.TypeOf(struct{}{}):  reflect.TypeOf(""),
  }
  schema, err := schemagen.GenerateSchema(reflect.TypeOf(Schema{}), packages, typeMap, map[reflect.Type]string{},"autoscaling")
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
