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
  "github.com/fabric8io/kubernetes-client/extensions/kudo/generator/pkg/schemagen"
  kudov1beta1 "github.com/kudobuilder/kudo/pkg/apis/kudo/v1beta1"
  kudopackage "github.com/kudobuilder/kudo/pkg/kudoctl/packages"

  "log"
  "reflect"
  "strings"
  "time"

  "os"
)

type Schema struct {
  // kudo
  AggregatedStatus       kudov1beta1.AggregatedStatus
  DummyTaskSpec          kudov1beta1.DummyTaskSpec
  ExecutionStatus        kudov1beta1.ExecutionStatus
  Instance               kudov1beta1.Instance
  InstanceError          kudov1beta1.InstanceError
  InstanceList           kudov1beta1.InstanceList
  InstanceSpec           kudov1beta1.InstanceSpec
  Maintainer             kudov1beta1.Maintainer
  InstanceStatus         kudov1beta1.InstanceStatus
  Operator               kudov1beta1.Operator
  OperatorDependency     kudov1beta1.OperatorDependency
  OperatorList           kudov1beta1.OperatorList
  OperatorSpec           kudov1beta1.OperatorSpec
  OperatorStatus         kudov1beta1.OperatorStatus
  OperatorVersion        kudov1beta1.OperatorVersion
  OperatorVersionList    kudov1beta1.OperatorVersionList
  OperatorVersionSpec    kudov1beta1.OperatorVersionSpec
  OperatorVersionStatus  kudov1beta1.OperatorVersionStatus
  Ordering               kudov1beta1.Ordering
  Parameter              kudov1beta1.Parameter
  ParameterType          kudov1beta1.ParameterType
  Phase                  kudov1beta1.Phase
  PhaseStatus            kudov1beta1.PhaseStatus
  PipeSpec               kudov1beta1.PipeSpec
  PipeTaskSpec           kudov1beta1.PipeTaskSpec
  Plan                   kudov1beta1.Plan
  PlanExecution          kudov1beta1.PlanExecution
  PlanStatus             kudov1beta1.PlanStatus
  ResourceTaskSpec       kudov1beta1.ResourceTaskSpec
  Step                   kudov1beta1.Step
  StepStatus             kudov1beta1.StepStatus
  Task                   kudov1beta1.Task
  TaskSpec               kudov1beta1.TaskSpec
  ToggleTaskSpec         kudov1beta1.ToggleTaskSpec

  Files         kudopackage.Files
  Package       kudopackage.Package
  Resources     kudopackage.Resources
  OperatorFile  kudopackage.OperatorFile
  ParamsFile    kudopackage.ParamsFile
  Parameters    kudopackage.Parameters
  FileParameter kudopackage.Parameter
  Templates     kudopackage.Templates
}

func main() {
  customTypeNames := map[string]string{
    "K8sSubjectAccessReview": "SubjectAccessReview",
    "K8sLocalSubjectAccessReview":  "LocalSubjectAccessReview",
    "JSONSchemaPropsorStringArray": "JSONSchemaPropsOrStringArray",
  }
  packages := []schemagen.PackageDescriptor{
    {"k8s.io/api/core/v1", "v1", "io.fabric8.kubernetes.api.model", "kubernetes_"},
    {"k8s.io/apimachinery/pkg/api/resource", "v1", "io.fabric8.kubernetes.api.model", "kubernetes_"},
    {"k8s.io/apimachinery/pkg/apis/meta/v1", "v1", "io.fabric8.kubernetes.api.model", "kubernetes_meta_"},
    {"k8s.io/apimachinery/pkg/util", "v1", "io.fabric8.kubernetes.api.model", "kubernetes_uti_"},
    {"k8s.io/apimachinery/pkg/runtime", "v1", "io.fabric8.kubernetes.api.model", "kubernetes_uti_"},

    {"github.com/kudobuilder/kudo/pkg/apis/kudo/v1beta1", "kudo.dev", "io.fabric8.kudo.api.model.v1beta1", "kudo_api_v1beta1_"},
    {"github.com/kudobuilder/kudo/pkg/kudoctl/packages", "kudo.dev", "io.fabric8.kudo.api.model.kubectl", "kudo_kubectl_"},
  }

  typeMap := map[reflect.Type]reflect.Type{
    reflect.TypeOf(time.Time{}): reflect.TypeOf(""),
    reflect.TypeOf(struct{}{}):  reflect.TypeOf(""),
  }
  schema, err := schemagen.GenerateSchema(reflect.TypeOf(Schema{}), packages, typeMap, customTypeNames)
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

  /**
   * Hack to fix https://github.com/fabric8io/kubernetes-client/issues/1565
   *
   * Right now enums are having body as array of jsons rather than being array of strings.
   * (See https://user-images.githubusercontent.com/13834498/59852204-00d25680-938c-11e9-91b6-74f6bc3ae65b.png)
   *
   * I could not find any other way of fixing this since I'm not sure where it's coming from.
   * So doing this search and replace of whole enum json object block hence converting it to an array of plain
   * strings rather than of json objects.
   */
  result = strings.Replace(result, "\"enum\":{\"type\":\"array\",\"description\":\"\",\"javaOmitEmpty\":true,\"items\":{\"$ref\":\"#/definitions/kubernetes_apiextensions_JSON\",\"javaType\":\"io.fabric8.kubernetes.api.model.apiextensions.JSON\"}},",
    "\"enum\":{\"type\":\"array\",\"description\":\"\",\"javaOmitEmpty\":true,\"items\":{\"type\": \"string\"}},", -1)

  var out bytes.Buffer
  err = json.Indent(&out, []byte(result), "", "  ")
  if err != nil {
    log.Fatal(err)
  }

  fmt.Println(out.String())
}
