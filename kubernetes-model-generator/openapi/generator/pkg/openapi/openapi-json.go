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
	"k8s.io/kube-openapi/pkg/validation/spec"
	"os"
	"path/filepath"
	"strings"
)

type JsonGenerator struct {
	name            string
	targetDirectory string
	definitions     map[string]spec.Schema
}

func NewGenerator(targetDirectory string, name string) *JsonGenerator {
	return &JsonGenerator{
		name:            name,
		targetDirectory: targetDirectory,
		definitions:     make(map[string]spec.Schema),
	}
}

func (g *JsonGenerator) PutDefinition(name string, schema spec.Schema) {
	g.definitions[name] = schema
}

func (g *JsonGenerator) WriteDefinitions() error {
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

// FriendlyName returns an OpenAPI friendly name for the given name.
// From vendor/k8s.io/apiserver/pkg/endpoints/openapi/openapi.go
// https://github.com/kubernetes/apiserver/blob/60d1ca672541e1b30b558e32e53cad7c172345a6/pkg/endpoints/openapi/openapi.go#L136-L147
func FriendlyName(name string) string {
	nameParts := strings.Split(name, "/")
	// Reverse first part. e.g., io.k8s... instead of k8s.io...
	if len(nameParts) > 0 && strings.Contains(nameParts[0], ".") {
		parts := strings.Split(nameParts[0], ".")
		for i, j := 0, len(parts)-1; i < j; i, j = i+1, j-1 {
			parts[i], parts[j] = parts[j], parts[i]
		}
		nameParts[0] = strings.Join(parts, ".")
	}
	return strings.Join(nameParts, ".")
}
