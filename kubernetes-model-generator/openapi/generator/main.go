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
	"github.com/getkin/kin-openapi/openapi3"
	admissionV1 "k8s.io/api/admission/v1"
	admissionV1Beta1 "k8s.io/api/admission/v1beta1"
	coreV1 "k8s.io/api/core/v1"
	apiextensionsV1 "k8s.io/apiextensions-apiserver/pkg/apis/apiextensions/v1"
	apiextensionsV1Beta1 "k8s.io/apiextensions-apiserver/pkg/apis/apiextensions/v1beta1"
	metaV1 "k8s.io/apimachinery/pkg/apis/meta/v1"
	configapiV1 "k8s.io/client-go/tools/clientcmd/api/v1"
	"os"
	"path/filepath"
	"reflect"
	"strings"
	"time"
)

type Schemas struct {
	Types []reflect.Type
	Name  string
}

func main() {
	var targetDirectory string
	if len(os.Args) > 1 {
		targetDirectory = os.Args[1]
	} else {
		targetDirectory = "."
	}
	err := os.MkdirAll(targetDirectory, 0755)
	if err != nil {
		panic(err)
	}
	schemas := []Schemas{
		{[]reflect.Type{reflect.TypeOf(configapiV1.Config{})}, "kubernetes-config"},
		{[]reflect.Type{
			reflect.TypeOf(metaV1.MicroTime{}),
			reflect.TypeOf(metaV1.CreateOptions{}),
			reflect.TypeOf(metaV1.DeleteOptions{}),
			reflect.TypeOf(metaV1.GetOptions{}),
			reflect.TypeOf(metaV1.ListOptions{}),
			reflect.TypeOf(metaV1.PatchOptions{}),
			reflect.TypeOf(metaV1.UpdateOptions{}),
			reflect.TypeOf(coreV1.PodExecOptions{}),
			reflect.TypeOf(metaV1.RootPaths{}),
			reflect.TypeOf(metaV1.GroupKind{}),
		}, "api-machinery-extra"},
		{[]reflect.Type{
			reflect.TypeOf(admissionV1.AdmissionRequest{}),
			reflect.TypeOf(admissionV1Beta1.AdmissionRequest{}),
		}, "admission-registration"},
		{[]reflect.Type{
			reflect.TypeOf(apiextensionsV1.ConversionReview{}),
			reflect.TypeOf(apiextensionsV1Beta1.ConversionReview{}),
			reflect.TypeOf(apiextensionsV1Beta1.SelectableField{}),
			reflect.TypeOf(apiextensionsV1Beta1.ValidationRule{}),
		}, "apiextensions"},
	}
	generate(schemas, targetDirectory)
}

func generate(schemas []Schemas, targetDirectory string) {
	for _, schema := range schemas {
		swagger := &openapi3.T{
			OpenAPI: "3.0.0",
			Info: &openapi3.Info{
				Title:   schema.Name,
				Version: "0.0.0",
			},
			Components: &openapi3.Components{
				Schemas: extractSchemas(schema.Types),
			},
			Paths: &openapi3.Paths{},
		}
		json, err := swagger.MarshalJSON()
		if err != nil {
			panic(err)
		}
		err = os.WriteFile(filepath.Join(targetDirectory, schema.Name+".json"), json, 0644)
		if err != nil {
			panic(err)
		}
	}
}

func extractSchemas(types []reflect.Type) openapi3.Schemas {
	schemas := make(openapi3.Schemas)
	for _, t := range types {
		generateType(schemas, t)
	}
	return schemas
}

func generateType(schemas openapi3.Schemas, t reflect.Type) {
	if t.Kind() != reflect.Struct {
		return
	}
	value := &openapi3.SchemaRef{Value: openapi3.NewObjectSchema()}
	value.Value.Properties = make(map[string]*openapi3.SchemaRef)
	// Gather fields
	fields := extractFields(make([]reflect.StructField, 0), t)
	// Process fields
	for _, field := range fields {
		var fieldName string
		jsonTag := field.Tag.Get("json")
		if len(jsonTag) > 0 {
			fieldName = strings.Split(jsonTag, ",")[0]
		} else {
			fieldName = field.Name
		}
		value.Value.Properties[fieldName] = openApiKind(field.Type)

		// Recurse to generate the schema for the subtypes
		switch field.Type.Kind() {
		case reflect.Struct:
			if field.Type != reflect.TypeOf(time.Time{}) {
				generateType(schemas, field.Type)
			}
		case reflect.Ptr, reflect.Array, reflect.Slice:
			generateType(schemas, field.Type.Elem())
		}
	}
	schemas[getKey(t)] = value
}

func extractFields(fields []reflect.StructField, t reflect.Type) []reflect.StructField {
	for it := 0; it < t.NumField(); it++ {
		field := t.Field(it)
		jsonTag := field.Tag.Get("json")
		// Fields to Skip
		if len(field.PkgPath) > 0 || // Private fields
			strings.Index(jsonTag, "-,") == 0 { //unserialized fields
			continue
		}
		if field.Anonymous && strings.Index(jsonTag, ",inline") == 0 {
			// Inlined fields
			fields = extractFields(fields, field.Type)
		} else {
			// Standard fields
			fields = append(fields, field)
		}
	}
	return fields
}

func openApiKind(t reflect.Type) *openapi3.SchemaRef {
	stringSchema := &openapi3.SchemaRef{
		Value: openapi3.NewStringSchema(),
	}
	switch t.Kind() {
	case reflect.Ptr:
		return openApiKind(t.Elem())
	case reflect.Struct:
		if t == reflect.TypeOf(time.Time{}) {
			return stringSchema
		}
		return &openapi3.SchemaRef{
			Ref: "#/components/schemas/" + getKey(t),
		}
	case reflect.String:
		return stringSchema
	case reflect.Bool:
		return &openapi3.SchemaRef{
			Value: openapi3.NewBoolSchema(),
		}
	case reflect.Int, reflect.Int8, reflect.Int16, reflect.Int32, reflect.Uint, reflect.Uint8, reflect.Uint16, reflect.Uint32:
		return &openapi3.SchemaRef{
			Value: openapi3.NewIntegerSchema(),
		}
	case reflect.Int64, reflect.Uint64:
		return &openapi3.SchemaRef{
			Value: openapi3.NewInt64Schema(),
		}
	case reflect.Array, reflect.Slice:
		// Byte-arrays as String (Fabric8)
		if t.Elem().Kind() == reflect.Uint8 {
			return stringSchema
		}
		return &openapi3.SchemaRef{
			Value: &openapi3.Schema{
				Type:  &openapi3.Types{openapi3.TypeArray},
				Items: openApiKind(t.Elem()),
			},
		}
	case reflect.Map:
		return &openapi3.SchemaRef{
			Value: &openapi3.Schema{
				Type: &openapi3.Types{openapi3.TypeObject},
				AdditionalProperties: openapi3.AdditionalProperties{
					Schema: openApiKind(t.Elem()),
				},
			},
		}
	default:
		println("unhandled default case " + t.Kind().String())
		return stringSchema
	}
}

func getKey(t reflect.Type) string {
	pkg := ""
	for _, segment := range strings.Split(t.PkgPath(), "/") {
		domainParts := strings.Split(segment, ".")
		for i := len(domainParts) - 1; i >= 0; i-- {
			if len(pkg) > 0 {
				pkg += "."
			}
			pkg += domainParts[i]
		}
	}
	return pkg + "." + t.Name()
}
