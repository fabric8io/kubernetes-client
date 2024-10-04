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
	"github.com/spf13/cobra"
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
	clusterapiv1beta1 "sigs.k8s.io/cluster-api/api/v1beta1"
	gatewayApiV1 "sigs.k8s.io/gateway-api/apis/v1"
	gatewayApiV1Beta1 "sigs.k8s.io/gateway-api/apis/v1beta1"
	kustomize "sigs.k8s.io/kustomize/api/types"
	"strings"
	"time"
)

var reflection = &cobra.Command{
	Use:   "reflection [targetDirectory]",
	Short: "Generate OpenAPI definitions from Go type reflection",
	Args:  cobra.MaximumNArgs(1),
	Run:   reflectionRun,
}

func init() {
	rootCmd.AddCommand(reflection)
}

var reflectionRun = func(cmd *cobra.Command, args []string) {
	var targetDirectory string
	if len(args) > 0 {
		targetDirectory = args[0]
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
		// Webhooks, add fake paths so that Maven OpenAPI plugin adds deserialization type information
		NewPathSchema(map[reflect.Type]ApiVersion{
			reflect.TypeOf(admissionV1.AdmissionReview{}):      {false, admissionV1.SchemeGroupVersion.String(), "admissionreviews", false},
			reflect.TypeOf(admissionV1Beta1.AdmissionReview{}): {false, admissionV1Beta1.SchemeGroupVersion.String(), "admissionreviews", false},
			reflect.TypeOf(admissionregistrationV1.Rule{}):     {},
		}, "admission-registration"),
		// Webhooks, add fake paths so that Maven OpenAPI plugin adds deserialization type information
		NewPathSchema(map[reflect.Type]ApiVersion{
			reflect.TypeOf(apiextensionsV1.ConversionReview{}):                  {false, apiextensionsV1.SchemeGroupVersion.String(), "conversionreviews", false},
			reflect.TypeOf(apiextensionsV1.JSONSchemaPropsOrArray{}):            {},
			reflect.TypeOf(apiextensionsV1.JSONSchemaPropsOrBool{}):             {},
			reflect.TypeOf(apiextensionsV1.JSONSchemaPropsOrStringArray{}):      {},
			reflect.TypeOf(apiextensionsV1Beta1.JSONSchemaPropsOrArray{}):       {},
			reflect.TypeOf(apiextensionsV1Beta1.JSONSchemaPropsOrBool{}):        {},
			reflect.TypeOf(apiextensionsV1Beta1.JSONSchemaPropsOrStringArray{}): {},
			reflect.TypeOf(apiextensionsV1Beta1.SelectableField{}):              {},
			reflect.TypeOf(apiextensionsV1Beta1.ValidationRule{}):               {},
		}, "apiextensions"),
		NewTypeSchema([]reflect.Type{
			reflect.TypeOf(clusterapiv1beta1.Condition{}),
			reflect.TypeOf(clusterapiv1beta1.Machine{}),
		}, "cluster-api"),
		NewPathSchema(map[reflect.Type]ApiVersion{
			reflect.TypeOf(gatewayApiV1.GatewayList{}):             {true, gatewayApiV1.GroupVersion.String(), "gateways", true},
			reflect.TypeOf(gatewayApiV1.Gateway{}):                 {false, gatewayApiV1.GroupVersion.String(), "gateways", true},
			reflect.TypeOf(gatewayApiV1.GatewayClassList{}):        {true, gatewayApiV1.GroupVersion.String(), "gatewayclasses", false},
			reflect.TypeOf(gatewayApiV1.GatewayClass{}):            {false, gatewayApiV1.GroupVersion.String(), "gatewayclasses", false},
			reflect.TypeOf(gatewayApiV1.HTTPRouteList{}):           {true, gatewayApiV1.GroupVersion.String(), "httproutes", true},
			reflect.TypeOf(gatewayApiV1.HTTPRoute{}):               {false, gatewayApiV1.GroupVersion.String(), "httproutes", true},
			reflect.TypeOf(gatewayApiV1Beta1.GatewayList{}):        {true, gatewayApiV1Beta1.GroupVersion.String(), "gateways", true},
			reflect.TypeOf(gatewayApiV1Beta1.Gateway{}):            {false, gatewayApiV1Beta1.GroupVersion.String(), "gateways", true},
			reflect.TypeOf(gatewayApiV1Beta1.GatewayClassList{}):   {true, gatewayApiV1Beta1.GroupVersion.String(), "gatewayclasses", false},
			reflect.TypeOf(gatewayApiV1Beta1.GatewayClass{}):       {false, gatewayApiV1Beta1.GroupVersion.String(), "gatewayclasses", false},
			reflect.TypeOf(gatewayApiV1Beta1.HTTPRouteList{}):      {true, gatewayApiV1Beta1.GroupVersion.String(), "httproutes", true},
			reflect.TypeOf(gatewayApiV1Beta1.HTTPRoute{}):          {false, gatewayApiV1Beta1.GroupVersion.String(), "httproutes", true},
			reflect.TypeOf(gatewayApiV1Beta1.ReferenceGrantList{}): {true, gatewayApiV1Beta1.GroupVersion.String(), "referencegrants", true},
			reflect.TypeOf(gatewayApiV1Beta1.ReferenceGrant{}):     {false, gatewayApiV1Beta1.GroupVersion.String(), "referencegrants", true},
		}, "gateway-api"),
		NewTypeSchema([]reflect.Type{
			reflect.TypeOf(kustomize.Kustomization{}),
		}, "kustomize"),
		NewPathSchema(map[reflect.Type]ApiVersion{
			reflect.TypeOf(metricsV1Beta1.NodeMetricsList{}): {true, metricsV1Beta1.SchemeGroupVersion.String(), "nodes", false},
			reflect.TypeOf(metricsV1Beta1.NodeMetrics{}):     {false, metricsV1Beta1.SchemeGroupVersion.String(), "nodes", false},
			reflect.TypeOf(metricsV1Beta1.PodMetricsList{}):  {true, metricsV1Beta1.SchemeGroupVersion.String(), "pods", true},
			reflect.TypeOf(metricsV1Beta1.PodMetrics{}):      {false, metricsV1Beta1.SchemeGroupVersion.String(), "pods", true},
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
	// Skip generation of overridden types
	if mappingOverrides[t] != "" {
		return
	}
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
	if mappingOverrides[t] != "" {
		return &openapi3.SchemaRef{
			Ref: mappingOverrides[t],
		}
	}
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
func extractPaths(apiVersions map[reflect.Type]ApiVersion) *openapi3.Paths {
	oApiPaths := openapi3.NewPaths()
	for t, apiVersion := range apiVersions {
		if apiVersion.GroupVersion == "" {
			continue
		}
		pathItem := &openapi3.PathItem{}
		pathItem.Get = openapi3.NewOperation()
		pathItem.Get.AddResponse(200, openapi3.NewResponse().WithDescription("OK").WithJSONSchemaRef(&openapi3.SchemaRef{
			Ref: "#/components/schemas/" + getKey(t),
		}))
		pathItem.Get.Extensions = make(map[string]interface{})
		pathItem.Get.Extensions["x-kubernetes-group-version-kind"] = map[string]interface{}{
			"group":   strings.Split(apiVersion.GroupVersion, "/")[0],
			"version": strings.Split(apiVersion.GroupVersion, "/")[1],
			"kind":    t.Name(),
		}
		path := "/apis/" + apiVersion.GroupVersion
		if apiVersion.Namespaced {
			path += "/namespaces/{namespace}"
			pathItem.Get.AddParameter(openapi3.NewPathParameter("namespace"))
		}
		path += "/" + apiVersion.Plural
		if !apiVersion.List {
			path += "/{name}"
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
