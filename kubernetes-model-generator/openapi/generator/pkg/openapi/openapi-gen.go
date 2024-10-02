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
)

type GoGenerator struct {
	openapiargs.Args
	Patterns  []string
	inputPkgs map[string]bool
}

func (g *GoGenerator) Generate() error {
	g.ReportFilename = g.OutputFile + ".report.txt"
	return gengo.Execute(
		generators.NameSystems(),
		generators.DefaultNameSystem(),
		g.KubernetesTargets,
		gengo.StdBuildTag,
		g.Patterns,
	)
}

func (g *GoGenerator) KubernetesTargets(context *generator.Context) []generator.Target {
	// Create a map of all the input packages for performance (queried later on)
	g.inputPkgs = make(map[string]bool)
	for _, inputPackage := range context.Inputs {
		g.inputPkgs[inputPackage] = true
	}
	// Replace original Filter function with something that includes all Kubernetes Object types regardless of the comment tag
	openApiGenTargets := generators.GetTargets(context, &g.Args)
	for _, target := range openApiGenTargets {
		// Override standard filter function to include types that haven't been annotated/tagged with k8s:openapi-gen=true
		target.(*generator.SimpleTarget).FilterFunc = g.KubernetesFilterFunc
	}
	return openApiGenTargets
}

// KubernetesFilterFunc
// Adaptation of https://github.com/kubernetes/kube-openapi/blob/9e1beecbcb384a484fb5cbd41024f316d51fdfac/pkg/generators/openapi.go#L106
func (g *GoGenerator) KubernetesFilterFunc(c *generator.Context, t *types.Type) bool {
	// Skip types that are not structs
	if t.Kind != types.Struct {
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
