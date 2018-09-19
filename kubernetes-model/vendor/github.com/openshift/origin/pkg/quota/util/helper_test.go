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
	"errors"
	"testing"

	kerrors "k8s.io/apimachinery/pkg/api/errors"
	"k8s.io/apimachinery/pkg/util/validation/field"
	kapi "k8s.io/kubernetes/pkg/apis/core"

	imageapi "github.com/openshift/origin/pkg/image/apis/image"
)

// TestIsErrorQuotaExceeded verifies that if a resource exceedes allowed usage, the admission will return
// error we can recognize.
func TestIsErrorQuotaExceeded(t *testing.T) {
	for _, tc := range []struct {
		name        string
		err         error
		shouldMatch bool
	}{
		{
			name: "unrelated error",
			err:  errors.New("unrelated"),
		},
		{
			name: "wrong type",
			err:  errors.New(errQuotaMessageString),
		},
		{
			name: "wrong kapi type",
			err:  kerrors.NewUnauthorized(errQuotaMessageString),
		},
		{
			name: "unrelated forbidden error",
			err:  kerrors.NewForbidden(kapi.Resource("imageStreams"), "is", errors.New("unrelated")),
		},
		{
			name: "unrelated invalid error",
			err: kerrors.NewInvalid(imageapi.Kind("imageStreams"), "is",
				field.ErrorList{
					field.Required(field.NewPath("imageStream").Child("Spec"), "detail"),
				}),
		},
		{
			name: "quota error not recognized with invalid reason",
			err: kerrors.NewInvalid(imageapi.Kind("imageStreams"), "is",
				field.ErrorList{
					field.Forbidden(field.NewPath("imageStreams"), errQuotaMessageString),
				}),
		},
		{
			name: "quota unknown error not recognized with invalid reason",
			err: kerrors.NewInvalid(imageapi.Kind("imageStreams"), "is",
				field.ErrorList{
					field.Forbidden(field.NewPath("imageStreams"), errQuotaUnknownMessageString),
				}),
		},
		{
			name:        "quota exceeded error",
			err:         kerrors.NewForbidden(kapi.Resource("imageStream"), "is", errors.New(errQuotaMessageString)),
			shouldMatch: true,
		},
		{
			name:        "quota unknown error",
			err:         kerrors.NewForbidden(kapi.Resource("imageStream"), "is", errors.New(errQuotaUnknownMessageString)),
			shouldMatch: true,
		},
		{
			name:        "limits exceeded error with forbidden reason",
			err:         kerrors.NewForbidden(imageapi.Resource("imageStream"), "is", errors.New(errLimitsMessageString)),
			shouldMatch: true,
		},
		{
			name: "limits exceeded error with invalid reason",
			err: kerrors.NewInvalid(imageapi.Kind("imageStreams"), "is",
				field.ErrorList{
					field.Forbidden(field.NewPath("imageStream"), errLimitsMessageString),
				}),
			shouldMatch: true,
		},
	} {
		match := IsErrorQuotaExceeded(tc.err)

		if !match && tc.shouldMatch {
			t.Errorf("[%s] expected to match error [%T]: %v", tc.name, tc.err, tc.err)
		}
		if match && !tc.shouldMatch {
			t.Errorf("[%s] expected not to match error [%T]: %v", tc.name, tc.err, tc.err)
		}
	}
}

// TestIsErrorLimitExceeded tests for limit errors.
func TestIsErrorLimitExceeded(t *testing.T) {
	for _, tc := range []struct {
		name        string
		err         error
		shouldMatch bool
	}{
		{
			name: "unrelated error",
			err:  errors.New("unrelated"),
		},
		{
			name: "wrong type",
			err:  errors.New(errQuotaMessageString),
		},
		{
			name: "wrong kapi type",
			err:  kerrors.NewUnauthorized(errQuotaMessageString),
		},
		{
			name: "unrelated forbidden error",
			err:  kerrors.NewForbidden(kapi.Resource("imageStreams"), "is", errors.New("unrelated")),
		},
		{
			name: "unrelated invalid error",
			err: kerrors.NewInvalid(imageapi.Kind("imageStreams"), "is",
				field.ErrorList{
					field.Required(field.NewPath("imageStream").Child("Spec"), "detail"),
				}),
		},
		{
			name: "quota error not recognized with invalid reason",
			err: kerrors.NewInvalid(imageapi.Kind("imageStreams"), "is",
				field.ErrorList{
					field.Forbidden(field.NewPath("imageStreams"), errQuotaMessageString),
				}),
		},
		{
			name: "quota unknown error not recognized with invalid reason",
			err: kerrors.NewInvalid(imageapi.Kind("imageStreams"), "is",
				field.ErrorList{
					field.Forbidden(field.NewPath("imageStreams"), errQuotaUnknownMessageString),
				}),
		},
		{
			name: "quota exceeded error",
			err:  kerrors.NewForbidden(kapi.Resource("imageStream"), "is", errors.New(errQuotaMessageString)),
		},
		{
			name: "quota unknown error",
			err:  kerrors.NewForbidden(kapi.Resource("imageStream"), "is", errors.New(errQuotaUnknownMessageString)),
		},
		{
			name:        "limits exceeded error with forbidden reason",
			err:         kerrors.NewForbidden(imageapi.Resource("imageStream"), "is", errors.New(errLimitsMessageString)),
			shouldMatch: true,
		},
		{
			name: "limits exceeded error with invalid reason",
			err: kerrors.NewInvalid(imageapi.Kind("imageStreams"), "is",
				field.ErrorList{
					field.Forbidden(field.NewPath("imageStream"), errLimitsMessageString),
				}),
			shouldMatch: true,
		},
	} {
		match := IsErrorLimitExceeded(tc.err)

		if !match && tc.shouldMatch {
			t.Errorf("[%s] expected to match error [%T]: %v", tc.name, tc.err, tc.err)
		}
		if match && !tc.shouldMatch {
			t.Errorf("[%s] expected not to match error [%T]: %v", tc.name, tc.err, tc.err)
		}
	}
}
