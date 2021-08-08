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

  apiextensions "k8s.io/apiextensions-apiserver/pkg/apis/apiextensions/v1beta1"
  v1apiextensions "k8s.io/apiextensions-apiserver/pkg/apis/apiextensions/v1"

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
  ObjectReference                          kapi.ObjectReference

  CustomResourceDefinition                 apiextensions.CustomResourceDefinition
  CustomResourceDefinitionList             apiextensions.CustomResourceDefinitionList
  CustomResourceDefinitionSpec             apiextensions.CustomResourceDefinitionSpec
  CustomResourceDefinitionNames            apiextensions.CustomResourceDefinitionNames
  CustomResourceDefinitionCondition        apiextensions.CustomResourceDefinitionCondition
  CustomResourceDefinitionStatus           apiextensions.CustomResourceDefinitionStatus
  // Added JSONSchemaPropsorStringArray here because of
  // https://github.com/joelittlejohn/jsonschema2pojo/issues/866
  JSONSchemaPropsOrStringArray             apiextensions.JSONSchemaPropsOrStringArray

  V1CustomResourceDefinition                 v1apiextensions.CustomResourceDefinition
  V1CustomResourceDefinitionList             v1apiextensions.CustomResourceDefinitionList
  V1CustomResourceDefinitionSpec             v1apiextensions.CustomResourceDefinitionSpec
  V1CustomResourceDefinitionNames            v1apiextensions.CustomResourceDefinitionNames
  V1CustomResourceDefinitionCondition        v1apiextensions.CustomResourceDefinitionCondition
  V1CustomResourceDefinitionStatus           v1apiextensions.CustomResourceDefinitionStatus
  // Added JSONSchemaPropsorStringArray here because of
  // https://github.com/joelittlejohn/jsonschema2pojo/issues/866
  V1JSONSchemaPropsOrStringArray             v1apiextensions.JSONSchemaPropsOrStringArray
  V1ConversionReview                         v1apiextensions.ConversionReview
}

func main() {
  packages := []schemagen.PackageDescriptor{
    {"k8s.io/apimachinery/pkg/util/intstr", "", "io.fabric8.kubernetes.api.model", "kubernetes_apimachinery_pkg_util_intstr_", false},
    {"k8s.io/apimachinery/pkg/runtime", "", "io.fabric8.kubernetes.api.model.runtime", "kubernetes_apimachinery_pkg_runtime_", false},
    {"k8s.io/apimachinery/pkg/version", "", "io.fabric8.kubernetes.api.model.version", "kubernetes_apimachinery_pkg_version_", false},
    {"k8s.io/apimachinery/pkg/apis/meta/v1", "", "io.fabric8.kubernetes.api.model", "kubernetes_apimachinery_", false},
    {"k8s.io/api/core/v1", "", "io.fabric8.kubernetes.api.model", "kubernetes_core_", false},
    {"k8s.io/apiextensions-apiserver/pkg/apis/apiextensions/v1beta1", "", "io.fabric8.kubernetes.api.model.apiextensions.v1beta1", "kubernetes_apiextensions_v1beta1_", true},
    {"k8s.io/apiextensions-apiserver/pkg/apis/apiextensions/v1", "", "io.fabric8.kubernetes.api.model.apiextensions.v1", "kubernetes_apiextensions_v1_", true},
  }

  typeMap := map[reflect.Type]reflect.Type{
    reflect.TypeOf(time.Time{}): reflect.TypeOf(""),
    reflect.TypeOf(struct{}{}):  reflect.TypeOf(""),
  }

  // overwriting some times
  manualTypeMapping := map[reflect.Type]string{
    reflect.TypeOf(apiextensions.JSON{}): "com.fasterxml.jackson.databind.JsonNode",
    reflect.TypeOf(v1apiextensions.JSON{}): "com.fasterxml.jackson.databind.JsonNode",
  }
  schema, err := schemagen.GenerateSchema(reflect.TypeOf(Schema{}), packages, typeMap, manualTypeMapping, "apiextensions")
  if err != nil {
    fmt.Fprintf(os.Stderr, "An error occurred: %v", err)
    return
  }

  serdes := map[string]*schemagen.JavaSerDeDescriptor{
		"kubernetes_apiextensions_v1beta1_JSONSchemaPropsOrBool": &schemagen.JavaSerDeDescriptor{
				Serializer: "io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaPropsOrBoolSerDe.Serializer.class",
				Deserializer: "io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaPropsOrBoolSerDe.Deserializer.class",
		},
		"kubernetes_apiextensions_v1beta1_JSONSchemaPropsOrArray": &schemagen.JavaSerDeDescriptor{
				Serializer: "io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaPropsOrArraySerDe.Serializer.class",
				Deserializer: "io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaPropsOrArraySerDe.Deserializer.class",
		},
		"kubernetes_apiextensions_v1beta1_JSONSchemaPropsOrStringArray": &schemagen.JavaSerDeDescriptor{
			Serializer: "io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaPropsOrStringArraySerDe.Serializer.class",
			Deserializer: "io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaPropsOrStringArraySerDe.Deserializer.class",
		},
		"kubernetes_apiextensions_v1_JSONSchemaPropsOrBool": &schemagen.JavaSerDeDescriptor{
				Serializer: "io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsOrBoolSerDe.Serializer.class",
				Deserializer: "io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsOrBoolSerDe.Deserializer.class",
		},
		"kubernetes_apiextensions_v1_JSONSchemaPropsOrArray": &schemagen.JavaSerDeDescriptor{
				Serializer: "io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsOrArraySerDe.Serializer.class",
				Deserializer: "io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsOrArraySerDe.Deserializer.class",
		},
		"kubernetes_apiextensions_v1_JSONSchemaPropsOrStringArray": &schemagen.JavaSerDeDescriptor{
			Serializer: "io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsOrStringArraySerDe.Serializer.class",
			Deserializer: "io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsOrStringArraySerDe.Deserializer.class",
		},
}

  for definitionKey, descriptor := range serdes {
		val := schema.Definitions[definitionKey]
		val.JavaSerDeDescriptor = descriptor
		schema.Definitions[definitionKey] = val
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
