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
package servicebroker

import (
	"fmt"

	"k8s.io/apimachinery/pkg/util/validation/field"

	templatevalidation "github.com/openshift/origin/pkg/template/apis/template/validation"
	"github.com/openshift/origin/pkg/templateservicebroker/openservicebroker/api"
)

// ValidateProvisionRequest ensures that a ProvisionRequest is valid, beyond
// the validation carried out by the service broker framework itself.
func ValidateProvisionRequest(preq *api.ProvisionRequest) field.ErrorList {
	var allErrs field.ErrorList

	for key := range preq.Parameters {
		if !templatevalidation.ParameterNameRegexp.MatchString(key) {
			allErrs = append(allErrs, field.Invalid(field.NewPath("parameters", key), key, fmt.Sprintf("does not match %v", templatevalidation.ParameterNameRegexp)))
		}
	}

	return allErrs
}

// ValidateBindRequest ensures that a BindRequest is valid, beyond the
// validation carried out by the service broker framework itself.
func ValidateBindRequest(breq *api.BindRequest) field.ErrorList {
	var allErrs field.ErrorList

	for key := range breq.Parameters {
		if !templatevalidation.ParameterNameRegexp.MatchString(key) {
			allErrs = append(allErrs, field.Invalid(field.NewPath("parameters."+key), key, fmt.Sprintf("does not match %v", templatevalidation.ParameterNameRegexp)))
		}
	}

	return allErrs
}
