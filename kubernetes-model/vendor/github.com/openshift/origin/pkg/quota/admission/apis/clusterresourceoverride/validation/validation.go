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

	"github.com/openshift/origin/pkg/quota/admission/apis/clusterresourceoverride"
)

func Validate(config *clusterresourceoverride.ClusterResourceOverrideConfig) field.ErrorList {
	allErrs := field.ErrorList{}
	if config == nil {
		return allErrs
	}
	if config.LimitCPUToMemoryPercent == 0 && config.CPURequestToLimitPercent == 0 && config.MemoryRequestToLimitPercent == 0 {
		allErrs = append(allErrs, field.Forbidden(field.NewPath(clusterresourceoverride.PluginName), "plugin enabled but no percentages were specified"))
	}
	if config.LimitCPUToMemoryPercent < 0 {
		allErrs = append(allErrs, field.Invalid(field.NewPath(clusterresourceoverride.PluginName, "LimitCPUToMemoryPercent"), config.LimitCPUToMemoryPercent, "must be positive"))
	}
	if config.CPURequestToLimitPercent < 0 || config.CPURequestToLimitPercent > 100 {
		allErrs = append(allErrs, field.Invalid(field.NewPath(clusterresourceoverride.PluginName, "CPURequestToLimitPercent"), config.CPURequestToLimitPercent, "must be between 0 and 100"))
	}
	if config.MemoryRequestToLimitPercent < 0 || config.MemoryRequestToLimitPercent > 100 {
		allErrs = append(allErrs, field.Invalid(field.NewPath(clusterresourceoverride.PluginName, "MemoryRequestToLimitPercent"), config.MemoryRequestToLimitPercent, "must be between 0 and 100"))
	}
	return allErrs
}
