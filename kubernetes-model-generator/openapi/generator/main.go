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
	admissionregistrationV1 "k8s.io/api/admissionregistration/v1"
	coreV1 "k8s.io/api/core/v1"
	apiextensionsV1 "k8s.io/apiextensions-apiserver/pkg/apis/apiextensions/v1"
	apiextensionsV1Beta1 "k8s.io/apiextensions-apiserver/pkg/apis/apiextensions/v1beta1"
	metaV1 "k8s.io/apimachinery/pkg/apis/meta/v1"
	configapiV1 "k8s.io/client-go/tools/clientcmd/api/v1"
	metricsV1Beta1 "k8s.io/metrics/pkg/apis/metrics/v1beta1"
	"os"
	"path/filepath"
	"reflect"
	gatewayApiV1 "sigs.k8s.io/gateway-api/apis/v1"
	gatewayApiV1Beta1 "sigs.k8s.io/gateway-api/apis/v1beta1"
	kustomize "sigs.k8s.io/kustomize/api/types"
	"strings"
	"time"
)

type Schema struct {
	Types []reflect.Type
	Name  string
	Paths map[reflect.Type]string
}

func NewTypeSchema(types []reflect.Type, name string) Schema {
	return Schema{types, name, make(map[reflect.Type]string)}
}

func NewPathSchema(paths map[reflect.Type]string, name string) Schema {
	schema := Schema{make([]reflect.Type, 0), name, paths}
	for t := range paths {
		schema.Types = append(schema.Types, t)

	}
	return schema
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
	schemas := []Schema{
		NewTypeSchema([]reflect.Type{reflect.TypeOf(configapiV1.Config{})}, "kubernetes-config"),
		NewTypeSchema([]reflect.Type{
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
			reflect.TypeOf(metaV1.TypeMeta{}), // TODO: can be removed, it's an inline type not directly used
		}, "api-machinery-extra"),
		NewTypeSchema([]reflect.Type{
			reflect.TypeOf(admissionV1.AdmissionReview{}),
			reflect.TypeOf(admissionV1Beta1.AdmissionReview{}),
			reflect.TypeOf(admissionregistrationV1.Rule{}),
		}, "admission-registration"),
		NewTypeSchema([]reflect.Type{
			reflect.TypeOf(apiextensionsV1.ConversionReview{}),
			reflect.TypeOf(apiextensionsV1.JSONSchemaPropsOrArray{}),
			reflect.TypeOf(apiextensionsV1.JSONSchemaPropsOrBool{}),
			reflect.TypeOf(apiextensionsV1.JSONSchemaPropsOrStringArray{}),
			reflect.TypeOf(apiextensionsV1Beta1.ConversionReview{}),
			reflect.TypeOf(apiextensionsV1Beta1.JSONSchemaPropsOrArray{}),
			reflect.TypeOf(apiextensionsV1Beta1.JSONSchemaPropsOrBool{}),
			reflect.TypeOf(apiextensionsV1Beta1.JSONSchemaPropsOrStringArray{}),
			reflect.TypeOf(apiextensionsV1Beta1.SelectableField{}),
			reflect.TypeOf(apiextensionsV1Beta1.ValidationRule{}),
		}, "apiextensions"),
		NewPathSchema(map[reflect.Type]string{
			reflect.TypeOf(gatewayApiV1.GatewayList{}):             "/apis/" + gatewayApiV1.GroupName + "/v1/namespaces/{namespace}/gateways",
			reflect.TypeOf(gatewayApiV1.Gateway{}):                 "/apis/" + gatewayApiV1.GroupName + "/v1/namespaces/{namespace}/gateways/{name}",
			reflect.TypeOf(gatewayApiV1.GatewayClassList{}):        "/apis/" + gatewayApiV1.GroupName + "/v1/gatewayclasses",
			reflect.TypeOf(gatewayApiV1.GatewayClass{}):            "/apis/" + gatewayApiV1.GroupName + "/v1/gatewayclasses/{name}",
			reflect.TypeOf(gatewayApiV1.HTTPRouteList{}):           "/apis/" + gatewayApiV1.GroupName + "/v1/namespaces/{namespace}/httproutes",
			reflect.TypeOf(gatewayApiV1.HTTPRoute{}):               "/apis/" + gatewayApiV1.GroupName + "/v1/namespaces/{namespace}/httproutes/{name}",
			reflect.TypeOf(gatewayApiV1Beta1.GatewayList{}):        "/apis/" + gatewayApiV1.GroupName + "/v1beta1/namespaces/{namespace}/gateways",
			reflect.TypeOf(gatewayApiV1Beta1.Gateway{}):            "/apis/" + gatewayApiV1.GroupName + "/v1beta1/namespaces/{namespace}/gateways/{name}",
			reflect.TypeOf(gatewayApiV1Beta1.GatewayClassList{}):   "/apis/" + gatewayApiV1.GroupName + "/v1beta1/gatewayclasses",
			reflect.TypeOf(gatewayApiV1Beta1.GatewayClass{}):       "/apis/" + gatewayApiV1.GroupName + "/v1beta1/gatewayclasses/{name}",
			reflect.TypeOf(gatewayApiV1Beta1.HTTPRouteList{}):      "/apis/" + gatewayApiV1.GroupName + "/v1beta1/namespaces/{namespace}/httproutes",
			reflect.TypeOf(gatewayApiV1Beta1.HTTPRoute{}):          "/apis/" + gatewayApiV1.GroupName + "/v1beta1/namespaces/{namespace}/httproutes/{name}",
			reflect.TypeOf(gatewayApiV1Beta1.ReferenceGrantList{}): "/apis/" + gatewayApiV1.GroupName + "/v1beta1/namespaces/{namespace}/referencegrants",
			reflect.TypeOf(gatewayApiV1Beta1.ReferenceGrant{}):     "/apis/" + gatewayApiV1.GroupName + "/v1beta1/namespaces/{namespace}/referencegrants/{name}",
		}, "gateway-api"),
		NewTypeSchema([]reflect.Type{
			reflect.TypeOf(kustomize.Kustomization{}),
		}, "kustomize"),
		NewPathSchema(map[reflect.Type]string{
			reflect.TypeOf(metricsV1Beta1.NodeMetricsList{}): "/apis/" + metricsV1Beta1.SchemeGroupVersion.String() + "/nodes",
			reflect.TypeOf(metricsV1Beta1.NodeMetrics{}):     "/apis/" + metricsV1Beta1.SchemeGroupVersion.String() + "/nodes/{name}",
			reflect.TypeOf(metricsV1Beta1.PodMetricsList{}):  "/apis/" + metricsV1Beta1.SchemeGroupVersion.String() + "/namespaces/{namespace}/pods",
			reflect.TypeOf(metricsV1Beta1.PodMetrics{}):      "/apis/" + metricsV1Beta1.SchemeGroupVersion.String() + "/namespaces/{namespace}/pods/{name}",
		}, "metrics"),
	}
	generate(schemas, targetDirectory)
}

