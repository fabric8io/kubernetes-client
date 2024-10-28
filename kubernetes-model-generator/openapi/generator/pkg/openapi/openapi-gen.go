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
	"github.com/fabric8io/kubernetes-client/kubernetes-model-generator/openapi/generator/pkg/kubernetes"
	"k8s.io/gengo/v2"
	"k8s.io/gengo/v2/generator"
	"k8s.io/gengo/v2/types"
	openapiargs "k8s.io/kube-openapi/cmd/openapi-gen/args"
	"k8s.io/kube-openapi/pkg/generators"
	"strings"
	"unicode"
)

type GoGenerator struct {
	openapiargs.Args
	Patterns   []string
	inputPkgs  map[string]bool
	// memberProcessors are functions that are applied to each member of a type
	memberProcessors []func(context *generator.Context, pkg *types.Package, t *types.Type, member *types.Member, memberIndex int)
	// packageProcessors are functions that are applied to each package once all type members have been processed for that package
	packageProcessors []func(context *generator.Context, pkg *types.Package)
}

func (g *GoGenerator) Generate() error {
	g.ReportFilename = g.OutputFile + ".report.txt"
	g.memberProcessors = []func(context *generator.Context, pkg *types.Package, t *types.Type, member *types.Member, memberIndex int){
		processMapKeyTypes,
		processOmitPrivateFields,
		processPatchComments,
		processProtobufEnumsForIstio,
		processProtobufOneof,
		processProtobufTags,
		processSwaggerIgnore,
	}
	g.packageProcessors = []func(context *generator.Context, pkg *types.Package){
		processProtobufPackageOneOf,
	}
	return gengo.Execute(
		generators.NameSystems(),
		generators.DefaultNameSystem(),
		g.KubernetesTargets,
		gengo.StdBuildTag,
		g.Patterns,
	)
}

// KubernetesTargets wrapper function around kube-openapi's generators.GetTargets function.
//
// Allows to override the default kube-openapi generators.apiTypeFilterFunc with our own (see KubernetesFilterFunc).
func (g *GoGenerator) KubernetesTargets(context *generator.Context) []generator.Target {
	g.processUniverse(context)
	// Replace original Filter function with something that includes all Kubernetes Object types regardless of the comment tag
	openApiGenTargets := generators.GetTargets(context, &g.Args)
	for _, target := range openApiGenTargets {
		// Override standard filter function to include types that haven't been annotated/tagged with k8s:openapi-gen=true
		target.(*generator.SimpleTarget).FilterFunc = g.KubernetesFilterFunc
		// Override standard Generator function to be able to provide our Generator overrides
		originalGeneratorsFunc := target.(*generator.SimpleTarget).GeneratorsFunc
		target.(*generator.SimpleTarget).GeneratorsFunc = func(context *generator.Context) []generator.Generator {
			originalGenerators := originalGeneratorsFunc(context)
			delegatingGenerators := make([]generator.Generator, len(originalGenerators))
			for i, originalGenerator := range originalGenerators {
				delegatingGenerators[i] = NewGeneratorDelegating(originalGenerator)
			}
			return delegatingGenerators
		}
	}
	return openApiGenTargets
}

// processUniverse function to process the universe and apply some fixes to the types.
func (g *GoGenerator) processUniverse(context *generator.Context) {
	// Create a map of all the input packages for performance (queried later on)
	g.inputPkgs = make(map[string]bool)
	for _, inputPackage := range context.Inputs {
		g.inputPkgs[inputPackage] = true
	}

	for _, pkg := range context.Universe {
		for _, t := range pkg.Types {
			for memberIndex, member := range t.Members {
				for _, memeberProcessor := range g.memberProcessors {
					memeberProcessor(context, pkg, t, &member, memberIndex)
				}
			}
		}
		for _, packageProcessor := range g.packageProcessors {
			packageProcessor(context, pkg)
		}
	}

	// Non-deterministic bug-fix
	// ScopeType is sometimes considered enum and others isn't. Force it to be non enum to avoid issues
	scopeType := context.Universe.Type(types.Name{Package: "k8s.io/api/admissionregistration/v1", Name: "ScopeType"})
	originalComments := scopeType.CommentLines
	scopeType.CommentLines = make([]string, 0)
	for _, comment := range originalComments {
		if comment != "+enum" {
			scopeType.CommentLines = append(scopeType.CommentLines, comment)
		}
	}
}

// KubernetesFilterFunc function to filter out types that are not Kubernetes Objects,
// Lists, or nested structs within those.
//
// Adaptation of https://github.com/kubernetes/kube-openapi/blob/9e1beecbcb384a484fb5cbd41024f316d51fdfac/pkg/generators/openapi.go#L106
//
// The original function only takes into account those structs that have been tagged with +k8s:openapi-gen=true
// or that belong to a package that has been tagged with +k8s:openapi-gen=true
//
// The default behavior is fine for most packages, however, some of them lack these annotations.
// While the upstream projects are fixed, we need to provide a workaround to generate the complete OpenAPI definitions.
func (g *GoGenerator) KubernetesFilterFunc(c *generator.Context, t *types.Type) bool {
	// Skip types that are not structs
	if t.Kind != types.Struct {
		return false
	}
	// Skip types that are not exported
	if t.Name.Name == "" || !unicode.IsUpper(rune(t.Name.Name[0])) {
		return false
	}
	// There is a conflict between this codegen and codecgen, we should avoid types generated for codecgen
	if strings.HasPrefix(t.Name.Name, "codecSelfer") {
		return false
	}
	// Standard +k8s:openapi-gen=true tag
	pkg := c.Universe.Package(t.Name.Package)
	tags := gengo.ExtractCommentTags("+", append(pkg.Comments, append(t.CommentLines, t.SecondClosestCommentLines...)...))
	for _, tag := range tags["k8s:openapi-gen"] {
		if tag == "true" {
			return true
		}
	}
	// Adaptation to consider also structs that have not been annotated with +k8s:openapi-gen=true
	// Any Kubernetes Object (or List)
	for _, m := range t.Members {
		if m.Embedded == true && m.Type.Name == kubernetes.ListMeta {
			return true
		} else if m.Embedded == true && m.Type.Name == kubernetes.TypeMeta {
			return true
		}
	}
	// Any struct present in the input packages (these can be structs that have not been annotated with +k8s:openapi-gen=true and are nested inside a Kubernetes Object)
	if g.inputPkgs[pkg.Path] {
		return true
	}
	return false
}

