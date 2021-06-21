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
  k8sauthapi "k8s.io/api/authorization/v1"
  "log"
  "reflect"
  "strings"
  "time"
  consoleapi "github.com/openshift/api/console/v1"
  consoleapiv1alpha1 "github.com/openshift/api/console/v1alpha1"

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
  ResourceAttributes                       k8sauthapi.ResourceAttributes
  ConsoleCLIDownload                       consoleapi.ConsoleCLIDownload
  ConsoleCLIDownloadList                   consoleapi.ConsoleCLIDownloadList
  ConsoleExternalLogLink                   consoleapi.ConsoleExternalLogLink
  ConsoleExternalLogLinkList               consoleapi.ConsoleExternalLogLinkList
  ConsoleLink                              consoleapi.ConsoleLink
  ConsoleLinkList                          consoleapi.ConsoleLinkList
  ConsoleNotification                      consoleapi.ConsoleNotification
  ConsoleNotificationList                  consoleapi.ConsoleNotificationList
  ConsoleYAMLSample                        consoleapi.ConsoleYAMLSample
  ConsoleYAMLSampleList                    consoleapi.ConsoleYAMLSampleList
  ConsoleQuickStart                        consoleapi.ConsoleQuickStart
  ConsoleQuickStartList                    consoleapi.ConsoleQuickStartList
  ConsolePlugin                            consoleapiv1alpha1.ConsolePluginList
  ConsolePluginList                        consoleapiv1alpha1.ConsolePluginList
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
    {"k8s.io/api/authorization/v1", "", "io.fabric8.kubernetes.api.model.authorization.v1", "kubernetes_authorization_v1_", false},
    {"github.com/openshift/api/console/v1", "", "io.fabric8.openshift.api.model.console.v1", "os_console_v1_", true},
    {"github.com/openshift/api/console/v1alpha1", "", "io.fabric8.openshift.api.model.console.v1alpha1", "os_console_v1alpha1_", true},
  }

  typeMap := map[reflect.Type]reflect.Type{
    reflect.TypeOf(time.Time{}): reflect.TypeOf(""),
    reflect.TypeOf(struct{}{}):  reflect.TypeOf(""),
  }
  schema, err := schemagen.GenerateSchema(reflect.TypeOf(Schema{}), packages, typeMap, map[reflect.Type]string{},"console")
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
