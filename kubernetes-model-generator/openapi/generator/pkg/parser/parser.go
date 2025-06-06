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

// Package parser provides functionality to extract information from Go types and packages using gengo.
package parser

import (
	"fmt"
	"github.com/fabric8io/kubernetes-client/kubernetes-model-generator/openapi/generator/pkg/kubernetes"
	goparser "go/parser"
	"go/token"
	"k8s.io/gengo/v2"
	"k8s.io/gengo/v2/parser"
	"k8s.io/gengo/v2/types"
	"path"
	"strings"
)

const genClient = "+genclient"
const genClientPrefix = genClient + ":"
const groupNamePrefix = "+groupName="
const versionNamePrefix = "+versionName="

var astFileSet = token.NewFileSet()

type Module struct {
	patterns []string
	parser   *parser.Parser
	universe *types.Universe
}

type Fabric8Info struct {
	// https://github.com/kubernetes/community/blob/495011674de058660011593e6c6c842c83a1fd24/contributors/devel/sig-architecture/api-conventions.md#types-kinds
	Type    string
	Group   string
	Version string
	Kind    string
	Scope   string
}

func NewModule(patterns ...string) *Module {
	p := parser.New()
	err := p.LoadPackages(patterns...)
	if err != nil {
		panic(fmt.Sprintf("error loading packages: %v", err))
	}
	universe, err := p.NewUniverse()
	if err != nil {
		panic(fmt.Sprintf("error creating universe: %v", err))
	}
	return &Module{
		patterns: patterns,
		parser:   p,
		universe: &universe,
	}
}

func (oam *Module) ExtractInfo(definitionName string) *Fabric8Info {
	pkg := oam.resolvePackage(definitionName)
	typ := oam.universe.Type(types.ParseFullyQualifiedName(definitionName))
	fabric8Info := &Fabric8Info{}
	fabric8Info.Type = resolveType(typ)
	fabric8Info.Group = groupName(pkg)
	fabric8Info.Version = versionName(pkg)
	fabric8Info.Kind = typ.Name.Name
	fabric8Info.Scope = scope(typ)
	return fabric8Info
}

// ApiName returns the completed definition name for the OpenAPI component
// The standard definition name is usually based on the module name + package name + type name.
// However, Kubernetes comment tags include augmented information such as the groupName and versionName.
// This method attempts to resolve the additional information from the gengo processed/parsed package and
// type information.
func (oam *Module) ApiName(definitionName string) string {
	// Don't treat k8s.io/api(.*) types (api,apimachinery,api-extensions...), json is expected to contain the full Go definition name instead of the group/version
	if strings.HasPrefix(definitionName, "k8s.io/api") {
		return FriendlyName(definitionName)
	}
	lastSeparator := strings.LastIndex(definitionName, ".")
	if lastSeparator < 0 {
		return FriendlyName(definitionName)
	}
	typeName := definitionName[lastSeparator+1:]
	pkg := oam.resolvePackage(definitionName)
	gn := groupName(pkg)
	if gn == "" {
		return FriendlyName(definitionName)
	}
	groupParts := strings.Split(gn, ".")
	for i, j := 0, len(groupParts)-1; i < j; i, j = i+1, j-1 {
		groupParts[i], groupParts[j] = groupParts[j], groupParts[i]
	}
	return strings.Join(groupParts, ".") + "." + versionName(pkg) + "." + typeName
}

func (oam *Module) resolvePackage(definitionName string) *types.Package {
	lastSeparator := strings.LastIndex(definitionName, ".")
	packageName := definitionName[:lastSeparator]
	pkg := oam.universe.Package(packageName)
	if pkg == nil || pkg.Name == "" {
		_, err := oam.parser.LoadPackagesTo(oam.universe, packageName)
		if err != nil {
			panic(fmt.Sprintf("error loading packages: %v", err))
		}
	}
	return pkg
}

// groupName returns the (kubernetes) group name for the given package.
// The group name is defined by the +groupName tag in the package comments.
// This function supports having the tag either in doc.go or groupversion_info.go files.
func groupName(pkg *types.Package) string {
	// gengo assumes that all packages have a doc.go file, the pkg comments are only considered from that file.
	// However, some kubernetes operators have this info in the groupversion_info.go file.
	tag := findTag(pkg, groupNamePrefix)
	if tag != "" {
		return tag
	}
	f, _ := goparser.ParseFile(astFileSet, path.Join(pkg.Dir, "groupversion_info.go"), nil, goparser.ParseComments)
	if f != nil {
		for _, c := range f.Doc.List {
			if strings.HasPrefix(c.Text, "// "+groupNamePrefix) {
				return strings.TrimPrefix(c.Text, "// "+groupNamePrefix)
			}
		}
	}
	return ""
}

func versionName(pkg *types.Package) string {
	// Some packages have a versionName tag, but it's not the standard (usually package name is used instead)
	v := findTag(pkg, versionNamePrefix)
	if v != "" {
		return v
	}
	return pkg.Name
}

func findTag(pkg *types.Package, tag string) string {
	for _, c := range pkg.Comments {
		if strings.HasPrefix(c, tag) {
			t := strings.TrimPrefix(c, tag)
			// Incredibly 🤦, there are some operators with a badly defined groupName tag:
			// https://github.com/openshift/installer/blob/66e9daae9dae59c2ec167a6c31f2f2c127382357/pkg/types/doc.go#L1
			t = strings.ReplaceAll(t, "\"", "")
			return t
		}
	}
	return ""
}

func resolveType(typ *types.Type) string {
	// types with a genClient annotation are always objects
	// types with a listType are always lists
	// types with metaType are always lists or objects
	for _, c := range append(typ.CommentLines, typ.SecondClosestCommentLines...) {
		if strings.TrimSpace(c) == genClient {
			return "object"
		}
	}
	isList := false
	isObject := false
	for _, m := range typ.Members {
		if m.Embedded == true && m.Type.Name == kubernetes.ListMeta {
			isList = true
			// stop iterating, if it's a list then it's not an object
			break
		} else if m.Embedded == true && m.Type.Name == kubernetes.TypeMeta {
			isObject = true
			// keep iterating, maybe it's a list
		}
	}
	if isList {
		return "list"
	}
	if isObject {
		return "object"
	}
	return "nested"
}

// scope returns the scope of the type (Clustered or Namespaced).
// The scope is defined by the +genclient tag in the type comments.
// For some CRDs, the scope is defined by the kubebuilder:resource:path tag.
func scope(typ *types.Type) string {
	commentTags := gengo.ExtractCommentTags("+", append(typ.CommentLines, typ.SecondClosestCommentLines...))
	_, hasGenclientNonNamespaced := commentTags["genclient:nonNamespaced"]
	if hasGenclientNonNamespaced {
		return "Clustered"
	}
	kubeBuilderResourcePath, hasKubeBuilderResourcePath := commentTags["kubebuilder:resource:path"]
	if hasKubeBuilderResourcePath {
		if strings.Contains(kubeBuilderResourcePath[0], "scope=Cluster") {
			return "Clustered"
		}
	}
	return "Namespaced"
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
