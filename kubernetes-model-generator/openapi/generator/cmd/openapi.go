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
	"github.com/spf13/cobra"
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
	fmt.Println("OpenAPI JSON schema generation started...")
	var targetDirectory string
	if len(args) > 0 {
		targetDirectory = args[0]
	} else {
		targetDirectory = "."
	}
	openApiGenerator := openapi.NewGenerator(
		targetDirectory,
		"openshift-generated",
		generated_openapi.GetOpenAPIDefinitions,
		openshift.PackagePatterns...,
	)
	if err := openApiGenerator.WriteDefinitions(); err != nil {
		panic(fmt.Errorf("error writing OpenAPI schema: %w", err))
	}
	fmt.Printf("OpenAPI JSON schema generation completed in %v\n", time.Since(startTime))
}
