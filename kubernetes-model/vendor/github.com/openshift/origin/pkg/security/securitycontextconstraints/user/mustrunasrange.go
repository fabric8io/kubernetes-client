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
package user

import (
	"fmt"

	"k8s.io/apimachinery/pkg/util/validation/field"
	api "k8s.io/kubernetes/pkg/apis/core"

	securityapi "github.com/openshift/origin/pkg/security/apis/security"
)

// mustRunAsRange implements the RunAsUserSecurityContextConstraintsStrategy interface
type mustRunAsRange struct {
	opts *securityapi.RunAsUserStrategyOptions
}

var _ RunAsUserSecurityContextConstraintsStrategy = &mustRunAsRange{}

// NewMustRunAsRange provides a strategy that requires the container to run as a specific UID in a range.
func NewMustRunAsRange(options *securityapi.RunAsUserStrategyOptions) (RunAsUserSecurityContextConstraintsStrategy, error) {
	if options == nil {
		return nil, fmt.Errorf("MustRunAsRange requires run as user options")
	}
	if options.UIDRangeMin == nil {
		return nil, fmt.Errorf("MustRunAsRange requires a UIDRangeMin")
	}
	if options.UIDRangeMax == nil {
		return nil, fmt.Errorf("MustRunAsRange requires a UIDRangeMax")
	}
	return &mustRunAsRange{
		opts: options,
	}, nil
}

// Generate creates the uid based on policy rules.  MustRunAs returns the UIDRangeMin it is initialized with.
func (s *mustRunAsRange) Generate(pod *api.Pod, container *api.Container) (*int64, error) {
	return s.opts.UIDRangeMin, nil
}

// Validate ensures that the specified values fall within the range of the strategy.
func (s *mustRunAsRange) Validate(fldPath *field.Path, _ *api.Pod, _ *api.Container, runAsNonRoot *bool, runAsUser *int64) field.ErrorList {
	allErrs := field.ErrorList{}

	if runAsUser == nil {
		allErrs = append(allErrs, field.Required(fldPath.Child("runAsUser"), ""))
		return allErrs
	}

	if *runAsUser < *s.opts.UIDRangeMin || *runAsUser > *s.opts.UIDRangeMax {
		detail := fmt.Sprintf("must be in the ranges: [%v, %v]", *s.opts.UIDRangeMin, *s.opts.UIDRangeMax)
		allErrs = append(allErrs, field.Invalid(fldPath.Child("runAsUser"), *runAsUser, detail))
		return allErrs
	}

	return allErrs
}
