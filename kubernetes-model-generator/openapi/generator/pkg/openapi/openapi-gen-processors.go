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

package openapi

import (
	"k8s.io/gengo/v2"
	"k8s.io/gengo/v2/generator"
	"k8s.io/gengo/v2/types"
	"reflect"
	"strings"
	"unicode"
)

// processMapKeyTypes function to process the map key types and replace them by string in case they are not
// kube-openapi throws a validation error for maps that have non-string keys such as uint32
// https://github.com/kubernetes/kube-openapi/blob/67ed5848f094e4cd74f5bdc458cd98f12767c538/pkg/generators/openapi.go#L1062-L1065
// Example errors:
// - failed to generate map property in k8s.io/autoscaler/vertical-pod-autoscaler/pkg/apis/autoscaling.k8s.io/v1.HistogramCheckpoint: BucketWeights: map with non-string keys are not supported by OpenAPI in map[int]uint32
// - failed to generate map property in istio.io/api/security/v1beta1.PeerAuthentication: PortLevelMtls: map with non-string keys are not supported by OpenAPI in map[uint32]*istio.io/api/security/v1beta1.PeerAuthentication_MutualTLS
func processMapKeyTypes(context *generator.Context, _ *types.Package, t *types.Type, m *types.Member, memberIndex int) {
	if m.Type.Kind == types.Map && m.Type.Key != nil && m.Type.Key.Name.Name != "string" {
		t.Members[memberIndex].Type.Key = context.Universe.Type(types.Name{Name: "string"})
	}
}

// processOmitPrivateFields
// Ignore private fields by adding the json:"-" tag
func processOmitPrivateFields(_ *generator.Context, _ *types.Package, t *types.Type, m *types.Member, memberIndex int) {
	// Skip types that are not exported
	if !unicode.IsUpper(rune(m.Name[0])) {
		t.Members[memberIndex].Tags = "json:\"-\""
	}
}

var patchTags = []string{"patchStrategy", "patchMergeKey"}

// processPatchComments function to process the patchStrategy and patchMergeKey comment tags and add them to the field tags if necessary
// See https://github.com/fabric8io/kubernetes-client/issues/6426#issuecomment-2431653451
func processPatchComments(_ *generator.Context, _ *types.Package, t *types.Type, m *types.Member, memberIndex int) {
	for _, patchTag := range patchTags {
		tag := reflect.StructTag(m.Tags).Get(patchTag)
		if tag != "" {
			continue // Value already set, there is no problem
		}
		tags, ok := gengo.ExtractCommentTags("+", m.CommentLines)[patchTag]
		if ok {
			t.Members[memberIndex].Tags = t.Members[memberIndex].Tags + " " + patchTag + ":\"" + tags[0] + "\""
		}
	}
}

// func processProtobufOneof
// To generate interfaces and extending classes for oneof fields
// This is something extensively used in the Istio API, that uses these as marker interfaces
func processProtobufOneof(_ *generator.Context, pkg *types.Package, t *types.Type, m *types.Member, memberIndex int) {
	publicInterfaceName := func(name string) string {
		if unicode.IsUpper(rune(name[0])) {
			return name
		}
		return string(unicode.ToUpper(rune(name[0]))) + name[1:]
	}
	// Interfaces
	protobufOneOf := reflect.StructTag(m.Tags).Get("protobuf_oneof")
	if protobufOneOf != "" {
		// kube-openapi doesn't handle interfaces, so we need to change the interface to a struct
		m.Type.Kind = types.Struct
		// Ensure it's exported
		t.Members[memberIndex].Type.Name.Name = publicInterfaceName(m.Type.Name.Name)
		// Add comment tag to mark this as an interface, this is later processed by kube-openapi and added to the OpenAPI json spec
		m.Type.CommentLines = append(m.Type.CommentLines, "+k8s:openapi-gen=x-kubernetes-fabric8-type:interface")
	}
	// Implementations
	// It's just a marker interface, it contains a single method that has the same name as the interface
	protobuf := reflect.StructTag(m.Tags).Get("protobuf")
	// This is a member field of a Type implementing an interface
	if protobuf != "" && strings.Contains(protobuf, "oneof") && len(t.Methods) == 1 {
		for _, candidateType := range pkg.Types {
			if candidateType.Kind != types.Interface || len(candidateType.Methods) != 1 {
				continue
			}
			if reflect.ValueOf(t.Methods).MapKeys()[0].String() == reflect.ValueOf(candidateType.Methods).MapKeys()[0].String() {
				t.CommentLines = append(t.CommentLines, "+k8s:openapi-gen=x-kubernetes-fabric8-implements:"+publicInterfaceName(candidateType.Name.Name))
			}
		}
	}
}

// processProtobufTags function to process the protobuf field tags and fix json tags that might have mismatched names for serialization
// This happens for most of the istio APIs
func processProtobufTags(_ *generator.Context, _ *types.Package, t *types.Type, m *types.Member, memberIndex int) {
	tags := reflect.StructTag(m.Tags)
	protobufTag := tags.Get("protobuf")
	jsonTag := tags.Get("json")
	if protobufTag != "" && jsonTag != "" && strings.Contains(protobufTag, "json=") {
		name := strings.Split(protobufTag, "json=")[1]
		name = strings.Split(name, ",")[0]
		var updatedJsonTag string
		if strings.Contains(jsonTag, ",") {
			updatedJsonTag = name + "," + strings.Split(jsonTag, ",")[1]
		} else {
			updatedJsonTag = name
		}
		t.Members[memberIndex].Tags = strings.Replace(t.Members[memberIndex].Tags, jsonTag, updatedJsonTag, 1)
	}
}

// processSwaggerIgnore function to process the swaggerignore tag and add json:omitted so that kube-openapi ignores the field.
func processSwaggerIgnore(_ *generator.Context, _ *types.Package, t *types.Type, m *types.Member, memberIndex int) {
	swaggerIgnore := reflect.StructTag(m.Tags).Get("swaggerignore")
	if swaggerIgnore != "" {
		jsonTag := reflect.StructTag(m.Tags).Get("json")
		if jsonTag == "" {
			t.Members[memberIndex].Tags = m.Tags + " json:\"-\""
		} else {
			t.Members[memberIndex].Tags = strings.Replace(m.Tags, jsonTag, ",omitted", 1)
		}
	}
}
