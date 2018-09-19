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
package v1

import (
	"k8s.io/apimachinery/pkg/conversion"
	"k8s.io/apimachinery/pkg/runtime"
	"k8s.io/apimachinery/pkg/runtime/schema"

	"github.com/openshift/origin/pkg/image/admission/apis/imagepolicy"
)

// SchemeGroupVersion is group version used to register these objects
var SchemeGroupVersion = schema.GroupVersion{Group: "", Version: "v1"}

var (
	SchemeBuilder = runtime.NewSchemeBuilder(addKnownTypes, addConversionFuncs, addDefaultingFuncs)
	AddToScheme   = SchemeBuilder.AddToScheme
)

// Adds the list of known types to api.Scheme.
func addKnownTypes(scheme *runtime.Scheme) error {
	scheme.AddKnownTypes(SchemeGroupVersion,
		&ImagePolicyConfig{},
	)
	return nil
}

func addConversionFuncs(scheme *runtime.Scheme) error {
	return scheme.AddConversionFuncs(
		// TODO: remove when MatchSignatures is implemented
		func(in *ImageCondition, out *imagepolicy.ImageCondition, s conversion.Scope) error {
			return s.DefaultConvert(in, out, conversion.IgnoreMissingFields)
		},
		// TODO: remove when ConsumptionRules and PlacementRules are implemented
		func(in *ImagePolicyConfig, out *imagepolicy.ImagePolicyConfig, s conversion.Scope) error {
			return s.DefaultConvert(in, out, conversion.IgnoreMissingFields)
		},
	)
}

func (obj *ImagePolicyConfig) GetObjectKind() schema.ObjectKind { return &obj.TypeMeta }
