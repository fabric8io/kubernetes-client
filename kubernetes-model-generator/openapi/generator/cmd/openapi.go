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

import "github.com/spf13/cobra"

var openApi = &cobra.Command{
	Use:   "open-api [targetDirectory]",
	Short: "Generate OpenAPI definitions from OpenAPI/Swagger schema definitions in codegen and openapi-gen zz_generated files",
	Run:   openApiRun,
}

func init() {
	rootCmd.AddCommand(openApi)
}

var openApiRun = func(cobraCmd *cobra.Command, args []string) {

}
