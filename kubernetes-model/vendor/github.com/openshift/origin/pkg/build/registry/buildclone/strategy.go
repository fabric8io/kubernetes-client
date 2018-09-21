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
	"k8s.io/apimachinery/pkg/util/validation/field"
	apirequest "k8s.io/apiserver/pkg/endpoints/request"
	"k8s.io/kubernetes/pkg/api/legacyscheme"

	buildapi "github.com/openshift/origin/pkg/build/apis/build"
	buildvalidation "github.com/openshift/origin/pkg/build/apis/build/validation"
)

type strategy struct {
	runtime.ObjectTyper
}

var Strategy = strategy{legacyscheme.Scheme}

func (s strategy) NamespaceScoped() bool {
	return true
}

func (s strategy) AllowCreateOnUpdate() bool {
	return false
}

func (s strategy) GenerateName(base string) string {
	return base
}

// PrepareForCreate clears fields that are not allowed to be set by end users on creation.
func (s strategy) PrepareForCreate(ctx apirequest.Context, obj runtime.Object) {
}

// Validate validates a new role.
func (s strategy) Validate(ctx apirequest.Context, obj runtime.Object) field.ErrorList {
	return buildvalidation.ValidateBuildRequest(obj.(*buildapi.BuildRequest))
}

// Canonicalize normalizes the object after validation.
func (strategy) Canonicalize(obj runtime.Object) {
}
