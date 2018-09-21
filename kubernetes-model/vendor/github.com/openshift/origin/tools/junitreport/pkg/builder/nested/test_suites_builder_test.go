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
package nested

import (
	"reflect"
	"testing"

	"github.com/openshift/origin/tools/junitreport/pkg/api"
)

func TestGetParentName(t *testing.T) {
	var testCases = []struct {
		name               string
		testName           string
		expectedParentName string
	}{
		{
			name:               "no parent",
			testName:           "root",
			expectedParentName: "",
		},
		{
			name:               "one parent",
			testName:           "root/package",
			expectedParentName: "root",
		},
		{
			name:               "many parents",
			testName:           "root/package/subpackage/etc",
			expectedParentName: "root/package/subpackage",
		},
	}

	for _, testCase := range testCases {
		if actual, expected := getParentName(testCase.testName), testCase.expectedParentName; actual != expected {
			t.Errorf("%s: did not get correct parent name for test name: expected: %q, got %q", testCase.name, expected, actual)
		}
	}
}

func TestAddSuite(t *testing.T) {
	var testCases = []struct {
		name           string
		rootSuiteNames []string
		seedSuites     map[string]*treeNode
		suiteToAdd     *api.TestSuite
		expectedSuites *api.TestSuites
	}{
		{
			name: "empty adding root",
			suiteToAdd: &api.TestSuite{
				Name: "root",
			},
			expectedSuites: &api.TestSuites{
				Suites: []*api.TestSuite{
					{
						Name: "root",
					},
				},
			},
		},
		{
			name: "empty adding child",
			suiteToAdd: &api.TestSuite{
				Name: "root/child",
			},
			expectedSuites: &api.TestSuites{
				Suites: []*api.TestSuite{
					{
						Name: "root",
						Children: []*api.TestSuite{
							{
								Name: "root/child",
							},
						},
					},
				},
			},
		},
		{
			name:           "empty with bounds, adding out of bounds",
			rootSuiteNames: []string{"someotherroot"},
			suiteToAdd: &api.TestSuite{
				Name: "root/child",
			},
			expectedSuites: &api.TestSuites{
				Suites: []*api.TestSuite{
					{
						Name: "someotherroot",
					},
				},
			},
		},
		{
			name: "populated adding child",
			seedSuites: map[string]*treeNode{
				"root": {
					suite: &api.TestSuite{
						Name: "root",
					},
				},
			},
			suiteToAdd: &api.TestSuite{
				Name: "root/child",
			},
			expectedSuites: &api.TestSuites{
				Suites: []*api.TestSuite{
					{
						Name: "root",
						Children: []*api.TestSuite{
							{
								Name: "root/child",
							},
						},
					},
				},
			},
		},
		{
			name:           "empty with bounds, adding in bounds",
			rootSuiteNames: []string{"root"},
			suiteToAdd: &api.TestSuite{
				Name: "root/child/grandchild",
			},
			expectedSuites: &api.TestSuites{
				Suites: []*api.TestSuite{
					{
						Name: "root",
						Children: []*api.TestSuite{
							{
								Name: "root/child",
								Children: []*api.TestSuite{
									{
										Name: "root/child/grandchild",
									},
								},
							},
						},
					},
				},
			},
		},
		{
			name: "populated overwriting record",
			seedSuites: map[string]*treeNode{
				"root": {
					suite: &api.TestSuite{
						Name:     "root",
						NumTests: 3,
					},
				},
			},
			suiteToAdd: &api.TestSuite{
				Name:     "root",
				NumTests: 4,
			},
			expectedSuites: &api.TestSuites{
				Suites: []*api.TestSuite{
					{
						Name:     "root",
						NumTests: 4,
					},
				},
			},
		},
	}

	for _, testCase := range testCases {
		builder := NewTestSuitesBuilder(testCase.rootSuiteNames)

		if testCase.seedSuites != nil {
			builder.(*nestedTestSuitesBuilder).nodes = testCase.seedSuites
		}

		builder.AddSuite(testCase.suiteToAdd)

		if actual, expected := builder.Build(), testCase.expectedSuites; !reflect.DeepEqual(actual, expected) {
			t.Errorf("%s: did not get correct test suites after addition of test suite:\n\texpected:\n\t%s,\n\tgot\n\t%s", testCase.name, expected, actual)
		}
	}
}
