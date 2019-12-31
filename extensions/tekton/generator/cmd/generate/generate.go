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
	"github.com/tektoncd/pipeline/pkg/apis/pipeline/v1alpha1"
	"log"
	"os"
	"reflect"
	"strings"
	"time"
)

//A Schema with the core types of the Service Catalog
type Schema struct {
	Pipeline                        v1alpha1.Pipeline
	PipelineList                    v1alpha1.PipelineList
	PipelineRun                     v1alpha1.PipelineRun
	PipelineRunList                 v1alpha1.PipelineRunList
	PipelineResource                v1alpha1.PipelineResource
	PipelineResourceList            v1alpha1.PipelineResourceList
	PipelineRunTaskRunStatus        v1alpha1.PipelineRunTaskRunStatus
	PipelineRunConditionCheckStatus v1alpha1.PipelineRunConditionCheckStatus
	Task                            v1alpha1.Task
	TaskList                        v1alpha1.TaskList
	TaskRun                         v1alpha1.TaskRun
	TaskRunList                     v1alpha1.TaskRunList
	ClusterTask                     v1alpha1.ClusterTask
	ClusterTaskList                 v1alpha1.ClusterTaskList
	Condition                       v1alpha1.Condition
	ConditionList                   v1alpha1.ConditionList
}

func main() {
	packages := []schemagen.PackageDescriptor{
		//"$ref": "#/definitions/github_com_tektoncd_pipeline_vendor_k8s_io_api_core_v1_Probe",
		{"github.com/tektoncd/pipeline/pkg/apis/pipeline/v1alpha1", "tekton.dev", "io.fabric8.tekton.pipeline.v1alpha1", "tekton_v1alpha1_"},
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
