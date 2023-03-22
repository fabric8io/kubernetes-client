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
	"fmt"
	"github.com/fabric8io/kubernetes-client/generator/pkg/schemagen"
	"github.com/tektoncd/pipeline/pkg/apis/pipeline/v1beta1"
	resolutionV1Beta1 "github.com/tektoncd/pipeline/pkg/apis/resolution/v1beta1"
	machinery "k8s.io/apimachinery/pkg/apis/meta/v1"
	"k8s.io/apimachinery/pkg/runtime"
	"reflect"
)

func main() {

	// the CRD List types for which the model should be generated
	// no other types need to be defined as they are auto discovered
	crdLists := map[reflect.Type]schemagen.CrdScope{
		// v1beta1
		reflect.TypeOf(v1beta1.CustomRunList{}):   schemagen.Namespaced,
		reflect.TypeOf(v1beta1.PipelineList{}):    schemagen.Namespaced,
		reflect.TypeOf(v1beta1.PipelineRunList{}): schemagen.Namespaced,
		reflect.TypeOf(v1beta1.TaskList{}):        schemagen.Namespaced,
		reflect.TypeOf(v1beta1.TaskRunList{}):     schemagen.Namespaced,
		reflect.TypeOf(v1beta1.ClusterTaskList{}): schemagen.Cluster,

		// resolution v1beta1
		reflect.TypeOf(resolutionV1Beta1.ResolutionRequestList{}): schemagen.Namespaced,
	}

	// constraints and patterns for fields
	constraints := map[reflect.Type]map[string]*schemagen.Constraint{
		reflect.TypeOf(v1beta1.Step{}): {"Name": &schemagen.Constraint{MaxLength: 63, Pattern: "^[a-z0-9]([-a-z0-9]*[a-z0-9])?$"}},
	}

	// types that are manually defined in the model
	providedTypes := []schemagen.ProvidedType{
		{GoType: reflect.TypeOf(v1beta1.ParamValue{}), JavaClass: "io.fabric8.tekton.pipeline.v1beta1.ParamValue"},
	}

	// go packages that are provided and where no generation is required and their corresponding java package
	providedPackages := map[string]string{
		// external
		"k8s.io/api/core/v1":                   "io.fabric8.kubernetes.api.model",
		"knative.dev/pkg/apis":                 "io.fabric8.knative.internal.pkg.apis",
		"k8s.io/apimachinery/pkg/apis/meta/v1": "io.fabric8.kubernetes.api.model",
	}

	// mapping of go packages of this module to the resulting java package
	// optional ApiGroup and ApiVersion for the go package (which is added to the generated java class)
	packageMapping := map[string]schemagen.PackageInformation{
		// v1beta1
		"github.com/tektoncd/pipeline/pkg/apis/pipeline/v1beta1": {JavaPackage: "io.fabric8.tekton.pipeline.v1beta1", ApiGroup: "tekton.dev", ApiVersion: "v1beta1"},
		// resolution v1beta1
		"github.com/tektoncd/pipeline/pkg/apis/resolution/v1beta1": {JavaPackage: "io.fabric8.tekton.resolution.v1beta1", ApiGroup: "resolution.tekton.dev", ApiVersion: "v1beta1"},
	}

	// converts all packages starting with <key> to a java package using an automated scheme:
	//  - replace <key> with <value> aka "package prefix"
	//  - replace '/' with '.' for a valid java package name
	// e.g. github.com/tektoncd/pipeline/pkg/apis/pipeline/pod/Template is mapped to "io.fabric8.tekton.internal.pipeline.pkg.apis.pipeline.pod.Template"
	mappingSchema := map[string]string{
		"github.com/tektoncd": "io.fabric8.tekton.v1beta1.internal",
	}

	// overwriting some times
	manualTypeMap := map[reflect.Type]string{
		reflect.TypeOf(runtime.RawExtension{}): "java.util.Map<String, Object>",
		reflect.TypeOf(machinery.Time{}):       "java.lang.String",
	}

	json := schemagen.GenerateSchema("http://fabric8.io/tekton/v1beta1/TektonSchema#", crdLists, providedPackages, manualTypeMap, packageMapping, mappingSchema, providedTypes, constraints, "io.fabric8")

	fmt.Println(json)
}
