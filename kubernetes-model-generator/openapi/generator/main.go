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
	v1admission "k8s.io/api/admission/v1"
	v1beta1admission "k8s.io/api/admission/v1beta1"
	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
	configapi "k8s.io/client-go/tools/clientcmd/api/v1"
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
		{[]reflect.Type{reflect.TypeOf(configapi.Config{})}, "kubernetes-config"},
		{[]reflect.Type{
			reflect.TypeOf(v1admission.AdmissionRequest{}),
			reflect.TypeOf(v1beta1admission.AdmissionRequest{}),
		}, "admission-registration"},
		{[]reflect.Type{
			reflect.TypeOf(metav1.MicroTime{}),
			//	reflect.TypeOf(metav1.GroupKind{}),
			//	reflect.TypeOf(metav1.GroupVersionKind{}),
			//	reflect.TypeOf(metav1.GroupVersionResource{}),
		}, "api-machinery-extra"},
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
	for it := 0; it < t.NumField(); it++ {
		field := t.Field(it)
		fieldName := field.Tag.Get("json")
		if len(fieldName) == 0 {
			fieldName = field.Name
		}
		if strings.Index(fieldName, ",") > 0 {
			fieldName = strings.Split(fieldName, ",")[0]
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
