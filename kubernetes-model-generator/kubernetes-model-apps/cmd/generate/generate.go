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
  kapi "k8s.io/api/core/v1"

  k8sappsapi "k8s.io/api/apps/v1"

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

  Deployment                               k8sappsapi.Deployment
  DeploymentList                           k8sappsapi.DeploymentList
  StatefulSet                              k8sappsapi.StatefulSet
  StatefulSetList                          k8sappsapi.StatefulSetList
  DaemonSet                                k8sappsapi.DaemonSet
  DaemonSetList                            k8sappsapi.DaemonSetList
  ReplicaSet                               k8sappsapi.ReplicaSet
  ReplicaSetList                           k8sappsapi.ReplicaSetList
  ControllerRevision                       k8sappsapi.ControllerRevision
  ControllerRevisionList                   k8sappsapi.ControllerRevisionList

  PodList                                  kapi.PodList
  PodTemplateList                          kapi.PodTemplateList
  ReplicationControllerList                kapi.ReplicationControllerList
  ServiceList                              kapi.ServiceList
  EndpointPort                             kapi.EndpointPort
  Endpoints                                kapi.Endpoints
  EndpointsList                            kapi.EndpointsList
  Node                                     kapi.Node
  NodeList                                 kapi.NodeList
  EnvVar                                   kapi.EnvVar
  Namespace                                kapi.Namespace
  NamespaceList                            kapi.NamespaceList
  PersistentVolume                         kapi.PersistentVolume
  PersistentVolumeList                     kapi.PersistentVolumeList
  PersistentVolumeClaim                    kapi.PersistentVolumeClaim
  PersistentVolumeClaimList                kapi.PersistentVolumeClaimList
  ResourceQuota                            kapi.ResourceQuota
  ResourceQuotaList                        kapi.ResourceQuotaList
  Secret                                   kapi.Secret
  SecretList                               kapi.SecretList
  ServiceAccount                           kapi.ServiceAccount
  ServiceAccountList                       kapi.ServiceAccountList
  Binding                                  kapi.Binding
  LimitRangeList                           kapi.LimitRangeList
  ComponentStatusList                      kapi.ComponentStatusList
  ContainerStatus                          kapi.ContainerStatus
  ConfigMap                                kapi.ConfigMap
  ConfigMapList                            kapi.ConfigMapList
  Toleration                               kapi.Toleration
}

func main() {
  packages := []schemagen.PackageDescriptor{
    {"k8s.io/apimachinery/pkg/util/intstr", "", "io.fabric8.kubernetes.api.model", "kubernetes_apimachinery_pkg_util_intstr_", false},
    {"k8s.io/apimachinery/pkg/runtime", "", "io.fabric8.kubernetes.api.model.runtime", "kubernetes_apimachinery_pkg_runtime_", false},
    {"k8s.io/apimachinery/pkg/version", "", "io.fabric8.kubernetes.api.model.version", "kubernetes_apimachinery_pkg_version_", false},
    {"k8s.io/apimachinery/pkg/apis/meta/v1", "", "io.fabric8.kubernetes.api.model", "kubernetes_apimachinery_", false},
    {"k8s.io/api/apps/v1", "", "io.fabric8.kubernetes.api.model.apps", "kubernetes_apps_", true},
    {"k8s.io/api/core/v1", "", "io.fabric8.kubernetes.api.model", "kubernetes_core_", false},
    {"k8s.io/kubernetes/pkg/watch/json", "", "io.fabric8.kubernetes.api.model", "kubernetes_watch_", false},
    {"k8s.io/kubernetes/pkg/util", "", "io.fabric8.kubernetes.api.model", "kubernetes_util_", false},
    {"k8s.io/kubernetes/pkg/api/errors", "", "io.fabric8.kubernetes.api.model", "kubernetes_errors_", false},
    {"k8s.io/client-go/tools/clientcmd/api/v1", "", "io.fabric8.kubernetes.api.model", "kubernetes_config_", false},
    {"k8s.io/kubernetes/pkg/api/unversioned", "", "io.fabric8.kubernetes.api.model", "api_", false},
  }

  typeMap := map[reflect.Type]reflect.Type{
    reflect.TypeOf(time.Time{}): reflect.TypeOf(""),
    reflect.TypeOf(struct{}{}):  reflect.TypeOf(""),
  }
  schema, err := schemagen.GenerateSchema(reflect.TypeOf(Schema{}), packages, typeMap, map[reflect.Type]string{},"apps")
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
