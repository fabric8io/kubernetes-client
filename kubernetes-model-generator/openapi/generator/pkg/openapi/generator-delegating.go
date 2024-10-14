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
	"io"
	"k8s.io/gengo/v2/generator"
	"k8s.io/gengo/v2/namer"
	"k8s.io/gengo/v2/types"
	"strings"
)

type generatorDelegating struct {
	delegate generator.Generator
}

func NewGeneratorDelegating(delegate generator.Generator) generator.Generator {
	return &generatorDelegating{
		delegate: delegate,
	}
}

func (g *generatorDelegating) Name() string {
	return g.delegate.Name()
}

func (g *generatorDelegating) Filter(context *generator.Context, t *types.Type) bool {
	return g.delegate.Filter(context, t)
}

// Namers returns the name systems used by the generators in this package.
func (g *generatorDelegating) Namers(context *generator.Context) namer.NameSystems {
	namers := g.delegate.Namers(context)
	// Override 'private' namer to prevent issue with duplicate name types in packages for the same api version
	// See SecretValueFromSource in eventing-github and eventing-gitlab v1alpha1
	if namers["private"] != nil {
		prependPackageNames := 5 // qualify problem with eventing-gitlab v1alpha1
		// https://github.com/kubernetes/kube-openapi/blob/67ed5848f094e4cd74f5bdc458cd98f12767c538/pkg/generators/openapi.go#L150-L155
		namers["private"] = &namer.NameStrategy{
			Join: func(pre string, in []string, post string) string {
				return strings.Join(in, "_")
			},
			PrependPackageNames: prependPackageNames,
		}
	}
	return namers
}

func (g *generatorDelegating) Imports(context *generator.Context) []string {
	return g.delegate.Imports(context)
}

func (g *generatorDelegating) PackageVars(context *generator.Context) []string {
	return g.delegate.PackageVars(context)
}

func (g *generatorDelegating) PackageConsts(context *generator.Context) []string {
	return g.delegate.PackageConsts(context)
}

func (g *generatorDelegating) GenerateType(context *generator.Context, t *types.Type, w io.Writer) error {
	return g.delegate.GenerateType(context, t, w)
}

func (g *generatorDelegating) Filename() string {
	return g.delegate.Filename()
}

func (g *generatorDelegating) FileType() string {
	return g.delegate.FileType()
}

func (g *generatorDelegating) Finalize(context *generator.Context, w io.Writer) error {
	return g.delegate.Finalize(context, w)
}

func (g *generatorDelegating) Init(context *generator.Context, w io.Writer) error {
	return g.delegate.Init(context, w)
}
