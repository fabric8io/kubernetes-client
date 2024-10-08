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
package pkg

//
//import (
//	"fmt"
//	"go/ast"
//	"go/parser"
//	"go/token"
//	"k8s.io/kube-openapi/pkg/common"
//	"os"
//	"path"
//	"reflect"
//	"runtime/debug"
//	"strings"
//)
//
//
//type ModuleInformation struct {
//	Name    string
//	Path    string
//	fileSet *token.FileSet
//	packages map[string]map[string]*ast.File
//}
//
//func NewModuleInformation(name string) *ModuleInformation {
//	bi, _ := debug.ReadBuildInfo()
//	var moduleDependency *debug.Module
//	for _, dep := range bi.Deps {
//		if dep.Path == name {
//			moduleDependency = dep
//		}
//	}
//	if moduleDependency == nil {
//		panic(name + " not found in go.mod")
//	}
//	// Find module sources
//	cache, ok := os.LookupEnv("GOMODCACHE")
//	if !ok {
//		cache = path.Join(os.Getenv("GOPATH"), "pkg", "mod")
//	}
//	modulePath := path.Join(cache, moduleDependency.Path+"@"+moduleDependency.Version)
//	if _, err := os.Stat(modulePath); os.IsNotExist(err) {
//		panic(fmt.Sprintf(name+" module not found at %s", modulePath))
//	}
//	moduleInformation := &ModuleInformation{
//		Name:    name,
//		Path:    modulePath,
//		fileSet: token.NewFileSet(),
//	}
//	return moduleInformation
//}
//
//func (mi *ModuleInformation) resolveTypeFile(definitionName string) *ast.File {
//	if strings.Index(definitionName, mi.Name) != 0 {
//		return nil
//	}
//	packageType := strings.Split(strings.Replace(definitionName, mi.Name, "", 1), ".")
//	packageName := packageType[0]
//	typeName := packageType[1]
//	if mi.packages == nil {
//		mi.packages = make(map[string]map[string]*ast.File)
//	}
//	if mi.packages[packageName] == nil {
//		dir, err := parser.ParseDir(mi.fileSet, mi.Path+packageName, nil, parser.ParseComments)
//		if err != nil {
//			panic(fmt.Errorf("error parsing %s module: %w", packageName, err))
//		}
//		if len(dir) != 1 {
//			panic(fmt.Errorf("error parsing %s module: %s", packageName, "expected exactly one package"))
//		}
//		for _, pkg := range dir {
//			mi.packages[packageName] = pkg.Files
//		}
//	}
//	var typeFile *ast.File
//	for _, file := range mi.packages[packageName] {
//		ast.Inspect(file, func(n ast.Node) bool {
//			switch x := n.(type) {
//			case *ast.TypeSpec:
//				if x.Name.Name == typeName {
//					typeFile = file
//					return false
//				}
//			}
//			return true
//		})
//		if typeFile != nil {
//			break
//		}
//	}
//	if typeFile == nil {
//		panic(fmt.Errorf("type %s not found in %s", typeName, packageName))
//	}
//	return typeFile
//}
//
//func (mi *ModuleInformation) isNamespaced(definitionName string) bool {
//	typeFile := mi.resolveTypeFile(definitionName)
//	namespaced := true
//	ast.Inspect(typeFile, func(n ast.Node) bool {
//		switch x := n.(type) {
//		case *ast.Comment:
//			if strings.Contains(x.Text, genClientPrefix + "nonNamespaced") {
//				mi.fileSet.File(typeFile.Pos()).Position(x.Pos())
//				namespaced = false
//				return false
//			}
//		}
//		return true
//	})
//	return namespaced
//}
//
//func (mi *ModuleInformation) AstInfo(definitionName string, definition *common.OpenAPIDefinition) {
//	if strings.Index(definitionName, mi.Name) != 0 {
//		return
//	}
//	packageType := strings.Split(strings.Replace(definitionName, mi.Name, "", 1), ".")
//	packageName := packageType[0]
//	fabric8Info := &Fabric8Info{}
//	if mi.isNamespaced(definitionName) {
//		fabric8Info.Scope = "Namespaced"
//	} else {
//		fabric8Info.Scope = "Cluster"
//	}
//	/////
//	//node, err := parser.ParseFile(fset, mi.Path + "/apps/v1/types.go", nil, parser.ParseComments)
//	//node, err := parser.ParseFile(fset, openShiftApiModulePath + "/install.go", nil, parser.ParseComments)
//	fileName := packageName + "/register.go"
//	node, err := parser.ParseFile(mi.fileSet, mi.Path+fileName, nil, parser.ParseComments)
//	if err != nil {
//		panic(fmt.Errorf("error parsing %s file: %w", fileName, err))
//	}
//	/////
//	if definition.Schema.ExtraProps == nil {
//		definition.Schema.ExtraProps = make(map[string]interface{})
//	}
//	if node.Scope.Objects["GroupName"] != nil {
//		fabric8Info.GroupName = node.Scope.Objects["GroupName"].Decl.(*ast.ValueSpec).Values[0].(*ast.BasicLit).Value
//	}
//	if node.Scope.Objects["GroupVersion"] != nil {
//		groupVersionNode := node.Scope.Objects["GroupVersion"].Decl.(*ast.ValueSpec).Values[0].(*ast.CompositeLit)
//		groupVersion := make(map[string]string)
//		for _, elt := range groupVersionNode.Elts {
//			visitor := &ValueExtractor{}
//			ast.Walk(visitor, elt)
//			groupVersion[elt.(*ast.KeyValueExpr).Key.(*ast.Ident).Name] = visitor.Value
//		}
//		fabric8Info.GroupVersion = groupVersion["Version"]
//	}
//	definition.Schema.ExtraProps["x-fabric8-info"] = fabric8Info
//}
//
//
//type ValueExtractor struct {
//	Value string
//}
//
//func (ve *ValueExtractor) Visit(node ast.Node) ast.Visitor {
//	switch n := node.(type) {
//	case *ast.BasicLit:
//		ve.Value = n.Value
//	case *ast.Ident:
//		if n.Obj != nil && reflect.TypeOf(n.Obj) == reflect.TypeOf(&ast.Object{}) {
//			if reflect.TypeOf(n.Obj.Decl) == reflect.TypeOf(&ast.ValueSpec{}) {
//				ast.Inspect(n.Obj.Decl.(*ast.ValueSpec), func(n ast.Node) bool {
//					if reflect.TypeOf(n) == reflect.TypeOf(&ast.BasicLit{}) {
//						ve.Value = n.(*ast.BasicLit).Value
//					}
//					return true
//				})
//			}
//		}
//	}
//	return ve
//}
