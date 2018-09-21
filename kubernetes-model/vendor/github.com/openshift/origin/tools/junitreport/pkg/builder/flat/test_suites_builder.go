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
	"github.com/openshift/origin/tools/junitreport/pkg/api"
	"github.com/openshift/origin/tools/junitreport/pkg/builder"
)

// NewTestSuitesBuilder returns a new flat test suites builder. All test suites consumed
// by this builder will be added to a flat list of suites - no suites will be children of other suites
func NewTestSuitesBuilder() builder.TestSuitesBuilder {
	return &flatTestSuitesBuilder{
		testSuites: &api.TestSuites{},
	}
}

// flatTestSuitesBuilder is a test suites builder that does not nest suites
type flatTestSuitesBuilder struct {
	testSuites *api.TestSuites
}

// AddSuite adds a test suite to the test suites collection being built
func (b *flatTestSuitesBuilder) AddSuite(suite *api.TestSuite) {
	b.testSuites.Suites = append(b.testSuites.Suites, suite)
}

// Build releases the test suites collection being built at whatever current state it is in
func (b *flatTestSuitesBuilder) Build() *api.TestSuites {
	return b.testSuites
}
