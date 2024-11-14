//go:generate go run ../tools/generator/openapi.go
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
	"github.com/fabric8io/kubernetes-client/kubernetes-model-generator/openapi/generator/cmd/generated_autoscaling_openapi"
	"github.com/fabric8io/kubernetes-client/kubernetes-model-generator/openapi/generator/cmd/generated_certmanager_openapi"
	"github.com/fabric8io/kubernetes-client/kubernetes-model-generator/openapi/generator/cmd/generated_chaosmesh_openapi"
	"github.com/fabric8io/kubernetes-client/kubernetes-model-generator/openapi/generator/cmd/generated_gatewayapi_openapi"
	"github.com/fabric8io/kubernetes-client/kubernetes-model-generator/openapi/generator/cmd/generated_istio_openapi"
	"github.com/fabric8io/kubernetes-client/kubernetes-model-generator/openapi/generator/cmd/generated_knative_openapi"
	"github.com/fabric8io/kubernetes-client/kubernetes-model-generator/openapi/generator/cmd/generated_openclustermanagement_openapi"
	"github.com/fabric8io/kubernetes-client/kubernetes-model-generator/openapi/generator/cmd/generated_openshift_openapi"
	"github.com/fabric8io/kubernetes-client/kubernetes-model-generator/openapi/generator/cmd/generated_ovn_openapi"
	"github.com/fabric8io/kubernetes-client/kubernetes-model-generator/openapi/generator/cmd/generated_tekton_openapi"
	"github.com/fabric8io/kubernetes-client/kubernetes-model-generator/openapi/generator/cmd/generated_volcano_openapi"
	"github.com/fabric8io/kubernetes-client/kubernetes-model-generator/openapi/generator/cmd/generated_volumesnapshot_openapi"
	"github.com/fabric8io/kubernetes-client/kubernetes-model-generator/openapi/generator/pkg/openapi"
	"github.com/fabric8io/kubernetes-client/kubernetes-model-generator/openapi/generator/pkg/packages"
	"github.com/spf13/cobra"
	"k8s.io/kube-openapi/pkg/common"
	"time"
)

var openApi = &cobra.Command{
	Use:   "open-api [targetDirectory]",
	Short: "Generate OpenAPI definitions from OpenAPI/Swagger schema definitions in codegen and openapi-gen zz_generated files",
	Run:   openApiRun,
}

func init() {
	rootCmd.AddCommand(openApi)
}

type module struct {
	outputName         string
	getDefinitionsFunc func(callback common.ReferenceCallback) map[string]common.OpenAPIDefinition
	patterns           []string
}

var modules = []module{
	{outputName: "openshift-generated", getDefinitionsFunc: generated_openshift_openapi.GetOpenAPIDefinitions, patterns: packages.OpenShiftPackagePatterns},
	{outputName: "dev.knative", getDefinitionsFunc: generated_knative_openapi.GetOpenAPIDefinitions, patterns: packages.KnativePackagePatterns},
	{outputName: "dev.tekton", getDefinitionsFunc: generated_tekton_openapi.GetOpenAPIDefinitions, patterns: packages.TektonPackagePatterns},
	{outputName: "gateway-api", getDefinitionsFunc: generated_gatewayapi_openapi.GetOpenAPIDefinitions, patterns: packages.GatewayApiPackagePatterns},
	{outputName: "io.cert-manager", getDefinitionsFunc: generated_certmanager_openapi.GetOpenAPIDefinitions, patterns: packages.CertManagerPackagePatterns},
	{outputName: "io.istio", getDefinitionsFunc: generated_istio_openapi.GetOpenAPIDefinitions, patterns: packages.IstioPackagePatterns},
	{outputName: "io.k8s.autoscaling", getDefinitionsFunc: generated_autoscaling_openapi.GetOpenAPIDefinitions, patterns: packages.AutoscalingPackagePatterns},
	{outputName: "io.k8s.storage.snapshot", getDefinitionsFunc: generated_volumesnapshot_openapi.GetOpenAPIDefinitions, patterns: packages.VolumeSnapshotPackagePatterns},
	{outputName: "io.open-cluster-management", getDefinitionsFunc: generated_openclustermanagement_openapi.GetOpenAPIDefinitions, patterns: packages.OvnPackagePatterns},
	{outputName: "org.chaos-mesh", getDefinitionsFunc: generated_chaosmesh_openapi.GetOpenAPIDefinitions, patterns: packages.ChaosMeshPackagePatterns},
	{outputName: "org.ovn", getDefinitionsFunc: generated_ovn_openapi.GetOpenAPIDefinitions, patterns: packages.OvnPackagePatterns},
	{outputName: "sh.volcano", getDefinitionsFunc: generated_volcano_openapi.GetOpenAPIDefinitions, patterns: packages.VolcanoPackagePatterns},
}

var openApiRun = func(cobraCmd *cobra.Command, args []string) {
	startTime := time.Now()
	fmt.Println("OpenAPI JSON schema generation started...")
	var targetDirectory string
	if len(args) > 0 {
		targetDirectory = args[0]
	} else {
		targetDirectory = "."
	}
	for _, m := range modules {
		taskStartTime := time.Now()
		openApiGenerator := openapi.NewGenerator(targetDirectory, m.outputName, m.getDefinitionsFunc, m.patterns...)
		if err := openApiGenerator.WriteDefinitions(); err != nil {
			panic(fmt.Errorf("OpenAPI JSON generation error (%s): %w", m.outputName, err))
		}
		fmt.Printf("OpenAPI JSON generation for (%s) completed in %v\n", m.outputName, time.Since(taskStartTime))
	}
	fmt.Printf("OpenAPI JSON schema generation completed in %v\n", time.Since(startTime))
}