func generate(schemas []Schema, targetDirectory string) {
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
			Paths: extractPaths(schema.Paths),
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
	// Nested pointers
	if t.Kind() == reflect.Ptr {
		generateType(schemas, t.Elem())
		return
	}
	// Types can only be generated for Structs (only ones that contain fields)
	if t.Kind() != reflect.Struct {
		return
	}
	if schemas[getKey(t)] != nil {
		// Prevent cycles
		return
	}
	value := &openapi3.SchemaRef{Value: openapi3.NewObjectSchema()}
	schemas[getKey(t)] = value

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
			Value: &openapi3.Schema{
				Type:   &openapi3.Types{openapi3.TypeInteger},
				Format: "int32",
			},
		}
	case reflect.Int64, reflect.Uint64:
		return &openapi3.SchemaRef{
			Value: openapi3.NewInt64Schema(),
		}
	case reflect.Float32, reflect.Float64, reflect.Complex64, reflect.Complex128:
		return &openapi3.SchemaRef{
			Value: &openapi3.Schema{
				Type:   &openapi3.Types{openapi3.TypeNumber},
				Format: "double",
			},
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
		return &openapi3.SchemaRef{
			Value: openapi3.NewObjectSchema(),
		}
	}
}

// Create fake paths so that the OpenAPI generator can compute group, version, plural, scope (namespaced/cluster)
func extractPaths(paths map[reflect.Type]string) *openapi3.Paths {
	oApiPaths := openapi3.NewPaths()
	for t, path := range paths {
		pathItem := &openapi3.PathItem{}
		pathItem.Get = openapi3.NewOperation()
		pathItem.Get.AddResponse(200, openapi3.NewResponse().WithDescription("OK").WithJSONSchemaRef(&openapi3.SchemaRef{
			Ref: "#/components/schemas/" + getKey(t),
		}))
		if strings.Contains(path, "{namespace}") {
			pathItem.Get.AddParameter(openapi3.NewPathParameter("namespace"))
		}
		if strings.Contains(path, "{name}") {
			pathItem.Get.AddParameter(openapi3.NewPathParameter("name"))
		}
		oApiPaths.Set(path, pathItem)

	}
	return oApiPaths
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
