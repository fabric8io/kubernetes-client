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

// Package openapi
package openapi

import (
	"encoding/json"
	"fmt"
	"github.com/fabric8io/kubernetes-client/kubernetes-model-generator/openapi/generator/pkg/parser"
	"k8s.io/kube-openapi/pkg/common"
	"k8s.io/kube-openapi/pkg/validation/spec"
	"os"
	"path/filepath"
)

type JsonGenerator interface {
	WriteDefinitions() error
}

type jsonGenerator struct {
	name            string
	targetDirectory string
	definitions     map[string]spec.Schema
	parserModule    *parser.Module
}

func NewGenerator(
	targetDirectory string,
	name string,
	getDefinitionsFunc func(callback common.ReferenceCallback) map[string]common.OpenAPIDefinition,
	patterns ...string,
) JsonGenerator {
	g := &jsonGenerator{
		name:            name,
		targetDirectory: targetDirectory,
		definitions:     make(map[string]spec.Schema),
		parserModule:    parser.NewModule(patterns...),
	}
	defs := getDefinitionsFunc(g.refFunc)
	// Ported and adapted from github.com/openshift/api/openapi/cmd/models-schema/main.go
	// https://github.com/openshift/api/blob/b1f700bdd8d22c4033be4e4e9ef751d89ade42e8/openapi/cmd/models-schema/main.go#L30-L44
	for k, v := range defs {
		g.addFabric8Info(k, &v)
		// Replace top-level schema with v2 if a v2 schema is embedded
		// so that the output of this program is always in OpenAPI v2.
		// This is done by looking up an extension that marks the embedded v2
		// schema, and, if the v2 schema is found, make it the resulting schema for
		// the type.
		if schema, ok := v.Schema.Extensions[common.ExtensionV2Schema]; ok {
			if v2Schema, isOpenAPISchema := schema.(spec.Schema); isOpenAPISchema {
				g.definitions[g.parserModule.ApiName(k)] = v2Schema
				continue
			}
		}
		g.definitions[g.parserModule.ApiName(k)] = v.Schema
	}
	return g
}

// Ported and adapted from github.com/openshift/api/openapi/cmd/models-schema/main.go
// https://github.com/openshift/api/blob/b1f700bdd8d22c4033be4e4e9ef751d89ade42e8/openapi/cmd/models-schema/main.go#L25-L27
func (g *jsonGenerator) refFunc(name string) spec.Ref {
	return spec.MustCreateRef(fmt.Sprintf("#/definitions/%s", g.parserModule.ApiName(name)))
}

func (g *jsonGenerator) addFabric8Info(k string, v *common.OpenAPIDefinition) {
	// Marc: Use gengo to complete information for the definition
	fabric8Info := g.parserModule.ExtractInfo(k)
	if v.Schema.ExtraProps == nil {
		v.Schema.ExtraProps = make(map[string]interface{})
	}
	v.Schema.ExtraProps["x-fabric8-info"] = fabric8Info
}

func (g *jsonGenerator) WriteDefinitions() error {
	data, err := json.MarshalIndent(&spec.Swagger{
		SwaggerProps: spec.SwaggerProps{
			Definitions: g.definitions,
			Info: &spec.Info{
				InfoProps: spec.InfoProps{
					Title:   "Kubernetes",
					Version: "0.0.0",
				},
			},
			Swagger: "2.0",
		},
	}, "", "  ")
	if err != nil {
		return fmt.Errorf("error serializing OpenAPI schema: %w", err)
	}
	err = os.WriteFile(filepath.Join(g.targetDirectory, g.name+".json"), data, 0644)
	if err != nil {
		return fmt.Errorf("error writing OpenAPI schema: %w", err)
	}
	return nil
}
