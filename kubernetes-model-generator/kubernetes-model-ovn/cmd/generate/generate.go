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

  v1adminpolicybasedroute "github.com/ovn-org/ovn-kubernetes/go-controller/pkg/crd/adminpolicybasedroute/v1"
  v1egressfirewall "github.com/ovn-org/ovn-kubernetes/go-controller/pkg/crd/egressfirewall/v1"
  v1egressip "github.com/ovn-org/ovn-kubernetes/go-controller/pkg/crd/egressip/v1"
  v1egressqos "github.com/ovn-org/ovn-kubernetes/go-controller/pkg/crd/egressqos/v1"
  v1egressservice "github.com/ovn-org/ovn-kubernetes/go-controller/pkg/crd/egressservice/v1"

  "log"
  "reflect"
  "strings"
  "time"

  "os"

  "github.com/fabric8io/kubernetes-client/kubernetes-model-generator/pkg/schemagen"
)

type Schema struct {
  V1AdminPolicyBasedExternalRoute          v1adminpolicybasedroute.AdminPolicyBasedExternalRoute
  V1AdminPolicyBasedExternalRouteList      v1adminpolicybasedroute.AdminPolicyBasedExternalRouteList
  V1EgressFirewall                         v1egressfirewall.EgressFirewall
  V1EgressFirewallList                     v1egressfirewall.EgressFirewallList
  V1EgressIP                               v1egressip.EgressIP
  V1EgressIPList                           v1egressip.EgressIPList
  V1EgressQoS                              v1egressqos.EgressQoS
  V1EgressQoSList                          v1egressqos.EgressQoSList
  V1EgressService                          v1egressservice.EgressService
  V1EgressServiceList                      v1egressservice.EgressServiceList
}

func main() {
  packages := []schemagen.PackageDescriptor{
    {"k8s.io/apimachinery/pkg/api/resource", "", "io.fabric8.kubernetes.api.model", "kubernetes_resource_", false},
    {"k8s.io/apimachinery/pkg/version", "", "io.fabric8.kubernetes.api.model.version", "kubernetes_apimachinery_pkg_version_", false},
    {"k8s.io/apimachinery/pkg/apis/meta/v1", "", "io.fabric8.kubernetes.api.model", "kubernetes_apimachinery_", false},
    {"k8s.io/api/core/v1", "", "io.fabric8.kubernetes.api.model", "kubernetes_core_", false},
    {"github.com/ovn-org/ovn-kubernetes/go-controller/pkg/crd/adminpolicybasedroute/v1", "k8s.ovn.org", "io.fabric8.kubernetes.api.model.ovn.v1", "kubernetes_ovn_v1_", true},
    {"github.com/ovn-org/ovn-kubernetes/go-controller/pkg/crd/egressfirewall/v1", "k8s.ovn.org", "io.fabric8.kubernetes.api.model.ovn.v1", "kubernetes_ovn_v1_", true},
    {"github.com/ovn-org/ovn-kubernetes/go-controller/pkg/crd/egressip/v1", "k8s.ovn.org", "io.fabric8.kubernetes.api.model.ovn.v1", "kubernetes_ovn_v1_", true},
    {"github.com/ovn-org/ovn-kubernetes/go-controller/pkg/crd/egressqos/v1", "k8s.ovn.org", "io.fabric8.kubernetes.api.model.ovn.v1", "kubernetes_ovn_v1_", true},
    {"github.com/ovn-org/ovn-kubernetes/go-controller/pkg/crd/egressservice/v1", "k8s.ovn.org", "io.fabric8.kubernetes.api.model.ovn.v1", "kubernetes_ovn_v1_", true},
  }

  typeMap := map[reflect.Type]reflect.Type{
    reflect.TypeOf(time.Time{}): reflect.TypeOf(""),
    reflect.TypeOf(struct{}{}):  reflect.TypeOf(""),
  }
  schema, err := schemagen.GenerateSchema(reflect.TypeOf(Schema{}), packages, typeMap, map[reflect.Type]string{},"ovn")
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
