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
package securitycontextconstraints

import (
	"reflect"
	"testing"

	securityapi "github.com/openshift/origin/pkg/security/apis/security"
)

func TestCanonicalize(t *testing.T) {
	testCases := []struct {
		obj    *securityapi.SecurityContextConstraints
		expect *securityapi.SecurityContextConstraints
	}{
		{
			obj:    &securityapi.SecurityContextConstraints{},
			expect: &securityapi.SecurityContextConstraints{},
		},
		{
			obj: &securityapi.SecurityContextConstraints{
				Users: []string{"a"},
			},
			expect: &securityapi.SecurityContextConstraints{
				Users: []string{"a"},
			},
		},
		{
			obj: &securityapi.SecurityContextConstraints{
				Users:  []string{"a", "a"},
				Groups: []string{"b", "b"},
			},
			expect: &securityapi.SecurityContextConstraints{
				Users:  []string{"a"},
				Groups: []string{"b"},
			},
		},
		{
			obj: &securityapi.SecurityContextConstraints{
				Users:  []string{"a", "b", "a"},
				Groups: []string{"c", "d", "c"},
			},
			expect: &securityapi.SecurityContextConstraints{
				Users:  []string{"a", "b"},
				Groups: []string{"c", "d"},
			},
		},
	}
	for i, testCase := range testCases {
		Strategy.Canonicalize(testCase.obj)
		if !reflect.DeepEqual(testCase.expect, testCase.obj) {
			t.Errorf("%d: unexpected object: %#v", i, testCase.obj)
		}
	}
}
