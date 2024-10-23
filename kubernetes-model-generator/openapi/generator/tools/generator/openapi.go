////go:build ignore
//// +build ignore

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
	"github.com/fabric8io/kubernetes-client/kubernetes-model-generator/openapi/generator/pkg/openapi"
	"github.com/fabric8io/kubernetes-client/kubernetes-model-generator/openapi/generator/pkg/packages"
	"k8s.io/kube-openapi/cmd/openapi-gen/args"
	"time"
)

type module struct {
	outputName string
	patterns   []string
}

var modules = []module{
	{patterns: packages.OpenShiftPackagePatterns, outputName: "generated_openshift_openapi"},
	{patterns: packages.AutoscalingPackagePatterns, outputName: "generated_autoscaling_openapi"},
	// https://github.com/chaos-mesh/chaos-mesh/issues/4517
	//{patterns: packages.ChaosMeshPackagePatterns, outputName: "generated_chaosmesh_openapi"},
	//{patterns: packages.IstioPackagePatterns, outputName: "generated_istio_openapi"},
	{patterns: packages.KnativePackagePatterns, outputName: "generated_knative_openapi"},
	{patterns: packages.TektonPackagePatterns, outputName: "generated_tekton_openapi"},
	{patterns: packages.VolcanoPackagePatterns, outputName: "generated_volcano_openapi"},
	{patterns: packages.VolumeSnapshotPackagePatterns, outputName: "generated_volumesnapshot_openapi"},
}

func main() {
	startTime := time.Now()
	fmt.Println("OpenAPI code generation started...")
	for _, m := range modules {
		taskStartTime := time.Now()
		err := (&openapi.GoGenerator{
			Args: args.Args{
				OutputFile: "zz_generated.openapi.go",
				OutputDir:  "./" + m.outputName,
				OutputPkg:  "./" + m.outputName,
			},
			Patterns: m.patterns,
		}).Generate()
		if err != nil {
			panic(fmt.Errorf("OpenAPI code generation error (%s): %w", m.outputName, err))
		}
		fmt.Printf("OpenAPI code generation for (%s) completed in %v\n", m.outputName, time.Since(taskStartTime))
	}
	fmt.Printf("OpenAPI code generation completed in %v\n", time.Since(startTime))
}
