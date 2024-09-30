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
package parser

import (
	"fmt"
	"k8s.io/gengo/v2/parser"
	"k8s.io/gengo/v2/types"
	"strings"
)

const genClient = "+genclient"
const genClientPrefix = genClient + ":"
const groupNamePrefix = "+groupName="

var listMeta = types.ParseFullyQualifiedName("k8s.io/apimachinery/pkg/apis/meta/v1.ListMeta")
var typeMeta = types.ParseFullyQualifiedName("k8s.io/apimachinery/pkg/apis/meta/v1.TypeMeta")

type Module struct {
	Name     string
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

func NewModule(name string) *Module {
	p := parser.New()
	err := p.LoadPackages(name)
	if err != nil {
		panic(fmt.Sprintf("error loading packages: %v", err))
	}
	universe, err := p.NewUniverse()
	if err != nil {
		panic(fmt.Sprintf("error creating universe: %v", err))
	}
	return &Module{
		Name:     name,
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
	fabric8Info.Version = pkg.Name
	fabric8Info.Kind = typ.Name.Name
	fabric8Info.Scope = scope(typ)
	return fabric8Info
}

func (oam *Module) ApiName(definitionName string) string {
	if strings.Index(definitionName, oam.Name) != 0 {
		return definitionName
	}
	lastSeparator := strings.LastIndex(definitionName, ".")
	typeName := definitionName[lastSeparator+1:]
	pkg := oam.resolvePackage(definitionName)
	groupName := groupName(pkg)
	groupParts := strings.Split(groupName, ".")
	for i, j := 0, len(groupParts)-1; i < j; i, j = i+1, j-1 {
		groupParts[i], groupParts[j] = groupParts[j], groupParts[i]
	}
	return strings.Join(groupParts, ".") + "." + typeName
}

func (oam *Module) resolvePackage(definitionName string) *types.Package {
	lastSeparator := strings.LastIndex(definitionName, ".")
	packageName := definitionName[:lastSeparator]
	_, err := oam.parser.LoadPackagesTo(oam.universe, packageName)
	if err != nil {
		panic(fmt.Sprintf("error loading packages: %v", err))
	}
	pkg := oam.universe.Package(packageName)
	if pkg == nil {
		panic(fmt.Sprintf("package %s not found", packageName))
	}
	return pkg
}

func groupName(pkg *types.Package) string {
	for _, c := range pkg.Comments {
		if strings.HasPrefix(c, groupNamePrefix) {
			return strings.TrimPrefix(c, groupNamePrefix)
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
		if m.Type.Name == listMeta {
			isList = true
			// stop iterating, if it's a list then it's not an object
			break
		} else if m.Type.Name == typeMeta {
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

func scope(typ *types.Type) string {
	scope := "Namespaced"
	for _, c := range append(typ.CommentLines, typ.SecondClosestCommentLines...) {
		if strings.Contains(c, genClientPrefix+"nonNamespaced") {
			scope = "Clustered"
			break
		}
	}
	return scope
}
