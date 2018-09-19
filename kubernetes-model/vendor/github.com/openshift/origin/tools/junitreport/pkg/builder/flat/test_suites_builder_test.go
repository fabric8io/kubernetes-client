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
package flat

import (
	"reflect"
	"testing"

	"github.com/openshift/origin/tools/junitreport/pkg/api"
)

func TestAddSuite(t *testing.T) {
	var testCases = []struct {
		name           string
		seedSuites     *api.TestSuites
		suitesToAdd    []*api.TestSuite
		expectedSuites *api.TestSuites
	}{
		{
			name: "empty",
			suitesToAdd: []*api.TestSuite{
				{
					Name: "testSuite",
				},
			},
			expectedSuites: &api.TestSuites{
				Suites: []*api.TestSuite{
					{
						Name: "testSuite",
					},
				},
			},
		},
		{
			name: "populated",
			seedSuites: &api.TestSuites{
				Suites: []*api.TestSuite{
					{
						Name: "testSuite",
					},
				},
			},
			suitesToAdd: []*api.TestSuite{
				{
					Name: "testSuite2",
				},
			},
			expectedSuites: &api.TestSuites{
				Suites: []*api.TestSuite{
					{
						Name: "testSuite",
					},
					{
						Name: "testSuite2",
					},
				},
			},
		},
	}

	for _, testCase := range testCases {
		builder := NewTestSuitesBuilder()
		if testCase.seedSuites != nil {
			builder.(*flatTestSuitesBuilder).testSuites = testCase.seedSuites
		}

		for _, suite := range testCase.suitesToAdd {
			builder.AddSuite(suite)
		}

		if expected, actual := testCase.expectedSuites, builder.Build(); !reflect.DeepEqual(expected, actual) {
			t.Errorf("%s: did not correctly add suites:\n\texpected:\n\t%v,\n\tgot\n\t%v", testCase.name, expected, actual)
		}
	}
}
