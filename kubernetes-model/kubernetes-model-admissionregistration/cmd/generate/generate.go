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
  // Dependencies 
  metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
  "k8s.io/apimachinery/pkg/api/resource"
  apimachineryversion "k8s.io/apimachinery/pkg/version"
  authenticationapi "k8s.io/api/authentication/v1"

  admission "k8s.io/api/admission/v1beta1"
  admissionregistration "k8s.io/api/admissionregistration/v1beta1"
  k8sauthapi "k8s.io/api/authorization/v1"

  "log"
  "reflect"
  "strings"
  "time"

  "os"

  "github.com/fabric8io/kubernetes-client/kubernetes-model/pkg/schemagen"
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

  TokenReview                              authenticationapi.TokenReview

  AdmissionReview                          admission.AdmissionReview
  AdmissionRequest                         admission.AdmissionRequest
  AdmissionResponse                        admission.AdmissionResponse
  PatchType                                admission.PatchType
  Operation                                admission.Operation
  Rule                                     admissionregistration.Rule
  ValidatingWebhookConfiguration           admissionregistration.ValidatingWebhookConfiguration
  ValidatingWebhookConfigurationList       admissionregistration.ValidatingWebhookConfigurationList
  MutatingWebhookConfiguration             admissionregistration.MutatingWebhookConfiguration
  MutatingWebhookConfigurationList         admissionregistration.MutatingWebhookConfigurationList
  RuleWithOperations                       admissionregistration.RuleWithOperations
  ServiceReference                         admissionregistration.ServiceReference
  K8sSubjectAccessReview                   k8sauthapi.SubjectAccessReview
  K8sLocalSubjectAccessReview              k8sauthapi.LocalSubjectAccessReview
  SelfSubjectRulesReview                   k8sauthapi.SelfSubjectRulesReview
  SelfSubjectAccessReview                  k8sauthapi.SelfSubjectAccessReview
}

func main() {
  customTypeNames := map[string]string{
    "K8sSubjectAccessReview": "SubjectAccessReview",
    "K8sLocalSubjectAccessReview":  "LocalSubjectAccessReview",
    "JSONSchemaPropsorStringArray": "JSONSchemaPropsOrStringArray",
  }
  packages := []schemagen.PackageDescriptor{
    {"k8s.io/api/admission/v1beta1", "admission.k8s.io", "io.fabric8.kubernetes.api.model.admission", "kubernetes_admission_"},
    {"k8s.io/api/admissionregistration/v1beta1", "admissionregistration.k8s.io", "io.fabric8.kubernetes.api.model.admissionregistration", "kubernetes_admissionregistration_"},
    {"k8s.io/api/authentication/v1", "authentication.k8s.io", "io.fabric8.kubernetes.api.model.authentication", "kubernetes_authentication_"},
    {"k8s.io/apimachinery/pkg/util/intstr", "", "io.fabric8.kubernetes.api.model", "kubernetes_apimachinery_pkg_util_intstr_"},
    {"k8s.io/apimachinery/pkg/runtime", "", "io.fabric8.kubernetes.api.model.runtime", "kubernetes_apimachinery_pkg_runtime_"},
    {"k8s.io/apimachinery/pkg/version", "", "io.fabric8.kubernetes.api.model.version", "kubernetes_apimachinery_pkg_version_"},
    {"k8s.io/apimachinery/pkg/apis/meta/v1", "", "io.fabric8.kubernetes.api.model", "kubernetes_apimachinery_"},
    {"k8s.io/api/authorization/v1", "authorization.k8s.io", "io.fabric8.kubernetes.api.model.authorization", "kubernetes_authorization_"},
  }

  typeMap := map[reflect.Type]reflect.Type{
    reflect.TypeOf(time.Time{}): reflect.TypeOf(""),
    reflect.TypeOf(struct{}{}):  reflect.TypeOf(""),
  }
  schema, err := schemagen.GenerateSchema(reflect.TypeOf(Schema{}), packages, typeMap, customTypeNames, "admissionregistration")
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
