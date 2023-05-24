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
	triggers "github.com/tektoncd/triggers/pkg/apis/triggers/v1beta1"
	v1apiextensions "k8s.io/apiextensions-apiserver/pkg/apis/apiextensions/v1"
	machinery "k8s.io/apimachinery/pkg/apis/meta/v1"
	"knative.dev/pkg/apis"
	"reflect"
)

func main() {

	// the CRD List types for which the model should be generated
	// no other types need to be defined as they are auto discovered
	crdLists := map[reflect.Type]schemagen.CrdScope{
		reflect.TypeOf(triggers.TriggerList{}):               schemagen.Namespaced,
		reflect.TypeOf(triggers.TriggerTemplateList{}):       schemagen.Namespaced,
		reflect.TypeOf(triggers.TriggerBindingList{}):        schemagen.Namespaced,
		reflect.TypeOf(triggers.EventListenerList{}):         schemagen.Namespaced,
		reflect.TypeOf(triggers.ClusterTriggerBindingList{}): schemagen.Cluster,
	}

	// constraints and patterns for fields
	constraints := map[reflect.Type]map[string]*schemagen.Constraint{}

	// types that are manually defined in the model
	providedTypes := []schemagen.ProvidedType{}

	// go packages that are provided and where no generation is required and their corresponding java package
	providedPackages := map[string]string{
		// external
		"k8s.io/api/core/v1":                                     "io.fabric8.kubernetes.api.model",
		"k8s.io/apimachinery/pkg/apis/meta/v1":                   "io.fabric8.kubernetes.api.model",
		"github.com/tektoncd/pipeline/pkg/apis/pipeline/v1beta1": "io.fabric8.tekton.pipeline.v1beta1",
	}

	// mapping of go packages of this module to the resulting java package
	// optional ApiGroup and ApiVersion for the go package (which is added to the generated java class)
	packageMapping := map[string]schemagen.PackageInformation{
		"github.com/tektoncd/triggers/pkg/apis/triggers/v1beta1": {JavaPackage: "io.fabric8.tekton.triggers.v1beta1", ApiGroup: "triggers.tekton.dev", ApiVersion: "v1beta1"},
	}

	// converts all packages starting with <key> to a java package using an automated scheme:
	//  - replace <key> with <value> aka "package prefix"
	//  - replace '/' with '.' for a valid java package name
	// e.g. github.com/tektoncd/pipeline/pkg/apis/pipeline/pod/Template is mapped to "io.fabric8.tekton.internal.pipeline.pkg.apis.pipeline.pod.Template"
	mappingSchema := map[string]string{
		"knative.dev": "io.fabric8.tekton.triggers.internal.knative",
	}

	// overwriting some types
	manualTypeMap := map[reflect.Type]string{
		reflect.TypeOf(machinery.Time{}):                   "java.lang.String",
		reflect.TypeOf(apis.VolatileTime{}):                "java.lang.String",
		reflect.TypeOf(apis.URL{}):                         "java.lang.String",
		reflect.TypeOf(triggers.TriggerResourceTemplate{}): "io.fabric8.kubernetes.api.model.HasMetadata",
		reflect.TypeOf(triggers.CustomResource{}):          "io.fabric8.kubernetes.api.model.HasMetadata",
		reflect.TypeOf(v1apiextensions.JSON{}):             "java.lang.Object",
	}

	json := schemagen.GenerateSchema("http://fabric8.io/tekton/triggers/TektonSchema#", crdLists, providedPackages, manualTypeMap, packageMapping, mappingSchema, providedTypes, constraints, "io.fabric8")

	fmt.Println(json)
}
