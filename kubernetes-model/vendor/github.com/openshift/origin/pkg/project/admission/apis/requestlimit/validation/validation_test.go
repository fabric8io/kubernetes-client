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
	"testing"

	"k8s.io/apimachinery/pkg/util/validation/field"

	"github.com/openshift/origin/pkg/project/admission/apis/requestlimit"
)

func TestValidateProjectRequestLimitConfig(t *testing.T) {
	tests := []struct {
		config      requestlimit.ProjectRequestLimitConfig
		errExpected bool
		errType     field.ErrorType
		errField    string
	}{
		// 0: empty config
		{
			config: requestlimit.ProjectRequestLimitConfig{},
		},
		// 1: single default
		{
			config: requestlimit.ProjectRequestLimitConfig{
				Limits: []requestlimit.ProjectLimitBySelector{
					{
						Selector:    nil,
						MaxProjects: intp(1),
					},
				},
			},
		},
		// 2: multiple limits
		{
			config: requestlimit.ProjectRequestLimitConfig{
				Limits: []requestlimit.ProjectLimitBySelector{
					{
						Selector:    map[string]string{"foo": "bar", "foo2": "baz"},
						MaxProjects: intp(10),
					},
					{
						Selector:    map[string]string{"foo": "foo"},
						MaxProjects: intp(1),
					},
				},
			},
		},
		// 3: negative limit (error)
		{
			config: requestlimit.ProjectRequestLimitConfig{
				Limits: []requestlimit.ProjectLimitBySelector{
					{
						Selector:    map[string]string{"foo": "bar", "foo2": "baz"},
						MaxProjects: intp(10),
					},
					{
						Selector:    map[string]string{"foo": "foo"},
						MaxProjects: intp(-1),
					},
				},
			},
			errExpected: true,
			errType:     field.ErrorTypeInvalid,
			errField:    "limits[1].maxProjects",
		},
		// 4: invalid selector label (error)
		{
			config: requestlimit.ProjectRequestLimitConfig{
				Limits: []requestlimit.ProjectLimitBySelector{
					{
						Selector:    map[string]string{"foo": "bar", "foo2": "baz"},
						MaxProjects: intp(10),
					},
					{
						Selector:    nil,
						MaxProjects: intp(5),
					},
					{
						Selector:    map[string]string{"foo": "foo", "*invalid/label": "test"},
						MaxProjects: intp(1),
					},
				},
			},
			errExpected: true,
			errType:     field.ErrorTypeInvalid,
			errField:    "limits[2].selector",
		},
	}

	for i, tc := range tests {
		errs := ValidateProjectRequestLimitConfig(&tc.config)
		if len(errs) > 0 && !tc.errExpected {
			t.Errorf("%d: unexpected error: %v", i, errs.ToAggregate())
			continue
		}
		if len(errs) == 0 && tc.errExpected {
			t.Errorf("%d: did not get expected error", i)
			continue
		}
		if !tc.errExpected {
			continue
		}
		verr := errs[0]
		if verr.Type != tc.errType {
			t.Errorf("%d: did not get expected error type. Expected: %s. Got: %s", i, tc.errType, verr.Type)
		}
		if verr.Field != tc.errField {
			t.Errorf("%d: did not get expected error field. Expected: %s. Got: %s", i, tc.errField, verr.Field)
		}
	}
}

func intp(n int) *int {
	return &n
}
