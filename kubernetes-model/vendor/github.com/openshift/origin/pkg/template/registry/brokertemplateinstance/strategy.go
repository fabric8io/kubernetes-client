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
package brokertemplateinstance

import (
	"k8s.io/apimachinery/pkg/runtime"
	"k8s.io/apimachinery/pkg/util/validation/field"
	apirequest "k8s.io/apiserver/pkg/endpoints/request"
	"k8s.io/apiserver/pkg/storage/names"
	"k8s.io/kubernetes/pkg/api/legacyscheme"

	templateapi "github.com/openshift/origin/pkg/template/apis/template"
	"github.com/openshift/origin/pkg/template/apis/template/validation"
)

// brokerTemplateInstanceStrategy implements behavior for BrokerTemplateInstances
type brokerTemplateInstanceStrategy struct {
	runtime.ObjectTyper
	names.NameGenerator
}

// Strategy is the default logic that applies when creating and updating BrokerTemplateInstance
// objects via the REST API.
var Strategy = brokerTemplateInstanceStrategy{legacyscheme.Scheme, names.SimpleNameGenerator}

// NamespaceScoped is false for brokertemplateinstances.
func (brokerTemplateInstanceStrategy) NamespaceScoped() bool {
	return false
}

// PrepareForUpdate clears fields that are not allowed to be set by end users on update.
func (brokerTemplateInstanceStrategy) PrepareForUpdate(ctx apirequest.Context, obj, old runtime.Object) {
}

// Canonicalize normalizes the object after validation.
func (brokerTemplateInstanceStrategy) Canonicalize(obj runtime.Object) {
}

// PrepareForCreate clears fields that are not allowed to be set by end users on creation.
func (brokerTemplateInstanceStrategy) PrepareForCreate(ctx apirequest.Context, obj runtime.Object) {
}

// Validate validates a new brokertemplateinstance.
func (brokerTemplateInstanceStrategy) Validate(ctx apirequest.Context, obj runtime.Object) field.ErrorList {
	return validation.ValidateBrokerTemplateInstance(obj.(*templateapi.BrokerTemplateInstance))
}

// AllowCreateOnUpdate is false for brokertemplateinstances.
func (brokerTemplateInstanceStrategy) AllowCreateOnUpdate() bool {
	return false
}

func (brokerTemplateInstanceStrategy) AllowUnconditionalUpdate() bool {
	return false
}

// ValidateUpdate is the default update validation for an end user.
func (brokerTemplateInstanceStrategy) ValidateUpdate(ctx apirequest.Context, obj, old runtime.Object) field.ErrorList {
	return validation.ValidateBrokerTemplateInstanceUpdate(obj.(*templateapi.BrokerTemplateInstance), old.(*templateapi.BrokerTemplateInstance))
}
