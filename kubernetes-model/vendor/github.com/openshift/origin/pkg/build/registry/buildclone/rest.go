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
package buildclone

import (
	"k8s.io/apimachinery/pkg/runtime"
	apirequest "k8s.io/apiserver/pkg/endpoints/request"
	"k8s.io/apiserver/pkg/registry/rest"

	buildapi "github.com/openshift/origin/pkg/build/apis/build"
	"github.com/openshift/origin/pkg/build/generator"
)

// NewStorage creates a new storage object for build generation
func NewStorage(generator *generator.BuildGenerator) *CloneREST {
	return &CloneREST{generator: generator}
}

// CloneREST is a RESTStorage implementation for a BuildGenerator which supports only
// the Get operation (as the generator has no underlying storage object).
type CloneREST struct {
	generator *generator.BuildGenerator
}

var _ rest.Creater = &CloneREST{}

// New creates a new build clone request
func (s *CloneREST) New() runtime.Object {
	return &buildapi.BuildRequest{}
}

// Create instantiates a new build from an existing build
func (s *CloneREST) Create(ctx apirequest.Context, obj runtime.Object, createValidation rest.ValidateObjectFunc, _ bool) (runtime.Object, error) {
	if err := rest.BeforeCreate(Strategy, ctx, obj); err != nil {
		return nil, err
	}
	if err := createValidation(obj); err != nil {
		return nil, err
	}

	return s.generator.Clone(ctx, obj.(*buildapi.BuildRequest))
}
