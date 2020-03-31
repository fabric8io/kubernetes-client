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
  "github.com/fabric8io/tekton/generator/pkg/schemagen"
  "github.com/tektoncd/pipeline/pkg/apis/pipeline/pod"
  "github.com/tektoncd/pipeline/pkg/apis/pipeline/v1alpha1"
  "github.com/tektoncd/pipeline/pkg/apis/pipeline/v1beta1"
  resource "github.com/tektoncd/pipeline/pkg/apis/resource/v1alpha1"
  "log"
  "os"
  "reflect"
  "strings"
  "time"
)

//A Schema with the core types of the Service Catalog
type Schema struct {
  V1alpha1Condition                       v1alpha1.Condition
  V1alpha1ConditionList                   v1alpha1.ConditionList
  V1alpha1PipelineResource                v1alpha1.PipelineResource
  V1alpha1PipelineResourceList            v1alpha1.PipelineResourceList

  V1beta1Pipeline                        v1beta1.Pipeline
  V1beta1PipelineList                    v1beta1.PipelineList
  V1beta1PipelineRun                     v1beta1.PipelineRun
  V1beta1PipelineRunList                 v1beta1.PipelineRunList
  V1beta1PipelineRunTaskRunStatus        v1beta1.PipelineRunTaskRunStatus
  V1beta1PipelineRunConditionCheckStatus v1beta1.PipelineRunConditionCheckStatus
  V1beta1Task                            v1beta1.Task
  V1beta1TaskList                        v1beta1.TaskList
  V1beta1TaskRun                         v1beta1.TaskRun
  V1beta1TaskRef                         v1beta1.TaskRef
  V1beta1TaskRunList                     v1beta1.TaskRunList
  V1beta1ClusterTask                     v1beta1.ClusterTask
  V1beta1ClusterTaskList                 v1beta1.ClusterTaskList
  V1beta1PipelineTask                    v1beta1.PipelineTask
  V1beta1PipelineTaskResource            v1beta1.PipelineTaskResources
  V1beta1ResourceDeclaration             v1beta1.ResourceDeclaration
	V1beta1Sidecar                         v1beta1.Sidecar
	V1beta1SidecarState                    v1beta1.SidecarState
	V1beta1PodTemplate                     v1beta1.PodTemplate
	V1beta1Step                            v1beta1.Step
	V1beta1TaskResource                    v1beta1.TaskResource
	V1beta1TaskResourceBinding             v1beta1.TaskResourceBinding

	Template                               pod.Template
	ResourceDeclaration                    resource.ResourceDeclaration
	resource                               resource.PipelineResource

}

func main() {
	packages := []schemagen.PackageDescriptor{
		//"$ref": "#/definitions/github_com_tektoncd_pipeline_vendor_k8s_io_api_core_v1_Probe",
		{"github.com/tektoncd/pipeline/pkg/apis/pipeline/v1alpha1", "tekton.dev", "io.fabric8.tekton.pipeline.v1alpha1", "tekton_v1alpha1_"},
    {"github.com/tektoncd/pipeline/pkg/apis/pipeline/v1beta1", "tekton.dev", "io.fabric8.tekton.pipeline.v1beta1", "tekton_v1alpha2_"},
    {"github.com/tektoncd/pipeline/pkg/apis/resource/v1alpha1", "tekton.dev", "io.fabric8.tekton.resource.v1alpha1", "tekton_resource_v1alpha1_"},
    {"github.com/tektoncd/pipeline/pkg/apis/pipeline/pod", "tekton.dev", "io.fabric8.tekton.pipeline.pod", "tekton_pod_"},
    {"github.com/knative/pkg/apis", "v1", "io.fabric8.knative.v1", "knative_"},
		{"knative.dev/pkg/apis", "v1", "io.fabric8.knative.v1", "knative_"},
		{"github.com/knative/pkg/apis/duck/v1beta1", "duck", "io.fabric8.knative.duck.v1beta1", "knative_duck_v1beta1_"},
		{"knative.dev/pkg/apis/duck/v1beta1", "duck", "io.fabric8.knative.duck.v1beta1", "knative_duck_v1beta1_"},
		{"k8s.io/api/core/v1", "v1", "io.fabric8.kubernetes.api.model", "kubernetes_"},
		{"k8s.io/apimachinery/pkg/apis/meta/v1", "v1", "io.fabric8.kubernetes.api.model", "kubernetes_meta_"},
		{"k8s.io/apimachinery/pkg/util", "v1", "io.fabric8.kubernetes.api.model", "kubernetes_uti_"},
	}

	typeMap := map[reflect.Type]reflect.Type{
		reflect.TypeOf(time.Time{}): reflect.TypeOf(""),
		reflect.TypeOf(struct{}{}):  reflect.TypeOf(""),
	}
	schema, err := schemagen.GenerateSchema(reflect.TypeOf(Schema{}), packages, typeMap)
	if err != nil {
		log.Fatal(err)
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
