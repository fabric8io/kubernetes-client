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
	"k8s.io/apimachinery/pkg/util/validation/field"

	"github.com/openshift/origin/pkg/quota/admission/apis/runonceduration"
)

// ValidateRunOnceDurationConfig validates the RunOnceDuration plugin configuration
func ValidateRunOnceDurationConfig(config *runonceduration.RunOnceDurationConfig) field.ErrorList {
	allErrs := field.ErrorList{}
	if config == nil || config.ActiveDeadlineSecondsLimit == nil {
		return allErrs
	}
	if *config.ActiveDeadlineSecondsLimit <= 0 {
		allErrs = append(allErrs, field.Invalid(field.NewPath("activeDeadlineSecondsOverride"), config.ActiveDeadlineSecondsLimit, "must be greater than 0"))
	}
	return allErrs
}
