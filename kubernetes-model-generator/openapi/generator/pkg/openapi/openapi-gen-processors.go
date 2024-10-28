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
	"go/ast"
	"go/parser"
	"go/token"
	"k8s.io/gengo/v2"
	"k8s.io/gengo/v2/generator"
	"k8s.io/gengo/v2/types"
	"reflect"
	"strconv"
	"strings"
	"unicode"
)

const (
	XKubernetesFabric8Type = "+k8s:openapi-gen=x-kubernetes-fabric8-type"
)

var astFileSet = token.NewFileSet()

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

func processProtobufEnumsForIstio(_ *generator.Context, pkg *types.Package, _ *types.Type, m *types.Member, memberIndex int) {
	protobuf := reflect.StructTag(m.Tags).Get("protobuf")
	if protobuf == "" || !strings.Contains(protobuf, "enum=") {
		return
	}
	hp, _ := hasPrefix(m.Type.CommentLines, XKubernetesFabric8Type+":enum")
	if hp {
		return
	}
	istioEnumExtractor := &IstioEnumExtractor{pkg: pkg, typeName: m.Type.Name.Name + "_value"}
	if istioEnumExtractor.extract() {
		// Export the type
		m.Type.Kind = types.Struct // Change to Struct so that it's processed by kube-openapi
		m.Type.CommentLines = append(m.Type.CommentLines, XKubernetesFabric8Type+":enum")
		for _, value := range istioEnumExtractor.values {
			m.Type.CommentLines = addOrAppend(m.Type.CommentLines, "+k8s:openapi-gen=x-kubernetes-fabric8-enum-values:", value)
		}
	}
}

func publicInterfaceName(name string) string {
	if unicode.IsUpper(rune(name[0])) {
		return name
	}
	return string(unicode.ToUpper(rune(name[0]))) + name[1:]
}

// func processProtobufOneof
// To generate interfaces and extending classes for oneof fields
// This is something extensively used in the Istio API, that uses these as marker interfaces
//
// For processing we'll add +k8s:openapi-gen=x-kubernetes tags that will be later processed by kube-openapi and added to the OpenAPI json spec
func processProtobufOneof(_ *generator.Context, pkg *types.Package, t *types.Type, m *types.Member, memberIndex int) {
	// Interfaces
	protobufOneOf := reflect.StructTag(m.Tags).Get("protobuf_oneof")
	if protobufOneOf != "" {
		//// Add comment tag to the referenced type and mark it as an interface
		t.Members[memberIndex].Type.CommentLines = append(m.Type.CommentLines, XKubernetesFabric8Type+":interface")
		// Add comment tag to the current type to mark it as it has fields that are interfaces (useful for the OpenAPI Java generator)
		t.CommentLines = addOrAppend(t.CommentLines, "+k8s:openapi-gen=x-kubernetes-fabric8-interface-fields:", m.Name)
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
				candidateType.CommentLines = addOrAppend(candidateType.CommentLines, "+k8s:openapi-gen=x-kubernetes-fabric8-implementation:", t.Name.Name)
			}
		}
	}
}

// processProtobufPackageOneOf function to process the protobuf package and change the interfaces to structs
// kube-openapi doesn't handle interfaces, so we need to change the interface to a struct
func processProtobufPackageOneOf(_ *generator.Context, pkg *types.Package) {
	for _, t := range pkg.Types {
		if t.Kind != types.Interface {
			continue
		}
		openApiGen := gengo.ExtractCommentTags("+", t.CommentLines)["k8s:openapi-gen"]
		if len(openApiGen) > 0 {
			for _, openApiGenValue := range openApiGen {
				if openApiGenValue == "x-kubernetes-fabric8-type:interface" {
					// Change to Struct so that it's processed by kube-openapi
					t.Kind = types.Struct
					// Ensure it's public so that it can be exported
					t.Name.Name = publicInterfaceName(t.Name.Name)
					break
				}
			}
		}
	}
}

// processProtobufTags function to process the protobuf field tags and fix json tags that might have mismatched names for serialization
// This happens for most of the istio APIs
func processProtobufTags(_ *generator.Context, _ *types.Package, t *types.Type, m *types.Member, memberIndex int) {
	tags := reflect.StructTag(m.Tags)
	protobufTag := tags.Get("protobuf")
	if protobufTag == "" {
		return
	}
	jsonTag := tags.Get("json")
	var name string
	if strings.Contains(protobufTag, "json=") {
		name = strings.Split(strings.Split(protobufTag, "json=")[1], ",")[0]

	} else if strings.Contains(protobufTag, "name=") && jsonTag == "" {
		name = strings.Split(strings.Split(protobufTag, "name=")[1], ",")[0]
	}
	if name == "" {
		return
	}
	var updatedJsonTag string
	if strings.Contains(jsonTag, ",") {
		updatedJsonTag = name + "," + strings.Split(jsonTag, ",")[1]
	} else {
		updatedJsonTag = name
	}
	if jsonTag == "" {
		t.Members[memberIndex].Tags = t.Members[memberIndex].Tags + " json:\"" + updatedJsonTag+"\""
	} else {
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

func hasPrefix(commentLines []string, prefix string) (bool, int) {
	for i, commentLine := range commentLines {
		if strings.HasPrefix(commentLine, prefix) {
			return true, i
		}
	}
	return false, -1
}

func addOrAppend(commentLines []string, prefix, value string) []string {
	if ok, i := hasPrefix(commentLines, prefix); ok {
		commentLines[i] = commentLines[i] + "," + value
	} else {
		commentLines = append(commentLines, prefix+value)
	}
	return commentLines
}

type IstioEnumExtractor struct {
	pkg *types.Package
	typeName string
	values []string
}

func (v *IstioEnumExtractor) Visit(node ast.Node) ast.Visitor {
	switch node.(type) {
	case *ast.ValueSpec:
		valueSpec := node.(*ast.ValueSpec)
			if valueSpec.Names[0].Name == v.typeName {
			ast.Inspect(valueSpec, func(valueNode ast.Node) bool {
				switch valueNode.(type) {
				case *ast.KeyValueExpr:
					enumKey, _ := strconv.Unquote(valueNode.(*ast.KeyValueExpr).Key.(*ast.BasicLit).Value)
					enumValue := valueNode.(*ast.KeyValueExpr).Value.(*ast.BasicLit).Value
					v.values = append(v.values, enumKey+"("+enumValue+")")
				}
				return true
			})
			return nil
		}
	}
	return v
}

func (v *IstioEnumExtractor) extract() bool {
	packages, err := parser.ParseDir(astFileSet, v.pkg.Dir, nil, parser.ParseComments)
	if err == nil && packages[v.pkg.Name] != nil {
		for _, f := range packages[v.pkg.Name].Files {
			ast.Walk(v, f)
			if v.values != nil {
				return true
			}
		}
	}
	return false
}
