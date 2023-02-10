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
  v1alpha2gwapi "sigs.k8s.io/gateway-api/apis/v1alpha2"
  v1beta1gwapi "sigs.k8s.io/gateway-api/apis/v1beta1"

  "log"
  "reflect"
  "strings"
  "time"

  "os"

  "github.com/fabric8io/kubernetes-client/kubernetes-model-generator/pkg/schemagen"
)

type Schema struct {
  Gateway                                  v1alpha2gwapi.Gateway
  GatewayList                              v1alpha2gwapi.GatewayList
  GatewayClass                             v1alpha2gwapi.GatewayClass
  GatewayClassList                         v1alpha2gwapi.GatewayClassList
  HTTPRoute                                v1alpha2gwapi.HTTPRoute
  HTTPRouteList                            v1alpha2gwapi.HTTPRouteList
  ReferenceGrant                           v1alpha2gwapi.ReferenceGrant
  ReferenceGrantList                       v1alpha2gwapi.ReferenceGrantList
  TCPRoute                                 v1alpha2gwapi.TCPRoute
  TCPRouteList                             v1alpha2gwapi.TCPRouteList
  TLSRoute                                 v1alpha2gwapi.TLSRoute
  TLSRouteList                             v1alpha2gwapi.TLSRouteList
  UDPRoute                                 v1alpha2gwapi.UDPRoute
  UDPRouteList                             v1alpha2gwapi.UDPRouteList
  GRPCRoute                                v1alpha2gwapi.GRPCRoute
  GRPCRouteList                            v1alpha2gwapi.GRPCRouteList
  V1Beta1Gateway                           v1beta1gwapi.Gateway
  V1Beta1GatewayList                       v1beta1gwapi.GatewayList
  V1Beta1GatewayClass                      v1beta1gwapi.GatewayClass
  V1Beta1GatewayClassList                  v1beta1gwapi.GatewayClassList
  V1Beta1HTTPRoute                         v1beta1gwapi.HTTPRoute
  V1Beta1HTTPRouteList                     v1beta1gwapi.HTTPRouteList
  V1Beta1ReferenceGrant                    v1beta1gwapi.ReferenceGrant
  V1Beta1ReferenceGrantList                v1beta1gwapi.ReferenceGrantList
}

func main() {
  packages := []schemagen.PackageDescriptor{
    {"k8s.io/apimachinery/pkg/api/resource", "", "io.fabric8.kubernetes.api.model", "kubernetes_resource_", false},
    {"k8s.io/apimachinery/pkg/version", "", "io.fabric8.kubernetes.api.model.version", "kubernetes_apimachinery_pkg_version_", false},
    {"k8s.io/apimachinery/pkg/apis/meta/v1", "", "io.fabric8.kubernetes.api.model", "kubernetes_apimachinery_", false},
    {"k8s.io/api/core/v1", "", "io.fabric8.kubernetes.api.model", "kubernetes_core_", false},
    {"sigs.k8s.io/gateway-api/apis/v1alpha2", "gateway.networking.k8s.io", "io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2", "kubernetes_sigs_gatewayapi_v1alpha2_", true},
    {"sigs.k8s.io/gateway-api/apis/v1beta1", "gateway.networking.k8s.io", "io.fabric8.kubernetes.api.model.gatewayapi.v1beta1", "kubernetes_sigs_gatewayapi_v1beta1_", true},
  }

  typeMap := map[reflect.Type]reflect.Type{
    reflect.TypeOf(time.Time{}): reflect.TypeOf(""),
    reflect.TypeOf(struct{}{}):  reflect.TypeOf(""),
  }
  schema, err := schemagen.GenerateSchema(reflect.TypeOf(Schema{}), packages, typeMap, map[reflect.Type]string{}, "gatewayapi")
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
