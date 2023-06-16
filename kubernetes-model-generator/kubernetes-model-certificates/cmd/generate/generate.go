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

  certificates "k8s.io/api/certificates/v1"
  v1alpha1certificates "k8s.io/api/certificates/v1alpha1"
  v1beta1certificates "k8s.io/api/certificates/v1beta1"

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

  CertificateSigningRequest                   certificates.CertificateSigningRequest
  CertificateSigningRequestSpec               certificates.CertificateSigningRequestSpec
  CertificateSigningRequestStatus             certificates.CertificateSigningRequestStatus
  CertificateSigningRequestCondition          certificates.CertificateSigningRequestCondition
  CertificateSigningRequestList               certificates.CertificateSigningRequestList
  V1Alpha1ClusterTrustBundle                  v1alpha1certificates.ClusterTrustBundle
  V1Alpha1ClusterTrustBundleList              v1alpha1certificates.ClusterTrustBundleList
  V1Beta1CertificateSigningRequest            v1beta1certificates.CertificateSigningRequest
  V1Beta1CertificateSigningRequestSpec        v1beta1certificates.CertificateSigningRequestSpec
  V1Beta1CertificateSigningRequestStatus      v1beta1certificates.CertificateSigningRequestStatus
  V1Beta1CertificateSigningRequestCondition   v1beta1certificates.CertificateSigningRequestCondition
  V1Beta1CertificateSigningRequestList        v1beta1certificates.CertificateSigningRequestList
}

func main() {
  packages := []schemagen.PackageDescriptor{
    {"k8s.io/apimachinery/pkg/util/intstr", "", "io.fabric8.kubernetes.api.model", "kubernetes_apimachinery_pkg_util_intstr_", false},
    {"k8s.io/apimachinery/pkg/runtime", "", "io.fabric8.kubernetes.api.model.runtime", "kubernetes_apimachinery_pkg_runtime_", false},
    {"k8s.io/apimachinery/pkg/version", "", "io.fabric8.kubernetes.api.model.version", "kubernetes_apimachinery_pkg_version_", false},
    {"k8s.io/apimachinery/pkg/apis/meta/v1", "", "io.fabric8.kubernetes.api.model", "kubernetes_apimachinery_", false},
    {"k8s.io/api/certificates/v1alpha1", "certificates.k8s.io", "io.fabric8.kubernetes.api.model.certificates.v1alpha1", "kubernetes_certificates_v1alpha1_", true},
    {"k8s.io/api/certificates/v1beta1", "certificates.k8s.io", "io.fabric8.kubernetes.api.model.certificates.v1beta1", "kubernetes_certificates_v1beta1_", true},
    {"k8s.io/api/certificates/v1", "certificates.k8s.io", "io.fabric8.kubernetes.api.model.certificates.v1", "kubernetes_certificates_v1_", true},
  }

  typeMap := map[reflect.Type]reflect.Type{
    reflect.TypeOf(time.Time{}): reflect.TypeOf(""),
    reflect.TypeOf(struct{}{}):  reflect.TypeOf(""),
  }
  schema, err := schemagen.GenerateSchema(reflect.TypeOf(Schema{}), packages, typeMap, map[reflect.Type]string{},"certificates")
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
