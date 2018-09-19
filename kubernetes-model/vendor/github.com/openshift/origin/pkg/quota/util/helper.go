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
package util

import (
	"strings"

	apierrs "k8s.io/apimachinery/pkg/api/errors"
)

// errMessageString is a part of error message copied from quotaAdmission.Admit() method in
// k8s.io/kubernetes/plugin/pkg/admission/resourcequota/admission.go module
const errQuotaMessageString = `exceeded quota:`
const errQuotaUnknownMessageString = `status unknown for quota:`
const errLimitsMessageString = `exceeds the maximum limit`

// IsErrorQuotaExceeded returns true if the given error stands for a denied request caused by detected quota
// abuse.
func IsErrorQuotaExceeded(err error) bool {
	if isForbidden := apierrs.IsForbidden(err); isForbidden || apierrs.IsInvalid(err) {
		lowered := strings.ToLower(err.Error())
		// the limit error message can be accompanied only by Invalid reason
		if strings.Contains(lowered, errLimitsMessageString) {
			return true
		}
		// the quota error message can be accompanied only by Forbidden reason
		if isForbidden && (strings.Contains(lowered, errQuotaMessageString) || strings.Contains(lowered, errQuotaUnknownMessageString)) {
			return true
		}
	}
	return false
}

// IsErrorLimitExceeded returns true if the given error is a limit error.
func IsErrorLimitExceeded(err error) bool {
	if isForbidden := apierrs.IsForbidden(err); isForbidden || apierrs.IsInvalid(err) {
		lowered := strings.ToLower(err.Error())
		// the limit error message can be accompanied only by Invalid reason
		if strings.Contains(lowered, errLimitsMessageString) {
			return true
		}
	}
	return false
}
