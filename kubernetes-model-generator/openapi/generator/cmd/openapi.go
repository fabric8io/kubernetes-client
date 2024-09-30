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
	"github.com/fabric8io/kubernetes-client/kubernetes-model-generator/openapi/generator/pkg/parser"
	"github.com/openshift/api/openapi/generated_openapi"
	"github.com/spf13/cobra"
	"k8s.io/kube-openapi/pkg/common"
	"k8s.io/kube-openapi/pkg/validation/spec"
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
	var targetDirectory string
	if len(args) > 0 {
		targetDirectory = args[0]
	} else {
		targetDirectory = "."
	}
	openApiGenerator := openapi.NewGenerator(targetDirectory, "openshift-generated")
	openShiftModule := parser.NewModule("github.com/openshift/api")
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
}
