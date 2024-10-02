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
	"github.com/fabric8io/kubernetes-client/kubernetes-model-generator/openapi/generator/cmd/generated_openapi"
	"github.com/fabric8io/kubernetes-client/kubernetes-model-generator/openapi/generator/pkg/openapi"
	"github.com/fabric8io/kubernetes-client/kubernetes-model-generator/openapi/generator/pkg/openshift"
	"github.com/fabric8io/kubernetes-client/kubernetes-model-generator/openapi/generator/pkg/parser"
	//openshiftbaremetaloperatorv1alpha1 "github.com/metal3-io/baremetal-operator/apis/metal3.io/v1alpha1"
	openshiftconfigv1 "github.com/openshift/api/config/v1"
	openshiftcloudcredentialoperatorv1 "github.com/openshift/cloud-credential-operator/pkg/apis/cloudcredential/v1"
	openshiftclusternetworkoperatorv1 "github.com/openshift/cluster-network-operator/pkg/apis/network/v1"
	openshiftclusternodetuningoperatorv1 "github.com/openshift/cluster-node-tuning-operator/pkg/apis/tuned/v1"
	operatorframeworkv1 "github.com/operator-framework/api/pkg/operators/v1"
	operatorframeworkv1alpha1 "github.com/operator-framework/api/pkg/operators/v1alpha1"
	olm "github.com/operator-framework/operator-lifecycle-manager/pkg/package-server/apis/operators/v1"
	prometheusoperatorv1 "github.com/prometheus-operator/prometheus-operator/pkg/apis/monitoring/v1"
	"github.com/spf13/cobra"
	"k8s.io/kube-openapi/pkg/common"
	"k8s.io/kube-openapi/pkg/validation/spec"
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

var openApiRun = func(cobraCmd *cobra.Command, args []string) {
	startTime := time.Now()
	fmt.Printf("OpenAPI JSON schema generation started...\n%s\n", []string{
		// Force imports so that modules are present in go.mod
		openshiftconfigv1.SchemeGroupVersion.String(),
		//openshiftbaremetaloperatorv1alpha1.GroupVersion.String(),
		operatorframeworkv1alpha1.SchemeGroupVersion.String(),
		operatorframeworkv1.GroupVersion.String(),
		openshiftcloudcredentialoperatorv1.GroupVersion.String(),
		openshiftclusternetworkoperatorv1.GroupVersion.String(),
		openshiftclusternodetuningoperatorv1.SchemeGroupVersion.String(),
		olm.SchemeGroupVersion.String(),
		prometheusoperatorv1.SchemeGroupVersion.String(),
	})
	var targetDirectory string
	if len(args) > 0 {
		targetDirectory = args[0]
	} else {
		targetDirectory = "."
	}
	openApiGenerator := openapi.NewGenerator(targetDirectory, "openshift-generated")
	openShiftModule := parser.NewModule(openshift.PackagePatterns...)
	/////////////////////////////////////////////////////////////////////////////////
	// Ported from github.com/openshift/api/openapi/cmd/models-schema/main.go
	refFunc := func(name string) spec.Ref {
		return spec.MustCreateRef(fmt.Sprintf("#/definitions/%s", openShiftModule.ApiName(name)))
	}
	defs := generated_openapi.GetOpenAPIDefinitions(refFunc)
	for k, v := range defs {
		// Marc: Use gengo to complete information for the definition
		fabric8Info := openShiftModule.ExtractInfo(k)
		if v.Schema.ExtraProps == nil {
			v.Schema.ExtraProps = make(map[string]interface{})
		}
		v.Schema.ExtraProps["x-fabric8-info"] = fabric8Info

		// Replace top-level schema with v2 if a v2 schema is embedded
		// so that the output of this program is always in OpenAPI v2.
		// This is done by looking up an extension that marks the embedded v2
		// schema, and, if the v2 schema is found, make it the resulting schema for
		// the type.
		if schema, ok := v.Schema.Extensions[common.ExtensionV2Schema]; ok {
			if v2Schema, isOpenAPISchema := schema.(spec.Schema); isOpenAPISchema {
				openApiGenerator.PutDefinition(openShiftModule.ApiName(k), v2Schema)
				continue
			}
		}
		openApiGenerator.PutDefinition(openShiftModule.ApiName(k), v.Schema)
	}
	if err := openApiGenerator.WriteDefinitions(); err != nil {
		panic(fmt.Errorf("error writing OpenAPI schema: %w", err))
	}
	fmt.Printf("OpenAPI JSON schema generation completed in %v\n", time.Since(startTime))
}
