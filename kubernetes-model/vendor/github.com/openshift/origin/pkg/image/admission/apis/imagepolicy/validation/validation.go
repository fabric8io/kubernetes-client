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
package validation

import (
	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
	"k8s.io/apimachinery/pkg/util/sets"
	"k8s.io/apimachinery/pkg/util/validation/field"

	"github.com/openshift/origin/pkg/image/admission/apis/imagepolicy"
)

func Validate(config *imagepolicy.ImagePolicyConfig) field.ErrorList {
	allErrs := field.ErrorList{}
	if config == nil {
		return allErrs
	}
	names := sets.NewString()
	for i, rule := range config.ExecutionRules {
		if names.Has(rule.Name) {
			allErrs = append(allErrs, field.Duplicate(field.NewPath(imagepolicy.PluginName, "executionRules").Index(i).Child("name"), rule.Name))
		}
		names.Insert(rule.Name)
		for j, selector := range rule.MatchImageLabels {
			_, err := metav1.LabelSelectorAsSelector(&selector)
			if err != nil {
				allErrs = append(allErrs, field.Invalid(field.NewPath(imagepolicy.PluginName, "executionRules").Index(i).Child("matchImageLabels").Index(j), nil, err.Error()))
			}
		}
	}

	for i, rule := range config.ResolutionRules {
		if len(rule.Policy) == 0 {
			allErrs = append(allErrs, field.Required(field.NewPath(imagepolicy.PluginName, "resolutionRules").Index(i).Child("policy"), "a policy must be specified for this resource"))
		}
		if len(rule.TargetResource.Resource) == 0 {
			allErrs = append(allErrs, field.Required(field.NewPath(imagepolicy.PluginName, "resolutionRules").Index(i).Child("targetResource", "resource"), "a target resource name or '*' must be provided"))
		}
	}

	// if you don't attempt resolution, you'll never be able to pass any rule that logically requires it
	if config.ResolveImages == imagepolicy.DoNotAttempt {
		for i, rule := range config.ExecutionRules {
			if len(rule.MatchDockerImageLabels) > 0 {
				allErrs = append(allErrs, field.Invalid(field.NewPath(imagepolicy.PluginName, "executionRules").Index(i).Child("matchDockerImageLabels"), rule.MatchDockerImageLabels, "images are not being resolved, this condition will always fail"))
			}
			if len(rule.MatchImageLabels) > 0 {
				allErrs = append(allErrs, field.Invalid(field.NewPath(imagepolicy.PluginName, "executionRules").Index(i).Child("matchImageLabels"), rule.MatchImageLabels, "images are not being resolved, this condition will always fail"))
			}
			if len(rule.MatchImageAnnotations) > 0 {
				allErrs = append(allErrs, field.Invalid(field.NewPath(imagepolicy.PluginName, "executionRules").Index(i).Child("matchImageAnnotations"), rule.MatchImageAnnotations, "images are not being resolved, this condition will always fail"))
			}
		}
	}

	return allErrs
}
