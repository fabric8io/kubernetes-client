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
	"k8s.io/apimachinery/pkg/util/validation/field"
	api "k8s.io/kubernetes/pkg/apis/core"

	securityapi "github.com/openshift/origin/pkg/security/apis/security"
)

type nonRoot struct{}

var _ RunAsUserSecurityContextConstraintsStrategy = &nonRoot{}

func NewRunAsNonRoot(options *securityapi.RunAsUserStrategyOptions) (RunAsUserSecurityContextConstraintsStrategy, error) {
	return &nonRoot{}, nil
}

// Generate creates the uid based on policy rules.  This strategy does return a UID.  It assumes
// that the user will specify a UID or the container image specifies a UID.
func (s *nonRoot) Generate(pod *api.Pod, container *api.Container) (*int64, error) {
	return nil, nil
}

// Validate ensures that the specified values fall within the range of the strategy.  Validation
// of this will pass if either the UID is not set, assuming that the image will provided the UID
// or if the UID is set it is not root.  In order to work properly this assumes that the kubelet
// will populate an
func (s *nonRoot) Validate(fldPath *field.Path, _ *api.Pod, _ *api.Container, runAsNonRoot *bool, runAsUser *int64) field.ErrorList {
	allErrs := field.ErrorList{}
	if runAsNonRoot == nil && runAsUser == nil {
		allErrs = append(allErrs, field.Required(fldPath.Child("runAsNonRoot"), "must be true"))
		return allErrs
	}
	if runAsNonRoot != nil && *runAsNonRoot == false {
		allErrs = append(allErrs, field.Invalid(fldPath.Child("runAsNonRoot"), *runAsNonRoot, "must be true"))
		return allErrs
	}
	if runAsUser != nil && *runAsUser == 0 {
		allErrs = append(allErrs, field.Invalid(fldPath.Child("runAsUser"), *runAsUser, "running with the root UID is forbidden"))
		return allErrs
	}
	return allErrs
}
